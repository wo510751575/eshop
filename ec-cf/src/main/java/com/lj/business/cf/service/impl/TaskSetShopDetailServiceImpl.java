package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
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
import com.lj.business.cf.dao.ITaskSetShopDetailDao;
import com.lj.business.cf.domain.TaskSetShopDetail;
import com.lj.business.cf.dto.FindTaskSetShopDetailByTypeMGMDay;
import com.lj.business.cf.dto.taskSetShop.FindNoSetShopCount;
import com.lj.business.cf.dto.taskSetShop.ToShopTaskSet;
import com.lj.business.cf.dto.taskSetShopDetail.AddTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.DelTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetailReturn;
import com.lj.business.cf.dto.taskSetShopDetail.UpdateTaskSetShopDetail;
import com.lj.business.cf.service.ITaskSetShopDetailService;

// TODO: Auto-generated Javadoc
/**
 * 类说明：店长任务设置明细服务实现类
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
public class TaskSetShopDetailServiceImpl implements ITaskSetShopDetailService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(TaskSetShopDetailServiceImpl.class);
	

	/** The task set shop detail dao. */
	@Resource
	private ITaskSetShopDetailDao taskSetShopDetailDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSetShopDetailService#addTaskSetShopDetail(com.lj.business.cf.dto.taskSetShopDetail.AddTaskSetShopDetail)
	 */
	@Override
	public void addTaskSetShopDetail(
			AddTaskSetShopDetail addTaskSetShopDetail) throws TsfaServiceException {
		logger.debug("addTaskSetShopDetail(AddTaskSetShopDetail addTaskSetShopDetail={}) - start", addTaskSetShopDetail); 

		AssertUtils.notNull(addTaskSetShopDetail);
		try {
			TaskSetShopDetail taskSetShopDetail = new TaskSetShopDetail();
			//add数据录入
			taskSetShopDetail.setCode(GUID.getPreUUID());
			taskSetShopDetail.setCodeTss(addTaskSetShopDetail.getCodeTss());
			taskSetShopDetail.setMerchantNo(addTaskSetShopDetail.getMerchantNo());
			taskSetShopDetail.setShopNo(addTaskSetShopDetail.getShopNo());
			taskSetShopDetail.setShopName(addTaskSetShopDetail.getShopName());
			taskSetShopDetail.setMemberNoSp(addTaskSetShopDetail.getMemberNoSp());
			taskSetShopDetail.setMemberNameSp(addTaskSetShopDetail.getMemberNameSp());
			taskSetShopDetail.setMemberNoGm(addTaskSetShopDetail.getMemberNoGm());
			taskSetShopDetail.setMemberNameGm(addTaskSetShopDetail.getMemberNameGm());
			taskSetShopDetail.setNumMonth(addTaskSetShopDetail.getNumMonth());
			taskSetShopDetail.setNumDay(addTaskSetShopDetail.getNumDay());
			taskSetShopDetail.setStartDate(addTaskSetShopDetail.getStartDate());
			taskSetShopDetail.setEndDate(addTaskSetShopDetail.getEndDate());
			taskSetShopDetail.setCreateId(addTaskSetShopDetail.getCreateId());
			taskSetShopDetail.setCreateDate(addTaskSetShopDetail.getCreateDate());
			taskSetShopDetail.setRemark4(addTaskSetShopDetail.getRemark4());
			taskSetShopDetail.setRemark3(addTaskSetShopDetail.getRemark3());
			taskSetShopDetail.setRemark2(addTaskSetShopDetail.getRemark2());
			taskSetShopDetail.setRemark(addTaskSetShopDetail.getRemark());
			taskSetShopDetail.setTaskUnit(addTaskSetShopDetail.getTaskUnit());
			taskSetShopDetailDao.insert(taskSetShopDetail);
			logger.debug("addTaskSetShopDetail(AddTaskSetShopDetail) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增店长任务设置明细表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_ADD_ERROR,"新增店长任务设置明细表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSetShopDetailService#delTaskSetShopDetail(com.lj.business.cf.dto.taskSetShopDetail.DelTaskSetShopDetail)
	 */
	@Override
	public void delTaskSetShopDetail(
			DelTaskSetShopDetail delTaskSetShopDetail) throws TsfaServiceException {
		logger.debug("delTaskSetShopDetail(DelTaskSetShopDetail delTaskSetShopDetail={}) - start", delTaskSetShopDetail); 

		AssertUtils.notNull(delTaskSetShopDetail);
		AssertUtils.notNull(delTaskSetShopDetail.getCode(),"Code不能为空！");
		try {
			taskSetShopDetailDao.deleteByPrimaryKey(delTaskSetShopDetail.getCode());
			logger.debug("delTaskSetShopDetail(DelTaskSetShopDetail) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除店长任务设置明细表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_DEL_ERROR,"删除店长任务设置明细表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSetShopDetailService#updateTaskSetShopDetail(com.lj.business.cf.dto.taskSetShopDetail.UpdateTaskSetShopDetail)
	 */
	@Override
	public void updateTaskSetShopDetail(
			UpdateTaskSetShopDetail updateTaskSetShopDetail)
			throws TsfaServiceException {
		logger.debug("updateTaskSetShopDetail(UpdateTaskSetShopDetail updateTaskSetShopDetail={}) - start", updateTaskSetShopDetail); //$NON-NLS-1$

		AssertUtils.notNull(updateTaskSetShopDetail);
		AssertUtils.notNullAndEmpty(updateTaskSetShopDetail.getCode(),"Code不能为空");
		try {
			TaskSetShopDetail taskSetShopDetail = new TaskSetShopDetail();
			//update数据录入
			taskSetShopDetail.setCode(updateTaskSetShopDetail.getCode());
			taskSetShopDetail.setCodeTss(updateTaskSetShopDetail.getCodeTss());
			taskSetShopDetail.setMerchantNo(updateTaskSetShopDetail.getMerchantNo());
			taskSetShopDetail.setShopNo(updateTaskSetShopDetail.getShopNo());
			taskSetShopDetail.setShopName(updateTaskSetShopDetail.getShopName());
			taskSetShopDetail.setMemberNoSp(updateTaskSetShopDetail.getMemberNoSp());
			taskSetShopDetail.setMemberNameSp(updateTaskSetShopDetail.getMemberNameSp());
			taskSetShopDetail.setMemberNoGm(updateTaskSetShopDetail.getMemberNoGm());
			taskSetShopDetail.setMemberNameGm(updateTaskSetShopDetail.getMemberNameGm());
			taskSetShopDetail.setNumMonth(updateTaskSetShopDetail.getNumMonth());
			taskSetShopDetail.setNumDay(updateTaskSetShopDetail.getNumDay());
			taskSetShopDetail.setStartDate(updateTaskSetShopDetail.getStartDate());
			taskSetShopDetail.setEndDate(updateTaskSetShopDetail.getEndDate());
			taskSetShopDetail.setCreateId(updateTaskSetShopDetail.getCreateId());
			taskSetShopDetail.setCreateDate(updateTaskSetShopDetail.getCreateDate());
			taskSetShopDetail.setRemark4(updateTaskSetShopDetail.getRemark4());
			taskSetShopDetail.setRemark3(updateTaskSetShopDetail.getRemark3());
			taskSetShopDetail.setRemark2(updateTaskSetShopDetail.getRemark2());
			taskSetShopDetail.setRemark(updateTaskSetShopDetail.getRemark());
			taskSetShopDetail.setTaskUnit(updateTaskSetShopDetail.getTaskUnit());
			AssertUtils.notUpdateMoreThanOne(taskSetShopDetailDao.updateByPrimaryKeySelective(taskSetShopDetail));
			logger.debug("updateTaskSetShopDetail(UpdateTaskSetShopDetail) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("店长任务设置明细表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_UPDATE_ERROR,"店长任务设置明细表信息更新信息错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSetShopDetailService#findTaskSetShopDetail(com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetail)
	 */
	@Override
	public FindTaskSetShopDetailReturn findTaskSetShopDetail(
			FindTaskSetShopDetail findTaskSetShopDetail) throws TsfaServiceException {
		logger.debug("findTaskSetShopDetail(FindTaskSetShopDetail findTaskSetShopDetail={}) - start", findTaskSetShopDetail); //$NON-NLS-1$

		AssertUtils.notNull(findTaskSetShopDetail);
		AssertUtils.notAllNull(findTaskSetShopDetail.getCode(),"Code不能为空");
		try {
			TaskSetShopDetail taskSetShopDetail = taskSetShopDetailDao.selectByPrimaryKey(findTaskSetShopDetail.getCode());
			if(taskSetShopDetail == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_NOT_EXIST_ERROR,"店长任务设置明细表信息不存在");
			}
			FindTaskSetShopDetailReturn findTaskSetShopDetailReturn = new FindTaskSetShopDetailReturn();
			//find数据录入
			findTaskSetShopDetailReturn.setCode(taskSetShopDetail.getCode());
			findTaskSetShopDetailReturn.setCodeTss(taskSetShopDetail.getCodeTss());
			findTaskSetShopDetailReturn.setMerchantNo(taskSetShopDetail.getMerchantNo());
			findTaskSetShopDetailReturn.setMemberNoSp(taskSetShopDetail.getMemberNoSp());
			findTaskSetShopDetailReturn.setMemberNameSp(taskSetShopDetail.getMemberNameSp());
			findTaskSetShopDetailReturn.setMemberNoGm(taskSetShopDetail.getMemberNoGm());
			findTaskSetShopDetailReturn.setMemberNameGm(taskSetShopDetail.getMemberNameGm());
			findTaskSetShopDetailReturn.setNumMonth(taskSetShopDetail.getNumMonth());
			findTaskSetShopDetailReturn.setNumDay(taskSetShopDetail.getNumDay());
			findTaskSetShopDetailReturn.setStartDate(taskSetShopDetail.getStartDate());
			findTaskSetShopDetailReturn.setEndDate(taskSetShopDetail.getEndDate());
			findTaskSetShopDetailReturn.setCreateId(taskSetShopDetail.getCreateId());
			findTaskSetShopDetailReturn.setCreateDate(taskSetShopDetail.getCreateDate());
			findTaskSetShopDetailReturn.setRemark4(taskSetShopDetail.getRemark4());
			findTaskSetShopDetailReturn.setRemark3(taskSetShopDetail.getRemark3());
			findTaskSetShopDetailReturn.setRemark2(taskSetShopDetail.getRemark2());
			findTaskSetShopDetailReturn.setRemark(taskSetShopDetail.getRemark());
			
			logger.debug("findTaskSetShopDetail(FindTaskSetShopDetail) - end - return value={}", findTaskSetShopDetailReturn); //$NON-NLS-1$
			return findTaskSetShopDetailReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找店长任务设置明细表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_FIND_ERROR,"查找店长任务设置明细表信息信息错误！",e);
		}


	}

	
//	@Override
//	public Page<FindTaskSetShopDetailPageReturn> findTaskSetShopDetailPage(
//			FindTaskSetShopDetailPage findTaskSetShopDetailPage)
//			throws TsfaServiceException {
//		logger.debug("findTaskSetShopDetailPage(FindTaskSetShopDetailPage findTaskSetShopDetailPage={}) - start", findTaskSetShopDetailPage); //$NON-NLS-1$
//
//		AssertUtils.notNull(findTaskSetShopDetailPage);
//		List<FindTaskSetShopDetailPageReturn> returnList;
//		int count = 0;
//		try {
//			returnList = taskSetShopDetailDao.findTaskSetShopDetailPage(findTaskSetShopDetailPage);
//			count = taskSetShopDetailDao.findTaskSetShopDetailPageCount(findTaskSetShopDetailPage);
//		}  catch (Exception e) {
//			logger.error("店长任务设置明细表信息不存在错误",e);
//			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_FIND_PAGE_ERROR,"店长任务设置明细表信息不存在错误.！",e);
//		}
//		Page<FindTaskSetShopDetailPageReturn> returnPage = new Page<FindTaskSetShopDetailPageReturn>(returnList, count, findTaskSetShopDetailPage);
//
//		logger.debug("findTaskSetShopDetailPage(FindTaskSetShopDetailPage) - end - return value={}", returnPage); //$NON-NLS-1$
//		return  returnPage;
//	} 
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSetShopDetailService#findTaskSetShopDetailList(com.lj.business.cf.dto.taskSetShop.ToShopTaskSet)
	 */
   @Override
   public List<TaskSetShopDetail> findTaskSetShopDetailList(ToShopTaskSet toShopTaskSet) throws TsfaServiceException {
		AssertUtils.notNull(toShopTaskSet);
		AssertUtils.notNullAndEmpty(toShopTaskSet.getCode(),"任务设置code不能为空");
		AssertUtils.notNullAndEmpty(toShopTaskSet.getStartDate(),"任务设置开始时间不能为空");
		AssertUtils.notNullAndEmpty(toShopTaskSet.getEndDate(),"任务设置结束时间不能为空");
		AssertUtils.notNullAndEmpty(toShopTaskSet.getMerchantNo(),"商户号不能为空");
		AssertUtils.notNullAndEmpty(toShopTaskSet.getShopNo(),"分店编号不能为空");
		
		try{
			List<TaskSetShopDetail> list = new ArrayList<TaskSetShopDetail>();
			toShopTaskSet.setStartDate(DateUtils.truncate(toShopTaskSet.getStartDate(), Calendar.DAY_OF_MONTH));
			toShopTaskSet.setEndDate(DateUtils.truncate(toShopTaskSet.getEndDate(), Calendar.DAY_OF_MONTH));
			list = taskSetShopDetailDao.findTaskSetShopDetailList(toShopTaskSet);
			return list;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找店长任务设置明细表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_FIND_ERROR,"查找店长任务设置明细表信息信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSetShopDetailService#findTaskSetShopDetailListByDay(java.util.Date)
	 */
	@Override
	public List<TaskSetShopDetail> findTaskSetShopDetailListByDay(Date now) throws TsfaServiceException {
		try{
			List<TaskSetShopDetail> list = new ArrayList<>();
			list = taskSetShopDetailDao.findTaskSetShopDetailListByDay(now);
			return list;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("根据当前时间查找店长任务设置明细表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_FIND_BY_DAY_ERROR,"根据当前时间查找店长任务设置明细表信息错误！",e);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSetShopDetailService#findTaskSetShopDetailByMGMDay(com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetail)
	 */
	@Override
	public FindTaskSetShopDetailReturn findTaskSetShopDetailByMGMDay(FindTaskSetShopDetail findTaskSetShopDetail) throws TsfaServiceException {
		AssertUtils.notNull(findTaskSetShopDetail);
		AssertUtils.notNullAndEmpty(findTaskSetShopDetail.getMerchantNo(),"商户编号不能为空");
		AssertUtils.notNullAndEmpty(findTaskSetShopDetail.getMemberNoGm(),"导购编号不能为空");
		AssertUtils.notNullAndEmpty(findTaskSetShopDetail.getShopNo(),"分店编号不能为空");
		FindTaskSetShopDetailReturn findTaskSetShopDetailReturn = null;
		try{
			findTaskSetShopDetailReturn = taskSetShopDetailDao.findTaskSetShopDetailByMGMDay(findTaskSetShopDetail);
			return findTaskSetShopDetailReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("根据当前时间查找店长任务设置明细表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_FIND_BY_DAY_ERROR,"根据当前时间查找店长任务设置明细表信息错误！",e);
		}
		
	}
	
	@Override
	public FindTaskSetShopDetailReturn findTaskSetShopDetailNewByMGMDay(FindTaskSetShopDetail findTaskSetShopDetail) throws TsfaServiceException {
		AssertUtils.notNull(findTaskSetShopDetail);
		AssertUtils.notNullAndEmpty(findTaskSetShopDetail.getMerchantNo(),"商户编号不能为空");
		AssertUtils.notNullAndEmpty(findTaskSetShopDetail.getMemberNoGm(),"导购编号不能为空");
		AssertUtils.notNullAndEmpty(findTaskSetShopDetail.getShopNo(),"分店编号不能为空");
		FindTaskSetShopDetailReturn findTaskSetShopDetailReturn = null;
		try{
			findTaskSetShopDetailReturn = taskSetShopDetailDao.findTaskSetShopDetailNewByMGMDay(findTaskSetShopDetail);
			return findTaskSetShopDetailReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("根据当前时间查找店长任务设置明细表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_FIND_BY_DAY_ERROR,"根据当前时间查找店长任务设置明细表信息错误！",e);
		}
		
	}


	@Override
	public FindTaskSetShopDetailReturn findTaskSetShopDetailByTypeMGMDay(FindTaskSetShopDetailByTypeMGMDay findTaskSetShopDetailByTypeMGMDay)throws TsfaServiceException {
		AssertUtils.notNull(findTaskSetShopDetailByTypeMGMDay);
		AssertUtils.notNullAndEmpty(findTaskSetShopDetailByTypeMGMDay.getMerchantNo(),"商户编号不能为空");
		AssertUtils.notNullAndEmpty(findTaskSetShopDetailByTypeMGMDay.getShopNo(),"店编号不能为空");
		AssertUtils.notNullAndEmpty(findTaskSetShopDetailByTypeMGMDay.getTaskType(),"任务类型不能为空");
		FindTaskSetShopDetailReturn findTaskSetShopDetailReturn = null;
		try{
			findTaskSetShopDetailReturn = taskSetShopDetailDao.findTaskSetShopDetailByTypeMGMDay(findTaskSetShopDetailByTypeMGMDay);
			return findTaskSetShopDetailReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("根据当前时间查找店长任务设置明细表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_FIND_BY_DAY_ERROR,"根据当前时间查找店长任务设置明细表信息错误！",e);
		}
	}


	@Override
	public int findCountDetail(FindNoSetShopCount findNoSetShopCount) {
		AssertUtils.notNull(findNoSetShopCount);
		AssertUtils.notNullAndEmpty(findNoSetShopCount.getMerchantNo(),"商户编号不能为空");
		//AssertUtils.notNullAndEmpty(findNoSetShopCount.getMemberNoShop(),"分店编号不能为空");
		int count = 0;
		try{
			count = taskSetShopDetailDao.findCountDetail(findNoSetShopCount);
			return count;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("根据分店编号查找店长任务设置明细表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_FIND_BY_DAY_ERROR,"根据分店编号查找店长任务设置明细表信息错误！",e);
		}
	}
	
	
	
}
