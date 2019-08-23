package com.lj.business.cf.service.impl.job;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IOtherTaskFinishInfoDao;
import com.lj.business.cf.domain.OtherTaskFinishInfo;
import com.lj.business.cf.domain.TaskSetShopDetail;
import com.lj.business.cf.dto.otherTaskFinishInfo.AddOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTask;
import com.lj.business.cf.dto.otherTaskFinishInfo.UpdateOtherTaskFinishInfo;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetShop;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetShopReturn;
import com.lj.business.cf.service.IOtherTaskFinishInfoService;
import com.lj.business.cf.service.ITaskSetShopDetailService;
import com.lj.business.cf.service.ITaskSetShopService;
import com.lj.cc.clientintf.IJob;

@Service
public class OtherTaskFinishJobServiceImpl implements IJob{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(OtherTaskFinishJobServiceImpl.class);


	@Resource
	private IOtherTaskFinishInfoDao otherTaskFinishInfoDao;
	
	@Resource
	private ITaskSetShopDetailService taskSetShopDetailService;
	
	@Resource
	private ITaskSetShopService taskSetShopService;
	
	@Resource
	private IOtherTaskFinishInfoService otherTaskFinishInfoService;
	
	

	@Override
	public void runJob() {
		this.triggerRemindJob();
	}

	public synchronized void triggerRemindJob() throws TsfaServiceException {
		try {
			//comTaskDao.
			doDayOtherTaskFinishInfo();
		} catch (Exception e) {
			logger.error("triggerDayChange()", e); //$NON-NLS-1$
			throw new TsfaServiceException(ErrorCode.REMIND_JOB_ERROR,"客户提醒JOB错误",e);
		}

	}
	
	 /* (non-Javadoc)
		 * @see com.lj.business.cf.service.IOtherTaskFinishInfoService#doDayOtherTaskFinishInfo()
		 */
		 public void doDayOtherTaskFinishInfo() throws TsfaServiceException {
			logger.debug("doDayOtherTaskFinishInfo() - start"); //$NON-NLS-1$
			 try{
				 //查询设置明细表
				 Date now = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
				 doOtherTaskFinishInfo(now);
			 }catch (TsfaServiceException e) {
					logger.error(e.getMessage(),e);
					throw e;
				} catch (Exception e) {
					logger.error("其他任务完成情况表每日初始化错误！",e);
					throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_DAY_FIND_ERROR,"其他任务完成情况表每日初始化错误！",e);
				}
			 
			logger.debug("doDayOtherTaskFinishInfo() - end"); //$NON-NLS-1$
		 }
		 
		 
		 /* (non-Javadoc)
	 	 * @see com.lj.business.cf.service.IOtherTaskFinishInfoService#doOtherTaskFinishInfo(java.util.Date)
	 	 */
	 	public void doOtherTaskFinishInfo(Date date) throws TsfaServiceException {
			 try{
				 //查询设置明细表
				 Date day = DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
				 List<TaskSetShopDetail> list = taskSetShopDetailService.findTaskSetShopDetailListByDay(day);
				 if(list != null && list.size() > 0){
					 for(TaskSetShopDetail taskSetShopDetail : list){
						 //查询是否存在
						 FindOtherTask findOtherTask = new FindOtherTask();
						 findOtherTask.setNow(day);
						 findOtherTask.setCode(taskSetShopDetail.getCode());
						 OtherTaskFinishInfo otherTaskFinishInfo = otherTaskFinishInfoService.findOtherTaskByDay(findOtherTask);
						 if(otherTaskFinishInfo == null){//不存在插入数据
							 AddOtherTaskFinishInfo addOtherTaskFinishInfo = new AddOtherTaskFinishInfo();
							 addOtherTaskFinishInfo.setCodeTss(taskSetShopDetail.getCodeTss());
							 addOtherTaskFinishInfo.setCodeTssd(taskSetShopDetail.getCode());
							 addOtherTaskFinishInfo.setDatSt(day);
							 addOtherTaskFinishInfo.setNumMonth(taskSetShopDetail.getNumMonth());
							 addOtherTaskFinishInfo.setNumDay(taskSetShopDetail.getNumDay());
							 addOtherTaskFinishInfo.setNumFinish(0L);
							 addOtherTaskFinishInfo.setMerchantNo(taskSetShopDetail.getMerchantNo());
							 addOtherTaskFinishInfo.setMemberNoGm(taskSetShopDetail.getMemberNoGm());
							 addOtherTaskFinishInfo.setMemberNameGm(taskSetShopDetail.getMemberNameGm());
							 addOtherTaskFinishInfo.setMemberNoSp(taskSetShopDetail.getMemberNoSp());
							 addOtherTaskFinishInfo.setMemberNameSp(taskSetShopDetail.getMemberNameSp());
							 addOtherTaskFinishInfo.setShopNo(taskSetShopDetail.getShopNo());
							 addOtherTaskFinishInfo.setShopName(taskSetShopDetail.getShopName());
							 addOtherTaskFinishInfo.setTaskUnit(taskSetShopDetail.getTaskUnit());
							 addOtherTaskFinishInfo.setCreateDate(new Date());
							 FindTaskSetShop findTaskSetShop = new FindTaskSetShop();
							 findTaskSetShop.setCode(taskSetShopDetail.getCodeTss());
							 FindTaskSetShopReturn findTaskSetShopReturn = taskSetShopService.findTaskSetShop(findTaskSetShop);
							 if(findTaskSetShopReturn != null){
								 addOtherTaskFinishInfo.setTaskName(findTaskSetShopReturn.getTaskName());
							 }
							 otherTaskFinishInfoService.addOtherTaskFinishInfo(addOtherTaskFinishInfo);
						 }else{//存在则修改数据
							 UpdateOtherTaskFinishInfo updateOtherTaskFinishInfo = new UpdateOtherTaskFinishInfo();
							 updateOtherTaskFinishInfo.setCode(otherTaskFinishInfo.getCode());
							 updateOtherTaskFinishInfo.setNumMonth(taskSetShopDetail.getNumMonth());
							 updateOtherTaskFinishInfo.setNumDay(taskSetShopDetail.getNumDay());
							 otherTaskFinishInfoService.updateOtherTaskFinishInfo(updateOtherTaskFinishInfo);
						 }
					 }
				 }
			 }catch (TsfaServiceException e) {
					logger.error(e.getMessage(),e);
					throw e;
				} catch (Exception e) {
					logger.error("其他任务完成情况表每日初始化错误！",e);
					throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_DAY_FIND_ERROR,"其他任务完成情况表每日初始化错误！",e);
				}
		 }

}
