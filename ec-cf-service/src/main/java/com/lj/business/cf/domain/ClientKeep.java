package com.lj.business.cf.domain;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * 类说明：客户维护记录表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 *
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 * @Company: 领居科技有限公司
 */
public class ClientKeep {
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
     * 是否再次购买             是:Y             否:N .
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
     * 客户编号 .
     *
     * @return the member no
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 客户编号 .
     *
     * @param memberNo the new member no
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 客户名称 .
     *
     * @return the member name
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 客户名称 .
     *
     * @param memberName the new member name
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
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
     * 维护编号 .
     *
     * @return the ck no
     */
    public String getCkNo() {
        return ckNo;
    }

    /**
     * 维护编号 .
     *
     * @param ckNo the new ck no
     */
    public void setCkNo(String ckNo) {
        this.ckNo = ckNo == null ? null : ckNo.trim();
    }

    /**
     * 维护次数 .
     *
     * @return the keep num
     */
    public Integer getKeepNum() {
        return keepNum;
    }

    /**
     * 维护次数 .
     *
     * @param keepNum the new keep num
     */
    public void setKeepNum(Integer keepNum) {
        this.keepNum = keepNum;
    }

    /**
     * 维护时间 .
     *
     * @return the keep time
     */
    public Date getKeepTime() {
        return keepTime;
    }

    /**
     * 维护时间 .
     *
     * @param keepTime the new keep time
     */
    public void setKeepTime(Date keepTime) {
        this.keepTime = keepTime;
    }

    /**
     * 维护类型 .
     *
     * @return the keep type
     */
    public String getKeepType() {
        return keepType;
    }

    /**
     * 维护类型 .
     *
     * @param keepType the new keep type
     */
    public void setKeepType(String keepType) {
        this.keepType = keepType == null ? null : keepType.trim();
    }

    /**
     * 维护结果 .
     *
     * @return the keep content
     */
    public String getKeepContent() {
        return keepContent;
    }

    /**
     * 维护结果 .
     *
     * @param keepContent the new keep content
     */
    public void setKeepContent(String keepContent) {
        this.keepContent = keepContent == null ? null : keepContent.trim();
    }

    /**
     * 下次维护提醒时间 .
     *
     * @return the next date
     */
    public Date getNextDate() {
        return nextDate;
    }

    /**
     * 下次维护提醒时间 .
     *
     * @param nextDate the new next date
     */
    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    /**
     * 是否再次购买
     *              是:Y
     *              否:N .
     *
     * @return the buy
     */
    public String getBuy() {
        return buy;
    }

    /**
     * 是否再次购买
     *              是:Y
     *              否:N .
     *
     * @param buy the new buy
     */
    public void setBuy(String buy) {
        this.buy = buy == null ? null : buy.trim();
    }

    /**
     * 所需产品CODE .
     *
     * @return the bom code
     */
    public String getBomCode() {
        return bomCode;
    }

    /**
     * 所需产品CODE .
     *
     * @param bomCode the new bom code
     */
    public void setBomCode(String bomCode) {
        this.bomCode = bomCode == null ? null : bomCode.trim();
    }

    /**
     * 产品名称 .
     *
     * @return the bom name
     */
    public String getBomName() {
        return bomName;
    }

    /**
     * 产品名称 .
     *
     * @param bomName the new bom name
     */
    public void setBomName(String bomName) {
        this.bomName = bomName == null ? null : bomName.trim();
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
     * 输出BEAN数据信息.
     *
     * @author LeoPeng
     * @return the string
     */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientKeep [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", ckNo=").append(ckNo).append(", keepNum=")
				.append(keepNum).append(", keepTime=").append(keepTime)
				.append(", keepType=").append(keepType)
				.append(", keepContent=").append(keepContent)
				.append(", nextDate=").append(nextDate).append(", buy=")
				.append(buy).append(", bomCode=").append(bomCode)
				.append(", bomName=").append(bomName).append(", remark=")
				.append(remark).append(", createId=").append(createId)
				.append(", createDate=").append(createDate)
				.append(", remark4=").append(remark4).append(", remark3=")
				.append(remark3).append(", remark2=").append(remark2)
				.append("]");
		return builder.toString();
	}
}