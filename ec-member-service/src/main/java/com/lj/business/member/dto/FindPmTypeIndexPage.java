package com.lj.business.member.dto;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindPmTypeIndexPage.
 */
public class FindPmTypeIndexPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5344189114540064352L;
	
	

	 /**
     * 商户编号(必填) .
     */
    private String merchantNo;
    
    /**
     * 导购编号(必填,分店编号,导购编号 2选1 )  .
     */
    private String memberNoGm;
    
    /**
     * 分店编号(必填，分店编号,导购编号 2选1) .
     */
    private String shopNo;
    
    /**
     * 客户分类CODE(必填) .
     */
    private String pmTypeCode;
    
    

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
	 * Gets the 导购编号  .
	 *
	 * @return the 导购编号  
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号  .
	 *
	 * @param memberNoGm the new 导购编号  
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
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

	/**
	 * Gets the 客户分类CODE(必填) .
	 *
	 * @return the 客户分类CODE(必填) 
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}

	/**
	 * Sets the 客户分类CODE(必填) .
	 *
	 * @param pmTypeCode the new 客户分类CODE(必填) 
	 */
	public void setPmTypeCode(String pmTypeCode) {
		this.pmTypeCode = pmTypeCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmTypeIndexPage [merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm).append(", shopNo=")
				.append(shopNo).append(", pmTypeCode=").append(pmTypeCode)
				.append("]");
		return builder.toString();
	}



}
