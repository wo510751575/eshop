package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdatePersonMemberBaseRatioClientInfoDto.
 */
public class UpdatePersonMemberBaseRatioClientInfoDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8585215352083578336L;
	
	/** 完成度. */
	private Double ratioClientInfo;
	
	/** 客户编号. */
	private String memberNo;

	/**
	 * Gets the ratio client info.
	 *
	 * @return the ratio client info
	 */
	public Double getRatioClientInfo() {
		return ratioClientInfo;
	}

	/**
	 * Sets the ratio client info.
	 *
	 * @param ratioClientInfo the new ratio client info
	 */
	public void setRatioClientInfo(Double ratioClientInfo) {
		this.ratioClientInfo = ratioClientInfo;
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
		builder.append(
				"UpdatePersonMemberBaseRatioClientInfoDto [ratioClientInfo=")
				.append(ratioClientInfo).append(", memberNo=").append(memberNo)
				.append("]");
		return builder.toString();
	}

}
