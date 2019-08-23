package com.lj.business.member.dto;

import java.io.Serializable;

public class FindGuidsDto implements Serializable{
	
     /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = -6764037202012894245L;

	/**
     * 头像地址 .
     */
    private String headAddress;
    
    /**
     * 会员姓名 .
     */
    private String memberName;

	public String getHeadAddress() {
		return headAddress;
	}

	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindGuidsDto [headAddress=").append(headAddress)
				.append(", memberName=").append(memberName).append("]");
		return builder.toString();
	}
    
}
