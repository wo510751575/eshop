package com.lj.business.member.dto.custKeep;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindCustKeepPageReturn.
 */
public class FindCustKeepPageReturn implements Serializable { 

	
	 /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5603479700423960835L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String merchantNo;

    /**
     * 客户标签名称 .
     */
    private String memberNo;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 0：关注  1：取消关注 .
     */
    private String status;

	/**
	 * Gets the cODE .
	 *
	 * @return the cODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 会员号  .
	 *
	 * @return the 会员号  
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param merchantNo the new 会员号  
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 客户标签名称 .
	 *
	 * @return the 客户标签名称 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 客户标签名称 .
	 *
	 * @param memberNo the new 客户标签名称 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 创建时间 .
	 *
	 * @return the 创建时间 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate the new 创建时间 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the 0：关注  1：取消关注 .
	 *
	 * @return the 0：关注  1：取消关注 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the 0：关注  1：取消关注 .
	 *
	 * @param status the new 0：关注  1：取消关注 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindCustKeepPageReturn [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNo=").append(memberNo).append(", status=")
				.append(status).append("]");
		return builder.toString();
	}
    
}
