package com.lj.business.member.dto;

public class FindMemberRecord implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2423726163137161831L;
	/**
	 * 导购编号 .
	 */
	private String memberNoGm;
	/**
	 * 商户编号 .
	 */
	private String merchantNo;

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
}
