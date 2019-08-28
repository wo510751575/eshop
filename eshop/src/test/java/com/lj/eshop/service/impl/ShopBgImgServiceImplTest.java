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

import com.lj.eshop.dto.ShopBgImgDto;
import com.lj.eshop.dto.FindShopBgImgPage;
import com.lj.eshop.service.IShopBgImgService;

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
public class ShopBgImgServiceImplTest extends SpringTestCase{

	@Resource
	IShopBgImgService shopBgImgService;



	/**
	 * 
	 *
	 * 方法说明：添加店铺背景图信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addShopBgImg() throws TsfaServiceException{
		ShopBgImgDto shopBgImgDto = new ShopBgImgDto();
		//add数据录入
		shopBgImgDto.setCode("Code");
		shopBgImgDto.setName("Name");
		shopBgImgDto.setSpe("Spe");
		shopBgImgDto.setStatus("Status");
		
		shopBgImgService.addShopBgImg(shopBgImgDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改店铺背景图信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateShopBgImg() throws TsfaServiceException{
		ShopBgImgDto shopBgImgDto = new ShopBgImgDto();
		//update数据录入
		shopBgImgDto.setCode("Code");
		shopBgImgDto.setName("Name");
		shopBgImgDto.setSpe("Spe");
		shopBgImgDto.setStatus("Status");

		shopBgImgService.updateShopBgImg(shopBgImgDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺背景图信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopBgImg() throws TsfaServiceException{
		ShopBgImgDto findShopBgImg = new ShopBgImgDto();
		findShopBgImg.setCode("111");
		shopBgImgService.findShopBgImg(findShopBgImg);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺背景图信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopBgImgPage() throws TsfaServiceException{
		FindShopBgImgPage findShopBgImgPage = new FindShopBgImgPage();
		Page<ShopBgImgDto> page = shopBgImgService.findShopBgImgPage(findShopBgImgPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺背景图信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopBgImgs() throws TsfaServiceException{
		FindShopBgImgPage findShopBgImgPage = new FindShopBgImgPage();
		List<ShopBgImgDto> page = shopBgImgService.findShopBgImgs(findShopBgImgPage);
		Assert.assertNotNull(page);
		
	}
	
}
