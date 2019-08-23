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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.EnumUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.ITaskSetShopDao;
import com.lj.business.cf.domain.ClientFollow;
import com.lj.business.cf.domain.TaskSetShop;
import com.lj.business.cf.domain.TaskSetShopDetail;
import com.lj.business.cf.dto.FindMangerWork;
import com.lj.business.cf.dto.FindTaskSetShopDetailByTypeMGMDay;
import com.lj.business.cf.dto.FindWorkTask;
import com.lj.business.cf.dto.MainWorkTaskList;
import com.lj.business.cf.dto.MangerWorkReturn;
import com.lj.business.cf.dto.OtherTaskList;
import com.lj.business.cf.dto.UnfinishTaskList;
import com.lj.business.cf.dto.clientFollow.FindClientFollowOrder;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskFinishInfo;
import com.lj.business.cf.dto.taskSetShop.AddTaskSetShop;
import com.lj.business.cf.dto.taskSetShop.DelTaskSetShop;
import com.lj.business.cf.dto.taskSetShop.FindNoSetShopCount;
import com.lj.business.cf.dto.taskSetShop.FindShopTaskSetList;
import com.lj.business.cf.dto.taskSetShop.FindShopTaskSetListReturn;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetAndOrder;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetAndOrderReturn;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetShop;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetShopReturn;
import com.lj.business.cf.dto.taskSetShop.NumDayAndTaskUnit;
import com.lj.business.cf.dto.taskSetShop.ShopTaskSet;
import com.lj.business.cf.dto.taskSetShop.ShopTaskSetDetailList;
import com.lj.business.cf.dto.taskSetShop.TaskSetShopDetailReturn;
import com.lj.business.cf.dto.taskSetShop.ToShopTaskSet;
import com.lj.business.cf.dto.taskSetShop.UpdateTaskSetShop;
import com.lj.business.cf.dto.taskSetShopDetail.AddTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetailReturn;
import com.lj.business.cf.dto.taskSetShopDetail.UpdateTaskSetShopDetail;
import com.lj.business.cf.dto.unfinishTaskSummary.FindUnfinishTaskSummary;
import com.lj.business.cf.emus.UnitType;
import com.lj.business.cf.service.IClientFollowService;
import com.lj.business.cf.service.IOtherTaskFinishInfoService;
import com.lj.business.cf.service.ITaskSetShopDetailService;
import com.lj.business.cf.service.ITaskSetShopService;
import com.lj.business.cf.service.IUnfinishTaskSummaryService;
import com.lj.business.cf.service.IWorkTaskService;
import com.lj.business.member.dto.FindGuidMemberDto;
import com.lj.business.member.dto.FindPersonMemberName;
import com.lj.business.member.dto.GuidMemberReturnDto;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDayReturn;
import com.lj.business.member.service.IGuidMemberIntegralDayService;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IPersonMemberBaseService;

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
 *         CreateDate: 2017-06-14
 */
@Service
public class TaskSetShopServiceImpl implements ITaskSetShopService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(TaskSetShopServiceImpl.class);

	/** The task set shop dao. */
	@Resource
	private ITaskSetShopDao taskSetShopDao;

	@Resource
	private IGuidMemberService guidMemberService;

	@Resource
	private IGuidMemberIntegralDayService guidMemberIntegralDayService;

	@Resource
	private ITaskSetShopDetailService taskSetShopDetailService;

	@Resource
	private IClientFollowService clientFollowService;

	@Resource
	private IPersonMemberBaseService personMemberBaseService;

	@Resource
	private IUnfinishTaskSummaryService unfinishTaskSummaryService;

	@Resource
	private IWorkTaskService workTaskService;

	@Resource
	private IOtherTaskFinishInfoService otherTaskFinishInfoService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.business.cf.service.ITaskSetShopService#addTaskSetShop(com.lj.business.cf.dto.taskSetShop.AddTaskSetShop)
	 */
	@Override
	public void addTaskSetShop(AddTaskSetShop addTaskSetShop) throws TsfaServiceException {
		logger.debug("addTaskSetShop(AddTaskSetShop addTaskSetShop={}) - start", addTaskSetShop);

		AssertUtils.notNull(addTaskSetShop);
		AssertUtils.notNullAndEmpty(addTaskSetShop.getMerchantNo(), "商户号不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getMemberNoSp(), "店长编号不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getMemberNameSp(), "店长姓名不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getShopNo(), "分店编号不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getShopName(), "分店名称不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getStartDate(), "任务开始时间不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getEndDate(), "任务结束时间不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getTaskName(), "任务名称不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getTaskUnit(), "任务单位不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getTaskType(), "任务类型不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getDimension(), "任务唯度不能为空");

		if (addTaskSetShop.getStartDate().after(addTaskSetShop.getEndDate())) {
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_ADD_ERROR, "任务开始时间不能大于结束时间");
		}

		// 判断任务名称

		try {
			TaskSetShop taskSetShop = new TaskSetShop();
			// add数据录入
			taskSetShop.setCode(GUID.generateCode());
			taskSetShop.setMerchantNo(addTaskSetShop.getMerchantNo());
			taskSetShop.setMemberNoSp(addTaskSetShop.getMemberNoSp());
			taskSetShop.setMemberNameSp(addTaskSetShop.getMemberNameSp());
			taskSetShop.setShopNo(addTaskSetShop.getShopNo());
			taskSetShop.setShopName(addTaskSetShop.getShopName());
			taskSetShop.setStartDate(addTaskSetShop.getStartDate());
			taskSetShop.setEndDate(addTaskSetShop.getEndDate());
			taskSetShop.setTaskName(addTaskSetShop.getTaskName());
			taskSetShop.setTaskUnit(addTaskSetShop.getTaskUnit());
			taskSetShop.setTaskType(addTaskSetShop.getTaskType());
			taskSetShop.setDimension(addTaskSetShop.getDimension());
			taskSetShop.setCodeList(addTaskSetShop.getCodeList());
			taskSetShop.setNumMonth(addTaskSetShop.getNumMonth());
			taskSetShop.setCreateId(addTaskSetShop.getCreateId());
			taskSetShop.setCreateDate(new Date());
			taskSetShop.setRemark4(addTaskSetShop.getRemark4());
			taskSetShop.setRemark3(addTaskSetShop.getRemark3());
			taskSetShop.setRemark2(addTaskSetShop.getRemark2());
			taskSetShop.setRemark(addTaskSetShop.getRemark());
			taskSetShopDao.insert(taskSetShop);
			logger.debug("addTaskSetShop(AddTaskSetShop) - end - return");
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增店长任务设置表信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_ADD_ERROR, "新增店长任务设置表信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.business.cf.service.ITaskSetShopService#addTaskSetShopMain(com.lj.business.cf.dto.taskSetShop.AddTaskSetShop)
	 */
	@Override
	public void addTaskSetShopMain(AddTaskSetShop addTaskSetShop) throws TsfaServiceException {
		logger.debug("addTaskSetShop(AddTaskSetShop addTaskSetShop={}) - start", addTaskSetShop);

		AssertUtils.notNull(addTaskSetShop);
		AssertUtils.notNullAndEmpty(addTaskSetShop.getMerchantNo(), "商户号不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getStartDate(), "任务开始时间不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getEndDate(), "任务结束时间不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getTaskName(), "任务名称不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getTaskUnit(), "任务单位不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getTaskType(), "任务类型不能为空");
		AssertUtils.notNullAndEmpty(addTaskSetShop.getDimension(), "任务唯度不能为空");

		if (addTaskSetShop.getStartDate().after(addTaskSetShop.getEndDate())) {
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_ADD_ERROR, "任务开始时间不能大于结束时间");
		}

		try {
			TaskSetShop taskSetShop = new TaskSetShop();
			// add数据录入
			taskSetShop.setCode(GUID.generateCode());
			taskSetShop.setMerchantNo(addTaskSetShop.getMerchantNo());
			taskSetShop.setMemberNoSp(addTaskSetShop.getMemberNoSp());
			taskSetShop.setMemberNameSp(addTaskSetShop.getMemberNameSp());
			taskSetShop.setShopNo(addTaskSetShop.getShopNo());
			taskSetShop.setShopName(addTaskSetShop.getShopName());
			taskSetShop.setStartDate(addTaskSetShop.getStartDate());
			taskSetShop.setEndDate(addTaskSetShop.getEndDate());
			taskSetShop.setTaskName(addTaskSetShop.getTaskName());
			taskSetShop.setTaskUnit(addTaskSetShop.getTaskUnit());
			taskSetShop.setTaskType(addTaskSetShop.getTaskType());
			taskSetShop.setDimension(addTaskSetShop.getDimension());
			taskSetShop.setCodeList(addTaskSetShop.getCodeList());
			taskSetShop.setNumMonth(addTaskSetShop.getNumMonth());
			taskSetShop.setCreateId(addTaskSetShop.getCreateId());
			taskSetShop.setCreateDate(new Date());
			taskSetShop.setRemark4(addTaskSetShop.getRemark4());
			taskSetShop.setRemark3(addTaskSetShop.getRemark3());
			taskSetShop.setRemark2(addTaskSetShop.getRemark2());
			taskSetShop.setRemark(addTaskSetShop.getRemark());
			taskSetShopDao.insert(taskSetShop);
			logger.debug("addTaskSetShop(AddTaskSetShop) - end - return");
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增店长任务设置表信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_ADD_ERROR, "新增店长任务设置表信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.business.cf.service.ITaskSetShopService#delTaskSetShop(com.lj.business.cf.dto.taskSetShop.DelTaskSetShop)
	 */
	@Override
	public void delTaskSetShop(DelTaskSetShop delTaskSetShop) throws TsfaServiceException {
		logger.debug("delTaskSetShop(DelTaskSetShop delTaskSetShop={}) - start", delTaskSetShop);

		AssertUtils.notNull(delTaskSetShop);
		AssertUtils.notNull(delTaskSetShop.getCode(), "Code不能为空！");
		try {
			taskSetShopDao.deleteByPrimaryKey(delTaskSetShop.getCode());
			logger.debug("delTaskSetShop(DelTaskSetShop) - end - return"); //$NON-NLS-1$
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("删除店长任务设置表信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DEL_ERROR, "删除店长任务设置表信息错误！", e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.business.cf.service.ITaskSetShopService#updateTaskSetShop(com.lj.business.cf.dto.taskSetShop.UpdateTaskSetShop)
	 */
	@Override
	public void updateTaskSetShop(UpdateTaskSetShop updateTaskSetShop) throws TsfaServiceException {
		logger.debug("updateTaskSetShop(UpdateTaskSetShop updateTaskSetShop={}) - start", updateTaskSetShop); //$NON-NLS-1$

		AssertUtils.notNull(updateTaskSetShop);
		AssertUtils.notNullAndEmpty(updateTaskSetShop.getCode(), "Code不能为空");
		try {
			TaskSetShop taskSetShop = new TaskSetShop();
			// update数据录入
			taskSetShop.setCode(updateTaskSetShop.getCode());
			taskSetShop.setMerchantNo(updateTaskSetShop.getMerchantNo());
			taskSetShop.setMemberNoSp(updateTaskSetShop.getMemberNoSp());
			taskSetShop.setMemberNameSp(updateTaskSetShop.getMemberNameSp());
			taskSetShop.setStartDate(updateTaskSetShop.getStartDate());
			taskSetShop.setEndDate(updateTaskSetShop.getEndDate());
			taskSetShop.setTaskName(updateTaskSetShop.getTaskName());
			taskSetShop.setTaskUnit(updateTaskSetShop.getTaskUnit());
			taskSetShop.setTaskType(updateTaskSetShop.getTaskType());
			taskSetShop.setDimension(updateTaskSetShop.getDimension());
			taskSetShop.setCodeList(updateTaskSetShop.getCodeList());
			taskSetShop.setCreateId(updateTaskSetShop.getCreateId());
			taskSetShop.setCreateDate(updateTaskSetShop.getCreateDate());
			taskSetShop.setRemark4(updateTaskSetShop.getRemark4());
			taskSetShop.setRemark3(updateTaskSetShop.getRemark3());
			taskSetShop.setRemark2(updateTaskSetShop.getRemark2());
			taskSetShop.setRemark(updateTaskSetShop.getRemark());
			AssertUtils.notUpdateMoreThanOne(taskSetShopDao.updateByPrimaryKeySelective(taskSetShop));
			logger.debug("updateTaskSetShop(UpdateTaskSetShop) - end - return"); //$NON-NLS-1$
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("店长任务设置表信息信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_UPDATE_ERROR, "店长任务设置表信息更新错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.business.cf.service.ITaskSetShopService#findTaskSetShop(com.lj.business.cf.dto.taskSetShop.FindTaskSetShop)
	 */
	@Override
	public FindTaskSetShopReturn findTaskSetShop(FindTaskSetShop findTaskSetShop) throws TsfaServiceException {
		logger.debug("findTaskSetShop(FindTaskSetShop findTaskSetShop={}) - start", findTaskSetShop); //$NON-NLS-1$

		AssertUtils.notNull(findTaskSetShop);
		AssertUtils.notNull(findTaskSetShop.getCode(), "Code不能为空");
		try {
			TaskSetShop taskSetShop = taskSetShopDao.selectByPrimaryKey(findTaskSetShop.getCode());
			if (taskSetShop == null) {
				throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_NOT_EXIST_ERROR, "店长任务设置表信息不存在");
			}
			FindTaskSetShopReturn findTaskSetShopReturn = new FindTaskSetShopReturn();
			// find数据录入
			findTaskSetShopReturn.setCode(taskSetShop.getCode());
			findTaskSetShopReturn.setMerchantNo(taskSetShop.getMerchantNo());
			findTaskSetShopReturn.setMemberNoSp(taskSetShop.getMemberNoSp());
			findTaskSetShopReturn.setMemberNameSp(taskSetShop.getMemberNameSp());
			findTaskSetShopReturn.setStartDate(taskSetShop.getStartDate());
			findTaskSetShopReturn.setEndDate(taskSetShop.getEndDate());
			findTaskSetShopReturn.setTaskName(taskSetShop.getTaskName());
			findTaskSetShopReturn.setTaskUnit(taskSetShop.getTaskUnit());
			findTaskSetShopReturn.setTaskType(taskSetShop.getTaskType());
			findTaskSetShopReturn.setDimension(taskSetShop.getDimension());
			findTaskSetShopReturn.setCodeList(taskSetShop.getCodeList());
			findTaskSetShopReturn.setCreateId(taskSetShop.getCreateId());
			findTaskSetShopReturn.setCreateDate(taskSetShop.getCreateDate());
			findTaskSetShopReturn.setRemark4(taskSetShop.getRemark4());
			findTaskSetShopReturn.setRemark3(taskSetShop.getRemark3());
			findTaskSetShopReturn.setRemark2(taskSetShop.getRemark2());
			findTaskSetShopReturn.setRemark(taskSetShop.getRemark());

			logger.debug("findTaskSetShop(FindTaskSetShop) - end - return value={}", findTaskSetShopReturn); //$NON-NLS-1$
			return findTaskSetShopReturn;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找店长任务设置表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_FIND_ERROR, "查找店长任务设置表信息错误！", e);
		}

	}

	// @Override
	// public Page<FindTaskSetShopPageReturn> findTaskSetShopPage(
	// FindTaskSetShopPage findTaskSetShopPage)
	// throws TsfaServiceException {
	//		logger.debug("findTaskSetShopPage(FindTaskSetShopPage findTaskSetShopPage={}) - start", findTaskSetShopPage); //$NON-NLS-1$
	//
	// AssertUtils.notNull(findTaskSetShopPage);
	// List<FindTaskSetShopPageReturn> returnList;
	// int count = 0;
	// try {
	// returnList = taskSetShopDao.findTaskSetShopPage(findTaskSetShopPage);
	// count = taskSetShopDao.findTaskSetShopPageCount(findTaskSetShopPage);
	// } catch (Exception e) {
	// logger.error("店长任务设置表信息信息不存在错误",e);
	// throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_FIND_PAGE_ERROR,"店长任务设置表信息信息不存在错误.！",e);
	// }
	// Page<FindTaskSetShopPageReturn> returnPage = new Page<FindTaskSetShopPageReturn>(returnList, count, findTaskSetShopPage);
	//
	//		logger.debug("findTaskSetShopPage(FindTaskSetShopPage) - end - return value={}", returnPage); //$NON-NLS-1$
	// return returnPage;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.business.cf.service.ITaskSetShopService#findShopTaskSetList(com.lj.business.cf.dto.taskSetShop.FindShopTaskSetList)
	 */
	@Override
	public List<FindShopTaskSetListReturn> findShopTaskSetList(FindShopTaskSetList findShopTaskSetList) throws TsfaServiceException {
		logger.debug("findShopTaskSetList(FindShopTaskSetList findShopTaskSetList={}) - start", findShopTaskSetList); //$NON-NLS-1$

		AssertUtils.notNull(findShopTaskSetList);
		AssertUtils.notNullAndEmpty(findShopTaskSetList.getMerchantNo(), "商户号不能为空");
//		AssertUtils.notNullAndEmpty(findShopTaskSetList.getMemberNoSp(), "店长编号不能为空");

		List<FindShopTaskSetListReturn> retList = new ArrayList<FindShopTaskSetListReturn>();
		try {
			// 商户类型的任务
			List<TaskSetShop> listMerchant = taskSetShopDao.findShopTaskSetListMerchant(findShopTaskSetList);
			FindShopTaskSetListReturn findShopTaskSetListReturn = null;
			if (listMerchant != null && listMerchant.size() > 0) {
				// 计算任务开始时间和结束时间
				for (TaskSetShop taskSetShop : listMerchant) {
					findShopTaskSetListReturn = new FindShopTaskSetListReturn();
					findShopTaskSetListReturn.setCode(taskSetShop.getCode());
					findShopTaskSetListReturn.setStartDate(org.apache.commons.lang.time.DateUtils.truncate(DateUtils.getMonthFirstDay(), Calendar.DAY_OF_MONTH));
					findShopTaskSetListReturn.setEndDate(org.apache.commons.lang.time.DateUtils.truncate(DateUtils.getMonthLastDay(), Calendar.DAY_OF_MONTH));
					findShopTaskSetListReturn.setDimension(taskSetShop.getDimension());
					findShopTaskSetListReturn.setCodeList(taskSetShop.getCodeList());
					findShopTaskSetListReturn.setTaskName(taskSetShop.getTaskName());
					findShopTaskSetListReturn.setTaskType(taskSetShop.getTaskType());
					findShopTaskSetListReturn.setTaskUnit(taskSetShop.getTaskUnit());

					// 店长设置的明细
					FindTaskSetShopDetailByTypeMGMDay findTaskSetShopDetailByTypeMGMDay = new FindTaskSetShopDetailByTypeMGMDay();
					findTaskSetShopDetailByTypeMGMDay.setMerchantNo(findShopTaskSetList.getMerchantNo());
					findTaskSetShopDetailByTypeMGMDay.setShopNo(findShopTaskSetList.getShopNo());
					findTaskSetShopDetailByTypeMGMDay.setTaskType(taskSetShop.getTaskType());
					findTaskSetShopDetailByTypeMGMDay.setNow(org.apache.commons.lang.time.DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
					FindTaskSetShopDetailReturn findTaskSetShopDetailReturn = taskSetShopDetailService.findTaskSetShopDetailByTypeMGMDay(findTaskSetShopDetailByTypeMGMDay);
					if (findTaskSetShopDetailReturn != null) {
						findShopTaskSetListReturn.setNumMonth(findTaskSetShopDetailReturn.getNumMonth());
					} else {
						findShopTaskSetListReturn.setNumMonth(0L);
					}
					findShopTaskSetListReturn.setCurrentMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);
					retList.add(findShopTaskSetListReturn);
				}
			}

			// 店长设置的任务
			// List<TaskSetShop> list = taskSetShopDao.findShopTaskSetList(findShopTaskSetList);
			// if(list != null && list.size() > 0){
			// for(TaskSetShop taskSetShop : list){
			// findShopTaskSetListReturn = new FindShopTaskSetListReturn();
			// findShopTaskSetListReturn.setCode(taskSetShop.getCode());
			// findShopTaskSetListReturn.setStartDate(taskSetShop.getStartDate());
			// findShopTaskSetListReturn.setEndDate(taskSetShop.getEndDate());
			// findShopTaskSetListReturn.setDimension(taskSetShop.getDimension());
			// findShopTaskSetListReturn.setCodeList(taskSetShop.getCodeList());
			// findShopTaskSetListReturn.setTaskName(taskSetShop.getTaskName());
			// findShopTaskSetListReturn.setTaskType(taskSetShop.getTaskType());
			// findShopTaskSetListReturn.setTaskUnit(taskSetShop.getTaskUnit());
			// findShopTaskSetListReturn.setNumMonth(taskSetShop.getNumMonth());
			// findShopTaskSetListReturn.setCurrentMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);
			// retList.add(findShopTaskSetListReturn);
			// }
			// }
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("店长设置任务列表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_FIND_ERROR, "查找店长任务设置表信息错误！", e);
		}

		logger.debug("findShopTaskSetList() - end - return value={}", retList); //$NON-NLS-1$
		return retList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.business.cf.service.ITaskSetShopService#toShopTaskSet(com.lj.business.cf.dto.taskSetShop.ToShopTaskSet)
	 */
	@Override
	public List<TaskSetShopDetailReturn> toShopTaskSet(ToShopTaskSet toShopTaskSet) throws TsfaServiceException {
		AssertUtils.notNull(toShopTaskSet);
		AssertUtils.notNullAndEmpty(toShopTaskSet.getCode(), "任务设置code不能为空");
		AssertUtils.notNullAndEmpty(toShopTaskSet.getTaskType(), "任务设置类型不能为空");
		AssertUtils.notNullAndEmpty(toShopTaskSet.getStartDate(), "任务设置开始时间不能为空");
		AssertUtils.notNullAndEmpty(toShopTaskSet.getEndDate(), "任务设置结束时间不能为空");
		AssertUtils.notNullAndEmpty(toShopTaskSet.getMerchantNo(), "商户号不能为空");
		AssertUtils.notNullAndEmpty(toShopTaskSet.getShopNo(), "分店编号不能为空");

		try {
			// 查询分店下所以的导购
			FindGuidMemberDto findGuidMemberDto = new FindGuidMemberDto();
			findGuidMemberDto.setMerchantNo(toShopTaskSet.getMerchantNo());
			findGuidMemberDto.setShopNo(toShopTaskSet.getShopNo());
			List<GuidMemberReturnDto> list = guidMemberService.findGuidMemberList(findGuidMemberDto);

			// 如果已经存在明细记录则为修改，不存在明细记录则为新增
			// 查询明细
			List<TaskSetShopDetailReturn> retList = new ArrayList<TaskSetShopDetailReturn>();
			List<TaskSetShopDetail> listDetail = taskSetShopDetailService.findTaskSetShopDetailList(toShopTaskSet);
			// 未设置过明细
			TaskSetShopDetailReturn taskSetShopDetailReturn = new TaskSetShopDetailReturn();
			if (listDetail == null || listDetail.size() == 0) {
				if (list != null && list.size() > 0) {
					for (GuidMemberReturnDto dto : list) {
						taskSetShopDetailReturn = new TaskSetShopDetailReturn();
						taskSetShopDetailReturn.setCodeTss(toShopTaskSet.getCode());
						taskSetShopDetailReturn.setMemberNoGm(dto.getMemberNo());
						taskSetShopDetailReturn.setMemberNameGm(dto.getMemberName());
						taskSetShopDetailReturn.setNumDay(0L);
						retList.add(taskSetShopDetailReturn);
					}
				}
			} else {// 设置过明细
				for (TaskSetShopDetail taskSetShopDetail : listDetail) {
					// update by 杨杰  bug 781 删除已经分配明细的导购 begin
					for (int i = list.size() - 1; i >= 0; i--) {
						if (org.apache.commons.lang.StringUtils.equals(list.get(i).getMemberNo(), taskSetShopDetail.getMemberNoGm())) {
							list.remove(i);
						}
					}
					// update by 杨杰 删除已经分配明细的导购 end
					taskSetShopDetailReturn = new TaskSetShopDetailReturn();
					taskSetShopDetailReturn.setCode(taskSetShopDetail.getCode());
					taskSetShopDetailReturn.setCodeTss(taskSetShopDetail.getCodeTss());
					taskSetShopDetailReturn.setMemberNameGm(taskSetShopDetail.getMemberNameGm());
					taskSetShopDetailReturn.setMemberNoGm(taskSetShopDetail.getMemberNoGm());
					taskSetShopDetailReturn.setNumDay(taskSetShopDetail.getNumDay());
					retList.add(taskSetShopDetailReturn);
				}
				// update by 杨杰 bug 781 返回新增的导购 begin
				for (GuidMemberReturnDto dto : list) {
					taskSetShopDetailReturn = new TaskSetShopDetailReturn();
					taskSetShopDetailReturn.setCodeTss(toShopTaskSet.getCode());
					taskSetShopDetailReturn.setMemberNoGm(dto.getMemberNo());
					taskSetShopDetailReturn.setMemberNameGm(dto.getMemberName());
					taskSetShopDetailReturn.setNumDay(0L);
					retList.add(taskSetShopDetailReturn);
				}
				// update by 杨杰 返回新增的导购 end
			}
			return retList;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("店长设置任务列表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_FIND_ERROR, "查找店长任务设置表信息错误！", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.business.cf.service.ITaskSetShopService#shopTaskSet(com.lj.business.cf.dto.taskSetShop.ShopTaskSet)
	 */
	@Override
	public void shopTaskSet(ShopTaskSet shopTaskSet) throws TsfaServiceException {
		AssertUtils.notNull(shopTaskSet);
		AssertUtils.notNullAndEmpty(shopTaskSet.getCode(), "任务设置code不能为空");
		AssertUtils.notNullAndEmpty(shopTaskSet.getMerchantNo(), "商户号不能为空");
		AssertUtils.notNullAndEmpty(shopTaskSet.getShopNo(), "分店编号不能为空");
		AssertUtils.notNullAndEmpty(shopTaskSet.getShopName(), "分店名称不能为空");
		AssertUtils.notNullAndEmpty(shopTaskSet.getMemberNoSp(), "导购编号不能为空");
		AssertUtils.notNullAndEmpty(shopTaskSet.getMemberNameSp(), "导购名称不能为空");
		AssertUtils.notNullAndEmpty(shopTaskSet.getStartDate(), "任务开始时间不能为空");
		AssertUtils.notNullAndEmpty(shopTaskSet.getEndDate(), "任务结束时间不能为空");
		AssertUtils.notNullAndEmpty(shopTaskSet.getNumMonth(), "月数量不能为空");
		if (shopTaskSet.getList() == null || shopTaskSet.getList().length == 0) {
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_NOT_EXIST_ERROR, "添加店长任务设置明细信息不存在错误！");
		}

		try {
			ShopTaskSetDetailList[] list = shopTaskSet.getList();
			AddTaskSetShopDetail addTaskSetShopDetail = new AddTaskSetShopDetail();

			boolean flag = false;

			for (ShopTaskSetDetailList shopTaskSetDetailList : list) {
				// code为空则添加任务设置明细
				if (StringUtils.isEmpty(shopTaskSetDetailList.getCode())) {
					addTaskSetShopDetail = new AddTaskSetShopDetail();

					addTaskSetShopDetail.setCodeTss(shopTaskSet.getCode());
					addTaskSetShopDetail.setMerchantNo(shopTaskSet.getMerchantNo());
					addTaskSetShopDetail.setShopNo(shopTaskSet.getShopNo());
					addTaskSetShopDetail.setShopName(shopTaskSet.getShopName());
					addTaskSetShopDetail.setMemberNoSp(shopTaskSet.getMemberNoSp());
					addTaskSetShopDetail.setMemberNameSp(shopTaskSet.getMemberNameSp());
					addTaskSetShopDetail.setStartDate(shopTaskSet.getStartDate());
					addTaskSetShopDetail.setEndDate(shopTaskSet.getEndDate());
					addTaskSetShopDetail.setNumMonth(shopTaskSet.getNumMonth());

					addTaskSetShopDetail.setMemberNoGm(shopTaskSetDetailList.getMemberNoGm());
					addTaskSetShopDetail.setMemberNameGm(shopTaskSetDetailList.getMemberNameGm());
					addTaskSetShopDetail.setNumDay(shopTaskSetDetailList.getNumDay());
					addTaskSetShopDetail.setTaskUnit(shopTaskSet.getTaskUnit());

					addTaskSetShopDetail.setCreateDate(new Date());
					addTaskSetShopDetail.setCreateId(shopTaskSet.getMemberNoSp());
					taskSetShopDetailService.addTaskSetShopDetail(addTaskSetShopDetail);
				} else {
					flag = true;
					// code不为空则修改任务设置明细
					UpdateTaskSetShopDetail updateTaskSetShopDetail = new UpdateTaskSetShopDetail();

					updateTaskSetShopDetail.setCodeTss(shopTaskSet.getCode());
					updateTaskSetShopDetail.setMerchantNo(shopTaskSet.getMerchantNo());
					updateTaskSetShopDetail.setShopNo(shopTaskSet.getShopNo());
					updateTaskSetShopDetail.setShopName(shopTaskSet.getShopName());
					updateTaskSetShopDetail.setMemberNoSp(shopTaskSet.getMemberNoSp());
					updateTaskSetShopDetail.setMemberNameSp(shopTaskSet.getMemberNameSp());
					updateTaskSetShopDetail.setStartDate(shopTaskSet.getStartDate());
					updateTaskSetShopDetail.setEndDate(shopTaskSet.getEndDate());
					updateTaskSetShopDetail.setNumMonth(shopTaskSet.getNumMonth());

					updateTaskSetShopDetail.setCode(shopTaskSetDetailList.getCode());
					updateTaskSetShopDetail.setMemberNoGm(shopTaskSetDetailList.getMemberNoGm());
					updateTaskSetShopDetail.setMemberNameGm(shopTaskSetDetailList.getMemberNameGm());
					updateTaskSetShopDetail.setNumDay(shopTaskSetDetailList.getNumDay());
					updateTaskSetShopDetail.setTaskUnit(shopTaskSet.getTaskUnit());

					taskSetShopDetailService.updateTaskSetShopDetail(updateTaskSetShopDetail);
				}

			}

			// 修改任务设置表数量
			// TaskSetShop taskSetShop = new TaskSetShop();
			// taskSetShop.setCode(shopTaskSet.getCode());
			// taskSetShop.setNumMonth(shopTaskSet.getNumMonth());
			// taskSetShopDao.updateByPrimaryKeySelective(taskSetShop);

			// 如果flag = false则为新增 为true则为修改
			if (!flag) {
				// 新增 如果startDate是当前时间则在其他任务完成情况表中插入数据
				if (DateUtils.isSameDay(new Date(), shopTaskSet.getStartDate())) {
					ToShopTaskSet toShopTaskSet = new ToShopTaskSet();
					toShopTaskSet.setCode(shopTaskSet.getCode());
					toShopTaskSet.setStartDate(shopTaskSet.getStartDate());
					toShopTaskSet.setEndDate(shopTaskSet.getEndDate());
					toShopTaskSet.setMerchantNo(shopTaskSet.getMerchantNo());
					toShopTaskSet.setShopNo(shopTaskSet.getShopNo());
					otherTaskFinishInfoService.doGmOtherTaskFinishInfo(shopTaskSet.getStartDate(), toShopTaskSet);
				}
			} else {
				// 修改 如果当前时间小于endDate大于startDate则在其他任务完成情况表中修改数据
				Date n = org.apache.commons.lang.time.DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
				if ((n.after(shopTaskSet.getStartDate()) || DateUtils.isSameDay(n, shopTaskSet.getStartDate()))
						&& (n.before(shopTaskSet.getEndDate()) || DateUtils.isSameDay(n, shopTaskSet.getEndDate()))) {
					ToShopTaskSet toShopTaskSet = new ToShopTaskSet();
					toShopTaskSet.setCode(shopTaskSet.getCode());
					toShopTaskSet.setStartDate(shopTaskSet.getStartDate());
					toShopTaskSet.setEndDate(shopTaskSet.getEndDate());
					toShopTaskSet.setMerchantNo(shopTaskSet.getMerchantNo());
					toShopTaskSet.setShopNo(shopTaskSet.getShopNo());
					otherTaskFinishInfoService.doGmOtherTaskFinishInfo(n, toShopTaskSet);
				}
			}

		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("添加店长任务设置明细信息错误！", e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_ADD_ERROR, "添加店长任务设置明细信息错误！", e);
		}

	}

	@Override
	public FindTaskSetAndOrderReturn findTaskSetAndOrder(FindTaskSetAndOrder findTaskSetAndOrder) {
		AssertUtils.notNull(findTaskSetAndOrder);

		// 默认为销售目标
		if (findTaskSetAndOrder.getTaskType() == null) {
			findTaskSetAndOrder.setTaskType("XIAO_SHOU");
		}

		// 查询当天的数量
		NumDayAndTaskUnit numDayAndTaskUnit = this.taskSetShopDao.findNumDayAndTaskUnit(findTaskSetAndOrder);
		Long numDay = 0L;
		String taskUnit = "";
		int days = 0;
		if (numDayAndTaskUnit != null) {
			numDay = numDayAndTaskUnit.getNumDay();
			taskUnit = EnumUtils.getValue(UnitType.class, numDayAndTaskUnit.getTaskUnit());

			// 获取当月的天数
			days = this.getDaysOfMonth(new Date());
		}

		// 获取订单列表
		List<FindClientFollowOrder> resultOrder = new ArrayList<>();
		List<ClientFollow> orderList = this.clientFollowService.findTodayOrder(findTaskSetAndOrder);
		Long todayComplete = 0L;
		if (orderList != null && orderList.size() > 0) {
			// 获取客户的编码列表并获取图像
			List<String> codeList = new ArrayList<>();
			for (ClientFollow each : orderList) {
				codeList.add(each.getMemberNo());
			}
			List<FindPersonMemberName> memberList = this.personMemberBaseService.findByCodeList(codeList);
			Map<String, FindPersonMemberName> memberMap = new HashMap<>();
			for (FindPersonMemberName each : memberList) {
				memberMap.put(each.getMemberNo(), each);
			}

			// 设置返回信息
			for (ClientFollow each : orderList) {
				FindClientFollowOrder orderItem = new FindClientFollowOrder();
				orderItem.setCode(each.getCode());
				orderItem.setCreateDate(DateUtils.formatDate(each.getCreateDate(), "HH:mm"));
				orderItem.setMemberName(each.getMemberName());
				orderItem.setMemberNo(each.getMemberNo());
				orderItem.setOrderAmount(each.getOrderAmount());

				FindPersonMemberName findPersonMemberName = memberMap.get(each.getMemberNo());
				if (findPersonMemberName != null) {
					orderItem.setImgAddr(findPersonMemberName.getHeadAddress());

					// 客户姓名的顺序：微信备注 -> 微信昵称 -> 客户名称
					String memberName = StringUtils.isEmpty(findPersonMemberName.getNickNameRemarkWx()) ? (StringUtils.isEmpty(findPersonMemberName.getNickNameWx()) ? each.getMemberName()
							: findPersonMemberName.getNickNameWx()) : findPersonMemberName.getNickNameRemarkWx();
					orderItem.setMemberName(memberName);
				}
				resultOrder.add(orderItem);

				todayComplete += each.getOrderAmount();
			}
		}

		// 获取当月的订单累计额
		Long monthComplete = this.clientFollowService.findMonthOrderMoney(findTaskSetAndOrder);

		// 设置返回值
		Long todayUncomplete = numDay - todayComplete;
		FindTaskSetAndOrderReturn result = new FindTaskSetAndOrderReturn();
		result.setMonthSale(days * numDay);
		result.setMonthComplete(monthComplete == null ? 0 : monthComplete);
		result.setTodayNeedSale(numDay);
		// result.setTodayUncomplete(todayUncomplete > 0 ? todayUncomplete : 0);//修改为超额返回负数 update by leopeng
		result.setTodayUncomplete(todayUncomplete);
		result.setOrderList(resultOrder);
		result.setTaskUnit(taskUnit);
		return result;
	}

	@Override
	public MangerWorkReturn findMangerWork(FindMangerWork findMangerWork) throws TsfaServiceException {
		AssertUtils.notNull(findMangerWork);
		AssertUtils.notNullAndEmpty(findMangerWork.getMerchantNo(), "商户号不能为空");
		AssertUtils.notNullAndEmpty(findMangerWork.getShopNo(), "分店编号不能为空");
		AssertUtils.notNullAndEmpty(findMangerWork.getMemberNoGm(), "导购编号不能为空");
		try {
			MangerWorkReturn mangerWorkReturn = new MangerWorkReturn();
			mangerWorkReturn.setMemberNoGm(findMangerWork.getMemberNoGm());
			mangerWorkReturn.setMemberNameGm(findMangerWork.getMemberNameGm());

			FindGuidMemberIntegralDay findGuidMemberIntegralDay = new FindGuidMemberIntegralDay();
			findGuidMemberIntegralDay.setMemberNo(findMangerWork.getMemberNoGm());
			Date workDate = org.apache.commons.lang.time.DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
			findGuidMemberIntegralDay.setDaySt(workDate);
			List<FindGuidMemberIntegralDayReturn> list = guidMemberIntegralDayService.findByGMDayList(findGuidMemberIntegralDay);
			if (list != null && list.size() > 0) {
				Double total = 0.0;
				for (FindGuidMemberIntegralDayReturn findGuidMemberIntegralDayReturn : list) {
					total = total + findGuidMemberIntegralDayReturn.getIntegralScore();
				}
				mangerWorkReturn.setAvgWorkScore(total.intValue());
			}

			// 查询主要工作
			FindWorkTask findWorkTask = new FindWorkTask();
			findWorkTask.setShopNo(findMangerWork.getShopNo());
			findWorkTask.setMerchantNo(findMangerWork.getMerchantNo());
			findWorkTask.setMemberNoGm(findMangerWork.getMemberNoGm());
			findWorkTask.setNow(org.apache.commons.lang.time.DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
			List<MainWorkTaskList> workTaskList = workTaskService.findWtsMain(findWorkTask);
			mangerWorkReturn.setWorkTaskList(workTaskList);

			// 查询其他工作
			FindOtherTaskFinishInfo findOtherTaskFinishInfo = new FindOtherTaskFinishInfo();
			findOtherTaskFinishInfo.setMemberNoGm(findMangerWork.getMemberNoGm());
			findOtherTaskFinishInfo.setMerchantNo(findMangerWork.getMerchantNo());
			findOtherTaskFinishInfo.setShopNo(findMangerWork.getShopNo());
			findOtherTaskFinishInfo.setNow(org.apache.commons.lang.time.DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
			List<OtherTaskList> otherList = otherTaskFinishInfoService.findWtsOther(findOtherTaskFinishInfo);
			mangerWorkReturn.setOtherWorkTaskList(otherList);

			// 查询异常跟进列表
			FindUnfinishTaskSummary findUnfinishTaskSummary2 = new FindUnfinishTaskSummary();
			findUnfinishTaskSummary2.setShopNo(findMangerWork.getShopNo());
			findUnfinishTaskSummary2.setMerchantNo(findMangerWork.getMerchantNo());
			findUnfinishTaskSummary2.setMemberNoGm(findMangerWork.getMemberNoGm());
			List<UnfinishTaskList> unfinishList = unfinishTaskSummaryService.findWtsUnfinish(findUnfinishTaskSummary2);
			mangerWorkReturn.setOnfinishTaskList(unfinishList);

			// 查询累计异常跟进客户次数
			if (unfinishList != null && unfinishList.size() > 0) {
				mangerWorkReturn.setErrorNum(Long.valueOf(unfinishList.size()));
			} else {
				mangerWorkReturn.setErrorNum(Long.valueOf(0));
			}
			return mangerWorkReturn;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("添加店长任务设置明细信息错误！", e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_ADD_ERROR, "添加店长任务设置明细信息错误！", e);
		}

	}

	private int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.business.cf.service.ITaskSetShopService#findShopNoSetCount(com.lj.business.cf.dto.taskSetShop.FindNoSetShopCount)
	 */
	@Override
	public int findShopNoSetCount(FindNoSetShopCount findNoSetShopCount) throws TsfaServiceException {
		AssertUtils.notNull(findNoSetShopCount);
		AssertUtils.notNullAndEmpty(findNoSetShopCount.getMerchantNo(), "商户号不能为空");
		AssertUtils.notNullAndEmpty(findNoSetShopCount.getMemberNoShop(), "店长编号不能为空");
		try {
			int count = taskSetShopDao.findShopNoSetCount(findNoSetShopCount);
			return count;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("添加店长任务设置明细信息错误！", e);
			throw new TsfaServiceException(ErrorCode.TASK_SET_SHOP_DETAIL_ADD_ERROR, "添加店长任务设置明细信息错误！", e);
		}
	}

	@Override
	public NumDayAndTaskUnit findNumDayAndTaskUnit(FindTaskSetAndOrder findTaskSetAndOrder) {
		AssertUtils.notNull(findTaskSetAndOrder);
		AssertUtils.notNullAndEmpty(findTaskSetAndOrder.getTaskType(), "任务类型不能为空");
		AssertUtils.notNullAndEmpty(findTaskSetAndOrder.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(findTaskSetAndOrder.getMemberNoGm(), "导购编号不能为空");
		return taskSetShopDao.findNumDayAndTaskUnit(findTaskSetAndOrder);
	}

}
