package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindIntegralDayDto.
 */
public class FindIntegralDayDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6487094341018260152L;
	
	/** 导购编号. */
	private String memberNoGm;
	
	/** 工作日期. */
	private Date workDate;

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
	 * Gets the work date.
	 *
	 * @return the work date
	 */
	public Date getWorkDate() {
		return workDate;
	}

	/**
	 * Sets the work date.
	 *
	 * @param workDate the new work date
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindIntegralDayDto [memberNoGm=").append(memberNoGm)
				.append(", workDate=").append(workDate).append("]");
		return builder.toString();
	}
	
}
