/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.member;

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
import com.lj.base.core.util.StringUtils;
import com.lj.eoms.dto.MerchantSettingModel;
import com.lj.eshop.dto.FindMerchantPage;
import com.lj.eshop.dto.FindMerchantSettingPage;
import com.lj.eshop.dto.MerchantDto;
import com.lj.eshop.dto.MerchantSettingDto;
import com.lj.eshop.service.IMerchantService;
import com.lj.eshop.service.IMerchantSettingService;

/**
 * 
 * 
 * 类说明：商户@Controller
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月30日
 */
@Controller
@RequestMapping("${adminPath}/member/merchant/")
public class MerchantController extends BaseController {

	public static final String LIST = "modules/member/merchant/list";
	public static final String SETTING_LIST = "modules/member/merchant/setting";
	public static final String FORM = "modules/member/merchant/form";
	public static final String EDIT = "modules/member/merchant/edit";
	public static final String VIEW = "modules/member/merchant/view";
	@Autowired
	private IMerchantService merchantService;
	@Autowired
	private IMerchantSettingService merchantSettingService;

	/** 列表 */
	@RequiresPermissions("member:merchant:view")
	@RequestMapping(value = {"list", ""})
	public String list(FindMerchantPage merchantPage,Integer pageNo,Integer pageSize, Model model) {
		MerchantDto merchant=merchantPage.getParam();
		if(merchant==null){
			merchant=new MerchantDto();
		}
		merchantPage.setParam(merchant);
		if(pageNo!=null){
			merchantPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			merchantPage.setLimit(pageSize);
		}
		Page<MerchantDto> pageDto = merchantService.findMerchantPage(merchantPage);
		List<MerchantDto> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());
		 
		com.ape.common.persistence.Page<MerchantDto> page=new com.ape.common.persistence.Page<MerchantDto>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
		page.initialize();
		
		model.addAttribute("page",page);
		model.addAttribute("findMerchantPage",merchantPage);
		return LIST;
	}

	/**设置**/
	@RequiresPermissions("member:merchant:edit")
	@RequestMapping(value = "/setting")
	public String setting(MerchantDto merchantDto, RedirectAttributes redirectAttributes, Model model) {
		FindMerchantSettingPage page = new FindMerchantSettingPage();
		MerchantSettingDto param = new MerchantSettingDto();
		param.setMerchantCode(merchantDto.getCode());
		page.setParam(param);
		List<MerchantSettingDto> list = merchantSettingService.findMerchantSettings(page);
		model.addAttribute("data", merchantDto);
		model.addAttribute("list", list);
		return SETTING_LIST;
	}
	/**设置**/
	@RequiresPermissions("member:merchant:edit")
	@RequestMapping(value = "/saveSetting")
	public String saveSetting(MerchantDto merchantDto, RedirectAttributes redirectAttributes, MerchantSettingModel model) {
		
		for (MerchantSettingDto setting : model.getSettings()) {
			setting.setMerchantCode(merchantDto.getCode());
			if(StringUtils.isEmpty(setting.getStatus())) {
				setting.setStatus("1");
			} else {
				setting.setStatus("0");
			}
			if(StringUtils.isEmpty(setting.getCode())) {
				setting.setCreateTime(new Date());
				merchantSettingService.addMerchantSetting(setting);			
			} else {
				merchantSettingService.updateMerchantSetting(setting);
			}
		}
		
		addMessage(redirectAttributes, "修改设置成功");
		return "redirect:" + adminPath + "/member/merchant/";
	}

	/** 新增/修改/查看表单 */
	@RequiresPermissions("member:merchant:view")
	@RequestMapping(value = "/form")
	public String form(String code,Boolean isView, Model model) {
		MerchantDto param = new MerchantDto();
		param.setCode(code);
		MerchantDto rtDto = merchantService.findMerchant(param);
		model.addAttribute("data", rtDto);
		if (isView != null && isView) {
			return VIEW;
		}
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("member:merchant:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(MerchantDto merchantDto, RedirectAttributes redirectAttributes) {
		merchantService.updateMerchant(merchantDto);
		addMessage(redirectAttributes, "修改客户'" + merchantDto.getMerchantName()+ "'成功");
		return "redirect:" + adminPath + "/merchant/merchant/";
	}

}
