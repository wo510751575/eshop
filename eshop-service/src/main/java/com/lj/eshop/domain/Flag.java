package com.lj.eshop.domain;

import java.util.Date;

public class Flag {
    /** */
    private String code;

    /** 标签*/
    private String productFlag;

    /** 卡位(数值越大越后)*/
    private Integer productSeq;

    /** 0:启用 1停用*/
    private String status;

    /** 创建人*/
    private String creater;

    /** 创建时间*/
    private Date createTime;

    /** 1:专题 2：标签*/
    private String flagType;
    
    /** 专题TAB展示的商品数（4或6）*/
    private Integer showCnt;

    /** 图标*/
    private String imageUrl;
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getProductFlag() {
        return productFlag;
    }

    public void setProductFlag(String productFlag) {
        this.productFlag = productFlag == null ? null : productFlag.trim();
    }

    public Integer getProductSeq() {
        return productSeq;
    }

    public void setProductSeq(Integer productSeq) {
        this.productSeq = productSeq ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFlagType() {
        return flagType;
    }

    public void setFlagType(String flagType) {
        this.flagType = flagType == null ? null : flagType.trim();
    }

	/**
	 * @return the showCnt
	 */
	public Integer getShowCnt() {
		return showCnt;
	}

	/**
	 * @param showCnt the showCnt to set
	 */
	public void setShowCnt(Integer showCnt) {
		this.showCnt = showCnt;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    
    
}