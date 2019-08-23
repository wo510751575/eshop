package com.lj.eshop.dto;

import java.util.List;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindMaterialCmPage extends PageParamEntity { 
	
	private static final long serialVersionUID = 1L;
	// 查询条件
	private MaterialCmDto param;

	private List<String> inCmMaterialCodes;
	
	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	

	public MaterialCmDto getParam() {
		return param;
	}

	public void setParam(MaterialCmDto param) {
		this.param = param;
	}

	public List<String> getInCmMaterialCodes() {
		return inCmMaterialCodes;
	}

	public void setInCmMaterialCodes(List<String> inCmMaterialCodes) {
		this.inCmMaterialCodes = inCmMaterialCodes;
	}
	
}
