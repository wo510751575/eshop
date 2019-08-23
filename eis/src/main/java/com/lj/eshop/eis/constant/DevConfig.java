/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.constant;

import java.util.ResourceBundle;

/**
 * 
 * 类说明：开发期间开关配置。
 *  
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月9日
 */
public class DevConfig {
	/** 开发测试开关 true 代表开发期间，不走真实的逻辑，模拟流程*/
	private static Boolean DEV_TEST;
	
	/**
	 * 方法说明：开发测试开关 true 代表开发期间，不走真实的逻辑，模拟流程.
	 * @return
	 *
	 * @author lhy  2017年9月9日
	 *
	 */
	public static boolean isDevTest(){
		if(DEV_TEST==null){
			ResourceBundle upload = ResourceBundle.getBundle("properties/upload");
			String dev_test = upload.getString("dev_test");
			if ("true".equals(dev_test)) {
				DEV_TEST = true;
			}else{
				DEV_TEST = false;
			}
		}
		return DEV_TEST;
	}
}
