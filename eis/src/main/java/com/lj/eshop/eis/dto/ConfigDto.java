/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.dto;

import java.io.Serializable;

/**
 * 类说明：系统对外的配置。
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月21日
 */
public class ConfigDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6620242148659560539L;
	/** 上传前缀路径. */
	private String uploadUrl;
	/** * 微信更新地址. */
	private String wxUpdateUrl;

	/**
	 * @return the uploadUrl
	 */
	public String getUploadUrl() {
		return uploadUrl;
	}

	/**
	 * @param uploadUrl
	 *            the uploadUrl to set
	 */
	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	/**
	 * @return the wxUpdateUrl
	 */
	public String getWxUpdateUrl() {
		return wxUpdateUrl;
	}

	/**
	 * @param wxUpdateUrl the wxUpdateUrl to set
	 */
	public void setWxUpdateUrl(String wxUpdateUrl) {
		this.wxUpdateUrl = wxUpdateUrl;
	}

}
