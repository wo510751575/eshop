package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.MbrbankDto;
import com.lj.eshop.dto.FindMbrbankPage;


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
public interface IMbrbankService {
	
	/**
	 * 
	 *
	 * 方法说明：添加银行卡信息
	 *
	 * @param mbrbankDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addMbrbank(MbrbankDto mbrbankDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找银行卡信息
	 *
	 * @param findMbrbank
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public MbrbankDto findMbrbank(MbrbankDto mbrbankDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询银行卡信息
	 *
	 * @param findMbrbankPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<MbrbankDto>  findMbrbanks(FindMbrbankPage findMbrbankPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改银行卡信息
	 *
	 * @param updateMbrbank
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateMbrbank(MbrbankDto mbrbankDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询银行卡信息
	 *
	 * @param findMbrbankPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<MbrbankDto> findMbrbankPage(FindMbrbankPage findMbrbankPage) throws TsfaServiceException;
	

}
