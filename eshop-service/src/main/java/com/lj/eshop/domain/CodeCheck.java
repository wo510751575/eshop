package com.lj.eshop.domain;

import java.util.Date;

public class CodeCheck {
    /** */
    private String code;

    /** 验证码*/
    private String sendCode;

    /** 业务类型 0:注册验证码 1:修改手机号验证 2:提现验证码 3:B端用户登录*/
    private String bizType;

    /** 发送时间*/
    private Date sendTime;

    /** 接受电话*/
    private String revicerPhone;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode == null ? null : sendCode.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getRevicerPhone() {
        return revicerPhone;
    }

    public void setRevicerPhone(String revicerPhone) {
        this.revicerPhone = revicerPhone == null ? null : revicerPhone.trim();
    }
}