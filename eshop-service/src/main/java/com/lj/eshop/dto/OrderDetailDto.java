package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年9月5日
 */
public class OrderDetailDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -616724686028432813L;

	/** */
    private String code;

    /** 商品编码*/
    private String productCode;

    /** 商品名称*/
    private String productName;

    /** 供应商代码*/
    private String supplyCode;

    /** 供应商名称*/
    private String supplyName;

    /** 数量*/
    private Integer cnt;

    /** 总金额（单价*数量）*/
    private BigDecimal amt;

    /** C端单个售价*/
    private BigDecimal salePrice;

    /** 订单编号*/
    private String orderNo;

    /** 商品sku编号(fk:t_product_code.code)*/
    private String skuCode;

    /** 小B进货单价*/
    private BigDecimal orgPrice;

    /** 小B提成单价*/
    private BigDecimal gapPrice;
    /** 退货数量*/
    private Integer returnCnt;
    /**
     * 商品规格
     */
    private ProductSkuDto sku;
    /**
     * 商品dto
     */
    private ProductDto product;
    
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
	 * @return the returnCnt
	 */
	public Integer getReturnCnt() {
		return returnCnt;
	}

	/**
	 * @param returnCnt the returnCnt to set
	 */
	public void setReturnCnt(Integer returnCnt) {
		this.returnCnt = returnCnt;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public String getSupplyCode() {
        return supplyCode;
    }

    public void setSupplyCode(String supplyCode) {
        this.supplyCode = supplyCode == null ? null : supplyCode.trim();
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName == null ? null : supplyName.trim();
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public BigDecimal getAmt() {
    	if (amt != null) {
    		amt= amt.setScale(2, BigDecimal.ROUND_HALF_UP);
		}  
		return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getSalePrice() {
    	if (salePrice != null) {
    		salePrice= salePrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}  
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
	 * @return the skuCode
	 */
	public String getSkuCode() {
		return skuCode;
	}

	/**
	 * @param skuCode the skuCode to set
	 */
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public BigDecimal getOrgPrice() {
		if (orgPrice != null) {
			orgPrice= orgPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}  
        return orgPrice;
    }

    public void setOrgPrice(BigDecimal orgPrice) {
        this.orgPrice = orgPrice;
    }

    public BigDecimal getGapPrice() {
    	if (gapPrice != null) {
    		gapPrice= gapPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}  
        return gapPrice;
    }

    public void setGapPrice(BigDecimal gapPrice) {
        this.gapPrice = gapPrice;
    }
}
