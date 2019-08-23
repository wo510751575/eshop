package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductSpeDto implements Serializable { 

    /** */
    private String code;

    /** */
    private String productCode;

    /** 规格说明*/
    private String ruleDetail;

    /** */
    private String ruleCode;

    /** */
    private BigDecimal salePrice;

    /** 0:默认显示的规格 1：非默认*/
    private String isDefault;

    /** 库存*/
    private String storeCnt;

    /** 规格说明*/
    private String remarks;
    /** 排序*/
    private Integer orderNo;
    
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

    public String getRuleDetail() {
        return ruleDetail;
    }

    public void setRuleDetail(String ruleDetail) {
        this.ruleDetail = ruleDetail == null ? null : ruleDetail.trim();
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode == null ? null : ruleCode.trim();
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

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public String getStoreCnt() {
        return storeCnt;
    }

    public void setStoreCnt(String storeCnt) {
        this.storeCnt = storeCnt == null ? null : storeCnt.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

	/**
	 * @return the orderNo
	 */
	public Integer getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
    
}
