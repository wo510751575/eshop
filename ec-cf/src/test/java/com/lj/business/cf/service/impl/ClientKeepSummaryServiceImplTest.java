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
import com.lj.business.cf.dto.clientKeepSummary.AddClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.DelClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryPage;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryPageReturn;
import com.lj.business.cf.dto.clientKeepSummary.UpdateClientKeepSummary;
import com.lj.business.cf.service.IClientKeepSummaryService;


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
public class ClientKeepSummaryServiceImplTest extends SpringTestCase{

	@Resource
	IClientKeepSummaryService clientKeepSummaryService;



	/**
	 * 
	 *
	 * 方法说明：添加反馈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addClientKeepSummary() throws TsfaServiceException{
		AddClientKeepSummary addClientKeepSummary = new AddClientKeepSummary();
		//add数据录入
		addClientKeepSummary.setCode("Code");
		addClientKeepSummary.setMerchantNo("MerchantNo");
		addClientKeepSummary.setMemberNo("MemberNo");
		addClientKeepSummary.setMemberName("MemberName");
		addClientKeepSummary.setMemberNoGm("MemberNoGm");
		addClientKeepSummary.setMemberNameGm("MemberNameGm");
		addClientKeepSummary.setCkNo("CkNo");
		addClientKeepSummary.setKeepNum(1);
		addClientKeepSummary.setBuy("Buy");
		addClientKeepSummary.setBomCode("BomCode");
		addClientKeepSummary.setBomName("BomName");
		addClientKeepSummary.setStartDate(new Date());
		addClientKeepSummary.setEndDate(new Date());
		addClientKeepSummary.setRemark("Remark");
		addClientKeepSummary.setCreateId("CreateId");
		addClientKeepSummary.setCreateDate(new Date());
		addClientKeepSummary.setRemark4("Remark4");
		addClientKeepSummary.setRemark3("Remark3");
		addClientKeepSummary.setRemark2("Remark2");
		
		clientKeepSummaryService.addClientKeepSummary(addClientKeepSummary );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改反馈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateClientKeepSummary() throws TsfaServiceException{
		UpdateClientKeepSummary updateClientKeepSummary = new UpdateClientKeepSummary();
		//update数据录入
		updateClientKeepSummary.setCode("Code");
		updateClientKeepSummary.setMerchantNo("MerchantNo");
		updateClientKeepSummary.setMemberNo("MemberNo");
		updateClientKeepSummary.setMemberName("MemberName");
		updateClientKeepSummary.setMemberNoGm("MemberNoGm");
		updateClientKeepSummary.setMemberNameGm("MemberNameGm");
		updateClientKeepSummary.setCkNo("CkNo");
		updateClientKeepSummary.setKeepNum(1);
		updateClientKeepSummary.setBuy("Buy");
		updateClientKeepSummary.setBomCode("BomCode");
		updateClientKeepSummary.setBomName("BomName");
		updateClientKeepSummary.setStartDate(new Date());
		updateClientKeepSummary.setEndDate(new Date());
		updateClientKeepSummary.setRemark("Remark");
		updateClientKeepSummary.setCreateId("CreateId");
		updateClientKeepSummary.setCreateDate(new Date());
		updateClientKeepSummary.setRemark4("Remark4");
		updateClientKeepSummary.setRemark3("Remark3");
		updateClientKeepSummary.setRemark2("Remark2");

		clientKeepSummaryService.updateClientKeepSummary(updateClientKeepSummary );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找反馈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findClientKeepSummary() throws TsfaServiceException{
		FindClientKeepSummary findClientKeepSummary = new FindClientKeepSummary();
		findClientKeepSummary.setCode("111");
		clientKeepSummaryService.findClientKeepSummary(findClientKeepSummary);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找反馈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findClientKeepSummaryPage() throws TsfaServiceException{
		FindClientKeepSummaryPage findClientKeepSummaryPage = new FindClientKeepSummaryPage();
		Page<FindClientKeepSummaryPageReturn> page = clientKeepSummaryService.findClientKeepSummaryPage(findClientKeepSummaryPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除反馈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delClientKeepSummary() throws TsfaServiceException{
		DelClientKeepSummary delClientKeepSummary = new DelClientKeepSummary();
		delClientKeepSummary.setCode("111");
		clientKeepSummaryService.delClientKeepSummary(delClientKeepSummary);
		
	}
	
	
}
