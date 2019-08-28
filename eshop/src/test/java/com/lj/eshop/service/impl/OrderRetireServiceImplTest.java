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
import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.OrderRetireDto;
import com.lj.eshop.dto.FindOrderRetireDetailPage;
import com.lj.eshop.dto.FindOrderRetirePage;
import com.lj.eshop.dto.OrderRetireDetailDto;
import com.lj.eshop.emus.AuditStatus;
import com.lj.eshop.service.IOrderRetireService;

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
public class OrderRetireServiceImplTest extends SpringTestCase{

	@Resource
	IOrderRetireService orderRetireService;



	/**
	 * 
	 *
	 * 方法说明：添加订单退换信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addOrderRetire() throws TsfaServiceException{
		OrderRetireDto orderRetireDto = new OrderRetireDto();
		//add数据录入
		orderRetireDto.setCode("111");
		orderRetireDto.setOrderNo("OrderNo");
		orderRetireDto.setExpressNo("ExpressNo");
		orderRetireDto.setExpressName("ExpressName");
		orderRetireDto.setRemarks("Remarks");
		orderRetireDto.setImg1("Img1");
		orderRetireDto.setImg2("Img2");
		orderRetireDto.setImg3("Img3");
		orderRetireDto.setImg4("Img4");
		orderRetireDto.setType("Type");
		orderRetireDto.setAmt(new BigDecimal(100));
		orderRetireDto.setCreateTime(new Date());
		orderRetireDto.setUpdateTime(new Date());
		orderRetireDto.setRetireNo("RetireNo");
		orderRetireDto.setAuditStatus(AuditStatus.WAIT.getValue());
		
		orderRetireService.addOrderRetire(orderRetireDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改订单退换信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateOrderRetire() throws TsfaServiceException{
		OrderRetireDto orderRetireDto = new OrderRetireDto();
		//update数据录入
		orderRetireDto.setCode("LJ_00ceb065622342c3b01d88df5f3046b3");
		orderRetireDto.setOrderNo("OrderNo");
		orderRetireDto.setExpressNo("ExpressNo");
		orderRetireDto.setExpressName("ExpressName");
		orderRetireDto.setRemarks("Remarks");
		orderRetireDto.setImg1("Img1");
		orderRetireDto.setImg2("Img2");
		orderRetireDto.setImg3("Img3");
		orderRetireDto.setImg4("Img4");
		orderRetireDto.setType("Type");
		orderRetireDto.setCreateTime(new Date());
		orderRetireDto.setUpdateTime(new Date());
		orderRetireDto.setRetireNo("RetireNo");
		orderRetireDto.setAmt(new BigDecimal(300));
		
		orderRetireService.updateOrderRetire(orderRetireDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单退换信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrderRetire() throws TsfaServiceException{
		OrderRetireDto findOrderRetire = new OrderRetireDto();
		findOrderRetire.setCode("LJ_00ceb065622342c3b01d88df5f3046b3");
		OrderRetireDto rDto = orderRetireService.findOrderRetire(findOrderRetire);
		System.out.println(rDto);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单退换信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrderRetirePage() throws TsfaServiceException{
		FindOrderRetirePage findOrderRetirePage = new FindOrderRetirePage();
		OrderRetireDto findOrderRetire = new OrderRetireDto();
		findOrderRetire.setCode("LJ_12621c19d990454bb1caaa1e8a964501");
		findOrderRetirePage.setParam(findOrderRetire);
		Page<OrderRetireDto> page = orderRetireService.findOrderRetirePage(findOrderRetirePage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单退换信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrderRetires() throws TsfaServiceException{
		FindOrderRetirePage findOrderRetirePage = new FindOrderRetirePage();
		List<String> orderNos = new ArrayList<>();
		orderNos.add("JY2017082912311741367");
//		orderNos.add("JY2017082914444147267");
		findOrderRetirePage.setInOrderNos(orderNos);
		
		List<OrderRetireDto> page = orderRetireService.findOrderRetires(findOrderRetirePage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * bc端查询方式 
	 * 方法说明：
	 *
	 *         CreateDate: 2017年9月5日
	 */
	@Test
	public void findOrderRetirePage4BC() throws TsfaServiceException{
		FindOrderRetirePage findOrderRetirePage = new FindOrderRetirePage();
//		findOrderRetirePage.setMbrCode("LJ_1eb863856573406c956c0478abf47a72");
//		findOrderRetirePage.setMerchantCode("LJ_d0e8edca19bc445bbca254ddca6703d9");
		findOrderRetirePage.setShopCode("111");
		Page<OrderRetireDto> page = orderRetireService.findOrderRetirePage4BC(findOrderRetirePage);
		Assert.assertNotNull(page);
		System.out.println(page);
		
	}
	
}
