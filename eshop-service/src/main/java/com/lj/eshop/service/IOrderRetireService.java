package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.FindOrderRetirePage;
import com.lj.eshop.dto.OrderRetireDto;
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
public interface IOrderRetireService {
	
	/**
	 * 
	 *
	 * 方法说明：添加订单退换信息
	 *
	 * @param orderRetireDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addOrderRetire(OrderRetireDto orderRetireDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找订单退换信息
	 *
	 * @param findOrderRetire
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public OrderRetireDto findOrderRetire(OrderRetireDto orderRetireDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询订单退换信息
	 *
	 * @param findOrderRetirePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<OrderRetireDto>  findOrderRetires(FindOrderRetirePage findOrderRetirePage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改订单退换信息
	 *
	 * @param updateOrderRetire
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateOrderRetire(OrderRetireDto orderRetireDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询订单退换信息
	 *
	 * @param findOrderRetirePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<OrderRetireDto> findOrderRetirePage(FindOrderRetirePage findOrderRetirePage) throws TsfaServiceException;
	//bc端的分页查询
	public Page<OrderRetireDto> findOrderRetirePage4BC(FindOrderRetirePage findOrderRetirePage) throws TsfaServiceException;

	/**
	 * 
	 * 方法说明：申请退款
	 *
	 * @param @param orderRetireDto
	 * @param @throws TsfaServiceException    设定文件 
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月4日
	 */
	public void applyBack(OrderRetireDto orderRetireDto) throws TsfaServiceException;

}
