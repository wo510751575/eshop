package com.lj.eshop.emus;

public enum MemberRankApplyStatus {

	/** 待审核. */
	WAIT("0", "审核中"),
	/** 成功. */
	SUCCESS("1", "成功"),
	/** 失败. */
	FAIL("2", "失败");
	
	MemberRankApplyStatus(String value, String chName) {
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
	 * @param value the value to set
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
	 * @param chName the chName to set
	 */
	public void setChName(String chName) {
		this.chName = chName;
	}
}
