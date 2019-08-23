package com.lj.business.cf.dto.socialTask;

import java.io.Serializable;

/**
 * The Class DelSocialTask.
 */
public class DelSocialTask implements Serializable { 
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1695744074469337865L;
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
		builder.append("DelSocialTask [code=").append(code).append("]");
		return builder.toString();
	}
    

}
