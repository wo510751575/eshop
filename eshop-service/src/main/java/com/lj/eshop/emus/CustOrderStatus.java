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
 * 类说明：定制单状态
 *  
 * 
 * <p>
 * 详细描述：
 * 0:待报价 
	1:待用户确认 
	2:待付款 
	3：已付定金
	4：待付尾款
	5：已付款 
	6：待发货 
	7：待收货  
	8：完成 
	9：已取消
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月30日
 */
public enum CustOrderStatus {
	/** 待报价. */
	UNOFFER("0", "待报价 "),
	/** 待用户确认 . */
	UNCONFIRM("1", "待用户确认  "),
	/** 待付款. */
	UNPAID("2", "待付款"),
	/** 已付定金--作废. 
	 * @deprecated
	 * */
	DEPOSIT("3", "已付定金"),
	/** 待付尾款. */
	UNRETAINAGE("4", "待付尾款"),
	/**
	 * 已付款
	 */
	PAYMENT("5", "已付款"),
	/** 待发货 --作废 已付款就是待发货. 
	 * @deprecated
	 * */
	UNSHIPPED("6", "待发货"),
	/** 待收货. */
	SHIPPED("7", "待收货"),
	/** 完成. */
	SUCCESS("8", "完成"),
	/** 已取消. */
	CANCEL("9", "已取消"),
	;
	
	CustOrderStatus(String value, String chName) {
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
