package com.lj.business.member.dto.guidMemberIntegral;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindGuidMemberIntegral.
 */
public class FindGuidMemberIntegral implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5098399070500806624L; 
	
	/** The code. */
	private String code;
	
	/** 日期. */
	private Date daySt;
	
	/** 积分类型. */
	private String integralType;
	
	/**  导购编号. */
	private String memberNo;

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
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the day st.
	 *
	 * @return the day st
	 */
	public Date getDaySt() {
		return daySt;
	}

	/**
	 * Sets the day st.
	 *
	 * @param daySt the new day st
	 */
	public void setDaySt(Date daySt) {
		this.daySt = daySt;
	}

	/**
	 * Gets the integral type.
	 *
	 * @return the integral type
	 */
	public String getIntegralType() {
		return integralType;
	}

	/**
	 * Sets the integral type.
	 *
	 * @param integralType the new integral type
	 */
	public void setIntegralType(String integralType) {
		this.integralType = integralType;
	}
	
	/**
	 * Gets the member no.
	 *
	 * @return the member no
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the member no.
	 *
	 * @param memberNo the new member no
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
		builder.append("FindGuidMemberIntegral [code=").append(code)
				.append(", daySt=").append(daySt).append(", integralType=")
				.append(integralType).append(", memberNo=").append(memberNo)
				.append("]");
		return builder.toString();
	}

}
