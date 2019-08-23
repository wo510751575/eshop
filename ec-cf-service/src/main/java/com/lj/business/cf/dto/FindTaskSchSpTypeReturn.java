package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindTaskSchSpTypeReturn.
 */
public class FindTaskSchSpTypeReturn implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8204265033817594362L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 待办事项名称 .
     */
    private String taskName;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

	/**
	 * Gets the cODE .
	 *
	 * @return the cODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the new 商户编号 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 待办事项名称 .
	 *
	 * @return the 待办事项名称 
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the 待办事项名称 .
	 *
	 * @param taskName the new 待办事项名称 
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the 创建人 .
	 *
	 * @return the 创建人 
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the 创建人 .
	 *
	 * @param createId the new 创建人 
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the 创建时间 .
	 *
	 * @return the 创建时间 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate the new 创建时间 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindTaskSchSpTypeReturn [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", taskName=").append(taskName).append(", createId=")
				.append(createId).append("]");
		return builder.toString();
	}
}
