package com.lj.eshop.dto;

import java.util.List;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindMaterialEcmPage extends PageParamEntity { 
	
	private static final long serialVersionUID = 1L;
	// 查询条件
	private MaterialCmDto param;
	
	private String memberNo;

	private String shopCode;
	
	private String merchantCode;
	
	private String title;

	/**
	 * eshhop的t_matreail_cm.code
	 */
	private String materialCmCode;
	
	/**
	 * cm的material/material_common.code
	 */
	private String cmMaterialCode;

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

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMaterialCmCode() {
		return materialCmCode;
	}

	public void setMaterialCmCode(String materialCmCode) {
		this.materialCmCode = materialCmCode;
	}

	public String getCmMaterialCode() {
		return cmMaterialCode;
	}

	public void setCmMaterialCode(String cmMaterialCode) {
		this.cmMaterialCode = cmMaterialCode;
	}
	
	
	
	
	
	
	
}
