package com.lj.eshop.dto;

import java.util.List;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindOrderRetirePage extends PageParamEntity {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private OrderRetireDto param;
	//订单状态list
	private List<String> inOrderNos;
	
	//会员code
	private String mbrCode;
	//商户code
	private String merchantCode;
	//商店code
	private String shopCode;

	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	/**
	 * @return the param
	 */
	public OrderRetireDto getParam() {
		return param;
	}

	/**
	 * @param param
	 */
	public void setParam(OrderRetireDto param) {
		this.param = param;
	}

	public List<String> getInOrderNos() {
		return inOrderNos;
	}

	public void setInOrderNos(List<String> inOrderNos) {
		this.inOrderNos = inOrderNos;
	}

	public String getMbrCode() {
		return mbrCode;
	}

	public void setMbrCode(String mbrCode) {
		this.mbrCode = mbrCode;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	
	
	
	

	
	
	

}
