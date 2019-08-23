/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */

package com.lj.business.member.emus;

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
	MALE("男"),
	
	/** 女. */
	FEMALE("女"),
	
	/** 未知. */
	UNKNOWN("未知");
	
	Gender(String name){
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
