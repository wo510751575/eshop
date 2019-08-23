package com.lj.business.cf.dto;

import java.io.Serializable;

/**
 * The Class FindTaskSchSpType.
 */
public class FindTaskSchSpType implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2068161059394250770L; 
	
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
		builder.append("FindTaskSchSpType [code=").append(code).append("]");
		return builder.toString();
	}
    
	

}
