package com.lj.business.member.dto.integralSet;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateIntegralSet.
 */
public class UpdateIntegralSet implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1504234268248955317L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 商户名称 .
     */
    private String merchantName;

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
     * 积分类型 .
     */
    private String integralType;

    /**
     * 积分类型名称 .
     */
    private String integralName;

    /**
     * 积分 .
     */
    private Double integralScore;

    /**
     * 积分上限 .
     */
    private Double integralUp;

    /**
     * 积分上限 .
     */
    private Double integralDown;

    /**
     * 状态  Y 正常  N  禁用 .
     */
    private String status;

    /**
     * 更新人 .
     */
    private String updateId;

    /**
     * 更新时间 .
     */
    private Date updateDate;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the merchant no.
	 *
	 * @return the merchant no
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the merchant no.
	 *
	 * @param merchantNo the new merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
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
	 * @param merchantName the new merchant name
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
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
	 * @param shopNo the new shop no
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
	 * @param shopName the new shop name
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	 * @param areaCode the new area code
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * Gets the area name.
	 *
	 * @return the area name
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * Sets the area name.
	 *
	 * @param areaName the new area name
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * Gets the integral type.
	 *
	 * @return the integral type
	 */
	public String getIntegralType() {
		return integralType;
	}

	/**
	 * Sets the integral type.
	 *
	 * @param integralType the new integral type
	 */
	public void setIntegralType(String integralType) {
		this.integralType = integralType;
	}

	/**
	 * Gets the integral name.
	 *
	 * @return the integral name
	 */
	public String getIntegralName() {
		return integralName;
	}

	/**
	 * Sets the integral name.
	 *
	 * @param integralName the new integral name
	 */
	public void setIntegralName(String integralName) {
		this.integralName = integralName;
	}

	/**
	 * Gets the integral score.
	 *
	 * @return the integral score
	 */
	public Double getIntegralScore() {
		return integralScore;
	}

	/**
	 * Sets the integral score.
	 *
	 * @param integralScore the new integral score
	 */
	public void setIntegralScore(Double integralScore) {
		this.integralScore = integralScore;
	}

	/**
	 * Gets the integral up.
	 *
	 * @return the integral up
	 */
	public Double getIntegralUp() {
		return integralUp;
	}

	/**
	 * Sets the integral up.
	 *
	 * @param integralUp the new integral up
	 */
	public void setIntegralUp(Double integralUp) {
		this.integralUp = integralUp;
	}

	/**
	 * Gets the integral down.
	 *
	 * @return the integral down
	 */
	public Double getIntegralDown() {
		return integralDown;
	}

	/**
	 * Sets the integral down.
	 *
	 * @param integralDown the new integral down
	 */
	public void setIntegralDown(Double integralDown) {
		this.integralDown = integralDown;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the update id.
	 *
	 * @return the update id
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * Sets the update id.
	 *
	 * @param updateId the new update id
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * Gets the update date.
	 *
	 * @return the update date
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Sets the update date.
	 *
	 * @param updateDate the new update date
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * Gets the creates the id.
	 *
	 * @return the creates the id
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the creates the id.
	 *
	 * @param createId the new creates the id
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateIntegralSet [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", merchantName=").append(merchantName)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", areaCode=").append(areaCode)
				.append(", areaName=").append(areaName)
				.append(", integralType=").append(integralType)
				.append(", integralName=").append(integralName)
				.append(", integralScore=").append(integralScore)
				.append(", integralUp=").append(integralUp)
				.append(", integralDown=").append(integralDown)
				.append(", status=").append(status).append(", updateId=")
				.append(updateId).append(", updateDate=").append(updateDate)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append("]");
		return builder.toString();
	}
    
    
    
}
