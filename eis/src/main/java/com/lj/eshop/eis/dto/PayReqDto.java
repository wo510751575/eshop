/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.dto;

import java.io.Serializable;

/**
 * 
 * 类说明：第三方支付请求入参。
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月8日
 */
public class PayReqDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4528393828233574731L;
	/** 必填：订单号 */
	private String orderNo;
	/** 必填：支付业务类型 （2：订单  4：押金  5特权  ）=t_acc_water.acc_source */
	private String accSource;
	/** 必填：支付方式 （支付方式：0：支付宝 1:微信 2：网银 3：积分 4：优惠券 5:现金 6虚拟资金  ） */
	private String payType;
	
	/** 支付页面的url（微信支付则要填，当前网页的URL，不包含#及其后面部分)*/
	public String url;
	/** 电商系统的会员号(谁支付的) */
	public String mbrCode;
	/** 终端IP */
	public String spbillCreateIp;
	
	/**
	 * @return the 订单号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	
	/**
	 * @return the 支付业务类型 （2：订单  4：押金  5特权  ）=t_acc_water.acc_source
	 */
	public String getAccSource() {
		return accSource;
	}
	/**
	 * @param accSource the accSource to set
	 */
	public void setAccSource(String accSource) {
		this.accSource = accSource;
	}
 
	/**
	 * @return  支付方式 （支付方式：0：支付宝 1:微信 2：网银 3：积分 4：优惠券 5:现金 6虚拟资金  ）
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * @return the spbillCreateIp
	 */
	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}
	/**
	 * @param spbillCreateIp the spbillCreateIp to set
	 */
	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
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
	/**
	 * @return the mbrCode
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
}
