package com.lj.business.member.dto.guidmemberActionInfo;

import com.lj.base.core.pagination.PageParamEntity; 

// TODO: Auto-generated Javadoc
/**
 * The Class FindGuidmemberActionInfoPage.
 */
public class FindGuidmemberActionInfoPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1463183311797274504L; 
	
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
		builder.append("FindGuidmemberActionInfoPage [code=").append(code)
				.append("]");
		return builder.toString();
	}
	
}
