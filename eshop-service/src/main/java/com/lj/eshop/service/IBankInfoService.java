package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.BankInfoDto;
import com.lj.eshop.dto.FindBankInfoPage;


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
public interface IBankInfoService {
	
	/**
	 * 
	 *
	 * 方法说明：添加银行卡信息信息
	 *
	 * @param bankInfoDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addBankInfo(BankInfoDto bankInfoDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找银行卡信息信息
	 *
	 * @param findBankInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public BankInfoDto findBankInfo(BankInfoDto bankInfoDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询银行卡信息信息
	 *
	 * @param findBankInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<BankInfoDto>  findBankInfos(FindBankInfoPage findBankInfoPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改银行卡信息信息
	 *
	 * @param updateBankInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateBankInfo(BankInfoDto bankInfoDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询银行卡信息信息
	 *
	 * @param findBankInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<BankInfoDto> findBankInfoPage(FindBankInfoPage findBankInfoPage) throws TsfaServiceException;
	

}
