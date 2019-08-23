package com.lj.business.member.domain;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * 类说明：客户分类表
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
public class PmType {
	/**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 导购编号  .
     */
    private String memberNo;

    /**
     * 导购姓名 .
     */
    private String memberName;

    /**
     * 客户分类名称 .
     */
    private String typeName;

    /**
     * 客户分类类型
 成单客户：SUCCESS
 已放弃客户：GIVE_UP
 紧急客户：URGENCY
 交叉客户：REPEAT
 意向客户：INTENTION
 其他：OTHER .
     */
    private String pmTypeType;

    /**
     * 客户分类维度 商户：MERCHANT 导购：GUID .
     */
    private String pmTypeDim;

    /**
     * 跟进频率值 单位：小时 .
     */
    private String freValue;

    /**
     * 状态 
             启用：Y
             停用：N
              .
     */
    private String status;
    
    /**
     * 排序 .
     */
    private Integer seq;

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
     * 导购编号  .
     *
     * @return the member no
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 导购编号  .
     *
     * @param memberNo the new member no
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the member name
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 导购姓名 .
     *
     * @param memberName the new member name
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 客户分类名称 .
     *
     * @return the type name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 客户分类名称 .
     *
     * @param typeName the new type name
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 客户分类类型
     *  成单客户：SUCCESS
     *  已放弃客户：GIVE_UP
     *  紧急客户：URGENCY
     *  交叉客户：REPEAT
     *  意向客户：INTENTION
     *  其他：OTHER .
     *
     * @return the pm type type
     */
    public String getPmTypeType() {
        return pmTypeType;
    }

    /**
     * 客户分类类型
     *  成单客户：SUCCESS
     *  已放弃客户：GIVE_UP
     *  紧急客户：URGENCY
     *  交叉客户：REPEAT
     *  意向客户：INTENTION
     *  其他：OTHER .
     *
     * @param pmTypeType the new pm type type
     */
    public void setPmTypeType(String pmTypeType) {
        this.pmTypeType = pmTypeType == null ? null : pmTypeType.trim();
    }

    /**
     * 客户分类维度 商户：MERCHANT 导购：GUID .
     *
     * @return the pm type dim
     */
    public String getPmTypeDim() {
        return pmTypeDim;
    }

    /**
     * 客户分类维度 商户：MERCHANT 导购：GUID .
     *
     * @param pmTypeDim the new pm type dim
     */
    public void setPmTypeDim(String pmTypeDim) {
        this.pmTypeDim = pmTypeDim == null ? null : pmTypeDim.trim();
    }

    /**
     * 跟进频率值 单位：小时 .
     *
     * @return the fre value
     */
    public String getFreValue() {
        return freValue;
    }

    /**
     * 跟进频率值 单位：小时 .
     *
     * @param freValue the new fre value
     */
    public void setFreValue(String freValue) {
        this.freValue = freValue == null ? null : freValue.trim();
    }

    /**
     * 状态 
     *              启用：Y
     *              停用：N
     *               .
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 
     *              启用：Y
     *              停用：N
     *               .
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PmType [code=").append(code).append(", merchantNo=")
				.append(merchantNo).append(", memberNo=").append(memberNo)
				.append(", memberName=").append(memberName)
				.append(", typeName=").append(typeName).append(", pmTypeType=")
				.append(pmTypeType).append(", pmTypeDim=").append(pmTypeDim)
				.append(", freValue=").append(freValue).append(", status=")
				.append(status).append(", seq=").append(seq)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", remark=").append(remark)
				.append(", remark2=").append(remark2).append(", remark3=")
				.append(remark3).append(", remark4=").append(remark4)
				.append("]");
		return builder.toString();
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
}