package com.lj.eshop.domain;

public class ProductFlag {
    /** */
    private String code;

    /** 商品编号*/
    private String productCode;

    /** 商品标记编号*/
    private String flagCode;

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

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode == null ? null : flagCode.trim();
    }
}