package com.lj.business.member.dto;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindMerchantPage.
 */
public class FindMerchantPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 246245244254900774L; 

	
	
	/** The merchant no. */
	private String merchantNo;



	/**
	 * Gets the merchant no.
	 *
	 * @return the merchant no
	 */
	public String getMerchantNo() {
		return merchantNo;
	}



	/**
	 * Sets the merchant no.
	 *
	 * @param merchantNo the merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMerchantPage [merchantNo=").append(merchantNo)
				.append("]");
		return builder.toString();
	}



}
