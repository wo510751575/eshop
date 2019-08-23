package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindGuidmemberActionInfoListDto.
 */
public class FindGuidmemberActionInfoListDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9104926362173560207L;
	
	/** 商户号. */
	private String merchantNo;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindGuidmemberActionInfoListDto [merchantNo=")
				.append(merchantNo).append("]");
		return builder.toString();
	}
	
}
