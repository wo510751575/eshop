package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MyCollDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -3864501713645025240L;

	/** 商品代码*/
    private String productCode;

    /** 会员编号*/
    private String mbrCode;

    /** */
    private Date createDate;
    
    /**商品类目*/
    private CatalogDto catalog;
    /**商品SKU*/
    private List<ProductSkuDto> skus;
    /**商品*/
    private List<ProductDto> products;
    /**店铺商品*/
    private List<ShopProductDto> shopProducts;
    /**店铺*/
    private List<ShopDto> shops;

    public List<ShopDto> getShops() {
		return shops;
	}

	public void setShops(List<ShopDto> shops) {
		this.shops = shops;
	}
	
    /**
     * 是否上架
     */
    private Integer isMarketable;
    
    /**
	 * @return the isMarketable
	 */
	public Integer getIsMarketable() {
		return isMarketable;
	}

	/**
	 * @param isMarketable the isMarketable to set
	 */
	public void setIsMarketable(Integer isMarketable) {
		this.isMarketable = isMarketable;
	}

	public List<ShopProductDto> getShopProducts() {
		return shopProducts;
	}

	public void setShopProducts(List<ShopProductDto> shopProducts) {
		this.shopProducts = shopProducts;
	}

	public CatalogDto getCatalog() {
		return catalog;
	}

	public void setCatalog(CatalogDto catalog) {
		this.catalog = catalog;
	}

	public List<ProductSkuDto> getSkus() {
		return skus;
	}

	public void setSkus(List<ProductSkuDto> skus) {
		this.skus = skus;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

	public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getMbrCode() {
        return mbrCode;
    }

    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
