package com.lj.business.cf.dto.workTaskList;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class AddWorkTaskList.
 */
public class AddWorkTaskList implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8608805900988437878L;
    /**
     * CODE .
     */
    private String code;

    /**
     * 任务名称 .
     */
    private String taskName;

    /**
     * 任务描述 .
     */
    private String taskDesc;

    /**
     * 任务类型
             主要工作：MAIN
             其他工作：OTHER .
     */
    private String taskType;

    /**
     * 状态 
             启用：Y
             停用：N
              .
     */
    private String status;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;
    
    /** 任务单位. */
    private String taskUnit;

    /**
     * CODE .
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 任务名称 .
     *
     * @return the task name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 任务名称 .
     *
     * @param taskName the new task name
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 任务描述 .
     *
     * @return the task desc
     */
    public String getTaskDesc() {
        return taskDesc;
    }

    /**
     * 任务描述 .
     *
     * @param taskDesc the new task desc
     */
    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc == null ? null : taskDesc.trim();
    }

    /**
     * 任务类型
     *              主要工作：MAIN
     *              其他工作：OTHER .
     *
     * @return the task type
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * 任务类型
     *              主要工作：MAIN
     *              其他工作：OTHER .
     *
     * @param taskType the new task type
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    /**
     * 状态 
     *              启用：Y
     *              停用：N
     *               .
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 
     *              启用：Y
     *              停用：N
     *               .
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 创建人 .
     *
     * @return the creates the id
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new creates the id
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the creates the date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new creates the date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddWorkTaskList [code=").append(code)
				.append(", taskName=").append(taskName).append(", taskDesc=")
				.append(taskDesc).append(", taskType=").append(taskType)
				.append(", status=").append(status).append(", createId=")
				.append(createId).append(", createDate=").append(createDate)
				.append(", taskUnit=").append(taskUnit).append("]");
		return builder.toString();
	}

}
