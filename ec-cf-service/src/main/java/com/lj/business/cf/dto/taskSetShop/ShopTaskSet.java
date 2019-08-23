package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ShopTaskSet.
 */
public class ShopTaskSet implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4316903572405780716L;
	
	 /**
     * CODE .(必填)
     */
    private String code;
	
	  /**
     * 商户编号 .(必填)
     */
    private String merchantNo;
    
    /** 分店编号. (必填)*/
    private String shopNo;
    
    /** 分店名称. (必填)*/
    private String shopName;
    
    /** 店长编号. (必填)*/
    private String memberNoSp;
    
    /** 店长名称.(必填) */
    private String memberNameSp;

	/**
	 * 任务开始时间 .(必填)
	 */
	private Date startDate;

	/**
	 * 任务结束时间 .(必填)
	 */
	private Date endDate;
	
	 /**
     * 月数量（所有店员合计） .(必填)
     */
    private Long numMonth;
    
    /**  任务单位. */
    private String taskUnit;
    
    /** 设置明细list. */
    private ShopTaskSetDetailList[] list;

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

	/**
	 * Gets the merchant no.
	 *
	 * @return the merchant no
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the merchant no.
	 *
	 * @param merchantNo the new merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the num month.
	 *
	 * @return the num month
	 */
	public Long getNumMonth() {
		return numMonth;
	}

	/**
	 * Sets the num month.
	 *
	 * @param numMonth the new num month
	 */
	public void setNumMonth(Long numMonth) {
		this.numMonth = numMonth;
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public ShopTaskSetDetailList[] getList() {
		return list;
	}

	/**
	 * Sets the list.
	 *
	 * @param list the new list
	 */
	public void setList(ShopTaskSetDetailList[] list) {
		this.list = list;
	}

	/**
	 * Gets the shop no.
	 *
	 * @return the shop no
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the shop no.
	 *
	 * @param shopNo the new shop no
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the shop name.
	 *
	 * @return the shop name
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the shop name.
	 *
	 * @param shopName the new shop name
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the member no sp.
	 *
	 * @return the member no sp
	 */
	public String getMemberNoSp() {
		return memberNoSp;
	}

	/**
	 * Sets the member no sp.
	 *
	 * @param memberNoSp the new member no sp
	 */
	public void setMemberNoSp(String memberNoSp) {
		this.memberNoSp = memberNoSp;
	}

	/**
	 * Gets the member name sp.
	 *
	 * @return the member name sp
	 */
	public String getMemberNameSp() {
		return memberNameSp;
	}

	/**
	 * Sets the member name sp.
	 *
	 * @param memberNameSp the new member name sp
	 */
	public void setMemberNameSp(String memberNameSp) {
		this.memberNameSp = memberNameSp;
	}
	
	/**
	 * Gets the task unit.
	 *
	 * @return the task unit
	 */
	public String getTaskUnit() {
		return taskUnit;
	}

	/**
	 * Sets the task unit.
	 *
	 * @param taskUnit the new task unit
	 */
	public void setTaskUnit(String taskUnit) {
		this.taskUnit = taskUnit;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShopTaskSet [code=").append(code)
				.append(", merchantNo=").append(merchantNo).append(", shopNo=")
				.append(shopNo).append(", shopName=").append(shopName)
				.append(", memberNoSp=").append(memberNoSp)
				.append(", memberNameSp=").append(memberNameSp)
				.append(", startDate=").append(startDate).append(", endDate=")
				.append(endDate).append(", numMonth=").append(numMonth)
				.append(", taskUnit=").append(taskUnit).append(", list=")
				.append(Arrays.toString(list)).append("]");
		return builder.toString();
	}

}
