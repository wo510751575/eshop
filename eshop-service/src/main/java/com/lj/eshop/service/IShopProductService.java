package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ShopProductDto;
import com.lj.eshop.dto.FindShopProductPage;


import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;

import java.util.List;
/**
 * 类说明：接口类
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
public interface IShopProductService {
	
	/**
	 * 
	 *
	 * 方法说明：添加店铺商品信息
	 *
	 * @param shopProductDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addShopProduct(ShopProductDto shopProductDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺商品信息
	 *
	 * @param findShopProduct
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ShopProductDto findShopProduct(ShopProductDto shopProductDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询店铺商品信息
	 *
	 * @param findShopProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ShopProductDto>  findShopProducts(FindShopProductPage findShopProductPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改店铺商品信息
	 *
	 * @param updateShopProduct
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateShopProduct(ShopProductDto shopProductDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询店铺商品信息
	 *
	 * @param findShopProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ShopProductDto> findShopProductPage(FindShopProductPage findShopProductPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：店铺首页商品信息
	 *
	 * @param findShopProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月31日
	 *
	 */
	public Page<ShopProductDto> findIndexShopProductPage(FindShopProductPage findShopProductPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：获取店铺商品根据店铺和商品
	 *
	 * @param shopCode		店铺Code
	 * @param productCode	商品Code
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月31日
	 *
	 */
	public ShopProductDto findByShopCodeAndProCode(ShopProductDto param) throws TsfaServiceException;
}
