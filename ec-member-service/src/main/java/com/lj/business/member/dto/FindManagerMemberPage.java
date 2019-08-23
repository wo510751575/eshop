package com.lj.business.member.dto;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindManagerMemberPage.
 */
public class FindManagerMemberPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3449222670507376579L;

	/** 会员编号. */
	private String memberNo;
	
	/** 手机号. */
	private String mobile;
	/**手机串号*/
	private String imei;
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
	 * 类型店长：SHOP\r\n 老板：BOSS' .
	 */
	private String memberType;

	/** 状态. */
	private String status;
	
	/** 会员名称. */
	private String memberName;
	
	 /** 微信号. */
    private String noWx;
    
    /** 开始时间. */
	private Date startTime;			
	
	/** 结束时间. */
	private Date endTime;
	/**
     * 区域CODE .
     */
    private String areaCode;
    /**
	 * 年龄起始
	 */
	private Integer ageFrom;
	/**
	 * 年龄起止
	 */
	private Integer ageTo;
    

    public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * @return the ageFrom
	 */
	public Integer getAgeFrom() {
		return ageFrom;
	}

	/**
	 * @param ageFrom the ageFrom to set
	 */
	public void setAgeFrom(Integer ageFrom) {
		this.ageFrom = ageFrom;
	}

	/**
	 * @return the ageTo
	 */
	public Integer getAgeTo() {
		return ageTo;
	}

	/**
	 * @param ageTo the ageTo to set
	 */
	public void setAgeTo(Integer ageTo) {
		this.ageTo = ageTo;
	}

	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
     * Gets the 开始时间.
     *
     * @return the startTime
     */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Sets the 开始时间.
	 *
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the 结束时间.
	 *
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * Sets the 结束时间.
	 *
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

    /**
     * Gets the 微信号.
     *
     * @return the noWx
     */
	public String getNoWx() {
		return noWx;
	}

	/**
	 * Sets the 微信号.
	 *
	 * @param noWx the noWx to set
	 */
	public void setNoWx(String noWx) {
		this.noWx = noWx;
	}
	
	/**
	 * Gets the 会员名称.
	 *
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 会员名称.
	 *
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the 状态.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the 状态.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the 类型店长：SHOP\r\n 老板：BOSS' .
	 *
	 * @return the memberType
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * Sets the 类型店长：SHOP\r\n 老板：BOSS' .
	 *
	 * @param memberType the memberType to set
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * Gets the 分店编号 .
	 *
	 * @return the memberNoShop
	 */
	public String getMemberNoShop() {
		return memberNoShop;
	}

	/**
	 * Sets the 分店编号 .
	 *
	 * @param memberNoShop the memberNoShop to set
	 */
	public void setMemberNoShop(String memberNoShop) {
		this.memberNoShop = memberNoShop;
	}

	/**
	 * Gets the 分店名称 .
	 *
	 * @return the memberNameShop
	 */
	public String getMemberNameShop() {
		return memberNameShop;
	}

	/**
	 * Sets the 分店名称 .
	 *
	 * @param memberNameShop the memberNameShop to set
	 */
	public void setMemberNameShop(String memberNameShop) {
		this.memberNameShop = memberNameShop;
	}

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the memberNoMerchant
	 */
	public String getMemberNoMerchant() {
		return memberNoMerchant;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param memberNoMerchant the memberNoMerchant to set
	 */
	public void setMemberNoMerchant(String memberNoMerchant) {
		this.memberNoMerchant = memberNoMerchant;
	}

	/**
	 * Gets the 手机号.
	 *
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Sets the 手机号.
	 *
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Gets the 会员编号.
	 *
	 * @return the memberNo
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 会员编号.
	 *
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

}
