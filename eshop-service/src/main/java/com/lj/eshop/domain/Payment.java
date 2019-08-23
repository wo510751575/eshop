package com.lj.eshop.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    /** */
    private String code;

    /** */
    private Date createDate;

    /** */
    private Date modifyDate;

    /** 账户*/
    private String accCode;

    /** bank=收款银行*/
    private String bank;

    /** 到期时间*/
    private Date expire;

    /** 支付手续费*/
    private BigDecimal fee;

    /** */
    private String memo;

    /** 操作员*/
    private String operator;

    /** 付款人*/
    private String payer;

    /** 付款日期*/
    private Date paymentDate;

    /** 支付方式
0：支付宝 1:微信 2：网银 3：积分 4：优惠券 5:现金 6虚拟资金*/
    private String paymentMethod;

    /** 编号*/
    private String sn;

    /** 0 wait=等待支付  1 success=支付成功 2failure=支付失败 */
    private Integer status;

    /** 0 online=在线支付 1 offline=线下支付 2 deposit=预存款支付 3recharge=充值支付*/
    private Integer type;

    /** 会员*/
    private String mbrCode;

    /** 业务编号
biz_type :订单 (fk:t_order_no)
biz_type :押金 (fk:t_shop_no)*/
    private String bizNo;

    /** 删除标记（0未删除 1删除）*/
    private String delFlag;

    /** 第三方交易号*/
    private String thirdpartyTradeNo;

    /** 金额*/
    private BigDecimal amount;

    /** 失败原因*/
    private String failReason;

    /** 0：充值 1：提现 2：订单 3：销售提成 4：押金 5特权 6：定制订单*/
    private String accSource;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode == null ? null : accCode.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMbrCode() {
        return mbrCode;
    }

    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getThirdpartyTradeNo() {
        return thirdpartyTradeNo;
    }

    public void setThirdpartyTradeNo(String thirdpartyTradeNo) {
        this.thirdpartyTradeNo = thirdpartyTradeNo == null ? null : thirdpartyTradeNo.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public String getAccSource() {
        return accSource;
    }

    public void setAccSource(String accSource) {
        this.accSource = accSource == null ? null : accSource.trim();
    }
}