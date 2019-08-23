package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IOtherTaskFinishInfoDao;
import com.lj.business.cf.domain.OtherTaskFinishInfo;
import com.lj.business.cf.domain.TaskSetShopDetail;
import com.lj.business.cf.dto.DoOtherFinishWork;
import com.lj.business.cf.dto.OtherTaskList;
import com.lj.business.cf.dto.otherTaskFinishInfo.AddOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.DelOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTask;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskFinishInfoReturn;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskReturn;
import com.lj.business.cf.dto.otherTaskFinishInfo.UpdateOtherTaskFinishInfo;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetShop;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetShopReturn;
import com.lj.business.cf.dto.taskSetShop.ToShopTaskSet;
import com.lj.business.cf.service.IOtherTaskFinishInfoService;
import com.lj.business.cf.service.ITaskSetShopDetailService;
import com.lj.business.cf.service.ITaskSetShopService;

// TODO: Auto-generated Javadoc
/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 冯辉
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class OtherTaskFinishInfoServiceImpl implements IOtherTaskFinishInfoService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(OtherTaskFinishInfoServiceImpl.class);
	

	/** The other task finish info dao. */
	@Resource
	private IOtherTaskFinishInfoDao otherTaskFinishInfoDao;
	
	@Resource
	private ITaskSetShopDetailService taskSetShopDetailService;
	
	@Resource
	private ITaskSetShopService taskSetShopService;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IOtherTaskFinishInfoService#addOtherTaskFinishInfo(com.lj.business.cf.dto.otherTaskFinishInfo.AddOtherTaskFinishInfo)
	 */
	@Override
	public void addOtherTaskFinishInfo(
			AddOtherTaskFinishInfo addOtherTaskFinishInfo) throws TsfaServiceException {
		logger.debug("addOtherTaskFinishInfo(AddOtherTaskFinishInfo addOtherTaskFinishInfo={}) - start", addOtherTaskFinishInfo); 

		AssertUtils.notNull(addOtherTaskFinishInfo);
		try {
			OtherTaskFinishInfo otherTaskFinishInfo = new OtherTaskFinishInfo();
			//add数据录入
			otherTaskFinishInfo.setCode(GUID.generateCode());
			otherTaskFinishInfo.setCodeTssd(addOtherTaskFinishInfo.getCodeTssd());
			otherTaskFinishInfo.setCodeTss(addOtherTaskFinishInfo.getCodeTss());
			otherTaskFinishInfo.setMerchantNo(addOtherTaskFinishInfo.getMerchantNo());
			otherTaskFinishInfo.setMemberNoSp(addOtherTaskFinishInfo.getMemberNoSp());
			otherTaskFinishInfo.setMemberNameSp(addOtherTaskFinishInfo.getMemberNameSp());
			otherTaskFinishInfo.setMemberNoGm(addOtherTaskFinishInfo.getMemberNoGm());
			otherTaskFinishInfo.setMemberNameGm(addOtherTaskFinishInfo.getMemberNameGm());
			otherTaskFinishInfo.setNumMonth(addOtherTaskFinishInfo.getNumMonth());
			otherTaskFinishInfo.setNumDay(addOtherTaskFinishInfo.getNumDay());
			otherTaskFinishInfo.setNumFinish(addOtherTaskFinishInfo.getNumFinish());
			otherTaskFinishInfo.setDatSt(addOtherTaskFinishInfo.getDatSt());
			otherTaskFinishInfo.setCreateId(addOtherTaskFinishInfo.getCreateId());
			otherTaskFinishInfo.setCreateDate(addOtherTaskFinishInfo.getCreateDate());
			otherTaskFinishInfo.setRemark4(addOtherTaskFinishInfo.getRemark4());
			otherTaskFinishInfo.setRemark3(addOtherTaskFinishInfo.getRemark3());
			otherTaskFinishInfo.setRemark2(addOtherTaskFinishInfo.getRemark2());
			otherTaskFinishInfo.setRemark(addOtherTaskFinishInfo.getRemark());
			otherTaskFinishInfo.setTaskUnit(addOtherTaskFinishInfo.getTaskUnit());
			otherTaskFinishInfo.setShopNo(addOtherTaskFinishInfo.getShopNo());
			otherTaskFinishInfo.setShopName(addOtherTaskFinishInfo.getShopName());
			otherTaskFinishInfo.setTaskName(addOtherTaskFinishInfo.getTaskName());
			otherTaskFinishInfoDao.insert(otherTaskFinishInfo);
			logger.debug("addOtherTaskFinishInfo(AddOtherTaskFinishInfo) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增其他任务完成情况表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_ADD_ERROR,"新增其他任务完成情况表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IOtherTaskFinishInfoService#delOtherTaskFinishInfo(com.lj.business.cf.dto.otherTaskFinishInfo.DelOtherTaskFinishInfo)
	 */
	@Override
	public void delOtherTaskFinishInfo(
			DelOtherTaskFinishInfo delOtherTaskFinishInfo) throws TsfaServiceException {
		logger.debug("delOtherTaskFinishInfo(DelOtherTaskFinishInfo delOtherTaskFinishInfo={}) - start", delOtherTaskFinishInfo); 

		AssertUtils.notNull(delOtherTaskFinishInfo);
		AssertUtils.notNull(delOtherTaskFinishInfo.getCode(),"Code不能为空！");
		try {
			otherTaskFinishInfoDao.deleteByPrimaryKey(delOtherTaskFinishInfo.getCode());
			logger.debug("delOtherTaskFinishInfo(DelOtherTaskFinishInfo) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除其他任务完成情况表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_DEL_ERROR,"删除其他任务完成情况表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IOtherTaskFinishInfoService#updateOtherTaskFinishInfo(com.lj.business.cf.dto.otherTaskFinishInfo.UpdateOtherTaskFinishInfo)
	 */
	@Override
	public void updateOtherTaskFinishInfo(
			UpdateOtherTaskFinishInfo updateOtherTaskFinishInfo)
			throws TsfaServiceException {
		logger.debug("updateOtherTaskFinishInfo(UpdateOtherTaskFinishInfo updateOtherTaskFinishInfo={}) - start", updateOtherTaskFinishInfo); //$NON-NLS-1$

		AssertUtils.notNull(updateOtherTaskFinishInfo);
		AssertUtils.notNullAndEmpty(updateOtherTaskFinishInfo.getCode(),"Code不能为空");
		try {
			OtherTaskFinishInfo otherTaskFinishInfo = new OtherTaskFinishInfo();
			//update数据录入
			otherTaskFinishInfo.setCode(updateOtherTaskFinishInfo.getCode());
			otherTaskFinishInfo.setCodeTssd(updateOtherTaskFinishInfo.getCodeTssd());
			otherTaskFinishInfo.setCodeTss(updateOtherTaskFinishInfo.getCodeTss());
			otherTaskFinishInfo.setMerchantNo(updateOtherTaskFinishInfo.getMerchantNo());
			otherTaskFinishInfo.setMemberNoSp(updateOtherTaskFinishInfo.getMemberNoSp());
			otherTaskFinishInfo.setMemberNameSp(updateOtherTaskFinishInfo.getMemberNameSp());
			otherTaskFinishInfo.setMemberNoGm(updateOtherTaskFinishInfo.getMemberNoGm());
			otherTaskFinishInfo.setMemberNameGm(updateOtherTaskFinishInfo.getMemberNameGm());
			otherTaskFinishInfo.setNumMonth(updateOtherTaskFinishInfo.getNumMonth());
			otherTaskFinishInfo.setNumDay(updateOtherTaskFinishInfo.getNumDay());
			otherTaskFinishInfo.setNumFinish(updateOtherTaskFinishInfo.getNumFinish());
			otherTaskFinishInfo.setDatSt(updateOtherTaskFinishInfo.getDatSt());
			otherTaskFinishInfo.setCreateId(updateOtherTaskFinishInfo.getCreateId());
			otherTaskFinishInfo.setCreateDate(updateOtherTaskFinishInfo.getCreateDate());
			otherTaskFinishInfo.setRemark4(updateOtherTaskFinishInfo.getRemark4());
			otherTaskFinishInfo.setRemark3(updateOtherTaskFinishInfo.getRemark3());
			otherTaskFinishInfo.setRemark2(updateOtherTaskFinishInfo.getRemark2());
			otherTaskFinishInfo.setRemark(updateOtherTaskFinishInfo.getRemark());
			otherTaskFinishInfo.setTaskUnit(updateOtherTaskFinishInfo.getTaskUnit());
			AssertUtils.notUpdateMoreThanOne(otherTaskFinishInfoDao.updateByPrimaryKeySelective(otherTaskFinishInfo));
			logger.debug("updateOtherTaskFinishInfo(UpdateOtherTaskFinishInfo) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("其他任务完成情况表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_UPDATE_ERROR,"其他任务完成情况表信息更新信息错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IOtherTaskFinishInfoService#findOtherTaskFinishInfo(com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskFinishInfo)
	 */
	@Override
	public FindOtherTaskFinishInfoReturn findOtherTaskFinishInfo(
			FindOtherTaskFinishInfo findOtherTaskFinishInfo) throws TsfaServiceException {
		logger.debug("findOtherTaskFinishInfo(FindOtherTaskFinishInfo findOtherTaskFinishInfo={}) - start", findOtherTaskFinishInfo); //$NON-NLS-1$

		AssertUtils.notNull(findOtherTaskFinishInfo);
		AssertUtils.notAllNull(findOtherTaskFinishInfo.getCode(),"Code不能为空");
		try {
			OtherTaskFinishInfo otherTaskFinishInfo = otherTaskFinishInfoDao.selectByPrimaryKey(findOtherTaskFinishInfo.getCode());
			if(otherTaskFinishInfo == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_NOT_EXIST_ERROR,"其他任务完成情况表信息不存在");
			}
			FindOtherTaskFinishInfoReturn findOtherTaskFinishInfoReturn = new FindOtherTaskFinishInfoReturn();
			//find数据录入
			findOtherTaskFinishInfoReturn.setCode(otherTaskFinishInfo.getCode());
			findOtherTaskFinishInfoReturn.setCodeTssd(otherTaskFinishInfo.getCodeTssd());
			findOtherTaskFinishInfoReturn.setCodeTss(otherTaskFinishInfo.getCodeTss());
			findOtherTaskFinishInfoReturn.setMerchantNo(otherTaskFinishInfo.getMerchantNo());
			findOtherTaskFinishInfoReturn.setMemberNoSp(otherTaskFinishInfo.getMemberNoSp());
			findOtherTaskFinishInfoReturn.setMemberNameSp(otherTaskFinishInfo.getMemberNameSp());
			findOtherTaskFinishInfoReturn.setMemberNoGm(otherTaskFinishInfo.getMemberNoGm());
			findOtherTaskFinishInfoReturn.setMemberNameGm(otherTaskFinishInfo.getMemberNameGm());
			findOtherTaskFinishInfoReturn.setNumMonth(otherTaskFinishInfo.getNumMonth());
			findOtherTaskFinishInfoReturn.setNumDay(otherTaskFinishInfo.getNumDay());
			findOtherTaskFinishInfoReturn.setNumFinish(otherTaskFinishInfo.getNumFinish());
			findOtherTaskFinishInfoReturn.setDatSt(otherTaskFinishInfo.getDatSt());
			findOtherTaskFinishInfoReturn.setCreateId(otherTaskFinishInfo.getCreateId());
			findOtherTaskFinishInfoReturn.setCreateDate(otherTaskFinishInfo.getCreateDate());
			findOtherTaskFinishInfoReturn.setRemark4(otherTaskFinishInfo.getRemark4());
			findOtherTaskFinishInfoReturn.setRemark3(otherTaskFinishInfo.getRemark3());
			findOtherTaskFinishInfoReturn.setRemark2(otherTaskFinishInfo.getRemark2());
			findOtherTaskFinishInfoReturn.setRemark(otherTaskFinishInfo.getRemark());
			findOtherTaskFinishInfoReturn.setTaskUnit(otherTaskFinishInfo.getTaskUnit());
			
			logger.debug("findOtherTaskFinishInfo(FindOtherTaskFinishInfo) - end - return value={}", findOtherTaskFinishInfoReturn); //$NON-NLS-1$
			return findOtherTaskFinishInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找其他任务完成情况表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_FIND_ERROR,"查找其他任务完成情况表信息信息错误！",e);
		}


	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IOtherTaskFinishInfoService#findWtsOther(com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskFinishInfo)
	 */
	@Override
	public List<OtherTaskList> findWtsOther(FindOtherTaskFinishInfo findOtherTaskFinishInfo) throws TsfaServiceException {
		AssertUtils.notNull(findOtherTaskFinishInfo);
		AssertUtils.notNull(findOtherTaskFinishInfo.getMemberNoGm(),"导购编号不能为空！");
		AssertUtils.notNull(findOtherTaskFinishInfo.getShopNo(),"分店编号不能为空！");
		AssertUtils.notNull(findOtherTaskFinishInfo.getMerchantNo(),"商户编号不能为空！");
		try{
			List<OtherTaskList> list = new ArrayList<OtherTaskList>();
			List<OtherTaskFinishInfo> otherList = otherTaskFinishInfoDao.findWtsOther(findOtherTaskFinishInfo);
			if(otherList != null && otherList.size() > 0){
				OtherTaskList otherTaskList = new OtherTaskList();
				for(OtherTaskFinishInfo otherTaskFinishInfo : otherList){
					otherTaskList = new OtherTaskList();
					otherTaskList.setCode(otherTaskFinishInfo.getCode());
					otherTaskList.setNumDay(otherTaskFinishInfo.getNumDay());
					otherTaskList.setNumFinish(otherTaskFinishInfo.getNumFinish());
					otherTaskList.setTaskName(otherTaskFinishInfo.getTaskName());
					otherTaskList.setTaskUnit(otherTaskFinishInfo.getTaskUnit());
					list.add(otherTaskList);
				}
			}
			return list;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找其他任务完成情况表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_FIND_ERROR,"查找其他任务完成情况表信息信息错误！",e);
		}
		
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IOtherTaskFinishInfoService#doOtherFinishWork(java.util.List)
	 */
	@Override
	public void doOtherFinishWork(DoOtherFinishWork[] doOtherFinishWorkList) throws TsfaServiceException {
		AssertUtils.notNull(doOtherFinishWorkList);
		try{
			if(doOtherFinishWorkList != null && doOtherFinishWorkList.length > 0){
				for(DoOtherFinishWork doOtherFinishWork : doOtherFinishWorkList){
					UpdateOtherTaskFinishInfo updateOtherTaskFinishInfo = new UpdateOtherTaskFinishInfo();
					updateOtherTaskFinishInfo.setCode(doOtherFinishWork.getCode());
					updateOtherTaskFinishInfo.setNumFinish(doOtherFinishWork.getNumFinish());
					updateOtherTaskFinishInfo(updateOtherTaskFinishInfo);
				}
			}
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("编辑其他任务完成情况表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_UPDATE_ERROR,"编辑其他任务完成情况表信息信息错误！",e);
		}
		
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IOtherTaskFinishInfoService#findOtherTask(com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTask)
	 */
	@Override
	public List<FindOtherTaskReturn> findOtherTask(FindOtherTask findOtherTask)
			throws TsfaServiceException {
		logger.debug("findOtherTask(FindOtherTask findOtherTask={}) - start", findOtherTask); //$NON-NLS-1$

		AssertUtils.notNull(findOtherTask);
		AssertUtils.notNull(findOtherTask.getMemberNoGm(),"导购编号不能为空！");
		AssertUtils.notNull(findOtherTask.getMerchantNo(),"商户编号不能为空！");
		try{
			List<FindOtherTaskReturn> returnList = otherTaskFinishInfoDao.findOtherTask(findOtherTask);
			logger.debug("findOtherTask(FindOtherTask) - end - return value={}", returnList); //$NON-NLS-1$
			return returnList;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找其他任务完成情况表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_FIND_ERROR,"查找其他任务完成情况表信息信息错误！",e);
		}
	}
	
	public OtherTaskFinishInfo findOtherTaskByDay(FindOtherTask findOtherTask) throws TsfaServiceException {
		AssertUtils.notNull(findOtherTask);
		AssertUtils.notNull(findOtherTask.getCode(),"明细设置code不能为空！");
		AssertUtils.notNull(findOtherTask.getNow(),"时间不能为空！");
		try{
			OtherTaskFinishInfo otherTaskFinishInfo = otherTaskFinishInfoDao.findOtherTaskByDay(findOtherTask);
			return otherTaskFinishInfo;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找其他任务完成情况表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_FIND_ERROR,"查找其他任务完成情况表信息信息错误！",e);
		}
	}
	
	
	 
	 @Override
	 public void doGmOtherTaskFinishInfo(Date date,ToShopTaskSet toShopTaskSet) throws TsfaServiceException {
			 try{
				 //查询设置明细表
				 Date day = DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
				 
				 List<TaskSetShopDetail> list = taskSetShopDetailService.findTaskSetShopDetailList(toShopTaskSet);
				 if(list != null && list.size() > 0){
					 for(TaskSetShopDetail taskSetShopDetail : list){
						 //查询是否存在
						 FindOtherTask findOtherTask = new FindOtherTask();
						 findOtherTask.setNow(day);
						 findOtherTask.setCode(taskSetShopDetail.getCode());
						 OtherTaskFinishInfo otherTaskFinishInfo = findOtherTaskByDay(findOtherTask);
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
							 addOtherTaskFinishInfo(addOtherTaskFinishInfo);
						 }else{//存在则修改数据
							 UpdateOtherTaskFinishInfo updateOtherTaskFinishInfo = new UpdateOtherTaskFinishInfo();
							 updateOtherTaskFinishInfo.setCode(otherTaskFinishInfo.getCode());
							 updateOtherTaskFinishInfo.setNumMonth(taskSetShopDetail.getNumMonth());
							 updateOtherTaskFinishInfo.setNumDay(taskSetShopDetail.getNumDay());
							 updateOtherTaskFinishInfo(updateOtherTaskFinishInfo);
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


	 
	 
	
	
//	@Override
//	public Page<FindOtherTaskFinishInfoPageReturn> findOtherTaskFinishInfoPage(
//			FindOtherTaskFinishInfoPage findOtherTaskFinishInfoPage)
//			throws TsfaServiceException {
//		logger.debug("findOtherTaskFinishInfoPage(FindOtherTaskFinishInfoPage findOtherTaskFinishInfoPage={}) - start", findOtherTaskFinishInfoPage); //$NON-NLS-1$
//
//		AssertUtils.notNull(findOtherTaskFinishInfoPage);
//		List<FindOtherTaskFinishInfoPageReturn> returnList;
//		int count = 0;
//		try {
//			returnList = otherTaskFinishInfoDao.findOtherTaskFinishInfoPage(findOtherTaskFinishInfoPage);
//			count = otherTaskFinishInfoDao.findOtherTaskFinishInfoPageCount(findOtherTaskFinishInfoPage);
//		}  catch (Exception e) {
//			logger.error("其他任务完成情况表信息不存在错误",e);
//			throw new TsfaServiceException(ErrorCode.OTHER_TASK_FINISH_INFO_FIND_PAGE_ERROR,"其他任务完成情况表信息不存在错误.！",e);
//		}
//		Page<FindOtherTaskFinishInfoPageReturn> returnPage = new Page<FindOtherTaskFinishInfoPageReturn>(returnList, count, findOtherTaskFinishInfoPage);
//
//		logger.debug("findOtherTaskFinishInfoPage(FindOtherTaskFinishInfoPage) - end - return value={}", returnPage); //$NON-NLS-1$
//		return  returnPage;
//	} 
	
	
	
}
