/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.utils;

import java.util.Random;

import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.CodeCheckDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.SmsCodeSenderRequest;
import com.lj.eshop.eis.dto.SmsCodeVerifyRequest;
import com.lj.eshop.eis.service.impl.SmsCodeService;
import com.lj.eshop.eis.spring.SpringContextUtil;
import com.lj.eshop.service.ICodeCheckService;

/**
 * 
 * 类说明：短信验证码生成器。
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
public class AuthCodeUtils {
	/** 短信验证码有效时长 (秒为单位)*/
	public final static int AUTH_CODE_VALID_TIME = 1800;// 30分钟的有效期
	private final static int AUTH_CODE_LENGTH = 4;
	private final static Random random = new Random();
	private static  ICodeCheckService  codeCheckService = SpringContextUtil.getBean(ICodeCheckService.class);
	private static  SmsCodeService  smsCodeService = SpringContextUtil.getBean(SmsCodeService.class);
	/***
	 * 
	 * 方法说明： 获取4位数长度的验证码。
	 *
	 * @return
	 *
	 * @author lhy 2017年9月2日
	 *
	 */
	private static String getAuthCode() {
		return getAuthCode(AUTH_CODE_LENGTH);
	}

	/** 获取指定长度的验证码 */
	private static String getAuthCode(int length) {
		random.setSeed(System.currentTimeMillis());
		StringBuilder code = new StringBuilder("");
		for (int i = 0; i < length; i++) {
			code.append(random.nextInt(10));
		}
		return code.toString();
	}
	
	
	/**
	 *
	 * 方法说明：发送验证码。
	 *
	 * @param codeCheckDto
	 *
	 * @author lhy  2017年9月2日
	 *
	 */
	public static void sendAuthCode(CodeCheckDto codeCheckDto){
		if(StringUtils.isEmpty(codeCheckDto.getRevicerPhone())||
				StringUtils.isEmpty(codeCheckDto.getBizType())){
			throw  new TsfaServiceException(ResponseCode.PARAM_ERROR.getCode(), "手机号或业务类型为空");
		}
		String senderName=null;
		SmsCodeSenderRequest request=new SmsCodeSenderRequest(codeCheckDto.getRevicerPhone(), senderName, AUTH_CODE_VALID_TIME , codeCheckDto.getBizType());
		smsCodeService.send(request);
	/*	// 1.发送验证码 todo
		String authCode = AuthCodeUtils.getAuthCode();
		// 2.存贮验证码到DB
		codeCheckDto.setSendCode(authCode);
		codeCheckService.addCodeCheck(codeCheckDto);*/
	}
	
	/***
	 * 方法说明：校验验证码。
	 *
	 * @param mobliePhone 手机号
	 * @param biz 短信业务
	 * @param authCode 验证码
	 * @param validTime 有效时长（秒）
	 *
	 * @author lhy  2017年9月2日
	 * @throws TsfaServiceException 
	 */
	public static void validAuthCode(String mobliePhone,String biz,String authCode,int validTime){
		boolean processFlag=false;
		SmsCodeVerifyRequest request=new SmsCodeVerifyRequest(mobliePhone,authCode,processFlag,AUTH_CODE_VALID_TIME,biz);
		smsCodeService.verify(request);
		
//		CodeCheckDto findAuthCode=new CodeCheckDto();
//		findAuthCode.setRevicerPhone(mobliePhone);
//		findAuthCode.setBizType(biz);
//		
//		FindCodeCheckPage findCodeCheckPage=new FindCodeCheckPage();
//		findCodeCheckPage.setParam(findAuthCode);
//		findCodeCheckPage.setStart(0);
//		findCodeCheckPage.setLimit(1);
//		Page<CodeCheckDto> authCodes=codeCheckService.findCodeCheckPage(findCodeCheckPage);
//		List<CodeCheckDto> ps= (List<CodeCheckDto>)authCodes.getRows();
//		
//		if (ps == null || ps.isEmpty()) {
//			throw  new TsfaServiceException(ResponseCode.AUTH_CODE_ERROR.getCode(), "找不到短信验证码");
//		} else {
//			CodeCheckDto rt=ps.get(0);
//			if(!rt.getSendCode().equals(authCode)){
//				throw  new TsfaServiceException(ResponseCode.AUTH_CODE_ERROR.getCode(), "短信验证码不正确");
//			} else if ((System.currentTimeMillis() - rt.getSendTime().getTime()) > validTime) {
//				throw  new TsfaServiceException(ResponseCode.AUTH_CODE_INVALID.getCode(), "短信验证码已过了有效期");
//			}
//		}
	}
}
