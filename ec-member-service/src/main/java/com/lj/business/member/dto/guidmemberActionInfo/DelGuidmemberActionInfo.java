package com.lj.business.member.dto.guidmemberActionInfo;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class DelGuidmemberActionInfo.
 */
public class DelGuidmemberActionInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5758963962883038842L; 
	
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
		builder.append("DelGuidmemberActionInfo [code=").append(code)
				.append("]");
		return builder.toString();
	}
	
}
