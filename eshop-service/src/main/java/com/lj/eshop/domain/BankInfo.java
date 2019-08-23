package com.lj.eshop.domain;

import java.util.Date;

public class BankInfo {
    /** */
    private String code;

    /** */
    private String bankName;

    /** */
    private String bankIcon;

    /** 排序（越小越前）*/
    private Integer orderNo;

    /** */
    private Date createTime;
    /** 背景图*/
    private String bgIcon;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankIcon() {
        return bankIcon;
    }

    public void setBankIcon(String bankIcon) {
        this.bankIcon = bankIcon == null ? null : bankIcon.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	/**
	 * @return the bgIcon
	 */
	public String getBgIcon() {
		return bgIcon;
	}

	/**
	 * @param bgIcon the bgIcon to set
	 */
	public void setBgIcon(String bgIcon) {
		this.bgIcon = bgIcon;
	}
    
}