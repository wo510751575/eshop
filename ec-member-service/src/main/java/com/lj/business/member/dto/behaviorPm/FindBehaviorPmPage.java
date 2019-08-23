package com.lj.business.member.dto.behaviorPm;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindBehaviorPmPage.
 */
public class FindBehaviorPmPage extends PageParamEntity { 
	
	
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1244944599480297154L;
	/**
     * 会员号  .
     */
    private String memberNo;

	/**
	 * Gets the 会员号  .
	 *
	 * @return the 会员号  
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param memberNo the new 会员号  
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindBehaviorPmPage [memberNo=").append(memberNo)
				.append("]");
		return builder.toString();
	}
	
}
