package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 类说明：
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月30日 
 */
public class AccWaterDto implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 8079151569658316002L;

	/** 记账流水主键*/
    private String code;

    /** 流水单号*/
    private String accWaterNo;

    /** 记账日期*/
    private Date accDate;

    /** 0：充值 1：提现 2：订单 3：销售提成 4：押金 5特权*/
    private String accSource;

    /** 0: AUTO自动记账
            1:MANUAL人工补单*/
    private String accType;

    /** 交易订单号*/
    private String tranOrderNo;

    /** 金额*/
    private BigDecimal amt;

    /** 账户编号*/
    private String accNo;

    /** 0：记账成功 1：记账中  2：记账失败*/
    private String status;

    /** 支付方式：0：支付宝 1:微信 2：网银 3：积分 4：优惠券 5:现金*/
    private String payType;

    /** 期初之前的金额 */
    private BigDecimal beforeAmt;

    /** 期末之前的金额 */
    private BigDecimal afterAmt;

    /** 流水业务类型 0：充值 1：消费 3：提成  4:退款 */
    private String bizType;

    /** 更新时间*/
    private Date updateTime;

    /** 操作人*/
    private String opCode;

    /** 1出账， 2入账*/
    private String waterType;

    /** 账户code(fk:t_account.code)*/
    private String accCode;
    
    /** 提成赚取金额 */
    private BigDecimal gapPrice;
    /** 商品名称  */
    private String productName;
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
    	if (amt != null) {
    		amt= amt.setScale(2, BigDecimal.ROUND_HALF_UP);
		} 
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
    	if (beforeAmt != null) {
    		beforeAmt= beforeAmt.setScale(2, BigDecimal.ROUND_HALF_UP);
		}  
		return beforeAmt;
    }

    public void setBeforeAmt(BigDecimal beforeAmt) {
        this.beforeAmt = beforeAmt;
    }

    public BigDecimal getAfterAmt() {
    	if (afterAmt != null) {
    		afterAmt= afterAmt.setScale(2, BigDecimal.ROUND_HALF_UP);
		}  
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

	/**
	 * @return the accCode
	 */
	public String getAccCode() {
		return accCode;
	}

	/**
	 * @param accCode the accCode to set
	 */
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	/**
	 * @return the gapPrice
	 */
	public BigDecimal getGapPrice() {
		if (gapPrice != null) {
			gapPrice= gapPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		} 
		return gapPrice;
	}

	/**
	 * @param gapPrice the gapPrice to set
	 */
	public void setGapPrice(BigDecimal gapPrice) {
		this.gapPrice = gapPrice;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
    
}
