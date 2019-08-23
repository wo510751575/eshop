package com.lj.business.cf.dto.clientFollowSummary;

import com.lj.base.core.pagination.PageParamEntity;

public class FindBuyRecordPage extends PageParamEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5547617805729094343L;

	 /**
     * 商户编号（必填） .
     */
    private String merchantNo;

    /**
     * 客户编号（必填） .
     */
    private String memberNo;

    /**
     * 导购编号（必填） .
     */
    private String memberNoGm;

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the new 商户编号 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 客户编号 .
	 *
	 * @return the 客户编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 客户编号 .
	 *
	 * @param memberNo the new 客户编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 导购编号 .
	 *
	 * @return the 导购编号 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNoGm the new 导购编号 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindBuyRecordPage [merchantNo=").append(merchantNo)
				.append(", memberNo=").append(memberNo).append(", memberNoGm=")
				.append(memberNoGm).append("]");
		return builder.toString();
	}


	
}
