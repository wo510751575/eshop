package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindShopTaskSetList.
 */
public class FindShopTaskSetList implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7982254775402893403L;
	
	
	 /**
     * 商户编号 .
     */
    private String merchantNo;
    
    /**
     * 店长编号 .
     */
    private String memberNoSp;
    
    /** 分店编号. */
    private String shopNo;

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
	 * Gets the member no sp.
	 *
	 * @return the member no sp
	 */
	public String getMemberNoSp() {
		return memberNoSp;
	}

	/**
	 * Sets the member no sp.
	 *
	 * @param memberNoSp the new member no sp
	 */
	public void setMemberNoSp(String memberNoSp) {
		this.memberNoSp = memberNoSp;
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
	 * Sets the shop no.
	 *
	 * @param shopNo the new shop no
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
		builder.append("FindShopTaskSetList [merchantNo=").append(merchantNo)
				.append(", memberNoSp=").append(memberNoSp).append(", shopNo=")
				.append(shopNo).append("]");
		return builder.toString();
	}

}
