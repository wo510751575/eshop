package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindShopDetail.
 */
public class FindShopDetail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -280978281592739009L;
	
	
	  /**
     * 商户编号(必填) .
     */
    private String merchantNo;
    

	/**
     * 分店编号(必填) .
     */
    private String shopNo;


	/**
	 * Gets the 商户编号(必填) .
	 *
	 * @return the 商户编号(必填) 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}


	/**
	 * Sets the 商户编号(必填) .
	 *
	 * @param merchantNo the new 商户编号(必填) 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}


	/**
	 * Gets the 分店编号(必填) .
	 *
	 * @return the 分店编号(必填) 
	 */
	public String getShopNo() {
		return shopNo;
	}


	/**
	 * Sets the 分店编号(必填) .
	 *
	 * @param shopNo the new 分店编号(必填) 
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindShopDetail [merchantNo=").append(merchantNo)
				.append(", shopNo=").append(shopNo).append("]");
		return builder.toString();
	}
    

}
