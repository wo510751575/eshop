package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.CustOrderDto;
import com.lj.eshop.dto.FindCustOrderPage;
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
public interface ICustOrderService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品定制订单信息
	 *
	 * @param custOrderDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addCustOrder(CustOrderDto custOrderDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品定制订单信息
	 *
	 * @param findCustOrder
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public CustOrderDto findCustOrder(CustOrderDto custOrderDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品定制订单信息
	 *
	 * @param findCustOrderPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<CustOrderDto>  findCustOrders(FindCustOrderPage findCustOrderPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品定制订单信息
	 *
	 * @param updateCustOrder
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateCustOrder(CustOrderDto custOrderDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品定制订单信息
	 *
	 * @param findCustOrderPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<CustOrderDto> findCustOrderPage(FindCustOrderPage findCustOrderPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：发货操作
	 *
	 * @param custOrderDto	当前定制单
	 * @param expressNo		快递单号
	 * @param expressName	快递公司
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月30日
	 *
	 */
	public void shipping(CustOrderDto custOrderDto,String expressNo,String expressName) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：商户报价
	 *
	 * @param custOrderDto
	 * @param costPrice		出厂价格
	 * @param orgPrice		小B售价		
	 * @param supply		供应商		
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月30日
	 *
	 */
	public void offer(CustOrderDto custOrderDto) throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：订单完成
	 *
	 * @param custOrderDto
	 *
	 * @author 段志鹏 CreateDate: 2017年8月30日
	 *
	 */
	public void complete(CustOrderDto custOrderDto)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：B端报价
	 *
	 * @param custOrderDto
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月30日
	 *
	 */
	public void offerShop(CustOrderDto custOrderDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：定制订单支付
	 *
	 * @param custOrderDto
	 * @param amt	付款金额
	 * @param payType	付款类型
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月30日
	 *
	 */
	public void payment(CustOrderDto custOrderDto,BigDecimal amt,String payType) throws TsfaServiceException;
}
