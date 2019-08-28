/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.core.encryption.MD5;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.common.SystemParamConstant;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.cc.enums.SystemAliasName;
import com.lj.distributecache.RedisCache;
import com.lj.eshop.dto.FindMemberPage;
import com.lj.eshop.dto.FindShopPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.eis.constant.Constans;
import com.lj.eshop.eis.constant.LoginRoleConstant;
import com.lj.eshop.eis.dto.ConfigDto;
import com.lj.eshop.eis.dto.GuidMbrDto;
import com.lj.eshop.eis.dto.LoginUserDto;
import com.lj.eshop.eis.dto.MobilePhoneLoginDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.dto.TokenDto;
import com.lj.eshop.eis.dto.UserTokenThreadLocal;
import com.lj.eshop.eis.dto.WxUserInfoDto;
import com.lj.eshop.eis.service.IUserLoginService;
import com.lj.eshop.eis.utils.AuthCodeUtils;
import com.lj.eshop.eis.utils.JsonUtils;
import com.lj.eshop.eis.utils.TokenUtils;
import com.lj.eshop.emus.CodeCheckBizType;
import com.lj.eshop.emus.MemberSex;
import com.lj.eshop.emus.MemberSourceFrom;
import com.lj.eshop.emus.MemberStatus;
import com.lj.eshop.emus.MemberType;
import com.lj.eshop.emus.ShopStatus;
import com.lj.eshop.emus.ShopUnlogin;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IShopService;

/**
 * 
 * 类说明：用户登录实现。
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
@Service
public class UserLoginService implements IUserLoginService {
	private static Logger logger = LoggerFactory.getLogger(MbrGuidMemberService.class);
	/** 缓存到redis的用户 有效期 （单位 秒），5分钟，30秒 */
	public final static int USER_VALID_SECOND = 300;
	@Autowired
	IMemberService memberService;

	@Autowired
	IShopService shopService;

	@Autowired
	private RedisCache redisCache;
	@Autowired
	private static String redisKeyPrefix = "EIS";
	@Autowired
	IGuidMemberService guidMemberService;// 导购
	@Autowired
	private LocalCacheSystemParamsFromCC localCacheSystemParams;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.eshop.eis.service.IUserLoginService#mobilePhoneLogin(com.lj.eshop.eis.
	 * dto.MobilePhoneLoginDto)
	 */
	@Override
	public TokenDto mobilePhoneLogin(MobilePhoneLoginDto dto) {
		if (dto == null || StringUtils.isEmpty(dto.getMobilePhone()) || StringUtils.isEmpty(dto.getAuthCode())) {
			throw new TsfaServiceException(ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg());
		}
		// 1.验证短信验证码
		AuthCodeUtils.validAuthCode(dto.getMobilePhone(), CodeCheckBizType.LOGIN.getValue(), dto.getAuthCode(),
				AuthCodeUtils.AUTH_CODE_VALID_TIME);
		// 2.获取店铺及店主信息校验
		MemberDto findM = new MemberDto();
		findM.setPhone(dto.getMobilePhone());
		FindMemberPage findMemberPage = new FindMemberPage();
		findMemberPage.setParam(findM);
		List<MemberDto> ms = memberService.findMembers(findMemberPage);
		if (ms == null || ms.isEmpty()) {
			throw new TsfaServiceException(ResponseCode.USER_NOT_FIND.getCode(), ResponseCode.USER_NOT_FIND.getMsg());
		} else {
			// 校验存在否以及 状态。
			MemberDto loginMbr = ms.get(0);
			/*
			 * ShopDto findShop = new ShopDto(); findShop.setMbrCode(loginMbr.getCode());
			 * FindShopPage findShopPage = new FindShopPage();
			 * findShopPage.setParam(findShop)
			 */;
			/*
			 * List<ShopDto> shops = shopService.findShops(findShopPage); if (shops == null
			 * || shops.isEmpty()) { throw new
			 * TsfaServiceException(ResponseCode.SHOP_NOT_FIND.getCode(),
			 * ResponseCode.SHOP_NOT_FIND.getMsg()); }
			 */
			if (!MemberStatus.NORMAL.getValue().equals(loginMbr.getStatus())) {
				throw new TsfaServiceException(ResponseCode.USER_UNNORMAL.getCode(),
						ResponseCode.USER_UNNORMAL.getMsg());
			}
//			ShopDto loginShop = shops.get(0);
			/*
			 * if (ShopStatus.IN_APPLY.getValue().equals(loginShop.getStatus())) { throw new
			 * TsfaServiceException(ResponseCode.SHOP_IN_APPLY.getCode(),
			 * ResponseCode.SHOP_IN_APPLY.getMsg()); } if
			 * (!ShopStatus.NORMAL.getValue().equals(loginShop.getStatus())) { throw new
			 * TsfaServiceException(ResponseCode.SHOP_UNNORMAL.getCode(),
			 * ResponseCode.SHOP_UNNORMAL.getMsg()); }
			 */
			// 微店检测导购
			GuidMbrDto guidMbrDto = findGuidMbrByMoblie(loginMbr.getPhone());
			// 正常通过校验，则把token存到DB。
			TokenDto token = login(LoginRoleConstant.IS_B, loginMbr, null, guidMbrDto);
			token.setHasOpenid(StringUtils.isBlank(loginMbr.getOpenId()) ? false : true);// 返回是否已绑定微信
			token.setMerchantCode(loginMbr.getMerchantCode());
//			if (ShopUnlogin.NEVER_LOGIN.getValue().equals(loginShop.getUnLogin())) {
//				updateShopHasLogin(loginShop.getCode());// 更新已登录过
//			}
			return token;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.eshop.eis.service.IUserLoginService#getCurrLoginUser(java.lang.String)
	 */
	@Override
	public LoginUserDto getCurrLoginUser(String token) {
		if (StringUtils.isBlank(token)) {
			return null;
		}
		String key = redisKeyPrefix + "_" + token;
		String userJson = redisCache.get(key);
		if (StringUtils.isBlank(userJson)) {//
			return null;
//			throw new TsfaServiceException(
//					ResponseCode.TOKEN_INVALID.getCode(), null);
		}
		LoginUserDto user = JsonUtils.toObj(userJson, LoginUserDto.class);
		// 刷新token时效
//		redisClient.setex(key, TokenUtils.VALID_TIME, userJson);
		redisCache.set(key, userJson, TokenUtils.VALID_TIME);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.eshop.eis.service.IUserLoginService#findMemberDtoByPhone(java.lang.
	 * String)
	 */
	@Override
	public MemberDto findMemberDtoByPhone(String phone) {
		// 2.获取店铺及店主信息校验
		MemberDto findM = new MemberDto();
		findM.setPhone(phone);
		FindMemberPage findMemberPage = new FindMemberPage();
		findMemberPage.setParam(findM);
		List<MemberDto> ms = memberService.findMembers(findMemberPage);
		if (ms == null || ms.isEmpty()) {
			return null;
		} else {
			// 校验存在否以及 状态。
			MemberDto mbr = ms.get(0);
			if (ms.size() > 1) {// 一个手机号查出了多个用户，系统异常。
				throw new TsfaServiceException(ResponseCode.SYS_ERROR.getCode(), ResponseCode.SYS_ERROR.getMsg());
			}
			return mbr;
		}
	}

	/**
	 * 
	 *
	 * 方法说明：openId获取会员信息
	 *
	 * @param openId
	 * @return
	 * @throws Exception
	 *
	 * @author 段志鹏 CreateDate: 2017年9月5日
	 *
	 */
	@Override
	public MemberDto getMemberByOpenId(String openId) {
		MemberDto param = new MemberDto();
		param.setOpenId(openId);
		FindMemberPage findMemberPage = new FindMemberPage();
		findMemberPage.setParam(param);
		List<MemberDto> list = memberService.findMembers(findMemberPage);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 方法说明：C端注册。
	 *
	 * @param wxUser
	 * @param merchantCode
	 * @return
	 *
	 * @author lhy 2017年9月7日
	 *
	 */
	private MemberDto register(WxUserInfoDto wxUser, String merchantCode) {
		MemberDto regMbr = new MemberDto();
		regMbr.setArea(null);
		regMbr.setAvotor(wxUser.getHeadimgurl());
		regMbr.setCity(wxUser.getCity());
		regMbr.setGrade(null);
		// regMbr.setCreateTime(createTime);
		regMbr.setMerchantCode(merchantCode);
		regMbr.setName(wxUser.getNickname());
		regMbr.setOpenId(wxUser.getOpenid());
		regMbr.setProvince(wxUser.getProvince());
		if ("1".equals(wxUser.getSex())) {
			regMbr.setSex(MemberSex.MALE.getValue());
		} else if ("2".equals(wxUser.getSex())) {
			regMbr.setSex(MemberSex.FEMALE.getValue());
		}
		regMbr.setSourceFrom(MemberSourceFrom.SHARE.getValue());
		regMbr.setStatus(MemberStatus.NORMAL.getValue());
		regMbr.setType(MemberType.CLIENT.getValue());
		regMbr.setMyInvite(wxUser.getInviteCode());
		MemberDto regMbrRt = memberService.addMember(regMbr);
		return regMbrRt;
	}

	/**
	 *
	 * 方法说明：登录记录存贮token.
	 *
	 * @param role
	 * @param member
	 * @param shop
	 * @return
	 *
	 * @author lhy 2017年9月7日
	 *
	 */
	private TokenDto login(String role, MemberDto member, ShopDto shop, GuidMbrDto guidMbrDto) {
		// 注册完成后 登录。
		LoginUserDto user = new LoginUserDto();
		user.setRole(role);
		user.setMember(member);
		user.setLoginTime(System.currentTimeMillis());
//		user.setShop(shop);
		user.setGuidMbr(guidMbrDto);
		// 生成token,放入缓存
		String token = TokenUtils.createToken(member.getCode(), null);
		user.setToken(token);
		String jsonUser = JsonUtils.toJSON(user);
//		redisClient.setex(redisKeyPrefix + "_" + token, TokenUtils.VALID_TIME, jsonUser);
		redisCache.set(redisKeyPrefix + "_" + token, jsonUser, TokenUtils.VALID_TIME);
		return new TokenDto(token, role);
	}

	/**
	 * 
	 * 方法说明：根据会员ID查找店铺。
	 *
	 * @param mbrCode
	 * @return
	 *
	 * @author lhy 2017年9月7日
	 *
	 */
	private ShopDto getShopDtoByMbrCode(String mbrCode) {
		// 检测有无店铺
		ShopDto findShop = new ShopDto();
		findShop.setMbrCode(mbrCode);
		FindShopPage findShopPage = new FindShopPage();
		findShopPage.setParam(findShop);
		List<ShopDto> shops = shopService.findShops(findShopPage);
		if (shops == null || shops.isEmpty()) {// 没有店则C端登录
			return null;
		} else {
			ShopDto shop = shops.get(0);
			return shop;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.eshop.eis.service.IUserLoginService#regOrLogin(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public ResponseDto regOrLogin(WxUserInfoDto wxUser, String merchantCode) {
		// 0.找用户
		MemberDto mbr = getMemberByOpenId(wxUser.getOpenid());
		if (mbr == null) {// 1.如果未注册在系统，则注册，且登录
			MemberDto regMbrRt = register(wxUser, merchantCode);
			// 注册完成后 登录。
			TokenDto token = login(LoginRoleConstant.IS_C, regMbrRt, null, null);
			return ResponseDto.successResp(token);
		} else {// 2.如果已注册在系统，则登录
				// 有用户先检测用户状态
			if (!MemberStatus.NORMAL.getValue().equals(mbr.getStatus())) {// 用户状态异常则返回
				return ResponseDto.getErrorResponse(ResponseCode.USER_UNNORMAL);
			}

			// 新版电商没有shop,直接用C端身份登录
			TokenDto token = login(LoginRoleConstant.IS_C, mbr, null, null);
			return ResponseDto.successResp(token);

			// 检测有无店铺
			/*
			 * ShopDto loginShop = getShopDtoByMbrCode(mbr.getCode()); if (loginShop ==
			 * null) {// 无店则C登录 TokenDto token=login(LoginRoleConstant.IS_C, mbr,
			 * null,null); return ResponseDto.successResp(token); }else if
			 * (!ShopStatus.NORMAL.getValue().equals(loginShop.getStatus()))
			 * {//不正常的B端，则以C端身份登录 TokenDto token=login(LoginRoleConstant.IS_C, mbr,
			 * loginShop,null); ShopDto shopStatus=new ShopDto();//店铺不正常则把店铺的状态返回给前端，用于前端提示
			 * shopStatus.setCode(loginShop.getCode());
			 * shopStatus.setStatus(loginShop.getStatus());
			 * shopStatus.setCloseReason(loginShop.getCloseReason());
			 * token.setShop(shopStatus);//end return ResponseDto.successResp(token); }else{
			 * GuidMbrDto guidMbrDto = findGuidMbrByMoblie(mbr.getPhone()); // 正常通过则B登录
			 * TokenDto token=login(LoginRoleConstant.IS_B, mbr, loginShop,guidMbrDto);
			 * //检测是否首次登录，首次登录则要提示其是否填写了收获地址，非首次则直接进B端主页 ShopDto shop=new
			 * ShopDto();//店铺是否首次登录状态查出去，并把收获地址带过去，用于前端提示 shop.setCode(loginShop.getCode());
			 * shop.setUnLogin(loginShop.getUnLogin());
			 * shop.setShopProvide(loginShop.getShopProvide()==null?"":loginShop.
			 * getShopProvide());
			 * 
			 * token.setShop(shop);//end
			 * if(ShopUnlogin.NEVER_LOGIN.getValue().equals(loginShop.getUnLogin())){
			 * updateShopHasLogin(loginShop.getCode());//更新已登录过 } return
			 * ResponseDto.successResp(token); }
			 */
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.eshop.eis.service.IUserLoginService#loginAgain(java.lang.String)
	 */
	@Override
	public ResponseDto loginAgain() {
		LoginUserDto loginUser = UserTokenThreadLocal.get();
		if (LoginRoleConstant.IS_C.equals(loginUser.getRole())) {
			MemberDto mbr = loginUser.getMember();
			// 检测有无店铺
			ShopDto loginShop = getShopDtoByMbrCode(mbr.getCode());
			if (loginShop == null) {// 无店则保留原来的token C
				TokenDto token = new TokenDto(loginUser.getToken(), LoginRoleConstant.IS_C);
				return ResponseDto.successResp(token);
			} else if (!ShopStatus.NORMAL.getValue().equals(loginShop.getStatus())) {// 不正常的B端，
																						// 则以C端身份登录,不换token,只是查出店铺状态
				TokenDto token = new TokenDto(loginUser.getToken(), LoginRoleConstant.IS_C);
				ShopDto rtShop = new ShopDto();// 店铺不正常则把店铺的状态返回给前端，用于前端提示
				rtShop.setCode(loginShop.getCode());
				rtShop.setStatus(loginShop.getStatus());
				rtShop.setCloseReason(loginShop.getCloseReason());

				token.setShop(rtShop);
				return ResponseDto.successResp(token);
			} else {// 身份更换了，则删除旧的token,重新登录新token
				redisCache.del(redisKeyPrefix + "_" + loginUser.getToken());
				// 微店检测导购
				GuidMbrDto guidMbrDto = findGuidMbrByMoblie(mbr.getPhone());
				// 正常通过则B登录
				TokenDto token = login(LoginRoleConstant.IS_B, mbr, loginShop, guidMbrDto);
				// 检测是否首次登录，首次登录则要提示其是否填写了收获地址，非首次则直接进B端主页
				ShopDto shop = new ShopDto();// 店铺是否首次登录状态查出去，并把收获地址带过去，用于前端提示
				shop.setCode(loginShop.getCode());
				shop.setUnLogin(loginShop.getUnLogin());
				shop.setShopProvide(loginShop.getShopProvide() == null ? "" : loginShop.getShopProvide());

				token.setShop(shop);// end
				if (ShopUnlogin.NEVER_LOGIN.getValue().equals(loginShop.getUnLogin())) {
					updateShopHasLogin(loginShop.getCode());// 更新已登录过
				}
				return ResponseDto.successResp(token);
			}
		} else {// 本身就是B端不重新登录，直接返回原token并提示非首次登录
			ShopDto shop = new ShopDto();
			shop.setCode(loginUser.getShop().getCode());
			shop.setUnLogin(ShopUnlogin.HAS_LOGIN.getValue());
			TokenDto token = new TokenDto(loginUser.getToken(), LoginRoleConstant.IS_B);
			token.setShop(shop);
			return ResponseDto.successResp(token);
		}
	}

	/***
	 * 方法说明：更新店铺已登录过。
	 * 
	 * @param code 店铺code
	 *
	 * @author lhy 2017年9月7日
	 *
	 */
	private void updateShopHasLogin(String code) {
		ShopDto shop = new ShopDto();//
		shop.setCode(code);
		shop.setUnLogin(ShopUnlogin.HAS_LOGIN.getValue());
		shopService.updateShop(shop);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.eshop.eis.service.IUserLoginService#bindOpenId(com.lj.eshop.eis.dto.
	 * WxUserInfoDto)
	 */
	@Override
	public void bindOpenId(WxUserInfoDto wxUser, MemberDto memberDto) {
//		LoginUserDto loginUser = UserTokenThreadLocal.get();
		// 0.找用户
		MemberDto mbr = getMemberByOpenId(wxUser.getOpenid());// 检查openID是否已经被绑定。
		if (mbr == null) {// 1.如果未绑定，则绑定到当前用户信息上
			MemberDto updateMy = new MemberDto();
			updateMy.setCode(memberDto.getCode());

			if (StringUtils.isNotBlank(memberDto.getOpenId())) {// 检查自己是否已经绑定openID，已经绑定则提示。
				throw new TsfaServiceException(ResponseCode.OPEN_ID_NOT_NULL.getCode(),
						ResponseCode.OPEN_ID_NOT_NULL.getMsg());
			}
			updateMy.setOpenId(wxUser.getOpenid());
			updateMy.setAvotor(wxUser.getHeadimgurl());
			updateMy.setPassword(MD5.encryptByMD5(memberDto.getPassword()));
			memberService.updateMember(updateMy);

			// 同步更新redis中token信息
//			MemberDto redisMemberDto = memberDto;
//			redisMemberDto.setCode(memberDto.getCode());
//			redisMemberDto.setOpenId(wxUser.getOpenid());
//			redisMemberDto.setAvotor(wxUser.getHeadimgurl());
//			loginUser.setMember(redisMemberDto);
//			String jsonUser = JsonUtils.toJSON(loginUser);
//			redisClient.setex(redisKeyPrefix + "_" + loginUser.getToken(), TokenUtils.VALID_TIME, jsonUser);
//			redisCache.set(redisKeyPrefix + "_" + loginUser.getToken(), jsonUser, TokenUtils.VALID_TIME);
		} else {// 2.已绑定提示
			if (memberDto.getCode().equals(mbr.getCode())) {// 绑定人是自己，不作任何操作
				return;
			}
			throw new TsfaServiceException(ResponseCode.OPEN_ID_IS_EXIST.getCode(),
					ResponseCode.OPEN_ID_IS_EXIST.getMsg());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lj.eshop.eis.service.IUserLoginService#logout()
	 */
	@Override
	public void logout() {
		// 登出直接清token
		LoginUserDto loginUser = UserTokenThreadLocal.get();
		if (loginUser != null) {
			redisCache.del(redisKeyPrefix + "_" + loginUser.getToken());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.eshop.eis.service.IUserLoginService#appLogin(com.lj.eshop.eis.dto.
	 * MobilePhoneLoginDto)
	 */
	@Override
	public TokenDto appLogin(MobilePhoneLoginDto loginDto) {
		if (loginDto == null || StringUtils.isEmpty(loginDto.getMobilePhone())
				|| StringUtils.isEmpty(loginDto.getPassword())) {
			throw new TsfaServiceException(ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg());
		}
		// 1.根据手机号查找用户所属电商,且验证身份及状态
		MemberDto loginMbr = findMemberDtoByPhone(loginDto.getMobilePhone());
		ShopDto loginShop = null;
		if (loginMbr == null) {
			throw new TsfaServiceException(ResponseCode.USER_NOT_FIND.getCode(), ResponseCode.USER_NOT_FIND.getMsg());
		}
		if (!MemberStatus.NORMAL.getValue().equals(loginMbr.getStatus())) {
			throw new TsfaServiceException(ResponseCode.USER_UNNORMAL.getCode(), ResponseCode.USER_UNNORMAL.getMsg());
		}
		// 校验店存在否以及 状态。
		loginShop = getShopDtoByMbrCode(loginMbr.getCode());
		if (loginShop == null) {
			throw new TsfaServiceException(ResponseCode.SHOP_NOT_FIND.getCode(), ResponseCode.SHOP_NOT_FIND.getMsg());
		}
		if (ShopStatus.IN_APPLY.getValue().equals(loginShop.getStatus())) {
			throw new TsfaServiceException(ResponseCode.SHOP_IN_APPLY.getCode(), ResponseCode.SHOP_IN_APPLY.getMsg());
		}
		if (!ShopStatus.NORMAL.getValue().equals(loginShop.getStatus())) {
			throw new TsfaServiceException(ResponseCode.SHOP_UNNORMAL.getCode(), ResponseCode.SHOP_UNNORMAL.getMsg());
		}
		// 2.根据手机号查找会员体系导购信息
		GuidMbrDto mbrDto = findGuidMbrAndCheck(loginDto.getMobilePhone(), loginDto.getPassword());
		// 3.以上通过的时候设置token
		TokenDto token = login(LoginRoleConstant.IS_B_APP, loginMbr, loginShop, mbrDto);
		token.setMerchantCode(loginMbr.getMerchantCode());
		token.setGuidMbr(mbrDto);// APP需要使用会员体系的导购信息
		String uploadUrl = localCacheSystemParams.getSystemParam(SystemAliasName.ms.toString(),
				SystemParamConstant.UPLOAD_GROUP, SystemParamConstant.UPLOAD_URL);
		String wxUpdateUrl = localCacheSystemParams.getSystemParam(Constans.CC_EIS_SYSTEMALIASNAME,
				Constans.CC_EC_APP_VERSION, Constans.CC_EC_KEY_ANDRIOD_WXUPDATEURL);
		ConfigDto configDto = new ConfigDto();
		configDto.setUploadUrl(uploadUrl);
		configDto.setWxUpdateUrl(wxUpdateUrl);
		token.setConfig(configDto);
		return token;
	}

	/**
	 * 方法说明：根据手机号查导购。
	 *
	 * @param moblie
	 * @return
	 *
	 * @author lhy 2017年9月20日
	 *
	 */
	private GuidMbrDto findGuidMbrByMoblie(String moblie) {
		FindGuidMemberReturn guidMember = guidMemberService.findGuidMemberByMoblie_ec(moblie);
		GuidMbrDto mbrDto = toGuidMbrDto(guidMember);
		return mbrDto;
	}

	/**
	 * 方法说明：根据导购编号找导购.暂时不使用,unchecked.
	 *
	 * @param memberNo
	 * @param password 非空则校验 否则不校验。
	 * @return
	 * 
	 * @author lhy 2017年10月10日
	 *
	 */
	private GuidMbrDto findGuidMbrByMemberNoAndCheck(String memberNo, String password) {
		// 1.根据电商会员找到导购进行修改
		FindGuidMember findGuidMember = new FindGuidMember();
		findGuidMember.setMemberNo(memberNo);
		FindGuidMemberReturn guidMbr = null;
		guidMbr = guidMemberService.findGuidMember(findGuidMember);
		if (guidMbr == null) {
			throw new TsfaServiceException(ResponseCode.GUID_MEMBER_NOT_EXIST.getCode(),
					ResponseCode.GUID_MEMBER_NOT_EXIST.getMsg());
		}
		if (StringUtils.isNotEmpty(password) && !guidMbr.getPwd().equals(MD5.encryptByMD5(password))) {
			throw new TsfaServiceException(ResponseCode.GUID_MEMBER_PWD_ERROR.getCode(),
					ResponseCode.GUID_MEMBER_PWD_ERROR.getMsg());
		}
		if (MemberStatus.FREEZE.toString().equals(guidMbr.getStatus())) {
			logger.error("个人会员登录错误：会员被冻结！");
			throw new TsfaServiceException(ResponseCode.USER_UNNORMAL.getCode(), "个人会员登录错误：会员被冻结！");
		}
		if (MemberStatus.CANCEL.toString().equals(guidMbr.getStatus())) {
			logger.error("个人会员登录错误：会员被注销！");
			throw new TsfaServiceException(ResponseCode.USER_UNNORMAL.getCode(), "个人会员登录错误：会员被注销！");
		}
		GuidMbrDto mbrDto = toGuidMbrDto(guidMbr);
		return mbrDto;

	}

	/**
	 * 方法说明：根据手机号查找会员体系导购信息.
	 *
	 * @param moblie
	 * @param password
	 * @return
	 *
	 * @author lhy 2017年9月20日
	 *
	 */
	private GuidMbrDto findGuidMbrAndCheck(String moblie, String password) {
		FindGuidMemberReturn guidMember = guidMemberService.findGuidMemberByMoblie_ec(moblie);
		if (guidMember == null) {
			throw new TsfaServiceException(ResponseCode.GUID_MEMBER_NOT_EXIST.getCode(),
					ResponseCode.GUID_MEMBER_NOT_EXIST.getMsg());
		}
		if (!guidMember.getPwd().equals(MD5.encryptByMD5(password))) {
			throw new TsfaServiceException(ResponseCode.GUID_MEMBER_PWD_ERROR.getCode(),
					ResponseCode.GUID_MEMBER_PWD_ERROR.getMsg());
		}
		if (MemberStatus.FREEZE.toString().equals(guidMember.getStatus())) {
			logger.error("个人会员登录错误：会员被冻结！");
			throw new TsfaServiceException(ResponseCode.USER_UNNORMAL.getCode(), "个人会员登录错误：会员被冻结！");
		}
		if (MemberStatus.CANCEL.toString().equals(guidMember.getStatus())) {
			logger.error("个人会员登录错误：会员被注销！");
			throw new TsfaServiceException(ResponseCode.USER_UNNORMAL.getCode(), "个人会员登录错误：会员被注销！");
		}
		GuidMbrDto mbrDto = toGuidMbrDto(guidMember);
		return mbrDto;
	}

	/**
	 * 方法说明：对象转换。
	 * 
	 * @param mbrRt
	 * @return
	 *
	 * @author lhy 2017年9月19日
	 *
	 */
	private GuidMbrDto toGuidMbrDto(FindGuidMemberReturn mbrRt) {
		if (mbrRt == null) {
			return null;
		}
		GuidMbrDto mbrDto = new GuidMbrDto();
		mbrDto.setCode(mbrRt.getCode());
		mbrDto.setMemberName(mbrRt.getMemberName());
		mbrDto.setMemberNo(mbrRt.getMemberNo());
		mbrDto.setMerchantName(mbrRt.getMerchantName());
		mbrDto.setMerchantNo(mbrRt.getMerchantNo());
		mbrDto.setShopName(mbrRt.getShopName());
		mbrDto.setShopNo(mbrRt.getShopNo());
		mbrDto.setNoWx(mbrRt.getNoWx());
		return mbrDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.eshop.eis.service.IUserLoginService#checkShopAndUserStatus(com.lj.
	 * eshop.eis.dto.LoginUserDto)
	 */
	@Override
	public void checkShopAndUserStatus(LoginUserDto dto) {
		if (dto == null) {
			return;
		}
		logger.info("检测用户状态start。");
		String tokenRedisKey = redisKeyPrefix + "_" + dto.getToken();
		// 1.从redis拿最新的状态
		// 2.若redis没有最新状态则从DB拿，并存贮其状态到redis有效期（5分钟）
		/*
		 * ShopDto shop = dto.getShop(); if (shop != null &&
		 * (LoginRoleConstant.IS_B.equals(dto.getRole()) ||
		 * LoginRoleConstant.IS_B_APP.equals(dto.getRole()))) {// B端才去检测其店铺状态 ShopDto
		 * rtShop = null; // 从redis拿 String key = redisKeyPrefix + "_shop_" +
		 * shop.getCode(); String objJson = redisCache.get(key); if
		 * (StringUtils.isNotBlank(objJson)) { rtShop = JsonUtils.toObj(objJson,
		 * ShopDto.class); } if (rtShop == null) { ShopDto shopParam = new ShopDto();
		 * shopParam.setCode(shop.getCode()); rtShop = shopService.findShop(shopParam);
		 * // 刷新到redis String jsonShop = JsonUtils.toJSON(rtShop); //
		 * redisClient.setex(key, USER_VALID_SECOND, jsonShop); redisCache.set(key,
		 * jsonShop, USER_VALID_SECOND); } if (rtShop == null) {
		 * redisCache.del(tokenRedisKey);// 校验不通过把token和用户信息都从redis删除
		 * redisCache.del(key); throw new
		 * TsfaServiceException(ResponseCode.SHOP_NOT_FIND.getCode(),
		 * ResponseCode.SHOP_NOT_FIND.getMsg()); } if
		 * (ShopStatus.IN_APPLY.getValue().equals(rtShop.getStatus())) {
		 * redisCache.del(tokenRedisKey);// 校验不通过把token和用户信息都从redis删除
		 * redisCache.del(key); throw new
		 * TsfaServiceException(ResponseCode.SHOP_IN_APPLY.getCode(),
		 * ResponseCode.SHOP_IN_APPLY.getMsg()); } if
		 * (!ShopStatus.NORMAL.getValue().equals(rtShop.getStatus())) {
		 * redisCache.del(tokenRedisKey);// 校验不通过把token和用户信息都从redis删除
		 * redisCache.del(key); throw new
		 * TsfaServiceException(ResponseCode.SHOP_UNNORMAL.getCode(),
		 * ResponseCode.SHOP_UNNORMAL.getMsg()); } }
		 */
		MemberDto user = dto.getMember();
		if (user != null) {
			MemberDto rtMbr = null;
			// 从redis拿
			String key = redisKeyPrefix + "_user_" + user.getCode();
			String objJson = redisCache.get(key);
			logger.info("objJson={}",objJson);
			if (StringUtils.isNotBlank(objJson)) {
				rtMbr = JsonUtils.toObj(objJson, MemberDto.class);
			}
			if (rtMbr == null) {
				MemberDto mbrParam = new MemberDto();
				mbrParam.setCode(user.getCode());
				rtMbr = memberService.findMember(mbrParam);
				// 刷新到redis
				String jsonMbr = JsonUtils.toJSON(rtMbr);
//				redisClient.setex(key, USER_VALID_SECOND, jsonMbr);
				redisCache.set(key, jsonMbr, USER_VALID_SECOND);
			}
			if (!MemberStatus.NORMAL.getValue().equals(rtMbr.getStatus())) {
				redisCache.del(tokenRedisKey);// 校验不通过把token和用户信息都从redis删除
				redisCache.del(key);
				throw new TsfaServiceException(ResponseCode.USER_UNNORMAL.getCode(),
						ResponseCode.USER_UNNORMAL.getMsg());
			}
		}
		logger.info("检测用户状态end,is ok。");
	}

	public static void main(String[] args) {
		String pwd = MD5.encryptByMD5("666666");
		System.out.println(pwd);
	}
}
