package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindManagersDto.
 */
public class FindManagersDto implements Serializable{

	 /** Generate cron. */
	private static final long serialVersionUID = 3136159061259078077L;
	
	   /**
     * 商家编号(必填) .
     */
    private String merchantNo;
    
    /**
     * 分店编号(必填) .
     */
    private String memberNoShop;
	
	
	/**
	 * Gets the 分店编号 .
	 *
	 * @return the 分店编号 
	 */
	public String getMemberNoShop() {
		return memberNoShop;
	}
	
	/**
	 * Sets the 分店编号 .
	 *
	 * @param memberNoShop the new 分店编号 
	 */
	public void setMemberNoShop(String memberNoShop) {
		this.memberNoShop = memberNoShop;
	}
	
	/**
	 * Gets the 商家编号 .
	 *
	 * @return the 商家编号 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}
	
	/**
	 * Sets the 商家编号 .
	 *
	 * @param merchantNo the new 商家编号 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindManagersDto [merchantNo=").append(merchantNo)
				.append(", memberNoShop=").append(memberNoShop).append("]");
		return builder.toString();
	}
    
}
