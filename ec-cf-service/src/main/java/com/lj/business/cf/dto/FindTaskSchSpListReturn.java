package com.lj.business.cf.dto;

import java.io.Serializable;

/**
 * The Class FindTaskSchSpListReturn.
 */
public class FindTaskSchSpListReturn implements Serializable {

	  /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1726220453800218851L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 待办事项CODE .
     */
    private String tsstCode;

    /**
     * 待办事项名称 .
     */
    private String taskName;

    /**
     * 数量 .
     */
    private Integer num;

    /**
     * CODE .
     *
     * @return the cODE 
     */
    public String getCode() {
        return code;
    }

	/**
	 * Gets the 待办事项CODE .
	 *
	 * @return the 待办事项CODE 
	 */
	public String getTsstCode() {
		return tsstCode;
	}

	/**
	 * Sets the 待办事项CODE .
	 *
	 * @param tsstCode the new 待办事项CODE 
	 */
	public void setTsstCode(String tsstCode) {
		this.tsstCode = tsstCode;
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
	 * Gets the 数量 .
	 *
	 * @return the 数量 
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * Sets the 数量 .
	 *
	 * @param num the new 数量 
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindTaskSchSpListReturn [code=").append(code)
				.append(", tsstCode=").append(tsstCode).append(", taskName=")
				.append(taskName).append(", num=").append(num).append("]");
		return builder.toString();
	}
}
