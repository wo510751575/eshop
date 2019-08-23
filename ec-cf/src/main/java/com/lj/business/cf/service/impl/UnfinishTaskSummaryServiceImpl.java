package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IUnfinishTaskSummaryDao;
import com.lj.business.cf.domain.UnfinishTaskSummary;
import com.lj.business.cf.dto.UnfinishTaskList;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndex;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndexReturn;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetAndOrder;
import com.lj.business.cf.dto.taskSetShop.NumDayAndTaskUnit;
import com.lj.business.cf.dto.unfinishTaskSummary.AddUnfinishTaskSummary;
import com.lj.business.cf.dto.unfinishTaskSummary.DelUnfinishTaskSummary;
import com.lj.business.cf.dto.unfinishTaskSummary.FindUnfinishTaskSummary;
import com.lj.business.cf.dto.unfinishTaskSummary.FindUnfinishTaskSummaryReturn;
import com.lj.business.cf.dto.unfinishTaskSummary.UpdateUnfinishTaskSummary;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskList;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListReturn;
import com.lj.business.cf.emus.TaskType;
import com.lj.business.cf.emus.UnitType;
import com.lj.business.cf.service.IClientFollowService;
import com.lj.business.cf.service.IComTaskChooseService;
import com.lj.business.cf.service.ITaskSetShopService;
import com.lj.business.cf.service.IUnfinishTaskSummaryService;
import com.lj.business.cf.service.IWorkTaskListService;
import com.lj.business.member.dto.FindNewPmCountDto;
import com.lj.business.member.service.IPersonMemberService;

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
public class UnfinishTaskSummaryServiceImpl implements IUnfinishTaskSummaryService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(UnfinishTaskSummaryServiceImpl.class);
	

	@Resource
	private IUnfinishTaskSummaryDao unfinishTaskSummaryDao;
	
	@Resource
	private ITaskSetShopService taskSetShopService;
	
	@Resource
	public IPersonMemberService personMemberService;
	
	@Resource
	public IWorkTaskListService workTaskListService;
	
	@Resource
	public IComTaskChooseService comTaskChooseService;
	
	@Resource
	private IClientFollowService clientFollowService;
	
	@Override
	public void addUnfinishTaskSummary(
			AddUnfinishTaskSummary addUnfinishTaskSummary) throws TsfaServiceException {
		logger.debug("addUnfinishTaskSummary(AddUnfinishTaskSummary addUnfinishTaskSummary={}) - start", addUnfinishTaskSummary); 

		AssertUtils.notNull(addUnfinishTaskSummary);
		try {
			UnfinishTaskSummary unfinishTaskSummary = new UnfinishTaskSummary();
			//add数据录入
			unfinishTaskSummary.setCode(GUID.getPreUUID());
			unfinishTaskSummary.setMerchantNo(addUnfinishTaskSummary.getMerchantNo());
			unfinishTaskSummary.setShopNo(addUnfinishTaskSummary.getShopNo());
			unfinishTaskSummary.setShopName(addUnfinishTaskSummary.getShopName());
			unfinishTaskSummary.setMemberNoGm(addUnfinishTaskSummary.getMemberNoGm());
			unfinishTaskSummary.setMemberNameGm(addUnfinishTaskSummary.getMemberNameGm());
			unfinishTaskSummary.setCodeList(addUnfinishTaskSummary.getCodeList());
			unfinishTaskSummary.setNameList(addUnfinishTaskSummary.getNameList());
			unfinishTaskSummary.setErrorNum(addUnfinishTaskSummary.getErrorNum());
			unfinishTaskSummary.setTaskUnit(addUnfinishTaskSummary.getTaskUnit());
			unfinishTaskSummary.setCreateId(addUnfinishTaskSummary.getCreateId());
			unfinishTaskSummary.setCreateDate(addUnfinishTaskSummary.getCreateDate());
			unfinishTaskSummary.setRemark4(addUnfinishTaskSummary.getRemark4());
			unfinishTaskSummary.setRemark3(addUnfinishTaskSummary.getRemark3());
			unfinishTaskSummary.setRemark2(addUnfinishTaskSummary.getRemark2());
			unfinishTaskSummary.setRemark(addUnfinishTaskSummary.getRemark());
			unfinishTaskSummaryDao.insert(unfinishTaskSummary);
			logger.debug("addUnfinishTaskSummary(AddUnfinishTaskSummary) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增其他任务完成情况表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.UNFINISH_TASK_SUMMARY_ADD_ERROR,"新增其他任务完成情况表信息错误！",e);
		}
	}
	
	
	@Override
	public void delUnfinishTaskSummary(
			DelUnfinishTaskSummary delUnfinishTaskSummary) throws TsfaServiceException {
		logger.debug("delUnfinishTaskSummary(DelUnfinishTaskSummary delUnfinishTaskSummary={}) - start", delUnfinishTaskSummary); 

		AssertUtils.notNull(delUnfinishTaskSummary);
		AssertUtils.notNull(delUnfinishTaskSummary.getCode(),"Code不能为空！");
		try {
			unfinishTaskSummaryDao.deleteByPrimaryKey(delUnfinishTaskSummary.getCode());
			logger.debug("delUnfinishTaskSummary(DelUnfinishTaskSummary) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除其他任务完成情况表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.UNFINISH_TASK_SUMMARY_DEL_ERROR,"删除其他任务完成情况表信息错误！",e);

		}
	}

	@Override
	public void updateUnfinishTaskSummary(
			UpdateUnfinishTaskSummary updateUnfinishTaskSummary)
			throws TsfaServiceException {
		logger.debug("updateUnfinishTaskSummary(UpdateUnfinishTaskSummary updateUnfinishTaskSummary={}) - start", updateUnfinishTaskSummary); //$NON-NLS-1$

		AssertUtils.notNull(updateUnfinishTaskSummary);
		AssertUtils.notNullAndEmpty(updateUnfinishTaskSummary.getCode(),"Code不能为空");
		try {
			UnfinishTaskSummary unfinishTaskSummary = new UnfinishTaskSummary();
			//update数据录入
			unfinishTaskSummary.setCode(updateUnfinishTaskSummary.getCode());
			unfinishTaskSummary.setMerchantNo(updateUnfinishTaskSummary.getMerchantNo());
			unfinishTaskSummary.setShopNo(updateUnfinishTaskSummary.getShopNo());
			unfinishTaskSummary.setShopName(updateUnfinishTaskSummary.getShopName());
			unfinishTaskSummary.setMemberNoGm(updateUnfinishTaskSummary.getMemberNoGm());
			unfinishTaskSummary.setMemberNameGm(updateUnfinishTaskSummary.getMemberNameGm());
			unfinishTaskSummary.setCodeList(updateUnfinishTaskSummary.getCodeList());
			unfinishTaskSummary.setNameList(updateUnfinishTaskSummary.getNameList());
			unfinishTaskSummary.setErrorNum(updateUnfinishTaskSummary.getErrorNum());
			unfinishTaskSummary.setTaskUnit(updateUnfinishTaskSummary.getTaskUnit());
			unfinishTaskSummary.setCreateId(updateUnfinishTaskSummary.getCreateId());
			unfinishTaskSummary.setCreateDate(updateUnfinishTaskSummary.getCreateDate());
			unfinishTaskSummary.setRemark4(updateUnfinishTaskSummary.getRemark4());
			unfinishTaskSummary.setRemark3(updateUnfinishTaskSummary.getRemark3());
			unfinishTaskSummary.setRemark2(updateUnfinishTaskSummary.getRemark2());
			unfinishTaskSummary.setRemark(updateUnfinishTaskSummary.getRemark());
			AssertUtils.notUpdateMoreThanOne(unfinishTaskSummaryDao.updateByPrimaryKeySelective(unfinishTaskSummary));
			logger.debug("updateUnfinishTaskSummary(UpdateUnfinishTaskSummary) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("其他任务完成情况表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.UNFINISH_TASK_SUMMARY_UPDATE_ERROR,"其他任务完成情况表信息更新信息错误！",e);
		}
	}

	

	@Override
	public FindUnfinishTaskSummaryReturn findUnfinishTaskSummary(
			FindUnfinishTaskSummary findUnfinishTaskSummary) throws TsfaServiceException {
		logger.debug("findUnfinishTaskSummary(FindUnfinishTaskSummary findUnfinishTaskSummary={}) - start", findUnfinishTaskSummary); //$NON-NLS-1$

		AssertUtils.notNull(findUnfinishTaskSummary);
		AssertUtils.notAllNull(findUnfinishTaskSummary.getCode(),"Code不能为空");
		try {
			UnfinishTaskSummary unfinishTaskSummary = unfinishTaskSummaryDao.selectByPrimaryKey(findUnfinishTaskSummary.getCode());
			if(unfinishTaskSummary == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.UNFINISH_TASK_SUMMARY_NOT_EXIST_ERROR,"其他任务完成情况表信息不存在");
			}
			FindUnfinishTaskSummaryReturn findUnfinishTaskSummaryReturn = new FindUnfinishTaskSummaryReturn();
			//find数据录入
			findUnfinishTaskSummaryReturn.setCode(unfinishTaskSummary.getCode());
			findUnfinishTaskSummaryReturn.setMerchantNo(unfinishTaskSummary.getMerchantNo());
			findUnfinishTaskSummaryReturn.setShopNo(unfinishTaskSummary.getShopNo());
			findUnfinishTaskSummaryReturn.setShopName(unfinishTaskSummary.getShopName());
			findUnfinishTaskSummaryReturn.setMemberNoGm(unfinishTaskSummary.getMemberNoGm());
			findUnfinishTaskSummaryReturn.setMemberNameGm(unfinishTaskSummary.getMemberNameGm());
			findUnfinishTaskSummaryReturn.setCodeList(unfinishTaskSummary.getCodeList());
			findUnfinishTaskSummaryReturn.setNameList(unfinishTaskSummary.getNameList());
			findUnfinishTaskSummaryReturn.setErrorNum(unfinishTaskSummary.getErrorNum());
			findUnfinishTaskSummaryReturn.setTaskUnit(unfinishTaskSummary.getTaskUnit());
			findUnfinishTaskSummaryReturn.setCreateId(unfinishTaskSummary.getCreateId());
			findUnfinishTaskSummaryReturn.setCreateDate(unfinishTaskSummary.getCreateDate());
			findUnfinishTaskSummaryReturn.setRemark4(unfinishTaskSummary.getRemark4());
			findUnfinishTaskSummaryReturn.setRemark3(unfinishTaskSummary.getRemark3());
			findUnfinishTaskSummaryReturn.setRemark2(unfinishTaskSummary.getRemark2());
			findUnfinishTaskSummaryReturn.setRemark(unfinishTaskSummary.getRemark());
			
			logger.debug("findUnfinishTaskSummary(FindUnfinishTaskSummary) - end - return value={}", findUnfinishTaskSummaryReturn); //$NON-NLS-1$
			return findUnfinishTaskSummaryReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找其他任务完成情况表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.UNFINISH_TASK_SUMMARY_FIND_ERROR,"查找其他任务完成情况表信息信息错误！",e);
		}


	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IUnfinishTaskSummaryService#findUtsCountGm(com.lj.business.cf.dto.unfinishTaskSummary.FindUnfinishTaskSummary)
	 */
	@Override
	public int findUtsCountGm(FindUnfinishTaskSummary findUnfinishTaskSummary) throws TsfaServiceException {
		AssertUtils.notNull(findUnfinishTaskSummary);
		AssertUtils.notNullAndEmpty(findUnfinishTaskSummary.getMerchantNo(),"商户号不能为空");
		AssertUtils.notNullAndEmpty(findUnfinishTaskSummary.getShopNo(),"分店编号不能为空");
		AssertUtils.notNullAndEmpty(findUnfinishTaskSummary.getMemberNoGm(),"导购编号不能为空");
		try{
			int count = unfinishTaskSummaryDao.findUtsCountGm(findUnfinishTaskSummary);
			return count;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找其他任务完成情况表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.UNFINISH_TASK_SUMMARY_FIND_ERROR,"查找其他任务完成情况表信息信息错误！",e);
		}
		
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IUnfinishTaskSummaryService#findWtsUnfinish(com.lj.business.cf.dto.unfinishTaskSummary.FindUnfinishTaskSummary)
	 */
//	@Override
//	public List<UnfinishTaskList> findWtsUnfinish(FindUnfinishTaskSummary findUnfinishTaskSummary) throws TsfaServiceException {
//		AssertUtils.notNull(findUnfinishTaskSummary);
//		AssertUtils.notNullAndEmpty(findUnfinishTaskSummary.getMerchantNo(),"商户号不能为空");
//		AssertUtils.notNullAndEmpty(findUnfinishTaskSummary.getShopNo(),"分店编号不能为空");
//		AssertUtils.notNullAndEmpty(findUnfinishTaskSummary.getMemberNoGm(),"导购编号不能为空");
//		try{
//			List<UnfinishTaskList> list = new ArrayList<UnfinishTaskList>();
//			List<UnfinishTaskSummary> unFinishList = unfinishTaskSummaryDao.findWtsUnfinish(findUnfinishTaskSummary);
//			if(unFinishList != null && unFinishList.size() > 0){
//				UnfinishTaskList unfinishTaskList = new UnfinishTaskList();
//				for(UnfinishTaskSummary unfinishTaskSummary : unFinishList){
//					 unfinishTaskList = new UnfinishTaskList();
//					 unfinishTaskList.setErrorNum(unfinishTaskSummary.getErrorNum());
//					 unfinishTaskList.setCodeList(unfinishTaskSummary.getCodeList());
//					 unfinishTaskList.setNameList(unfinishTaskSummary.getNameList());
//					 unfinishTaskList.setTaskUnit(unfinishTaskSummary.getTaskUnit());
//					 list.add(unfinishTaskList);
//				}
//			}
//			return list;
//		}catch (TsfaServiceException e) {
//			logger.error(e.getMessage(),e);
//			throw e;
//		} catch (Exception e) {
//			logger.error("查找其他任务完成情况表信息信息错误！",e);
//			throw new TsfaServiceException(ErrorCode.UNFINISH_TASK_SUMMARY_FIND_ERROR,"查找其他任务完成情况表信息信息错误！",e);
//		}
//	}
	
	
	@Override
	public List<UnfinishTaskList> findWtsUnfinish(FindUnfinishTaskSummary findUnfinishTaskSummary) throws TsfaServiceException {
		AssertUtils.notNull(findUnfinishTaskSummary);
		AssertUtils.notNullAndEmpty(findUnfinishTaskSummary.getMerchantNo(),"商户号不能为空");
		AssertUtils.notNullAndEmpty(findUnfinishTaskSummary.getShopNo(),"分店编号不能为空");
		AssertUtils.notNullAndEmpty(findUnfinishTaskSummary.getMemberNoGm(),"导购编号不能为空");
		try{
			List<UnfinishTaskList> list = new ArrayList<UnfinishTaskList>();
			
			//本月新增欠
			FindTaskSetAndOrder findTaskSetAndOrder = new FindTaskSetAndOrder();
			findTaskSetAndOrder.setMemberNoGm(findUnfinishTaskSummary.getMemberNoGm());
			findTaskSetAndOrder.setMerchantNo(findUnfinishTaskSummary.getMerchantNo());
			findTaskSetAndOrder.setTaskType(TaskType.XIN_ZENG.toString());
			NumDayAndTaskUnit numDayAndTaskUnit = taskSetShopService.findNumDayAndTaskUnit(findTaskSetAndOrder);
			//计算月初到今天添加的总人
			Date monthFirstDate = DateUtils.getMonthFirstDay();//月初
			Date now = new Date();//今天
			int monthTotal = 0;
			FindNewPmCountDto findNewPmCountDto = new FindNewPmCountDto();
			findNewPmCountDto.setMemberNoGm(findUnfinishTaskSummary.getMemberNoGm());
			findNewPmCountDto.setMerchantNo(findUnfinishTaskSummary.getMerchantNo());
			findNewPmCountDto.setBeginDate(monthFirstDate);
			findNewPmCountDto.setEndDate(now);
			monthTotal =  personMemberService.findNewPmCount(findNewPmCountDto);
			//相差天数
			int difDay = DateUtils.differentDays(DateUtils.getMonthFirstDay(),new Date()) + 1;
			int monthNeedAdd = 0;
			if(null != numDayAndTaskUnit){
				monthNeedAdd = difDay * numDayAndTaskUnit.getNumDay().intValue();
			}
			int numDis = monthNeedAdd - monthTotal;
			if(numDis > 0){
				UnfinishTaskList unfinishTaskList = new UnfinishTaskList();
				unfinishTaskList.setErrorNum(Long.valueOf(numDis));
				unfinishTaskList.setTaskUnit(UnitType.GE.toString());
				unfinishTaskList.setTaskUnitName("个");
				FindWorkTaskList findWorkTaskList = new FindWorkTaskList();
				findWorkTaskList.setTaskType(TaskType.XIN_ZENG.toString());
				FindWorkTaskListReturn findWorkTaskListReturn = workTaskListService.findWorkTaskListByTaskType(findWorkTaskList);
				if(findWorkTaskListReturn != null){
					unfinishTaskList.setNameList(findWorkTaskListReturn.getTaskName());
					unfinishTaskList.setCodeList(findWorkTaskListReturn.getCode());
				}
				list.add(unfinishTaskList);
			}
			
			//本月沟通任务欠
			FindComTaskChooseIndex findComTaskChooseIndex = new FindComTaskChooseIndex();
			findComTaskChooseIndex.setFlag("DIS");
			findComTaskChooseIndex.setMemberNoGm(findUnfinishTaskSummary.getMemberNoGm());
			findComTaskChooseIndex.setMerchantNo(findUnfinishTaskSummary.getMerchantNo());
			List<FindComTaskChooseIndexReturn> listDis = comTaskChooseService.findComTaskChooseIndex(findComTaskChooseIndex);
			Integer numTodayDis = 0;
			for (FindComTaskChooseIndexReturn findComTaskChooseIndexReturn : listDis) {
				numTodayDis = numTodayDis + findComTaskChooseIndexReturn.getNumClient().intValue();
			}
			if(numTodayDis > 0){
				UnfinishTaskList unfinishTaskList = new UnfinishTaskList();
				unfinishTaskList.setErrorNum(Long.valueOf(numTodayDis));
				unfinishTaskList.setTaskUnit(UnitType.GE.toString());
				unfinishTaskList.setTaskUnitName("个");
				FindWorkTaskList findWorkTaskList = new FindWorkTaskList();
				findWorkTaskList.setTaskType(TaskType.GOU_TONG.toString());
				FindWorkTaskListReturn findWorkTaskListReturn = workTaskListService.findWorkTaskListByTaskType(findWorkTaskList);
				if(findWorkTaskListReturn != null){
					unfinishTaskList.setNameList(findWorkTaskListReturn.getTaskName());
					unfinishTaskList.setCodeList(findWorkTaskListReturn.getCode());
				}
				list.add(unfinishTaskList);
			}
			
			//本月销售目标欠
			FindTaskSetAndOrder findTaskSetAndOrder2 = new FindTaskSetAndOrder();
			findTaskSetAndOrder2.setMemberNoGm(findUnfinishTaskSummary.getMemberNoGm());
			findTaskSetAndOrder2.setMerchantNo(findUnfinishTaskSummary.getMerchantNo());
			findTaskSetAndOrder2.setTaskType(TaskType.XIAO_SHOU.toString());
			NumDayAndTaskUnit numDayAndTaskUnit2 = taskSetShopService.findNumDayAndTaskUnit(findTaskSetAndOrder2);
			//相差天数
			int difDay2 = DateUtils.differentDays(DateUtils.getMonthFirstDay(),new Date()) + 1;
			int monthNeedAdd2 = 0;
			if(null != numDayAndTaskUnit2){
				monthNeedAdd2 = difDay2 * numDayAndTaskUnit2.getNumDay().intValue();
			}
			//计算月初到今天的销售额
			Long monthComplete2 = clientFollowService.findMonthOrderMoney(findTaskSetAndOrder2);
			Long monthAdd2 = monthNeedAdd2 - (monthComplete2==null?0L:monthComplete2);
			if(monthAdd2 > 0){
				UnfinishTaskList unfinishTaskList = new UnfinishTaskList();
				unfinishTaskList.setErrorNum(Long.valueOf(monthAdd2));
				unfinishTaskList.setTaskUnit(UnitType.YUAN.toString());
				unfinishTaskList.setTaskUnitName("元");
				FindWorkTaskList findWorkTaskList = new FindWorkTaskList();
				findWorkTaskList.setTaskType(TaskType.XIAO_SHOU.toString());
				FindWorkTaskListReturn findWorkTaskListReturn = workTaskListService.findWorkTaskListByTaskType(findWorkTaskList);
				if(findWorkTaskListReturn != null){
					unfinishTaskList.setNameList(findWorkTaskListReturn.getTaskName());
					unfinishTaskList.setCodeList(findWorkTaskListReturn.getCode());
				}
				list.add(unfinishTaskList);
			}
			return list;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找其他任务完成情况表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.UNFINISH_TASK_SUMMARY_FIND_ERROR,"查找其他任务完成情况表信息信息错误！",e);
		}
	}
	
	
//	@Override
//	public Page<FindUnfinishTaskSummaryPageReturn> findUnfinishTaskSummaryPage(
//			FindUnfinishTaskSummaryPage findUnfinishTaskSummaryPage)
//			throws TsfaServiceException {
//		logger.debug("findUnfinishTaskSummaryPage(FindUnfinishTaskSummaryPage findUnfinishTaskSummaryPage={}) - start", findUnfinishTaskSummaryPage); //$NON-NLS-1$
//
//		AssertUtils.notNull(findUnfinishTaskSummaryPage);
//		List<FindUnfinishTaskSummaryPageReturn> returnList;
//		int count = 0;
//		try {
//			returnList = unfinishTaskSummaryDao.findUnfinishTaskSummaryPage(findUnfinishTaskSummaryPage);
//			count = unfinishTaskSummaryDao.findUnfinishTaskSummaryPageCount(findUnfinishTaskSummaryPage);
//		}  catch (Exception e) {
//			logger.error("其他任务完成情况表信息不存在错误",e);
//			throw new TsfaServiceException(ErrorCode.UNFINISH_TASK_SUMMARY_FIND_PAGE_ERROR,"其他任务完成情况表信息不存在错误.！",e);
//		}
//		Page<FindUnfinishTaskSummaryPageReturn> returnPage = new Page<FindUnfinishTaskSummaryPageReturn>(returnList, count, findUnfinishTaskSummaryPage);
//
//		logger.debug("findUnfinishTaskSummaryPage(FindUnfinishTaskSummaryPage) - end - return value={}", returnPage); //$NON-NLS-1$
//		return  returnPage;
//	} 
	
	
	


}
