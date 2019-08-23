package com.lj.business.cf.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class OtherTaskFinishInfo.
 */
public class OtherTaskFinishInfo {
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
    
    /**  任务名称. */
    private String taskName;

    /**
     * CODE .
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 店长任务设置明细表CODE .
     *
     * @return the code tssd
     */
    public String getCodeTssd() {
        return codeTssd;
    }

    /**
     * 店长任务设置明细表CODE .
     *
     * @param codeTssd the new code tssd
     */
    public void setCodeTssd(String codeTssd) {
        this.codeTssd = codeTssd == null ? null : codeTssd.trim();
    }

    /**
     * 店长任务设置表CODE .
     *
     * @return the code tss
     */
    public String getCodeTss() {
        return codeTss;
    }

    /**
     * 店长任务设置表CODE .
     *
     * @param codeTss the new code tss
     */
    public void setCodeTss(String codeTss) {
        this.codeTss = codeTss == null ? null : codeTss.trim();
    }

    /**
     * 商户编号 .
     *
     * @return the merchant no
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     * @param merchantNo the new merchant no
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 店长编号 .
     *
     * @return the member no sp
     */
    public String getMemberNoSp() {
        return memberNoSp;
    }

    /**
     * 店长编号 .
     *
     * @param memberNoSp the new member no sp
     */
    public void setMemberNoSp(String memberNoSp) {
        this.memberNoSp = memberNoSp == null ? null : memberNoSp.trim();
    }

    /**
     * 店长姓名 .
     *
     * @return the member name sp
     */
    public String getMemberNameSp() {
        return memberNameSp;
    }

    /**
     * 店长姓名 .
     *
     * @param memberNameSp the new member name sp
     */
    public void setMemberNameSp(String memberNameSp) {
        this.memberNameSp = memberNameSp == null ? null : memberNameSp.trim();
    }

    /**
     * 分店名称 .
     *
     * @return the shop no
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * 分店名称 .
     *
     * @param shopNo the new shop no
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    /**
     * 分店名称 .
     *
     * @return the shop name
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 分店名称 .
     *
     * @param shopName the new shop name
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 导购编号 .
     *
     * @return the member no gm
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * 导购编号 .
     *
     * @param memberNoGm the new member no gm
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the member name gm
     */
    public String getMemberNameGm() {
        return memberNameGm;
    }

    /**
     * 导购姓名 .
     *
     * @param memberNameGm the new member name gm
     */
    public void setMemberNameGm(String memberNameGm) {
        this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
    }

    /**
     * 月数量 .
     *
     * @return the num month
     */
    public Long getNumMonth() {
        return numMonth;
    }

    /**
     * 月数量 .
     *
     * @param numMonth the new num month
     */
    public void setNumMonth(Long numMonth) {
        this.numMonth = numMonth;
    }

    /**
     * 日均数量 .
     *
     * @return the num day
     */
    public Long getNumDay() {
        return numDay;
    }

    /**
     * 日均数量 .
     *
     * @param numDay the new num day
     */
    public void setNumDay(Long numDay) {
        this.numDay = numDay;
    }

    /**
     * 完成数量 .
     *
     * @return the num finish
     */
    public Long getNumFinish() {
        return numFinish;
    }

    /**
     * 完成数量 .
     *
     * @param numFinish the new num finish
     */
    public void setNumFinish(Long numFinish) {
        this.numFinish = numFinish;
    }

    /**
     * 任务日期 .
     *
     * @return the dat st
     */
    public Date getDatSt() {
        return datSt;
    }

    /**
     * 任务日期 .
     *
     * @param datSt the new dat st
     */
    public void setDatSt(Date datSt) {
        this.datSt = datSt;
    }

    /**
     * 创建人 .
     *
     * @return the creates the id
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new creates the id
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the creates the date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new creates the date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 备注 .
     *
     * @return the remark 4
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     * @param remark4 the new remark 4
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 3
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     * @param remark3 the new remark 3
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     * @param remark2 the new remark 2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
		builder.append("OtherTaskFinishInfo [code=").append(code)
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