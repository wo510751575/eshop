package com.lj.eshop.dto;

import java.util.List;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindProductSkuPage extends PageParamEntity {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private ProductSkuDto param;
	
	//skuCode
	private List<String> inCodes;

	/*** 查询来源  b：B端要计算提成 c:端不计算提出返回 */
	private String from;
	
	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	/**
	 * @return the param
	 */
	public ProductSkuDto getParam() {
		return param;
	}

	/**
	 * @param param
	 */
	public void setParam(ProductSkuDto param) {
		this.param = param;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getInCodes() {
		return inCodes;
	}

	public void setInCodes(List<String> inCodes) {
		this.inCodes = inCodes;
	}
	
	

}
