package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindPmTypePmListByMGMDto.
 */
public class FindPmTypePmListByMGMDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6890087183781291550L;
	
	/** pmcode. */
	private String codePm;

	/**
	 * Gets the code pm.
	 *
	 * @return the code pm
	 */
	public String getCodePm() {
		return codePm;
	}

	/**
	 * Sets the code pm.
	 *
	 * @param codePm the new code pm
	 */
	public void setCodePm(String codePm) {
		this.codePm = codePm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmTypePmListByMGMDto [codePm=").append(codePm)
				.append("]");
		return builder.toString();
	}
	
}
