package com.lj.business.cf.dto;

import java.io.Serializable;

/**
 * The Class AddWorkTaskUnfinishReturn.
 */
public class AddWorkTaskUnfinishReturn implements Serializable {
	
	/** The code. */
	private String code;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6830558353225717678L;
	
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
		return "AddWorkTaskUnfinishReturn [code=" + code + ", getCode()="
				+ getCode() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	} 

}
