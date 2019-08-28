/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.FindMaterialEcmPage;
import com.lj.eshop.dto.MateriaEcmDto;
import com.lj.eshop.dto.MaterialCmDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.EisMaterialDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.MaterialBizType;
import com.lj.eshop.emus.MaterialCmType;
import com.lj.eshop.service.IMaterialCmService;
import com.lj.eshop.service.IProductService;

/**
 * 
 * 类说明：素材
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@RestController
@RequestMapping("/material")
public class MaterialController extends BaseController {

	@Autowired
	private IMaterialCmService materialCmService;
	@Autowired
	private IProductService productService;

	/**
	 * 营销-我的素材列表 方法说明：
	 * 
	 * @param @param pageNo 页码
	 * @param @param pageSize 每页数量
	 * @param param.productCode 商品编码/不传查全部
	 * @param param.bizType 0私人、1官方/不传时不默认查私人
	 * @author 林进权 CreateDate: 2017年9月4日
	 */
	@RequestMapping(value = { "list" })
	@ResponseBody
	public ResponseDto list(FindMaterialEcmPage findMaterialEcmPage, String productCode, String bizType) {
		logger.debug("MaterialController list() - start");
		if (StringUtils.isEmpty(bizType)) {
			bizType = MaterialBizType.MALE.getValue();
		}
		if (StringUtils.isNotEmpty(bizType)) {
			findMaterialEcmPage.getParam().setType(bizType);
		}
		if (StringUtils.isNotEmpty(productCode)) {
			findMaterialEcmPage.getParam().setProductCode(productCode);
		}

		Page<MateriaEcmDto> page = null;
		if (StringUtils.isEmpty(bizType) || StringUtils.equal(MaterialBizType.MALE.getValue(), bizType)) {
			// findMaterialEcmPageParam.setShopCode(getLoginShopCode());
			// //卖家的素材的需要传shopcode, 公共的不需要
			page = materialCmService.findCmMaterialPgae(findMaterialEcmPage);
		} else {

			page = materialCmService.findCmCommonMaterialPgae(findMaterialEcmPage);
		}

		List<MateriaEcmDto> list = new ArrayList<MateriaEcmDto>();
		list.addAll(page.getRows());
		List<EisMaterialDto> eisMaterialDtos = reBuildEis(list);
		Page<EisMaterialDto> eisPage = new Page<EisMaterialDto>(eisMaterialDtos, page.getTotal(), page.getStart(),
				page.getLimit());

		return ResponseDto.successResp(eisPage);
	}

	private List<EisMaterialDto> reBuildEis(List<MateriaEcmDto> list) {
		List<EisMaterialDto> eisMaterialDtos = new ArrayList<EisMaterialDto>();
		if (list.size() > 0) {
			for (MateriaEcmDto materiaEcmDto : list) {
				eisMaterialDtos.add(reBuildEis(materiaEcmDto));
			}
		}
		return eisMaterialDtos;
	}

	private EisMaterialDto reBuildEis(MateriaEcmDto materiaEcmDto) {
		if (null != materiaEcmDto) {
			EisMaterialDto eisMaterialDto = new EisMaterialDto();
			eisMaterialDto.setImgs(materiaEcmDto.getImgAddr());
			eisMaterialDto.setCode(materiaEcmDto.getCode());
			eisMaterialDto.setRemarks(materiaEcmDto.getContent());
			eisMaterialDto.setProductCode(materiaEcmDto.getProductCode());
			eisMaterialDto.setMaterialCmCode(materiaEcmDto.getMaterialCmCode());
			eisMaterialDto.setBizType(materiaEcmDto.getType());
			eisMaterialDto.setCreateTime(materiaEcmDto.getCreateDate());
			eisMaterialDto.setTitle(materiaEcmDto.getTitle());
			eisMaterialDto.setMerchantCode(getLoginMerchantCode());
			if (StringUtils.isNotEmpty(materiaEcmDto.getChoicenessCode())) {
				eisMaterialDto.setBizType(MaterialCmType.CHOICE.getValue());
			}
			return eisMaterialDto;
		}
		return null;
	}

	/**
	 * 营销-我的素材删除 方法说明：
	 * 
	 * @param code 素材代码
	 * @author 林进权 CreateDate: 2017年9月4日
	 */
	@RequestMapping(value = { "del" })
	@ResponseBody
	public ResponseDto del(String code) {
		logger.debug("MaterialController del() - start", code);

		if (StringUtils.isEmpty(code)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		try {
			MaterialCmDto materialCmDto = new MaterialCmDto();
			materialCmDto.setCode(code);
			materialCmService.delCmMaterial(materialCmDto);

			logger.debug("MaterialController --> del(={}) - end");
			return ResponseDto.successResp(null);
		} catch (Exception e) {
			return ResponseDto.generateFailureResponse(e);
		}
	}

	/**
	 * 营销-我的素材添加 方法说明：
	 * 
	 * @param remarks     改得，必填
	 * @param imgs        图片，逗号分割，最多五张。必填
	 * @param productCode 商品code， 必填
	 * 
	 * @author 林进权 CreateDate: 2017年9月4日
	 */
	@RequestMapping(value = { "add" })
	@ResponseBody
	public ResponseDto add(String remarks, String imgs, String productCode, String title, String productName) {
		logger.debug("MaterialController add() - start");

		if (StringUtils.isEmpty(remarks) || StringUtils.isEmpty(imgs) || StringUtils.isEmpty(productCode)
				|| StringUtils.isEmpty(title)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		MateriaEcmDto materiaEcmDto = new MateriaEcmDto();
		materiaEcmDto.setContent(remarks);
		materiaEcmDto.setImgAddr(imgs);
		materiaEcmDto.setProductCode(productCode);
		materiaEcmDto.setProductName(productName);
		materiaEcmDto.setTitle(title);
		materiaEcmDto.setType(MaterialCmType.SALE.getValue());

		ProductDto paramProductDto = new ProductDto();
		paramProductDto.setCode(productCode);
		ProductDto productDto = productService.findProduct(paramProductDto);
		if (null == productDto) {
			logger.debug("MaterialController add fauil for product is null");
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		materiaEcmDto.setProductName(productDto.getName());

		// 素材添加
		/*
		 * GuidMbrDto guidMbrDto = getGuidMember(); if(null!=guidMbrDto) {
		 * materiaEcmDto.setMemberNameGm(getLoginMember().getName());
		 * materiaEcmDto.setMemberNoGm(getLoginMemberCode());
		 * materiaEcmDto.setMerchantNo(guidMbrDto.getMerchantNo());
		 * materiaEcmDto.setMerchantName(guidMbrDto.getMerchantName());
		 * materiaEcmDto.setEcShopNo(guidMbrDto.getShopNo());
		 * materiaEcmDto.setShopName(guidMbrDto.getShopName());
		 * 
		 * }
		 */

		materiaEcmDto.setMerchantCode(getLoginMerchantCode());
		materiaEcmDto.setShopCode(getLoginShopCode());
		materialCmService.addMaterialSale(materiaEcmDto);

		logger.debug("MaterialController --> add(={}) - end");
		return ResponseDto.successResp(null);
	}

	/**
	 * 营销-素材详情
	 * 
	 * @author 林进权 CreateDate: 2017年9月4日
	 */
	@RequestMapping(value = { "view" })
	@ResponseBody
	public ResponseDto view(String code) {
		logger.debug("MaterialController view() - start");

		if (StringUtils.isEmpty(code)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		MaterialCmDto findmaterialCmDto = new MaterialCmDto();
		findmaterialCmDto.setCode(code);
		MaterialCmDto rltMaterialCmDto = materialCmService.findMaterialCm(findmaterialCmDto);
		if (null == rltMaterialCmDto) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		MateriaEcmDto findMateriaEcmDto = new MateriaEcmDto();
		findMateriaEcmDto.setCode(code);
		MateriaEcmDto rltMaterialEcmDto = materialCmService.findMaterialEcm(findMateriaEcmDto);

		logger.debug("MaterialController --> view(={})");
		return ResponseDto.successResp(reBuildEis(rltMaterialEcmDto));
	}

}
