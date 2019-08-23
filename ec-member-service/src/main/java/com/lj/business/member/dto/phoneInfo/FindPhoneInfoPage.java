package com.lj.business.member.dto.phoneInfo;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindPhoneInfoPage.
 */
public class FindPhoneInfoPage extends PageParamEntity { 

	
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8051853800755204411L;
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
		builder.append("FindPhoneInfoPage [memberNo=").append(memberNo)
				.append("]");
		return builder.toString();
	}
}
