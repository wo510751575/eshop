package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindIntegralDayDtoReturn.
 */
public class FindIntegralDayDtoReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1263517451722734939L;
	
	/** The total. */
	private double total;

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindIntegralDayDtoReturn [total=").append(total)
				.append("]");
		return builder.toString();
	}
	
}
