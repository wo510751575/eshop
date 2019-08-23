package com.lj.business.cf.dto.pmAbandon;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindPmAbandonPageReturn.
 */
public class FindPmAbandonListReturn implements Serializable {

	/** Generate cron. */
	private static final long serialVersionUID = -5034711913745472606L;

	/**
	 * CODE .
	 */
	private String code;

	/**
	 * 商户编号 .
	 */
	private String merchantNo;

	/**
	 * 导购编号 .
	 */
	private String memberNoGm;

	/**
	 * 导购姓名 .
	 */
	private String memberNameGm;

	/**
	 * 客户编号 .
	 */
	private String memberNo;

	/**
	 * 客户名称 .
	 */
	private String memberName;

	/**
	 * 放弃原因 .
	 */
	private String resean;

	/**
	 * 回访时间 .
	 */
	private Date followDate;

	/**
	 * 审批时间 .
	 */
	private Date checkDate;

	/**
	 * 审批人编号 .
	 */
	private String memberNoCheck;

	/**
	 * 审批人姓名 .
	 */
	private String checker;

	/**
	 * 审批说明 .
	 */
	private String checkDes;

	/**
	 * 审批结果 等待审批：WAIT 同意：Y 拒绝：N .
	 */
	private String checkResult;

	/** 跟踪总表编号. */
	private String cfNo;

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

	/** 产品code. */
	private String bomCode;

	/** 产品名称. */
	private String bomName;
	
	/** 跟踪次数. */
	private String followNum;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the merchant no.
	 *
	 * @return the merchant no
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the merchant no.
	 *
	 * @param merchantNo the new merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the member no gm.
	 *
	 * @return the member no gm
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the member no gm.
	 *
	 * @param memberNoGm the new member no gm
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the member name gm.
	 *
	 * @return the member name gm
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the member name gm.
	 *
	 * @param memberNameGm the new member name gm
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the member no.
	 *
	 * @return the member no
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the member no.
	 *
	 * @param memberNo the new member no
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the member name.
	 *
	 * @return the member name
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the member name.
	 *
	 * @param memberName the new member name
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the resean.
	 *
	 * @return the resean
	 */
	public String getResean() {
		return resean;
	}

	/**
	 * Sets the resean.
	 *
	 * @param resean the new resean
	 */
	public void setResean(String resean) {
		this.resean = resean;
	}

	/**
	 * Gets the follow date.
	 *
	 * @return the follow date
	 */
	public Date getFollowDate() {
		return followDate;
	}

	/**
	 * Sets the follow date.
	 *
	 * @param followDate the new follow date
	 */
	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}

	/**
	 * Gets the check date.
	 *
	 * @return the check date
	 */
	public Date getCheckDate() {
		return checkDate;
	}

	/**
	 * Sets the check date.
	 *
	 * @param checkDate the new check date
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	/**
	 * Gets the member no check.
	 *
	 * @return the member no check
	 */
	public String getMemberNoCheck() {
		return memberNoCheck;
	}

	/**
	 * Sets the member no check.
	 *
	 * @param memberNoCheck the new member no check
	 */
	public void setMemberNoCheck(String memberNoCheck) {
		this.memberNoCheck = memberNoCheck;
	}

	/**
	 * Gets the checker.
	 *
	 * @return the checker
	 */
	public String getChecker() {
		return checker;
	}

	/**
	 * Sets the checker.
	 *
	 * @param checker the new checker
	 */
	public void setChecker(String checker) {
		this.checker = checker;
	}

	/**
	 * Gets the check des.
	 *
	 * @return the check des
	 */
	public String getCheckDes() {
		return checkDes;
	}

	/**
	 * Sets the check des.
	 *
	 * @param checkDes the new check des
	 */
	public void setCheckDes(String checkDes) {
		this.checkDes = checkDes;
	}

	/**
	 * Gets the check result.
	 *
	 * @return the check result
	 */
	public String getCheckResult() {
		return checkResult;
	}

	/**
	 * Sets the check result.
	 *
	 * @param checkResult the new check result
	 */
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
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
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the creates the id.
	 *
	 * @return the creates the id
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the creates the id.
	 *
	 * @param createId the new creates the id
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the update id.
	 *
	 * @return the update id
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * Sets the update id.
	 *
	 * @param updateId the new update id
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * Gets the update date.
	 *
	 * @return the update date
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Sets the update date.
	 *
	 * @param updateDate the new update date
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * Gets the bom code.
	 *
	 * @return the bom code
	 */
	public String getBomCode() {
		return bomCode;
	}

	/**
	 * Sets the bom code.
	 *
	 * @param bomCode the new bom code
	 */
	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}

	/**
	 * Gets the bom name.
	 *
	 * @return the bom name
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * Sets the bom name.
	 *
	 * @param bomName the new bom name
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName;
	}

	/**
	 * Gets the follow num.
	 *
	 * @return the follow num
	 */
	public String getFollowNum() {
		return followNum;
	}

	/**
	 * Sets the follow num.
	 *
	 * @param followNum the new follow num
	 */
	public void setFollowNum(String followNum) {
		this.followNum = followNum;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmAbandonListReturn [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", resean=").append(resean)
				.append(", followDate=").append(followDate)
				.append(", checkDate=").append(checkDate)
				.append(", memberNoCheck=").append(memberNoCheck)
				.append(", checker=").append(checker).append(", checkDes=")
				.append(checkDes).append(", checkResult=").append(checkResult)
				.append(", cfNo=").append(cfNo).append(", remark=")
				.append(remark).append(", createId=").append(createId)
				.append(", createDate=").append(createDate)
				.append(", updateId=").append(updateId).append(", updateDate=")
				.append(updateDate).append(", bomCode=").append(bomCode)
				.append(", bomName=").append(bomName).append(", followNum=")
				.append(followNum).append("]");
		return builder.toString();
	}

}
