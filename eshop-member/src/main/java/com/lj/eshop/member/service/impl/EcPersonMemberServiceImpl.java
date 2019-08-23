/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.member.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DistanceUtil;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.common.SystemParamConstant;
import com.lj.business.member.common.MemberUtils;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IGuidMemberDao;
import com.lj.business.member.dao.IPersonMemberBaseDao;
import com.lj.business.member.dao.IPersonMemberDao;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.domain.PersonMember;
import com.lj.business.member.domain.PersonMemberBase;
import com.lj.business.member.dto.AddPersonMember;
import com.lj.business.member.dto.AddPersonMemberReturn;
import com.lj.business.member.dto.AddPmTypePmDto;
import com.lj.business.member.dto.DoRepeatMemberDto;
import com.lj.business.member.dto.FindPersonMember;
import com.lj.business.member.dto.FindPersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBaseReturn;
import com.lj.business.member.dto.FindPersonMemberReturn;
import com.lj.business.member.dto.FindPmType;
import com.lj.business.member.dto.FindPmTypeReturn;
import com.lj.business.member.dto.FindShop;
import com.lj.business.member.dto.FindShopReturn;
import com.lj.business.member.dto.PersonMemberRateDto;
import com.lj.business.member.dto.UpdatePersonMember;
import com.lj.business.member.dto.UpdatePersonMemberBase;
import com.lj.business.member.dto.UpdatePersonMemberBaseRatioClientInfoDto;
import com.lj.business.member.dto.UpdatePersonMemberReturn;
import com.lj.business.member.dto.behaviorPm.AddBehaviorPm;
import com.lj.business.member.emus.FirstIntroduce;
import com.lj.business.member.emus.MemberStatus;
import com.lj.business.member.emus.MemerSourceType;
import com.lj.business.member.emus.NameAuthFlag;
import com.lj.business.member.emus.PmTypeType;
import com.lj.business.member.emus.UrgentFlagType;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.cc.enums.SystemAliasName;
import com.lj.eshop.member.service.IEcBehaviorPmService;
import com.lj.eshop.member.service.IEcPersonMemberBaseService;
import com.lj.eshop.member.service.IEcPersonMemberService;
import com.lj.eshop.member.service.IEcPmTypeService;
import com.lj.eshop.member.service.IEcShopService;

/**
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月18日
 */
@Service
public class EcPersonMemberServiceImpl implements IEcPersonMemberService {
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(EcPersonMemberServiceImpl.class);
	/** The person member dao. */
	@Resource
	private IPersonMemberDao personMemberDao;
	
	/** The iguidMember dao. */
	@Resource
	private IGuidMemberDao iguidMemberDao;
	
	/** The pm type service. */
	@Resource
	private IEcPmTypeService pmTypeService;
	@Resource
	private IEcShopService shopService;
	/** The iperson member base dao. */
	@Resource
	private IPersonMemberBaseDao personMemberBaseDao;
	/** The person member base service. */
	@Resource
	private IEcPersonMemberBaseService personMemberBaseService;

//	@Resource
//	private IEcPersonMemberService personMemberService;
	
	/** The behavior pm service. */
	@Resource
	private IEcBehaviorPmService behaviorPmService;
	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;

	/* (non-Javadoc)
	 * @see com.lj.eshop.member.service.IEcPersonMemberService#addPersonMember(com.lj.business.member.dto.AddPersonMember)
	 */
	@Override
	public AddPersonMemberReturn addPersonMember(AddPersonMember addPersonMember)
			throws TsfaServiceException {
		logger.debug("addPersonMember(AddPersonMember addPersonMember={}) - start", addPersonMember);

		AssertUtils.notNull(addPersonMember);
		try {
			PersonMember personMember = new PersonMember();
			// add数据录入
			personMember.setCode(GUID.getPreUUID());
			if (addPersonMember.getMemberNo() != null && !"".equals(addPersonMember.getMemberNo())) {
				personMember.setMemberNo(addPersonMember.getMemberNo());
			} else {
				personMember.setMemberNo(GUID.generateByUUID());
			}
			personMember.setMemberName(addPersonMember.getMemberName());
			personMember.setMemberNoGm(addPersonMember.getMemberNoGm());
			personMember.setMemberNameGm(addPersonMember.getMemberNameGm());
			personMember.setShopNo(addPersonMember.getShopNo());
			personMember.setShopName(addPersonMember.getShopName());
			personMember.setMerchantNo(addPersonMember.getMerchantNo());
			personMember.setMerchantName(addPersonMember.getMerchantName());
			personMember.setSpruceUp(addPersonMember.getSpruceUp());
			personMember.setHouses(addPersonMember.getHouses());
			personMember.setKeepEye(addPersonMember.getKeepEye());
			personMember.setUrgencyPm(addPersonMember.getUrgencyPm());
			personMember.setBomCode(addPersonMember.getBomCode());
			personMember.setBomName(addPersonMember.getBomName());
			personMember.setCreateId(addPersonMember.getCreateId());
			personMember.setRemark4(addPersonMember.getRemark4());
			personMember.setRemark3(addPersonMember.getRemark3());
			personMember.setRemark2(addPersonMember.getRemark2());
			personMember.setRemark(addPersonMember.getRemark());
			/* 扫码相关 */
			personMember.setLatitude(addPersonMember.getLatitude());
			personMember.setLongitude(addPersonMember.getLongitude());
			personMember.setScanAddress(addPersonMember.getScanAddress());
			personMemberDao.insertSelective(personMember);
			AddPersonMemberReturn addPersonMemberReturn = new AddPersonMemberReturn();

			logger.debug("addPersonMember(AddPersonMember) - end - return value={}", addPersonMemberReturn);
			return addPersonMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增客户会员信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_ADD_ERROR, "新增客户会员信息错误！", e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.eshop.member.service.IEcPersonMemberService#addPersonMemberFromHook(java.lang.String)
	 */
	@Override
	public void addPersonMemberFromHook(String infos)
			throws TsfaServiceException {
		logger.debug("addPersonMemberFromHook(String infos={}) - start", infos); //$NON-NLS-1$

		try {
			// 先插入客户基础表
			JSONObject jsonObject = JSONObject.fromObject(infos);
			String noWxGM = jsonObject.getString("noWxGM");
			logger.debug("addPersonMemberFromHook(String noWxGM={})", noWxGM);
			JSONArray ja = jsonObject.getJSONArray("data");
			// 根据导购微信查询导购和门店信息
			GuidMember gm = new GuidMember();
			gm.setNoWx(noWxGM);
			GuidMember guidMember = iguidMemberDao.selectByParams(gm);

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			PersonMemberBase personMemberBase = null;
			// 未分组
			FindPmType findPmType = new FindPmType();
			findPmType.setMerchantNo(guidMember.getMerchantNo());
			findPmType.setPmTypeType(PmTypeType.UNGROUP.toString());
			FindPmTypeReturn ptp = pmTypeService.findPmTypeByMP(findPmType);
			// 意向(到店)
			FindPmType findPmType2 = new FindPmType();
			findPmType2.setMerchantNo(guidMember.getMerchantNo());
			findPmType2.setPmTypeType(PmTypeType.INTENTION.toString());
			FindPmTypeReturn ptp2 = pmTypeService.findPmTypeByMP(findPmType2);

			// 获取店铺经度纬度
			FindShop findShop = new FindShop();
			findShop.setShopNo(guidMember.getShopNo());
			FindShopReturn findShopReturn = shopService.findShopByShopNo(findShop);
			// 获取距离范围
			String distance = localCacheSystemParams.getSystemParam(SystemAliasName.cf.toString(), SystemParamConstant.DISTANCE, SystemParamConstant.DISTANCE_RANGE);

			logger.info("$$$$$$$$$$$$$$$$$$$$:distance=" + distance);

			for (int i = 0; i < ja.size(); i++) {
				Date now = new Date();
				FindPersonMemberBase fmb = new FindPersonMemberBase();
				PersonMember addPersonMember = new PersonMember();

				JSONObject jObj = ja.getJSONObject(i);
				String noWx = jObj.containsKey("noWx") ? jObj.getString("noWx") : "";
				logger.debug("addPersonMemberFromHook(String noWx={})", noWx);
				String nickNameWx = jObj.containsKey("nickNameWx") ? jObj.getString("nickNameWx") : "";

				/* emoji标签转码 */
				// String base64Str =
				// Base64.encodeBase64String(nickNameWx.getBytes());
				// nickNameWx = base64Str;

				/* 扩展表参数 */
				String nickNameRemarkWx = jObj.containsKey("nickNameRemarkWx") ? jObj.getString("nickNameRemarkWx") : "";
				String longitude = jObj.containsKey("longitude") ? jObj.getString("longitude") : "";
				String latitude = jObj.containsKey("latitude") ? jObj.getString("latitude") : "";
				String scanAddress = jObj.containsKey("scanAddress") ? jObj.getString("scanAddress") : "";
				addPersonMember.setNickNameRemarkWx(nickNameRemarkWx);
				addPersonMember.setLatitude(latitude);
				addPersonMember.setLongitude(longitude);
				addPersonMember.setScanAddress(scanAddress);
				/* 扩展表参数 */

				// 是否到店
				boolean toShopFlag = false;

				// 判断是否到店
				if (findShopReturn != null) {
					toShopFlag = isToShop(findShopReturn.getLongitude(), findShopReturn.getLatitude(), longitude, latitude, distance);
				}

				fmb.setNoWx(noWx);
				personMemberBase = personMemberBaseDao.selectByParams(fmb);

				/* 客户基础数据存在 */
				if (personMemberBase != null) {
					logger.debug("基础数据存在");

					/* 修改客户微信昵称 */
					logger.debug("修改客户微信昵称--code={}--nickNameWx={}--start", personMemberBase.getCode(), nickNameWx);
					UpdatePersonMemberBase updatePersonMemberBase = new UpdatePersonMemberBase();
					updatePersonMemberBase.setCode(personMemberBase.getCode());
					updatePersonMemberBase.setNickNameWx(nickNameWx);
					personMemberBaseService.updatePersonMemberBase(updatePersonMemberBase);
					/* 修改客户微信昵称 */

					// 客户扩展表数据是否存在
					PersonMember personMember = new PersonMember();
					personMember.setMemberNo(personMemberBase.getMemberNo());
					personMember.setMemberNoGm(guidMember.getMemberNo());
					PersonMember personMemberTemp = personMemberDao.selectByParamKey(personMember);
					// update by 杨杰 2017-09-05 begin
					String nickNameRemarkLocal = "";
					if (StringUtils.isNotEmpty(personMemberBase.getMemberName())) {
						nickNameRemarkLocal += personMemberBase.getMemberName();
					}
					if (StringUtils.isNotEmpty(personMemberBase.getMobile())) {
						nickNameRemarkLocal += ("-" + personMemberBase.getMobile());
					}
					// update by 杨杰 2017-09-05 end
					if (personMemberTemp != null) {// 数据已存在
						logger.debug("客户扩展表数据已存在");

						logger.debug("修改客户微信昵称备注--code={}--nickNameRemarkWx={}--start", personMemberTemp.getCode(), nickNameRemarkWx);
						UpdatePersonMember updatePersonMember = new UpdatePersonMember();
						updatePersonMember.setCode(personMemberTemp.getCode());
						updatePersonMember.setNickNameRemarkWx(nickNameRemarkWx);
						// update by 杨杰 2017-09-05 begin
						if (StringUtils.isNotEmpty(personMemberTemp.getBomName())) {
							nickNameRemarkLocal += ("-" + personMemberTemp.getBomName());
						}
						updatePersonMember.setNickNameRemarkLocal(nickNameRemarkLocal);
						// update by 杨杰 2017-09-05 end
						updatePersonMember(updatePersonMember);
						continue;
					} else {
						logger.debug("插入客户扩展表数据");
						insertPm(guidMember, personMemberBase, addPersonMember);
						innerProcess(toShopFlag, guidMember, personMemberBase, addPersonMember, ptp, ptp2);
					}
				} else {
					logger.debug("基础数据不存在");
					personMemberBase = new PersonMemberBase();
					personMemberBase.setCode(GUID.generateCode());
					personMemberBase.setMemberNo(GUID.generateByUUID());
					//personMemberBase.setMemberName(nickNameWx);// 名称暂时用微信昵称
					
					String mn = "";
					if(!StringUtils.isEmpty(nickNameRemarkWx)){
						mn = nickNameRemarkWx;
					}else if(!StringUtils.isEmpty(nickNameWx)){
						mn = nickNameWx;
					}
					personMemberBase.setMemberName(mn);
					
					personMemberBase.setSex(ja.getJSONObject(i).getString("sex"));
					personMemberBase.setCityWx(ja.getJSONObject(i).getString("cityWx"));
					personMemberBase.setCountryWx(ja.getJSONObject(i).getString("countryWx"));
					personMemberBase.setHeadAddress(ja.getJSONObject(i).getString("headAddress"));
					personMemberBase.setNickNameWx(nickNameWx);

					if (toShopFlag) {
						personMemberBase.setMemberSrc(MemerSourceType.SHOP_SACN.toString());
					} else {
						personMemberBase.setMemberSrc(MemerSourceType.NO_SHOP_SACN.toString());
					}

					personMemberBase.setNoWx(ja.getJSONObject(i).getString("noWx"));
					try {
						personMemberBase.setSubsribeTime(df.parse(ja.getJSONObject(i).getString("subsribeTime")));
					} catch (ParseException e) {
						logger.error("addPersonMemberFromHook(String)", e); //$NON-NLS-1$
						throw new TsfaServiceException(ErrorCode.DATA_TRANS_ERROR, "时间转换错误!", e);
					}

					personMemberBase.setCreateDate(now);
					personMemberBase.setCreateId(guidMember.getMemberNo());
					personMemberBase.setUpdateDate(now);
					personMemberBase.setUpdateId(guidMember.getMemberNo());
					personMemberBase.setNameAuthFlag(NameAuthFlag.N.toString());
					personMemberBase.setStatus(MemberStatus.NORMAL.toString());
					personMemberBase.setRatioClientInfo(MemberUtils.completeRate(personMemberBase));

					personMemberBase.setAreaCode(findShopReturn.getAreaCode());
					personMemberBase.setAreaName(findShopReturn.getAreaName());
					personMemberBase.setProvinceCode(findShopReturn.getProvinceCode());
					personMemberBase.setCityCode(findShopReturn.getCityCode());
					personMemberBase.setCityAreaCode(findShopReturn.getCityAreaCode());
					personMemberBaseDao.insertSelective(personMemberBase);

					logger.debug("插入客户扩展表数据");
					insertPm(guidMember, personMemberBase, addPersonMember);

					innerProcess(toShopFlag, guidMember, personMemberBase, addPersonMember, ptp, ptp2);

					// 添加客户动态
					AddBehaviorPm addBehaviorPm = new AddBehaviorPm();
					addBehaviorPm.setMemberNo(personMemberBase.getMemberNo());
					addBehaviorPm.setMemberName(personMemberBase.getMemberName());
					addBehaviorPm.setBehaviorDesc("暂无动态");
					addBehaviorPm.setBehaviorDate(now);
					behaviorPmService.addBehaviorPm(addBehaviorPm);
				}

				// 修改资料完成度
				FindPersonMemberBase findNowx = new FindPersonMemberBase();
				findNowx.setNoWx(personMemberBase.getNoWx());
				FindPersonMemberBaseReturn findPersonMemberBaseReturn = personMemberBaseService.findPersonMemberBase(findNowx);

				FindPersonMember findPm = new FindPersonMember();
				findPm.setMemberNo(personMemberBase.getMemberNo());
				findPm.setMemberNoGm(guidMember.getMemberNo());
				FindPersonMemberReturn findPmReturn = findPersonMemberByMGM(findPm);

				computeRate(findPersonMemberBaseReturn, findPmReturn);
			}
			logger.debug("addPersonMemberFromHook(String) - end"); //$NON-NLS-1$
		} catch (Exception e) {
			logger.error("同步客户信息出错！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "同步客户信息出错！", e);
		}

	}
	@Override
	public void computeRate(FindPersonMemberBaseReturn findPersonMemberBaseReturn, FindPersonMemberReturn findPersonMemberReturn) throws TsfaServiceException {
		logger.debug(
				"computeRate(FindPersonMemberBaseReturn findPersonMemberBaseReturn={}, FindPersonMemberReturn findPersonMemberReturn={}) - start", findPersonMemberBaseReturn, findPersonMemberReturn); //$NON-NLS-1$

		// 拼装设置条件
		PersonMemberRateDto personMemberRateDto = new PersonMemberRateDto();
		personMemberRateDto.setBirthday(findPersonMemberBaseReturn.getBirthday());
		personMemberRateDto.setBomName(findPersonMemberReturn.getBomName());
		personMemberRateDto.setBrandCompare(findPersonMemberReturn.getBrandCompare());
		personMemberRateDto.setClientSpecial(findPersonMemberReturn.getClientSpecial());
		personMemberRateDto.setHeadAddress(findPersonMemberBaseReturn.getHeadAddress());
		personMemberRateDto.setHouses(findPersonMemberReturn.getHouses());
		personMemberRateDto.setJob(findPersonMemberBaseReturn.getJob());
		personMemberRateDto.setMemberName(findPersonMemberBaseReturn.getMemberName());
		personMemberRateDto.setMemberSrc(findPersonMemberBaseReturn.getMemberSrc());
		personMemberRateDto.setMobile(findPersonMemberBaseReturn.getMobile());
		personMemberRateDto.setNickNameWx(findPersonMemberBaseReturn.getNickNameWx());
		personMemberRateDto.setNoWx(findPersonMemberBaseReturn.getNoWx());
		personMemberRateDto.setSex(findPersonMemberBaseReturn.getSex());
		personMemberRateDto.setSpruceUp(findPersonMemberReturn.getSpruceUp());

		logger.debug("computeRate(==== personMemberRateDto={}", personMemberRateDto); //$NON-NLS-1$

		// 计算完成度
		Double rate = MemberUtils.completeRateNew(personMemberRateDto);
		// 修改完成度
		UpdatePersonMemberBaseRatioClientInfoDto dto = new UpdatePersonMemberBaseRatioClientInfoDto();
		dto.setRatioClientInfo(rate);
		dto.setMemberNo(findPersonMemberBaseReturn.getMemberNo());
		personMemberBaseService.updatePersonMemberBaseRatioClientInfo(dto);

		logger.debug("computeRate() - end"); //$NON-NLS-1$
	}
	
	public boolean isToShop(String shopLongitude, String shopLatitude, String pmLongitude, String pmLatitude, String distance) {
		boolean toShopFlag = false;
		if (!StringUtils.isEmpty(shopLongitude) && !StringUtils.isEmpty(shopLatitude) && !StringUtils.isEmpty(pmLongitude) && !StringUtils.isEmpty(pmLatitude) && !StringUtils.isEmpty(distance)) {
			double dis = DistanceUtil.getDistance(Double.valueOf(shopLongitude), Double.valueOf(shopLatitude), Double.valueOf(pmLongitude), Double.valueOf(pmLatitude));
			if (dis <= Double.valueOf(distance)) {
				toShopFlag = true;
			}

			logger.info("&&&&&&&&&&&&&&&&&&&&&:dis=" + dis + ",toShopFlag=" + toShopFlag);
		}
		return toShopFlag;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#updatePersonMember
	 * (com.lj.business.member.dto.UpdatePersonMember)
	 */
	@Override
	public UpdatePersonMemberReturn updatePersonMember(UpdatePersonMember updatePersonMember) throws TsfaServiceException {
		logger.debug("updatePersonMember(UpdatePersonMember updatePersonMember={}) - start", updatePersonMember); //$NON-NLS-1$

		AssertUtils.notNull(updatePersonMember);
		AssertUtils.notNullAndEmpty(updatePersonMember.getCode(), "ID不能为空");
		try {
			PersonMember personMember = new PersonMember();
			// update数据录入
			personMember.setCode(updatePersonMember.getCode());
			personMember.setMemberNo(updatePersonMember.getMemberNo());
			personMember.setMemberName(updatePersonMember.getMemberName());
			personMember.setMemberNoGm(updatePersonMember.getMemberNoGm());
			personMember.setMemberNameGm(updatePersonMember.getMemberNameGm());
			personMember.setShopNo(updatePersonMember.getShopNo());
			personMember.setShopName(updatePersonMember.getShopName());
			personMember.setMerchantNo(updatePersonMember.getMerchantNo());
			personMember.setMerchantName(updatePersonMember.getMerchantName());
			personMember.setSpruceUp(updatePersonMember.getSpruceUp());
			personMember.setHouses(updatePersonMember.getHouses());
			personMember.setKeepEye(updatePersonMember.getKeepEye());
			personMember.setUrgencyPm(updatePersonMember.getUrgencyPm());
			personMember.setBomCode(updatePersonMember.getBomCode());
			personMember.setBomName(updatePersonMember.getBomName());
			personMember.setBrandCompare(updatePersonMember.getBrandCompare());
			personMember.setClientSpecial(updatePersonMember.getClientSpecial());
			personMember.setUpdateId(updatePersonMember.getUpdateId());
			personMember.setUpdateDate(updatePersonMember.getUpdateDate());
			personMember.setRemark4(updatePersonMember.getRemark4());
			personMember.setRemark3(updatePersonMember.getRemark3());
			personMember.setRemark2(updatePersonMember.getRemark2());
			personMember.setRemark(updatePersonMember.getRemark());
			personMember.setNickNameRemarkWx(updatePersonMember.getNickNameRemarkWx());
			/* 扫码相关 */
			personMember.setLatitude(updatePersonMember.getLatitude());
			personMember.setLongitude(updatePersonMember.getLongitude());
			personMember.setScanAddress(updatePersonMember.getScanAddress());
			// upate by 杨杰 2017-09-05
			personMember.setNickNameRemarkLocal(updatePersonMember.getNickNameRemarkLocal());

			AssertUtils.notUpdateMoreThanOne(personMemberDao.updateByPrimaryKeySelective(personMember));
			UpdatePersonMemberReturn updatePersonMemberReturn = new UpdatePersonMemberReturn();

			logger.debug("updatePersonMember(UpdatePersonMember) - end - return value={}", updatePersonMemberReturn); //$NON-NLS-1$
			return updatePersonMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("客户会员信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_UPDATE_ERROR, "客户会员信息更新信息错误！", e);
		}
	}
	
	public void innerProcess(boolean toShopFlag, GuidMember guidMember, PersonMemberBase personMemberBase, PersonMember addPersonMember, FindPmTypeReturn ptp, FindPmTypeReturn ptp2) {
//		// 产生跟进总表和第一条跟进明细记录
//		AddPmClientFollowFirstDto addPmClientFollowFirstDto = new AddPmClientFollowFirstDto();
//		addPmClientFollowFirstDto.setMerchantNo(guidMember.getMerchantNo());
//		addPmClientFollowFirstDto.setMemberNo(personMemberBase.getMemberNo());
//		addPmClientFollowFirstDto.setMemberName(personMemberBase.getMemberName());
//		addPmClientFollowFirstDto.setMemberNoGm(addPersonMember.getMemberNoGm());
//		addPmClientFollowFirstDto.setMemberNameGm(addPersonMember.getMemberNameGm());
//		addPmClientFollowFirstDto.setPmTypeCode(ptp.getCode());
//		String cfNo = clientFollowSummaryService.addSummaryWithClientFollow(addPmClientFollowFirstDto);
//
//		// 到店则添加意向(到店)
//		if (toShopFlag) {
//			// 插入客户分类关联表 意向(到店)
//			AddPmTypePmDto addPmTypePmDto = new AddPmTypePmDto();
//			addPmTypePmDto.setCodePm(addPersonMember.getCode());
//			addPmTypePmDto.setPmTypeCode(ptp2.getCode());
//			pmTypeService.addPmTypePm(addPmTypePmDto);
//
//			// 添加跟进记录
//			AddClientFollow addClientFollow = new AddClientFollow();
//			addClientFollow.setCfNo(cfNo);
//			addClientFollow.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
//			addClientFollow.setMemberNo(addPmClientFollowFirstDto.getMemberNo());
//			addClientFollow.setMemberName(personMemberBase.getMemberName());
//			addClientFollow.setMemberNoGm(addPmClientFollowFirstDto.getMemberNoGm());
//			addClientFollow.setMemberNameGm(addPersonMember.getMemberNameGm());
//			addClientFollow.setFollowNum(2);
//			addClientFollow.setFollowTime(new Date());
//			addClientFollow.setFollowInfo("客户分组到意向(到店)");
//			addClientFollow.setDeal(DealType.N.toString());
//			addClientFollow.setStatus(Status.NORMAL);
//			addClientFollow.setComTaskType("SYSTEM");
//			addClientFollow.setCreateId(addPmClientFollowFirstDto.getMemberNoGm());
//			clientFollowService.addClientFollow(addClientFollow);
//
//			// 更新跟踪总表数量
//			UpdateClientFollowSummary updateClientFollowSummary = new UpdateClientFollowSummary();
//			updateClientFollowSummary.setCfNo(cfNo);
//			updateClientFollowSummary.setFollowNum(2);
//			clientFollowSummaryService.updateClientFollowSummaryByCfNo(updateClientFollowSummary);
//
//			// 产生初次介绍任务
//			// 查询客户分类频率
//			int hour = 0;
//			if (ptp == null || StringUtils.isEmpty(ptp.getFreValue())) {
//				hour = 0;
//			} else {
//				hour = Integer.valueOf(ptp.getFreValue());
//			}
//			AddComTask addComTask = new AddComTask();
//			addComTask.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
//			addComTask.setMemberNoGm(addPmClientFollowFirstDto.getMemberNoGm());
//			addComTask.setMemberNo(addPmClientFollowFirstDto.getMemberNo());
//			addComTask.setMemberName(addPmClientFollowFirstDto.getMemberName());
//			addComTask.setCfNo(cfNo);
//			addComTask.setNoType(FollowNoType.FOLLOW.toString());
//			addComTask.setWorkDate(DateUtils.addHours(new Date(), hour));
//			addComTask.setComTaskType(ComTaskType.FIRST_INTR);
//			addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "扫码新增意向到店客户");
//			addComTask.setLastResultDate(new Date());
//
//			FindComTaskList findComTaskList = new FindComTaskList();
//			findComTaskList.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
//			findComTaskList.setComTaskType(ComTaskType.FIRST_INTR);
//			FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
//			if (findComTaskListReturn != null) {
//				addComTask.setCodeList(findComTaskListReturn.getCode());
//				addComTask.setFinishOrgComTask(false);
//				comTaskService.addComTask(addComTask);
//			}
//
//		} else {
//			// 插入客户分类关联表 未分组
//			AddPmTypePmDto addPmTypePmDto = new AddPmTypePmDto();
//			addPmTypePmDto.setCodePm(addPersonMember.getCode());
//			addPmTypePmDto.setPmTypeCode(ptp.getCode());
//			pmTypeService.addPmTypePm(addPmTypePmDto);
//
//			// 未分组则产生分组任务
//			// 查询客户分类频率
//			int hour = 0;
//			if (ptp == null || StringUtils.isEmpty(ptp.getFreValue())) {
//				hour = 0;
//			} else {
//				hour = Integer.valueOf(ptp.getFreValue());
//			}
//			AddComTask addComTask = new AddComTask();
//			addComTask.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
//			addComTask.setMemberNoGm(addPmClientFollowFirstDto.getMemberNoGm());
//			addComTask.setMemberNo(addPmClientFollowFirstDto.getMemberNo());
//			addComTask.setMemberName(addPmClientFollowFirstDto.getMemberName());
//			addComTask.setCfNo(cfNo);
//			addComTask.setNoType(FollowNoType.FOLLOW.toString());
//			addComTask.setWorkDate(DateUtils.addHours(new Date(), hour));
//			addComTask.setComTaskType(ComTaskType.GROUP);
//			addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "扫码新增客户");
//			addComTask.setLastResultDate(new Date());
//
//			FindComTaskList findComTaskList = new FindComTaskList();
//			findComTaskList.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
//			findComTaskList.setComTaskType(ComTaskType.GROUP);
//			FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
//			if (findComTaskListReturn != null) {
//				addComTask.setCodeList(findComTaskListReturn.getCode());
//				addComTask.setFinishOrgComTask(false);
//				comTaskService.addComTask(addComTask);
//			}
//		}
//
//		// 增加客户新增的数量
//		UpdateWorkTaskFinishNum updateWorkTaskFinishNum = new UpdateWorkTaskFinishNum();
//		updateWorkTaskFinishNum.setMemberNoGm(addPersonMember.getMemberNoGm());
//		updateWorkTaskFinishNum.setMerchantNo(guidMember.getMerchantNo());
//		updateWorkTaskFinishNum.setTaskType(TaskType.XIN_ZENG);
//		updateWorkTaskFinishNum.setFinishNum(1L);
//		workTaskService.updateFinishNum(updateWorkTaskFinishNum);
//
//		// 添加积分
//		GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
//		guidMemberIntegralDto.setMerchantNo(guidMember.getMerchantNo());
//		guidMemberIntegralDto.setShopNo(guidMember.getShopNo());
//		guidMemberIntegralDto.setMemberNo(addPersonMember.getMemberNoGm());
//		guidMemberIntegralDto.setAreaCode(guidMember.getAreaCode());
//		guidMemberIntegralDto.setIntegralType(IntegralType.NEW.toString());
//		guidMemberIntegralDto.setAmount(1d);
//		guidMemberIntegralService.doIntegral(guidMemberIntegralDto);
//
//		// 添加到导购行为统计表
//		AddGuidmemberActionInfo addGuidmemberActionInfo = new AddGuidmemberActionInfo();
//		addGuidmemberActionInfo.setCode(GUID.generateCode());
//		addGuidmemberActionInfo.setActionType(GuidmemberActionType.NEW.toString());
//		addGuidmemberActionInfo.setActionTime(new Date());
//		addGuidmemberActionInfo.setCreateDate(new Date());
//		addGuidmemberActionInfo.setMerchantNo(guidMember.getMerchantNo());
//		addGuidmemberActionInfo.setMemberNoGm(guidMember.getMemberNo());
//		addGuidmemberActionInfo.setMemberNameGm(guidMember.getMemberName());
//		addGuidmemberActionInfo.setShopNo(guidMember.getShopNo());
//		addGuidmemberActionInfo.setShopName(guidMember.getShopName());
//		addGuidmemberActionInfo.setActionDetail(guidMember.getMemberName() + "新增了一个用户");
//		guidmemberActionInfoService.addGuidmemberActionInfo(addGuidmemberActionInfo);
	}
	/**
	 * Insert pm.
	 *
	 * @param guidMember
	 *            the guid member
	 * @param personMemberBase
	 *            the person member base
	 * @param addPersonMember
	 *            the add person member
	 */
	private void insertPm(GuidMember guidMember, PersonMemberBase personMemberBase, PersonMember addPersonMember) {
		addPersonMember.setCode(GUID.generateCode());
		addPersonMember.setMemberNo(personMemberBase.getMemberNo());
		addPersonMember.setCreateId(guidMember.getMemberNo());
		addPersonMember.setKeepEye("Y");
		addPersonMember.setMemberName(personMemberBase.getMemberName());
		addPersonMember.setMemberNameGm(guidMember.getMemberName());
		addPersonMember.setMemberNoGm(guidMember.getMemberNo());
		addPersonMember.setMerchantName(guidMember.getMerchantName());
		addPersonMember.setMerchantNo(guidMember.getMerchantNo());
		addPersonMember.setShopName(guidMember.getShopName());
		addPersonMember.setShopNo(guidMember.getShopNo());
		addPersonMember.setUrgencyPm(UrgentFlagType.N.toString());
		addPersonMember.setFirstIntroduce(FirstIntroduce.Y.toString());
		// update by 杨杰 2017-09-05 begin
		String nickNameRemarkLocal = "";
		if (StringUtils.isNotEmpty(personMemberBase.getMemberName())) {
			nickNameRemarkLocal += personMemberBase.getMemberName();
		}
		if (StringUtils.isNotEmpty(personMemberBase.getMobile())) {
			nickNameRemarkLocal += ("-" + personMemberBase.getMobile());
		}
		if (StringUtils.isNotEmpty(addPersonMember.getBomName())) {
			nickNameRemarkLocal += ("-" + addPersonMember.getBomName());
		}
		addPersonMember.setNickNameRemarkLocal(nickNameRemarkLocal);
		// update by 杨杰 2017-09-05 end
		personMemberDao.insertSelective(addPersonMember);

		// 添加交叉客户
		DoRepeatMemberDto doRepeatMemberDto = new DoRepeatMemberDto();
		doRepeatMemberDto.setMerchantNo(guidMember.getMerchantNo());
		doRepeatMemberDto.setMemberNo(personMemberBase.getMemberNo());
		doRepeatMemberDto.setMemberNoGm(guidMember.getMemberNo());
		doRepeatMember(doRepeatMemberDto);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#doRepeatMember(com
	 * .lj.business.member.dto.DoRepeatMemberDto)
	 */
	@Override
	public void doRepeatMember(DoRepeatMemberDto doRepeatMemberDto) throws TsfaServiceException {
		FindPersonMember fp = new FindPersonMember();
		fp.setMemberNo(doRepeatMemberDto.getMemberNo());
		fp.setMerchantNo(doRepeatMemberDto.getMerchantNo());
		int count = findCountByMemberNo(fp);

		if (count > 1) {
			logger.debug("如果是交叉用户则插入客户分类");
			FindPmType fpt = new FindPmType();
			fpt.setPmTypeType(PmTypeType.REPEAT.toString());
			fpt.setMerchantNo(doRepeatMemberDto.getMerchantNo());
			FindPmTypeReturn fptr = pmTypeService.findPmTypeByMP(fpt);

			List<FindPersonMemberReturn> list = findList(doRepeatMemberDto);
			if (list != null && list.size() > 0) {
				for (FindPersonMemberReturn pm : list) {
					if (fptr != null) {
						AddPmTypePmDto addPmTypePmDto = new AddPmTypePmDto();
						addPmTypePmDto.setCodePm(pm.getCode());
						addPmTypePmDto.setPmTypeCode(fptr.getCode());
						pmTypeService.addPmTypePmRepeat(addPmTypePmDto);
					}
				}
			}
		}

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findPersonMemberByMGM
	 * (com.lj.business.member.dto.FindPersonMember)
	 */
	@Override
	public FindPersonMemberReturn findPersonMemberByMGM(FindPersonMember findPersonMember) throws TsfaServiceException {
		logger.debug("findPersonMemberByMGM(FindPersonMember findPersonMember={}) - start", findPersonMember); //$NON-NLS-1$

		AssertUtils.notNull(findPersonMember);
		AssertUtils.notNullAndEmpty(findPersonMember.getMemberNo(), "客户号不能为空");
		AssertUtils.notNullAndEmpty(findPersonMember.getMemberNoGm(), "导购号不能为空");
		try {
			PersonMember personMember = personMemberDao.selectByMGM(findPersonMember);
			if (personMember == null) {
				return null;
				// throw new
				// TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR,"客户会员信息不存在");
			}
			FindPersonMemberReturn findPersonMemberReturn = new FindPersonMemberReturn();
			// find数据录入
			findPersonMemberReturn.setCode(personMember.getCode());
			findPersonMemberReturn.setMemberNo(personMember.getMemberNo());
			findPersonMemberReturn.setMemberName(personMember.getMemberName());
			findPersonMemberReturn.setMemberNoGm(personMember.getMemberNoGm());
			findPersonMemberReturn.setMemberNameGm(personMember.getMemberNameGm());
			findPersonMemberReturn.setShopNo(personMember.getShopNo());
			findPersonMemberReturn.setShopName(personMember.getShopName());
			findPersonMemberReturn.setMerchantNo(personMember.getMerchantNo());
			findPersonMemberReturn.setMerchantName(personMember.getMerchantName());
			findPersonMemberReturn.setSpruceUp(personMember.getSpruceUp());
			findPersonMemberReturn.setHouses(personMember.getHouses());
			findPersonMemberReturn.setKeepEye(personMember.getKeepEye());
			findPersonMemberReturn.setUrgencyPm(personMember.getUrgencyPm());
			findPersonMemberReturn.setBomCode(personMember.getBomCode());
			findPersonMemberReturn.setBomName(personMember.getBomName());
			findPersonMemberReturn.setCreateId(personMember.getCreateId());
			findPersonMemberReturn.setCreateDate(personMember.getCreateDate());
			findPersonMemberReturn.setUpdateId(personMember.getUpdateId());
			findPersonMemberReturn.setUpdateDate(personMember.getUpdateDate());
			findPersonMemberReturn.setRemark4(personMember.getRemark4());
			findPersonMemberReturn.setRemark3(personMember.getRemark3());
			findPersonMemberReturn.setRemark2(personMember.getRemark2());
			findPersonMemberReturn.setRemark(personMember.getRemark());
			/* 扫码相关 */
			findPersonMemberReturn.setLatitude(personMember.getLatitude());
			findPersonMemberReturn.setLongitude(personMember.getLongitude());
			findPersonMemberReturn.setScanAddress(personMember.getScanAddress());
			findPersonMemberReturn.setBrandCompare(personMember.getBrandCompare());
			findPersonMemberReturn.setClientSpecial(personMember.getClientSpecial());

			logger.debug("findPersonMemberByMGM(FindPersonMember) - end - return value={}", findPersonMemberReturn); //$NON-NLS-1$
			return findPersonMemberReturn;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户会员信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找客户会员信息信息错误！", e);
		}

	}
	/**
	 * 查找该客户是和导购关联过.
	 *
	 * @param findPersonMember
	 *            the find person member
	 * @return the int
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 */
	@Override
	public int findCountByMemberNo(FindPersonMember findPersonMember) throws TsfaServiceException {
		logger.debug("findCountByMemberNo(FindPersonMember findPersonMember={}) - start", findPersonMember); //$NON-NLS-1$

		AssertUtils.notNull(findPersonMember);
		AssertUtils.notNullAndEmpty(findPersonMember.getMemberNo(), "客户号不能为空");
		int count = 0;
		try {
			count = personMemberDao.findCountByMemberNo(findPersonMember);
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找该客户是和导购关联过错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找该客户是和导购关联过错误！", e);
		}

		logger.debug("findCountByMemberNo(FindPersonMember findPersonMember={}) - end", findPersonMember); //$NON-NLS-1$
		return count;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findList(com.lj.business
	 * .member.dto.DoRepeatMemberDto)
	 */
	@Override
	public List<FindPersonMemberReturn> findList(DoRepeatMemberDto doRepeatMemberDto) throws TsfaServiceException {
		AssertUtils.notNull(doRepeatMemberDto);
		AssertUtils.notNullAndEmpty(doRepeatMemberDto.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(doRepeatMemberDto.getMemberNo(), "客户编号不能为空");
		AssertUtils.notNullAndEmpty(doRepeatMemberDto.getMemberNoGm(), "导购编号不能为空");
		try {
			List<FindPersonMemberReturn> list = personMemberDao.findList(doRepeatMemberDto);
			return list;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户会员信息错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找客户会员信息错误", e);
		}
	}
}
