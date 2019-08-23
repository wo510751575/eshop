package com.lj.business.member.dto.behaviorInfoPm;

import java.io.Serializable;

/**
 * The Class DelBehaviorInfoPm.
 */
public class DelBehaviorInfoPm implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 535489057148759171L; 
	
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
		builder.append("DelBehaviorInfoPm [code=").append(code).append("]");
		return builder.toString();
	}

}
