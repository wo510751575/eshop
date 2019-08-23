package com.lj.business.member.dto;

import java.io.Serializable;

public class FindInqueryComTaskListNewDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8685889728465789060L;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 会员编号
	 */
	private String memberNo;
	
	/**
	 * 导购编号
	 */
	private String memberNoGm;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the member no gm.
	 *
	 * @return the member no gm
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindInqueryComTaskListNewDto [merchantNo=")
				.append(merchantNo).append(", memberNo=").append(memberNo)
				.append(", memberNoGm=").append(memberNoGm).append("]");
		return builder.toString();
	}
	
}
