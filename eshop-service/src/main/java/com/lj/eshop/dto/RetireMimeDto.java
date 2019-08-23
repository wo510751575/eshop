package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class RetireMimeDto implements Serializable {
    /** */
    private String code;

    /** 申请人电话*/
    private String phone;

    /** 申请人姓名*/
    private String memberName;

    /** 设备号*/
    private String cellMime;

    /** 快递号*/
    private String expressNo;

    /** 快递公司*/
    private String expressName;

    /** */
    private Date createTime;

    /** 状态 0:申请中  1:完成*/
    private String status;

    /** 说明*/
    private String remarks;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getCellMime() {
        return cellMime;
    }

    public void setCellMime(String cellMime) {
        this.cellMime = cellMime == null ? null : cellMime.trim();
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo == null ? null : expressNo.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
