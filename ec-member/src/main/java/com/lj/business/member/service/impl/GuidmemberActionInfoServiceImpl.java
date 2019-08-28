package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IGuidmemberActionInfoDao;
import com.lj.business.member.domain.GuidmemberActionInfo;
import com.lj.business.member.dto.FindGuidmemberActionInfoListDto;
import com.lj.business.member.dto.guidmemberActionInfo.AddGuidmemberActionInfo;
import com.lj.business.member.dto.guidmemberActionInfo.DelGuidmemberActionInfo;
import com.lj.business.member.dto.guidmemberActionInfo.FindGuidmemberActionInfo;
import com.lj.business.member.dto.guidmemberActionInfo.FindGuidmemberActionInfoReturn;
import com.lj.business.member.dto.guidmemberActionInfo.UpdateGuidmemberActionInfo;
import com.lj.business.member.service.IGuidmemberActionInfoService;

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
public class GuidmemberActionInfoServiceImpl implements IGuidmemberActionInfoService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(GuidmemberActionInfoServiceImpl.class);
	

	@Resource
	private IGuidmemberActionInfoDao guidmemberActionInfoDao;
	
	
	@Override
	public void addGuidmemberActionInfo(
			AddGuidmemberActionInfo addGuidmemberActionInfo) throws TsfaServiceException {
		logger.debug("addGuidmemberActionInfo(AddGuidmemberActionInfo addGuidmemberActionInfo={}) - start", addGuidmemberActionInfo); 

		AssertUtils.notNull(addGuidmemberActionInfo);
		try {
			GuidmemberActionInfo guidmemberActionInfo = new GuidmemberActionInfo();
			//add数据录入
			guidmemberActionInfo.setCode(addGuidmemberActionInfo.getCode());
			guidmemberActionInfo.setMerchantNo(addGuidmemberActionInfo.getMerchantNo());
			guidmemberActionInfo.setShopNo(addGuidmemberActionInfo.getShopNo());
			guidmemberActionInfo.setShopName(addGuidmemberActionInfo.getShopName());
			guidmemberActionInfo.setMemberNoGm(addGuidmemberActionInfo.getMemberNoGm());
			guidmemberActionInfo.setMemberNameGm(addGuidmemberActionInfo.getMemberNameGm());
			guidmemberActionInfo.setActionType(addGuidmemberActionInfo.getActionType());
			guidmemberActionInfo.setActionDetail(addGuidmemberActionInfo.getActionDetail());
			guidmemberActionInfo.setActionTime(addGuidmemberActionInfo.getActionTime());
			guidmemberActionInfo.setCreateDate(addGuidmemberActionInfo.getCreateDate());
			guidmemberActionInfoDao.insert(guidmemberActionInfo);
			logger.debug("addGuidmemberActionInfo(AddGuidmemberActionInfo) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增导购行为信息记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUIDMEMBER_ACTION_INFO_ADD_ERROR,"新增导购行为信息记录表信息错误！",e);
		}
	}
	
	
	@Override
	public void delGuidmemberActionInfo(
			DelGuidmemberActionInfo delGuidmemberActionInfo) throws TsfaServiceException {
		logger.debug("delGuidmemberActionInfo(DelGuidmemberActionInfo delGuidmemberActionInfo={}) - start", delGuidmemberActionInfo); 

		AssertUtils.notNull(delGuidmemberActionInfo);
		AssertUtils.notNull(delGuidmemberActionInfo.getCode(),"Code不能为空！");
		try {
			guidmemberActionInfoDao.deleteByPrimaryKey(delGuidmemberActionInfo.getCode());
			logger.debug("delGuidmemberActionInfo(DelGuidmemberActionInfo) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除导购行为信息记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUIDMEMBER_ACTION_INFO_DEL_ERROR,"删除导购行为信息记录表信息错误！",e);

		}
	}

	@Override
	public void updateGuidmemberActionInfo(
			UpdateGuidmemberActionInfo updateGuidmemberActionInfo)
			throws TsfaServiceException {
		logger.debug("updateGuidmemberActionInfo(UpdateGuidmemberActionInfo updateGuidmemberActionInfo={}) - start", updateGuidmemberActionInfo); //$NON-NLS-1$

		AssertUtils.notNull(updateGuidmemberActionInfo);
		AssertUtils.notNullAndEmpty(updateGuidmemberActionInfo.getCode(),"Code不能为空");
		try {
			GuidmemberActionInfo guidmemberActionInfo = new GuidmemberActionInfo();
			//update数据录入
			guidmemberActionInfo.setCode(updateGuidmemberActionInfo.getCode());
			guidmemberActionInfo.setMerchantNo(updateGuidmemberActionInfo.getMerchantNo());
			guidmemberActionInfo.setShopNo(updateGuidmemberActionInfo.getShopNo());
			guidmemberActionInfo.setShopName(updateGuidmemberActionInfo.getShopName());
			guidmemberActionInfo.setMemberNoGm(updateGuidmemberActionInfo.getMemberNoGm());
			guidmemberActionInfo.setMemberNameGm(updateGuidmemberActionInfo.getMemberNameGm());
			guidmemberActionInfo.setActionType(updateGuidmemberActionInfo.getActionType());
			guidmemberActionInfo.setActionDetail(updateGuidmemberActionInfo.getActionDetail());
			guidmemberActionInfo.setActionTime(updateGuidmemberActionInfo.getActionTime());
			guidmemberActionInfo.setCreateDate(updateGuidmemberActionInfo.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(guidmemberActionInfoDao.updateByPrimaryKeySelective(guidmemberActionInfo));
			logger.debug("updateGuidmemberActionInfo(UpdateGuidmemberActionInfo) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("导购行为信息记录表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUIDMEMBER_ACTION_INFO_UPDATE_ERROR,"导购行为信息记录表信息更新信息错误！",e);
		}
	}

	

	@Override
	public FindGuidmemberActionInfoReturn findGuidmemberActionInfo(
			FindGuidmemberActionInfo findGuidmemberActionInfo) throws TsfaServiceException {
		logger.debug("findGuidmemberActionInfo(FindGuidmemberActionInfo findGuidmemberActionInfo={}) - start", findGuidmemberActionInfo); //$NON-NLS-1$

		AssertUtils.notNull(findGuidmemberActionInfo);
		AssertUtils.notAllNull(findGuidmemberActionInfo.getCode(),"Code不能为空");
		try {
			GuidmemberActionInfo guidmemberActionInfo = guidmemberActionInfoDao.selectByPrimaryKey(findGuidmemberActionInfo.getCode());
			if(guidmemberActionInfo == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.GUIDMEMBER_ACTION_INFO_NOT_EXIST_ERROR,"导购行为信息记录表信息不存在");
			}
			FindGuidmemberActionInfoReturn findGuidmemberActionInfoReturn = new FindGuidmemberActionInfoReturn();
			//find数据录入
			findGuidmemberActionInfoReturn.setCode(guidmemberActionInfo.getCode());
			findGuidmemberActionInfoReturn.setMerchantNo(guidmemberActionInfo.getMerchantNo());
			findGuidmemberActionInfoReturn.setShopNo(guidmemberActionInfo.getShopNo());
			findGuidmemberActionInfoReturn.setShopName(guidmemberActionInfo.getShopName());
			findGuidmemberActionInfoReturn.setMemberNoGm(guidmemberActionInfo.getMemberNoGm());
			findGuidmemberActionInfoReturn.setMemberNameGm(guidmemberActionInfo.getMemberNameGm());
			findGuidmemberActionInfoReturn.setActionType(guidmemberActionInfo.getActionType());
			findGuidmemberActionInfoReturn.setActionDetail(guidmemberActionInfo.getActionDetail());
			findGuidmemberActionInfoReturn.setActionTime(guidmemberActionInfo.getActionTime());
			findGuidmemberActionInfoReturn.setCreateDate(guidmemberActionInfo.getCreateDate());
			
			logger.debug("findGuidmemberActionInfo(FindGuidmemberActionInfo) - end - return value={}", findGuidmemberActionInfoReturn); //$NON-NLS-1$
			return findGuidmemberActionInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找导购行为信息记录表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUIDMEMBER_ACTION_INFO_FIND_ERROR,"查找导购行为信息记录表信息信息错误！",e);
		}


	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IGuidmemberActionInfoService#findGuidmemberActionInfoList(com.lj.business.member.dto.FindGuidmemberActionInfoListDto)
	 */
	@Override
	public List<FindGuidmemberActionInfoReturn> findGuidmemberActionInfoList(FindGuidmemberActionInfoListDto findGuidmemberActionInfoListDto) throws TsfaServiceException {
		logger.debug("findGuidmemberActionInfoList(FindGuidmemberActionInfoListDto findGuidmemberActionInfoListDto={}) - start", findGuidmemberActionInfoListDto); //$NON-NLS-1$

		AssertUtils.notNull(findGuidmemberActionInfoListDto);
		AssertUtils.notNullAndEmpty(findGuidmemberActionInfoListDto.getMerchantNo(), "商户号不能为空");
		try{
			List<FindGuidmemberActionInfoReturn> list = new ArrayList<FindGuidmemberActionInfoReturn>();
			list = guidmemberActionInfoDao.findGuidmemberActionInfoList(findGuidmemberActionInfoListDto);

			logger.debug("findGuidmemberActionInfoList() - end - return value={}", list); //$NON-NLS-1$
			return list;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找导购行为信息记录表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GUIDMEMBER_ACTION_INFO_FIND_ERROR,"查找导购行为信息记录表信息信息错误！",e);
		}
	}
	
	
	
	
}
