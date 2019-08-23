package com.lj.business.cf.dto;

import java.io.Serializable;

import com.lj.base.core.util.EnumUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.business.cf.emus.UnitType;

// TODO: Auto-generated Javadoc
/**
 * The Class UnfinishTaskList.
 */
public class UnfinishTaskList implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -268160772588099030L;
	
	/** 项目code. */
	private String codeList;
	
	/** 项目名称. */
	private String nameList;
	
	/** 数量. */
	private Long errorNum;
	
	/** 单位. */
	private String taskUnit;
	
	/** 单位名称. */
	private String taskUnitName;

	/**
	 * Gets the code list.
	 *
	 * @return the code list
	 */
	public String getCodeList() {
		return codeList;
	}

	/**
	 * Sets the code list.
	 *
	 * @param codeList the new code list
	 */
	public void setCodeList(String codeList) {
		this.codeList = codeList;
	}

	/**
	 * Gets the name list.
	 *
	 * @return the name list
	 */
	public String getNameList() {
		return nameList;
	}

	/**
	 * Sets the name list.
	 *
	 * @param nameList the new name list
	 */
	public void setNameList(String nameList) {
		this.nameList = nameList;
	}

	/**
	 * Gets the error num.
	 *
	 * @return the error num
	 */
	public Long getErrorNum() {
		return errorNum;
	}

	/**
	 * Sets the error num.
	 *
	 * @param errorNum the new error num
	 */
	public void setErrorNum(Long errorNum) {
		this.errorNum = errorNum;
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
		if(!StringUtils.isEmpty(this.taskUnit)){
			this.taskUnitName = EnumUtils.getValue(UnitType.class, this.taskUnit);
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
		builder.append("UnfinishTaskList [codeList=").append(codeList)
				.append(", nameList=").append(nameList).append(", errorNum=")
				.append(errorNum).append(", taskUnit=").append(taskUnit)
				.append(", taskUnitName=").append(taskUnitName).append("]");
		return builder.toString();
	}
	
}
