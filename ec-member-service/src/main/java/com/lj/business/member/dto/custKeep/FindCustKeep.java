package com.lj.business.member.dto.custKeep;

import java.io.Serializable;

/**
 * The Class FindCustKeep.
 */
public class FindCustKeep implements Serializable { 

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -129011439190849373L;
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
		builder.append("FindCustKeep [code=").append(code).append("]");
		return builder.toString();
	}
}
