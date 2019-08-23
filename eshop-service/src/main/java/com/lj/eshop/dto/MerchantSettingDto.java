package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class MerchantSettingDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -5638788625198991461L;

	/** */
    private String code;

    /** 商户编号*/
    private String merchantCode;

    /** */
    private String value;

    /** */
    private String name;

    /** */
    private String remarks;

    /** */
    private Date createTime;

    /**  0:启用 1:停用*/
    private String status;
    
    /**  0:普通配置;1:图片配置*/
    private String types;

    public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode == null ? null : merchantCode.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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
}
