package com.lj.business.member.service.impl;

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
import com.lj.business.member.dto.phoneInfo.AddPhoneInfo;
import com.lj.business.member.dto.phoneInfo.DelPhoneInfo;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfo;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfoPage;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfoPageReturn;
import com.lj.business.member.dto.phoneInfo.UpdatePhoneInfo;
import com.lj.business.member.service.IMemLineService;
import com.lj.business.member.service.IPhoneInfoService;


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
public class PhoneInfoServiceImplTest extends SpringTestCase{

	@Resource
	IPhoneInfoService phoneInfoService;
	@Resource
	IMemLineService memLineService;

	
	public void test(){
		
	}


	/**
	 * 
	 *
	 * 方法说明：添加设备信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addPhoneInfo() throws TsfaServiceException{
		AddPhoneInfo addPhoneInfo = new AddPhoneInfo();
		//add数据录入
		addPhoneInfo.setMemberNoMerchant("MemberNoMerchant");
		addPhoneInfo.setShopNo("ShopNo");
		addPhoneInfo.setShopName("ShopName");
		addPhoneInfo.setStatus("Status");
		addPhoneInfo.setImei("Imei");
		addPhoneInfo.setMemberNo("MemberNo");
		addPhoneInfo.setMemberName("MemberName");
		addPhoneInfo.setMemberType("MemberType");
		addPhoneInfo.setCreateId("CreateId");
		addPhoneInfo.setRemark4("Remark4");
		addPhoneInfo.setRemark3("Remark3");
		addPhoneInfo.setRemark("Remark");
		addPhoneInfo.setRemark2("Remark2");
		
		phoneInfoService.addPhoneInfo(addPhoneInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改设备信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updatePhoneInfo() throws TsfaServiceException{
		UpdatePhoneInfo updatePhoneInfo = new UpdatePhoneInfo();
		//update数据录入
		updatePhoneInfo.setCode("Code");
		updatePhoneInfo.setMemberNoMerchant("MemberNoMerchant");
		updatePhoneInfo.setShopNo("ShopNo");
		updatePhoneInfo.setShopName("ShopName");
		updatePhoneInfo.setStatus("Status");
		updatePhoneInfo.setImei("Imei");
		updatePhoneInfo.setMemberNo("MemberNo");
		updatePhoneInfo.setMemberName("MemberName");
		updatePhoneInfo.setMemberType("MemberType");
		updatePhoneInfo.setRemark4("Remark4");
		updatePhoneInfo.setRemark3("Remark3");
		updatePhoneInfo.setRemark("Remark");
		updatePhoneInfo.setRemark2("Remark2");

		phoneInfoService.updatePhoneInfo(updatePhoneInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找设备信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPhoneInfo() throws TsfaServiceException{
		FindPhoneInfo findPhoneInfo = new FindPhoneInfo();
		findPhoneInfo.setCode("111");
		phoneInfoService.findPhoneInfo(findPhoneInfo);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找设备信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPhoneInfoPage() throws TsfaServiceException{
		FindPhoneInfoPage findPhoneInfoPage = new FindPhoneInfoPage();
		Page<FindPhoneInfoPageReturn> page = phoneInfoService.findPhoneInfoPage(findPhoneInfoPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除设备信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delPhoneInfo() throws TsfaServiceException{
		DelPhoneInfo delPhoneInfo = new DelPhoneInfo();
		delPhoneInfo.setCode("111");
		phoneInfoService.delPhoneInfo(delPhoneInfo);
		
	}
	
	  
	
	
}
