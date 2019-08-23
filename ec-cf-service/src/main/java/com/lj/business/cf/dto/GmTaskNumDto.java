package com.lj.business.cf.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class GmTaskNumDto.
 */
public class GmTaskNumDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5206131189681346059L;
	
	/** 导购编号. */
	private String memberNo;
	
	/** 导购姓名. */
	private String memberNoName;
	
	/** 日均数量. */
	private Long numDay;

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

	/**
	 * Gets the member no name.
	 *
	 * @return the member no name
	 */
	public String getMemberNoName() {
		return memberNoName;
	}

	/**
	 * Sets the member no name.
	 *
	 * @param memberNoName the new member no name
	 */
	public void setMemberNoName(String memberNoName) {
		this.memberNoName = memberNoName;
	}

	/**
	 * Gets the num day.
	 *
	 * @return the num day
	 */
	public Long getNumDay() {
		return numDay;
	}

	/**
	 * Sets the num day.
	 *
	 * @param numDay the new num day
	 */
	public void setNumDay(Long numDay) {
		this.numDay = numDay;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GmTaskNumDto [memberNo=").append(memberNo)
				.append(", memberNoName=").append(memberNoName)
				.append(", numDay=").append(numDay).append("]");
		return builder.toString();
	}
	
}
