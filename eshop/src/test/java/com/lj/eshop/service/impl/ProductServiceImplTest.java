package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.eshop.dto.FindProductPage;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.emus.ProductStatus;
import com.lj.eshop.emus.ProductYN;
import com.lj.eshop.service.IProductService;

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
public class ProductServiceImplTest extends SpringTestCase{

	@Resource
	IProductService productService;



	/**
	 * 
	 *
	 * 方法说明：添加商品信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addProduct() throws TsfaServiceException{
		ProductDto productDto = new ProductDto();
		//add数据录入
		productDto.setCode("Code");
		productDto.setSupplyCode("SupplyCode");
		productDto.setSupplyName("SupplyName");
		productDto.setName("Name");
		productDto.setCatalogTypeCode("CatalogTypeCode");
		productDto.setOrgPrice(new BigDecimal(1));
		productDto.setSalePrice(new BigDecimal(1));
		productDto.setGapPrice(new BigDecimal(1));
		productDto.setCnt(1);
		productDto.setSaleCnt(2);
		productDto.setRemarks("Remarks");
		productDto.setUnit("Unit");
		productDto.setStatus(ProductStatus.USE.getValue());
		productDto.setPackageInfo("PackageInfo");
		productDto.setExpressFee("ExpressFee");
		productDto.setTotalScore(3);
		productDto.setSpeImg("SpeImg");
		productDto.setViewCnt(5);
		productDto.setEvlCnt(6);
		productDto.setShareCnt(7);
		productDto.setSaleShopCnt(8);
		productDto.setMerchantCode("merchant1");
		productDto.setCollectFlag(ProductYN.Y.getValue());
		productDto.setReturnFlag(ProductYN.Y.getValue());
		productDto.setPackFlag(ProductYN.Y.getValue());
		productDto.setCreateTime(new Date());
		productDto.setUpdateTime(new Date());
		productDto.setProductKey("ProductKey");
		productDto.setProductIcon("ProductIcon");
		productDto.setProductOrder(1);
		productDto.setProductDesc("ProductDesc");
		
		productService.addProduct(productDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateProduct() throws TsfaServiceException{
		ProductDto productDto = new ProductDto();
		//数据录入
		productDto.setCode("Code");
		productDto.setSupplyCode("SupplyCode");
		productDto.setSupplyName("SupplyName");
		productDto.setName("Name");
		productDto.setCatalogTypeCode("CatalogTypeCode");
		productDto.setOrgPrice(new BigDecimal(1));
		productDto.setSalePrice(new BigDecimal(1));
		productDto.setGapPrice(new BigDecimal(1));
		productDto.setCnt(1);
		productDto.setSaleCnt(2);
		productDto.setRemarks("Remarks");
		productDto.setUnit("Unit");
		productDto.setStatus("Status");
		productDto.setPackageInfo("PackageInfo");
		productDto.setExpressFee("ExpressFee");
		productDto.setTotalScore(3);
		productDto.setSpeImg("SpeImg");
		productDto.setViewCnt(5);
		productDto.setEvlCnt(6);
		productDto.setShareCnt(7);
		productDto.setSaleShopCnt(8);
		productDto.setMerchantCode("merchant1");
		productDto.setCollectFlag("CollectFlag");
		productDto.setReturnFlag("ReturnFlag");
		productDto.setPackFlag("PackFlag");
		productDto.setCreateTime(new Date());
		productDto.setUpdateTime(new Date());
		productDto.setProductKey("ProductKey");
		productDto.setProductIcon("ProductIcon");
		productDto.setProductOrder(1);
		productDto.setProductDesc("ProductDesc");
		

		productService.updateProduct(productDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProduct() throws TsfaServiceException{
		ProductDto findProduct = new ProductDto();
		findProduct.setCode("111");
		productService.findProduct(findProduct);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProductPage() throws TsfaServiceException{
		FindProductPage findProductPage = new FindProductPage();
		Page<ProductDto> page = productService.findProductPage(findProductPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findProducts() throws TsfaServiceException{
		FindProductPage findProductPage = new FindProductPage();
		ProductDto dto = new ProductDto();
//		dto.setCode("LJ_434786d95fbe42969a94831ac7cfc426");
//		findProductPage.setParam(dto);
		List<String> catalogTypeCodes = new LinkedList<String>();
		catalogTypeCodes.add("LJ_9ef79470664842e9b6ac322893cea35f");
		catalogTypeCodes.add("LJ_da91f03e59734055a09cd2f9d4adc516");
		findProductPage.setCatalogTypeCodes(catalogTypeCodes);
		
		List<ProductDto> page = productService.findProducts(findProductPage);
		System.out.println(page);
		Assert.assertNotNull(page);
		
	}
	
}
