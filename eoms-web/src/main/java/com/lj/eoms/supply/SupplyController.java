/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.supply;

import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ape.common.config.Global;
import com.ape.common.web.BaseController;
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.dto.FindSupplyPage;
import com.lj.eshop.dto.SupplyDto;
import com.lj.eshop.emus.BankCode;
import com.lj.eshop.emus.BillPayType;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.ISupplyService;

/**
 * 
 * 类说明：供应商管理。
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年8月24日
 */
@Controller
@RequestMapping("${adminPath}/member/supplier/")
public class SupplyController extends BaseController {

	public static final String LIST = "modules/member/supplier/list";

	public static final String FORM = "modules/member/supplier/form";
	public static final String EDIT = "modules/member/supplier/edit";
	public static final String VIEW = "modules/member/supplier/view";

	@Autowired
	private ISupplyService supplyService;

	/** 列表 */
	@RequiresPermissions("member:supplier:view")
	@RequestMapping(value = {"list", ""}, method = RequestMethod.GET)
	public String list(SupplyDto supplyDto, Model model) {
		if(null!=UserUtils.getUser().getMerchant()) {
			supplyDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
			FindSupplyPage supplyPage = new FindSupplyPage();
			supplyPage.setParam(supplyDto);
			List<SupplyDto> list = supplyService.findSupplys(supplyPage);
			model.addAttribute("list", list);
			model.addAttribute("payTypes", BillPayType.values());
		}
		return LIST;
	}

	/** 新增 */
	@RequiresPermissions("member:supplier:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(SupplyDto supplyDto, RedirectAttributes redirectAttributes) {
		if(null==UserUtils.getUser().getMerchant()) {
			addMessage(redirectAttributes, "保存供应商失败！失败信息：只支持商户保存供应商");
			return "redirect:"+Global.getAdminPath()+"/member/supplier/?repage";
		}
		supplyDto.setCreateTime(new Date());
		supplyDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
		supplyDto.setMerchantName(UserUtils.getUser().getMerchant().getMerchantName());// 这里设置用户所属商户
		supplyService.addSupply(supplyDto);
		addMessage(redirectAttributes, "保存供应商'" + supplyDto.getSupplyName() + "'成功");
		return "redirect:" + adminPath + "/member/supplier/";
	}

	/** 新增/修改表单 */
	@RequiresPermissions("member:supplier:view")
	@RequestMapping(value = "/form")
	public String form(String code,Boolean isView, Model model) {
		SupplyDto param = new SupplyDto();
		param.setCode(code);
		SupplyDto rtDto = supplyService.findSupply(param);
		model.addAttribute("data", rtDto);
		model.addAttribute("payTypes", BillPayType.values());
		model.addAttribute("bankCodes", BankCode.values());
		
		if (isView != null && isView) {
			return VIEW;
		}
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("member:supplier:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(SupplyDto supplyDto, RedirectAttributes redirectAttributes) {
		supplyDto.setUpdateTime(new Date());
		supplyService.updateSupply(supplyDto);
		addMessage(redirectAttributes, "修改供应商'" + supplyDto.getSupplyName() + "'成功");
		return "redirect:" + adminPath + "/member/supplier/";
	}

	/** 启用/停用 */
	@RequiresPermissions("member:supplier:edit")
	@RequestMapping(value = "/status")
	public String status(SupplyDto supplyDto, RedirectAttributes redirectAttributes) {
		if(Status.USE.getValue().equals(supplyDto.getStatus())){
			supplyService.updateSupply(supplyDto);
			addMessage(redirectAttributes, "启用供应商成功");
		}else if(Status.STOP.getValue().equals(supplyDto.getStatus())){
			supplyService.updateSupply(supplyDto);
			addMessage(redirectAttributes, "停用供应商成功");
		}
		return "redirect:" + adminPath + "/member/supplier/";
	}
}
