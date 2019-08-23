package com.lj.eshop.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    /** */
    private String code;

    /** 供应商名称*/
    private String supplyName;

    /** 供应商代码*/
    private String supplyCode;

    /** 供应商手机号码*/
    private String phone;

    /** 账单地址*/
    private String billAddr;

    /** 0:周结 1：双周结 2：月结 3：季度结 4：T+N*/
    private String payType;

    /** T+N的N天数*/
    private String accountDays;

    /** 0：生成  1：待确认 2：未生成 3:已经付款 4:待付款 */
    private String status;

    /** 账单生成日*/
    private Date billDate;

    /** 付款日*/
    private Date payDate;

    /** 账单金额*/
    private BigDecimal amt;

    /** 账单开始日（包含当天）*/
    private Date startDate;

    /** 账单结束日（包含当天）*/
    private Date endDate;

    /** 退款金额*/
    private BigDecimal retireAmt;

    /** */
    private String billFileAddrs;

    /** 采购笔数*/
    private Integer cnt;

    /** 退单笔数*/
    private Integer rtCnt;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBillAddr() {
        return billAddr;
    }

    public void setBillAddr(String billAddr) {
        this.billAddr = billAddr == null ? null : billAddr.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getRetireAmt() {
        return retireAmt;
    }

    public void setRetireAmt(BigDecimal retireAmt) {
        this.retireAmt = retireAmt;
    }

    public String getBillFileAddrs() {
        return billFileAddrs;
    }

    public void setBillFileAddrs(String billFileAddrs) {
        this.billFileAddrs = billFileAddrs == null ? null : billFileAddrs.trim();
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Integer getRtCnt() {
        return rtCnt;
    }

    public void setRtCnt(Integer rtCnt) {
        this.rtCnt = rtCnt;
    }
}