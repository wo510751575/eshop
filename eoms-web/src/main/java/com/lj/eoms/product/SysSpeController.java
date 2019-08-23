/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
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
import com.lj.eshop.dto.FindSysSpePage;
import com.lj.eshop.dto.SysSpeDto;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.ISysSpeService;

/**
 * 
 * 类说明：系统商品规格管理。
 * <p>
 * 详细描述：
 * 
 * @Company: 领居科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年8月26日
 */
@Controller
@RequestMapping("${adminPath}/product/spec/")
public class SysSpeController extends BaseController {

	public static final String LIST = "modules/product/spec/list";
	public static final String FORM = "modules/product/spec/form";
	public static final String EDIT = "modules/product/spec/edit";

	@Autowired
	private ISysSpeService sysSpeService;

	/** 列表 */
	@RequiresPermissions("product:spec:view")
	@RequestMapping(value = { "list", "" })
	public String list(FindSysSpePage sysSpePage, Integer pageNo,
			Integer pageSize, Model model) {
		if (pageNo != null) {
			sysSpePage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			sysSpePage.setLimit(pageSize);
		}
		Page<SysSpeDto> pageDto = sysSpeService.findSysSpePage(sysSpePage);
		List<SysSpeDto> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());

		com.ape.common.persistence.Page<SysSpeDto> page = new com.ape.common.persistence.Page<SysSpeDto>(
				pageNo == null ? 1 : pageNo, pageDto.getLimit(),
				pageDto.getTotal(), list);
		page.initialize();

		model.addAttribute("page", page);
		model.addAttribute("statuss", Status.values());
		model.addAttribute("reqParam", sysSpePage);
		return LIST;
	}

	/** 新增 */
	@RequiresPermissions("product:spec:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(SysSpeDto supplyDto,
			RedirectAttributes redirectAttributes) {
		supplyDto.setCreateTime(new Date());
		supplyDto.setCreater(UserUtils.getUser().getId());// 这里设置用户
		sysSpeService.addSysSpe(supplyDto);
		
		addMessage(redirectAttributes, "保存商品规格'" + supplyDto.getSpeName()
				+ "'成功");
		return "redirect:" + adminPath + "/product/spec/";
	}

	/** 新增/修改表单 */
	@RequiresPermissions("product:spec:view")
	@RequestMapping(value = "/form")
	public String form(String code, Model model) {
		SysSpeDto param = new SysSpeDto();
		param.setCode(code);
		SysSpeDto rtDto = sysSpeService.findSysSpe(param);
		model.addAttribute("data", rtDto);
		model.addAttribute("statuss", Status.values());
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("product:spec:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(SysSpeDto supplyDto,
			RedirectAttributes redirectAttributes) {
		sysSpeService.updateSysSpe(supplyDto);
		addMessage(redirectAttributes, "修改商品规格'" + supplyDto.getSpeName()
				+ "'成功");
		return "redirect:" + adminPath + "/product/spec/";
	}

	/** 启用/停用 */
	@RequiresPermissions("product:spec:edit")
	@RequestMapping(value = "/status")
	public String status(SysSpeDto supplyDto,
			RedirectAttributes redirectAttributes) {
		if (Status.USE.getValue().equals(supplyDto.getStatus())) {
			sysSpeService.updateSysSpe(supplyDto);
			addMessage(redirectAttributes, "启用商品规格成功");
		} else if (Status.STOP.getValue().equals(supplyDto.getStatus())) {
			sysSpeService.updateSysSpe(supplyDto);
			addMessage(redirectAttributes, "停用商品规格成功");
		}
		return "redirect:" + adminPath + "/product/spec/";
	}
}
