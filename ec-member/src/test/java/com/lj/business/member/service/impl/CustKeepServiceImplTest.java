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
import com.lj.business.member.dto.custKeep.AddCustKeep;
import com.lj.business.member.dto.custKeep.DelCustKeep;
import com.lj.business.member.dto.custKeep.FindCustKeep;
import com.lj.business.member.dto.custKeep.FindCustKeepPage;
import com.lj.business.member.dto.custKeep.FindCustKeepPageReturn;
import com.lj.business.member.service.ICustKeepService;


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
public class CustKeepServiceImplTest extends SpringTestCase{

	@Resource
	ICustKeepService custKeepService;



	/**
	 * 
	 *
	 * 方法说明：添加客户关注操作信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addCustKeep() throws TsfaServiceException{
		AddCustKeep addCustKeep = new AddCustKeep();
		//add数据录入
		addCustKeep.setMerchantNo("MerchantNo");
		addCustKeep.setMemberNo("MemberNo");
		addCustKeep.setStatus("1");
		
		custKeepService.addCustKeep(addCustKeep );
		
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：查找客户关注操作信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findCustKeep() throws TsfaServiceException{
		FindCustKeep findCustKeep = new FindCustKeep();
		findCustKeep.setCode("111");
		custKeepService.findCustKeep(findCustKeep);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户关注操作信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findCustKeepPage() throws TsfaServiceException{
		FindCustKeepPage findCustKeepPage = new FindCustKeepPage();
		Page<FindCustKeepPageReturn> page = custKeepService.findCustKeepPage(findCustKeepPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除客户关注操作信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delCustKeep() throws TsfaServiceException{
		DelCustKeep delCustKeep = new DelCustKeep();
		delCustKeep.setCode("111");
		custKeepService.delCustKeep(delCustKeep);
		
	}
	
	
}
