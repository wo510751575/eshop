package com.lj.business.cf.service.impl;

import java.util.HashMap;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IComTaskWorkflowDao;
import com.lj.business.cf.domain.ComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.AddComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.DelComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowPage;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowPageReturn;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowReturn;
import com.lj.business.cf.dto.comTaskWorkflow.UpdateComTaskWorkflow;
import com.lj.business.cf.service.IComTaskWorkflowService;


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
public class ComTaskWorkflowServiceImpl implements IComTaskWorkflowService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ComTaskWorkflowServiceImpl.class);
	

	/** The com task workflow dao. */
	@Resource
	private IComTaskWorkflowDao comTaskWorkflowDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskWorkflowService#addComTaskWorkflow(com.lj.business.cf.dto.comTaskWorkflow.AddComTaskWorkflow)
	 */
	
	@Override
	public void addComTaskWorkflow(
			AddComTaskWorkflow addComTaskWorkflow) throws TsfaServiceException {
		logger.debug("addComTaskWorkflow(AddComTaskWorkflow addComTaskWorkflow={}) - start", addComTaskWorkflow); 

		AssertUtils.notNull(addComTaskWorkflow);
		try {
			ComTaskWorkflow comTaskWorkflow = new ComTaskWorkflow();
			//add数据录入
			comTaskWorkflow.setCode(GUID.generateCode());
			comTaskWorkflow.setMerchantNo(addComTaskWorkflow.getMerchantNo());
			comTaskWorkflow.setCodeList(addComTaskWorkflow.getCodeList());
			comTaskWorkflow.setNameList(addComTaskWorkflow.getNameList());
			comTaskWorkflow.setNextCodeList(addComTaskWorkflow.getNextCodeList());
			comTaskWorkflow.setNextNameList(addComTaskWorkflow.getNextNameList());
			comTaskWorkflow.setFirst(addComTaskWorkflow.getFirst());
			comTaskWorkflow.setCreateId(addComTaskWorkflow.getCreateId());
			comTaskWorkflow.setRemark(addComTaskWorkflow.getRemark());
			comTaskWorkflowDao.insert(comTaskWorkflow);
			logger.debug("addComTaskWorkflow(AddComTaskWorkflow) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户沟通任务信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_WORKFLOW_ADD_ERROR,"新增客户沟通任务信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskWorkflowService#delComTaskWorkflow(com.lj.business.cf.dto.comTaskWorkflow.DelComTaskWorkflow)
	 */
	
	@Override
	public void delComTaskWorkflow(
			DelComTaskWorkflow delComTaskWorkflow) throws TsfaServiceException {
		logger.debug("delComTaskWorkflow(DelComTaskWorkflow delComTaskWorkflow={}) - start", delComTaskWorkflow); 

		AssertUtils.notNull(delComTaskWorkflow);
		AssertUtils.notNull(delComTaskWorkflow.getCode(),"Code不能为空！");
		try {
			comTaskWorkflowDao.deleteByPrimaryKey(delComTaskWorkflow.getCode());
			logger.debug("delComTaskWorkflow(DelComTaskWorkflow) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户沟通任务流程表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_WORKFLOW_DEL_ERROR,"删除客户沟通任务流程表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskWorkflowService#updateComTaskWorkflow(com.lj.business.cf.dto.comTaskWorkflow.UpdateComTaskWorkflow)
	 */
	
	@Override
	public void updateComTaskWorkflow(
			UpdateComTaskWorkflow updateComTaskWorkflow)
			throws TsfaServiceException {
		logger.debug("updateComTaskWorkflow(UpdateComTaskWorkflow updateComTaskWorkflow={}) - start", updateComTaskWorkflow); //$NON-NLS-1$

		AssertUtils.notNull(updateComTaskWorkflow);
		AssertUtils.notNullAndEmpty(updateComTaskWorkflow.getCode(),"Code不能为空");
		try {
			ComTaskWorkflow comTaskWorkflow = new ComTaskWorkflow();
			//update数据录入
			comTaskWorkflow.setCode(updateComTaskWorkflow.getCode());
			comTaskWorkflow.setMerchantNo(updateComTaskWorkflow.getMerchantNo());
			comTaskWorkflow.setCodeList(updateComTaskWorkflow.getCodeList());
			comTaskWorkflow.setNameList(updateComTaskWorkflow.getNameList());
			comTaskWorkflow.setNextCodeList(updateComTaskWorkflow.getNextCodeList());
			comTaskWorkflow.setNextNameList(updateComTaskWorkflow.getNextNameList());
			comTaskWorkflow.setFirst(updateComTaskWorkflow.getFirst());
			comTaskWorkflow.setRemark(updateComTaskWorkflow.getRemark());
			AssertUtils.notUpdateMoreThanOne(comTaskWorkflowDao.updateByPrimaryKeySelective(comTaskWorkflow));
			logger.debug("updateComTaskWorkflow(UpdateComTaskWorkflow) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户沟通任务流程表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_WORKFLOW_UPDATE_ERROR,"客户沟通任务流程表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskWorkflowService#findComTaskWorkflow(com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflow)
	 */
	
	@Override
	public FindComTaskWorkflowReturn findComTaskWorkflow(
			FindComTaskWorkflow findComTaskWorkflow) throws TsfaServiceException {
		logger.debug("findComTaskWorkflow(FindComTaskWorkflow findComTaskWorkflow={}) - start", findComTaskWorkflow); //$NON-NLS-1$

		AssertUtils.notNull(findComTaskWorkflow);
		AssertUtils.notAllNull(findComTaskWorkflow.getCode(),"Code不能为空");
		try {
			ComTaskWorkflow comTaskWorkflow = comTaskWorkflowDao.selectByPrimaryKey(findComTaskWorkflow.getCode());
			if(comTaskWorkflow == null){
				throw new TsfaServiceException(ErrorCode.COM_TASK_WORKFLOW_NOT_EXIST_ERROR,"客户沟通任务流程表信息不存在");
			}
			FindComTaskWorkflowReturn findComTaskWorkflowReturn = new FindComTaskWorkflowReturn();
			//find数据录入
			findComTaskWorkflowReturn.setCode(comTaskWorkflow.getCode());
			findComTaskWorkflowReturn.setMerchantNo(comTaskWorkflow.getMerchantNo());
			findComTaskWorkflowReturn.setCodeList(comTaskWorkflow.getCodeList());
			findComTaskWorkflowReturn.setNameList(comTaskWorkflow.getNameList());
			findComTaskWorkflowReturn.setNextCodeList(comTaskWorkflow.getNextCodeList());
			findComTaskWorkflowReturn.setNextNameList(comTaskWorkflow.getNextNameList());
			findComTaskWorkflowReturn.setFirst(comTaskWorkflow.getFirst());
			findComTaskWorkflowReturn.setCreateId(comTaskWorkflow.getCreateId());
			findComTaskWorkflowReturn.setCreateDate(comTaskWorkflow.getCreateDate());
			findComTaskWorkflowReturn.setRemark(comTaskWorkflow.getRemark());
			
			logger.debug("findComTaskWorkflow(FindComTaskWorkflow) - end - return value={}", findComTaskWorkflowReturn); //$NON-NLS-1$
			return findComTaskWorkflowReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户沟通任务信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_WORKFLOW_FIND_ERROR,"查找客户沟通任务流程表信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskWorkflowService#findComTaskWorkflowPage(com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowPage)
	 */
	
	@Override
	public Page<FindComTaskWorkflowPageReturn> findComTaskWorkflowPage(
			FindComTaskWorkflowPage findComTaskWorkflowPage)
			throws TsfaServiceException {
		logger.debug("findComTaskWorkflowPage(FindComTaskWorkflowPage findComTaskWorkflowPage={}) - start", findComTaskWorkflowPage); //$NON-NLS-1$

		AssertUtils.notNull(findComTaskWorkflowPage);
		List<FindComTaskWorkflowPageReturn> returnList;
		int count = 0;
		try {
			returnList = comTaskWorkflowDao.findComTaskWorkflowPage(findComTaskWorkflowPage);
			count = comTaskWorkflowDao.findComTaskWorkflowPageCount(findComTaskWorkflowPage);
		}  catch (Exception e) {
			logger.error("客户沟通任务流程表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_WORKFLOW_FIND_PAGE_ERROR,"客户沟通任务流程表信息分页查询错误.！",e);
		}
		Page<FindComTaskWorkflowPageReturn> returnPage = new Page<FindComTaskWorkflowPageReturn>(returnList, count, findComTaskWorkflowPage);

		logger.debug("findComTaskWorkflowPage(FindComTaskWorkflowPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskWorkflowService#comTaskWorkFlowList(com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflow)
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<FindComTaskWorkflowReturn> comTaskWorkFlowList(FindComTaskWorkflow findComTaskWorkflow)
			throws TsfaServiceException {
		logger.debug("comTaskWorkFlowList(FindClientFollow comTaskWorkFlowList={}) - start", findComTaskWorkflow); //$NON-NLS-1$

		List<FindComTaskWorkflowReturn> returnList;
		try {
			Map map = new HashMap();
			map.put("merchantNo", findComTaskWorkflow.getMerchantNo());
			map.put("codeList", findComTaskWorkflow.getCodeList());
			returnList = comTaskWorkflowDao.comTaskWorkFlowList(map);
		}  catch (Exception e) {
			logger.error("客户沟通任务流程表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_FIND_PAGE_ERROR,"客户沟通任务流程表信息分页查询错误.！",e);
		}

		logger.debug("comTaskWorkFlowList(comTaskWorkFlowList) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnList;
	} 


}
