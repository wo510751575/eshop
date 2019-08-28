/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.weixin.config;

/**
 * 
 * 类说明：微信公众号配置。
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月7日
 */
public class WeixinConfigDto {
	/** 公众号的唯一标识 */
	private String appid;
	/** 微信支付分配的商户号 */
	private String mchId;
	/** APP 应用密钥 用于公众号通过code换取网页授权access_token,的参数 位置：开发者中心-配置项 */
	private String appSecret;
	/** API安全 密钥 用于支付签名 位置：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置 */
	private String apiKey;
	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * @param appid the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * @return the mchId
	 */
	public String getMchId() {
		return mchId;
	}
	/**
	 * @param mchId the mchId to set
	 */
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	/**
	 * APP 应用密钥 用于公众号通过code换取网页授权access_token,的参数 位置：开发者中心-配置项 
	 * @return the appSecret
	 */
	public String getAppSecret() {
		return appSecret;
	}
	/**
	 * @param appSecret the appSecret to set
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	/**
	 * API安全 密钥 用于支付签名 位置：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}
	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
}
