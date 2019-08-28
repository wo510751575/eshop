/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eoms.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ape.common.config.Global;
import com.lj.base.core.encryption.MD5;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.httpclient.HttpClientUtils;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dto.AddGuidMember;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindShop;
import com.lj.business.member.dto.FindShopPageReturn;
import com.lj.business.member.dto.UpdateGuidMember;
import com.lj.business.member.emus.Gender;
import com.lj.business.member.emus.MemberStatus;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.eoms.dto.ResponseCode;
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.dto.FindMemberPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.MerchantDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.emus.MemberSex;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IShopService;

/**
 * 
 * 类说明：导购同步。
 *  
 * 
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月20日
 */
@Service
public class MbrGuidMemberService {
	@Autowired
	private IShopService shopService;
	@Autowired
	private IGuidMemberService guidMemberService;//导购信息
	@Autowired
	private IMemberService memberService;
	@Autowired
	private com.lj.business.member.service.IShopService mbrShopService;//会员体系店铺信息
	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	
	/**
	 * 方法说明：新增导购。
	 * @param shopDto.code 必填
	 * @param from 来源备注
	 * @author lhy  2017年9月20日
	 *
	 */
	public void addGuidMember(ShopDto shopDto,String from ){
		/*try {
			//把会员信息同步更新到热文会员
			String url = localCacheSystemParams.getSystemParam("cc","rw", "rwRegistUrl");
			Map map = new HashMap<>();
			map.put("code", shopDto.getMbrCode());
			map.put("name", shopDto.getShopName());
			String result = HttpClientUtils.postToWeb(url, map);
			
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		ShopDto ecfindShop=shopService.findShop(shopDto);
		//1.根据店找到电商会员
		MemberDto mbrParam=new MemberDto(); 
		mbrParam.setCode(ecfindShop.getMbrCode());
		MemberDto ecfindMbr=memberService.findMember(mbrParam);
		//2.根据电商商户找到会员体系shop
		FindShop findShop=new FindShop();
		findShop.setMemberNoMerchant(UserUtils.getUser().getMerchant().getOfficeId());
		FindShopPageReturn mbrShop= mbrShopService.findShopByMerchantNo_ec(findShop);
		MerchantDto ecMerchant= UserUtils.getUser().getMerchant();
		AddGuidMember addGuidMember = new AddGuidMember();
		addGuidMember.setMemberNo(ecfindMbr.getCode());
		addGuidMember.setMemberName(ecfindMbr.getName());
		addGuidMember.setShopNo(mbrShop.getShopNo());
		addGuidMember.setShopName(mbrShop.getShopName());
		addGuidMember.setMerchantNo(ecMerchant.getOfficeId());
		addGuidMember.setMerchantName(ecMerchant.getMerchantName());
		addGuidMember.setStatus(MemberStatus.NORMAL.toString());
		//addGuidMember.setJobNum();
		addGuidMember.setMobile(ecfindMbr.getPhone());
		addGuidMember.setImei(ecfindShop.getMimeCode());
//		addGuidMember.setEmail(findMbr);
		addGuidMember.setNickName(ecfindMbr.getName());
//		addGuidMember.setAreaCode();
//		addGuidMember.setAreaName();
		addGuidMember.setNoWx(ecfindMbr.getWxNo());
//		addGuidMember.setProvinceCode();
//		addGuidMember.setCityCode();
//		addGuidMember.setCityAreaCode();
//		addGuidMember.setAddress();
//		addGuidMember.setAge();
		if(StringUtils.isNotEmpty(ecfindMbr.getSex())){
			addGuidMember.setGender(ecfindMbr.getSex().equals(MemberSex.MALE.getValue())?Gender.MALE.toString():Gender.FEMALE.toString());
		}
		addGuidMember.setHeadAddress(ecfindMbr.getAvotor());
//		addGuidMember.setWorkDate();
//		addGuidMember.setQcord();
		addGuidMember.setCreateId(UserUtils.getUser().getId());
		addGuidMember.setRemark(from);
		String pwd="123456";
		if (StringUtils.isNotEmpty(ecfindMbr.getPhone())
				&& ecfindMbr.getPhone().length() > 5) {
			pwd = ecfindMbr.getPhone().substring(ecfindMbr.getPhone().length()-6);
		}
		addGuidMember.setPwd(MD5.encryptByMD5(MD5.encryptByMD5(pwd)));//2次Md5加密存贮
		guidMemberService.addGuidMember_ec(addGuidMember);
	}
	/***
	 * 方法说明：检测微信号是否唯一
	 *
	 * @param wxNo
	 * @return
	 *
	 * @author lhy  2017年9月21日
	 *
	 */
	private boolean checkWxNo(MemberDto memberDto) {
		if(StringUtils.isEmpty(memberDto.getWxNo())){
			return true;
		}
		FindMemberPage findMemberPage = new FindMemberPage();
		MemberDto param = new MemberDto();
		param.setWxNoAll(memberDto.getWxNo());
		findMemberPage.setParam(param);
		List<MemberDto> list = memberService.findMembers(findMemberPage);
		if(null==list || list.size()==0) {
			return true;
		}else{
			MemberDto mbr=list.get(0);
			if(!mbr.getCode().equals(memberDto.getCode())){//已有微信号
				throw new TsfaServiceException(ResponseCode.WXNO_EXIST.getCode(), ResponseCode.WXNO_EXIST.getMsg());
			}
		}
		return false; 
	}
	
	/**
	 *
	 * 方法说明：检测手机号是否唯一
	 *
	 * @param memberDto
	 * @return
	 *
	 * @author lhy  2017年9月21日
	 *
	 */
	private boolean checkMobile(MemberDto memberDto) {
		if(StringUtils.isEmpty(memberDto.getPhone())){
			return true;
		}
		FindMemberPage findMemberPage = new FindMemberPage();
		MemberDto param = new MemberDto();
		param.setPhone(memberDto.getPhone());
		findMemberPage.setParam(param);
		List<MemberDto> list = memberService.findMembers(findMemberPage);
		if(null==list || list.size()==0) {
			return true;
		}else{
			MemberDto mbr=list.get(0);
			if(!mbr.getCode().equals(memberDto.getCode())){//已有手机号
				throw new TsfaServiceException(ResponseCode.PHONE_EXIST.getCode(), ResponseCode.PHONE_EXIST.getMsg());
			}
		}
		return true; 
	}
	
	/**
	 * 方法说明：修改会员&同步修改导购。
	 * @param memberDto
	 * @author lhy  2017年9月21日
	 *
	 */
	public void updateMember(MemberDto memberDto){
		checkMobile(memberDto);//检测手机号唯一性
		checkWxNo(memberDto);//检测微信号唯一性
		memberService.updateMember(memberDto);//1.修改电商数据
		
		//1.根据电商会员找到导购进行修改
		FindGuidMember findGuidMember=new FindGuidMember();
		findGuidMember.setMemberNo(memberDto.getCode());
		FindGuidMemberReturn guidMbr = null;
		try{
			guidMbr=guidMemberService.findGuidMember(findGuidMember);
		}catch(TsfaServiceException e){
			//未找到导购不抛出异常，只是不同步
			if(!ErrorCode.GUID_MEMBER_NOT_EXIST_ERROR.equals(ErrorCode.GUID_MEMBER_NOT_EXIST_ERROR)){
				throw e;
			} 
		}
		if (guidMbr != null) {
			UpdateGuidMember updateGuidMbr=new UpdateGuidMember();
			updateGuidMbr.setMemberName(memberDto.getName());
			updateGuidMbr.setCode(guidMbr.getCode());
			updateGuidMbr.setMobile(memberDto.getPhone());
			updateGuidMbr.setNickName(memberDto.getName());
			updateGuidMbr.setNoWx(memberDto.getWxNo());
			if(StringUtils.isNotEmpty(memberDto.getSex())){
				updateGuidMbr.setGender(memberDto.getSex().equals(MemberSex.MALE.getValue())?Gender.MALE.toString():Gender.FEMALE.toString());
			}
			if(StringUtils.isNotEmpty(memberDto.getStatus())){
				if(com.lj.eshop.emus.MemberStatus.NORMAL.getValue().equals(memberDto.getStatus())){
					updateGuidMbr.setStatus(MemberStatus.NORMAL.toString());
				}else if(com.lj.eshop.emus.MemberStatus.CANCEL.getValue().equals(memberDto.getStatus())){
					updateGuidMbr.setStatus(MemberStatus.CANCEL.toString());
				}else if(com.lj.eshop.emus.MemberStatus.FREEZE.getValue().equals(memberDto.getStatus())){
					updateGuidMbr.setStatus(MemberStatus.FREEZE.toString());
				}
			}
			updateGuidMbr.setHeadAddress(memberDto.getAvotor());
			
			updateGuidMbr.setUpdateDate(new Date());
			updateGuidMbr.setUpdateId(UserUtils.getUser().getId());
			guidMemberService.updateGuidMember(updateGuidMbr);
		}
	}

}
