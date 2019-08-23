package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class AddPmLabel.
 */
public class AddPmLabel implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8504250018727756004L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String merchantNo;

    /**
     * 客户分类名称 .
     */
    private String labelName;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;
    /**
     * 备注
     */
    private String remark;
    
    
    
    
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the cODE .
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 会员号  .
	 *
	 * @return the merchantNo
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param merchantNo the merchantNo to set
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 客户分类名称 .
	 *
	 * @return the labelName
	 */
	public String getLabelName() {
		return labelName;
	}

	/**
	 * Sets the 客户分类名称 .
	 *
	 * @param labelName the labelName to set
	 */
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	/**
	 * Gets the 创建人 .
	 *
	 * @return the createId
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the 创建人 .
	 *
	 * @param createId the createId to set
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the 创建时间 .
	 *
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "AddPmLabel [code=" + code + ", merchantNo=" + merchantNo
				+ ", labelName=" + labelName + ", createId=" + createId
				+ ", createDate=" + createDate + ", remark=" + remark + "]";
	}
    
    
}
