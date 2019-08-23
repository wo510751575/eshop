package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class UpdateMemberLoginInfo.
 */
public class UpdateMemberLoginInfo implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5297369958045613210L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 会员类型
             导购：GUID
             店长：SHOP
             老板：BOSS .
     */
    private String memberType;

    /**
     * 会员号 .
     */
    private String memberNo;

    /**
     *  .
     */
    private String ipAddress;

    /**
     *  .
     */
    private String mac;

    /**
     *  .
     */
    private String netType;

    /**
     * PC
             ANDROID PAD
             ANDROID PHONE
             IPAD
             IPHONE
             PHONE
             PAD .
     */
    private String equipment;

    /**
     * 区域信息（经纬度） .
     */
    private String areaInfo;

    /**
     *  .
     */
    private String loginArea;

    /**
     * 创建时间 .
     */
    private Date createDate;

	/**
	 * Gets the cODE .
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 会员类型 导购：GUID 店长：SHOP 老板：BOSS .
	 *
	 * @return the memberType
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * Sets the 会员类型 导购：GUID 店长：SHOP 老板：BOSS .
	 *
	 * @param memberType the memberType to set
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * Gets the 会员号 .
	 *
	 * @return the memberNo
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 会员号 .
	 *
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the ip address.
	 *
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Sets the ip address.
	 *
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Gets the mac.
	 *
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * Sets the mac.
	 *
	 * @param mac the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * Gets the net type.
	 *
	 * @return the netType
	 */
	public String getNetType() {
		return netType;
	}

	/**
	 * Sets the net type.
	 *
	 * @param netType the netType to set
	 */
	public void setNetType(String netType) {
		this.netType = netType;
	}

	/**
	 * Gets the pC ANDROID PAD ANDROID PHONE IPAD IPHONE PHONE PAD .
	 *
	 * @return the equipment
	 */
	public String getEquipment() {
		return equipment;
	}

	/**
	 * Sets the pC ANDROID PAD ANDROID PHONE IPAD IPHONE PHONE PAD .
	 *
	 * @param equipment the equipment to set
	 */
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	/**
	 * Gets the 区域信息（经纬度） .
	 *
	 * @return the areaInfo
	 */
	public String getAreaInfo() {
		return areaInfo;
	}

	/**
	 * Sets the 区域信息（经纬度） .
	 *
	 * @param areaInfo the areaInfo to set
	 */
	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}

	/**
	 * Gets the login area.
	 *
	 * @return the loginArea
	 */
	public String getLoginArea() {
		return loginArea;
	}

	/**
	 * Sets the login area.
	 *
	 * @param loginArea the loginArea to set
	 */
	public void setLoginArea(String loginArea) {
		this.loginArea = loginArea;
	}

	/**
	 * Gets the 创建时间 .
	 *
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
    
    
}
