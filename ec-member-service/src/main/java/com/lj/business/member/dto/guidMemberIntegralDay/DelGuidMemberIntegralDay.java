package com.lj.business.member.dto.guidMemberIntegralDay;

import java.io.Serializable;

public class DelGuidMemberIntegralDay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2858408415097948329L; 
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DelGuidMemberIntegralDay [code=").append(code)
				.append("]");
		return builder.toString();
	}
	
}
