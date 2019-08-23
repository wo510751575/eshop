package com.lj.business.cm.dto.activity;

import java.io.Serializable;

public class FindActivityDto implements Serializable{

	 /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = 5100265435749484121L;
	
    /**
     * 商户编号 .
     */
    private String merchantNo;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindActivityDto [merchantNo=").append(merchantNo)
				.append("]");
		return builder.toString();
	}
}
