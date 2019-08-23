package com.lj.business.cf.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class TodayBeforeClientExpTaskReturn.
 */
public class TodayBeforeClientExpTaskReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8964164621332625205L;
	
	/** 记录数. */
	private int count;

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TodayBeforeClientExpTaskReturn [count=").append(count)
				.append("]");
		return builder.toString();
	}
	
}
