package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindShopReturn.
 */
public class FindShopReturnAreaCode implements Serializable {

	 /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = -2113556965094685845L; 

    /**
     * 区域CODE .
     */
    private String areaCode;
    
    /**
     * 区域名称 .
     */
    private String areaName;

    /**
     * 分店编号 .
     */
    private String shopNo;
    
    /**
     * 分店名称
     */
    private String shopName;
    /**
     * 商户编号
     */
    private String memberNoMerchant;

	/**
     * 省code
     */
    private String provinceCode;
    
    public String getMemberNoMerchant() {
		return memberNoMerchant;
	}

	public void setMemberNoMerchant(String memberNoMerchant) {
		this.memberNoMerchant = memberNoMerchant;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
    
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	@Override
	public String toString() {
		return "FindShopReturnAreaCode [areaCode=" + areaCode + ", areaName="
				+ areaName + ", shopNo=" + shopNo + ", shopName=" + shopName
				+ ", memberNoMerchant=" + memberNoMerchant + ", provinceCode="
				+ provinceCode + "]";
	}
    
}
