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
import com.lj.eshop.dto.FindShopBgImgPage;
import com.lj.eshop.dto.ShopBgImgDto;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.IShopBgImgService;

/**
 * 
 * 
 * 类说明：店铺背景图@Controller
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
@RequestMapping("${adminPath}/shop/bgimg")
public class ShopBgimgController extends BaseController {

	public static final String LIST = "modules/shop/bgimg/list";
	public static final String FORM = "modules/shop/bgimg/form";
	public static final String EDIT = "modules/shop/bgimg/edit";
	public static final String VIEW = "modules/shop/bgimg/view";
	
	@Autowired
	private IShopBgImgService shopBgImgService;
	
	
	/** 列表 */
	@RequiresPermissions("shop:bgimg:view")
	@RequestMapping(value = {"list",""}, method = {RequestMethod.GET,RequestMethod.POST})
	public String list(ShopBgImgDto param,Integer pageNo,Integer pageSize, Model model) {
		try {
			FindShopBgImgPage findShopBgImgPage = new FindShopBgImgPage(); 
			findShopBgImgPage.setSortBy("name");
			findShopBgImgPage.setSortDir(PageSortType.desc);
			findShopBgImgPage.setParam(param);
			if(pageNo!=null){
				findShopBgImgPage.setStart((pageNo-1)*pageSize);
			}
			if(pageSize!=null){
				findShopBgImgPage.setLimit(pageSize);
			}
			Page<ShopBgImgDto> pageDto = shopBgImgService.findShopBgImgPage(findShopBgImgPage);
			List<ShopBgImgDto> list = Lists.newArrayList();
			list.addAll(pageDto.getRows());
			 
			com.ape.common.persistence.Page<ShopBgImgDto> page=new com.ape.common.persistence.Page<ShopBgImgDto>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
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
	@RequiresPermissions("shop:bgimg:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ShopBgImgDto shopBgImgDto, RedirectAttributes redirectAttributes) {
		try {
			shopBgImgService.addShopBgImg(shopBgImgDto);
			addMessage(redirectAttributes, "保存店铺背景'" + shopBgImgDto.getName() + "'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/shop/bgimg/";
	}

	/** 新增/修改表单 */
	@RequiresPermissions("shop:bgimg:view")
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(String code,Boolean isView, Model model) {
		try {
			ShopBgImgDto param = new ShopBgImgDto();
			param.setCode(code);
			ShopBgImgDto rtDto = shopBgImgService.findShopBgImg(param);
			model.addAttribute("data", rtDto);
			model.addAttribute("status", Status.values());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("shop:bgimg:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(ShopBgImgDto shopBgImgDto, RedirectAttributes redirectAttributes) {
		try {
			shopBgImgService.updateShopBgImg(shopBgImgDto);
			addMessage(redirectAttributes, "修改店铺背景'" + shopBgImgDto.getName() + "'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/shop/bgimg/list";
	}

	/** 启用/禁用*/
	@RequiresPermissions("shop:bgimg:edit")
	@RequestMapping(value = "/status")
	public String status(ShopBgImgDto shopBgImgDto, RedirectAttributes redirectAttributes) {
		try {
			shopBgImgService.updateShopBgImg(shopBgImgDto);
			addMessage(redirectAttributes, "操作'"+shopBgImgDto.getName()+"'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/shop/bgimg/list";
	}
}
