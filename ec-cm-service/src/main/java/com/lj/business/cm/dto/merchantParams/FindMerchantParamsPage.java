package com.lj.business.cm.dto.merchantParams;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindMerchantParamsPage.
 */
public class FindMerchantParamsPage extends PageParamEntity { 

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2737888558653360864L;
	/**
     * 商户编号 .
     */
    private String merchantNo;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMerchantParamsPage [merchantNo=")
				.append(merchantNo).append("]");
		return builder.toString();
	}
    
}
