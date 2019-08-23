package com.lj.business.cf.dto.clientFollow;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindClientFollowPageReturn.
 */
public class FindClientFollowPageReturn implements Serializable {

	
	 /** Generate cron. */
	private static final long serialVersionUID = -6091438601756922792L; 
	 /**
     * CODE .
     */
    private String code;
    
    /**
     * CF_NO .
     */
    private String cfNo;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 客户编号 .
     */
    private String memberNo;

    /**
     * 客户名称 .
     */
    private String memberName;

    /**
     * 导购编号 .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 跟踪次数 .
     */
    private Integer followNum;

    /**
     * 跟踪类型 .
     */
    private String followType;

    /**
     * 跟踪情况 .
     */
    private String followInfo;

    /**
     * 是否成单
             是：Y
             否：N
              .
     */
    private String deal;

    /**
     * 跟踪状态
             正常：NORMAL
             成单：DEAL
             放弃：ABANDON .
     */
    private String status;

    /**
     * 订单金额 .
     */
    private Long orderAmount;

    /**
     * 下次跟进提醒时间 .
     */
    private Date nextDate;

    /**
     * 客户沟通任务选择表的CODE .
     */
    private String taskCode;

    /**
     * 下次跟踪任务名称 .
     */
    private String taskName;
    
    /**
     * 未成单原因
     */
    private String notDealReason;

    /**
     * 备注 .
     */
    private String remark;

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
    private String remark5;

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
     * 跟进时间
     */
    private Date followTime;
    
	/**
	 * Gets the cODE .
	 *
	 * @return the cODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCfNo() {
		return cfNo;
	}

	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}

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
	 * Gets the 跟踪次数 .
	 *
	 * @return the 跟踪次数 
	 */
	public Integer getFollowNum() {
		return followNum;
	}

	/**
	 * Sets the 跟踪次数 .
	 *
	 * @param followNum the new 跟踪次数 
	 */
	public void setFollowNum(Integer followNum) {
		this.followNum = followNum;
	}

	/**
	 * Gets the 跟踪类型 .
	 *
	 * @return the 跟踪类型 
	 */
	public String getFollowType() {
		return followType;
	}

	/**
	 * Sets the 跟踪类型 .
	 *
	 * @param followType the new 跟踪类型 
	 */
	public void setFollowType(String followType) {
		this.followType = followType;
	}

	/**
	 * Gets the 跟踪情况 .
	 *
	 * @return the 跟踪情况 
	 */
	public String getFollowInfo() {
		return followInfo;
	}

	/**
	 * Sets the 跟踪情况 .
	 *
	 * @param followInfo the new 跟踪情况 
	 */
	public void setFollowInfo(String followInfo) {
		this.followInfo = followInfo;
	}

	/**
	 * Gets the 是否成单 是：Y 否：N .
	 *
	 * @return the 是否成单 是：Y 否：N 
	 */
	public String getDeal() {
		return deal;
	}

	/**
	 * Sets the 是否成单 是：Y 否：N .
	 *
	 * @param deal the new 是否成单 是：Y 否：N 
	 */
	public void setDeal(String deal) {
		this.deal = deal;
	}

	/**
	 * Gets the 跟踪状态 正常：NORMAL 成单：DEAL 放弃：ABANDON .
	 *
	 * @return the 跟踪状态 正常：NORMAL 成单：DEAL 放弃：ABANDON 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the 跟踪状态 正常：NORMAL 成单：DEAL 放弃：ABANDON .
	 *
	 * @param status the new 跟踪状态 正常：NORMAL 成单：DEAL 放弃：ABANDON 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the 订单金额 .
	 *
	 * @return the 订单金额 
	 */
	public Long getOrderAmount() {
		return orderAmount;
	}

	/**
	 * Sets the 订单金额 .
	 *
	 * @param orderAmount the new 订单金额 
	 */
	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * Gets the 下次跟进提醒时间 .
	 *
	 * @return the 下次跟进提醒时间 
	 */
	public Date getNextDate() {
		return nextDate;
	}

	/**
	 * Sets the 下次跟进提醒时间 .
	 *
	 * @param nextDate the new 下次跟进提醒时间 
	 */
	public void setNextDate(Date nextDate) {
		this.nextDate = nextDate;
	}

	/**
	 * Gets the 客户沟通任务选择表的CODE .
	 *
	 * @return the 客户沟通任务选择表的CODE 
	 */
	public String getTaskCode() {
		return taskCode;
	}

	/**
	 * Sets the 客户沟通任务选择表的CODE .
	 *
	 * @param taskCode the new 客户沟通任务选择表的CODE 
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	/**
	 * Gets the 下次跟踪任务名称 .
	 *
	 * @return the 下次跟踪任务名称 
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the 下次跟踪任务名称 .
	 *
	 * @param taskName the new 下次跟踪任务名称 
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String getNotDealReason() {
		return notDealReason;
	}

	public void setNotDealReason(String notDealReason) {
		this.notDealReason = notDealReason;
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
	 * Gets the 创建时间 .
	 *
	 * @return the 创建时间 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate the new 创建时间 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark5() {
		return remark5;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark5 the new 备注 
	 */
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
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
	
	public Date getFollowTime() {
		return followTime;
	}

	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindClientFollowPageReturn [code=").append(code)
				.append(", cfNo=").append(cfNo).append(", merchantNo=")
				.append(merchantNo).append(", memberNo=").append(memberNo)
				.append(", memberName=").append(memberName)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", followNum=").append(followNum)
				.append(", followType=").append(followType)
				.append(", followInfo=").append(followInfo).append(", deal=")
				.append(deal).append(", status=").append(status)
				.append(", orderAmount=").append(orderAmount)
				.append(", nextDate=").append(nextDate).append(", taskCode=")
				.append(taskCode).append(", taskName=").append(taskName)
				.append(", notDealReason=").append(notDealReason)
				.append(", remark=").append(remark).append(", createId=")
				.append(createId).append(", createDate=").append(createDate)
				.append(", remark5=").append(remark5).append(", remark4=")
				.append(remark4).append(", remark3=").append(remark3)
				.append(", remark2=").append(remark2).append(", followTime=")
				.append(followTime).append("]");
		return builder.toString();
	}

}
