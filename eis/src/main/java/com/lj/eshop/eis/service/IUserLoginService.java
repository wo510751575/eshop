/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.service;

import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.eis.dto.LoginUserDto;
import com.lj.eshop.eis.dto.MobilePhoneLoginDto;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.dto.TokenDto;
import com.lj.eshop.eis.dto.WxUserInfoDto;

/**
 * 
 * 类说明：登录。
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
public interface IUserLoginService {

	/**
	 * 方法说明：门店手机号登录
	 * 
	 * @param dto
	 * @return
	 *
	 * @author lhy 2017年9月2日
	 *
	 */
	public TokenDto mobilePhoneLogin(MobilePhoneLoginDto dto);

	/**
	 * 方法说明：获取当前登录用户信息。
	 * 
	 * @param token 令牌
	 * @return
	 *
	 * @author lhy 2017年9月2日
	 *
	 */
	public LoginUserDto getCurrLoginUser(String token);

	/**
	 * 方法说明：根据手机号找用户。
	 *
	 * @param phone
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	public MemberDto findMemberDtoByPhone(String phone);

	/**
	 * 
	 *
	 * 方法说明：根据openid获取会员信息
	 *
	 * @param openid
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月5日
	 *
	 */
	public MemberDto getMemberByOpenId(String openid);

	/**
	 *
	 * 方法说明：微信用户注册或登录。
	 * <p>
	 * 系统无该用户则注册，系统有该用户则登录，
	 * 
	 * @param wxUser       微信用户信息
	 * @param merchantCode 商户code
	 * @return
	 *
	 * @author lhy 2017年9月7日
	 *
	 */
	public ResponseDto regOrLogin(WxUserInfoDto wxUser, String merchantCode);

	/**
	 * 方法说明：通过token 再次登录。
	 * <p>
	 * 比如C端申请了开店成功后，则更换登录身份为B。
	 * 
	 * @return
	 *
	 * @author lhy 2017年9月7日
	 *
	 */
	public ResponseDto loginAgain();

	/**
	 * 首批EOMS导入的微店用户，用手机登录后绑定openid信息。
	 * 
	 * @return
	 * @author lhy 2017年9月7日
	 *
	 */
	public void bindOpenId(WxUserInfoDto wxUser, MemberDto memberDto);

	/***
	 * 方法说明： 会员登出。
	 * 
	 * @author lhy 2017年9月14日
	 *
	 */
	public void logout();

	/**
	 * 方法说明：小B.APP手机登录。
	 * 
	 * @warn unchecked
	 * @param loginDto
	 *
	 * @author lhy 2017年9月19日
	 *
	 */
	public TokenDto appLogin(MobilePhoneLoginDto loginDto);

	/**
	 * 方法说明：检测当前登录的用户状态。
	 *
	 * @param dto
	 *
	 * @author lhy 2017年10月12日
	 *
	 */
	public void checkShopAndUserStatus(LoginUserDto dto);
}
