package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class MbrbankDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -9062976675059473636L;

	/** */
    private String code;

    /** 会员编号*/
    private String mbrCode;

    /** 银行名称*/
    private String bankName;

    /** 分支行*/
    private String branchBank;

    /** 卡号*/
    private String bankAccNo;

    /** 开户姓名*/
    private String accName;

    /** 创建时间*/
    private Date createTime;

    /** 所属银行code*/
    private String bankCode;
    /** 预留手机号*/
    private String phone;
    
    /** 银行图标 */
    private String bankIcon;
    /** 背景图*/
    private String bgIcon;
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBranchBank() {
        return branchBank;
    }

    public void setBranchBank(String branchBank) {
        this.branchBank = branchBank == null ? null : branchBank.trim();
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo == null ? null : bankAccNo.trim();
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName == null ? null : accName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	/**
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the bankIcon
	 */
	public String getBankIcon() {
		return bankIcon;
	}

	/**
	 * @param bankIcon the bankIcon to set
	 */
	public void setBankIcon(String bankIcon) {
		this.bankIcon = bankIcon;
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
