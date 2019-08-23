package com.lj.business.member.dto;

import java.io.Serializable;


/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author LeoPeng
 * 
 * 
 * CreateDate: 2017-6-4
 */
public class PersonMemberLogin implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2167078588183922561L;
	
	 /**
     * 手机号（必填） .
     */
    private String mobile;
    

    /**
     * 登录密码（必填） .
     */
    private String pwd;
    
    /**
     * 手机串号 .
     */
    private String imei;
    

    /**
     * 微信公众号OPENID .
     */
    private String openIdGzhWx;
    
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
	 * Gets the 登录密码 .
	 *
	 * @return the 登录密码 
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Sets the 登录密码 .
	 *
	 * @param pwd the new 登录密码 
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Gets the 手机串号 .
	 *
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * Sets the 手机串号 .
	 *
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonMemberLogin [mobile=").append(mobile)
				.append(", pwd=").append(pwd).append(", imei=").append(imei)
				.append(", openIdGzhWx=").append(openIdGzhWx)
				.append(", ipAddress=").append(ipAddress).append(", mac=")
				.append(mac).append(", netType=").append(netType)
				.append(", equipment=").append(equipment).append(", areaInfo=")
				.append(areaInfo).append(", loginArea=").append(loginArea)
				.append("]");
		return builder.toString();
	}

	/**
	 * Gets the 微信公众号OPENID .
	 *
	 * @return the 微信公众号OPENID 
	 */
	public String getOpenIdGzhWx() {
		return openIdGzhWx;
	}

	/**
	 * Sets the 微信公众号OPENID .
	 *
	 * @param openIdGzhWx the new 微信公众号OPENID 
	 */
	public void setOpenIdGzhWx(String openIdGzhWx) {
		this.openIdGzhWx = openIdGzhWx;
	}

	

}
