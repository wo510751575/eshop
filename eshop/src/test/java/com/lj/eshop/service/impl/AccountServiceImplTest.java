package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;

import java.math.BigDecimal;
import java.util.List;

import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindAccountPage;
import com.lj.eshop.service.IAccountService;

/**
 * 类说明：测试类
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
public class AccountServiceImplTest extends SpringTestCase{

	@Resource
	IAccountService accountService;



	/**
	 * 
	 *
	 * 方法说明：添加账户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addAccount() throws TsfaServiceException{
		AccountDto accountDto = new AccountDto();
		//add数据录入
		accountDto.setAccNo("AccNo1");
		accountDto.setCashAmt(new BigDecimal(0));
		accountDto.setTotalWithdrawAmt(new BigDecimal(0));
		accountDto.setRankCashAmt(new BigDecimal("10"));
		accountDto.setType("0");
		accountDto.setStatus("1");
		accountDto.setFreeAmt(new BigDecimal(0));
		accountDto.setPayPwd("PayPwd");
		accountDto.setCreater("Creater");
		accountDto.setMbrCode("1111111111");
		accountService.addAccount(accountDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改账户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateAccount() throws TsfaServiceException{
		AccountDto accountDto = new AccountDto();
		//update数据录入
		accountDto.setCode("LJ_ed6b67d3c4c14b47b1c8a7ebcde2f7c8");
		accountDto.setAccNo("AccNo");
		accountDto.setMbrCode("MbrCode");
		accountDto.setCashAmt(new BigDecimal(0));
		accountDto.setTotalWithdrawAmt(new BigDecimal(0));
		accountDto.setRankCashAmt(new BigDecimal(1000d));
		accountDto.setType("0");
		accountDto.setStatus("1");
		accountDto.setFreeAmt(new BigDecimal(0));
		accountDto.setPayPwd("PayPwd");
		accountDto.setCreater("Creater");

		accountService.updateAccount(accountDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找账户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findAccount() throws TsfaServiceException{
		AccountDto findAccount = new AccountDto();
		findAccount.setCode("111");
		accountService.findAccount(findAccount);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找账户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findAccountPage() throws TsfaServiceException{
		FindAccountPage findAccountPage = new FindAccountPage();
		Page<AccountDto> page = accountService.findAccountPage(findAccountPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找账户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findAccounts() throws TsfaServiceException{
		AccountDto param = new AccountDto();
		param.setMbrCode("LJ_1eb863856573406c956c0478abf47a72");
		FindAccountPage findAccountPage = new FindAccountPage();
		findAccountPage.setParam(param);
		
		List<AccountDto> page = accountService.findAccounts(findAccountPage);
		Assert.assertNotNull(page);
		
	}
	
}
