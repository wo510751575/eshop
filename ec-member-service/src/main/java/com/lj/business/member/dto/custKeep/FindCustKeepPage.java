package com.lj.business.member.dto.custKeep;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindCustKeepPage.
 */
public class FindCustKeepPage extends PageParamEntity { 

	
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5136622358312090890L;
	/**
     * 会员号  .
     */
    private String memberNo;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindCustKeepPage [memberNo=").append(memberNo)
				.append("]");
		return builder.toString();
	}
	
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
}
