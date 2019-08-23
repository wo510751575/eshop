package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;
import java.util.Date;

import com.lj.base.core.util.EnumUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.business.cf.emus.ShopTaskType;
import com.lj.business.cf.emus.UnitType;

// TODO: Auto-generated Javadoc
/**
 * The Class FindShopTaskSetListReturn.
 */
public class FindShopTaskSetListReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6773454147482130817L;
	
	 /**
     * CODE .
     */
    private String code;
    
    /**
     * 任务开始时间 .
     */
    private Date startDate;

    /**
     * 任务结束时间 .
     */
    private Date endDate;
    
    /**
     * 任务名称 .
     */
    private String taskName;

    /**
     * 任务单位
             个：GE
             元：YUAN .
     */
    private String taskUnit;
    
    /** 任务单位名称. */
    private String taskUnitName;
    
    /**
     * 任务类型
             销售目标：XIAO_SHOU
             新增客户：XIN_ZENG
             其他任务：OTHER .
     */
    private String taskType;
    
    /** 任务类型名称. */
    private String taskTypeName;
    
    /**
     * 维度
             店长：SHOP
             商户：MERCHANT
              .
     */
    private String dimension;
    
    /**
     * 项目CODE .
     */
    private String codeList;
    
    /** 月数量. */
    private Long numMonth;
    
    /**
     * 当前月份
     */
    private int currentMonth;

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
		if(!StringUtils.isEmpty(taskType)){
			this.taskTypeName = EnumUtils.getValue(ShopTaskType.class, taskType);
		}
	}

	/**
	 * Gets the dimension.
	 *
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}

	/**
	 * Sets the dimension.
	 *
	 * @param dimension the new dimension
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

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
	 * Gets the num month.
	 *
	 * @return the num month
	 */
	public Long getNumMonth() {
		return numMonth;
	}

	/**
	 * Sets the num month.
	 *
	 * @param numMonth the new num month
	 */
	public void setNumMonth(Long numMonth) {
		this.numMonth = numMonth;
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

	/**
	 * Gets the task type name.
	 *
	 * @return the task type name
	 */
	public String getTaskTypeName() {
		return taskTypeName;
	}

	/**
	 * Sets the task type name.
	 *
	 * @param taskTypeName the new task type name
	 */
	public void setTaskTypeName(String taskTypeName) {
		this.taskTypeName = taskTypeName;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindShopTaskSetListReturn [code=").append(code)
				.append(", startDate=").append(startDate).append(", endDate=")
				.append(endDate).append(", taskName=").append(taskName)
				.append(", taskUnit=").append(taskUnit)
				.append(", taskUnitName=").append(taskUnitName)
				.append(", taskType=").append(taskType)
				.append(", taskTypeName=").append(taskTypeName)
				.append(", dimension=").append(dimension).append(", codeList=")
				.append(codeList).append(", numMonth=").append(numMonth)
				.append("]");
		return builder.toString();
	}

}
