package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.FlagDto;
import com.lj.eshop.dto.FindFlagPage;


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
public interface IFlagService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品标记信息
	 *
	 * @param flagDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addFlag(FlagDto flagDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品标记信息
	 *
	 * @param findFlag
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public FlagDto findFlag(FlagDto flagDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品标记信息
	 *
	 * @param findFlagPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<FlagDto>  findFlags(FindFlagPage findFlagPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品标记信息
	 *
	 * @param updateFlag
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateFlag(FlagDto flagDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品标记信息
	 *
	 * @param findFlagPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<FlagDto> findFlagPage(FindFlagPage findFlagPage) throws TsfaServiceException;
	

}
