package com.lj.eshop.domain;

import java.util.Date;

public class Message {
    /** 自增长ID*/
    private String code;

    /** 消息类型： 0、系统消息 1、通知*/
    private String type;

    /** 标题*/
    private String title;

    /** 发送者CODE*/
    private String sender;

    /** 接受者CODE*/
    private String recevier;

    /** 0、未读 1、已读*/
    private String isRead;

    /** 修改时间*/
    private Date updateTime;

    /** 创建时间*/
    private Date createTime;

    /** 删除标记*/
    private String senderDel;

    /** 删除标记*/
    private String recevierDel;

    /** 业务类型*/
    private String bizType;

    /** 业务编码*/
    private String bizCode;

    /** 店铺编号*/
    private String shopCode;

    /** 消息内容*/
    private String content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getRecevier() {
        return recevier;
    }

    public void setRecevier(String recevier) {
        this.recevier = recevier == null ? null : recevier.trim();
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead == null ? null : isRead.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSenderDel() {
        return senderDel;
    }

    public void setSenderDel(String senderDel) {
        this.senderDel = senderDel == null ? null : senderDel.trim();
    }

    public String getRecevierDel() {
        return recevierDel;
    }

    public void setRecevierDel(String recevierDel) {
        this.recevierDel = recevierDel == null ? null : recevierDel.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode == null ? null : bizCode.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}