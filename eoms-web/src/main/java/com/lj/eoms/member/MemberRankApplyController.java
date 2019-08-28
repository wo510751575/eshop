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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ape.common.web.BaseController;
import com.google.common.collect.Lists;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.FindMemberRankApplyPage;
import com.lj.eshop.dto.MemberRankApplyDto;
import com.lj.eshop.emus.MemberRankApplyStatus;
import com.lj.eshop.service.IMemberRankApplyService;

/**
 * 
 * 类说明：特权申请
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@Controller
@RequestMapping("${adminPath}/member/memberRankApply/")
public class MemberRankApplyController extends BaseController {

	public static final String LIST = "modules/member/memberRankApply/list";

	public static final String FORM = "modules/member/memberRankApply/form";
	public static final String EDIT = "modules/member/memberRankApply/edit";
	public static final String VIEW = "modules/member/memberRankApply/view";
	@Autowired
	private IMemberRankApplyService memberRankApplyService;

	/** 列表 */
	@RequiresPermissions("member:memberRankApply:view")
	@RequestMapping(value = { "list", "" })
	public String list(FindMemberRankApplyPage findMemberRankApplyPage, Integer pageNo, Integer pageSize, Model model) {
		MemberRankApplyDto param = findMemberRankApplyPage.getParam();
		if(null==param) {
			param = new MemberRankApplyDto();
		}
		param.setDelFlag("0");
		findMemberRankApplyPage.setParam(param);
		if (pageNo != null) {
			findMemberRankApplyPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			findMemberRankApplyPage.setLimit(pageSize);
		}
		Page<MemberRankApplyDto> pageDto = memberRankApplyService.findMemberRankApplyPage(findMemberRankApplyPage);
		List<MemberRankApplyDto> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());
		
		com.ape.common.persistence.Page<MemberRankApplyDto> page = new com.ape.common.persistence.Page<MemberRankApplyDto>(
				pageNo == null ? 1 : pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
		page.initialize();

		model.addAttribute("page", page);
		model.addAttribute("findMemberRankApplyPage", findMemberRankApplyPage);
		model.addAttribute("statuss", MemberRankApplyStatus.values());
		return LIST;
	}



	/** 新增/修改/查看表单 */
	@RequiresPermissions("member:memberRankApply:view")
	@RequestMapping(value = "/form")
	public String form(String code, Boolean isView, Model model) {
		try {
			MemberRankApplyDto param = new MemberRankApplyDto();
			param.setCode(code);
			MemberRankApplyDto rtDto = memberRankApplyService.findMemberRankApply(param);
			model.addAttribute("data", rtDto);
			if (isView != null && isView) {
				return VIEW;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM;
	}

	
	/** 审核 */
	@RequiresPermissions("member:memberRankApply:edit")
	@RequestMapping(value = "/status")
	public String status(MemberRankApplyDto memberRankApplyDto, RedirectAttributes redirectAttributes) {
		if(StringUtils.isNotEmpty(memberRankApplyDto.getStatus())) {
			MemberRankApplyDto rtDto = new MemberRankApplyDto();
			rtDto.setCode(memberRankApplyDto.getCode());
			rtDto = memberRankApplyService.findMemberRankApply(rtDto);
			//状态为空或者待审核的才可以修改状态
			if(StringUtils.isEmpty(rtDto.getStatus()) || StringUtils.equal(rtDto.getStatus(),MemberRankApplyStatus.WAIT.getValue())) {
				try {
					rtDto.setApproveTime(new Date());
					rtDto.setStatus(memberRankApplyDto.getStatus());
					memberRankApplyService.updateByPkAndStatus(rtDto);
					addMessage(redirectAttributes, "特权申请审核操作成功");
				} catch (TsfaServiceException e) {
					addMessage(redirectAttributes, "特权申请审核操作失败："+ e.getMessage());
				}
			} else {
				addMessage(redirectAttributes, "特权申请审核操作失败");
			}
		}
		return "redirect:" + adminPath + "/member/memberRankApply/";
	}
	
}
