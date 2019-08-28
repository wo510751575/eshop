package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Test;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.taskSetShop.FindShopTaskSetList;
import com.lj.business.cf.service.ITaskSetShopService;


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
public class TaskSetServiceImplTest extends SpringTestCase{

//	@Resource
//	private ITaskSetService taskSetService;
	
	@Resource
	private ITaskSetShopService taskSetShopService;



	/**
	 * 
	 *
	 * 方法说明：添加店长任务设置表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
//	@Test
//	public void addTaskSet() throws TsfaServiceException{
//		AddTaskSet addTaskSet = new AddTaskSet();
//		//add数据录入
//		addTaskSet.setCode(GUID.getPreUUID());
//		addTaskSet.setMerchantNo(GUID.generateByUUID());
//		addTaskSet.setMemberNoSp("MemberNoSp");
//		addTaskSet.setMemberNameSp("MemberNameSp");
//		addTaskSet.setNumMonth(6L);
//		addTaskSet.setMemberNoList("MemberNoList");
//		addTaskSet.setMemberNameList("MemberNameList");
//		addTaskSet.setNumDay(1L);
//		addTaskSet.setNumPm(1L);
//		addTaskSet.setYear(1);
//		addTaskSet.setMonth(1);
//		addTaskSet.setContent("Content");
//		addTaskSet.setCreateId("CreateId");
//		addTaskSet.setCreateDate(new Date());
//		addTaskSet.setRemark("很好");
//		addTaskSet.setRemark2("很好");
//		addTaskSet.setRemark3("很好");
//		addTaskSet.setRemark4("很好");
//		
//		Assert.assertNotNull(taskSetService.addTaskSet(addTaskSet ));
//		
//	}
	
	/**
	 * 
	 *
	 * 方法说明：修改店长任务设置表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
//	@Test
//	public void updateTaskSet() throws TsfaServiceException{
//		UpdateTaskSet updateTaskSet = new UpdateTaskSet();
//		//update数据录入
//		updateTaskSet.setCode(GUID.getPreUUID());
//		updateTaskSet.setCode(GUID.getPreUUID());
//		updateTaskSet.setMerchantNo(GUID.generateByUUID());
//		updateTaskSet.setMemberNoSp("MemberNoSp");
//		updateTaskSet.setMemberNameSp("MemberNameSp");
//		updateTaskSet.setNumMonth(6L);
//		updateTaskSet.setMemberNoList("MemberNoList");
//		updateTaskSet.setMemberNameList("MemberNameList");
//		updateTaskSet.setNumDay(1L);
//		updateTaskSet.setNumPm(1L);
//		updateTaskSet.setYear(1);
//		updateTaskSet.setMonth(1);
//		updateTaskSet.setContent("Content");
//		updateTaskSet.setCreateId("CreateId");
//		updateTaskSet.setCreateDate(new Date());
//		updateTaskSet.setRemark("很好");
//		updateTaskSet.setRemark2("很好");
//		updateTaskSet.setRemark3("很好");
//		updateTaskSet.setRemark4("很好");
//
//		taskSetService.updateTaskSet(updateTaskSet );
//		
//	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店长任务设置表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
//	@Test
//	public void findTaskSet() throws TsfaServiceException{
//		FindTaskSet findTaskSet = new FindTaskSet();
//		findTaskSet.setCode("LJ_36af76a4a5f14d4aa2667a988ee27f79");
//		taskSetService.findTaskSet(findTaskSet);
//	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店长任务设置表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
//	@Test
//	public void findTaskSetPage() throws TsfaServiceException{
//		FindTaskSetPage findTaskSetPage = new FindTaskSetPage();
//		Page<FindTaskSetPageReturn> page = taskSetService.findTaskSetPage(findTaskSetPage);
//		Assert.assertNotNull(page);
//		
//	}
	
	/**
	 * 
	 *
	 * 方法说明：删除店长任务设置表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
//	@Test
//	public void delTaskSet() throws TsfaServiceException{
//		DelTaskSet delTaskSet = new DelTaskSet();
//		delTaskSet.setCode("LJ_b791b1e604914cf19779903c7e42d482");
//		Assert.assertNotNull(taskSetService.delTaskSet(delTaskSet));
//		
//	}
	
	@Test
	public void findShopTaskSetList() throws TsfaServiceException{
		FindShopTaskSetList findShopTaskSetList = new FindShopTaskSetList();
		findShopTaskSetList.setMerchantNo("1f169ad6143d46f5832535642ce2d331");
		findShopTaskSetList.setShopNo("LJ_82039188265241e0bd8f87651db6ab3c");
		taskSetShopService.findShopTaskSetList(findShopTaskSetList);
		
	}
	

	
	
}
