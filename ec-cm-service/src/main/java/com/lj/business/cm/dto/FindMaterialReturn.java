package com.lj.business.cm.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindMaterialReturn.
 */
public class FindMaterialReturn implements Serializable { 

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
     * 导购编号  .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
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
	 * Gets the 导购编号  .
	 *
	 * @return the 导购编号  
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号  .
	 *
	 * @param memberNoGm the new 导购编号  
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the 导购姓名 
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberNameGm the new 导购姓名 
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

    
    
}
