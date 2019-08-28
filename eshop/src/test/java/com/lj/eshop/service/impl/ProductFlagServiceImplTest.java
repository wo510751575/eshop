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

import com.lj.eshop.dto.ProductFlagDto;
import com.lj.eshop.dto.FindProductFlagPage;
import com.lj.eshop.service.IProductFlagService;

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
public class ProductFlagServiceImplTest extends SpringTestCase{

	@Resource
	IProductFlagService productFlagService;



	/**
	 * 
	 *
	 * 方法说明：添加商品标记关联信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addProductFlag() throws TsfaServiceException{
		ProductFlagDto productFlagDto = new ProductFlagDto();
		//add数据录入
		productFlagDto.setCode("Code");
		productFlagDto.setProductCode("ProductCode");
		productFlagDto.setFlagCode("FlagCode");
		
		productFlagService.addProductFlag(productFlagDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品标记关联信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateProductFlag() throws TsfaServiceException{
		ProductFlagDto productFlagDto = new ProductFlagDto();
		//update数据录入
		productFlagDto.setCode("Code");
		productFlagDto.setProductCode("ProductCode");
		productFlagDto.setFlagCode("FlagCode");

		productFlagService.updateProductFlag(productFlagDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品标记关联信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductFlag() throws TsfaServiceException{
		ProductFlagDto findProductFlag = new ProductFlagDto();
		findProductFlag.setCode("111");
		productFlagService.findProductFlag(findProductFlag);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品标记关联信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductFlagPage() throws TsfaServiceException{
		FindProductFlagPage findProductFlagPage = new FindProductFlagPage();
		Page<ProductFlagDto> page = productFlagService.findProductFlagPage(findProductFlagPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品标记关联信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductFlags() throws TsfaServiceException{
		FindProductFlagPage findProductFlagPage = new FindProductFlagPage();
		List<ProductFlagDto> page = productFlagService.findProductFlags(findProductFlagPage);
		Assert.assertNotNull(page);
		
	}
	
}
