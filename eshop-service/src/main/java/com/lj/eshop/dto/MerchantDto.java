package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class MerchantDto implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 商户名*/
    private String code;

    /** */
    private String merchantName;

    /** 商户联系手机号*/
    private String merchantPhone;

    /** 商户地址*/
    private String merchantAddr;

    /** 创建时间*/
    private Date createTime;

    /** OMS所属机构（fk:eoms.sys_office_id）*/
    private String officeId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone == null ? null : merchantPhone.trim();
    }

    public String getMerchantAddr() {
        return merchantAddr;
    }

    public void setMerchantAddr(String merchantAddr) {
        this.merchantAddr = merchantAddr == null ? null : merchantAddr.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId == null ? null : officeId.trim();
    }
}
