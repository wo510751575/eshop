package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.DateUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.AddrsDto;
import com.lj.eshop.dto.CatalogSummaryDto;
import com.lj.eshop.dto.FindOrderPage;
import com.lj.eshop.dto.FindShopCarPage;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.ProductSkuDto;
import com.lj.eshop.dto.ShopCarDto;
import com.lj.eshop.emus.OrderInvoice;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.service.IAddrsService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IProductSkuService;
import com.lj.eshop.service.IShopCarService;

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
public class OrderServiceImplTest extends SpringTestCase{

	@Resource
	IOrderService orderService;
	@Resource
	IProductSkuService productSkuService;
	@Resource
	IAddrsService addrsService;
	@Resource
	IShopCarService shopCarService;
	


	/**
	 * 
	 *
	 * 方法说明：添加订单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addOrder() throws TsfaServiceException{
		OrderDto orderDto = new OrderDto();
		//add数据录入
		orderDto.setCode("Code");
		orderDto.setAmt(new BigDecimal(1));
		orderDto.setMbrCode("LJ_1eb863856573406c956c0478abf47a72");
		orderDto.setMbrName("小微");
		orderDto.setMbrPhone("MbrPhone");
		orderDto.setRevicerName("RevicerName");
		orderDto.setRevicePhone("RevicePhone");
		orderDto.setStatus(OrderStatus.UNSHIPPED.getValue());
		orderDto.setRemarks("Remarks");
		orderDto.setIsInvoice(OrderInvoice.Y.getValue());
		orderDto.setInvoiceTitle("InvoiceTitle");
		orderDto.setInvoiceInfo("InvoiceInfo");
		orderDto.setCreateTime(new Date());
		orderDto.setUpdateTime(new Date());
		orderDto.setOrderNo(NoUtil.generateNo(NoUtil.JY));
		orderDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
		orderDto.setMerchantCode("LJ_d0e8edca19bc445bbca254ddca6703d9");
		orderService.addOrder(orderDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改订单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateOrder() throws TsfaServiceException{
		OrderDto orderDto = new OrderDto();
		//update数据录入
		orderDto.setCode("Code");
		orderDto.setAmt(new BigDecimal(1));
		orderDto.setMbrCode("MbrCode");
		orderDto.setMbrName("MbrName");
		orderDto.setMbrPhone("MbrPhone");
		orderDto.setRevicerName("RevicerName");
		orderDto.setRevicePhone("RevicePhone");
		orderDto.setStatus("Status");
		orderDto.setRemarks("Remarks");
		orderDto.setIsInvoice("IsInvoice");
		orderDto.setInvoiceTitle("InvoiceTitle");
		orderDto.setInvoiceInfo("InvoiceInfo");
		orderDto.setCreateTime(new Date());
		orderDto.setUpdateTime(new Date());
		orderDto.setOrderNo("OrderNo");
		orderDto.setShopCode("ShopCode");

		orderService.updateOrder(orderDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrder() throws TsfaServiceException{
		OrderDto findOrder = new OrderDto();
		findOrder.setCode("LJ_42087387dc48478ebfb63692c668b008");
		OrderDto orderDto= orderService.findOrder(findOrder);
		System.out.println(orderDto.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrderPage() throws TsfaServiceException{
		OrderDto param = new OrderDto();
		param.setStatus(OrderStatus.UNPAID.getValue());
//		param.setMerchantCode("LJ_d0e8edca19bc445bbca254ddca6703d9");
		FindOrderPage findOrderPage = new FindOrderPage();
//		findOrderPage.setSortBy("create_time");
//		findOrderPage.setSortDir(PageSortType.desc);
		findOrderPage.setParam(param);
		Page<OrderDto> page = orderService.findOrderPage(findOrderPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找订单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findOrders() throws TsfaServiceException{
		FindOrderPage findOrderPage = new FindOrderPage();
		
		List<String> inStatuss = new LinkedList<String>();
//		inStatuss.add(OrderStatus.UNRETURNS.getValue());
//		inStatuss.add(OrderStatus.RETURNS.getValue());
//		findOrderPage.setInStatuss(inStatuss);
		
		List<OrderDto> page = orderService.findOrders(findOrderPage);
		System.out.println(page);
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：从购物车下单
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月5日
	 *
	 */
	@Test
	public void createByCar() throws TsfaServiceException{
		ShopCarDto param = new ShopCarDto();
		param.setMbrCode("LJ_1eb863856573406c956c0478abf47a72");
		FindShopCarPage findShopCarPage = new FindShopCarPage();
		findShopCarPage.setParam(param);
		List<ShopCarDto> carList = shopCarService.findShopCars(findShopCarPage);
		
		AddrsDto parmAddrsDto = new AddrsDto();
		parmAddrsDto.setCode("LJ_03a22325b5ca4ae9b2cbe1e8e3460e91");
		AddrsDto addrsDto= addrsService.findAddrs(parmAddrsDto);
		
		orderService.createByCar(carList, addrsDto, false, "", "","","","","");
	}
	
	/**
	 * 
	 *
	 * 方法说明：创建订单
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月5日
	 *
	 */
	@Test
	public void createOrder() throws TsfaServiceException{
//		for (int i = 0; i < 10; i++) {
//			ProductSkuDto productSkuDto = new ProductSkuDto();
//			productSkuDto.setCode("LJ_663f16e577de44a784055a5f9739066c");
//			AddrsDto paramDto = new AddrsDto();
//			paramDto.setCode("LJ_03a22325b5ca4ae9b2cbe1e8e3460e91");
//			orderService.createOrder(productSkuService.findProductSku(productSkuDto), "LJ_0e0a461585fa493794cc1368b87ec324", 1, addrsService.findAddrs(paramDto), true, "深圳市领居科技有限公司", "123546151222", "备注");
//		}
		
		ProductSkuDto productSkuDto = new ProductSkuDto();
		productSkuDto.setCode("LJ_c38f6f68539e4cd5a803458d2041210b");
		AddrsDto paramDto = new AddrsDto();
		paramDto.setCode("LJ_b6e033a1e275476f9bf2464eeb21cfd4");
		String shopCode ="LJ_0e0a461585fa493794cc1368b87ec324";
		orderService.createOrder(productSkuService.findProductSku(productSkuDto),shopCode, 1, addrsService.findAddrs(paramDto), true, "深圳市领居科技有限公司", "123546151222", "备注","","","");
	}
	
	/**
	 * 
	 *
	 * 方法说明：支付
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月5日
	 *
	 */
	@Test
	public void payment() throws TsfaServiceException{
		FindOrderPage findOrderPage = new FindOrderPage();
		OrderDto parOrder = new OrderDto();
		parOrder.setCode("LJ_eded58e823c042cf807df845afaa9052");
		findOrderPage.setParam(parOrder);
		List<OrderDto> orderDtos= orderService.findOrders(findOrderPage);
		
//		orderService.payment(paymentDto);;
	}
	
	/**
	 * 
	 *
	 * 方法说明：发货
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月5日
	 *
	 */
	@Test
	public void shipping() throws TsfaServiceException{
		OrderDto orderDto = new OrderDto();
		orderDto.setCode("LJ_6274cd5df2954b3ba447cac8edf4584c");
		orderService.shipping(orderDto, "111", "222");
	}
	
	@Test
	public void cancel() throws TsfaServiceException{
		OrderDto parmOrderDto = new OrderDto();
		parmOrderDto.setCode("LJ_28ebe1bc64f2440a844e8907be57c9c7");
		orderService.cancel(orderService.findOrder(parmOrderDto));
	}
	
	@Test
	public void findProductCatalog() throws TsfaServiceException{
		FindOrderPage findOrderPage = new FindOrderPage();
		OrderDto parOrder = new OrderDto();
		parOrder.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
		parOrder.setStartTime("2017-09-11 09:00:00");
		parOrder.setEndTime("2017-09-11 10:00:00");
		findOrderPage.setParam(parOrder);
		List<CatalogSummaryDto> list = orderService.findProductCatalog(findOrderPage);
		System.out.println(list);
	}
	
	@Test
	public void findOrderPageCount() throws TsfaServiceException{
		/*当天收益*/
		Date now =new Date();
		Calendar calendar =  org.apache.commons.lang.time.DateUtils.toCalendar(now);
		//将小时至0  
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		//将分钟至0  
		calendar.set(Calendar.MINUTE, 0);  
		//将秒至0  
		calendar.set(Calendar.SECOND,0);  
		Date startTime= calendar.getTime();
		
		//将小时至23  
		calendar.set(Calendar.HOUR_OF_DAY, 23);  
		//将分钟至59  
		calendar.set(Calendar.MINUTE, 59);  
		//将秒至59  
		calendar.set(Calendar.SECOND,59);  
		Date endTime= calendar.getTime();
		
		FindOrderPage findOrderPage = new FindOrderPage();
		OrderDto param = new OrderDto();
		param.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
		param.setStatus(OrderStatus.UNPAID.getValue());
//		param.setStartTime(DateUtils.formatDate(startTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
//		param.setEndTime(DateUtils.formatDate(endTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
		findOrderPage.setParam(param);
		int dayCount = orderService.findOrderPageCount(findOrderPage);
		System.out.println(dayCount);
	}
	
}
