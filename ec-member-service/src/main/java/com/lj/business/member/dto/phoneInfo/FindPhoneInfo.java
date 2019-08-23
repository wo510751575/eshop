package com.lj.business.member.dto.phoneInfo;

import java.io.Serializable;

/**
 * The Class FindPhoneInfo.
 */
public class FindPhoneInfo implements Serializable { 

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8522053980921276497L;
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
		builder.append("FindPhoneInfo [code=").append(code).append("]");
		return builder.toString();
	}
}
