/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.dto;

import java.io.Serializable;

/**
 * 
 * 类说明：修改手机号及手机号登录DTO.
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
public class MobilePhoneLoginDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1346712937569365354L;

	/** 手机号 */
	private String mobilePhone;
	/** 验证码 */
	private String authCode;
	/** 登录密码 */
	private String password;
	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * @return the authCode
	 */
	public String getAuthCode() {
		return authCode;
	}
	/**
	 * @param authCode the authCode to set
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
