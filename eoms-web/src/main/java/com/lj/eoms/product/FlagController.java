/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.product;

import java.util.Date;
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
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.dto.FindFlagPage;
import com.lj.eshop.dto.FlagDto;
import com.lj.eshop.emus.ProductFlagType;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.IFlagService;

/**
 * 
 * 类说明：系统商品标签管理。
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年8月26日
 */
@Controller
@RequestMapping("${adminPath}/product/flag/")
public class FlagController extends BaseController {

	public static final String LIST = "modules/product/flag/list";
	public static final String FORM = "modules/product/flag/form";
	public static final String EDIT = "modules/product/flag/edit";

	@Autowired
	private IFlagService flagService;

	/** 列表 */
	@RequiresPermissions("product:flag:view")
	@RequestMapping(value = { "list", "" })
	public String list(FindFlagPage flagPage, Integer pageNo,
			Integer pageSize, Model model) {
		if (pageNo != null) {
			flagPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			flagPage.setLimit(pageSize);
		}
		Page<FlagDto> pageDto = flagService.findFlagPage(flagPage);
		List<FlagDto> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());

		com.ape.common.persistence.Page<FlagDto> page = new com.ape.common.persistence.Page<FlagDto>(
				pageNo == null ? 1 : pageNo, pageDto.getLimit(),
				pageDto.getTotal(), list);
		page.initialize();

		model.addAttribute("page", page);
		model.addAttribute("statuss", Status.values());
		model.addAttribute("flagTypes", ProductFlagType.values());
		
		model.addAttribute("reqParam", flagPage);
		return LIST;
	}

	/** 新增 */
	@RequiresPermissions("product:flag:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(FlagDto flagDto,
			RedirectAttributes redirectAttributes) {
		flagDto.setCreateTime(new Date());
		flagDto.setCreater(UserUtils.getUser().getId());// 这里设置用户
		flagService.addFlag(flagDto);
		
		addMessage(redirectAttributes, "保存商品标签'" + flagDto.getProductFlag() + "'成功");
		return "redirect:" + adminPath + "/product/flag/";
	}

	/** 新增/修改表单 */
	@RequiresPermissions("product:flag:view")
	@RequestMapping(value = "/form")
	public String form(String code, Model model) {
		FlagDto param = new FlagDto();
		param.setCode(code);
		FlagDto rtDto = flagService.findFlag(param);
		model.addAttribute("data", rtDto);
		model.addAttribute("statuss", Status.values());
		model.addAttribute("flagTypes", ProductFlagType.values());
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("product:flag:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(FlagDto flagDto,
			RedirectAttributes redirectAttributes) {
		flagService.updateFlag(flagDto);
		addMessage(redirectAttributes, "修改商品标签'" + flagDto.getProductFlag() 
				+ "'成功");
		return "redirect:" + adminPath + "/product/flag/";
	}

	/** 启用/停用 */
	@RequiresPermissions("product:flag:edit")
	@RequestMapping(value = "/status")
	public String status(FlagDto flagDto,
			RedirectAttributes redirectAttributes) {
		if (Status.USE.getValue().equals(flagDto.getStatus())) {
			flagService.updateFlag(flagDto);
			addMessage(redirectAttributes, "启用商品标签成功");
		} else if (Status.STOP.getValue().equals(flagDto.getStatus())) {
			flagService.updateFlag(flagDto);
			addMessage(redirectAttributes, "停用商品标签成功");
		}
		return "redirect:" + adminPath + "/product/flag/";
	}
}
