package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindPmInfoAll.
 */
public class FindPmInfoAll implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2124738072708625614L;



	/**
	 * 客户编号(必填) .
	 */
	private String memberNo;


	/**
	 * 导购编号(必填) .
	 */
	private String memberNoGm;


	/**
	 * Gets the 客户编号 .
	 *
	 * @return the 客户编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}


	/**
	 * Sets the 客户编号 .
	 *
	 * @param memberNo the new 客户编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	/**
	 * Gets the 导购编号 .
	 *
	 * @return the 导购编号 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}


	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNoGm the new 导购编号 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmInfoAll [memberNo=").append(memberNo)
				.append(", memberNoGm=").append(memberNoGm).append("]");
		return builder.toString();
	}


}
