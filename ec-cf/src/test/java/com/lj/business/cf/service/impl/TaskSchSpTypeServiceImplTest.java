package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.AddTaskSchSpType;
import com.lj.business.cf.dto.DelTaskSchSpType;
import com.lj.business.cf.dto.FindTaskSchSpType;
import com.lj.business.cf.dto.FindTaskSchSpTypePage;
import com.lj.business.cf.dto.FindTaskSchSpTypePageReturn;
import com.lj.business.cf.dto.UpdateTaskSchSpType;
import com.lj.business.cf.service.ITaskSchSpTypeService;


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
public class TaskSchSpTypeServiceImplTest extends SpringTestCase{

	@Resource
	ITaskSchSpTypeService taskSchSpTypeService;



	/**
	 * 
	 *
	 * 方法说明：添加店长待办事项类型信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addTaskSchSpType() throws TsfaServiceException{
		AddTaskSchSpType addTaskSchSpType = new AddTaskSchSpType();
		//add数据录入
		addTaskSchSpType.setMerchantNo("MerchantNo");
		addTaskSchSpType.setTaskName("TaskName");
		addTaskSchSpType.setCreateId("CreateId");
		
		Assert.assertNotNull(taskSchSpTypeService.addTaskSchSpType(addTaskSchSpType ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改店长待办事项类型信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateTaskSchSpType() throws TsfaServiceException{
		UpdateTaskSchSpType updateTaskSchSpType = new UpdateTaskSchSpType();
		//update数据录入
		updateTaskSchSpType.setCode("Code");
		updateTaskSchSpType.setTaskName("TaskName");

		taskSchSpTypeService.updateTaskSchSpType(updateTaskSchSpType );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店长待办事项类型信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findTaskSchSpType() throws TsfaServiceException{
		FindTaskSchSpType findTaskSchSpType = new FindTaskSchSpType();
		findTaskSchSpType.setCode("LJ_9ccb7039a3cd4ad78aee665d47b25f17");
		taskSchSpTypeService.findTaskSchSpType(findTaskSchSpType);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店长待办事项类型信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findTaskSchSpTypePage() throws TsfaServiceException{
		FindTaskSchSpTypePage findTaskSchSpTypePage = new FindTaskSchSpTypePage();
		Page<FindTaskSchSpTypePageReturn> page = taskSchSpTypeService.findTaskSchSpTypePage(findTaskSchSpTypePage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除店长待办事项类型信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delTaskSchSpType() throws TsfaServiceException{
		DelTaskSchSpType delTaskSchSpType = new DelTaskSchSpType();
		delTaskSchSpType.setCode("111");
		Assert.assertNotNull(taskSchSpTypeService.delTaskSchSpType(delTaskSchSpType));
		
	}
	
	
}
