/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.member;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.dto.FindMemberRankApplyPage;
import com.lj.eshop.dto.FindMemberRankPage;
import com.lj.eshop.dto.MemberRankApplyDto;
import com.lj.eshop.dto.MemberRankDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.MemberRankApplyStatus;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IMemberRankApplyService;
import com.lj.eshop.service.IMemberRankService;
import com.lj.eshop.service.IShopService;

/**
 * 
 * 类说明：我的特权
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年9月1日
 */
@RestController
@RequestMapping("/member/memberRankApply")
public class MemberRankApplyController extends BaseController{

	@Autowired
	private IMemberRankApplyService memberRankApplyService;
	@Autowired
	private IMemberRankService memberRankService;
	@Autowired
	private IShopService shopService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IAccWaterService accWaterService;
	

	/**
	 * 方法说明： 会员特权列表()
	 * @author 林进权
	 * 
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"list"})
	@ResponseBody
	public ResponseDto list() {
		logger.debug("MemberRankController --> list() - start"); 
		
		FindMemberRankPage findMemberRankPage = new FindMemberRankPage();
		MemberRankDto dto = new MemberRankDto();
		dto.setDelFlag("0");
		findMemberRankPage.setParam(dto);
		List<MemberRankDto> list = memberRankService.findMemberRanks(findMemberRankPage);
		
		ShopDto paramShopDto = new ShopDto();
		paramShopDto.setCode(getLoginShopCode());
		ShopDto rltShopDto = shopService.findShop(paramShopDto);
		List<MemberRankDto> endMemberRankList = list; 
		
		//如果已经过期，清除特权信息
		if(null!=rltShopDto.getRankExpireTime() && (rltShopDto.getRankExpireTime().getTime()<new Date().getTime())) {
			
			ShopDto updShopDto = new ShopDto();
			updShopDto.setCode(rltShopDto.getCode());
			updShopDto.setRankCode(null);
			updShopDto.setRankExpireTime(null);
			this.shopService.updateShop(updShopDto);
		} else {

			//如果本身有特权权限，过滤
			if(null!=rltShopDto && StringUtils.isNotEmpty(rltShopDto.getRankCode())) {
				AccountDto accountDto = accountService.findAccountByMbrCode(getLoginMemberCode());
				FindAccWaterPage findAccWaterPage = new FindAccWaterPage();
				AccWaterDto accWaterDto = new AccWaterDto();
				accWaterDto.setAccDate(new Date());
				accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
				accWaterDto.setAccSource(AccWaterSource.ORDER.getValue());
				accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
				accWaterDto.setBizType(AccWaterBizType.PAYMENT.getValue());
				accWaterDto.setWaterType(AccWaterType.SUBTRACT.getValue());
				accWaterDto.setPayType(AccWaterPayType.RANK.getValue());
				accWaterDto.setAccCode(accountDto.getCode());
				findAccWaterPage.setParam(accWaterDto);
				List<AccWaterDto> acclist = accWaterService.findAccWaters(findAccWaterPage);
				
				endMemberRankList = new LinkedList<MemberRankDto>();
				MemberRankDto shopRankDto = new MemberRankDto();
				shopRankDto.setCode(rltShopDto.getRankCode());
				MemberRankDto rltShopMemberRankDto = memberRankService.findMemberRank(shopRankDto);
				
				for (MemberRankDto memberRankDto : list) {
					if(memberRankDto.getAmount().compareTo(rltShopMemberRankDto.getAmount())>0) {
						memberRankDto.setAmount(memberRankDto.getAmount().subtract(rltShopMemberRankDto.getAmount())); //重算购买特权的金额
						
						//如果不是不限制,重算可购买次数 
						if(rltShopMemberRankDto.getScale()!=null && rltShopMemberRankDto.getScale()!=0d && memberRankDto.getScale()!=0d) {
							BigDecimal rltShopScale = new BigDecimal(acclist.size());
							BigDecimal rankScale = new BigDecimal(memberRankDto.getScale());
							memberRankDto.setScale(rankScale.subtract(rltShopScale).doubleValue());
						}
						endMemberRankList.add(memberRankDto);
					}
				}
			} 
		}
		
		
		if(null==endMemberRankList || endMemberRankList.size()==0){
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		
		logger.debug("MemberRankController --> list(={}) - end");
		return ResponseDto.successResp(endMemberRankList);
	}
	/**
	 * 方法说明： 我的特权-查询现有特权信息
	 * @author 林进权
	 * 
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"view"})
	@ResponseBody
	public ResponseDto view() {
		logger.debug("MemberRankController --> view() - start"); 
		
		ShopDto paramShopDto = new ShopDto();
		paramShopDto.setCode(getLoginShopCode());
		ShopDto shopDto = shopService.findShop(paramShopDto);
		
		if(null==shopDto || StringUtils.isEmpty(shopDto.getRankCode())) {
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		
		MemberRankDto param = new MemberRankDto();
		param.setCode(shopDto.getRankCode());
		MemberRankDto memberRankDto = memberRankService.findMemberRank(param);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("amount", memberRankDto.getAmount());
		map.put("rankName", memberRankDto.getName());
		map.put("scale", memberRankDto.getScale());
		map.put("rankExpireTime", shopDto.getRankExpireTime());
		map.put("bgUrl", shopDto.getBgUrl());
		map.put("img", shopDto.getImg());
		map.put("shopName", shopDto.getShopName());
		map.put("validRank", 1);
		if(null!=shopDto.getRankExpireTime() &&
				shopDto.getRankExpireTime().getTime()>(new Date()).getTime()
				) {
			map.put("validRank", 0);
		}
		
		
		AccountDto accountDto = accountService.findAccountByMbrCode(getLoginMemberCode());
		if(null!=accountDto) {
			map.put("rankCashAmt", accountDto.getRankCashAmt());
		}
		
		
		FindMemberRankPage findMemberRankPage = new FindMemberRankPage();
		MemberRankDto dto = new MemberRankDto();
		dto.setDelFlag("0");
		findMemberRankPage.setParam(dto);
		List<MemberRankDto> memberRankDtos = memberRankService.findMemberRanks(findMemberRankPage);
		int gtCnt = 0;
		for (MemberRankDto memberRankDto2 : memberRankDtos) {
			if(memberRankDto.getAmount().compareTo(memberRankDto2.getAmount())>=0) {
				gtCnt++;
			}
		}
		
		//如果是最大, 0不是，1是
		map.put("isMax", 0);
		if(gtCnt==memberRankDtos.size()) {
			map.put("isMax", 1);
		}
		
		logger.debug("MemberRankController --> view(={}) - end");
		return ResponseDto.successResp(map);
	}
	
	/**
	 * 方法说明： 我的特权-申请-付款
	 * @param 会员特权编码	memberRankCode	必填
	 * @author 林进权
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"apply"})
	@ResponseBody
	public ResponseDto apply(MemberRankApplyDto memberRankApplyDto, String payAmt, String payType) {
		
		logger.debug("MemberRankControl --> apply() - start", memberRankApplyDto); 
		if(memberRankApplyDto==null || StringUtils.isEmpty(memberRankApplyDto.getMemberRankCode())
				){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
		MemberRankDto memberRankDto = new MemberRankDto();
		memberRankDto.setCode(memberRankApplyDto.getMemberRankCode());
		memberRankDto = memberRankService.findMemberRank(memberRankDto);
		if(memberRankDto==null){
			return ResponseDto.createResp(false, ResponseCode.MEMBER_RANK_APPLY_NOT_FOUND.getCode(), ResponseCode.MEMBER_RANK_APPLY_NOT_FOUND.getMsg(), null);
		}
		
		ShopDto logShop = getLoginShop();
		
		//如果有特权尚未处理，禁止再次申请
		FindMemberRankApplyPage findMemberRankApplyPage = new FindMemberRankApplyPage();
		MemberRankApplyDto param = new MemberRankApplyDto();
		param.setShopCode(logShop.getCode());
		param.setDelFlag("0");
		param.setStatus(MemberRankApplyStatus.WAIT.getValue());
		findMemberRankApplyPage.setParam(param);
		List<MemberRankApplyDto> list = memberRankApplyService.findMemberRankApplys(findMemberRankApplyPage);
		if(null!=list && list.size()>0) {
			return ResponseDto.createResp(false, ResponseCode.MEMBER_RANK_APPLY_FAIL.getCode(), ResponseCode.MEMBER_RANK_APPLY_FAIL.getMsg(), null);
		}
		
		
		ShopDto paramShopDto = new ShopDto();
		param.setCode(getLoginShopCode());
		ShopDto rltShop = this.shopService.findShop(paramShopDto);
//		ShopDto rltShop = getLoginShop();
		if(null!=rltShop && StringUtils.isNotEmpty(rltShop.getRankCode())) {
			//如果已经过期，清除特权信息
			if(null!=rltShop.getRankExpireTime() && (rltShop.getRankExpireTime().getTime()<new Date().getTime())) {
				ShopDto updShopDto = new ShopDto();
				updShopDto.setCode(rltShop.getCode());
				updShopDto.setRankCode(null);
				updShopDto.setRankExpireTime(null);
				this.shopService.updateShop(updShopDto);
			} else {
				//没过期，如果购买特权小于或等于现特权金额，不允许购买
				MemberRankDto shopRankDto = new MemberRankDto();
				shopRankDto.setCode(rltShop.getRankCode());
				MemberRankDto rltShopRankDto = memberRankService.findMemberRank(memberRankDto);
				if(memberRankDto.getAmount().compareTo(rltShopRankDto.getAmount())<=0) {
					return ResponseDto.createResp(false, ResponseCode.MEMBER_RANK_APPLY_FAIL_DISABLED_BUY_DOWN.getCode(), ResponseCode.MEMBER_RANK_APPLY_FAIL_DISABLED_BUY_DOWN.getMsg(), null);
				}
			}
		}
		
		//申请纪录
		memberRankApplyDto.setMemberRankName(memberRankDto.getName());
		memberRankApplyDto.setShopCode(logShop.getCode());
		memberRankApplyDto.setShopName(logShop.getShopName());
		memberRankApplyDto.setApplyTime(new Date());
		memberRankApplyDto.setStatus(MemberRankApplyStatus.WAIT.getValue());
		memberRankApplyDto.setDelFlag("0");
		MemberRankApplyDto rDto = memberRankApplyService.addMemberRankApply(memberRankApplyDto);
		
		logger.debug("MemberRankController --> apply(={}) - end");
		Map<String, String> map = new HashMap<String, String>();
		map.put("applyCode", rDto.getCode());
		map.put("shopCode", getLoginMerchantCode());
		map.put("merchantCode", getLoginMerchantCode());
		return ResponseDto.successResp(map);
	}
	
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("a1");
		strings.add("a2");
		strings.add("a3");
		strings.add("a4");
		System.out.println(strings);
		Iterator<String> iterator = strings.iterator();
		while(iterator.hasNext()) {
//			if("a1".equals(iterator.next())) {
				iterator.remove();
//			}
		}
		System.out.println(strings);
	}
	
}
