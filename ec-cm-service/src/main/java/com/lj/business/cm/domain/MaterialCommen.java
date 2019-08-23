package com.lj.business.cm.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class MaterialCommen.
 */
/**
 * 
 * 
 * 类说明：公用素材中心表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 */
public class MaterialCommen {
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
     * 简介 .
     */
    private String brief;

    /**
     * 图片地址 .
     */
    private String imgAddr;
    
    /** 回应数量. */
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
    
   /** 网址链接. */
    private String linkUrl;
    
    /** 门店类型. */
    private String shopType;
    
    /** 模版ID. */
    private String tempId;
    
    /**
     * Gets the 模版ID.
     *
     * @return the tempId
     */
	public String getTempId() {
		return tempId;
	}

	/**
	 * Sets the 模版ID.
	 *
	 * @param tempId the tempId to set
	 */
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	/**
	 * Gets the 门店类型.
	 *
	 * @return the 门店类型
	 */
	public String getShopType() {
		return shopType;
	}

	/**
	 * Sets the 门店类型.
	 *
	 * @param shopType the new 门店类型
	 */
	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

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
	 * Gets the merchant name.
	 *
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * Sets the merchant name.
	 *
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * CODE .
	 *
	 * @return the code
	 */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 类型CODE .
     *
     * @return the material type code
     */
    public String getMaterialTypeCode() {
        return materialTypeCode;
    }

    /**
     * 类型CODE .
     *
     * @param materialTypeCode the new material type code
     */
    public void setMaterialTypeCode(String materialTypeCode) {
        this.materialTypeCode = materialTypeCode == null ? null : materialTypeCode.trim();
    }

    /**
     * 类型名称 .
     *
     * @return the material type name
     */
    public String getMaterialTypeName() {
        return materialTypeName;
    }

    /**
     * 类型名称 .
     *
     * @param materialTypeName the new material type name
     */
    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName == null ? null : materialTypeName.trim();
    }

    /**
     * 标题 .
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题 .
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 内容 .
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容 .
     *
     * @param content the new content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 图片地址 .
     *
     * @return the img addr
     */
    public String getImgAddr() {
        return imgAddr;
    }

    /**
     * 图片地址 .
     *
     * @param imgAddr the new img addr
     */
    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr == null ? null : imgAddr.trim();
    }

    /**
     * Gets the 回应数量.
     *
     * @return the 回应数量
     */
    public int getRespondNum() {
		return respondNum;
	}

	/**
	 * Sets the 回应数量.
	 *
	 * @param respondNum the new 回应数量
	 */
	public void setRespondNum(int respondNum) {
		this.respondNum = respondNum;
	}

	/**
     * 创建人 .
     *
     * @return the creates the id
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new creates the id
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the creates the date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
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
		builder.append("MaterialCommen [code=").append(code)
				.append(", materialTypeCode=").append(materialTypeCode)
				.append(", materialTypeName=").append(materialTypeName)
				.append(", title=").append(title).append(", content=")
				.append(content).append(", brief=").append(brief)
				.append(", imgAddr=").append(imgAddr).append(", respondNum=")
				.append(respondNum).append(", createId=").append(createId)
				.append(", createDate=").append(createDate)
				.append(", merchantNo=").append(merchantNo)
				.append(", merchantName=").append(merchantName)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", dimensionSt=").append(dimensionSt)
				.append(", linkUrl=").append(linkUrl).append(", shopType=")
				.append(shopType).append(", tempId=").append(tempId)
				.append("]");
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