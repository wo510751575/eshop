package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dao.IOrderDao;
import com.lj.eshop.domain.Order;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.AddrsDto;
import com.lj.eshop.dto.CatalogSummaryDto;
import com.lj.eshop.dto.EvlProductDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.dto.FindOrderDetailPage;
import com.lj.eshop.dto.FindOrderPage;
import com.lj.eshop.dto.FindOrderRetireDetailPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.dto.OrderDetailDto;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.OrderRetireDetailDto;
import com.lj.eshop.dto.OrderRetireDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.ProductRankPriceDto;
import com.lj.eshop.dto.ProductSkuDto;
import com.lj.eshop.dto.ShopCarDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.dto.SupplyDto;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.AuditStatus;
import com.lj.eshop.emus.MemberType;
import com.lj.eshop.emus.MessageTemplate;
import com.lj.eshop.emus.OrderInvoice;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IEvlProductService;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IMessageService;
import com.lj.eshop.service.IOrderDetailService;
import com.lj.eshop.service.IOrderRetireDetailService;
import com.lj.eshop.service.IOrderRetireService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IProductService;
import com.lj.eshop.service.IProductSkuService;
import com.lj.eshop.service.IShopCarService;
import com.lj.eshop.service.IShopService;
import com.lj.eshop.service.ISupplyService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author lhy
 * 
 * 
 *         CreateDate: 2017-08-22
 */
@Service
public class OrderServiceImpl implements IOrderService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Resource
	private IOrderDao orderDao;
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IProductSkuService productSkuService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IOrderDetailService orderDetailService;
	@Autowired
	private IShopCarService shopCarService;
	@Autowired
	private IAccWaterService accWaterService;
	@Autowired
	private IOrderRetireDetailService orderRetireDetailService;
	@Autowired
	private IOrderRetireService orderRetireService;
	@Autowired
	private ISupplyService supplyService;
	@Autowired
	private IShopService shopService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IMessageService messageService;
	@Autowired
	private IEvlProductService evlProductService;

	@Override
	public void addOrder(OrderDto orderDto) throws TsfaServiceException {
		logger.debug("addOrder(AddOrder addOrder={}) - start", orderDto);

		AssertUtils.notNull(orderDto);
		try {
			Order order = new Order();
			// add数据录入
			order.setCode(GUID.generateCode());
			order.setAmt(orderDto.getAmt());
			order.setMbrCode(orderDto.getMbrCode());
			order.setMbrName(orderDto.getMbrName());
			order.setMbrPhone(orderDto.getMbrPhone());
			order.setRevicerName(orderDto.getRevicerName());
			order.setRevicePhone(orderDto.getRevicePhone());
			order.setStatus(orderDto.getStatus());
			order.setRemarks(orderDto.getRemarks());
			order.setIsInvoice(orderDto.getIsInvoice());
			order.setInvoiceTitle(orderDto.getInvoiceTitle());
			order.setInvoiceInfo(orderDto.getInvoiceInfo());
			order.setCreateTime(new Date());
			order.setUpdateTime(new Date());
			order.setOrderNo(orderDto.getOrderNo());
			order.setShopCode(orderDto.getShopCode());
			order.setShopName(orderDto.getShopName());
			order.setExpressNo(orderDto.getExpressNo());
			order.setExpressName(orderDto.getExpressName());
			order.setPayType(orderDto.getPayType());
			order.setMerchantCode(orderDto.getMerchantCode());
			order.setPayTime(orderDto.getPayTime());
			order.setShippingTime(orderDto.getShippingTime());
			order.setAddrInfo(orderDto.getAddrInfo());
			order.setAreaName(orderDto.getAreaName());
			order.setReciverZip(orderDto.getReciverZip());
			order.setMbrType(orderDto.getMbrType());
			orderDao.insertSelective(order);
			/* 回写code，创建订单所需 */
			orderDto.setCode(order.getCode());
			logger.debug("addOrder(OrderDto) - end - return");
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增订单信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_ADD_ERROR, "新增订单信息错误！", e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：不分页查询订单信息
	 *
	 * @param findOrderPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<OrderDto> findOrders(FindOrderPage findOrderPage) throws TsfaServiceException {
		AssertUtils.notNull(findOrderPage);
		List<OrderDto> returnList = null;
		try {
			returnList = orderDao.findOrders(findOrderPage);
		} catch (Exception e) {
			logger.error("查找订单信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_NOT_EXIST_ERROR, "订单信息不存在");
		}
		return returnList;
	}

	@Override
	public void updateOrder(OrderDto orderDto) throws TsfaServiceException {
		logger.debug("updateOrder(OrderDto orderDto={}) - start", orderDto); //$NON-NLS-1$

		AssertUtils.notNull(orderDto);
		AssertUtils.notNullAndEmpty(orderDto.getCode(), "Code不能为空");
		try {
			Order order = new Order();
			// update数据录入
			order.setCode(orderDto.getCode());
			order.setAmt(orderDto.getAmt());
			order.setMbrCode(orderDto.getMbrCode());
			order.setMbrName(orderDto.getMbrName());
			order.setMbrPhone(orderDto.getMbrPhone());
			order.setStatus(orderDto.getStatus());
			order.setRemarks(orderDto.getRemarks());
			order.setIsInvoice(orderDto.getIsInvoice());
			order.setInvoiceTitle(orderDto.getInvoiceTitle());
			order.setInvoiceInfo(orderDto.getInvoiceInfo());
			order.setUpdateTime(new Date());
			order.setOrderNo(orderDto.getOrderNo());
			order.setShopCode(orderDto.getShopCode());
			order.setShopName(orderDto.getShopName());
			order.setExpressNo(orderDto.getExpressNo());
			order.setExpressName(orderDto.getExpressName());
			order.setPayType(orderDto.getPayType());
			order.setMerchantCode(orderDto.getMerchantCode());
			order.setPayTime(orderDto.getPayTime());
			order.setShippingTime(orderDto.getShippingTime());
			order.setRevicerName(orderDto.getRevicerName());
			order.setRevicePhone(orderDto.getRevicePhone());
			order.setAddrInfo(orderDto.getAddrInfo());
			order.setAreaName(orderDto.getAreaName());
			order.setReciverZip(orderDto.getReciverZip());
			AssertUtils.notUpdateMoreThanOne(orderDao.updateByPrimaryKeySelective(order));
			logger.debug("updateOrder(OrderDto) - end - return"); //$NON-NLS-1$
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("订单信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_UPDATE_ERROR, "订单信息更新信息错误！", e);
		}
	}

	@Override
	public OrderDto findOrder(OrderDto orderDto) throws TsfaServiceException {
		logger.debug("findOrder(FindOrder findOrder={}) - start", orderDto); //$NON-NLS-1$

		AssertUtils.notNull(orderDto);
		AssertUtils.notAllNull(orderDto.getCode(), "Code不能为空");
		try {
			Order order = orderDao.selectByPrimaryKey(orderDto.getCode());
			if (order == null) {
				return null;
				// throw new TsfaServiceException(ErrorCode.ORDER_NOT_EXIST_ERROR,"订单信息不存在");
			}
			OrderDto findOrderReturn = new OrderDto();
			// find数据录入
			findOrderReturn.setCode(order.getCode());
			findOrderReturn.setAmt(order.getAmt());
			findOrderReturn.setMbrCode(order.getMbrCode());
			findOrderReturn.setMbrName(order.getMbrName());
			findOrderReturn.setMbrPhone(order.getMbrPhone());
			findOrderReturn.setRevicerName(order.getRevicerName());
			findOrderReturn.setRevicePhone(order.getRevicePhone());
			findOrderReturn.setStatus(order.getStatus());
			findOrderReturn.setRemarks(order.getRemarks());
			findOrderReturn.setIsInvoice(order.getIsInvoice());
			findOrderReturn.setInvoiceTitle(order.getInvoiceTitle());
			findOrderReturn.setInvoiceInfo(order.getInvoiceInfo());
			findOrderReturn.setCreateTime(order.getCreateTime());
			findOrderReturn.setUpdateTime(order.getUpdateTime());
			findOrderReturn.setOrderNo(order.getOrderNo());
			findOrderReturn.setShopCode(order.getShopCode());
			findOrderReturn.setShopName(order.getShopName());
			findOrderReturn.setExpressNo(order.getExpressNo());
			findOrderReturn.setExpressName(order.getExpressName());
			findOrderReturn.setPayType(order.getPayType());
			findOrderReturn.setMerchantCode(order.getMerchantCode());
			findOrderReturn.setPayTime(order.getPayTime());
			findOrderReturn.setShippingTime(order.getShippingTime());
			findOrderReturn.setAddrInfo(order.getAddrInfo());
			findOrderReturn.setAreaName(order.getAreaName());
			findOrderReturn.setReciverZip(order.getReciverZip());
			logger.debug("findOrder(OrderDto) - end - return value={}", findOrderReturn); //$NON-NLS-1$
			return findOrderReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找订单信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_FIND_ERROR, "查找订单信息信息错误！", e);
		}

	}

	@Override
	public Page<OrderDto> findOrderPage(FindOrderPage findOrderPage) throws TsfaServiceException {
		logger.debug("findOrderPage(FindOrderPage findOrderPage={}) - start", findOrderPage); //$NON-NLS-1$

		AssertUtils.notNull(findOrderPage);
		List<OrderDto> returnList = null;
		int count = 0;
		try {
			count = orderDao.findOrderPageCount(findOrderPage);
			if (count > 0) {
				returnList = orderDao.findOrderPage(findOrderPage);
			}
		} catch (Exception e) {
			logger.error("订单信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.ORDER_FIND_PAGE_ERROR, "订单信息不存在错误.！", e);
		}
		Page<OrderDto> returnPage = new Page<OrderDto>(returnList, count, findOrderPage);

		logger.debug("findOrderPage(FindOrderPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	@Override
	public List<OrderDto> createByCar(List<ShopCarDto> shopCarDtos, AddrsDto addrsDto, boolean isInvoice,
			String invoiceTitle, String invoiceInfo, String remarks, String mbrType, String province, String city,
			String area) {
		logger.debug("createByCar(List<ShopCarDto> shopCarDtos={}) - start", shopCarDtos);
		AssertUtils.notNull(shopCarDtos);
		AssertUtils.notNull(addrsDto);
		AssertUtils.notNull(isInvoice, "发票标记不能为空");
		AssertUtils.notNullAndEmpty(addrsDto.getCode(), "收货地址编号不能为空");
		AssertUtils.notNullAndEmpty(shopCarDtos.get(0), "购物车列表不能为空");
		AssertUtils.notNullAndEmpty(shopCarDtos.get(0).getMbrCode(), "下单人编号不能为空");
		List<OrderDto> returnOrders = new ArrayList<OrderDto>();
		try {

			if (shopCarDtos != null && shopCarDtos.size() > 0) {
				/* 库存不足直接返回 */
				for (ShopCarDto shopCarDto : shopCarDtos) {
					/* 获取规格商品 */
					ProductSkuDto paramSkuDto = new ProductSkuDto();
					paramSkuDto.setCode(shopCarDto.getProductSkuCode());
					ProductSkuDto productSkuDto = productSkuService.findProductSku(paramSkuDto);
					if (productSkuDto.getCnt() == 0) {
						logger.error("库存不足！");
						throw new TsfaServiceException(ErrorCode.PRODUCT_LOWSTOCK_ERROR, "库存不足！");
					} else if (productSkuDto.getCnt() - shopCarDto.getCnt() < 0) {
						logger.error("库存不足！");
						throw new TsfaServiceException(ErrorCode.PRODUCT_LOWSTOCK_ERROR, "库存不足！");
					}
				}

//				String shopCodeTmp = "";
				String orderNo = NoUtil.generateNo(NoUtil.JY);
				MemberDto param = new MemberDto();
				param.setCode(shopCarDtos.get(0).getMbrCode());
				MemberDto member = memberService.findMember(param);

				/* 赋值临时变量 */
				OrderDto orderDto = new OrderDto();
				orderDto.setMbrCode(shopCarDtos.get(0).getMbrCode());
				orderDto.setMbrName(member.getName());

				/* 收货地址 */
				orderDto.setRevicerName(addrsDto.getReciverName());
				orderDto.setRevicePhone(addrsDto.getReciverPhone());
				orderDto.setAddrInfo(addrsDto.getAddrDetail());
				String areaName = province + city + area;
				orderDto.setAreaName(areaName);
				orderDto.setReciverZip(addrsDto.getReciverZip());

				orderDto.setMbrPhone(member.getPhone());
				orderDto.setRevicerName(addrsDto.getReciverName());
				orderDto.setRevicePhone(addrsDto.getReciverPhone());
				orderDto.setStatus(OrderStatus.UNPAID.getValue());
				orderDto.setMerchantCode(member.getMerchantCode());
				if (isInvoice) {
					orderDto.setIsInvoice(OrderInvoice.Y.getValue());
					orderDto.setInvoiceTitle(invoiceTitle);
					orderDto.setInvoiceInfo(invoiceInfo);
				} else {
					orderDto.setIsInvoice(OrderInvoice.N.getValue());
				}
//				orderDto.setShopCode(shopCarDto.getShopCode());
//				orderDto.setShopName(shopDto.getShopName());

				orderDto.setOrderNo(orderNo);
				orderDto.setRemarks(remarks);
				orderDto.setMbrType(mbrType);
				this.addOrder(orderDto);
				returnOrders.add(orderDto);

				// 遍历购物车列表
				for (ShopCarDto shopCarDto : shopCarDtos) {

					/* 店铺关闭状态不允许下单 */
					/*
					 * ShopDto parmShopDto = new ShopDto();
					 * parmShopDto.setCode(shopCarDto.getShopCode()); ShopDto shopDto =
					 * shopService.findShop(parmShopDto); if
					 * (shopDto.getStatus().equals(ShopStatus.STOP.getValue())) { continue; }
					 */

					/* 根据店铺创建订单 */
					/*
					 * if (!shopCodeTmp.equals(shopCarDto.getShopCode())) { 赋值临时变量 shopCodeTmp =
					 * shopCarDto.getShopCode(); OrderDto orderDto = new OrderDto();
					 * orderDto.setMbrCode(shopCarDto.getMbrCode());
					 * orderDto.setMbrName(member.getName());
					 * 
					 * 收货地址 orderDto.setRevicerName(addrsDto.getReciverName());
					 * orderDto.setRevicePhone(addrsDto.getReciverPhone());
					 * orderDto.setAddrInfo(addrsDto.getAddrDetail()); String areaName = province +
					 * city + area; orderDto.setAreaName(areaName);
					 * orderDto.setReciverZip(addrsDto.getReciverZip());
					 * 
					 * orderDto.setMbrPhone(member.getPhone());
					 * orderDto.setRevicerName(addrsDto.getReciverName());
					 * orderDto.setRevicePhone(addrsDto.getReciverPhone());
					 * orderDto.setStatus(OrderStatus.UNPAID.getValue());
					 * orderDto.setMerchantCode(member.getMerchantCode()); if (isInvoice) {
					 * orderDto.setIsInvoice(OrderInvoice.Y.getValue());
					 * orderDto.setInvoiceTitle(invoiceTitle); orderDto.setInvoiceInfo(invoiceInfo);
					 * } else { orderDto.setIsInvoice(OrderInvoice.N.getValue()); } //
					 * orderDto.setShopCode(shopCarDto.getShopCode()); //
					 * orderDto.setShopName(shopDto.getShopName()); orderNo =
					 * NoUtil.generateNo(NoUtil.JY); orderDto.setOrderNo(orderNo);
					 * orderDto.setRemarks(remarks); this.addOrder(orderDto);
					 * returnOrders.add(orderDto); }
					 */

					/* 创建订单子项 */
					OrderDetailDto detailDto = new OrderDetailDto();

					/* 获取商品 */
					ProductDto paramPro = new ProductDto();
					paramPro.setCode(shopCarDto.getProductCode());
					ProductDto productDto = productService.findProduct(paramPro);

					/* 获取商品规格价格 */
					ProductSkuDto paramSku = new ProductSkuDto();
					paramSku.setCode(shopCarDto.getProductSkuCode());
					ProductSkuDto productSkuDto = productSkuService.findProductSku(paramSku);

					// 获取商品售价-根据特权
					BigDecimal salePrice = productSkuDto.getSalePrice();
					BigDecimal gapPrice = new BigDecimal(0);
					if (productSkuDto.getRankPriceDtos() != null && productSkuDto.getRankPriceDtos().size() > 0) {
						for (ProductRankPriceDto rankPriceDto : productSkuDto.getRankPriceDtos()) {

							if (MemberType.CLIENT.getValue().equalsIgnoreCase(mbrType)) {
								MemberDto memb = new MemberDto();
								memb.setCode(member.getMyInvite());
								MemberDto memberReturn = memberService.findMember(memb);
								if (rankPriceDto.getRankCode().equals(memberReturn.getMemberRankCode())) {
									gapPrice = productSkuDto.getSalePrice().subtract(rankPriceDto.getRankPrice());
									break;
								}
							} else {
								if (rankPriceDto.getRankCode().equals(member.getMemberRankCode())) {
									salePrice = rankPriceDto.getRankPrice();
									break;
								}
							}

						}
					}

					/* 获取商品供应商 */
					SupplyDto paramSupply = new SupplyDto();
					paramSupply.setCode(productDto.getSupplyCode());
//					SupplyDto supplyDto = supplyService.findSupply(paramSupply);

					detailDto.setProductCode(shopCarDto.getProductCode());
					detailDto.setProductName(shopCarDto.getProductName());
					detailDto.setSupplyCode(productDto.getSupplyCode());
					detailDto.setSupplyName(productDto.getSupplyName());
					detailDto.setCnt(shopCarDto.getCnt());
					/* C端售价*数量 */
					detailDto.setAmt(salePrice.multiply(new BigDecimal(shopCarDto.getCnt())));
					detailDto.setSalePrice(salePrice); // C端单个售价
//					BigDecimal disCount = new BigDecimal(supplyDto.getDiscountOff()); // 供应商折扣（0-100的数字）
//					detailDto.setOrgPrice(productSkuDto.getSalePrice().multiply(disCount).divide(new BigDecimal(100))
//							.add(productSkuDto.getSalePrice())); // 小B进货单价（按供应商折扣计算）
					detailDto.setGapPrice(gapPrice); // 小B提成单价（按供应商折扣计算）
					detailDto.setOrderNo(orderNo);
					detailDto.setSkuCode(productSkuDto.getCode());
					orderDetailService.addOrderDetail(detailDto);

					/* 移除购物车 */
					shopCarService.deleteShopCar(shopCarDto.getCode());

					/* 扣除商品库存 */
					productDto.setCnt(productDto.getCnt() - shopCarDto.getCnt());
					productService.updateProduct(productDto);

					/* 扣除规格商品库存 */
					productSkuDto.setCnt(productSkuDto.getCnt() - shopCarDto.getCnt());
					productSkuService.updateProductSku(productSkuDto);
				}

				/* 回写订单总额 */
				for (OrderDto orderDto2 : returnOrders) {
					/* 计算订单子项总额 */
					BigDecimal amt = new BigDecimal(0);
					OrderDetailDto paramDetailDto = new OrderDetailDto();
					paramDetailDto.setOrderNo(orderDto2.getOrderNo());
					FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
					findOrderDetailPage.setParam(paramDetailDto);
					List<OrderDetailDto> list = orderDetailService.findOrderDetails(findOrderDetailPage);
					if (list.size() > 0) {
						Iterator<OrderDetailDto> localIterator = list.iterator();
						while (localIterator.hasNext()) {
							OrderDetailDto item = localIterator.next();
							if ((item != null) && (item.getAmt() != null)) {
								amt = amt.add(item.getAmt());
							}
						}
					}
					orderDto2.setAmt(amt);
					this.updateOrder(orderDto2);
				}
			}

			/* 消息通知 */
			sendMessageByOrder(returnOrders, MessageTemplate.B_SERVICE_ORDER_BILL_NON_PAYMENT);

			logger.debug("createByCar(returnOrders) - end - return={}", returnOrders);
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增订单信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_ADD_ERROR, "新增订单信息错误！", e);
		}
		return returnOrders;
	}

	@Override
	public void confirm(OrderDto orderDto) {

	}

	@Override
	public void complete(OrderDto orderDto) {
		logger.debug("complete(OrderDto orderDto={}) - start", orderDto);
		AssertUtils.notNull(orderDto);
		AssertUtils.notNullAndEmpty(orderDto.getOrderNo(), "订单编号不能为空");
//		AssertUtils.notNullAndEmpty(orderDto.getShopCode(), "店铺编号不能为空");
		try {
			if (!orderDto.getStatus().equals(OrderStatus.SHIPPED.getValue())) {
				return;
			}

			/* 店主提成--计算订单子项提成总额 */
			BigDecimal gapPrice = new BigDecimal(0);
			/* 订单总额 */
			BigDecimal amt = new BigDecimal(0);
			OrderDetailDto paramDetailDto = new OrderDetailDto();
			paramDetailDto.setOrderNo(orderDto.getOrderNo());
			FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
			findOrderDetailPage.setParam(paramDetailDto);
			List<OrderDetailDto> detailList = orderDetailService.findOrderDetails(findOrderDetailPage);
			if (detailList.size() > 0) {
				Iterator<OrderDetailDto> localIterator = detailList.iterator();
				while (localIterator.hasNext()) {
					OrderDetailDto item = localIterator.next();
					/* 计算提成 */
					if ((item != null) && (item.getGapPrice() != null) && (item.getCnt() != null)) {
						gapPrice = gapPrice
								.add(item.getGapPrice().multiply(new BigDecimal(item.getCnt() - item.getReturnCnt())));
					}
					/* 计算订单金额 */
					if ((item != null) && (item.getAmt() != null) && (item.getReturnCnt() != null)
							&& (item.getSalePrice() != null)) {
						amt = amt.add(item.getAmt()
								.subtract(item.getSalePrice().multiply(new BigDecimal(item.getReturnCnt()))));
					}

					/* 记录商品销量 */
					if ((item != null) && (item.getProductCode() != null) && (item.getCnt() != null)) {
						ProductDto parmProductDto = new ProductDto();
						parmProductDto.setCode(item.getProductCode());
						ProductDto productDto = productService.findProduct(parmProductDto);
						productDto.setSaleCnt(productDto.getSaleCnt() + item.getCnt());
						productService.updateProduct(productDto);
					}
				}
			}

			/* 店主提成-店主账户增加提成金额 */
			/* 获取店铺 */
			/*
			 * ShopDto parmShop = new ShopDto(); parmShop.setCode(orderDto.getShopCode());
			 * ShopDto shopDto = shopService.findShop(parmShop);
			 */

			/* 特权订单没有提成 */
//			if (!orderDto.getPayType().equals(AccWaterPayType.RANK.getValue())) {
			MemberDto memberDto = new MemberDto();
			memberDto.setCode(orderDto.getMbrCode());
			MemberDto dto = memberService.findMember(memberDto);
			/* 获取上级账户，当前下单会员是买家C端才给上级提成-增加提成 */
			if (MemberType.CLIENT.getValue().equals(dto.getType()) && StringUtils.isNotEmpty(dto.getMyInvite())) {
				AccountDto accountDto = accountService.findAccountByMbrCode(dto.getMyInvite());
				BigDecimal beforeAmt = accountDto.getCashAmt();
				accountDto.setCashAmt(accountDto.getCashAmt().add(gapPrice));
				BigDecimal afterAmt = accountDto.getCashAmt();
				accountService.updateAccount(accountDto);

				/* 记录账户流水 */
				AccWaterDto accWaterDto = new AccWaterDto();
				accWaterDto.setAccDate(new Date());
				accWaterDto.setAccSource(AccWaterSource.COMMISSION.getValue());
				accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
				accWaterDto.setAmt(gapPrice);
				accWaterDto.setAccNo(accountDto.getAccNo());
				accWaterDto.setAccCode(accountDto.getCode());
				accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
				accWaterDto.setPayType(AccWaterPayType.VIRTUAL.getValue());
				accWaterDto.setBeforeAmt(beforeAmt);
				accWaterDto.setAfterAmt(afterAmt);
				accWaterDto.setBizType(AccWaterBizType.COMMISSION.getValue());
				accWaterDto.setWaterType(AccWaterType.ADD.getValue());
				accWaterDto.setTranOrderNo(orderDto.getOrderNo());
				accWaterService.addAccWater(accWaterDto);
			}
//			}

			/* 记录会员历史花销 */
			/* 获取会员账户-增加花销 */
			AccountDto accountDto = accountService.findAccountByMbrCode(orderDto.getMbrCode());
			accountDto.setPayedAmount(accountDto.getPayedAmount().add(amt));
			accountService.updateAccount(accountDto);

			/* 状态流转至待评价 */
			orderDto.setStatus(OrderStatus.UNEVL.getValue());
			this.updateOrder(orderDto);
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("订单发货错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_SHIPPED_ERROR, "订单发货错误！", e);
		}

	}

	@Override
	public void cancel(OrderDto orderDto) {
		logger.debug("cancel(OrderDto orderDto={}) - start", orderDto);
		AssertUtils.notNull(orderDto);
		AssertUtils.notNullAndEmpty(orderDto.getOrderNo(), "订单编号不能为空");
		try {
			if (orderDto.getStatus().equals(OrderStatus.CANCEL.getValue())) {
				return;
			}
			/* 库存回归 */
			OrderDetailDto param = new OrderDetailDto();
			param.setOrderNo(orderDto.getOrderNo());
			FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
			findOrderDetailPage.setParam(param);
			List<OrderDetailDto> detailDtos = orderDetailService.findOrderDetails(findOrderDetailPage);
			for (OrderDetailDto orderDetailDto : detailDtos) {
				/* 获取商品 */
				ProductDto paramPro = new ProductDto();
				paramPro.setCode(orderDetailDto.getProductCode());
				ProductDto productDto = productService.findProduct(paramPro);

				/* 获取商品规格 */
				ProductSkuDto paramSku = new ProductSkuDto();
				paramSku.setCode(orderDetailDto.getSkuCode());
				ProductSkuDto productSkuDto = productSkuService.findProductSku(paramSku);

				/* 增加商品库存 */
				productDto.setCnt(productDto.getCnt() + orderDetailDto.getCnt());
				productService.updateProduct(productDto);

				/* 增加规格商品库存 */
				productSkuDto.setCnt(productSkuDto.getCnt() + orderDetailDto.getCnt());
				productSkuService.updateProductSku(productSkuDto);

			}

			/* 状态流转至已取消 */
			orderDto.setStatus(OrderStatus.CANCEL.getValue());
			this.updateOrder(orderDto);

		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("订单取消错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_CANCEL_ERROR, "订单取消错误！", e);
		}

	}

	@Override
	public void payment(PaymentDto paymentDto) {
		logger.debug("payment(PaymentDto paymentDto={}) - start", paymentDto);
		AssertUtils.notNull(paymentDto);
		AssertUtils.notNull(paymentDto.getAmount(), "支付金额不能为空");
		AssertUtils.notNullAndEmpty(paymentDto.getAccCode(), "账户编号不能为空");
		AssertUtils.notNullAndEmpty(paymentDto.getBizNo(), "订单号不能为空");
		AssertUtils.notNullAndEmpty(paymentDto.getPaymentMethod(), "支付方式不能为空");
		try {
			/* 获取订单 */
			OrderDto orderDto = this.findOrderByOrderNo(paymentDto.getBizNo());

			if (orderDto.getAmt().compareTo(paymentDto.getAmount()) <= 0) {

				/* 状态流转至待发货 */
				orderDto.setStatus(OrderStatus.UNSHIPPED.getValue());
				orderDto.setPayType(paymentDto.getPaymentMethod());
				orderDto.setPayTime(new Date());
				this.updateOrder(orderDto);

				/* 获取账户 */
				AccountDto parmAccountDto = new AccountDto();
				parmAccountDto.setCode(paymentDto.getAccCode());
				AccountDto accountDto = accountService.findAccount(parmAccountDto);

				if (paymentDto.getPaymentMethod().equals(AccWaterPayType.RANK.getValue())) {
					if (accountDto.getRankCashAmt().compareTo(orderDto.getAmt()) < 0) {
						logger.error("特权额度不足！");
						throw new TsfaServiceException(ErrorCode.ORDER_PAYMENT_ERROR, "特权额度不足！");
					}
					BigDecimal beforeAmt = accountDto.getRankCashAmt();
					accountDto.setRankCashAmt(accountDto.getRankCashAmt().subtract(orderDto.getAmt()));
					BigDecimal afterAmt = accountDto.getRankCashAmt();
					accountService.updateAccount(accountDto);

					/* 记录账户流水 */
					AccWaterDto accWaterDto = new AccWaterDto();
					accWaterDto.setAccDate(new Date());
					accWaterDto.setAccSource(AccWaterSource.ORDER.getValue());
					accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
					accWaterDto.setAmt(paymentDto.getAmount());
					accWaterDto.setAccNo(accountDto.getAccNo());
					accWaterDto.setAccCode(accountDto.getCode());
					accWaterDto.setBeforeAmt(beforeAmt);
					accWaterDto.setAfterAmt(afterAmt);
					accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
					accWaterDto.setPayType(paymentDto.getPaymentMethod());
					accWaterDto.setBizType(AccWaterBizType.PAYMENT.getValue());
					accWaterDto.setWaterType(AccWaterType.SUBTRACT.getValue());
					accWaterDto.setTranOrderNo(orderDto.getOrderNo());
					accWaterService.addAccWater(accWaterDto);
				} else {

					/* 记录账户流水 */
					AccWaterDto accWaterDto = new AccWaterDto();
					accWaterDto.setAccDate(new Date());
					accWaterDto.setAccSource(AccWaterSource.ORDER.getValue());
					accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
					accWaterDto.setAmt(paymentDto.getAmount());
					accWaterDto.setAccNo(accountDto.getAccNo());
					accWaterDto.setAccCode(accountDto.getCode());
					accWaterDto.setBeforeAmt(new BigDecimal(0));
					accWaterDto.setAfterAmt(paymentDto.getAmount());
					accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
					accWaterDto.setPayType(paymentDto.getPaymentMethod());
					accWaterDto.setBizType(AccWaterBizType.PAYMENT.getValue());
					accWaterDto.setWaterType(AccWaterType.SUBTRACT.getValue());
					accWaterDto.setTranOrderNo(orderDto.getOrderNo());
					accWaterService.addAccWater(accWaterDto);
				}

				/* 消息通知 */
				sendMessageByOrder(orderDto, MessageTemplate.B_SERVICE_ORDER_BILL_PAYMENTED);
				sendMessageByOrder(orderDto, MessageTemplate.C_SERVICE_ORDER_BILL_PAYMENTED, orderDto.getMbrCode());
			}
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("订单支付错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_PAYMENT_ERROR, "订单支付错误！", e);
		}

	}

	@Override
	public void refunds(OrderDto orderDto) {
		// TODO 预留退款接口

	}

	@Override
	public void shipping(OrderDto orderDto, String expressNo, String expressName) {
		logger.debug("shipping(OrderDto orderDto={}) - start", orderDto);
		AssertUtils.notNull(orderDto);
		AssertUtils.notNullAndEmpty(orderDto.getCode(), "订单编号不能为空");
		try {

			if (orderDto != null && orderDto.getStatus().equals(OrderStatus.UNSHIPPED.getValue())) {
				/* 状态流转至待收货 */
				orderDto.setStatus(OrderStatus.SHIPPED.getValue());
				orderDto.setExpressNo(expressNo);
				orderDto.setExpressName(expressName);
				orderDto.setShippingTime(new Date());
				this.updateOrder(orderDto);
				/* 消息通知 */
				OrderDto paramOrder = new OrderDto();
				paramOrder.setCode(orderDto.getCode());
				OrderDto returnOrders = findOrder(paramOrder);
				sendMessageByOrder(returnOrders, MessageTemplate.C_SYS_COMMODITY_SENDED, returnOrders.getMbrCode());
			}
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("订单发货错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_SHIPPED_ERROR, "订单发货错误！", e);
		}
	}

	@Override
	public void returns(OrderRetireDto orderRetireDto, String failReason) {
		logger.debug("returns(OrderRetireDto orderRetireDto={}) - start", orderRetireDto);
		logger.debug("returns(String failReason={}) - start", failReason);
		AssertUtils.notNull(orderRetireDto);
		AssertUtils.notNullAndEmpty(orderRetireDto.getCode(), "退货编号不能为空");
		AssertUtils.notNullAndEmpty(orderRetireDto.getOrderNo(), "订单号不能为空");
		AssertUtils.notNullAndEmpty(orderRetireDto.getRetireNo(), "退货单号不能为空");
		try {
			/* 审核成功 */
			if (orderRetireDto.getAuditStatus().equals(AuditStatus.SUCCESS.getValue())) {
				OrderDto param = new OrderDto();
				param.setOrderNo(orderRetireDto.getOrderNo());
				FindOrderPage findOrderPage = new FindOrderPage();
				findOrderPage.setParam(param);
				/* 获取订单 */
				List<OrderDto> orderList = this.findOrders(findOrderPage);
				if (orderList.size() <= 0) {
					logger.error("订单不存在！");
					throw new TsfaServiceException(ErrorCode.ORDER_DETAIL_NOT_EXIST_ERROR, "订单不存在！");
				}
				OrderDto orderDto = orderList.get(0);
				String orderMbrCode = orderDto.getMbrCode();

				/* 获取退货 */
				OrderRetireDto parmRetireDto = new OrderRetireDto();
				parmRetireDto.setCode(orderRetireDto.getCode());
				OrderRetireDto retireDto = orderRetireService.findOrderRetire(parmRetireDto);

				/* 获取退货明细 */
				OrderRetireDetailDto paramRetire = new OrderRetireDetailDto();
				paramRetire.setRetireNo(orderRetireDto.getRetireNo());
				FindOrderRetireDetailPage findOrderRetireDetailPage = new FindOrderRetireDetailPage();
				findOrderRetireDetailPage.setParam(paramRetire);
				List<OrderRetireDetailDto> retireDetailList = orderRetireDetailService
						.findOrderRetireDetails(findOrderRetireDetailPage);
				BigDecimal returnAmt = retireDto.getAmt(); // 退款总额
				BigDecimal gapPrice = new BigDecimal(0); // 提成
				for (OrderRetireDetailDto orderRetireDetailDto : retireDetailList) {
					/* 获取订单子项，修改订单子项退货数量 */
					OrderDetailDto orderDetailParam = new OrderDetailDto();
					orderDetailParam.setCode(orderRetireDetailDto.getOrderDetailCode());
					OrderDetailDto orderDetailDto = orderDetailService.findOrderDetail(orderDetailParam);
					if (orderDetailDto != null) {
						orderDetailDto.setReturnCnt(Integer.valueOf(
								orderDetailDto.getReturnCnt().intValue() + orderRetireDetailDto.getCnt().intValue()));
					}
					orderDetailService.updateOrderDetail(orderDetailDto);

					/* 获取商品 */
					ProductDto paramPro = new ProductDto();
					paramPro.setCode(orderDetailDto.getProductCode());
					ProductDto productDto = productService.findProduct(paramPro);
					/* 修改商品库存 */
					productDto.setCnt(productDto.getCnt() + orderRetireDetailDto.getCnt());
					productService.updateProduct(productDto);

					/* 获取商品规格 */
					ProductSkuDto paramSku = new ProductSkuDto();
					paramSku.setCode(orderDetailDto.getSkuCode());
					ProductSkuDto productSkuDto = productSkuService.findProductSku(paramSku);
					/* 增加规格商品库存 */
					productSkuDto.setCnt(productSkuDto.getCnt() + orderRetireDetailDto.getCnt());
					productSkuService.updateProductSku(productSkuDto);

					/* 计算提成 */
					if ((orderDetailDto != null) && (orderDetailDto.getGapPrice() != null)
							&& (orderRetireDetailDto.getCnt() != null)) {
						gapPrice = gapPrice.add(
								orderDetailDto.getGapPrice().multiply(new BigDecimal(orderRetireDetailDto.getCnt())));
					}

				}

				/* 获取会员账户 */
				AccountDto accountDto = accountService.findAccountByMbrCode(orderDto.getMbrCode());

				/* 特权订单,返回特权额度/其它订单返回到账户余额 */
				if (orderDto.getPayType().equals(AccWaterPayType.RANK.getValue())) {
					BigDecimal beforeAmt = accountDto.getRankCashAmt();
					accountDto.setRankCashAmt(accountDto.getRankCashAmt().add(returnAmt));
					BigDecimal afterAmt = accountDto.getRankCashAmt();
					/* 减去历史花销 */
					accountDto.setPayedAmount(accountDto.getPayedAmount().subtract(returnAmt));
					accountService.updateAccount(accountDto);

					/* 记录账户流水 */
					AccWaterDto accWaterDto = new AccWaterDto();
					accWaterDto.setAccDate(new Date());
					accWaterDto.setAccSource(AccWaterSource.ORDER.getValue());
					accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
					accWaterDto.setAmt(returnAmt);
					accWaterDto.setAccNo(accountDto.getAccNo());
					accWaterDto.setAccCode(accountDto.getCode());
					accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
					accWaterDto.setPayType(AccWaterPayType.RANK.getValue());
					accWaterDto.setBeforeAmt(beforeAmt);
					accWaterDto.setAfterAmt(afterAmt);
					accWaterDto.setBizType(AccWaterBizType.REFUND.getValue());
					accWaterDto.setOpCode(orderRetireDto.getAuditor());
					accWaterDto.setWaterType(AccWaterType.ADD.getValue());
					accWaterDto.setTranOrderNo(orderDto.getOrderNo());
					accWaterService.addAccWater(accWaterDto);

				} else {
					BigDecimal beforeAmt = accountDto.getCashAmt();
					accountDto.setCashAmt(accountDto.getCashAmt().add(returnAmt));
					BigDecimal afterAmt = accountDto.getCashAmt();
					/* 减去历史花销 */
					accountDto.setPayedAmount(accountDto.getPayedAmount().subtract(returnAmt));
					accountService.updateAccount(accountDto);

					/* 记录账户流水 */
					AccWaterDto accWaterDto = new AccWaterDto();
					accWaterDto.setAccDate(new Date());
					accWaterDto.setAccSource(AccWaterSource.ORDER.getValue());
					accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
					accWaterDto.setAmt(returnAmt);
					accWaterDto.setAccNo(accountDto.getAccNo());
					accWaterDto.setAccCode(accountDto.getCode());
					accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
					accWaterDto.setPayType(AccWaterPayType.VIRTUAL.getValue());
					accWaterDto.setBeforeAmt(beforeAmt);
					accWaterDto.setAfterAmt(afterAmt);
					accWaterDto.setBizType(AccWaterBizType.REFUND.getValue());
					accWaterDto.setOpCode(orderRetireDto.getAuditor());
					accWaterDto.setWaterType(AccWaterType.ADD.getValue());
					accWaterDto.setTranOrderNo(orderDto.getOrderNo());
					accWaterService.addAccWater(accWaterDto);

					/* 获取店主 */
					ShopDto parmShopDto = new ShopDto();
					parmShopDto.setCode(orderDto.getShopCode());
					ShopDto shopDto = shopService.findShop(parmShopDto);

					/* 获取店主账户-减去提成 */
					AccountDto accountDtoShop = accountService.findAccountByMbrCode(shopDto.getMbrCode());
					// 查找是否分配过提成
					AccWaterDto paramAccWater = new AccWaterDto();
					paramAccWater.setAccSource(AccWaterSource.COMMISSION.getValue());
					paramAccWater.setAccType(AccWaterAccType.AUTO.getValue());
					paramAccWater.setAccCode(accountDtoShop.getCode());
					paramAccWater.setStatus(AccWaterStatus.SUCCESS.getValue());
					paramAccWater.setPayType(AccWaterPayType.VIRTUAL.getValue());
					paramAccWater.setBizType(AccWaterBizType.COMMISSION.getValue());
					paramAccWater.setWaterType(AccWaterType.ADD.getValue());
					paramAccWater.setTranOrderNo(orderDto.getOrderNo());
					FindAccWaterPage findAccWaterPage = new FindAccWaterPage();
					findAccWaterPage.setParam(paramAccWater);
					List<AccWaterDto> datas = accWaterService.findAccWaters(findAccWaterPage);
					if (datas != null && datas.size() > 0) {// 订单分配过提成才退提成
						BigDecimal beforeAmtShop = accountDtoShop.getCashAmt();
						accountDtoShop.setCashAmt(accountDtoShop.getCashAmt().subtract(gapPrice));
						BigDecimal afterAmtShop = accountDtoShop.getCashAmt();
						accountService.updateAccount(accountDtoShop);
						/* 记录账户流水 */
						accWaterDto = new AccWaterDto();
						accWaterDto.setAccDate(new Date());
						accWaterDto.setAccSource(AccWaterSource.COMMISSION.getValue());
						accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
						accWaterDto.setAmt(gapPrice);
						accWaterDto.setAccNo(accountDtoShop.getAccNo());
						accWaterDto.setAccCode(accountDtoShop.getCode());
						accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
						accWaterDto.setPayType(AccWaterPayType.VIRTUAL.getValue());
						accWaterDto.setBeforeAmt(beforeAmtShop);
						accWaterDto.setAfterAmt(afterAmtShop);
						accWaterDto.setBizType(AccWaterBizType.COMMISSION.getValue());
						accWaterDto.setWaterType(AccWaterType.SUBTRACT.getValue());
						accWaterDto.setTranOrderNo(orderDto.getOrderNo());
						accWaterService.addAccWater(accWaterDto);
					}
				}

				/* 状态流转至退货成功 */
				orderDto.setStatus(OrderStatus.RETURNS.getValue());
				this.updateOrder(orderDto);

				/* 审核通过 */
				orderRetireDto.setUpdateTime(new Date());
				orderRetireService.updateOrderRetire(orderRetireDto);

				/* 审核失败 */

				/* 消息通知 */
				sendMessageByRetire(retireDetailList, orderMbrCode);

			} else if (orderRetireDto.getAuditStatus().equals(AuditStatus.FAIL.getValue())) {
				orderRetireDto.setFailReason(failReason);
				orderRetireService.updateOrderRetire(orderRetireDto);
			}

		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("订单退货错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETURNS_ERROR, "订单退货错误！", e);
		}
	}

	@Override
	public OrderDto createOrder(ProductSkuDto paramSku, String shopCode, Integer cnt, AddrsDto addrsDto,
			boolean isInvoice, String invoiceTitle, String invoiceInfo, String remarks, String mbrType, String province,
			String city, String area) {
		logger.debug("createByCar(ProductSkuDto paramSku={}) - start", paramSku);
		logger.debug("createByCar(AddrsDto addrsDto={}) - start", addrsDto);
		AssertUtils.notNull(paramSku);
		AssertUtils.notNull(addrsDto);
		AssertUtils.notNull(isInvoice, "发票标记不能为空");
		AssertUtils.notNullAndEmpty(addrsDto.getCode(), "收货地址编号不能为空");
		AssertUtils.notNullAndEmpty(paramSku.getCode(), "规格编号不能为空");
		AssertUtils.notNullAndEmpty(addrsDto.getMbrCode(), "下单人编号不能为空");
		AssertUtils.notNull(cnt, "数量不能为空");

		OrderDto orderDto = new OrderDto();
		try {
			/* 获取店铺 */
			/*
			 * ShopDto paramShop = new ShopDto(); paramShop.setCode(shopCode); ShopDto
			 * shopDto= shopService.findShop(paramShop);
			 * if(shopDto.getStatus().equals(ShopStatus.STOP.getValue())){
			 * logger.error("店铺已关闭！"); throw new
			 * TsfaServiceException(ErrorCode.SHOP_STOP_ERROR,"店铺已关闭！"); }
			 */

			/* 库存不足直接返回 */
			if (paramSku.getCnt() == 0) {
				logger.error("库存不足！");
				throw new TsfaServiceException(ErrorCode.PRODUCT_LOWSTOCK_ERROR, "库存不足！");
			} else if (paramSku.getCnt() - cnt < 0) {
				logger.error("库存不足！");
				throw new TsfaServiceException(ErrorCode.PRODUCT_LOWSTOCK_ERROR, "库存不足！");
			}

			/* 获取商品 */
			ProductDto paramPro = new ProductDto();
			paramPro.setCode(paramSku.getProductCode());
			ProductDto productDto = productService.findProduct(paramPro);

			MemberDto param = new MemberDto();
			param.setCode(addrsDto.getMbrCode());
			MemberDto member = memberService.findMember(param);
			// 获取商品售价-根据特权
			BigDecimal salePrice = paramSku.getSalePrice();
			BigDecimal gapPrice = new BigDecimal(0);
			if (paramSku.getRankPriceDtos() != null && paramSku.getRankPriceDtos().size() > 0) {
				for (ProductRankPriceDto rankPriceDto : paramSku.getRankPriceDtos()) {

					if (MemberType.CLIENT.getValue().equalsIgnoreCase(mbrType)) {
						MemberDto memb = new MemberDto();
						memb.setCode(member.getMyInvite());
						MemberDto memberReturn = memberService.findMember(memb);
						if (rankPriceDto.getRankCode().equals(memberReturn.getMemberRankCode())) {
							gapPrice = paramSku.getSalePrice().subtract(rankPriceDto.getRankPrice());
							break;
						}
					} else {
						if (rankPriceDto.getRankCode().equals(member.getMemberRankCode())) {
							salePrice = rankPriceDto.getRankPrice();
							break;
						}
					}
				}
			}

			/* 创建订单 */
			orderDto.setAmt(salePrice.multiply(new BigDecimal(cnt)));
			orderDto.setMbrCode(member.getCode());
			orderDto.setMbrName(member.getName());
			/* 收货地址 */
			orderDto.setRevicerName(addrsDto.getReciverName());
			orderDto.setRevicePhone(addrsDto.getReciverPhone());
			orderDto.setAddrInfo(addrsDto.getAddrDetail());
			String areaName = province + city + area;
			orderDto.setAreaName(areaName);
			orderDto.setReciverZip(addrsDto.getReciverZip() == null ? "" : addrsDto.getReciverZip());

			orderDto.setMbrPhone(member.getPhone());
			orderDto.setRevicerName(addrsDto.getReciverName());
			orderDto.setRevicePhone(addrsDto.getReciverPhone());
			orderDto.setStatus(OrderStatus.UNPAID.getValue());
			orderDto.setMerchantCode(member.getMerchantCode());
			orderDto.setRemarks(remarks);
			if (isInvoice) {
				orderDto.setIsInvoice(OrderInvoice.Y.getValue());
				orderDto.setInvoiceTitle(invoiceTitle);
				orderDto.setInvoiceInfo(invoiceInfo);
			} else {
				orderDto.setIsInvoice(OrderInvoice.N.getValue());
			}
//			orderDto.setShopCode(shopCode);
//			orderDto.setShopName(shopDto.getShopName());
			orderDto.setOrderNo(NoUtil.generateNo(NoUtil.JY));
			orderDto.setMbrType(mbrType);
			this.addOrder(orderDto);

			/* 创建订单子项 */
			OrderDetailDto detailDto = new OrderDetailDto();

			/* 获取商品供应商 */
			SupplyDto paramSupply = new SupplyDto();
			paramSupply.setCode(productDto.getSupplyCode());
			SupplyDto supplyDto = supplyService.findSupply(paramSupply);

			detailDto.setProductCode(productDto.getCode());
			detailDto.setProductName(productDto.getName());
			detailDto.setSupplyCode(productDto.getSupplyCode());
			detailDto.setSupplyName(productDto.getSupplyName());
			detailDto.setCnt(cnt);
			/* C端售价*数量 */
			detailDto.setAmt(orderDto.getAmt());
			detailDto.setSalePrice(salePrice); // C端单个售价
//			BigDecimal disCount = new BigDecimal(supplyDto.getDiscountOff()); // 供应商折扣（0-100的数字）
//			detailDto.setOrgPrice(paramSku.getSalePrice().multiply(disCount).divide(new BigDecimal(100)).add(paramSku.getSalePrice())); // 小B进货单价（按供应商折扣计算）
			detailDto.setGapPrice(gapPrice); // 小B提成单价（按供应商折扣计算）
			detailDto.setOrderNo(orderDto.getOrderNo());
			detailDto.setSkuCode(paramSku.getCode());
			orderDetailService.addOrderDetail(detailDto);

			/* 扣除商品库存 */
			productDto.setCnt(productDto.getCnt() - cnt);
			productService.updateProduct(productDto);

			/* 扣除规格商品库存 */
			paramSku.setCnt(paramSku.getCnt() - cnt);
			productSkuService.updateProductSku(paramSku);

			/* 消息通知 */
			sendMessageByOrder(orderDto, MessageTemplate.B_SERVICE_ORDER_BILL_NON_PAYMENT);
			sendMessageByOrder(orderDto, MessageTemplate.C_SERVICE_ORDER_BILL_NON_PAYMENT, orderDto.getMbrCode());
			/* APP手机通知 */
//				String senContent = "您的客户${nickName}购买了一个新商品！";	
//				AddNotifyInfo addNotifyInfo = new AddNotifyInfo();
//				addNotifyInfo.setMerchantNo(merchantNo);
//				addNotifyInfo.setMemberNo(memberNoGm);
//				addNotifyInfo.setMemberName(memberNameGm);
//				addNotifyInfo.setMemberType(MemberType.GUID.toString());
//				addNotifyInfo.setMemberNoSender(memberNoSender);
//				addNotifyInfo.setMemberNameSender(memberNameSender);
//				addNotifyInfo.setMemberTypeSender(MemberType.);
//				addNotifyInfo.setMobile(mobileGm);
//				addNotifyInfo.setSendType(SendType.SINGLE.toString());
//				addNotifyInfo.setContent(senContent.replace("${nickName}", nickName));
//				addNotifyInfo.setSysType(MsgSystemType.ALL.toString());
			// notifyService.sendMsgInfo(addNotifyInfo);

			/* return */
			List<OrderDetailDto> detailList = new ArrayList<OrderDetailDto>();
			detailList.add(detailDto);
			orderDto.setDetailDtos(detailList);
			logger.debug("createOrder(returnOrder) - end - return={}", orderDto);

		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增订单信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_ADD_ERROR, "新增订单信息错误！", e);
		}
		return orderDto;
	}

	@Override
	public Page<OrderDto> findOrderEisPage(FindOrderPage findOrderPage) throws TsfaServiceException {
		logger.debug("findOrderEisPage(FindOrderPage findOrderPage={}) - start", findOrderPage); //$NON-NLS-1$

		AssertUtils.notNull(findOrderPage);
		List<OrderDto> returnList = null;
		int count = 0;
		try {
			returnList = orderDao.findOrderEisPage(findOrderPage);
			count = orderDao.findOrderEisPageCount(findOrderPage);
		} catch (Exception e) {
			logger.error("订单信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.ORDER_FIND_PAGE_ERROR, "订单信息不存在错误.！", e);
		}
		Page<OrderDto> returnPage = new Page<OrderDto>(returnList, count, findOrderPage);

		logger.debug("findOrderEisPage(FindOrderPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	private void sendMessageByOrder(List<OrderDto> returnOrders, MessageTemplate template) {
		for (OrderDto orderDto : returnOrders) {
			sendMessageByOrder(orderDto, template);
		}
	}

	private void sendMessageByOrder(OrderDto orderDto, MessageTemplate template) {
		sendMessageByOrder(orderDto, template, null);
	}

	/**
	 * 方法说明：
	 * 
	 * @param @param orderDto
	 * @param @param template
	 * @param @param receiveCode 收信人code
	 * @author 林进权 CreateDate: 2017年10月13日
	 */
	private void sendMessageByOrder(OrderDto orderDto, MessageTemplate template, String receiveCode) {
		OrderDetailDto paramDetailDto = new OrderDetailDto();
		paramDetailDto.setOrderNo(orderDto.getOrderNo());
		FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
		findOrderDetailPage.setParam(paramDetailDto);
		List<OrderDetailDto> list = orderDetailService.findOrderDetails(findOrderDetailPage);

		// 构建订单金额，订单商品名称
		StringBuilder sbCommodity = new StringBuilder();
		BigDecimal money = orderDto.getAmt();
		if (null != list && list.size() > 0) {
			for (OrderDetailDto orderDetailDto : list) {
				sbCommodity.append(orderDetailDto.getProductName()).append("；");
				// money.add(orderDetailDto.getSalePrice());
			}
		}

//		ShopDto shopDto = new ShopDto();
//		shopDto.setCode(orderDto.getShopCode());
//		shopDto = shopService.findShop(shopDto);
		MemberDto memberDto = new MemberDto();
		memberDto.setCode(orderDto.getMbrCode());
		MemberDto dto = memberService.findMember(memberDto);
		// 消息实体
		// 消息推送给上级，因为没有开店业务了
		MessageDto messageDto = new MessageDto();
		messageDto.setRecevier(dto.getMyInvite());

		// 推送给指定
		if (StringUtils.isNotEmpty(receiveCode)) {
			messageDto.setRecevier(receiveCode);
		}

		if (sbCommodity.length() > 0) {
			messageDto.setcClientCommodity(sbCommodity.toString().substring(0, sbCommodity.length() - 1));
		}
		messageDto.setcClientMoney(money.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		messageDto.setcClientOrderNo(orderDto.getOrderNo());
		messageDto.setcClientName(orderDto.getMbrName());
		messageDto.setcClientReceiveName(orderDto.getRevicerName());
		logger.debug("messageDto ={}", messageDto);
		messageService.addMessageByTemplate(messageDto, template);
	}

	/**
	 * 
	 * 方法说明：退货成功发送消息给c端
	 *
	 * @param @param retireDetailList 退货明细列表
	 * @param @param orderMbrCode 下订单的c端用户
	 * @return void 返回类型
	 * @throws Exception
	 *
	 * @author 林进权 CreateDate: 2017年9月4日
	 */
	private void sendMessageByRetire(List<OrderRetireDetailDto> retireDetailList, String orderMbrCode) {
		for (OrderRetireDetailDto orderRetireDetailDto : retireDetailList) {
			sendMessageByRetire(orderRetireDetailDto, orderMbrCode);
		}

	}

	private void sendMessageByRetire(OrderRetireDetailDto detail, String orderMbrCode) {

		// 查询订购明细
		OrderDetailDto orderDetailDto = new OrderDetailDto();
		orderDetailDto.setCode(detail.getOrderDetailCode());
		orderDetailDto = orderDetailService.findOrderDetail(orderDetailDto);

		// 消息实体
		MessageDto messageDto = new MessageDto();
		messageDto.setRecevier(orderMbrCode);
		messageDto.setcClientCommodity(orderDetailDto.getProductName());
		messageDto.setcClientOrderNo(detail.getRetireNo());
		messageService.addMessageByTemplate(messageDto, MessageTemplate.C_SERVICE_BACK_SUCCESS);
	}

	@Override
	public BigDecimal findAmtSum(FindOrderPage findOrderPage) throws TsfaServiceException {
		logger.debug("findAmtSum(FindOrderPage findOrderPage={}) - start", findOrderPage); //$NON-NLS-1$
		AssertUtils.notNull(findOrderPage);
		BigDecimal decimal = new BigDecimal(0);
		try {
			double tem = orderDao.findAmtSum(findOrderPage);
			decimal = new BigDecimal(tem).setScale(2, BigDecimal.ROUND_HALF_UP);
			;
		} catch (Exception e) {
			logger.error("订单信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.ORDER_FIND_PAGE_ERROR, "订单信息不存在错误.！", e);
		}
		logger.debug("findAmtSum(decimal) - end - return value={}", decimal); //$NON-NLS-1$
		return decimal;
	}

	@Override
	public int findOrderPageCount(FindOrderPage findOrderPage) throws TsfaServiceException {
		logger.debug("findOrderPageCount(FindOrderPage findOrderPage={}) - start", findOrderPage); //$NON-NLS-1$

		AssertUtils.notNull(findOrderPage);
		int count = 0;
		try {
			count = orderDao.findOrderPageCount(findOrderPage);
		} catch (Exception e) {
			logger.error("订单信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.ORDER_FIND_PAGE_ERROR, "订单信息不存在错误.！", e);
		}
		logger.debug("findOrderPageCount(FindOrderPage) - end - return value={}", count); //$NON-NLS-1$
		return count;
	}

	@Override
	public OrderDto findOrderByOrderNo(String orderNo) throws TsfaServiceException {
		AssertUtils.notAllNullAndEmpty(orderNo, "订单号不能为空");
		OrderDto orderDto = null;
		try {
			FindOrderPage findOrderPage = new FindOrderPage();
			OrderDto param = new OrderDto();
			param.setOrderNo(orderNo);
			findOrderPage.setParam(param);
			List<OrderDto> returnList = orderDao.findOrders(findOrderPage);
			if (returnList.size() <= 0) {
				logger.error("订单信息不存在错误");
				throw new TsfaServiceException(ErrorCode.ORDER_FIND_PAGE_ERROR, "订单信息不存在错误.！");
			}
			orderDto = returnList.get(0);
		} catch (Exception e) {
			logger.error("查找订单信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_NOT_EXIST_ERROR, "订单信息不存在");
		}
		return orderDto;
	}

	public void review(OrderDto orderDto) {
		logger.debug("receipt(OrderDto orderDto={}) - start", orderDto);
		AssertUtils.notNull(orderDto);
		AssertUtils.notNullAndEmpty(orderDto.getCode(), "订单编号不能为空");
		AssertUtils.notNullAndEmpty(orderDto.getOrderNo(), "订单号不能为空");
		try {
			/* 状态流转至已完成 */
			orderDto.setStatus(OrderStatus.COMPLETED.getValue());
			this.updateOrder(orderDto);
			/* 消息通知 */
			sendMessageByOrder(orderDto, MessageTemplate.B_SERVICE_ORDER_BILL_COMPLETED);
			sendMessageByOrder(orderDto, MessageTemplate.C_SERVICE_ORDER_BILL_COMPLETED, orderDto.getMbrCode());
		} catch (Exception e) {
			logger.error("订单评价错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_UPDATE_ERROR, "订单评价错误！", e);
		}
	}

	@Override
	public List<CatalogSummaryDto> findProductCatalog(FindOrderPage findOrderPage) throws TsfaServiceException {

		return orderDao.findProductCatalog(findOrderPage);
	}

	@Override
	public Integer findAmtRank(FindOrderPage findOrderPage) throws TsfaServiceException {
		return orderDao.findAmtRank(findOrderPage);
	}

	/**
	 * 自动确认收货
	 */
	@Override
	public void autoReceipt() throws TsfaServiceException {
		logger.info("autoReceipt----------------start");
		/* 获取所有待收货订单 */
		OrderDto paramOrderDto = new OrderDto();
		paramOrderDto.setStatus(OrderStatus.SHIPPED.getValue());
		FindOrderPage findOrderPage = new FindOrderPage();
		findOrderPage.setParam(paramOrderDto);
		List<OrderDto> orderDtos = this.findOrders(findOrderPage);
		ResourceBundle config = ResourceBundle.getBundle("properties/config");
		if (orderDtos != null && orderDtos.size() > 0) {
			Iterator<OrderDto> localIterator1 = orderDtos.iterator();
			Integer expire_receipt = -Integer.valueOf(config.getString("expire.member_order_receipt"));
			while (localIterator1.hasNext()) {
				OrderDto orderDto = localIterator1.next();
				if (orderDto.getShippingTime() != null
						&& orderDto.getShippingTime().compareTo(DateUtils.addMinutes(new Date(), expire_receipt)) < 0) {
					this.complete(orderDto);
				}
			}
		}
		logger.info("autoReceipt----------------end");
	}

	/**
	 * 自动好评
	 */
	@Override
	public void autoReview() throws TsfaServiceException {
		logger.info("autoReview----------------start");
		/* 获取所有待评价订单 */
		OrderDto paramOrderDto = new OrderDto();
		paramOrderDto.setStatus(OrderStatus.UNEVL.getValue());
		FindOrderPage findOrderPage = new FindOrderPage();
		findOrderPage.setParam(paramOrderDto);
		List<OrderDto> orderDtos = this.findOrders(findOrderPage);

		ResourceBundle config = ResourceBundle.getBundle("properties/config");
		if (orderDtos != null && orderDtos.size() > 0) {
			Iterator<OrderDto> localIterator1 = orderDtos.iterator();
			Integer expire_receipt = -Integer.valueOf(config.getString("expire.member_order_review"));
			while (localIterator1.hasNext()) {
				OrderDto orderDto = localIterator1.next();
				if (orderDto.getUpdateTime() != null
						&& orderDto.getUpdateTime().compareTo(DateUtils.addMinutes(new Date(), expire_receipt)) < 0) {

					/* 订单 */
					OrderDetailDto paramOrderDetailDto = new OrderDetailDto();
					paramOrderDetailDto.setOrderNo(orderDto.getOrderNo());
					FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
					findOrderDetailPage.setParam(paramOrderDetailDto);

					/* 会员 */
					MemberDto parmMemberDto = new MemberDto();
					parmMemberDto.setCode(orderDto.getMbrCode());
					MemberDto memberDto = memberService.findMember(parmMemberDto);

					/* 处理订单详情 */
					List<OrderDetailDto> detailDtos = orderDetailService.findOrderDetails(findOrderDetailPage);
					if (detailDtos.size() > 0) {
						Iterator<OrderDetailDto> iterator = detailDtos.iterator();
						while (iterator.hasNext()) {
							OrderDetailDto detailDto = iterator.next();
							/* 获取规格商品 */
							ProductSkuDto paramSkuDto = new ProductSkuDto();
							paramSkuDto.setCode(detailDto.getSkuCode());
							ProductSkuDto productSkuDto = productSkuService.findProductSku(paramSkuDto);

							/* 获取商品 */
							ProductDto parProductDto = new ProductDto();
							parProductDto.setCode(productSkuDto.getProductCode());
							ProductDto productDto = productService.findProduct(parProductDto);

							EvlProductDto evlProductDto = new EvlProductDto();
							evlProductDto.setEvlGrade("5");
							evlProductDto.setEvlInfo("评价方未及时做出评论，系统默认好评！");
							evlProductDto.setEvlMbrCode(memberDto.getCode());
							evlProductDto.setEvlMbrImg(memberDto.getAvotor());
							evlProductDto.setEvlMbrName(memberDto.getName());
							evlProductDto.setGoodCnt(0);
							evlProductDto.setProductCode(productSkuDto.getProductCode());
							evlProductDto.setProductName(productDto.getName());
							evlProductDto.setProductSkuCode(detailDto.getSkuCode());
							evlProductDto.setSkuDesc(productSkuDto.getSkuDesc());
							evlProductService.addEvlProduct(evlProductDto);

							/* 修改商品总评分和评论数 */
							productDto.setTotalScore(
									productDto.getTotalScore() + Integer.valueOf(evlProductDto.getEvlGrade()));
							productDto.setEvlCnt(productDto.getEvlCnt() + 1);
							productService.updateProduct(productDto);
						}
					}

					// 评论
					this.review(orderDto);
				}
			}
		}
		logger.info("autoReview----------------end");
	}

	public static void main(String[] args) throws ParseException {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("properties/config");
//		System.out.println(new BigDecimal(200).compareTo(new BigDecimal(150))<=0);
		System.out.println(com.lj.base.core.util.DateUtils
				.parseDate("2017-10-03", com.lj.base.core.util.DateUtils.PATTERN_yyyy_MM_dd)
				.compareTo(DateUtils.addMinutes(new Date(), -10080)) < 0);
	}

	@Override
	public List<Map<String, Object>> findOrderGroupStatus(FindOrderPage findOrderPage) throws TsfaServiceException {
		logger.debug("findOrderGroupStatus(FindOrderPage findOrderPage={}) - start", findOrderPage); //$NON-NLS-1$

		AssertUtils.notNull(findOrderPage);
		List<Map<String, Object>> returnList = null;
		try {
			returnList = orderDao.findOrderGroupStatus(findOrderPage);
		} catch (Exception e) {
			logger.error("订单信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.ORDER_FIND_PAGE_ERROR, "订单信息不存在错误.！", e);
		}
		logger.debug("findOrderPage(FindOrderPage) - end - return value={}", returnList); //$NON-NLS-1$
		return returnList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.eshop.service.IOrderService#findTopProductCatalog(com.lj.eshop.dto.
	 * FindOrderPage)
	 */
	@Override
	public CatalogSummaryDto findTopProductCatalog(FindOrderPage findOrderPage) throws TsfaServiceException {
		return orderDao.findTopProductCatalog(findOrderPage);
	}

}
