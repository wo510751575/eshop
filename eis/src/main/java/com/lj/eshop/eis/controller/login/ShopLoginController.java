/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.MobilePhoneLoginDto;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.dto.TokenDto;
import com.lj.eshop.eis.service.IUserLoginService;

/**
 * 类说明：店铺登录。
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月2日
 */
@RestController
public class ShopLoginController extends BaseController {

	@Autowired
	IUserLoginService userLoginService ;
	
	/***
	 * 方法说明：B端手机号登录。
	 * 
	 * @param dto
	 *            登录信息。
	 * @return
	 * @author lhy 2017年9月2日
	 *
	 */
	@RequestMapping(value = "/shop/login/moblie", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto mobilePhoneLogin(MobilePhoneLoginDto dto) {
		TokenDto tk=userLoginService.mobilePhoneLogin(dto);
		return ResponseDto.successResp(tk);
	}
	
	/**
	 * 方法说明：登出。
	 *
	 * @return
	 *
	 * @author lhy  2017年9月14日
	 *
	 */
	@RequestMapping(value = "/logout")
	@ResponseBody
	public ResponseDto logout(){
		userLoginService.logout();
		return ResponseDto.successResp(null);
	}
	
	
	/**
	 * 方法说明：小B，APP登录。
	 *
	 * @return
	 *
	 * @author lhy  2017年9月14日
	 *
	 */
	@RequestMapping(value = "/app/login")
	@ResponseBody
	public ResponseDto appLogin(MobilePhoneLoginDto dto){
		TokenDto tk = userLoginService.appLogin(dto);
		return ResponseDto.successResp(tk);
	}

}
