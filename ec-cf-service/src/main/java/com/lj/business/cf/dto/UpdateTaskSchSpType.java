package com.lj.business.cf.dto;

import java.io.Serializable;

/**
 * The Class UpdateTaskSchSpType.
 */
public class UpdateTaskSchSpType implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -270868300891158930L;


	/**
     * CODE .
     */
    private String code;


    /**
     * 待办事项名称 .
     */
    private String taskName;


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
		builder.append("UpdateTaskSchSpType [code=").append(code)
				.append(", taskName=").append(taskName).append("]");
		return builder.toString();
	}
    

}
