package com.lj.eshop.domain;

import java.util.Date;

/**
 * 
 * 
 * 类说明：供应商表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月21日
 */
public class Supply {
    /** */
    private String code;

    /** */
    private String supplyName;

    /** */
    private String supplyCode;

    /** */
    private String tel;

    /** */
    private String email;

    /** 0:启用 1：停用*/
    private String status;

    /** */
    private String fax;

    /** 0:周结 1：双周结 2：月结 3：季度结 4：T+N*/
    private String payType;

    /** T+N的N天数*/
    private String accountDays;

    /** 银行卡号*/
    private String bankNo;

    /** 银行名称*/
    private String bankName;

    /** */
    private String remarks;

    /** */
    private Date updateTime;

    /** */
    private Date createTime;

    /** 供应商整体折扣*/
    private String discountOff;

    /** 账单开始日期*/
    private Date billStart;

    /** 供应商地址*/
    private String addrs;

    /** */
    private String merchantCode;

    /** */
    private String merchantName;

    /** 银行卡户主名*/
    private String bankAccName;

    /** 分行名*/
    private String bankBranch;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName == null ? null : supplyName.trim();
    }

    public String getSupplyCode() {
        return supplyCode;
    }

    public void setSupplyCode(String supplyCode) {
        this.supplyCode = supplyCode == null ? null : supplyCode.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getAccountDays() {
        return accountDays;
    }

    public void setAccountDays(String accountDays) {
        this.accountDays = accountDays == null ? null : accountDays.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDiscountOff() {
        return discountOff;
    }

    public void setDiscountOff(String discountOff) {
        this.discountOff = discountOff == null ? null : discountOff.trim();
    }

    public Date getBillStart() {
        return billStart;
    }

    public void setBillStart(Date billStart) {
        this.billStart = billStart;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs == null ? null : addrs.trim();
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode == null ? null : merchantCode.trim();
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getBankAccName() {
        return bankAccName;
    }

    public void setBankAccName(String bankAccName) {
        this.bankAccName = bankAccName == null ? null : bankAccName.trim();
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch == null ? null : bankBranch.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Supply [code=" + code + ", supplyName=" + supplyName
				+ ", supplyCode=" + supplyCode + ", tel=" + tel + ", email="
				+ email + ", status=" + status + ", fax=" + fax + ", payType="
				+ payType + ", accountDays=" + accountDays + ", bankNo="
				+ bankNo + ", bankName=" + bankName + ", remarks=" + remarks
				+ ", updateTime=" + updateTime + ", createTime=" + createTime
				+ ", discountOff=" + discountOff + ", billStart=" + billStart
				+ ", addrs=" + addrs + ", merchantCode=" + merchantCode
				+ ", merchantName=" + merchantName + ", bankAccName="
				+ bankAccName + ", bankBranch=" + bankBranch + "]";
	}
    
}