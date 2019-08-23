package com.lj.eshop.domain;

import java.util.Date;

/**
 * 
 * 
 * 类说明：店铺商品
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
public class ShopProduct {
    /**
     *  .
     */
    private String code;

    /**
     *  .
     */
    private String shopCode;

    /**
     *  .
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