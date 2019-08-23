package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class ChangePmTypeApp.
 */
public class ChangePmTypeApp implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6563179811947849893L;

	  /**
     * 客户客户分类关联表CODE（必填） .
     */
    private String code;


    /**
     * 客户分类CODE（必填） .
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
	 * Gets the 客户客户分类关联表CODE（必填） .
	 *
	 * @return the 客户客户分类关联表CODE（必填） 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the 客户客户分类关联表CODE（必填） .
	 *
	 * @param code the new 客户客户分类关联表CODE（必填） 
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * Gets the 客户分类CODE .
	 *
	 * @return the 客户分类CODE 
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}


	/**
	 * Sets the 客户分类CODE .
	 *
	 * @param pmTypeCode the new 客户分类CODE 
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
		builder.append("ChangePmTypeApp [code=").append(code)
				.append(", pmTypeCode=").append(pmTypeCode)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNo=").append(memberNo).append(", merchantNo=")
				.append(merchantNo).append("]");
		return builder.toString();
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

	
}
