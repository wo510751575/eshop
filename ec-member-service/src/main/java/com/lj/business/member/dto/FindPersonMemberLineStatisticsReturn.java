package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindPersonMemberReturn.
 */
public class FindPersonMemberLineStatisticsReturn implements Serializable {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8812969072108321896L;

	/**
	 * 职业数
	 */
	private Integer numLine;

	/**
	 * 商户编号
	 */
	private String merchantNo;

	/**
	 * 分店编号
	 */
	private String shopNo;

	/**
	 * 职业编号
	 */
	private String codeLine;

	/**
	 * 职业名字
	 */
	private String lineName;

	/**
	 * 区域编码
	 */
	private String areaCode;

	/**
	 * 商户名字
	 */
	private String shopName;

	public Integer getNumLine() {
		return numLine;
	}

	public void setNumLine(Integer numLine) {
		this.numLine = numLine;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getCodeLine() {
		return codeLine;
	}

	public void setCodeLine(String codeLine) {
		this.codeLine = codeLine;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}
