/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.prodcut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.EvlProductDto;
import com.lj.eshop.dto.FindEvlProductPage;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.service.IEvlLikeService;
import com.lj.eshop.service.IEvlProductService;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IProductService;
import com.lj.eshop.service.IProductSkuService;

/**
 * 
 * 类说明：商品评价。
 *  
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年8月31日
 */
@RestController
@RequestMapping("/product/evl")
public class EvlProductController extends BaseController{
	
	@Autowired
	private IEvlProductService evlProductService;
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IProductSkuService productSkuService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IEvlLikeService evlLikeService;
	
	/***
	 * 方法说明：商品评论分页查询。
	 *
	 * @param findEvlProductPage
	 * @return
	 *
	 * @author lhy  2017年8月31日
	 *
	 */
	@RequestMapping(value = { "/list"}, method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto findEvlProduct(FindEvlProductPage findEvlProductPage,Integer pageNo,Integer pageSize){
		if(findEvlProductPage.getParam()==null||StringUtils.isEmpty(findEvlProductPage.getParam().getProductCode())){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR, null);
		}
		findEvlProductPage.getParam().setEvlMbrCode(getLoginMemberCode());//查登录者是否已点赞
		if(pageNo!=null){
			findEvlProductPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findEvlProductPage.setLimit(pageSize);
		}
		Page<EvlProductDto> data =evlProductService.findEvlProductPage(findEvlProductPage);
		return ResponseDto.successResp(data);
	}
	
}
