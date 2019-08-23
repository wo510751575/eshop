/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.area;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.util.StringUtils;
import com.lj.eoms.entity.sys.Area;
import com.lj.eoms.service.AreaHessianService;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;

/**
 * 
 * 类说明：区域地址维护。
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月1日
 */
@RestController
@RequestMapping("/sys/area")
public class AreaController {

	@Autowired
	private AreaHessianService areaHessianService;
	
	/***
	 * 
	 * 方法说明：获取省份。
	 *
	 * @return
	 *
	 * @author lhy  2017年9月1日
	 *
	 */
	@RequestMapping(value = "/province",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDto findProvince() {
		List<Area> area = areaHessianService.selectProvince();
		return ResponseDto.successResp(area);
	}
	
	
	/***
	 * 
	 * 方法说明：下级地址。
	 *
	 * @return
	 *
	 * @author lhy  2017年9月1日
	 *
	 */
	@RequestMapping(value = "/child",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDto findProvince(String parentId) {
		if(StringUtils.isEmpty(parentId)){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		List<Area> area = areaHessianService.selectAreaByParentId(parentId);
		return ResponseDto.successResp(area);
	}
}
