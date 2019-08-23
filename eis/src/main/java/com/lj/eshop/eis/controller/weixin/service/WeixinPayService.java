/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.weixin.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.FindPaymentPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.eis.config.SysConfig;
import com.lj.eshop.eis.constant.DevConfig;
import com.lj.eshop.eis.controller.weixin.config.WeixinConfigDto;
import com.lj.eshop.eis.controller.weixin.config.WxCfgConstant;
import com.lj.eshop.eis.controller.weixin.dto.WxPayNotifyDataDto;
import com.lj.eshop.eis.controller.weixin.dto.WxPayReqDataDto;
import com.lj.eshop.eis.controller.weixin.dto.WxPayReqDto;
import com.lj.eshop.eis.controller.weixin.dto.WxPayResDataDto;
import com.lj.eshop.eis.controller.weixin.dto.WxPayRespDto;
import com.lj.eshop.eis.controller.weixin.util.HttpsRequest;
import com.lj.eshop.eis.controller.weixin.util.Util;
import com.lj.eshop.eis.controller.weixin.util.WeixinSignUtil;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.redis.RedisClient;
import com.lj.eshop.eis.service.impl.MbrGuidMemberService;
import com.lj.eshop.eis.utils.HttpClientUtils;
import com.lj.eshop.eis.utils.JsonUtils;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.PaymentStatus;
import com.lj.eshop.service.IMemberRankApplyService;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IPaymentService;
import com.lj.eshop.service.IShopService;

/**
 * 
 * 类说明：微信公众号支付API对接。
 *  
 * 	1、商户server调用统一下单接口请求订单，api参见公共api【统一下单API】
 *	2、商户server接收支付通知，api参见公共api【支付结果通知API】
 *	3、商户server查询支付结果，api参见公共api【查询订单API】
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月8日
 */
@Service
public class WeixinPayService{
	private static final Logger LOG = LoggerFactory .getLogger(WeixinPayService.class);
	public static final String TICKET_REDIS_KEY_PREFIX = "WX_TICKETREDISKEY_";

	public static final String ACCESS_TOKEN_BIN_PREFIX = "WX_ACCESSTOKENBIN_";

	@Autowired
	private RedisClient redisClient;
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IShopService shopService;
	@Autowired 
	private IMemberRankApplyService memberRankApplyService;
	@Autowired
	private SysConfig sysConfig;
	@Autowired
	private  WeixinApiService weixinApiService;
	@Autowired 
	private MbrGuidMemberService mbrGuidMemberService;
	
	/***
	 * 方法说明：微信公众号预支付。<p>
	 * 1.返回预付单号
	 * 2.返回JSSDK API签名相关的数据
	 * @param payReqDto
	 * @return
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
	public WxPayRespDto prePay(WxPayReqDto payReqDto) {
		MemberDto reqMbr = new MemberDto();
		reqMbr.setCode(payReqDto.getMbrCode());
		MemberDto member = memberService.findMember(reqMbr);
		if(StringUtils.isBlank(member.getOpenId())){
			throw new TsfaServiceException(ResponseCode.OPEN_ID_IS_NULL.getCode(),ResponseCode.OPEN_ID_IS_NULL.getMsg());
		}
		WeixinConfigDto config = weixinApiService.getWeixinConfig(reqMbr.getMerchantCode());
		WxPayRespDto payRespDto;
		try {
			payRespDto = getWechatParams(payReqDto, member, config);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("微信预支付错误。", e);
		}
		return payRespDto;
	}
	
	
	 /**
     * 微信回调
     *
     * @param xmlMsg 回调报文
     * @return 返回给微信的报文。
     */
    public String notifyUrl(String xmlMsg) {
        final String resultOK = "<xml>"
                + "<return_code><![CDATA[SUCCESS]]></return_code>"
                + "<return_msg><![CDATA[OK]]></return_msg>"
                + "</xml>";
        String resultFail = "<xml>"
                + "<return_code><![CDATA[FAIL]]></return_code>"
                + "</xml>";
        try {
            //收到API的返回数据的时候得先验证一下数据有没有被第三方篡改，确保安全
            if (!WeixinSignUtil.checkIsSignValidFromResponseString(xmlMsg)) {
                LOG.error("【交易失败】交易回调返回的数据签名验证失败，有可能数据被篡改了:" + xmlMsg);
                return resultFail;
            }
            WxPayNotifyDataDto postData = (WxPayNotifyDataDto) Util.getObjectFromXML(xmlMsg, WxPayNotifyDataDto.class);
            LOG.debug("wechatPay Callback param:{}", JsonUtils.toJSON(postData));
            PaymentDto s = getPaymentByTradeNo(postData.getOut_trade_no());
            PaymentDto u = new PaymentDto();
            u.setCode(s.getCode());
            if (postData.getReturn_code().equalsIgnoreCase("success") && postData.getResult_code().equalsIgnoreCase("success")) {
                /* 支付成功后修改支付流水状态  */
            	u.setStatus(PaymentStatus.SUCCESS.getValue());
            	s.setStatus(PaymentStatus.SUCCESS.getValue());
            	u.setPaymentDate(new Date());
                s.setPaymentDate(u.getPaymentDate());
            	notifyBizPayRusult(s);
                LOG.info("AccWaterDto Callback param:{}", JsonUtils.toJSON(u));
            } else {
            	u.setStatus(PaymentStatus.FAILURE.getValue());
            	u.setPaymentDate(new Date());
            	LOG.info("支付回调失败:", JsonUtils.toJSON(postData));
            }
            paymentService.updatePayment(u);
        } catch (Exception e) {
            LOG.error("微信支付回调失败", e);
            return resultFail;
        }
        return resultOK;
    }
    
	/**
	*
	* 方法说明：通知支付业务支付成功。
	* @param payment
	*
	* @author lhy  2017年9月8日
	*
	*/
	private void notifyBizPayRusult(PaymentDto payment){
		try{
			// 对业务逻辑进行处理 修改数据库
			if (AccWaterSource.ORDER.getValue().equals(payment.getAccSource())) {
				orderService.payment(payment);// 通知订单支付成功
			} else if (AccWaterSource.DEPOSIT.getValue().equals(payment.getAccSource())) {
				shopService.payment(payment);
				 mbrGuidMemberService.addGuidMember(payment.getBizNo());
			} else if (AccWaterSource.VIP.getValue().equals(payment.getAccSource())) {
				memberRankApplyService.payment(payment);
			}
		} catch (Exception e) {//异常不外抛
			LOG.error("支付成功，通知业务异常。", e);
		}
	}
    /**
     * 方法说明：获取支付流水。
     *
     * @param thirdpartyTradeNo
     * @return
     *
     * @author lhy  2017年9月8日
     *
     */
    private PaymentDto getPaymentByTradeNo(String thirdpartyTradeNo ){
		FindPaymentPage findPaymentPage=new FindPaymentPage();
		PaymentDto param=new PaymentDto();
		param.setThirdpartyTradeNo(thirdpartyTradeNo);
		findPaymentPage.setParam(param);
		List<PaymentDto> water=paymentService.findPayments(findPaymentPage);
		if (water == null || water.isEmpty()) {
			return null;
		} 
		return water.get(0);
	}
 
	/**
	 * 方法说明：获取JSAPI 鉴权的票据。
	 * @param config
	 * @return
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
	private String getJsapiTicket(WeixinConfigDto config) {
		String tokenKey = ACCESS_TOKEN_BIN_PREFIX + config.getAppid();
		String token = redisClient.get(tokenKey);
		if (StringUtils.isBlank(token)) {
			token = getBinAccessToken(config);
			redisClient.setex(tokenKey, 7200, token); // 将access_token做缓存设置7200秒过期时间
		}
		String ticketKey = TICKET_REDIS_KEY_PREFIX + config.getAppid();
		String ticket = redisClient.get(ticketKey);
		if (StringUtils.isBlank(ticket)) {
			ticket = getAccessToken(token);
			redisClient.setex(ticketKey, 7200, ticket); // 将jsapi_ticket做缓存设置7200秒过期时间
		}
		return ticket;
	}
	/**
	 *
	 * 方法说明：微信预支付请求参数签名。
	 *
	 * @param payReqDto
	 * @param member
	 * @param config
	 * @return
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
	private Map<String, Object> getWechatSignParams(WxPayReqDto payReqDto,MemberDto member,WeixinConfigDto config){
		String random = WeixinSignUtil.createRandomNumber(32); //生成随机数
		Map<String, Object> map=new HashMap<String, Object>();
    	map.put("openid", member.getOpenId());
    	map.put("body", payReqDto.getBody());
    	map.put("out_trade_no", payReqDto.getOutTradeNo());
    	map.put("total_fee", payReqDto.getTotalFee());
    	map.put("spbill_create_ip", payReqDto.getSpbillCreateIp());
    	map.put("appid", config.getAppid());
        map.put("mch_id", config.getMchId());
        map.put("nonce_str", random);
        map.put("notify_url", sysConfig.getWxPayNotifyUrl());
        map.put("trade_type", WxCfgConstant.TRADE_TYPE);
        String sign = WeixinSignUtil.getSign(map,config);
        map.put("sign", sign);
        //map.put("random", random);
		LOG.info("wxNotifyUrl：" + sysConfig.getWxPayNotifyUrl());
		return map;
	}
	/**
	 *
	 * 方法说明：调用API进行微信预支付。
	 *
	 * @param payReqDto
	 * @param member
	 * @param config
	 * @return
	 * @throws IllegalAccessException
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
    private WxPayRespDto getWechatParams(WxPayReqDto payReqDto,MemberDto member,WeixinConfigDto config) throws IllegalAccessException {
    	Map<String, Object> map=getWechatSignParams(payReqDto, member, config);//生成签名参数
        String random =(String)map.get("nonce_str"); //生成随机数
        String timestamp = Long.toString(System.currentTimeMillis() / 1000); //支付签名时间戳
        String openId = (String) map.get("openid");
        String wxPrepayid = null;//生成的预付单号
		// 封装请求数据
		WxPayReqDataDto reqData = new WxPayReqDataDto();
		reqData.setAppid(config.getAppid());
		reqData.setMch_id(config.getMchId());
		reqData.setNonce_str(random);
		reqData.setSign((String)map.get("sign"));
		reqData.setBody((String) map.get("body"));
		reqData.setOut_trade_no((String) map.get("out_trade_no"));
		reqData.setTotal_fee((BigDecimal) map.get("total_fee"));
		reqData.setSpbill_create_ip((String) map.get("spbill_create_ip"));
		reqData.setNotify_url(sysConfig.getWxPayNotifyUrl());
		reqData.setOpenid(openId);
		reqData.setTrade_type(WxCfgConstant.TRADE_TYPE);
		try {
			if(DevConfig.isDevTest()){
				wxPrepayid=System.currentTimeMillis()+"";//模拟成功的预付单号
			}else{
				// 调用统一支付接口
				String result = HttpsRequest.sendPost(WxCfgConstant.UNIFIEDORDER_URL, reqData);
				// 转换返回数据
				WxPayResDataDto payResData = (WxPayResDataDto) Util
						.getObjectFromXML(result, WxPayResDataDto.class);
				if (payResData == null || payResData.getReturn_code() == null) {
					throw new RuntimeException(
							"【支付失败】支付请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问:"
									+ result);
				}
				if (payResData.getReturn_code().equals("FAIL")) {
					// 注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
					throw new RuntimeException("【支付失败】支付API系统返回失败，请检测Post给API的数据是否规范合法:" + result);
				} else {
					// 收到API的返回数据的时候得先验证一下数据有没有被第三方篡改，确保安全
					if (!WeixinSignUtil.checkIsSignValidFromResponseString(result)) {
						throw new RuntimeException( "【支付失败】支付请求API返回的数据签名验证失败，有可能数据被篡改了:" + result);
					}
					if (payResData.getResult_code().equals("SUCCESS")) { // 预支付订单成功
						String prePayId = payResData.getPrepay_id();
						wxPrepayid = prePayId;
					} else {
						String errorCode = payResData.getErr_code();// 获取错误码
						String errorCodeDes = payResData.getErr_code_des();// 获取错误描述
						// 出现业务错误
						throw new RuntimeException("业务返回失败,err_code:" + errorCode + ",err_code_des" + errorCodeDes);
					}
				}
			}

        } catch (Exception e) {
        	throw new RuntimeException("调用微信统一订单接口错误", e);
        }
		//预付信息 签名及封装
		String signType="MD5";
        Map<String, Object> signMap = new HashMap<>();
        signMap.put("appId", config.getAppid());
        signMap.put("timeStamp", timestamp);
        signMap.put("nonceStr", random);
        signMap.put("signType", signType);
		signMap.put("package", "prepay_id=" + wxPrepayid);
        String paySign = "";
        paySign = WeixinSignUtil.getSign(signMap,config);
        //JS 签名及封装
        String ticketSign = getJsapiSign(config, random, timestamp, payReqDto.getUrl());
        //封装返回
        WxPayRespDto payRespDto=new WxPayRespDto();
		payRespDto.setAppId(config.getAppid());
		payRespDto.setNonceStr(random);
		payRespDto.setPaySign(paySign);
		payRespDto.setPrepayId(wxPrepayid);
		payRespDto.setPrepayId((String)signMap.get("package"));
		payRespDto.setSignType(signType);
		payRespDto.setTimeStamp(timestamp);
		payRespDto.setTicketSign(ticketSign);
        return payRespDto;
    }
     
    /**
     * 
     *
     * 方法说明：JS sdk 权限验证配置。
     *
     * @param url （当前网页的URL，不包含#及其后面部分） 
     * @param merchantCode 电商系统的商户号
     * @return JS sdk 权限验证配置相关数据。<link>https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115M</link>
     *
     * @author lhy  2017年9月12日
     *
     */
    public  Map<String, Object> getJsapiSign(String url ,String merchantCode){
    	String random = WeixinSignUtil.createRandomNumber(32); //生成随机数
    	WeixinConfigDto config = weixinApiService.getWeixinConfig(merchantCode);
    	String timestamp = Long.toString(System.currentTimeMillis() / 1000); //时间戳
    	
    	String ticket = getJsapiTicket(config);
    	LOG.info("js ticket:"+ticket);
    	//采用sha1加密
    	String ticketSign = getJsapiSign(ticket, random, timestamp, url);
      	
    	Map<String, Object> jsSdkSign = new HashMap<>();
    	jsSdkSign.put("appId", config.getAppid());
    	jsSdkSign.put("nonceStr", random);
    	jsSdkSign.put("timestamp", timestamp);
    	jsSdkSign.put("signature", ticketSign);
        return jsSdkSign;
    }
    
    /**
     * 方法说明：获取微信JSSDK API签名。
     * @param config  公众号配置
     * @param random
     * @param timestamp
     * @param url
     * @return
     *
     * @author lhy  2017年9月8日
     *
     */
    private String getJsapiSign(WeixinConfigDto config,String random,String timestamp,String url){
    	 String ticket = getJsapiTicket(config);
         String ticketSign = getJsapiSign(ticket, random, timestamp, url);
         return ticketSign;
    }
    /**
     * 方法说明：获取微信JSSDK API签名。
     * @param jsapiTicket 
     * @param random
     * @param timestamp
     * @param url
     * @return
     *
     * @author lhy  2017年9月8日
     *
     */
    private String getJsapiSign(String jsapiTicket,String random,String timestamp,String url){
    	 Map<String, Object> ticketSignMap = new HashMap<>();
         ticketSignMap.put("jsapi_ticket", jsapiTicket);
         ticketSignMap.put("noncestr", random);
         ticketSignMap.put("timestamp", timestamp);
         ticketSignMap.put("url", url);//url（当前网页的URL，不包含#及其后面部分
         //采用sha1加密
         String ticketSign = WeixinSignUtil.getSha1Sign(ticketSignMap);
         return ticketSign;
    }
    
    /**
     * 获取普通token
     *
     * @return
     */
    private String getBinAccessToken(WeixinConfigDto config) {
        String accessToken = "";
        String acsTokenUrl = WxCfgConstant.ACCESSTOKEN_URL + "?grant_type=client_credential&appid=" +config.getAppid() + "&secret=" + config.getAppSecret();
        String acsTokenResult = HttpClientUtils.httpGet(acsTokenUrl);
        LOG.info("acsTokenUrl=========================================" + acsTokenUrl);
        if (!acsTokenResult.equals("") && acsTokenResult != null) {
            JSONObject jsonObject =JSONObject.parseObject(acsTokenResult);
            String errcode=jsonObject.getString("errcode");
			if (StringUtils.isNotBlank(errcode)) {
           	 	throw new TsfaServiceException(errcode,"获取微信公众号access_token失败"+ jsonObject.getString("errmsg"));
            }
            accessToken = jsonObject.getString("access_token");
        }
        
        return accessToken;
    }

    /**
     * 获取jsapi_ticket
     *
     * @return map
     */
    private String getAccessToken(String accessToken) {
        String ticketUrl = WxCfgConstant.TICKET_URL + "?access_token=" + accessToken + "&&type=jsapi";
        String ticketResult = HttpClientUtils.httpGet(ticketUrl);
        String ticket = null;
        if (!ticketResult.equals("") && ticketResult != null) {
            JSONObject jsonObject = JSONObject.parseObject(ticketResult);
            String errcode=jsonObject.getString("errcode");
            ticket = jsonObject.getString("ticket");
            if (StringUtils.isBlank(ticket)) {
           	 	throw new TsfaServiceException(errcode,"获取微信公众号getticket失败"+ jsonObject.getString("errmsg"));
            }
           
        }
        return ticket;
    }
    
    
}
