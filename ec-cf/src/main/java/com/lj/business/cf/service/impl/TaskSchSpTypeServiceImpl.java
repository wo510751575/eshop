package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.ITaskSchSpTypeDao;
import com.lj.business.cf.domain.TaskSchSpType;
import com.lj.business.cf.dto.AddTaskSchSpType;
import com.lj.business.cf.dto.AddTaskSchSpTypeReturn;
import com.lj.business.cf.dto.DelTaskSchSpType;
import com.lj.business.cf.dto.DelTaskSchSpTypeReturn;
import com.lj.business.cf.dto.FindTaskSchSpType;
import com.lj.business.cf.dto.FindTaskSchSpTypePage;
import com.lj.business.cf.dto.FindTaskSchSpTypePageReturn;
import com.lj.business.cf.dto.FindTaskSchSpTypeReturn;
import com.lj.business.cf.dto.UpdateTaskSchSpType;
import com.lj.business.cf.dto.UpdateTaskSchSpTypeReturn;
import com.lj.business.cf.service.ITaskSchSpTypeService;


/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class TaskSchSpTypeServiceImpl implements ITaskSchSpTypeService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(TaskSchSpTypeServiceImpl.class);
	

	/** The task sch sp type dao. */
	@Resource
	private ITaskSchSpTypeDao taskSchSpTypeDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpTypeService#addTaskSchSpType(com.lj.business.cf.dto.AddTaskSchSpType)
	 */
	
	@Override
	public AddTaskSchSpTypeReturn addTaskSchSpType(
			AddTaskSchSpType addTaskSchSpType) throws TsfaServiceException {
		logger.debug("addTaskSchSpType(AddTaskSchSpType addTaskSchSpType={}) - start", addTaskSchSpType); 

		AssertUtils.notNull(addTaskSchSpType);
		try {
			TaskSchSpType taskSchSpType = new TaskSchSpType();
			//add数据录入
			taskSchSpType.setCode(GUID.getPreUUID());
			taskSchSpType.setMerchantNo(addTaskSchSpType.getMerchantNo());
			taskSchSpType.setTaskName(addTaskSchSpType.getTaskName());
			taskSchSpType.setCreateId(addTaskSchSpType.getCreateId());
			taskSchSpTypeDao.insert(taskSchSpType);
			AddTaskSchSpTypeReturn addTaskSchSpTypeReturn = new AddTaskSchSpTypeReturn();
			
			logger.debug("addTaskSchSpType(AddTaskSchSpType) - end - return value={}", addTaskSchSpTypeReturn); 
			return addTaskSchSpTypeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增店长待办事项列表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_TYPE_ADD_ERROR,"新增店长待办事项列表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpTypeService#delTaskSchSpType(com.lj.business.cf.dto.DelTaskSchSpType)
	 */
	
	@Override
	public DelTaskSchSpTypeReturn delTaskSchSpType(
			DelTaskSchSpType delTaskSchSpType) throws TsfaServiceException {
		logger.debug("delTaskSchSpType(DelTaskSchSpType delTaskSchSpType={}) - start", delTaskSchSpType); 

		AssertUtils.notNull(delTaskSchSpType);
		AssertUtils.notNull(delTaskSchSpType.getCode(),"ID不能为空！");
		try {
			taskSchSpTypeDao.deleteByPrimaryKey(delTaskSchSpType.getCode());
			DelTaskSchSpTypeReturn delTaskSchSpTypeReturn  = new DelTaskSchSpTypeReturn();

			logger.debug("delTaskSchSpType(DelTaskSchSpType) - end - return value={}", delTaskSchSpTypeReturn); //$NON-NLS-1$
			return delTaskSchSpTypeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除店长待办事项类型信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_TYPE_DEL_ERROR,"删除店长待办事项类型信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpTypeService#updateTaskSchSpType(com.lj.business.cf.dto.UpdateTaskSchSpType)
	 */
	
	@Override
	public UpdateTaskSchSpTypeReturn updateTaskSchSpType(
			UpdateTaskSchSpType updateTaskSchSpType)
			throws TsfaServiceException {
		logger.debug("updateTaskSchSpType(UpdateTaskSchSpType updateTaskSchSpType={}) - start", updateTaskSchSpType); //$NON-NLS-1$

		AssertUtils.notNull(updateTaskSchSpType);
		AssertUtils.notNullAndEmpty(updateTaskSchSpType.getCode(),"ID不能为空");
		try {
			TaskSchSpType taskSchSpType = new TaskSchSpType();
			//update数据录入
			taskSchSpType.setCode(updateTaskSchSpType.getCode());
			taskSchSpType.setTaskName(updateTaskSchSpType.getTaskName());
			AssertUtils.notUpdateMoreThanOne(taskSchSpTypeDao.updateByPrimaryKeySelective(taskSchSpType));
			UpdateTaskSchSpTypeReturn updateTaskSchSpTypeReturn = new UpdateTaskSchSpTypeReturn();

			logger.debug("updateTaskSchSpType(UpdateTaskSchSpType) - end - return value={}", updateTaskSchSpTypeReturn); //$NON-NLS-1$
			return updateTaskSchSpTypeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("店长待办事项类型信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_TYPE_UPDATE_ERROR,"店长待办事项类型信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpTypeService#findTaskSchSpType(com.lj.business.cf.dto.FindTaskSchSpType)
	 */
	
	@Override
	public FindTaskSchSpTypeReturn findTaskSchSpType(
			FindTaskSchSpType findTaskSchSpType) throws TsfaServiceException {
		logger.debug("findTaskSchSpType(FindTaskSchSpType findTaskSchSpType={}) - start", findTaskSchSpType); //$NON-NLS-1$

		AssertUtils.notNull(findTaskSchSpType);
		AssertUtils.notAllNull(findTaskSchSpType.getCode(),"ID不能为空");
		try {
			TaskSchSpType taskSchSpType = taskSchSpTypeDao.selectByPrimaryKey(findTaskSchSpType.getCode());
			if(taskSchSpType == null){
				throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_TYPE_NOT_EXIST_ERROR,"店长待办事项类型信息不存在");
			}
			FindTaskSchSpTypeReturn findTaskSchSpTypeReturn = new FindTaskSchSpTypeReturn();
			//find数据录入
			findTaskSchSpTypeReturn.setCode(taskSchSpType.getCode());
			findTaskSchSpTypeReturn.setMerchantNo(taskSchSpType.getMerchantNo());
			findTaskSchSpTypeReturn.setTaskName(taskSchSpType.getTaskName());
			findTaskSchSpTypeReturn.setCreateId(taskSchSpType.getCreateId());
			findTaskSchSpTypeReturn.setCreateDate(taskSchSpType.getCreateDate());
			
			logger.debug("findTaskSchSpType(FindTaskSchSpType) - end - return value={}", findTaskSchSpTypeReturn); //$NON-NLS-1$
			return findTaskSchSpTypeReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找店长待办事项类型信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_TYPE_FIND_ERROR,"查找店长待办事项类型信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpTypeService#findTaskSchSpTypePage(com.lj.business.cf.dto.FindTaskSchSpTypePage)
	 */
	
	@Override
	public Page<FindTaskSchSpTypePageReturn> findTaskSchSpTypePage(
			FindTaskSchSpTypePage findTaskSchSpTypePage)
			throws TsfaServiceException {
		logger.debug("findTaskSchSpTypePage(FindTaskSchSpTypePage findTaskSchSpTypePage={}) - start", findTaskSchSpTypePage); //$NON-NLS-1$

		AssertUtils.notNull(findTaskSchSpTypePage);
		List<FindTaskSchSpTypePageReturn> returnList=null;
		int count = 0;
		try {
			returnList = taskSchSpTypeDao.findTaskSchSpTypePage(findTaskSchSpTypePage);
			count = taskSchSpTypeDao.findTaskSchSpTypePageCount(findTaskSchSpTypePage);
		}  catch (Exception e) {
			logger.error("店长待办事项类型信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_TYPE_FIND_PAGE_ERROR,"店长待办事项类型信息分页查询错误.！",e);
		}
		Page<FindTaskSchSpTypePageReturn> returnPage = new Page<FindTaskSchSpTypePageReturn>(returnList, count, findTaskSchSpTypePage);

		logger.debug("findTaskSchSpTypePage(FindTaskSchSpTypePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
