package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindShopDetail.
 */
public class FindShopDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -280978281592739009L;
	
	
   /** 商户编号. */
    private String memberNoMerchant;

	/**
     * 分店编号(必填) .
     */
    private String shopNo;
    
    /** 区域编号. */
    private String  areaCode;
    
    /** 区域名称. */
    private String  areaName;
    
    /** 省code. */
    private String provinceCode;
    
	/**
	 * Gets the area code.
	 *
	 * @return the area code
	 */
	public String getAreaCode() {
		return areaCode;
	}


	/**
	 * Sets the area code.
	 *
	 * @param areaCode the area code
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


	public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	/**
	 * Gets the province code.
	 *
	 * @return the province code
	 */
	public String getProvinceCode() {
		return provinceCode;
	}


	/**
	 * Sets the province code.
	 *
	 * @param provinceCode the province code
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}


	/**
	 * Gets the shop no.
	 *
	 * @return the shop no
	 */
	public String getShopNo() {
		return shopNo;
	}


	/**
	 * Gets the member no merchant.
	 *
	 * @return the member no merchant
	 */
	public String getMemberNoMerchant() {
		return memberNoMerchant;
	}


	/**
	 * Sets the member no merchant.
	 *
	 * @param memberNoMerchant the member no merchant
	 */
	public void setMemberNoMerchant(String memberNoMerchant) {
		this.memberNoMerchant = memberNoMerchant;
	}


	/**
	 * Sets the 分店编号(必填) .
	 *
	 * @param shopNo the new 分店编号(必填) 
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}


	@Override
	public String toString() {
		return "FindShopDto [memberNoMerchant=" + memberNoMerchant
				+ ", shopNo=" + shopNo + ", areaCode=" + areaCode
				+ ", areaName=" + areaName + ", provinceCode=" + provinceCode
				+ "]";
	}
    

}
