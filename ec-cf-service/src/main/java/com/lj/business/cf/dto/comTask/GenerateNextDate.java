package com.lj.business.cf.dto.comTask;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class GenerateNextDate.
 */
public class GenerateNextDate implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2025066182629886785L;

	/** 下次任务时间. */
	private Date nextDate;
	
	/** 是否获取下周时间. */
	private Boolean nextWeek = false;

	/**
	 * Gets the 下次任务时间.
	 *
	 * @return the 下次任务时间
	 */
	public Date getNextDate() {
		return nextDate;
	}

	/**
	 * Sets the 下次任务时间.
	 *
	 * @param nextDate the new 下次任务时间
	 */
	public void setNextDate(Date nextDate) {
		this.nextDate = nextDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GenerateNextDate [nextDate=").append(nextDate)
				.append(", nextWeek=").append(nextWeek).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 是否获取下周时间.
	 *
	 * @return the 是否获取下周时间
	 */
	public Boolean getNextWeek() {
		return nextWeek;
	}

	/**
	 * Sets the 是否获取下周时间.
	 *
	 * @param nextWeek the new 是否获取下周时间
	 */
	public void setNextWeek(Boolean nextWeek) {
		this.nextWeek = nextWeek;
	}



}
