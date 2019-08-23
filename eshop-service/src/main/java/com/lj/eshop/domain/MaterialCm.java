package com.lj.eshop.domain;

import java.util.Date;

public class MaterialCm {
    /**
     *  .
     */
    private String code;

    /**
     * fk: cm的[material卖家素材/material_code精选素材].code .
     */
    private String cmMaterialCode;

    /**
     * 商品code，外键(t_product.code) .
     */
    private String productCode;

    /**
     * 商品名称 .
     */
    private String productName;

    /**
     * 0卖家素材, 1官方素材， 6个人素材 .
     */
    private String type;

    /**
     * 如果是卖家素材，被加入为精选后， 精选code(fk: cm.material_commen.code) .
     */
    private String choicenessCode;

    /**
     * 商店code(fk: t_shop.code) .
     */
    private String shopCode;

    /**
     * 商户code(fk: t_merchant.code) .
     */
    private String merchantCode;

    /**
     *  .
     */
    private Date createTime;

    /**
     * 素材类型code .
     */
    private String materialTypeCode;

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
     * fk: cm的[material卖家素材/material_code精选素材].code .
     *
     */
    public String getCmMaterialCode() {
        return cmMaterialCode;
    }

    /**
     * fk: cm的[material卖家素材/material_code精选素材].code .
     *
     */
    public void setCmMaterialCode(String cmMaterialCode) {
        this.cmMaterialCode = cmMaterialCode == null ? null : cmMaterialCode.trim();
    }

    /**
     * 商品code，外键(t_product.code) .
     *
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 商品code，外键(t_product.code) .
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
     * 0卖家素材, 1官方素材， 6个人素材 .
     *
     */
    public String getType() {
        return type;
    }

    /**
     * 0卖家素材, 1官方素材， 6个人素材 .
     *
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 如果是卖家素材，被加入为精选后， 精选code(fk: cm.material_commen.code) .
     *
     */
    public String getChoicenessCode() {
        return choicenessCode;
    }

    /**
     * 如果是卖家素材，被加入为精选后， 精选code(fk: cm.material_commen.code) .
     *
     */
    public void setChoicenessCode(String choicenessCode) {
        this.choicenessCode = choicenessCode == null ? null : choicenessCode.trim();
    }

    /**
     * 商店code(fk: t_shop.code) .
     *
     */
    public String getShopCode() {
        return shopCode;
    }

    /**
     * 商店code(fk: t_shop.code) .
     *
     */
    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    /**
     * 商户code(fk: t_merchant.code) .
     *
     */
    public String getMerchantCode() {
        return merchantCode;
    }

    /**
     * 商户code(fk: t_merchant.code) .
     *
     */
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode == null ? null : merchantCode.trim();
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
     * 素材类型code .
     *
     */
    public String getMaterialTypeCode() {
        return materialTypeCode;
    }

    /**
     * 素材类型code .
     *
     */
    public void setMaterialTypeCode(String materialTypeCode) {
        this.materialTypeCode = materialTypeCode == null ? null : materialTypeCode.trim();
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MaterialCm [code=").append(code);
        builder.append(",cmMaterialCode=").append(cmMaterialCode); 
        builder.append(",productCode=").append(productCode); 
        builder.append(",productName=").append(productName); 
        builder.append(",type=").append(type); 
        builder.append(",choicenessCode=").append(choicenessCode); 
        builder.append(",shopCode=").append(shopCode); 
        builder.append(",merchantCode=").append(merchantCode); 
        builder.append(",createTime=").append(createTime); 
        builder.append(",materialTypeCode=").append(materialTypeCode); 
        builder.append("]");
        return builder.toString();
    }
}