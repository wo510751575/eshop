/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.member;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ape.common.config.Global;
import com.ape.common.web.BaseController;
import com.google.common.collect.Lists;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.eoms.dto.ShopMemberDto;
import com.lj.eoms.utils.UserUtils;
import com.lj.eoms.utils.Validator;
import com.lj.eoms.utils.excel.ExportExcel;
import com.lj.eoms.utils.excel.ImportExcel;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.FindMemberPage;
import com.lj.eshop.dto.FindShopBgImgPage;
import com.lj.eshop.dto.FindShopStylePage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.dto.ShopBgImgDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.dto.ShopStyleDto;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.emus.Gender;
import com.lj.eshop.emus.MemberGrade;
import com.lj.eshop.emus.MemberSex;
import com.lj.eshop.emus.MemberSourceFrom;
import com.lj.eshop.emus.MemberStatus;
import com.lj.eshop.emus.MemberType;
import com.lj.eshop.emus.PaymentStatus;
import com.lj.eshop.emus.PaymentType;
import com.lj.eshop.emus.ShopGrade;
import com.lj.eshop.emus.ShopStatus;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IPaymentService;
import com.lj.eshop.service.IShopBgImgService;
import com.lj.eshop.service.IShopService;
import com.lj.eshop.service.IShopStyleService;

/**
 * 
 * 类说明：门店会员 。
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author lhy CreateDate: 2017-8-25
 */
@Controller
@RequestMapping("${adminPath}/member/member/")
public class MemberController extends BaseController {

	public static final String LIST = "modules/member/member/list";

	public static final String FORM = "modules/member/member/form";
	public static final String EDIT = "modules/member/member/edit";
	public static final String VIEW = "modules/member/member/view";
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IShopService shopService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IShopBgImgService shopBgImgService;
	@Autowired
	private IShopStyleService shopStyleService;

	/** 列表 */
	@RequiresPermissions("member:member:view")
	@RequestMapping(value = {"list", ""})
	public String list(FindMemberPage memberPage,Integer pageNo,Integer pageSize, Model model) {
		MemberDto member=memberPage.getParam();
		if(member==null){
			member=new MemberDto();
		}
		member.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
		List<String> types=new ArrayList<String>();//查询的类型 1,2,3
		types.add(MemberType.CLIENT.getValue());
		types.add(MemberType.SHOP.getValue());
		types.add(MemberType.SHOP_AND_CLIENT.getValue());
		
		memberPage.setTypes(types);
		memberPage.setParam(member);
		
		
		if(pageNo!=null){
			memberPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			memberPage.setLimit(pageSize);
		}
		Page<MemberDto> pageDto = memberService.findMemberPage(memberPage);
		List<MemberDto> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());
		 
		com.ape.common.persistence.Page<MemberDto> page=new com.ape.common.persistence.Page<MemberDto>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
		page.initialize();
		
		model.addAttribute("page",page);
		model.addAttribute("grades", MemberGrade.values());
		model.addAttribute("statuss", MemberStatus.values());
		model.addAttribute("sexs", MemberSex.values());
		model.addAttribute("types", MemberType.values());
		model.addAttribute("memberPage",memberPage);
		model.addAttribute("sourceFroms", MemberSourceFrom.values());
		return LIST;
	}

	/** 新增  无新增
	@RequiresPermissions("member:member:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(MemberDto memberDto, RedirectAttributes redirectAttributes) {
		memberDto.setCreateTime(new Date());
		memberDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
		memberService.addMember(memberDto);
		addMessage(redirectAttributes, "保存客户'" + memberDto.getName() + "'成功");
		return "redirect:" + adminPath + "/member/member/";
	}*/

	/** 新增/修改/查看表单 */
	@RequiresPermissions("member:member:view")
	@RequestMapping(value = "/form")
	public String form(String code,Boolean isView, Model model) {
		MemberDto param = new MemberDto();
		param.setCode(code);
		MemberDto rtDto = memberService.findMember(param);
		model.addAttribute("data", rtDto);
		model.addAttribute("grades", MemberGrade.values());
		model.addAttribute("statuss", MemberStatus.values());
		model.addAttribute("sexs", MemberSex.values());
		model.addAttribute("types", MemberType.values());
		model.addAttribute("sourceFroms", MemberSourceFrom.values());
		if (isView != null && isView) {
			return VIEW;
		}
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("member:member:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(MemberDto memberDto, RedirectAttributes redirectAttributes) {
		memberService.updateMember(memberDto);
		addMessage(redirectAttributes, "修改客户'" + memberDto.getName()+ "'成功");
		return "redirect:" + adminPath + "/member/member/";
	}

	/** 正常/注销/冻结 */
	@RequiresPermissions("member:member:edit")
	@RequestMapping(value = "/status")
	public String status(MemberDto memberDto, RedirectAttributes redirectAttributes) {
		if(MemberStatus.NORMAL.getValue().equals(memberDto.getStatus())){
			memberService.updateMember(memberDto);
			addMessage(redirectAttributes, "取消冻结客户成功");
		}else if(MemberStatus.CANCEL.getValue().equals(memberDto.getStatus())){
			memberService.updateMember(memberDto);
			addMessage(redirectAttributes, "注销客户成功");
		}else if(MemberStatus.FREEZE.getValue().equals(memberDto.getStatus())){
			memberService.updateMember(memberDto);
			addMessage(redirectAttributes, "冻结客户成功");
		}
		return "redirect:" + adminPath + "/member/member/";
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：导入客户数据
	 *
	 * @param file
	 * @param redirectAttributes
	 * @return
	 *
	 * @author 林进权	CreateDate: 2017年9月2日
	 *
	 */
	@RequiresPermissions("member:member:edit")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importExcel(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			
			List<ShopMemberDto> list = ei.getDataList(ShopMemberDto.class);
			logger.info("importExcel>>", list);
			MemberDto memberDto = null; 
			
			for (ShopMemberDto dto : list){
				try{
					logger.info("excel dto >>" +  dto.toString());
					/*处理excel数据转码*/
//					dto.setMobile(DictUtils.excelChage(dto.getMobile()));
					
					/*校验手机号格式*/
					if(!Validator.isMobile(dto.getMobile())){
						failureMsg.append("<br/>客户手机号： "+dto.getMobile()+"格式不正确; ");
						failureNum++;
						continue;
					}
					
					/*校验性别*/
					List<String> items = Lists.newArrayList();
					for (Gender gender : Gender.values()) {
						items.add(gender.getName());
					}
					if(!items.contains(dto.getSex().trim())){
						failureMsg.append("<br/>客户手机号： "+dto.getMobile()+"性别填写错误 ："+dto.getSex());
						failureNum++;
						continue;
					}
					
					if (checkMobile(dto.getMobile())){
						createMemberOrderInfo(memberDto, dto);
						
						successNum++;
					}else{
						failureMsg.append("<br/>手机号 "+dto.getMobile()+" 已存在; ");
						failureNum++;
					}
				}catch (Exception ex) {
					ex.printStackTrace();
					failureMsg.append("<br/>手机号 "+dto.getMobile()+" 导入失败："+ex.getMessage());
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条客户，导入信息如下：");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条客户" + failureMsg);
		}catch (Exception e) {
			addMessage(redirectAttributes, "导入客户失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/member/member/?repage";
    }
	
	private void createMemberOrderInfo(MemberDto memberDto, ShopMemberDto shopMemberDto) {
		memberDto = new MemberDto();
		memberDto.setPhone(shopMemberDto.getMobile());
		memberDto.setName(shopMemberDto.getMemberName());
		memberDto.setStatus(MemberStatus.NORMAL.getValue());
		memberDto.setSex(shopMemberDto.getSex());
		memberDto.setWxNo(shopMemberDto.getWxNo());
		memberDto.setType(MemberType.SHOP.getValue());
		memberDto.setProvince(shopMemberDto.getProvince());
		memberDto.setCity(shopMemberDto.getCity());
		memberDto.setArea(shopMemberDto.getArea());
		memberDto.setCreateTime(new Date());
		memberDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
		memberDto = memberService.addMember(memberDto);
		
		//创建商户
		ShopDto shopDto = new ShopDto();
		shopDto.setStatus(ShopStatus.NORMAL.getValue());
		shopDto.setShopGarde(ShopGrade.FIVE.getValue());
		shopDto.setReadNum(0);
		shopDto.setCreateTime(new Date());
		shopDto.setShopName(memberDto.getName());
		try {
			shopDto.setOpenTime(DateUtils.parseDate(shopMemberDto.getShopOpenTime(), "yyyy-MM-dd"));
		}catch (Exception e) {
			shopDto.setOpenTime(new Date());
			e.printStackTrace();
		}
		shopDto.setShopAddinfo(shopMemberDto.getShopAddres());
		shopDto.setMbrCode(memberDto.getCode());
		shopDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
		shopDto.setShopNo(GUID.generateCode());
		FindShopBgImgPage findShopBgImgPage = new FindShopBgImgPage();
		List<ShopBgImgDto> bgimgs = shopBgImgService.findShopBgImgs(findShopBgImgPage);
		shopDto.setBgUrl(bgimgs.get(0).getSpe());
		shopDto.setShopBgImgCode(bgimgs.get(0).getCode());
		
		FindShopStylePage findShopStylePage = new FindShopStylePage();
		List<ShopStyleDto> shopStyleDtos = shopStyleService.findShopStyles(findShopStylePage);
		shopDto.setStyleColor(shopStyleDtos.get(0).getSpe());
		shopDto.setStyleName(shopStyleDtos.get(0).getName());
		shopDto.setShopStyleCode(shopStyleDtos.get(0).getCode());
		shopService.addShop(shopDto);
		
		//预支付流水
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setBizNo(shopDto.getShopNo());
		paymentDto.setStatus(PaymentStatus.SUCCESS.getValue());
		paymentDto.setFee(new BigDecimal(0));
		paymentDto.setAmount(NoUtil.DEFAULT_CASH_PLEDGE);
		paymentDto.setSn(shopDto.getShopNo());
		paymentDto.setType(PaymentType.OFFLINE.getValue());
		paymentDto.setDelFlag(DelFlag.N.getValue());
		paymentDto.setMemo("导入用户，默认为支付成功");
		paymentService.addPayment(paymentDto);
	}

	/**
	 * 
	 *
	 * 方法说明：店主会员导入模板下载
	 *
	 * @param response
	 * @param request
	 * @param redirectAttributes
	 * @return
	 *
	 * @author 林进权	CreateDate: 2017年9月2日
	 *
	 */
	@RequiresPermissions("member:member:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response,HttpServletRequest request, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "店主会员导入模版.xlsx";
    		List<ShopMemberDto> list = Lists.newArrayList(); 
    		ShopMemberDto dto = new ShopMemberDto();
    		dto.setMemberName("小龙");
    		dto.setSex(Gender.MALE.getName());
    		dto.setMobile("13888888888");
    		dto.setProvince("广东");
    		dto.setCity("深圳市");
    		dto.setArea("福田区");
    		dto.setWxNo("wx123");
    		dto.setShopOpenTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
    		dto.setShopCountry("中国");
    		dto.setShopAddres("商店地址");
    		list.add(dto);
    		
    		dto = new ShopMemberDto();
     		dto.setMemberName("小强");
     		dto.setSex(Gender.FEMALE.getName());
     		dto.setMobile("13888888887");
     		dto.setProvince("广东");
    		dto.setCity("深圳市");
    		dto.setArea("福田区");
    		dto.setWxNo("wx124");
    		dto.setShopOpenTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
    		dto.setShopCountry("中国");
    		dto.setShopAddres("商店地址222");
    		list.add(dto);
    		
    		new ExportExcel("店主会员导入模版", ShopMemberDto.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "店主会员导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/member/?repage";
    }
	
	private boolean checkMobile(String mobile) {
		FindMemberPage findMemberPage = new FindMemberPage();
		MemberDto param = new MemberDto();
		param.setPhone(mobile);
		findMemberPage.setParam(param);
		List<MemberDto> list = memberService.findMembers(findMemberPage);
		if(null==list || list.size()==0) {
			return true;
		}
		return false; 
	}
}
