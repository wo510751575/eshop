/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.eshop.constant.MerchantSetting;
import com.lj.eshop.dto.MerchantSettingDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.service.IMerchantSettingService;

/**
 * 
 * 类说明：商户配置
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author 彭俊霖
 * 
 *         CreateDate: 2017年9月11日
 */
@RestController
@RequestMapping("/merchant/setting")
public class MerchantSettingController extends BaseController {


	@Autowired
	private IMerchantSettingService merchantSettingService;

	/**
	 * 方法说明： 商户配置列表
	 * 
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月11日
	 */
	@RequestMapping(value = {"list"})
	@ResponseBody
	public ResponseDto list() {
		logger.debug("list --> list(getLoginMerchantCode={}) - start", getLoginMerchantCode());
		Map<String,Object> returnMap = new HashMap<String,Object>();
		
		MerchantSettingDto account=merchantSettingService.findSettingsByName(MerchantSetting.OFFLINE_ACCOUNT, getLoginMerchantCode());
		MerchantSettingDto amt=merchantSettingService.findSettingsByName(MerchantSetting.OFFLINE_AMT, getLoginMerchantCode());
		MerchantSettingDto company=merchantSettingService.findSettingsByName(MerchantSetting.OFFLINE_COMPANY, getLoginMerchantCode());
		MerchantSettingDto bgm=merchantSettingService.findSettingsByName(MerchantSetting.OFFLINE_BGM, getLoginMerchantCode());
		
		returnMap.put("account", account==null?"":account.getValue());
		returnMap.put("amt", amt==null?"":amt.getValue());
		returnMap.put("company", company==null?"":company.getValue());
		returnMap.put("bgm", bgm==null?"":bgm.getValue());
		logger.debug("list --> list(={}) - end", returnMap);
		return ResponseDto.successResp(returnMap);
	}
	
}
