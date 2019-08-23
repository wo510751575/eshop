package com.lj.business.cm.dto.merchantParams;

import java.io.Serializable;

/**
 * The Class FindMerchantParams.
 */
public class FindMerchantParams implements Serializable { 

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1577671266389419463L;
	/**
     * CODE .
     */
    private String code;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMerchantParams [code=").append(code).append("]");
		return builder.toString();
	}
    
}
