package com.lj.business.cm.dto;

import java.io.Serializable;

/**
 * The Class FindGreetClient.
 */
public class FindGreetClient implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8939853291291157448L;

	 /** The code. */
 	private String code;

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
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindGreetClient [code=" + code + ", getCode()=" + getCode()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	 

}
