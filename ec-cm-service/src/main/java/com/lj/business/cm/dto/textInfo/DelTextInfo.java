package com.lj.business.cm.dto.textInfo;

import java.io.Serializable;

/**
 * The Class DelTextInfo.
 */
public class DelTextInfo implements Serializable { 

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8980692672621094442L;
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
		builder.append("DelTextInfo [code=").append(code).append("]");
		return builder.toString();
	}
    
}
