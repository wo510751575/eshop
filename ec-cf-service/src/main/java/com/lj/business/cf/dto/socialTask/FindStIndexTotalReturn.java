package com.lj.business.cf.dto.socialTask;

import java.io.Serializable;

/**
 * The Class FindStIndexTotalReturn.
 */
public class FindStIndexTotalReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2234482503149452585L;
	
	
	/** 累计未完成任务. */
	private Integer numDis;


	/**
	 * Gets the 累计未完成任务.
	 *
	 * @return the 累计未完成任务
	 */
	public Integer getNumDis() {
		return numDis;
	}


	/**
	 * Sets the 累计未完成任务.
	 *
	 * @param numDis the new 累计未完成任务
	 */
	public void setNumDis(Integer numDis) {
		this.numDis = numDis;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindStIndexTotalReturn [numDis=").append(numDis)
				.append("]");
		return builder.toString();
	}

}
