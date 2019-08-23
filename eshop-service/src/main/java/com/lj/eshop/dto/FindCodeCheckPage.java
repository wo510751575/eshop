package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity;

public class FindCodeCheckPage extends PageParamEntity {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private CodeCheckDto param;

	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	/**
	 * @return the param
	 */
	public CodeCheckDto getParam() {
		return param;
	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void setParam(CodeCheckDto param) {
		this.param = param;
	}

}
