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
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.ILoginCheckDao;
import com.lj.business.member.domain.LoginCheck;
import com.lj.business.member.dto.AddLoginCheck;
import com.lj.business.member.dto.AddLoginCheckReturn;
import com.lj.business.member.dto.DelLoginCheck;
import com.lj.business.member.dto.DelLoginCheckReturn;
import com.lj.business.member.dto.FindLoginCheck;
import com.lj.business.member.dto.FindLoginCheckPage;
import com.lj.business.member.dto.FindLoginCheckPageReturn;
import com.lj.business.member.dto.FindLoginCheckReturn;
import com.lj.business.member.dto.UpdateLoginCheck;
import com.lj.business.member.dto.UpdateLoginCheckReturn;
import com.lj.business.member.service.ILoginCheckService;

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
public class LoginCheckServiceImpl implements ILoginCheckService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(LoginCheckServiceImpl.class);
	

	/** The login check dao. */
	@Resource
	private ILoginCheckDao loginCheckDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.ILoginCheckService#addLoginCheck(com.lj.business.member.dto.AddLoginCheck)
	 */
	@Override
	public AddLoginCheckReturn addLoginCheck(
			AddLoginCheck addLoginCheck) throws TsfaServiceException {
		logger.debug("addLoginCheck(AddLoginCheck addLoginCheck={}) - start", addLoginCheck); 

		AssertUtils.notNull(addLoginCheck);
		try {
			LoginCheck loginCheck = new LoginCheck();
			//add数据录入
			loginCheck.setCode(addLoginCheck.getCode());
			loginCheck.setMemberNo(addLoginCheck.getMemberNo());
			loginCheck.setMemberType(addLoginCheck.getMemberType());
			loginCheck.setLockStatus(addLoginCheck.getLockStatus());
			loginCheck.setLastLoginDate(addLoginCheck.getLastLoginDate());
			loginCheck.setCycleLoginFailTimes(addLoginCheck.getCycleLoginFailTimes());
			loginCheck.setLastLoginErrorDate(addLoginCheck.getLastLoginErrorDate());
			loginCheck.setUpdateId(addLoginCheck.getUpdateId());
			loginCheck.setUpdateDate(addLoginCheck.getUpdateDate());
			loginCheckDao.insertSelective(loginCheck);
			AddLoginCheckReturn addLoginCheckReturn = new AddLoginCheckReturn();
			
			logger.debug("addLoginCheck(AddLoginCheck) - end - return value={}", addLoginCheckReturn); 
			return addLoginCheckReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增登录检查表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.LOGIN_CHECK_ADD_ERROR,"新增登录检查表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.ILoginCheckService#delLoginCheck(com.lj.business.member.dto.DelLoginCheck)
	 */
	@Override
	public DelLoginCheckReturn delLoginCheck(
			DelLoginCheck delLoginCheck) throws TsfaServiceException {
		logger.debug("delLoginCheck(DelLoginCheck delLoginCheck={}) - start", delLoginCheck); 

		AssertUtils.notNull(delLoginCheck);
		AssertUtils.notNull(delLoginCheck.getCode(),"ID不能为空！");
		try {
			loginCheckDao.deleteByPrimaryKey(delLoginCheck.getCode());
			DelLoginCheckReturn delLoginCheckReturn  = new DelLoginCheckReturn();

			logger.debug("delLoginCheck(DelLoginCheck) - end - return value={}", delLoginCheckReturn); //$NON-NLS-1$
			return delLoginCheckReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除登录检查表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.LOGIN_CHECK_DEL_ERROR,"删除登录检查表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.ILoginCheckService#updateLoginCheck(com.lj.business.member.dto.UpdateLoginCheck)
	 */
	@Override
	public UpdateLoginCheckReturn updateLoginCheck(
			UpdateLoginCheck updateLoginCheck)
			throws TsfaServiceException {
		logger.debug("updateLoginCheck(UpdateLoginCheck updateLoginCheck={}) - start", updateLoginCheck); //$NON-NLS-1$

		AssertUtils.notNull(updateLoginCheck);
		AssertUtils.notNullAndEmpty(updateLoginCheck.getCode(),"ID不能为空");
		try {
			LoginCheck loginCheck = new LoginCheck();
			//update数据录入
			loginCheck.setCode(updateLoginCheck.getCode());
			loginCheck.setMemberNo(updateLoginCheck.getMemberNo());
			loginCheck.setMemberType(updateLoginCheck.getMemberType());
			loginCheck.setLockStatus(updateLoginCheck.getLockStatus());
			loginCheck.setLastLoginDate(updateLoginCheck.getLastLoginDate());
			loginCheck.setCycleLoginFailTimes(updateLoginCheck.getCycleLoginFailTimes());
			loginCheck.setLastLoginErrorDate(updateLoginCheck.getLastLoginErrorDate());
			loginCheck.setUpdateId(updateLoginCheck.getUpdateId());
			loginCheck.setUpdateDate(updateLoginCheck.getUpdateDate());
			AssertUtils.notUpdateMoreThanOne(loginCheckDao.updateByPrimaryKeySelective(loginCheck));
			UpdateLoginCheckReturn updateLoginCheckReturn = new UpdateLoginCheckReturn();

			logger.debug("updateLoginCheck(UpdateLoginCheck) - end - return value={}", updateLoginCheckReturn); //$NON-NLS-1$
			return updateLoginCheckReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("登录检查表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.LOGIN_CHECK_UPDATE_ERROR,"登录检查表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.ILoginCheckService#findLoginCheck(com.lj.business.member.dto.FindLoginCheck)
	 */
	@Override
	public FindLoginCheckReturn findLoginCheck(
			FindLoginCheck findLoginCheck) throws TsfaServiceException {
		logger.debug("findLoginCheck(FindLoginCheck findLoginCheck={}) - start", findLoginCheck); //$NON-NLS-1$

		AssertUtils.notNull(findLoginCheck);
		AssertUtils.notAllNull(findLoginCheck.getCode(),"ID不能为空");
		try {
			LoginCheck loginCheck = loginCheckDao.selectByPrimaryKey(findLoginCheck.getCode());
			if(loginCheck == null){
				throw new TsfaServiceException(ErrorCode.LOGIN_CHECK_NOT_EXIST_ERROR,"登录检查表信息不存在");
			}
			FindLoginCheckReturn findLoginCheckReturn = new FindLoginCheckReturn();
			//find数据录入
			findLoginCheckReturn.setCode(loginCheck.getCode());
			findLoginCheckReturn.setMemberNo(loginCheck.getMemberNo());
			findLoginCheckReturn.setMemberType(loginCheck.getMemberType());
			findLoginCheckReturn.setLockStatus(loginCheck.getLockStatus());
			findLoginCheckReturn.setLastLoginDate(loginCheck.getLastLoginDate());
			findLoginCheckReturn.setCycleLoginFailTimes(loginCheck.getCycleLoginFailTimes());
			findLoginCheckReturn.setLastLoginErrorDate(loginCheck.getLastLoginErrorDate());
			findLoginCheckReturn.setUpdateId(loginCheck.getUpdateId());
			findLoginCheckReturn.setUpdateDate(loginCheck.getUpdateDate());
			
			logger.debug("findLoginCheck(FindLoginCheck) - end - return value={}", findLoginCheckReturn); //$NON-NLS-1$
			return findLoginCheckReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找登录检查表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.LOGIN_CHECK_FIND_ERROR,"查找登录检查表信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.ILoginCheckService#findLoginCheckPage(com.lj.business.member.dto.FindLoginCheckPage)
	 */
	@Override
	public Page<FindLoginCheckPageReturn> findLoginCheckPage(
			FindLoginCheckPage findLoginCheckPage)
			throws TsfaServiceException {
		logger.debug("findLoginCheckPage(FindLoginCheckPage findLoginCheckPage={}) - start", findLoginCheckPage); //$NON-NLS-1$

		AssertUtils.notNull(findLoginCheckPage);
		List<FindLoginCheckPageReturn> returnList;
		int count = 0;
		try {
			returnList = loginCheckDao.findLoginCheckPage(findLoginCheckPage);
			count = loginCheckDao.findLoginCheckPageCount(findLoginCheckPage);
		}  catch (Exception e) {
			logger.error("商户表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.LOGIN_CHECK_FIND_PAGE_ERROR,"商户表信息分页查询错误.！",e);
		}
		Page<FindLoginCheckPageReturn> returnPage = new Page<FindLoginCheckPageReturn>(returnList, count, findLoginCheckPage);

		logger.debug("findLoginCheckPage(FindLoginCheckPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.ILoginCheckService#findLoginCheck(com.lj.business.member.domain.LoginCheck)
	 */
	@Override
	public LoginCheck findLoginCheck(LoginCheck record)
			throws TsfaServiceException {

		AssertUtils.notNull(record);
		try {
			LoginCheck loginCheck = loginCheckDao.findLoginCheck(record);
			if(loginCheck == null){
				throw new TsfaServiceException(ErrorCode.LOGIN_CHECK_NOT_EXIST_ERROR,"登录检查表信息不存在");
			}
			FindLoginCheckReturn findLoginCheckReturn = new FindLoginCheckReturn();
			//find数据录入
			findLoginCheckReturn.setCode(loginCheck.getCode());
			findLoginCheckReturn.setMemberNo(loginCheck.getMemberNo());
			findLoginCheckReturn.setMemberType(loginCheck.getMemberType());
			findLoginCheckReturn.setLockStatus(loginCheck.getLockStatus());
			findLoginCheckReturn.setLastLoginDate(loginCheck.getLastLoginDate());
			findLoginCheckReturn.setCycleLoginFailTimes(loginCheck.getCycleLoginFailTimes());
			findLoginCheckReturn.setLastLoginErrorDate(loginCheck.getLastLoginErrorDate());
			findLoginCheckReturn.setUpdateId(loginCheck.getUpdateId());
			findLoginCheckReturn.setUpdateDate(loginCheck.getUpdateDate());
			
			return loginCheck;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找登录检查表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.LOGIN_CHECK_FIND_ERROR,"查找登录检查表信息信息错误！",e);
		}
	}
}
