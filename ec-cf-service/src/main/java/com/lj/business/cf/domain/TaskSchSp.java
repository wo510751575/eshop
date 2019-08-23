package com.lj.business.cf.domain;

import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * The Class TaskSchSp.
 */
/**
 * 
 * 
 * 类说明：店长待办事项表
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
public class TaskSchSp {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 工作日期 .
     */
    private Date workDate;

    /**
     * 店长编号 .
     */
    private String memberNo;

    /**
     * 店长姓名 .
     */
    private String memberName;

    /**
     * 待办事项类型CODE .
     */
    private String tsstCode;

    /**
     * 待办事项名称 .
     */
    private String taskName;

    /**
     * 数量 .
     */
    private Integer num;

    /**
     * 排序 .
     */
    private Integer seq;

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
     * 工作日期 .
     *
     * @return the work date
     */
    public Date getWorkDate() {
        return workDate;
    }

    /**
     * 工作日期 .
     *
     * @param workDate the new work date
     */
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    /**
     * 店长编号 .
     *
     * @return the member no
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 店长编号 .
     *
     * @param memberNo the new member no
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 店长姓名 .
     *
     * @return the member name
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 店长姓名 .
     *
     * @param memberName the new member name
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 待办事项类型CODE .
     *
     * @return the tsst code
     */
    public String getTsstCode() {
        return tsstCode;
    }

    /**
     * 待办事项类型CODE .
     *
     * @param tsstCode the new tsst code
     */
    public void setTsstCode(String tsstCode) {
        this.tsstCode = tsstCode == null ? null : tsstCode.trim();
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
     * 数量 .
     *
     * @return the num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 数量 .
     *
     * @param num the new num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 排序 .
     *
     * @return the seq
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 排序 .
     *
     * @param seq the new seq
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
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
		builder.append("TaskSchSp [code=").append(code).append(", merchantNo=")
				.append(merchantNo).append(", workDate=").append(workDate)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", tsstCode=").append(tsstCode)
				.append(", taskName=").append(taskName).append(", num=")
				.append(num).append(", seq=").append(seq).append(", createId=")
				.append(createId).append(", createDate=").append(createDate)
				.append("]");
		return builder.toString();
	}
}