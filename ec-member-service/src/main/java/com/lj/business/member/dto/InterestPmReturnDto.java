package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class InterestPmReturnDto.
 */
public class InterestPmReturnDto implements Serializable{
	
	 /** Generate cron. */
	private static final long serialVersionUID = 6849061317749667550L;

	/** 唯一code. */
	private String code;
	
	/** 会员号. */
    private String merchantNo;
    
    /** 名称. */
    private String name;
    
    /** 备注. */
    private String remark;
    
    /** 创建时间. */
    private Date createDate;
    
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
	 * Gets the merchant no.
	 *
	 * @return the merchant no
	 */
	public String getMerchantNo() {
		return merchantNo;
	}
	
	/**
	 * Sets the merchant no.
	 *
	 * @param merchantNo the new merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	
	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InterestPm [code=").append(code)
				.append(", merchantNo=").append(merchantNo).append(", name=")
				.append(name).append(", remark=").append(remark)
				.append(", createDate=").append(createDate).append("]");
		return builder.toString();
	}
}
