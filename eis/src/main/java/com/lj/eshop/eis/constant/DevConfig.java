/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.constant;

import java.util.ResourceBundle;

import com.lj.eshop.eis.config.SysConfig;
import com.lj.eshop.eis.spring.SpringContextUtil;

/**
 * 
 * 类说明：开发期间开关配置。
 *  
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月9日
 */
public class DevConfig {
	private static  SysConfig  sysConfig = SpringContextUtil.getBean(SysConfig.class);
	
	/**
	 * 方法说明：开发测试开关 true 代表开发期间，不走真实的逻辑，模拟流程.
	 * @return
	 *
	 * @author lhy  2017年9月9日
	 *
	 */
	public static boolean isDevTest(){
		return sysConfig.isDevTest();
	}
}
