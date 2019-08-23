/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */

package com.lj.business.member.emus;


/**
 * 类说明：会员锁定状态
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * CreateDate: 2017-5-28
 */
public enum LockStatus {

	/** 正常. */
	NORMAL("正常"),
	
	/** 密码输入错误超过次数,自动锁定会员,登录锁定. */
	AUTOLOCK("登录锁定"),
	
	/** 人工锁定. */
	MANUALLOCK("人工锁定");

	/**
	 * Instantiates a new member status.
	 *
	 * @param chName the ch name
	 */
	LockStatus(String chName){
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
