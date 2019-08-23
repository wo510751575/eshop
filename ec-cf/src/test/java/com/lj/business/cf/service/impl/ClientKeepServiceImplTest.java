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
import com.lj.business.cf.dto.clientKeep.AddClientKeep;
import com.lj.business.cf.dto.clientKeep.DelClientKeep;
import com.lj.business.cf.dto.clientKeep.FindClientKeep;
import com.lj.business.cf.dto.clientKeep.FindClientKeepPage;
import com.lj.business.cf.dto.clientKeep.FindClientKeepPageReturn;
import com.lj.business.cf.dto.clientKeep.UpdateClientKeep;
import com.lj.business.cf.service.IClientKeepService;


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
public class ClientKeepServiceImplTest extends SpringTestCase{

	@Resource
	IClientKeepService clientKeepService;



	/**
	 * 
	 *
	 * 方法说明：添加客户维护记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addClentKeep() throws TsfaServiceException{
		AddClientKeep addClientKeep = new AddClientKeep();
		//add数据录入
		addClientKeep.setMerchantNo("MerchantNo");
		addClientKeep.setMemberNo("MemberNo");
		addClientKeep.setMemberName("MemberName");
		addClientKeep.setMemberNoGm("MemberNoGm");
		addClientKeep.setMemberNameGm("MemberNameGm");
		addClientKeep.setKeepNum(1);
		addClientKeep.setKeepTime(new Date());
		addClientKeep.setKeepType("KeepType");
		addClientKeep.setKeepContent("KeepContent");
		addClientKeep.setNextDate(new Date());
		addClientKeep.setBuy("1");
		addClientKeep.setBomCode("BomCode");
		addClientKeep.setBomName("BomName");
		addClientKeep.setRemark("Remark");
		addClientKeep.setCreateId("CreateId");
		addClientKeep.setRemark4("Remark4");
		addClientKeep.setRemark3("Remark3");
		addClientKeep.setRemark2("Remark2");
		
		Assert.assertNotNull(clientKeepService.addClientKeep(addClientKeep ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户维护记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateClentKeep() throws TsfaServiceException{
		UpdateClientKeep updateClientKeep = new UpdateClientKeep();
		//update数据录入
		updateClientKeep.setCode("Code");
		updateClientKeep.setMerchantNo("MerchantNo");
		updateClientKeep.setMemberNo("MemberNo");
		updateClientKeep.setMemberName("MemberName");
		updateClientKeep.setMemberNoGm("MemberNoGm");
		updateClientKeep.setMemberNameGm("MemberNameGm");
		updateClientKeep.setKeepNum(1);
		updateClientKeep.setKeepTime(new Date());
		updateClientKeep.setKeepType("KeepType");
		updateClientKeep.setKeepContent("KeepContent");
		updateClientKeep.setNextDate(new Date());
		updateClientKeep.setBuy("Buy");
		updateClientKeep.setBomCode("BomCode");
		updateClientKeep.setBomName("BomName");
		updateClientKeep.setRemark("Remark");
		updateClientKeep.setRemark4("Remark4");
		updateClientKeep.setRemark3("Remark3");
		updateClientKeep.setRemark2("Remark2");

		clientKeepService.updateClientKeep(updateClientKeep );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户维护记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findClentKeep() throws TsfaServiceException{
		FindClientKeep findClientKeep = new FindClientKeep();
		findClientKeep.setCode("LJ_781b85f8d9434a38acf5ed6bc8852c3c");
		clientKeepService.findClientKeep(findClientKeep);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户维护记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findClentKeepPage() throws TsfaServiceException{
		FindClientKeepPage findClientKeepPage = new FindClientKeepPage();
		Page<FindClientKeepPageReturn> page = clientKeepService.findClientKeepPage(findClientKeepPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除客户维护记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delClentKeep() throws TsfaServiceException{
		DelClientKeep delClientKeep = new DelClientKeep();
		delClientKeep.setCode("Code");
		Assert.assertNotNull(clientKeepService.delClientKeep(delClientKeep));
		
	}
	
	
}
