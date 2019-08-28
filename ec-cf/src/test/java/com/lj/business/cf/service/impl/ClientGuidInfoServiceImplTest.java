package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.clientGuidInfo.AddClientGuidInfo;
import com.lj.business.cf.dto.clientGuidInfo.DelClientGuidInfo;
import com.lj.business.cf.dto.clientGuidInfo.FindClientGuidInfo;
import com.lj.business.cf.dto.clientGuidInfo.UpdateClientGuidInfo;
import com.lj.business.cf.service.IClientGuidInfoService;


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
public class ClientGuidInfoServiceImplTest extends SpringTestCase{

	@Resource
	IClientGuidInfoService clientGuidInfoService;



	/**
	 * 
	 *
	 * 方法说明：添加客户引导记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void addClientGuidInfo() throws TsfaServiceException{
		AddClientGuidInfo addClientGuidInfo = new AddClientGuidInfo();
		//add数据录入
		addClientGuidInfo.setCode("Code");
		addClientGuidInfo.setMerchantNo("MerchantNo");
		addClientGuidInfo.setMemberNo("MemberNo");
		addClientGuidInfo.setMemberName("MemberName");
		addClientGuidInfo.setMemberNoGm("MemberNoGm");
		addClientGuidInfo.setMemberNameGm("MemberNameGm");
		addClientGuidInfo.setShopNo("ShopNo");
		addClientGuidInfo.setShopName("ShopName");
		addClientGuidInfo.setSendTime(new Date());
		addClientGuidInfo.setMaterialCode("MaterialCode");
		addClientGuidInfo.setMaterialCommenType("MaterialCommenType");
		addClientGuidInfo.setCfNo("CfNo");
		addClientGuidInfo.setCfCode("CfCode");
		addClientGuidInfo.setCreateId("CreateId");
		addClientGuidInfo.setCreateDate(new Date());
		addClientGuidInfo.setRemark("Remark");
		addClientGuidInfo.setRemark4("Remark4");
		addClientGuidInfo.setRemark3("Remark3");
		addClientGuidInfo.setRemark2("Remark2");
		
		clientGuidInfoService.addClientGuidInfo(addClientGuidInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户引导记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void updateClientGuidInfo() throws TsfaServiceException{
		UpdateClientGuidInfo updateClientGuidInfo = new UpdateClientGuidInfo();
		//update数据录入
		updateClientGuidInfo.setCode("Code");
		updateClientGuidInfo.setMerchantNo("MerchantNo");
		updateClientGuidInfo.setMemberNo("MemberNo");
		updateClientGuidInfo.setMemberName("MemberName");
		updateClientGuidInfo.setMemberNoGm("MemberNoGm");
		updateClientGuidInfo.setMemberNameGm("MemberNameGm");
		updateClientGuidInfo.setShopNo("ShopNo");
		updateClientGuidInfo.setShopName("ShopName");
		updateClientGuidInfo.setSendTime(new Date());
		updateClientGuidInfo.setMaterialCode("MaterialCode");
		updateClientGuidInfo.setMaterialCommenType("MaterialCommenType");
		updateClientGuidInfo.setCfNo("CfNo");
		updateClientGuidInfo.setCfCode("CfCode");
		updateClientGuidInfo.setCreateId("CreateId");
		updateClientGuidInfo.setCreateDate(new Date());
		updateClientGuidInfo.setRemark("Remark");
		updateClientGuidInfo.setRemark4("Remark4");
		updateClientGuidInfo.setRemark3("Remark3");
		updateClientGuidInfo.setRemark2("Remark2");

		clientGuidInfoService.updateClientGuidInfo(updateClientGuidInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户引导记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void findClientGuidInfo() throws TsfaServiceException{
		FindClientGuidInfo findClientGuidInfo = new FindClientGuidInfo();
		findClientGuidInfo.setCode("111");
		clientGuidInfoService.findClientGuidInfo(findClientGuidInfo);
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除客户引导记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void delClientGuidInfo() throws TsfaServiceException{
		DelClientGuidInfo delClientGuidInfo = new DelClientGuidInfo();
		delClientGuidInfo.setCode("111");
		clientGuidInfoService.delClientGuidInfo(delClientGuidInfo);
		
	}
	
	
}
