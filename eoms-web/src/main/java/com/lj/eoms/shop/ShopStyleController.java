/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.shop;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ape.common.web.BaseController;
import com.google.common.collect.Lists;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.pagination.PageSortType;
import com.lj.eshop.dto.FindShopStylePage;
import com.lj.eshop.dto.ShopStyleDto;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.IShopStyleService;

/**
 * 
 * 
 * 类说明：店铺风格@Controller
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月25日
 */
@Controller
@RequestMapping("${adminPath}/shop/style")
public class ShopStyleController extends BaseController {

	public static final String LIST = "modules/shop/style/list";
	public static final String FORM = "modules/shop/style/form";
	public static final String EDIT = "modules/shop/style/edit";
	public static final String VIEW = "modules/shop/style/view";
	
	@Autowired
	private IShopStyleService shopStyleService;
	
	
	/** 列表 */
	@RequiresPermissions("shop:style:view")
	@RequestMapping(value = {"list",""}, method = {RequestMethod.GET,RequestMethod.POST})
	public String list(ShopStyleDto param,Integer pageNo,Integer pageSize, Model model) {
		try {
			FindShopStylePage findShopStylePage = new FindShopStylePage(); 
			findShopStylePage.setSortBy("code");
			findShopStylePage.setSortDir(PageSortType.desc);
			findShopStylePage.setParam(param);
			if(pageNo!=null){
				findShopStylePage.setStart((pageNo-1)*pageSize);
			}
			if(pageSize!=null){
				findShopStylePage.setLimit(pageSize);
			}
			Page<ShopStyleDto> pageDto = shopStyleService.findShopStylePage(findShopStylePage);
			List<ShopStyleDto> list = Lists.newArrayList();
			list.addAll(pageDto.getRows());
			 
			com.ape.common.persistence.Page<ShopStyleDto> page=new com.ape.common.persistence.Page<ShopStyleDto>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
			page.initialize();
			model.addAttribute("page",page);
			model.addAttribute("status", Status.values());
			model.addAttribute("param", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return LIST;
	}

	/** 新增 */
	@RequiresPermissions("shop:style:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ShopStyleDto shopStyleDto, RedirectAttributes redirectAttributes) {
		try {
			shopStyleService.addShopStyle(shopStyleDto);
			addMessage(redirectAttributes, "保存店铺风格'" + shopStyleDto.getName() + "'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/shop/style/";
	}

	/** 新增/修改表单 */
	@RequiresPermissions("shop:style:view")
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(String code,Boolean isView, Model model) {
		try {
			ShopStyleDto param = new ShopStyleDto();
			param.setCode(code);
			ShopStyleDto rtDto = shopStyleService.findShopStyle(param);
			model.addAttribute("data", rtDto);
			model.addAttribute("status", Status.values());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("shop:style:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(ShopStyleDto shopStyleDto, RedirectAttributes redirectAttributes) {
		try {
			shopStyleService.updateShopStyle(shopStyleDto);
			addMessage(redirectAttributes, "修改店铺风格'" + shopStyleDto.getName() + "'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/shop/style/list";
	}

	/** 启用/禁用*/
	@RequiresPermissions("shop:style:edit")
	@RequestMapping(value = "/status")
	public String status(ShopStyleDto shopStyleDto, RedirectAttributes redirectAttributes) {
		try {
			shopStyleService.updateShopStyle(shopStyleDto);
			addMessage(redirectAttributes, "操作'"+shopStyleDto.getName()+"'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/shop/style/list";
	}
}
