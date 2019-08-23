package com.lj.eshop.domain;

import java.util.Date;

/**
 * 
 * 
 * 类说明：购物车
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月21日
 */
public class ShopCar {
    /**
     *  .
     */
    private String code;

    /**
     * 商品代码 .
     */
    private String productCode;

    /**
     * 商品名称 .
     */
    private String productName;

    /**
     * 商品规格 .
     */
    private String productSkuCode;

    /**
     * 数量 .
     */
    private Integer cnt;

    /**
     *  .
     */
    private Date createTime;

    /**
     * 购买人 .
     */
    private String mbrCode;

    /**
     * 图片 .
     */
    private String img;

    /**
     * 店铺code
     */
    private String shopCode;
    
    /**
	 * @return the productSkuCode
	 */
	public String getProductSkuCode() {
		return productSkuCode;
	}

	/**
	 * @param productSkuCode the productSkuCode to set
	 */
	public void setProductSkuCode(String productSkuCode) {
		this.productSkuCode = productSkuCode;
	}

	/**
	 * @return the shopCode
	 */
	public String getShopCode() {
		return shopCode;
	}

	/**
	 * @param shopCode the shopCode to set
	 */
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	/**
     *  .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     *  .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商品代码 .
     *
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 商品代码 .
     *
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * 商品名称 .
     *
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 商品名称 .
     *
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }


	/**
     * 数量 .
     *
     */
    public Integer getCnt() {
        return cnt;
    }

    /**
     * 数量 .
     *
     */
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    /**
     *  .
     *
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *  .
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 购买人 .
     *
     */
    public String getMbrCode() {
        return mbrCode;
    }

    /**
     * 购买人 .
     *
     */
    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }

    /**
     * 图片 .
     *
     */
    public String getImg() {
        return img;
    }

    /**
     * 图片 .
     *
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

}