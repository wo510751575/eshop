package com.lj.business.cf.dto.otherTaskFinishInfo;

import java.io.Serializable;

/**
 * The Class FindOtherTaskReturn.
 */
public class FindOtherTaskReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2677024850573057524L;
	
	/**
     * 其他任务完成情况表CODE .
     */
    private String code;

    /**
     * 月数量 .
     */
    private Long numMonth;

    /**
     * 日均数量 .
     */
    private Long numDay;

    /**
     * 完成数量 .
     */
    private Long numFinish;

    
    /**  任务名称. */
    private String taskName;


	/**
	 * Gets the 其他任务完成情况表CODE .
	 *
	 * @return the 其他任务完成情况表CODE 
	 */
	public String getCode() {
		return code;
	}


	/**
	 * Sets the 其他任务完成情况表CODE .
	 *
	 * @param code the new 其他任务完成情况表CODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * Gets the 月数量 .
	 *
	 * @return the 月数量 
	 */
	public Long getNumMonth() {
		return numMonth;
	}


	/**
	 * Sets the 月数量 .
	 *
	 * @param numMonth the new 月数量 
	 */
	public void setNumMonth(Long numMonth) {
		this.numMonth = numMonth;
	}


	/**
	 * Gets the 日均数量 .
	 *
	 * @return the 日均数量 
	 */
	public Long getNumDay() {
		return numDay;
	}


	/**
	 * Sets the 日均数量 .
	 *
	 * @param numDay the new 日均数量 
	 */
	public void setNumDay(Long numDay) {
		this.numDay = numDay;
	}


	/**
	 * Gets the 完成数量 .
	 *
	 * @return the 完成数量 
	 */
	public Long getNumFinish() {
		return numFinish;
	}


	/**
	 * Sets the 完成数量 .
	 *
	 * @param numFinish the new 完成数量 
	 */
	public void setNumFinish(Long numFinish) {
		this.numFinish = numFinish;
	}


	/**
	 * Gets the 任务名称.
	 *
	 * @return the 任务名称
	 */
	public String getTaskName() {
		return taskName;
	}


	/**
	 * Sets the 任务名称.
	 *
	 * @param taskName the new 任务名称
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
		builder.append("FindOtherTaskReturn [code=").append(code)
				.append(", numMonth=").append(numMonth).append(", numDay=")
				.append(numDay).append(", numFinish=").append(numFinish)
				.append(", taskName=").append(taskName).append("]");
		return builder.toString();
	}
	

}
