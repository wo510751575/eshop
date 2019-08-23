package com.lj.business.cm.dto.textInfo;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindTextInfoPage.
 */
public class FindTextInfoPage extends PageParamEntity { 

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1569483223975808821L;
	/**
     * 商户编号 .
     */
    private String merchantNo;
    
    /**
     * 话术类型
     */
    private String textType;
    
    
    
    
    
	public String getTextType() {
		return textType;
	}

	public void setTextType(String textType) {
		this.textType = textType;
	}

	/**
	 * Gets the 商户编号 .


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

	@Override
	public String toString() {
		return "FindTextInfoPage [merchantNo=" + merchantNo + ", textType="
				+ textType + "]";
	}
    
}
