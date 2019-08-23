package com.lj.eshop.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
	/** */
    private String code;

    /** */
    private String supplyCode;

    /** */
    private String supplyName;

    /** 产品名称*/
    private String name;

    /** 商品类目*/
    private String catalogTypeCode;

    /** 小B进货价*/
    private BigDecimal orgPrice;

    /** C端售价*/
    private BigDecimal salePrice;

    /** 小B返利价*/
    private BigDecimal gapPrice;

    /** 库存数量*/
    private Integer cnt;

    /** 已经销售数量*/
    private Integer saleCnt;

    /** 详细说明*/
    private String remarks;

    /** 单位*/
    private String unit;

    /** 状态 0:上架  1:下架*/
    private String status;

    /** 包装信息*/
    private String packageInfo;

    /** 目前都是到付*/
    private String expressFee;

    /** 总评分数*/
    private Integer totalScore;

    /** 规格图片*/
    private String speImg;

    /** 浏览量*/
    private Integer viewCnt;

    /** 评论数*/
    private Integer evlCnt;

    /** 分享数*/
    private Integer shareCnt;

    /** 在售人数*/
    private Integer saleShopCnt;

    /** 所属商户*/
    private String merchantCode;

    /** 邮费到付否(0 是 1 否)*/
    private String collectFlag;

    /** 24小时无理由退货否(0 是 1 否)*/
    private String returnFlag;

    /** 包精美礼盒包装否(0 是 1 否)*/
    private String packFlag;

    /** */
    private Date createTime;

    /** t_product*/
    private Date updateTime;

    /** 商品关键字(标签及专题文本设置到此用于搜索)*/
    private String productKey;

    /** 商品icon*/
    private String productIcon;

    /** 商品排序（商品标签的最低卡位数）*/
    private Integer productOrder;

    /** 商品描述*/
    private String productDesc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCatalogTypeCode() {
        return catalogTypeCode;
    }

    public void setCatalogTypeCode(String catalogTypeCode) {
        this.catalogTypeCode = catalogTypeCode == null ? null : catalogTypeCode.trim();
    }

    public BigDecimal getOrgPrice() {
        return orgPrice;
    }

    public void setOrgPrice(BigDecimal orgPrice) {
        this.orgPrice = orgPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getGapPrice() {
        return gapPrice;
    }

    public void setGapPrice(BigDecimal gapPrice) {
        this.gapPrice = gapPrice;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Integer getSaleCnt() {
        return saleCnt;
    }

    public void setSaleCnt(Integer saleCnt) {
        this.saleCnt = saleCnt;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(String packageInfo) {
        this.packageInfo = packageInfo == null ? null : packageInfo.trim();
    }

    public String getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee == null ? null : expressFee.trim();
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getSpeImg() {
        return speImg;
    }

    public void setSpeImg(String speImg) {
        this.speImg = speImg == null ? null : speImg.trim();
    }

    public Integer getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(Integer viewCnt) {
        this.viewCnt = viewCnt;
    }

    public Integer getEvlCnt() {
        return evlCnt;
    }

    public void setEvlCnt(Integer evlCnt) {
        this.evlCnt = evlCnt;
    }

    public Integer getShareCnt() {
        return shareCnt;
    }

    public void setShareCnt(Integer shareCnt) {
        this.shareCnt = shareCnt;
    }

    public Integer getSaleShopCnt() {
        return saleShopCnt;
    }

    public void setSaleShopCnt(Integer saleShopCnt) {
        this.saleShopCnt = saleShopCnt;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode == null ? null : merchantCode.trim();
    }

    public String getCollectFlag() {
        return collectFlag;
    }

    public void setCollectFlag(String collectFlag) {
        this.collectFlag = collectFlag == null ? null : collectFlag.trim();
    }

    public String getReturnFlag() {
        return returnFlag;
    }

    public void setReturnFlag(String returnFlag) {
        this.returnFlag = returnFlag == null ? null : returnFlag.trim();
    }

    public String getPackFlag() {
        return packFlag;
    }

    public void setPackFlag(String packFlag) {
        this.packFlag = packFlag == null ? null : packFlag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey == null ? null : productKey.trim();
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon == null ? null : productIcon.trim();
    }

    public Integer getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(Integer productOrder) {
        this.productOrder = productOrder;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }
}