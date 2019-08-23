package com.lj.business.member.dto;

import java.io.Serializable;

public class FindManagersReturnDto implements Serializable {

	/**
	 * Generate cron.
	 *
	 * @param
	 * @param
	 * @throws
	 */
	private static final long serialVersionUID = 3183169888351109214L;

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

	/**
	 * 会员编号 .
	 */
	private String memberNo;

	/**
	 * 手机编号 .
	 */
	private String mobile;

	/**
	 * 总分数 .
	 */
	private int scoreSum;

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

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public int getScoreSum() {
		return scoreSum;
	}

	public void setScoreSum(int scoreSum) {
		this.scoreSum = scoreSum;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuidAndManagerDto [memberType=").append(memberType).append(", headAddress=").append(headAddress).append(", memberName=").append(memberName).append(", scoreSum=")
				.append(scoreSum).append("]");
		return builder.toString();
	}
}
