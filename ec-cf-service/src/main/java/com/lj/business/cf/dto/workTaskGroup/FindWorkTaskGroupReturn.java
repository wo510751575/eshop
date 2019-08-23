package com.lj.business.cf.dto.workTaskGroup;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindWorkTaskGroupReturn.
 */
public class FindWorkTaskGroupReturn implements Serializable { 

     /** Generate cron. */
	private static final long serialVersionUID = 5453070506300007255L;

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
	 * Gets the 商户编号  .
	 *
	 * @return the 商户编号  
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号  .
	 *
	 * @param merchantNo the new 商户编号  
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 工作事项CODE .
	 *
	 * @return the 工作事项CODE 
	 */
	public String getWtlCode() {
		return wtlCode;
	}

	/**
	 * Sets the 工作事项CODE .
	 *
	 * @param wtlCode the new 工作事项CODE 
	 */
	public void setWtlCode(String wtlCode) {
		this.wtlCode = wtlCode;
	}

	/**
	 * Gets the 任务名称 .
	 *
	 * @return the 任务名称 
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the 任务名称 .
	 *
	 * @param taskName the new 任务名称 
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the 分组名称 .
	 *
	 * @return the 分组名称 
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Sets the 分组名称 .
	 *
	 * @param groupName the new 分组名称 
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * Gets the 创建人 .
	 *
	 * @return the 创建人 
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the 创建人 .
	 *
	 * @param createId the new 创建人 
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the 创建时间 .
	 *
	 * @return the 创建时间 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate the new 创建时间 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindWorkTaskGroupReturn [code=" + code + ", merchantNo="
				+ merchantNo + ", wtlCode=" + wtlCode + ", taskName="
				+ taskName + ", groupName=" + groupName + ", createId="
				+ createId + ", createDate=" + createDate + ", getCode()="
				+ getCode() + ", getMerchantNo()=" + getMerchantNo()
				+ ", getWtlCode()=" + getWtlCode() + ", getTaskName()="
				+ getTaskName() + ", getGroupName()=" + getGroupName()
				+ ", getCreateId()=" + getCreateId() + ", getCreateDate()="
				+ getCreateDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
    
    
    
}
