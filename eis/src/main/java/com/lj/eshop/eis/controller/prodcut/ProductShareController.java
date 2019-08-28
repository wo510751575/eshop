/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.prodcut;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.constant.UpdateProductCntType;
import com.lj.eshop.dto.FindProductPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.UpdateProductCntDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.utils.ProductQRcodeUtil;
import com.lj.eshop.service.IProductService;

/**
 * 
 * 类说明：商品分享。
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年8月31日
 */
@RestController
@RequestMapping("/product/share")
public class ProductShareController extends BaseController {

	@Autowired
	IProductService productService;
	
	/**
	 * 方法说明：商品分享次数累加。
	 *
	 * @param procutCode 商品code
	 *
	 * @author lhy 2017年8月31日
	 *
	 */
	@RequestMapping(value = { "" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto addProductShare(String code) {
		if(StringUtils.isEmpty(code)){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR, null);
		}
		MemberDto meb = getLoginMember();
		logger.info("商品分享记录：mbr.code:"+(meb==null?"游客":meb.getCode())+",productCode"+code);
		
		UpdateProductCntDto u=new UpdateProductCntDto();
		u.setType(UpdateProductCntType.SHARE_CNT);
		u.setCode(code);
		u.setCnt(1);
		productService.updateProductCntByType(u);
		return ResponseDto.successResp(null);
	}
	
	/***
	 * 方法说明：制作商品分享图片。
	 *
	 * @param shareUrl 二维码分享的链接
	 * @param code 商品code
	 * @return
	 *
	 * @author lhy  2017年9月1日
	 *
	 */
	@RequestMapping(value = "/pic" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto createShareImage(String shareUrl,String code){
		logger.info("createShareImage----------->shareUrl="+shareUrl);
		logger.info("createShareImage----------->code="+code);
		if(StringUtils.isEmpty(code)||StringUtils.isEmpty(shareUrl)){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR, null);
		}
		FindProductPage findProductPage=new FindProductPage();
		ProductDto productDto=new ProductDto();
		productDto.setCode(code);
		findProductPage.setParam(productDto);
		findProductPage.setLimit(1);
		findProductPage.setStart(0);
		Page<ProductDto> pages=productService.findIndexProductPage(findProductPage);
		List<ProductDto> ps= (List<ProductDto>)pages.getRows();
		if (ps == null || ps.isEmpty()) {
			return ResponseDto.getErrorResponse(ResponseCode.NO_DATA, null);
		} else {
			ProductDto p=ps.get(0);
			BigDecimal price=null;
			if(p.getSkus()!=null && !p.getSkus().isEmpty()){
				price=p.getSkus().get(0).getSalePrice();
			}
			String shareImageUrl=ProductQRcodeUtil.createShareQRcode(shareUrl, p.getProductIcon(), p.getName(),price);
			return ResponseDto.successResp(shareImageUrl);
		}
	}
	
}
