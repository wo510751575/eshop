package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.cf.emus.ShopTaskType;

// TODO: Auto-generated Javadoc
/**
 * The Class FindWorkTaskMainList.
 */
public class FindWorkTaskMainList implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2258857967095123421L;

    /**
     * 工作日期（必填） .
     */
    private Date workDate;

    /**
     * 导购编号（必填） .
     */
    private String memberNoGm;
    
    /**
     * 任务类型（必填） .
     */
    private ShopTaskType taskType;
    
    /**
     * 商户编号(必填) .
     */
    private String merchantNo;

	/**
	 * Gets the 工作日期（必填） .
	 *
	 * @return the 工作日期（必填） 
	 */
	public Date getWorkDate() {
		return workDate;
	}

	/**
	 * Sets the 工作日期（必填） .
	 *
	 * @param workDate the new 工作日期（必填） 
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	/**
	 * Gets the 导购编号（必填） .
	 *
	 * @return the 导购编号（必填） 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号（必填） .
	 *
	 * @param memberNoGm the new 导购编号（必填） 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the task type.
	 *
	 * @return the task type
	 */
	public ShopTaskType getTaskType() {
		return taskType;
	}

	/**
	 * Sets the task type.
	 *
	 * @param taskType the new task type
	 */
	public void setTaskType(ShopTaskType taskType) {
		this.taskType = taskType;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindWorkTaskMainList [workDate=").append(workDate)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", taskType=").append(taskType).append(", merchantNo=")
				.append(merchantNo).append("]");
		return builder.toString();
	}

}
