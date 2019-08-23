/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.emus;

/**
 * 
 * 
 * 类说明：统计维度
 *  
 * 
 * <p>
 * 详细描述：统计维度
            订单状态：0
            商品分类：1
            客户量：2
            销售额：3
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年9月11日
 */
public enum DimensionSt {
	
	/** 0：订单状态. */
	ORDER("0", "订单状态"),
	/** 商品分类. */
	CATALOG("1", "商品分类"),
	/** 客户量 . */
	MEMBER("2", "客户量"),
	/** 销售额*/
	AMT("3", "销售额");
	
	DimensionSt(String value, String chName) {
		this.value = value;
		this.chName = chName;
	}

	private String value;// DB 存贮值
	private String chName;// 值对应的中文描述
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the chName
	 */
	public String getChName() {
		return chName;
	}
	/**
	 * @param chName the chName to set
	 */
	public void setChName(String chName) {
		this.chName = chName;
	}
	
}
