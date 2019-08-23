package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindBankInfoPage extends PageParamEntity { 
	/**
	 * 
	 */
	private static final long serialVersionUID = -6992886315250148067L;
	// 查询条件
	private BankInfoDto param;
	/**
	 * @return the param
	 */
	public BankInfoDto getParam() {
		return param;
	}
	/**
	 * @param param the param to set
	 */
	public void setParam(BankInfoDto param) {
		this.param = param;
	}
	
	
}
