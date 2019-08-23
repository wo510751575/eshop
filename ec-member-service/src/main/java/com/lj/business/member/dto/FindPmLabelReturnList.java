package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindPmLabelReturn.
 */
public class FindPmLabelReturnList implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6621317481803695656L;

	 /**
	  *
	  *,count(plp.MEMBER_NO)as memberNoCount
	  */
	
	/**
     * CODE .
     */
    private String code;
    
    /** 客户数量. */
    private Integer memberNo;

	/** 会员号. */
    private String merchantNo;
    
    /** 导购编号. */
    private String memberNoGm;

    /** 导购名称. */
    private String memberNameGm;
    
    /**
     * 客户分类名称 .
     */
    private String labelName;
    
    /** 商户名称. */
    private String merchantName;
    
     /** 区域code. */
    private String areaCode;
     
    /** 门店编号. */
    private String shopNo;
    
    /** 门店名称. */
    private String shopName;
    
    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;


	/**
	 * Gets the member no gm.
	 *
	 * @return the member no gm
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the member no gm.
	 *
	 * @param memberNoGm the member no gm
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the member name gm.
	 *
	 * @return the member name gm
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the member name gm.
	 *
	 * @param memberNameGm the member name gm
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the merchant name.
	 *
	 * @return the merchant name
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * Sets the merchant name.
	 *
	 * @param merchantName the merchant name
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * Gets the area code.
	 *
	 * @return the area code
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * Sets the area code.
	 *
	 * @param areaCode the area code
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * Gets the shop no.
	 *
	 * @return the shop no
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the shop no.
	 *
	 * @param shopNo the shop no
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the shop name.
	 *
	 * @return the shop name
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the shop name.
	 *
	 * @param shopName the shop name
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

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
	 * Gets the 会员号  .
	 *
	 * @return the merchantNo
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param merchantNo the merchantNo to set
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 客户分类名称 .
	 *
	 * @return the labelName
	 */
	public String getLabelName() {
		return labelName;
	}

	/**
	 * Sets the 客户分类名称 .
	 *
	 * @param labelName the labelName to set
	 */
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	/**
	 * Gets the 创建人 .
	 *
	 * @return the createId
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the 创建人 .
	 *
	 * @param createId the createId to set
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
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

    public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "FindPmLabelReturnList [code=" + code + ", memberNo=" + memberNo
				+ ", merchantNo=" + merchantNo + ", memberNoGm=" + memberNoGm
				+ ", memberNameGm=" + memberNameGm + ", labelName=" + labelName
				+ ", merchantName=" + merchantName + ", areaCode=" + areaCode
				+ ", shopNo=" + shopNo + ", shopName=" + shopName
				+ ", createId=" + createId + ", createDate=" + createDate + "]";
	}
    
    
}
