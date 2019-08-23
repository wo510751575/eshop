package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindAccountPage;


import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;

import java.util.List;
/**
 * 类说明：接口类
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
public interface IAccountService {
	
	/**
	 * 
	 *
	 * 方法说明：添加账户信息
	 *
	 * @param accountDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addAccount(AccountDto accountDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找账户信息
	 *
	 * @param findAccount
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public AccountDto findAccount(AccountDto accountDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询账户信息
	 *
	 * @param findAccountPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<AccountDto>  findAccounts(FindAccountPage findAccountPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改账户信息
	 *
	 * @param updateAccount
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateAccount(AccountDto accountDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询账户信息
	 *
	 * @param findAccountPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<AccountDto> findAccountPage(FindAccountPage findAccountPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据会员编号获取账户
	 *
	 * @param mbrCode
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月29日
	 *
	 */
	public AccountDto findAccountByMbrCode(String mbrCode) throws TsfaServiceException;
}
