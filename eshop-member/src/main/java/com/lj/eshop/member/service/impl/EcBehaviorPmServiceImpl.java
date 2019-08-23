/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.member.service.impl;

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
import com.lj.business.member.dao.IBehaviorPmDao;
import com.lj.business.member.domain.BehaviorPm;
import com.lj.business.member.dto.behaviorPm.AddBehaviorPm;
import com.lj.business.member.dto.behaviorPm.DelBehaviorPm;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPm;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmPage;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmPageReturn;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmReturn;
import com.lj.business.member.dto.behaviorPm.UpdateBehaviorPm;
import com.lj.eshop.member.service.IEcBehaviorPmService;

/**
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月18日
 */
@Service
public class EcBehaviorPmServiceImpl implements IEcBehaviorPmService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(EcBehaviorPmServiceImpl.class);
	

	/** The behavior pm dao. */
	@Resource
	private IBehaviorPmDao behaviorPmDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IBehaviorPmService#addBehaviorPm(com.lj.business.member.dto.behaviorPm.AddBehaviorPm)
	 */
	@Override
	public void addBehaviorPm(
			AddBehaviorPm addBehaviorPm) throws TsfaServiceException {
		logger.debug("addBehaviorPm(AddBehaviorPm addBehaviorPm={}) - start", addBehaviorPm); 

		AssertUtils.notNull(addBehaviorPm);
		try {
			BehaviorPm behaviorPm = new BehaviorPm();
			//add数据录入
			behaviorPm.setCode(GUID.getPreUUID());
			behaviorPm.setMemberNo(addBehaviorPm.getMemberNo());
			behaviorPm.setMemberName(addBehaviorPm.getMemberName());
			behaviorPm.setBehaviorDesc(addBehaviorPm.getBehaviorDesc());
			behaviorPm.setBehaviorDate(addBehaviorPm.getBehaviorDate());
			behaviorPm.setRemark(addBehaviorPm.getRemark());
			behaviorPm.setRemark2(addBehaviorPm.getRemark2());
			behaviorPm.setRemark3(addBehaviorPm.getRemark3());
			behaviorPm.setRemark4(addBehaviorPm.getRemark4());
			behaviorPmDao.insert(behaviorPm);
			logger.debug("addBehaviorPm(AddBehaviorPm) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户最近动态信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BEHAVIOR_PM_ADD_ERROR,"新增客户最近动态信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IBehaviorPmService#delBehaviorPm(com.lj.business.member.dto.behaviorPm.DelBehaviorPm)
	 */
	@Override
	public void delBehaviorPm(
			DelBehaviorPm delBehaviorPm) throws TsfaServiceException {
		logger.debug("delBehaviorPm(DelBehaviorPm delBehaviorPm={}) - start", delBehaviorPm); 

		AssertUtils.notNull(delBehaviorPm);
		AssertUtils.notNull(delBehaviorPm.getCode(),"Code不能为空！");
		try {
			behaviorPmDao.deleteByPrimaryKey(delBehaviorPm.getCode());
			logger.debug("delBehaviorPm(DelBehaviorPm) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户最近动态信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BEHAVIOR_PM_DEL_ERROR,"删除客户最近动态信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IBehaviorPmService#updateBehaviorPm(com.lj.business.member.dto.behaviorPm.UpdateBehaviorPm)
	 */
	@Override
	public void updateBehaviorPm(
			UpdateBehaviorPm updateBehaviorPm)
			throws TsfaServiceException {
		logger.debug("updateBehaviorPm(UpdateBehaviorPm updateBehaviorPm={}) - start", updateBehaviorPm); //$NON-NLS-1$

		AssertUtils.notNull(updateBehaviorPm);
		AssertUtils.notNullAndEmpty(updateBehaviorPm.getMemberNo(),"会员号不能为空");
		try {
			BehaviorPm behaviorPm = new BehaviorPm();
			//update数据录入
			behaviorPm.setMemberNo(updateBehaviorPm.getMemberNo());
			behaviorPm.setBehaviorDesc(updateBehaviorPm.getBehaviorDesc());
			behaviorPm.setBehaviorDate(updateBehaviorPm.getBehaviorDate());
			behaviorPm.setRemark(updateBehaviorPm.getRemark());
			behaviorPm.setRemark2(updateBehaviorPm.getRemark2());
			behaviorPm.setRemark3(updateBehaviorPm.getRemark3());
			behaviorPm.setRemark4(updateBehaviorPm.getRemark4());
			AssertUtils.notUpdateMoreThanOne(behaviorPmDao.updateByPrimaryKeySelective(behaviorPm));
			logger.debug("updateBehaviorPm(UpdateBehaviorPm) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户最近动态信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.BEHAVIOR_PM_UPDATE_ERROR,"客户最近动态信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IBehaviorPmService#findBehaviorPm(com.lj.business.member.dto.behaviorPm.FindBehaviorPm)
	 */
	@Override
	public FindBehaviorPmReturn findBehaviorPm(
			FindBehaviorPm findBehaviorPm) throws TsfaServiceException {
		logger.debug("findBehaviorPm(FindBehaviorPm findBehaviorPm={}) - start", findBehaviorPm); //$NON-NLS-1$

		AssertUtils.notNull(findBehaviorPm);
		AssertUtils.notAllNullAndEmpty(findBehaviorPm.getCode(), findBehaviorPm.getMemberNo(),"Code,会员编号不能同时不能为空");
		try {
			BehaviorPm behaviorPmQuery = new BehaviorPm();
			behaviorPmQuery.setCode(findBehaviorPm.getCode());
			behaviorPmQuery.setMemberNo(findBehaviorPm.getMemberNo());
			BehaviorPm behaviorPm = behaviorPmDao.selectByParamKey(behaviorPmQuery );
			if(behaviorPm == null){
				throw new TsfaServiceException(ErrorCode.BEHAVIOR_PM_NOT_EXIST_ERROR,"客户最近动态信息不存在");
			}
			FindBehaviorPmReturn findBehaviorPmReturn = new FindBehaviorPmReturn();
			//find数据录入
			findBehaviorPmReturn.setCode(behaviorPm.getCode());
			findBehaviorPmReturn.setMemberNo(behaviorPm.getMemberNo());
			findBehaviorPmReturn.setMemberName(behaviorPm.getMemberName());
			findBehaviorPmReturn.setBehaviorDesc(behaviorPm.getBehaviorDesc());
			findBehaviorPmReturn.setBehaviorDate(behaviorPm.getBehaviorDate());
			findBehaviorPmReturn.setCreateDate(behaviorPm.getCreateDate());
			findBehaviorPmReturn.setRemark(behaviorPm.getRemark());
			findBehaviorPmReturn.setRemark2(behaviorPm.getRemark2());
			findBehaviorPmReturn.setRemark3(behaviorPm.getRemark3());
			findBehaviorPmReturn.setRemark4(behaviorPm.getRemark4());
			
			logger.debug("findBehaviorPm(FindBehaviorPm) - end - return value={}", findBehaviorPmReturn); //$NON-NLS-1$
			return findBehaviorPmReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户最近动态信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BEHAVIOR_PM_FIND_ERROR,"查找客户最近动态信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IBehaviorPmService#findBehaviorPmPage(com.lj.business.member.dto.behaviorPm.FindBehaviorPmPage)
	 */
	@Override
	public Page<FindBehaviorPmPageReturn> findBehaviorPmPage(
			FindBehaviorPmPage findBehaviorPmPage)
			throws TsfaServiceException {
		logger.debug("findBehaviorPmPage(FindBehaviorPmPage findBehaviorPmPage={}) - start", findBehaviorPmPage); //$NON-NLS-1$

		AssertUtils.notNull(findBehaviorPmPage);
		List<FindBehaviorPmPageReturn> returnList;
		int count = 0;
		try {
			returnList = behaviorPmDao.findBehaviorPmPage(findBehaviorPmPage);
			count = behaviorPmDao.findBehaviorPmPageCount(findBehaviorPmPage);
		}  catch (Exception e) {
			logger.error("客户最近动态信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.BEHAVIOR_PM_FIND_PAGE_ERROR,"客户最近动态信息分页查询错误.！",e);
		}
		Page<FindBehaviorPmPageReturn> returnPage = new Page<FindBehaviorPmPageReturn>(returnList, count, findBehaviorPmPage);

		logger.debug("findBehaviorPmPage(FindBehaviorPmPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
