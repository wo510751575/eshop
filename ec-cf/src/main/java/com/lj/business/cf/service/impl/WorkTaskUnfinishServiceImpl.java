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
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IWorkTaskUnfinishDao;
import com.lj.business.cf.domain.WorkTaskUnfinish;
import com.lj.business.cf.dto.AddWorkTaskUnfinish;
import com.lj.business.cf.dto.AddWorkTaskUnfinishReturn;
import com.lj.business.cf.dto.DelWorkTaskUnfinish;
import com.lj.business.cf.dto.DelWorkTaskUnfinishReturn;
import com.lj.business.cf.dto.FindWorkTaskUnfinish;
import com.lj.business.cf.dto.FindWorkTaskUnfinishPage;
import com.lj.business.cf.dto.FindWorkTaskUnfinishPageReturn;
import com.lj.business.cf.dto.FindWorkTaskUnfinishReturn;
import com.lj.business.cf.dto.UpdateWorkTaskUnfinish;
import com.lj.business.cf.dto.UpdateWorkTaskUnfinishReturn;
import com.lj.business.cf.service.IWorkTaskUnfinishService;


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
public class WorkTaskUnfinishServiceImpl implements IWorkTaskUnfinishService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(WorkTaskUnfinishServiceImpl.class);
	

	/** The work task unfinish dao. */
	@Resource
	private IWorkTaskUnfinishDao workTaskUnfinishDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskUnfinishService#addWorkTaskUnfinish(com.lj.business.cf.dto.AddWorkTaskUnfinish)
	 */
	
	@Override
	public AddWorkTaskUnfinishReturn addWorkTaskUnfinish(
			AddWorkTaskUnfinish addWorkTaskUnfinish) throws TsfaServiceException {
		logger.debug("addWorkTaskUnfinish(AddWorkTaskUnfinish addWorkTaskUnfinish={}) - start", addWorkTaskUnfinish); 

		AssertUtils.notNull(addWorkTaskUnfinish);
		try {
			WorkTaskUnfinish workTaskUnfinish = new WorkTaskUnfinish();
			//add数据录入
			workTaskUnfinish.setMerchantNo(addWorkTaskUnfinish.getMerchantNo());
			workTaskUnfinish.setWorkDate(addWorkTaskUnfinish.getWorkDate());
			workTaskUnfinish.setMemberNoGm(addWorkTaskUnfinish.getMemberNoGm());
			workTaskUnfinish.setMemberNameGm(addWorkTaskUnfinish.getMemberNameGm());
			workTaskUnfinish.setTaskListCode(addWorkTaskUnfinish.getTaskListCode());
			workTaskUnfinish.setTaskName(addWorkTaskUnfinish.getTaskName());
			workTaskUnfinish.setRequireNum(addWorkTaskUnfinish.getRequireNum());
			workTaskUnfinish.setFinishNum(addWorkTaskUnfinish.getFinishNum());
			workTaskUnfinish.setUnfinishNum(addWorkTaskUnfinish.getUnfinishNum());
			workTaskUnfinish.setDefeatNum(addWorkTaskUnfinish.getDefeatNum());
			workTaskUnfinish.setWorkRatio(addWorkTaskUnfinish.getWorkRatio());
			workTaskUnfinish.setFinish(addWorkTaskUnfinish.getFinish());
			workTaskUnfinish.setReason(addWorkTaskUnfinish.getReason());
			workTaskUnfinish.setCreateId(addWorkTaskUnfinish.getCreateId());
			workTaskUnfinish.setRemark(addWorkTaskUnfinish.getRemark());
			workTaskUnfinish.setRemark2(addWorkTaskUnfinish.getRemark2());
			workTaskUnfinish.setRemark3(addWorkTaskUnfinish.getRemark3());
			workTaskUnfinish.setRemark4(addWorkTaskUnfinish.getRemark4());
			workTaskUnfinishDao.insert(workTaskUnfinish);
			AddWorkTaskUnfinishReturn addWorkTaskUnfinishReturn = new AddWorkTaskUnfinishReturn();
			
			logger.debug("addWorkTaskUnfinish(AddWorkTaskUnfinish) - end - return value={}", addWorkTaskUnfinishReturn); 
			return addWorkTaskUnfinishReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增未完成工作任务表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_UNFINISH_ADD_ERROR,"新增未完成工作任务表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskUnfinishService#delWorkTaskUnfinish(com.lj.business.cf.dto.DelWorkTaskUnfinish)
	 */
	
	@Override
	public DelWorkTaskUnfinishReturn delWorkTaskUnfinish(
			DelWorkTaskUnfinish delWorkTaskUnfinish) throws TsfaServiceException {
		logger.debug("delWorkTaskUnfinish(DelWorkTaskUnfinish delWorkTaskUnfinish={}) - start", delWorkTaskUnfinish); 

		AssertUtils.notNull(delWorkTaskUnfinish);
		AssertUtils.notNull(delWorkTaskUnfinish.getCode(),"ID不能为空！");
		try {
			workTaskUnfinishDao.deleteByPrimaryKey(delWorkTaskUnfinish.getCode());
			DelWorkTaskUnfinishReturn delWorkTaskUnfinishReturn  = new DelWorkTaskUnfinishReturn();

			logger.debug("delWorkTaskUnfinish(DelWorkTaskUnfinish) - end - return value={}", delWorkTaskUnfinishReturn); //$NON-NLS-1$
			return delWorkTaskUnfinishReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除未完成工作任务表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_UNFINISH_DEL_ERROR,"删除未完成工作任务表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskUnfinishService#updateWorkTaskUnfinish(com.lj.business.cf.dto.UpdateWorkTaskUnfinish)
	 */
	
	@Override
	public UpdateWorkTaskUnfinishReturn updateWorkTaskUnfinish(
			UpdateWorkTaskUnfinish updateWorkTaskUnfinish)
			throws TsfaServiceException {
		logger.debug("updateWorkTaskUnfinish(UpdateWorkTaskUnfinish updateWorkTaskUnfinish={}) - start", updateWorkTaskUnfinish); //$NON-NLS-1$

		AssertUtils.notNull(updateWorkTaskUnfinish);
		AssertUtils.notNullAndEmpty(updateWorkTaskUnfinish.getCode(),"ID不能为空");
		try {
			WorkTaskUnfinish workTaskUnfinish = new WorkTaskUnfinish();
			//update数据录入
			workTaskUnfinish.setCode(updateWorkTaskUnfinish.getCode());
			workTaskUnfinish.setMerchantNo(updateWorkTaskUnfinish.getMerchantNo());
			workTaskUnfinish.setWorkDate(updateWorkTaskUnfinish.getWorkDate());
			workTaskUnfinish.setMemberNoGm(updateWorkTaskUnfinish.getMemberNoGm());
			workTaskUnfinish.setMemberNameGm(updateWorkTaskUnfinish.getMemberNameGm());
			workTaskUnfinish.setTaskListCode(updateWorkTaskUnfinish.getTaskListCode());
			workTaskUnfinish.setTaskName(updateWorkTaskUnfinish.getTaskName());
			workTaskUnfinish.setRequireNum(updateWorkTaskUnfinish.getRequireNum());
			workTaskUnfinish.setFinishNum(updateWorkTaskUnfinish.getFinishNum());
			workTaskUnfinish.setUnfinishNum(updateWorkTaskUnfinish.getUnfinishNum());
			workTaskUnfinish.setDefeatNum(updateWorkTaskUnfinish.getDefeatNum());
			workTaskUnfinish.setWorkRatio(updateWorkTaskUnfinish.getWorkRatio());
			workTaskUnfinish.setFinish(updateWorkTaskUnfinish.getFinish());
			workTaskUnfinish.setReason(updateWorkTaskUnfinish.getReason());
			workTaskUnfinish.setCreateId(updateWorkTaskUnfinish.getCreateId());
			workTaskUnfinish.setRemark(updateWorkTaskUnfinish.getRemark());
			workTaskUnfinish.setRemark2(updateWorkTaskUnfinish.getRemark2());
			workTaskUnfinish.setRemark3(updateWorkTaskUnfinish.getRemark3());
			workTaskUnfinish.setRemark4(updateWorkTaskUnfinish.getRemark4());
			AssertUtils.notUpdateMoreThanOne(workTaskUnfinishDao.updateByPrimaryKeySelective(workTaskUnfinish));
			UpdateWorkTaskUnfinishReturn updateWorkTaskUnfinishReturn = new UpdateWorkTaskUnfinishReturn();

			logger.debug("updateWorkTaskUnfinish(UpdateWorkTaskUnfinish) - end - return value={}", updateWorkTaskUnfinishReturn); //$NON-NLS-1$
			return updateWorkTaskUnfinishReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("未完成工作任务表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_UNFINISH_UPDATE_ERROR,"未完成工作任务表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskUnfinishService#findWorkTaskUnfinish(com.lj.business.cf.dto.FindWorkTaskUnfinish)
	 */
	
	@Override
	public FindWorkTaskUnfinishReturn findWorkTaskUnfinish(
			FindWorkTaskUnfinish findWorkTaskUnfinish) throws TsfaServiceException {
		logger.debug("findWorkTaskUnfinish(FindWorkTaskUnfinish findWorkTaskUnfinish={}) - start", findWorkTaskUnfinish); //$NON-NLS-1$

		AssertUtils.notNull(findWorkTaskUnfinish);
		AssertUtils.notAllNull(findWorkTaskUnfinish.getCode(),"ID不能为空");
		try {
			WorkTaskUnfinish workTaskUnfinish = workTaskUnfinishDao.selectByPrimaryKey(findWorkTaskUnfinish.getCode());
			if(workTaskUnfinish == null){
				throw new TsfaServiceException(ErrorCode.WORK_TASK_UNFINISH_NOT_EXIST_ERROR,"未完成工作任务表信息不存在");
			}
			FindWorkTaskUnfinishReturn findWorkTaskUnfinishReturn = new FindWorkTaskUnfinishReturn();
			//find数据录入
			findWorkTaskUnfinishReturn.setCode(workTaskUnfinish.getCode());
			findWorkTaskUnfinishReturn.setMerchantNo(workTaskUnfinish.getMerchantNo());
			findWorkTaskUnfinishReturn.setWorkDate(workTaskUnfinish.getWorkDate());
			findWorkTaskUnfinishReturn.setMemberNoGm(workTaskUnfinish.getMemberNoGm());
			findWorkTaskUnfinishReturn.setMemberNameGm(workTaskUnfinish.getMemberNameGm());
			findWorkTaskUnfinishReturn.setTaskListCode(workTaskUnfinish.getTaskListCode());
			findWorkTaskUnfinishReturn.setTaskName(workTaskUnfinish.getTaskName());
			findWorkTaskUnfinishReturn.setRequireNum(workTaskUnfinish.getRequireNum());
			findWorkTaskUnfinishReturn.setFinishNum(workTaskUnfinish.getFinishNum());
			findWorkTaskUnfinishReturn.setUnfinishNum(workTaskUnfinish.getUnfinishNum());
			findWorkTaskUnfinishReturn.setDefeatNum(workTaskUnfinish.getDefeatNum());
			findWorkTaskUnfinishReturn.setWorkRatio(workTaskUnfinish.getWorkRatio());
			findWorkTaskUnfinishReturn.setFinish(workTaskUnfinish.getFinish());
			findWorkTaskUnfinishReturn.setReason(workTaskUnfinish.getReason());
			findWorkTaskUnfinishReturn.setCreateId(workTaskUnfinish.getCreateId());
			findWorkTaskUnfinishReturn.setCreateDate(workTaskUnfinish.getCreateDate());
			findWorkTaskUnfinishReturn.setRemark(workTaskUnfinish.getRemark());
			findWorkTaskUnfinishReturn.setRemark2(workTaskUnfinish.getRemark2());
			findWorkTaskUnfinishReturn.setRemark3(workTaskUnfinish.getRemark3());
			findWorkTaskUnfinishReturn.setRemark4(workTaskUnfinish.getRemark4());
			
			logger.debug("findWorkTaskUnfinish(FindWorkTaskUnfinish) - end - return value={}", findWorkTaskUnfinishReturn); //$NON-NLS-1$
			return findWorkTaskUnfinishReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找未完成工作任务表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_UNFINISH_FIND_ERROR,"查找未完成工作任务表信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskUnfinishService#findWorkTaskUnfinishPage(com.lj.business.cf.dto.FindWorkTaskUnfinishPage)
	 */
	
	@Override
	public Page<FindWorkTaskUnfinishPageReturn> findWorkTaskUnfinishPage(
			FindWorkTaskUnfinishPage findWorkTaskUnfinishPage)
			throws TsfaServiceException {
		logger.debug("findWorkTaskUnfinishPage(FindWorkTaskUnfinishPage findWorkTaskUnfinishPage={}) - start", findWorkTaskUnfinishPage); //$NON-NLS-1$

		AssertUtils.notNull(findWorkTaskUnfinishPage);
		List<FindWorkTaskUnfinishPageReturn> returnList;
		int count = 0;
		try {
			returnList = workTaskUnfinishDao.findWorkTaskUnfinishPage(findWorkTaskUnfinishPage);
			count = workTaskUnfinishDao.findWorkTaskUnfinishPageCount(findWorkTaskUnfinishPage);
		}  catch (Exception e) {
			logger.error("未完成工作任务表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.WORK_TASK_UNFINISH_FIND_PAGE_ERROR,"未完成工作任务表信息分页查询错误.！",e);
		}
		Page<FindWorkTaskUnfinishPageReturn> returnPage = new Page<FindWorkTaskUnfinishPageReturn>(returnList, count, findWorkTaskUnfinishPage);

		logger.debug("findWorkTaskUnfinishPage(FindWorkTaskUnfinishPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
