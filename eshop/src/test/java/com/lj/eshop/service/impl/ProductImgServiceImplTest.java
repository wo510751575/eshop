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

import com.lj.eshop.dto.ProductImgDto;
import com.lj.eshop.dto.FindProductImgPage;
import com.lj.eshop.service.IProductImgService;

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
public class ProductImgServiceImplTest extends SpringTestCase{

	@Resource
	IProductImgService productImgService;



	/**
	 * 
	 *
	 * 方法说明：添加商品图片信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addProductImg() throws TsfaServiceException{
		ProductImgDto productImgDto = new ProductImgDto();
		//add数据录入
		productImgDto.setCode("Code");
		productImgDto.setProductCode("ProductCode");
		productImgDto.setStatus("Status");
		productImgDto.setImg("Img");
		
		productImgService.addProductImg(productImgDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品图片信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateProductImg() throws TsfaServiceException{
		ProductImgDto productImgDto = new ProductImgDto();
		//update数据录入
		productImgDto.setCode("Code");
		productImgDto.setProductCode("ProductCode");
		productImgDto.setStatus("Status");
		productImgDto.setImg("Img");

		productImgService.updateProductImg(productImgDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品图片信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductImg() throws TsfaServiceException{
		ProductImgDto findProductImg = new ProductImgDto();
		findProductImg.setCode("111");
		productImgService.findProductImg(findProductImg);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品图片信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductImgPage() throws TsfaServiceException{
		FindProductImgPage findProductImgPage = new FindProductImgPage();
		Page<ProductImgDto> page = productImgService.findProductImgPage(findProductImgPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品图片信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductImgs() throws TsfaServiceException{
		FindProductImgPage findProductImgPage = new FindProductImgPage();
		List<ProductImgDto> page = productImgService.findProductImgs(findProductImgPage);
		Assert.assertNotNull(page);
		
	}
	
}
