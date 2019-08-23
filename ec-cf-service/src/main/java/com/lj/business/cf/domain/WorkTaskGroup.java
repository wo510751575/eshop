package com.lj.business.cf.domain;

import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * The Class WorkTaskGroup.
 */
/**
 * 
 * 
 * 类说明：工作事项分组表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 */
public class WorkTaskGroup {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号  .
     */
    private String merchantNo;

    /**
     * 工作事项CODE .
     */
    private String wtlCode;

    /**
     * 任务名称 .
     */
    private String taskName;

    /**
     * 分组名称 .
     */
    private String groupName;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

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
     * 商户编号  .
     *
     * @return the merchant no
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号  .
     *
     * @param merchantNo the new merchant no
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 工作事项CODE .
     *
     * @return the wtl code
     */
    public String getWtlCode() {
        return wtlCode;
    }

    /**
     * 工作事项CODE .
     *
     * @param wtlCode the new wtl code
     */
    public void setWtlCode(String wtlCode) {
        this.wtlCode = wtlCode == null ? null : wtlCode.trim();
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
     * 分组名称 .
     *
     * @return the group name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 分组名称 .
     *
     * @param groupName the new group name
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkTaskGroup [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", wtlCode=").append(wtlCode).append(", taskName=")
				.append(taskName).append(", groupName=").append(groupName)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append("]");
		return builder.toString();
	}

}