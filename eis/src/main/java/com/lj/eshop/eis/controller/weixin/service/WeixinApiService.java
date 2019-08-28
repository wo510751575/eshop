/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.weixin.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.FindMerchantSettingPage;
import com.lj.eshop.dto.MerchantSettingDto;
import com.lj.eshop.eis.controller.account.AccountController;
import com.lj.eshop.eis.controller.weixin.config.WeixinConfigDto;
import com.lj.eshop.eis.controller.weixin.config.WxCfgConstant;
import com.lj.eshop.eis.controller.weixin.util.WeixinSignUtil;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.WxUserInfoDto;
import com.lj.eshop.eis.utils.HttpClientUtils;
import com.lj.eshop.emus.MerchantSettingStatus;
import com.lj.eshop.service.IMerchantSettingService;



/**
 * 
 * 类说明：微信公众号授权API对接。<p>
 *  
 * 	1 第一步：用户同意授权，获取code
 *	2 第二步：通过code换取网页授权access_token
 *	3 第三步：刷新access_token（如果需要）
 *	4 第四步：拉取用户信息(需scope为 snsapi_userinfo)
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月6日
 */
@Service
public class WeixinApiService {
	private static final Logger LOG = LoggerFactory .getLogger(AccountController.class);
	
	private static final String WEIXIN_PREFIX="weixin.";
	private static final String WEIXIN_APPID="weixin.appid";
	private static final String WEIXIN_MCHID="weixin.mchId";
	private static final String WEIXIN_APPSECRET="weixin.appSecret";
	private static final String WEIXIN_APIKEY="weixin.apiKey";
	@Autowired
	private IMerchantSettingService merchantSettingService;
	
	/**
	 *
	 * 方法说明：根据微信的商户号找到电商系统的商户公众号配置信息。
	 *
	 * @param wxMchId 微信商户号
	 * @return
	 *
	 * @author lhy  2017年9月11日
	 *
	 */
	public WeixinConfigDto getWeixinConfigByWxMchId(String wxMchId){
		FindMerchantSettingPage find=new FindMerchantSettingPage();
		MerchantSettingDto param=new MerchantSettingDto();
		find.setParam(param);
		param.setName(WEIXIN_MCHID);
		param.setValue(wxMchId);
		param.setStatus(MerchantSettingStatus.USE.getValue());
		List<MerchantSettingDto> configs = merchantSettingService.findMerchantSettings(find);
		if (configs != null && !configs.isEmpty()) {
			MerchantSettingDto cfg=configs.get(0);
			return getWeixinConfig(cfg.getMerchantCode());
		}else{
			//检测未配置该商户号则提示。
			throw new TsfaServiceException(ResponseCode.MERCHANT_WXCFG_NULL.getCode(), ResponseCode.MERCHANT_WXCFG_NULL.getMsg());
		}
	}
	
	/**
	 *
	 * 方法说明：根据电商商户号找微信公众号配置信息。
	 *
	 * @param merchantCode 电商商户code
	 * @return
	 *
	 * @author lhy  2017年9月11日
	 *
	 */
	protected WeixinConfigDto getWeixinConfig(String merchantCode){
		WeixinConfigDto config=null;
		
		FindMerchantSettingPage find=new FindMerchantSettingPage();
		MerchantSettingDto param=new MerchantSettingDto();
		find.setParam(param);
		param.setName(WEIXIN_PREFIX);
		param.setMerchantCode(merchantCode);
		param.setStatus(MerchantSettingStatus.USE.getValue());
		
		Map<String, String> wxMap=new HashMap<String, String>();
		List<MerchantSettingDto> configs = merchantSettingService.findMerchantSettings(find);
		if (configs != null && !configs.isEmpty()) {
			for (Iterator<MerchantSettingDto> iterator = configs.iterator(); iterator.hasNext();) {
				MerchantSettingDto ele = (MerchantSettingDto) iterator.next();
				wxMap.put(ele.getName(), ele.getValue());
			}
			config=new WeixinConfigDto();
			config.setApiKey(wxMap.get(WEIXIN_APIKEY));
			config.setAppid(wxMap.get(WEIXIN_APPID));
			config.setMchId(wxMap.get(WEIXIN_MCHID));
			config.setAppSecret(wxMap.get(WEIXIN_APPSECRET));
		}
		
		if(config==null || StringUtils.isBlank(config.getApiKey())
				|| StringUtils.isBlank(config.getAppid())
				|| StringUtils.isBlank(config.getMchId())
				|| StringUtils.isBlank(config.getAppSecret())){
			//检测未配置完整微信公众号信息则抛异常。
			throw new TsfaServiceException(ResponseCode.MERCHANT_WXCFG_NULL.getCode(), ResponseCode.MERCHANT_WXCFG_NULL.getMsg());
		}
		return config;
	}
	
	 /**
     * 刷新access_token
     *
     * @param refreshToken 
     * @param merchantCode 商户号
     * @return
     */
    public Map<String, String> getRefreshToken(String refreshToken,String merchantCode) {
		Map<String, String> map = new HashMap<>();
		if (refreshToken != null) {
			String result = this.refreshToken(refreshToken,merchantCode);
			if (!result.equalsIgnoreCase("") && refreshToken != null) {
				JSONObject jsonObject = JSONObject.parseObject(result);
				try {
					// access_token
					// 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
					// expires_in access_token接口调用凭证超时时间，单位（秒）
					// refresh_token 用户刷新access_token
					// openid 用户唯一标识
					// scope
					map.put("openid", jsonObject.getString("openid"));
					map.put("refreshToken",jsonObject.getString("refresh_token"));
					map.put("accessToken", jsonObject.getString("access_token"));
				} catch (Exception e) {
					throw new RuntimeException("刷新token异常",e);
				}
			}
		}
		return map;
    }

    /**
     * 刷新refreshToken获取openid
     * 
     * @param refreshToken
     * @param merchantCode 商户号
     * @return
     */
    private String refreshToken(String refreshToken,String merchantCode) {
		WeixinConfigDto config = getWeixinConfig(merchantCode);
        Map<String, String> params = new HashMap<>();
        String param = "";
        try {
            params.put("appid", config.getAppid());
            params.put("grant_type", "refresh_token");
            params.put("refresh_token", refreshToken);
            param = WeixinSignUtil.createGetReqParam(params, false);
        } catch (Exception e) {
        	throw new RuntimeException("刷新refreshToken失败", e);
            //LOG.error("刷新refreshToken失败", e);
        }
        param = WxCfgConstant.REFRESH_TOKEN_URL + "?" + param;
        return HttpClientUtils.httpGet(param);
    }
    

    /**
     * 获取公众号access_token和openid
     * @param code 用户授权的code 
     * @param merchantCode 商户号
     * @return
     */
    private Map<String, String> getAccessToken(String code,String merchantCode) {
        String result = "";
        Map<String, String> resultMap = new HashMap<>();
        try {
        	WeixinConfigDto config = getWeixinConfig(merchantCode);
            Map<String, String> map = new HashMap<>();
            map.put("appid",config.getAppid());
            map.put("code", code);
            map.put("grant_type", "authorization_code");
            map.put("secret",config.getAppSecret());
            String url = WxCfgConstant.ACSTOKEN_URL + "?" + WeixinSignUtil.createGetReqParam(map, false);
            result = HttpClientUtils.httpGet(url);
            if (!result.equals("") && result != null) {
//              access_token	网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
//              expires_in	access_token接口调用凭证超时时间，单位（秒）
//              refresh_token	用户刷新access_token
//              openid	用户唯一标识
//              scope
                JSONObject jsonObject = JSONObject.parseObject(result);
                String errcode=jsonObject.getString("errcode");
                if(StringUtils.isNotBlank(errcode)){
                	 throw new TsfaServiceException(errcode,"获取微信公众号token失败"+ jsonObject.getString("errmsg"));
                }
                resultMap.put("openid", jsonObject.getString("openid"));
                resultMap.put("refreshToken", jsonObject.getString("refresh_token"));
                resultMap.put("accessToken", jsonObject.getString("access_token"));
            }
        } catch (Exception e) {
        	 throw new RuntimeException("获取微信公众号token失败", e);
        	 //LOG.error("获取微信公众号token失败", e);
        }
        return resultMap;
    }
    
    /**
     * 方法说明：拼接code获取url.<p>
     * 弹出授权页面,授权。
     * @param url
     * @param merchantCode 商户号
     * @return
     *
     * @author lhy  2017年9月7日
     *
     */
    public String getCode(String url,String merchantCode) {
        Map<String, String> params = new HashMap<>();
        String param = "";
        try {
        	WeixinConfigDto config = getWeixinConfig(merchantCode);
            params.put("appid", config.getAppid());
            params.put("redirect_uri", URLEncoder.encode(url, "UTF-8"));
            params.put("response_type", "code");
            params.put("scope", "snsapi_userinfo"); // snsapi_base（不弹出授权页面，只能拿到用户openid）snsapi_userinfo
            // （弹出授权页面，这个可以通过 openid 拿到昵称、性别、所在地）
            params.put("state", merchantCode+"#wechat_redirect");
            param = WeixinSignUtil.createGetReqParam(params, false);
        } catch (Exception e) {
        	LOG.error("拼接字符串失败", e);
        	throw new RuntimeException("拼接字符串失败", e);
        }
        return WxCfgConstant.REQCODE_URL + "?" + param;
    }
    
    /**
     * 方法说明：拼接code获取url.<br>
     * 直接静默授权。
     * @param url
     * @param merchantCode 商户号
     * @return
     *
     * @author lhy  2017年9月7日
     *
     */
    public String getBaseCode(String url,String merchantCode) {
        Map<String, String> params = new HashMap<>();
        String param = "";
        try {
        	WeixinConfigDto config = getWeixinConfig(merchantCode);
            params.put("appid", config.getAppid());
            params.put("redirect_uri", URLEncoder.encode(url, "UTF-8"));
            params.put("response_type", "code");
            params.put("scope", "snsapi_base"); // snsapi_base（不弹出授权页面，只能拿到用户openid）snsapi_userinfo
            // （弹出授权页面，这个可以通过 openid 拿到昵称、性别、所在地）
            params.put("state", merchantCode+"#wechat_redirect");
            param = WeixinSignUtil.createGetReqParam(params, false);
        } catch (Exception e) {
        	LOG.error("拼接字符串失败", e);
        	throw new RuntimeException("拼接字符串失败", e);
        }
        return WxCfgConstant.REQCODE_URL + "?" + param;
    }
    /**
     * 方法说明：拿取微信用户信息。
     * @todo
     * @param openId
     * @param accessToken
     * @param merchantCode 商户号
     * @return
     *
     * @author lhy  2017年9月6日
     *
     */
	private WxUserInfoDto getUserInfo(String openId,String accessToken,String merchantCode) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("access_token", accessToken);
		map.put("openid", openId);
		map.put("lang", "zh_CN");
		String url;
		try {
			url = WxCfgConstant.GET_USER_INFO + "?"+ WeixinSignUtil.createGetReqParam(map, false);
		} catch (UnsupportedEncodingException e) {
			 throw new RuntimeException("获取用户信息异常。",e);
		}
		LOG.info("微信获取用户信息url："+url);
		String result = HttpClientUtils.httpGet(url);
		LOG.info("微信获取用户信息结果："+result);
		JSONObject jsonObject=JSONObject.parseObject(result);
		String errcode=jsonObject.getString("errcode");
        if(StringUtils.isNotBlank(errcode)){
        	 throw new TsfaServiceException(errcode,"微信获取用户信息失败,"+ jsonObject.getString("errmsg"));
        }
		WxUserInfoDto userInfoDto=new WxUserInfoDto();
		userInfoDto.setOpenid(jsonObject.getString("openid"));
		userInfoDto.setNickname(jsonObject.getString("nickname"));
		userInfoDto.setSex(jsonObject.getString("sex"));
		userInfoDto.setProvince(jsonObject.getString("province"));
		userInfoDto.setCity(jsonObject.getString("city"));
		userInfoDto.setHeadimgurl(jsonObject.getString("headimgurl"));
		userInfoDto.setUnionid(jsonObject.getString("unionid"));
		String ps=jsonObject.getString("privilege");
		if (StringUtils.isNoneBlank(ps)) {
			JSONArray p = JSONObject.parseArray(ps);
			if(p!=null){
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < p.size(); i++) {
					list.add(p.get(i).toString());
				}
				userInfoDto.setPrivilege(list);
			}
		}
		LOG.info("微信获取用户信息结果userInfoDto--->："+userInfoDto.toString());
		return userInfoDto;
	}
	/**
	 * 方法说明：通过微信code 获取微信用户信息。
	 *
	 * @param wxCode
	 * @param merchantCode 商户号
	 * @return
	 *
	 * @author lhy  2017年9月7日
	 *
	 */
	public WxUserInfoDto getUserInfo(String wxCode,String merchantCode){
		//1.获取 access_token及open id
		Map<String, String> tokens=getAccessToken(wxCode,merchantCode);
		//2.获取用户信息
		WxUserInfoDto user=getUserInfo(tokens.get("openid"),tokens.get("accessToken"),merchantCode);
		return user;
	}

}
