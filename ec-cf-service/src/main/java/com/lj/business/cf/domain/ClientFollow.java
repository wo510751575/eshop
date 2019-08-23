package com.lj.business.cf.domain;

import java.util.Date;

public class ClientFollow {
    /**
     * CODE .
     */
    private String code;

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
     * 跟踪编号 .
     */
    private String cfNo;

    /**
     * 跟踪次数 .
     */
    private Integer followNum;

    /**
     * 跟进时间 .
     */
    private Date followTime;

    /**
     * 跟踪类型 .
     */
    private String followType;

    /**
     * 跟踪情况 .
     */
    private String followInfo;

    /**
     * 未成单原因 .
     */
    private String notDealReason;

    /**
     * 是否成单             是：Y             否：N              .
     */
    private String deal;

    /**
     * 跟踪状态             正常：NORMAL             成单：DEAL             放弃：ABANDON .
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
     * 沟通任务类型 .
     */
    private String comTaskType;

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
     *  .
     */
    private String paCode;

    /**
     * CODE .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商户编号 .
     *
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 客户编号 .
     *
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 客户编号 .
     *
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 客户名称 .
     *
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 客户名称 .
     *
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 导购编号 .
     *
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * 导购编号 .
     *
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
    }

    /**
     * 导购姓名 .
     *
     */
    public String getMemberNameGm() {
        return memberNameGm;
    }

    /**
     * 导购姓名 .
     *
     */
    public void setMemberNameGm(String memberNameGm) {
        this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
    }

    /**
     * 跟踪编号 .
     *
     */
    public String getCfNo() {
        return cfNo;
    }

    /**
     * 跟踪编号 .
     *
     */
    public void setCfNo(String cfNo) {
        this.cfNo = cfNo == null ? null : cfNo.trim();
    }

    /**
     * 跟踪次数 .
     *
     */
    public Integer getFollowNum() {
        return followNum;
    }

    /**
     * 跟踪次数 .
     *
     */
    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    /**
     * 跟进时间 .
     *
     */
    public Date getFollowTime() {
        return followTime;
    }

    /**
     * 跟进时间 .
     *
     */
    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    /**
     * 跟踪类型 .
     *
     */
    public String getFollowType() {
        return followType;
    }

    /**
     * 跟踪类型 .
     *
     */
    public void setFollowType(String followType) {
        this.followType = followType == null ? null : followType.trim();
    }

    /**
     * 跟踪情况 .
     *
     */
    public String getFollowInfo() {
        return followInfo;
    }

    /**
     * 跟踪情况 .
     *
     */
    public void setFollowInfo(String followInfo) {
        this.followInfo = followInfo == null ? null : followInfo.trim();
    }

    /**
     * 未成单原因 .
     *
     */
    public String getNotDealReason() {
        return notDealReason;
    }

    /**
     * 未成单原因 .
     *
     */
    public void setNotDealReason(String notDealReason) {
        this.notDealReason = notDealReason == null ? null : notDealReason.trim();
    }

    /**
     * 是否成单             是：Y             否：N              .
     *
     */
    public String getDeal() {
        return deal;
    }

    /**
     * 是否成单             是：Y             否：N              .
     *
     */
    public void setDeal(String deal) {
        this.deal = deal == null ? null : deal.trim();
    }

    /**
     * 跟踪状态             正常：NORMAL             成单：DEAL             放弃：ABANDON .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 跟踪状态             正常：NORMAL             成单：DEAL             放弃：ABANDON .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 订单金额 .
     *
     */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * 订单金额 .
     *
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 下次跟进提醒时间 .
     *
     */
    public Date getNextDate() {
        return nextDate;
    }

    /**
     * 下次跟进提醒时间 .
     *
     */
    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    /**
     * 客户沟通任务选择表的CODE .
     *
     */
    public String getTaskCode() {
        return taskCode;
    }

    /**
     * 客户沟通任务选择表的CODE .
     *
     */
    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode == null ? null : taskCode.trim();
    }

    /**
     * 下次跟踪任务名称 .
     *
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 下次跟踪任务名称 .
     *
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 沟通任务类型 .
     *
     */
    public String getComTaskType() {
        return comTaskType;
    }

    /**
     * 沟通任务类型 .
     *
     */
    public void setComTaskType(String comTaskType) {
        this.comTaskType = comTaskType == null ? null : comTaskType.trim();
    }

    /**
     * 客户体验次数 .
     *
     */
    public Integer getClientExpNum() {
        return clientExpNum;
    }

    /**
     * 客户体验次数 .
     *
     */
    public void setClientExpNum(Integer clientExpNum) {
        this.clientExpNum = clientExpNum;
    }

    /**
     * 客户邀约次数 .
     *
     */
    public Integer getClientInviteNum() {
        return clientInviteNum;
    }

    /**
     * 客户邀约次数 .
     *
     */
    public void setClientInviteNum(Integer clientInviteNum) {
        this.clientInviteNum = clientInviteNum;
    }

    /**
     * 客户引导次数 .
     *
     */
    public Integer getClientGuidNum() {
        return clientGuidNum;
    }

    /**
     * 客户引导次数 .
     *
     */
    public void setClientGuidNum(Integer clientGuidNum) {
        this.clientGuidNum = clientGuidNum;
    }

    /**
     * 备注 .
     *
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 创建人 .
     *
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 备注 .
     *
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     *  .
     *
     */
    public String getPaCode() {
        return paCode;
    }

    /**
     *  .
     *
     */
    public void setPaCode(String paCode) {
        this.paCode = paCode == null ? null : paCode.trim();
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClientFollow [code=").append(code);
        builder.append(",merchantNo=").append(merchantNo); 
        builder.append(",memberNo=").append(memberNo); 
        builder.append(",memberName=").append(memberName); 
        builder.append(",memberNoGm=").append(memberNoGm); 
        builder.append(",memberNameGm=").append(memberNameGm); 
        builder.append(",cfNo=").append(cfNo); 
        builder.append(",followNum=").append(followNum); 
        builder.append(",followTime=").append(followTime); 
        builder.append(",followType=").append(followType); 
        builder.append(",followInfo=").append(followInfo); 
        builder.append(",notDealReason=").append(notDealReason); 
        builder.append(",deal=").append(deal); 
        builder.append(",status=").append(status); 
        builder.append(",orderAmount=").append(orderAmount); 
        builder.append(",nextDate=").append(nextDate); 
        builder.append(",taskCode=").append(taskCode); 
        builder.append(",taskName=").append(taskName); 
        builder.append(",comTaskType=").append(comTaskType); 
        builder.append(",clientExpNum=").append(clientExpNum); 
        builder.append(",clientInviteNum=").append(clientInviteNum); 
        builder.append(",clientGuidNum=").append(clientGuidNum); 
        builder.append(",remark=").append(remark); 
        builder.append(",createId=").append(createId); 
        builder.append(",createDate=").append(createDate); 
        builder.append(",remark4=").append(remark4); 
        builder.append(",remark3=").append(remark3); 
        builder.append(",remark2=").append(remark2); 
        builder.append(",paCode=").append(paCode); 
        builder.append("]");
        return builder.toString();
    }
}