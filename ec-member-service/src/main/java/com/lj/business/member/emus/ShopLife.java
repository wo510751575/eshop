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
 * 类说明：门店开店年限
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月12日
 */
public enum ShopLife {


	/** 三个月. */
	MARCH("三个月"),

	/** 六个月. */
	JUNE("六个月"),

	/** 一年. */
	ONEYEAR("一年"),

	/** 二年. */
	TWOYEARS("二年"),

	/** 三年. */
	THREEYEARS("三年"),

	/** 三年以上. */
	THREEYEARSABOVE("三年以上"),
	;

	ShopLife(String name){
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
