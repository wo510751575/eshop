package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.taskSetShop.FindNoSetShopCount;
import com.lj.business.cf.dto.taskSetShop.ToShopTaskSet;
import com.lj.business.cf.dto.taskSetShopDetail.AddTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.DelTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.UpdateTaskSetShopDetail;
import com.lj.business.cf.service.ITaskSetShopDetailService;


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
public class TaskSetShopDetailServiceImplTest extends SpringTestCase{

	@Resource
	ITaskSetShopDetailService taskSetShopDetailService;



	/**
	 * 
	 *
	 * 方法说明：添加店长任务设置明细表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void addTaskSetShopDetail() throws TsfaServiceException{
		AddTaskSetShopDetail addTaskSetShopDetail = new AddTaskSetShopDetail();
		//add数据录入
		addTaskSetShopDetail.setCode("Code");
		addTaskSetShopDetail.setCodeTss("CodeTss");
		addTaskSetShopDetail.setMerchantNo("MerchantNo");
		addTaskSetShopDetail.setMemberNoSp("MemberNoSp");
		addTaskSetShopDetail.setMemberNameSp("MemberNameSp");
		addTaskSetShopDetail.setMemberNoGm("MemberNoGm");
		addTaskSetShopDetail.setMemberNameGm("MemberNameGm");
		addTaskSetShopDetail.setNumMonth(10L);
		addTaskSetShopDetail.setNumDay(20L);
		addTaskSetShopDetail.setStartDate(new Date());
		addTaskSetShopDetail.setEndDate(new Date());
		addTaskSetShopDetail.setCreateId("CreateId");
		addTaskSetShopDetail.setCreateDate(new Date());
		addTaskSetShopDetail.setRemark4("Remark4");
		addTaskSetShopDetail.setRemark3("Remark3");
		addTaskSetShopDetail.setRemark2("Remark2");
		addTaskSetShopDetail.setRemark("Remark");
		
		taskSetShopDetailService.addTaskSetShopDetail(addTaskSetShopDetail );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改店长任务设置明细表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void updateTaskSetShopDetail() throws TsfaServiceException{
		UpdateTaskSetShopDetail updateTaskSetShopDetail = new UpdateTaskSetShopDetail();
		//update数据录入
		updateTaskSetShopDetail.setCode("Code");
		updateTaskSetShopDetail.setCodeTss("CodeTss");
		updateTaskSetShopDetail.setMerchantNo("MerchantNo");
		updateTaskSetShopDetail.setMemberNoSp("MemberNoSp");
		updateTaskSetShopDetail.setMemberNameSp("MemberNameSp");
		updateTaskSetShopDetail.setMemberNoGm("MemberNoGm");
		updateTaskSetShopDetail.setMemberNameGm("MemberNameGm");
		updateTaskSetShopDetail.setNumMonth(10L);
		updateTaskSetShopDetail.setNumDay(21L);
		updateTaskSetShopDetail.setStartDate(new Date());
		updateTaskSetShopDetail.setEndDate(new Date());
		updateTaskSetShopDetail.setCreateId("CreateId");
		updateTaskSetShopDetail.setCreateDate(new Date());
		updateTaskSetShopDetail.setRemark4("Remark4");
		updateTaskSetShopDetail.setRemark3("Remark3");
		updateTaskSetShopDetail.setRemark2("Remark2");
		updateTaskSetShopDetail.setRemark("Remark");

		taskSetShopDetailService.updateTaskSetShopDetail(updateTaskSetShopDetail );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店长任务设置明细表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void findTaskSetShopDetail() throws TsfaServiceException{
		FindTaskSetShopDetail findTaskSetShopDetail = new FindTaskSetShopDetail();
		findTaskSetShopDetail.setCode("111");
		taskSetShopDetailService.findTaskSetShopDetail(findTaskSetShopDetail);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店长任务设置明细表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
//	@Test
//	public void findTaskSetShopDetailPage() throws TsfaServiceException{
//		FindTaskSetShopDetailPage findTaskSetShopDetailPage = new FindTaskSetShopDetailPage();
//		Page<FindTaskSetShopDetailPageReturn> page = taskSetShopDetailService.findTaskSetShopDetailPage(findTaskSetShopDetailPage);
//		Assert.assertNotNull(page);
//		
//	}
	
	/**
	 * 
	 *
	 * 方法说明：删除店长任务设置明细表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void delTaskSetShopDetail() throws TsfaServiceException{
		DelTaskSetShopDetail delTaskSetShopDetail = new DelTaskSetShopDetail();
		delTaskSetShopDetail.setCode("111");
		taskSetShopDetailService.delTaskSetShopDetail(delTaskSetShopDetail);
		
	}
	
	@Test
	public void findTaskSetShopDetail2() throws TsfaServiceException{
		ToShopTaskSet toShopTaskSet = new ToShopTaskSet();
		toShopTaskSet.setCode("LJ_07ba4455b5aa4d338d23a83f0bb34ded");
		DateFormat df6 = new SimpleDateFormat("yyyy-MM-dd"); 
		 try {
			Date startDate = df6.parse("2007-07-22");
			Date endDate = df6.parse("2007-07-27");
			toShopTaskSet.setStartDate(DateUtils.truncate(startDate, Calendar.DAY_OF_MONTH));
			toShopTaskSet.setEndDate(DateUtils.truncate(endDate, Calendar.DAY_OF_MONTH));
			toShopTaskSet.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
			toShopTaskSet.setShopNo("LJ_c269478af52646b692fcc48deb10a7ad");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		taskSetShopDetailService.findTaskSetShopDetailList(toShopTaskSet);
	}
	
	@Test
	public void findCountDetail() throws Exception {
		FindNoSetShopCount findNoSetShopCount = new FindNoSetShopCount();
		findNoSetShopCount.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findNoSetShopCount.setMemberNoShop("LJ_c1ac4f96ce3640ada54dd9c8c1b16d33");
		findNoSetShopCount.setNow(org.apache.commons.lang.time.DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
		System.out.println(taskSetShopDetailService.findCountDetail(findNoSetShopCount));
	}
	
}
