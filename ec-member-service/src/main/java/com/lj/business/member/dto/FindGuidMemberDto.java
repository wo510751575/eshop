package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindGuidMemberDto.
 */
public class FindGuidMemberDto implements Serializable{

	 /** Generate cron. */
	private static final long serialVersionUID = -3965488723564621235L;
    /**
     * CODE .
     */
    private String code;
    /**
     * 导购编号 .
     */
    private String memberNo;
    
    /** The shop no. */
    private String shopNo;
    
    /** The no wx. */
    private String noWx;
    
    /** 商户编号. */
    private String merchantNo;
    
    /** 区域code. */
    private String areaCode;

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

	/**
	 * Gets the cODE .
	 *
	 * @return the cODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 导购编号 .
	 *
	 * @return the 导购编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNo the new 导购编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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
	 * @param shopNo the shop no
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the no wx.
	 *
	 * @return the no wx
	 */
	public String getNoWx() {
		return noWx;
	}

	/**
	 * Sets the no wx.
	 *
	 * @param noWx the no wx
	 */
	public void setNoWx(String noWx) {
		this.noWx = noWx;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindGuidMemberDto [code=").append(code)
				.append(", memberNo=").append(memberNo).append(", shopNo=")
				.append(shopNo).append(", noWx=").append(noWx)
				.append(", merchantNo=").append(merchantNo).append("]");
		return builder.toString();
	}
}
