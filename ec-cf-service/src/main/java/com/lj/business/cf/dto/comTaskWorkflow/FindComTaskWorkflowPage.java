package com.lj.business.cf.dto.comTaskWorkflow;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindComTaskWorkflowPage.
 */
public class FindComTaskWorkflowPage extends PageParamEntity { 

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3297201841428570946L;
	/**
     * CODE .
     */
    private String code;
    
    /**
     * merchantNo .
     */
    private String merchantNo;

    /**
     * 项目CODE .
     */
    private String codeList;
    
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
	 * Gets the merchantNo .
	 *
	 * @return the merchantNo 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the merchantNo .
	 *
	 * @param merchantNo the new merchantNo 
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskWorkflow [code=").append(code).append("]");
		return builder.toString();
	}
}
