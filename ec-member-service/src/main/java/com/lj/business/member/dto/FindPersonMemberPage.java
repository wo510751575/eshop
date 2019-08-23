package com.lj.business.member.dto;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindPersonMemberPage.
 */
public class FindPersonMemberPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7146345596624141287L; 

	/** 会员编号. */
	private String memberNo;		
	
	/** 手机串号. */
	private int imei;		
	
	/** 会员名称. */
	private String memberName;		
	
	/** 手机号. */
	private String mobile;
	
	/** 导购编号. */
	private String memberNoGm;		
	
	/** 客户来源. */
	private String memberSrc;		
	
	/** 开始时间. */
	private Date startTime;			
	
	/** 结束时间. */
	private Date endTime;			
	
	/** 分店编号. */
	private String shopNo;			
	
	/** 商户编号. */
	private String merchantNo;		
	
	/** 客户分类CODE. */
	private String pmTypeCode;		
	
	/** 产品code. */
	private String bomCode;			
	
	/** 客户分类类型. */
    private String pmTypeType;
    
    /** 客户分类维度. */
    private String pmTypeDim;
    
    /** 导购姓名. */
    private String memberNameGm;
    
    /** 分店名称. */
	private String shopName;
	/**
	 * 所在地区
	 */
	private String area;
	
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the 导购姓名.
	 *
	 * @return the memberNameGm
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the 导购姓名.
	 *
	 * @param memberNameGm the memberNameGm to set
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the 客户分类类型.
	 *
	 * @return the pmTypeType
	 */
	public String getPmTypeType() {
		return pmTypeType;
	}

	/**
	 * Sets the 客户分类类型.
	 *
	 * @param pmTypeType the pmTypeType to set
	 */
	public void setPmTypeType(String pmTypeType) {
		this.pmTypeType = pmTypeType;
	}

	/**
	 * Gets the 客户分类维度.
	 *
	 * @return the pmTypeDim
	 */
	public String getPmTypeDim() {
		return pmTypeDim;
	}

	/**
	 * Sets the 客户分类维度.
	 *
	 * @param pmTypeDim the pmTypeDim to set
	 */
	public void setPmTypeDim(String pmTypeDim) {
		this.pmTypeDim = pmTypeDim;
	}

	/**
	 * Gets the 手机串号.
	 *
	 * @return the imei
	 */
	public int getImei() {
		return imei;
	}

	/**
	 * Sets the 手机串号.
	 *
	 * @param imei the imei to set
	 */
	public void setImei(int imei) {
		this.imei = imei;
	}

	/**
	 * Gets the 客户来源.
	 *
	 * @return the memberSrc
	 */
	public String getMemberSrc() {
		return memberSrc;
	}

	/**
	 * Sets the 客户来源.
	 *
	 * @param memberSrc the memberSrc to set
	 */
	public void setMemberSrc(String memberSrc) {
		this.memberSrc = memberSrc;
	}

	/**
	 * Gets the 客户分类CODE.
	 *
	 * @return the pmTypeCode
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}

	/**
	 * Sets the 客户分类CODE.
	 *
	 * @param pmTypeCode the pmTypeCode to set
	 */
	public void setPmTypeCode(String pmTypeCode) {
		this.pmTypeCode = pmTypeCode;
	}

	/**
	 * Gets the 产品code.
	 *
	 * @return the bomCode
	 */
	public String getBomCode() {
		return bomCode;
	}

	/**
	 * Sets the 产品code.
	 *
	 * @param bomCode the bomCode to set
	 */
	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
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
	 * Gets the 导购编号.
	 *
	 * @return the memberNoGm
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号.
	 *
	 * @param memberNoGm the memberNoGm to set
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
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
	 * Gets the 分店编号.
	 *
	 * @return the shopNo
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号.
	 *
	 * @param shopNo the shopNo to set
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the 商户编号.
	 *
	 * @return the merchantNo
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号.
	 *
	 * @param merchantNo the merchantNo to set
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
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
