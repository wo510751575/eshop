package com.lj.business.cf.dto;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindTaskSchSpTypePage.
 */
public class FindTaskSchSpTypePage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9138475916786040621L; 
	

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 待办事项名称 .
     */
    private String taskName;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindTaskSchSpTypePage [merchantNo=").append(merchantNo)
				.append(", taskName=").append(taskName).append("]");
		return builder.toString();
	}

	

}
