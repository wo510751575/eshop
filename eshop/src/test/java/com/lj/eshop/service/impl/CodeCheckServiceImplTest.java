package com.lj.eshop.service.impl;

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

import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.CodeCheckDto;
import com.lj.eshop.dto.FindCodeCheckPage;
import com.lj.eshop.service.ICodeCheckService;

/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author lhy
 * 
 * 
 * CreateDate: 2017-08-22
 */
public class CodeCheckServiceImplTest extends SpringTestCase{

	@Resource
	ICodeCheckService codeCheckService;



	/**
	 * 
	 *
	 * 方法说明：添加验证码信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addCodeCheck() throws TsfaServiceException{
		CodeCheckDto codeCheckDto = new CodeCheckDto();
		//add数据录入
		codeCheckDto.setCode("Code");
		codeCheckDto.setSendCode("SendCode");
		codeCheckDto.setBizType("BizType");
		codeCheckDto.setSendTime(new Date());
		codeCheckDto.setRevicerPhone("RevicerPhone");
		
		codeCheckService.addCodeCheck(codeCheckDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改验证码信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateCodeCheck() throws TsfaServiceException{
		CodeCheckDto codeCheckDto = new CodeCheckDto();
		//update数据录入
		codeCheckDto.setCode("Code");
		codeCheckDto.setSendCode("SendCode");
		codeCheckDto.setBizType("BizType");
		codeCheckDto.setSendTime(new Date());
		codeCheckDto.setRevicerPhone("RevicerPhone");

		codeCheckService.updateCodeCheck(codeCheckDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找验证码信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findCodeCheck() throws TsfaServiceException{
		CodeCheckDto findCodeCheck = new CodeCheckDto();
		findCodeCheck.setCode("111");
		codeCheckService.findCodeCheck(findCodeCheck);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找验证码信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findCodeCheckPage() throws TsfaServiceException{
		FindCodeCheckPage findCodeCheckPage = new FindCodeCheckPage();
		Page<CodeCheckDto> page = codeCheckService.findCodeCheckPage(findCodeCheckPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找验证码信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findCodeChecks() throws TsfaServiceException{
		FindCodeCheckPage findCodeCheckPage = new FindCodeCheckPage();
		List<CodeCheckDto> page = codeCheckService.findCodeChecks(findCodeCheckPage);
		Assert.assertNotNull(page);
		
	}
	
}
