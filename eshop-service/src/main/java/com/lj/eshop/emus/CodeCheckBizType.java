/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.emus;

/**
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年8月23日
 */
public enum CodeCheckBizType {
	//业务类型 0:注册验证码 1:修改手机号验证 2:提现验证码 3:B端用户登录, 4开店验证码
	/** 注册验证码*/
	REG("0", "注册验证码"),
	/** 修改手机号验证*/
	CHANGE_MOBLIE("1", "修改手机号验证"), 
	/** 提现验证码*/
	WITHDRAW("2", "提现验证码"),
	/** 提现验证码*/
	LOGIN("3", "登录验证码"),
	/** 开店验证码*/
	OPEN_SHOP("4", "开店验证码"),
	/** 修改登录密码*/
	CHANGE_LOGIN_PWD("5", "修改登录密码"),
	/** 找回登录密码*/
	GET_LOGIN_PWD("6", "找回登录密码")
	;
	
	CodeCheckBizType(String value, String chName) {
		this.value = value;
		this.chName = chName;
	}

	private String value;// DB 存贮值
	private String chName;// 值对应的中文描述
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the chName
	 */
	public String getChName() {
		return chName;
	}
	/**
	 * @param chName the chName to set
	 */
	public void setChName(String chName) {
		this.chName = chName;
	}
	
	
}
