package com.lj.business.cf.dto.comTask;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindComTaskIndexPage.
 */
public class FindComTaskIndexPage  extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6939435476221460724L;
	
	 /**
     * 商户编号(必填) .
     */
    private String merchantNo;
    
    /**
     * 导购编号(必填)  .
     */
    private String memberNoGm;
    
    /**
     * 项目CODE(必填) .
     */
    private String codeList;
    
    /**
     * 工作日期_开始 .
     */
    private Date workDateStart;
    
    /**
     * 工作日期_结束 .
     */
    private Date workDateEnd;
    
    /**
     * 查询维度(必填)
     * NOW：当天
     * DIS：累计 .
     */
    private String flag;
    
    /**
     * 沟通任务类型
		分组任务：GROUP
		初次介绍：FIRST_INTR
		沟通任务：COM_TASK
		邀约任务：INVITE
		提醒任务：REMIND
		到店体验：CLIENT_EXP
		引导客户：GUID_PM
     */
    private String comTaskType;

	/**
	 * Gets the 商户编号(必填) .
	 *
	 * @return the 商户编号(必填) 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号(必填) .
	 *
	 * @param merchantNo the new 商户编号(必填) 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 导购编号(必填)  .
	 *
	 * @return the 导购编号(必填)  
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号(必填)  .
	 *
	 * @param memberNoGm the new 导购编号(必填)  
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 项目CODE(必填) .
	 *
	 * @return the 项目CODE(必填) 
	 */
	public String getCodeList() {
		return codeList;
	}

	/**
	 * Sets the 项目CODE(必填) .
	 *
	 * @param codeList the new 项目CODE(必填) 
	 */
	public void setCodeList(String codeList) {
		this.codeList = codeList;
	}

	/**
	 * Gets the 查询维度(必填) NOW：当天 DIS：累计 .
	 *
	 * @return the 查询维度(必填) NOW：当天 DIS：累计 
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * Sets the 查询维度(必填) NOW：当天 DIS：累计 .
	 *
	 * @param flag the new 查询维度(必填) NOW：当天 DIS：累计 
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskIndexPage [merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", codeList=").append(codeList)
				.append(", workDateStart=").append(workDateStart)
				.append(", workDateEnd=").append(workDateEnd).append(", flag=")
				.append(flag).append(", comTaskType=").append(comTaskType)
				.append("]");
		return builder.toString();
	}

	/**
	 * Gets the 工作日期_开始 .
	 *
	 * @return the 工作日期_开始 
	 */
	public Date getWorkDateStart() {
		return workDateStart;
	}

	/**
	 * Sets the 工作日期_开始 .
	 *
	 * @param workDateStart the new 工作日期_开始 
	 */
	public void setWorkDateStart(Date workDateStart) {
		this.workDateStart = workDateStart;
	}

	/**
	 * Gets the 工作日期_结束 .
	 *
	 * @return the 工作日期_结束 
	 */
	public Date getWorkDateEnd() {
		return workDateEnd;
	}

	/**
	 * Sets the 工作日期_结束 .
	 *
	 * @param workDateEnd the new 工作日期_结束 
	 */
	public void setWorkDateEnd(Date workDateEnd) {
		this.workDateEnd = workDateEnd;
	}

	/**
	 * Gets the 沟通任务类型 完善资料：IMPROVE（作废） 分组任务：GROUP 初次介绍：FIRST_INTR 沟通任务：COM_TASK 邀约任务：INVITE 提醒任务：REMIND 到店体验：CLIENT_EXP 引导客户：GUID_PM.
	 *
	 * @return the 沟通任务类型 完善资料：IMPROVE（作废） 分组任务：GROUP 初次介绍：FIRST_INTR 沟通任务：COM_TASK 邀约任务：INVITE 提醒任务：REMIND 到店体验：CLIENT_EXP 引导客户：GUID_PM
	 */
	public String getComTaskType() {
		return comTaskType;
	}

	public void setComTaskType(String comTaskType) {
		this.comTaskType = comTaskType;
	}
  

}
