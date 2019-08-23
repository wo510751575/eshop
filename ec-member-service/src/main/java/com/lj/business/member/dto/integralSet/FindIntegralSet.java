package com.lj.business.member.dto.integralSet;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindIntegralSet.
 */
public class FindIntegralSet implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4871199759293759836L; 
	
	/** The code. */
	private String code;
	
	/** The integral type. */
	private String integralType;
	
	private String merchantNo;

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
	 * Gets the integral type.
	 *
	 * @return the integral type
	 */
	public String getIntegralType() {
		return integralType;
	}

	/**
	 * Sets the integral type.
	 *
	 * @param integralType the new integral type
	 */
	public void setIntegralType(String integralType) {
		this.integralType = integralType;
	}
	
	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindIntegralSet [code=").append(code)
				.append(", integralType=").append(integralType)
				.append(", merchantNo=").append(merchantNo).append("]");
		return builder.toString();
	}

}
