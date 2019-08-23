package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindMaterialReturn.
 */
public class MateriaEcmDto implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8338883261343358379L;

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
     * 编号  .
     */
    private String memberNoGm;

    /**
     * 姓名 .
     */
    private String memberNameGm;

    /**
     * 类型ID .
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
     * 简介 .
     */
    private String brief;

    /**
     * 图片地址 .
     */
    private String imgAddr;


    /**
     * 图片地址 .
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
    
    /** 网址链接. */
    private String linkUrl;
    
    /** 商品code. */
    private String productCode;
    
    /** 商品名称. */
    private String productName;
    
    /** 连接表的code. */
    private String materialCmCode;
    
    /** cm的material/material_commoe.code */
    private String cmMaterialCode;
    
    /** 类型0私人，1官方， 2精选 */
    private String type;
    
    /** 商店code */
    private String shopCode;
    
    /** 商店编号. */
    private String shopNo;
    
    /** 商店名称. */
    private String shopName;
    
    /** 模版ID. */
    private String tempId;
    
    /**
     * 精选code(fk: cm.material_commen.code) .
     */
    private String choicenessCode;
    
    /**
     * ec导购编号 .
     */
    private String ecGuildNo;

    /**
     * ec商店编号 .
     */
    private String ecShopNo;

    /**
     * ec商户编号 .
     */
    private String ecMerchantNo;
    
	/**
	 * Gets the 网址链接.
	 *
	 * @return the 网址链接
	 */
	public String getLinkUrl() {
		return linkUrl;
	}

	/**
	 * Sets the 网址链接.
	 *
	 * @param linkUrl the new 网址链接
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
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
	 * Gets the 编号  .
	 *
	 * @return the 编号  
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 编号  .
	 *
	 * @param memberNoGm the new 编号  
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 姓名 .
	 *
	 * @return the 姓名 
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the 姓名 .
	 *
	 * @param memberNameGm the new 姓名 
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the 类型ID .
	 *
	 * @return the 类型ID 
	 */
	public String getMaterialTypeCode() {
		return materialTypeCode;
	}

	/**
	 * Sets the 类型ID .
	 *
	 * @param materialTypeCode the new 类型ID 
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
	 * Gets the 图片地址 .
	 *
	 * @return the 图片地址 
	 */
	public int getRespondNum() {
		return respondNum;
	}

	/**
	 * Sets the 图片地址 .
	 *
	 * @param respondNum the new 图片地址 
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMaterialReturn [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", materialTypeCode=").append(materialTypeCode)
				.append(", materialTypeName=").append(materialTypeName)
				.append(", title=").append(title).append(", content=")
				.append(content).append(", brief=").append(brief)
				.append(", imgAddr=").append(imgAddr).append(", respondNum=")
				.append(respondNum).append(", createId=").append(createId)
				.append(", createDate=").append(createDate)
				.append(", linkUrl=").append(linkUrl).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 简介 .
	 *
	 * @return the 简介 
	 */
	public String getBrief() {
		return brief;
	}

	/**
	 * Sets the 简介 .
	 *
	 * @param brief the new 简介 
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMaterialCmCode() {
		return materialCmCode;
	}

	public void setMaterialCmCode(String materialCmCode) {
		this.materialCmCode = materialCmCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCmMaterialCode() {
		return cmMaterialCode;
	}

	public void setCmMaterialCode(String cmMaterialCode) {
		this.cmMaterialCode = cmMaterialCode;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getEcGuildNo() {
		return ecGuildNo;
	}

	public void setEcGuildNo(String ecGuildNo) {
		this.ecGuildNo = ecGuildNo;
	}

	public String getEcShopNo() {
		return ecShopNo;
	}

	public void setEcShopNo(String ecShopNo) {
		this.ecShopNo = ecShopNo;
	}

	public String getEcMerchantNo() {
		return ecMerchantNo;
	}

	public void setEcMerchantNo(String ecMerchantNo) {
		this.ecMerchantNo = ecMerchantNo;
	}

	public String getChoicenessCode() {
		return choicenessCode;
	}

	public void setChoicenessCode(String choicenessCode) {
		this.choicenessCode = choicenessCode;
	}

	
	
	
    
    
}
