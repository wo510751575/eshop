package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetailReturn;
import com.lj.business.cf.service.ITaskSetShopDetailService;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IGuidMemberIntegralDao;
import com.lj.business.member.domain.GuidMemberIntegral;
import com.lj.business.member.dto.FindGuidMemberDto;
import com.lj.business.member.dto.FindMerchantDto;
import com.lj.business.member.dto.FindMerchantReturnDto;
import com.lj.business.member.dto.GuidMemberReturnDto;
import com.lj.business.member.dto.guidMemberIntegral.AddGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.DelGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.FindGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.FindGuidMemberIntegralReturn;
import com.lj.business.member.dto.guidMemberIntegral.GuidMemberIntegralDto;
import com.lj.business.member.dto.guidMemberIntegral.UpdateGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegralDay.AddGuidMemberIntegralDay;
import com.lj.business.member.dto.integralSet.FindIntegralSet;
import com.lj.business.member.dto.integralSet.FindIntegralSetReturn;
import com.lj.business.member.emus.IntegralType;
import com.lj.business.member.service.IGuidMemberIntegralDayService;
import com.lj.business.member.service.IGuidMemberIntegralService;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IIntegralSetService;
import com.lj.business.member.service.IMerchantService;
import com.lj.business.member.service.IShopService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 冯辉
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class GuidMemberIntegralServiceImpl implements IGuidMemberIntegralService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(GuidMemberIntegralServiceImpl.class);
	

	@Resource
	private IGuidMemberIntegralDao guidMemberIntegralDao;
	
	@Resource
	private IIntegralSetService integralSetService;
	
	@Resource
	private IMerchantService merchantService;
	
	@Resource
	private IGuidMemberService guidMemberService;
	
	@Resource
	private IShopService shopService;
	
	
	@Resource
	private IGuidMemberIntegralDayService guidMemberIntegralDayService;
	
	@Resource
	private ITaskSetShopDetailService taskSetShopDetailService;
	
	@Override
	public void addGuidMemberIntegral(
			AddGuidMemberIntegral addGuidMemberIntegral) throws TsfaServiceException {
		logger.debug("addGuidMemberIntegral(AddGuidMemberIntegral addGuidMemberIntegral={}) - start", addGuidMemberIntegral); 

		AssertUtils.notNull(addGuidMemberIntegral);
		try {
			GuidMemberIntegral guidMemberIntegral = new GuidMemberIntegral();
			//add数据录入
			guidMemberIntegral.setCode(addGuidMemberIntegral.getCode());
			guidMemberIntegral.setMerchantNo(addGuidMemberIntegral.getMerchantNo());
			guidMemberIntegral.setMerchantName(addGuidMemberIntegral.getMerchantName());
			guidMemberIntegral.setMemberNo(addGuidMemberIntegral.getMemberNo());
			guidMemberIntegral.setMemberName(addGuidMemberIntegral.getMemberName());
			guidMemberIntegral.setShopNo(addGuidMemberIntegral.getShopNo());
			guidMemberIntegral.setShopName(addGuidMemberIntegral.getShopName());
			guidMemberIntegral.setAreaCode(addGuidMemberIntegral.getAreaCode());
			guidMemberIntegral.setAreaName(addGuidMemberIntegral.getAreaName());
			guidMemberIntegral.setCodeList(addGuidMemberIntegral.getCodeList());
			guidMemberIntegral.setCodeName(addGuidMemberIntegral.getCodeName());
			guidMemberIntegral.setIntegralType(addGuidMemberIntegral.getIntegralType());
			guidMemberIntegral.setIntegralScore(new BigDecimal(addGuidMemberIntegral.getIntegralScore()));
			guidMemberIntegral.setDaySt(addGuidMemberIntegral.getDaySt());
			guidMemberIntegral.setCreateId(addGuidMemberIntegral.getCreateId());
			guidMemberIntegral.setCreateDate(addGuidMemberIntegral.getCreateDate());
			guidMemberIntegralDao.insert(guidMemberIntegral);
			logger.debug("addGuidMemberIntegral(AddGuidMemberIntegral) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增导购积分明细表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_ADD_ERROR,"新增导购积分明细表信息错误！",e);
		}
	}
	
	
	@Override
	public void delGuidMemberIntegral(
			DelGuidMemberIntegral delGuidMemberIntegral) throws TsfaServiceException {
		logger.debug("delGuidMemberIntegral(DelGuidMemberIntegral delGuidMemberIntegral={}) - start", delGuidMemberIntegral); 

		AssertUtils.notNull(delGuidMemberIntegral);
		AssertUtils.notNull(delGuidMemberIntegral.getCode(),"Code不能为空！");
		try {
			guidMemberIntegralDao.deleteByPrimaryKey(delGuidMemberIntegral.getCode());
			logger.debug("delGuidMemberIntegral(DelGuidMemberIntegral) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除导购积分明细表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_DEL_ERROR,"删除导购积分明细表信息错误！",e);

		}
	}

	@Override
	public void updateGuidMemberIntegral(
			UpdateGuidMemberIntegral updateGuidMemberIntegral)
			throws TsfaServiceException {
		logger.debug("updateGuidMemberIntegral(UpdateGuidMemberIntegral updateGuidMemberIntegral={}) - start", updateGuidMemberIntegral); //$NON-NLS-1$

		AssertUtils.notNull(updateGuidMemberIntegral);
		AssertUtils.notNullAndEmpty(updateGuidMemberIntegral.getCode(),"Code不能为空");
		try {
			GuidMemberIntegral guidMemberIntegral = new GuidMemberIntegral();
			//update数据录入
			guidMemberIntegral.setCode(updateGuidMemberIntegral.getCode());
			guidMemberIntegral.setMerchantNo(updateGuidMemberIntegral.getMerchantNo());
			guidMemberIntegral.setMerchantName(updateGuidMemberIntegral.getMerchantName());
			guidMemberIntegral.setMemberNo(updateGuidMemberIntegral.getMemberNo());
			guidMemberIntegral.setMemberName(updateGuidMemberIntegral.getMemberName());
			guidMemberIntegral.setShopNo(updateGuidMemberIntegral.getShopNo());
			guidMemberIntegral.setShopName(updateGuidMemberIntegral.getShopName());
			guidMemberIntegral.setAreaCode(updateGuidMemberIntegral.getAreaCode());
			guidMemberIntegral.setAreaName(updateGuidMemberIntegral.getAreaName());
			guidMemberIntegral.setCodeList(updateGuidMemberIntegral.getCodeList());
			guidMemberIntegral.setCodeName(updateGuidMemberIntegral.getCodeName());
			guidMemberIntegral.setIntegralType(updateGuidMemberIntegral.getIntegralType());
			guidMemberIntegral.setIntegralScore(new BigDecimal(updateGuidMemberIntegral.getIntegralScore()));
			guidMemberIntegral.setDaySt(updateGuidMemberIntegral.getDaySt());
			guidMemberIntegral.setCreateId(updateGuidMemberIntegral.getCreateId());
			guidMemberIntegral.setCreateDate(updateGuidMemberIntegral.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(guidMemberIntegralDao.updateByPrimaryKeySelective(guidMemberIntegral));
			logger.debug("updateGuidMemberIntegral(UpdateGuidMemberIntegral) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("导购积分明细表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_UPDATE_ERROR,"导购积分明细表信息更新信息错误！",e);
		}
	}

	

	@Override
	public FindGuidMemberIntegralReturn findGuidMemberIntegral(
			FindGuidMemberIntegral findGuidMemberIntegral) throws TsfaServiceException {
		logger.debug("findGuidMemberIntegral(FindGuidMemberIntegral findGuidMemberIntegral={}) - start", findGuidMemberIntegral); //$NON-NLS-1$

		AssertUtils.notNull(findGuidMemberIntegral);
		AssertUtils.notAllNull(findGuidMemberIntegral.getCode(),"Code不能为空");
		try {
			GuidMemberIntegral guidMemberIntegral = guidMemberIntegralDao.selectByPrimaryKey(findGuidMemberIntegral.getCode());
			if(guidMemberIntegral == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_NOT_EXIST_ERROR,"导购积分明细表信息不存在");
			}
			FindGuidMemberIntegralReturn findGuidMemberIntegralReturn = new FindGuidMemberIntegralReturn();
			//find数据录入
			findGuidMemberIntegralReturn.setCode(guidMemberIntegral.getCode());
			findGuidMemberIntegralReturn.setMerchantNo(guidMemberIntegral.getMerchantNo());
			findGuidMemberIntegralReturn.setMerchantName(guidMemberIntegral.getMerchantName());
			findGuidMemberIntegralReturn.setMemberNo(guidMemberIntegral.getMemberNo());
			findGuidMemberIntegralReturn.setMemberName(guidMemberIntegral.getMemberName());
			findGuidMemberIntegralReturn.setShopNo(guidMemberIntegral.getShopNo());
			findGuidMemberIntegralReturn.setShopName(guidMemberIntegral.getShopName());
			findGuidMemberIntegralReturn.setAreaCode(guidMemberIntegral.getAreaCode());
			findGuidMemberIntegralReturn.setAreaName(guidMemberIntegral.getAreaName());
			findGuidMemberIntegralReturn.setCodeList(guidMemberIntegral.getCodeList());
			findGuidMemberIntegralReturn.setCodeName(guidMemberIntegral.getCodeName());
			findGuidMemberIntegralReturn.setIntegralType(guidMemberIntegral.getIntegralType());
			findGuidMemberIntegralReturn.setIntegralScore(guidMemberIntegral.getIntegralScore()!=null?guidMemberIntegral.getIntegralScore().doubleValue():0.0);
			findGuidMemberIntegralReturn.setDaySt(guidMemberIntegral.getDaySt());
			findGuidMemberIntegralReturn.setCreateId(guidMemberIntegral.getCreateId());
			findGuidMemberIntegralReturn.setCreateDate(guidMemberIntegral.getCreateDate());
			
			logger.debug("findGuidMemberIntegral(FindGuidMemberIntegral) - end - return value={}", findGuidMemberIntegralReturn); //$NON-NLS-1$
			return findGuidMemberIntegralReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找导购积分明细表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_FIND_ERROR,"查找导购积分明细表信息信息错误！",e);
		}


	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IGuidMemberIntegralService#findByIntegralType(com.lj.business.member.dto.guidMemberIntegral.FindGuidMemberIntegral)
	 */
	@Override
	public List<FindGuidMemberIntegralReturn>  findByIntegralType(FindGuidMemberIntegral findGuidMemberIntegral) throws TsfaServiceException{
		AssertUtils.notNull(findGuidMemberIntegral);
		AssertUtils.notNullAndEmpty(findGuidMemberIntegral.getIntegralType(), "积分类型不能为空");
		AssertUtils.notNullAndEmpty(findGuidMemberIntegral.getDaySt(), "统计日期不能为空");
		try{
			List<FindGuidMemberIntegralReturn> list = guidMemberIntegralDao.findByIntegralType(findGuidMemberIntegral);
			return list;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找导购积分明细表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_FIND_ERROR,"查找导购积分明细表信息信息错误！",e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IGuidMemberIntegralService#doIntegral(com.lj.business.member.dto.guidMemberIntegral.GuidMemberIntegralDto)
	 */
	@Override
	public void doIntegral(GuidMemberIntegralDto guidMemberIntegralDto)throws TsfaServiceException {
		logger.debug("doIntegral(GuidMemberIntegralDto guidMemberIntegralDto={}) - start", guidMemberIntegralDto); //$NON-NLS-1$

		AssertUtils.notNull(guidMemberIntegralDto);
		AssertUtils.notNullAndEmpty(guidMemberIntegralDto.getMemberNo(), "导购编号不能为空");
		AssertUtils.notNullAndEmpty(guidMemberIntegralDto.getMerchantNo(), "商户编号不能为空");
		//AssertUtils.notNullAndEmpty(guidMemberIntegralDto.getShopNo(), "分店编号不能为空");
		//AssertUtils.notNullAndEmpty(guidMemberIntegralDto.getAreaCode(), "区域编号不能为空");
		AssertUtils.notNullAndEmpty(guidMemberIntegralDto.getIntegralType(), "积分类型不能为空");
		try{
			//根据积分类型查询积分设置表 
			Date now = org.apache.commons.lang.time.DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
			String integralType = guidMemberIntegralDto.getIntegralType();
			FindIntegralSet findIntegralSet = new FindIntegralSet();
			findIntegralSet.setIntegralType(integralType);
			findIntegralSet.setMerchantNo(guidMemberIntegralDto.getMerchantNo());
			FindIntegralSetReturn findIntegralSetReturn = integralSetService.findIntegralSetByType(findIntegralSet);
			if(findIntegralSetReturn != null){
				convertName(guidMemberIntegralDto);
				//查询任务目标 
				FindTaskSetShopDetail findTaskSetShopDetail = new FindTaskSetShopDetail();
				findTaskSetShopDetail.setMerchantNo(guidMemberIntegralDto.getMerchantNo());
				findTaskSetShopDetail.setMemberNoGm(guidMemberIntegralDto.getMemberNo());
				findTaskSetShopDetail.setShopNo(guidMemberIntegralDto.getShopNo());
				findTaskSetShopDetail.setNow(now);
				//查询当天该类型明细总分
				FindGuidMemberIntegral FindGuidMemberIntegral = new FindGuidMemberIntegral();
				FindGuidMemberIntegral.setIntegralType(findIntegralSetReturn.getIntegralType());
				FindGuidMemberIntegral.setMemberNo(guidMemberIntegralDto.getMemberNo());
				FindGuidMemberIntegral.setDaySt(now);
				List<FindGuidMemberIntegralReturn> list = findByIntegralType(FindGuidMemberIntegral);
				//计算之前的明细总积分
				Double total = 0.0;
				if(list != null && list.size() > 0){
					for(FindGuidMemberIntegralReturn findGuidMemberIntegralReturn:list){
						total = total + findGuidMemberIntegralReturn.getIntegralScore();
					}
				}
				//沟通客户
				if(IntegralType.COM_TASK.toString().equals(findIntegralSetReturn.getIntegralType())){
					//添加积分明细
					addGuidMemberIntegral(toDto(guidMemberIntegralDto,findIntegralSetReturn));
					
					//添加或修改积分日表
					guidMemberIntegralDayService.addOrUpdateGuidMemberIntegralDay(toDayDto(guidMemberIntegralDto,findIntegralSetReturn));
					
				// 新增客户
				}else if(IntegralType.NEW.toString().equals(findIntegralSetReturn.getIntegralType())){
					FindTaskSetShopDetailReturn findTaskSetShopDetailReturn = taskSetShopDetailService.findTaskSetShopDetailNewByMGMDay(findTaskSetShopDetail);
					if(findTaskSetShopDetailReturn != null){
						//日目标
						Long target = findTaskSetShopDetailReturn.getNumDay();
						if(target > 0){
							BigDecimal child = new BigDecimal(guidMemberIntegralDto.getAmount() == null?0:guidMemberIntegralDto.getAmount());
							BigDecimal mother = new BigDecimal(target);
							
							Double s = child.divide(mother, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(findIntegralSetReturn.getIntegralUp().doubleValue())).
									setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
							findIntegralSetReturn.setIntegralScore(s);
							
							logger.info("target:" + target + ",child:" + child + ",mother:" + mother + ",s:" + s);
							
							//添加积分明细
							addGuidMemberIntegral(toDto(guidMemberIntegralDto,findIntegralSetReturn));
							//添加或修改积分日表
							guidMemberIntegralDayService.addOrUpdateGuidMemberIntegralDay(toDayDto(guidMemberIntegralDto,findIntegralSetReturn));
						}
					}
				// 销售目标
				}else if(IntegralType.XIAO_SHOU.toString().equals(findIntegralSetReturn.getIntegralType())){
					FindTaskSetShopDetailReturn findTaskSetShopDetailReturn = taskSetShopDetailService.findTaskSetShopDetailByMGMDay(findTaskSetShopDetail);
					if(findTaskSetShopDetailReturn != null){
						//日目标
						Long target = findTaskSetShopDetailReturn.getNumDay();
						if(target > 0){
							BigDecimal child = new BigDecimal(guidMemberIntegralDto.getAmount() == null ?0:guidMemberIntegralDto.getAmount());
							BigDecimal mother = new BigDecimal(target);
							
							Double s = child.divide(mother, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(findIntegralSetReturn.getIntegralUp().doubleValue())).
									setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
							
							findIntegralSetReturn.setIntegralScore(s);
							
							logger.info("target:" + target + ",child:" + child + ",mother:" + mother + ",s:" + s);
							
							//添加积分明细
							addGuidMemberIntegral(toDto(guidMemberIntegralDto,findIntegralSetReturn));
							//添加或修改积分日表
						    guidMemberIntegralDayService.addOrUpdateGuidMemberIntegralDay(toDayDto(guidMemberIntegralDto,findIntegralSetReturn));
							
						}
					}
				}else if(IntegralType.NOTICE.toString().equals(findIntegralSetReturn.getIntegralType())  //NOTICE 客户提醒 
						|| IntegralType.SOCIAL.toString().equals(findIntegralSetReturn.getIntegralType()) // SOCIAL 社交任务  //完成
						|| IntegralType.ACTIVE.toString().equals(findIntegralSetReturn.getIntegralType()) // ACTIVE 活动专题  //直接调用接口 
						|| IntegralType.ASK.toString().equals(findIntegralSetReturn.getIntegralType()) // ASK 问候 
						|| IntegralType.NEW_MET.toString().equals(findIntegralSetReturn.getIntegralType()) //  NEW_MET 新增素材  
						|| IntegralType.SEND_MET.toString().equals(findIntegralSetReturn.getIntegralType()) // SEND_MET 发送素材  //直接调用接口 
						){
						//添加积分明细
						addGuidMemberIntegral(toDto(guidMemberIntegralDto,findIntegralSetReturn));
						//添加或修改积分日表
					    guidMemberIntegralDayService.addOrUpdateGuidMemberIntegralDay(toDayDto(guidMemberIntegralDto,findIntegralSetReturn));
						
				}
			}
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
		} catch (Exception e) {
			logger.error("新增导购积分明细表信息错误！",e);
		}
		
		
		logger.debug("doIntegral() - end"); //$NON-NLS-1$
	}
	
	private AddGuidMemberIntegralDay toDayDto(GuidMemberIntegralDto guidMemberIntegralDto,FindIntegralSetReturn findIntegralSetReturn){
		AddGuidMemberIntegralDay addGuidMemberIntegralDay = new AddGuidMemberIntegralDay();
		addGuidMemberIntegralDay.setMerchantNo(guidMemberIntegralDto.getMerchantNo());
		addGuidMemberIntegralDay.setMerchantName(guidMemberIntegralDto.getMerchantName());
		addGuidMemberIntegralDay.setShopNo(guidMemberIntegralDto.getShopNo());
		addGuidMemberIntegralDay.setShopName(guidMemberIntegralDto.getShopName());
		addGuidMemberIntegralDay.setAreaCode(guidMemberIntegralDto.getAreaCode());
		addGuidMemberIntegralDay.setAreaName(guidMemberIntegralDto.getAreaName());
		addGuidMemberIntegralDay.setMemberNo(guidMemberIntegralDto.getMemberNo());
		addGuidMemberIntegralDay.setMemberName(guidMemberIntegralDto.getMemberName());
		addGuidMemberIntegralDay.setIntegralScore(findIntegralSetReturn.getIntegralScore());
		addGuidMemberIntegralDay.setDaySt(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
		addGuidMemberIntegralDay.setUp(findIntegralSetReturn.getIntegralUp());
		addGuidMemberIntegralDay.setIntegralType(findIntegralSetReturn.getIntegralType());
		return addGuidMemberIntegralDay;
	}
	
	
	private AddGuidMemberIntegral toDto(GuidMemberIntegralDto guidMemberIntegralDto,FindIntegralSetReturn findIntegralSetReturn){
		AddGuidMemberIntegral addGuidMemberIntegral = new AddGuidMemberIntegral();
		addGuidMemberIntegral.setCode(GUID.generateCode());
		addGuidMemberIntegral.setMerchantNo(guidMemberIntegralDto.getMerchantNo());
		addGuidMemberIntegral.setMerchantName(guidMemberIntegralDto.getMerchantName());
		addGuidMemberIntegral.setShopNo(guidMemberIntegralDto.getShopNo());
		addGuidMemberIntegral.setShopName(guidMemberIntegralDto.getShopName());
		addGuidMemberIntegral.setAreaCode(guidMemberIntegralDto.getAreaCode());
		addGuidMemberIntegral.setAreaName(guidMemberIntegralDto.getAreaName());
		addGuidMemberIntegral.setCodeList(findIntegralSetReturn.getCode());
		addGuidMemberIntegral.setCodeName(findIntegralSetReturn.getIntegralName());
		addGuidMemberIntegral.setMemberNo(guidMemberIntegralDto.getMemberNo());
		addGuidMemberIntegral.setMemberName(guidMemberIntegralDto.getMemberName());
		addGuidMemberIntegral.setIntegralScore(findIntegralSetReturn.getIntegralScore());
		addGuidMemberIntegral.setIntegralType(findIntegralSetReturn.getIntegralType());
		addGuidMemberIntegral.setCreateDate(new Date());
		addGuidMemberIntegral.setCreateId(guidMemberIntegralDto.getMemberNo());
		addGuidMemberIntegral.setDaySt(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
		return addGuidMemberIntegral;
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param guidMemberIntegralDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月3日
	 *
	 */
	public GuidMemberIntegralDto convertName(GuidMemberIntegralDto guidMemberIntegralDto)throws TsfaServiceException {
		try{
			if(StringUtils.isEmpty(guidMemberIntegralDto.getMerchantName())){
				FindMerchantDto findMerchantDto = new FindMerchantDto();
				findMerchantDto.setMerchantNo(guidMemberIntegralDto.getMerchantNo());
				FindMerchantReturnDto findMerchantReturnDto = merchantService.selectMerchant(findMerchantDto);
				if(findMerchantReturnDto != null){
					guidMemberIntegralDto.setMerchantName(findMerchantReturnDto.getMerchantName());
				}
			}
			
			if(StringUtils.isEmpty(guidMemberIntegralDto.getMemberName())){
				FindGuidMemberDto findGuidMemberDto = new FindGuidMemberDto();
				findGuidMemberDto.setMemberNo(guidMemberIntegralDto.getMemberNo());
				GuidMemberReturnDto guidMemberReturnDto = guidMemberService.findGuid(findGuidMemberDto);
				if(guidMemberReturnDto != null){
					guidMemberIntegralDto.setMemberName(guidMemberReturnDto.getMemberName());
					guidMemberIntegralDto.setShopName(guidMemberReturnDto.getShopName());
					guidMemberIntegralDto.setAreaCode(guidMemberReturnDto.getAreaCode());
				}
			}
			
			return guidMemberIntegralDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("新增导购积分明细表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_ADD_ERROR,"新增导购积分明细表信息错误！",e);
		}
	}

}
