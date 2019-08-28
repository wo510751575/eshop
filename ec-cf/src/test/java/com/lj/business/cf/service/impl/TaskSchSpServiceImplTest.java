package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.AddTaskSchSp;
import com.lj.business.cf.dto.DelTaskSchSp;
import com.lj.business.cf.dto.FindTaskSchSp;
import com.lj.business.cf.dto.FindTaskSchSpList;
import com.lj.business.cf.dto.FindTaskSchSpListReturn;
import com.lj.business.cf.dto.FindTaskSchSpPage;
import com.lj.business.cf.dto.FindTaskSchSpPageReturn;
import com.lj.business.cf.dto.UpdateTaskSchSp;
import com.lj.business.cf.service.ITaskSchSpService;


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
public class TaskSchSpServiceImplTest extends SpringTestCase{

	@Resource
	private ITaskSchSpService taskSchSpService;



	/**
	 * 
	 *
	 * 方法说明：添加店长待办事项表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addTaskSchSp() throws TsfaServiceException{
		AddTaskSchSp addTaskSchSp = new AddTaskSchSp();
		//add数据录入
		addTaskSchSp.setCode(GUID.getPreUUID());
		addTaskSchSp.setMerchantNo(GUID.generateByUUID());
		addTaskSchSp.setWorkDate(new Date());
		addTaskSchSp.setMemberNo("MemberNo");
		addTaskSchSp.setMemberName("MemberName");
		addTaskSchSp.setTsstCode("TsstCode");
		addTaskSchSp.setTaskName("TaskName");
		addTaskSchSp.setNum(1);
		addTaskSchSp.setSeq(1);
		addTaskSchSp.setCreateId("CreateId");
		addTaskSchSp.setCreateDate(new Date());
		
		Assert.assertNotNull(taskSchSpService.addTaskSchSp(addTaskSchSp ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改店长待办事项表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateTaskSchSp() throws TsfaServiceException{
		UpdateTaskSchSp updateTaskSchSp = new UpdateTaskSchSp();
		//update数据录入
		updateTaskSchSp.setCode(GUID.getPreUUID());
		updateTaskSchSp.setMerchantNo(GUID.generateByUUID());
		updateTaskSchSp.setWorkDate(new Date());
		updateTaskSchSp.setMemberNo("MemberNo");
		updateTaskSchSp.setMemberName("MemberName");
		updateTaskSchSp.setTsstCode("TsstCode");
		updateTaskSchSp.setTaskName("TaskName");
		updateTaskSchSp.setNum(1);
		updateTaskSchSp.setSeq(1);
		updateTaskSchSp.setCreateId("CreateId");
		updateTaskSchSp.setCreateDate(new Date());

		taskSchSpService.updateTaskSchSp(updateTaskSchSp );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店长待办事项表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findTaskSchSp() throws TsfaServiceException{
		FindTaskSchSp findTaskSchSp = new FindTaskSchSp();
		findTaskSchSp.setCode("LJ_e9f328998c864ba9963b4e1103f0e888");
		taskSchSpService.findTaskSchSp(findTaskSchSp);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店长待办事项表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findTaskSchSpPage() throws TsfaServiceException{
		FindTaskSchSpPage findTaskSchSpPage = new FindTaskSchSpPage();
		Page<FindTaskSchSpPageReturn> page = taskSchSpService.findTaskSchSpPage(findTaskSchSpPage);
		Assert.assertNotNull(page);
		
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：查找店长待办事项表信息LIST
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月26日
	 *
	 */
	@Test
	public void findTaskSchSpList() throws TsfaServiceException{
		FindTaskSchSpList findTaskSchSpList = new FindTaskSchSpList();
		List<FindTaskSchSpListReturn> page = taskSchSpService.findTaskSchSpList(findTaskSchSpList);
		Assert.assertNotNull(page);
		
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：删除店长待办事项表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delTaskSchSp() throws TsfaServiceException{
		DelTaskSchSp delTaskSchSp = new DelTaskSchSp();
		delTaskSchSp.setCode("LJ_a76a76dc30ee47cf80286afb9cbf46de");
		Assert.assertNotNull(taskSchSpService.delTaskSchSp(delTaskSchSp));
		
	}
	
	
}
