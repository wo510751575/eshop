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

import com.lj.eshop.dto.ShopProductDto;
import com.lj.eshop.dto.FindShopProductPage;
import com.lj.eshop.emus.ProductStatus;
import com.lj.eshop.service.IShopProductService;

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
public class ShopProductServiceImplTest extends SpringTestCase{

	@Resource
	IShopProductService shopProductService;



	/**
	 * 
	 *
	 * 方法说明：添加店铺商品信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addShopProduct() throws TsfaServiceException{
		
		for(int i=0; i<100; i++) {
			//add数据录入
			
			ShopProductDto shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_0d97014306c745f8a441228ec5f0aece");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
			
			shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_12007b633ec2462182247631adc1c44f");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
			
			shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_12e3654ada3647f0b589a56fe08108cc");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
			
			shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_215a73d2ad9d4cda8d5212104ce6b318");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
			
			shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_2c56b4b715b64218a348a04657c1f017");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
			
			shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_35d0b4477dc9482dab3e35e2f9b41a89");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
			
			shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_36d68b4e592b4093bbc5d983649d724d");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
			
			shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_47686344ba2f431596bbfe3ee2f38f1d");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
			
			shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_48658bf337bb40ccb2fc3a0996683d3c");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
			
			shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_4b76d961fb1446b59a0affbc3a6ebc34");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
			
			shopProductDto = new ShopProductDto();
			shopProductDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			shopProductDto.setProductCode("LJ_6bd2f6b43bd045bea4b55431fc4820c2");
			shopProductDto.setStatus(ProductStatus.USE.getValue());
			shopProductService.addShopProduct(shopProductDto);
		}
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改店铺商品信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateShopProduct() throws TsfaServiceException{
		ShopProductDto shopProductDto = new ShopProductDto();
		//update数据录入
		shopProductDto.setCode("Code");
		shopProductDto.setShopCode("ShopCode");
		shopProductDto.setProductCode("ProductCode");
		shopProductDto.setStatus("Status");
		shopProductDto.setCreateTime(new Date());

		shopProductService.updateShopProduct(shopProductDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺商品信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopProduct() throws TsfaServiceException{
		ShopProductDto findShopProduct = new ShopProductDto();
		findShopProduct.setCode("111");
		shopProductService.findShopProduct(findShopProduct);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺商品信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopProductPage() throws TsfaServiceException{
		FindShopProductPage findShopProductPage = new FindShopProductPage();
		Page<ShopProductDto> page = shopProductService.findShopProductPage(findShopProductPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺商品信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopProducts() throws TsfaServiceException{
		FindShopProductPage findShopProductPage = new FindShopProductPage();
		List<ShopProductDto> page = shopProductService.findShopProducts(findShopProductPage);
		Assert.assertNotNull(page);
		
	}
	
	@Test
	public void findIndexShopProductPage() throws TsfaServiceException{
		FindShopProductPage findShopProductPage = new FindShopProductPage();
		Page<ShopProductDto> page = shopProductService.findIndexShopProductPage(findShopProductPage);
		Assert.assertNotNull(page);
		System.out.println(page.toString());
	}
	
}
