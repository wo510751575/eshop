/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */

package com.lj.business.member.emus;

/**
 * 类说明：实名认证标识
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * CreateDate: 2017-5-28
 */
public enum NameAuthFlag {
	
	/** 未实名认证. */
	N("未实名认证"),
	
	/** 实名认证. */
	Y("实名认证");


	/**
	 * Instantiates a new member status.
	 *
	 * @param chName the ch name
	 */
	NameAuthFlag(String chName){
		this.chName = chName;
	}

	/** 中文名称. */
	private String chName;

	/**
	 * Gets the 中文名称.
	 *
	 * @return the 中文名称
	 */
	public String getChName() {
		return chName;
	}

	/**
	 * Sets the 中文名称.
	 *
	 * @param chName the new 中文名称
	 */
	public void setChName(String chName) {
		this.chName = chName;
	}
}
