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
 * CreateDate: 2017年9月8日
 */
public enum PaymentType {
	/** 0：在线支付 */
	ONLINE(0, "在线支付"),
	/** 线下支付. */
	OFFLINE(1, "线下支付"),
	/** 预存款支付 */
	DEPOSIT(2, "预存款支付"),
	/** 充值支付*/
	RECHARGE(3, "充值支付");
	
	PaymentType(int value, String chName) {
		this.value = value;
		this.chName = chName;
	}

	private int value;// DB 存贮值
	private String chName;// 值对应的中文描述
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
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
