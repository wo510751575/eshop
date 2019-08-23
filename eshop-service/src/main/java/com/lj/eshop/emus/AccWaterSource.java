/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.emus;


/**
 * 
 * 类说明：账户流水来源。
 *  
 * 
 * <p>
 * 详细描述：0：充值 1：提现 2：订单 3：销售提成 4：押金
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年8月23日
 */
public enum AccWaterSource {
	/**充值**/
	RECHARGE("0", "充值"),
	/**提现*/
	WITHDRAW("1", "提现"), 
	/**订单*/
	ORDER("2", "订单"), 
	/**销售提成*/
	COMMISSION("3", "销售提成"), 
	/**押金*/
	DEPOSIT("4", "押金"),
	/**特权*/
	VIP("5", "特权"),
	/**定制订单*/
	CUSTORDER("6", "定制订单");
	AccWaterSource(String value, String chName) {
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
        AccWaterSource[] enums = AccWaterSource.values();
    	for (int i = 0; i < enums.length; i++) {
			if(enums[i].getValue().equals(val)){
				return enums[i].getChName();
			}
		}
        return "";  
    }
    
    
}
