package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindSupplyPage extends PageParamEntity {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private SupplyDto param;

	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	/**
	 * @return the param
	 */
	public SupplyDto getParam() {
		return param;
	}

	/**
	 * @param param
	 */
	public void setParam(SupplyDto param) {
		this.param = param;
	}

}
