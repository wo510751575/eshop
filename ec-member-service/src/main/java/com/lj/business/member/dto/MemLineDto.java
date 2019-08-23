package com.lj.business.member.dto;

import java.io.Serializable;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class MemLineDto.
 */
public class MemLineDto extends PageParamEntity implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7829836416728372721L;

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

	@Override
	public String toString() {
		return "MemLineDto [code=" + code + ", name=" + name + ", remark="
				+ remark + "]";
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

    
}