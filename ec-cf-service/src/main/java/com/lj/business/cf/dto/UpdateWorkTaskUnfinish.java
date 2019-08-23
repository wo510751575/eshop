package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class UpdateWorkTaskUnfinish.
 */
public class UpdateWorkTaskUnfinish implements Serializable { 


	 /**

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -82944496427570067L;
	   /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号  .
     */
    private String merchantNo;

    /**
     * 工作日期 .
     */
    private Date workDate;

    /**
     * 导购编号 .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 工作事项ID .
     */
    private String taskListCode;

    /**
     * 任务名称 .
     */
    private String taskName;

    /**
     * 任务要求数量 .
     */
    private Integer requireNum;

    /**
     * 完成数量 .
     */
    private Integer finishNum;

    /**
     * 未完成数量 .
     */
    private Integer unfinishNum;

    /**
     * 击败数量 .
     */
    private Integer defeatNum;

    /**
     * 工作完成度 .
     */
    private Double workRatio;

    /**
     * 工作是否完成
             是：Y
             否：N .
     */
    private String finish;

    /**
     * 未完成原因 .
     */
    private String reason;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 备注 .
     */
    private String remark4;

    /**
     * 备注 .
     */
    private String remark3;

    /**
     * 备注 .
     */
    private String remark2;

    /**
     * 备注 .
     */
    private String remark;

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
     * 商户编号  .
     *
     * @return the 商户编号  
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号  .
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
     * 导购编号 .
     *
     * @return the 导购编号 
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * 导购编号 .
     *
     * @param memberNoGm the new 导购编号 
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the 导购姓名 
     */
    public String getMemberNameGm() {
        return memberNameGm;
    }

    /**
     * 导购姓名 .
     *
     * @param memberNameGm the new 导购姓名 
     */
    public void setMemberNameGm(String memberNameGm) {
        this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
    }

    /**
     * 工作事项ID .
     *
     * @return the 工作事项ID 
     */
    public String getTaskListCode() {
        return taskListCode;
    }

    /**
     * 工作事项ID .
     *
     * @param taskListCode the new 工作事项ID 
     */
    public void setTaskListCode(String taskListCode) {
        this.taskListCode = taskListCode == null ? null : taskListCode.trim();
    }

    /**
     * 任务名称 .
     *
     * @return the 任务名称 
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 任务名称 .
     *
     * @param taskName the new 任务名称 
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 任务要求数量 .
     *
     * @return the 任务要求数量 
     */
    public Integer getRequireNum() {
        return requireNum;
    }

    /**
     * 任务要求数量 .
     *
     * @param requireNum the new 任务要求数量 
     */
    public void setRequireNum(Integer requireNum) {
        this.requireNum = requireNum;
    }

    /**
     * 完成数量 .
     *
     * @return the 完成数量 
     */
    public Integer getFinishNum() {
        return finishNum;
    }

    /**
     * 完成数量 .
     *
     * @param finishNum the new 完成数量 
     */
    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    /**
     * 未完成数量 .
     *
     * @return the 未完成数量 
     */
    public Integer getUnfinishNum() {
        return unfinishNum;
    }

    /**
     * 未完成数量 .
     *
     * @param unfinishNum the new 未完成数量 
     */
    public void setUnfinishNum(Integer unfinishNum) {
        this.unfinishNum = unfinishNum;
    }

    /**
     * 击败数量 .
     *
     * @return the 击败数量 
     */
    public Integer getDefeatNum() {
        return defeatNum;
    }

    /**
     * 击败数量 .
     *
     * @param defeatNum the new 击败数量 
     */
    public void setDefeatNum(Integer defeatNum) {
        this.defeatNum = defeatNum;
    }

    /**
     * 工作完成度 .
     *
     * @return the 工作完成度 
     */
    public Double getWorkRatio() {
        return workRatio;
    }

    /**
     * 工作完成度 .
     *
     * @param workRatio the new 工作完成度 
     */
    public void setWorkRatio(Double workRatio) {
        this.workRatio = workRatio;
    }

    /**
     * 工作是否完成
     * 是：Y
     * 否：N .
     *
     * @return the 工作是否完成 是：Y 否：N 
     */
    public String getFinish() {
        return finish;
    }

    /**
     * 工作是否完成
     * 是：Y
     * 否：N .
     *
     * @param finish the new 工作是否完成 是：Y 否：N 
     */
    public void setFinish(String finish) {
        this.finish = finish == null ? null : finish.trim();
    }

    /**
     * 未完成原因 .
     *
     * @return the 未完成原因 
     */
    public String getReason() {
        return reason;
    }

    /**
     * 未完成原因 .
     *
     * @param reason the new 未完成原因 
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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

    /**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     * @param remark4 the new 备注 
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     * @param remark3 the new 备注 
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     * @param remark2 the new 备注 
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new 备注 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateWorkTaskUnfinish [code=" + code + ", merchantNo="
				+ merchantNo + ", workDate=" + workDate + ", memberNoGm="
				+ memberNoGm + ", memberNameGm=" + memberNameGm
				+ ", taskListCode=" + taskListCode + ", taskName=" + taskName
				+ ", requireNum=" + requireNum + ", finishNum=" + finishNum
				+ ", unfinishNum=" + unfinishNum + ", defeatNum=" + defeatNum
				+ ", workRatio=" + workRatio + ", finish=" + finish
				+ ", reason=" + reason + ", createId=" + createId
				+ ", createDate=" + createDate + ", remark4=" + remark4
				+ ", remark3=" + remark3 + ", remark2=" + remark2 + ", remark="
				+ remark + "]";
	}

}
