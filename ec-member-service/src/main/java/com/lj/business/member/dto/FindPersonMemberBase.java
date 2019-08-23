package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindPersonMemberBase.
 */
public class FindPersonMemberBase implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2770571931218201266L; 
	
	/** The code. */
	private String code;
	
	/** The member no. */
	private String memberNo;
	
	/** The no wx. */
	private String noWx;
	/**手机号码 */
	private String mobile;
	
	/**商户编号*/
	private String merchantNo;
	/**
	 * 导购编号
	 */
	private String memberNoGm;
	

	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the member no.
	 *
	 * @return the member no
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the member no.
	 *
	 * @param memberNo the member no
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the no wx.
	 *
	 * @return the no wx
	 */
	public String getNoWx() {
		return noWx;
	}

	/**
	 * Sets the no wx.
	 *
	 * @param noWx the no wx
	 */
	public void setNoWx(String noWx) {
		this.noWx = noWx;
	}

	@Override
	public String toString() {
		return "FindPersonMemberBase [code=" + code + ", memberNo=" + memberNo
				+ ", noWx=" + noWx + ", mobile=" + mobile + ", merchantNo="
				+ merchantNo + ", memberNoGm=" + memberNoGm + "]";
	}
	
}
