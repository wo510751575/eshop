package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class EvlProductDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -2108560375533952099L;

	/** */
    private String code;

    /** 评论信息*/
    private String evlInfo;

    /** 评论等级*/
    private String evlGrade;

    /** 评论人代码*/
    private String evlMbrCode;

    /** 评论人姓名*/
    private String evlMbrName;

    /** 评论人头像*/
    private String evlMbrImg;

    /** 评论时间*/
    private Date createTime;

    /** 评论商品代码*/
    private String productCode;

    /** 评论商品名称*/
    private String productName;

    /** 商品sku编号(fk:t_product_sku.code)*/
    private String productSkuCode;


    /** 点赞次数*/
    private Integer goodCnt;
    
    /** 评论图片集合，英文逗号分割*/
    private String imgs;
    
    /** 商品规格*/
    private String skuDesc;
    /** 是否已点赞（0 未点赞 1已点赞 ） */
    private String likeStatus;
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getEvlInfo() {
        return evlInfo;
    }

    public void setEvlInfo(String evlInfo) {
        this.evlInfo = evlInfo == null ? null : evlInfo.trim();
    }

    public String getEvlGrade() {
        return evlGrade;
    }

    public void setEvlGrade(String evlGrade) {
        this.evlGrade = evlGrade == null ? null : evlGrade.trim();
    }

    public String getEvlMbrCode() {
        return evlMbrCode;
    }

    public void setEvlMbrCode(String evlMbrCode) {
        this.evlMbrCode = evlMbrCode == null ? null : evlMbrCode.trim();
    }

    public String getEvlMbrName() {
        return evlMbrName;
    }

    public void setEvlMbrName(String evlMbrName) {
        this.evlMbrName = evlMbrName == null ? null : evlMbrName.trim();
    }

    public String getEvlMbrImg() {
        return evlMbrImg;
    }

    public void setEvlMbrImg(String evlMbrImg) {
        this.evlMbrImg = evlMbrImg == null ? null : evlMbrImg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode == null ? null : productSkuCode.trim();
    }

    public Integer getGoodCnt() {
        return goodCnt;
    }

    public void setGoodCnt(Integer goodCnt) {
        this.goodCnt = goodCnt;
    }

	/**
	 * @return the skuDesc
	 */
	public String getSkuDesc() {
		return skuDesc;
	}

	/**
	 * @param skuDesc the skuDesc to set
	 */
	public void setSkuDesc(String skuDesc) {
		this.skuDesc = skuDesc;
	}

	/**
	 * @return the imgs
	 */
	public String getImgs() {
		return imgs;
	}

	/**
	 * @param imgs the imgs to set
	 */
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	/**
	 * @return the likeStatus
	 */
	public String getLikeStatus() {
		return likeStatus;
	}

	/**
	 * @param likeStatus the likeStatus to set
	 */
	public void setLikeStatus(String likeStatus) {
		this.likeStatus = likeStatus;
	}
    
    
}
