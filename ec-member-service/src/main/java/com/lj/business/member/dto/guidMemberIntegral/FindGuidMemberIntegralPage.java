package com.lj.business.member.dto.guidMemberIntegral;

import com.lj.base.core.pagination.PageParamEntity; 

// TODO: Auto-generated Javadoc
/**
 * The Class FindGuidMemberIntegralPage.
 */
public class FindGuidMemberIntegralPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5166664437347402765L; 
	
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
		builder.append("FindGuidMemberIntegralPage [code=").append(code)
				.append("]");
		return builder.toString();
	}
	
}
