package com.lj.eshop.domain;

import java.util.Date;

public class Catalog {
    /** */
    private String code;

    /** 分类名称*/
    private String catalogName;

    /** 父分类*/
    private String parentCatalogCode;

    /** 父分类名称*/
    private String parentCatalogName;

    /** 二级分类图片*/
    private String imageUrl;

    /** 排序（数值越大越后）*/
    private Integer orderNo;

    /** 创建人*/
    private String creater;

    /** 创建时间*/
    private Date createTime;

    /** 是否删除（0未删除 1删除）*/
    private String delFlag;
    /**
     * 是否推荐（0否 1是）
     */
    private String recommend;
    
    /**
	 * @return the recommend
	 */
	public String getRecommend() {
		return recommend;
	}

	/**
	 * @param recommend the recommend to set
	 */
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public String getParentCatalogCode() {
        return parentCatalogCode;
    }

    public void setParentCatalogCode(String parentCatalogCode) {
        this.parentCatalogCode = parentCatalogCode == null ? null : parentCatalogCode.trim();
    }

    public String getParentCatalogName() {
        return parentCatalogName;
    }

    public void setParentCatalogName(String parentCatalogName) {
        this.parentCatalogName = parentCatalogName == null ? null : parentCatalogName.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}