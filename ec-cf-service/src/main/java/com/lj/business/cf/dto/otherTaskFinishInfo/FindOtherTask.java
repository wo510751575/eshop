package com.lj.business.cf.dto.otherTaskFinishInfo;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindOtherTask.
 */
public class FindOtherTask implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2021186021658616226L;
	
	
    /**
     * 商户编号(必填) .
     */
    private String merchantNo;


    /**
     * 导购编号(必填) .
     */
    private String memberNoGm;
    
    /** 当前时间. */
    private Date now;
    
    /** code. */
    private String code;


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
	 * Gets the 导购编号(必填) .
	 *
	 * @return the 导购编号(必填) 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}


	/**
	 * Sets the 导购编号(必填) .
	 *
	 * @param memberNoGm the new 导购编号(必填) 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}
	
	/**
	 * Gets the now.
	 *
	 * @return the now
	 */
	public Date getNow() {
		return now;
	}

	/**
	 * Sets the now.
	 *
	 * @param now the new now
	 */
	public void setNow(Date now) {
		this.now = now;
	}
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindOtherTask [merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm).append(", now=")
				.append(now).append(", code=").append(code).append("]");
		return builder.toString();
	}

}
