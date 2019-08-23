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
 * 类说明：订单状态
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月28日
 */
public enum OrderStatus {
	/** 待付款. */
	UNPAID("0", "待付款"),
	/** 待发货. */
	UNSHIPPED("1", "待发货"),
	/** 待收货. */
	SHIPPED("2", "待收货"),
	/** 待评价. */
	UNEVL("3", "待评价"),
	/** 申请退货. */
	UNRETURNS("4", "申请退货"),
	/** 申请换货. */
	UNCHANGE("5", "申请换货"),
	/** 完成. */
	COMPLETED("6", "完成"),
	/** 退货成功. */
	RETURNS("7", "退货成功"),
	/** 换货成功. */
	CHANGE("8", "换货成功"),
	/** 已取消. */
	CANCEL("9", "已取消"),;
	
	OrderStatus(String value, String chName) {
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
