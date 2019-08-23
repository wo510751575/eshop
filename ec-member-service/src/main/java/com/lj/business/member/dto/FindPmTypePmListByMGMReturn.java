package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindPmTypePmListByMGMReturn.
 */
public class FindPmTypePmListByMGMReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2653318906817732616L;
	
	/** 分组类型. */
	private String pmTypeType;

	/**
	 * Gets the pm type type.
	 *
	 * @return the pm type type
	 */
	public String getPmTypeType() {
		return pmTypeType;
	}

	/**
	 * Sets the pm type type.
	 *
	 * @param pmTypeType the new pm type type
	 */
	public void setPmTypeType(String pmTypeType) {
		this.pmTypeType = pmTypeType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmTypePmListByMGMReturn [pmTypeType=")
				.append(pmTypeType).append("]");
		return builder.toString();
	}
	
}
