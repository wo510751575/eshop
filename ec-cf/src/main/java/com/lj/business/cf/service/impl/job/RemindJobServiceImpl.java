package com.lj.business.cf.service.impl.job;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IComTaskDao;
import com.lj.business.cf.domain.ComTask;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.emus.ComTaskFinish;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.common.CommonConstant;
import com.lj.business.common.SystemParamConstant;
import com.lj.cc.clientintf.IJob;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;

@Service
public class RemindJobServiceImpl implements IJob{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(RemindJobServiceImpl.class);


	@Resource
	private IComTaskDao comTaskDao;

	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;

	@Resource
	private IComTaskListService comTaskListService;

	@Override
	public void runJob() {
		this.triggerRemindJob();
	}

	//XXX LEOPENG 服务器有时间差造成无缝衔接BUG。
	public synchronized void triggerRemindJob() throws TsfaServiceException {
		logger.debug("【客户提醒JOB】triggerRemindJob() - start"); //$NON-NLS-1$

		try {
			String disMinute = localCacheSystemParams.getSystemParam(SystemParamConstant.CF_PARAM, SystemParamConstant.DIS_MINUTE);
			String freMinute = localCacheSystemParams.getSystemParam(SystemParamConstant.CF_PARAM, SystemParamConstant.FRE_MINUTE);

			if(StringUtils.isEmpty(disMinute))
				disMinute = "120";
			if(StringUtils.isEmpty(freMinute))
				freMinute = "30";
			Map<String, String> comTaskQeury = new HashMap<String, String>();
			comTaskQeury.put("disMinuteStart", disMinute);
			comTaskQeury.put("disMinuteEnd", String.valueOf(Integer.valueOf(disMinute) + Integer.valueOf(freMinute)));
			List<ComTask> list = comTaskDao.selectRemindList(comTaskQeury);
			Date now = new Date();
			String codeList = "";
			String nameList = "";
			int count = 1;
			for (ComTask comTaskTemp : list) {
				ComTask comTask = new ComTask();
				if(count == 1){
					FindComTaskList findComTaskList_remind = new FindComTaskList();
					findComTaskList_remind.setComTaskType(ComTaskType.REMIND);
					findComTaskList_remind.setMerchantNo(comTaskTemp.getMerchantNo());
					FindComTaskListReturn findComTaskListReturn_remind = comTaskListService.findComTaskList(findComTaskList_remind);
					if(findComTaskListReturn_remind != null){
						codeList = findComTaskListReturn_remind.getCode();
						nameList = findComTaskListReturn_remind.getNameList();
					}
				}
				//add数据录入
				comTask.setCode(GUID.generateCode());
				comTask.setMerchantNo(comTaskTemp.getMerchantNo());
				comTask.setShopNo(comTaskTemp.getShopNo());
				comTask.setShopName(comTaskTemp.getShopName());
				comTask.setMemberNoGm(comTaskTemp.getMemberNoGm());
				comTask.setMemberNameGm(comTaskTemp.getMemberNameGm());
				comTask.setMemberNo(comTaskTemp.getMemberNo());
				comTask.setMemberName(comTaskTemp.getMemberName());
				comTask.setCodeList(codeList);
				comTask.setNameList(nameList);
				comTask.setWorkDate(now);
				comTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM +"邀约未到店，重新邀约" );
				comTask.setFinish(ComTaskFinish.NORMAL.toString());
				comTask.setReason("");
				comTask.setCfNo(comTaskTemp.getCfNo());
				comTask.setNoType(comTaskTemp.getNoType());
				comTask.setComTaskType(ComTaskType.REMIND.toString());
				comTask.setLastResultDate(now);
				comTask.setCreateId(comTaskTemp.getCreateId());
				comTask.setRemark4(comTaskTemp.getRemark4());
				comTask.setRemark3(comTaskTemp.getRemark3());
				comTask.setRemark2(comTaskTemp.getRemark2());
				comTask.setRemark(comTaskTemp.getRemark());
				comTaskDao.insert(comTask);
				count ++;
			}

		} catch (Exception e) {
			logger.error("triggerDayChange()", e); //$NON-NLS-1$
			throw new TsfaServiceException(ErrorCode.REMIND_JOB_ERROR,"客户提醒JOB错误",e);
		}

		logger.debug("【客户提醒JOB】triggerRemindJob() - end"); //$NON-NLS-1$
	}

}
