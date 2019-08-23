package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindPaymentPage extends PageParamEntity { 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7178817685896647643L;
	// 查询条件
	private PaymentDto param;
	/**
	 * @return the param
	 */
	public PaymentDto getParam() {
		return param;
	}
	/**
	 * @param param the param to set
	 */
	public void setParam(PaymentDto param) {
		this.param = param;
	}
	
	
}
