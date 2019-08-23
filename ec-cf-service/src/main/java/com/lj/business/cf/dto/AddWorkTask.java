package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class AddWorkTask.
 */
public class AddWorkTask implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2063041756197706561L;

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
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the new 商户编号 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 分店编号 .
	 *
	 * @return the 分店编号 
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号 .
	 *
	 * @param shopNo the new 分店编号 
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the 分店名称 .
	 *
	 * @return the 分店名称 
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the 分店名称 .
	 *
	 * @param shopName the new 分店名称 
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the 导购编号 .
	 *
	 * @return the 导购编号 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNoGm the new 导购编号 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the 导购姓名 
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberNameGm the new 导购姓名 
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the 项目CODE .
	 *
	 * @return the 项目CODE 
	 */
	public String getCodeList() {
		return codeList;
	}

	/**
	 * Sets the 项目CODE .
	 *
	 * @param codeList the new 项目CODE 
	 */
	public void setCodeList(String codeList) {
		this.codeList = codeList;
	}

	/**
	 * Gets the 项目名称 .
	 *
	 * @return the 项目名称 
	 */
	public String getNameList() {
		return nameList;
	}

	/**
	 * Sets the 项目名称 .
	 *
	 * @param nameList the new 项目名称 
	 */
	public void setNameList(String nameList) {
		this.nameList = nameList;
	}

	/**
	 * Gets the 工作日期 .
	 *
	 * @return the 工作日期 
	 */
	public Date getWorkDate() {
		return workDate;
	}

	/**
	 * Sets the 工作日期 .
	 *
	 * @param workDate the new 工作日期 
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	/**
	 * Gets the 任务要求数量 .
	 *
	 * @return the 任务要求数量 
	 */
	public Long getRequireNum() {
		return requireNum;
	}

	/**
	 * Sets the 任务要求数量 .
	 *
	 * @param requireNum the new 任务要求数量 
	 */
	public void setRequireNum(Long requireNum) {
		this.requireNum = requireNum;
	}

	/**
	 * Gets the 完成数量 .
	 *
	 * @return the 完成数量 
	 */
	public Long getFinishNum() {
		return finishNum;
	}

	/**
	 * Sets the 完成数量 .
	 *
	 * @param finishNum the new 完成数量 
	 */
	public void setFinishNum(Long finishNum) {
		this.finishNum = finishNum;
	}

	/**
	 * Gets the 未完成数量 .
	 *
	 * @return the 未完成数量 
	 */
	public Long getUnfinishNum() {
		return unfinishNum;
	}

	/**
	 * Sets the 未完成数量 .
	 *
	 * @param unfinishNum the new 未完成数量 
	 */
	public void setUnfinishNum(Long unfinishNum) {
		this.unfinishNum = unfinishNum;
	}

	/**
	 * Gets the 击败数量 .
	 *
	 * @return the 击败数量 
	 */
	public Long getDefeatNum() {
		return defeatNum;
	}

	/**
	 * Sets the 击败数量 .
	 *
	 * @param defeatNum the new 击败数量 
	 */
	public void setDefeatNum(Long defeatNum) {
		this.defeatNum = defeatNum;
	}

	/**
	 * Gets the 工作是否完成 是：Y 否：N .
	 *
	 * @return the 工作是否完成 是：Y 否：N 
	 */
	public String getFinish() {
		return finish;
	}

	/**
	 * Sets the 工作是否完成 是：Y 否：N .
	 *
	 * @param finish the new 工作是否完成 是：Y 否：N 
	 */
	public void setFinish(String finish) {
		this.finish = finish;
	}

	/**
	 * Gets the 未完成原因 .
	 *
	 * @return the 未完成原因 
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Sets the 未完成原因 .
	 *
	 * @param reason the new 未完成原因 
	 */
	public void setReason(String reason) {
		this.reason = reason;
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
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark4() {
		return remark4;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark4 the new 备注 
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark3() {
		return remark3;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark3 the new 备注 
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark2() {
		return remark2;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark2 the new 备注 
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark the new 备注 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Gets the task unit.
	 *
	 * @return the task unit
	 */
	public String getTaskUnit() {
		return taskUnit;
	}

	public void setTaskUnit(String taskUnit) {
		this.taskUnit = taskUnit;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddWorkTask [merchantNo=").append(merchantNo)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", codeList=").append(codeList).append(", nameList=")
				.append(nameList).append(", workDate=").append(workDate)
				.append(", requireNum=").append(requireNum)
				.append(", finishNum=").append(finishNum)
				.append(", unfinishNum=").append(unfinishNum)
				.append(", defeatNum=").append(defeatNum).append(", finish=")
				.append(finish).append(", reason=").append(reason)
				.append(", createId=").append(createId).append(", remark4=")
				.append(remark4).append(", remark3=").append(remark3)
				.append(", remark2=").append(remark2).append(", remark=")
				.append(remark).append(", taskUnit=").append(taskUnit)
				.append("]");
		return builder.toString();
	}

}
