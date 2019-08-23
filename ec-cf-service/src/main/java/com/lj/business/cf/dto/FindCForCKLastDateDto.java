package com.lj.business.cf.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindCForCKLastDateDto.
 */
public class FindCForCKLastDateDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3331345598781258159L;
	
	/**  跟踪号. */
	private String cfNo;
    
    /** 跟进类型 FOLLOW KEEP. */
    private String type;

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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindCForCKLastDateDto [cfNo=").append(cfNo)
				.append(", type=").append(type).append("]");
		return builder.toString();
	}

}
