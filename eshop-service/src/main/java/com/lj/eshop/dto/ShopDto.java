package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class ShopDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 3639827710721178601L;

	/** */
    private String code;

    /** 店铺名称*/
    private String shopName;

    /** 店铺所在省份*/
    private String shopProvide;

    /** 店铺所在市*/
    private String shopCity;

    /** 店铺所在区域*/
    private String shopArea;

    /** 店铺所在详情如街道*/
    private String shopAddinfo;

    /** 店铺状态 0:申请中 1:正常  2:关闭  3:申请失败*/
    private String status;

    /** 店铺头像图片*/
    private String img;

    /** 店铺说明*/
    private String shopFlag;

    /** 店铺背景图片*/
    private String shopBgImgCode;

    /** 店铺等级 1星 2星 3星 4星 5星*/
    private String shopGarde;

    /** 关店原因*/
    private String closeReason;

    /** 开店申请日期*/
    private Date createTime;

    /** 关店日期*/
    private Date closeTime;

    /** 开店日期*/
    private Date openTime;

    /**
     * 店铺风格COde
     *  */
    private String shopStyleCode;

    /** 绑定设备*/
    private String mimeCode;

    /** 访问量*/
    private Integer readNum;
    /**
     * 商户编号
     */
    private String merchantCode;
    /**
     * 会员编号
     */
    private String mbrCode;
    /**
     * 背景名称
     */
    private String bgName;
    /**
     * 背景图路径
     */
    private String bgUrl;
    /**
     * 风格名称
     */
    private String styleName;
    /**
     * 风格色值
     */
    private String styleColor;
    
    /**
     * 特权编号
     */
    private String rankCode;
    /**
     * 特权到期时间
     */
    private Date rankExpireTime;
    /**
     * 特权名称冗余
     */
    private String rankName;
    
    /** 从未登录（0，是 1，否-代表登录过）*/
    private String unLogin;

    /** 开店编号*/
    private String shopNo;
    
    /**
	 * @return the rankName
	 */
	public String getRankName() {
		return rankName;
	}

	/**
	 * @param rankName the rankName to set
	 */
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	/**
	 * @return the bgName
	 */
	public String getBgName() {
		return bgName;
	}

	/**
	 * @param bgName the bgName to set
	 */
	public void setBgName(String bgName) {
		this.bgName = bgName;
	}

	/**
	 * @return the bgUrl
	 */
	public String getBgUrl() {
		return bgUrl;
	}

	/**
	 * @param bgUrl the bgUrl to set
	 */
	public void setBgUrl(String bgUrl) {
		this.bgUrl = bgUrl;
	}

	/**
	 * @return the styleName
	 */
	public String getStyleName() {
		return styleName;
	}

	/**
	 * @param styleName the styleName to set
	 */
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	/**
	 * @return the styleColor
	 */
	public String getStyleColor() {
		return styleColor;
	}

	/**
	 * @param styleColor the styleColor to set
	 */
	public void setStyleColor(String styleColor) {
		this.styleColor = styleColor;
	}

	/**
	 * @return the mbrCode
	 */
	public String getMbrCode() {
		return mbrCode;
	}

	/**
	 * @param mbrCode the mbrCode to set
	 */
	public void setMbrCode(String mbrCode) {
		this.mbrCode = mbrCode;
	}

	/**
	 * @return the merchantCode
	 */
	public String getMerchantCode() {
		return merchantCode;
	}

	/**
	 * @param merchantCode the merchantCode to set
	 */
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopProvide() {
        return shopProvide;
    }

    public void setShopProvide(String shopProvide) {
        this.shopProvide = shopProvide == null ? null : shopProvide.trim();
    }

    public String getShopCity() {
        return shopCity;
    }

    public void setShopCity(String shopCity) {
        this.shopCity = shopCity == null ? null : shopCity.trim();
    }

    public String getShopArea() {
        return shopArea;
    }

    public void setShopArea(String shopArea) {
        this.shopArea = shopArea == null ? null : shopArea.trim();
    }

    public String getShopAddinfo() {
        return shopAddinfo;
    }

    public void setShopAddinfo(String shopAddinfo) {
        this.shopAddinfo = shopAddinfo == null ? null : shopAddinfo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getShopFlag() {
        return shopFlag;
    }

    public void setShopFlag(String shopFlag) {
        this.shopFlag = shopFlag == null ? null : shopFlag.trim();
    }

    public String getShopBgImgCode() {
        return shopBgImgCode;
    }

    public void setShopBgImgCode(String shopBgImgCode) {
        this.shopBgImgCode = shopBgImgCode == null ? null : shopBgImgCode.trim();
    }

    public String getShopGarde() {
        return shopGarde;
    }

    public void setShopGarde(String shopGarde) {
        this.shopGarde = shopGarde == null ? null : shopGarde.trim();
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason == null ? null : closeReason.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getShopStyleCode() {
        return shopStyleCode;
    }

    public void setShopStyleCode(String shopStyleCode) {
        this.shopStyleCode = shopStyleCode == null ? null : shopStyleCode.trim();
    }

    public String getMimeCode() {
        return mimeCode;
    }

    public void setMimeCode(String mimeCode) {
        this.mimeCode = mimeCode == null ? null : mimeCode.trim();
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }
	public String getRankCode() {
		return rankCode;
	}

	public void setRankCode(String rankCode) {
		this.rankCode = rankCode;
	}

	public Date getRankExpireTime() {
		return rankExpireTime;
	}

	public void setRankExpireTime(Date rankExpireTime) {
		this.rankExpireTime = rankExpireTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShopDto [code=" + code + ", shopName=" + shopName
				+ ", shopProvide=" + shopProvide + ", shopCity=" + shopCity
				+ ", shopArea=" + shopArea + ", shopAddinfo=" + shopAddinfo
				+ ", status=" + status + ", img=" + img + ", shopFlag="
				+ shopFlag + ", shopBgImgCode=" + shopBgImgCode
				+ ", shopGarde=" + shopGarde + ", closeReason=" + closeReason
				+ ", createTime=" + createTime + ", closeTime=" + closeTime
				+ ", openTime=" + openTime + ", shopStyleCode=" + shopStyleCode
				+ ", mimeCode=" + mimeCode + ", readNum=" + readNum
				+ ", merchantCode=" + merchantCode + ", mbrCode=" + mbrCode
				+ ", bgName=" + bgName + ", bgUrl=" + bgUrl + ", styleName="
				+ styleName + ", styleColor=" + styleColor + "]";
	}

	/**
	 * @return the unLogin
	 */
	public String getUnLogin() {
		return unLogin;
	}

	/**
	 * @param unLogin the unLogin to set
	 */
	public void setUnLogin(String unLogin) {
		this.unLogin = unLogin;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}
	
	
	
	
}
