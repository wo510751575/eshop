/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.dto;

import java.io.Serializable;

/**
 * 
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 领居科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年8月31日
 */
public class UpdateProductCntDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2559865439990033973L;
	private String type;
	private Integer cnt;
	private String code;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the cnt
	 */
	public Integer getCnt() {
		return cnt;
	}

	/**
	 * @param cnt
	 *            the cnt to set
	 */
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
