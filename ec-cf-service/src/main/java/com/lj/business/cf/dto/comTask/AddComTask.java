package com.lj.business.cf.dto.comTask;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.cf.emus.ComTaskFinish;
import com.lj.business.cf.emus.ComTaskType;

/**
 * The Class AddComTask.
 */
public class AddComTask implements Serializable { 

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4823507199952220073L;

	/**
     * 商户编号（必填） .
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
     * 导购编号（必填） .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 项目CODE（必填） .
     */
    private String codeList;

    /**
     * 项目名称 .
     */
    private String nameList;

    /**
     * 客户编号（必填） .
     */
    private String memberNo;

    /**
     * 客户名称 .
     */
    private String memberName;

    
    /**
     * 工作日期（必填） .
     */
    private Date workDate;

    /**
     * 任务备注 .
     */
    private String remarkCom;

    /**
     * 任务完成情况
		进行中：NORMAL
		完成：FINISH
		系统关闭：CLOSE_SYS.
     */
    private ComTaskFinish finish;

    /**
     * 未完成原因 .
     */
    private String reason;
    
    /** 跟踪总表或维护总表code（必填）. */
    private String cfNo;
    
    /** 编号类型 （必填） 跟进：FOLLOW 维护：KEEP. */
    private String noType;
    
    /**
     * 原客户沟通任务Code .
     */
    private String orgComTaskCode;
    
    /**
     * 是否FINISH原沟通任务，默认true .
     */
    private Boolean finishOrgComTask = true;
    
    
    /**
     * 是否累计任务，默认false .
     */
    private Boolean dis = false;
    

    /**
     * 沟通任务类型(必填) .
     */
    private ComTaskType comTaskType;
    
    /**
     * 上次结果时间 .
     */
    private Date lastResultDate;
    
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
	 * Gets the 未完成原因 .
	 *
	 * @return the 未完成原因 
	 */
	public String getRemarkCom() {
		return remarkCom;
	}

	/**
	 * Sets the 未完成原因 .
	 *
	 * @param remarkCom the new 未完成原因 
	 */
	public void setRemarkCom(String remarkCom) {
		this.remarkCom = remarkCom;
	}

	/**
	 * Gets the 任务完成情况 进行中：NORMAL 完成：FINISH 已关闭：CLOSE 系统关闭：C_SYS.
	 *
	 * @return the 任务完成情况 进行中：NORMAL 完成：FINISH 已关闭：CLOSE 系统关闭：C_SYS
	 */
	public ComTaskFinish getFinish() {
		return finish;
	}

	/**
	 * Sets the 任务完成情况 进行中：NORMAL 完成：FINISH 已关闭：CLOSE 系统关闭：C_SYS.
	 *
	 * @param finish the new 任务完成情况 进行中：NORMAL 完成：FINISH 已关闭：CLOSE 系统关闭：C_SYS
	 */
	public void setFinish(ComTaskFinish finish) {
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
	 * Gets the 跟踪总表或维护总表code（必填）.
	 *
	 * @return the 跟踪总表或维护总表code（必填）
	 */
	public String getCfNo() {
		return cfNo;
	}

	/**
	 * Sets the 跟踪总表或维护总表code（必填）.
	 *
	 * @param cfNo the new 跟踪总表或维护总表code（必填）
	 */
	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}

	/**
	 * Gets the 编号类型 （必填） 跟进：FOLLOW 维护：KEEP.
	 *
	 * @return the 编号类型 （必填） 跟进：FOLLOW 维护：KEEP
	 */
	public String getNoType() {
		return noType;
	}

	/**
	 * Sets the 编号类型 （必填） 跟进：FOLLOW 维护：KEEP.
	 *
	 * @param noType the new 编号类型 （必填） 跟进：FOLLOW 维护：KEEP
	 */
	public void setNoType(String noType) {
		this.noType = noType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddComTask [merchantNo=").append(merchantNo)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", codeList=").append(codeList).append(", nameList=")
				.append(nameList).append(", memberNo=").append(memberNo)
				.append(", memberName=").append(memberName)
				.append(", workDate=").append(workDate).append(", remarkCom=")
				.append(remarkCom).append(", finish=").append(finish)
				.append(", reason=").append(reason).append(", cfNo=")
				.append(cfNo).append(", noType=").append(noType)
				.append(", orgComTaskCode=").append(orgComTaskCode)
				.append(", finishOrgComTask=").append(finishOrgComTask)
				.append(", dis=").append(dis).append(", comTaskType=")
				.append(comTaskType).append(", lastResultDate=")
				.append(lastResultDate).append(", createId=").append(createId)
				.append(", remark4=").append(remark4).append(", remark3=")
				.append(remark3).append(", remark2=").append(remark2)
				.append(", remark=").append(remark).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 客户编号 .
	 *
	 * @return the 客户编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 客户编号 .
	 *
	 * @param memberNo the new 客户编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 客户名称 .
	 *
	 * @return the 客户名称 
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 客户名称 .
	 *
	 * @param memberName the new 客户名称 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the 原客户沟通任务Code .
	 *
	 * @return the 原客户沟通任务Code 
	 */
	public String getOrgComTaskCode() {
		return orgComTaskCode;
	}

	/**
	 * Sets the 原客户沟通任务Code .
	 *
	 * @param orgComTaskCode the new 原客户沟通任务Code 
	 */
	public void setOrgComTaskCode(String orgComTaskCode) {
		this.orgComTaskCode = orgComTaskCode;
	}

	/**
	 * Gets the 是否FINISH原沟通任务，默认true .
	 *
	 * @return the 是否FINISH原沟通任务，默认true 
	 */
	public Boolean getFinishOrgComTask() {
		return finishOrgComTask;
	}

	/**
	 * Sets the 是否FINISH原沟通任务，默认true .
	 *
	 * @param finishOrgComTask the new 是否FINISH原沟通任务，默认true 
	 */
	public void setFinishOrgComTask(Boolean finishOrgComTask) {
		this.finishOrgComTask = finishOrgComTask;
	}

	/**
	 * Gets the 是否累计任务，默认false .
	 *
	 * @return the 是否累计任务，默认false 
	 */
	public Boolean getDis() {
		return dis;
	}

	/**
	 * Sets the 是否累计任务，默认false .
	 *
	 * @param dis the new 是否累计任务，默认false 
	 */
	public void setDis(Boolean dis) {
		this.dis = dis;
	}

	/**
	 * Gets the 沟通任务类型(必填) .
	 *
	 * @return the 沟通任务类型(必填) 
	 */
	public ComTaskType getComTaskType() {
		return comTaskType;
	}

	/**
	 * Sets the 沟通任务类型(必填) .
	 *
	 * @param comTaskType the new 沟通任务类型(必填) 
	 */
	public void setComTaskType(ComTaskType comTaskType) {
		this.comTaskType = comTaskType;
	}

	/**
	 * Gets the 上次结果时间 .
	 *
	 * @return the 上次结果时间 
	 */
	public Date getLastResultDate() {
		return lastResultDate;
	}

	/**
	 * Sets the 上次结果时间 .
	 *
	 * @param lastResultDate the new 上次结果时间 
	 */
	public void setLastResultDate(Date lastResultDate) {
		this.lastResultDate = lastResultDate;
	}
}
