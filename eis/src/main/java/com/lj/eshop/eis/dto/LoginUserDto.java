/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.dto;

import java.io.Serializable;

import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.ShopDto;

/**
 * 
 * 类说明：当前登录的用户。
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
public class LoginUserDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 登录者角色 （b =代表B端 c=代表C端） */
	private String role;

	/** 登录人 */
	private MemberDto member;

	/** 店铺 （仅当店铺登录的时候存在该值） */
	private ShopDto shop;
	/** 登录时间(登录时的毫秒) */
	private Long loginTime;
	/** 登录token */
	private String token;
	/** 会员体系导购信息 */
    private GuidMbrDto guidMbr;

	/**
	 * @return the shop
	 */
	public ShopDto getShop() {
		return shop;
	}

	/**
	 * @param shop
	 *            the shop to set
	 */
	public void setShop(ShopDto shop) {
		this.shop = shop;
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
	 * @return the member
	 */
	public MemberDto getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(MemberDto member) {
		this.member = member;
	}

	/**
	 * @return the loginTime
	 */
	public Long getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
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

	
}
