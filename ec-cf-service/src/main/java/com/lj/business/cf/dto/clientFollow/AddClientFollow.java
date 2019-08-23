package com.lj.business.cf.dto.clientFollow;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.cf.emus.Status;

// TODO: Auto-generated Javadoc
/**
 * The Class AddClientFollow.
 */
public class AddClientFollow implements Serializable { 

    
	 /** Generate cron. */
	private static final long serialVersionUID = 2528383592361227182L;
	
    /**
     * 商户编号 .
     */
    private String merchantNo;
    
    /** 跟踪编号. */
    private String cfNo;

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

    /** 未成单原因. */
    private String notDealReason;
    
    /** 放弃原因. */
    private String resean;

    /**
     * 沟通任务类型 .
     */
    private String comTaskType;
    

    /**
     * 跟进沟通任务类型 .
     */
    private String comTaskTypeCf;


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
    
    /** 跟进时间. */
    private Date followTime;
    
    /**
     * 区域编号 .
     */
    private String areaCode;
    
    /**
     * 区域名称.
     */
    private String areaName;
    
    /** 分店编号. */
    private String shopNo;
    
    /** 分店名称. */
    private String shopName;
    
    /**
     * 导购头像 .
     */
    private String headAddress;
    
    /**
     * 客户沟通任务Code .
     */
    private String comTaskCode;
    
    /**
     * 是否累计任务，默认false .
     */
    private Boolean dis = false;
    
    /**
     * 是否FINISH原沟通任务，默认true .
     */
    private Boolean finishOrgComTask = true;
    
    
    /**
     * 任务备注(业务任务用) .
     */
    private String remarkCom;
    
    /**
     * 上次结果时间(业务任务用) .
     */
    private Date lastResultDate;
    

    /**
     * 是否FINISH所有原任务，默认false .
     */
    private Boolean finishAllComTask = false;
    
    
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
	 * Gets the cf no.
	 *
	 * @return the cf no
	 */
	public String getCfNo() {
		return cfNo;
	}

	/**
	 * Sets the cf no.
	 *
	 * @param cfNo the new cf no
	 */
	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
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
	 * Gets the 放弃原因.
	 *
	 * @return the 放弃原因
	 */
	public String getResean() {
		return resean;
	}
	
	/**
	 * Sets the 放弃原因.
	 *
	 * @param resean the new 放弃原因
	 */
	public void setResean(String resean) {
		this.resean = resean;
	}
	
	/**
	 * Gets the 区域编号 .
	 *
	 * @return the 区域编号 
	 */
	public String getAreaCode() {
		return areaCode;
	}
	
	/**
	 * Sets the 区域编号 .
	 *
	 * @param areaCode the new 区域编号 
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * Gets the 区域名称.
	 *
	 * @return the 区域名称
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * Sets the 区域名称.
	 *
	 * @param areaName the new 区域名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	/**
	 * Gets the 分店编号.
	 *
	 * @return the 分店编号
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号.
	 *
	 * @param shopNo the new 分店编号
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the 分店名称.
	 *
	 * @return the 分店名称
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the 分店名称.
	 *
	 * @param shopName the new 分店名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	/**
	 * Gets the 导购头像 .
	 *
	 * @return the 导购头像 
	 */
	public String getHeadAddress() {
		return headAddress;
	}

	/**
	 * Sets the 导购头像 .
	 *
	 * @param headAddress the new 导购头像 
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
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
	
	/**
	 * Gets the 客户沟通任务Code .
	 *
	 * @return the 客户沟通任务Code 
	 */
	public String getComTaskCode() {
		return comTaskCode;
	}

	/**
	 * Sets the 客户沟通任务Code .
	 *
	 * @param comTaskCode the new 客户沟通任务Code 
	 */
	public void setComTaskCode(String comTaskCode) {
		this.comTaskCode = comTaskCode;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddClientFollow [merchantNo=").append(merchantNo)
				.append(", cfNo=").append(cfNo).append(", memberNo=")
				.append(memberNo).append(", memberName=").append(memberName)
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
				.append(", resean=").append(resean).append(", comTaskType=")
				.append(comTaskType).append(", comTaskTypeCf=")
				.append(comTaskTypeCf).append(", clientExpNum=")
				.append(clientExpNum).append(", clientInviteNum=")
				.append(clientInviteNum).append(", clientGuidNum=")
				.append(clientGuidNum).append(", remark=").append(remark)
				.append(", createId=").append(createId).append(", remark4=")
				.append(remark4).append(", remark3=").append(remark3)
				.append(", remark2=").append(remark2).append(", followTime=")
				.append(followTime).append(", areaCode=").append(areaCode)
				.append(", areaName=").append(areaName).append(", shopNo=")
				.append(shopNo).append(", shopName=").append(shopName)
				.append(", headAddress=").append(headAddress)
				.append(", comTaskCode=").append(comTaskCode).append(", dis=")
				.append(dis).append(", finishOrgComTask=")
				.append(finishOrgComTask).append(", remarkCom=")
				.append(remarkCom).append(", lastResultDate=")
				.append(lastResultDate).append(", finishAllComTask=")
				.append(finishAllComTask).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 跟进沟通任务类型 .
	 *
	 * @return the 跟进沟通任务类型 
	 */
	public String getComTaskTypeCf() {
		return comTaskTypeCf;
	}

	/**
	 * Sets the 跟进沟通任务类型 .
	 *
	 * @param comTaskTypeCf the new 跟进沟通任务类型 
	 */
	public void setComTaskTypeCf(String comTaskTypeCf) {
		this.comTaskTypeCf = comTaskTypeCf;
	}

	/**
	 * Gets the 任务备注(业务任务用) .
	 *
	 * @return the 任务备注(业务任务用) 
	 */
	public String getRemarkCom() {
		return remarkCom;
	}

	/**
	 * Sets the 任务备注(业务任务用) .
	 *
	 * @param remarkCom the new 任务备注(业务任务用) 
	 */
	public void setRemarkCom(String remarkCom) {
		this.remarkCom = remarkCom;
	}

	/**
	 * Gets the 上次结果时间(业务任务用) .
	 *
	 * @return the 上次结果时间(业务任务用) 
	 */
	public Date getLastResultDate() {
		return lastResultDate;
	}

	/**
	 * Sets the 上次结果时间(业务任务用) .
	 *
	 * @param lastResultDate the new 上次结果时间(业务任务用) 
	 */
	public void setLastResultDate(Date lastResultDate) {
		this.lastResultDate = lastResultDate;
	}

	/**
	 * Gets the 是否FINISH所有原任务，默认false .
	 *
	 * @return the 是否FINISH所有原任务，默认false 
	 */
	public Boolean getFinishAllComTask() {
		return finishAllComTask;
	}

	/**
	 * Sets the 是否FINISH所有原任务，默认false .
	 *
	 * @param finishAllComTask the new 是否FINISH所有原任务，默认false 
	 */
	public void setFinishAllComTask(Boolean finishAllComTask) {
		this.finishAllComTask = finishAllComTask;
	}

}
