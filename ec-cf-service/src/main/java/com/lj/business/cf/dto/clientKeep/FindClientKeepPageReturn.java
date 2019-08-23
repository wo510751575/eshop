package com.lj.business.cf.dto.clientKeep;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindClientKeepPageReturn.
 */
public class FindClientKeepPageReturn implements Serializable {
	
	 /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1006216136908178045L;

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
     * 维护编号 .
     */
    private String ckNo;

    /**
     * 维护次数 .
     */
    private Integer keepNum;

    /**
     * 维护时间 .
     */
    private Date keepTime;

    /**
     * 维护类型 .
     */
    private String keepType;

    /**
     * 维护结果 .
     */
    private String keepContent;

    /**
     * 下次维护提醒时间 .
     */
    private Date nextDate;

    /**
     * 是否再次购买
             是:Y
             否:N .
     */
    private String buy;

    /**
     * 所需产品CODE .
     */
    private String bomCode;

    /**
     * 产品名称 .
     */
    private String bomName;

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
	 * Gets the 维护编号 .
	 *
	 * @return the 维护编号 
	 */
	public String getCkNo() {
		return ckNo;
	}

	/**
	 * Sets the 维护编号 .
	 *
	 * @param ckNo the new 维护编号 
	 */
	public void setCkNo(String ckNo) {
		this.ckNo = ckNo;
	}

	/**
	 * Gets the 维护次数 .
	 *
	 * @return the 维护次数 
	 */
	public Integer getKeepNum() {
		return keepNum;
	}

	/**
	 * Sets the 维护次数 .
	 *
	 * @param keepNum the new 维护次数 
	 */
	public void setKeepNum(Integer keepNum) {
		this.keepNum = keepNum;
	}

	/**
	 * Gets the 维护时间 .
	 *
	 * @return the 维护时间 
	 */
	public Date getKeepTime() {
		return keepTime;
	}

	/**
	 * Sets the 维护时间 .
	 *
	 * @param keepTime the new 维护时间 
	 */
	public void setKeepTime(Date keepTime) {
		this.keepTime = keepTime;
	}

	/**
	 * Gets the 维护类型 .
	 *
	 * @return the 维护类型 
	 */
	public String getKeepType() {
		return keepType;
	}

	/**
	 * Sets the 维护类型 .
	 *
	 * @param keepType the new 维护类型 
	 */
	public void setKeepType(String keepType) {
		this.keepType = keepType;
	}

	/**
	 * Gets the 维护结果 .
	 *
	 * @return the 维护结果 
	 */
	public String getKeepContent() {
		return keepContent;
	}

	/**
	 * Sets the 维护结果 .
	 *
	 * @param keepContent the new 维护结果 
	 */
	public void setKeepContent(String keepContent) {
		this.keepContent = keepContent;
	}

	/**
	 * Gets the 下次维护提醒时间 .
	 *
	 * @return the 下次维护提醒时间 
	 */
	public Date getNextDate() {
		return nextDate;
	}

	/**
	 * Sets the 下次维护提醒时间 .
	 *
	 * @param nextDate the new 下次维护提醒时间 
	 */
	public void setNextDate(Date nextDate) {
		this.nextDate = nextDate;
	}

	/**
	 * Gets the 是否再次购买 是:Y 否:N .
	 *
	 * @return the 是否再次购买 是:Y 否:N 
	 */
	public String getBuy() {
		return buy;
	}

	/**
	 * Sets the 是否再次购买 是:Y 否:N .
	 *
	 * @param buy the new 是否再次购买 是:Y 否:N 
	 */
	public void setBuy(String buy) {
		this.buy = buy;
	}

	/**
	 * Gets the 所需产品CODE .
	 *
	 * @return the 所需产品CODE 
	 */
	public String getBomCode() {
		return bomCode;
	}

	/**
	 * Sets the 所需产品CODE .
	 *
	 * @param bomCode the new 所需产品CODE 
	 */
	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}

	/**
	 * Gets the 产品名称 .
	 *
	 * @return the 产品名称 
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * Sets the 产品名称 .
	 *
	 * @param bomName the new 产品名称 
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindClientKeepPageReturn [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", ckNo=").append(ckNo).append(", keepNum=")
				.append(keepNum).append(", keepType=").append(keepType)
				.append(", keepContent=").append(keepContent).append(", buy=")
				.append(buy).append(", bomCode=").append(bomCode)
				.append(", bomName=").append(bomName).append(", remark=")
				.append(remark).append(", createId=").append(createId)
				.append(", remark4=").append(remark4).append(", remark3=")
				.append(remark3).append(", remark2=").append(remark2)
				.append("]");
		return builder.toString();
	}

}
