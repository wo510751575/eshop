/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.constant;

import java.util.HashMap;
import java.util.Map;

import com.lj.eshop.emus.AccWaterSource;

/**
 * 
 * 类说明：支付业务类型
 *  
 * 
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月8日
 */
public class PayAccSourceConstant {
	/** 支付业务类型 */
	public final static  Map<String, String> bizSources=new HashMap<String, String>();
	static {
		bizSources.put(AccWaterSource.ORDER.getValue(), "商品支付");
		bizSources.put(AccWaterSource.DEPOSIT.getValue(), "开店押金");
		bizSources.put(AccWaterSource.VIP.getValue(), "特权购买");
	}

}
