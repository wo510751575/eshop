/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.emus;

/**
 * 
 * 类说明：账户流水业务类型。
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年8月23日
 */
public enum AccWaterBizType {
	/** 充值*/
	RECHARGE("0", "充值"),
	/** 消费*/
	CONSUME("1", "消费"), 
	/** 支付*/
	PAYMENT("2", "支付"), 
	/** 提成*/
	COMMISSION("3", "提成"), 
	/** 退款 */
	REFUND("4", "退款 "),
	/** 提现 */
	WITHDRAW("5", "提现");
	AccWaterBizType(String value, String chName) {
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
	
	/**
	 * 方法说明：通过key获取值
	 * @author 林进权
	 *         CreateDate: 2017年8月29日
	 */
    public static String getChName(String val) {  
    	AccWaterBizType[] enums = AccWaterBizType.values();
    	for (int i = 0; i < enums.length; i++) {
			if(enums[i].getValue().equals(val)){
				return enums[i].getChName();
			}
		}
        return "";  
    }
	
}
