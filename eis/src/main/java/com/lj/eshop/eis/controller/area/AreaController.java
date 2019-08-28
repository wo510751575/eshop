/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.area;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月1日
 */
@RestController
@RequestMapping("/sys/area")
public class AreaController {
	private static Logger logger = LoggerFactory.getLogger(AreaController.class);
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
	
	/**
	 * 
	 *
	 * 方法说明：获取所有省市区
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月4日
	 *
	 */
	@RequestMapping(value="findAllList",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDto findAllList() {
		logger.debug("FindProvinceAndCityarea() - start"); //$NON-NLS-1$
		List<Area> returnList = areaHessianService.findAllList();
		logger.debug("cityarea(String parentId={}) - end"); //$NON-NLS-1$
		return ResponseDto.successResp(returnList);
	}
}
