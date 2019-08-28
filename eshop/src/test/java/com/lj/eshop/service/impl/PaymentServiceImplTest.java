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

import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.dto.FindPaymentPage;
import com.lj.eshop.service.IPaymentService;

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
public class PaymentServiceImplTest extends SpringTestCase{

	@Resource
	IPaymentService paymentService;



	/**
	 * 
	 *
	 * 方法说明：添加预支付流水信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addPayment() throws TsfaServiceException{
		PaymentDto paymentDto = new PaymentDto();
		//add数据录入
		paymentDto.setCode("Code");
		paymentDto.setAccCode("AccCode");
		paymentDto.setBank("Bank");
		paymentDto.setExpire(new Date());
		paymentDto.setFee(BigDecimal.ZERO);
		paymentDto.setMemo("Memo");
		paymentDto.setOperator("Operator");
		paymentDto.setPayer("Payer");
		paymentDto.setPaymentDate(new Date());
		paymentDto.setPaymentMethod("PaymentMethod");
		paymentDto.setSn("Sn");
		paymentDto.setStatus(1);
		paymentDto.setType(1);
		paymentDto.setMbrCode("MbrCode");
		paymentDto.setBizNo("BizNo");
		paymentDto.setDelFlag("DelFlag");
		paymentDto.setThirdpartyTradeNo("ThirdpartyTradeNo");
		paymentDto.setAmount(BigDecimal.ZERO);
		paymentDto.setFailReason("FailReason");
		paymentDto.setAccSource("AccSource");
		
		paymentService.addPayment(paymentDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改预支付流水信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updatePayment() throws TsfaServiceException{
		PaymentDto paymentDto = new PaymentDto();
		//update数据录入
		paymentDto.setCode("Code");
		paymentDto.setAccCode("AccCode");
		paymentDto.setBank("Bank");
		paymentDto.setExpire(new Date());
		paymentDto.setFee(BigDecimal.ZERO);
		paymentDto.setMemo("Memo");
		paymentDto.setOperator("Operator");
		paymentDto.setPayer("Payer");
		paymentDto.setPaymentDate(new Date());
		paymentDto.setPaymentMethod("PaymentMethod");
		paymentDto.setSn("Sn");
		paymentDto.setStatus(1);
		paymentDto.setType(1);
		paymentDto.setMbrCode("MbrCode");
		paymentDto.setBizNo("BizNo");
		paymentDto.setDelFlag("DelFlag");
		paymentDto.setThirdpartyTradeNo("ThirdpartyTradeNo");
		paymentDto.setAmount(BigDecimal.ZERO);
		paymentDto.setFailReason("FailReason");
		paymentDto.setAccSource("AccSource");

		paymentService.updatePayment(paymentDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找预支付流水信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findPayment() throws TsfaServiceException{
		PaymentDto findPayment = new PaymentDto();
		findPayment.setCode("111");
		paymentService.findPayment(findPayment);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找预支付流水信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findPaymentPage() throws TsfaServiceException{
		FindPaymentPage findPaymentPage = new FindPaymentPage();
		Page<PaymentDto> page = paymentService.findPaymentPage(findPaymentPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找预支付流水信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findPayments() throws TsfaServiceException{
		FindPaymentPage findPaymentPage = new FindPaymentPage();
		List<PaymentDto> page = paymentService.findPayments(findPaymentPage);
		Assert.assertNotNull(page);
		
	}
	
}
