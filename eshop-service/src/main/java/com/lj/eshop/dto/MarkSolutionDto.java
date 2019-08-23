package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class MarkSolutionDto implements Serializable { 

    /** */
    private String code;

    /** 租金*/
    private String amt;

    /** 我的权利*/
    private String myPower;

    /** 详细说明*/
    private String detail;

    /** 方案状态 0:启用 1:停用*/
    private String status;

    /** */
    private Date createTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt == null ? null : amt.trim();
    }

    public String getMyPower() {
        return myPower;
    }

    public void setMyPower(String myPower) {
        this.myPower = myPower == null ? null : myPower.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
