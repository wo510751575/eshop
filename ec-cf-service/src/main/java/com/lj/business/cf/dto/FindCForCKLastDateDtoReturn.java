package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindCForCKLastDateDtoReturn.
 */
public class FindCForCKLastDateDtoReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5961648358723617706L;
	
	/** The last date. */
	private Date lastDate;

	/**
	 * Gets the last date.
	 *
	 * @return the last date
	 */
	public Date getLastDate() {
		return lastDate;
	}

	/**
	 * Sets the last date.
	 *
	 * @param lastDate the new last date
	 */
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindCForCKLastDateDtoReturn [lastDate=")
				.append(lastDate).append("]");
		return builder.toString();
	}
	
}
