package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class DelPersonMemberBase.
 */
public class DelPersonMemberBase implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1049144899116575424L; 
	
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
}
