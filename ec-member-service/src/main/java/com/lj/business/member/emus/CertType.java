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
public enum CertType
{

	/** 身份证. */
	I_CARD("身份证"),

	/** 军官证. */
	O_CERT("军官证"),

	/** 护照. */
	PASSPORT("护照"),

	/** 台胞证（台湾居民来往大陆通行证）. */
	TW_CEP("台胞证"),
	/** 港澳居民来往内地通行证. */
	HK_M_RMP("港澳居民来往内地通行证"),

	/**
	 * 港澳通行证（内地居民来往港澳通行证）.
	 *
	 * @param chName the ch name
	 */
	/*	HK_M_PASS("港澳通行证")*/

	;


	/**
	 * Instantiates a new member status.
	 *
	 * @param chName the ch name
	 */
	CertType(String name){
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