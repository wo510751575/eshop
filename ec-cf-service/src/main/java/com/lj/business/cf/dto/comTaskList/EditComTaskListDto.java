package com.lj.business.cf.dto.comTaskList;

import com.lj.base.core.pagination.PageParamEntity;


/**
 * The Class EditComTaskListDto.
 */
public class EditComTaskListDto extends PageParamEntity{

	 /** Generate cron. */
	private static final long serialVersionUID = 4647797092333571983L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 项目名称 .
     */
    private String nameList;

    /**
     * 项目描述 .
     */
    private String desList;
    
    /**
     * 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
     */
    private String comTaskType;

    /**
     * 状态 
             启用：Y
             停用：N
              .
     */
    private String status;

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
     * 项目名称 .
     *
     * @return the name list
     */
    public String getNameList() {
        return nameList;
    }

    /**
     * 项目名称 .
     *
     * @param nameList the new name list
     */
    public void setNameList(String nameList) {
        this.nameList = nameList == null ? null : nameList.trim();
    }

    /**
     * 项目描述 .
     *
     * @return the des list
     */
    public String getDesList() {
        return desList;
    }

    /**
     * 项目描述 .
     *
     * @param desList the new des list
     */
    public void setDesList(String desList) {
        this.desList = desList == null ? null : desList.trim();
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EditComTaskListDto [code=").append(code)
				.append(", nameList=").append(nameList).append(", desList=")
				.append(desList).append(", comTaskType=").append(comTaskType)
				.append(", status=").append(status).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
	 *
	 * @return the 沟通任务类型 完善资料：IMPROVE 其他：OTHER 
	 */
	public String getComTaskType() {
		return comTaskType;
	}

	/**
	 * Sets the 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
	 *
	 * @param comTaskType the new 沟通任务类型 完善资料：IMPROVE 其他：OTHER 
	 */
	public void setComTaskType(String comTaskType) {
		this.comTaskType = comTaskType;
	}

}
