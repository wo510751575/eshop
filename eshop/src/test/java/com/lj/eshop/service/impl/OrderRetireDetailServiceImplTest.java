package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;

import java.math.BigDecimal;
import java.util.List;

import com.lj.eshop.dto.OrderRetireDetailDto;
import com.lj.eshop.dto.FindOrderRetireDetailPage;
import com.lj.eshop.service.IOrderRetireDetailService;

/**
 * 类说明：测试类
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
public class OrderRetireDetailServiceImplTest extends SpringTestCase{

	@Resource
	IOrderRetireDetailService orderRetireDetailService;



	/**
	 * 
	 *
	 * 方法说明：添加订单退换明细信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addOrderRetireDetail() throws TsfaServiceException{
		OrderRetireDetailDto orderRetireDetailDto = new OrderRetireDetailDto();
		//add数据录入
		orderRetireDetailDto.setCnt(1);
		orderRetireDetailDto.setAmt(new BigDecimal(1));
		orderRetireDetailDto.setRetireNo("JY2017082912311741367");
		orderRetireDetailDto.setSkuNo("SkuNo");
		
		orderRetireDetailService.addOrderRetireDetail(orderRetireDetailDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改订单退换明细信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateOrderRetireDetail() throws TsfaServiceException{
		OrderRetireDetailDto orderRetireDetailDto = new OrderRetireDetailDto();
		//update数据录入
		orderRetireDetailDto.setCode("Code");
		orderRetireDetailDto.setCnt(1);
		orderRetireDetailDto.setAmt(new BigDecimal(1));
		orderRetireDetailDto.setRetireNo("RetireNo");
		orderRetireDetailDto.setSkuNo("SkuNo");

		orderRetireDetailService.updateOrderRetireDetail(orderRetireDetailDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单退换明细信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrderRetireDetail() throws TsfaServiceException{
		OrderRetireDetailDto findOrderRetireDetail = new OrderRetireDetailDto();
		findOrderRetireDetail.setCode("111");
		orderRetireDetailService.findOrderRetireDetail(findOrderRetireDetail);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单退换明细信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrderRetireDetailPage() throws TsfaServiceException{
		FindOrderRetireDetailPage findOrderRetireDetailPage = new FindOrderRetireDetailPage();
		Page<OrderRetireDetailDto> page = orderRetireDetailService.findOrderRetireDetailPage(findOrderRetireDetailPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单退换明细信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrderRetireDetails() throws TsfaServiceException{
		FindOrderRetireDetailPage findOrderRetireDetailPage = new FindOrderRetireDetailPage();
		List<OrderRetireDetailDto> page = orderRetireDetailService.findOrderRetireDetails(findOrderRetireDetailPage);
		Assert.assertNotNull(page);
		
	}
	
}
