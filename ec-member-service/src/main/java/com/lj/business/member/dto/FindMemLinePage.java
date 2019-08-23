package com.lj.business.member.dto;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindMemLinePage.
 */
public class FindMemLinePage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 246245244254900774L; 
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
	public String getName() {
		return name;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param name the new 会员号  
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the 导购姓名 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remark the remarks
	 */
	public void setRemarks(String remark) {
		this.remark = remark;
	}

	/**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String name;

    /**
     * 导购姓名 .
     */
    private String remark;
	@Override
	public String toString() {
		return "FindMemLinePage [code=" + code + ", name=" + name + ", remark="
				+ remark + "]";
	}

    

}
