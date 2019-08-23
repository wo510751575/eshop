package com.lj.eshop.domain;

import java.util.Date;

public class EvlLike {
    /** */
    private String code;

    /** */
    private String mbrCode;

    /** */
    private String evlCode;

    /** 创建时间*/
    private Date createTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMbrCode() {
        return mbrCode;
    }

    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }

    public String getEvlCode() {
        return evlCode;
    }

    public void setEvlCode(String evlCode) {
        this.evlCode = evlCode == null ? null : evlCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}