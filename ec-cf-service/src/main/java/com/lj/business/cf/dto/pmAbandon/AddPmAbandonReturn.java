package com.lj.business.cf.dto.pmAbandon;

import java.io.Serializable;

/**
 * The Class AddPmAbandonReturn.
 */
public class AddPmAbandonReturn implements Serializable {
	
	/** The code. */
	private String code;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7663024426106574387L;
	
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
		return "AddPmAbandonReturn [code=" + code + ", getCode()=" + getCode()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	} 
	
}
