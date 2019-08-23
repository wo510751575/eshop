package com.lj.business.cf.dto;

import java.io.Serializable;

/**
 * The Class FindClientFollowClientKeep.
 */
public class FindClientFollowClientKeep implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4693226168432180760L;
	
	 /**
     * 商户号  .
     */
    private String merchantNo;

    /**
     * 会员号  .
     */
    private String memberNo;

    /**
     * 导购编号 .
     */
    private String memberNoGm;

	/**
	 * Gets the 商户号  .
	 *
	 * @return the 商户号  
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户号  .
	 *
	 * @param merchantNo the new 商户号  
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 会员号  .
	 *
	 * @return the 会员号  
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param memberNo the new 会员号  
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindClientFollowClientKeep [merchantNo=")
				.append(merchantNo).append(", memberNo=").append(memberNo)
				.append(", memberNoGm=").append(memberNoGm).append("]");
		return builder.toString();
	}

}
