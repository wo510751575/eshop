package com.lj.business.cf.dto.clientKeep;

import java.io.Serializable;

/**
 * The Class FindClientKeep.
 */
public class FindClientKeep implements Serializable {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6956620107899791293L;
	
	/** The code. */
	private String code;
	
	/** The memberNo. */
	private String memberNo;
	
	
	/** The code. */
	private String memberGMCode;
	
	/**
	 * 维护总表no
	 */
	private String ckNo;
	
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
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getMemberGMCode() {
		return memberGMCode;
	}

	/**
	 * Sets the code.
	 *
	 * @param memberGMCode the new code
	 */
	public void setMemberGMCode(String memberGMCode) {
		this.memberGMCode = memberGMCode;
	}
	
	public String getCkNo() {
		return ckNo;
	}

	public void setCkNo(String ckNo) {
		this.ckNo = ckNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindClientKeep [code=").append(code)
				.append(", memberNo=").append(memberNo)
				.append(", memberGMCode=").append(memberGMCode)
				.append(", ckNo=").append(ckNo).append("]");
		return builder.toString();
	}

}
