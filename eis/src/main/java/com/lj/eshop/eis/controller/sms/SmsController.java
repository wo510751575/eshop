/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.CodeCheckDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.utils.AuthCodeUtils;
import com.lj.eshop.service.ICodeCheckService;

/**
 * 
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月2日
 */
@RestController
@RequestMapping("/sms")
public class SmsController {

	@Autowired
	ICodeCheckService codeCheckService;

	/***
	 * 方法说明：发送短信验证码。
	 *
	 * @param codeCheckDto
	 * @return
	 *
	 * @author lhy 2017年9月2日
	 *
	 */
	@RequestMapping(value="/send",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDto sendSms(CodeCheckDto codeCheckDto) {
		if (StringUtils.isEmpty(codeCheckDto.getRevicerPhone())
				|| StringUtils.isEmpty(codeCheckDto.getBizType())) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		AuthCodeUtils.sendAuthCode(codeCheckDto);
		// 3.提示发送成功
		return ResponseDto.successResp(null);
	}
}
