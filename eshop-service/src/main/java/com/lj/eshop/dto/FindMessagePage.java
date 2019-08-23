package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindMessagePage extends PageParamEntity {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private MessageDto param;

	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	/**
	 * @return the param
	 */
	public MessageDto getParam() {
		return param;
	}

	/**
	 * @param param
	 */
	public void setParam(MessageDto param) {
		this.param = param;
	}

}
