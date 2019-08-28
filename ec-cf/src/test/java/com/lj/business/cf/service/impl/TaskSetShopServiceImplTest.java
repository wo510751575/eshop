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

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.FindMangerWork;
import com.lj.business.cf.dto.MangerWorkReturn;
import com.lj.business.cf.dto.taskSetShop.AddTaskSetShop;
import com.lj.business.cf.dto.taskSetShop.DelTaskSetShop;
import com.lj.business.cf.dto.taskSetShop.FindShopTaskSetList;
import com.lj.business.cf.dto.taskSetShop.FindShopTaskSetListReturn;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetAndOrder;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetAndOrderReturn;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetShop;
import com.lj.business.cf.dto.taskSetShop.UpdateTaskSetShop;
import com.lj.business.cf.emus.TaskType;
import com.lj.business.cf.service.ITaskSetShopService;
import com.lj.business.cf.util.TestHelp;


/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 冯辉
 * 
 * 
 * CreateDate: 2017-06-14
 */
public class TaskSetShopServiceImplTest extends SpringTestCase{

	@Resource
	ITaskSetShopService taskSetShopService;



	/**
	 * 
	 *
	 * 方法说明：添加店长任务设置表信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年10月10日
	 *
	 */
	@Test
	public void addTaskSetShop() throws TsfaServiceException{
		AddTaskSetShop addTaskSetShop = new AddTaskSetShop();
		//add数据录入
		addTaskSetShop.setMerchantNo(TestHelp.merchantNo_test);
		addTaskSetShop.setMemberNoSp("MemberNoSp");
		addTaskSetShop.setMemberNameSp("MemberNameSp");
		addTaskSetShop.setStartDate(new Date());
		addTaskSetShop.setEndDate(new Date());
		addTaskSetShop.setTaskName("TaskName");
		addTaskSetShop.setTaskUnit("TaskUnit");
		addTaskSetShop.setTaskType("TaskType");
		addTaskSetShop.setDimension("Dimension");
		addTaskSetShop.setCodeList("CodeList");
		addTaskSetShop.setCreateId("CreateId");
		addTaskSetShop.setCreateDate(new Date());
		addTaskSetShop.setRemark4("Remark4");
		addTaskSetShop.setRemark3("Remark3");
		addTaskSetShop.setRemark2("Remark2");
		addTaskSetShop.setRemark("Remark");
		
		taskSetShopService.addTaskSetShop(addTaskSetShop );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改店长任务设置表信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年10月10日
	 *
	 */
	@Test
	public void updateTaskSetShop() throws TsfaServiceException{
		UpdateTaskSetShop updateTaskSetShop = new UpdateTaskSetShop();
		//update数据录入
		updateTaskSetShop.setCode("Code");
		updateTaskSetShop.setMerchantNo("MerchantNo");
		updateTaskSetShop.setMemberNoSp("MemberNoSp");
		updateTaskSetShop.setMemberNameSp("MemberNameSp");
		updateTaskSetShop.setStartDate(new Date());
		updateTaskSetShop.setEndDate(new Date());
		updateTaskSetShop.setTaskName("TaskName");
		updateTaskSetShop.setTaskUnit("TaskUnit");
		updateTaskSetShop.setTaskType("TaskType");
		updateTaskSetShop.setDimension("Dimension");
		updateTaskSetShop.setCodeList("CodeList");
		updateTaskSetShop.setCreateId("CreateId");
		updateTaskSetShop.setCreateDate(new Date());
		updateTaskSetShop.setRemark4("Remark4");
		updateTaskSetShop.setRemark3("Remark3");
		updateTaskSetShop.setRemark2("Remark2");
		updateTaskSetShop.setRemark("Remark");

		taskSetShopService.updateTaskSetShop(updateTaskSetShop );
		
	}
	
	@Test
	public void findNumDayAndTaskUnit() throws TsfaServiceException{
		FindTaskSetAndOrder findTaskSetAndOrder = new FindTaskSetAndOrder();
		findTaskSetAndOrder.setMemberNoGm("38df1c34ff2b430599fdbbe6aab1aaac");
		findTaskSetAndOrder.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findTaskSetAndOrder.setTaskType(TaskType.XIAO_SHOU.toString());
		System.out.println(taskSetShopService.findNumDayAndTaskUnit(findTaskSetAndOrder).getNumDay());
//		Assert.assertNotNull(taskSetShopService.findNumDayAndTaskUnit(findTaskSetAndOrder));
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店长任务设置表信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年10月10日
	 *
	 */
	@Test
	public void findTaskSetShop() throws TsfaServiceException{
		FindTaskSetShop findTaskSetShop = new FindTaskSetShop();
		findTaskSetShop.setCode("111");
		taskSetShopService.findTaskSetShop(findTaskSetShop);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店长任务设置表信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年10月10日
	 *
	 */
//	@Test
//	public void findTaskSetShopPage() throws TsfaServiceException{
//		FindTaskSetShopPage findTaskSetShopPage = new FindTaskSetShopPage();
//		Page<FindTaskSetShopPageReturn> page = taskSetShopService.findTaskSetShopPage(findTaskSetShopPage);
//		Assert.assertNotNull(page);
//		
//	}
	
	/**
	 * 
	 *
	 * 方法说明：删除店长任务设置表信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年10月10日
	 *
	 */
	@Test
	public void delTaskSetShop() throws TsfaServiceException{
		DelTaskSetShop delTaskSetShop = new DelTaskSetShop();
		delTaskSetShop.setCode("111");
		taskSetShopService.delTaskSetShop(delTaskSetShop);
		
	}
	
	@Test
	public void findTaskSetAndOrder() throws TsfaServiceException{
		FindTaskSetAndOrder findTaskSetAndOrder = new FindTaskSetAndOrder();
		findTaskSetAndOrder.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		findTaskSetAndOrder.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		FindTaskSetAndOrderReturn result = taskSetShopService.findTaskSetAndOrder(findTaskSetAndOrder);
		Assert.assertNotNull(result);
		System.out.println(result);
	}
	
	@Test
	public void guidMemberIntegralDayService() throws Exception {
		FindMangerWork findMangerWork = new FindMangerWork();
		findMangerWork.setMerchantNo("1f2a6d3e3022448382734bc70c9384af");
		findMangerWork.setMemberNoGm("04f52a95d04d42548325e99232d5ef7b");
		findMangerWork.setMemberNameGm("李白");
		findMangerWork.setShopNo("LJ_31bdf059170446808c39467e0b8ef2ff");
		MangerWorkReturn work = this.taskSetShopService.findMangerWork(findMangerWork);
		System.out.println(work);
	}
	
	@Test
	public void findMangerWork() throws TsfaServiceException{
		FindMangerWork findMangerWork = new FindMangerWork();
		findMangerWork.setShopNo("LJ_31bdf059170446808c39467e0b8ef2ff");
		findMangerWork.setMerchantNo("1f2a6d3e3022448382734bc70c9384af");
		findMangerWork.setMemberNoGm("3f59ef3cd6514dd7887b93c88b08c2fb");
		findMangerWork.setMemberNameGm("张海");
		taskSetShopService.findMangerWork(findMangerWork);
	}
	
	
	@Test
	public void findShopTaskSetList() throws TsfaServiceException{
		FindShopTaskSetList findShopTaskSetList = new FindShopTaskSetList();
		findShopTaskSetList.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findShopTaskSetList.setMemberNoSp("LJ_c1ac4f96ce3640ada54dd9c8c1b16d33");
		
		List<FindShopTaskSetListReturn> list = taskSetShopService.findShopTaskSetList(findShopTaskSetList);
		
		System.out.println(list);
		
	}
}
