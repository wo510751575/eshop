package com.lj.business.cm.dto;

import java.io.Serializable;

/**
 * The Class DelGreetClient.
 */
public class DelGreetClient implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5110450044561157901L;

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
		return "DelGreetClient [code=" + code + ", getCode()=" + getCode()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	 
}
