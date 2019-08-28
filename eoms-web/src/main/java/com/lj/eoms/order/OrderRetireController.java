/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.order;

import java.util.List;

import org.apache.log4j.Logger;
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
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.dto.FindOrderRetirePage;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.OrderRetireDto;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AuditStatus;
import com.lj.eshop.emus.OrderInvoice;
import com.lj.eshop.emus.OrderRetireType;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.emus.RetireStatus;
import com.lj.eshop.service.IOrderRetireService;
import com.lj.eshop.service.IOrderService;

/**
 * 
 * 
 * 类说明：订单退货@Controller
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月29日
 */
@Controller
@RequestMapping("${adminPath}/order/retire")
public class OrderRetireController extends BaseController {

	public static final String LIST = "modules/order/retire/list";
	public static final String FORM = "modules/order/retire/form";
	public static final String EDIT = "modules/order/retire/edit";
	public static final String VIEW = "modules/order/retire/view";
	
	private Logger log = Logger.getLogger(getClass());
	@Autowired
	private IOrderRetireService orderRetireService;
	@Autowired
	private IOrderService orderService;
	
	
	/** 列表 */
	@RequiresPermissions("order:retire:view")
	@RequestMapping(value = {"list",""}, method = {RequestMethod.GET,RequestMethod.POST})
	public String list(FindOrderRetirePage findOrderRetirePage,Integer pageNo,Integer pageSize, Model model) {
		try {
			OrderRetireDto orderRetire=findOrderRetirePage.getParam();
			if(orderRetire==null){
				orderRetire=new OrderRetireDto();
			}
			findOrderRetirePage.setSortBy("create_time");
			findOrderRetirePage.setSortDir(PageSortType.desc);
			findOrderRetirePage.setParam(orderRetire);
			if(pageNo!=null){
				findOrderRetirePage.setStart((pageNo-1)*pageSize);
			}
			if(pageSize!=null){
				findOrderRetirePage.setLimit(pageSize);
			}
			Page<OrderRetireDto> pageDto = orderRetireService.findOrderRetirePage(findOrderRetirePage);
			List<OrderRetireDto> list = Lists.newArrayList();
			list.addAll(pageDto.getRows());
			 
			com.ape.common.persistence.Page<OrderRetireDto> page=new com.ape.common.persistence.Page<OrderRetireDto>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
			page.initialize();
			model.addAttribute("page",page);
			model.addAttribute("auditStatus", AuditStatus.values());
			model.addAttribute("orderRetireTypes", OrderRetireType.values());
			model.addAttribute("retireStatus", RetireStatus.values());
			model.addAttribute("orderRetireParam", orderRetire);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return LIST;
	}

	/** 视图 */
	@RequiresPermissions("order:order:view")
	@RequestMapping(value = {"form", "view"}, method = {RequestMethod.GET,RequestMethod.POST})
	public String form(String code, Model model) {
		try {
			OrderRetireDto param = new OrderRetireDto();
			param.setCode(code);
			OrderRetireDto dto = orderRetireService.findOrderRetire(param);
			model.addAttribute("data", dto);
			model.addAttribute("auditStatus", AuditStatus.values());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return VIEW;
	}

	/** 审核*/
	@RequiresPermissions("order:retire:edit")
	@RequestMapping(value = "/status")
	public String status(String code,String failReason,String auditStatus, RedirectAttributes redirectAttributes) {
		try {
			OrderRetireDto parm = new OrderRetireDto();
			parm.setCode(code);
			OrderRetireDto retireDto= orderRetireService.findOrderRetire(parm);
			
			/*构建退货对象*/
			OrderRetireDto orderRetireDto = new OrderRetireDto();
			orderRetireDto.setCode(code);
			orderRetireDto.setFailReason(failReason);
			orderRetireDto.setAuditor(UserUtils.getUser().getName());
			orderRetireDto.setAuditStatus(auditStatus);
			orderRetireDto.setOrderNo(retireDto.getOrderNo());
			orderRetireDto.setRetireNo(retireDto.getRetireNo());
			orderService.returns(orderRetireDto, orderRetireDto.getFailReason());
			addMessage(redirectAttributes, "操作退单号:'"+orderRetireDto.getRetireNo()+"'成功");
		} catch (Exception e) {
//			log.error(e);
			e.printStackTrace();
			addMessage(redirectAttributes, e.toString());
		}
		return "redirect:" + adminPath + "/order/retire/list";
	}
}
