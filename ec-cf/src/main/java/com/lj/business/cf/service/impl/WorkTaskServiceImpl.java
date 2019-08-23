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

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IWorkTaskDao;
import com.lj.business.cf.domain.WorkTask;
import com.lj.business.cf.dto.AddWorkTask;
import com.lj.business.cf.dto.AddWorkTaskReturn;
import com.lj.business.cf.dto.DelWorkTask;
import com.lj.business.cf.dto.DelWorkTaskReturn;
import com.lj.business.cf.dto.FindWorkTask;
import com.lj.business.cf.dto.FindWorkTaskMainList;
import com.lj.business.cf.dto.FindWorkTaskMainListReturn;
import com.lj.business.cf.dto.FindWorkTaskPage;
import com.lj.business.cf.dto.FindWorkTaskPageReturn;
import com.lj.business.cf.dto.FindWorkTaskReturn;
import com.lj.business.cf.dto.MainWorkTaskList;
import com.lj.business.cf.dto.UpdateWorkTask;
import com.lj.business.cf.dto.UpdateWorkTaskFinishNum;
import com.lj.business.cf.dto.UpdateWorkTaskReturn;
import com.lj.business.cf.dto.comTask.FindComTask;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskList;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListReturn;
import com.lj.business.cf.emus.ComTaskFinish;
import com.lj.business.cf.emus.TaskType;
import com.lj.business.cf.emus.UnitType;
import com.lj.business.cf.service.IComTaskService;
import com.lj.business.cf.service.ITaskSetShopService;
import com.lj.business.cf.service.IWorkTaskChooseService;
import com.lj.business.cf.service.IWorkTaskListService;
import com.lj.business.cf.service.IWorkTaskService;
import com.lj.business.member.service.IGuidMemberService;


/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class WorkTaskServiceImpl implements IWorkTaskService { 


	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(WorkTaskServiceImpl.class);


	/** The work task dao. */
	@Resource
	private IWorkTaskDao workTaskDao;

	/** The work task choose service. */
	@Resource
	private IWorkTaskChooseService workTaskChooseService;

	/** The work task list service. */
	@Resource
	private IWorkTaskListService workTaskListService;

	/** The task set shop service. */
	@Resource
	private ITaskSetShopService taskSetShopService;

	/** The guid member service. */
	@Resource
	private IGuidMemberService guidMemberService;
	
	/** The com task service. */
	@Resource
	private IComTaskService comTaskService;

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskService#addWorkTask(com.lj.business.cf.dto.AddWorkTask)
	 */

	@Override
	public AddWorkTaskReturn addWorkTask(
			AddWorkTask addWorkTask) throws TsfaServiceException {
		logger.debug("addWorkTask(AddWorkTask addWorkTask={}) - start", addWorkTask); 

		AssertUtils.notNull(addWorkTask);
		try {
			// 查询导购的数据是否存在
			Date now = new Date();
			FindWorkTask findWorkTask = new FindWorkTask();
			findWorkTask.setMerchantNo(addWorkTask.getMerchantNo());
			findWorkTask.setShopNo(addWorkTask.getShopNo());
			findWorkTask.setMemberNoGm(addWorkTask.getMemberNoGm());
			findWorkTask.setNow(now);
			findWorkTask.setCodeList(addWorkTask.getCodeList());
			int count = workTaskDao.findExistByMember(findWorkTask);
			if (count > 0) {
				logger.info("导购的数据已存在merchantNo=" + addWorkTask.getMerchantNo() + ",shopNo=" + addWorkTask.getShopNo() + ",memberNoGm=" + addWorkTask.getMemberNoGm() + ",now=" + now);
				return new AddWorkTaskReturn();
			}

			WorkTask workTask = new WorkTask();
			//add数据录入

			workTask.setCode(GUID.getPreUUID());
			workTask.setMerchantNo(addWorkTask.getMerchantNo());
			workTask.setShopNo(addWorkTask.getShopNo());
			workTask.setShopName(addWorkTask.getShopName());
			workTask.setMemberNoGm(addWorkTask.getMemberNoGm());
			workTask.setMemberNameGm(addWorkTask.getMemberNameGm());
			workTask.setCodeList(addWorkTask.getCodeList());
			workTask.setNameList(addWorkTask.getNameList());
			workTask.setWorkDate(addWorkTask.getWorkDate());
			workTask.setRequireNum(addWorkTask.getRequireNum());
			workTask.setFinishNum(addWorkTask.getFinishNum());
			workTask.setUnfinishNum(addWorkTask.getUnfinishNum());
			workTask.setDefeatNum(addWorkTask.getDefeatNum());
			workTask.setFinish(addWorkTask.getFinish());
			workTask.setReason(addWorkTask.getReason());
			workTask.setTaskType(addWorkTask.getTaskType());
			workTask.setTaskUnit(addWorkTask.getTaskUnit());
			workTask.setCreateId(addWorkTask.getCreateId());
			workTask.setRemark(addWorkTask.getRemark());
			workTask.setRemark2(addWorkTask.getRemark2());
			workTask.setRemark3(addWorkTask.getRemark3());
			workTask.setRemark4(addWorkTask.getRemark4());
			workTaskDao.insert(workTask);
			AddWorkTaskReturn addWorkTaskReturn = new AddWorkTaskReturn();

			logger.debug("addWorkTask(AddWorkTask) - end - return value={}", addWorkTaskReturn); 
			return addWorkTaskReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增工作任务统计表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_ADD_ERROR,"新增工作任务统计表信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskService#delWorkTask(com.lj.business.cf.dto.DelWorkTask)
	 */

	@Override
	public DelWorkTaskReturn delWorkTask(
			DelWorkTask delWorkTask) throws TsfaServiceException {
		logger.debug("delWorkTask(DelWorkTask delWorkTask={}) - start", delWorkTask); 

		AssertUtils.notNull(delWorkTask);
		AssertUtils.notNull(delWorkTask.getCode(),"ID不能为空！");
		try {
			workTaskDao.deleteByPrimaryKey(delWorkTask.getCode());
			DelWorkTaskReturn delWorkTaskReturn  = new DelWorkTaskReturn();

			logger.debug("delWorkTask(DelWorkTask) - end - return value={}", delWorkTaskReturn); //$NON-NLS-1$
			return delWorkTaskReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除工作任务统计表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_DEL_ERROR,"删除工作任务统计表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskService#updateWorkTask(com.lj.business.cf.dto.UpdateWorkTask)
	 */

	@Override
	public UpdateWorkTaskReturn updateWorkTask(
			UpdateWorkTask updateWorkTask)
					throws TsfaServiceException {
		logger.debug("updateWorkTask(UpdateWorkTask updateWorkTask={}) - start", updateWorkTask); //$NON-NLS-1$

		AssertUtils.notNull(updateWorkTask);
		AssertUtils.notNullAndEmpty(updateWorkTask.getCode(),"ID不能为空");
		try {
			WorkTask workTask = new WorkTask();
			//update数据录入
			workTask.setCode(updateWorkTask.getCode());
			workTask.setMerchantNo((GUID.getPreUUID()));
			workTask.setShopNo(updateWorkTask.getShopNo());
			workTask.setShopName(updateWorkTask.getShopName());
			workTask.setMemberNoGm(updateWorkTask.getMemberNoGm());
			workTask.setMemberNameGm(updateWorkTask.getMemberNameGm());
			workTask.setCodeList(updateWorkTask.getCodeList());
			workTask.setNameList(updateWorkTask.getNameList());
			workTask.setWorkDate(updateWorkTask.getWorkDate());
			workTask.setRequireNum(updateWorkTask.getRequireNum());
			workTask.setFinishNum(updateWorkTask.getFinishNum());
			workTask.setUnfinishNum(updateWorkTask.getUnfinishNum());
			workTask.setDefeatNum(updateWorkTask.getDefeatNum());
			workTask.setFinish(updateWorkTask.getFinish());
			workTask.setReason(updateWorkTask.getReason());
			workTask.setRemark(updateWorkTask.getRemark());
			workTask.setRemark2(updateWorkTask.getRemark2());
			workTask.setRemark3(updateWorkTask.getRemark3());
			workTask.setRemark4(updateWorkTask.getRemark4());
			AssertUtils.notUpdateMoreThanOne(workTaskDao.updateByPrimaryKeySelective(workTask));
			UpdateWorkTaskReturn updateWorkTaskReturn = new UpdateWorkTaskReturn();

			logger.debug("updateWorkTask(UpdateWorkTask) - end - return value={}", updateWorkTaskReturn); //$NON-NLS-1$
			return updateWorkTaskReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("工作任务统计表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_UPDATE_ERROR,"工作任务统计表信息更新错误！",e);
		}
	}



	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskService#findWorkTask(com.lj.business.cf.dto.FindWorkTask)
	 */

	@Override
	public FindWorkTaskReturn findWorkTask(
			FindWorkTask findWorkTask) throws TsfaServiceException {
		logger.debug("findWorkTask(FindWorkTask findWorkTask={}) - start", findWorkTask); //$NON-NLS-1$

		AssertUtils.notNull(findWorkTask);
		AssertUtils.notAllNull(findWorkTask.getCode(),"ID不能为空");
		try {
			WorkTask workTask = workTaskDao.selectByPrimaryKey(findWorkTask.getCode());
			if(workTask == null){
				throw new TsfaServiceException(ErrorCode.WORK_TASK_NOT_EXIST_ERROR,"工作任务统计表信息不存在");
			}
			FindWorkTaskReturn findWorkTaskReturn = new FindWorkTaskReturn();
			//find数据录入
			findWorkTaskReturn.setCode(GUID.getPreUUID());
			findWorkTaskReturn.setMerchantNo((GUID.getPreUUID()));
			findWorkTaskReturn.setShopNo(workTask.getShopNo());
			findWorkTaskReturn.setShopName(workTask.getShopName());
			findWorkTaskReturn.setMemberNoGm(workTask.getMemberNoGm());
			findWorkTaskReturn.setMemberNameGm(workTask.getMemberNameGm());
			findWorkTaskReturn.setCodeList(workTask.getCodeList());
			findWorkTaskReturn.setNameList(workTask.getNameList());
			findWorkTaskReturn.setWorkDate(workTask.getWorkDate());
			findWorkTaskReturn.setRequireNum(workTask.getRequireNum());
			findWorkTaskReturn.setFinishNum(workTask.getFinishNum());
			findWorkTaskReturn.setUnfinishNum(workTask.getUnfinishNum());
			findWorkTaskReturn.setDefeatNum(workTask.getDefeatNum());
			findWorkTaskReturn.setFinish(workTask.getFinish());
			findWorkTaskReturn.setReason(workTask.getReason());
			findWorkTaskReturn.setCreateId(workTask.getCreateId());
			findWorkTaskReturn.setCreateDate(workTask.getCreateDate());
			findWorkTaskReturn.setRemark(workTask.getRemark());
			findWorkTaskReturn.setRemark2(workTask.getRemark2());
			findWorkTaskReturn.setRemark3(workTask.getRemark3());
			findWorkTaskReturn.setRemark4(workTask.getRemark4());

			logger.debug("findWorkTask(FindWorkTask) - end - return value={}", findWorkTaskReturn); //$NON-NLS-1$
			return findWorkTaskReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找工作任务统计表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_FIND_ERROR,"查找工作任务统计表信息错误！",e);
		}


	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskService#findWorkTaskPage(com.lj.business.cf.dto.FindWorkTaskPage)
	 */

	@Override
	public Page<FindWorkTaskPageReturn> findWorkTaskPage(
			FindWorkTaskPage findWorkTaskPage)
					throws TsfaServiceException {
		logger.debug("findWorkTaskPage(FindWorkTaskPage findWorkTaskPage={}) - start", findWorkTaskPage); //$NON-NLS-1$

		AssertUtils.notNull(findWorkTaskPage);
		List<FindWorkTaskPageReturn> returnList;
		int count = 0;
		try {
			returnList = workTaskDao.findWorkTaskPage(findWorkTaskPage);
			count = workTaskDao.findWorkTaskPageCount(findWorkTaskPage);
		}  catch (Exception e) {
			logger.error("工作任务统计表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_FIND_PAGE_ERROR,"工作任务统计表信息分页查询错误.！",e);
		}
		Page<FindWorkTaskPageReturn> returnPage = new Page<FindWorkTaskPageReturn>(returnList, count, findWorkTaskPage);

		logger.debug("findWorkTaskPage(FindWorkTaskPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;

	}



	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskService#findWorkTaskMainList(com.lj.business.cf.dto.FindWorkTaskMainList)
	 */

	@Override
	public List<FindWorkTaskMainListReturn> findWorkTaskMainList(
			FindWorkTaskMainList findWorkTaskMainList)
					throws TsfaServiceException {
		logger.debug("findWorkTaskMainList(FindWorkTaskMainList findWorkTaskMainList={}) - start", findWorkTaskMainList); //$NON-NLS-1$

		AssertUtils.notNull(findWorkTaskMainList);
		AssertUtils.notNull(findWorkTaskMainList.getWorkDate(),"工作日期不能为空！");
		AssertUtils.notNull(findWorkTaskMainList.getMemberNoGm(),"导购编号不能为空！");
		//AssertUtils.notNull(findWorkTaskMainList.getShopTaskType(),"任务类型不能为空！");
		try {
			List<FindWorkTaskMainListReturn> returnList = workTaskDao.findWorkTaskMainList(findWorkTaskMainList);
			for (FindWorkTaskMainListReturn findWorkTaskMainListReturn : returnList) {

				Map<String, Integer> map = setServiceTypeCount(findWorkTaskMainListReturn.getTaskType(), findWorkTaskMainList.getMemberNoGm(),
						findWorkTaskMainList.getMerchantNo());
				findWorkTaskMainListReturn.setRequireNum(map.get("requireNum") == -1 ? findWorkTaskMainListReturn.getRequireNum() : map.get("requireNum"));
				findWorkTaskMainListReturn.setFinishNum(map.get("finishCount") == -1 ? findWorkTaskMainListReturn.getFinishNum() : map.get("finishCount"));
				
				String taskUnit =  findWorkTaskMainListReturn.getTaskUnit();
				if(StringUtils.isEmpty(taskUnit)){
					taskUnit = "个";
				}else{
					taskUnit = UnitType.valueOf(taskUnit).getName();
				}

				String title = findWorkTaskMainListReturn.getNameList() + "（"+ findWorkTaskMainListReturn.getRequireNum()  +taskUnit + "）";
				String desc = "完成" + findWorkTaskMainListReturn.getFinishNum() + taskUnit + " 击败"+ findWorkTaskMainListReturn.getDefeatNum() + taskUnit +"导购";
				findWorkTaskMainListReturn.setTitle(title);
				findWorkTaskMainListReturn.setDesc(desc);
			}

			logger.debug("findWorkTaskMainList(FindWorkTaskMainList) - end - return value={}", returnList); //$NON-NLS-1$
			return  returnList;
		}  catch (Exception e) {
			logger.error("工作任务统计表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_FIND_PAGE_ERROR,"工作任务统计表信息分页查询错误.！",e);
		}

	}


	private Map<String, Integer> setServiceTypeCount(String taskType, String memberNoGm, String merchantNo) {
		Map<String, Integer> map = new HashMap<>();
		int finishCount = -1;
		int requireNum = -1;
		if (TaskType.GOU_TONG.toString().equals(taskType)) {
			FindComTask findComTask = new FindComTask();
			findComTask.setMemberNoGm(memberNoGm);
			findComTask.setMerchantNo(merchantNo);
			Date workDate = org.apache.commons.lang.time.DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
			findComTask.setDate(workDate);
			requireNum = comTaskService.findCountFinishByDay(findComTask);//沟通任务需求量
			findComTask.setFinish(ComTaskFinish.FINISH.toString());
			finishCount = comTaskService.findCountFinishByDay(findComTask);//沟通任务完成量
		}
		map.put("finishCount", finishCount);
		map.put("requireNum", requireNum);
		return map;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskService#findWtsMain(com.lj.business.cf.dto.FindWorkTask)
	 */
	@Override
	public List<MainWorkTaskList> findWtsMain(FindWorkTask findWorkTask) throws TsfaServiceException {
		AssertUtils.notNull(findWorkTask);
		AssertUtils.notNull(findWorkTask.getMemberNoGm(),"导购编号不能为空！");
		AssertUtils.notNull(findWorkTask.getShopNo(),"分店编号不能为空！");
		AssertUtils.notNull(findWorkTask.getMerchantNo(),"商户编号不能为空！");
		try{
			List<MainWorkTaskList> list = new ArrayList<MainWorkTaskList>();
			
			List<WorkTask> wtList = workTaskDao.findWtsMain(findWorkTask);
			
			if(wtList != null && wtList.size() > 0){
				MainWorkTaskList mainWorkTaskList = new MainWorkTaskList();
				for(WorkTask workTask : wtList){
					Map<String,Integer> map = setServiceTypeCount(workTask.getTaskType(), findWorkTask.getMemberNoGm(),
							findWorkTask.getMerchantNo());
					workTask.setRequireNum(map.get("requireNum") == -1 ? workTask.getRequireNum() : map.get("requireNum"));
					workTask.setFinishNum(map.get("finishCount") == -1 ? workTask.getFinishNum() : map.get("finishCount"));
					
					mainWorkTaskList = new MainWorkTaskList();
					mainWorkTaskList.setCodeList(workTask.getCodeList());
					mainWorkTaskList.setFinishNum(workTask.getFinishNum());
					mainWorkTaskList.setNameList(workTask.getNameList());
					mainWorkTaskList.setRequireNum(workTask.getRequireNum());
					mainWorkTaskList.setTaskUnit(workTask.getTaskUnit());
					mainWorkTaskList.setTaskUnitName(workTask.getTaskUnit());
					list.add(mainWorkTaskList);
				}
			}

			return list;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找工作任务统计表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_FIND_ERROR,"查找工作任务统计表信息错误！",e);
		}

	}



	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskService#updateFinishNum(com.lj.business.cf.dto.UpdateWorkTaskFinishNum)
	 */
	@Override
	public int updateFinishNum(UpdateWorkTaskFinishNum updateWorkTaskFinishNum) {
		AssertUtils.notNull(updateWorkTaskFinishNum);
		AssertUtils.notNullAndEmpty(updateWorkTaskFinishNum.getMerchantNo(),"商户编号不能为空！");
		AssertUtils.notNullAndEmpty(updateWorkTaskFinishNum.getMemberNoGm(),"导购编号不能为空！");
		AssertUtils.notNullAndEmpty(updateWorkTaskFinishNum.getTaskType(),"任务类型不能为空！");
		validAndInit(updateWorkTaskFinishNum);
		return workTaskDao.updateFinishNum(updateWorkTaskFinishNum);
	}

	/**
	 * 方法说明：.
	 *
	 * @param updateWorkTaskFinishNum the update work task finish num
	 * @author 彭阳 CreateDate: 2017年8月19日
	 */
	private void validAndInit(UpdateWorkTaskFinishNum updateWorkTaskFinishNum) {
		FindWorkTaskList findWorkTaskList = new FindWorkTaskList();
		findWorkTaskList.setTaskType(updateWorkTaskFinishNum.getTaskType().toString());
		FindWorkTaskListReturn workTaskListByTaskType = workTaskListService.findWorkTaskListByTaskType(findWorkTaskList);
		updateWorkTaskFinishNum.setCodeList(workTaskListByTaskType.getCode());
		if (updateWorkTaskFinishNum.getWorkDate() == null) {
			updateWorkTaskFinishNum.setWorkDate(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH) );
		}
		if (updateWorkTaskFinishNum.getFinishNum() == null) {
			updateWorkTaskFinishNum.setFinishNum(1L);
		}
	}


	@Override
	public int updateRequireNumByGmTypeDay(UpdateWorkTask updateWorkTask) {
		AssertUtils.notNull(updateWorkTask);
		AssertUtils.notNullAndEmpty(updateWorkTask.getMemberNoGm(),"导购编号不能为空！");
		AssertUtils.notNullAndEmpty(updateWorkTask.getTaskType(),"任务类型不能为空！");
		AssertUtils.notNullAndEmpty(updateWorkTask.getWorkDate(),"工作时间不能为空！");
		return workTaskDao.updateRequireNumByGmTypeDay(updateWorkTask);
	}



}
