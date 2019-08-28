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

import java.math.BigDecimal;
import java.util.List;

import com.lj.eshop.dto.ProductSpeDto;
import com.lj.eshop.dto.FindProductSpePage;
import com.lj.eshop.service.IProductSpeService;

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
public class ProductSpeServiceImplTest extends SpringTestCase{

	@Resource
	IProductSpeService productSpeService;



	/**
	 * 
	 *
	 * 方法说明：添加商品规格值信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addProductSpe() throws TsfaServiceException{
		ProductSpeDto productSpeDto = new ProductSpeDto();
		//add数据录入
		productSpeDto.setCode("Code");
		productSpeDto.setProductCode("ProductCode");
		productSpeDto.setRuleDetail("RuleDetail");
		productSpeDto.setRuleCode("RuleCode");
		productSpeDto.setSalePrice(new BigDecimal(1));
		productSpeDto.setIsDefault("IsDefault");
		productSpeDto.setStoreCnt("StoreCnt");
		productSpeDto.setRemarks("Remarks");
		
		productSpeService.addProductSpe(productSpeDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品规格值信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateProductSpe() throws TsfaServiceException{
		ProductSpeDto productSpeDto = new ProductSpeDto();
		//update数据录入
		productSpeDto.setCode("Code");
		productSpeDto.setProductCode("ProductCode");
		productSpeDto.setRuleDetail("RuleDetail");
		productSpeDto.setRuleCode("RuleCode");
		productSpeDto.setSalePrice(new BigDecimal(1));
		productSpeDto.setIsDefault("IsDefault");
		productSpeDto.setStoreCnt("StoreCnt");
		productSpeDto.setRemarks("Remarks");

		productSpeService.updateProductSpe(productSpeDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格值信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductSpe() throws TsfaServiceException{
		ProductSpeDto findProductSpe = new ProductSpeDto();
		findProductSpe.setCode("111");
		productSpeService.findProductSpe(findProductSpe);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格值信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductSpePage() throws TsfaServiceException{
		FindProductSpePage findProductSpePage = new FindProductSpePage();
		Page<ProductSpeDto> page = productSpeService.findProductSpePage(findProductSpePage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格值信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductSpes() throws TsfaServiceException{
		FindProductSpePage findProductSpePage = new FindProductSpePage();
		List<ProductSpeDto> page = productSpeService.findProductSpes(findProductSpePage);
		Assert.assertNotNull(page);
		
	}
	
}
