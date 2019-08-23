package com.lj.business.cf.dto.otherTaskFinishInfo;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class DelOtherTaskFinishInfo.
 */
public class DelOtherTaskFinishInfo implements Serializable { 
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6988968433658329596L;
	
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
		builder.append("DelOtherTaskFinishInfo [code=").append(code)
				.append("]");
		return builder.toString();
	}
	
}
