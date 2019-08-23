package com.lj.business.cf.dto.workTaskGroup;

import java.io.Serializable;
import java.util.Date;

public class FindWorkTaskGroup implements Serializable {

	 /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = 5093489537479649385L;

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
	    
	    
	    

	public String getMerchantNo() {
			return merchantNo;
		}

		public void setMerchantNo(String merchantNo) {
			this.merchantNo = merchantNo;
		}

		public String getWtlCode() {
			return wtlCode;
		}

		public void setWtlCode(String wtlCode) {
			this.wtlCode = wtlCode;
		}

		public String getTaskName() {
			return taskName;
		}

		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}

		public String getGroupName() {
			return groupName;
		}

		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}

		public String getCreateId() {
			return createId;
		}

		public void setCreateId(String createId) {
			this.createId = createId;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FindWorkTaskGroup [code=" + code + ", merchantNo=" + merchantNo
				+ ", wtlCode=" + wtlCode + ", taskName=" + taskName
				+ ", groupName=" + groupName + ", createId=" + createId
				+ ", createDate=" + createDate + "]";
	}
	  

}
