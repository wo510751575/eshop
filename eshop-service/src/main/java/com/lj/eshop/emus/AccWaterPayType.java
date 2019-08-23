/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.emus;

/**
 * 
 * 类说明：账户流水支付方式。
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
public enum AccWaterPayType {
	//支付方式：0：支付宝 1:微信 2：网银 3：积分 4：优惠券 5:现金  
	/**支付宝*/
	ALI("0", "支付宝"),
	/**微信*/
	WX("1", "微信"),
	/**网银*/
	BANK("2", "网银"),
	/**积分*/
	integral("3","积分"),
	/**优惠券分*/
	DISCOUNT("4","优惠券"),
	/**现金*/
	CASH("5","现金"),
	/**虚拟资金*/
	VIRTUAL("6","虚拟资金"),
	/**特权*/
	RANK("7","特权");
	AccWaterPayType(String value, String chName) {
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
    	AccWaterPayType[] enums = AccWaterPayType.values();
    	for (int i = 0; i < enums.length; i++) {
			if(enums[i].getValue().equals(val)){
				return enums[i].getChName();
			}
		}
        return "";  
    }
}
