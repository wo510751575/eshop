package com.lj.business.member.dto.integralSet;

import com.lj.base.core.pagination.PageParamEntity; 

// TODO: Auto-generated Javadoc
/**
 * The Class FindIntegralSetPage.
 */
public class FindIntegralSetPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4719303571947897721L; 
	
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
		builder.append("FindIntegralSetPage [code=").append(code).append("]");
		return builder.toString();
	}
	
}
