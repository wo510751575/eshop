/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.SuggestionDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.service.ISuggestionService;

/**
 * 
 * 类说明：意见与建议
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 彭俊霖
 * 
 *         CreateDate: 2017年9月5日
 */
@RestController
@RequestMapping("/suggestion")
public class SuggestionController extends BaseController {

	@Autowired
	private ISuggestionService suggestionService;

	/**
	 * 方法说明： 意见与建议添加
	 * @param  意见与建议	suggestion
	 * 
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月5日
	 */
	@RequestMapping(value = {"add"},method=RequestMethod.POST)
	@ResponseBody
	public ResponseDto add(SuggestionDto suggestionDto) {
		logger.info("SuggestionController --> add() - start", suggestionDto); 
		if(suggestionDto==null || StringUtils.isEmpty(suggestionDto.getSuggestion())){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		//如果当前用户已登录,录入当前会员信息
		if(getLoginMember()!=null){
			suggestionDto.setMbrCode(getLoginMemberCode());
			suggestionDto.setMbrName(getLoginMember().getName());
		}
		suggestionService.addSuggestion(suggestionDto);
		logger.info("SuggestionController --> add(={}) - end");
		return ResponseDto.successResp(null);
	}
	
	
}
