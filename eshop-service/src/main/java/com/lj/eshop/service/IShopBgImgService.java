package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ShopBgImgDto;
import com.lj.eshop.dto.FindShopBgImgPage;


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
public interface IShopBgImgService {
	
	/**
	 * 
	 *
	 * 方法说明：添加店铺背景图信息
	 *
	 * @param shopBgImgDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addShopBgImg(ShopBgImgDto shopBgImgDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺背景图信息
	 *
	 * @param findShopBgImg
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ShopBgImgDto findShopBgImg(ShopBgImgDto shopBgImgDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询店铺背景图信息
	 *
	 * @param findShopBgImgPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ShopBgImgDto>  findShopBgImgs(FindShopBgImgPage findShopBgImgPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改店铺背景图信息
	 *
	 * @param updateShopBgImg
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateShopBgImg(ShopBgImgDto shopBgImgDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询店铺背景图信息
	 *
	 * @param findShopBgImgPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ShopBgImgDto> findShopBgImgPage(FindShopBgImgPage findShopBgImgPage) throws TsfaServiceException;
	

}
