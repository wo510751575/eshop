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
import com.lj.business.member.dao.ICustKeepDao;
import com.lj.business.member.domain.CustKeep;
import com.lj.business.member.dto.custKeep.AddCustKeep;
import com.lj.business.member.dto.custKeep.DelCustKeep;
import com.lj.business.member.dto.custKeep.FindCustKeep;
import com.lj.business.member.dto.custKeep.FindCustKeepPage;
import com.lj.business.member.dto.custKeep.FindCustKeepPageReturn;
import com.lj.business.member.dto.custKeep.FindCustKeepReturn;
import com.lj.business.member.service.ICustKeepService;

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
public class CustKeepServiceImpl implements ICustKeepService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(CustKeepServiceImpl.class);
	

	/** The cust keep dao. */
	@Resource
	private ICustKeepDao custKeepDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.ICustKeepService#addCustKeep(com.lj.business.member.dto.custKeep.AddCustKeep)
	 */
	@Override
	public void addCustKeep(
			AddCustKeep addCustKeep) throws TsfaServiceException {
		logger.debug("addCustKeep(AddCustKeep addCustKeep={}) - start", addCustKeep); 

		AssertUtils.notNull(addCustKeep);
		try {
			CustKeep custKeep = new CustKeep();
			//add数据录入
			custKeep.setCode(GUID.getPreUUID());
			custKeep.setMerchantNo(addCustKeep.getMerchantNo());
			custKeep.setMemberNo(addCustKeep.getMemberNo());
			custKeep.setStatus(addCustKeep.getStatus());
			custKeepDao.insert(custKeep);
			logger.debug("addCustKeep(AddCustKeep) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户关注操作信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CUST_KEEP_ADD_ERROR,"新增客户关注操作信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.ICustKeepService#delCustKeep(com.lj.business.member.dto.custKeep.DelCustKeep)
	 */
	@Override
	public void delCustKeep(
			DelCustKeep delCustKeep) throws TsfaServiceException {
		logger.debug("delCustKeep(DelCustKeep delCustKeep={}) - start", delCustKeep); 

		AssertUtils.notNull(delCustKeep);
		AssertUtils.notNull(delCustKeep.getCode(),"Code不能为空！");
		try {
			custKeepDao.deleteByPrimaryKey(delCustKeep.getCode());
			logger.debug("delCustKeep(DelCustKeep) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户关注操作信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CUST_KEEP_DEL_ERROR,"删除客户关注操作信息错误！",e);

		}
	}


	

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.ICustKeepService#findCustKeep(com.lj.business.member.dto.custKeep.FindCustKeep)
	 */
	@Override
	public FindCustKeepReturn findCustKeep(
			FindCustKeep findCustKeep) throws TsfaServiceException {
		logger.debug("findCustKeep(FindCustKeep findCustKeep={}) - start", findCustKeep); //$NON-NLS-1$

		AssertUtils.notNull(findCustKeep);
		AssertUtils.notAllNull(findCustKeep.getCode(),"Code不能为空");
		try {
			CustKeep custKeep = custKeepDao.selectByPrimaryKey(findCustKeep.getCode());
			if(custKeep == null){
				throw new TsfaServiceException(ErrorCode.CUST_KEEP_NOT_EXIST_ERROR,"客户关注操作信息不存在");
			}
			FindCustKeepReturn findCustKeepReturn = new FindCustKeepReturn();
			//find数据录入
			findCustKeepReturn.setCode(custKeep.getCode());
			findCustKeepReturn.setMerchantNo(custKeep.getMerchantNo());
			findCustKeepReturn.setMemberNo(custKeep.getMemberNo());
			findCustKeepReturn.setCreateDate(custKeep.getCreateDate());
			findCustKeepReturn.setStatus(custKeep.getStatus());
			
			logger.debug("findCustKeep(FindCustKeep) - end - return value={}", findCustKeepReturn); //$NON-NLS-1$
			return findCustKeepReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户关注操作信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CUST_KEEP_FIND_ERROR,"查找客户关注操作信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.ICustKeepService#findCustKeepPage(com.lj.business.member.dto.custKeep.FindCustKeepPage)
	 */
	@Override
	public Page<FindCustKeepPageReturn> findCustKeepPage(
			FindCustKeepPage findCustKeepPage)
			throws TsfaServiceException {
		logger.debug("findCustKeepPage(FindCustKeepPage findCustKeepPage={}) - start", findCustKeepPage); //$NON-NLS-1$

		AssertUtils.notNull(findCustKeepPage);
		List<FindCustKeepPageReturn> returnList;
		int count = 0;
		try {
			returnList = custKeepDao.findCustKeepPage(findCustKeepPage);
			count = custKeepDao.findCustKeepPageCount(findCustKeepPage);
		}  catch (Exception e) {
			logger.error("客户关注操作信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.CUST_KEEP_FIND_PAGE_ERROR,"客户关注操作信息分页查询错误.！",e);
		}
		Page<FindCustKeepPageReturn> returnPage = new Page<FindCustKeepPageReturn>(returnList, count, findCustKeepPage);

		logger.debug("findCustKeepPage(FindCustKeepPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
