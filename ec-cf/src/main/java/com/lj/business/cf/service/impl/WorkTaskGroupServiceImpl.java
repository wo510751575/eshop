package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
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
import com.lj.business.cf.dao.IWorkTaskGroupDao;
import com.lj.business.cf.domain.WorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.AddWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.AddWorkTaskGroupReturn;
import com.lj.business.cf.dto.workTaskGroup.DelWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.DelWorkTaskGroupReturn;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroupPage;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroupPageReturn;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroupReturn;
import com.lj.business.cf.dto.workTaskGroup.UpdateWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.UpdateWorkTaskGroupReturn;
import com.lj.business.cf.service.IWorkTaskGroupService;


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
public class WorkTaskGroupServiceImpl implements IWorkTaskGroupService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(WorkTaskGroupServiceImpl.class);
	

	/** The work task group dao. */
	@Resource
	private IWorkTaskGroupDao workTaskGroupDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskGroupService#addWorkTaskGroup(com.lj.business.cf.dto.AddWorkTaskGroup)
	 */
	
	@Override
	public AddWorkTaskGroupReturn addWorkTaskGroup(
			AddWorkTaskGroup addWorkTaskGroup) throws TsfaServiceException {
		logger.debug("addWorkTaskGroup(AddWorkTaskGroup addWorkTaskGroup={}) - start", addWorkTaskGroup); 

		AssertUtils.notNull(addWorkTaskGroup);
		try {
			WorkTaskGroup workTaskGroup = new WorkTaskGroup();
			//add数据录入
			workTaskGroup.setCode(GUID.getPreUUID());
			workTaskGroup.setMerchantNo(addWorkTaskGroup.getMerchantNo());
			workTaskGroup.setWtlCode(addWorkTaskGroup.getWtlCode());
			workTaskGroup.setTaskName(addWorkTaskGroup.getTaskName());
			workTaskGroup.setGroupName(addWorkTaskGroup.getGroupName());
			workTaskGroup.setCreateId(addWorkTaskGroup.getCreateId());
			workTaskGroup.setCreateDate(addWorkTaskGroup.getCreateDate());
			workTaskGroupDao.insert(workTaskGroup);
			AddWorkTaskGroupReturn addWorkTaskGroupReturn = new AddWorkTaskGroupReturn();
			
			logger.debug("addWorkTaskGroup(AddWorkTaskGroup) - end - return value={}", addWorkTaskGroupReturn); 
			return addWorkTaskGroupReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增工作事项分组表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_GROUP_ADD_ERROR,"新增工作事项分组表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskGroupService#delWorkTaskGroup(com.lj.business.cf.dto.DelWorkTaskGroup)
	 */
	
	@Override
	public DelWorkTaskGroupReturn delWorkTaskGroup(
			DelWorkTaskGroup delWorkTaskGroup) throws TsfaServiceException {
		logger.debug("delWorkTaskGroup(DelWorkTaskGroup delWorkTaskGroup={}) - start", delWorkTaskGroup); 

		AssertUtils.notNull(delWorkTaskGroup);
		AssertUtils.notNull(delWorkTaskGroup.getCode(),"ID不能为空！");
		try {
			workTaskGroupDao.deleteByPrimaryKey(delWorkTaskGroup.getCode());
			DelWorkTaskGroupReturn delWorkTaskGroupReturn  = new DelWorkTaskGroupReturn();

			logger.debug("delWorkTaskGroup(DelWorkTaskGroup) - end - return value={}", delWorkTaskGroupReturn); //$NON-NLS-1$
			return delWorkTaskGroupReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除工作事项分组表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_GROUP_DEL_ERROR,"删除工作事项分组表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskGroupService#updateWorkTaskGroup(com.lj.business.cf.dto.UpdateWorkTaskGroup)
	 */
	
	@Override
	public UpdateWorkTaskGroupReturn updateWorkTaskGroup(
			UpdateWorkTaskGroup updateWorkTaskGroup)
			throws TsfaServiceException {
		logger.debug("updateWorkTaskGroup(UpdateWorkTaskGroup updateWorkTaskGroup={}) - start", updateWorkTaskGroup); //$NON-NLS-1$

		AssertUtils.notNull(updateWorkTaskGroup);
		AssertUtils.notNullAndEmpty(updateWorkTaskGroup.getCode(),"ID不能为空");
		try {
			WorkTaskGroup workTaskGroup = new WorkTaskGroup();
			//update数据录入
			workTaskGroup.setCode(updateWorkTaskGroup.getCode());
			workTaskGroup.setMerchantNo(updateWorkTaskGroup.getMerchantNo());
			workTaskGroup.setWtlCode(updateWorkTaskGroup.getWtlCode());
			workTaskGroup.setTaskName(updateWorkTaskGroup.getTaskName());
			workTaskGroup.setGroupName(updateWorkTaskGroup.getGroupName());
			workTaskGroup.setCreateId(updateWorkTaskGroup.getCreateId());
			workTaskGroup.setCreateDate(updateWorkTaskGroup.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(workTaskGroupDao.updateByPrimaryKeySelective(workTaskGroup));
			UpdateWorkTaskGroupReturn updateWorkTaskGroupReturn = new UpdateWorkTaskGroupReturn();

			logger.debug("updateWorkTaskGroup(UpdateWorkTaskGroup) - end - return value={}", updateWorkTaskGroupReturn); //$NON-NLS-1$
			return updateWorkTaskGroupReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("工作事项分组表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_GROUP_UPDATE_ERROR,"工作事项分组表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskGroupService#findWorkTaskGroup(com.lj.business.cf.dto.FindWorkTaskGroup)
	 */
	
	@Override
	public FindWorkTaskGroupReturn findWorkTaskGroup(
			FindWorkTaskGroup findWorkTaskGroup) throws TsfaServiceException {
		logger.debug("findWorkTaskGroup(FindWorkTaskGroup findWorkTaskGroup={}) - start", findWorkTaskGroup); //$NON-NLS-1$

		AssertUtils.notNull(findWorkTaskGroup);
		AssertUtils.notAllNull(findWorkTaskGroup.getCode(),"ID不能为空");
		try {
			WorkTaskGroup workTaskGroup = workTaskGroupDao.selectByPrimaryKey(findWorkTaskGroup.getCode());
			if(workTaskGroup == null){
				throw new TsfaServiceException(ErrorCode.WORK_TASK_GROUP_NOT_EXIST_ERROR,"工作事项分组表信息不存在");
			}
			FindWorkTaskGroupReturn findWorkTaskGroupReturn = new FindWorkTaskGroupReturn();
			//find数据录入
			findWorkTaskGroupReturn.setCode(workTaskGroup.getCode());
			findWorkTaskGroupReturn.setMerchantNo(workTaskGroup.getMerchantNo());
			findWorkTaskGroupReturn.setWtlCode(workTaskGroup.getWtlCode());
			findWorkTaskGroupReturn.setTaskName(workTaskGroup.getTaskName());
			findWorkTaskGroupReturn.setGroupName(workTaskGroup.getGroupName());
			findWorkTaskGroupReturn.setCreateId(workTaskGroup.getCreateId());
			findWorkTaskGroupReturn.setCreateDate(workTaskGroup.getCreateDate());
			
			logger.debug("findWorkTaskGroup(FindWorkTaskGroup) - end - return value={}", findWorkTaskGroupReturn); //$NON-NLS-1$
			return findWorkTaskGroupReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找工作事项分组表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_GROUP_FIND_ERROR,"查找工作事项分组表信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskGroupService#findWorkTaskGroupPage(com.lj.business.cf.dto.FindWorkTaskGroupPage)
	 */
	
	@Override
	public Page<FindWorkTaskGroupPageReturn> findWorkTaskGroupPage(
			FindWorkTaskGroupPage findWorkTaskGroupPage)
			throws TsfaServiceException {
		logger.debug("findWorkTaskGroupPage(FindWorkTaskGroupPage findWorkTaskGroupPage={}) - start", findWorkTaskGroupPage); //$NON-NLS-1$

		AssertUtils.notNull(findWorkTaskGroupPage);
		List<FindWorkTaskGroupPageReturn> returnList;
		int count = 0;
		try {
			returnList = workTaskGroupDao.findWorkTaskGroupPage(findWorkTaskGroupPage);
			count = workTaskGroupDao.findWorkTaskGroupPageCount(findWorkTaskGroupPage);
		}  catch (Exception e) {
			logger.error("工作事项分组表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_GROUP_FIND_PAGE_ERROR,"工作事项分组表信息分页查询错误.！",e);
		}
		Page<FindWorkTaskGroupPageReturn> returnPage = new Page<FindWorkTaskGroupPageReturn>(returnList, count, findWorkTaskGroupPage);

		logger.debug("findWorkTaskGroupPage(FindWorkTaskGroupPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}




}
