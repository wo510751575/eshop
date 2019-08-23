package com.lj.business.cf.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindComTaskChooseByCode.
 */
public class FindComTaskChooseByCode implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2309092584290522847L;

	/** 商户号. */
	  private String merchantNo;
	  
	  /** 任务类型code. */
	  private String code;

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
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskChooseByCode [merchantNo=")
				.append(merchantNo).append(", code=").append(code).append("]");
		return builder.toString();
	}
	  
}
