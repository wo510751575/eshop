package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.eshop.dto.EvlProductDto;
import com.lj.eshop.dto.FindEvlProductPage;
import com.lj.eshop.service.IEvlProductService;

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
public class EvlProductServiceImplTest extends SpringTestCase{

	@Resource
	IEvlProductService evlProductService;



	/**
	 * 
	 *
	 * 方法说明：添加商品评价信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addEvlProduct() throws TsfaServiceException{
		EvlProductDto evlProductDto = new EvlProductDto();
		//add数据录入
		Random r=new Random();
		r.setSeed(System.currentTimeMillis());
		evlProductDto.setCode("Code");
		evlProductDto.setEvlInfo("非常满意的购物，女友很喜欢"+( r.nextInt()));
		evlProductDto.setEvlGrade("5");
		evlProductDto.setEvlMbrCode("LJ_0d97014306c745f8a441228ec5f0aece");
		evlProductDto.setEvlMbrName("小康");
		evlProductDto.setEvlMbrImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503664817612&di=5cc7935b0100e4fcf5f930cc43de2fbb&imgtype=0&src=http%3A%2F%2Fimg.yanj.cn%2Feditor%2F20160517010157_15745.gif");
		evlProductDto.setCreateTime(new Date());
		evlProductDto.setProductCode("LJ_0d97014306c745f8a441228ec5f0aece");
		evlProductDto.setProductName("新增时候无价");
		evlProductDto.setProductSkuCode("LJ_3daf1fd72d324ebd919c7e0bee854568");
		evlProductDto.setGoodCnt(1);
		
		evlProductService.addEvlProduct(evlProductDto);
		evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);evlProductService.addEvlProduct(evlProductDto);
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品评价信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateEvlProduct() throws TsfaServiceException{
		EvlProductDto evlProductDto = new EvlProductDto();
		//update数据录入
		evlProductDto.setCode("Code");
		evlProductDto.setEvlInfo("EvlInfo");
		evlProductDto.setEvlGrade("EvlGrade");
		evlProductDto.setEvlMbrCode("EvlMbrCode");
		evlProductDto.setEvlMbrName("EvlMbrName");
		evlProductDto.setEvlMbrImg("EvlMbrImg");
		evlProductDto.setCreateTime(new Date());
		evlProductDto.setProductCode("ProductCode");
		evlProductDto.setProductName("ProductName");
		evlProductDto.setProductSkuCode("ProductSkuNo");
		evlProductDto.setGoodCnt(1);

		evlProductService.updateEvlProduct(evlProductDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品评价信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findEvlProduct() throws TsfaServiceException{
		EvlProductDto findEvlProduct = new EvlProductDto();
		findEvlProduct.setCode("111");
		evlProductService.findEvlProduct(findEvlProduct);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品评价信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findEvlProductPage() throws TsfaServiceException{
		FindEvlProductPage findEvlProductPage = new FindEvlProductPage();
		Page<EvlProductDto> page = evlProductService.findEvlProductPage(findEvlProductPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品评价信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findEvlProducts() throws TsfaServiceException{
		FindEvlProductPage findEvlProductPage = new FindEvlProductPage();
		List<EvlProductDto> page = evlProductService.findEvlProducts(findEvlProductPage);
		Assert.assertNotNull(page);
		
	}
	
}
