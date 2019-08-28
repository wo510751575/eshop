/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.content;

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
import com.lj.eshop.dto.FindWshopInfoPage;
import com.lj.eshop.dto.WshopInfoDto;
import com.lj.eshop.emus.MemberSourceFrom;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.IWshopInfoService;

/**
 * 
 * 类说明：微信加油站
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@Controller
@RequestMapping("${adminPath}/content/wshopinfo/")
public class WshopInfoController extends BaseController {

	public static final String LIST = "modules/content/wshopinfo/list";

	public static final String FORM = "modules/content/wshopinfo/form";
	public static final String EDIT = "modules/content/wshopinfo/edit";
	public static final String VIEW = "modules/content/wshopinfo/view";

	@Autowired
	private IWshopInfoService wshopinfoService;

	/** 列表 */
	@RequiresPermissions("content:wshopinfo:view")
	@RequestMapping(value = { "list", "" })
	public String list(FindWshopInfoPage wshopInfoPage, Integer pageNo, Integer pageSize, Model model) {


		if (pageNo != null) {
			wshopInfoPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			wshopInfoPage.setLimit(pageSize);
		}
		Page<FindWshopInfoPage> pageDto = wshopinfoService.findWshopInfoPage(wshopInfoPage);
		List<FindWshopInfoPage> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());

		com.ape.common.persistence.Page<FindWshopInfoPage> page = new com.ape.common.persistence.Page<FindWshopInfoPage>(
				pageNo == null ? 1 : pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
		page.initialize();

		model.addAttribute("page", page);
		model.addAttribute("wshopInfoPage", wshopInfoPage);
		return LIST;
	}

	/** 新增 无新增 */
	@RequiresPermissions("content:wshopinfo:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(WshopInfoDto wshopInfoDto, RedirectAttributes redirectAttributes) {
		wshopInfoDto.setCreateTime(new Date());
		wshopInfoDto.setCreater(UserUtils.getUser().getId());// 这里设置用户
		wshopinfoService.addWshopInfo(wshopInfoDto);
		addMessage(redirectAttributes, "保存微信加油站'" + wshopInfoDto.getTitle() + "'成功");
		return "redirect:" + adminPath + "/content/wshopinfo/";
	}

	/** 新增/修改/查看表单 */
	@RequiresPermissions("content:wshopinfo:view")
	@RequestMapping(value = "/form")
	public String form(String code, Boolean isView, Model model) {
		model.addAttribute("statuss", Status.values());
		try {
			FindWshopInfoPage param = new FindWshopInfoPage();
			param.setCode(code);
			WshopInfoDto rtDto = wshopinfoService.findWshopInfo(param);
			model.addAttribute("data", rtDto);
			model.addAttribute("sourceFroms", MemberSourceFrom.values());
			if (isView != null && isView) {
				return VIEW;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("content:wshopinfo:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(WshopInfoDto wshopInfoDto, RedirectAttributes redirectAttributes) {
		wshopinfoService.updateWshopInfo(wshopInfoDto);
		addMessage(redirectAttributes, "修改微信加油站'" + wshopInfoDto.getTitle() + "'成功");
		return "redirect:" + adminPath + "/content/wshopinfo/";
	}

	/** 发布/下架 */
	@RequiresPermissions("content:wshopinfo:edit")
	@RequestMapping(value = "/status")
	public String status(WshopInfoDto wshopInfoDto, RedirectAttributes redirectAttributes) {
		if(Status.USE.getValue().equals(wshopInfoDto.getStatus())){
			wshopinfoService.updateWshopInfo(wshopInfoDto);
			addMessage(redirectAttributes, "发布成功");
		}else if(Status.STOP.getValue().equals(wshopInfoDto.getStatus())){
			wshopinfoService.updateWshopInfo(wshopInfoDto);
			addMessage(redirectAttributes, "下架成功");
		}
		return "redirect:" + adminPath + "/content/wshopinfo/";
	}
	
}
