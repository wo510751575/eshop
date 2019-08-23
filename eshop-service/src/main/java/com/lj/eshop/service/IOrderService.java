package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.AddrsDto;
import com.lj.eshop.dto.CatalogSummaryDto;
import com.lj.eshop.dto.FindOrderPage;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.OrderRetireDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.dto.ProductSkuDto;
import com.lj.eshop.dto.ShopCarDto;
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
public interface IOrderService {
	
	/**
	 * 
	 *
	 * 方法说明：添加订单信息
	 *
	 * @param orderDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addOrder(OrderDto orderDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找订单信息
	 *
	 * @param findOrder
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public OrderDto findOrder(OrderDto orderDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询订单信息
	 *
	 * @param findOrderPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<OrderDto>  findOrders(FindOrderPage findOrderPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改订单信息
	 *
	 * @param updateOrder
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateOrder(OrderDto orderDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询订单信息
	 *
	 * @param findOrderPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<OrderDto> findOrderPage(FindOrderPage findOrderPage) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 *	方法说明：创建订单根据购物车列表
	 *
	 * @param shopCarDtos	购物车列表
	 * @param addrsDto		收货地址
	 * @param isInvoice		是否需要发票
	 * @param invoiceTitle	发票抬头
	 * @param invoiceInfo	发票明细
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月28日
	 *
	 */
	public List<OrderDto> createByCar(List<ShopCarDto> shopCarDtos,AddrsDto addrsDto,boolean isInvoice, String invoiceTitle,String invoiceInfo,String remarks,String province,String city,String area);
	/**
	 * 
	 *
	 * 方法说明：确认订单
	 *
	 * @param orderDto
	 *
	 * @author 段志鹏 CreateDate: 2017年8月28日
	 *
	 */
	public void confirm(OrderDto orderDto);
	
	/**
	 * 
	 *
	 * 方法说明：完成订单
	 *
	 * @param order
	 *
	 * @author 段志鹏 CreateDate: 2017年8月28日
	 *
	 */
	public void complete(OrderDto orderDto);
	
	/**
	 * 
	 *
	 * 方法说明：取消订单
	 *
	 * @param orderDto
	 *
	 * @author 段志鹏 CreateDate: 2017年8月28日
	 *
	 */
	public void cancel(OrderDto orderDto);
	/**
	 * 
	 *
	 * 方法说明：订单支付
	 *
	 * @param orderDto	订单
	 * @param amt	支付金额
	 * @param payType	支付方式
	 *
	 * @author 段志鹏 CreateDate: 2017年8月28日
	 *
	 */
	public void payment(PaymentDto paymentDto);
	
	/**
	 * 
	 *
	 * 方法说明：订单退款
	 *
	 * @param orderDto
	 *
	 * @author 段志鹏 CreateDate: 2017年8月28日
	 *
	 */
	public void refunds(OrderDto orderDto);
	
	/**
	 * 
	 *
	 * 方法说明：订单发货
	 *
	 * @param orderDto
	 *
	 * @author 段志鹏 CreateDate: 2017年8月28日
	 *
	 */
	public void shipping(OrderDto orderDto,String expressNo,String expressName);
	/**
	 * 
	 *
	 * 方法说明：订单退货
	 *
	 * @param orderDto
	 * @param orderRetireDto
	 *
	 * @author 段志鹏 CreateDate: 2017年8月28日
	 *
	 */
	public void returns(OrderRetireDto orderRetireDto,String failReason);
	
	/**
	 * 
	 *
	 * 方法说明：创建订单
	 *
	 * @param paramSku		规格sku
	 * @param addrsDto		收货地址
	 * @param shopCode		店铺Code
	 * @param cnt			数量
	 * @param isInvoice		是否需要发票
	 * @param invoiceTitle	发票抬头
	 * @param invoiceInfo	发票明细
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月30日
	 *
	 */
	public OrderDto createOrder(ProductSkuDto productSkuDto,String shopCode,Integer cnt,AddrsDto addrsDto,boolean isInvoice, String invoiceTitle,String invoiceInfo,String remarks,String province,String city,String area);

	/**
	 * 
	 *
	 * 方法说明：分页查询
	 *
	 * @param findOrderPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月1日
	 *
	 */
	public Page<OrderDto> findOrderEisPage(FindOrderPage findOrderPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：累计订单金额
	 *
	 * @param findOrderPage
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月5日
	 *
	 */
	public BigDecimal findAmtSum(FindOrderPage findOrderPage)throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：统计订单量
	 *
	 * @param findOrderPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月5日
	 *
	 */
	public int findOrderPageCount(FindOrderPage findOrderPage)throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：根据订单号查找订单
	 *
	 * @param orderNo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月8日
	 *
	 */
	public OrderDto findOrderByOrderNo(String orderNo) throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：订单评价
	 *
	 * @param order
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月11日
	 *
	 */
	public void review(OrderDto orderDto) throws TsfaServiceException;

	/**
	 * 
	 * 方法说明： 商品统计
	 * @param @param orderDto
	 * @param @throws TsfaServiceException    设定文件 
	 * @return void    list
	 * @author 林进权
	 *         CreateDate: 2017年9月12日
	 */
	public List<CatalogSummaryDto> findProductCatalog(FindOrderPage findOrderPage) throws TsfaServiceException;

	/**
	 * 
	 * 方法说明： 获取店铺销售排名
	 * @param  loginShopCode 店铺code
	 * @throws TsfaServiceException    
	 * @return Integer  rank
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月13日
	 */
	public Integer findAmtRank(String loginShopCode) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：自动确认收货
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月15日
	 *
	 */
	public void autoReceipt() throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：自动好评
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月15日
	 *
	 */
	public void autoReview() throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据状态分组获取数量
	 *
	 * @param findOrderPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月20日
	 *
	 */
	public List<Map<String,Object>> findOrderGroupStatus(FindOrderPage findOrderPage)throws TsfaServiceException;
}
