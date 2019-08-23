package com.lj.business.member.dto;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindPmSeachPage.
 */
public class FindPmSeachPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8273481863869779167L;
	
	
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
     * 查询KEY .
     */
    private String searchKey;


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
	 * Gets the 导购编号(必填,分店编号,导购编号 2选1 )  .
	 *
	 * @return the 导购编号(必填,分店编号,导购编号 2选1 )  
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号(必填,分店编号,导购编号 2选1 )  .
	 *
	 * @param memberNoGm the new 导购编号(必填,分店编号,导购编号 2选1 )  
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 分店编号(必填，分店编号,导购编号 2选1) .
	 *
	 * @return the 分店编号(必填，分店编号,导购编号 2选1) 
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号(必填，分店编号,导购编号 2选1) .
	 *
	 * @param shopNo the new 分店编号(必填，分店编号,导购编号 2选1) 
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
		builder.append("FindPmSeachPage [merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm).append(", shopNo=")
				.append(shopNo).append(", searchKey=").append(searchKey)
				.append("]");
		return builder.toString();
	}

	/**
	 * Gets the 查询KEY .
	 *
	 * @return the 查询KEY 
	 */
	public String getSearchKey() {
		return searchKey;
	}

	/**
	 * Sets the 查询KEY .
	 *
	 * @param searchKey the new 查询KEY 
	 */
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
    
    

}
