package com.lj.business.cf.dto.comTaskChoose;

import java.io.Serializable;

/**
 * The Class FindComTaskChoose.
 */
public class FindComTaskChoose implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6808650607364395319L;
	
	
	/**
     * CODE(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) .
     */
    private String code;

    /**
     * 商户编号(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) .
     */
    private String merchantNo;
	
    
    /**
     * 沟通任务类型(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) .
     */
    private String comTaskType;


	/**
	 * Gets the cODE(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) .
	 *
	 * @return the cODE(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) 
	 */
	public String getCode() {
		return code;
	}


	/**
	 * Sets the cODE(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) .
	 *
	 * @param code the new cODE(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) 
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * Gets the 商户编号(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) .
	 *
	 * @return the 商户编号(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}


	/**
	 * Sets the 商户编号(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) .
	 *
	 * @param merchantNo the new 商户编号(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}


	/**
	 * Gets the 沟通任务类型(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) .
	 *
	 * @return the 沟通任务类型(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) 
	 */
	public String getComTaskType() {
		return comTaskType;
	}


	/**
	 * Sets the 沟通任务类型(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) .
	 *
	 * @param comTaskType the new 沟通任务类型(必填,CODE 或者 (merchantNo && comTaskType) 2选一 ) 
	 */
	public void setComTaskType(String comTaskType) {
		this.comTaskType = comTaskType;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskChoose [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", comTaskType=").append(comTaskType).append("]");
		return builder.toString();
	}

}
