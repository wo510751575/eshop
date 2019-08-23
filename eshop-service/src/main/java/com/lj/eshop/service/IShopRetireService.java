package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ShopRetireDto;
import com.lj.eshop.dto.FindShopRetirePage;
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;

import java.math.BigDecimal;
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
public interface IShopRetireService {
	
	/**
	 * 
	 *
	 * 方法说明：添加店铺押金退出申请信息
	 *
	 * @param shopRetireDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addShopRetire(ShopRetireDto shopRetireDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺押金退出申请信息
	 *
	 * @param findShopRetire
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ShopRetireDto findShopRetire(ShopRetireDto shopRetireDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询店铺押金退出申请信息
	 *
	 * @param findShopRetirePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ShopRetireDto>  findShopRetires(FindShopRetirePage findShopRetirePage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改店铺押金退出申请信息
	 *
	 * @param updateShopRetire
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateShopRetire(ShopRetireDto shopRetireDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询店铺押金退出申请信息
	 *
	 * @param findShopRetirePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ShopRetireDto> findShopRetirePage(FindShopRetirePage findShopRetirePage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：审核
	 *
	 * @param shopRetireDto
	 *
	 * @author 段志鹏 CreateDate: 2017年8月26日
	 *
	 */
	public void audit(ShopRetireDto shopRetireDto,BigDecimal amount);
}
