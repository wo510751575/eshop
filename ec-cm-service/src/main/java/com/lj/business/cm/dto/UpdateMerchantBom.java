package com.lj.business.cm.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class UpdateMerchantBom.
 */
public class UpdateMerchantBom implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5910351835907283967L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String merchantNo;

    /**
     * 会员名称 .
     */
    private String merchantName;

    /**
     *  .
     */
    private String bomCode;

    /**
     * 客户分类名称 .
     */
    private String bomName;

    /**
     *  .
     */
    private String imgAddr;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

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
	 * Gets the 会员号  .
	 *
	 * @return the 会员号  
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param merchantNo the new 会员号  
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 会员名称 .
	 *
	 * @return the 会员名称 
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * Sets the 会员名称 .
	 *
	 * @param merchantName the new 会员名称 
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * Gets the bom code.
	 *
	 * @return the bom code
	 */
	public String getBomCode() {
		return bomCode;
	}

	/**
	 * Sets the bom code.
	 *
	 * @param bomCode the bom code
	 */
	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}

	/**
	 * Gets the 客户分类名称 .
	 *
	 * @return the 客户分类名称 
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * Sets the 客户分类名称 .
	 *
	 * @param bomName the new 客户分类名称 
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName;
	}

	/**
	 * Gets the img addr.
	 *
	 * @return the img addr
	 */
	public String getImgAddr() {
		return imgAddr;
	}

	/**
	 * Sets the img addr.
	 *
	 * @param imgAddr the img addr
	 */
	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	/**
	 * Gets the 创建人 .
	 *
	 * @return the 创建人 
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the 创建人 .
	 *
	 * @param createId the new 创建人 
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the 创建时间 .
	 *
	 * @return the 创建时间 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate the new 创建时间 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateMerchantBom [code=" + code + ", merchantNo=" + merchantNo
				+ ", merchantName=" + merchantName + ", bomCode=" + bomCode
				+ ", bomName=" + bomName + ", imgAddr=" + imgAddr
				+ ", createId=" + createId + ", createDate=" + createDate
				+ ", getCode()=" + getCode() + ", getMerchantNo()="
				+ getMerchantNo() + ", getMerchantName()=" + getMerchantName()
				+ ", getBomCode()=" + getBomCode() + ", getBomName()="
				+ getBomName() + ", getImgAddr()=" + getImgAddr()
				+ ", getCreateId()=" + getCreateId() + ", getCreateDate()="
				+ getCreateDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
    
    
}
