package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindPersonMemberReturn.
 */
public class FindPersonMemberInterestStatisticsReturn implements Serializable {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8812969072108321896L;

	/**
	 * 兴趣数
	 */
	private Integer numInterest;

	/**
	 * 商户编号
	 */
	private String merchantNo;

	/**
	 * 分店编号
	 */
	private String shopNo;

	/**
	 * 兴趣编号
	 */
	private String codeInterest;

	/**
	 * 兴趣名字
	 */
	private String interestName;

	/**
	 * 区域编码
	 */
	private String areaCode;

	/**
	 * 商户名字
	 */
	private String shopName;

	public Integer getNumInterest() {
		return numInterest;
	}

	public void setNumInterest(Integer numInterest) {
		this.numInterest = numInterest;
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

	public String getCodeInterest() {
		return codeInterest;
	}

	public void setCodeInterest(String codeInterest) {
		this.codeInterest = codeInterest;
	}

	public String getInterestName() {
		return interestName;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
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
