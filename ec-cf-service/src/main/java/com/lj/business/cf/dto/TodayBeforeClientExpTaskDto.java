package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class TodayBeforeClientExpTaskDto.
 */
public class TodayBeforeClientExpTaskDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5397621627149066235L;
	
	/** 商户编号. */
	private String merchantNo;
	
	/** 分店编号. */
	private String shopNo;
	
	/** 导购编号. */
	private String memberNoGm;
	
	/** 客户编号. */
	private String memberNo;
	
	/** 统计时间. */
	private Date stDate;

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
	 * Gets the member no.
	 *
	 * @return the member no
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the member no.
	 *
	 * @param memberNo the new member no
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the st date.
	 *
	 * @return the st date
	 */
	public Date getStDate() {
		return stDate;
	}

	/**
	 * Sets the st date.
	 *
	 * @param stDate the new st date
	 */
	public void setStDate(Date stDate) {
		this.stDate = stDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TodayBeforeClientExpTaskDto [merchantNo=")
				.append(merchantNo).append(", shopNo=").append(shopNo)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNo=").append(memberNo).append(", stDate=")
				.append(stDate).append("]");
		return builder.toString();
	}

}
