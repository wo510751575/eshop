package com.lj.business.cf.service.impl;

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
import com.lj.base.exception.TsfaContextServiceException;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.ICfErrorInfoDao;
import com.lj.business.cf.domain.CfErrorInfo;
import com.lj.business.cf.dto.cfErrorInfo.AddCfErrorInfoDto;
import com.lj.business.cf.dto.cfErrorInfo.CfErrorInfoReturnDto;
import com.lj.business.cf.dto.cfErrorInfo.EditCfErrorInfoDto;
import com.lj.business.cf.dto.cfErrorInfo.FindCfErrorInfoPageDto;
import com.lj.business.cf.service.ICfErrorInfoService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class CfErrorInfoServiceImpl implements ICfErrorInfoService { 
	
	/** The Cf error info dao. */
	@Resource
	private ICfErrorInfoDao cfErrorInfoDao;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CfErrorInfoServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ICfErrorInfoService#addCfErrorInfo(com.lj.business.cf.domain.CfErrorInfo)
	 */
	@Override
	public void addCfErrorInfo(AddCfErrorInfoDto addCfErrorInfoDto) {
		AssertUtils.notNull(addCfErrorInfoDto);
		AssertUtils.notNullAndEmpty(addCfErrorInfoDto.getMerchantNo(),"商户编号不能为空");
		try {
			CfErrorInfo cfErrorInfo = new CfErrorInfo();
			cfErrorInfo.setCode(GUID.getPreUUID());
			cfErrorInfo.setMerchantNo(addCfErrorInfoDto.getMerchantNo());
			cfErrorInfo.setShopNo(addCfErrorInfoDto.getShopNo());
			cfErrorInfo.setMerchantNo(addCfErrorInfoDto.getMerchantNo());
			cfErrorInfo.setShopNo(addCfErrorInfoDto.getShopNo());
			cfErrorInfo.setShopName(addCfErrorInfoDto.getShopName());
			cfErrorInfo.setMemberNoGm(addCfErrorInfoDto.getMemberNoGm());
			cfErrorInfo.setMemberNameGm(addCfErrorInfoDto.getMemberNameGm());
			cfErrorInfo.setCodeList(addCfErrorInfoDto.getCodeList());
			cfErrorInfo.setNameList(addCfErrorInfoDto.getNameList());
			cfErrorInfo.setErrorNum(addCfErrorInfoDto.getErrorNum());
			cfErrorInfo.setCreateId(addCfErrorInfoDto.getCreateId());
			cfErrorInfo.setRemark(addCfErrorInfoDto.getRemark());
			cfErrorInfo.setRemark2(addCfErrorInfoDto.getRemark2());
			cfErrorInfo.setRemark3(addCfErrorInfoDto.getRemark3());
			cfErrorInfo.setRemark4(addCfErrorInfoDto.getRemark4());
			cfErrorInfoDao.addCfErrorInfo(cfErrorInfo);
		} catch (TsfaContextServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增跟进异常情况表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CFERRORINFO_ADD_ERROR,"新增跟进异常情况表信息错误！",e);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ICfErrorInfoService#editCfErrorInfo(com.lj.business.cf.domain.CfErrorInfo)
	 */
	@Override
	public void editCfErrorInfo(EditCfErrorInfoDto editCfErrorInfoDto) {
		AssertUtils.notNull(editCfErrorInfoDto);
		AssertUtils.notNullAndEmpty(editCfErrorInfoDto.getCode(),"CODE不能为空");
		try {
			CfErrorInfo cfErrorInfo = new CfErrorInfo();
			cfErrorInfo.setCode(GUID.getPreUUID());
			cfErrorInfo.setMerchantNo(editCfErrorInfoDto.getMerchantNo());
			cfErrorInfo.setShopNo(editCfErrorInfoDto.getShopNo());
			cfErrorInfo.setMerchantNo(editCfErrorInfoDto.getMerchantNo());
			cfErrorInfo.setShopNo(editCfErrorInfoDto.getShopNo());
			cfErrorInfo.setShopName(editCfErrorInfoDto.getShopName());
			cfErrorInfo.setMemberNoGm(editCfErrorInfoDto.getMemberNoGm());
			cfErrorInfo.setMemberNameGm(editCfErrorInfoDto.getMemberNameGm());
			cfErrorInfo.setCodeList(editCfErrorInfoDto.getCodeList());
			cfErrorInfo.setNameList(editCfErrorInfoDto.getNameList());
			cfErrorInfo.setErrorNum(editCfErrorInfoDto.getErrorNum());
			cfErrorInfo.setCreateId(editCfErrorInfoDto.getCreateId());
			cfErrorInfo.setRemark(editCfErrorInfoDto.getRemark());
			cfErrorInfo.setRemark2(editCfErrorInfoDto.getRemark2());
			cfErrorInfo.setRemark3(editCfErrorInfoDto.getRemark3());
			cfErrorInfo.setRemark4(editCfErrorInfoDto.getRemark4());
			cfErrorInfo.setCreateDate(editCfErrorInfoDto.getCreateDate());
			cfErrorInfoDao.editCfErrorInfo(cfErrorInfo);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("编辑跟进异常情况表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CFERRORINFO_EDIT_ERROR,"编辑跟进异常情况表信息错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ICfErrorInfoService#selectByCode(java.lang.String)
	 */
	@Override
	public CfErrorInfoReturnDto selectByCode(String code) {
		AssertUtils.notNullAndEmpty(code,"CODE不能为空");
		try {
			CfErrorInfo cfErrorInfo  = cfErrorInfoDao.selectByCode(code);
			CfErrorInfoReturnDto cfErrorInfoReturnDto = new CfErrorInfoReturnDto();
			cfErrorInfoReturnDto.setCode(cfErrorInfo.getCode());
			cfErrorInfoReturnDto.setMerchantNo(cfErrorInfo.getMerchantNo());
			cfErrorInfoReturnDto.setShopNo(cfErrorInfo.getShopNo());
			cfErrorInfoReturnDto.setShopName(cfErrorInfo.getShopName());
			cfErrorInfoReturnDto.setMemberNoGm(cfErrorInfo.getMemberNoGm());
			cfErrorInfoReturnDto.setMemberNameGm(cfErrorInfo.getMemberNameGm());
			cfErrorInfoReturnDto.setCodeList(cfErrorInfo.getCodeList());
			cfErrorInfoReturnDto.setNameList(cfErrorInfo.getNameList());
			cfErrorInfoReturnDto.setErrorNum(cfErrorInfo.getErrorNum());
			cfErrorInfoReturnDto.setCreateId(cfErrorInfo.getCreateId());
			cfErrorInfoReturnDto.setRemark(cfErrorInfo.getRemark());
			cfErrorInfoReturnDto.setRemark2(cfErrorInfo.getRemark2());
			cfErrorInfoReturnDto.setRemark3(cfErrorInfo.getRemark3());
			cfErrorInfoReturnDto.setRemark4(cfErrorInfo.getRemark4());
			cfErrorInfoReturnDto.setCreateDate(cfErrorInfo.getCreateDate());
			return cfErrorInfoReturnDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("查找跟进异常情况表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CFERRORINFO_FIND_ERROR,"查找跟进异常情况表信息错误！",e);
		}  
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ICfErrorInfoService#findCfErrorInfos(com.lj.business.cf.dto.FindCfErrorInfoPageDto)
	 */
	@Override
	public List<FindCfErrorInfoPageDto> findCfErrorInfos(FindCfErrorInfoPageDto findCfErrorInfoPageDto) {
		AssertUtils.notNull(findCfErrorInfoPageDto);
		List<FindCfErrorInfoPageDto> returnList;
		try {
			returnList = cfErrorInfoDao.findCfErrorInfos(findCfErrorInfoPageDto);
		}  catch (Exception e) {
			logger.error("查找跟进异常情况表信息错误",e);
			throw new TsfaServiceException(ErrorCode.CFERRORINFO_FIND_ERROR,"查找跟进异常情况表信息错误.！",e);
		}
		return  returnList;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ICfErrorInfoService#findCfErrorInfoPage(com.lj.business.cf.dto.FindCfErrorInfoPageDto)
	 */
	@Override
	public Page<FindCfErrorInfoPageDto> findCfErrorInfoPage(FindCfErrorInfoPageDto findCfErrorInfoPageDto) {
		logger.debug("findCfErrorInfoPageDto(FindCfErrorInfoPageDto findCfErrorInfoPageDto) ) - start", findCfErrorInfoPageDto); 

		AssertUtils.notNull(findCfErrorInfoPageDto);
		List<FindCfErrorInfoPageDto> returnList;
		int count = 0;
		try {
			returnList = cfErrorInfoDao.findCfErrorInfoPage(findCfErrorInfoPageDto);
			count = cfErrorInfoDao.findCfErrorInfoPageCount(findCfErrorInfoPageDto);
		}  catch (Exception e) {
			logger.error("跟进异常情况表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.CFERRORINFO_FIND_PAGE_ERROR,"跟进异常情况表信息分页查询错误.！",e);
		}
		Page<FindCfErrorInfoPageDto> returnPage = new Page<FindCfErrorInfoPageDto>(returnList, count, findCfErrorInfoPageDto);

		logger.debug("findCfErrorInfoPageDto(FindCfErrorInfoPageDto) - end - return value={}", returnPage); 
		return  returnPage;
	}


}
