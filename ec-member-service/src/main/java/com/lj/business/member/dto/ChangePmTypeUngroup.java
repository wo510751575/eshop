package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class ChangePmTypeUngroup.
 */
public class ChangePmTypeUngroup implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4475426248063687819L;
	
	

    /**
     * 客户分类目标CODE（必填） .
     */
    private String pmTypeCode;
    
    /**
     * 导购编号(必填 ) .
     */
    private String memberNoGm;
    
    /**
     * 客户编号(必填 ) .
     */
    private String memberNo;
    
    /**
     * 商户编号(必填) .
     */
    private String merchantNo;

    /**
     * 门店编号
     */
    private String shopNo;
    
	/**
	 * Gets the 客户分类目标CODE（必填） .
	 *
	 * @return the 客户分类目标CODE（必填） 
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}

	/**
	 * Sets the 客户分类目标CODE（必填） .
	 *
	 * @param pmTypeCode the new 客户分类目标CODE（必填） 
	 */
	public void setPmTypeCode(String pmTypeCode) {
		this.pmTypeCode = pmTypeCode;
	}

	/**
	 * Gets the 导购编号(必填 ) .
	 *
	 * @return the 导购编号(必填 ) 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号(必填 ) .
	 *
	 * @param memberNoGm the new 导购编号(必填 ) 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 客户编号(必填 ) .
	 *
	 * @return the 客户编号(必填 ) 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 客户编号(必填 ) .
	 *
	 * @param memberNo the new 客户编号(必填 ) 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

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
	
	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChangePmTypeUngroup [pmTypeCode=").append(pmTypeCode)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", shopNo=").append(shopNo)
				.append(", memberNo=").append(memberNo).append(", merchantNo=")
				.append(merchantNo).append("]");
		return builder.toString();
	}
    
    
	

}
