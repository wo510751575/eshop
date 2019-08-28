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

import com.lj.eshop.dto.MerchantDto;
import com.lj.eshop.dto.FindMerchantPage;
import com.lj.eshop.service.IMerchantService;

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
public class MerchantServiceImplTest extends SpringTestCase{

	@Resource
	IMerchantService merchantService;



	/**
	 * 
	 *
	 * 方法说明：添加商户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addMerchant() throws TsfaServiceException{
		MerchantDto merchantDto = new MerchantDto();
		//add数据录入
		merchantDto.setCode("Code");
		merchantDto.setMerchantName("MerchantName");
		merchantDto.setMerchantPhone("MerchantPhone");
		merchantDto.setMerchantAddr("MerchantAddr");
		merchantDto.setCreateTime(new Date());
		
		merchantService.addMerchant(merchantDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateMerchant() throws TsfaServiceException{
		MerchantDto merchantDto = new MerchantDto();
		//update数据录入
		merchantDto.setCode("Code");
		merchantDto.setMerchantName("MerchantName");
		merchantDto.setMerchantPhone("MerchantPhone");
		merchantDto.setMerchantAddr("MerchantAddr");
		merchantDto.setCreateTime(new Date());

		merchantService.updateMerchant(merchantDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMerchant() throws TsfaServiceException{
		MerchantDto findMerchant = new MerchantDto();
		findMerchant.setCode("111");
		merchantService.findMerchant(findMerchant);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMerchantPage() throws TsfaServiceException{
		FindMerchantPage findMerchantPage = new FindMerchantPage();
		Page<MerchantDto> page = merchantService.findMerchantPage(findMerchantPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMerchants() throws TsfaServiceException{
		FindMerchantPage findMerchantPage = new FindMerchantPage();
		List<MerchantDto> page = merchantService.findMerchants(findMerchantPage);
		Assert.assertNotNull(page);
		
	}
	
}
