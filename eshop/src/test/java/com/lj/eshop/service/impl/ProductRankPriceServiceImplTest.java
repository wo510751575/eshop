package com.lj.eshop.service.impl;

import java.math.BigDecimal;
import java.util.List;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.eshop.dto.FindProductRankPricePage;
import com.lj.eshop.dto.ProductRankPriceDto;
import com.lj.eshop.service.IProductRankPriceService;

/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 段志鹏
 * 
 * 
 *         CreateDate: 2017.12.11
 */
public class ProductRankPriceServiceImplTest extends SpringTestCase {

	@Resource
	IProductRankPriceService productRankPriceService;

	/**
	 * 
	 *
	 * 方法说明：添加商品特权价格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	@Test
	public void addProductRankPrice() throws TsfaServiceException {
		ProductRankPriceDto productRankPriceDto = new ProductRankPriceDto();
		// add数据录入
		productRankPriceDto.setCode("Code");
		productRankPriceDto.setProductCode("ProductCode");
		productRankPriceDto.setRankCode("RankCode");
		productRankPriceDto.setSkuCode("SkuCode");
		productRankPriceDto.setRankPrice(BigDecimal.ONE);

		productRankPriceService.addProductRankPrice(productRankPriceDto);

	}

	/**
	 * 
	 *
	 * 方法说明：修改商品特权价格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	@Test
	public void updateProductRankPrice() throws TsfaServiceException {
		ProductRankPriceDto productRankPriceDto = new ProductRankPriceDto();
		// update数据录入
		productRankPriceDto.setCode("Code");
		productRankPriceDto.setProductCode("ProductCode");
		productRankPriceDto.setRankCode("RankCode");
		productRankPriceDto.setSkuCode("SkuCode");
		productRankPriceDto.setRankPrice(BigDecimal.ONE);

		productRankPriceService.updateProductRankPrice(productRankPriceDto);

	}

	/**
	 * 
	 *
	 * 方法说明：查找商品特权价格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	@Test
	public void findProductRankPrice() throws TsfaServiceException {
		ProductRankPriceDto findProductRankPrice = new ProductRankPriceDto();
		findProductRankPrice.setCode("111");
		productRankPriceService.findProductRankPrice(findProductRankPrice);
	}

	/**
	 * 
	 *
	 * 方法说明：查找商品特权价格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	@Test
	public void findProductRankPricePage() throws TsfaServiceException {
		FindProductRankPricePage findProductRankPricePage = new FindProductRankPricePage();
		Page<ProductRankPriceDto> page = productRankPriceService.findProductRankPricePage(findProductRankPricePage);
		Assert.assertNotNull(page);

	}

	/**
	 * 
	 *
	 * 方法说明：查找商品特权价格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	@Test
	public void findProductRankPrices() throws TsfaServiceException {
		FindProductRankPricePage findProductRankPricePage = new FindProductRankPricePage();
		List<ProductRankPriceDto> page = productRankPriceService.findProductRankPrices(findProductRankPricePage);
		Assert.assertNotNull(page);

	}

}
