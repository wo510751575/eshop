package com.lj.business.cf.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.workTaskList.AddWorkTaskList;
import com.lj.business.cf.dto.workTaskList.DelWorkTaskList;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskList;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListPage;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListPageReturn;
import com.lj.business.cf.dto.workTaskList.UpdateWorkTaskList;
import com.lj.business.cf.service.IWorkTaskListService;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */


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
public class WorkTaskListServiceImplTest extends SpringTestCase{

	@Resource
	IWorkTaskListService workTaskListService;



	/**
	 * 
	 *
	 * 方法说明：添加工作事项表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addWorkTaskList() throws TsfaServiceException{
		for (int i = 0; i < 4; i++) {
			AddWorkTaskList addWorkTaskList = new AddWorkTaskList();
			//add数据录入
			addWorkTaskList.setCode(GUID.getPreUUID());
			addWorkTaskList.setTaskName("客户沟通");
			addWorkTaskList.setTaskDesc("客户沟通");
			addWorkTaskList.setTaskType("很好");
			addWorkTaskList.setStatus("Y");
			addWorkTaskList.setCreateId("吴晶晶");
			addWorkTaskList.setCreateDate(new Date());
			
			Assert.assertNotNull(workTaskListService.addWorkTaskList(addWorkTaskList ));
		}
		
		
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改工作事项表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateWorkTaskList() throws TsfaServiceException{
		UpdateWorkTaskList updateWorkTaskList = new UpdateWorkTaskList();
		//update数据录入
		updateWorkTaskList.setCode(GUID.getPreUUID());
		updateWorkTaskList.setTaskName("TaskName");
		updateWorkTaskList.setTaskDesc("TaskDesc");
		updateWorkTaskList.setTaskType("很好");
		updateWorkTaskList.setStatus("Y");
		updateWorkTaskList.setCreateId("CreateId");
		updateWorkTaskList.setCreateDate(new Date());

		workTaskListService.updateWorkTaskList(updateWorkTaskList );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找工作事项表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWorkTaskList() throws TsfaServiceException{
		FindWorkTaskList findWorkTaskList = new FindWorkTaskList();
		findWorkTaskList.setCode("LJ_019f907efb7546a8aa6de12321c5d6b2");
		workTaskListService.findWorkTaskList(findWorkTaskList);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找工作事项表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWorkTaskListPage() throws TsfaServiceException{
		FindWorkTaskListPage findWorkTaskListPage = new FindWorkTaskListPage();
		findWorkTaskListPage.setTaskName("微信");
		Page<FindWorkTaskListPageReturn> page = workTaskListService.findWorkTaskListPage(findWorkTaskListPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除工作事项表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delWorkTaskList() throws TsfaServiceException{
		DelWorkTaskList delWorkTaskList = new DelWorkTaskList();
		delWorkTaskList.setCode("LJ_592ba314c2cb4468a3bcc97090800ee9");
		Assert.assertNotNull(workTaskListService.delWorkTaskList(delWorkTaskList));
		
	}
	
	
}
