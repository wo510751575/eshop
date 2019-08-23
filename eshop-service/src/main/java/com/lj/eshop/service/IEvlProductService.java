package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.EvlProductDto;
import com.lj.eshop.dto.FindEvlProductPage;


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
public interface IEvlProductService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品评价信息
	 *
	 * @param evlProductDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addEvlProduct(EvlProductDto evlProductDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品评价信息
	 *
	 * @param findEvlProduct
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public EvlProductDto findEvlProduct(EvlProductDto evlProductDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品评价信息
	 *
	 * @param findEvlProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<EvlProductDto>  findEvlProducts(FindEvlProductPage findEvlProductPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品评价信息
	 *
	 * @param updateEvlProduct
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateEvlProduct(EvlProductDto evlProductDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品评价信息
	 *
	 * @param findEvlProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<EvlProductDto> findEvlProductPage(FindEvlProductPage findEvlProductPage) throws TsfaServiceException;
	

}
