package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class ShopRetireDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -8213670271763541113L;

	/** */
    private String code;

    /** 退出申请编号*/
    private String retireNo;

    /** 会员编号*/
    private String mbrCode;

    /** 店铺编号*/
    private String shopCode;

    /** 状态（0待审核，1成功，2失败）*/
    private String auditStatus;

    /** 退款状态（1成功 2失败）*/
    private String retireStatus;

    /** 快递单号*/
    private String expressNo;

    /** 0待收货 1已收货*/
    private String expressStatus;

    /** 创建时间*/
    private Date createTime;

    /** 修改时间*/
    private Date updateTime;

    /** 审核人*/
    private String auditor;

    /** 备注*/
    private String remarks;

    /** 快递公司*/
    private String expressName;
    /**店铺名称**/
    private String shopName;
    /**会员名称**/
    private String memberName;

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getRetireNo() {
        return retireNo;
    }

    public void setRetireNo(String retireNo) {
        this.retireNo = retireNo == null ? null : retireNo.trim();
    }

    public String getMbrCode() {
        return mbrCode;
    }

    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public String getRetireStatus() {
        return retireStatus;
    }

    public void setRetireStatus(String retireStatus) {
        this.retireStatus = retireStatus == null ? null : retireStatus.trim();
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo == null ? null : expressNo.trim();
    }

    public String getExpressStatus() {
        return expressStatus;
    }

    public void setExpressStatus(String expressStatus) {
        this.expressStatus = expressStatus == null ? null : expressStatus.trim();
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

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShopRetire [code=" + code + ", retireNo=" + retireNo
				+ ", mbrCode=" + mbrCode + ", shopCode=" + shopCode
				+ ", auditStatus=" + auditStatus + ", retireStatus="
				+ retireStatus + ", expressNo=" + expressNo
				+ ", expressStatus=" + expressStatus + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", auditor="
				+ auditor + ", remarks=" + remarks + ", expressName="
				+ expressName + "]";
	}
    
    
}
