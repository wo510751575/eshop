package com.lj.business.member.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class BehaviorInfoPm.
 */
/**
 * 
 * 
 * 类说明：客户动态详情表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 */
public class BehaviorInfoPm {
    /**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String memberNo;

    /**
     * 会员名称 .
     */
    private String memberName;

    /**
     * 动态描述 .
     */
    private String behaviorDesc;

    /**
     * 行为时间 .
     */
    private Date behaviorDate;

    /**
     * 行为类型 .
     */
    private String behaviorCode;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * 备注 .
     */
    private String remark2;

    /**
     * 备注 .
     */
    private String remark3;

    /**
     * 备注 .
     */
    private String remark4;

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
     * 会员号  .
     *
     * @return the member no
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 会员号  .
     *
     * @param memberNo the new member no
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 会员名称 .
     *
     * @return the member name
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 会员名称 .
     *
     * @param memberName the new member name
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 动态描述 .
     *
     * @return the behavior desc
     */
    public String getBehaviorDesc() {
        return behaviorDesc;
    }

    /**
     * 动态描述 .
     *
     * @param behaviorDesc the new behavior desc
     */
    public void setBehaviorDesc(String behaviorDesc) {
        this.behaviorDesc = behaviorDesc == null ? null : behaviorDesc.trim();
    }

    /**
     * 行为时间 .
     *
     * @return the behavior date
     */
    public Date getBehaviorDate() {
        return behaviorDate;
    }

    /**
     * 行为时间 .
     *
     * @param behaviorDate the new behavior date
     */
    public void setBehaviorDate(Date behaviorDate) {
        this.behaviorDate = behaviorDate;
    }

    /**
     * 行为类型 .
     *
     * @return the behavior code
     */
    public String getBehaviorCode() {
        return behaviorCode;
    }

    /**
     * 行为类型 .
     *
     * @param behaviorCode the new behavior code
     */
    public void setBehaviorCode(String behaviorCode) {
        this.behaviorCode = behaviorCode == null ? null : behaviorCode.trim();
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
     * 输出BEAN数据信息.
     *
     * @author LeoPeng
     * @return the string
     */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BehaviorInfoPm [code=").append(code)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", behaviorDesc=")
				.append(behaviorDesc).append(", behaviorDate=")
				.append(behaviorDate).append(", behaviorCode=")
				.append(behaviorCode).append(", createDate=")
				.append(createDate).append(", remark=").append(remark)
				.append(", remark2=").append(remark2).append(", remark3=")
				.append(remark3).append(", remark4=").append(remark4)
				.append("]");
		return builder.toString();
	}
}