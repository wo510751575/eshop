/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.finance;

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
import com.lj.base.core.pagination.PageSortType;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindWithdrawPage;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.dto.WithdrawDto;
import com.lj.eshop.emus.MemberRankApplyStatus;
import com.lj.eshop.emus.MessageTemplate;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IMessageService;
import com.lj.eshop.service.IWithdrawService;

/**
 * 
 * 
 * 类说明：提现申请@Controller
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月30日
 */
@Controller
@RequestMapping("${adminPath}/finance/withdraw/")
public class WithdrawController extends BaseController {

	public static final String LIST = "modules/finance/withdraw/list";

	public static final String FORM = "modules/finance/withdraw/form";
	public static final String EDIT = "modules/finance/withdraw/edit";
	public static final String VIEW = "modules/finance/withdraw/view";

	@Autowired
	private IWithdrawService withdrawService;
	@Autowired
	private IAccountService iAccountService;
	@Autowired
	private IMessageService messageService;

	/** 列表 */
	@RequiresPermissions("finance:withdraw:view")
	@RequestMapping(value = { "list", "" })
	public String list(FindWithdrawPage findWithdrawPage, Integer pageNo, Integer pageSize, Model model) {
		WithdrawDto reqDto=findWithdrawPage.getParam();
		if(reqDto==null){
			reqDto=new WithdrawDto();
			findWithdrawPage.setParam(reqDto);
		}
		
		if (pageNo != null) {
			findWithdrawPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			findWithdrawPage.setLimit(pageSize);
		}
		findWithdrawPage.setSortDir(PageSortType.desc);
		findWithdrawPage.setSortBy("create_time");
		Page<WithdrawDto> pageDto = withdrawService.findWithdrawPage(findWithdrawPage);
		List<WithdrawDto> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());

		com.ape.common.persistence.Page<WithdrawDto> page = new com.ape.common.persistence.Page<WithdrawDto>(
				pageNo == null ? 1 : pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
		page.initialize();

		model.addAttribute("page", page);
		return LIST;
	}


	/** 新增/修改/查看表单 */
	@RequiresPermissions("finance:withdraw:view")
	@RequestMapping(value = "/form")
	public String form(String code, Boolean isView, Model model) {
		model.addAttribute("statuss", Status.values());
		try {
			WithdrawDto param = new WithdrawDto();
			param.setCode(code);
			WithdrawDto rtDto = withdrawService.findWithdraw(param);
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
	@RequiresPermissions("finance:withdraw:edit")
	@RequestMapping(value = "/status")
	public String status(WithdrawDto withdrawDto, RedirectAttributes redirectAttributes) {
		//如果审核状态为空，就不做处理
		if(StringUtils.isNotEmpty(withdrawDto.getStatus())) {
			WithdrawDto rtDto = new WithdrawDto(); 
			rtDto.setCode(withdrawDto.getCode());
			rtDto = withdrawService.findWithdraw(rtDto);
			//状态为空或者待审核的才可以修改状态
			if(StringUtils.isEmpty(rtDto.getStatus()) || StringUtils.equal(rtDto.getStatus(),MemberRankApplyStatus.WAIT.getValue())) {
				rtDto.setUpdateTime(new Date());
				rtDto.setStatus(withdrawDto.getStatus());
				
				//金额恢复，
				AccountDto rAccountDto = iAccountService.findAccountByMbrCode(rtDto.getMbrCode());
				//审核失败
				if(StringUtils.equal(withdrawDto.getStatus(),MemberRankApplyStatus.FAIL.getValue())) {
					
					
					if(null!=rtDto.getAmt()) {
						//可用增加，
						rAccountDto.setCashAmt(rAccountDto.getCashAmt().add(rtDto.getAmt()));
						//提现总额减少
						rAccountDto.setTotalWithdrawAmt(rAccountDto.getTotalWithdrawAmt().subtract(rtDto.getAmt()));
						iAccountService.updateAccount(rAccountDto);
					}
				} else if(StringUtils.equal(withdrawDto.getStatus(),MemberRankApplyStatus.SUCCESS.getValue())) {
					
					//通知申请成功
					MessageDto messageDto = new MessageDto();
					messageDto.setRecevier(rAccountDto.getMbrCode());
					messageService.addMessageByTemplate(messageDto, MessageTemplate.B_SERVICE_NOT_PARAM_WITHDRAW);
				}
				
				withdrawService.updateWithdraw(rtDto);
				addMessage(redirectAttributes, "审核操作成功");
			} else {
				addMessage(redirectAttributes, "审核操作失败");
			}
		}
		return "redirect:" + adminPath + "/finance/withdraw/";
	}
}
