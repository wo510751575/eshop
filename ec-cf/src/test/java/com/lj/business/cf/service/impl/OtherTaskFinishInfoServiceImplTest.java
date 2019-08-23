package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.otherTaskFinishInfo.AddOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.DelOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTask;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskReturn;
import com.lj.business.cf.dto.otherTaskFinishInfo.UpdateOtherTaskFinishInfo;
import com.lj.business.cf.service.IOtherTaskFinishInfoService;


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
public class OtherTaskFinishInfoServiceImplTest extends SpringTestCase{

	@Resource
	IOtherTaskFinishInfoService otherTaskFinishInfoService;



	/**
	 * 
	 *
	 * 方法说明：添加其他任务完成情况表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void addOtherTaskFinishInfo() throws TsfaServiceException{
		AddOtherTaskFinishInfo addOtherTaskFinishInfo = new AddOtherTaskFinishInfo();
		//add数据录入
		addOtherTaskFinishInfo.setCode("Code");
		addOtherTaskFinishInfo.setCodeTssd("CodeTssd");
		addOtherTaskFinishInfo.setCodeTss("CodeTss");
		addOtherTaskFinishInfo.setMerchantNo("MerchantNo");
		addOtherTaskFinishInfo.setMemberNoSp("MemberNoSp");
		addOtherTaskFinishInfo.setMemberNameSp("MemberNameSp");
		addOtherTaskFinishInfo.setMemberNoGm("MemberNoGm");
		addOtherTaskFinishInfo.setMemberNameGm("MemberNameGm");
		addOtherTaskFinishInfo.setNumMonth(10L);
		addOtherTaskFinishInfo.setNumDay(21L);
		addOtherTaskFinishInfo.setNumFinish(11L);
		addOtherTaskFinishInfo.setDatSt(new Date());
		addOtherTaskFinishInfo.setCreateId("CreateId");
		addOtherTaskFinishInfo.setCreateDate(new Date());
		addOtherTaskFinishInfo.setRemark4("Remark4");
		addOtherTaskFinishInfo.setRemark3("Remark3");
		addOtherTaskFinishInfo.setRemark2("Remark2");
		addOtherTaskFinishInfo.setRemark("Remark");
		
		otherTaskFinishInfoService.addOtherTaskFinishInfo(addOtherTaskFinishInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改其他任务完成情况表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void updateOtherTaskFinishInfo() throws TsfaServiceException{
		UpdateOtherTaskFinishInfo updateOtherTaskFinishInfo = new UpdateOtherTaskFinishInfo();
		//update数据录入
		updateOtherTaskFinishInfo.setCode("Code");
		updateOtherTaskFinishInfo.setCodeTssd("CodeTssd");
		updateOtherTaskFinishInfo.setCodeTss("CodeTss");
		updateOtherTaskFinishInfo.setMerchantNo("MerchantNo");
		updateOtherTaskFinishInfo.setMemberNoSp("MemberNoSp");
		updateOtherTaskFinishInfo.setMemberNameSp("MemberNameSp");
		updateOtherTaskFinishInfo.setMemberNoGm("MemberNoGm");
		updateOtherTaskFinishInfo.setMemberNameGm("MemberNameGm");
		updateOtherTaskFinishInfo.setNumMonth(10L);
		updateOtherTaskFinishInfo.setNumDay(21L);
		updateOtherTaskFinishInfo.setNumFinish(10L);
		updateOtherTaskFinishInfo.setDatSt(new Date());
		updateOtherTaskFinishInfo.setCreateId("CreateId");
		updateOtherTaskFinishInfo.setCreateDate(new Date());
		updateOtherTaskFinishInfo.setRemark4("Remark4");
		updateOtherTaskFinishInfo.setRemark3("Remark3");
		updateOtherTaskFinishInfo.setRemark2("Remark2");
		updateOtherTaskFinishInfo.setRemark("Remark");

		otherTaskFinishInfoService.updateOtherTaskFinishInfo(updateOtherTaskFinishInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找其他任务完成情况表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void findOtherTaskFinishInfo() throws TsfaServiceException{
		FindOtherTaskFinishInfo findOtherTaskFinishInfo = new FindOtherTaskFinishInfo();
		findOtherTaskFinishInfo.setCode("111");
		otherTaskFinishInfoService.findOtherTaskFinishInfo(findOtherTaskFinishInfo);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找其他任务完成情况表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
//	@Test
//	public void findOtherTaskFinishInfoPage() throws TsfaServiceException{
//		FindOtherTaskFinishInfoPage findOtherTaskFinishInfoPage = new FindOtherTaskFinishInfoPage();
//		Page<FindOtherTaskFinishInfoPageReturn> page = otherTaskFinishInfoService.findOtherTaskFinishInfoPage(findOtherTaskFinishInfoPage);
//		Assert.assertNotNull(page);
//		
//	}
	
	/**
	 * 
	 *
	 * 方法说明：删除其他任务完成情况表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void delOtherTaskFinishInfo() throws TsfaServiceException{
		DelOtherTaskFinishInfo delOtherTaskFinishInfo = new DelOtherTaskFinishInfo();
		delOtherTaskFinishInfo.setCode("111");
		otherTaskFinishInfoService.delOtherTaskFinishInfo(delOtherTaskFinishInfo);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月24日
	 *
	 */
	@Test
	public void findOtherTask() throws TsfaServiceException{
		FindOtherTask findOtherTask = new FindOtherTask();
		findOtherTask.setMemberNoGm("memberNoGm");
		findOtherTask.setMerchantNo("merchantNo");
		 List<FindOtherTaskReturn> list = otherTaskFinishInfoService.findOtherTask(findOtherTask );
		 Assert.assertNotNull(list);
	}
	
	
}
