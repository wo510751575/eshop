package com.lj.business.cf.dto.clientFollow;

import java.io.Serializable;
import java.util.Date;

import com.lj.base.core.util.EnumUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.emus.FollowType;
import com.lj.business.cf.emus.Status;

/**
 * The Class FindClientFollowReturn.
 */
public class FindClientFollowReturn implements Serializable { 

    
	 /** Generate cron. */
	private static final long serialVersionUID = -296672307236641553L;

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
    
    /** 跟进类型中文. */
    private String followTypeName;

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
    private Status status;

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
     * 沟通任务类型 .
     */
    private String comTaskType;
    
    /**
     * 沟通任务类型名称
     */
    private String comTaskTypeName;

    /**
     * 客户体验次数 .
     */
    private Integer clientExpNum;

    /**
     * 客户邀约次数 .
     */
    private Integer clientInviteNum;

    /**
     * 客户引导次数 .
     */
    private Integer clientGuidNum;


    /**
     * 备注 .
     */
    private String remark;
    
    /** 未成单原因. */
    private String notDealReason;

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
    
    /** 跟进时间. */
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
	
	/**
	 * Gets the cF_NO .
	 *
	 * @return the cF_NO 
	 */
	public String getCfNo() {
		return cfNo;
	}

	/**
	 * Sets the cF_NO .
	 *
	 * @param cfNo the new cF_NO 
	 */
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
		if(!StringUtils.isEmpty(followType)){
			this.followTypeName = EnumUtils.getValue(FollowType.class, followType);
		}
	}
	
	/**
	 * Gets the 跟进类型中文.
	 *
	 * @return the 跟进类型中文
	 */
	public String getFollowTypeName() {
		return followTypeName;
	}

	/**
	 * Sets the 跟进类型中文.
	 *
	 * @param followTypeName the new 跟进类型中文
	 */
	public void setFollowTypeName(String followTypeName) {
		this.followTypeName = followTypeName;
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
	public Status getStatus() {
		return status;
	}

	/**
	 * Sets the 跟踪状态 正常：NORMAL 成单：DEAL 放弃：ABANDON .
	 *
	 * @param status the new 跟踪状态 正常：NORMAL 成单：DEAL 放弃：ABANDON 
	 */
	public void setStatus(Status status) {
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
	 * Gets the 未成单原因.
	 *
	 * @return the 未成单原因
	 */
	public String getNotDealReason() {
		return notDealReason;
	}

	/**
	 * Sets the 未成单原因.
	 *
	 * @param notDealReason the new 未成单原因
	 */
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
	
	/**
	 * Gets the 跟进时间.
	 *
	 * @return the 跟进时间
	 */
	public Date getFollowTime() {
		return followTime;
	}

	/**
	 * Sets the 跟进时间.
	 *
	 * @param followTime the new 跟进时间
	 */
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}

	/**
	 * Gets the 沟通任务类型 .
	 *
	 * @return the 沟通任务类型 
	 */
	public String getComTaskType() {
		return comTaskType;
	}

	/**
	 * Sets the 沟通任务类型 .
	 *
	 * @param comTaskType the new 沟通任务类型 
	 */
	public void setComTaskType(String comTaskType) {
		this.comTaskType = comTaskType;
		if(!StringUtils.isEmpty(this.comTaskType)){
			this.comTaskTypeName = EnumUtils.getValue(ComTaskType.class, this.comTaskType);
		}
	}
	
	public String getComTaskTypeName() {
		return comTaskTypeName;
	}

	public void setComTaskTypeName(String comTaskTypeName) {
		this.comTaskTypeName = comTaskTypeName;
	}

	/**
	 * Gets the 客户体验次数 .
	 *
	 * @return the 客户体验次数 
	 */
	public Integer getClientExpNum() {
		return clientExpNum;
	}

	/**
	 * Sets the 客户体验次数 .
	 *
	 * @param clientExpNum the new 客户体验次数 
	 */
	public void setClientExpNum(Integer clientExpNum) {
		this.clientExpNum = clientExpNum;
	}

	/**
	 * Gets the 客户邀约次数 .
	 *
	 * @return the 客户邀约次数 
	 */
	public Integer getClientInviteNum() {
		return clientInviteNum;
	}

	/**
	 * Sets the 客户邀约次数 .
	 *
	 * @param clientInviteNum the new 客户邀约次数 
	 */
	public void setClientInviteNum(Integer clientInviteNum) {
		this.clientInviteNum = clientInviteNum;
	}

	/**
	 * Gets the 客户引导次数 .
	 *
	 * @return the 客户引导次数 
	 */
	public Integer getClientGuidNum() {
		return clientGuidNum;
	}

	/**
	 * Sets the 客户引导次数 .
	 *
	 * @param clientGuidNum the new 客户引导次数 
	 */
	public void setClientGuidNum(Integer clientGuidNum) {
		this.clientGuidNum = clientGuidNum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindClientFollowReturn [code=").append(code)
				.append(", cfNo=").append(cfNo).append(", merchantNo=")
				.append(merchantNo).append(", memberNo=").append(memberNo)
				.append(", memberName=").append(memberName)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", followNum=").append(followNum)
				.append(", followType=").append(followType)
				.append(", followTypeName=").append(followTypeName)
				.append(", followInfo=").append(followInfo).append(", deal=")
				.append(deal).append(", status=").append(status)
				.append(", orderAmount=").append(orderAmount)
				.append(", nextDate=").append(nextDate).append(", taskCode=")
				.append(taskCode).append(", taskName=").append(taskName)
				.append(", comTaskType=").append(comTaskType)
				.append(", clientExpNum=").append(clientExpNum)
				.append(", clientInviteNum=").append(clientInviteNum)
				.append(", clientGuidNum=").append(clientGuidNum)
				.append(", remark=").append(remark).append(", notDealReason=")
				.append(notDealReason).append(", createId=").append(createId)
				.append(", createDate=").append(createDate)
				.append(", remark4=").append(remark4).append(", remark3=")
				.append(remark3).append(", remark2=").append(remark2)
				.append(", followTime=").append(followTime).append("]");
		return builder.toString();
	}


}
