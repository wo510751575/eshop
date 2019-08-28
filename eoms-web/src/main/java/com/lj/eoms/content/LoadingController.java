/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.content;

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
import com.lj.eshop.dto.FindLoadingPage;
import com.lj.eshop.dto.LoadingDto;
import com.lj.eshop.emus.LoadingBiz;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.ILoadingService;

/**
 * 
 * 类说明：广告管理
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@Controller
@RequestMapping("${adminPath}/content/loading/")
public class LoadingController extends BaseController {

	public static final String LIST = "modules/content/loading/list";

	public static final String FORM = "modules/content/loading/form";
	public static final String EDIT = "modules/content/loading/edit";
	public static final String VIEW = "modules/content/loading/view";

	@Autowired
	private ILoadingService loadingService;

	/** 列表 */
	@RequiresPermissions("content:loading:view")
	@RequestMapping(value = { "list", "" })
	public String list(FindLoadingPage findLoadingPage, Integer pageNo, Integer pageSize, Model model) {

		LoadingDto param = findLoadingPage.getParam();
		if(null==param) {
			param = new LoadingDto();
		}
		param.setStatus("0");
		findLoadingPage.setParam(param);
		if (pageNo != null) {
			findLoadingPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			findLoadingPage.setLimit(pageSize);
		}
		Page<LoadingDto> pageDto = loadingService.findLoadingPage(findLoadingPage);
		List<LoadingDto> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());

		com.ape.common.persistence.Page<LoadingDto> page = new com.ape.common.persistence.Page<LoadingDto>(
				pageNo == null ? 1 : pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
		page.initialize();

		model.addAttribute("page", page);
		model.addAttribute("findLoadingPage", findLoadingPage);
		model.addAttribute("bizs", LoadingBiz.values());
		return LIST;
	}

	/** 新增 无新增 */
	@RequiresPermissions("content:loading:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(LoadingDto loadingDto, RedirectAttributes redirectAttributes) {
		loadingService.addLoading(loadingDto);
		addMessage(redirectAttributes, "保存广告'"  + "'成功");
		return "redirect:" + adminPath + "/content/loading/";
	}

	/** 新增/修改/查看表单 */
	@RequiresPermissions("content:loading:view")
	@RequestMapping(value = "/form")
	public String form(String code, Boolean isView, Model model) {
		model.addAttribute("statuss", Status.values());
		try {
			LoadingDto param = new LoadingDto();
			param.setCode(code);
			LoadingDto rtDto = loadingService.findLoading(param);
			model.addAttribute("data", rtDto);
			model.addAttribute("bizs", LoadingBiz.values());
			if (isView != null && isView) {
				return VIEW;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("content:loading:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(LoadingDto loadingDto, RedirectAttributes redirectAttributes) {
		loadingService.updateLoading(loadingDto);
		addMessage(redirectAttributes, "修改广告'" +  "'成功");
		return "redirect:" + adminPath + "/content/loading/";
	}


	/** 删除 */
	@RequiresPermissions("member:memberRank:edit")
	@RequestMapping(value = "/delete")
	public String delete(LoadingDto loadingDto, RedirectAttributes redirectAttributes) {
		loadingDto.setStatus("1");
		loadingService.updateLoading(loadingDto);
		addMessage(redirectAttributes, "删除广告成功");
		return "redirect:" + adminPath + "/content/loading/";
	}
	
}
