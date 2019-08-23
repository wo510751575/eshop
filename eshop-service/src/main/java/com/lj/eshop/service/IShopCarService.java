package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ShopCarDto;
import com.lj.eshop.dto.FindShopCarPage;


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
public interface IShopCarService {
	
	/**
	 * 
	 *
	 * 方法说明：添加购物车信息
	 *
	 * @param shopCarDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addShopCar(ShopCarDto shopCarDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找购物车信息
	 *
	 * @param findShopCar
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ShopCarDto findShopCar(ShopCarDto shopCarDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询购物车信息
	 *
	 * @param findShopCarPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ShopCarDto>  findShopCars(FindShopCarPage findShopCarPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改购物车信息
	 *
	 * @param updateShopCar
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateShopCar(ShopCarDto shopCarDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询购物车信息
	 *
	 * @param findShopCarPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ShopCarDto> findShopCarPage(FindShopCarPage findShopCarPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：移除购物车项
	 *
	 * @param code
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月28日
	 *
	 */
	public void deleteShopCar(String code) throws TsfaServiceException;
}
