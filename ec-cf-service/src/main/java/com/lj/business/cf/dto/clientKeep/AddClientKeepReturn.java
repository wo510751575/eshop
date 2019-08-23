package com.lj.business.cf.dto.clientKeep;

import java.io.Serializable;

/**
 * The Class AddClientKeepReturn.
 */
public class AddClientKeepReturn implements Serializable {
	
	/** The code. */
	private String code;
	
	 /**
     * 维护次数 .
     */
    private Integer keepNum;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4268879201599233612L;
	
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

	public Integer getKeepNum() {
		return keepNum;
	}

	public void setKeepNum(Integer keepNum) {
		this.keepNum = keepNum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddClientKeepReturn [code=").append(code)
				.append(", keepNum=").append(keepNum).append("]");
		return builder.toString();
	}
	
}
