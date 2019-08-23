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
 * 类说明：门店状态
 *  
 * 
 * <p>
 * 详细描述：0:申请中 1:正常  2:关闭  3:申请失败
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月25日
 */
public enum ShopStatus {
	/** 申请中. */
	IN_APPLY("0", "申请中"),
	/** 正常. */
	NORMAL("1", "正常"),
	/** 关闭. */
	STOP("2", "关闭"),
	/** 申请失败. */
	FAIL("3", "申请失败");
	
	ShopStatus(String value, String chName) {
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
