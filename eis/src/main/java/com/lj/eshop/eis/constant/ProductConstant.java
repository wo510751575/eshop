/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年8月30日
 */
public class ProductConstant {
	private static final Map<String, String> sort = new HashMap<String, String>();

	/** 推荐类型 */
	public final static String SORT_TYPE_TJ = "tj";
	static {
		/** 推荐排序：按照销量，活动，浏览量来排序 */
		sort.put(SORT_TYPE_TJ, "p.sale_cnt DESC,p.product_order ASC,p.view_cnt DESC,p.evl_cnt DESC");
		/** 价格 */
		sort.put("jg", "s.sale_price");
		/** 销量 */
		sort.put("xl", "p.sale_cnt");
		/** 评价 */
		sort.put("pj", "p.evl_cnt");
		/** C端店铺商品所需，新品上架 **/
//		sort.put("xp", "t.create_time")
		;
	}

	/***
	 * 方法说明：获取商品排序方式。
	 *
	 * @param type
	 * @return
	 *
	 * @author lhy 2017年8月30日
	 *
	 */
	public static String getSort(String type) {
		return sort.get(type);
	}
}
