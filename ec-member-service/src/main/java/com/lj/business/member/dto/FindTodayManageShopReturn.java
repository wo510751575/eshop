package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindTodayManageShopReturn.
 */
public class FindTodayManageShopReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4645530190001563843L;

	/** The head address. */
	private String headAddress; // 头像地址.
	
	/** The member name gm. */
	private String memberNameGm; // 导购姓名.
	
	/** The member no gm. */
	private String memberNoGm; // 导购编号.
	
	/** The merchant no. */
	private String merchantNo; // 商户编号.
	
	/** The ratio work. */
	private double ratioWork; // 工作完成度.
	
	/** The shop name. */
	private String shopName; // 分店名称.
	
	/** The shop no. */
	private String shopNo; // 分店编号.

	/**
	 * Gets the head address.
	 *
	 * @return the head address
	 */
	public String getHeadAddress() {
		return headAddress;
	}

	/**
	 * Sets the head address.
	 *
	 * @param headAddress the new head address
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	/**
	 * Gets the member name gm.
	 *
	 * @return the member name gm
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the member name gm.
	 *
	 * @param memberNameGm the new member name gm
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the member no gm.
	 *
	 * @return the member no gm
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the member no gm.
	 *
	 * @param memberNoGm the new member no gm
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
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
	 * Gets the ratio work.
	 *
	 * @return the ratio work
	 */
	public double getRatioWork() {
		return ratioWork;
	}

	/**
	 * Sets the ratio work.
	 *
	 * @param ratioWork the new ratio work
	 */
	public void setRatioWork(double ratioWork) {
		this.ratioWork = ratioWork;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindTodayManageShopReturn [headAddress=")
				.append(headAddress).append(", memberNameGm=")
				.append(memberNameGm).append(", memberNoGm=")
				.append(memberNoGm).append(", merchantNo=").append(merchantNo)
				.append(", ratioWork=").append(ratioWork).append(", shopName=")
				.append(shopName).append(", shopNo=").append(shopNo)
				.append("]");
		return builder.toString();
	}
	
}
