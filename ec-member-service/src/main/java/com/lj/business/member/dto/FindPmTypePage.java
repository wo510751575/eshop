package com.lj.business.member.dto;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindPmTypePage.
 */
public class FindPmTypePage extends PageParamEntity {

	
	 /** Generate cron. */
	private static final long serialVersionUID = -2756067738042838562L; 
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
     * 导购编号  .
     *
     * @return the 导购编号  
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 导购编号  .
     *
     * @param memberNo the new 导购编号  
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the 导购姓名 
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 导购姓名 .
     *
     * @param memberName the new 导购姓名 
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 客户分类名称 .
     *
     * @return the 客户分类名称 
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 客户分类名称 .
     *
     * @param typeName the new 客户分类名称 
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 客户分类类型
     * 成单客户：SUCCESS
     * 已放弃客户：GIVE_UP
     * 紧急客户：URGENCY
     * 交叉客户：REPEAT
     * 意向客户：INTENTION
     * 其他：OTHER .
     *
     * @return the 客户分类类型 成单客户：SUCCESS 已放弃客户：GIVE_UP 紧急客户：URGENCY 交叉客户：REPEAT 意向客户：INTENTION 其他：OTHER 
     */
    public String getPmTypeType() {
        return pmTypeType;
    }

    /**
     * 客户分类类型
     * 成单客户：SUCCESS
     * 已放弃客户：GIVE_UP
     * 紧急客户：URGENCY
     * 交叉客户：REPEAT
     * 意向客户：INTENTION
     * 其他：OTHER .
     *
     * @param pmTypeType the new 客户分类类型 成单客户：SUCCESS 已放弃客户：GIVE_UP 紧急客户：URGENCY 交叉客户：REPEAT 意向客户：INTENTION 其他：OTHER 
     */
    public void setPmTypeType(String pmTypeType) {
        this.pmTypeType = pmTypeType == null ? null : pmTypeType.trim();
    }

    /**
     * 客户分类维度 商户：MERCHANT 导购：GUID .
     *
     * @return the 客户分类维度 商户：MERCHANT 导购：GUID 
     */
    public String getPmTypeDim() {
        return pmTypeDim;
    }

    /**
     * 客户分类维度 商户：MERCHANT 导购：GUID .
     *
     * @param pmTypeDim the new 客户分类维度 商户：MERCHANT 导购：GUID 
     */
    public void setPmTypeDim(String pmTypeDim) {
        this.pmTypeDim = pmTypeDim == null ? null : pmTypeDim.trim();
    }

    /**
     * 跟进频率值 单位：小时 .
     *
     * @return the 跟进频率值 单位：小时 
     */
    public String getFreValue() {
        return freValue;
    }

    /**
     * 跟进频率值 单位：小时 .
     *
     * @param freValue the new 跟进频率值 单位：小时 
     */
    public void setFreValue(String freValue) {
        this.freValue = freValue == null ? null : freValue.trim();
    }

    /**
     * 状态
     * 启用：Y
     * 停用：N
     * .
     *
     * @return the 状态 启用：Y 停用：N 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * 启用：Y
     * 停用：N
     * .
     *
     * @param status the new 状态 启用：Y 停用：N 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 输出BEAN数据信息.
     *
     * @return the string
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PmType [code=").append(code);
        builder.append(",merchantNo=").append(merchantNo); 
        builder.append(",memberNo=").append(memberNo); 
        builder.append(",memberName=").append(memberName); 
        builder.append(",typeName=").append(typeName); 
        builder.append(",pmTypeType=").append(pmTypeType); 
        builder.append(",pmTypeDim=").append(pmTypeDim); 
        builder.append(",freValue=").append(freValue); 
        builder.append(",status=").append(status); 
        builder.append(",createId=").append(createId); 
        builder.append(",createDate=").append(createDate); 
        builder.append(",remark=").append(remark); 
        builder.append(",remark2=").append(remark2); 
        builder.append(",remark3=").append(remark3); 
        builder.append(",remark4=").append(remark4); 
        builder.append("]");
        return builder.toString();
    }
}
