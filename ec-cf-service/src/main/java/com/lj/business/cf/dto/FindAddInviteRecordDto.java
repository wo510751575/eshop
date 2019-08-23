package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindAddInviteRecordDto.
 */
public class FindAddInviteRecordDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6128609058590944777L;

	/**
	 * 商户编号 .
	 */
	private String merchantNo;

	/**
	 * 客户编号 .
	 */
	private String memberNo;

	/**
	 * 客户名称 .
	 */
	private String memberName;

	/**
	 * 导购编号 .
	 */
	private String memberNoGm;

	/**
	 * 导购姓名 .
	 */
	private String memberNameGm;

	/**
	 * 门店编号 .
	 */
	private String shopNo;

	/**
	 * 门店名称 .
	 */
	private String shopName;

	/**
	 * 预计到店时间 .
	 */
	private Date reachTime;

	/**
	 * 邀约失败原因 .
	 */
	private String failReason;

	/**
	 * 邀约结果
             邀约成功：Y
             邀约失败：N
              .
	 */
	private String inviteResult;

	/**
	 * 跟踪编号 .
	 */
	private String cfNo;

	/**
	 * 跟踪明细CODE .
	 */
	private String cfCode;

	/**
	 * 客户沟通任务Code .
	 */
	private String comTaskCode;

	/**
	 * 是否累计任务，默认false .
	 */
	private Boolean dis = false;






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
	 * Gets the 客户编号 .
	 *
	 * @return the 客户编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}



	/**
	 * Sets the 客户编号 .
	 *
	 * @param memberNo the new 客户编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}



	/**
	 * Gets the 客户名称 .
	 *
	 * @return the 客户名称 
	 */
	public String getMemberName() {
		return memberName;
	}



	/**
	 * Sets the 客户名称 .
	 *
	 * @param memberName the new 客户名称 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	/**
	 * Gets the 导购编号 .
	 *
	 * @return the 导购编号 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}



	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNoGm the new 导购编号 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}



	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the 导购姓名 
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}



	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberNameGm the new 导购姓名 
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}



	/**
	 * Gets the 门店编号 .
	 *
	 * @return the 门店编号 
	 */
	public String getShopNo() {
		return shopNo;
	}



	/**
	 * Sets the 门店编号 .
	 *
	 * @param shopNo the new 门店编号 
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}



	/**
	 * Gets the 门店名称 .
	 *
	 * @return the 门店名称 
	 */
	public String getShopName() {
		return shopName;
	}



	/**
	 * Sets the 门店名称 .
	 *
	 * @param shopName the new 门店名称 
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}



	/**
	 * Gets the 预计到店时间 .
	 *
	 * @return the 预计到店时间 
	 */
	public Date getReachTime() {
		return reachTime;
	}



	/**
	 * Sets the 预计到店时间 .
	 *
	 * @param reachTime the new 预计到店时间 
	 */
	public void setReachTime(Date reachTime) {
		this.reachTime = reachTime;
	}



	/**
	 * Gets the 邀约失败原因 .
	 *
	 * @return the 邀约失败原因 
	 */
	public String getFailReason() {
		return failReason;
	}



	/**
	 * Sets the 邀约失败原因 .
	 *
	 * @param failReason the new 邀约失败原因 
	 */
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}



	/**
	 * Gets the 邀约结果 邀约成功：Y 邀约失败：N .
	 *
	 * @return the 邀约结果 邀约成功：Y 邀约失败：N 
	 */
	public String getInviteResult() {
		return inviteResult;
	}



	/**
	 * Sets the 邀约结果 邀约成功：Y 邀约失败：N .
	 *
	 * @param inviteResult the new 邀约结果 邀约成功：Y 邀约失败：N 
	 */
	public void setInviteResult(String inviteResult) {
		this.inviteResult = inviteResult;
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
	 * Gets the 跟踪明细CODE .
	 *
	 * @return the 跟踪明细CODE 
	 */
	public String getCfCode() {
		return cfCode;
	}



	/**
	 * Sets the 跟踪明细CODE .
	 *
	 * @param cfCode the new 跟踪明细CODE 
	 */
	public void setCfCode(String cfCode) {
		this.cfCode = cfCode;
	}



	/**
	 * Gets the 客户沟通任务Code .
	 *
	 * @return the 客户沟通任务Code 
	 */
	public String getComTaskCode() {
		return comTaskCode;
	}



	/**
	 * Sets the 客户沟通任务Code .
	 *
	 * @param comTaskCode the new 客户沟通任务Code 
	 */
	public void setComTaskCode(String comTaskCode) {
		this.comTaskCode = comTaskCode;
	}



	/**
	 * Gets the 是否累计任务，默认false .
	 *
	 * @return the 是否累计任务，默认false 
	 */
	public Boolean getDis() {
		return dis;
	}



	/**
	 * Sets the 是否累计任务，默认false .
	 *
	 * @param dis the new 是否累计任务，默认false 
	 */
	public void setDis(Boolean dis) {
		this.dis = dis;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindAddInviteRecordDto [merchantNo=")
		.append(merchantNo).append(", memberNo=").append(memberNo)
		.append(", memberName=").append(memberName)
		.append(", memberNoGm=").append(memberNoGm)
		.append(", memberNameGm=").append(memberNameGm)
		.append(", shopNo=").append(shopNo).append(", shopName=")
		.append(shopName).append(", reachTime=").append(reachTime)
		.append(", failReason=").append(failReason)
		.append(", inviteResult=").append(inviteResult)
		.append(", cfNo=").append(cfNo).append(", cfCode=")
		.append(cfCode).append(", comTaskCode=").append(comTaskCode)
		.append(", dis=").append(dis).append("]");
		return builder.toString();
	}

}
