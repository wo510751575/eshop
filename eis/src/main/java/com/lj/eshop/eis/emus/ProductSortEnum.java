/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.emus;

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
 * CreateDate: 2017年8月30日
 */
public enum ProductSortEnum {
	
	/** 推荐排序：按照销量，活动，浏览量来排序 */
	SORT_RECOMMEND("p.sale_cnt DESC,p.product_order ASC,p.view_cnt DESC,p.evl_cnt DESC"),
	/** 价格 */
	SORT_PRICE("s.sale_price"),
	/** 销量  */
	SORT_SALE_CNT("p.sale_cnt"),
	/** 评价  */
	SORT_EVL_CNT("p.evl_cnt");
	
	private String sort;
	
	ProductSortEnum(String sort) {
			this.sort=sort;
	}

	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

}
