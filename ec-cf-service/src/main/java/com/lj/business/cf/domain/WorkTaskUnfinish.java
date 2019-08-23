package com.lj.business.cf.domain;

import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * The Class WorkTaskUnfinish.
 */
/**
 * 
 * 
 * 类说明：未完成工作任务表
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
public class WorkTaskUnfinish {
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
     * 导购编号 .
     *
     * @return the member no gm
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * 导购编号 .
     *
     * @param memberNoGm the new member no gm
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the member name gm
     */
    public String getMemberNameGm() {
        return memberNameGm;
    }

    /**
     * 导购姓名 .
     *
     * @param memberNameGm the new member name gm
     */
    public void setMemberNameGm(String memberNameGm) {
        this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
    }

    /**
     * 工作事项ID .
     *
     * @return the task list code
     */
    public String getTaskListCode() {
        return taskListCode;
    }

    /**
     * 工作事项ID .
     *
     * @param taskListCode the new task list code
     */
    public void setTaskListCode(String taskListCode) {
        this.taskListCode = taskListCode == null ? null : taskListCode.trim();
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
     * 任务要求数量 .
     *
     * @return the require num
     */
    public Integer getRequireNum() {
        return requireNum;
    }

    /**
     * 任务要求数量 .
     *
     * @param requireNum the new require num
     */
    public void setRequireNum(Integer requireNum) {
        this.requireNum = requireNum;
    }

    /**
     * 完成数量 .
     *
     * @return the finish num
     */
    public Integer getFinishNum() {
        return finishNum;
    }

    /**
     * 完成数量 .
     *
     * @param finishNum the new finish num
     */
    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    /**
     * 未完成数量 .
     *
     * @return the unfinish num
     */
    public Integer getUnfinishNum() {
        return unfinishNum;
    }

    /**
     * 未完成数量 .
     *
     * @param unfinishNum the new unfinish num
     */
    public void setUnfinishNum(Integer unfinishNum) {
        this.unfinishNum = unfinishNum;
    }

    /**
     * 击败数量 .
     *
     * @return the defeat num
     */
    public Integer getDefeatNum() {
        return defeatNum;
    }

    /**
     * 击败数量 .
     *
     * @param defeatNum the new defeat num
     */
    public void setDefeatNum(Integer defeatNum) {
        this.defeatNum = defeatNum;
    }

    /**
     * 工作完成度 .
     *
     * @return the work ratio
     */
    public Double getWorkRatio() {
        return workRatio;
    }

    /**
     * 工作完成度 .
     *
     * @param workRatio the new work ratio
     */
    public void setWorkRatio(Double workRatio) {
        this.workRatio = workRatio;
    }

    /**
     * 工作是否完成
     *              是：Y
     *              否：N .
     *
     * @return the finish
     */
    public String getFinish() {
        return finish;
    }

    /**
     * 工作是否完成
     *              是：Y
     *              否：N .
     *
     * @param finish the new finish
     */
    public void setFinish(String finish) {
        this.finish = finish == null ? null : finish.trim();
    }

    /**
     * 未完成原因 .
     *
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 未完成原因 .
     *
     * @param reason the new reason
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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
     * 备注 .
     *
     * @return the remark 4
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     * @param remark4 the new remark 4
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 3
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     * @param remark3 the new remark 3
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     * @param remark2 the new remark 2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkTaskUnfinish [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", workDate=").append(workDate).append(", memberNoGm=")
				.append(memberNoGm).append(", memberNameGm=")
				.append(memberNameGm).append(", taskListCode=")
				.append(taskListCode).append(", taskName=").append(taskName)
				.append(", requireNum=").append(requireNum)
				.append(", finishNum=").append(finishNum)
				.append(", unfinishNum=").append(unfinishNum)
				.append(", defeatNum=").append(defeatNum)
				.append(", workRatio=").append(workRatio).append(", finish=")
				.append(finish).append(", reason=").append(reason)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", remark4=").append(remark4)
				.append(", remark3=").append(remark3).append(", remark2=")
				.append(remark2).append(", remark=").append(remark).append("]");
		return builder.toString();
	}
}