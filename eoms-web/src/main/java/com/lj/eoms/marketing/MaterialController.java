/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.marketing;

import java.util.ArrayList;
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
import com.lj.eshop.dto.MateriaEcmDto;
import com.lj.eshop.dto.MaterialCmDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.emus.MaterialCmType;
import com.lj.eshop.service.IMaterialCmService;
import com.lj.eshop.service.IProductService;
import com.lj.eshop.service.IShopService;

/**
 * 
 * 类说明：卖家素材
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
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
			
			MaterialCmDto materialCmDto = findMaterialReturnPage.getParam();
			if(null==findMaterialReturnPage.getParam()) {
				materialCmDto = new MaterialCmDto();
				findMaterialReturnPage.setParam(materialCmDto);
			}
			materialCmDto.setProductName(productName);
			materialCmDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());
			List<String> inTypes = new ArrayList<String>();
			inTypes.add(MaterialCmType.SALE.getValue());
			inTypes.add(MaterialCmType.PRIVATE.getValue());
			materialCmDto.setInTypes(inTypes);
			
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
				findMaterialTypePage.setMerchantNo(UserUtils.getUser().getMerchant().getOfficeId());
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
			
			model.addAttribute("materialCmTypes", MaterialCmType.values());
			model.addAttribute("productName", productName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modules/marketing/material/materialList";
	}

	

	/** 引用为官方精选 */
	@RequiresPermissions("marketing:material:edit")
	@RequestMapping(value = "/biztype")
	public String biztype(MateriaEcmDto findMaterialEcDto, RedirectAttributes redirectAttributes) {

		MateriaEcmDto addMateriaEcmDto = materialCmService.findMaterialEcm(findMaterialEcDto);
		if (null != addMateriaEcmDto) {
			if(StringUtils.isNotEmpty(addMateriaEcmDto.getChoicenessCode())) {
				addMessage(redirectAttributes, "引用为官方精选失败，已经添加为官方精选");
			} else {
				// 商店
				ShopDto shopDto = new ShopDto();
				shopDto.setCode(addMateriaEcmDto.getShopCode());
				ShopDto rltShopDto = shopService.findShop(shopDto);
				if (rltShopDto == null) {
					addMessage(redirectAttributes, "引用为官方精选失败，查找不到相关商店");
				} else {
					addMateriaEcmDto.setMerchantNo(UserUtils.getUser().getMerchant().getOfficeId());
					addMateriaEcmDto.setMerchantName(UserUtils.getUser().getMerchant().getMerchantName());
					materialCmService.updBiztypeForPub(addMateriaEcmDto, rltShopDto);
					
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
	public String view(String code, Model model) {
		try {
			if(StringUtils.isNotEmpty(code)){
				MateriaEcmDto findMateriaEcmDto = new MateriaEcmDto();
				findMateriaEcmDto.setCode(code);
				MateriaEcmDto materiaEcmDto = materialCmService.findMaterialEcm(findMateriaEcmDto);
				model.addAttribute("data", materiaEcmDto);
				//公司名
				model.addAttribute("companyName",UserUtils.getUser().getCompany().getName());
				//公司LOGO
				model.addAttribute("companyLogo",UserUtils.getUser().getCompany().getLogo());
				//公司简介
				model.addAttribute("companyRemarks",UserUtils.getUser().getCompany().getRemarks());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modules/marketing/material/materialView";
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param model
	 * @return 返回静态页面数据
	 *
	 * @author 林进权 CreateDate: 2017年9月25日
	 *
	 */
	@RequestMapping(value = "viewH5")
	public String viewH5(String code, Model model) {
		try {
			if(StringUtils.isNotEmpty(code)){
				MateriaEcmDto findMateriaEcmDto = new MateriaEcmDto();
				findMateriaEcmDto.setCode(code);
				MateriaEcmDto materiaEcmDto = materialCmService.findMaterialEcm(findMateriaEcmDto);
				model.addAttribute("data", materiaEcmDto);
				
				//公司名
				model.addAttribute("companyName",UserUtils.getUser().getCompany().getName());
				//公司LOGO
				model.addAttribute("companyLogo",UserUtils.getUser().getCompany().getLogo());
				//公司简介
				model.addAttribute("companyRemarks",UserUtils.getUser().getCompany().getRemarks());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "modules/marketing/materialcommon/materialcommenH5";
	}
}
