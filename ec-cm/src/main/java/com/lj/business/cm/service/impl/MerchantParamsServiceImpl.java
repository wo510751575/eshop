package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
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
import com.lj.business.cm.constant.ErrorCode;
import com.lj.business.cm.dao.IMerchantParamsDao;
import com.lj.business.cm.domain.MerchantParams;
import com.lj.business.cm.dto.merchantParams.AddMerchantParams;
import com.lj.business.cm.dto.merchantParams.DelMerchantParams;
import com.lj.business.cm.dto.merchantParams.FindMerchantParams;
import com.lj.business.cm.dto.merchantParams.FindMerchantParamsPage;
import com.lj.business.cm.dto.merchantParams.FindMerchantParamsPageReturn;
import com.lj.business.cm.dto.merchantParams.FindMerchantParamsReturn;
import com.lj.business.cm.dto.merchantParams.UpdateMerchantParams;
import com.lj.business.cm.service.IMerchantParamsService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class MerchantParamsServiceImpl implements IMerchantParamsService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MerchantParamsServiceImpl.class);
	

	/** The merchant params dao. */
	@Resource
	private IMerchantParamsDao merchantParamsDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IMerchantParamsService#addMerchantParams(com.lj.business.cm.dto.merchantParams.AddMerchantParams)
	 */
	@Override
	public void addMerchantParams(
			AddMerchantParams addMerchantParams) throws TsfaServiceException {
		logger.debug("addMerchantParams(AddMerchantParams addMerchantParams={}) - start", addMerchantParams); 

		AssertUtils.notNull(addMerchantParams);
		try {
			MerchantParams merchantParams = new MerchantParams();
			//add数据录入
			merchantParams.setCode(GUID.generateCode());
			merchantParams.setMerchantNo(addMerchantParams.getMerchantNo());
			merchantParams.setMerchantName(addMerchantParams.getMerchantName());
			merchantParams.setSysParamName(addMerchantParams.getSysParamName());
			merchantParams.setGroupName(addMerchantParams.getGroupName());
			merchantParams.setSysParamValue(addMerchantParams.getSysParamValue());
			merchantParams.setRemark(addMerchantParams.getRemark());
			merchantParams.setOnlyAdminModify(addMerchantParams.getOnlyAdminModify());
			merchantParamsDao.insert(merchantParams);
			logger.debug("addMerchantParams(AddMerchantParams) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商户参数配置表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_PARAMS_ADD_ERROR,"新增商户参数配置表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IMerchantParamsService#delMerchantParams(com.lj.business.cm.dto.merchantParams.DelMerchantParams)
	 */
	@Override
	public void delMerchantParams(
			DelMerchantParams delMerchantParams) throws TsfaServiceException {
		logger.debug("delMerchantParams(DelMerchantParams delMerchantParams={}) - start", delMerchantParams); 

		AssertUtils.notNull(delMerchantParams);
		AssertUtils.notNull(delMerchantParams.getCode(),"Code不能为空！");
		try {
			merchantParamsDao.deleteByPrimaryKey(delMerchantParams.getCode());
			logger.debug("delMerchantParams(DelMerchantParams) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除商户参数配置表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_PARAMS_DEL_ERROR,"删除商户参数配置表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IMerchantParamsService#updateMerchantParams(com.lj.business.cm.dto.merchantParams.UpdateMerchantParams)
	 */
	@Override
	public void updateMerchantParams(
			UpdateMerchantParams updateMerchantParams)
			throws TsfaServiceException {
		logger.debug("updateMerchantParams(UpdateMerchantParams updateMerchantParams={}) - start", updateMerchantParams); //$NON-NLS-1$

		AssertUtils.notNull(updateMerchantParams);
		AssertUtils.notNullAndEmpty(updateMerchantParams.getCode(),"Code不能为空");
		try {
			MerchantParams merchantParams = new MerchantParams();
			//update数据录入
			merchantParams.setCode(updateMerchantParams.getCode());
			merchantParams.setMerchantNo(updateMerchantParams.getMerchantNo());
			merchantParams.setMerchantName(updateMerchantParams.getMerchantName());
			merchantParams.setSysParamName(updateMerchantParams.getSysParamName());
			merchantParams.setGroupName(updateMerchantParams.getGroupName());
			merchantParams.setSysParamValue(updateMerchantParams.getSysParamValue());
			merchantParams.setRemark(updateMerchantParams.getRemark());
			merchantParams.setOnlyAdminModify(updateMerchantParams.getOnlyAdminModify());
			AssertUtils.notUpdateMoreThanOne(merchantParamsDao.updateByPrimaryKeySelective(merchantParams));
			logger.debug("updateMerchantParams(UpdateMerchantParams) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商户参数配置表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_PARAMS_UPDATE_ERROR,"商户参数配置表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IMerchantParamsService#findMerchantParams(com.lj.business.cm.dto.merchantParams.FindMerchantParams)
	 */
	@Override
	public FindMerchantParamsReturn findMerchantParams(
			FindMerchantParams findMerchantParams) throws TsfaServiceException {
		logger.debug("findMerchantParams(FindMerchantParams findMerchantParams={}) - start", findMerchantParams); //$NON-NLS-1$

		AssertUtils.notNull(findMerchantParams);
		AssertUtils.notAllNull(findMerchantParams.getCode(),"Code不能为空");
		try {
			MerchantParams merchantParams = merchantParamsDao.selectByPrimaryKey(findMerchantParams.getCode());
			if(merchantParams == null){
				throw new TsfaServiceException(ErrorCode.MERCHANT_PARAMS_NOT_EXIST_ERROR,"商户参数配置表信息不存在");
			}
			FindMerchantParamsReturn findMerchantParamsReturn = new FindMerchantParamsReturn();
			//find数据录入
			findMerchantParamsReturn.setCode(merchantParams.getCode());
			findMerchantParamsReturn.setMerchantNo(merchantParams.getMerchantNo());
			findMerchantParamsReturn.setMerchantName(merchantParams.getMerchantName());
			findMerchantParamsReturn.setSysParamName(merchantParams.getSysParamName());
			findMerchantParamsReturn.setGroupName(merchantParams.getGroupName());
			findMerchantParamsReturn.setSysParamValue(merchantParams.getSysParamValue());
			findMerchantParamsReturn.setRemark(merchantParams.getRemark());
			findMerchantParamsReturn.setOnlyAdminModify(merchantParams.getOnlyAdminModify());
			findMerchantParamsReturn.setCreateDate(merchantParams.getCreateDate());
			
			logger.debug("findMerchantParams(FindMerchantParams) - end - return value={}", findMerchantParamsReturn); //$NON-NLS-1$
			return findMerchantParamsReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找商户参数配置表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_PARAMS_FIND_ERROR,"查找商户参数配置表信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IMerchantParamsService#findMerchantParamsPage(com.lj.business.cm.dto.merchantParams.FindMerchantParamsPage)
	 */
	@Override
	public Page<FindMerchantParamsPageReturn> findMerchantParamsPage(
			FindMerchantParamsPage findMerchantParamsPage)
			throws TsfaServiceException {
		logger.debug("findMerchantParamsPage(FindMerchantParamsPage findMerchantParamsPage={}) - start", findMerchantParamsPage); //$NON-NLS-1$

		AssertUtils.notNull(findMerchantParamsPage);
		List<FindMerchantParamsPageReturn> returnList;
		int count = 0;
		try {
			returnList = merchantParamsDao.findMerchantParamsPage(findMerchantParamsPage);
			count = merchantParamsDao.findMerchantParamsPageCount(findMerchantParamsPage);
		}  catch (Exception e) {
			logger.error("商户参数配置表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_PARAMS_FIND_PAGE_ERROR,"商户参数配置表信息分页查询错误.！",e);
		}
		Page<FindMerchantParamsPageReturn> returnPage = new Page<FindMerchantParamsPageReturn>(returnList, count, findMerchantParamsPage);

		logger.debug("findMerchantParamsPage(FindMerchantParamsPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
