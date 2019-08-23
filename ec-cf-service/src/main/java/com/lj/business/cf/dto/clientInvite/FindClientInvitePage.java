package com.lj.business.cf.dto.clientInvite;

import com.lj.base.core.pagination.PageParamEntity; 

// TODO: Auto-generated Javadoc
/**
 * The Class FindClientInvitePage.
 */
public class FindClientInvitePage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 137947910583989942L; 
	
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
		builder.append("FindClientInvitePage [code=").append(code).append("]");
		return builder.toString();
	}
	
}
