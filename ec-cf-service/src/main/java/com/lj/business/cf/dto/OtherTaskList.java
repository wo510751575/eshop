package com.lj.business.cf.dto;

import java.io.Serializable;

import com.lj.base.core.util.EnumUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.business.cf.emus.UnitType;

// TODO: Auto-generated Javadoc
/**
 * The Class OtherTaskList.
 */
public class OtherTaskList implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2016225630510435282L;
	
	/** code. */
	private String code;
	
	/** 任务名称. */
	private String taskName;
	
	/** 日均数量. */
	private Long numDay;

	/** 完成数量. */
	private Long numFinish;
	
	/** 单位. */
	private String taskUnit;
	
	/** 单位名称. */
	private String taskUnitName;

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
	 * Gets the task name.
	 *
	 * @return the task name
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the task name.
	 *
	 * @param taskName the new task name
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the num day.
	 *
	 * @return the num day
	 */
	public Long getNumDay() {
		return numDay;
	}

	/**
	 * Sets the num day.
	 *
	 * @param numDay the new num day
	 */
	public void setNumDay(Long numDay) {
		this.numDay = numDay;
	}

	/**
	 * Gets the num finish.
	 *
	 * @return the num finish
	 */
	public Long getNumFinish() {
		return numFinish;
	}

	/**
	 * Sets the num finish.
	 *
	 * @param numFinish the new num finish
	 */
	public void setNumFinish(Long numFinish) {
		this.numFinish = numFinish;
	}

	/**
	 * Gets the task unit.
	 *
	 * @return the task unit
	 */
	public String getTaskUnit() {
		return taskUnit;
	}

	/**
	 * Sets the task unit.
	 *
	 * @param taskUnit the new task unit
	 */
	public void setTaskUnit(String taskUnit) {
		this.taskUnit = taskUnit;
		if(!StringUtils.isEmpty(taskUnit)){
			this.taskUnitName = EnumUtils.getValue(UnitType.class, taskUnit);
		}
	}

	/**
	 * Gets the task unit name.
	 *
	 * @return the task unit name
	 */
	public String getTaskUnitName() {
		return taskUnitName;
	}

	/**
	 * Sets the task unit name.
	 *
	 * @param taskUnitName the new task unit name
	 */
	public void setTaskUnitName(String taskUnitName) {
		this.taskUnitName = taskUnitName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OtherTaskList [code=").append(code)
				.append(", taskName=").append(taskName).append(", numDay=")
				.append(numDay).append(", numFinish=").append(numFinish)
				.append(", taskUnit=").append(taskUnit)
				.append(", taskUnitName=").append(taskUnitName).append("]");
		return builder.toString();
	}
	
	
}
