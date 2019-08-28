/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.emus;

/**
 * 
 * 类说明：
 *  地址是否完善
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 *   
 * CreateDate: 2017年10月11日
 */
public enum ShopReceiveStatus {
	/** 未完善. */
	NOT_COMPLETE("0", "未完善"),
	
	/** 地址已经完善. */
	COMPLETEED("1", "地址已经完善")
	;
	
	ShopReceiveStatus(String value, String chName) {
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
