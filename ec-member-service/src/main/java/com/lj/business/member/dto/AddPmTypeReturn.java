package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class AddPmTypeReturn.
 */
public class AddPmTypeReturn implements Serializable {

	
	 /** Generate cron. */
	private static final long serialVersionUID = -2884679863790689514L; 
	/**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
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
     * 客户数量 .
     */
    private Integer pmNum;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

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
	 * Gets the 会员号  .
	 *
	 * @return the 会员号  
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param merchantNo the new 会员号  
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
	 * Gets the 客户数量 .
	 *
	 * @return the 客户数量 
	 */
	public Integer getPmNum() {
		return pmNum;
	}

	/**
	 * Sets the 客户数量 .
	 *
	 * @param pmNum the new 客户数量 
	 */
	public void setPmNum(Integer pmNum) {
		this.pmNum = pmNum;
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
		return "AddPmType [code=" + code + ", merchantNo=" + merchantNo
				+ ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", typeName=" + typeName + ", pmNum=" + pmNum + ", createId="
				+ createId + ", createDate=" + createDate + "]";
	}
    
}
