package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;

/**
 * 
 * 
 * 类说明：查询销售目标和订单
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 领居科技有限公司
 * @author 武鹏飞
 * 
 *         CreateDate: 2017年7月21日
 */
public class FindTaskSetAndOrder implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5278547443592756621L;

	/**
	 * 任务类型 销售目标：XIAO_SHOU 新增客户：XIN_ZENG 其他任务：OTHER
	 */
	private String taskType;

	/**
	 * 商户编号
	 */
	private String merchantNo;

	/**
	 * 导购编号
	 */
	private String memberNoGm;
	
	/**
	 * 开始日期
	 */
	private String startDate;

	/**
	 * 结束日期
	 */
	private String endDate;
	
	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
