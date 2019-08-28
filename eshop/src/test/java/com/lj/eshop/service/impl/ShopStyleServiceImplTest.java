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

import java.util.List;

import com.lj.eshop.dto.ShopStyleDto;
import com.lj.eshop.dto.FindShopStylePage;
import com.lj.eshop.service.IShopStyleService;

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
public class ShopStyleServiceImplTest extends SpringTestCase{

	@Resource
	IShopStyleService shopStyleService;



	/**
	 * 
	 *
	 * 方法说明：添加店铺风格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addShopStyle() throws TsfaServiceException{
		ShopStyleDto shopStyleDto = new ShopStyleDto();
		//add数据录入
		shopStyleDto.setCode("Code");
		shopStyleDto.setName("Name");
		shopStyleDto.setSpe("Spe");
		shopStyleDto.setStatus("Status");
		
		shopStyleService.addShopStyle(shopStyleDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改店铺风格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateShopStyle() throws TsfaServiceException{
		ShopStyleDto shopStyleDto = new ShopStyleDto();
		//update数据录入
		shopStyleDto.setCode("Code");
		shopStyleDto.setName("Name");
		shopStyleDto.setSpe("Spe");
		shopStyleDto.setStatus("Status");

		shopStyleService.updateShopStyle(shopStyleDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺风格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopStyle() throws TsfaServiceException{
		ShopStyleDto findShopStyle = new ShopStyleDto();
		findShopStyle.setCode("111");
		shopStyleService.findShopStyle(findShopStyle);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺风格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopStylePage() throws TsfaServiceException{
		FindShopStylePage findShopStylePage = new FindShopStylePage();
		Page<ShopStyleDto> page = shopStyleService.findShopStylePage(findShopStylePage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺风格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopStyles() throws TsfaServiceException{
		FindShopStylePage findShopStylePage = new FindShopStylePage();
		List<ShopStyleDto> page = shopStyleService.findShopStyles(findShopStylePage);
		Assert.assertNotNull(page);
		
	}
	
}
