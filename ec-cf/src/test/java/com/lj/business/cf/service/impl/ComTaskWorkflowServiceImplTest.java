package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.comTaskWorkflow.AddComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.DelComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowPage;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowPageReturn;
import com.lj.business.cf.dto.comTaskWorkflow.UpdateComTaskWorkflow;
import com.lj.business.cf.service.IComTaskWorkflowService;


/**
 * 类说明：测试类
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
public class ComTaskWorkflowServiceImplTest extends SpringTestCase{

	@Resource
	IComTaskWorkflowService comTaskWorkflowService;



	/**
	 * 
	 *
	 * 方法说明：添加客户沟通任务信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addComTaskWorkflow() throws TsfaServiceException{
		AddComTaskWorkflow addComTaskWorkflow = new AddComTaskWorkflow();
		//add数据录入
		addComTaskWorkflow.setMerchantNo("MerchantNo");
		addComTaskWorkflow.setCodeList("CodeList");
		addComTaskWorkflow.setNameList("NameList");
		addComTaskWorkflow.setNextCodeList("NextCodeList");
		addComTaskWorkflow.setNextNameList("NextNameList");
		addComTaskWorkflow.setCreateId("CreateId");
		addComTaskWorkflow.setRemark("Remark");
		
		comTaskWorkflowService.addComTaskWorkflow(addComTaskWorkflow );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户沟通任务信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateComTaskWorkflow() throws TsfaServiceException{
		UpdateComTaskWorkflow updateComTaskWorkflow = new UpdateComTaskWorkflow();
		//update数据录入
		updateComTaskWorkflow.setCode("Code");
		updateComTaskWorkflow.setMerchantNo("MerchantNo");
		updateComTaskWorkflow.setCodeList("CodeList");
		updateComTaskWorkflow.setNameList("NameList");
		updateComTaskWorkflow.setNextCodeList("NextCodeList");
		updateComTaskWorkflow.setNextNameList("NextNameList");
		updateComTaskWorkflow.setRemark("Remark");

		comTaskWorkflowService.updateComTaskWorkflow(updateComTaskWorkflow );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findComTaskWorkflow() throws TsfaServiceException{
		FindComTaskWorkflow findComTaskWorkflow = new FindComTaskWorkflow();
		findComTaskWorkflow.setCode("LJ_82927a71e4804001bfc3c735cda2c846");
		comTaskWorkflowService.findComTaskWorkflow(findComTaskWorkflow);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findComTaskWorkflowPage() throws TsfaServiceException{
		FindComTaskWorkflowPage findComTaskWorkflowPage = new FindComTaskWorkflowPage();
		Page<FindComTaskWorkflowPageReturn> page = comTaskWorkflowService.findComTaskWorkflowPage(findComTaskWorkflowPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除客户沟通任务信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delComTaskWorkflow() throws TsfaServiceException{
		DelComTaskWorkflow delComTaskWorkflow = new DelComTaskWorkflow();
		delComTaskWorkflow.setCode("111");
		comTaskWorkflowService.delComTaskWorkflow(delComTaskWorkflow);
		
	}
	
	
}
