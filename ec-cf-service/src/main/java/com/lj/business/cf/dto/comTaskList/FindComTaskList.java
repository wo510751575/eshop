package com.lj.business.cf.dto.comTaskList;

import java.io.Serializable;

import com.lj.business.cf.emus.ComTaskType;

/**
 * The Class FindComTaskList.
 */
public class FindComTaskList implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3795020284008380720L;
	

    /**
     * 商户编号(必填) .
     */
    private String merchantNo;

    /**
     * 沟通任务类型(必填)
		完善资料：IMPROVE
		沟通任务：COM_TASK
		引导客户：GUID_PM
		其他：OTHER .
     */
    private ComTaskType comTaskType;


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
	 * Gets the 沟通任务类型 完善资料：IMPROVE 沟通任务：COM_TASK 引导客户：GUID_PM 其他：OTHER .
	 *
	 * @return the 沟通任务类型 完善资料：IMPROVE 沟通任务：COM_TASK 引导客户：GUID_PM 其他：OTHER 
	 */
	public ComTaskType getComTaskType() {
		return comTaskType;
	}

	/**
	 * Sets the 沟通任务类型 完善资料：IMPROVE 沟通任务：COM_TASK 引导客户：GUID_PM 其他：OTHER .
	 *
	 * @param comTaskType the new 沟通任务类型 完善资料：IMPROVE 沟通任务：COM_TASK 引导客户：GUID_PM 其他：OTHER 
	 */
	public void setComTaskType(ComTaskType comTaskType) {
		this.comTaskType = comTaskType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskList [merchantNo=").append(merchantNo)
				.append(", comTaskType=").append(comTaskType).append("]");
		return builder.toString();
	}


}
