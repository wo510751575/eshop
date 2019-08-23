package com.lj.business.cf.dto.workTaskChoose;

import java.io.Serializable;

/**
 * The Class FindWorkTaskChoose.
 */
public class FindWorkTaskChoose implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6348678856876882218L;
	
	 /**
     * CODE(必填,CODE 或者 (merchantNo && taskType) 2选一 ) .
     */
    private String code;

    /**
     * 商户编号(必填,CODE 或者 (merchantNo && taskType) 2选一 ) .
     */
    private String merchantNo;

    
    /**   任务类型  (必填,CODE 或者 (merchantNo && taskType) 2选一 )   
     * 客户沟通：GOU_TONG  销售目标：XIAO_SHOU  新增客户：XIN_ZENG 社交任务：SHE_JIAO. */
    private String taskType;


	/**
	 * Gets the cODE(必填,CODE 或者 (merchantNo && taskType) 2选一 ) .
	 *
	 * @return the cODE(必填,CODE 或者 (merchantNo && taskType) 2选一 ) 
	 */
	public String getCode() {
		return code;
	}


	/**
	 * Sets the cODE(必填,CODE 或者 (merchantNo && taskType) 2选一 ) .
	 *
	 * @param code the new cODE(必填,CODE 或者 (merchantNo && taskType) 2选一 ) 
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * Gets the 商户编号(必填,CODE 或者 (merchantNo && taskType) 2选一 ) .
	 *
	 * @return the 商户编号(必填,CODE 或者 (merchantNo && taskType) 2选一 ) 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}


	/**
	 * Sets the 商户编号(必填,CODE 或者 (merchantNo && taskType) 2选一 ) .
	 *
	 * @param merchantNo the new 商户编号(必填,CODE 或者 (merchantNo && taskType) 2选一 ) 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}


	/**
	 * Gets the 任务类型  (必填,CODE 或者 (merchantNo && taskType) 2选一 ) 客户沟通：GOU_TONG  销售目标：XIAO_SHOU  新增客户：XIN_ZENG 社交任务：SHE_JIAO.
	 *
	 * @return the 任务类型  (必填,CODE 或者 (merchantNo && taskType) 2选一 ) 客户沟通：GOU_TONG  销售目标：XIAO_SHOU  新增客户：XIN_ZENG 社交任务：SHE_JIAO
	 */
	public String getTaskType() {
		return taskType;
	}


	/**
	 * Sets the 任务类型  (必填,CODE 或者 (merchantNo && taskType) 2选一 ) 客户沟通：GOU_TONG  销售目标：XIAO_SHOU  新增客户：XIN_ZENG 社交任务：SHE_JIAO.
	 *
	 * @param taskType the new 任务类型  (必填,CODE 或者 (merchantNo && taskType) 2选一 ) 客户沟通：GOU_TONG  销售目标：XIAO_SHOU  新增客户：XIN_ZENG 社交任务：SHE_JIAO
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindWorkTaskChoose [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", taskType=").append(taskType).append("]");
		return builder.toString();
	}
	
	
	

}
