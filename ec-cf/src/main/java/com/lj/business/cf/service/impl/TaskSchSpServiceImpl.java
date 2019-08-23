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
import com.lj.business.cf.dao.ITaskSchSpDao;
import com.lj.business.cf.domain.TaskSchSp;
import com.lj.business.cf.dto.AddTaskSchSp;
import com.lj.business.cf.dto.AddTaskSchSpReturn;
import com.lj.business.cf.dto.DelTaskSchSp;
import com.lj.business.cf.dto.DelTaskSchSpReturn;
import com.lj.business.cf.dto.FindTaskSchSp;
import com.lj.business.cf.dto.FindTaskSchSpList;
import com.lj.business.cf.dto.FindTaskSchSpListReturn;
import com.lj.business.cf.dto.FindTaskSchSpPage;
import com.lj.business.cf.dto.FindTaskSchSpPageReturn;
import com.lj.business.cf.dto.FindTaskSchSpReturn;
import com.lj.business.cf.dto.UpdateTaskSchSp;
import com.lj.business.cf.dto.UpdateTaskSchSpReturn;
import com.lj.business.cf.service.ITaskSchSpService;


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
public class TaskSchSpServiceImpl implements ITaskSchSpService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(TaskSchSpServiceImpl.class);
	

	/** The task sch sp dao. */
	@Resource
	private ITaskSchSpDao taskSchSpDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpService#addTaskSchSp(com.lj.business.cf.dto.AddTaskSchSp)
	 */
	@Override
	public AddTaskSchSpReturn addTaskSchSp(
			AddTaskSchSp addTaskSchSp) throws TsfaServiceException {
		logger.debug("addTaskSchSp(AddTaskSchSp addTaskSchSp={}) - start", addTaskSchSp); 

		AssertUtils.notNull(addTaskSchSp);
		try {
			TaskSchSp taskSchSp = new TaskSchSp();
			//add数据录入
			taskSchSp.setCode(addTaskSchSp.getCode());
			taskSchSp.setMerchantNo(addTaskSchSp.getMerchantNo());
			taskSchSp.setWorkDate(addTaskSchSp.getWorkDate());
			taskSchSp.setMemberNo(addTaskSchSp.getMemberNo());
			taskSchSp.setMemberName(addTaskSchSp.getMemberName());
			taskSchSp.setTsstCode(addTaskSchSp.getTsstCode());
			taskSchSp.setTaskName(addTaskSchSp.getTaskName());
			taskSchSp.setNum(addTaskSchSp.getNum());
			taskSchSp.setSeq(addTaskSchSp.getSeq());
			taskSchSp.setCreateId(addTaskSchSp.getCreateId());
			taskSchSp.setCreateDate(addTaskSchSp.getCreateDate());
			taskSchSpDao.insert(taskSchSp);
			AddTaskSchSpReturn addTaskSchSpReturn = new AddTaskSchSpReturn();
			
			logger.debug("addTaskSchSp(AddTaskSchSp) - end - return value={}", addTaskSchSpReturn); 
			return addTaskSchSpReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增店长待办事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_ADD_ERROR,"新增店长待办事项表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpService#delTaskSchSp(com.lj.business.cf.dto.DelTaskSchSp)
	 */
	@Override
	public DelTaskSchSpReturn delTaskSchSp(
			DelTaskSchSp delTaskSchSp) throws TsfaServiceException {
		logger.debug("delTaskSchSp(DelTaskSchSp delTaskSchSp={}) - start", delTaskSchSp); 

		AssertUtils.notNull(delTaskSchSp);
		AssertUtils.notNull(delTaskSchSp.getCode(),"ID不能为空！");
		try {
			taskSchSpDao.deleteByPrimaryKey(delTaskSchSp.getCode());
			DelTaskSchSpReturn delTaskSchSpReturn  = new DelTaskSchSpReturn();

			logger.debug("delTaskSchSp(DelTaskSchSp) - end - return value={}", delTaskSchSpReturn); //$NON-NLS-1$
			return delTaskSchSpReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除店长待办事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_DEL_ERROR,"删除店长待办事项表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpService#updateTaskSchSp(com.lj.business.cf.dto.UpdateTaskSchSp)
	 */
	@Override
	public UpdateTaskSchSpReturn updateTaskSchSp(
			UpdateTaskSchSp updateTaskSchSp)
			throws TsfaServiceException {
		logger.debug("updateTaskSchSp(UpdateTaskSchSp updateTaskSchSp={}) - start", updateTaskSchSp); //$NON-NLS-1$

		AssertUtils.notNull(updateTaskSchSp);
		AssertUtils.notNullAndEmpty(updateTaskSchSp.getCode(),"ID不能为空");
		try {
			TaskSchSp taskSchSp = new TaskSchSp();
			//update数据录入
			taskSchSp.setCode(GUID.getPreUUID());
			taskSchSp.setMerchantNo(GUID.generateByUUID());
			taskSchSp.setWorkDate(updateTaskSchSp.getWorkDate());
			taskSchSp.setMemberNo(updateTaskSchSp.getMemberNo());
			taskSchSp.setMemberName(updateTaskSchSp.getMemberName());
			taskSchSp.setTsstCode(updateTaskSchSp.getTsstCode());
			taskSchSp.setTaskName(updateTaskSchSp.getTaskName());
			taskSchSp.setNum(updateTaskSchSp.getNum());
			taskSchSp.setSeq(updateTaskSchSp.getSeq());
			taskSchSp.setCreateId(updateTaskSchSp.getCreateId());
			taskSchSp.setCreateDate(updateTaskSchSp.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(taskSchSpDao.updateByPrimaryKeySelective(taskSchSp));
			UpdateTaskSchSpReturn updateTaskSchSpReturn = new UpdateTaskSchSpReturn();

			logger.debug("updateTaskSchSp(UpdateTaskSchSp) - end - return value={}", updateTaskSchSpReturn); //$NON-NLS-1$
			return updateTaskSchSpReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("店长待办事项表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_UPDATE_ERROR,"店长待办事项表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpService#findTaskSchSp(com.lj.business.cf.dto.FindTaskSchSp)
	 */
	@Override
	public FindTaskSchSpReturn findTaskSchSp(
			FindTaskSchSp findTaskSchSp) throws TsfaServiceException {
		logger.debug("findTaskSchSp(FindTaskSchSp findTaskSchSp={}) - start", findTaskSchSp); //$NON-NLS-1$

		AssertUtils.notNull(findTaskSchSp);
		AssertUtils.notAllNull(findTaskSchSp.getCode(),"ID不能为空");
		try {
			TaskSchSp taskSchSp = taskSchSpDao.selectByPrimaryKey(findTaskSchSp.getCode());
			if(taskSchSp == null){
				throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_NOT_EXIST_ERROR,"店长待办事项表信息不存在");
			}
			FindTaskSchSpReturn findTaskSchSpReturn = new FindTaskSchSpReturn();
			//find数据录入
			findTaskSchSpReturn.setCode(taskSchSp.getCode());
			findTaskSchSpReturn.setMerchantNo(taskSchSp.getMerchantNo());
			findTaskSchSpReturn.setWorkDate(taskSchSp.getWorkDate());
			findTaskSchSpReturn.setMemberNo(taskSchSp.getMemberNo());
			findTaskSchSpReturn.setMemberName(taskSchSp.getMemberName());
			findTaskSchSpReturn.setTsstCode(taskSchSp.getTsstCode());
			findTaskSchSpReturn.setTaskName(taskSchSp.getTaskName());
			findTaskSchSpReturn.setNum(taskSchSp.getNum());
			findTaskSchSpReturn.setSeq(taskSchSp.getSeq());
			findTaskSchSpReturn.setCreateId(taskSchSp.getCreateId());
			findTaskSchSpReturn.setCreateDate(taskSchSp.getCreateDate());
			
			logger.debug("findTaskSchSp(FindTaskSchSp) - end - return value={}", findTaskSchSpReturn); //$NON-NLS-1$
			return findTaskSchSpReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找店长待办事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_FIND_ERROR,"查找店长待办事项表信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpService#findTaskSchSpPage(com.lj.business.cf.dto.FindTaskSchSpPage)
	 */
	@Override
	public Page<FindTaskSchSpPageReturn> findTaskSchSpPage(
			FindTaskSchSpPage findTaskSchSpPage)
			throws TsfaServiceException {
		logger.debug("findTaskSchSpPage(FindTaskSchSpPage findTaskSchSpPage={}) - start", findTaskSchSpPage); //$NON-NLS-1$

		AssertUtils.notNull(findTaskSchSpPage);
		List<FindTaskSchSpPageReturn> returnList;
		int count = 0;
		try {
			returnList = taskSchSpDao.findTaskSchSpPage(findTaskSchSpPage);
			count = taskSchSpDao.findTaskSchSpPageCount(findTaskSchSpPage);
		}  catch (Exception e) {
			logger.error("店长待办事项表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_FIND_PAGE_ERROR,"店长待办事项表信息分页查询错误.！",e);
		}
		Page<FindTaskSchSpPageReturn> returnPage = new Page<FindTaskSchSpPageReturn>(returnList, count, findTaskSchSpPage);

		logger.debug("findTaskSchSpPage(FindTaskSchSpPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ITaskSchSpService#findTaskSchSpList(com.lj.business.cf.dto.FindTaskSchSpList)
	 */
	@Override
	public List<FindTaskSchSpListReturn> findTaskSchSpList(
			FindTaskSchSpList findTaskSchSpList)
			throws TsfaServiceException {
		AssertUtils.notNull(findTaskSchSpList);
		//AssertUtils.notNull(findTaskSchSpList.getMemberNo());
		try {
			List<FindTaskSchSpListReturn> returnList = taskSchSpDao.findTaskSchSpList(findTaskSchSpList);
			return returnList;
		}  catch (Exception e) {
			logger.error("店长待办事项表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.TASK_SCH_SP_FIND_PAGE_ERROR,"店长待办事项表信息分页查询错误.！",e);
		}

	}




}
