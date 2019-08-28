package com.lj.business.member.service.impl;

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
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IBehaviorInfoPmDao;
import com.lj.business.member.domain.BehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.AddBehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.DelBehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmPage;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmPageReturn;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmReturn;
import com.lj.business.member.dto.behaviorInfoPm.UpdateBehaviorInfoPm;
import com.lj.business.member.service.IBehaviorInfoPmService;

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
public class BehaviorInfoPmServiceImpl implements IBehaviorInfoPmService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(BehaviorInfoPmServiceImpl.class);
	

	/** The behavior info pm dao. */
	@Resource
	private IBehaviorInfoPmDao behaviorInfoPmDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IBehaviorInfoPmService#addBehaviorInfoPm(com.lj.business.member.dto.behaviorInfoPm.AddBehaviorInfoPm)
	 */
	@Override
	public void addBehaviorInfoPm(
			AddBehaviorInfoPm addBehaviorInfoPm) throws TsfaServiceException {
		logger.debug("addBehaviorInfoPm(AddBehaviorInfoPm addBehaviorInfoPm={}) - start", addBehaviorInfoPm); 

		AssertUtils.notNull(addBehaviorInfoPm);
		try {
			BehaviorInfoPm behaviorInfoPm = new BehaviorInfoPm();
			//add数据录入
			behaviorInfoPm.setCode(GUID.getPreUUID());
			behaviorInfoPm.setMemberNo(addBehaviorInfoPm.getMemberNo());
			behaviorInfoPm.setMemberName(addBehaviorInfoPm.getMemberName());
			behaviorInfoPm.setBehaviorDesc(addBehaviorInfoPm.getBehaviorDesc());
			behaviorInfoPm.setBehaviorDate(addBehaviorInfoPm.getBehaviorDate());
			behaviorInfoPm.setBehaviorCode(addBehaviorInfoPm.getBehaviorCode());
			behaviorInfoPm.setRemark(addBehaviorInfoPm.getRemark());
			behaviorInfoPm.setRemark2(addBehaviorInfoPm.getRemark2());
			behaviorInfoPm.setRemark3(addBehaviorInfoPm.getRemark3());
			behaviorInfoPm.setRemark4(addBehaviorInfoPm.getRemark4());
			behaviorInfoPmDao.insert(behaviorInfoPm);
			logger.debug("addBehaviorInfoPm(AddBehaviorInfoPm) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户动态详情信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BEHAVIOR_INFO_PM_ADD_ERROR,"新增客户动态详情信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IBehaviorInfoPmService#delBehaviorInfoPm(com.lj.business.member.dto.behaviorInfoPm.DelBehaviorInfoPm)
	 */
	@Override
	public void delBehaviorInfoPm(
			DelBehaviorInfoPm delBehaviorInfoPm) throws TsfaServiceException {
		logger.debug("delBehaviorInfoPm(DelBehaviorInfoPm delBehaviorInfoPm={}) - start", delBehaviorInfoPm); 

		AssertUtils.notNull(delBehaviorInfoPm);
		AssertUtils.notNull(delBehaviorInfoPm.getCode(),"ID不能为空！");
		try {
			behaviorInfoPmDao.deleteByPrimaryKey(delBehaviorInfoPm.getCode());
			logger.debug("delBehaviorInfoPm(DelBehaviorInfoPm) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户动态详情信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BEHAVIOR_INFO_PM_DEL_ERROR,"删除客户动态详情信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IBehaviorInfoPmService#updateBehaviorInfoPm(com.lj.business.member.dto.behaviorInfoPm.UpdateBehaviorInfoPm)
	 */
	@Override
	public void updateBehaviorInfoPm(
			UpdateBehaviorInfoPm updateBehaviorInfoPm)
			throws TsfaServiceException {
		logger.debug("updateBehaviorInfoPm(UpdateBehaviorInfoPm updateBehaviorInfoPm={}) - start", updateBehaviorInfoPm); //$NON-NLS-1$

		AssertUtils.notNull(updateBehaviorInfoPm);
		AssertUtils.notNullAndEmpty(updateBehaviorInfoPm.getCode(),"ID不能为空");
		try {
			BehaviorInfoPm behaviorInfoPm = new BehaviorInfoPm();
			//update数据录入
			behaviorInfoPm.setCode(updateBehaviorInfoPm.getCode());
			behaviorInfoPm.setBehaviorDesc(updateBehaviorInfoPm.getBehaviorDesc());
			behaviorInfoPm.setBehaviorDate(updateBehaviorInfoPm.getBehaviorDate());
			behaviorInfoPm.setBehaviorCode(updateBehaviorInfoPm.getBehaviorCode());
			behaviorInfoPm.setRemark(updateBehaviorInfoPm.getRemark());
			behaviorInfoPm.setRemark2(updateBehaviorInfoPm.getRemark2());
			behaviorInfoPm.setRemark3(updateBehaviorInfoPm.getRemark3());
			behaviorInfoPm.setRemark4(updateBehaviorInfoPm.getRemark4());
			AssertUtils.notUpdateMoreThanOne(behaviorInfoPmDao.updateByPrimaryKeySelective(behaviorInfoPm));
			logger.debug("updateBehaviorInfoPm(UpdateBehaviorInfoPm) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户动态详情信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.BEHAVIOR_INFO_PM_UPDATE_ERROR,"客户动态详情信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IBehaviorInfoPmService#findBehaviorInfoPm(com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPm)
	 */
	@Override
	public FindBehaviorInfoPmReturn findBehaviorInfoPm(
			FindBehaviorInfoPm findBehaviorInfoPm) throws TsfaServiceException {
		logger.debug("findBehaviorInfoPm(FindBehaviorInfoPm findBehaviorInfoPm={}) - start", findBehaviorInfoPm); //$NON-NLS-1$

		AssertUtils.notNull(findBehaviorInfoPm);
		AssertUtils.notAllNull(findBehaviorInfoPm.getCode(),"ID不能为空");
		try {
			BehaviorInfoPm behaviorInfoPm = behaviorInfoPmDao.selectByPrimaryKey(findBehaviorInfoPm.getCode());
			if(behaviorInfoPm == null){
				throw new TsfaServiceException(ErrorCode.BEHAVIOR_INFO_PM_NOT_EXIST_ERROR,"客户动态详情信息不存在");
			}
			FindBehaviorInfoPmReturn findBehaviorInfoPmReturn = new FindBehaviorInfoPmReturn();
			//find数据录入
			findBehaviorInfoPmReturn.setCode(behaviorInfoPm.getCode());
			findBehaviorInfoPmReturn.setMemberNo(behaviorInfoPm.getMemberNo());
			findBehaviorInfoPmReturn.setMemberName(behaviorInfoPm.getMemberName());
			findBehaviorInfoPmReturn.setBehaviorDesc(behaviorInfoPm.getBehaviorDesc());
			findBehaviorInfoPmReturn.setBehaviorDate(behaviorInfoPm.getBehaviorDate());
			findBehaviorInfoPmReturn.setBehaviorCode(behaviorInfoPm.getBehaviorCode());
			findBehaviorInfoPmReturn.setCreateDate(behaviorInfoPm.getCreateDate());
			findBehaviorInfoPmReturn.setRemark(behaviorInfoPm.getRemark());
			findBehaviorInfoPmReturn.setRemark2(behaviorInfoPm.getRemark2());
			findBehaviorInfoPmReturn.setRemark3(behaviorInfoPm.getRemark3());
			findBehaviorInfoPmReturn.setRemark4(behaviorInfoPm.getRemark4());
			
			logger.debug("findBehaviorInfoPm(FindBehaviorInfoPm) - end - return value={}", findBehaviorInfoPmReturn); //$NON-NLS-1$
			return findBehaviorInfoPmReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户动态详情信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BEHAVIOR_INFO_PM_FIND_ERROR,"查找客户动态详情信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IBehaviorInfoPmService#findBehaviorInfoPmPage(com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmPage)
	 */
	@Override
	public Page<FindBehaviorInfoPmPageReturn> findBehaviorInfoPmPage(
			FindBehaviorInfoPmPage findBehaviorInfoPmPage)
			throws TsfaServiceException {
		logger.debug("findBehaviorInfoPmPage(FindBehaviorInfoPmPage findBehaviorInfoPmPage={}) - start", findBehaviorInfoPmPage); //$NON-NLS-1$

		AssertUtils.notNull(findBehaviorInfoPmPage);
		List<FindBehaviorInfoPmPageReturn> returnList;
		int count = 0;
		try {
			returnList = behaviorInfoPmDao.findBehaviorInfoPmPage(findBehaviorInfoPmPage);
			count = behaviorInfoPmDao.findBehaviorInfoPmPageCount(findBehaviorInfoPmPage);
		}  catch (Exception e) {
			logger.error("客户动态详情信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.BEHAVIOR_INFO_PM_FIND_PAGE_ERROR,"客户动态详情信息分页查询错误.！",e);
		}
		Page<FindBehaviorInfoPmPageReturn> returnPage = new Page<FindBehaviorInfoPmPageReturn>(returnList, count, findBehaviorInfoPmPage);

		logger.debug("findBehaviorInfoPmPage(FindBehaviorInfoPmPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
