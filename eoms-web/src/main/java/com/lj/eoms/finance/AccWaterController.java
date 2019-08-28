/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.finance;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ape.common.config.Global;
import com.ape.common.web.BaseController;
import com.google.common.collect.Lists;
import com.lj.base.core.pagination.Page;
import com.lj.eoms.dto.AccWaterExportDto;
import com.lj.eoms.utils.UserUtils;
import com.lj.eoms.utils.excel.ExportExcel;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.dto.FindAccountPage;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAccountService;

/**
 * 
 * 类说明：账户流水
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@Controller
@RequestMapping("${adminPath}/finance/accwater/")
public class AccWaterController extends BaseController {

	public static final String LIST = "modules/finance/accwater/list";

	public static final String FORM = "modules/finance/accwater/form";
	public static final String EDIT = "modules/finance/accwater/edit";
	public static final String VIEW = "modules/finance/accwater/view";

	@Autowired
	private IAccWaterService accWaterService;
	@Autowired
	private IAccountService accountService;

	/** 列表 */
	@RequiresPermissions("finance:accwater:view")
	@RequestMapping(value = { "list", "" })
	public String list(FindAccWaterPage findAccWaterPage, Integer pageNo, Integer pageSize, Model model) {
		AccWaterDto reqDto=findAccWaterPage.getParam();
		if(reqDto==null){
			reqDto=new AccWaterDto();
			findAccWaterPage.setParam(reqDto);
		}
		
		if (pageNo != null) {
			findAccWaterPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			findAccWaterPage.setLimit(pageSize);
		}
		Page<AccWaterDto> pageDto = accWaterService.findAccWaterPage(findAccWaterPage);
		List<AccWaterDto> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());

		com.ape.common.persistence.Page<AccWaterDto> page = new com.ape.common.persistence.Page<AccWaterDto>(
				pageNo == null ? 1 : pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
		page.initialize();

		model.addAttribute("page", page);
		model.addAttribute("findAccWaterPage", findAccWaterPage);
		model.addAttribute("accwatersource", AccWaterSource.values());
		model.addAttribute("accwateracctype", AccWaterAccType.values());
		model.addAttribute("accwaterpaytype", AccWaterPayType.values());
		model.addAttribute("accwaterbiztype", AccWaterBizType.values());
		model.addAttribute("accwatertype", AccWaterType.values());
		model.addAttribute("statuss", AccWaterStatus.values());
		return LIST;
	}

	/** 人工补单 */
	@RequiresPermissions("content:wshopinfo:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(AccWaterDto accWaterDto, RedirectAttributes redirectAttributes) {
		
		FindAccountPage findAccountPage = new FindAccountPage();
		AccountDto findAccountPageParam = new AccountDto();
		findAccountPageParam.setAccNo(accWaterDto.getAccNo());
		findAccountPage.setParam(findAccountPageParam);
		List<AccountDto> accountList = accountService.findAccounts(findAccountPage);
		if(accountList.size()==0) {
			addMessage(redirectAttributes, "查询不到帐户");
			return "redirect:" + adminPath + "/finance/accwater/";
		}
		accWaterDto.setAccType(AccWaterAccType.MANUAL.getValue());
		accWaterDto.setOpCode(UserUtils.getUser().getName());// 这里设置用户
		accWaterDto.setUpdateTime(new Date());
		accWaterDto.setAccDate(new Date());
		accWaterService.addAccWater(accWaterDto);
		
		AccountDto rltAccountDto = accountList.get(0);
		if(StringUtils.equals(accWaterDto.getAccSource(), AccWaterSource.VIP.getValue())) {
			rltAccountDto.setRankCashAmt(accWaterDto.getAfterAmt());
		} else {
			rltAccountDto.setCashAmt(accWaterDto.getAfterAmt());
		}
		
		accountService.addAccount(rltAccountDto);
		
		addMessage(redirectAttributes, "保存成功");
		return "redirect:" + adminPath + "/finance/accwater/";
	}
	
	/** 新增/修改/查看表单 */
	@RequiresPermissions("finance:accwater:view")
	@RequestMapping(value = "/form")
	public String form(String code, Boolean isView, Model model) {
		model.addAttribute("statuss", Status.values());
		try {
			AccWaterDto param = new AccWaterDto();
			param.setCode(code);
			AccWaterDto rtDto = accWaterService.findAccWater(param);
			model.addAttribute("data", rtDto);
			model.addAttribute("accwatersource", AccWaterSource.values());
			model.addAttribute("accwateracctype", AccWaterAccType.values());
			model.addAttribute("accwaterpaytype", AccWaterPayType.values());
			model.addAttribute("accwaterbiztype", AccWaterBizType.values());
			model.addAttribute("accwatertype", AccWaterType.values());
			if (isView != null && isView) {
				return VIEW;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM;
	}

	/**
	 * 
	 * 方法说明： 导出
	 *
	 * @author 林进权
	 *         CreateDate: 2017年8月29日
	 */
	@RequiresPermissions("finance:accwater:view")
    @RequestMapping(value = "export")
    public String export(HttpServletResponse response,FindAccWaterPage findAccWaterPage,Integer pageNo,Integer pageSize, RedirectAttributes redirectAttributes) {
		try {
    		
    		List<AccWaterDto> list = accWaterService.findAccWaters(findAccWaterPage);
    		for (AccWaterDto accWaterDto : list) {
    			if(StringUtils.isNotBlank(accWaterDto.getAccType())) {
    				accWaterDto.setAccType(AccWaterAccType.getChName(accWaterDto.getAccType()));
    			}
    			if(StringUtils.isNotBlank(accWaterDto.getBizType())) {
    				accWaterDto.setBizType(AccWaterBizType.getChName(accWaterDto.getBizType()));
    			}
    			if(StringUtils.isNotBlank(accWaterDto.getPayType())) {
    				accWaterDto.setPayType(AccWaterPayType.getChName(accWaterDto.getPayType()));
    			}
    			if(StringUtils.isNotBlank(accWaterDto.getAccSource())) {
    				accWaterDto.setAccSource(AccWaterSource.getChName(accWaterDto.getAccSource()));
    			}
    			if(StringUtils.isNotBlank(accWaterDto.getStatus())) {
    				accWaterDto.setStatus(AccWaterStatus.getChName(accWaterDto.getStatus()));
    			}
    			if(StringUtils.isNotBlank(accWaterDto.getWaterType())) {
    				accWaterDto.setWaterType(AccWaterStatus.getChName(accWaterDto.getWaterType()));
    			}
			}
    		
    		String fileName = "帐户流水导出.xlsx";
    		new ExportExcel("帐户流水导出", AccWaterExportDto.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "帐户流水导出失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"modules/finance/accwater/?repage";
    }
	
}
