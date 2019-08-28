/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.shop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ape.common.utils.Encodes;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.FindWshopInfoPage;
import com.lj.eshop.dto.WshopInfoDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.IWshopInfoService;

/**
 * 
 * 类说明：微商加油站
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@RestController
@RequestMapping("/wshopinfo")
public class WshopInfoController  extends BaseController{


	@Autowired
	private IWshopInfoService wshopInfoService;

	/**
	 * 微商加油列表
	 * 方法说明：
	 * @param @param pageNo 页码
	 * @param @param pageSize 每页数量
	 * @author 林进权
	 *         CreateDate: 2017年9月4日
	 */
	@RequestMapping(value = {"list"})
	@ResponseBody
	public ResponseDto list(Integer pageNo, Integer pageSize) {
		logger.debug("list() - start", "pageNo>"+pageNo+"--pageSize>"+pageSize); 
		
		FindWshopInfoPage fwshopInfoPage = new FindWshopInfoPage();
		pageNo = pageNo==null?1:pageNo;
		pageSize = pageSize==null || pageSize>500?10:pageSize;
		fwshopInfoPage.setStart((pageNo - 1) * pageSize);
		fwshopInfoPage.setLimit(pageSize);
		fwshopInfoPage.setStatus(Status.USE.getValue());
		
		Page<FindWshopInfoPage> pageDto = wshopInfoService.findWshopInfoPage(fwshopInfoPage);
		List<FindWshopInfoPage> list = new LinkedList<FindWshopInfoPage>();
		list.addAll(pageDto.getRows());
		for (FindWshopInfoPage findWshopInfoPage : list) {
			/*HTML转码*/
			findWshopInfoPage.setDetail(Encodes.unescapeHtml(findWshopInfoPage.getDetail()));
			findWshopInfoPage.setTitle(Encodes.unescapeHtml(findWshopInfoPage.getTitle()));
		}
		
		logger.debug("wshopinfo --> list(={}) - end");
		return ResponseDto.successResp(pageDto);
	}
	/**
	 * 微商加油文章详情
	 * 方法说明：
	 * @param code
	 * @author 林进权
	 *         CreateDate: 2017年9月4日
	 */
	@RequestMapping(value = {"view"})
	@ResponseBody
	public ResponseDto view(String code) {
		logger.debug("WshopInfoController --> view() - start", code); 
		
		if(code==null || StringUtils.isEmpty(code)){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
		FindWshopInfoPage findWshopInfoPage = new FindWshopInfoPage();
		findWshopInfoPage.setCode(code);
			
		WshopInfoDto rDto = wshopInfoService.findWshopInfo(findWshopInfoPage);
		if(rDto==null){
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		/*HTML转码*/
		rDto.setDetail(Encodes.unescapeHtml(rDto.getDetail()));
		rDto.setTitle(Encodes.unescapeHtml(rDto.getTitle()));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantCode", getLoginMerchantCode());
		map.put("info", rDto);
		
		/*阅读量+1*/
		Integer cnt = rDto.getReadCnt()==null?0:(Integer.valueOf(rDto.getReadCnt())+1);
		rDto.setReadCnt(cnt.toString());
		wshopInfoService.updateWshopInfo(rDto);
		
		logger.debug("WshopInfoController --> view(={}) - end");
		return ResponseDto.successResp(map);
	}
	
	/**
	 * 微商加油文章阅读量+1
	 * 方法说明：
	 * @param code 文章code
	 * @author 林进权
	 *         CreateDate: 2017年9月4日
	 */
	@Deprecated
	@RequestMapping(value = {"updRead"})
	@ResponseBody
	public ResponseDto updRead(String code) {
		logger.debug("WshopInfoController --> updRead() - start", code); 
		
		if(code==null || StringUtils.isEmpty(code)){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
		FindWshopInfoPage findWshopInfoPage = new FindWshopInfoPage();
		findWshopInfoPage.setCode(code);
			
		WshopInfoDto rDto = wshopInfoService.findWshopInfo(findWshopInfoPage);
		if(StringUtils.isEmpty(rDto.getReadCnt())) {
			rDto.setReadCnt("1");
		} else {
			rDto.setReadCnt((Integer.valueOf(rDto.getReadCnt())+1)+"");
		}
		
		wshopInfoService.updateWshopInfo(rDto);
		
		logger.debug("WshopInfoController --> updRead(={}) - end");
		return ResponseDto.successResp(null);
	}
	
	/**
	 * 微商加油文分享量+1
	 * 方法说明：
	 * @param code 文章code
	 * @author 林进权
	 *         CreateDate: 2017年9月4日
	 */
	@RequestMapping(value = {"updShare"})
	@ResponseBody
	public ResponseDto updShare(String code) {
		logger.debug("WshopInfoController --> updShare() - start", code); 
		
		if(code==null || StringUtils.isEmpty(code)){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
		FindWshopInfoPage findWshopInfoPage = new FindWshopInfoPage();
		findWshopInfoPage.setCode(code);
			
		WshopInfoDto rDto = wshopInfoService.findWshopInfo(findWshopInfoPage);
		if(StringUtils.isEmpty(rDto.getShareCnt())) {
			rDto.setShareCnt("1");
		} else {
			rDto.setShareCnt((Integer.valueOf(rDto.getShareCnt())+1)+"");
		}
		
		wshopInfoService.updateWshopInfo(rDto);
		
		logger.debug("WshopInfoController --> updShare(={}) - end");
		return ResponseDto.successResp(null);
	}
	
	
}
