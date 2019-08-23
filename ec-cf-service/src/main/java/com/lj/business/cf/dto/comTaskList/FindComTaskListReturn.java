package com.lj.business.cf.dto.comTaskList;

import java.io.Serializable;

/**
 * The Class FindComTaskListReturn.
 */
public class FindComTaskListReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1735793347369336658L;
	
	
	/**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 项目名称 .
     */
    private String nameList;

    /**
     * 项目描述 .
     */
    private String desList;

    /**
     * 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
     */
    private String comTaskType;

    /**
     * 状态 
             启用：Y
             停用：N
              .
     */
    private String status;

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
	 * Gets the 项目描述 .
	 *
	 * @return the 项目描述 
	 */
	public String getDesList() {
		return desList;
	}

	/**
	 * Sets the 项目描述 .
	 *
	 * @param desList the new 项目描述 
	 */
	public void setDesList(String desList) {
		this.desList = desList;
	}

	/**
	 * Gets the 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
	 *
	 * @return the 沟通任务类型 完善资料：IMPROVE 其他：OTHER 
	 */
	public String getComTaskType() {
		return comTaskType;
	}

	/**
	 * Sets the 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
	 *
	 * @param comTaskType the new 沟通任务类型 完善资料：IMPROVE 其他：OTHER 
	 */
	public void setComTaskType(String comTaskType) {
		this.comTaskType = comTaskType;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskListReturn [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", nameList=").append(nameList).append(", desList=")
				.append(desList).append(", comTaskType=").append(comTaskType)
				.append(", status=").append(status).append("]");
		return builder.toString();
	}
    
    

}
