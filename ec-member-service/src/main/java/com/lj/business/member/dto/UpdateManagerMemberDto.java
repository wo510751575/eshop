package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class UpdateManagerMemberDto.
 */
public class UpdateManagerMemberDto implements Serializable{

	 /** Generate cron. */
	private static final long serialVersionUID = 4853224696045549049L;

    /**
     * 会员类型
             店长：SHOP
             老板：BOSS .
     */
    private String memberType;
    /**
     * 店长编号 .
     */
    private String memberNo;

    /**
     * 会员姓名 .
     */
    private String memberName;

    /**
     * 邮箱 .
     */
    private String email;
    /**
     * 区域CODE .
     */
    private String areaCode;

    /**
     * 省CODE .
     */
    private String provinceCode;

    /**
     * 市CODE .
     */
    private String cityCode;
    /**
     * 市区CODE .
     */
    private String cityAreaCode;

    /**
     * 住址 .
     */
    private String address;
    /**
     * 性别 .
     */
    private String sex;
    /**
     * 头像地址 .
     */
    private String headAddress;
    
	/**
	 * @return the headAddress
	 */
	public String getHeadAddress() {
		return headAddress;
	}
	/**
	 * @param headAddress the headAddress to set
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityAreaCode() {
		return cityAreaCode;
	}
	public void setCityAreaCode(String cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateManagerMemberDto [memberType=")
				.append(memberType).append(", memberNo=").append(memberNo)
				.append(", memberName=").append(memberName).append(", email=")
				.append(email).append(", areaCode=").append(areaCode)
				.append(", provinceCode=").append(provinceCode)
				.append(", cityCode=").append(cityCode)
				.append(", cityAreaCode=").append(cityAreaCode)
				.append(", address=").append(address).append(", sex=")
				.append(sex).append("]");
		return builder.toString();
	}
}
