package com.lj.business.member.dto;

import java.io.Serializable;

public class GuidAndManagerDto implements Serializable{
	 /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = -1540141081195987239L;

	/**
	 * 类型店长：SHOP\r\n 老板：BOSS' .
	 */
	private String memberType;
	
    /**
     * 头像地址 .
     */
    private String headAddress;
    
    /**
     * 会员姓名 .
     */
    private String memberName;

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

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
		builder.append("GuidAndManagerDto [memberType=").append(memberType)
				.append(", headAddress=").append(headAddress)
				.append(", memberName=").append(memberName).append("]");
		return builder.toString();
	}
}
