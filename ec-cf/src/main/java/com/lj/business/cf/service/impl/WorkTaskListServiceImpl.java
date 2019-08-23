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

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IWorkTaskListDao;
import com.lj.business.cf.domain.WorkTaskList;
import com.lj.business.cf.dto.workTaskList.AddWorkTaskList;
import com.lj.business.cf.dto.workTaskList.AddWorkTaskListReturn;
import com.lj.business.cf.dto.workTaskList.DelWorkTaskList;
import com.lj.business.cf.dto.workTaskList.DelWorkTaskListReturn;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskList;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListPage;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListPageReturn;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListReturn;
import com.lj.business.cf.dto.workTaskList.UpdateWorkTaskList;
import com.lj.business.cf.dto.workTaskList.UpdateWorkTaskListReturn;
import com.lj.business.cf.service.IWorkTaskListService;


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
public class WorkTaskListServiceImpl implements IWorkTaskListService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(WorkTaskListServiceImpl.class);
	

	/** The work task list dao. */
	@Resource
	private IWorkTaskListDao workTaskListDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskListService#addWorkTaskList(com.lj.business.cf.dto.AddWorkTaskList)
	 */
	
	@Override
	public AddWorkTaskListReturn addWorkTaskList(
			AddWorkTaskList addWorkTaskList) throws TsfaServiceException {
		logger.debug("addWorkTaskList(AddWorkTaskList addWorkTaskList={}) - start", addWorkTaskList); 

		AssertUtils.notNull(addWorkTaskList);
		try {
			WorkTaskList workTaskList = new WorkTaskList();
			//add数据录入
			workTaskList.setCode(GUID.getPreUUID());
			workTaskList.setTaskName(addWorkTaskList.getTaskName());
			workTaskList.setTaskDesc(addWorkTaskList.getTaskDesc());
			workTaskList.setTaskType(addWorkTaskList.getTaskType());
			workTaskList.setStatus(StringUtils.toStringNull(addWorkTaskList.getStatus()));
			workTaskList.setCreateId(addWorkTaskList.getCreateId());
			workTaskList.setCreateDate(new Date());
			workTaskList.setTaskUnit(addWorkTaskList.getTaskUnit());
			workTaskListDao.insert(workTaskList);
			AddWorkTaskListReturn addWorkTaskListReturn = new AddWorkTaskListReturn();
			
			logger.debug("addWorkTaskList(AddWorkTaskList) - end - return value={}", addWorkTaskListReturn); 
			return addWorkTaskListReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增工作事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_LIST_ADD_ERROR,"新增工作事项表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskListService#delWorkTaskList(com.lj.business.cf.dto.DelWorkTaskList)
	 */
	
	@Override
	public DelWorkTaskListReturn delWorkTaskList(DelWorkTaskList delWorkTaskList) throws TsfaServiceException {
		logger.debug("delWorkTaskList(DelWorkTaskList delWorkTaskList={}) - start", delWorkTaskList); 

		AssertUtils.notNull(delWorkTaskList);
		AssertUtils.notNull(delWorkTaskList.getCode(),"ID不能为空！");
		try {
			workTaskListDao.deleteByPrimaryKey(delWorkTaskList.getCode());
			DelWorkTaskListReturn delWorkTaskListReturn  = new DelWorkTaskListReturn();

			logger.debug("delWorkTaskList(DelWorkTaskList) - end - return value={}", delWorkTaskListReturn); //$NON-NLS-1$
			return delWorkTaskListReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除工作事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_LIST_DEL_ERROR,"删除工作事项表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskListService#updateWorkTaskList(com.lj.business.cf.dto.UpdateWorkTaskList)
	 */
	
	@Override
	public UpdateWorkTaskListReturn updateWorkTaskList(
			UpdateWorkTaskList updateWorkTaskList)
			throws TsfaServiceException {
		logger.debug("updateWorkTaskList(UpdateWorkTaskList updateWorkTaskList={}) - start", updateWorkTaskList); //$NON-NLS-1$

		AssertUtils.notNull(updateWorkTaskList);
		AssertUtils.notNullAndEmpty(updateWorkTaskList.getCode(),"ID不能为空");
		try {
			WorkTaskList workTaskList = new WorkTaskList();
			//update数据录入
			workTaskList.setCode(updateWorkTaskList.getCode());
			workTaskList.setTaskName(updateWorkTaskList.getTaskName());
			workTaskList.setTaskDesc(updateWorkTaskList.getTaskDesc());
			workTaskList.setTaskType(updateWorkTaskList.getTaskType());
			workTaskList.setStatus(StringUtils.toStringNull(updateWorkTaskList.getStatus()));
			workTaskList.setCreateId(updateWorkTaskList.getCreateId());
			workTaskList.setCreateDate(updateWorkTaskList.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(workTaskListDao.updateByPrimaryKeySelective(workTaskList));
			UpdateWorkTaskListReturn updateWorkTaskListReturn = new UpdateWorkTaskListReturn();

			logger.debug("updateWorkTaskList(UpdateWorkTaskList) - end - return value={}", updateWorkTaskListReturn); //$NON-NLS-1$
			return updateWorkTaskListReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("工作事项表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_LIST_UPDATE_ERROR,"工作事项表信息更新信息错误！",e);
		}
	}
	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskListService#findWorkTaskList(com.lj.business.cf.dto.workTaskList.FindWorkTaskList)
	 */
	@Override
	public FindWorkTaskListReturn findWorkTaskList(FindWorkTaskList findWorkTaskList) throws TsfaServiceException {
		logger.debug("findWorkTaskList(FindWorkTaskList findWorkTaskList={}) - start", findWorkTaskList); //$NON-NLS-1$

		AssertUtils.notNull(findWorkTaskList);
		AssertUtils.notAllNull(findWorkTaskList.getCode(),"ID不能为空");
		try {
			WorkTaskList workTaskList = workTaskListDao.selectByPrimaryKey(findWorkTaskList.getCode());
			if(workTaskList == null){
				throw new TsfaServiceException(ErrorCode.WORK_TASK_LIST_NOT_EXIST_ERROR,"工作事项表信息不存在");
			}
			FindWorkTaskListReturn findWorkTaskListReturn = new FindWorkTaskListReturn();
			//find数据录入
			findWorkTaskListReturn.setCode(workTaskList.getCode());
			findWorkTaskListReturn.setTaskName(workTaskList.getTaskName());
			findWorkTaskListReturn.setTaskDesc(workTaskList.getTaskDesc());
			findWorkTaskListReturn.setTaskType(workTaskList.getTaskType());
			findWorkTaskListReturn.setStatus(StringUtils.toStringNull(workTaskList.getStatus()));
			findWorkTaskListReturn.setCreateId(workTaskList.getCreateId());
			findWorkTaskListReturn.setCreateDate(workTaskList.getCreateDate());
			
			logger.debug("findWorkTaskList(FindWorkTaskList) - end - return value={}", findWorkTaskListReturn); //$NON-NLS-1$
			return findWorkTaskListReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找工作事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_LIST_FIND_ERROR,"查找工作事项表信息错误！",e);
		}
	}
	
	
	public FindWorkTaskListReturn findWorkTaskListByTaskType(FindWorkTaskList findWorkTaskList) throws TsfaServiceException {
		logger.debug("findWorkTaskList(FindWorkTaskList findWorkTaskList={}) - start", findWorkTaskList); //$NON-NLS-1$

		AssertUtils.notNull(findWorkTaskList);
		AssertUtils.notNullAndEmpty(findWorkTaskList.getTaskType(),"任务类型不能为空");
		try {
			WorkTaskList workTaskList = workTaskListDao.findWorkTaskListByTaskType(findWorkTaskList);
			if(workTaskList == null){
				throw new TsfaServiceException(ErrorCode.WORK_TASK_LIST_NOT_EXIST_ERROR,"工作事项表信息不存在");
			}
			FindWorkTaskListReturn findWorkTaskListReturn = new FindWorkTaskListReturn();
			//find数据录入
			findWorkTaskListReturn.setCode(workTaskList.getCode());
			findWorkTaskListReturn.setTaskName(workTaskList.getTaskName());
			findWorkTaskListReturn.setTaskDesc(workTaskList.getTaskDesc());
			findWorkTaskListReturn.setTaskType(workTaskList.getTaskType());
			findWorkTaskListReturn.setStatus(StringUtils.toStringNull(workTaskList.getStatus()));
			findWorkTaskListReturn.setCreateId(workTaskList.getCreateId());
			findWorkTaskListReturn.setCreateDate(workTaskList.getCreateDate());
			
			logger.debug("findWorkTaskList(FindWorkTaskList) - end - return value={}", findWorkTaskListReturn); //$NON-NLS-1$
			return findWorkTaskListReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找工作事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_LIST_FIND_ERROR,"查找工作事项表信息错误！",e);
		}


	}
	
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskListService#findWorkTaskListPage(com.lj.business.cf.dto.FindWorkTaskListPage)
	 */
	
	@Override
	public List<FindWorkTaskListPageReturn> findWorkTaskListAll() throws TsfaServiceException {
		List<FindWorkTaskListPageReturn> list = new ArrayList<FindWorkTaskListPageReturn>();
		try{
			list = workTaskListDao.findWorkTaskListAll();
			return list;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找工作事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_LIST_FIND_ERROR,"查找工作事项表信息错误！",e);
		}
	}

	@Override
	public Page<FindWorkTaskListPageReturn> findWorkTaskListPage(
			FindWorkTaskListPage findWorkTaskListPage)
			throws TsfaServiceException {
		logger.debug("findWorkTaskListPage(FindWorkTaskListPage findWorkTaskListPage={}) - start", findWorkTaskListPage); //$NON-NLS-1$

		AssertUtils.notNull(findWorkTaskListPage);
		List<FindWorkTaskListPageReturn> returnList=null;
		int count = 0;
		try {
			returnList = workTaskListDao.findWorkTaskListPage(findWorkTaskListPage);
			count = workTaskListDao.findWorkTaskListPageCount(findWorkTaskListPage);
		}  catch (Exception e) {
			logger.error("工作事项表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_LIST_FIND_PAGE_ERROR,"工作事项表信息分页查询错误.！",e);
		}
		Page<FindWorkTaskListPageReturn> returnPage = new Page<FindWorkTaskListPageReturn>(returnList, count, findWorkTaskListPage);

		logger.debug("findWorkTaskListPage(FindWorkTaskListPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskListService#findWorkTaskListPages(com.lj.business.cf.dto.workTaskList.FindWorkTaskListPage)
	 */
	public List<FindWorkTaskListPageReturn> findWorkTaskListPages(
			FindWorkTaskListPage findWorkTaskListPage) throws TsfaServiceException {
		logger.debug("findWorkTaskListPages(FindWorkTaskListPage findWorkTaskListPage={}) - start", findWorkTaskListPage); 
		AssertUtils.notNull(findWorkTaskListPage);
		 List<FindWorkTaskListPageReturn> list = null;
		try {
			list=workTaskListDao.findWorkTaskListPages(findWorkTaskListPage);
		} catch (TsfaServiceException e) {
			logger.error("工作事项表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_LIST_FIND_PAGE_ERROR,"工作事项表信息分页查询错误.！",e);
		}
		
		return list;
	}

	@Override
	public List<WorkTaskList> findByCodeList(List<String> codeList) {
		return workTaskListDao.findByCodeList(codeList);
	}


}
