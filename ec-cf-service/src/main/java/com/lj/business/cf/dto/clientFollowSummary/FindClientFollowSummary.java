package com.lj.business.cf.dto.clientFollowSummary;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */

import java.io.Serializable;

/**
 * The Class FindClientFollowSummary.
 */
public class FindClientFollowSummary implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 721644291634634543L;
	
	/** The code. */
	private String code;
	
	 /**
     * 商户号  .
     */
    private String merchantNo;

    /**
     * 会员号  .
     */
    private String memberNo;

    /**
     * 导购编号 .
     */
    private String memberNoGm;
    
    /**
     * 跟进编号
     */
    private String cfNo;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 商户号  .
	 *
	 * @return the 商户号  
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户号  .
	 *
	 * @param merchantNo the new 商户号  
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 会员号  .
	 *
	 * @return the 会员号  
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param memberNo the new 会员号  
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 导购编号 .
	 *
	 * @return the 导购编号 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNoGm the new 导购编号 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}
	
	public String getCfNo() {
		return cfNo;
	}

	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindClientFollowSummary [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNo=").append(memberNo).append(", memberNoGm=")
				.append(memberNoGm).append(", cfNo=").append(cfNo).append("]");
		return builder.toString();
	}

}
