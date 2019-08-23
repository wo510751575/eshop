package com.lj.business.cf.dto.clientFollowSummary;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindBuyRecordCountReturn.
 */
public class FindAbandonRecordCountReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6379567409227421758L;
	
	/** 跟进编号. */
	private String cfNo;
	
	/** 放弃code. */
	private String paCode;
	
	/** 数量. */
	private int total;
	
	/**
	 * Gets the cf no.
	 *
	 * @return the cf no
	 */
	public String getCfNo() {
		return cfNo;
	}

	/**
	 * Sets the cf no.
	 *
	 * @param cfNo the new cf no
	 */
	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}

	/**
	 * Gets the pa code.
	 *
	 * @return the pa code
	 */
	public String getPaCode() {
		return paCode;
	}

	/**
	 * Sets the pa code.
	 *
	 * @param paCode the new pa code
	 */
	public void setPaCode(String paCode) {
		this.paCode = paCode;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindAbandonRecordCountReturn [cfNo=").append(cfNo)
				.append(", paCode=").append(paCode).append(", total=")
				.append(total).append("]");
		return builder.toString();
	}

}
