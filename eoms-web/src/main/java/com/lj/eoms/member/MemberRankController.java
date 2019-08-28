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
import com.lj.eshop.dto.FindMemberRankPage;
import com.lj.eshop.dto.MemberRankDto;
import com.lj.eshop.service.IMemberRankService;

/**
 * 
 * 类说明：会员特权
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@Controller
@RequestMapping("${adminPath}/member/memberRank/")
public class MemberRankController extends BaseController {

	public static final String LIST = "modules/member/memberRank/list";

	public static final String FORM = "modules/member/memberRank/form";
	public static final String EDIT = "modules/member/memberRank/edit";
	public static final String VIEW = "modules/member/memberRank/view";
	@Autowired
	private IMemberRankService memberRankService;

	/** 列表 */
	@RequiresPermissions("member:memberRank:view")
	@RequestMapping(value = { "list", "" })
	public String list(FindMemberRankPage findMemberRankPage, Integer pageNo, Integer pageSize, Model model) {
		MemberRankDto param = findMemberRankPage.getParam();
		if(null==param) {
			param = new MemberRankDto();
		}
		param.setDelFlag("0");
		findMemberRankPage.setParam(param);
		if (pageNo != null) {
			findMemberRankPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			findMemberRankPage.setLimit(pageSize);
		}
		Page<MemberRankDto> pageDto = memberRankService.findMemberRankPage(findMemberRankPage);
		List<MemberRankDto> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());

		com.ape.common.persistence.Page<MemberRankDto> page = new com.ape.common.persistence.Page<MemberRankDto>(
				pageNo == null ? 1 : pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
		page.initialize();

		model.addAttribute("page", page);
		model.addAttribute("findMemberRankPage", findMemberRankPage);
		model.addAttribute("name", param.getName());
		return LIST;
	}

	/** 新增 无新增 */
	@RequiresPermissions("member:memberRank:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(MemberRankDto memberRankDto, RedirectAttributes redirectAttributes) {
		memberRankDto.setCreateDate(new Date());
		memberRankService.addMemberRank(memberRankDto);
		addMessage(redirectAttributes, "保存会员特权'" + memberRankDto.getName() + "'成功");
		return "redirect:" + adminPath + "/member/memberRank/";
	}

	/** 新增/修改/查看表单 */
	@RequiresPermissions("member:memberRank:view")
	@RequestMapping(value = "/form")
	public String form(String code, Boolean isView, Model model) {
		try {
			MemberRankDto param = new MemberRankDto();
			param.setCode(code);
			MemberRankDto rtDto = memberRankService.findMemberRank(param);
			model.addAttribute("data", rtDto);
			if (isView != null && isView) {
				return VIEW;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("member:memberRank:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(MemberRankDto memberRankDto, RedirectAttributes redirectAttributes) {
		memberRankService.updateMemberRank(memberRankDto);
		addMessage(redirectAttributes, "修改会员特权'" + memberRankDto.getName() + "'成功");
		return "redirect:" + adminPath + "/member/memberRank/";
	}

	/** 删除 */
	@RequiresPermissions("member:memberRank:edit")
	@RequestMapping(value = "/delete")
	public String delete(MemberRankDto memberRankDto, RedirectAttributes redirectAttributes) {
		memberRankDto.setDelFlag("1");
		memberRankService.updateMemberRank(memberRankDto);
		addMessage(redirectAttributes, "删除会员特权成功");
		return "redirect:" + adminPath + "/member/memberRank/";
	}
	
}
