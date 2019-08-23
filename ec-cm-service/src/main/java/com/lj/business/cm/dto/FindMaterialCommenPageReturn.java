package com.lj.business.cm.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindMaterialCommenPageReturn.
 */
public class FindMaterialCommenPageReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7657025108358567508L; 
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
     * 商户编号 .
     */
    private String merchantNo;
    
    
    /**
     * 商户名称 .
     */
    private String merchantName;
    
    /**
     * 门店编号
     */
    private String shopNo;
    /**
     * 门店名称
     */
    private String shopName;
    
    /**
     * 维护维度
     */
    private String dimensionSt;
    /**
     * 网址链接
     */
    private String linkUrl;
    
    /**
     * 门店类型
     */
    private String shopType;
    /**
     * 模版ID
     */
    private String tempId;
    /**
     * 简介 .
     */
    private String brief;
    
    /**
	 * @return the brief
	 */
	public String getBrief() {
		return brief;
	}

	/**
	 * @param brief the brief to set
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}

	/**
	 * @return the tempId
	 */
	public String getTempId() {
		return tempId;
	}

	/**
	 * @param tempId the tempId to set
	 */
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
    
    public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
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

	public String getDimensionSt() {
		return dimensionSt;
	}

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
     * 创建时间 .
     */
    private Date createDate;

    /**
     * CODE .
     *
     * @return the cODE 
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new cODE 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 类型CODE .
     *
     * @return the 类型CODE 
     */
    public String getMaterialTypeCode() {
        return materialTypeCode;
    }

    /**
     * 类型CODE .
     *
     * @param materialTypeCode the new 类型CODE 
     */
    public void setMaterialTypeCode(String materialTypeCode) {
        this.materialTypeCode = materialTypeCode == null ? null : materialTypeCode.trim();
    }

    /**
     * 类型名称 .
     *
     * @return the 类型名称 
     */
    public String getMaterialTypeName() {
        return materialTypeName;
    }

    /**
     * 类型名称 .
     *
     * @param materialTypeName the new 类型名称 
     */
    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName == null ? null : materialTypeName.trim();
    }

    /**
     * 标题 .
     *
     * @return the 标题 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题 .
     *
     * @param title the new 标题 
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 内容 .
     *
     * @return the 内容 
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容 .
     *
     * @param content the new 内容 
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 图片地址 .
     *
     * @return the 图片地址 
     */
    public String getImgAddr() {
        return imgAddr;
    }

    /**
     * 图片地址 .
     *
     * @param imgAddr the new 图片地址 
     */
    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr == null ? null : imgAddr.trim();
    }

    /**
     * 回应数量 .
     *
     * @return the 回应数量 
     */
    public int getRespondNum() {
		return respondNum;
	}

    /**
     * 回应数量 .
     *
     * @param imgAddr the new 回应数量 
     */
	public void setRespondNum(int respondNum) {
		this.respondNum = respondNum;
	}

	/**
     * 创建人 .
     *
     * @return the 创建人 
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new 创建人 
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the 创建时间 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new 创建时间 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
	public String toString() {
		return "FindMaterialCommenPageReturn [code=" + code
				+ ", materialTypeCode=" + materialTypeCode
				+ ", materialTypeName=" + materialTypeName + ", title=" + title
				+ ", content=" + content + ", imgAddr=" + imgAddr
				+ ", respondNum=" + respondNum + ", createId=" + createId
				+ ", merchantNo=" + merchantNo + ", merchantName="
				+ merchantName + ", shopNo=" + shopNo + ", shopName="
				+ shopName + ", dimensionSt=" + dimensionSt + ", linkUrl="
				+ linkUrl + ", shopType=" + shopType + ", createDate="
				+ createDate + "]";
	}

}
