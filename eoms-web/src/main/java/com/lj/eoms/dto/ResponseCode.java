/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 类说明：系统错误码定义。
 * 
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy CreateDate: 2017年8月24日
 */
public enum ResponseCode {
	// 定义系统错误码
	SYS_ERROR("000000", "系统异常，请稍后再试！"),
	ACCESS_VALID("100015", "非法请求"),
	PARAM_ERROR("100016", "参数错误"),
	PHONE_EXIST("100312","手机号已存在"),
	WXNO_EXIST("100313","微信号已存在"),
	;

	private static final Map<String, ResponseCode> ERROR_MAP = new HashMap<String, ResponseCode>();
	static {
		ERROR_MAP.put(ResponseCode.SYS_ERROR.getCode(), ResponseCode.SYS_ERROR);
		ERROR_MAP.put(ResponseCode.ACCESS_VALID.getCode(),ResponseCode.ACCESS_VALID);
		ERROR_MAP.put(ResponseCode.PARAM_ERROR.getCode(),ResponseCode.PARAM_ERROR);
		ERROR_MAP.put(ResponseCode.PHONE_EXIST.getCode(),ResponseCode.PHONE_EXIST);
		ERROR_MAP.put(ResponseCode.WXNO_EXIST.getCode(),ResponseCode.WXNO_EXIST);
		
		// *****业务服务抛出的错误在此做映射
	}
	
	/** 根据业务错误码返回系统错误 */
	public static ResponseCode getResponseCode(String errorCode) {
		if (ERROR_MAP.containsKey(errorCode)) {
			return ERROR_MAP.get(errorCode);
		}
		return ResponseCode.SYS_ERROR;
	}

	ResponseCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private String code;
	private String msg;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static void main(String[] args) {
		System.out.println(ResponseCode.SYS_ERROR.toString());
	}
}
