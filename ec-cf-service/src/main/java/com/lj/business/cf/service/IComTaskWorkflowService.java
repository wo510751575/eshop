package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.comTaskWorkflow.AddComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.DelComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowPage;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowPageReturn;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowReturn;
import com.lj.business.cf.dto.comTaskWorkflow.UpdateComTaskWorkflow;


/**
 * 类说明：接口类
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
public interface IComTaskWorkflowService {
	
	/**
	 * 
	 *
	 * 方法说明：添加客户沟通任务信息
	 *
	 * @param addComTaskWorkflow
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void addComTaskWorkflow(AddComTaskWorkflow addComTaskWorkflow) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务信息
	 *
	 * @param findComTaskWorkflow
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindComTaskWorkflowReturn findComTaskWorkflow(FindComTaskWorkflow findComTaskWorkflow) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除客户沟通任务信息
	 *
	 * @param delComTaskWorkflow
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void delComTaskWorkflow(DelComTaskWorkflow delComTaskWorkflow) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改客户沟通任务信息
	 *
	 * @param updateComTaskWorkflow
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void updateComTaskWorkflow(UpdateComTaskWorkflow updateComTaskWorkflow)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询客户沟通任务信息
	 *
	 * @param findComTaskWorkflowPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindComTaskWorkflowPageReturn> findComTaskWorkflowPage(FindComTaskWorkflowPage findComTaskWorkflowPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：客户购买信息-APP
	 *
	 * @param FindComTaskWorkflow
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author rain CreateDate: 2017年7月4日
	 *
	 */
	public List<FindComTaskWorkflowReturn> comTaskWorkFlowList(FindComTaskWorkflow findComTaskWorkflow) throws TsfaServiceException;
	

}
