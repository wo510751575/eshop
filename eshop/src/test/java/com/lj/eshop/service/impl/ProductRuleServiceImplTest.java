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

import com.lj.eshop.dto.ProductRuleDto;
import com.lj.eshop.dto.FindProductRulePage;
import com.lj.eshop.service.IProductRuleService;

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
public class ProductRuleServiceImplTest extends SpringTestCase{

	@Resource
	IProductRuleService productRuleService;



	/**
	 * 
	 *
	 * 方法说明：添加商品规格分类信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addProductRule() throws TsfaServiceException{
		ProductRuleDto productRuleDto = new ProductRuleDto();
		//add数据录入
		productRuleDto.setCode("Code");
		productRuleDto.setName("Name");
		productRuleDto.setProductCode("ProductCode");
		productRuleDto.setRemarks("Remarks");
		productRuleDto.setOrderNo(1);
		
		productRuleService.addProductRule(productRuleDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品规格分类信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateProductRule() throws TsfaServiceException{
		ProductRuleDto productRuleDto = new ProductRuleDto();
		//update数据录入
		productRuleDto.setCode("Code");
		productRuleDto.setName("Name");
		productRuleDto.setProductCode("ProductCode");
		productRuleDto.setRemarks("Remarks");
		productRuleDto.setOrderNo(2);

		productRuleService.updateProductRule(productRuleDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格分类信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductRule() throws TsfaServiceException{
		ProductRuleDto findProductRule = new ProductRuleDto();
		findProductRule.setCode("111");
		productRuleService.findProductRule(findProductRule);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格分类信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductRulePage() throws TsfaServiceException{
		FindProductRulePage findProductRulePage = new FindProductRulePage();
		Page<ProductRuleDto> page = productRuleService.findProductRulePage(findProductRulePage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格分类信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductRules() throws TsfaServiceException{
		FindProductRulePage findProductRulePage = new FindProductRulePage();
		List<ProductRuleDto> page = productRuleService.findProductRules(findProductRulePage);
		Assert.assertNotNull(page);
		
	}
	
}
