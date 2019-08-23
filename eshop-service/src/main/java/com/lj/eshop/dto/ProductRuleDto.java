package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.List;

public class ProductRuleDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1556483840352965212L;

	/** */
    private String code;

    /** 规格名*/
    private String name;

    /** 产品编号*/
    private String productCode;

    /** */
    private String remarks;

    /** 排序*/
    private Integer orderNo;
    
    /**商品的规格属性值*/
    private List<ProductSpeDto> spes;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

	/**
	 * @return the spes
	 */
	public List<ProductSpeDto> getSpes() {
		return spes;
	}

	/**
	 * @param spes the spes to set
	 */
	public void setSpes(List<ProductSpeDto> spes) {
		this.spes = spes;
	}
    
    
}
