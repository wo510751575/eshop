package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindAgreementMerchant.
 */
public class FindAgreementMerchant implements Serializable{
	 
 	/** Generate cron. */
	private static final long serialVersionUID = 6695626588878026933L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String merchantNo;

	/**
	 * Gets the cODE .
	 *
	 * @return the cODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 会员号  .
	 *
	 * @return the 会员号  
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param merchantNo the new 会员号  
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
		builder.append("FindAgreementMerchant [code=").append(code)
				.append(", merchantNo=").append(merchantNo).append("]");
		return builder.toString();
	}

}
