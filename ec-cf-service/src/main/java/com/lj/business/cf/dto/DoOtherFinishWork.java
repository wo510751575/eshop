package com.lj.business.cf.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class DoOtherFinishWork.
 */
public class DoOtherFinishWork implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3327897365122509664L;
	
	/** code. */
	private String code;
	
	/**  完成数量. */
	private Long numFinish;

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
	 * Gets the num finish.
	 *
	 * @return the num finish
	 */
	public Long getNumFinish() {
		return numFinish;
	}

	/**
	 * Sets the num finish.
	 *
	 * @param numFinish the new num finish
	 */
	public void setNumFinish(Long numFinish) {
		this.numFinish = numFinish;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoOtherFinishWork [code=").append(code)
				.append(", numFinish=").append(numFinish).append("]");
		return builder.toString();
	}

}
