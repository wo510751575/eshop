package com.lj.eshop.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    /** */
    private String code;

    /** 账号*/
    private String accNo;

    /** 会员编码*/
    private String mbrCode;

    /** 可用金额*/
    private BigDecimal cashAmt;

    /** 特权可用金额*/
    private BigDecimal rankCashAmt;

    /** 总提现金额*/
    private BigDecimal totalWithdrawAmt;

    /** 账户类型 0：资金账户 1：其他*/
    private String type;

    /** 状态 0：激活 1：正常 2：冻结*/
    private String status;

    /** 赠送金额*/
    private BigDecimal freeAmt;

    /** 提现密码*/
    private String payPwd;

    /** 更新时间*/
    private Date updateTime;

    /** */
    private String creater;

    /** */
    private Date createTime;

    /** 提现密码连续输入错误次数*/
    private Integer wrongCnt;

    /** 提现密码输入错误的最新时间*/
    private Date wrongTime;
    /**
     * 历史花销
     */
    private BigDecimal payedAmount;
    
    /**
	 * @return the payedAmount
	 */
	public BigDecimal getPayedAmount() {
		return payedAmount;
	}

	/**
	 * @param payedAmount the payedAmount to set
	 */
	public void setPayedAmount(BigDecimal payedAmount) {
		this.payedAmount = payedAmount;
	}

	/**
	 * @return the cashAmt
	 */
	public BigDecimal getCashAmt() {
		return cashAmt;
	}

	/**
	 * @param cashAmt the cashAmt to set
	 */
	public void setCashAmt(BigDecimal cashAmt) {
		this.cashAmt = cashAmt;
	}

	/**
	 * @return the totalWithdrawAmt
	 */
	public BigDecimal getTotalWithdrawAmt() {
		return totalWithdrawAmt;
	}

	/**
	 * @param totalWithdrawAmt the totalWithdrawAmt to set
	 */
	public void setTotalWithdrawAmt(BigDecimal totalWithdrawAmt) {
		this.totalWithdrawAmt = totalWithdrawAmt;
	}

	/**
	 * @return the freeAmt
	 */
	public BigDecimal getFreeAmt() {
		return freeAmt;
	}

	/**
	 * @param freeAmt the freeAmt to set
	 */
	public void setFreeAmt(BigDecimal freeAmt) {
		this.freeAmt = freeAmt;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo == null ? null : accNo.trim();
    }

    public String getMbrCode() {
        return mbrCode;
    }

    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }


    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd == null ? null : payPwd.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public BigDecimal getRankCashAmt() {
		return rankCashAmt;
	}

	public void setRankCashAmt(BigDecimal rankCashAmt) {
		this.rankCashAmt = rankCashAmt;
	}

	/**
	 * @return the wrongCnt
	 */
	public Integer getWrongCnt() {
		return wrongCnt;
	}

	/**
	 * @param wrongCnt the wrongCnt to set
	 */
	public void setWrongCnt(Integer wrongCnt) {
		this.wrongCnt = wrongCnt;
	}

	/**
	 * @return the wrongTime
	 */
	public Date getWrongTime() {
		return wrongTime;
	}

	/**
	 * @param wrongTime the wrongTime to set
	 */
	public void setWrongTime(Date wrongTime) {
		this.wrongTime = wrongTime;
	}
    
    
}