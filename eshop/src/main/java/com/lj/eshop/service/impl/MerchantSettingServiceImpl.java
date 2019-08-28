package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IMerchantSettingDao;
import com.lj.eshop.domain.MerchantSetting;
import com.lj.eshop.dto.FindMerchantSettingPage;
import com.lj.eshop.dto.MerchantSettingDto;
import com.lj.eshop.service.IMerchantSettingService;
/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author lhy
 * 
 * 
 * CreateDate: 2017-08-22
 */
@Service
public class MerchantSettingServiceImpl implements IMerchantSettingService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MerchantSettingServiceImpl.class);
	

	@Resource
	private IMerchantSettingDao merchantSettingDao;
	
	
	@Override
	public void addMerchantSetting(
			MerchantSettingDto merchantSettingDto) throws TsfaServiceException {
		logger.debug("addMerchantSetting(AddMerchantSetting addMerchantSetting={}) - start", merchantSettingDto); 

		AssertUtils.notNull(merchantSettingDto);
		try {
			MerchantSetting merchantSetting = new MerchantSetting();
			//add数据录入
			merchantSetting.setCode(GUID.generateCode());
			merchantSetting.setMerchantCode(merchantSettingDto.getMerchantCode());
			merchantSetting.setValue(merchantSettingDto.getValue());
			merchantSetting.setName(merchantSettingDto.getName());
			merchantSetting.setRemarks(merchantSettingDto.getRemarks());
			merchantSetting.setCreateTime(merchantSettingDto.getCreateTime());
			merchantSetting.setStatus(merchantSettingDto.getStatus());
			merchantSetting.setTypes(merchantSettingDto.getTypes());
			merchantSettingDao.insertSelective(merchantSetting);
			logger.debug("addMerchantSetting(MerchantSettingDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商户配置信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_SETTING_ADD_ERROR,"新增商户配置信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商户配置信息
	 *
	 * @param findMerchantSettingPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<MerchantSettingDto>  findMerchantSettings(FindMerchantSettingPage findMerchantSettingPage)throws TsfaServiceException{
		AssertUtils.notNull(findMerchantSettingPage);
		List<MerchantSettingDto> returnList=null;
		try {
			returnList = merchantSettingDao.findMerchantSettings(findMerchantSettingPage);
		} catch (Exception e) {
			logger.error("查找商户配置信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_SETTING_NOT_EXIST_ERROR,"商户配置信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateMerchantSetting(
			MerchantSettingDto merchantSettingDto)
			throws TsfaServiceException {
		logger.debug("updateMerchantSetting(MerchantSettingDto merchantSettingDto={}) - start", merchantSettingDto); //$NON-NLS-1$

		AssertUtils.notNull(merchantSettingDto);
		AssertUtils.notNullAndEmpty(merchantSettingDto.getCode(),"Code不能为空");
		try {
			MerchantSetting merchantSetting = new MerchantSetting();
			//update数据录入
			merchantSetting.setCode(merchantSettingDto.getCode());
			merchantSetting.setMerchantCode(merchantSettingDto.getMerchantCode());
			merchantSetting.setValue(merchantSettingDto.getValue());
			merchantSetting.setName(merchantSettingDto.getName());
			merchantSetting.setRemarks(merchantSettingDto.getRemarks());
			merchantSetting.setCreateTime(merchantSettingDto.getCreateTime());
			merchantSetting.setStatus(merchantSettingDto.getStatus());
			merchantSetting.setTypes(merchantSettingDto.getTypes());
			AssertUtils.notUpdateMoreThanOne(merchantSettingDao.updateByPrimaryKeySelective(merchantSetting));
			logger.debug("updateMerchantSetting(MerchantSettingDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商户配置信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_SETTING_UPDATE_ERROR,"商户配置信息更新信息错误！",e);
		}
	}

	

	@Override
	public MerchantSettingDto findMerchantSetting(
			MerchantSettingDto merchantSettingDto) throws TsfaServiceException {
		logger.debug("findMerchantSetting(FindMerchantSetting findMerchantSetting={}) - start", merchantSettingDto); //$NON-NLS-1$

		AssertUtils.notNull(merchantSettingDto);
		AssertUtils.notAllNull(merchantSettingDto.getCode(),"Code不能为空");
		try {
			MerchantSetting merchantSetting = merchantSettingDao.selectByPrimaryKey(merchantSettingDto.getCode());
			if(merchantSetting == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.MERCHANT_SETTING_NOT_EXIST_ERROR,"商户配置信息不存在");
			}
			MerchantSettingDto findMerchantSettingReturn = new MerchantSettingDto();
			//find数据录入
			findMerchantSettingReturn.setCode(merchantSetting.getCode());
			findMerchantSettingReturn.setMerchantCode(merchantSetting.getMerchantCode());
			findMerchantSettingReturn.setValue(merchantSetting.getValue());
			findMerchantSettingReturn.setName(merchantSetting.getName());
			findMerchantSettingReturn.setRemarks(merchantSetting.getRemarks());
			findMerchantSettingReturn.setCreateTime(merchantSetting.getCreateTime());
			findMerchantSettingReturn.setStatus(merchantSetting.getStatus());
			findMerchantSettingReturn.setTypes(merchantSetting.getTypes());
			
			logger.debug("findMerchantSetting(MerchantSettingDto) - end - return value={}", findMerchantSettingReturn); //$NON-NLS-1$
			return findMerchantSettingReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商户配置信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_SETTING_FIND_ERROR,"查找商户配置信息信息错误！",e);
		}


	}

	
	@Override
	public Page<MerchantSettingDto> findMerchantSettingPage(
			FindMerchantSettingPage findMerchantSettingPage)
			throws TsfaServiceException {
		logger.debug("findMerchantSettingPage(FindMerchantSettingPage findMerchantSettingPage={}) - start", findMerchantSettingPage); //$NON-NLS-1$

		AssertUtils.notNull(findMerchantSettingPage);
		List<MerchantSettingDto> returnList=null;
		int count = 0;
		try {
			returnList = merchantSettingDao.findMerchantSettingPage(findMerchantSettingPage);
			count = merchantSettingDao.findMerchantSettingPageCount(findMerchantSettingPage);
		}  catch (Exception e) {
			logger.error("商户配置信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_SETTING_FIND_PAGE_ERROR,"商户配置信息不存在错误.！",e);
		}
		Page<MerchantSettingDto> returnPage = new Page<MerchantSettingDto>(returnList, count, findMerchantSettingPage);

		logger.debug("findMerchantSettingPage(FindMerchantSettingPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 

	
	public MerchantSettingDto  findSettingsByName(String name,String merchantCode)throws TsfaServiceException{
		AssertUtils.notNullAndEmpty(name);
		AssertUtils.notNullAndEmpty(merchantCode);
		List<MerchantSettingDto> returnList=null;
		try {
			MerchantSettingDto param = new MerchantSettingDto();
			param.setMerchantCode(merchantCode);
			param.setName(name);
			FindMerchantSettingPage findMerchantSettingPage = new FindMerchantSettingPage();
			findMerchantSettingPage.setParam(param);
			returnList = merchantSettingDao.findMerchantSettings(findMerchantSettingPage);
			if(returnList.size()<=0){
				return null;
			}
		} catch (Exception e) {
			logger.error("查找商户配置信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_SETTING_NOT_EXIST_ERROR,"商户配置信息不存在");
		}
		return returnList.get(0);
	}

}
