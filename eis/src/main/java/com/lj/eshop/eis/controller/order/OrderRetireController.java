/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.FindOrderDetailPage;
import com.lj.eshop.dto.FindOrderRetireDetailPage;
import com.lj.eshop.dto.FindOrderRetirePage;
import com.lj.eshop.dto.OrderDetailDto;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.OrderRetireDetailDto;
import com.lj.eshop.dto.OrderRetireDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.OrderRetireType;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.service.IOrderDetailService;
import com.lj.eshop.service.IOrderRetireDetailService;
import com.lj.eshop.service.IOrderRetireService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IProductImgService;

/**
 * 
 * 类说明：退货
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@RestController
@RequestMapping("/order/retire")
public class OrderRetireController extends BaseController {


	@Autowired
	private IOrderRetireService orderRetireService;
	@Autowired
	private IOrderRetireDetailService orderRetireDetailService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderDetailService orderDetailService;
	@Autowired
	private IProductImgService productImgService;

	/**
	 * 退货列表
	 * 方法说明：
	 * @param  pageNo 页码
	 * @param  pageSize 每页数量
	 * @param  param.auditStatus 0待审核，1成功，2失败
	 * @param  clientType B、B端，C、C端
	 * @author 林进权
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"list"})
	@ResponseBody
	public ResponseDto list(Integer pageNo, Integer pageSize, FindOrderRetirePage findOrderRetirePage, String clientType) {
		logger.debug("OrderRetireController --> list() - start", findOrderRetirePage); 
		
		if(StringUtils.isEmpty(clientType)){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
			pageNo = pageNo==null?1:pageNo;
			pageSize = pageSize==null || pageSize>500?10:pageSize;
			findOrderRetirePage.setStart((pageNo - 1) * pageSize);
			findOrderRetirePage.setLimit(pageSize);
			
			
			Page<OrderRetireDto> pageDto = null;
			List<OrderRetireDto> list = new ArrayList<OrderRetireDto>();
			
			//String role =getLoginUserRole();
			if(clientType.equals("C")) {
				findOrderRetirePage.setMbrCode(getLoginMemberCode());
				pageDto = orderRetireService.findOrderRetirePage4BC(findOrderRetirePage);
				
			} else {
				//b端
//				findOrderRetirePage.setMerchantCode(getLoginMerchantCode());
				findOrderRetirePage.setShopCode(getLoginShopCode());
				pageDto = orderRetireService.findOrderRetirePage4BC(findOrderRetirePage);
			}
			
			list.addAll(pageDto.getRows());
			if(list==null || list.size()<=0){
				return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
			}
			buildRetireDetail(list);
			
			logger.debug("OrderRetireController --> list(={}) - end",list);
			return ResponseDto.successResp(pageDto);
		
	}

	//构建明细
	private void buildRetireDetail(List<OrderRetireDto> list) {
		for (OrderRetireDto orderRetireDto : list) {
			//退货明细价格、数量，通过退货单
			FindOrderRetireDetailPage findOrderRetireDetailPage = new FindOrderRetireDetailPage();
			OrderRetireDetailDto retireDetailDto = new OrderRetireDetailDto();
			retireDetailDto.setRetireNo(orderRetireDto.getRetireNo());
			findOrderRetireDetailPage.setParam(retireDetailDto);
			List<OrderRetireDetailDto> retireDetails = orderRetireDetailService.findOrderRetireDetails(findOrderRetireDetailPage);
//			orderRetireDto.setRetireDetailDtos(retireDetails);
//			orderRetireDto.setRetireDetailDtos(details);
			
			if(retireDetails!=null && retireDetails.size()>0) {
				List<String> orderDetailCodes = new LinkedList<String>();
				List<String> skuCodes = new LinkedList<String>();
				for (OrderRetireDetailDto orderRetireDetailDto : retireDetails) {
					orderDetailCodes.add(orderRetireDetailDto.getOrderDetailCode());
					if(StringUtils.isNotEmpty(orderRetireDetailDto.getSkuNo())) {
						skuCodes.add(orderRetireDetailDto.getSkuNo());
					}
				}
				
				//订购明细查询商品，编号通过退货明细
				Map<String, OrderDetailDto> detailMap = buildOrderDetailMap(orderDetailCodes);
				
				List<Map<String,Object>> redetailMapList = new LinkedList<Map<String,Object>>();
				for (int i=0; i<retireDetails.size(); i++) {
					OrderRetireDetailDto retireDetailDtoTmp = retireDetails.get(i);
					Map<String,Object> map = new TreeMap<String,Object>();
					map.put("amt", retireDetailDtoTmp.getAmt()); //金额
					map.put("code", retireDetailDtoTmp.getCode());
					map.put("cnt", retireDetailDtoTmp.getCnt()); //数量
					map.put("skuCode", retireDetailDtoTmp.getSkuNo()); //
					map.put("orderDetailCode", retireDetailDtoTmp.getOrderDetailCode());
					
					OrderDetailDto orderDetailDto = detailMap.get(retireDetailDtoTmp.getOrderDetailCode());
					if(null!=orderDetailDto) {
						map.put("sku", orderDetailDto.getSku());
						map.put("productCode", orderDetailDto.getProductCode()); //
						map.put("productName", orderDetailDto.getProductName()); //
						if(null!=orderDetailDto.getProduct()) {
							map.put("productIcon", orderDetailDto.getProduct().getProductIcon());
						}
					}
					
//					retireDetailDtoTmp.setProductMap(map);
					redetailMapList.add(map);
				}
				orderRetireDto.setRetireDetails(redetailMapList);
			}
		}
		
	}

	
	private  Map<String, OrderDetailDto>  buildOrderDetailMap(List<String> orderDetailCodes) {
		FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
		findOrderDetailPage.setOrderDetailCode(orderDetailCodes);
		List<OrderDetailDto> orderDetailDtos = orderDetailService.findOrderDetails(findOrderDetailPage);
		Map<String, OrderDetailDto> map = new HashMap<String, OrderDetailDto>();
		for (OrderDetailDto orderDetailDto : orderDetailDtos) {
			map.put(orderDetailDto.getCode(), orderDetailDto);
		}
		return map;
	}

	/**
	 * 退货详情
	 * 方法说明：
	 *
	 * @param 退货单code: code
	 * @return ResponseDto    返回类型 
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月4日
	 */
	@RequestMapping(value = {"view"})
	@ResponseBody
	public ResponseDto view(OrderRetireDto orderRetireDto) {
		logger.debug("OrderRetireController --> view() - start", orderRetireDto); 
		if(orderRetireDto==null || StringUtils.isEmpty(orderRetireDto.getCode())
			){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
			OrderRetireDto rDto = this.orderRetireService.findOrderRetire(orderRetireDto);
			
			List<OrderRetireDto> list = new ArrayList<OrderRetireDto>();
			list.add(rDto);
			buildRetireDetail(list);
			
			logger.debug("OrderRetireController --> view(={}) - end");
			return ResponseDto.successResp(list);
	}
	
	
	/**
	 * 申请退货
	 * 方法说明：
	 *
	 * @param 订单号：orderNo	必填
	 * @param 问题描述：remarks		必填
	 * @param 订单code: orderCode		必填
	 * @param img1
	 * @param 快递号码：expressNo	必填
  	 * @param 快递公司：expressName	必填
	 * @param 退货数量：retireDetailDtos[0].amt:11  		 必填
	   @param 退货金额：retireDetailDtos[0].cnt:11		必填
	   @param 订单明细Code： retireDetailDtos[0].orderDetailCode:order11	必填
		
		退货数量：retireDetailDtos[n..].amt:12
		退货金额：retireDetailDtos[n..].cnt:12
		订单明细Code： retireDetailDtos[n..].orderDetailCode:order12
	 * 
	 * @return ResponseDto    返回类型 
	 * @author 林进权
	 *         CreateDate: 2017年9月4日
	 *         @RequestBody 接收json对象
	 */
	@RequestMapping(value = {"add"})
	@ResponseBody
	public ResponseDto add( OrderRetireDto orderRetireDto, String orderCode) {
		logger.debug("OrderRetireController --> add() - start", orderRetireDto); 
		if(orderRetireDto==null || StringUtils.isEmpty(orderRetireDto.getOrderNo())
				|| StringUtils.isEmpty(orderRetireDto.getExpressNo()) || StringUtils.isEmpty(orderRetireDto.getExpressName())
				|| StringUtils.isEmpty(orderRetireDto.getRemarks()) || StringUtils.isEmpty(orderCode)
				|| StringUtils.isEmpty(orderRetireDto.getRemarks())
				|| StringUtils.isEmpty(orderRetireDto.getRetireDetailJsonStr()) 
			){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
		Gson gson = new Gson();
		orderRetireDto.setRetireDetailDtos(gson.fromJson(orderRetireDto.getRetireDetailJsonStr(), new TypeToken<LinkedList<OrderRetireDetailDto>>(){}.getType()));
		
			OrderDto orderDto = new OrderDto();
			orderDto.setCode(orderCode);
			OrderDto rOrderDto = orderService.findOrder(orderDto);
			String orderStatus = rOrderDto.getStatus();
			//首要条件必须是完成的
			if(!StringUtils.equal(orderStatus, OrderStatus.SHIPPED.getValue())
					&& !StringUtils.equal(orderStatus, OrderStatus.UNEVL.getValue())
					) {
				return ResponseDto.createResp(false, ResponseCode.ORDER_RETIRE_STATUS_FAIL.getCode(), ResponseCode.ORDER_RETIRE_STATUS_FAIL.getMsg(), null);
			}
			
			//然后updatetime时间超过24小时
			if(//(StringUtils.equal(orderStatus, OrderStatus.SHIPPED.getValue())  || 
					StringUtils.equal(orderStatus, OrderStatus.UNEVL.getValue())
					&& !checkReceive(rOrderDto.getUpdateTime(), new Date())){
				return ResponseDto.createResp(false, ResponseCode.ORDER_RETIRE_TIME_EXPIRE.getCode(), ResponseCode.ORDER_RETIRE_TIME_EXPIRE.getMsg(), null);
			}
			
			orderRetireDto.setType(OrderRetireType.SUCCESS.getValue());
			orderRetireDto.setAuditStatus("0");//待审
			orderRetireDto.setCreateTime(new Date());
			orderRetireDto.setOrderCode(orderCode);
			String orderRetireNo = NoUtil.generateNo(NoUtil.JY);
			orderRetireDto.setRetireNo(orderRetireNo);
			orderRetireService.applyBack(orderRetireDto);
			
			
			logger.debug("OrderRetireController --> add(={}) - end");
			return ResponseDto.successResp(null);
	}
	
	
	/**
	 * 
	 * 方法说明：
	 * @param 退货单code： code 必填
	 * @param 快递号码：expressNo	必填
	 * @param 快递公司：expressName	必填 
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月7日
	 */
	//@RequestMapping(value = {"upd"})
	//@ResponseBody
	public ResponseDto upd(OrderRetireDto orderRetireDto) {
		logger.debug("OrderRetireController --> upd(={}) - start", orderRetireDto);
		if(orderRetireDto==null || StringUtils.isEmpty(orderRetireDto.getCode())
				|| StringUtils.isEmpty(orderRetireDto.getExpressNo()) || StringUtils.isEmpty(orderRetireDto.getExpressName()) 
			){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		this.orderRetireService.updateOrderRetire(orderRetireDto);
		
		logger.debug("OrderRetireController --> upd(={}) - end");
		return ResponseDto.successResp(null);
	}
	
	
	
	
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date bDate = simpleDateFormat.parse("2017-09-08 00:00:00");
		Date dDate = simpleDateFormat.parse("2017-09-04 00:00:00");
		
		
		System.out.println((bDate.getTime()-dDate.getTime())/(1000*60*60*24));
		
		String json = "[{\"cnt\":1,\"amt\":30,\"orderDetailCode\":\"0139418e-93cc-11e7-be8b-000c29aa1308\"},{\"cnt\":2,\"amt\":40,\"orderDetailCode\":\"05e806be-93cc-11e7-be8b-000c29aa1308\"}]";
		Gson gson = new Gson();
		List<OrderRetireDetailDto> list = gson.fromJson(json, new TypeToken<LinkedList<OrderRetireDetailDto>>(){}.getType());
		System.out.println(list.get(0).getAmt());
	}
	
	private boolean checkReceive(Date before, Date after) {
		if(before==null) {
			return false;
		}
		int minuteForOneDay = 60*24;
		long intervalMinute = (after.getTime()-before.getTime())/(1000*60);
		if(intervalMinute>minuteForOneDay) {
			return false;
		}
		return true;
	}
}
