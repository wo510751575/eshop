/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.weixin.dto;

/**
 * 
 * 类说明：JS预支付出参接口.
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月8日
 */
public class WxPayRespDto {
	/** 公众号id	*/
	private String appId;
	/** 时间戳 (自1970年1月1日 0点0分0秒以来的秒数)*/
	private String timeStamp;
	/** 随机字符串	*/
	private String nonceStr;
	/** 预付单号，用于订单详情扩展字符串,格式(prepayId=prepay_id=123456789)*/
	private String prepayId;
	/** 签名方式 暂支持MD5*/
	private String signType;
	/** 支付签名*/
	private String paySign;
	/** JS-SDK config 签名*/
	private String ticketSign;
	/**
	 * @return 公众号id
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * @return 时间戳 (自1970年1月1日 0点0分0秒以来的秒数)
	 */
	public String getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return  随机字符串
	 */
	public String getNonceStr() {
		return nonceStr;
	}
	/**
	 * @param nonceStr the nonceStr to set
	 */
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	/**
	 * @return 订单详情扩展字符串
	 */
	public String getPrepayId() {
		return prepayId;
	}
	/**
	 * @param prepayId the prepayId to set
	 */
	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	/**
	 * @return 签名方式 暂支持MD5
	 */
	public String getSignType() {
		return signType;
	}
	/**
	 * @param signType the signType to set
	 */
	public void setSignType(String signType) {
		this.signType = signType;
	}
	/**
	 * @return 签名
	 */
	public String getPaySign() {
		return paySign;
	}
	/**
	 * @param paySign the paySign to set
	 */
	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
	/**
	 * @return the ticketSign
	 */
	public String getTicketSign() {
		return ticketSign;
	}
	/**
	 * @param ticketSign the ticketSign to set
	 */
	public void setTicketSign(String ticketSign) {
		this.ticketSign = ticketSign;
	}
	
}
