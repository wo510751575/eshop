package com.lj.business.cm.dto;

import java.io.Serializable;

/**
 * The Class FindMaterialTypesApp.
 */
public class FindMaterialTypesApp implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7977126336552889736L;

    /**
     * 商户编号（必填） .
     */
    private String merchantNo;

    /**
     * 导购编号（必填）  .
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
	 * Gets the 导购编号  .
	 *
	 * @return the 导购编号  
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号  .
	 *
	 * @param memberNoGm the new 导购编号  
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMaterialTypesApp [merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm).append("]");
		return builder.toString();
	}

	

}
