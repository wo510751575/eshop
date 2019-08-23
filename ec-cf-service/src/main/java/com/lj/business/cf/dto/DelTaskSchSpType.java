package com.lj.business.cf.dto;

import java.io.Serializable;

/**
 * The Class DelTaskSchSpType.
 */
public class DelTaskSchSpType implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2617024270557725056L; 
	
	
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
		builder.append("DelTaskSchSpType [code=").append(code).append("]");
		return builder.toString();
	}

}
