package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ShopTaskSetDetailList.
 */
public class ShopTaskSetDetailList implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7109367773472074860L;
	

    /**
     * 店长任务设置明细表CODE .
     */
    private String code;

    /**
     * 导购编号 .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 日均数量 .
     */
    private Long numDay;

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
	 * Gets the num day.
	 *
	 * @return the num day
	 */
	public Long getNumDay() {
		return numDay;
	}

	/**
	 * Sets the num day.
	 *
	 * @param numDay the new num day
	 */
	public void setNumDay(Long numDay) {
		this.numDay = numDay;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShopTaskSetDetailList [code=").append(code)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", numDay=").append(numDay).append("]");
		return builder.toString();
	}

}
