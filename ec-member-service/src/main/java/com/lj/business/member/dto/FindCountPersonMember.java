package com.lj.business.member.dto;

import java.io.Serializable;

public class FindCountPersonMember implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3894839629233338791L;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 开始时间
	 */
	private String startTime;
	
	/**
	 * 结束时间
	 */
	private String endTime;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "FindCountPersonMember [merchantNo=" + merchantNo
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
