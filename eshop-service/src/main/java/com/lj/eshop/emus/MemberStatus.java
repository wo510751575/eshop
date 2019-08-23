/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */

package com.lj.eshop.emus;

/**
 * 
 * 类说明：会员状态.
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年8月23日
 */
public enum MemberStatus {

	/** 正常. */
	NORMAL("0", "正常"),

	/** 注销. */
	CANCEL("1", "注销"),

	/** 冻结. */
	FREEZE("2", "冻结");

	MemberStatus(String value, String chName) {
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
	 * @param value
	 *            the value to set
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
	 * @param chName
	 *            the chName to set
	 */
	public void setChName(String chName) {
		this.chName = chName;
	}

	public static void main(String[] args) {
		// 循环输出 值
		for (MemberStatus e : MemberStatus.values()) {
			System.out.println(e.toString());
			System.out.println(e + ":" + e.getValue() + "," + e.getChName());
		}
		System.out.println(MemberStatus.FREEZE.getValue());
	}

}
