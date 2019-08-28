/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.member;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.eoms.entity.sys.Area;
import com.lj.eoms.service.AreaHessianService;
import com.lj.eshop.dto.AddrsDto;
import com.lj.eshop.dto.FindAddrsPage;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.AddrsIsDefault;
import com.lj.eshop.service.IAddrsService;

/**
 * 
 * 类说明：我的收货地址
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年9月1日
 */
@RestController
@RequestMapping("/addrs")
public class AddrsController extends BaseController{


	@Autowired
	private IAddrsService addrsService;
	
	@Autowired
	private AreaHessianService areaHessianService;

	/**
	 * 方法说明： 地址列表
	 * @param  会员code	mbrCode	notNull
	 * @param  是否默认 0:是 1:否		isFefault	
	 * @author 林进权
	 * 
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"list"})
	@ResponseBody
	public ResponseDto list(AddrsDto param) {
		FindAddrsPage findAddrsPage = new FindAddrsPage();
		findAddrsPage.setParam(param);
		logger.debug("AddrsController --> list() - start", findAddrsPage); 

		param.setMbrCode(getLoginMemberCode());
		param.setDelFlag("0");
			
		Page<AddrsDto> pageDto = addrsService.findAddrsPage(findAddrsPage);
		if(pageDto.getRows()==null || pageDto.getRows().size()<=0){
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		
		Iterator<AddrsDto> iterator = pageDto.getRows().iterator();
		while(iterator.hasNext()) {
			AddrsDto addrsDto = iterator.next();
			StringBuilder sBuilder = new StringBuilder();
			if(StringUtils.isNotEmpty(addrsDto.getProvinceCode())) {
				List<Area> list = areaHessianService.selectProvince();
				if(list.size()>0) {
					for (Area area : list) {
						if(StringUtils.equals(area.getId(), addrsDto.getProvinceCode())) {
							sBuilder.append(area.getName());
						}
					}
				}
			}
			if(StringUtils.isNotEmpty(addrsDto.getCityCode())) {
				List<Area> list = areaHessianService.selectAreaByParentId(addrsDto.getProvinceCode());
				if(list.size()>0) {
					for (Area area : list) {
						if(StringUtils.equals(area.getId(), addrsDto.getCityCode())) {
							sBuilder.append(area.getName());
						}
					}
				}
			}
			if(StringUtils.isNotEmpty(addrsDto.getAreCode())) {
				List<Area> list = areaHessianService.selectAreaByParentId(addrsDto.getCityCode());
				if(list.size()>0) {
					for (Area area : list) {
						if(StringUtils.equals(area.getId(), addrsDto.getAreCode())) {
							sBuilder.append(area.getName());
						}
					}
				}
			}
			sBuilder.append(addrsDto.getAddrDetail());
			addrsDto.setAddrInfo(sBuilder.toString());
		}
		
		logger.debug("AddrsController --> list(={}) - end", pageDto);
		return ResponseDto.successResp(pageDto);
	}
	
	/**
	 * 方法说明： 地址详情
	 * @param  地址code	code	notNull
	 * @author 林进权
	 * 
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"view"})
	@ResponseBody
	public ResponseDto view(AddrsDto addrsDto) {
		logger.debug("AddrsController --> view() - start", addrsDto); 
		
		if(addrsDto==null || StringUtils.isEmpty(addrsDto.getCode())){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
			
		AddrsDto rDto = addrsService.findAddrs(addrsDto);
		if(rDto==null){
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		
		StringBuilder sBuilder = new StringBuilder();
		if(StringUtils.isNotEmpty(rDto.getProvinceCode())) {
			List<Area> list = areaHessianService.selectProvince();
			if(list.size()>0) {
				for (Area area : list) {
					if(StringUtils.equals(area.getId(), rDto.getProvinceCode())) {
						sBuilder.append(area.getName());
					}
				}
			}
		}
		if(StringUtils.isNotEmpty(rDto.getCityCode())) {
			List<Area> list = areaHessianService.selectAreaByParentId(rDto.getProvinceCode());
			if(list.size()>0) {
				for (Area area : list) {
					if(StringUtils.equals(area.getId(), rDto.getCityCode())) {
						sBuilder.append(area.getName());
					}
				}
			}
		}
		if(StringUtils.isNotEmpty(rDto.getAreCode())) {
			List<Area> list = areaHessianService.selectAreaByParentId(rDto.getCityCode());
			if(list.size()>0) {
				for (Area area : list) {
					if(StringUtils.equals(area.getId(), rDto.getAreCode())) {
						sBuilder.append(area.getName());
					}
				}
			}
		}
		sBuilder.append(rDto.getAddrDetail());
		rDto.setAddrInfo(sBuilder.toString());
		
		logger.debug("AddrsController --> view(={}) - end");
		return ResponseDto.successResp(rDto);
		
	}
	
	/**
	 * 方法说明： 地址添加
	 * @param  会员code	mbrCode			notNull
	 * @param  收件人姓名	reciverName		notNull
	 * @param  联系电话	reciverPhone	notNull
	 * @param  省编码		provinceCode
	 * @param  市编码		cityCode
	 * @param  县编码		areCode
	 * @param  详细地址	addrDetail	notNull
	 * @param  是否默认	isDefault/0是--1否
	 * 
	 * @author 林进权
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"add"})
	@ResponseBody
	public ResponseDto add(AddrsDto addrsDto) {
		logger.debug("AddrsController --> add() - start", addrsDto); 
		if(addrsDto==null //|| StringUtils.isEmpty(addrsDto.getMbrCode())
				|| StringUtils.isEmpty(addrsDto.getReciverName()) || StringUtils.isEmpty(addrsDto.getReciverPhone())
				|| StringUtils.isEmpty(addrsDto.getAddrDetail())
				){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
		addrsDto.setMbrCode(getLoginMemberCode());
		
		//如果是默认，其它重置为非默认
		if(StringUtils.equal(addrsDto.getIsDefault(), "0")) {
			AddrsDto otherAddrs = new AddrsDto();
			otherAddrs.setIsDefault("1");
			otherAddrs.setMbrCode(addrsDto.getMbrCode());
			addrsService.updateAddrsByMbr(otherAddrs);
		}
		
		addrsDto.setDelFlag("0");
		addrsDto.setCreateTime(new Date());
		addrsService.addAddrs(addrsDto);
		logger.debug("AddrsController --> add(={}) - end");
		return ResponseDto.successResp(null);
	}
	
	/**
	 * 方法说明： 地址更新
	 * @param  地址code	code			notNull
	 * @param  收件人姓名	reciverName		notNull
	 * @param  联系电话	reciverPhone	notNull
	 * @param  省编码		provinceCode
	 * @param  市编码		cityCode
	 * @param  县编码		areCode
	 * @param  详细地址	addrDetail		notNull
	 * @param  是否默认	isDefault/0是--1否
	 * @author 林进权
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"upd"})
	@ResponseBody
	public ResponseDto upd(AddrsDto addrsDto) {
		logger.debug("AddrsController --> upd() - start", addrsDto); 
		
		if(addrsDto==null || StringUtils.isEmpty(addrsDto.getCode())
				|| StringUtils.isEmpty(addrsDto.getReciverName()) || StringUtils.isEmpty(addrsDto.getReciverPhone())
				|| StringUtils.isEmpty(addrsDto.getAddrDetail())
				){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
		AddrsDto rDto = new AddrsDto();
		rDto.setCode(addrsDto.getCode());
		rDto = addrsService.findAddrs(rDto);
		
		//如果是默认，其它重置为非默认
		if(StringUtils.equal(addrsDto.getIsDefault(), "0")) {
			AddrsDto otherAddrs = new AddrsDto();
			otherAddrs.setIsDefault("1");
			otherAddrs.setMbrCode(rDto.getMbrCode());
			addrsService.updateAddrsByMbr(otherAddrs);
		}
		
		addrsService.updateAddrs(addrsDto);
		logger.debug("AddrsController --> upd() - end", addrsDto); 
		return ResponseDto.successResp(addrsDto);
	
	}

	/**
	 * 方法说明： 地址删除
	 * @param  地址code	code			notNull
	 * @author 林进权
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"del"})
	@ResponseBody
	public ResponseDto del(String code) {
		logger.debug("AddrsController --> del() - start", code); 
		
		if(StringUtils.isEmpty(code)){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		AddrsDto addrsDto = new AddrsDto();
		addrsDto.setDelFlag("1");
		addrsDto.setCode(code);
		addrsService.updateAddrs(addrsDto);
		
		FindAddrsPage findAddrsPage = new FindAddrsPage();
		AddrsDto param = new AddrsDto();
		param.setDelFlag("0");
		findAddrsPage.setParam(param);
		List<AddrsDto> list = addrsService.findAddrss(findAddrsPage);
		
		//校验是否没有默认的
		boolean defaultFlag = false;
		for(int i=0; i<list.size(); i++) {
			if(StringUtils.equal(list.get(i).getIsDefault(), AddrsIsDefault.Y.getValue())) {
				defaultFlag = true;
			}
		}
		
		//如果没有，重新设置
		if(!defaultFlag) {
			list.get(0).setIsDefault(AddrsIsDefault.Y.getValue());
			addrsService.updateAddrs(list.get(0));
		}
		
		try {
			logger.debug("AddrsController --> del(={}) - end", code);
			return ResponseDto.successResp(null);
		} catch (Exception e) {
			return ResponseDto.generateFailureResponse(e);
		}
	}
	
	
	/**
	 * 方法说明： 设置默认
	 * @param  地址code	code			notNull
	 * @author 林进权
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"setDefault"})
	@ResponseBody
	public ResponseDto setDefault(String code) {
		logger.debug("AddrsController --> setDefault() - start", code); 
		
		if(StringUtils.isEmpty(code)){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
		AddrsDto paramDto = new AddrsDto();
		paramDto.setCode(code);
		paramDto = addrsService.findAddrs(paramDto);
		
		//其它重置为非默认
		AddrsDto otherAddrs = new AddrsDto();
		otherAddrs.setIsDefault("1");
		otherAddrs.setMbrCode(paramDto.getMbrCode());
		addrsService.updateAddrsByMbr(otherAddrs);
		
		paramDto.setIsDefault("0");
		addrsService.updateAddrs(paramDto);
		
		logger.debug("AddrsController --> setDefault(={}) - end", code);
		return ResponseDto.successResp(null);
	}
	
}
