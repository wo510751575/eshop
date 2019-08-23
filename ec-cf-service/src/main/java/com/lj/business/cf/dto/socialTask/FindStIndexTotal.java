package com.lj.business.cf.dto.socialTask;

import java.io.Serializable;

public class FindStIndexTotal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1607265122555098778L;

	 /**
     * 商户编号 .
     */
    private String merchantNo;
    
    /**
     * 导购编号 .
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
		builder.append("FindStIndexTotal [merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm).append("]");
		return builder.toString();
	}

	
}
