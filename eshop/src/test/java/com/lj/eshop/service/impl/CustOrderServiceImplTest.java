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
import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.CustOrderDto;
import com.lj.eshop.dto.FindCustOrderPage;
import com.lj.eshop.service.ICustOrderService;

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
public class CustOrderServiceImplTest extends SpringTestCase{

	@Resource
	ICustOrderService custOrderService;



	/**
	 * 
	 *
	 * 方法说明：添加商品定制订单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addCustOrder() throws TsfaServiceException{
		CustOrderDto custOrderDto = new CustOrderDto();
		//add数据录入
		custOrderDto.setCode("Code");
		custOrderDto.setSupplyCode("SupplyCode");
		custOrderDto.setSupplyName("SupplyName");
		custOrderDto.setImg1("Img1");
		custOrderDto.setImg2("Img2");
		custOrderDto.setImg3("Img3");
		custOrderDto.setImg4("Img4");
		custOrderDto.setImg5("Img5");
		custOrderDto.setImg6("Img6");
		custOrderDto.setRemarks("Remarks");
		custOrderDto.setPayAmt(new BigDecimal(1));
		custOrderDto.setCreateTime(new Date());
		custOrderDto.setUpdateTime(new Date());
		custOrderDto.setCatalogCode("CatalogCode");
		custOrderDto.setCatalogName("CatalogName");
		custOrderDto.setPayType("PayType");
		custOrderDto.setOrderNo("OrderNo");
		custOrderDto.setCostPrice(new BigDecimal(2));
		custOrderDto.setOrgPrice(new BigDecimal(3));
		custOrderDto.setGapPrice(new BigDecimal(4));
		custOrderDto.setSalePrice(new BigDecimal(5));
		
		custOrderService.addCustOrder(custOrderDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品定制订单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateCustOrder() throws TsfaServiceException{
		CustOrderDto custOrderDto = new CustOrderDto();
		//update数据录入
		custOrderDto.setCode("Code");
		custOrderDto.setSupplyCode("SupplyCode");
		custOrderDto.setSupplyName("SupplyName");
		custOrderDto.setImg1("Img1");
		custOrderDto.setImg2("Img2");
		custOrderDto.setImg3("Img3");
		custOrderDto.setImg4("Img4");
		custOrderDto.setImg5("Img5");
		custOrderDto.setImg6("Img6");
		custOrderDto.setRemarks("Remarks");
		custOrderDto.setPayAmt(new BigDecimal(1));
		custOrderDto.setCreateTime(new Date());
		custOrderDto.setUpdateTime(new Date());
		custOrderDto.setCatalogCode("CatalogCode");
		custOrderDto.setCatalogName("CatalogName");
		custOrderDto.setPayType("PayType");
		custOrderDto.setOrderNo("OrderNo");
		custOrderDto.setCostPrice(new BigDecimal(2));
		custOrderDto.setOrgPrice(new BigDecimal(3));
		custOrderDto.setGapPrice(new BigDecimal(4));
		custOrderDto.setSalePrice(new BigDecimal(5));

		custOrderService.updateCustOrder(custOrderDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品定制订单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findCustOrder() throws TsfaServiceException{
		CustOrderDto findCustOrder = new CustOrderDto();
		findCustOrder.setCode("111");
		custOrderService.findCustOrder(findCustOrder);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品定制订单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findCustOrderPage() throws TsfaServiceException{
		FindCustOrderPage findCustOrderPage = new FindCustOrderPage();
		Page<CustOrderDto> page = custOrderService.findCustOrderPage(findCustOrderPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品定制订单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findCustOrders() throws TsfaServiceException{
		FindCustOrderPage findCustOrderPage = new FindCustOrderPage();
		List<CustOrderDto> page = custOrderService.findCustOrders(findCustOrderPage);
		Assert.assertNotNull(page);
		
	}
	
}
