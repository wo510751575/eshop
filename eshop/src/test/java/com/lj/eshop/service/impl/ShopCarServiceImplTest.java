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

import com.lj.eshop.dto.ShopCarDto;
import com.lj.eshop.dto.FindShopCarPage;
import com.lj.eshop.service.IShopCarService;

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
public class ShopCarServiceImplTest extends SpringTestCase{

	@Resource
	IShopCarService shopCarService;



	/**
	 * 
	 *
	 * 方法说明：添加购物车信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addShopCar() throws TsfaServiceException{
		
		for (int i = 0; i < 20; i++) {
			ShopCarDto shopCarDto = new ShopCarDto();
			//add数据录入
			shopCarDto.setProductCode("LJ_36d68b4e592b4093bbc5d983649d724d");
			shopCarDto.setProductName("TESiRO通灵珠宝 金秋灿然简约 金18K钻石戒指 钻戒女 婚戒 情侣戒指对戒 七夕礼");
			shopCarDto.setProductSkuCode("LJ_663f16e577de44a784055a5f9739066c");
			shopCarDto.setCnt(1);
			shopCarDto.setMbrCode("LJ_1eb863856573406c956c0478abf47a72");
			shopCarDto.setImg("/image/product/859f9fc4-ee6a-4de9-9932-1c33113dbab7.jpg");
			shopCarDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopCarService.addShopCar(shopCarDto);
		}
		
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改购物车信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateShopCar() throws TsfaServiceException{
		ShopCarDto shopCarDto = new ShopCarDto();
		//update数据录入
		shopCarDto.setCode("Code");
		shopCarDto.setProductCode("ProductCode");
		shopCarDto.setProductName("ProductName");
		shopCarDto.setProductSkuCode("ProductSpe");
		shopCarDto.setCnt(0);
		shopCarDto.setCreateTime(new Date());
		shopCarDto.setMbrCode("MbrCode");
		shopCarDto.setImg("Img");

		shopCarService.updateShopCar(shopCarDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找购物车信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopCar() throws TsfaServiceException{
		ShopCarDto findShopCar = new ShopCarDto();
		findShopCar.setCode("111");
		shopCarService.findShopCar(findShopCar);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找购物车信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopCarPage() throws TsfaServiceException{
		FindShopCarPage findShopCarPage = new FindShopCarPage();
		Page<ShopCarDto> page = shopCarService.findShopCarPage(findShopCarPage);
		Assert.assertNotNull(page);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找购物车信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopCars() throws TsfaServiceException{
		FindShopCarPage findShopCarPage = new FindShopCarPage();
		List<ShopCarDto> page = shopCarService.findShopCars(findShopCarPage);
		Assert.assertNotNull(page);
		
	}
	
}
