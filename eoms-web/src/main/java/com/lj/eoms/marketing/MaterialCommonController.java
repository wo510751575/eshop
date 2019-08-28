/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
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

import com.ape.common.utils.IdGen;
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
import com.lj.eshop.service.IMaterialCmService;
import com.lj.eshop.service.IProductService;

/**
 * 
 * 类说明：官方素材管理
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@Controller
@RequestMapping("${adminPath}/marketing/materialcommon/")
public class MaterialCommonController extends BaseController {

	/**
	 * 素材类型服务
	 */
	@Resource
	private IMaterialTypeService materialTypeService;


	@Autowired
	private IProductService productService;
	
	@Autowired
	private IMaterialCmService materialCmService;
	
	/**
	 * 
	 *
	 * 方法说明：公用素材分页数据转换
	 *
	 * @param findMaterialCommenPage
	 * @param model
	 * @param pageNo
	 * @param pageSize
	 * @return 返回分页数据,OMS展现分页数据
	 *
	 * @author 林进权 CreateDate: 2017年9月15日
	 *
	 */
	@RequestMapping(value = { "list", "" })
	public String list(FindMaterialEcmPage findMaterialEcmPage, Model model, Integer pageNo, Integer pageSize, String productName) {
		try {
			
			pageNo = pageNo==null?1:pageNo;
			pageSize = pageSize==null || pageSize>500?10:pageSize;
			findMaterialEcmPage.setStart((pageNo - 1) * pageSize);
			findMaterialEcmPage.setLimit(pageSize);
			MaterialCmDto materialCmDto = findMaterialEcmPage.getParam();
			if(null==materialCmDto) {
				materialCmDto = new MaterialCmDto();
				findMaterialEcmPage.setParam(materialCmDto);
			}
			materialCmDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());
			materialCmDto.setProductName(productName);
			
			Page<MateriaEcmDto> page = materialCmService.findCmCommonMaterialPgae(findMaterialEcmPage);
			
			if(page.getRows().size()>0) {
				
				List<MateriaEcmDto> list = Lists.newArrayList();
				list.addAll(page.getRows());
				com.ape.common.persistence.Page<MateriaEcmDto> page2 = new com.ape.common.persistence.Page<MateriaEcmDto>(
						pageNo == null ? 1 : pageNo, page.getLimit(), page.getTotal(), list);
				page2.initialize();
				model.addAttribute("page", page2);
				
				
				
				//产品
				FindProductPage productPage = new FindProductPage();
				ProductDto productDto= new ProductDto();
				productDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
				productPage.setParam(productDto);
				List<ProductDto> productList = productService.findProducts(productPage);
				model.addAttribute("productList", productList);
			}
			
			/* 获取素材类型下拉数据 */
			FindMaterialTypePage findMaterialTypePage = new FindMaterialTypePage();
			findMaterialTypePage.setMerchantNo(UserUtils.getUser().getMerchant().getOfficeId());
			findMaterialTypePage.setIsPublic(true);
			model.addAttribute("materialType", materialTypeService.findMaterialTypes(findMaterialTypePage));
			model.addAttribute("findMaterialReturnPage", findMaterialEcmPage);
			
			model.addAttribute("productName", productName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modules/marketing/materialcommon/materialcommenList";
	}

	/**
	 * 
	 *
	 * 方法说明：公用素材编辑页面数据展现
	 *
	 * @param findMaterialCommen
	 * @param model
	 * @return 返回编辑页面数据
	 *
	 * @author 林进权 CreateDate: 2017年9月15日
	 *
	 */
	@RequiresPermissions("marketing:materialcommon:view")
	@RequestMapping(value = "form")
	public String form(MateriaEcmDto findMateriaEcmDto, String tempId, Model model, String materialCmCode) {
		try {
			
			//产品
			FindProductPage productPage = new FindProductPage();
			ProductDto productDto= new ProductDto();
			productDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
			productPage.setParam(productDto);
			List<ProductDto> productList = productService.findProducts(productPage);
			model.addAttribute("productList", productList);
			
			
			if (findMateriaEcmDto != null && findMateriaEcmDto.getCode() != null) {
				try {
					MateriaEcmDto  materialReturnDto = materialCmService.findMaterialEcm(findMateriaEcmDto);
					model.addAttribute("data", materialReturnDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			/* 获取素材类型下拉数据 */
			FindMaterialTypePage findMaterialTypePage = new FindMaterialTypePage();
			findMaterialTypePage.setMerchantNo(UserUtils.getUser().getMerchant().getOfficeId());
			findMaterialTypePage.setLimit(1000);
			// 获取门店下拉信息
			// 分店与地址下拉列表
			/*
			 * FindShopPage findShop = new FindShopPage(); ShopDto shopDto = new ShopDto();
			 * shopDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());
			 * List<ShopDto> shops= shopService.findShops(findShop);
			 */
			
			
			
			model.addAttribute("materialType", materialTypeService.findMaterialTypes(findMaterialTypePage));
			if (StringUtils.isEmpty(tempId)) {
				return "modules/marketing/materialcommon/materialcommenForm";
			} else {
//				model.addAttribute("temp", dictService.get(tempId));
				return "modules/marketing/materialcommon/materialcommenTempForm";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modules/marketing/materialcommon/materialcommenForm";
	}

	/**
	 * 
	 *
	 * 方法说明：公用素材新增数据保存方法
	 *
	 * @param addMaterial
	 * @param model
	 * @param redirectAttributes
	 * @return 保存成功跳转页面
	 *
	 * @author 林进权 CreateDate: 2017年9月15日
	 *
	 */
	@RequiresPermissions("marketing:materialcommon:edit")
	@RequestMapping(value = "save")
	public String save(MateriaEcmDto materialEcDto, Model model, RedirectAttributes redirectAttributes) {
		try {
			materialEcDto.setCode(IdGen.uuid());
			materialEcDto.setMerchantNo(UserUtils.getUser().getMerchant().getOfficeId());
			materialEcDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());
			materialEcDto.setMerchantName(UserUtils.getUser().getCompany().getName());
			materialEcDto.setCreateId(UserUtils.getUser().getName());
			materialCmService.addMaterialPub(materialEcDto);
			
			addMessage(redirectAttributes, "保存素材'" + materialEcDto.getTitle() + "'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/marketing/materialcommon/";
	}

	/**
	 * 
	 *
	 * 方法说明：编辑修改公用素材信息保存
	 *
	 * @param updateMaterial
	 * @param model
	 * @param redirectAttributes
	 * @return 保存成功跳转页面
	 *
	 * @author 林进权 CreateDate: 2017年9月15日
	 *
	 */
	@RequiresPermissions("marketing:materialcommon:edit")
	@RequestMapping(value = "edit")
	public String edit(MateriaEcmDto materialEcDto, Model model, RedirectAttributes redirectAttributes, String materialCmCode) {
		try {
			
			materialCmService.updMaterialPub(materialEcDto);
			addMessage(redirectAttributes, "保存素材'" + materialEcDto.getTitle() + "'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/marketing/materialcommon/";
	}
	/**
	 * 
	 *
	 * 方法说明：删除
	 *
	 *
	 * @author 林进权 CreateDate: 2017年9月15日
	 *
	 */
	@RequiresPermissions("marketing:materialcommon:edit")
	@RequestMapping(value = "del")
	public String del(MaterialCmDto materialCmDto, Model model, RedirectAttributes redirectAttributes) {
		try {
			
			materialCmService.delCommonMaterial(materialCmDto);
			addMessage(redirectAttributes, "删除素材成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/marketing/materialcommon/";
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
	 * @author 林进权  CreateDate: 2017年9月17日
	 *
	 */
	@RequiresPermissions("marketing:materialcommon:view")
	@RequestMapping(value = "view")
	public String view(String code, Model model) {
		try {
			if(StringUtils.isNotEmpty(code)){
				MateriaEcmDto findMateriaEcmDto = new MateriaEcmDto();
				findMateriaEcmDto.setCode(code);
				MateriaEcmDto  returnDto = materialCmService.findMaterialEcm(findMateriaEcmDto);
				model.addAttribute("data",returnDto);
				
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
		return "modules/marketing/materialcommon/materialcommenView";
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
