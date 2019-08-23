package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * 类说明：提现申请DTO
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月22日
 */
public class WithdrawDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -2326241160661414476L;

	/**
     *  .
     */
    private String code;

    /**
     * 提现人姓名 .
     */
    private String mbrName;

    /**
     * 提现人代码 .
     */
    private String mbrCode;

    /**
     * 提现金额 .
     */
    private BigDecimal amt;

    /**
     * 提现人银行名称 .
     */
    private String bankName;

    /**
     * 提现人银行账户 .
     */
    private String bankAccNo;

    /**
     * 提现至银行 .
     */
    private String branchBank;

    /**
     * 0：申请中 1：提现成功 2：提现失败 3：取消提现  .
     */
    private String status;

    /**
     *  .
     */
    private String phone;

    /**
     * 失败原因 .
     */
    private String failReason;

    /**
     *  .
     */
    private Date createTime;

    /**
     *  .
     */
    private Date updateTime;

    /**
     * 提现申请编号 .
     */
    private String withdrawNo;

    /**
     *  .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     *  .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 提现人姓名 .
     *
     */
    public String getMbrName() {
        return mbrName;
    }

    /**
     * 提现人姓名 .
     *
     */
    public void setMbrName(String mbrName) {
        this.mbrName = mbrName == null ? null : mbrName.trim();
    }

    /**
     * 提现人代码 .
     *
     */
    public String getMbrCode() {
        return mbrCode;
    }

    /**
     * 提现人代码 .
     *
     */
    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }

    /**
     * 提现金额 .
     *
     */
    public BigDecimal getAmt() {
    	if (amt != null) {
			amt= amt.setScale(2, BigDecimal.ROUND_HALF_UP);
		} 
    	return amt;
    }

    /**
     * 提现金额 .
     *
     */
    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    /**
     * 提现人银行名称 .
     *
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 提现人银行名称 .
     *
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 提现人银行账户 .
     *
     */
    public String getBankAccNo() {
        return bankAccNo;
    }

    /**
     * 提现人银行账户 .
     *
     */
    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo == null ? null : bankAccNo.trim();
    }

    /**
     * 提现至银行 .
     *
     */
    public String getBranchBank() {
        return branchBank;
    }

    /**
     * 提现至银行 .
     *
     */
    public void setBranchBank(String branchBank) {
        this.branchBank = branchBank == null ? null : branchBank.trim();
    }

    /**
     * 0：申请中 1：提现成功 2：提现失败 3：取消提现  .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 0：申请中 1：提现成功 2：提现失败 3：取消提现  .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     *  .
     *
     */
    public String getPhone() {
        return phone;
    }

    /**
     *  .
     *
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 失败原因 .
     *
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * 失败原因 .
     *
     */
    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    /**
     *  .
     *
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *  .
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *  .
     *
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *  .
     *
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 提现申请编号 .
     *
     */
    public String getWithdrawNo() {
        return withdrawNo;
    }

    /**
     * 提现申请编号 .
     *
     */
    public void setWithdrawNo(String withdrawNo) {
        this.withdrawNo = withdrawNo == null ? null : withdrawNo.trim();
    }
 

	/**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Withdraw [code=").append(code);
        builder.append(",mbrName=").append(mbrName); 
        builder.append(",mbrCode=").append(mbrCode); 
        builder.append(",amt=").append(amt); 
        builder.append(",bankName=").append(bankName); 
        builder.append(",bankAccNo=").append(bankAccNo); 
        builder.append(",branchBank=").append(branchBank); 
        builder.append(",status=").append(status); 
        builder.append(",phone=").append(phone); 
        builder.append(",failReason=").append(failReason); 
        builder.append(",createTime=").append(createTime); 
        builder.append(",updateTime=").append(updateTime); 
        builder.append(",withdrawNo=").append(withdrawNo); 
        builder.append("]");
        return builder.toString();
    }
}
