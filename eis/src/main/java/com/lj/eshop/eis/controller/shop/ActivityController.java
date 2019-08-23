/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.dto.activity.FindActivityPage;
import com.lj.business.cm.dto.activity.FindActivityPageReturn;
import com.lj.business.cm.service.IActivityService;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseDto;

/**
 * 
 * 
 * 类说明：活动
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年9月22日
 */
@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController {
	
	@Autowired
	private IActivityService activityService;
	
	@RequestMapping(value="list")
	@ResponseBody
	public ResponseDto list(Integer pageNo, Integer pageSize) throws TsfaServiceException {
		logger.debug("list(String getLoginMerchantCode={}) - start", getLoginMerchantCode()); 
		FindActivityPage findActivityPage = new FindActivityPage();
		findActivityPage.setMerchantNo(getLoginMerchantCode());
		if(pageNo!=null){
			findActivityPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findActivityPage.setLimit(pageSize);
		}
		Page<FindActivityPageReturn> page = activityService.findActivityPage(findActivityPage);
		logger.debug("list() - end - return value={}", page); //$NON-NLS-1$
		return ResponseDto.successResp(page);
	}
	
}
