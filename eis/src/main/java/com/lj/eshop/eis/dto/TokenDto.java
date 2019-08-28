/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.dto;

import java.io.Serializable;

import com.lj.eshop.dto.ShopDto;

/**
 * 
 * 类说明：登录的TOKEN 。
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月2日
 */
public class TokenDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String token;
	/** 角色 */
	private String role;
	/** 用户已开店，但其店铺状态不正常，则以角色C的身份登录系统，但返回其店铺状态给 前端显示 */
	private ShopDto shop;
	/** 是否已绑定openId  true则代表已绑定，否则未绑定 */
	private Boolean hasOpenid;
	/**商户号*/
	private String merchantCode;
	/** 会员体系导购信息 （APP登录后要使用 ）0*/
	private GuidMbrDto guidMbr;
    /** 系统配置常量 */
    private ConfigDto config;
    
	/**
	 * @param token
	 * @param role
	 */
	public TokenDto(String token, String role) {
		super();
		this.token = token;
		this.role = role;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the shop
	 */
	public ShopDto getShop() {
		return shop;
	}

	/**
	 * @param shop the shop to set
	 */
	public void setShop(ShopDto shop) {
		this.shop = shop;
	}

	/**
	 * @return the hasOpenid
	 */
	public Boolean getHasOpenid() {
		return hasOpenid;
	}

	/**
	 * @param hasOpenid the hasOpenid to set
	 */
	public void setHasOpenid(Boolean hasOpenid) {
		this.hasOpenid = hasOpenid;
	}

	/**
	 * @return the merchantCode
	 */
	public String getMerchantCode() {
		return merchantCode;
	}

	/**
	 * @param merchantCode the merchantCode to set
	 */
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	/**
	 * @return the guidMbr
	 */
	public GuidMbrDto getGuidMbr() {
		return guidMbr;
	}

	/**
	 * @param guidMbr the guidMbr to set
	 */
	public void setGuidMbr(GuidMbrDto guidMbr) {
		this.guidMbr = guidMbr;
	}

	/**
	 * @return the config
	 */
	public ConfigDto getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public void setConfig(ConfigDto config) {
		this.config = config;
	}

}
