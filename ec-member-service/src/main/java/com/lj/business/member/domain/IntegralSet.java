package com.lj.business.member.domain;

import java.math.BigDecimal;
import java.util.Date;

public class IntegralSet {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 商户名称 .
     */
    private String merchantName;

    /**
     * 分店编号 .
     */
    private String shopNo;

    /**
     * 分店名称 .
     */
    private String shopName;

    /**
     * 区域CODE .
     */
    private String areaCode;

    /**
     * 区域名称 .
     */
    private String areaName;

    /**
     * 积分类型 .
     */
    private String integralType;

    /**
     * 积分类型名称 .
     */
    private String integralName;

    /**
     * 积分 .
     */
    private BigDecimal integralScore;

    /**
     * 积分上限 .
     */
    private BigDecimal integralUp;

    /**
     * 积分上限 .
     */
    private BigDecimal integralDown;

    /**
     * 状态  Y 正常  N  禁用 .
     */
    private String status;

    /**
     * 更新人 .
     */
    private String updateId;

    /**
     * 更新时间 .
     */
    private Date updateDate;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * CODE .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商户编号 .
     *
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 商户名称 .
     *
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 商户名称 .
     *
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * 分店编号 .
     *
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * 分店编号 .
     *
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    /**
     * 分店名称 .
     *
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 分店名称 .
     *
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 区域CODE .
     *
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 区域CODE .
     *
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * 区域名称 .
     *
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 区域名称 .
     *
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * 积分类型 .
     *
     */
    public String getIntegralType() {
        return integralType;
    }

    /**
     * 积分类型 .
     *
     */
    public void setIntegralType(String integralType) {
        this.integralType = integralType == null ? null : integralType.trim();
    }

    /**
     * 积分类型名称 .
     *
     */
    public String getIntegralName() {
        return integralName;
    }

    /**
     * 积分类型名称 .
     *
     */
    public void setIntegralName(String integralName) {
        this.integralName = integralName == null ? null : integralName.trim();
    }

    /**
     * 积分 .
     *
     */
    public BigDecimal getIntegralScore() {
        return integralScore;
    }

    /**
     * 积分 .
     *
     */
    public void setIntegralScore(BigDecimal integralScore) {
        this.integralScore = integralScore;
    }

    /**
     * 积分上限 .
     *
     */
    public BigDecimal getIntegralUp() {
        return integralUp;
    }

    /**
     * 积分上限 .
     *
     */
    public void setIntegralUp(BigDecimal integralUp) {
        this.integralUp = integralUp;
    }

    /**
     * 积分上限 .
     *
     */
    public BigDecimal getIntegralDown() {
        return integralDown;
    }

    /**
     * 积分上限 .
     *
     */
    public void setIntegralDown(BigDecimal integralDown) {
        this.integralDown = integralDown;
    }

    /**
     * 状态  Y 正常  N  禁用 .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态  Y 正常  N  禁用 .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 更新人 .
     *
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 更新人 .
     *
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * 更新时间 .
     *
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间 .
     *
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 创建人 .
     *
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("IntegralSet [code=").append(code);
        builder.append(",merchantNo=").append(merchantNo); 
        builder.append(",merchantName=").append(merchantName); 
        builder.append(",shopNo=").append(shopNo); 
        builder.append(",shopName=").append(shopName); 
        builder.append(",areaCode=").append(areaCode); 
        builder.append(",areaName=").append(areaName); 
        builder.append(",integralType=").append(integralType); 
        builder.append(",integralName=").append(integralName); 
        builder.append(",integralScore=").append(integralScore); 
        builder.append(",integralUp=").append(integralUp); 
        builder.append(",integralDown=").append(integralDown); 
        builder.append(",status=").append(status); 
        builder.append(",updateId=").append(updateId); 
        builder.append(",updateDate=").append(updateDate); 
        builder.append(",createId=").append(createId); 
        builder.append(",createDate=").append(createDate); 
        builder.append("]");
        return builder.toString();
    }
}