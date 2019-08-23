package com.lj.eshop.service;

import java.math.BigDecimal;
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.FindShopPage;
import com.lj.eshop.dto.PaymentDto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ShopDto;
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
public interface IShopService {
	
	/**
	 * 
	 *
	 * 方法说明：添加微店店铺信息
	 *
	 * @param shopDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ShopDto addShop(ShopDto shopDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找微店店铺信息
	 *
	 * @param findShop
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ShopDto findShop(ShopDto shopDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询微店店铺信息
	 *
	 * @param findShopPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ShopDto>  findShops(FindShopPage findShopPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改微店店铺信息
	 *
	 * @param updateShop
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateShop(ShopDto shopDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询微店店铺信息
	 *
	 * @param findShopPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ShopDto> findShopPage(FindShopPage findShopPage) throws TsfaServiceException;
	
	/**
	 * 支付成功后 回调 开店 处理结果的接口
	 * 方法说明：
	 * @author 林进权 CreateDate: 2017年8月28日
	 *
	 */
	public void payment(PaymentDto paymentDto);
	
	/**
	 * 根据开店申请编号查询押金的接口 ，默认是2000
	 * 方法说明：
	 * @author 林进权 CreateDate: 2017年8月28日
	 *
	 */
	public BigDecimal queryCashPledge(String shopNo);

}
