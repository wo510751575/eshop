package com.lj.business.cf.dto.clientInvite;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class DelClientInvite.
 */
public class DelClientInvite implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7298219477249647830L; 
	
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
		builder.append("DelClientInvite [code=").append(code).append("]");
		return builder.toString();
	}
	
}
