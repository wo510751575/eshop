package com.lj.business.cm.dto.textInfo;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindTextInfo.
 */
public class FindTextInfo implements Serializable { 

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3298645228283959567L;
	/**
     * CODE .
     */
    private String code;
     
     /** 数量. */
    private Integer count;
    
    /** 商户编号. */
    private String merchantNo;
    
    /** 类型. */
    private String textType;
    
   
	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the count
	 */
	public void setCount(Integer count) {
		this.count = count;
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
	 * @param merchantNo the merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the text type.
	 *
	 * @return the text type
	 */
	public String getTextType() {
		return textType;
	}

	/**
	 * Sets the text type.
	 *
	 * @param textType the text type
	 */
	public void setTextType(String textType) {
		this.textType = textType;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindTextInfo [code=" + code + ", count=" + count
				+ ", merchantNo=" + merchantNo + ", textType=" + textType + "]";
	}
    
}
