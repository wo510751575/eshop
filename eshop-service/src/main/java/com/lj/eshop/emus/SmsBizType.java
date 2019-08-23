/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.emus;

/**
 * 
 * 
 * 类说明：短信业务类型
 *  
 * 
 * <p>
 * 详细描述：业务类型 0:注册验证码 1:修改手机号验证 2:提现验证码 3:B端用户登录
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年9月4日
 */
public enum SmsBizType {
	/** 注册验证码. */
	REGISTER("0", "注册验证码"),

	/** 修改手机号验证. */
	MODIFY("1", "修改手机号验证"),
	
	/** 提现验证码. */
	WITHDRAW("2", "提现验证码"),

	/** B端用户登录. */
	LOGIN("3", "B端用户登录"),
	;
	
	SmsBizType(String value, String chName) {
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
