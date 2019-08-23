package com.lj.business.cf.dto.comTaskWorkflow;

import java.io.Serializable;

/**
 * The Class DelComTaskWorkflow.
 */
public class DelComTaskWorkflow implements Serializable { 
	
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6773722160367250327L;
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
		builder.append("DelComTaskWorkflow [code=").append(code).append("]");
		return builder.toString();
	}
    
    
}
