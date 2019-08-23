package com.lj.eshop.dto;

import java.util.List;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindOrderDetailPage extends PageParamEntity {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private OrderDetailDto param;

	//订购明细code
	private List<String> orderDetailCode;
	
	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	/**
	 * @return the param
	 */
	public OrderDetailDto getParam() {
		return param;
	}

	/**
	 * @param param
	 */
	public void setParam(OrderDetailDto param) {
		this.param = param;
	}

	public List<String> getOrderDetailCode() {
		return orderDetailCode;
	}

	public void setOrderDetailCode(List<String> orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}
	
	

}
