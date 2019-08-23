package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class DelTaskSet.
 */
public class DelTaskSet implements Serializable {

	
	 /** Generate cron. */
	private static final long serialVersionUID = -1519713979486798941L; 
    /**
     * CODE .
     */
    private String code;

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
     * 月数量 .
     */
    private Long numMonth;

    /**
     * 会员号列表，逗号分隔 .
     */
    private String memberNoList;

    /**
     * 会员名称列表，逗号分隔 .
     */
    private String memberNameList;

    /**
     * 日均数量 .
     */
    private Long numDay;

    /**
     * 客户数量 .
     */
    private Long numPm;

    /**
     * 年份 .
     */
    private Integer year;

    /**
     * 月份 .
     */
    private Integer month;

    /**
     * 任务详情 .
     */
    private String content;

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

    /**
     * CODE .
     *
     * @return the cODE 
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new cODE 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商户编号 .
     *
     * @return the 商户编号 
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     * @param merchantNo the new 商户编号 
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 店长编号 .
     *
     * @return the 店长编号 
     */
    public String getMemberNoSp() {
        return memberNoSp;
    }

    /**
     * 店长编号 .
     *
     * @param memberNoSp the new 店长编号 
     */
    public void setMemberNoSp(String memberNoSp) {
        this.memberNoSp = memberNoSp == null ? null : memberNoSp.trim();
    }

    /**
     * 店长姓名 .
     *
     * @return the 店长姓名 
     */
    public String getMemberNameSp() {
        return memberNameSp;
    }

    /**
     * 店长姓名 .
     *
     * @param memberNameSp the new 店长姓名 
     */
    public void setMemberNameSp(String memberNameSp) {
        this.memberNameSp = memberNameSp == null ? null : memberNameSp.trim();
    }

    /**
     * 月数量 .
     *
     * @return the 月数量 
     */
    public Long getNumMonth() {
        return numMonth;
    }

    /**
     * 月数量 .
     *
     * @param numMonth the new 月数量 
     */
    public void setNumMonth(Long numMonth) {
        this.numMonth = numMonth;
    }

    /**
     * 会员号列表，逗号分隔 .
     *
     * @return the 会员号列表，逗号分隔 
     */
    public String getMemberNoList() {
        return memberNoList;
    }

    /**
     * 会员号列表，逗号分隔 .
     *
     * @param memberNoList the new 会员号列表，逗号分隔 
     */
    public void setMemberNoList(String memberNoList) {
        this.memberNoList = memberNoList == null ? null : memberNoList.trim();
    }

    /**
     * 会员名称列表，逗号分隔 .
     *
     * @return the 会员名称列表，逗号分隔 
     */
    public String getMemberNameList() {
        return memberNameList;
    }

    /**
     * 会员名称列表，逗号分隔 .
     *
     * @param memberNameList the new 会员名称列表，逗号分隔 
     */
    public void setMemberNameList(String memberNameList) {
        this.memberNameList = memberNameList == null ? null : memberNameList.trim();
    }

    /**
     * 日均数量 .
     *
     * @return the 日均数量 
     */
    public Long getNumDay() {
        return numDay;
    }

    /**
     * 日均数量 .
     *
     * @param numDay the new 日均数量 
     */
    public void setNumDay(Long numDay) {
        this.numDay = numDay;
    }

    /**
     * 客户数量 .
     *
     * @return the 客户数量 
     */
    public Long getNumPm() {
        return numPm;
    }

    /**
     * 客户数量 .
     *
     * @param numPm the new 客户数量 
     */
    public void setNumPm(Long numPm) {
        this.numPm = numPm;
    }

    /**
     * 年份 .
     *
     * @return the 年份 
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 年份 .
     *
     * @param year the new 年份 
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 月份 .
     *
     * @return the 月份 
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * 月份 .
     *
     * @param month the new 月份 
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * 任务详情 .
     *
     * @return the 任务详情 
     */
    public String getContent() {
        return content;
    }

    /**
     * 任务详情 .
     *
     * @param content the new 任务详情 
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 创建人 .
     *
     * @return the 创建人 
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new 创建人 
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the 创建时间 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new 创建时间 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     * @param remark4 the new 备注 
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     * @param remark3 the new 备注 
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     * @param remark2 the new 备注 
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new 备注 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TaskSet [code=" + code + ", merchantNo=" + merchantNo
				+ ", memberNoSp=" + memberNoSp + ", memberNameSp="
				+ memberNameSp + ", numMonth=" + numMonth + ", memberNoList="
				+ memberNoList + ", memberNameList=" + memberNameList
				+ ", numDay=" + numDay + ", numPm=" + numPm + ", year=" + year
				+ ", month=" + month + ", content=" + content + ", createId="
				+ createId + ", createDate=" + createDate + ", remark4="
				+ remark4 + ", remark3=" + remark3 + ", remark2=" + remark2
				+ ", remark=" + remark + "]";
	}
}
