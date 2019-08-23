package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindMerchant.
 */
public class FindMerchant implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5272619738857111286L; 
	
	/** The code. */
	private String code;
	
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMerchant [code=").append(code).append("]");
		return builder.toString();
	}

}
