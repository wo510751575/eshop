package com.lj.business.cm.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class AddMaterialCommen.
 */
public class CountMaterialCommenDto implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3195705942142780189L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 类型CODE .
     */
    private String materialTypeCode;

    /**
     * 类型名称 .
     */
    private String materialTypeName;

    /**
     * 标题 .
     */
    private String title;

    /**
     * 内容 .
     */
    private String content;

    /**
     * 图片地址 .
     */
    private String imgAddr;
    
    /**
     * 回应数量
     */
    private int respondNum;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;
    
    /**
     * 商户编号 .
     */
    private String merchantNo;
    
    
    /**
     * 商户名称 .
     */
    private String merchantName;
    
    /** 门店编号. */
    private String shopNo;
    
    /** 门店名称. */
    private String shopName;
     
     /** 维护维度. */
    private String dimensionSt;
    
    /**
     * 网址链接
     */
    private String linkUrl;
    
    

    public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
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
	 * Gets the dimension st.
	 *
	 * @return the dimension st
	 */
	public String getDimensionSt() {
		return dimensionSt;
	}

	/**
	 * Sets the dimension st.
	 *
	 * @param dimensionSt the dimension st
	 */
	public void setDimensionSt(String dimensionSt) {
		this.dimensionSt = dimensionSt;
	}

	/**
     * Gets the 商户编号 .
     *
     * @return the merchantNo
     */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the merchantNo to set
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 商户名称 .
	 *
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * Sets the 商户名称 .
	 *
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

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
	 * Gets the 类型CODE .
	 *
	 * @return the 类型CODE 
	 */
	public String getMaterialTypeCode() {
		return materialTypeCode;
	}

	/**
	 * Sets the 类型CODE .
	 *
	 * @param materialTypeCode the new 类型CODE 
	 */
	public void setMaterialTypeCode(String materialTypeCode) {
		this.materialTypeCode = materialTypeCode;
	}

	/**
	 * Gets the 类型名称 .
	 *
	 * @return the 类型名称 
	 */
	public String getMaterialTypeName() {
		return materialTypeName;
	}

	/**
	 * Sets the 类型名称 .
	 *
	 * @param materialTypeName the new 类型名称 
	 */
	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	/**
	 * Gets the 标题 .
	 *
	 * @return the 标题 
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the 标题 .
	 *
	 * @param title the new 标题 
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the 内容 .
	 *
	 * @return the 内容 
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the 内容 .
	 *
	 * @param content the new 内容 
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the 图片地址 .
	 *
	 * @return the 图片地址 
	 */
	public String getImgAddr() {
		return imgAddr;
	}

	/**
	 * Sets the 图片地址 .
	 *
	 * @param imgAddr the new 图片地址 
	 */
	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	/**
	 * Gets the 回应数量 .
	 *
	 * @return the 回应数量 
	 */
	public int getRespondNum() {
		return respondNum;
	}

	/**
	 * Sets the 回应数量 .
	 *
	 * @param imgAddr the new 回应数量 
	 */
	public void setRespondNum(int respondNum) {
		this.respondNum = respondNum;
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

	@Override
	public String toString() {
		return "AddMaterialCommen [code=" + code + ", materialTypeCode="
				+ materialTypeCode + ", materialTypeName=" + materialTypeName
				+ ", title=" + title + ", content=" + content + ", imgAddr="
				+ imgAddr + ", respondNum=" + respondNum + ", createId="
				+ createId + ", createDate=" + createDate + ", merchantNo="
				+ merchantNo + ", merchantName=" + merchantName + ", shopNo="
				+ shopNo + ", shopName=" + shopName + ", dimensionSt="
				+ dimensionSt + ", linkUrl=" + linkUrl + "]";
	}
}
