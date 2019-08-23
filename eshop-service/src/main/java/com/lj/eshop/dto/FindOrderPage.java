package com.lj.eshop.dto;

import java.util.List;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindOrderPage extends PageParamEntity {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private OrderDto param;

	
	private List<String> inStatuss;
	
	
	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	
	
	
	/**
	 * @return the param
	 */
	public OrderDto getParam() {
		return param;
	}

	/**
	 * @param param
	 */
	public void setParam(OrderDto param) {
		this.param = param;
	}

	public List<String> getInStatuss() {
		return inStatuss;
	}

	public void setInStatuss(List<String> inStatuss) {
		this.inStatuss = inStatuss;
	}

	
	
}
