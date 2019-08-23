package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.SupplyDto;
import com.lj.eshop.dto.FindSupplyPage;


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
public interface ISupplyService {
	
	/**
	 * 
	 *
	 * 方法说明：添加供应商信息
	 *
	 * @param supplyDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addSupply(SupplyDto supplyDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找供应商信息
	 *
	 * @param findSupply
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public SupplyDto findSupply(SupplyDto supplyDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询供应商信息
	 *
	 * @param findSupplyPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<SupplyDto>  findSupplys(FindSupplyPage findSupplyPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改供应商信息
	 *
	 * @param updateSupply
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateSupply(SupplyDto supplyDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询供应商信息
	 *
	 * @param findSupplyPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<SupplyDto> findSupplyPage(FindSupplyPage findSupplyPage) throws TsfaServiceException;
	

}
