package com.lj.business.member.dto;

import java.io.Serializable;


/**
 * The Class FindMerchantReturn.
 */
public class FindMerchantReturnDto implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2491970527948535892L;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 商户名称 .
     */
    private String merchantName;

    /**
     * LOGO图片 .
     */
    private String logoAddr;

    /**
     * 官方网站 .
     */
    private String websiteUrl;

    /**
     * 联系电话 .
     */
    private String telephone;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getLogoAddr() {
		return logoAddr;
	}

	public void setLogoAddr(String logoAddr) {
		this.logoAddr = logoAddr;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMerchantReturn [merchantNo=").append(merchantNo)
				.append(", merchantName=").append(merchantName)
				.append(", logoAddr=").append(logoAddr).append(", websiteUrl=")
				.append(websiteUrl).append(", telephone=").append(telephone)
				.append("]");
		return builder.toString();
	}
}
