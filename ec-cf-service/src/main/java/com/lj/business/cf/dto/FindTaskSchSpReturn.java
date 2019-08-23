package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindTaskSchSpReturn.
 */
public class FindTaskSchSpReturn implements Serializable { 

    
	 /** Generate cron. */
	private static final long serialVersionUID = -5599304610693641499L;
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
     * @return the cODE 
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new cODE 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商户编号 .
     *
     * @return the 商户编号 
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     * @param merchantNo the new 商户编号 
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 工作日期 .
     *
     * @return the 工作日期 
     */
    public Date getWorkDate() {
        return workDate;
    }

    /**
     * 工作日期 .
     *
     * @param workDate the new 工作日期 
     */
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    /**
     * 店长编号 .
     *
     * @return the 店长编号 
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 店长编号 .
     *
     * @param memberNo the new 店长编号 
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 店长姓名 .
     *
     * @return the 店长姓名 
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 店长姓名 .
     *
     * @param memberName the new 店长姓名 
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 待办事项类型CODE .
     *
     * @return the 待办事项类型CODE 
     */
    public String getTsstCode() {
        return tsstCode;
    }

    /**
     * 待办事项类型CODE .
     *
     * @param tsstCode the new 待办事项类型CODE 
     */
    public void setTsstCode(String tsstCode) {
        this.tsstCode = tsstCode == null ? null : tsstCode.trim();
    }

    /**
     * 待办事项名称 .
     *
     * @return the 待办事项名称 
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 待办事项名称 .
     *
     * @param taskName the new 待办事项名称 
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 数量 .
     *
     * @return the 数量 
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 数量 .
     *
     * @param num the new 数量 
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 排序 .
     *
     * @return the 排序 
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 排序 .
     *
     * @param seq the new 排序 
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 创建人 .
     *
     * @return the 创建人 
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new 创建人 
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the 创建时间 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new 创建时间 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TaskSchSp [code=" + code + ", merchantNo=" + merchantNo
				+ ", workDate=" + workDate + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + ", tsstCode=" + tsstCode
				+ ", taskName=" + taskName + ", num=" + num + ", seq=" + seq
				+ ", createId=" + createId + ", createDate=" + createDate + "]";
	}
    
}
