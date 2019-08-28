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
import java.util.ArrayList;
import java.util.List;

import com.lj.eshop.dto.OrderDetailDto;
import com.lj.eshop.dto.FindOrderDetailPage;
import com.lj.eshop.service.IOrderDetailService;

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
public class OrderDetailServiceImplTest extends SpringTestCase{

	@Resource
	IOrderDetailService orderDetailService;



	/**
	 * 
	 *
	 * 方法说明：添加订单明细信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addOrderDetail() throws TsfaServiceException{
		OrderDetailDto orderDetailDto = new OrderDetailDto();
		//add数据录入
		orderDetailDto.setProductCode("LJ_12007b633ec2462182247631adc1c44f");
		orderDetailDto.setProductName("ProductName");
		orderDetailDto.setSupplyCode("SupplyCode");
		orderDetailDto.setSupplyName("SupplyName");
		orderDetailDto.setCnt(1);
		orderDetailDto.setAmt(new BigDecimal(1));
		orderDetailDto.setSalePrice(new BigDecimal(2));
		orderDetailDto.setOrderNo("JY2017082914444147267");
		orderDetailDto.setSkuCode("LJ_67630d261db74e58aa835b42986c4ff3");
		orderDetailDto.setOrgPrice(new BigDecimal(3));
		orderDetailDto.setGapPrice(new BigDecimal(1));
		orderDetailService.addOrderDetail(orderDetailDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改订单明细信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateOrderDetail() throws TsfaServiceException{
		OrderDetailDto orderDetailDto = new OrderDetailDto();
		//update数据录入
		orderDetailDto.setCode("Code");
		orderDetailDto.setProductCode("ProductCode");
		orderDetailDto.setProductName("ProductName");
		orderDetailDto.setSupplyCode("SupplyCode");
		orderDetailDto.setSupplyName("SupplyName");
		orderDetailDto.setCnt(1);
		orderDetailDto.setAmt(new BigDecimal(1));
		orderDetailDto.setSalePrice(new BigDecimal(2));
		orderDetailDto.setOrderNo("OrderNo");
		orderDetailDto.setSkuCode("SkuCode");
		orderDetailDto.setOrgPrice(new BigDecimal(3));
		orderDetailDto.setGapPrice(new BigDecimal(1));
		orderDetailService.updateOrderDetail(orderDetailDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单明细信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrderDetail() throws TsfaServiceException{
		OrderDetailDto findOrderDetail = new OrderDetailDto();
		findOrderDetail.setCode("111");
		orderDetailService.findOrderDetail(findOrderDetail);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单明细信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrderDetailPage() throws TsfaServiceException{
		FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();

		List<String> codes = new ArrayList<>();
		codes.add("LJ_07f8d99f6cb24082973129f6e0a6a571");
		codes.add("LJ_159b70963cde4ea4b0b8eea6ff087d15");
		findOrderDetailPage.setOrderDetailCode(codes);
		
		Page<OrderDetailDto> page = orderDetailService.findOrderDetailPage(findOrderDetailPage);
		

		
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单明细信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrderDetails() throws TsfaServiceException{
		FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
		List<OrderDetailDto> page = orderDetailService.findOrderDetails(findOrderDetailPage);
		Assert.assertNotNull(page);
		
	}
	
}
