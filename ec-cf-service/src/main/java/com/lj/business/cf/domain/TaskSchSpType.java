package com.lj.business.cf.domain;

import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * The Class TaskSchSpType.
 */
/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：店长待办事项列表
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 */
public class TaskSchSpType {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 待办事项名称 .
     */
    private String taskName;

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
     * 商户编号 .
     *
     * @return the merchant no
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     * @param merchantNo the new merchant no
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 待办事项名称 .
     *
     * @return the task name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 待办事项名称 .
     *
     * @param taskName the new task name
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
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
		builder.append("TaskSchSpType [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", taskName=").append(taskName).append(", createId=")
				.append(createId).append(", createDate=").append(createDate)
				.append("]");
		return builder.toString();
	}
}