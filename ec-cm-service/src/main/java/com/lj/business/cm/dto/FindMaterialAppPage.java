package com.lj.business.cm.dto;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindMaterialAppPage.
 */
public class FindMaterialAppPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3924490271643719116L;
	
    
    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 导购编号  .
     */
    private String memberNoGm;

    /**
     * 类型CODE .
     */
    private String materialTypeCode;

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the new 商户编号 
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
	 * Gets the 类型CODE .
	 *
	 * @return the 类型CODE 
	 */
	public String getMaterialTypeCode() {
		return materialTypeCode;
	}

	/**
	 * Sets the 类型CODE .
	 *
	 * @param materialTypeCode the new 类型CODE 
	 */
	public void setMaterialTypeCode(String materialTypeCode) {
		this.materialTypeCode = materialTypeCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMaterialAppPage [merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", materialTypeCode=").append(materialTypeCode)
				.append("]");
		return builder.toString();
	}

    
    
}
