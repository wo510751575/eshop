package com.lj.business.member.service.impl;

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
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IPhoneInfoDao;
import com.lj.business.member.domain.PhoneInfo;
import com.lj.business.member.dto.phoneInfo.AddPhoneInfo;
import com.lj.business.member.dto.phoneInfo.DelPhoneInfo;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfo;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfoPage;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfoPageReturn;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfoReturn;
import com.lj.business.member.dto.phoneInfo.UpdatePhoneInfo;
import com.lj.business.member.service.IPhoneInfoService;

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
public class PhoneInfoServiceImpl implements IPhoneInfoService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(PhoneInfoServiceImpl.class);
	

	/** The phone info dao. */
	@Resource
	private IPhoneInfoDao phoneInfoDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPhoneInfoService#addPhoneInfo(com.lj.business.member.dto.phoneInfo.AddPhoneInfo)
	 */
	@Override
	public void addPhoneInfo(
			AddPhoneInfo addPhoneInfo) throws TsfaServiceException {
		logger.debug("addPhoneInfo(AddPhoneInfo addPhoneInfo={}) - start", addPhoneInfo); 

		AssertUtils.notNull(addPhoneInfo);
		try {
			PhoneInfo phoneInfo = new PhoneInfo();
			//add数据录入
			phoneInfo.setCode(GUID.getPreUUID());
			phoneInfo.setMemberNoMerchant(addPhoneInfo.getMemberNoMerchant());
			phoneInfo.setShopNo(addPhoneInfo.getShopNo());
			phoneInfo.setShopName(addPhoneInfo.getShopName());
			phoneInfo.setStatus(addPhoneInfo.getStatus());
			phoneInfo.setImei(addPhoneInfo.getImei());
			phoneInfo.setMemberNo(addPhoneInfo.getMemberNo());
			phoneInfo.setMemberName(addPhoneInfo.getMemberName());
			phoneInfo.setMemberType(addPhoneInfo.getMemberType());
			phoneInfo.setCreateId(addPhoneInfo.getCreateId());
			phoneInfo.setRemark4(addPhoneInfo.getRemark4());
			phoneInfo.setRemark3(addPhoneInfo.getRemark3());
			phoneInfo.setRemark(addPhoneInfo.getRemark());
			phoneInfo.setRemark2(addPhoneInfo.getRemark2());
			phoneInfoDao.insert(phoneInfo);
			logger.debug("addPhoneInfo(AddPhoneInfo) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增设备信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PHONE_INFO_ADD_ERROR,"新增设备信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPhoneInfoService#delPhoneInfo(com.lj.business.member.dto.phoneInfo.DelPhoneInfo)
	 */
	@Override
	public void delPhoneInfo(
			DelPhoneInfo delPhoneInfo) throws TsfaServiceException {
		logger.debug("delPhoneInfo(DelPhoneInfo delPhoneInfo={}) - start", delPhoneInfo); 

		AssertUtils.notNull(delPhoneInfo);
		AssertUtils.notNull(delPhoneInfo.getCode(),"Code不能为空！");
		try {
			phoneInfoDao.deleteByPrimaryKey(delPhoneInfo.getCode());
			logger.debug("delPhoneInfo(DelPhoneInfo) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除设备信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PHONE_INFO_DEL_ERROR,"删除设备信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPhoneInfoService#updatePhoneInfo(com.lj.business.member.dto.phoneInfo.UpdatePhoneInfo)
	 */
	@Override
	public void updatePhoneInfo(
			UpdatePhoneInfo updatePhoneInfo)
			throws TsfaServiceException {
		logger.debug("updatePhoneInfo(UpdatePhoneInfo updatePhoneInfo={}) - start", updatePhoneInfo); //$NON-NLS-1$

		AssertUtils.notNull(updatePhoneInfo);
		AssertUtils.notNullAndEmpty(updatePhoneInfo.getCode(),"Code不能为空");
		try {
			PhoneInfo phoneInfo = new PhoneInfo();
			//update数据录入
			phoneInfo.setCode(updatePhoneInfo.getCode());
			phoneInfo.setMemberNoMerchant(updatePhoneInfo.getMemberNoMerchant());
			phoneInfo.setShopNo(updatePhoneInfo.getShopNo());
			phoneInfo.setShopName(updatePhoneInfo.getShopName());
			phoneInfo.setStatus(updatePhoneInfo.getStatus());
			phoneInfo.setImei(updatePhoneInfo.getImei());
			phoneInfo.setMemberNo(updatePhoneInfo.getMemberNo());
			phoneInfo.setMemberName(updatePhoneInfo.getMemberName());
			phoneInfo.setMemberType(updatePhoneInfo.getMemberType());
			phoneInfo.setRemark4(updatePhoneInfo.getRemark4());
			phoneInfo.setRemark3(updatePhoneInfo.getRemark3());
			phoneInfo.setRemark(updatePhoneInfo.getRemark());
			phoneInfo.setRemark2(updatePhoneInfo.getRemark2());
			AssertUtils.notUpdateMoreThanOne(phoneInfoDao.updateByPrimaryKeySelective(phoneInfo));
			logger.debug("updatePhoneInfo(UpdatePhoneInfo) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("设备信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.PHONE_INFO_UPDATE_ERROR,"设备信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPhoneInfoService#findPhoneInfo(com.lj.business.member.dto.phoneInfo.FindPhoneInfo)
	 */
	@Override
	public FindPhoneInfoReturn findPhoneInfo(
			FindPhoneInfo findPhoneInfo) throws TsfaServiceException {
		logger.debug("findPhoneInfo(FindPhoneInfo findPhoneInfo={}) - start", findPhoneInfo); //$NON-NLS-1$

		AssertUtils.notNull(findPhoneInfo);
		AssertUtils.notAllNull(findPhoneInfo.getCode(),"Code不能为空");
		try {
			PhoneInfo phoneInfo = phoneInfoDao.selectByPrimaryKey(findPhoneInfo.getCode());
			if(phoneInfo == null){
				throw new TsfaServiceException(ErrorCode.PHONE_INFO_NOT_EXIST_ERROR,"设备信息不存在");
			}
			FindPhoneInfoReturn findPhoneInfoReturn = new FindPhoneInfoReturn();
			//find数据录入
			findPhoneInfoReturn.setCode(phoneInfo.getCode());
			findPhoneInfoReturn.setMemberNoMerchant(phoneInfo.getMemberNoMerchant());
			findPhoneInfoReturn.setShopNo(phoneInfo.getShopNo());
			findPhoneInfoReturn.setShopName(phoneInfo.getShopName());
			findPhoneInfoReturn.setStatus(phoneInfo.getStatus());
			findPhoneInfoReturn.setImei(phoneInfo.getImei());
			findPhoneInfoReturn.setMemberNo(phoneInfo.getMemberNo());
			findPhoneInfoReturn.setMemberName(phoneInfo.getMemberName());
			findPhoneInfoReturn.setMemberType(phoneInfo.getMemberType());
			findPhoneInfoReturn.setCreateId(phoneInfo.getCreateId());
			findPhoneInfoReturn.setCreateDate(phoneInfo.getCreateDate());
			findPhoneInfoReturn.setRemark4(phoneInfo.getRemark4());
			findPhoneInfoReturn.setRemark3(phoneInfo.getRemark3());
			findPhoneInfoReturn.setRemark(phoneInfo.getRemark());
			findPhoneInfoReturn.setRemark2(phoneInfo.getRemark2());
			
			logger.debug("findPhoneInfo(FindPhoneInfo) - end - return value={}", findPhoneInfoReturn); //$NON-NLS-1$
			return findPhoneInfoReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找设备信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PHONE_INFO_FIND_ERROR,"查找设备信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPhoneInfoService#findPhoneInfoPage(com.lj.business.member.dto.phoneInfo.FindPhoneInfoPage)
	 */
	@Override
	public Page<FindPhoneInfoPageReturn> findPhoneInfoPage(
			FindPhoneInfoPage findPhoneInfoPage)
			throws TsfaServiceException {
		logger.debug("findPhoneInfoPage(FindPhoneInfoPage findPhoneInfoPage={}) - start", findPhoneInfoPage); //$NON-NLS-1$

		AssertUtils.notNull(findPhoneInfoPage);
		List<FindPhoneInfoPageReturn> returnList;
		int count = 0;
		try {
			returnList = phoneInfoDao.findPhoneInfoPage(findPhoneInfoPage);
			count = phoneInfoDao.findPhoneInfoPageCount(findPhoneInfoPage);
		}  catch (Exception e) {
			logger.error("设备信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PHONE_INFO_FIND_PAGE_ERROR,"设备信息分页查询错误.！",e);
		}
		Page<FindPhoneInfoPageReturn> returnPage = new Page<FindPhoneInfoPageReturn>(returnList, count, findPhoneInfoPage);

		logger.debug("findPhoneInfoPage(FindPhoneInfoPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
