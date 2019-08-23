package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.AddrsDto;
import com.lj.eshop.dto.FindAddrsPage;


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
public interface IAddrsService {
	
	/**
	 * 
	 *
	 * 方法说明：添加收货地址信息
	 *
	 * @param addrsDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addAddrs(AddrsDto addrsDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找收货地址信息
	 *
	 * @param findAddrs
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public AddrsDto findAddrs(AddrsDto addrsDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询收货地址信息
	 *
	 * @param findAddrsPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<AddrsDto>  findAddrss(FindAddrsPage findAddrsPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改收货地址信息
	 *
	 * @param updateAddrs
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateAddrs(AddrsDto addrsDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询收货地址信息
	 *
	 * @param findAddrsPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<AddrsDto> findAddrsPage(FindAddrsPage findAddrsPage) throws TsfaServiceException;
	
	/**
	 * 
	 * 方法说明： 修改地址通过商户code
	 *
	 * @param @param addrsDto
	 * @param @throws TsfaServiceException    设定文件 
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月4日
	 */
	public void updateAddrsByMbr(AddrsDto addrsDto)throws TsfaServiceException;
}
