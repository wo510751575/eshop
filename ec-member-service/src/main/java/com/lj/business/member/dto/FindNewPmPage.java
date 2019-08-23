package com.lj.business.member.dto;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindNewPmPage.
 */
public class FindNewPmPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7186893069530297917L;



	/**
	 * 商户编号(必填) .
	 */
	private String merchantNo;

	/**
	 * 导购编号(必填)  .
	 */
	private String memberNoGm;
	
	

	/**
	 * Gets the 商户编号(必填) .
	 *
	 * @return the 商户编号(必填) 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号(必填) .
	 *
	 * @param merchantNo the new 商户编号(必填) 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 导购编号(必填)  .
	 *
	 * @return the 导购编号(必填)  
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号(必填)  .
	 *
	 * @param memberNoGm the new 导购编号(必填)  
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindNewPmPage [merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm).append("]");
		return builder.toString();
	}



}
