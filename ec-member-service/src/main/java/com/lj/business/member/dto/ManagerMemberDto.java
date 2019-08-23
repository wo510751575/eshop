package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class ManagerMemberDto.
 */
public class ManagerMemberDto implements Serializable {

	/** Generate cron. */
	private static final long serialVersionUID = -6101102058299004398L;

	/**
	 * CODE .
	 */
	private String code;
	/**
	 * 店长编号 .
	 */
	private String memberNo;
	/**
	 * 会员类型 店长：SHOP 老板：BOSS .
	 */
	private String memberType;

	/**
	 * 分店编号 .
	 */
	private String memberNoShop;

	/**
	 * 手机号码 .
	 */
	private String mobile;

	/**
	 * Gets the cODE .
	 *
	 * @return the cODE
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code
	 *            the new cODE
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 店长编号 .
	 *
	 * @return the 店长编号
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 店长编号 .
	 *
	 * @param memberNo
	 *            the new 店长编号
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 会员类型 店长：SHOP 老板：BOSS .
	 *
	 * @return the 会员类型 店长：SHOP 老板：BOSS
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * Sets the 会员类型 店长：SHOP 老板：BOSS .
	 *
	 * @param memberType
	 *            the new 会员类型 店长：SHOP 老板：BOSS
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * Gets the 分店编号 .
	 *
	 * @return the 分店编号
	 */
	public String getMemberNoShop() {
		return memberNoShop;
	}

	/**
	 * Sets the 分店编号 .
	 *
	 * @param memberNoShop
	 *            the new 分店编号
	 */
	public void setMemberNoShop(String memberNoShop) {
		this.memberNoShop = memberNoShop;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "ManagerMemberDto [code=" + code + ", memberNo=" + memberNo + ", memberType=" + memberType + ", memberNoShop=" + memberNoShop + "]";
	}

}
