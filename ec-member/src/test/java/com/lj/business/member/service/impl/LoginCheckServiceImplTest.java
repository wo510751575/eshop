package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.domain.LoginCheck;
import com.lj.business.member.dto.AddLoginCheck;
import com.lj.business.member.dto.DelLoginCheck;
import com.lj.business.member.dto.FindLoginCheck;
import com.lj.business.member.dto.FindLoginCheckPage;
import com.lj.business.member.dto.FindLoginCheckPageReturn;
import com.lj.business.member.dto.UpdateLoginCheck;
import com.lj.business.member.service.ILoginCheckService;


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
public class LoginCheckServiceImplTest extends SpringTestCase{

	@Resource
	ILoginCheckService loginCheckService;



	/**
	 * 
	 *
	 * 方法说明：添加商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addLoginCheck() throws TsfaServiceException{
		AddLoginCheck addLoginCheck = new AddLoginCheck();
		//add数据录入
		addLoginCheck.setCode(GUID.getPreUUID());
		addLoginCheck.setMemberNo("395d72ae33af4a8fa8f2198e528f06a5");
		addLoginCheck.setMemberType("SHOP");
		addLoginCheck.setLockStatus("NORMAL");
		addLoginCheck.setLastLoginDate(new Date());
		addLoginCheck.setCycleLoginFailTimes(1);
		addLoginCheck.setLastLoginErrorDate(new Date());
		addLoginCheck.setUpdateId("UpdateId");
		addLoginCheck.setUpdateDate(new Date());
		
		Assert.assertNotNull(loginCheckService.addLoginCheck(addLoginCheck ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateLoginCheck() throws TsfaServiceException{
		UpdateLoginCheck updateLoginCheck = new UpdateLoginCheck();
		//update数据录入
		updateLoginCheck.setCode("Id");
		updateLoginCheck.setMemberNo("MemberNo");
		updateLoginCheck.setMemberType("MemberType");
		updateLoginCheck.setLockStatus("LockStatus");
		updateLoginCheck.setLastLoginDate(new Date());
		updateLoginCheck.setCycleLoginFailTimes(1);
		updateLoginCheck.setLastLoginErrorDate(new Date());
		updateLoginCheck.setUpdateId("UpdateId");
		updateLoginCheck.setUpdateDate(new Date());

		loginCheckService.updateLoginCheck(updateLoginCheck );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findLoginCheck() throws TsfaServiceException{
		FindLoginCheck findLoginCheck = new FindLoginCheck();
		findLoginCheck.setCode("LJ_86564608-5963-412d-b4a1-1e2f30a82cf5");
		loginCheckService.findLoginCheck(findLoginCheck);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findLoginCheckPage() throws TsfaServiceException{
		FindLoginCheckPage findLoginCheckPage = new FindLoginCheckPage();
		Page<FindLoginCheckPageReturn> page = loginCheckService.findLoginCheckPage(findLoginCheckPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delLoginCheck() throws TsfaServiceException{
		DelLoginCheck delLoginCheck = new DelLoginCheck();
		delLoginCheck.setCode(GUID.getPreUUID());
		Assert.assertNotNull(loginCheckService.delLoginCheck(delLoginCheck));
	}
	
	@Test
	public void findLoginCheckByCond() throws TsfaServiceException{
		LoginCheck record= new LoginCheck();
		record.setMemberNo("MemberNo001");
		LoginCheck loginCheck = loginCheckService.findLoginCheck(record);
		System.out.println(loginCheck.getCode());
	}
}
