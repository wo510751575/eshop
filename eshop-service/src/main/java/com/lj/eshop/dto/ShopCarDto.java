package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopCarDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -5014493833548342586L;

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
     * 规格名称冗余
     */
    private String productSkuName;
    /**
     * 商品金额冗余
     */
    private String amt;
    /**
     * 规格描述
     */
    private String skuDesc;
    /**
     * 销售价格
     */
    private BigDecimal salePrice;
    
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
	 * @return the salePrice
	 */
	public BigDecimal getSalePrice() {
		if (salePrice != null) {
			salePrice= salePrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		} 
		return salePrice;
	}

	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * @return the productSkuName
	 */
	public String getProductSkuName() {
		return productSkuName;
	}

	/**
	 * @param productSkuName the productSkuName to set
	 */
	public void setProductSkuName(String productSkuName) {
		this.productSkuName = productSkuName;
	}

	/**
	 * @return the amt
	 */
	public String getAmt() {
		return amt;
	}

	/**
	 * @param amt the amt to set
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}

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

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
	@Override
	public String toString() {
		return "ShopCarDto [code=" + code + ", productCode=" + productCode
				+ ", productName=" + productName + ", productSkuCode="
				+ productSkuCode + ", cnt=" + cnt + ", createTime="
				+ createTime + ", mbrCode=" + mbrCode + ", img=" + img
				+ ", shopCode=" + shopCode + "]";
	}


    
}
