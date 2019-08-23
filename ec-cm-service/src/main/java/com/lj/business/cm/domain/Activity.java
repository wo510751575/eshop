package com.lj.business.cm.domain;

import java.util.Date;

public class Activity {
    /**
     * CODE .
     */
    private String code;

    /**
     * 客户编号 .
     */
    private String merchantNo;

    /**
     * 客户名称 .
     */
    private String merchantName;

    /**
     * 标题 .
     */
    private String title;

    /**
     * 内容 .
     */
    private String content;

    /**
     * 图片地址 .
     */
    private String imgAddr;

    /**
     * 网址链接 .
     */
    private String linkUrl;

    /**
     * 展示图片地址 .
     */
    private String showImgAddr;

    /**
     * 阅读量 .
     */
    private Long readCount;

    /**
     * 分享量 .
     */
    private Long shareCount;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 活动开始时间 .
     */
    private Date startDate;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * 备注 .
     */
    private String remark2;

    /**
     * 备注 .
     */
    private String remark3;

    /**
     * 备注 .
     */
    private String remark4;

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
     * 客户编号 .
     *
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 客户编号 .
     *
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 客户名称 .
     *
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 客户名称 .
     *
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * 标题 .
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题 .
     *
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 内容 .
     *
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容 .
     *
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 图片地址 .
     *
     */
    public String getImgAddr() {
        return imgAddr;
    }

    /**
     * 图片地址 .
     *
     */
    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr == null ? null : imgAddr.trim();
    }

    /**
     * 网址链接 .
     *
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 网址链接 .
     *
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    /**
     * 展示图片地址 .
     *
     */
    public String getShowImgAddr() {
        return showImgAddr;
    }

    /**
     * 展示图片地址 .
     *
     */
    public void setShowImgAddr(String showImgAddr) {
        this.showImgAddr = showImgAddr == null ? null : showImgAddr.trim();
    }

    /**
     * 阅读量 .
     *
     */
    public Long getReadCount() {
        return readCount;
    }

    /**
     * 阅读量 .
     *
     */
    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    /**
     * 分享量 .
     *
     */
    public Long getShareCount() {
        return shareCount;
    }

    /**
     * 分享量 .
     *
     */
    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
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
     * 活动开始时间 .
     *
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 活动开始时间 .
     *
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
     * 备注 .
     *
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Activity [code=").append(code);
        builder.append(",merchantNo=").append(merchantNo); 
        builder.append(",merchantName=").append(merchantName); 
        builder.append(",title=").append(title); 
        builder.append(",content=").append(content); 
        builder.append(",imgAddr=").append(imgAddr); 
        builder.append(",linkUrl=").append(linkUrl); 
        builder.append(",showImgAddr=").append(showImgAddr); 
        builder.append(",readCount=").append(readCount); 
        builder.append(",shareCount=").append(shareCount); 
        builder.append(",createId=").append(createId); 
        builder.append(",startDate=").append(startDate); 
        builder.append(",createDate=").append(createDate); 
        builder.append(",remark=").append(remark); 
        builder.append(",remark2=").append(remark2); 
        builder.append(",remark3=").append(remark3); 
        builder.append(",remark4=").append(remark4); 
        builder.append("]");
        return builder.toString();
    }
}