package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindMerchantSettingPage extends PageParamEntity {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private MerchantSettingDto param;
	private String leftLikeValue;

	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	/**
	 * @return the param
	 */
	public MerchantSettingDto getParam() {
		return param;
	}

	/**
	 * @param param
	 */
	public void setParam(MerchantSettingDto param) {
		this.param = param;
	}

	public String getLeftLikeValue() {
		return leftLikeValue;
	}

	public void setLeftLikeValue(String leftLikeValue) {
		this.leftLikeValue = leftLikeValue;
	}
	
	

}
