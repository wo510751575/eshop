/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.member;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.FindMyCollPage;
import com.lj.eshop.dto.MyCollDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IMyCollService;
import com.lj.eshop.service.IProductService;

/**
 * 
 * 类说明：我的收藏
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 彭俊霖
 * 
 *         CreateDate: 2017年9月5日
 */
@RestController
@RequestMapping("/myColl")
public class MyCollController extends BaseController {

	@Autowired
	private IMyCollService myCollService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IMemberService memberService;

	/**
	 * 方法说明： 我的收藏列表
	 * 
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月5日
	 */
	@RequestMapping(value = {"list",""})
	@ResponseBody
	public ResponseDto list(MyCollDto myCollDto,Integer pageNo,Integer pageSize) {
		FindMyCollPage findMyCollPage = new FindMyCollPage();
		findMyCollPage.setParam(myCollDto);
		logger.debug("MyCollController --> list() - start", findMyCollPage); 
		
		if(myCollDto==null){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		if(pageNo!=null){
			findMyCollPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findMyCollPage.setLimit(pageSize);
		}
		myCollDto.setMbrCode(getLoginMemberCode());
		findMyCollPage.setParam(myCollDto);
		Page<MyCollDto> myColls=myCollService.findMyCollProductPage(findMyCollPage);
		
		if(myColls.getRows()==null || myColls.getRows().size()<=0){
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		logger.debug("MyCollController --> list(={}) - end", myColls.getRows());
		return ResponseDto.successResp(myColls);
	}
	
	/**
	 * 方法说明： 取消收藏
	 * 
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月6日
	 */
	@RequestMapping(value = {"del"})
	@ResponseBody
	public ResponseDto del(String codes) {
		logger.debug("MyCollController --> del() - start", codes.toString()); 
		if(StringUtils.isEmpty(codes)){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		String mbrCode=getLoginMemberCode();
		if(!codes.contains(",")){
			myCollService.delColl(mbrCode,codes);
		}else{
			String[] split = codes.split(",");
			for (String code : split) {
				myCollService.delColl(mbrCode,code);
			}
		}
		logger.debug("MyCollController --> del(={}) - end", codes.toString());
		return ResponseDto.successResp(null);
	}
	
	/**
	 * 方法说明： 我的收藏- 新增
	 * @param  
	 * 
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月9日
	 */
	@RequestMapping(value = {"add"},method=RequestMethod.POST)
	@ResponseBody
	public ResponseDto add(MyCollDto myCollDto) {
		logger.info("MyCollController --> add() - start", myCollDto);
		if(myCollDto==null || StringUtils.isEmpty(myCollDto.getProductCode())){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		myCollDto.setMbrCode(getLoginMemberCode());
		myCollDto.setCreateDate(new Date());
		myCollService.addMyColl(myCollDto);
		logger.info("MyCollController --> add(={}) - end");
		return ResponseDto.successResp(null);
	}
}
