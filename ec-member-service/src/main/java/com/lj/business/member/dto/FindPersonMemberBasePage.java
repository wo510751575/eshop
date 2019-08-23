package com.lj.business.member.dto;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindPersonMemberBasePage.
 */
public class FindPersonMemberBasePage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6189819856301405559L; 
	
	/** The member no. */
	private String memberNo;		//会员编号
	
	/** The imei. */
	private int imei;				//手机串号
	
	/** The member name. */
	private String memberName;		//会员名称
	
	/** The mobile. */
	private String mobile;			//手机号
	
	/** The member no gm. */
	private String memberNoGm;		//导购编号
	
	/** The member src. */
	private String memberSrc;		//客户来源
	
	/** The start time. */
	private Date startTime;			//开始时间
	
	/** The end time. */
	private Date endTime;			//结束时间
	
	/** The shop no. */
	private String shopNo;			//分店编号
	
	/** The merchant no. */
	private String merchantNo;		//商户编号
	
	/** The pm type code. */
	private String pmTypeCode;		//客户分类CODE
	
	/** The bom code. */
	private String bomCode;			//产品code
    
    /** The urgency pm. */
    private String urgencyPm;		//紧急客户
    
	/**
	 * Gets the bom code.
	 *
	 * @return the bomCode
	 */
	public String getBomCode() {
		return bomCode;
	}
	
	/**
	 * Sets the bom code.
	 *
	 * @param bomCode the bomCode to set
	 */
	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}
	
	/**
	 * Gets the urgency pm.
	 *
	 * @return the urgencyPm
	 */
	public String getUrgencyPm() {
		return urgencyPm;
	}
	
	/**
	 * Sets the urgency pm.
	 *
	 * @param urgencyPm the urgencyPm to set
	 */
	public void setUrgencyPm(String urgencyPm) {
		this.urgencyPm = urgencyPm;
	}
	
	/**
	 * Gets the shop no.
	 *
	 * @return the shopNo
	 */
	public String getShopNo() {
		return shopNo;
	}
	
	/**
	 * Sets the shop no.
	 *
	 * @param shopNo the shopNo to set
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}
	
	/**
	 * Gets the merchant no.
	 *
	 * @return the merchantNo
	 */
	public String getMerchantNo() {
		return merchantNo;
	}
	
	/**
	 * Sets the merchant no.
	 *
	 * @param merchantNo the merchantNo to set
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	
	/**
	 * Gets the pm type code.
	 *
	 * @return the pmTypeCode
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}
	
	/**
	 * Sets the pm type code.
	 *
	 * @param pmTypeCode the pmTypeCode to set
	 */
	public void setPmTypeCode(String pmTypeCode) {
		this.pmTypeCode = pmTypeCode;
	}
	
	/**
	 * Gets the member name.
	 *
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}
	
	/**
	 * Sets the member name.
	 *
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Sets the mobile.
	 *
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Gets the member no gm.
	 *
	 * @return the memberNoGm
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}
	
	/**
	 * Sets the member no gm.
	 *
	 * @param memberNoGm the memberNoGm to set
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}
	
	/**
	 * Gets the member src.
	 *
	 * @return the memberSrc
	 */
	public String getMemberSrc() {
		return memberSrc;
	}
	
	/**
	 * Sets the member src.
	 *
	 * @param memberSrc the memberSrc to set
	 */
	public void setMemberSrc(String memberSrc) {
		this.memberSrc = memberSrc;
	}
	
	/**
	 * Gets the start time.
	 *
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * Sets the start time.
	 *
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Gets the end time.
	 *
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * Sets the end time.
	 *
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Gets the imei.
	 *
	 * @return the imei
	 */
	public int getImei() {
		return imei;
	}
	
	/**
	 * Sets the imei.
	 *
	 * @param imei the imei to set
	 */
	public void setImei(int imei) {
		this.imei = imei;
	}
	
	/**
	 * Gets the member no.
	 *
	 * @return the memberNo
	 */
	public String getMemberNo() {
		return memberNo;
	}
	
	/**
	 * Sets the member no.
	 *
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	
}
