package com.lj.business.cf.domain;

import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * The Class WorkTask.
 */
/**
 * 
 * 
 * 类说明：工作任务统计表
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
public class WorkTask {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 分店编号 .
     */
    private String shopNo;

    /**
     * 分店名称 .
     */
    private String shopName;

    /**
     * 导购编号 .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 项目CODE .
     */
    private String codeList;

    /**
     * 项目名称 .
     */
    private String nameList;

    /**
     * 工作日期 .
     */
    private Date workDate;

    /**
     * 任务要求数量 .
     */
    private Long requireNum;

    /**
     * 完成数量 .
     */
    private Long finishNum;

    /**
     * 未完成数量 .
     */
    private Long unfinishNum;

    /**
     * 击败数量 .
     */
    private Long defeatNum;

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
    
    /** 任务单位. */
    private String taskUnit;

    /**
     * 任务类型
     */
    private String taskType;

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
     * 分店编号 .
     *
     * @return the shop no
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * 分店编号 .
     *
     * @param shopNo the new shop no
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    /**
     * 分店名称 .
     *
     * @return the shop name
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 分店名称 .
     *
     * @param shopName the new shop name
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
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
     * 项目CODE .
     *
     * @return the code list
     */
    public String getCodeList() {
        return codeList;
    }

    /**
     * 项目CODE .
     *
     * @param codeList the new code list
     */
    public void setCodeList(String codeList) {
        this.codeList = codeList == null ? null : codeList.trim();
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
     * 任务要求数量 .
     *
     * @return the require num
     */
    public Long getRequireNum() {
        return requireNum;
    }

    /**
     * 任务要求数量 .
     *
     * @param requireNum the new require num
     */
    public void setRequireNum(Long requireNum) {
        this.requireNum = requireNum;
    }

    /**
     * 完成数量 .
     *
     * @return the finish num
     */
    public Long getFinishNum() {
        return finishNum;
    }

    /**
     * 完成数量 .
     *
     * @param finishNum the new finish num
     */
    public void setFinishNum(Long finishNum) {
        this.finishNum = finishNum;
    }

    /**
     * 未完成数量 .
     *
     * @return the unfinish num
     */
    public Long getUnfinishNum() {
        return unfinishNum;
    }

    /**
     * 未完成数量 .
     *
     * @param unfinishNum the new unfinish num
     */
    public void setUnfinishNum(Long unfinishNum) {
        this.unfinishNum = unfinishNum;
    }

    /**
     * 击败数量 .
     *
     * @return the defeat num
     */
    public Long getDefeatNum() {
        return defeatNum;
    }

    /**
     * 击败数量 .
     *
     * @param defeatNum the new defeat num
     */
    public void setDefeatNum(Long defeatNum) {
        this.defeatNum = defeatNum;
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

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkTask [code=").append(code).append(", merchantNo=")
				.append(merchantNo).append(", shopNo=").append(shopNo)
				.append(", shopName=").append(shopName).append(", memberNoGm=")
				.append(memberNoGm).append(", memberNameGm=")
				.append(memberNameGm).append(", codeList=").append(codeList)
				.append(", nameList=").append(nameList).append(", workDate=")
				.append(workDate).append(", requireNum=").append(requireNum)
				.append(", finishNum=").append(finishNum)
				.append(", unfinishNum=").append(unfinishNum)
				.append(", defeatNum=").append(defeatNum).append(", finish=")
				.append(finish).append(", reason=").append(reason)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", remark4=").append(remark4)
				.append(", remark3=").append(remark3).append(", remark2=")
				.append(remark2).append(", remark=").append(remark)
				.append(", taskUnit=").append(taskUnit).append("]");
		return builder.toString();
	}

}