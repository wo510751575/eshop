package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：是否到店
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月9日
 */
public enum ExpResult {
	Y("是"),
	N("否")
	;
	
	ExpResult(String name){
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
