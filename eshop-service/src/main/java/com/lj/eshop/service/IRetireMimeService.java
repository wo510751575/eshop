package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.RetireMimeDto;
import com.lj.eshop.dto.FindRetireMimePage;


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
public interface IRetireMimeService {
	
	/**
	 * 
	 *
	 * 方法说明：添加退设备信息
	 *
	 * @param retireMimeDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addRetireMime(RetireMimeDto retireMimeDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找退设备信息
	 *
	 * @param findRetireMime
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public RetireMimeDto findRetireMime(RetireMimeDto retireMimeDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询退设备信息
	 *
	 * @param findRetireMimePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<RetireMimeDto>  findRetireMimes(FindRetireMimePage findRetireMimePage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改退设备信息
	 *
	 * @param updateRetireMime
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateRetireMime(RetireMimeDto retireMimeDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询退设备信息
	 *
	 * @param findRetireMimePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<RetireMimeDto> findRetireMimePage(FindRetireMimePage findRetireMimePage) throws TsfaServiceException;
	

}
