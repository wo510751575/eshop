package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AddPmTypePmDto.
 */
public class AddPmTypePmDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4105365320981545712L;
	
	   /**
     * CODE .
     */
    private String code;

    /**
     * 客户表CODE .
     */
    private String codePm;

    /**
     * 客户分类CODE .
     */
    private String pmTypeCode;

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
	 * Gets the code pm.
	 *
	 * @return the code pm
	 */
	public String getCodePm() {
		return codePm;
	}

	/**
	 * Sets the code pm.
	 *
	 * @param codePm the new code pm
	 */
	public void setCodePm(String codePm) {
		this.codePm = codePm;
	}

	/**
	 * Gets the pm type code.
	 *
	 * @return the pm type code
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}

	/**
	 * Sets the pm type code.
	 *
	 * @param pmTypeCode the new pm type code
	 */
	public void setPmTypeCode(String pmTypeCode) {
		this.pmTypeCode = pmTypeCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddPmTypePmDto [code=").append(code)
				.append(", codePm=").append(codePm).append(", pmTypeCode=")
				.append(pmTypeCode).append("]");
		return builder.toString();
	}
    
}
