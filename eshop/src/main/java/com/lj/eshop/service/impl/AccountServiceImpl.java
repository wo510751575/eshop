package com.lj.eshop.service.impl;

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
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dao.IAccountDao;
import com.lj.eshop.domain.Account;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindAccountPage;
import com.lj.eshop.service.IAccountService;
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
public class AccountServiceImpl implements IAccountService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	

	@Resource
	private IAccountDao accountDao;
	
	
	@Override
	public void addAccount(
			AccountDto accountDto) throws TsfaServiceException {
		logger.debug("addAccount(AddAccount addAccount={}) - start", accountDto); 

		AssertUtils.notNull(accountDto);
		try {
			Account account = new Account();
			//add数据录入
			account.setCode(GUID.generateCode());
			account.setAccNo(NoUtil.generateNo(NoUtil.JY));
			account.setMbrCode(accountDto.getMbrCode());
			account.setCashAmt(accountDto.getCashAmt());
			account.setTotalWithdrawAmt(accountDto.getTotalWithdrawAmt());
			account.setRankCashAmt(accountDto.getRankCashAmt());
			account.setType(accountDto.getType());
			account.setStatus(accountDto.getStatus());
			account.setFreeAmt(accountDto.getFreeAmt());
			account.setPayPwd(accountDto.getPayPwd());
			account.setUpdateTime(accountDto.getUpdateTime());
			account.setCreater(accountDto.getCreater());
			account.setCreateTime(new Date());
			account.setWrongCnt(accountDto.getWrongCnt());
			account.setWrongTime(accountDto.getWrongTime());
			account.setPayedAmount(accountDto.getPayedAmount());
			accountDao.insertSelective(account);
			logger.debug("addAccount(AccountDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增账户信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACCOUNT_ADD_ERROR,"新增账户信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询账户信息
	 *
	 * @param findAccountPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<AccountDto>  findAccounts(FindAccountPage findAccountPage)throws TsfaServiceException{
		AssertUtils.notNull(findAccountPage);
		List<AccountDto> returnList=null;
		try {
			returnList = accountDao.findAccounts(findAccountPage);
		} catch (Exception e) {
			logger.error("查找账户信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ACCOUNT_NOT_EXIST_ERROR,"账户信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateAccount(
			AccountDto accountDto)
			throws TsfaServiceException {
		logger.debug("updateAccount(AccountDto accountDto={}) - start", accountDto); //$NON-NLS-1$

		AssertUtils.notNull(accountDto);
		AssertUtils.notNullAndEmpty(accountDto.getCode(),"Code不能为空");
		try {
			Account account = new Account();
			//update数据录入
			account.setCode(accountDto.getCode());
			account.setAccNo(accountDto.getAccNo());
			account.setMbrCode(accountDto.getMbrCode());
			account.setCashAmt(accountDto.getCashAmt());
			account.setTotalWithdrawAmt(accountDto.getTotalWithdrawAmt());
			account.setRankCashAmt(accountDto.getRankCashAmt());
			account.setType(accountDto.getType());
			account.setStatus(accountDto.getStatus());
			account.setFreeAmt(accountDto.getFreeAmt());
			account.setPayPwd(accountDto.getPayPwd());
			account.setUpdateTime(new Date());
			account.setWrongCnt(accountDto.getWrongCnt());
			account.setWrongTime(accountDto.getWrongTime());
			account.setPayedAmount(accountDto.getPayedAmount());
			AssertUtils.notUpdateMoreThanOne(accountDao.updateByPrimaryKeySelective(account));
			logger.debug("updateAccount(AccountDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("账户信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACCOUNT_UPDATE_ERROR,"账户信息更新信息错误！",e);
		}
	}

	

	@Override
	public AccountDto findAccount(
			AccountDto accountDto) throws TsfaServiceException {
		logger.debug("findAccount(FindAccount findAccount={}) - start", accountDto); //$NON-NLS-1$

		AssertUtils.notNull(accountDto);
		AssertUtils.notAllNull(accountDto.getCode(),"Code不能为空");
		try {
			Account account = accountDao.selectByPrimaryKey(accountDto.getCode());
			if(account == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.ACCOUNT_NOT_EXIST_ERROR,"账户信息不存在");
			}
			AccountDto findAccountReturn = new AccountDto();
			//find数据录入
			findAccountReturn.setCode(account.getCode());
			findAccountReturn.setAccNo(account.getAccNo());
			findAccountReturn.setMbrCode(account.getMbrCode());
			findAccountReturn.setCashAmt(account.getCashAmt());
			findAccountReturn.setTotalWithdrawAmt(account.getTotalWithdrawAmt());
			findAccountReturn.setRankCashAmt(account.getRankCashAmt());
			findAccountReturn.setType(account.getType());
			findAccountReturn.setStatus(account.getStatus());
			findAccountReturn.setFreeAmt(account.getFreeAmt());
			findAccountReturn.setPayPwd(account.getPayPwd());
			findAccountReturn.setUpdateTime(account.getUpdateTime());
			findAccountReturn.setCreater(account.getCreater());
			findAccountReturn.setCreateTime(account.getCreateTime());
			findAccountReturn.setWrongCnt(account.getWrongCnt());
			findAccountReturn.setWrongTime(account.getWrongTime());
			findAccountReturn.setPayedAmount(account.getPayedAmount());
			logger.debug("findAccount(AccountDto) - end - return value={}", findAccountReturn); //$NON-NLS-1$
			return findAccountReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找账户信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACCOUNT_FIND_ERROR,"查找账户信息信息错误！",e);
		}


	}

	
	@Override
	public Page<AccountDto> findAccountPage(
			FindAccountPage findAccountPage)
			throws TsfaServiceException {
		logger.debug("findAccountPage(FindAccountPage findAccountPage={}) - start", findAccountPage); //$NON-NLS-1$

		AssertUtils.notNull(findAccountPage);
		List<AccountDto> returnList=null;
		int count = 0;
		try {
		 	returnList = accountDao.findAccountPage(findAccountPage);
		 	count = accountDao.findAccountPageCount(findAccountPage);
		}  catch (Exception e) {
			logger.error("账户信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.ACCOUNT_FIND_PAGE_ERROR,"账户信息不存在错误.！",e);
		}
		Page<AccountDto> returnPage = new Page<AccountDto>(returnList, count, findAccountPage);

		logger.debug("findAccountPage(FindAccountPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	public AccountDto findAccountByMbrCode(String mbrCode)
			throws TsfaServiceException {
		AssertUtils.notNullAndEmpty(mbrCode,"会员编号不能为空");
		List<AccountDto> returnList=null;
		try {
			AccountDto param = new AccountDto();
			param.setMbrCode(mbrCode);
			FindAccountPage findAccountPage = new FindAccountPage();
			findAccountPage.setParam(param);
			returnList = accountDao.findAccounts(findAccountPage);
			if(returnList.size()<=0){
				logger.error("查找账户信息信息错误！");
				throw new TsfaServiceException(ErrorCode.ACCOUNT_NOT_EXIST_ERROR,"账户信息不存在");
			}
		} catch (Exception e) {
			logger.error("查找账户信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ACCOUNT_NOT_EXIST_ERROR,"账户信息不存在");
		}
		return returnList.get(0);
	} 


}
