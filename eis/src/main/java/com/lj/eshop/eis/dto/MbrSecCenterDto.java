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
 * 类说明：安全中心首页数据DTO.
 * 
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月4日
 */
public class MbrSecCenterDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5299547845260605848L;
	/** 手机号码 */
	private String phone;
	/** 是否设置了支付密码 true 代表设置了 false 代表未设置 */
	private Boolean hasPayPwd;

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the hasPayPwd
	 */
	public Boolean isHasPayPwd() {
		return hasPayPwd;
	}

	/**
	 * @param hasPayPwd
	 *            the hasPayPwd to set
	 */
	public void setHasPayPwd(Boolean hasPayPwd) {
		this.hasPayPwd = hasPayPwd;
	}

}
