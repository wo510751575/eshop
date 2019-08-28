/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.weixin;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.controller.weixin.service.WeixinPayService;
import com.lj.eshop.eis.controller.weixin.util.WeixinSignUtil;

/**
 * 类说明：微信支付回调接口。
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy  CreateDate: 2017年9月8日
 */
@RestController
@RequestMapping("/wx/pay")
public class WxPayNotifyController extends BaseController{
	private static final Logger LOG = LoggerFactory .getLogger(WxPayNotifyController.class);
	@Autowired
	private WeixinPayService weixinPayService;
	
	 /**
     * 微信支付成功回调接口.
     *
     * @param request  请求下
     * @param response 返回
     * @return	
     * @throws Exception 异常
     */
    @RequestMapping(value = "/notify", method = RequestMethod.POST)
    public void wechatNotifyUrl(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		LOG.info("微信回调开始");
		// post 过来的xml
		ServletInputStream in = request.getInputStream();
		// 转换微信post过来的xml内容
		String xmlMsg = WeixinSignUtil.inputStream2String(in);
		LOG.info("微信回调-微信内容：" + xmlMsg);
		String message = weixinPayService.notifyUrl(xmlMsg);
		LOG.info("微信回调-处理结果：" + message);
		response.getWriter().write(message);
    }
}
