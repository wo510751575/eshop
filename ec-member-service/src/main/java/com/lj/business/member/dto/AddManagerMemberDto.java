package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class AddManagerMemberDto.
 */
public class AddManagerMemberDto implements Serializable{
	 
 	/** Generate cron. */
	private static final long serialVersionUID = 6751144455295059929L;
	/**
     * CODE .
     */
    private String code;

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
     * 分店编号 .
     */
    private String memberNoShop;

    /**
     * 分店名称 .
     */
    private String memberNameShop;

    /**
     * 商户编号 .
     */
    private String memberNoMerchant;

    /**
     * 商户名称 .
     */
    private String memberNameMerchant;
    /**
     * 手机号 .
     */
    private String mobile;
    
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
     * 头像地址 .
     */
    private String headAddress;
    /**
     * 性别 .
     */
    private String sex;
    /**
     * 入职时间 .
     */
    private Date workDate;
	
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
	
	/**
	 * Gets the 店长编号 .
	 *
	 * @return the 店长编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}
	
	/**
	 * Sets the 店长编号 .
	 *
	 * @param memberNo the new 店长编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	
	/**
	 * Gets the 会员姓名 .
	 *
	 * @return the 会员姓名 
	 */
	public String getMemberName() {
		return memberName;
	}
	
	/**
	 * Sets the 会员姓名 .
	 *
	 * @param memberName the new 会员姓名 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	/**
	 * Gets the 分店编号 .
	 *
	 * @return the 分店编号 
	 */
	public String getMemberNoShop() {
		return memberNoShop;
	}
	
	/**
	 * Sets the 分店编号 .
	 *
	 * @param memberNoShop the new 分店编号 
	 */
	public void setMemberNoShop(String memberNoShop) {
		this.memberNoShop = memberNoShop;
	}
	
	/**
	 * Gets the 分店名称 .
	 *
	 * @return the 分店名称 
	 */
	public String getMemberNameShop() {
		return memberNameShop;
	}
	
	/**
	 * Sets the 分店名称 .
	 *
	 * @param memberNameShop the new 分店名称 
	 */
	public void setMemberNameShop(String memberNameShop) {
		this.memberNameShop = memberNameShop;
	}
	
	/**
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMemberNoMerchant() {
		return memberNoMerchant;
	}
	
	/**
	 * Sets the 商户编号 .
	 *
	 * @param memberNoMerchant the new 商户编号 
	 */
	public void setMemberNoMerchant(String memberNoMerchant) {
		this.memberNoMerchant = memberNoMerchant;
	}
	
	/**
	 * Gets the 商户名称 .
	 *
	 * @return the 商户名称 
	 */
	public String getMemberNameMerchant() {
		return memberNameMerchant;
	}
	
	/**
	 * Sets the 商户名称 .
	 *
	 * @param memberNameMerchant the new 商户名称 
	 */
	public void setMemberNameMerchant(String memberNameMerchant) {
		this.memberNameMerchant = memberNameMerchant;
	}
	
	/**
	 * Gets the 手机号 .
	 *
	 * @return the 手机号 
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Sets the 手机号 .
	 *
	 * @param mobile the new 手机号 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Gets the 邮箱 .
	 *
	 * @return the 邮箱 
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the 邮箱 .
	 *
	 * @param email the new 邮箱 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the 区域CODE .
	 *
	 * @return the 区域CODE 
	 */
	public String getAreaCode() {
		return areaCode;
	}
	
	/**
	 * Sets the 区域CODE .
	 *
	 * @param areaCode the new 区域CODE 
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	/**
	 * Gets the 省CODE .
	 *
	 * @return the 省CODE 
	 */
	public String getProvinceCode() {
		return provinceCode;
	}
	
	/**
	 * Sets the 省CODE .
	 *
	 * @param provinceCode the new 省CODE 
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	/**
	 * Gets the 市CODE .
	 *
	 * @return the 市CODE 
	 */
	public String getCityCode() {
		return cityCode;
	}
	
	/**
	 * Sets the 市CODE .
	 *
	 * @param cityCode the new 市CODE 
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	/**
	 * Gets the 市区CODE .
	 *
	 * @return the 市区CODE 
	 */
	public String getCityAreaCode() {
		return cityAreaCode;
	}
	
	/**
	 * Sets the 市区CODE .
	 *
	 * @param cityAreaCode the new 市区CODE 
	 */
	public void setCityAreaCode(String cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
	}
	
	/**
	 * Gets the 住址 .
	 *
	 * @return the 住址 
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the 住址 .
	 *
	 * @param address the new 住址 
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets the 头像地址 .
	 *
	 * @return the 头像地址 
	 */
	public String getHeadAddress() {
		return headAddress;
	}
	
	/**
	 * Sets the 头像地址 .
	 *
	 * @param headAddress the new 头像地址 
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}
	
	/**
	 * Gets the 性别 .
	 *
	 * @return the 性别 
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * Sets the 性别 .
	 *
	 * @param sex the new 性别 
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * Gets the 入职时间 .
	 *
	 * @return the 入职时间 
	 */
	public Date getWorkDate() {
		return workDate;
	}
	
	/**
	 * Sets the 入职时间 .
	 *
	 * @param workDate the new 入职时间 
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	
	/**
	 * Gets the 会员类型 店长：SHOP 老板：BOSS .
	 *
	 * @return the 会员类型 店长：SHOP 老板：BOSS 
	 */
	public String getMemberType() {
		return memberType;
	}
	
	/**
	 * Sets the 会员类型 店长：SHOP 老板：BOSS .
	 *
	 * @param memberType the new 会员类型 店长：SHOP 老板：BOSS 
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddManagerMemberDto [code=").append(code)
				.append(", memberType=").append(memberType)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", memberNoShop=")
				.append(memberNoShop).append(", memberNameShop=")
				.append(memberNameShop).append(", memberNoMerchant=")
				.append(memberNoMerchant).append(", memberNameMerchant=")
				.append(memberNameMerchant).append(", mobile=").append(mobile)
				.append(", email=").append(email).append(", areaCode=")
				.append(areaCode).append(", provinceCode=")
				.append(provinceCode).append(", cityCode=").append(cityCode)
				.append(", cityAreaCode=").append(cityAreaCode)
				.append(", address=").append(address).append(", headAddress=")
				.append(headAddress).append(", sex=").append(sex)
				.append(", workDate=").append(workDate).append("]");
		return builder.toString();
	}
	
}
