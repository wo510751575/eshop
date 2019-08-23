package com.lj.business.cf.dto.comTaskWorkflow;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindComTaskWorkflowPageReturn.
 */
public class FindComTaskWorkflowPageReturn implements Serializable { 

	 /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3041205216277902981L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 项目CODE .
     */
    private String codeList;

    /**
     * 项目名称 .
     */
    private String nameList;

    /**
     * 下个项目CODE .
     */
    private String nextCodeList;

    /**
     * 下个项目名称 .
     */
    private String nextNameList;
    /**
     * 是否首节点  是：Y 否：N .
     */
    private String first;

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
	 * Gets the 项目CODE .
	 *
	 * @return the 项目CODE 
	 */
	public String getCodeList() {
		return codeList;
	}

	/**
	 * Sets the 项目CODE .
	 *
	 * @param codeList the new 项目CODE 
	 */
	public void setCodeList(String codeList) {
		this.codeList = codeList;
	}

	/**
	 * Gets the 项目名称 .
	 *
	 * @return the 项目名称 
	 */
	public String getNameList() {
		return nameList;
	}

	/**
	 * Sets the 项目名称 .
	 *
	 * @param nameList the new 项目名称 
	 */
	public void setNameList(String nameList) {
		this.nameList = nameList;
	}

	/**
	 * Gets the 下个项目CODE .
	 *
	 * @return the 下个项目CODE 
	 */
	public String getNextCodeList() {
		return nextCodeList;
	}

	/**
	 * Sets the 下个项目CODE .
	 *
	 * @param nextCodeList the new 下个项目CODE 
	 */
	public void setNextCodeList(String nextCodeList) {
		this.nextCodeList = nextCodeList;
	}

	/**
	 * Gets the 下个项目名称 .
	 *
	 * @return the 下个项目名称 
	 */
	public String getNextNameList() {
		return nextNameList;
	}

	/**
	 * Sets the 下个项目名称 .
	 *
	 * @param nextNameList the new 下个项目名称 
	 */
	public void setNextNameList(String nextNameList) {
		this.nextNameList = nextNameList;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskWorkflowPageReturn [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", codeList=").append(codeList).append(", nameList=")
				.append(nameList).append(", nextCodeList=")
				.append(nextCodeList).append(", nextNameList=")
				.append(nextNameList).append(", first=").append(first)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", remark=").append(remark)
				.append("]");
		return builder.toString();
	}

	/**
	 * Gets the 是否首节点  是：Y 否：N .
	 *
	 * @return the 是否首节点  是：Y 否：N 
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Sets the 是否首节点  是：Y 否：N .
	 *
	 * @param first the new 是否首节点  是：Y 否：N 
	 */
	public void setFirst(String first) {
		this.first = first;
	}
}
