package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IIntegralSetDao;
import com.lj.business.member.domain.IntegralSet;
import com.lj.business.member.dto.integralSet.AddIntegralSet;
import com.lj.business.member.dto.integralSet.DelIntegralSet;
import com.lj.business.member.dto.integralSet.FindIntegralSet;
import com.lj.business.member.dto.integralSet.FindIntegralSetReturn;
import com.lj.business.member.dto.integralSet.UpdateIntegralSet;
import com.lj.business.member.service.IIntegralSetService;

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
public class IntegralSetServiceImpl implements IIntegralSetService { 


	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(IntegralSetServiceImpl.class);


	@Resource
	private IIntegralSetDao integralSetDao;


	@Override
	public void addIntegralSet(
			AddIntegralSet addIntegralSet) throws TsfaServiceException {
		logger.debug("addIntegralSet(AddIntegralSet addIntegralSet={}) - start", addIntegralSet); 

		AssertUtils.notNull(addIntegralSet);
		try {
			IntegralSet integralSet = new IntegralSet();
			//add数据录入
			integralSet.setCode(GUID.generateCode());
			integralSet.setMerchantNo(addIntegralSet.getMerchantNo());
			integralSet.setMerchantName(addIntegralSet.getMerchantName());
			integralSet.setShopNo(addIntegralSet.getShopNo());
			integralSet.setShopName(addIntegralSet.getShopName());
			integralSet.setAreaCode(addIntegralSet.getAreaCode());
			integralSet.setAreaName(addIntegralSet.getAreaName());
			integralSet.setIntegralType(addIntegralSet.getIntegralType());
			integralSet.setIntegralName(addIntegralSet.getIntegralName());
			if(addIntegralSet.getIntegralScore() != null)
				integralSet.setIntegralScore(new BigDecimal(addIntegralSet.getIntegralScore()));
			if(addIntegralSet.getIntegralUp() != null)
				integralSet.setIntegralUp(new BigDecimal(addIntegralSet.getIntegralUp()));
			if(addIntegralSet.getIntegralDown() != null)
				integralSet.setIntegralDown(new BigDecimal(addIntegralSet.getIntegralDown()));

			integralSet.setStatus(addIntegralSet.getStatus());
			integralSet.setUpdateId(addIntegralSet.getUpdateId());
			integralSet.setUpdateDate(addIntegralSet.getUpdateDate());
			integralSet.setCreateId(addIntegralSet.getCreateId());
			integralSet.setCreateDate(addIntegralSet.getCreateDate());
			integralSetDao.insert(integralSet);
			logger.debug("addIntegralSet(AddIntegralSet) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增积分设置表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.INTEGRAL_SET_ADD_ERROR,"新增积分设置表信息错误！",e);
		}
	}


	@Override
	public void delIntegralSet(
			DelIntegralSet delIntegralSet) throws TsfaServiceException {
		logger.debug("delIntegralSet(DelIntegralSet delIntegralSet={}) - start", delIntegralSet); 

		AssertUtils.notNull(delIntegralSet);
		AssertUtils.notNull(delIntegralSet.getCode(),"Code不能为空！");
		try {
			integralSetDao.deleteByPrimaryKey(delIntegralSet.getCode());
			logger.debug("delIntegralSet(DelIntegralSet) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除积分设置表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.INTEGRAL_SET_DEL_ERROR,"删除积分设置表信息错误！",e);

		}
	}

	@Override
	public void updateIntegralSet(
			UpdateIntegralSet updateIntegralSet)
					throws TsfaServiceException {
		logger.debug("updateIntegralSet(UpdateIntegralSet updateIntegralSet={}) - start", updateIntegralSet); //$NON-NLS-1$

		AssertUtils.notNull(updateIntegralSet);
		AssertUtils.notNullAndEmpty(updateIntegralSet.getCode(),"Code不能为空");
		try {
			IntegralSet integralSet = new IntegralSet();
			//update数据录入
			integralSet.setCode(updateIntegralSet.getCode());
			integralSet.setMerchantNo(updateIntegralSet.getMerchantNo());
			integralSet.setMerchantName(updateIntegralSet.getMerchantName());
			integralSet.setShopNo(updateIntegralSet.getShopNo());
			integralSet.setShopName(updateIntegralSet.getShopName());
			integralSet.setAreaCode(updateIntegralSet.getAreaCode());
			integralSet.setAreaName(updateIntegralSet.getAreaName());
			integralSet.setIntegralType(updateIntegralSet.getIntegralType());
			integralSet.setIntegralName(updateIntegralSet.getIntegralName());
			integralSet.setIntegralScore(new BigDecimal(updateIntegralSet.getIntegralScore()));
			integralSet.setIntegralUp(new BigDecimal(updateIntegralSet.getIntegralUp()));
			integralSet.setIntegralDown(new BigDecimal(updateIntegralSet.getIntegralDown()));
			integralSet.setStatus(updateIntegralSet.getStatus());
			integralSet.setUpdateId(updateIntegralSet.getUpdateId());
			integralSet.setUpdateDate(updateIntegralSet.getUpdateDate());
			integralSet.setCreateId(updateIntegralSet.getCreateId());
			integralSet.setCreateDate(updateIntegralSet.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(integralSetDao.updateByPrimaryKeySelective(integralSet));
			logger.debug("updateIntegralSet(UpdateIntegralSet) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("积分设置表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.INTEGRAL_SET_UPDATE_ERROR,"积分设置表信息更新信息错误！",e);
		}
	}



	@Override
	public FindIntegralSetReturn findIntegralSet(
			FindIntegralSet findIntegralSet) throws TsfaServiceException {
		logger.debug("findIntegralSet(FindIntegralSet findIntegralSet={}) - start", findIntegralSet); //$NON-NLS-1$

		AssertUtils.notNull(findIntegralSet);
		AssertUtils.notAllNull(findIntegralSet.getCode(),"Code不能为空");
		try {
			IntegralSet integralSet = integralSetDao.selectByPrimaryKey(findIntegralSet.getCode());
			if(integralSet == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.INTEGRAL_SET_NOT_EXIST_ERROR,"积分设置表信息不存在");
			}
			FindIntegralSetReturn findIntegralSetReturn = new FindIntegralSetReturn();
			//find数据录入
			findIntegralSetReturn.setCode(integralSet.getCode());
			findIntegralSetReturn.setMerchantNo(integralSet.getMerchantNo());
			findIntegralSetReturn.setMerchantName(integralSet.getMerchantName());
			findIntegralSetReturn.setShopNo(integralSet.getShopNo());
			findIntegralSetReturn.setShopName(integralSet.getShopName());
			findIntegralSetReturn.setAreaCode(integralSet.getAreaCode());
			findIntegralSetReturn.setAreaName(integralSet.getAreaName());
			findIntegralSetReturn.setIntegralType(integralSet.getIntegralType());
			findIntegralSetReturn.setIntegralName(integralSet.getIntegralName());
			findIntegralSetReturn.setIntegralScore(integralSet.getIntegralScore() != null?integralSet.getIntegralScore().doubleValue():0.0);
			findIntegralSetReturn.setIntegralUp(integralSet.getIntegralUp()!=null?integralSet.getIntegralUp().doubleValue():0.0);
			findIntegralSetReturn.setIntegralDown(integralSet.getIntegralDown()!=null?integralSet.getIntegralDown().doubleValue():0.0);
			findIntegralSetReturn.setStatus(integralSet.getStatus());
			findIntegralSetReturn.setUpdateId(integralSet.getUpdateId());
			findIntegralSetReturn.setUpdateDate(integralSet.getUpdateDate());
			findIntegralSetReturn.setCreateId(integralSet.getCreateId());
			findIntegralSetReturn.setCreateDate(integralSet.getCreateDate());

			logger.debug("findIntegralSet(FindIntegralSet) - end - return value={}", findIntegralSetReturn); //$NON-NLS-1$
			return findIntegralSetReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找积分设置表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.INTEGRAL_SET_FIND_ERROR,"查找积分设置表信息信息错误！",e);
		}


	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IIntegralSetService#findIntegralSetByType(com.lj.business.member.dto.integralSet.FindIntegralSet)
	 */
	@Override
	public FindIntegralSetReturn findIntegralSetByType(FindIntegralSet findIntegralSet) throws TsfaServiceException {
		AssertUtils.notNull(findIntegralSet);
		AssertUtils.notNullAndEmpty(findIntegralSet.getIntegralType(), "积分类型不能为空");
		FindIntegralSetReturn findIntegralSetReturn = null;
		try{
			findIntegralSetReturn = integralSetDao.findIntegralSetByType(findIntegralSet);
			return findIntegralSetReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找积分设置表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.INTEGRAL_SET_FIND_ERROR,"查找积分设置表信息信息错误！",e);
		}
	}


}
