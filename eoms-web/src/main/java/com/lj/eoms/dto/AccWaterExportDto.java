package com.lj.eoms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lj.eoms.utils.excel.annotation.ExcelField;


/**
 * 
 * 类说明：账户流水导出dto
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月29日
 */
public class AccWaterExportDto implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -8475436664919196432L;
	
	/** 记账流水主键*/
    private String code;

    /** 流水单号*/
    @ExcelField(title="流水单号", align=0, sort=10)
    private String accWaterNo;

    /** 记账日期*/
    @ExcelField(title="记账日期", align=0, sort=20)
    private Date accDate;

    /** 流水来源:0：充值 1：提现 2：订单 3：销售提成 4：押金 5特权*/
 //   @ExcelField(title="流水来源", align=0, sort=30, dictType="xxx")
    @ExcelField(title="流水来源", align=0, sort=30)
    private String accSource;

    /** 流水记账类型:0: AUTO自动记账
            1:MANUAL人工补单*/
//    @ExcelField(title="流水记账类型", align=0, sort=40, fieldType=AccWaterAccTypeExl.class)
    @ExcelField(title="流水记账类型", align=0, sort=40)
    private String accType;

    /** 交易订单号*/
    @ExcelField(title="交易订单号", align=0, sort=50)
    private String tranOrderNo;

    /** 金额*/
    @ExcelField(title="金额", align=0, sort=60)
    private BigDecimal amt;

    /** 账户编号*/
    @ExcelField(title="账户编号", align=0, sort=70)
    private String accNo;

    /** 0：记账成功 1：记账中  2：记账失败*/
//    @ExcelField(title="流水状态", align=0, sort=80, fieldType=AccWaterStatusExl.class)
    @ExcelField(title="流水状态", align=0, sort=80)
    private String status;

    /** 支付方式：0：支付宝 1:微信 2：网银 3：积分 4：优惠券 5:现金*/
//    @ExcelField(title="支付方式", align=0, sort=90, fieldType=AccWaterPayTypeExl.class)
    @ExcelField(title="支付方式", align=0, sort=90)
    private String payType;

    /** 期初之前的金额 */
    @ExcelField(title="期初之前的金额", align=0, sort=100)
    private BigDecimal beforeAmt;

    /** 期末之前的金额 */
    @ExcelField(title="期末之前的金额", align=0, sort=110)
    private BigDecimal afterAmt;

    /** 流水业务类型 0：充值 1：消费 3：提成  4:退款 */
//    @ExcelField(title="流水业务类型", align=0, sort=120, fieldType=AccWaterBizTypeExl.class)
    @ExcelField(title="流水业务类型", align=0, sort=120)
    private String bizType;

    /** 更新时间*/
    @ExcelField(title="更新时间", align=0, sort=130)
    private Date updateTime;

    /** 操作人*/
    @ExcelField(title="操作人", align=0, sort=140)
    private String opCode;

    /** 账户流水类型:1出账， 2入账*/
//    @ExcelField(title="账户流水类型", align=0, sort=150, fieldType=AccWaterTypeExl.class)
    @ExcelField(title="账户流水类型", align=0, sort=150)
    private String waterType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getAccWaterNo() {
        return accWaterNo;
    }

    public void setAccWaterNo(String accWaterNo) {
        this.accWaterNo = accWaterNo == null ? null : accWaterNo.trim();
    }

    public Date getAccDate() {
        return accDate;
    }

    public void setAccDate(Date accDate) {
        this.accDate = accDate;
    }

    public String getAccSource() {
        return accSource;
    }

    public void setAccSource(String accSource) {
        this.accSource = accSource == null ? null : accSource.trim();
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType == null ? null : accType.trim();
    }

    public String getTranOrderNo() {
        return tranOrderNo;
    }

    public void setTranOrderNo(String tranOrderNo) {
        this.tranOrderNo = tranOrderNo == null ? null : tranOrderNo.trim();
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo == null ? null : accNo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public BigDecimal getBeforeAmt() {
        return beforeAmt;
    }

    public void setBeforeAmt(BigDecimal beforeAmt) {
        this.beforeAmt = beforeAmt;
    }

    public BigDecimal getAfterAmt() {
        return afterAmt;
    }

    public void setAfterAmt(BigDecimal afterAmt) {
        this.afterAmt = afterAmt;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode == null ? null : opCode.trim();
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType == null ? null : waterType.trim();
    }
}
