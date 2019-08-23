package com.lj.eshop.domain;

import java.util.Date;

public class Addrs {
    /** */
    private String code;

    /** 收件人*/
    private String reciverName;

    /** 联系手机*/
    private String reciverPhone;

    /** 邮编*/
    private String reciverZip;

    /** 会员编码*/
    private String mbrCode;

    /** 详细地址*/
    private String addrInfo;

    /** 是否默认 0:是 1:否*/
    private String isDefault;

    /** 省编码*/
    private String provinceCode;

    /** 市编码*/
    private String cityCode;

    /** 县编码*/
    private String areCode;

    /** 详细地址*/
    private String addrDetail;

    /** 创建时间*/
    private Date createTime;
    
    /** 是否删除（0未删除 1删除）*/
    private String delFlag;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReciverName() {
        return reciverName;
    }

    public void setReciverName(String reciverName) {
        this.reciverName = reciverName == null ? null : reciverName.trim();
    }

    public String getReciverPhone() {
        return reciverPhone;
    }

    public void setReciverPhone(String reciverPhone) {
        this.reciverPhone = reciverPhone == null ? null : reciverPhone.trim();
    }

    public String getReciverZip() {
        return reciverZip;
    }

    public void setReciverZip(String reciverZip) {
        this.reciverZip = reciverZip == null ? null : reciverZip.trim();
    }

    public String getMbrCode() {
        return mbrCode;
    }

    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }

    public String getAddrInfo() {
        return addrInfo;
    }

    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo == null ? null : addrInfo.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getAreCode() {
        return areCode;
    }

    public void setAreCode(String areCode) {
        this.areCode = areCode == null ? null : areCode.trim();
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail == null ? null : addrDetail.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
    
    
}