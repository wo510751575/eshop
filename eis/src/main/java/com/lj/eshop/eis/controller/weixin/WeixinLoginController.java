/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.weixin;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.encryption.MD5;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.controller.weixin.service.WeixinApiService;
import com.lj.eshop.eis.controller.weixin.service.WeixinPayService;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.dto.WxUserInfoDto;
import com.lj.eshop.eis.service.IUserLoginService;
import com.lj.eshop.eis.utils.AuthCodeUtils;
import com.lj.eshop.eis.utils.JsonUtils;
import com.lj.eshop.emus.CodeCheckBizType;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IShopService;

/**
 * 类说明：微信注册对接。
 * <p>
 * （进入微店）
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月6日
 */
@RestController
@RequestMapping("/wx")
public class WeixinLoginController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(WeixinLoginController.class);

	@Autowired
	private WeixinApiService weixinApiService;
	@Autowired
	private IUserLoginService userLoginService;
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IShopService shopService;
	@Autowired
	private WeixinPayService weixinPayService;

	/**
	 * 方法说明：授权认证页。
	 * <p>
	 * 1.用户同意授权，获取code.
	 *
	 * @param url 微信回传code的URL
	 * @return
	 * @author lhy 2017年9月6日
	 *
	 */
	@RequestMapping(value = "/isAuthorize")
	@ResponseBody
	public ResponseDto getAuthorize(String url, String merchantCode) {
		if (StringUtils.isBlank(url) || StringUtils.isBlank(merchantCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		String wxUrl = weixinApiService.getCode(url, merchantCode);
		return ResponseDto.successResp(wxUrl);
	}

	/**
	 * 方法说明：授权认证页。
	 * <p>
	 * 
	 *
	 * @param url 微信回传code的URL
	 * @return
	 * @author lhy 2017年9月6日
	 *
	 */
	@RequestMapping(value = "/base/isAuthorize")
	@ResponseBody
	public ResponseDto getUserinfoAuthorize(String url, String merchantCode) {
		if (StringUtils.isBlank(url) || StringUtils.isBlank(merchantCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		String wxUrl = weixinApiService.getBaseCode(url, merchantCode);
		return ResponseDto.successResp(wxUrl);
	}

//	/**
//     * 2.通过code换取网页授权access_token和openid<p>
//     * 可用于支付，支付时需要openid。
//     * @param code 微信用户code
//     * @return
//     */
//    @RequestMapping(value = "/openid", method = RequestMethod.GET)
//    public ResponseDto getWachatOpid(@RequestParam String code) {
//       Map<String, String> map = weixinApiService.getAccessToken(code);
//       return ResponseDto.successResp(map);
//    }
//	
//	/**
//     * 3.刷新access_token（如果需要）
//     *
//     * @param refreshToken
//     * @return
//     */
//    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
//    public ResponseDto getRefreshToken(@RequestParam(required = true) String refreshToken) {
//         Map<String, String> map = weixinApiService.getRefreshToken(refreshToken);
//        return ResponseDto.successResp(map);
//    }
//
//    /**
//     *
//     * 方法说明：4 第四步：拉取用户信息(需scope为 snsapi_userinfo)
//     *
//     * @param accessToken
//     * @param openid
//     * @return
//     *
//     * @author lhy  2017年9月6日
//     *
//     */
//    public ResponseDto getWeixinUserInfo(String accessToken,String openid){
//    	WxUserInfoDto wxUser = weixinApiService.getUserInfo(openid,accessToken);
//    	 return ResponseDto.successResp(wxUser);
//    }

	/**
	 * 方法说明：微信用户号登录。
	 * 
	 * @param wxCode       微信code
	 * @param merchantCode 商户code
	 * @return
	 *
	 * @author lhy 2017年9月7日
	 *
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto login(String wxCode, String merchantCode, String inviteCode) {
		if (StringUtils.isBlank(wxCode) || StringUtils.isBlank(merchantCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		LOG.info("进入微店[wxCode:" + wxCode + ",merchantCode:" + merchantCode);
		WxUserInfoDto wxUser = null;
//		if (DevConfig.isDevTest()) {
//			wxUser = createWxUserInfo(wxCode);
//		} else {
		wxUser = weixinApiService.getUserInfo(wxCode, merchantCode);
		LOG.info("进入微店获取微信用户：" + JsonUtils.toJSON(wxUser));
//		}
		wxUser.setInviteCode(inviteCode);
		ResponseDto rt = userLoginService.regOrLogin(wxUser, merchantCode);
		LOG.info("进入微店 end " + rt);
		return rt;
	}

	/** 模拟微信公众号获取用户信息 **/
	private WxUserInfoDto createWxUserInfo(String wxCode) {
		WxUserInfoDto dto = new WxUserInfoDto();
		dto.setCity("city" + wxCode);
		dto.setCountry("CN");
		dto.setHeadimgurl(
				"http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46");
		dto.setNickname("nichname" + wxCode);
		dto.setOpenid("openId" + wxCode);
		dto.setProvince("province" + wxCode);
		dto.setSex("1");
		return dto;
	}

	/**
	 * 方法说明：已登录用户，再次进入微店，重新登录.
	 * <p>
	 * 1.原来是C登录的，已有审核通过的店铺则重新登录更换token，换身份为b用户.<br/>
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/login/again", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto loginAgain() {
		LOG.info("进入微店[mbrCode:" + getLoginMemberCode());
		ResponseDto rt = userLoginService.loginAgain();
		LOG.info("进入微店 end " + rt);
		return rt;
	}

	/**
	 * 方法说明： 首批EOMS导入的微店用户，用手机登录后绑定openid信息。
	 * 
	 * @param wxCode 微信code
	 * @return
	 *
	 * @author lhy 2017年9月9日
	 *
	 */
	@RequestMapping(value = "/openid/bind", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto bindOpenId(String wxCode, String mobilePhone, String authCode, String password,
			String merchantCode) {
		if (StringUtils.isBlank(wxCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		if (StringUtils.isEmpty(merchantCode) || StringUtils.isEmpty(mobilePhone) || StringUtils.isEmpty(authCode)
				|| StringUtils.isEmpty(password)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		// 校验验证码
		AuthCodeUtils.validAuthCode(mobilePhone, CodeCheckBizType.OPEN_SHOP.getValue(), authCode,
				AuthCodeUtils.AUTH_CODE_VALID_TIME);
		LOG.info("绑定手机号openId[wxCode:" + wxCode + ",merchantCode:" + merchantCode + ",mobilePhone:" + mobilePhone);

		MemberDto memberDto = userLoginService.findMemberDtoByPhone(mobilePhone);
		if (memberDto == null) {
			return ResponseDto.getErrorResponse(ResponseCode.USER_NOT_FIND);
		}
		memberDto.setPassword(password);
		WxUserInfoDto wxUser = null;
//		if(DevConfig.isDevTest()){
//			wxUser=createWxUserInfo(wxCode);
//		}else{
		wxUser = weixinApiService.getUserInfo(wxCode, merchantCode);
//		}

		userLoginService.bindOpenId(wxUser, memberDto);
		LOG.info("绑定微信openId end.");
		return ResponseDto.successResp(null);
	}

	@RequestMapping(value = "/phoneNumber/bind", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto bindPhoneNumber(String wxCode, String mobilePhone, String authCode, String password,
			String merchantCode) {
		if (StringUtils.isBlank(wxCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		if (StringUtils.isEmpty(merchantCode) || StringUtils.isEmpty(mobilePhone) || StringUtils.isEmpty(authCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		// 校验验证码
		AuthCodeUtils.validAuthCode(mobilePhone, CodeCheckBizType.OPEN_SHOP.getValue(), authCode,
				AuthCodeUtils.AUTH_CODE_VALID_TIME);

		LOG.info("绑定手机号mobilePhone[wxCode:" + wxCode + ",merchantCode:" + merchantCode + ",mobilePhone:" + mobilePhone);
		WxUserInfoDto wxUser = null;
		wxUser = weixinApiService.getUserInfo(wxCode, merchantCode);
		MemberDto memberDto = new MemberDto();
		memberDto.setOpenId(wxUser.getOpenid());
		MemberDto findMember = memberService.findMember(memberDto);
		if (findMember == null) {
			return ResponseDto.getErrorResponse(ResponseCode.USER_NOT_FIND);
		}
		findMember.setPhone(mobilePhone);
		findMember.setPassword(MD5.encryptByMD5(password));
		memberService.updateMember(findMember);

		return ResponseDto.successResp(findMember);

	}

	/**
	 * 方法说明： js sdk 签名。
	 * <p>
	 * 用于 微信 JSSDK使用，比如分享。
	 * 
	 * @param url          当前网页的URL，不包含#及其后面部分
	 * @param merchantCode 电商系统商户号
	 * @return
	 *
	 * @author lhy 2017年9月12日
	 *
	 */
	@RequestMapping(value = "/jsconfig", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto jsSdkSign(String url, String merchantCode) {
		LOG.info("Url:" + url + ",merchantCode:" + merchantCode);
		if (StringUtils.isBlank(url) || StringUtils.isBlank(merchantCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		Map<String, Object> jsSdk = weixinPayService.getJsapiSign(url, merchantCode);
		return ResponseDto.successResp(jsSdk);
	}

}
