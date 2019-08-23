package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ShopTaskSet.
 */
public class ToShopTaskSet implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4316903572405780716L;
	
	/**
     * CODE .(必填)
     */
    private String code;
    
    /**
     * 任务类型(必填)
             销售目标：XIAO_SHOU
             新增客户：XIN_ZENG
             其他任务：OTHER .
     */
    private String taskType;
    
	/**
	 * 任务开始时间 .(必填)
	 */
	private Date startDate;

	/**
	 * 任务结束时间 .(必填)
	 */
	private Date endDate;
	
	 /**
     * 商户编号 .(必填)
     */
    private String merchantNo;
    
    /** 分店编号(必填). */
    private String shopNo;
    
    
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

	/**
	 * Gets the task type.
	 *
	 * @return the task type
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * Sets the task type.
	 *
	 * @param taskType the new task type
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * @param merchantNo the new merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the shop no.
	 *
	 * @return the shop no
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the shop no.
	 *
	 * @param shopNo the new shop no
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ToShopTaskSet [code=").append(code)
				.append(", taskType=").append(taskType).append(", startDate=")
				.append(startDate).append(", endDate=").append(endDate)
				.append(", merchantNo=").append(merchantNo).append(", shopNo=")
				.append(shopNo).append("]");
		return builder.toString();
	}

}
