package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindGuidMember.
 */
public class FindGuidMember implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6402608402042477403L;

	/**
     * CODE(必填，会员号，CODE二选一) .
     */
    private String code;

    /**
     * 会员号(必填，会员号，CODE二选一)  .
     */
    private String memberNo;
    
    /**
     * 手机号 .
     */
    private String mobile;
    
    /**
     * 商户号 .
     */
    private String merchantNo;
    
    /**
     * 状态 .
     */
    private String status;

    /**
     * 会员名 .
     */
    private String memberName;
    
    /**
     * 商户名 .
     */
    private String shopNo;
    
    /**
     * 微信号 .
     */
    private String noWx;

	/**
	 * Gets the cODE(必填，会员号，CODE二选一) .
	 *
	 * @return the cODE(必填，会员号，CODE二选一) 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE(必填，会员号，CODE二选一) .
	 *
	 * @param code the new cODE(必填，会员号，CODE二选一) 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 会员号(必填，会员号，CODE二选一)  .
	 *
	 * @return the 会员号(必填，会员号，CODE二选一)  
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 会员号(必填，会员号，CODE二选一)  .
	 *
	 * @param memberNo the new 会员号(必填，会员号，CODE二选一)  
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getNoWx() {
		return noWx;
	}

	public void setNoWx(String noWx) {
		this.noWx = noWx;
	}

	@Override
	public String toString() {
		return "FindGuidMember [code=" + code + ", memberNo=" + memberNo
				+ ", mobile=" + mobile + ", merchantNo=" + merchantNo
				+ ", status=" + status + ", memberName=" + memberName
				+ ", shopNo=" + shopNo + ", noWx=" + noWx + "]";
	}

}
