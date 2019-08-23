package com.lj.business.cf.dto.comTask;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindComTaskPage.
 */
public class FindComTaskPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3163286745846315408L; 
	
	/**
     * 商户编号 .
     */
    private String merchantNo;

	/**
	 * 导购编号
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

	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskPage [merchantNo=").append(merchantNo)
				.append("]");
		return builder.toString();
	}


}
