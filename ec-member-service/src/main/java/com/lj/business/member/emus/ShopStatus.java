/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */

package com.lj.business.member.emus;

/**
 * 
 * 
 * 类说明：门店状态
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月5日
 */
public enum ShopStatus {


	/** 已经开业. */
	OPENED("已经开业")
	,

	/** 暂停营业. */
	SUSPEND("暂停营业"),

	/** 尚在装修. */
	INDECORATION("尚在装修")
	;

	ShopStatus(String name){
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
