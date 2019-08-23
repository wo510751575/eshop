package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindMerchantDto.
 */
public class FindMerchantDto implements Serializable{
	 
 	/** Generate cron. */
	private static final long serialVersionUID = 1510207103470751172L;
	
	/** The code. */
	private String code;
	
	/** The merchant no. */
	private String merchantNo;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

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
		builder.append("FindMerchant [code=").append(code)
				.append(", merchantNo=").append(merchantNo).append("]");
		return builder.toString();
	}
}
