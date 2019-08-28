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

import com.lj.eshop.dto.MerchantSettingDto;
import com.lj.eshop.dto.FindMerchantSettingPage;
import com.lj.eshop.service.IMerchantSettingService;

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
public class MerchantSettingServiceImplTest extends SpringTestCase{

	@Resource
	IMerchantSettingService merchantSettingService;



	/**
	 * 
	 *
	 * 方法说明：添加商户配置信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addMerchantSetting() throws TsfaServiceException{
		MerchantSettingDto merchantSettingDto = new MerchantSettingDto();
		//add数据录入
		merchantSettingDto.setCode("Code");
		merchantSettingDto.setMerchantCode("MerchantCode");
		merchantSettingDto.setValue("Value");
		merchantSettingDto.setName("Name");
		merchantSettingDto.setRemarks("Remarks");
		merchantSettingDto.setCreateTime(new Date());
		merchantSettingDto.setStatus("Status");
		
		merchantSettingService.addMerchantSetting(merchantSettingDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商户配置信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateMerchantSetting() throws TsfaServiceException{
		MerchantSettingDto merchantSettingDto = new MerchantSettingDto();
		//update数据录入
		merchantSettingDto.setCode("Code");
		merchantSettingDto.setMerchantCode("MerchantCode");
		merchantSettingDto.setValue("Value");
		merchantSettingDto.setName("Name");
		merchantSettingDto.setRemarks("Remarks");
		merchantSettingDto.setCreateTime(new Date());
		merchantSettingDto.setStatus("Status");

		merchantSettingService.updateMerchantSetting(merchantSettingDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户配置信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMerchantSetting() throws TsfaServiceException{
		MerchantSettingDto findMerchantSetting = new MerchantSettingDto();
		findMerchantSetting.setCode("111");
		merchantSettingService.findMerchantSetting(findMerchantSetting);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户配置信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMerchantSettingPage() throws TsfaServiceException{
		FindMerchantSettingPage findMerchantSettingPage = new FindMerchantSettingPage();
		Page<MerchantSettingDto> page = merchantSettingService.findMerchantSettingPage(findMerchantSettingPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户配置信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMerchantSettings() throws TsfaServiceException{
		FindMerchantSettingPage findMerchantSettingPage = new FindMerchantSettingPage();
		findMerchantSettingPage.setLeftLikeValue("/eoms/image");
		List<MerchantSettingDto> page = merchantSettingService.findMerchantSettings(findMerchantSettingPage);
		Assert.assertNotNull(page);
		
	}
	
}
