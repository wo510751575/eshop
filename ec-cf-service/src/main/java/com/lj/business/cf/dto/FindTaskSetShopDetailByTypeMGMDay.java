package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

public class FindTaskSetShopDetailByTypeMGMDay implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7958614748569661945L;
	
	 /**
     * 商户编号 .
     */
    private String merchantNo;
    
    /** 当前时间. */
    private Date now;
    
    /**
     * 店长编号
     */
    //private String memberNoSp;
    private String shopNo;
    
    /**
     * 任务类型
     */
    private String taskType;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public Date getNow() {
		return now;
	}

	public void setNow(Date now) {
		this.now = now;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindTaskSetShopDetailByTypeMGMDay [merchantNo=")
				.append(merchantNo).append(", now=").append(now)
				.append(", shopNo=").append(shopNo).append(", taskType=")
				.append(taskType).append("]");
		return builder.toString();
	}

}
