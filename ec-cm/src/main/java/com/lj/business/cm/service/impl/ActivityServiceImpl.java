package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.constant.ErrorCode;
import com.lj.business.cm.constant.PublicConstants;
import com.lj.business.cm.dao.IActivityDao;
import com.lj.business.cm.domain.Activity;
import com.lj.business.cm.dto.activity.AddActivity;
import com.lj.business.cm.dto.activity.AddActivityReturn;
import com.lj.business.cm.dto.activity.DelActivity;
import com.lj.business.cm.dto.activity.DelActivityReturn;
import com.lj.business.cm.dto.activity.FindActivity;
import com.lj.business.cm.dto.activity.FindActivityPage;
import com.lj.business.cm.dto.activity.FindActivityPageReturn;
import com.lj.business.cm.dto.activity.FindActivityReturn;
import com.lj.business.cm.dto.activity.UpdateActivity;
import com.lj.business.cm.dto.activity.UpdateActivityForReadDto;
import com.lj.business.cm.dto.activity.UpdateActivityReturn;
import com.lj.business.cm.service.IActivityService;
import com.lj.business.common.SystemParamConstant;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.cc.enums.SystemAliasName;

/**
 * 
 * 
 * 类说明：活动表实现类
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月24日
 */
@Service
public class ActivityServiceImpl implements IActivityService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);
	

	@Resource
	private IActivityDao activityDao;
	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	
	@Override
	public AddActivityReturn addActivity(
			AddActivity addActivity) throws TsfaServiceException {
		logger.debug("addActivity(AddActivity addActivity={}) - start", addActivity); 

		AssertUtils.notNull(addActivity);
		try {
			Activity activity = new Activity();
			//add数据录入
			activity.setCode(GUID.generateByUUID());
			activity.setMerchantNo(addActivity.getMerchantNo());
			activity.setMerchantName(addActivity.getMerchantName());
			activity.setTitle(addActivity.getTitle());
			activity.setContent(addActivity.getContent());
			activity.setImgAddr(addActivity.getImgAddr());
			activity.setLinkUrl(addActivity.getLinkUrl());
			activity.setShowImgAddr(addActivity.getShowImgAddr());
			activity.setReadCount(0L);
			activity.setShareCount(0L);
			activity.setCreateId(addActivity.getCreateId());
			activity.setCreateDate(new Date());
			activity.setRemark(addActivity.getRemark());
			activity.setRemark2(addActivity.getRemark2());
			activity.setRemark3(addActivity.getRemark3());
			activity.setRemark4(addActivity.getRemark4());
			activity.setStartDate(addActivity.getStartDate());
			activityDao.insertSelective(activity);
			AddActivityReturn addActivityReturn = new AddActivityReturn();
			
			logger.debug("addActivity(AddActivity) - end - return value={}", addActivityReturn); 
			return addActivityReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增活动表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACTIVITY_ADD_ERROR,"新增活动表信息错误！",e);
		}
	}
	
	
	@Override
	public DelActivityReturn delActivity(
			DelActivity delActivity) throws TsfaServiceException {
		logger.debug("delActivity(DelActivity delActivity={}) - start", delActivity); 

		AssertUtils.notNull(delActivity);
		AssertUtils.notNull(delActivity.getCode(),"CODE不能为空！");
		try {
			activityDao.deleteByPrimaryKey(delActivity.getCode());
			DelActivityReturn delActivityReturn  = new DelActivityReturn();

			logger.debug("delActivity(DelActivity) - end - return value={}", delActivityReturn); //$NON-NLS-1$
			return delActivityReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除活动表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACTIVITY_DEL_ERROR,"删除活动表信息错误！",e);

		}
	}

	@Override
	public UpdateActivityReturn updateActivity(
			UpdateActivity updateActivity)
			throws TsfaServiceException {
		logger.debug("updateActivity(UpdateActivity updateActivity={}) - start", updateActivity); //$NON-NLS-1$

		AssertUtils.notNull(updateActivity);
		AssertUtils.notNullAndEmpty(updateActivity.getCode(),"CODE不能为空");
		try {
			Activity activity = new Activity();
			//update数据录入
			activity.setCode(updateActivity.getCode());
			activity.setMerchantNo(updateActivity.getMerchantNo());
			activity.setMerchantName(updateActivity.getMerchantName());
			activity.setTitle(updateActivity.getTitle());
			activity.setContent(updateActivity.getContent());
			activity.setImgAddr(updateActivity.getImgAddr());
			activity.setLinkUrl(updateActivity.getLinkUrl());
			activity.setReadCount(updateActivity.getReadCount());
			activity.setShareCount(updateActivity.getShareCount());
			activity.setShowImgAddr(updateActivity.getShowImgAddr());
			activity.setRemark(updateActivity.getRemark());
			activity.setRemark2(updateActivity.getRemark2());
			activity.setRemark3(updateActivity.getRemark3());
			activity.setRemark4(updateActivity.getRemark4());
			activity.setStartDate(updateActivity.getStartDate());
			AssertUtils.notUpdateMoreThanOne(activityDao.updateByPrimaryKeySelective(activity));
			UpdateActivityReturn updateActivityReturn = new UpdateActivityReturn();

			logger.debug("updateActivity(UpdateActivity) - end - return value={}", updateActivityReturn); //$NON-NLS-1$
			return updateActivityReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("活动表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACTIVITY_UPDATE_ERROR,"活动表信息更新信息错误！",e);
		}
	}

	

	@Override
	public FindActivityReturn findActivity(
			FindActivity findActivity) throws TsfaServiceException {
		logger.debug("findActivity(FindActivity findActivity={}) - start", findActivity); //$NON-NLS-1$

		AssertUtils.notNull(findActivity);
		AssertUtils.notAllNull(findActivity.getCode(),"CODE不能为空");
		try {
			Activity activity = activityDao.selectByPrimaryKey(findActivity.getCode());
			if(activity == null){
				throw new TsfaServiceException(ErrorCode.ACTIVITY_NOT_EXIST_ERROR,"活动表信息不存在");
			}
			FindActivityReturn findActivityReturn = new FindActivityReturn();
			//find数据录入
			findActivityReturn.setCode(activity.getCode());
			findActivityReturn.setMerchantNo(activity.getMerchantNo());
			findActivityReturn.setMerchantName(activity.getMerchantName());
			findActivityReturn.setTitle(activity.getTitle());
			findActivityReturn.setContent(activity.getContent());
			findActivityReturn.setImgAddr(activity.getImgAddr());
			findActivityReturn.setLinkUrl(activity.getLinkUrl());
			findActivityReturn.setReadCount(activity.getReadCount());
			findActivityReturn.setShareCount(activity.getShareCount());
			findActivityReturn.setCreateId(activity.getCreateId());
			findActivityReturn.setCreateDate(activity.getCreateDate());
			findActivityReturn.setRemark(activity.getRemark());
			findActivityReturn.setRemark2(activity.getRemark2());
			findActivityReturn.setRemark3(activity.getRemark3());
			findActivityReturn.setRemark4(activity.getRemark4());
			findActivityReturn.setShowImgAddr(activity.getShowImgAddr());
			findActivityReturn.setStartDate(activity.getStartDate());
			logger.debug("findActivity(FindActivity) - end - return value={}", findActivityReturn); //$NON-NLS-1$
			return findActivityReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找活动表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACTIVITY_FIND_ERROR,"查找活动表信息错误！",e);
		}


	}

	
	@Override
	public Page<FindActivityPageReturn> findActivityPage(
			FindActivityPage findActivityPage)
			throws TsfaServiceException {
		logger.debug("findActivityPage(FindActivityPage findActivityPage={}) - start", findActivityPage); //$NON-NLS-1$

		AssertUtils.notNull(findActivityPage);
		List<FindActivityPageReturn> returnList;
		int count = 0;
		try {
			returnList = activityDao.findActivityPage(findActivityPage);
			count = activityDao.findActivityPageCount(findActivityPage);
		}  catch (Exception e) {
			logger.error("活动表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.ACTIVITY_FIND_PAGE_ERROR,"活动表信息分页查询错误.！",e);
		}
		Page<FindActivityPageReturn> returnPage = new Page<FindActivityPageReturn>(returnList, count, findActivityPage);

		logger.debug("findActivityPage(FindActivityPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}

	/**
	 * 查找所活动列表
	 */
	@Override
	public List<FindActivityPageReturn> findActivitys(FindActivityPage findActivityPage) throws TsfaServiceException {
		logger.debug("findActivitys(FindActivityPage findActivityPage={}) - start", findActivityPage); //$NON-NLS-1$
		AssertUtils.notNull(findActivityPage);
		List<FindActivityPageReturn> returnList;
		try {
			returnList = activityDao.findActivitys(findActivityPage);
			String uploadUrl =  localCacheSystemParams.getSystemParam(SystemAliasName.ms.toString(),SystemParamConstant.UPLOAD_GROUP, SystemParamConstant.UPLOAD_URL);
			/*处理活动链接*/
			for (FindActivityPageReturn findActivityReturnDto : returnList) {
				if(StringUtils.isEmpty(findActivityReturnDto.getLinkUrl())){
					String url = uploadUrl+PublicConstants.ACTIVITY_H5+"?code="+findActivityReturnDto.getCode();
					findActivityReturnDto.setLinkUrl(url);
					logger.debug("处理活动链接 ={}",url);
				}
			}
		} catch (Exception e) {
			logger.error("活动表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.ACTIVITY_FIND_PAGE_ERROR,"活动表信息分页查询错误.！",e);
		}
		logger.debug("findActivityDto(findActivityDto) - end - return value={}", returnList); //$NON-NLS-1$
		return returnList;
	}

	/**
	 * 点击量+1
	 */
	@Override
	public void updateActivityForRead(UpdateActivityForReadDto updateActivityForReadDto)throws TsfaServiceException {
		logger.debug("UpdateActivityForReadDto(UpdateActivityForReadDto UpdateActivityForReadDto={}) - start", updateActivityForReadDto); //$NON-NLS-1$
		AssertUtils.notNull(updateActivityForReadDto);
		AssertUtils.notNullAndEmpty(updateActivityForReadDto.getLinkUrl(),"网址链接不能为空");
		try {
			activityDao.updateActivityForRead(updateActivityForReadDto);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("活动表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACTIVITY_UPDATE_ERROR,"活动表信息更新信息错误！",e);
		}
	}


	@Override
	public void addActivityForShare(UpdateActivity updateActivity)
			throws TsfaServiceException {
		logger.debug("addActivityForShare(UpdateActivity updateActivity={}) - start", updateActivity); //$NON-NLS-1$
		AssertUtils.notNull(updateActivity);
		AssertUtils.notNullAndEmpty(updateActivity.getMerchantNo(),"商户编号不能为空");
		AssertUtils.notNullAndEmpty(updateActivity.getCode(),"活动编号不能为空");
		try {
			FindActivity findActivity = new FindActivity();
			 findActivity.setCode(updateActivity.getCode());;
			 FindActivityReturn findActivityReturn= this.findActivity(findActivity);
			 if(findActivityReturn==null){
				 logger.error("查找活动表信息错误！");
				 throw new TsfaServiceException(ErrorCode.ACTIVITY_FIND_ERROR,"查找活动表信息错误！");
			 }
			 Long shareCount= findActivityReturn.getShareCount();
			updateActivity.setShareCount(shareCount==null?1L:shareCount+1);
			this.updateActivity(updateActivity);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("分享信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACTIVITY_UPDATE_ERROR,"活动表信息更新信息错误！",e);
		}
	} 
}
