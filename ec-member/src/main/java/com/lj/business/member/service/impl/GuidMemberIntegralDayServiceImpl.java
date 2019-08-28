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
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IGuidMemberIntegralDayDao;
import com.lj.business.member.domain.GuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.AddGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.DelGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDayReturn;
import com.lj.business.member.dto.guidMemberIntegralDay.UpdateGuidMemberIntegralDay;
import com.lj.business.member.service.IGuidMemberIntegralDayService;

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
public class GuidMemberIntegralDayServiceImpl implements IGuidMemberIntegralDayService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(GuidMemberIntegralDayServiceImpl.class);
	

	@Resource
	private IGuidMemberIntegralDayDao guidMemberIntegralDayDao;
	
	
	@Override
	public void addGuidMemberIntegralDay(
			AddGuidMemberIntegralDay addGuidMemberIntegralDay) throws TsfaServiceException {
		logger.debug("addGuidMemberIntegralDay(AddGuidMemberIntegralDay addGuidMemberIntegralDay={}) - start", addGuidMemberIntegralDay); 

		AssertUtils.notNull(addGuidMemberIntegralDay);
		try {
			GuidMemberIntegralDay guidMemberIntegralDay = new GuidMemberIntegralDay();
			//add数据录入
			guidMemberIntegralDay.setCode(addGuidMemberIntegralDay.getCode());
			guidMemberIntegralDay.setMerchantNo(addGuidMemberIntegralDay.getMerchantNo());
			guidMemberIntegralDay.setMerchantName(addGuidMemberIntegralDay.getMerchantName());
			guidMemberIntegralDay.setMemberNo(addGuidMemberIntegralDay.getMemberNo());
			guidMemberIntegralDay.setMemberName(addGuidMemberIntegralDay.getMemberName());
			guidMemberIntegralDay.setShopNo(addGuidMemberIntegralDay.getShopNo());
			guidMemberIntegralDay.setShopName(addGuidMemberIntegralDay.getShopName());
			guidMemberIntegralDay.setAreaCode(addGuidMemberIntegralDay.getAreaCode());
			guidMemberIntegralDay.setAreaName(addGuidMemberIntegralDay.getAreaName());
			guidMemberIntegralDay.setIntegralScore(new BigDecimal(addGuidMemberIntegralDay.getIntegralScore()));
			guidMemberIntegralDay.setDaySt(addGuidMemberIntegralDay.getDaySt());
			guidMemberIntegralDay.setUpdateId(addGuidMemberIntegralDay.getUpdateId());
			guidMemberIntegralDay.setUpdateDate(addGuidMemberIntegralDay.getUpdateDate());
			guidMemberIntegralDay.setCreateId(addGuidMemberIntegralDay.getCreateId());
			guidMemberIntegralDay.setCreateDate(addGuidMemberIntegralDay.getCreateDate());
			guidMemberIntegralDay.setIntegralType(addGuidMemberIntegralDay.getIntegralType());
			guidMemberIntegralDayDao.insert(guidMemberIntegralDay);
			logger.debug("addGuidMemberIntegralDay(AddGuidMemberIntegralDay) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增导购积分日总表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_DAY_ADD_ERROR,"新增导购积分日总表信息错误！",e);
		}
	}
	
	
	@Override
	public void delGuidMemberIntegralDay(
			DelGuidMemberIntegralDay delGuidMemberIntegralDay) throws TsfaServiceException {
		logger.debug("delGuidMemberIntegralDay(DelGuidMemberIntegralDay delGuidMemberIntegralDay={}) - start", delGuidMemberIntegralDay); 

		AssertUtils.notNull(delGuidMemberIntegralDay);
		AssertUtils.notNull(delGuidMemberIntegralDay.getCode(),"Code不能为空！");
		try {
			guidMemberIntegralDayDao.deleteByPrimaryKey(delGuidMemberIntegralDay.getCode());
			logger.debug("delGuidMemberIntegralDay(DelGuidMemberIntegralDay) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除导购积分日总表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_DAY_DEL_ERROR,"删除导购积分日总表信息错误！",e);

		}
	}

	@Override
	public void updateGuidMemberIntegralDay(
			UpdateGuidMemberIntegralDay updateGuidMemberIntegralDay)
			throws TsfaServiceException {
		logger.debug("updateGuidMemberIntegralDay(UpdateGuidMemberIntegralDay updateGuidMemberIntegralDay={}) - start", updateGuidMemberIntegralDay); //$NON-NLS-1$

		AssertUtils.notNull(updateGuidMemberIntegralDay);
		AssertUtils.notNullAndEmpty(updateGuidMemberIntegralDay.getCode(),"Code不能为空");
		try {
			GuidMemberIntegralDay guidMemberIntegralDay = new GuidMemberIntegralDay();
			//update数据录入
			guidMemberIntegralDay.setCode(updateGuidMemberIntegralDay.getCode());
			guidMemberIntegralDay.setMerchantNo(updateGuidMemberIntegralDay.getMerchantNo());
			guidMemberIntegralDay.setMerchantName(updateGuidMemberIntegralDay.getMerchantName());
			guidMemberIntegralDay.setMemberNo(updateGuidMemberIntegralDay.getMemberNo());
			guidMemberIntegralDay.setMemberName(updateGuidMemberIntegralDay.getMemberName());
			guidMemberIntegralDay.setShopNo(updateGuidMemberIntegralDay.getShopNo());
			guidMemberIntegralDay.setShopName(updateGuidMemberIntegralDay.getShopName());
			guidMemberIntegralDay.setAreaCode(updateGuidMemberIntegralDay.getAreaCode());
			guidMemberIntegralDay.setAreaName(updateGuidMemberIntegralDay.getAreaName());
			guidMemberIntegralDay.setIntegralScore(new BigDecimal(updateGuidMemberIntegralDay.getIntegralScore()));
			guidMemberIntegralDay.setDaySt(updateGuidMemberIntegralDay.getDaySt());
			guidMemberIntegralDay.setUpdateId(updateGuidMemberIntegralDay.getUpdateId());
			guidMemberIntegralDay.setUpdateDate(updateGuidMemberIntegralDay.getUpdateDate());
			guidMemberIntegralDay.setCreateId(updateGuidMemberIntegralDay.getCreateId());
			guidMemberIntegralDay.setCreateDate(updateGuidMemberIntegralDay.getCreateDate());
			guidMemberIntegralDay.setIntegralType(updateGuidMemberIntegralDay.getIntegralType());
			AssertUtils.notUpdateMoreThanOne(guidMemberIntegralDayDao.updateByPrimaryKeySelective(guidMemberIntegralDay));
			logger.debug("updateGuidMemberIntegralDay(UpdateGuidMemberIntegralDay) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("导购积分日总表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_DAY_UPDATE_ERROR,"导购积分日总表信息更新信息错误！",e);
		}
	}

	

	@Override
	public FindGuidMemberIntegralDayReturn findGuidMemberIntegralDay(
			FindGuidMemberIntegralDay findGuidMemberIntegralDay) throws TsfaServiceException {
		logger.debug("findGuidMemberIntegralDay(FindGuidMemberIntegralDay findGuidMemberIntegralDay={}) - start", findGuidMemberIntegralDay); //$NON-NLS-1$

		AssertUtils.notNull(findGuidMemberIntegralDay);
		AssertUtils.notAllNull(findGuidMemberIntegralDay.getCode(),"Code不能为空");
		try {
			GuidMemberIntegralDay guidMemberIntegralDay = guidMemberIntegralDayDao.selectByPrimaryKey(findGuidMemberIntegralDay.getCode());
			if(guidMemberIntegralDay == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_DAY_NOT_EXIST_ERROR,"导购积分日总表信息不存在");
			}
			FindGuidMemberIntegralDayReturn findGuidMemberIntegralDayReturn = new FindGuidMemberIntegralDayReturn();
			//find数据录入
			findGuidMemberIntegralDayReturn.setCode(guidMemberIntegralDay.getCode());
			findGuidMemberIntegralDayReturn.setMerchantNo(guidMemberIntegralDay.getMerchantNo());
			findGuidMemberIntegralDayReturn.setMerchantName(guidMemberIntegralDay.getMerchantName());
			findGuidMemberIntegralDayReturn.setMemberNo(guidMemberIntegralDay.getMemberNo());
			findGuidMemberIntegralDayReturn.setMemberName(guidMemberIntegralDay.getMemberName());
			findGuidMemberIntegralDayReturn.setShopNo(guidMemberIntegralDay.getShopNo());
			findGuidMemberIntegralDayReturn.setShopName(guidMemberIntegralDay.getShopName());
			findGuidMemberIntegralDayReturn.setAreaCode(guidMemberIntegralDay.getAreaCode());
			findGuidMemberIntegralDayReturn.setAreaName(guidMemberIntegralDay.getAreaName());
			findGuidMemberIntegralDayReturn.setIntegralScore(guidMemberIntegralDay.getIntegralScore()!=null?guidMemberIntegralDay.getIntegralScore().doubleValue():0.0);
			findGuidMemberIntegralDayReturn.setDaySt(guidMemberIntegralDay.getDaySt());
			findGuidMemberIntegralDayReturn.setUpdateId(guidMemberIntegralDay.getUpdateId());
			findGuidMemberIntegralDayReturn.setUpdateDate(guidMemberIntegralDay.getUpdateDate());
			findGuidMemberIntegralDayReturn.setCreateId(guidMemberIntegralDay.getCreateId());
			findGuidMemberIntegralDayReturn.setCreateDate(guidMemberIntegralDay.getCreateDate());
			
			logger.debug("findGuidMemberIntegralDay(FindGuidMemberIntegralDay) - end - return value={}", findGuidMemberIntegralDayReturn); //$NON-NLS-1$
			return findGuidMemberIntegralDayReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找导购积分日总表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_DAY_FIND_ERROR,"查找导购积分日总表信息信息错误！",e);
		}


	}
	
	@Override
	public FindGuidMemberIntegralDayReturn findByGMDay(FindGuidMemberIntegralDay findGuidMemberIntegralDay)throws TsfaServiceException {
		AssertUtils.notNull(findGuidMemberIntegralDay);
		AssertUtils.notNullAndEmpty(findGuidMemberIntegralDay.getMemberNo(), "导购编号不能为空");
		try{
			return guidMemberIntegralDayDao.findByDaySt(findGuidMemberIntegralDay);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找导购积分日总表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_DAY_FIND_ERROR,"查找导购积分日总表信息信息错误！",e);
		}
	}
	
	@Override
	public List<FindGuidMemberIntegralDayReturn> findByGMDayList(FindGuidMemberIntegralDay findGuidMemberIntegralDay) throws TsfaServiceException {
		AssertUtils.notNull(findGuidMemberIntegralDay);
		AssertUtils.notNullAndEmpty(findGuidMemberIntegralDay.getMemberNo(), "导购编号不能为空");
		try{
			return guidMemberIntegralDayDao.findByDayStList(findGuidMemberIntegralDay);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找导购积分日总表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_DAY_FIND_ERROR,"查找导购积分日总表信息信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IGuidMemberIntegralDayService#addOrUpdateGuidMemberIntegralDay(com.lj.business.member.dto.guidMemberIntegralDay.AddGuidMemberIntegralDay)
	 */
	@Override
	public void addOrUpdateGuidMemberIntegralDay(AddGuidMemberIntegralDay addGuidMemberIntegralDay) throws TsfaServiceException {
		AssertUtils.notNull(addGuidMemberIntegralDay);
//		AssertUtils.notNullAndEmpty(addGuidMemberIntegralDay.getMemberNo(), "导购编号不能为空");
//		AssertUtils.notNullAndEmpty(addGuidMemberIntegralDay.getMerchantNo(), "商户编号不能为空");
//		AssertUtils.notNullAndEmpty(addGuidMemberIntegralDay.getShopNo(), "分店编号不能为空");
//		AssertUtils.notNullAndEmpty(addGuidMemberIntegralDay.getAreaCode(), "区域编号不能为空");
		try{
			//查询是否存在
			FindGuidMemberIntegralDay findGuidMemberIntegralDay = new FindGuidMemberIntegralDay();
			findGuidMemberIntegralDay.setMemberNo(addGuidMemberIntegralDay.getMemberNo());
			findGuidMemberIntegralDay.setDaySt(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
			findGuidMemberIntegralDay.setIntegralType(addGuidMemberIntegralDay.getIntegralType());
			FindGuidMemberIntegralDayReturn findGuidMemberIntegralDayReturn = guidMemberIntegralDayDao.findByDaySt(findGuidMemberIntegralDay);
			if(findGuidMemberIntegralDayReturn != null){
				//修改
				UpdateGuidMemberIntegralDay updateGuidMemberIntegralDay = new UpdateGuidMemberIntegralDay();
				updateGuidMemberIntegralDay.setCode(findGuidMemberIntegralDayReturn.getCode());
				updateGuidMemberIntegralDay.setMerchantNo(addGuidMemberIntegralDay.getMerchantNo());
				updateGuidMemberIntegralDay.setMerchantName(addGuidMemberIntegralDay.getMerchantName());
				updateGuidMemberIntegralDay.setAreaCode(addGuidMemberIntegralDay.getAreaCode());
				updateGuidMemberIntegralDay.setAreaName(addGuidMemberIntegralDay.getAreaName());
				updateGuidMemberIntegralDay.setShopNo(addGuidMemberIntegralDay.getShopNo());
				updateGuidMemberIntegralDay.setShopName(addGuidMemberIntegralDay.getShopName());
				updateGuidMemberIntegralDay.setMemberNo(addGuidMemberIntegralDay.getMemberNo());
				updateGuidMemberIntegralDay.setMemberName(addGuidMemberIntegralDay.getMemberName());
				updateGuidMemberIntegralDay.setDaySt(DateUtils.truncate(addGuidMemberIntegralDay.getDaySt(), Calendar.DAY_OF_MONTH));
				updateGuidMemberIntegralDay.setUpdateDate(new Date());
				updateGuidMemberIntegralDay.setUpdateId(addGuidMemberIntegralDay.getMemberNo());
				if(findGuidMemberIntegralDayReturn.getIntegralScore() + addGuidMemberIntegralDay.getIntegralScore() > addGuidMemberIntegralDay.getUp()){
					updateGuidMemberIntegralDay.setIntegralScore(addGuidMemberIntegralDay.getUp());
				}else{
					updateGuidMemberIntegralDay.setIntegralScore(findGuidMemberIntegralDayReturn.getIntegralScore() + addGuidMemberIntegralDay.getIntegralScore());
				}
				updateGuidMemberIntegralDay(updateGuidMemberIntegralDay);
			}else{
				//添加
				if(addGuidMemberIntegralDay.getIntegralScore() > addGuidMemberIntegralDay.getUp()){
					addGuidMemberIntegralDay.setIntegralScore(addGuidMemberIntegralDay.getUp());
				}else{
					addGuidMemberIntegralDay.setIntegralScore(addGuidMemberIntegralDay.getIntegralScore());
				}
				
				addGuidMemberIntegralDay.setCode(GUID.generateCode());
				addGuidMemberIntegralDay.setCreateId(addGuidMemberIntegralDay.getMemberNo());
				addGuidMemberIntegralDay.setCreateDate(new Date());
				addGuidMemberIntegralDay(addGuidMemberIntegralDay);
			}
			
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("新增导购积分日总表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_INTEGRAL_DAY_ADD_ERROR,"新增导购积分日总表信息错误！",e);
		}
		
	}
	

}
