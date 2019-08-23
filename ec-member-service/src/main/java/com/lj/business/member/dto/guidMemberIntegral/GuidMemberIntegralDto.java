package com.lj.business.member.dto.guidMemberIntegral;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class GuidMemberIntegralDto.
 */
public class GuidMemberIntegralDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7180927966141440547L;
	
	 /**
     * 商户编号(必填) .
     */
    private String merchantNo;

    /**
     * 商户名称 .
     */
    private String merchantName;

    /**
     * 导购编号(必填) .
     */
    private String memberNo;

    /**
     * 导购姓名 .
     */
    private String memberName;

    /**
     * 分店编号 .
     */
    private String shopNo;

    /**
     * 分店名称 .
     */
    private String shopName;

    /**
     * 区域CODE .
     */
    private String areaCode;

    /**
     * 区域名称 .
     */
    private String areaName;

    /**
     * 积分类型(必填) .
     */
    private String integralType;
    
    /** 完成值. */
    private Double amount;

	

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the new 商户编号 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 商户名称 .
	 *
	 * @return the 商户名称 
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * Sets the 商户名称 .
	 *
	 * @param merchantName the new 商户名称 
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * Gets the 导购编号 .
	 *
	 * @return the 导购编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNo the new 导购编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the 导购姓名 
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberName the new 导购姓名 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the 分店编号 .
	 *
	 * @return the 分店编号 
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号 .
	 *
	 * @param shopNo the new 分店编号 
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the 分店名称 .
	 *
	 * @return the 分店名称 
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the 分店名称 .
	 *
	 * @param shopName the new 分店名称 
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	 * Gets the 区域名称 .
	 *
	 * @return the 区域名称 
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * Sets the 区域名称 .
	 *
	 * @param areaName the new 区域名称 
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * Gets the 积分类型 .
	 *
	 * @return the 积分类型 
	 */
	public String getIntegralType() {
		return integralType;
	}

	/**
	 * Sets the 积分类型 .
	 *
	 * @param integralType the new 积分类型 
	 */
	public void setIntegralType(String integralType) {
		this.integralType = integralType;
	}

	/**
	 * Gets the 完成值.
	 *
	 * @return the 完成值
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Sets the 完成值.
	 *
	 * @param amount the new 完成值
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuidMemberIntegralDto [merchantNo=").append(merchantNo)
				.append(", merchantName=").append(merchantName)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", shopNo=").append(shopNo)
				.append(", shopName=").append(shopName).append(", areaCode=")
				.append(areaCode).append(", areaName=").append(areaName)
				.append(", integralType=").append(integralType)
				.append(", amount=").append(amount).append("]");
		return builder.toString();
	}
}
