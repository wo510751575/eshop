package com.lj.business.cf.dto.clientFollowSummary;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindBuyRecordPageReturn.
 */
public class FindBuyRecordPageReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8281641226061491803L;
	
	/**
     * CODE .
     */
    private String code;

    /**
     * 跟踪编号 .
     */
    private String cfNo;

    /**
     * 跟踪次数 .
     */
    private Integer followNum;


    /**
     * 订单金额 .
     */
    private Long orderAmount;


    /**
     * 跟踪结束时间 .
     */
    private Date endDate;


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
	 * Gets the 跟踪编号 .
	 *
	 * @return the 跟踪编号 
	 */
	public String getCfNo() {
		return cfNo;
	}


	/**
	 * Sets the 跟踪编号 .
	 *
	 * @param cfNo the new 跟踪编号 
	 */
	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}


	/**
	 * Gets the 跟踪次数 .
	 *
	 * @return the 跟踪次数 
	 */
	public Integer getFollowNum() {
		return followNum;
	}


	/**
	 * Sets the 跟踪次数 .
	 *
	 * @param followNum the new 跟踪次数 
	 */
	public void setFollowNum(Integer followNum) {
		this.followNum = followNum;
	}


	/**
	 * Gets the 订单金额 .
	 *
	 * @return the 订单金额 
	 */
	public Long getOrderAmount() {
		return orderAmount;
	}


	/**
	 * Sets the 订单金额 .
	 *
	 * @param orderAmount the new 订单金额 
	 */
	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}


	/**
	 * Gets the 跟踪结束时间 .
	 *
	 * @return the 跟踪结束时间 
	 */
	public Date getEndDate() {
		return endDate;
	}


	/**
	 * Sets the 跟踪结束时间 .
	 *
	 * @param endDate the new 跟踪结束时间 
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindBuyRecordPageReturn [code=").append(code)
				.append(", cfNo=").append(cfNo).append(", followNum=")
				.append(followNum).append(", orderAmount=").append(orderAmount)
				.append(", endDate=").append(endDate).append("]");
		return builder.toString();
	}



}
