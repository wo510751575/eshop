package com.lj.business.member.dto;

import java.io.Serializable;


public class FindAgreementMerchantReturnDto implements Serializable{


     /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = -909221484383202826L;

	/**
     * 会员号  .
     */
    private String merchantNo;

    /**
     * 服务协议 .
     */
    private String agreement;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindAgreementMerchantReturnDto [merchantNo=")
				.append(merchantNo).append(", agreement=").append(agreement)
				.append("]");
		return builder.toString();
	}
}
