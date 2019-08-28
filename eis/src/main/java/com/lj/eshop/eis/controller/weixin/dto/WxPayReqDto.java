/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.weixin.dto;

import java.math.BigDecimal;

/**
 * 
 * 类说明：JS预支付入参接口.
 * 
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月8日
 */
public class WxPayReqDto {
	
	/** 电商系统的会员号(谁支付的) */
	public String mbrCode;
	/** 商品描述 */
	public String body;
	/** 商户订单号 */
	public String outTradeNo;
	/** 标价金额 */
	public BigDecimal totalFee;
	/** 终端IP */
	public String spbillCreateIp;
	/** 支付页面的url（当前网页的URL，不包含#及其后面部分*/
	public String url;
	/**
	 * @return the 商品描述
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the 商户订单号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * @param outTradeNo
	 *            the outTradeNo to set
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 * @return 标价金额
	 */
	public BigDecimal getTotalFee() {
		return totalFee;
	}

	/**
	 * @param totalFee
	 *            the totalFee to set
	 */
	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * @return 终端IP
	 */
	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	/**
	 * @param spbillCreateIp
	 *            the spbillCreateIp to set
	 */
	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	/**
	 * @return  电商系统的会员号(谁支付的) 
	 */
	public String getMbrCode() {
		return mbrCode;
	}

	/**
	 * @param mbrCode the mbrCode to set
	 */
	public void setMbrCode(String mbrCode) {
		this.mbrCode = mbrCode;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
