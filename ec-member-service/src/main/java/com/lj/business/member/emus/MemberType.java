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
 * 详细描述： 会员类型.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-6-4
 */
public enum MemberType {
   
	/** 个人. */
	PERSON("个人"),

	/** 导购. */
	GUID("导购"),

	/** 店长. */
	SHOP("店长"),

	/**区域经理*/
	AREA_MAN("区域经理"),

	/** 老板. */
	BOSS("老板");

	MemberType(String name){
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
