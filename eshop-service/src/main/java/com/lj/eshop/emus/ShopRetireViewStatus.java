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
 * 类说明：退款状态
 *  
 * 
 * <p>
 * 详细描述：1成功 2失败
 *   
 * @Company: 领居科技有限公司
 * @author 林进权
 *   
 * CreateDate: 2017年8月26日
 */
public enum ShopRetireViewStatus {
	/** 申请中. */
	APPLY("0", "申请中"),
	/** 正常. */
	SUCCESS("1", "正常"),
	/** 失败. */
	FAIL("2", "关闭"),
	
	/** 审核中. */
	RETIRE_APPLY("11", "申请中"),
	/** 审核成功. */
	RETIRE_SUCCESS("13", "审核通过"),
	/** 审核失败. */
	RETIRE_FAIL("15", "审核失败"),
	/** 退款成功. */
	RETIRE_BACK("17", "已退款")
	;
	
//	11审核中, 13审核成功,15审核失败
	
	ShopRetireViewStatus(String value, String chName) {
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
	
	/**
	 * @return the chName
	 */
	public static String getChName(String viewStatusVal) {
		String cnName = null;
		ShopRetireViewStatus[] statuss = ShopRetireViewStatus.values();
		for (ShopRetireViewStatus shopRetireViewStatus : statuss) {
			if(shopRetireViewStatus.value.equals(viewStatusVal)) {
				cnName = shopRetireViewStatus.getChName();
				break;
			}
		}
		return cnName;
	}
}
