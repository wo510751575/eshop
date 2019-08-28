/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.eis.dto.LoginUserDto;
import com.lj.eshop.eis.dto.UserTokenThreadLocal;

/**
 * 
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年8月31日
 */
public class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 方法说明：获取当前登录的用户信息。
	 * <p>
	 * 注意：由于信息缓存，未必和DB同步，请只使用会员的ID，其他的信息不使用。
	 * 
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	public MemberDto getLoginMember() {
		LoginUserDto user = UserTokenThreadLocal.get();
		if (user != null) {
			return user.getMember();
		} else {
			return null;
		}
	}

	/**
	 * 方法说明：获取当前登录的用户信息CODE。
	 * <p>
	 * 
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	public String getLoginMemberCode() {
		LoginUserDto user = UserTokenThreadLocal.get();
		if (user != null && user.getMember() != null) {
			return user.getMember().getCode();
		} else {
			return null;
		}
	}

	/**
	 * 方法说明：获取当前登录的B端用户的店铺。
	 * <p>
	 * 注意：由于信息缓存，未必和DB同步，请只使用店铺的ID，其他的信息不使用。
	 * 
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	public ShopDto getLoginShop() {
		LoginUserDto user = UserTokenThreadLocal.get();
		if (user != null) {
			return user.getShop();
		} else {
			return null;
		}
	}

	/**
	 * 方法说明：获取当前登录的用户店铺的CODE。
	 * <p>
	 * 
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	public String getLoginShopCode() {
		LoginUserDto user = UserTokenThreadLocal.get();
		if (user != null && user.getShop() != null) {
			return user.getShop().getCode();
		} else {
			return null;
		}
	}

	/**
	 * 方法说明：获取登录店铺用户的商户号。C端则找会员所在的商户号。
	 *
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	public String getLoginMerchantCode() {
		LoginUserDto user = UserTokenThreadLocal.get();
		if (user != null) {
			if (user.getShop() != null) {// 店登录的则返回店的 商户号
				return user.getShop().getMerchantCode();
			}
			if (user.getMember() != null) {
				return user.getMember().getMerchantCode();
			}
			return null;
		} else {
			return null;
		}
	}

	/***
	 * 方法说明：获取登录用户的角色。
	 * 
	 * @return
	 *
	 * @author lhy 2017年9月7日
	 *
	 */
	public String getLoginUserRole() {
		LoginUserDto user = UserTokenThreadLocal.get();
		if (user != null) {
			return user.getRole();
		}
		return null;
	}

	/**
	 * 方法说明：获取导购code
	 *
	 * @return
	 *
	 * @author lhy 2017年9月20日
	 *
	 */
	/*
	 * public String getGuidMemberCode(){ LoginUserDto
	 * user=UserTokenThreadLocal.get(); if (user != null && user.getGuidMbr() !=
	 * null) { return user.getGuidMbr().getCode(); } return null; }
	 */
	/**
	 * 方法说明：获取导购
	 *
	 * @return
	 *
	 * @author 林进权 2017年9月21日
	 *
	 */
	/*
	 * public GuidMbrDto getGuidMember(){ LoginUserDto
	 * user=UserTokenThreadLocal.get(); if (user != null && user.getGuidMbr() !=
	 * null) { return user.getGuidMbr(); } return null; }
	 */

	/**
	 * 
	 *
	 * 方法说明：获取导购编号，也就是电商会员Code
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月22日
	 *
	 */
	/*
	 * public String getLoginMemberCode(){ LoginUserDto
	 * user=UserTokenThreadLocal.get(); if (user != null && user.getGuidMbr() !=
	 * null) { return user.getGuidMbr().getMemberNo(); } return null; }
	 */
}
