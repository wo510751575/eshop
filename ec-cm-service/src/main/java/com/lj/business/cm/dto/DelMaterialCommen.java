package com.lj.business.cm.dto;

import java.io.Serializable;

/**
 * The Class DelMaterialCommen.
 */
public class DelMaterialCommen implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2343041888526234311L;

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

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DelMaterialCommen [code=" + code + "]";
	}
	 
}
