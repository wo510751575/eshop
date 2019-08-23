package com.lj.business.cf.dto.otherTaskFinishInfo;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindOtherTaskFinishInfo.
 */
public class FindOtherTaskFinishInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 190656280724301163L; 
	
	/** code. */
	private String code;
	
	/** 商户号. */
	private String merchantNo;

	/** 导购编号 (必填). */
    private String memberNoGm;
    
    /** 分店编号. (必填)*/
    private String shopNo;
    
    /** 当前时间. */
    private Date now;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindOtherTaskFinishInfo [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm).append(", shopNo=")
				.append(shopNo).append(", now=").append(now).append("]");
		return builder.toString();
	}

}
