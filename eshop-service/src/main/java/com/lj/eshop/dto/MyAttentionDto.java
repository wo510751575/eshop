package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MyAttentionDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 9220601381708504211L;

	/** */
    private String code;

    /** 关注人代码*/
    private String mbrCode;

    /** 关注人姓名*/
    private String mbrName;

    /** 关注的店铺代码*/
    private String shopCode;

    /** 关注的店铺名称*/
    private String shopName;

    /** 0：关注  1：取消关注*/
    private String status;

    /** */
    private Date createTime;

    /** */
    private Date updateTime;

    /** */
    private String shopImg;
    /**
     * 店铺商品列表
     */
    private List<ShopProductDto> shopProductDtos;
    
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
    
    /**
	 * @return the mbrName
	 */
	public String getMbrName() {
		return mbrName;
	}

	/**
	 * @param mbrName the mbrName to set
	 */
	public void setMbrName(String mbrName) {
		this.mbrName = mbrName;
	}

	/**
	 * @return the shopProductDtos
	 */
	public List<ShopProductDto> getShopProductDtos() {
		return shopProductDtos;
	}

	/**
	 * @param shopProductDtos the shopProductDtos to set
	 */
	public void setShopProductDtos(List<ShopProductDto> shopProductDtos) {
		this.shopProductDtos = shopProductDtos;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMbrCode() {
        return mbrCode;
    }

    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg == null ? null : shopImg.trim();
    }
}
