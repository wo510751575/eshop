package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.dto.FindPaymentPage;


import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;

import java.util.List;
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
public interface IPaymentService {
	
	/**
	 * 
	 *
	 * 方法说明：添加预支付流水信息
	 *
	 * @param paymentDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addPayment(PaymentDto paymentDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找预支付流水信息
	 *
	 * @param findPayment
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public PaymentDto findPayment(PaymentDto paymentDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询预支付流水信息
	 *
	 * @param findPaymentPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<PaymentDto>  findPayments(FindPaymentPage findPaymentPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改预支付流水信息
	 *
	 * @param updatePayment
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updatePayment(PaymentDto paymentDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询预支付流水信息
	 *
	 * @param findPaymentPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<PaymentDto> findPaymentPage(FindPaymentPage findPaymentPage) throws TsfaServiceException;
	

}
