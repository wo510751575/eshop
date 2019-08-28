/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.prodcut;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.EvlLikeDto;
import com.lj.eshop.dto.FindEvlLikePage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.service.IEvlLikeService;
import com.lj.eshop.service.IEvlProductService;

/**
 * 
 * 类说明：商品评论点赞。
 *  
 * 
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年8月31日
 */
@RestController
@RequestMapping("/product/evl/like")
public class ProductEvlLikeController extends BaseController{
	
	@Autowired
	private IEvlLikeService evlLikeService;
	
	@Autowired
	private IEvlProductService evlProductService;
	

	/***
	 * 方法说明：评论点赞。
	 *
	 * @param evlLikeDto
	 * @return
	 *
	 * @author lhy  2017年8月31日
	 *
	 */
	@RequestMapping(value = { ""}, method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto addEvlLike(EvlLikeDto evlLikeDto){
		if(StringUtils.isEmpty(evlLikeDto.getEvlCode())){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR, null);
		}
		//0:获取登录用户
		MemberDto meb=getLoginMember();
		// 需求：点赞一个用户一条评论只能点赞一次，不可以取消
		//一：先查是否有该点赞记录 ,有则提示重复
		FindEvlLikePage param=new FindEvlLikePage();
		EvlLikeDto like=new EvlLikeDto();
		like.setEvlCode(evlLikeDto.getEvlCode());
		like.setMbrCode(meb.getCode());
		param.setParam(like);
		List<EvlLikeDto> likes=evlLikeService.findEvlLikes(param);
		if(likes !=null && !likes.isEmpty()){
			return ResponseDto.getErrorResponse(ResponseCode.EVL_LIKE_REPEAT, null);
		}else{
			//二:无则记录且点赞总数加一 
			evlLikeDto.setMbrCode(meb.getCode());
			evlLikeService.addEvlLike(evlLikeDto);
		}
		return ResponseDto.successResp(null);
	}
}
