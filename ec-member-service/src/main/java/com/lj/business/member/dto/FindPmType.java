package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindPmType.
 */
public class FindPmType implements Serializable {

	
	 /** Generate cron. */
	private static final long serialVersionUID = -6644843124891489727L; 
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
    
    /** 频率  小时. */
    private String freValue;

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
	 * Gets the 导购编号  .
	 *
	 * @return the 导购编号  
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 导购编号  .
	 *
	 * @param memberNo the new 导购编号  
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the 导购姓名 
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberName the new 导购姓名 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the 客户分类名称 .
	 *
	 * @return the 客户分类名称 
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * Sets the 客户分类名称 .
	 *
	 * @param typeName the new 客户分类名称 
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * Gets the 客户分类类型 成单客户：SUCCESS 已放弃客户：GIVE_UP 紧急客户：URGENCY 交叉客户：REPEAT 意向客户：INTENTION 其他：OTHER .
	 *
	 * @return the 客户分类类型 成单客户：SUCCESS 已放弃客户：GIVE_UP 紧急客户：URGENCY 交叉客户：REPEAT 意向客户：INTENTION 其他：OTHER 
	 */
	public String getPmTypeType() {
		return pmTypeType;
	}

	/**
	 * Sets the 客户分类类型 成单客户：SUCCESS 已放弃客户：GIVE_UP 紧急客户：URGENCY 交叉客户：REPEAT 意向客户：INTENTION 其他：OTHER .
	 *
	 * @param pmTypeType the new 客户分类类型 成单客户：SUCCESS 已放弃客户：GIVE_UP 紧急客户：URGENCY 交叉客户：REPEAT 意向客户：INTENTION 其他：OTHER 
	 */
	public void setPmTypeType(String pmTypeType) {
		this.pmTypeType = pmTypeType;
	}

	/**
	 * Gets the 客户分类维度 商户：MERCHANT 导购：GUID .
	 *
	 * @return the 客户分类维度 商户：MERCHANT 导购：GUID 
	 */
	public String getPmTypeDim() {
		return pmTypeDim;
	}

	/**
	 * Sets the 客户分类维度 商户：MERCHANT 导购：GUID .
	 *
	 * @param pmTypeDim the new 客户分类维度 商户：MERCHANT 导购：GUID 
	 */
	public void setPmTypeDim(String pmTypeDim) {
		this.pmTypeDim = pmTypeDim;
	}

	/**
	 * Gets the 状态 启用：Y 停用：N .
	 *
	 * @return the 状态 启用：Y 停用：N 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the 状态 启用：Y 停用：N .
	 *
	 * @param status the new 状态 启用：Y 停用：N 
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * Gets the 频率  小时.
	 *
	 * @return the 频率  小时
	 */
	public String getFreValue() {
		return freValue;
	}

	/**
	 * Sets the 频率  小时.
	 *
	 * @param freValue the new 频率  小时
	 */
	public void setFreValue(String freValue) {
		this.freValue = freValue;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmType [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", typeName=").append(typeName)
				.append(", pmTypeType=").append(pmTypeType)
				.append(", pmTypeDim=").append(pmTypeDim).append(", status=")
				.append(status).append(", createId=").append(createId)
				.append(", createDate=").append(createDate)
				.append(", freValue=").append(freValue).append(", remark=")
				.append(remark).append(", remark2=").append(remark2)
				.append(", remark3=").append(remark3).append(", remark4=")
				.append(remark4).append("]");
		return builder.toString();
	}

}
