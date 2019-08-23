package com.lj.business.member.dto.behaviorPm;

import java.io.Serializable;

/**
 * The Class FindBehaviorPm.
 */
public class FindBehaviorPm implements Serializable { 
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7292911070497231133L;
	/**
     * CODE .
     */
    private String code;
    
    /**
     * 会员号  .
     */
    private String memberNo;

	/**
	 * Gets the cODE .
	 *
	 * @return the cODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindBehaviorPm [code=").append(code)
				.append(", memberNo=").append(memberNo).append("]");
		return builder.toString();
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
    
}
