/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 类说明：提现申请。
 *  
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月5日
 */
public class WithdrawApplyDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3758292178030022351L;


    /**
     *  银行卡code.
     */
    private String bankCardCode;
    /** 提现金额 */
    private BigDecimal amt;
    /** 提现密码  */
    private String payPwd;
	/**
	 * @return the bankCardCode
	 */
	public String getBankCardCode() {
		return bankCardCode;
	}
	/**
	 * @param bankCardCode the bankCardCode to set
	 */
	public void setBankCardCode(String bankCardCode) {
		this.bankCardCode = bankCardCode;
	}
	/**
	 * @return the amt
	 */
	public BigDecimal getAmt() {
		return amt;
	}
	/**
	 * @param amt the amt to set
	 */
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	/**
	 * @return the payPwd
	 */
	public String getPayPwd() {
		return payPwd;
	}
	/**
	 * @param payPwd the payPwd to set
	 */
	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}
    
    
    
}
