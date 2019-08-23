package com.lj.business.cf.dto.comTaskChoose;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindComTaskChooseIndex.
 */
public class FindComTaskChooseIndex implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2591822795984319884L;
	

    /**
     * 商户编号(必填) .
     */
    private String merchantNo;
    
    /**
     * 导购编号(必填)  .
     */
    private String memberNoGm;
    
    /**
     * 工作日期_开始 .
     */
    private Date workDateStart;
    
    /**
     * 工作日期_结束 .
     */
    private Date workDateEnd;
    
    /**
     * 查询模式，默认当前
     * 当前：NOW
     * 累计欠：DIS .
     */
    private String flag = "NOW";


	/**
	 * Gets the 商户编号(必填) .
	 *
	 * @return the 商户编号(必填) 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号(必填) .
	 *
	 * @param merchantNo the new 商户编号(必填) 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 导购编号(必填)  .
	 *
	 * @return the 导购编号(必填)  
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号(必填)  .
	 *
	 * @param memberNoGm the new 导购编号(必填)  
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskChooseIndex [merchantNo=")
				.append(merchantNo).append(", memberNoGm=").append(memberNoGm)
				.append(", workDateStart=").append(workDateStart)
				.append(", workDateEnd=").append(workDateEnd).append(", flag=")
				.append(flag).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 工作日期_开始 .
	 *
	 * @return the 工作日期_开始 
	 */
	public Date getWorkDateStart() {
		return workDateStart;
	}

	/**
	 * Sets the 工作日期_开始 .
	 *
	 * @param workDateStart the new 工作日期_开始 
	 */
	public void setWorkDateStart(Date workDateStart) {
		this.workDateStart = workDateStart;
	}

	/**
	 * Gets the 工作日期_结束 .
	 *
	 * @return the 工作日期_结束 
	 */
	public Date getWorkDateEnd() {
		return workDateEnd;
	}

	/**
	 * Sets the 工作日期_结束 .
	 *
	 * @param workDateEnd the new 工作日期_结束 
	 */
	public void setWorkDateEnd(Date workDateEnd) {
		this.workDateEnd = workDateEnd;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
    

}
