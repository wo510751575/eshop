/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.eshop.dto.FindMerchantPage;
import com.lj.eshop.dto.MerchantDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.service.IMerchantService;

/**
 * 
 * 类说明：商户
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 彭俊霖
 * 
 *         CreateDate: 2017年9月9日
 */
@RestController
@RequestMapping("/merchant")
public class MerchantController extends BaseController {

	@Autowired
	private IMerchantService merchantService;

	/**
	 * 方法说明： 商户列表
	 * 
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月5日
	 */
	@RequestMapping(value = {"list",""})
	@ResponseBody
	public ResponseDto list(MerchantDto merchantDto,Integer pageNo,Integer pageSize) {
		FindMerchantPage findMerchantPage = new FindMerchantPage();
		findMerchantPage.setParam(merchantDto);
		logger.debug("MyCollController --> list() - start", findMerchantPage); 
		
		if(merchantDto==null){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		if(pageNo!=null){
			findMerchantPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findMerchantPage.setLimit(pageSize);
		}
		findMerchantPage.setParam(merchantDto);
		Page<MerchantDto> merchants=merchantService.findMerchantPage(findMerchantPage);
		List<MerchantDto> list = new ArrayList<MerchantDto>();
		list.addAll(merchants.getRows());
		
		if(merchants.getRows()==null || list.size()<=0){
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		logger.debug("MyCollController --> list(={}) - end", list);
		return ResponseDto.successResp(merchants);
	}
	
}
