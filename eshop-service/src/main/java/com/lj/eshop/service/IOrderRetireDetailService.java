package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.OrderRetireDetailDto;
import com.lj.eshop.dto.FindOrderRetireDetailPage;


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
public interface IOrderRetireDetailService {
	
	/**
	 * 
	 *
	 * 方法说明：添加订单退换明细信息
	 *
	 * @param orderRetireDetailDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addOrderRetireDetail(OrderRetireDetailDto orderRetireDetailDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找订单退换明细信息
	 *
	 * @param findOrderRetireDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public OrderRetireDetailDto findOrderRetireDetail(OrderRetireDetailDto orderRetireDetailDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询订单退换明细信息
	 *
	 * @param findOrderRetireDetailPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<OrderRetireDetailDto>  findOrderRetireDetails(FindOrderRetireDetailPage findOrderRetireDetailPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改订单退换明细信息
	 *
	 * @param updateOrderRetireDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateOrderRetireDetail(OrderRetireDetailDto orderRetireDetailDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询订单退换明细信息
	 *
	 * @param findOrderRetireDetailPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<OrderRetireDetailDto> findOrderRetireDetailPage(FindOrderRetireDetailPage findOrderRetireDetailPage) throws TsfaServiceException;
	

}
