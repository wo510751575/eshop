package com.lj.business.cm.dto.merchantParams;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindMerchantParamsPageReturn.
 */
public class FindMerchantParamsPageReturn implements Serializable { 

	
	 /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2394238830292161760L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 商户名称 .
     */
    private String merchantName;

    /**
     * 系统参数名 .
     */
    private String sysParamName;

    /**
     * 分组信息 .
     */
    private String groupName;

    /**
     * 系统参数值 .
     */
    private String sysParamValue;

    /**
     * 参数信息备注 .
     */
    private String remark;

    /**
     * 是否只有运维能修改，0代表业务也能修改，1代表只有运维能修改 .
     */
    private String onlyAdminModify;

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
	 * Gets the 商户名称 .
	 *
	 * @return the 商户名称 
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * Sets the 商户名称 .
	 *
	 * @param merchantName the new 商户名称 
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * Gets the 系统参数名 .
	 *
	 * @return the 系统参数名 
	 */
	public String getSysParamName() {
		return sysParamName;
	}

	/**
	 * Sets the 系统参数名 .
	 *
	 * @param sysParamName the new 系统参数名 
	 */
	public void setSysParamName(String sysParamName) {
		this.sysParamName = sysParamName;
	}

	/**
	 * Gets the 分组信息 .
	 *
	 * @return the 分组信息 
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Sets the 分组信息 .
	 *
	 * @param groupName the new 分组信息 
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * Gets the 系统参数值 .
	 *
	 * @return the 系统参数值 
	 */
	public String getSysParamValue() {
		return sysParamValue;
	}

	/**
	 * Sets the 系统参数值 .
	 *
	 * @param sysParamValue the new 系统参数值 
	 */
	public void setSysParamValue(String sysParamValue) {
		this.sysParamValue = sysParamValue;
	}

	/**
	 * Gets the 参数信息备注 .
	 *
	 * @return the 参数信息备注 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the 参数信息备注 .
	 *
	 * @param remark the new 参数信息备注 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the 是否只有运维能修改，0代表业务也能修改，1代表只有运维能修改 .
	 *
	 * @return the 是否只有运维能修改，0代表业务也能修改，1代表只有运维能修改 
	 */
	public String getOnlyAdminModify() {
		return onlyAdminModify;
	}

	/**
	 * Sets the 是否只有运维能修改，0代表业务也能修改，1代表只有运维能修改 .
	 *
	 * @param onlyAdminModify the new 是否只有运维能修改，0代表业务也能修改，1代表只有运维能修改 
	 */
	public void setOnlyAdminModify(String onlyAdminModify) {
		this.onlyAdminModify = onlyAdminModify;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMerchantParamsPageReturn [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", merchantName=").append(merchantName)
				.append(", sysParamName=").append(sysParamName)
				.append(", groupName=").append(groupName)
				.append(", sysParamValue=").append(sysParamValue)
				.append(", remark=").append(remark)
				.append(", onlyAdminModify=").append(onlyAdminModify)
				.append("]");
		return builder.toString();
	}
    
}
