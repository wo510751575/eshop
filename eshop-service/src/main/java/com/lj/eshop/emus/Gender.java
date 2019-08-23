/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */

package com.lj.eshop.emus;

/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-5-28
 */
public enum Gender {
	
	/** 男. */
	MALE("FEMALE", "男"),
	
	/** 女. */
	FEMALE("MALE", "女"),
	
	;
	Gender(String value, String name){
		this.value = value;
		this.name = name;
	}
	
	private String value;
	private String name;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
