/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.banner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.eshop.dto.FindLoadingPage;
import com.lj.eshop.dto.LoadingDto;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.ILoadingService;

/**
 * 
 * 类说明：广告。
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年8月30日
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
	
	@Autowired
	private ILoadingService loadingService;
	
	//0抢货 1进货  开店邀请?
	@RequestMapping(value = { "/list", "" })
	@ResponseBody
	public ResponseDto list(LoadingDto loadingDto){
		FindLoadingPage page=new FindLoadingPage();
		loadingDto.setStatus(Status.USE.getValue());
		page.setParam(loadingDto);
		List<LoadingDto> loadings=loadingService.findLoadings(page);
		return ResponseDto.successResp(loadings);
	}
}
