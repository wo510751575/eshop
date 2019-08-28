/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.dto;

import java.io.Serializable;

import com.lj.base.exception.TsfaContextServiceException;
import com.lj.base.exception.TsfaServiceException;

/**
 * 
 * 类说明：eis请求返回对象。
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年8月24日
 */
public class ResponseDto implements Serializable {
	private static final long serialVersionUID = -7629309590846227983L;
	/*** 操作是否成功.true 成功 false失败 */
	private boolean result;

	/** * 返回结果Code. */
	private String code;

	/** * 返回结果信息. */
	private String msg;

	/** * 返回数据的对象（操作成功才有）. */
	private Object data;

	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
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
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	public static ResponseDto successResp(Object respData) {
		return createResp(Boolean.TRUE, "", "", respData);
	}

	public static ResponseDto successResp() {
		return createResp(Boolean.TRUE, "", "", "");
	}

	public static ResponseDto createResp(boolean isSucess, String errorCode, String errorMessage, Object respData) {
		ResponseDto r = new ResponseDto();
		r.setResult(isSucess);
		r.setCode(errorCode);
		r.setMsg(errorMessage);
		r.setData(respData);
		return r;
	}

	/**
	 * 方法说明：构建错误影响信息。。
	 *
	 * @param responseCode
	 * @param respData
	 * @return
	 *
	 * @author lhy 2017年8月31日
	 *
	 */
	public static ResponseDto getErrorResponse(String code, String msg) {
		return createResp(Boolean.FALSE, code, msg, null);
	}

	/**
	 * 方法说明：构建错误影响信息。。
	 *
	 * @param responseCode
	 * @param respData
	 * @return
	 *
	 * @author lhy 2017年8月31日
	 *
	 */
	public static ResponseDto getErrorResponse(ResponseCode responseCode, Object respData) {
		return createResp(Boolean.FALSE, responseCode.getCode(), responseCode.getMsg(), respData);
	}

	/**
	 * 方法说明：构建错误影响信息。
	 *
	 * @param responseCode
	 * @param respData
	 * @return
	 *
	 * @author lhy 2017年8月31日
	 *
	 */
	public static ResponseDto getErrorResponse(ResponseCode responseCode) {
		return getErrorResponse(responseCode, null);
	}

	/**
	 * 异常返回对象。
	 * 
	 * @param e
	 * @return
	 *
	 * @author lhy 2017年8月24日
	 *
	 */
	public static ResponseDto generateFailureResponse(Throwable e) {
		ResponseCode responseCode = null;
		if (e instanceof TsfaContextServiceException) {
			TsfaContextServiceException et = (TsfaContextServiceException) e;
			responseCode = getErrorResponse(et);
		} else if (e.getCause() != null && e.getCause() instanceof TsfaContextServiceException) {
			TsfaContextServiceException et = (TsfaContextServiceException) e.getCause();
			responseCode = getErrorResponse(et);
		} else if (e instanceof TsfaServiceException) {
			TsfaServiceException et = (TsfaServiceException) e;
			responseCode = getErrorResponse(et);
		} else if (e.getCause() != null && e.getCause() instanceof TsfaServiceException) {
			TsfaServiceException et = (TsfaServiceException) e.getCause();
			responseCode = getErrorResponse(et);
		} else if (e instanceof IllegalArgumentException) {
			responseCode = ResponseCode.PARAM_ERROR;
		} else if (e.getCause() != null && e.getCause() instanceof IllegalArgumentException) {
			responseCode = ResponseCode.PARAM_ERROR;
		} else {
			responseCode = ResponseCode.SYS_ERROR;
		}
		return createResp(Boolean.FALSE, responseCode.getCode(), responseCode.getMsg(), null);
	}

	/**
	 * 
	 *
	 * 方法说明：根据业务服务异常获取系统响应码。
	 *
	 * @param e
	 * @return
	 *
	 * @author lhy 2017年8月24日
	 *
	 */
	private static ResponseCode getErrorResponse(Throwable e) {
		if (e instanceof TsfaServiceException) {
			TsfaServiceException et = (TsfaServiceException) e;
			String errorCode = et.getExceptionCode();
			return ResponseCode.getResponseCode(errorCode);
		}
		return ResponseCode.SYS_ERROR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseDto [result=" + result + ", code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
