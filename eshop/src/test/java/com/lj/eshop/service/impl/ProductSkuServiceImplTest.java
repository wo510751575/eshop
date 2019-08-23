package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lj.eshop.dto.ProductSkuDto;
import com.lj.eshop.dto.FindProductSkuPage;
import com.lj.eshop.service.IProductSkuService;

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
public class ProductSkuServiceImplTest extends SpringTestCase{

	@Resource
	IProductSkuService productSkuService;



	/**
	 * 
	 *
	 * 方法说明：添加商品SKU信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addProductSku() throws TsfaServiceException{
		ProductSkuDto productSkuDto = new ProductSkuDto();
		//add数据录入
		productSkuDto.setCode("Code");
		productSkuDto.setCnt(1);
		productSkuDto.setProductCode("ProductCode");
		productSkuDto.setProductSpes("ProductSpes");
		productSkuDto.setSkuNo("SkuNo");
		productSkuDto.setDelFlag("DelFlag");
		productSkuDto.setCostPrice(new BigDecimal(1));
		productSkuDto.setSalePrice(new BigDecimal(1));
		productSkuDto.setOrgPrice(new BigDecimal(1));
		productSkuDto.setGapPrice(new BigDecimal(1));
		productSkuDto.setPrice(new BigDecimal(1));
		productSkuDto.setIsDefault("IsDefault");
		productSkuDto.setSkuDesc("SkuDesc");
		
		productSkuService.addProductSku(productSkuDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品SKU信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateProductSku() throws TsfaServiceException{
		ProductSkuDto productSkuDto = new ProductSkuDto();
		//update数据录入
		productSkuDto.setCode("Code");
		productSkuDto.setCnt(1);
		productSkuDto.setProductCode("ProductCode");
		productSkuDto.setProductSpes("ProductSpes");
		productSkuDto.setSkuNo("SkuNo");
		productSkuDto.setDelFlag("1");
		productSkuDto.setCostPrice(new BigDecimal(1));
		productSkuDto.setSalePrice(new BigDecimal(1));
		productSkuDto.setOrgPrice(new BigDecimal(1));
		productSkuDto.setGapPrice(new BigDecimal(1));
		productSkuDto.setPrice(new BigDecimal(1));
		productSkuDto.setIsDefault("IsDefault");
		productSkuDto.setSkuDesc("SkuDesc");

		productSkuService.updateProductSku(productSkuDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品SKU信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductSku() throws TsfaServiceException{
		ProductSkuDto findProductSku = new ProductSkuDto();
		findProductSku.setCode("111");
		productSkuService.findProductSku(findProductSku);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品SKU信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductSkuPage() throws TsfaServiceException{
		FindProductSkuPage findProductSkuPage = new FindProductSkuPage();
		List<String> codes = new ArrayList<>();
		codes.add("LJ_30a149a70212427782a2fce1977bc290");
		codes.add("LJ_33960089ac98485e89ceb0e7fdf4ec08");
		findProductSkuPage.setInCodes(codes);
		Page<ProductSkuDto> page = productSkuService.findProductSkuPage(findProductSkuPage);
		
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品SKU信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductSkus() throws TsfaServiceException{
		FindProductSkuPage findProductSkuPage = new FindProductSkuPage();
		List<ProductSkuDto> page = productSkuService.findProductSkus(findProductSkuPage);
		Assert.assertNotNull(page);
		
	}
	
}
