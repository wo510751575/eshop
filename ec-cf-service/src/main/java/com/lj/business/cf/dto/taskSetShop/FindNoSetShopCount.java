package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindNoSetShopCount.
 */
public class FindNoSetShopCount implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6675640804057339731L;
    
    /**
     * 店长编号（必填） .
     */
    private String memberNoShop;
    
    /** 商户号.（必填） */
    private String merchantNo;
    
    /** 当天. */
    private Date now;
    
    private String shopNo;

	/**
	 * Gets the member no shop.
	 *
	 * @return the member no shop
	 */
	public String getMemberNoShop() {
		return memberNoShop;
	}

	/**
	 * Sets the member no shop.
	 *
	 * @param memberNoShop the new member no shop
	 */
	public void setMemberNoShop(String memberNoShop) {
		this.memberNoShop = memberNoShop;
	}

	/**
	 * Gets the merchant no.
	 *
	 * @return the merchant no
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the merchant no.
	 *
	 * @param merchantNo the new merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	
	/**
	 * Gets the now.
	 *
	 * @return the now
	 */
	public Date getNow() {
		return now;
	}

	/**
	 * Sets the now.
	 *
	 * @param now the new now
	 */
	public void setNow(Date now) {
		this.now = now;
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
		builder.append("FindNoSetShopCount [memberNoShop=")
				.append(memberNoShop).append(", merchantNo=")
				.append(merchantNo).append(", now=").append(now)
				.append(", shopNo=").append(shopNo).append("]");
		return builder.toString();
	}

}
