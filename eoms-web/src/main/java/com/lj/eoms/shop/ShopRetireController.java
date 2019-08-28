/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.shop;

import java.math.BigDecimal;
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
import com.lj.base.core.pagination.PageSortType;
import com.lj.base.core.util.StringUtils;
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.FindShopRetirePage;
import com.lj.eshop.dto.ShopRetireDto;
import com.lj.eshop.emus.AuditStatus;
import com.lj.eshop.emus.ExpressStatus;
import com.lj.eshop.emus.RetireStatus;
import com.lj.eshop.emus.ShopRetireViewStatus;
import com.lj.eshop.service.IShopRetireService;

/**
 * 
 * 
 * 类说明：店铺押金退出申请@Controller
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月26日
 */
@Controller
@RequestMapping("${adminPath}/shop/retire")
public class ShopRetireController extends BaseController {

	public static final String LIST = "modules/shop/retire/list";
	public static final String FORM = "modules/shop/retire/form";
	public static final String EDIT = "modules/shop/retire/edit";
	public static final String VIEW = "modules/shop/retire/view";
	
	@Autowired
	private IShopRetireService shopRetireService;
	
	
	/** 列表 */
	@RequiresPermissions("shop:retire:view")
	@RequestMapping(value = {"list",""}, method = {RequestMethod.GET,RequestMethod.POST})
	public String list(ShopRetireDto param,Integer pageNo,Integer pageSize, Model model) {
		try {
			FindShopRetirePage findShopRetirePage = new FindShopRetirePage(); 
			findShopRetirePage.setSortBy("create_time");
			findShopRetirePage.setSortDir(PageSortType.desc);
			findShopRetirePage.setParam(param);
			if(pageNo!=null){
				findShopRetirePage.setStart((pageNo-1)*pageSize);
			}
			if(pageSize!=null){
				findShopRetirePage.setLimit(pageSize);
			}
			Page<ShopRetireDto> pageDto = shopRetireService.findShopRetirePage(findShopRetirePage);
			List<ShopRetireDto> list = Lists.newArrayList();
			list.addAll(pageDto.getRows());
			 
			com.ape.common.persistence.Page<ShopRetireDto> page=new com.ape.common.persistence.Page<ShopRetireDto>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
			page.initialize();
			model.addAttribute("page",page);
			model.addAttribute("auditStatus", AuditStatus.values());
			model.addAttribute("expressStatus", ExpressStatus.values());
			model.addAttribute("retireStatus", RetireStatus.values());
			model.addAttribute("param", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return LIST;
	}


	/** 审核*/
	@RequiresPermissions("shop:retire:edit")
	@RequestMapping(value = "/status")
	public String status(ShopRetireDto shopRetireDto,BigDecimal amount, RedirectAttributes redirectAttributes) {
		try {
			if(StringUtils.equals(shopRetireDto.getRetireStatus(), RetireStatus.SUCCESS.getValue())) {
				if(amount.compareTo(NoUtil.DEFAULT_CASH_PLEDGE)>0) {
					addMessage(redirectAttributes, "打款押金不能大于"+NoUtil.DEFAULT_CASH_PLEDGE);
					return "redirect:" + adminPath + "/shop/retire/list";
				}
			}
			
			
			/*审核人为当前登录人*/
			shopRetireDto.setAuditor(UserUtils.getUser().getName());
			shopRetireService.audit(shopRetireDto,amount);
			addMessage(redirectAttributes, "操作'"+shopRetireDto.getRetireNo()+"'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/shop/retire/list";
	}
}
