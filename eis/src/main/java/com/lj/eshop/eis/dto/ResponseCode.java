/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.dto;

import java.util.HashMap;
import java.util.Map;

import com.lj.eshop.constant.ErrorCode;

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
	NO_DATA("100017", "无数据"),
	UPLOAD_ERROR("100018", "上传失败"),
	UPLOAD_TYPE_ERROR("100019", "上传文件格式或大小不正确！"),
	/*** 100101 - 100199 属于商品的模块的错误码 ，请勿乱用  */
	PRODCUT_SOLD_OUT("100101","商品已下架"),
	EVL_LIKE_REPEAT("100102","重复点赞"),
	/*** 100101 - 100199 属于商品的模块的错误码 ，请勿乱用  END */
	
	
	/**100200 - 100300 购物车**/
	BE_CNT("100200","库存不足"),
	CAR_NOT_EXIST("100201","购物车不存在"),
	/**100200 - 100300 购物车 END**/
	
	/**100300 - 100400  验证码/登录相关**/
	AUTH_CODE_ERROR("100300","验证码错误"),
	AUTH_CODE_INVALID("100301","验证码无效"),
	USER_NOT_FIND("100302","用户不存在"),
	SHOP_NOT_FIND("100303","店铺不存在"),
	USER_UNNORMAL("100304","用户不可用"),
	SHOP_UNNORMAL("100305","店铺不可用"),
	SHOP_IN_APPLY("100306","店铺申请中"),
	TOKEN_INVALID("100307","token无效"),
	UN_LOGIN("100308","请登录"),//没检测到登录
	NEED_C_LOGIN("100309","非c端无权限操作"),//非C端登录
	NEED_B_LOGIN("100310","非b端无权限操作"),//非B端登录
	PHONE_REPEAT("100311","手机号重复"),
	PHONE_EXIST("100312","手机号已存在"),
	SMS_TOO_FAST("100313","亲，短信费用好贵哦，请不要频繁发送！"),
	PAY_PWD_UNSET("100314","请设置提现密码！"),
	PAY_PWD_ERROR("100315","提现密码错误！"),
	BANKCARD_REPEAT("100316","重复的银行卡！"),
	SHOP_APPLY_FAILD("100317","店铺申请失败！"),
	PAY_PWD_LOCK("100318","提现密码锁定中！"),
	GUID_MEMBER_NOT_EXIST("100319","导购信息不存在"),
	GUID_MEMBER_PWD_ERROR("100320","登录密码错误"),
	NO_PERMISSION("100321","无权限操作"),//接口无权限操作，身份不对
	/** 100300 - 100350   验证码/登录相关 END***/
	MERCHANT_WXCFG_NULL("100351","商户无微信公众号配置"),
	ACC_WATER_NOT_EXIST("100352","支付流水不存在"),
	ACC_WATER_MORE("100353","支付流水不正常"),
	PAY_REPEAT("100354","订单已支付"),
	PAY_BIZ_NOT_EXIST("100355","支付业务不存在"),
	PAY_TYPE_NOT_EXIST("100356","不支持的支付方式"),
	OPEN_ID_IS_NULL("100357","微信号未授权"),
	OPEN_ID_IS_EXIST("100358","您的微信号已被绑定"),
	OPEN_ID_NOT_NULL("100359","您已绑定微信号"),
	WXCODE_BEEN_USED("40163","微信code已被使用"),
	WXCODE_INVALID("40029","微信code已失效"),
	WXCODE_INVALID_IP("40164","服务器IP不在白名单内"),
	/**100300 - 100400   验证码/登录相关 END**/
	
	/*** 100400 - 100500 申请退货相关  */
	ORDER_RETIRE_STATUS_FAIL("100400","订单状态有误"),
	ORDER_RETIRE_TIME_EXPIRE("100410","收货已超24小时"),
	/*** 100400 - 100500申请退货相关  END */
	
	/**100600 - 100700 虚拟资金相关**/
	ACC_UNDERBALANCE("100600","可用余额不足！"),
	ACC_AMT_MUST_MORE_THAN_ZERO("100601","提现金额必须大于0"),
	/**100600 - 100700 虚拟资金相关END**/
	

	/*** 100800 - 100900 特权相关  */
	MEMBER_RANK_APPLY_FAIL("100800","尚有特权未审核，暂时无法再申请"),
	MEMBER_RANK_APPLY_NOT_FOUND("100810","该特权暂未提供，请以后再试"),
	MEMBER_RANK_APPLY_FAIL_DISABLED_BUY_DOWN("100813","不允许购买比现拥有特权更低阶的特权"),
	MEMBER_RANK_APPLY_NOT_FOUND_BUY("100820","暂未查询到购买特权的记录"),
	MEMBER_RANK_APPLY_EXTIRED("100830","特权已过期"),
	MEMBER_RANK_APPLY_NOT_YET_AMT("100840","特权租凭金额已超该特权最大金额，现可用额度余"),
	MEMBER_RANK_APPLY_NOT_YET_TIMES("100850","特权租凭次数已超该特权最大次数"),
	MEMBER_RANK_APPLY_NOT_YET_STORAGE("100860","库存不足"),
	/*** 100800 - 100900 特权相关  END */
	
	/*** 100900 - 101000 押金退出申請相关  */
	SHOP_RETIRE_APPLY_FAIL("100900","尚有押金申请未审核，暂时无法再申请"),
	SHOP_RETIRE_APPLY_FAIL_SUCCESS("100901","已有押金申请通过，禁止再申请"),
	/*** 100900 - 101000 押金退出特权相关  END */
	
	/*** 1001000 - 101100 开店相关  */
	OPEN_SHOP_NON_PAYMENT("1001000","尚未支付押金"),
	OPEN_SHOP_HAVEN_SHOP_ERROR("1001003","您已开店，请不要重复申请"),
	OPEN_SHOP_HAVEN_SHOP_STOP_ERROR("1001003","您的店已被关闭，请联系客服"),
	OPEN_SHOP_VALID_PHONE_SHOP_ERROR("1001004","该手机号已被注册"),
	/*** 1001000 - 101100 开店相关   END */
	
	
	/*** 101101 - 101200 订单相关  */
	ORDER_ADD_ERROR("101101","创建订单失败"),
	ORDER_SHIPPED_ERROR("101102","订单发货失败"),
	ORDER_CANCEL_ERROR("101103","订单取消失败"),
	ORDER_PAYMENT_ERROR("101104","订单支付失败"),
	ORDER_RETURNS_ERROR("101105","订单退货失败"),
	/*** 101101 - 101200 订单相关   END */
	
	;

	private static final Map<String, ResponseCode> ERROR_MAP = new HashMap<String, ResponseCode>();
	static {
		ERROR_MAP.put(ResponseCode.SYS_ERROR.getCode(), ResponseCode.SYS_ERROR);
		ERROR_MAP.put(ResponseCode.ACCESS_VALID.getCode(),ResponseCode.ACCESS_VALID);
		ERROR_MAP.put(ResponseCode.PARAM_ERROR.getCode(),ResponseCode.PARAM_ERROR);
		ERROR_MAP.put(ResponseCode.AUTH_CODE_ERROR.getCode(),ResponseCode.AUTH_CODE_ERROR);
		ERROR_MAP.put(ResponseCode.AUTH_CODE_INVALID.getCode(),ResponseCode.AUTH_CODE_INVALID);
		ERROR_MAP.put(ResponseCode.USER_NOT_FIND.getCode(),ResponseCode.USER_NOT_FIND);
		ERROR_MAP.put(ResponseCode.SHOP_NOT_FIND.getCode(),ResponseCode.SHOP_NOT_FIND);
		ERROR_MAP.put(ResponseCode.USER_UNNORMAL.getCode(),ResponseCode.USER_UNNORMAL);
		ERROR_MAP.put(ResponseCode.SHOP_UNNORMAL.getCode(),ResponseCode.SHOP_UNNORMAL);
		ERROR_MAP.put(ResponseCode.SHOP_IN_APPLY.getCode(),ResponseCode.SHOP_IN_APPLY);
		ERROR_MAP.put(ResponseCode.TOKEN_INVALID.getCode(),ResponseCode.TOKEN_INVALID);
		ERROR_MAP.put(ResponseCode.UN_LOGIN.getCode(),ResponseCode.UN_LOGIN);
		ERROR_MAP.put(ResponseCode.NEED_C_LOGIN.getCode(),ResponseCode.NEED_C_LOGIN);
		ERROR_MAP.put(ResponseCode.NEED_B_LOGIN.getCode(),ResponseCode.NEED_B_LOGIN);
		ERROR_MAP.put(ResponseCode.PHONE_REPEAT.getCode(),ResponseCode.PHONE_REPEAT);
		ERROR_MAP.put(ResponseCode.PHONE_EXIST.getCode(),ResponseCode.PHONE_EXIST);
		ERROR_MAP.put(ResponseCode.PAY_PWD_UNSET.getCode(),ResponseCode.PAY_PWD_UNSET);
		ERROR_MAP.put(ResponseCode.ACC_UNDERBALANCE.getCode(),ResponseCode.ACC_UNDERBALANCE);
		ERROR_MAP.put(ResponseCode.ACC_AMT_MUST_MORE_THAN_ZERO.getCode(), ResponseCode.ACC_AMT_MUST_MORE_THAN_ZERO);
		ERROR_MAP.put(ResponseCode.PAY_PWD_ERROR.getCode(), ResponseCode.PAY_PWD_ERROR);
		ERROR_MAP.put(ResponseCode.BANKCARD_REPEAT.getCode(), ResponseCode.BANKCARD_REPEAT);
		ERROR_MAP.put(ResponseCode.SHOP_APPLY_FAILD.getCode(), ResponseCode.SHOP_APPLY_FAILD);
		ERROR_MAP.put(ResponseCode.MERCHANT_WXCFG_NULL.getCode(), ResponseCode.MERCHANT_WXCFG_NULL);
		ERROR_MAP.put(ResponseCode.ACC_WATER_NOT_EXIST.getCode(), ResponseCode.ACC_WATER_NOT_EXIST);
		ERROR_MAP.put(ResponseCode.ACC_WATER_MORE.getCode(), ResponseCode.ACC_WATER_MORE);
		ERROR_MAP.put(ResponseCode.PAY_REPEAT.getCode(), ResponseCode.PAY_REPEAT);
		ERROR_MAP.put(ResponseCode.PAY_BIZ_NOT_EXIST.getCode(), ResponseCode.PAY_BIZ_NOT_EXIST);
		ERROR_MAP.put(ResponseCode.PAY_TYPE_NOT_EXIST.getCode(), ResponseCode.PAY_TYPE_NOT_EXIST);
		ERROR_MAP.put(ResponseCode.OPEN_ID_IS_NULL.getCode(), ResponseCode.OPEN_ID_IS_NULL);
		ERROR_MAP.put(ResponseCode.OPEN_ID_IS_EXIST.getCode(), ResponseCode.OPEN_ID_IS_EXIST);
		ERROR_MAP.put(ResponseCode.OPEN_ID_NOT_NULL.getCode(), ResponseCode.OPEN_ID_NOT_NULL);
		ERROR_MAP.put(ResponseCode.PAY_PWD_LOCK.getCode(), ResponseCode.PAY_PWD_LOCK);
		ERROR_MAP.put(ResponseCode.WXCODE_BEEN_USED.getCode(), ResponseCode.WXCODE_BEEN_USED);
		ERROR_MAP.put(ResponseCode.WXCODE_INVALID.getCode(), ResponseCode.WXCODE_INVALID);
		ERROR_MAP.put(ResponseCode.GUID_MEMBER_NOT_EXIST.getCode(), ResponseCode.GUID_MEMBER_NOT_EXIST);
		ERROR_MAP.put(ResponseCode.GUID_MEMBER_PWD_ERROR.getCode(), ResponseCode.GUID_MEMBER_PWD_ERROR);
		ERROR_MAP.put(ResponseCode.WXCODE_INVALID_IP.getCode(), ResponseCode.WXCODE_INVALID_IP);
		ERROR_MAP.put(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION);
		
		// *****业务服务抛出的错误在此做映射
		ERROR_MAP.put(ErrorCode.LOADING_NOT_EXIST_ERROR,ResponseCode.NO_DATA);
		ERROR_MAP.put(ErrorCode.SMS_CODE_ERROR,ResponseCode.AUTH_CODE_ERROR);
		ERROR_MAP.put(ErrorCode.SMS_CODE_EXIST,ResponseCode.SMS_TOO_FAST);
		ERROR_MAP.put(ErrorCode.ACC_UNDERBALANCE,ResponseCode.ACC_UNDERBALANCE);
		ERROR_MAP.put(ErrorCode.PRODUCT_LOWSTOCK_ERROR,ResponseCode.BE_CNT);
		ERROR_MAP.put(ErrorCode.SHOP_STOP_ERROR,ResponseCode.USER_UNNORMAL);
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
