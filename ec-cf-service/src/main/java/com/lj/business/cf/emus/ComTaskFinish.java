package com.lj.business.cf.emus;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */


/**
 * 
 * 
 * 类说明：任务完成情况
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年6月26日
 */
public enum ComTaskFinish {

	
	NORMAL("进行中"),
	
	FINISH("完成"),
	CLOSE("已关闭"),
	C_SYS("系统关闭"),
	;
	
	
	private String name;
	
	private ComTaskFinish(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
