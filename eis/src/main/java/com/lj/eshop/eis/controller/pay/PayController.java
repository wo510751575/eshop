/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.pay;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.distributelock.IDistributeLock;
import com.lj.distributelock.RedisLock;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.PayReqDto;
import com.lj.eshop.eis.dto.PayRespDto;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.service.impl.PayService;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.emus.PaymentStatus;
import com.lj.eshop.emus.PaymentType;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IPaymentService;

/**
 * 
 * 类说明：支付接口。
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy CreateDate: 2017年9月8日
 */
@RestController
@RequestMapping(value = "/pay")
public class PayController extends BaseController {

	@Autowired
	private PayService payService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IDistributeLock redisLock;

	/***
	 * 方法说明：支付接口。
	 * <p>
	 * 当前支持微信支付。
	 * 
	 * @param dto
	 * @param request
	 * @return
	 *
	 * @author lhy 2017年9月8日
	 *
	 */
	@RequestMapping(value = "/unifiedorder")
	@ResponseBody
	public ResponseDto pay(PayReqDto dto, HttpServletRequest request) {
		dto.setSpbillCreateIp(request.getRemoteAddr());
		dto.setMbrCode(getLoginMemberCode());
		PayRespDto resp = payService.payment(dto);
		return ResponseDto.successResp(resp);
	}

	@RequestMapping(value = "/rank")
	@ResponseBody
	public ResponseDto rank(String orderNo, HttpServletRequest request) {
		OrderDto orderDto = orderService.findOrderByOrderNo(orderNo);
		AccountDto accountDto = accountService.findAccountByMbrCode(getLoginMemberCode());
		
		//校验订单状态
		if(null == orderDto){
			return ResponseDto.getErrorResponse(ErrorCode.ORDER_PAYMENT_ERROR, "订单不存在");
		}
		
		if(!orderDto.getStatus().equals(OrderStatus.UNPAID.getValue())){
			return ResponseDto.getErrorResponse(ErrorCode.ORDER_PAYMENT_ERROR, "订单已支付");
		}
		//校验订单价格
		if(orderDto.getAmt().compareTo(accountDto.getRankCashAmt())>0){
			return ResponseDto.getErrorResponse(ErrorCode.ORDER_PAYMENT_ERROR, "订单价格超出会员可用余额");
		}
		
		//加锁防止重复操作
		String claimLockName = RedisLock.LOCK_NAME_PREFIX + orderNo;
		String claimLockValue = "";
		try {
			claimLockValue = redisLock.getLockNoWait(claimLockName, 5);
			orderService.payment(builPaymentDto(orderDto));
		} catch (Exception e) {
			logger.error("订单正在支付中", e);
			return ResponseDto.getErrorResponse(ErrorCode.ORDER_PAYMENT_ERROR, "订单正在支付中");
		}finally {
			// 释放锁
			redisLock.releaseLock(claimLockName, claimLockValue);
		}
		
		return ResponseDto.successResp(orderDto);
	}

	private PaymentDto builPaymentDto(OrderDto orderDto) {
		/* 获取账户 */
		AccountDto accountDto = accountService.findAccountByMbrCode(orderDto.getMbrCode());
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setAccCode(accountDto.getCode());
		paymentDto.setFee(new BigDecimal(0));
		paymentDto.setOperator(getLoginMemberCode());
		paymentDto.setPayer(orderDto.getMbrCode());
		paymentDto.setPaymentDate(new Date());
		paymentDto.setPaymentMethod(AccWaterPayType.RANK.getValue());
		paymentDto.setSn(NoUtil.generateNo(NoUtil.JY));
		paymentDto.setStatus(PaymentStatus.SUCCESS.getValue());
		paymentDto.setType(PaymentType.OFFLINE.getValue());
		paymentDto.setMbrCode(orderDto.getMbrCode());
		paymentDto.setBizNo(orderDto.getOrderNo());
		paymentDto.setDelFlag(DelFlag.N.getValue());
		paymentDto.setAmount(orderDto.getAmt());
		paymentDto.setAccSource(AccWaterSource.ORDER.getValue());
		paymentService.addPayment(paymentDto);
		return paymentDto;
	}
}
