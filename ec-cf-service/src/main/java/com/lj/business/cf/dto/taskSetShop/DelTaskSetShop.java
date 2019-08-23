package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class DelTaskSetShop.
 */
public class DelTaskSetShop implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4543629924146818276L; 
	
	/** code. */
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
	 * @param code the new code
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
		builder.append("DelTaskSetShop [code=").append(code).append("]");
		return builder.toString();
	}
	
}
