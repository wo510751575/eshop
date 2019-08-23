package com.lj.business.cf.dto.clientKeepSummary;

import java.io.Serializable;

public class FindClientKeepSummary implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5051711320754653732L;
	
	private String code;
	
	 /**
     * 商户号  .
     */
    private String merchantNo;

    /**
     * 会员号  .
     */
    private String memberNo;

    /**
     * 导购编号 .
     */
    private String memberNoGm;
    
    /**
     * 维护号
     */
    private String ckNo;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}
	
	public String getCkNo() {
		return ckNo;
	}

	public void setCkNo(String ckNo) {
		this.ckNo = ckNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindClientKeepSummary [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNo=").append(memberNo).append(", memberNoGm=")
				.append(memberNoGm).append(", ckNo=").append(ckNo).append("]");
		return builder.toString();
	}

}
