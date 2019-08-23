/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.shop;

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
import com.lj.base.core.pagination.PageSortType;
import com.lj.eoms.entity.sys.Area;
import com.lj.eoms.service.sys.AreaService;
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.dto.FindShopBgImgPage;
import com.lj.eshop.dto.FindShopPage;
import com.lj.eshop.dto.FindShopStylePage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.ShopBgImgDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.dto.ShopStyleDto;
import com.lj.eshop.emus.MemberType;
import com.lj.eshop.emus.ShopGrade;
import com.lj.eshop.emus.ShopStatus;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IShopBgImgService;
import com.lj.eshop.service.IShopService;
import com.lj.eshop.service.IShopStyleService;

/**
 * 
 * 
 * 类说明：店铺@Controller
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月25日
 */
@Controller
@RequestMapping("${adminPath}/shop/")
public class ShopController extends BaseController {

	public static final String LIST = "modules/shop/list";
	public static final String FORM = "modules/shop/form";
	public static final String EDIT = "modules/shop/edit";
	public static final String VIEW = "modules/shop/view";
	
	@Autowired
	private IShopService shopService;
	@Autowired
	private AreaService areaservice;
	@Autowired
	private IShopBgImgService shopBgImgService;
	@Autowired
	private IShopStyleService shopStyleService;
	@Autowired
	private IMemberService memberService;
	
	
	/** 列表 */
	@RequiresPermissions("shop:shop:view")
	@RequestMapping(value = {"list"}, method ={RequestMethod.GET,RequestMethod.POST})
	public String list(ShopDto param,Integer pageNo,Integer pageSize, Model model) {
		try {
			param.setMerchantCode(UserUtils.getUser().getMerchant().getCode());
			FindShopPage findShopPage = new FindShopPage();
			findShopPage.setSortBy("create_time");
			findShopPage.setSortDir(PageSortType.desc);
			findShopPage.setParam(param);
			if(pageNo!=null){
				findShopPage.setStart((pageNo-1)*pageSize);
			}
			if(pageSize!=null){
				findShopPage.setLimit(pageSize);
			}
			Page<ShopDto> pageDto = shopService.findShopPage(findShopPage);
			List<ShopDto> list = Lists.newArrayList();
			list.addAll(pageDto.getRows());
			 
			com.ape.common.persistence.Page<ShopDto> page=new com.ape.common.persistence.Page<ShopDto>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
			page.initialize();
			model.addAttribute("page",page);
			model.addAttribute("shopStatus", ShopStatus.values());
			model.addAttribute("shopGrades", ShopGrade.values());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LIST;
	}

	/** 新增 */
	@RequiresPermissions("shop:shop:edit")
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(ShopDto shopDto, RedirectAttributes redirectAttributes) {
		Area area =areaservice.get(shopDto.getShopArea());
		shopDto.setShopArea(area.getCode());
		//区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）
		if(area.getType().equals("4")){
			Area city =areaservice.get(area.getParentId());
			shopDto.setShopCity(city.getCode());		//市
			Area province =areaservice.get(city.getParentId());
			shopDto.setShopProvide(province.getCode());//省
		}else if(area.getType().equals("3")){
			Area province =areaservice.get(area.getParentId());
			shopDto.setShopProvide(province.getCode());//省
		}
		shopService.addShop(shopDto);
		addMessage(redirectAttributes, "保存店铺'" + shopDto.getShopName() + "'成功");
		return "redirect:" + adminPath + "/shop/";
	}

	/** 视图表单 */
	@RequiresPermissions("shop:shop:view")
	@RequestMapping(value = {"form", "view"}, method = {RequestMethod.GET,RequestMethod.POST})
	public String form(String code,Boolean isView, Model model) {
		try {
			ShopDto param = new ShopDto();
			param.setCode(code);
			ShopDto rtDto = shopService.findShop(param);
			model.addAttribute("data", rtDto);
			
			/*背景图下拉列表*/
			ShopBgImgDto param1 = new ShopBgImgDto();
			param1.setStatus(Status.USE.getValue());
			FindShopBgImgPage findShopBgImgPage = new FindShopBgImgPage();
			findShopBgImgPage.setParam(param1);
			model.addAttribute("shopBgImgs", shopBgImgService.findShopBgImgs(findShopBgImgPage));

			/*风格下拉列表*/
			ShopStyleDto param2 = new ShopStyleDto();
			param2.setStatus(Status.USE.getValue());
			FindShopStylePage findShopStylePage = new FindShopStylePage();
			findShopStylePage.setParam(param2);
			model.addAttribute("shopStyles", shopStyleService.findShopStyles(findShopStylePage));
			
			/*门店状态*/
			model.addAttribute("shopStatus", ShopStatus.values());
			/*门店等级*/
			model.addAttribute("shopGrades", ShopGrade.values());
			if(isView!=null && isView){
				return VIEW;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("shop:shop:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(ShopDto shopDto, RedirectAttributes redirectAttributes) {
		//根据ID获取CODE
		Area area =areaservice.get(shopDto.getShopArea());
		if(area!=null){
			shopDto.setShopArea(area.getCode());
			//区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）
			if(area.getType().equals("4")){
				Area city =areaservice.get(area.getParentId());
				shopDto.setShopCity(city.getCode());		//市
				Area province =areaservice.get(city.getParentId());
				shopDto.setShopProvide(province.getCode());//省
			}else if(area.getType().equals("3")){
				Area province =areaservice.get(area.getParentId());
				shopDto.setShopProvide(province.getCode());//省
			}
		}
		shopService.updateShop(shopDto);
		addMessage(redirectAttributes, "修改店铺'" + shopDto.getShopName() + "'成功");
		return "redirect:" + adminPath + "/shop/list";
	}

	/** 审核 */
	@RequiresPermissions("shop:shop:edit")
	@RequestMapping(value = "status")
	public String status(ShopDto shopDto, RedirectAttributes redirectAttributes) {
		shopDto.setOpenTime(new Date());
		shopService.updateShop(shopDto);
		//审核通过
		if(ShopStatus.NORMAL.getValue().equals(shopDto.getStatus())){
			shopDto.setOpenTime(new Date());
			ShopDto rltShopDto = shopService.findShop(shopDto);
			
			MemberDto memberDto = new MemberDto();
			memberDto.setCode(rltShopDto.getMbrCode());
			MemberDto rltMemberDto = memberService.findMember(memberDto);
			if(rltMemberDto!=null) {
				rltMemberDto.setType(MemberType.SHOP.getValue());
				memberService.updateMember(rltMemberDto);
			}
			
		}
		addMessage(redirectAttributes, "操作"+shopDto.getShopName()+"成功");
		return "redirect:" + adminPath + "/shop/list";
	}
	
	/**
	 * 绑定设备
	 * 方法说明：
	 *
	 * @param @param shopDto
	 * @param @param redirectAttributes
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月7日
	 */
	@RequiresPermissions("shop:shop:edit")
	@RequestMapping(value = "bindDevice")
	public String bindDevice(ShopDto shopDto, RedirectAttributes redirectAttributes) {
		shopService.updateShop(shopDto);
		addMessage(redirectAttributes, "操作"+shopDto.getMimeCode()+"成功");
		return "redirect:" + adminPath + "/shop/list";
	}
}
