package com.lj.business.cf.dto.pmAbandon;

import java.io.Serializable;

/**
 * The Class FindPmAbandon.
 */
public class FindPmAbandon implements Serializable {
	
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1726335683315980869L;
	
	/** The code. */
	private String code;
	
	/** The memberNo. */
	private String memberNo;
	
	/** The memberGMCode. */
	private String memberGMCode;
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
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
	/**
	 * Gets the memberNo.
	 *
	 * @return the memberNo
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the memberNo.
	 *
	 * @param memberNo the new memberNo
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the memberGMCode.
	 *
	 * @return the memberGMCode
	 */
	public String getMemberGMCode() {
		return memberGMCode;
	}

	/**
	 * Sets the memberGMCode.
	 *
	 * @param memberGMCode the new memberGMCode
	 */
	public void setMemberGMCode(String memberGMCode) {
		this.memberGMCode = memberGMCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindPmAbandon [code=" + code + ", getCode()=" + getCode()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
