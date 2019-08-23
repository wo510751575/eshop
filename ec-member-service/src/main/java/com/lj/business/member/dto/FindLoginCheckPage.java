package com.lj.business.member.dto;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindLoginCheckPage.
 */
public class FindLoginCheckPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1844497968330002705L; 

	/** The member no. */
	private String memberNo;

	/**
	 * Gets the member no.
	 *
	 * @return the memberNo
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the member no.
	 *
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

}
