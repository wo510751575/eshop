package com.lj.business.member.dto;

import java.io.Serializable;

public class FindShopGmDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5014982912232070375L;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 导购编号
	 */
	private String memberNoGm;
	
	/** 分店编号. */
	private String shopNo;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindShopGmDto [merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm).append(", shopNo=")
				.append(shopNo).append("]");
		return builder.toString();
	}
	
}
