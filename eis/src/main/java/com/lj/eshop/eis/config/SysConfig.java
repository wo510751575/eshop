/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.config;

/**
 *  
 * 类说明：对内的常量配置。
 *  
 * 
 * <p>
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月14日
 */
public class SysConfig {
	/**微信回调地址*/
	private String wxPayNotifyUrl;

	/**
	 * @return the wxPayNotifyUrl
	 */
	public String getWxPayNotifyUrl() {
		return wxPayNotifyUrl;
	}

	/**
	 * @param wxPayNotifyUrl the wxPayNotifyUrl to set
	 */
	public void setWxPayNotifyUrl(String wxPayNotifyUrl) {
		this.wxPayNotifyUrl = wxPayNotifyUrl;
	}
	
	
	
}
