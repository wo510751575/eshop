package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.workTaskGroup.AddWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.DelWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroupPage;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroupPageReturn;
import com.lj.business.cf.dto.workTaskGroup.UpdateWorkTaskGroup;
import com.lj.business.cf.service.IWorkTaskGroupService;


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
public class WorkTaskGroupServiceImplTest extends SpringTestCase{

	@Resource
	IWorkTaskGroupService workTaskGroupService;



	/**
	 * 
	 *
	 * 方法说明：添加工作事项分组表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addWorkTaskGroup() throws TsfaServiceException{
		AddWorkTaskGroup addWorkTaskGroup = new AddWorkTaskGroup();
		//add数据录入
		addWorkTaskGroup.setCode(GUID.getPreUUID());
		addWorkTaskGroup.setMerchantNo("MerchantNo");
		addWorkTaskGroup.setWtlCode("WtlCode");
		addWorkTaskGroup.setTaskName("TaskName");
		addWorkTaskGroup.setGroupName("GroupName");
		addWorkTaskGroup.setCreateId("CreateId");
		addWorkTaskGroup.setCreateDate(new Date());
		
		Assert.assertNotNull(workTaskGroupService.addWorkTaskGroup(addWorkTaskGroup ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改工作事项分组表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateWorkTaskGroup() throws TsfaServiceException{
		UpdateWorkTaskGroup updateWorkTaskGroup = new UpdateWorkTaskGroup();
		//update数据录入
		updateWorkTaskGroup.setCode("Code");
		updateWorkTaskGroup.setMerchantNo("MerchantNo");
		updateWorkTaskGroup.setWtlCode("WtlCode");
		updateWorkTaskGroup.setTaskName("TaskName");
		updateWorkTaskGroup.setGroupName("GroupName");
		updateWorkTaskGroup.setCreateId("CreateId");
		updateWorkTaskGroup.setCreateDate(new Date());

		workTaskGroupService.updateWorkTaskGroup(updateWorkTaskGroup );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找工作事项分组表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWorkTaskGroup() throws TsfaServiceException{
		FindWorkTaskGroup findWorkTaskGroup = new FindWorkTaskGroup();
		findWorkTaskGroup.setCode("LJ_1406cff6c1fc454d8725d5062ec0ac21");
		workTaskGroupService.findWorkTaskGroup(findWorkTaskGroup);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找工作事项分组表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWorkTaskGroupPage() throws TsfaServiceException{
		FindWorkTaskGroupPage findWorkTaskGroupPage = new FindWorkTaskGroupPage();
		Page<FindWorkTaskGroupPageReturn> page = workTaskGroupService.findWorkTaskGroupPage(findWorkTaskGroupPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除工作事项分组表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delWorkTaskGroup() throws TsfaServiceException{
		DelWorkTaskGroup delWorkTaskGroup = new DelWorkTaskGroup();
		delWorkTaskGroup.setCode("code");
		Assert.assertNotNull(workTaskGroupService.delWorkTaskGroup(delWorkTaskGroup));
		
	}
	
	
}
