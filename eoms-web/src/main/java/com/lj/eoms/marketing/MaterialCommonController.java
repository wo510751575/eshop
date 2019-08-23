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
import com.lj.eshop.dto.MaterialCmDto;
import com.lj.eshop.dto.MateriaEcmDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.service.IMaterialCmService;
import com.lj.eshop.service.IProductService;

/**
 * 
 * 类说明：官方素材管理
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
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
	public String list(FindMaterialEcmPage findMaterialReturnPage, Model model, Integer pageNo, Integer pageSize, String productName) {
		try {
			
			pageNo = pageNo==null?1:pageNo;
			pageSize = pageSize==null || pageSize>500?10:pageSize;
//			FindMaterialReturnPage findMaterialReturnPage = new FindMaterialReturnPage();
			findMaterialReturnPage.setStart((pageNo - 1) * pageSize);
			findMaterialReturnPage.setLimit(pageSize);
//			findMaterialReturnPage.setShopCode();
			findMaterialReturnPage.setMerchantCode(UserUtils.getUser().getMerchant().getCode());
			MaterialCmDto materialCmDto = new MaterialCmDto();
			materialCmDto.setProductName(productName);
			findMaterialReturnPage.setParam(materialCmDto);
			Page<MateriaEcmDto> page = materialCmService.findCmCommonMaterialPgae(findMaterialReturnPage);
			
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
	public String form(MateriaEcmDto materialEcDto, String tempId, Model model, String materialCmCode) {
		try {
			
			//产品
			FindProductPage productPage = new FindProductPage();
			ProductDto productDto= new ProductDto();
			productDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
			productPage.setParam(productDto);
			List<ProductDto> productList = productService.findProducts(productPage);
			model.addAttribute("productList", productList);
			
			
			if (materialEcDto != null && materialEcDto.getCode() != null) {
				try {
					
					FindMaterialEcmPage findMaterialReturnPage = new FindMaterialEcmPage();
					findMaterialReturnPage.setCmMaterialCode(materialEcDto.getCmMaterialCode());
					findMaterialReturnPage.setMaterialCmCode(materialEcDto.getCode());
					MateriaEcmDto  materialReturnDto = materialCmService.findMaterialCommen(findMaterialReturnPage);
					model.addAttribute("data", materialReturnDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			/* 获取素材类型下拉数据 */
			FindMaterialTypePage findMaterialTypePage = new FindMaterialTypePage();
			findMaterialTypePage.setMerchantNo(UserUtils.getUser().getMerchant().getCode());
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
			materialEcDto.setMerchantNo(UserUtils.getUser().getMerchant().getCode());
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
			
			materialCmService.delMaterial(materialCmDto);
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
	public String view(FindMaterialEcmPage findMaterialReturnPage, Model model) {
		try {
			if(findMaterialReturnPage!=null && findMaterialReturnPage.getCmMaterialCode()!=null){
//				FindMaterialCommenReturn findMaterialCommenReturn = materialcommenService.findMaterialCommen(findMaterialCommen);
				
				MateriaEcmDto  returnDto = materialCmService.findMaterialCommen(findMaterialReturnPage);
				model.addAttribute("data",returnDto);
				/*获取模版*/
				/*if(StringUtils.isNotEmpty(findMaterialCommenReturn.getTempId())){
					model.addAttribute("temp", dictService.get(findMaterialCommenReturn.getTempId()));
				}*/
				
				if(!returnDto.getMerchantNo().isEmpty()){
					/*Office company= officeService.get(officeService.get(findMaterialCommenReturn.getMerchantNo()));
					//公司名
					model.addAttribute("companyName",company.getName());
					//公司LOGO
					model.addAttribute("companyLogo",company.getLogo());
					//公司简介
					model.addAttribute("companyRemarks",company.getRemarks());*/
				}
			}
			
			//地址 	TODO获取附近门店
//			model.addAttribute("addr","深圳市龙华新区民治大道785号");
			//电话	TODO
//			model.addAttribute("tel","400-8008001");
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return "modules/marketing/materialcommon/materialcommenView";
	}
	
}
