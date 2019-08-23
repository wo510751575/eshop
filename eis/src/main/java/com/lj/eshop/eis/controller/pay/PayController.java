/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.pay;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.PayReqDto;
import com.lj.eshop.eis.dto.PayRespDto;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.service.impl.PayService;

/**
 * 
 * 类说明：支付接口。
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author lhy CreateDate: 2017年9月8日
 */
@RestController
@RequestMapping(value = "/pay")
public class PayController extends BaseController{
	
	@Autowired
	private PayService payService;
	
	/***
	 * 方法说明：支付接口。<p>
	 * 当前支持微信支付。
	 * @param dto
	 * @param request
	 * @return
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
	@RequestMapping(value = "/unifiedorder")
	@ResponseBody
	public ResponseDto pay(PayReqDto dto,HttpServletRequest request){
		dto.setSpbillCreateIp(request.getRemoteAddr());
		dto.setMbrCode(getLoginMemberCode());
		PayRespDto resp = payService.payment(dto);
		return ResponseDto.successResp(resp);
	}
}
