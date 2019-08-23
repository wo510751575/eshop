/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.marketing;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ape.common.web.BaseController;
import com.google.common.collect.Lists;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.business.cm.dto.FindMaterialTypePage;
import com.lj.business.cm.service.IMaterialTypeService;
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.dto.FindMaterialEcmPage;
import com.lj.eshop.dto.FindProductPage;
import com.lj.eshop.dto.FindShopPage;
import com.lj.eshop.dto.MaterialCmDto;
import com.lj.eshop.dto.MateriaEcmDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.service.IMaterialCmService;
import com.lj.eshop.service.IProductService;
import com.lj.eshop.service.IShopService;

/**
 * 
 * 类说明：卖家素材
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@Controller
@RequestMapping("${adminPath}/marketing/material/")
public class MaterialController extends BaseController {

	@Resource
	private IMaterialTypeService materialTypeService;
	
	@Resource
	private IShopService shopService;
	@Autowired
	private IMaterialCmService materialCmService;
	
	@Autowired
	private IProductService productService;

	/**
	 * 
	 *
	 * 方法说明：商户服务分页数据转换
	 *
	 * @param model
	 * @param pageNo
	 * @param pageSize
	 * @param findMaterialPage
	 * @return 返回分页数据，OMS进行分页数据展现
	 *
	 * @author 林进权 CreateDate: 2017年9月15日
	 *
	 */
	@RequestMapping(value = { "list", "" })
	public String list(Model model, Integer pageNo, Integer pageSize, FindMaterialEcmPage findMaterialReturnPage, String productName) {
		try {

			
			pageNo = pageNo==null?1:pageNo;
			pageSize = pageSize==null || pageSize>500?10:pageSize;
			findMaterialReturnPage.setStart((pageNo - 1) * pageSize);
			findMaterialReturnPage.setLimit(pageSize);
			findMaterialReturnPage.setMerchantCode(UserUtils.getUser().getMerchant().getCode());
			MaterialCmDto materialCmDto = new MaterialCmDto();
			materialCmDto.setProductName(productName);
			findMaterialReturnPage.setParam(materialCmDto);
			Page<MateriaEcmDto> page = materialCmService.findCmMaterialPgae(findMaterialReturnPage);
			
			if(page.getRows().size()>0) {
				List<MateriaEcmDto> list = Lists.newArrayList();
				list.addAll(page.getRows());
				
				com.ape.common.persistence.Page<MateriaEcmDto> page2 = new com.ape.common.persistence.Page<MateriaEcmDto>(
						pageNo == null ? 1 : pageNo, page.getLimit(), page.getTotal(), list);
				page2.initialize();
				model.addAttribute("page", page2);
				
				/* 获取素材类型下拉数据 */
				FindMaterialTypePage findMaterialTypePage = new FindMaterialTypePage();
				findMaterialTypePage.setMerchantNo(UserUtils.getUser().getMerchant().getCode());
				findMaterialTypePage.setIsPublic(true);
				model.addAttribute("materialType", materialTypeService.findMaterialTypes(findMaterialTypePage));

				model.addAttribute("findMaterialReturnPage", findMaterialReturnPage);
				
				//产品
				FindProductPage productPage = new FindProductPage();
				ProductDto productDto= new ProductDto();
				productDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
				productPage.setParam(productDto);
				List<ProductDto> productList = productService.findProducts(productPage);
				model.addAttribute("productList", productList);
			}
			model.addAttribute("productName", productName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modules/marketing/material/materialList";
	}

	

	/** 引用为官方精选 */
	@RequiresPermissions("marketing:material:edit")
	@RequestMapping(value = "/biztype")
	public String biztype(MateriaEcmDto materialEcDto, RedirectAttributes redirectAttributes, String materialCmCode) {

		FindMaterialEcmPage findMaterialReturnPage = new FindMaterialEcmPage();
		findMaterialReturnPage.setCmMaterialCode(materialEcDto.getCmMaterialCode());
		findMaterialReturnPage.setMaterialCmCode(materialEcDto.getMaterialCmCode());
		MateriaEcmDto materialReturnDto = materialCmService.findMaterialSale(findMaterialReturnPage);
		if (null != materialReturnDto) {
			if(StringUtils.isNotEmpty(materialReturnDto.getChoicenessCode())) {
				addMessage(redirectAttributes, "引用为官方精选失败，已经添加为官方精选");
			} else {
				// 商店
				FindShopPage findShopPage = new FindShopPage();
				ShopDto shopDto = new ShopDto();
				shopDto.setMbrCode(materialReturnDto.getMemberNoGm());
				findShopPage.setParam(shopDto);
				List<ShopDto> shopDtos = shopService.findShops(findShopPage);
				if (shopDtos.size() == 0) {
					addMessage(redirectAttributes, "引用为官方精选失败，查找不到相关商店");
				} else {
					materialReturnDto.setMaterialCmCode(materialCmCode);
					materialCmService.updBiztypeForPub(materialReturnDto, shopDtos.get(0));
					
					addMessage(redirectAttributes, "引用为官方精选成功");
				}
			}
		} 
		return "redirect:" + adminPath + "/marketing/material/";
	}

	/**
	 * 
	 *
	 * 方法说明：静态页面数据返回
	 *
	 * @param findMaterialCommen
	 * @param model
	 * @return 返回静态页面数据
	 *
	 * @author 林进权 CreateDate: 2017年9月17日
	 *
	 */
	@RequiresPermissions("marketing:material:view")
	@RequestMapping(value = "view")
	public String view(FindMaterialEcmPage findMaterialReturnPage, Model model) {
		try {
			if (findMaterialReturnPage != null && findMaterialReturnPage.getCmMaterialCode() != null) {
				//
				MateriaEcmDto returnDto =  materialCmService.findMaterialSale(findMaterialReturnPage);
				model.addAttribute("data", returnDto);
				/* 获取模版 */
				/*
				 * if(StringUtils.isNotEmpty(findMaterialCommenReturn.getTempId())){
				 * model.addAttribute("temp",
				 * dictService.get(findMaterialCommenReturn.getTempId())); }
				 */
			}

			// 地址 TODO获取附近门店
			// model.addAttribute("addr","深圳市龙华新区民治大道785号");
			// 电话 TODO
			// model.addAttribute("tel","400-8008001");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modules/marketing/material/materialView";
	}
}
