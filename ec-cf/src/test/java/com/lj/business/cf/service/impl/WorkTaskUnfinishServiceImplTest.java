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
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.AddWorkTaskUnfinish;
import com.lj.business.cf.dto.DelWorkTaskUnfinish;
import com.lj.business.cf.dto.FindWorkTaskUnfinish;
import com.lj.business.cf.dto.FindWorkTaskUnfinishPage;
import com.lj.business.cf.dto.FindWorkTaskUnfinishPageReturn;
import com.lj.business.cf.dto.UpdateWorkTaskUnfinish;
import com.lj.business.cf.service.IWorkTaskUnfinishService;


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
public class WorkTaskUnfinishServiceImplTest extends SpringTestCase{

	@Resource
	IWorkTaskUnfinishService workTaskUnfinishService;



	/**
	 * 
	 *
	 * 方法说明：添加未完成工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addWorkTaskUnfinish() throws TsfaServiceException{
		AddWorkTaskUnfinish addWorkTaskUnfinish = new AddWorkTaskUnfinish();
		//add数据录入
		addWorkTaskUnfinish.setWorkDate(new Date());
		addWorkTaskUnfinish.setMemberNoGm("MemberNoGm");
		addWorkTaskUnfinish.setMemberNameGm("MemberNameGm");
		addWorkTaskUnfinish.setTaskListCode("TaskListCode");
		addWorkTaskUnfinish.setTaskName("TaskName");
		addWorkTaskUnfinish.setRequireNum(24);
		addWorkTaskUnfinish.setFinishNum(0);
		addWorkTaskUnfinish.setUnfinishNum(24);
		addWorkTaskUnfinish.setDefeatNum(24);
		addWorkTaskUnfinish.setWorkRatio(0.1);
		addWorkTaskUnfinish.setFinish("1");
		addWorkTaskUnfinish.setReason("Reason");
		addWorkTaskUnfinish.setCreateId("CreateId");
		addWorkTaskUnfinish.setRemark("很好");
		addWorkTaskUnfinish.setRemark2("很好");
		addWorkTaskUnfinish.setRemark3("很好");
		addWorkTaskUnfinish.setRemark4("很好");
		
		Assert.assertNotNull(workTaskUnfinishService.addWorkTaskUnfinish(addWorkTaskUnfinish ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改未完成工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateWorkTaskUnfinish() throws TsfaServiceException{
		UpdateWorkTaskUnfinish updateWorkTaskUnfinish = new UpdateWorkTaskUnfinish();
		//update数据录入
		updateWorkTaskUnfinish.setCode("2");
		updateWorkTaskUnfinish.setWorkDate(new Date());
		updateWorkTaskUnfinish.setMemberNoGm("MemberNoGm");
		updateWorkTaskUnfinish.setMemberNameGm("MemberNameGm");
		updateWorkTaskUnfinish.setTaskListCode("TaskListCode");
		updateWorkTaskUnfinish.setTaskName("TaskName");
		updateWorkTaskUnfinish.setRequireNum(24);
		updateWorkTaskUnfinish.setFinishNum(1);
		updateWorkTaskUnfinish.setUnfinishNum(2);
		updateWorkTaskUnfinish.setDefeatNum(24);
		updateWorkTaskUnfinish.setWorkRatio(0.88);
		updateWorkTaskUnfinish.setFinish("1");
		updateWorkTaskUnfinish.setReason("Reason");
		updateWorkTaskUnfinish.setCreateId("CreateId");
		updateWorkTaskUnfinish.setCreateDate(new Date());
		updateWorkTaskUnfinish.setRemark("henhao");
		updateWorkTaskUnfinish.setRemark2("henhao");
		updateWorkTaskUnfinish.setRemark3("henhao");
		updateWorkTaskUnfinish.setRemark4("henhao");

		workTaskUnfinishService.updateWorkTaskUnfinish(updateWorkTaskUnfinish );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找未完成工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWorkTaskUnfinish() throws TsfaServiceException{
		FindWorkTaskUnfinish findWorkTaskUnfinish = new FindWorkTaskUnfinish();
		findWorkTaskUnfinish.setCode("4");
		workTaskUnfinishService.findWorkTaskUnfinish(findWorkTaskUnfinish);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找未完成工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWorkTaskUnfinishPage() throws TsfaServiceException{
		FindWorkTaskUnfinishPage findWorkTaskUnfinishPage = new FindWorkTaskUnfinishPage();
		Page<FindWorkTaskUnfinishPageReturn> page = workTaskUnfinishService.findWorkTaskUnfinishPage(findWorkTaskUnfinishPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除未完成工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delWorkTaskUnfinish() throws TsfaServiceException{
		DelWorkTaskUnfinish delWorkTaskUnfinish = new DelWorkTaskUnfinish();
		delWorkTaskUnfinish.setCode("2");
		Assert.assertNotNull(workTaskUnfinishService.delWorkTaskUnfinish(delWorkTaskUnfinish));
		
	}
	
	
}
