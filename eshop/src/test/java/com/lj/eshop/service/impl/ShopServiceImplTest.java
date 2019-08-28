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
import com.lj.base.core.pagination.PageSortType;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;

import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.dto.FindShopPage;
import com.lj.eshop.emus.ShopStatus;
import com.lj.eshop.service.IShopService;

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
public class ShopServiceImplTest extends SpringTestCase{

	@Resource
	IShopService shopService;



	/**
	 * 
	 *
	 * 方法说明：添加微店店铺信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addShop() throws TsfaServiceException{
		ShopDto shopDto = new ShopDto();
		//add数据录入
		shopDto.setCode("Code");
		shopDto.setShopName("ShopName");
		shopDto.setShopProvide("ShopProvide");
		shopDto.setShopCity("ShopCity");
		shopDto.setShopArea("ShopArea");
		shopDto.setShopAddinfo("ShopAddinfo");
		shopDto.setStatus(ShopStatus.NORMAL.getValue());
		shopDto.setImg("Img");
		shopDto.setShopFlag("ShopFlag");
		shopDto.setShopBgImgCode("ShopBgImgCode");
		shopDto.setShopGarde("1");
		shopDto.setCloseReason("CloseReason");
		shopDto.setCreateTime(new Date());
		shopDto.setCloseTime(new Date());
		shopDto.setOpenTime(new Date());
		shopDto.setShopStyleCode("ShopStyleCode");
		shopDto.setMimeCode("MimeCode");
		shopDto.setReadNum(1);
		shopDto.setMbrCode("LJ_6077614d932649ebb32e17cf4033d802");
		shopDto.setMerchantCode("LJ_d0e8edca19bc445bbca254ddca6703d9");
		shopDto.setShopNo("shop1111");
		shopService.addShop(shopDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改微店店铺信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateShop() throws TsfaServiceException{
		ShopDto shopDto = new ShopDto();
		//update数据录入
		shopDto.setCode("LJ_b7abef1c5dc34dbf8ad6f0b032bf39c5");
		shopDto.setShopName("ShopName");
		shopDto.setShopProvide("ShopProvide");
		shopDto.setShopCity("ShopCity");
		shopDto.setShopArea("ShopArea");
		shopDto.setShopAddinfo("ShopAddinfo");
		shopDto.setStatus("1");
		shopDto.setImg("Img");
		shopDto.setShopFlag("ShopFlag");
		shopDto.setShopBgImgCode("ShopBgImgCode");
		shopDto.setShopGarde("ShopGarde");
		shopDto.setCloseReason("CloseReason");
		shopDto.setCreateTime(new Date());
		shopDto.setCloseTime(new Date());
		shopDto.setOpenTime(new Date());
		shopDto.setShopStyleCode("ShopStyleCode");
		shopDto.setMimeCode("MimeCode");
		shopDto.setReadNum(1);
		shopDto.setShopNo("shop2222");

		shopService.updateShop(shopDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找微店店铺信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShop() throws TsfaServiceException{
		ShopDto findShop = new ShopDto();
		findShop.setCode("LJ_0e0a461585fa493794cc1368b87ec324");
		ShopDto shopDto = shopService.findShop(findShop);
		System.out.println(shopDto);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找微店店铺信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopPage() throws TsfaServiceException{
		FindShopPage findShopPage = new FindShopPage();
		ShopDto param = new ShopDto();
		param.setShopName("1");
		findShopPage.setParam(param);
		findShopPage.setSortBy("create_time");
		findShopPage.setSortDir(PageSortType.desc);
		Page<ShopDto> page = shopService.findShopPage(findShopPage);
		System.out.println(page);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找微店店铺信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShops() throws TsfaServiceException{
		FindShopPage findShopPage = new FindShopPage();
//		ShopDto param = new ShopDto();
//		param.setShopName("1");
//		findShopPage.setParam(param);
		List<ShopDto> page = shopService.findShops(findShopPage);
		Assert.assertNotNull(page);
		System.out.println(page.toString());
	}
	
}
