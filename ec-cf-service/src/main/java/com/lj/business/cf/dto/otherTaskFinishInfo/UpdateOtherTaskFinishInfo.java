package com.lj.business.cf.dto.otherTaskFinishInfo;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateOtherTaskFinishInfo.
 */
public class UpdateOtherTaskFinishInfo implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7496760728702803202L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 店长任务设置明细表CODE .
     */
    private String codeTssd;

    /**
     * 店长任务设置表CODE .
     */
    private String codeTss;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 店长编号 .
     */
    private String memberNoSp;

    /**
     * 店长姓名 .
     */
    private String memberNameSp;
    
    /**
     * 分店名称 .
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
     * 月数量 .
     */
    private Long numMonth;

    /**
     * 日均数量 .
     */
    private Long numDay;

    /**
     * 完成数量 .
     */
    private Long numFinish;

    /**
     * 任务日期 .
     */
    private Date datSt;

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
     * 备注 .
     */
    private String remark;
    
    /** 任务单位. */
    private String taskUnit;
    
    /** 任务名称. */
    private String taskName;

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
	 * Gets the code tssd.
	 *
	 * @return the code tssd
	 */
	public String getCodeTssd() {
		return codeTssd;
	}

	/**
	 * Sets the code tssd.
	 *
	 * @param codeTssd the new code tssd
	 */
	public void setCodeTssd(String codeTssd) {
		this.codeTssd = codeTssd;
	}

	/**
	 * Gets the code tss.
	 *
	 * @return the code tss
	 */
	public String getCodeTss() {
		return codeTss;
	}

	/**
	 * Sets the code tss.
	 *
	 * @param codeTss the new code tss
	 */
	public void setCodeTss(String codeTss) {
		this.codeTss = codeTss;
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
	 * Gets the member no sp.
	 *
	 * @return the member no sp
	 */
	public String getMemberNoSp() {
		return memberNoSp;
	}

	/**
	 * Sets the member no sp.
	 *
	 * @param memberNoSp the new member no sp
	 */
	public void setMemberNoSp(String memberNoSp) {
		this.memberNoSp = memberNoSp;
	}

	/**
	 * Gets the member name sp.
	 *
	 * @return the member name sp
	 */
	public String getMemberNameSp() {
		return memberNameSp;
	}

	/**
	 * Sets the member name sp.
	 *
	 * @param memberNameSp the new member name sp
	 */
	public void setMemberNameSp(String memberNameSp) {
		this.memberNameSp = memberNameSp;
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
	 * Gets the num month.
	 *
	 * @return the num month
	 */
	public Long getNumMonth() {
		return numMonth;
	}

	/**
	 * Sets the num month.
	 *
	 * @param numMonth the new num month
	 */
	public void setNumMonth(Long numMonth) {
		this.numMonth = numMonth;
	}

	/**
	 * Gets the num day.
	 *
	 * @return the num day
	 */
	public Long getNumDay() {
		return numDay;
	}

	/**
	 * Sets the num day.
	 *
	 * @param numDay the new num day
	 */
	public void setNumDay(Long numDay) {
		this.numDay = numDay;
	}

	/**
	 * Gets the num finish.
	 *
	 * @return the num finish
	 */
	public Long getNumFinish() {
		return numFinish;
	}

	/**
	 * Sets the num finish.
	 *
	 * @param numFinish the new num finish
	 */
	public void setNumFinish(Long numFinish) {
		this.numFinish = numFinish;
	}

	/**
	 * Gets the dat st.
	 *
	 * @return the dat st
	 */
	public Date getDatSt() {
		return datSt;
	}

	/**
	 * Sets the dat st.
	 *
	 * @param datSt the new dat st
	 */
	public void setDatSt(Date datSt) {
		this.datSt = datSt;
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
	 * Gets the remark 4.
	 *
	 * @return the remark 4
	 */
	public String getRemark4() {
		return remark4;
	}

	/**
	 * Sets the remark 4.
	 *
	 * @param remark4 the new remark 4
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	/**
	 * Gets the remark 3.
	 *
	 * @return the remark 3
	 */
	public String getRemark3() {
		return remark3;
	}

	/**
	 * Sets the remark 3.
	 *
	 * @param remark3 the new remark 3
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	/**
	 * Gets the remark 2.
	 *
	 * @return the remark 2
	 */
	public String getRemark2() {
		return remark2;
	}

	/**
	 * Sets the remark 2.
	 *
	 * @param remark2 the new remark 2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
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
	 * Gets the shop no.
	 *
	 * @return the shop no
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the shop no.
	 *
	 * @param shopNo the new shop no
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the shop name.
	 *
	 * @return the shop name
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the shop name.
	 *
	 * @param shopName the new shop name
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	/**
	 * Gets the task unit.
	 *
	 * @return the task unit
	 */
	public String getTaskUnit() {
		return taskUnit;
	}

	/**
	 * Sets the task unit.
	 *
	 * @param taskUnit the new task unit
	 */
	public void setTaskUnit(String taskUnit) {
		this.taskUnit = taskUnit;
	}
	
	/**
	 * Gets the task name.
	 *
	 * @return the task name
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the task name.
	 *
	 * @param taskName the new task name
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateOtherTaskFinishInfo [code=").append(code)
				.append(", codeTssd=").append(codeTssd).append(", codeTss=")
				.append(codeTss).append(", merchantNo=").append(merchantNo)
				.append(", memberNoSp=").append(memberNoSp)
				.append(", memberNameSp=").append(memberNameSp)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", numMonth=").append(numMonth).append(", numDay=")
				.append(numDay).append(", numFinish=").append(numFinish)
				.append(", datSt=").append(datSt).append(", createId=")
				.append(createId).append(", createDate=").append(createDate)
				.append(", remark4=").append(remark4).append(", remark3=")
				.append(remark3).append(", remark2=").append(remark2)
				.append(", remark=").append(remark).append(", taskUnit=")
				.append(taskUnit).append(", taskName=").append(taskName)
				.append("]");
		return builder.toString();
	}

}
