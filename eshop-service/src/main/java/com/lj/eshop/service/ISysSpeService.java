package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.SysSpeDto;
import com.lj.eshop.dto.FindSysSpePage;


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
public interface ISysSpeService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品规格信息
	 *
	 * @param sysSpeDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addSysSpe(SysSpeDto sysSpeDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格信息
	 *
	 * @param findSysSpe
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public SysSpeDto findSysSpe(SysSpeDto sysSpeDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品规格信息
	 *
	 * @param findSysSpePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<SysSpeDto>  findSysSpes(FindSysSpePage findSysSpePage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品规格信息
	 *
	 * @param updateSysSpe
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateSysSpe(SysSpeDto sysSpeDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品规格信息
	 *
	 * @param findSysSpePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<SysSpeDto> findSysSpePage(FindSysSpePage findSysSpePage) throws TsfaServiceException;
	

}
