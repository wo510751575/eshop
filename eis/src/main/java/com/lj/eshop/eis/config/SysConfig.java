/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.eshop.eis.constant.Constans;

/**
 *  
 * 类说明：对内的常量配置。
 *  
 * 
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月14日
 */
@Service
public class SysConfig {
	private static Logger logger = LoggerFactory.getLogger(SysConfig.class); 
	@Autowired 
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	 
	/**
	 * @return the wxPayNotifyUrl
	 */
	public String getWxPayNotifyUrl() {
		String wxPayNotifyUrl =  localCacheSystemParams.getSystemParam(Constans.CC_EIS_SYSTEMALIASNAME,Constans.CC_EC_WXAPI_GROUP,Constans.CC_EC_WXAPI_KEY_NOTIFY_URL);
		logger.info("eis.wxapi.pay.wx_notify_url:{}",wxPayNotifyUrl);
		return wxPayNotifyUrl;
	}
	
	/**
	 * 方法说明：开发测试开关 true 代表开发期间，不走真实的逻辑，模拟流程.
	 * @return
	 *
	 * @author lhy  2017年9月9日
	 *
	 */
	public boolean isDevTest(){
		String isDev =  localCacheSystemParams.getSystemParam(Constans.CC_EIS_SYSTEMALIASNAME,Constans.CC_EC_DEV_GROUP,Constans.CC_EC_DEV_KEY_ENV);
		logger.info("eis.dev.isDev:{}",isDev);
		if ("true".equals(isDev)) {
			return true;
		}else{
			return false;
		}
	}
	
}
