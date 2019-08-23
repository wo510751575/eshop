package com.lj.business.cf.dto.pmAbandon;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class UpdatePmAbandon.
 */
public class UpdatePmAbandon implements Serializable { 


    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5128832928252474930L;

	/**

     * CODE .
     */
    private String code;

    
    /** 商户编号. */
    private String merchantNo;
    
    /**
     * 导购编号 .
     */
    private String memberNoGm;
    
    /** 审批人会员编号. */
    private String memberNoCheck;
    

	/**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 放弃原因 .
     */
    private String resean;

    /**
     * 回访时间 .
     */
    private Date followDate;
    
    /**
     * 跟踪总表编号
     */
    private String cfNo;

    /**
     * 审批时间 .
     */
    private Date checkDate;

    /**
     * 审批人 .
     */
    private String checker;

    /**
     * 审批说明 .
     */
    private String checkDes;

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
     * 更新人 .
     */
    private String updateId;

    /**
     * 更新时间 .
     */
    private Date updateDate;
    
    /**
     * 产品code
     */
    private String bomCode;
    
    /**
     * 产品名称
     */
    private String bomName;

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
	 * Gets the 商户编号.
	 *
	 * @return the 商户编号
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号.
	 *
	 * @param merchantNo the new 商户编号
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
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
	 * Gets the 审批人会员编号.
	 *
	 * @return the 审批人会员编号
	 */
	public String getMemberNoCheck() {
		return memberNoCheck;
	}

	/**
	 * Sets the 审批人会员编号.
	 *
	 * @param memberNoCheck the new 审批人会员编号
	 */
	public void setMemberNoCheck(String memberNoCheck) {
		this.memberNoCheck = memberNoCheck;
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
	 * Gets the 放弃原因 .
	 *
	 * @return the 放弃原因 
	 */
	public String getResean() {
		return resean;
	}

	/**
	 * Sets the 放弃原因 .
	 *
	 * @param resean the new 放弃原因 
	 */
	public void setResean(String resean) {
		this.resean = resean;
	}

	/**
	 * Gets the 回访时间 .
	 *
	 * @return the 回访时间 
	 */
	public Date getFollowDate() {
		return followDate;
	}

	/**
	 * Sets the 回访时间 .
	 *
	 * @param followDate the new 回访时间 
	 */
	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}

	/**
	 * Gets the 审批时间 .
	 *
	 * @return the 审批时间 
	 */
	public Date getCheckDate() {
		return checkDate;
	}

	/**
	 * Sets the 审批时间 .
	 *
	 * @param checkDate the new 审批时间 
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	/**
	 * Gets the 审批人 .
	 *
	 * @return the 审批人 
	 */
	public String getChecker() {
		return checker;
	}

	/**
	 * Sets the 审批人 .
	 *
	 * @param checker the new 审批人 
	 */
	public void setChecker(String checker) {
		this.checker = checker;
	}

	/**
	 * Gets the 审批说明 .
	 *
	 * @return the 审批说明 
	 */
	public String getCheckDes() {
		return checkDes;
	}

	/**
	 * Sets the 审批说明 .
	 *
	 * @param checkDes the new 审批说明 
	 */
	public void setCheckDes(String checkDes) {
		this.checkDes = checkDes;
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
	 * Gets the 更新人 .
	 *
	 * @return the 更新人 
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * Sets the 更新人 .
	 *
	 * @param updateId the new 更新人 
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * Gets the 更新时间 .
	 *
	 * @return the 更新时间 
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Sets the 更新时间 .
	 *
	 * @param updateDate the new 更新时间 
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public String getCfNo() {
		return cfNo;
	}

	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}
	
	public String getBomCode() {
		return bomCode;
	}

	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}

	public String getBomName() {
		return bomName;
	}

	public void setBomName(String bomName) {
		this.bomName = bomName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdatePmAbandon [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNoCheck=").append(memberNoCheck)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", resean=").append(resean).append(", followDate=")
				.append(followDate).append(", cfNo=").append(cfNo)
				.append(", checkDate=").append(checkDate).append(", checker=")
				.append(checker).append(", checkDes=").append(checkDes)
				.append(", remark=").append(remark).append(", createId=")
				.append(createId).append(", createDate=").append(createDate)
				.append(", updateId=").append(updateId).append(", updateDate=")
				.append(updateDate).append(", bomCode=").append(bomCode)
				.append(", bomName=").append(bomName).append("]");
		return builder.toString();
	}

}
