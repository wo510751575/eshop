package com.lj.business.member.common;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */

import java.math.BigDecimal;

import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.domain.PersonMemberBase;
import com.lj.business.member.dto.PersonMemberRateDto;
import com.lj.business.member.emus.MemberStatus;
import com.lj.business.member.emus.NameAuthFlag;

/**
 * 类说明：会员工具类
 * 
 * 
 * <p/>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * CreateDate: 2017-06-12
 */
public class MemberUtils {
	
	/**
	 * 方法说明：校验会员状态必须为指定状态.
	 *
	 * @param memberNo 			会员编号
	 * @param memberStatus 		会员当前状态
	 * @param allowStatuss 		允许的会员状态
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 * 
	 * CreateDate: 2017-06-12
	 */
	public static void validateMemberStatus(Long memberNo, MemberStatus memberStatus, MemberStatus ... allowStatuss) throws TsfaServiceException {
		if(allowStatuss == null || allowStatuss.length == 0) {
			return;
		}
		for(MemberStatus status : allowStatuss) {
			// 会员状态为指定状态，则返回；否则继续循环
			if(status == memberStatus) {
				return;
			}
		}
		// 会员状态都不是指定的状态，则提示对应的异常信息
		switch (memberStatus) {
		case NORMAL:
			throw new TsfaServiceException(ErrorCode.MBR_MEMBER_STATUS_IS_NORMAL, "会员[" + memberNo + "]状态正常");
		case FREEZE:
			throw new TsfaServiceException(ErrorCode.MBR_MEMBER_STATUS_IS_FREEZE, "会员[" + memberNo + "]已冻结");
		case CANCEL:
			throw new TsfaServiceException(ErrorCode.MBR_MEMBER_STATUS_IS_CANCEL, "会员[" + memberNo + "]已注销");
		}
	}
	
	/**
	 * 方法说明：校验商户的会员状态必须为指定状态.
	 *
	 * @param merchantNo 		商户编号
	 * @param memberStatus 		会员当前状态
	 * @param allowStatuss 		允许的会员状态
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 * 
	 * CreateDate: 2017-06-12
	 */
	public static void validateMerchantMemberStatus(Long merchantNo, MemberStatus memberStatus, MemberStatus ... allowStatuss) throws TsfaServiceException {
		if(allowStatuss == null || allowStatuss.length == 0) {
			return;
		}
		for(MemberStatus status : allowStatuss) {
			// 会员状态为指定状态，则返回；否则继续循环
			if(status == memberStatus) {
				return;
			}
		}
		// 会员状态都不是指定的状态，则提示对应的异常信息
		switch (memberStatus) {
		case NORMAL:
			throw new TsfaServiceException(ErrorCode.MBR_MERCHANT_MEMBER_STATUS_IS_NORMAL, "商户会员[" + merchantNo + "]状态正常");
		case FREEZE:
			throw new TsfaServiceException(ErrorCode.MBR_MERCHANT_MEMBER_STATUS_IS_FREEZE, "商户会员[" + merchantNo + "]已冻结");
		case CANCEL:
			throw new TsfaServiceException(ErrorCode.MBR_MERCHANT_MEMBER_STATUS_IS_CANCEL, "商户会员[" + merchantNo + "]已注销");
		}
	}
	
	/**
	 * 方法说明：校验商户的会员状态必须为指定状态.
	 *
	 * @param memberNo 			会员编号
	 * @param memberStatus 		会员当前状态
	 * @param allowStatuss 		允许的会员状态
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 * 
	 * CreateDate: 2017-06-12
	 */
	public static void validateMerchantStatusByMemberNo(Long memberNo, MemberStatus memberStatus, MemberStatus ... allowStatuss) throws TsfaServiceException {
		if(allowStatuss == null || allowStatuss.length == 0) {
			return;
		}
		for(MemberStatus status : allowStatuss) {
			// 会员状态为指定状态，则返回；否则继续循环
			if(status == memberStatus) {
				return;
			}
		}
		// 会员状态都不是指定的状态，则提示对应的异常信息
		switch (memberStatus) {
		case NORMAL:
			throw new TsfaServiceException(ErrorCode.MBR_MERCHANT_MEMBER_STATUS_IS_NORMAL, "商户会员[" + memberNo + "]状态正常");
		case FREEZE:
			throw new TsfaServiceException(ErrorCode.MBR_MERCHANT_MEMBER_STATUS_IS_FREEZE, "商户会员[" + memberNo + "]已冻结");
		case CANCEL:
			throw new TsfaServiceException(ErrorCode.MBR_MERCHANT_MEMBER_STATUS_IS_CANCEL, "商户会员[" + memberNo + "]已注销");
		}
	}
	
	/**
	 * 方法说明：校验会员为实名或未实名.
	 *
	 * @param memberNo 			会员编号
	 * @param nameAuthFlag 		会员当前实名状态
	 * @param validateFlag 		实名true、未实名false
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 * 
	 * CreateDate: 2017-06-12
	 */
	public static void isNameAuthentication(Long memberNo, String nameAuthFlag, NameAuthFlag validateFlag) throws TsfaServiceException {
		if(!validateFlag.name().equals(nameAuthFlag)) {
			if(NameAuthFlag.Y == validateFlag) {	// 验证实名
				throw new TsfaServiceException(ErrorCode.MBR_MEMBER_NOT_BEEN_NAME_AUTHENTICATION, "会员[" + memberNo + "]未实名认证");
			} else {	// 验证未实名
				throw new TsfaServiceException(ErrorCode.MBR_MEMBER_HAVE_BEEN_NAME_AUTHENTICATION, "会员[" + memberNo + "]已实名认证");
			}
		} 
	}
	
	/**
	 * 
	 *
	 * 方法说明：TODO 业务成熟以后优化
	 *
	 * @param personMemberBase
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月27日
	 *
	 */
	public static Double completeRate(PersonMemberBase personMemberBase){
		Double rate = new Double(0.0);
		BigDecimal rateChild = new BigDecimal(0.0);
		BigDecimal rateMother = new BigDecimal(0.0);
		if(!StringUtils.isEmpty(personMemberBase.getMobile())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberBase.getNoWx())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberBase.getNickNameWx())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberBase.getMemberName())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberBase.getAddress())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		//保留两位小数
		rate = rateChild.divide(rateMother, 4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		return rate;
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：完成率
	 *
	 * @param personMemberBase
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月27日
	 *
	 */
	public static Double completeRateNew(PersonMemberRateDto personMemberRateDto){
		Double rate = new Double(0.0);
		BigDecimal rateChild = new BigDecimal(0.0);
		BigDecimal rateMother = new BigDecimal(0.0);
		if(!StringUtils.isEmpty(personMemberRateDto.getMobile())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getNoWx())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getNickNameWx())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getMemberName())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getBomName())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getHeadAddress())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getBrandCompare())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getClientSpecial())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getHouses())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getJob())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getMemberSrc())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getSex())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(!StringUtils.isEmpty(personMemberRateDto.getSpruceUp())){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		if(personMemberRateDto.getBirthday() != null){
			rateChild = rateChild.add(new BigDecimal("1"));
		}
		rateMother = rateMother.add(new BigDecimal("1"));
		
		//保留两位小数
		rate = rateChild.divide(rateMother, 4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		return rate;
	}
	

}
