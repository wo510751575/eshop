package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.OrderDetailDto;
import com.lj.eshop.dto.FindOrderDetailPage;


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
public interface IOrderDetailService {
	
	/**
	 * 
	 *
	 * 方法说明：添加订单明细信息
	 *
	 * @param orderDetailDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addOrderDetail(OrderDetailDto orderDetailDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找订单明细信息
	 *
	 * @param findOrderDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public OrderDetailDto findOrderDetail(OrderDetailDto orderDetailDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询订单明细信息
	 *
	 * @param findOrderDetailPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<OrderDetailDto>  findOrderDetails(FindOrderDetailPage findOrderDetailPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改订单明细信息
	 *
	 * @param updateOrderDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateOrderDetail(OrderDetailDto orderDetailDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询订单明细信息
	 *
	 * @param findOrderDetailPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<OrderDetailDto> findOrderDetailPage(FindOrderDetailPage findOrderDetailPage) throws TsfaServiceException;
	

}
