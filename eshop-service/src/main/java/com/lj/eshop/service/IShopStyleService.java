package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ShopStyleDto;
import com.lj.eshop.dto.FindShopStylePage;


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
public interface IShopStyleService {
	
	/**
	 * 
	 *
	 * 方法说明：添加店铺风格信息
	 *
	 * @param shopStyleDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addShopStyle(ShopStyleDto shopStyleDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺风格信息
	 *
	 * @param findShopStyle
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ShopStyleDto findShopStyle(ShopStyleDto shopStyleDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询店铺风格信息
	 *
	 * @param findShopStylePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ShopStyleDto>  findShopStyles(FindShopStylePage findShopStylePage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改店铺风格信息
	 *
	 * @param updateShopStyle
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateShopStyle(ShopStyleDto shopStyleDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询店铺风格信息
	 *
	 * @param findShopStylePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ShopStyleDto> findShopStylePage(FindShopStylePage findShopStylePage) throws TsfaServiceException;
	

}
