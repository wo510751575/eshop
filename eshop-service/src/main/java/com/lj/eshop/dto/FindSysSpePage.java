package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindSysSpePage extends PageParamEntity { 

	private static final long serialVersionUID = 1L;
	// 查询条件
	private SysSpeDto param;
	/**
	 * @return the param
	 */
	public SysSpeDto getParam() {
		return param;
	}
	/**
	 * @param param the param to set
	 */
	public void setParam(SysSpeDto param) {
		this.param = param;
	}
	
	
}
