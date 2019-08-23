package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * The Class FindTaskSchSpList.
 */
public class FindTaskSchSpList  implements Serializable{

	  /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4258098486201674302L;


    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 工作日期 .
     */
    private Date workDate;

    /**
     * 店长编号 .
     */
    private String memberNo;

    /**
     * 店长姓名 .
     */
    private String memberName;

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
	 * Gets the 工作日期 .
	 *
	 * @return the 工作日期 
	 */
	public Date getWorkDate() {
		return workDate;
	}

	/**
	 * Sets the 工作日期 .
	 *
	 * @param workDate the new 工作日期 
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	/**
	 * Gets the 店长编号 .
	 *
	 * @return the 店长编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 店长编号 .
	 *
	 * @param memberNo the new 店长编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 店长姓名 .
	 *
	 * @return the 店长姓名 
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 店长姓名 .
	 *
	 * @param memberName the new 店长姓名 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindTaskSchSpList [merchantNo=").append(merchantNo)
				.append(", workDate=").append(workDate).append(", memberNo=")
				.append(memberNo).append(", memberName=").append(memberName)
				.append("]");
		return builder.toString();
	}

}
