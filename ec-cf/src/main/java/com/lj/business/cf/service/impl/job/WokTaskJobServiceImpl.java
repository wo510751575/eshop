package com.lj.business.cf.service.impl.job;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dto.AddWorkTask;
import com.lj.business.cf.dto.AddWorkTaskReturn;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetAndOrder;
import com.lj.business.cf.dto.taskSetShop.NumDayAndTaskUnit;
import com.lj.business.cf.dto.workTaskChoose.FindWorkTaskChoosePageDto;
import com.lj.business.cf.service.ITaskSetShopService;
import com.lj.business.cf.service.IWorkTaskChooseService;
import com.lj.business.cf.service.IWorkTaskService;
import com.lj.business.member.dto.FindGuidMemberPageReturn;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.cc.clientintf.IJob;

@Service
public class WokTaskJobServiceImpl implements IJob{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(WokTaskJobServiceImpl.class);


	@Resource
	private IGuidMemberService guidMemberService;

	@Resource
	private IWorkTaskChooseService workTaskChooseService;

	@Resource
	private IWorkTaskService workTaskService;

	@Resource
	private ITaskSetShopService taskSetShopService;


	@Override
	public void runJob() {
		this.triggerWokTaskJob();
	}

	public synchronized void triggerWokTaskJob() throws TsfaServiceException {
		try {
			addWorkTask();
		} catch (Exception e) {
			logger.error("triggerDayChange()", e); //$NON-NLS-1$
			throw new TsfaServiceException(ErrorCode.REMIND_JOB_ERROR,"客户提醒JOB错误",e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：工作任务统计
	 *
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年8月19日
	 *
	 */
	private AddWorkTaskReturn addWorkTask() throws TsfaServiceException {
		logger.info("【工作任务统计】 START");
		try{
			// 查询第一页的数据并插入统计数据
			Page<FindGuidMemberPageReturn> guidMemberPage = guidMemberService.findGuidMemberPage(1, 100);
			doAddWorkTask(guidMemberPage.getRows());

			// 计算总页数并从第二页插入统计数据
			long totalPage = guidMemberPage.getTotal() / guidMemberPage.getLimit();
			totalPage = (guidMemberPage.getTotal() % guidMemberPage.getLimit() == 0) ? totalPage : totalPage + 1;
			for (int i = 2; i < totalPage; i++) {
				guidMemberPage = guidMemberService.findGuidMemberPage(i, 100);
				doAddWorkTask(guidMemberPage.getRows());
			}
			return new AddWorkTaskReturn();
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("【工作任务统计】增加工作任务统计时异常！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_FIND_ERROR,"增加工作任务统计时异常！",e);
		}

	}


	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param members
	 *
	 * @author 彭阳 CreateDate: 2017年8月19日
	 *
	 */
	private void doAddWorkTask(Collection<FindGuidMemberPageReturn> members) {
		if (!CollectionUtils.isEmpty(members)) {
			// 根据商户编号查询任务列表
			List<String> merchantNoList = new ArrayList<>();
			for (FindGuidMemberPageReturn each : members) {
				merchantNoList.add(each.getMerchantNo());
			}
			List<FindWorkTaskChoosePageDto> taskChooseList = workTaskChooseService.findWorkTaskChooseByMerchantNo(merchantNoList);
			Map<String, List<FindWorkTaskChoosePageDto>> taskChooseMap = new HashMap<>();
			if (!CollectionUtils.isEmpty(taskChooseList)) {
				for(FindWorkTaskChoosePageDto each : taskChooseList) {
					List<FindWorkTaskChoosePageDto> valueList = taskChooseMap.get(each.getMerchantNo());
					if (valueList == null) {
						valueList = new ArrayList<>();
						taskChooseMap.put(each.getMerchantNo(), valueList);
					}
					valueList.add(each);
				}
			}

			// 增加数据
			Date now = new Date();
			now = DateUtils.truncate(now, Calendar.DAY_OF_MONTH);
			for (FindGuidMemberPageReturn each : members) {
				logger.info("【工作任务统计】为每个导购增加所在商户的任务,MemberNo: " + each.getMemberNo() +" MemberName: " + each.getMemberName());
				List<FindWorkTaskChoosePageDto> merchantTaskList = taskChooseMap.get(each.getMerchantNo());
				if (!CollectionUtils.isEmpty(merchantTaskList)) {
					for(FindWorkTaskChoosePageDto eachMerchantTask : merchantTaskList) {
						AddWorkTask addWorkTask = new AddWorkTask();
						addWorkTask.setMerchantNo(each.getMerchantNo());
						addWorkTask.setShopNo(each.getShopNo());
						addWorkTask.setShopName(each.getShopName());
						addWorkTask.setMemberNoGm(each.getMemberNo());
						addWorkTask.setMemberNameGm(each.getMemberName());
						addWorkTask.setCodeList(eachMerchantTask.getCodeList());
						addWorkTask.setNameList(eachMerchantTask.getNameList());
						addWorkTask.setWorkDate(now);
						addWorkTask.setRequireNum(0L);

						// 销售目标和新增客户
						if ("XIAO_SHOU".equals(eachMerchantTask.getTaskType()) || "XIN_ZENG".equals(eachMerchantTask.getTaskType())) {
							logger.info("【工作任务统计】查询任务数量");
							FindTaskSetAndOrder findTaskSetAndOrder = new FindTaskSetAndOrder();
							findTaskSetAndOrder.setTaskType(eachMerchantTask.getTaskType());
							findTaskSetAndOrder.setMerchantNo(each.getMerchantNo());
							findTaskSetAndOrder.setMemberNoGm(each.getMemberNo());
							NumDayAndTaskUnit numDayAndTaskUnit = taskSetShopService.findNumDayAndTaskUnit(findTaskSetAndOrder);
							if (numDayAndTaskUnit != null) {
								addWorkTask.setRequireNum(numDayAndTaskUnit.getNumDay());
							}
						}

						addWorkTask.setTaskUnit(eachMerchantTask.getTaskUnit());
						addWorkTask.setTaskType(eachMerchantTask.getTaskType());
						addWorkTask.setFinishNum(0L);
						addWorkTask.setUnfinishNum(addWorkTask.getRequireNum());
						addWorkTask.setDefeatNum(0L);
						addWorkTask.setFinish("N");
						addWorkTask.setReason("");
						workTaskService.addWorkTask(addWorkTask);
					}
				}
			}
		}
	}

}
