package com.lj.eshop.domain;

import java.math.BigDecimal;

public class OrderRetireDetail {
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

    /** 金额*/
    private BigDecimal amt;

    /** 退单号（fk:t_order_retire.retire_no）*/
    private String retireNo;

    /** 商品sku编号(fk:t_product_code.sku_no)*/
    private String skuNo;
    /**
     * 订单明细Code
     */
    private String orderDetailCode;
    
    /**
	 * @return the orderDetailCode
	 */
	public String getOrderDetailCode() {
		return orderDetailCode;
	}

	/**
	 * @param orderDetailCode the orderDetailCode to set
	 */
	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
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
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getRetireNo() {
        return retireNo;
    }

    public void setRetireNo(String retireNo) {
        this.retireNo = retireNo == null ? null : retireNo.trim();
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo == null ? null : skuNo.trim();
    }
}