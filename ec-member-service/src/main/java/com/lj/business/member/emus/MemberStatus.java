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
 * 详细描述：会员状态.
 *
 * @author 彭阳
 * 
 * CreateDate: 2017-5-27
 */
public enum MemberStatus {

	/** 正常. */
	NORMAL("正常")
	,

	/** 注销. */
	CANCEL("注销"),

	/** 冻结. */
	FREEZE("冻结")
	;

	/**
	 * Instantiates a new member status.
	 *
	 * @param chName the ch name
	 */
	MemberStatus(String name){
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
