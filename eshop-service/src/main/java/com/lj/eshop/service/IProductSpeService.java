package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ProductSpeDto;
import com.lj.eshop.dto.FindProductSpePage;


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
public interface IProductSpeService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品规格值信息
	 *
	 * @param productSpeDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ProductSpeDto addProductSpe(ProductSpeDto productSpeDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格值信息
	 *
	 * @param findProductSpe
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ProductSpeDto findProductSpe(ProductSpeDto productSpeDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品规格值信息
	 *
	 * @param findProductSpePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ProductSpeDto>  findProductSpes(FindProductSpePage findProductSpePage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品规格值信息
	 *
	 * @param updateProductSpe
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateProductSpe(ProductSpeDto productSpeDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品规格值信息
	 *
	 * @param findProductSpePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ProductSpeDto> findProductSpePage(FindProductSpePage findProductSpePage) throws TsfaServiceException;
	

}
