package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class ShopProductDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 7903778445264418124L;

	/**
     *  .
     */
    private String code;

    /**
     *  店铺Code
     */
    private String shopCode;

    /**
     *  商品Code
     */
    private String productCode;

    /**
     * 0:上架 1:下架 .
     */
    private String status;

    /**
     *  .
     */
    private Date createTime;
    /**
     * 商品
     */
    private ProductDto product;

    private ProductSkuDto sku;
    
    
    /**
	 * @return the product
	 */
	public ProductDto getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductDto product) {
		this.product = product;
	}

	/**
	 * @return the sku
	 */
	public ProductSkuDto getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(ProductSkuDto sku) {
		this.sku = sku;
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
     *  .
     *
     */
    public String getShopCode() {
        return shopCode;
    }

    /**
     *  .
     *
     */
    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    /**
     *  .
     *
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     *  .
     *
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * 0:上架 1:下架 .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 0:上架 1:下架 .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShopProduct [code=").append(code);
        builder.append(",shopCode=").append(shopCode); 
        builder.append(",productCode=").append(productCode); 
        builder.append(",status=").append(status); 
        builder.append(",createTime=").append(createTime); 
        builder.append("]");
        return builder.toString();
    }
}
