package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.FindProductPage;
import com.lj.eshop.dto.UpdateProductCntDto;
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
public interface IProductService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品信息
	 *
	 * @param productDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ProductDto addProduct(ProductDto productDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品信息
	 *
	 * @param findProduct
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ProductDto findProduct(ProductDto productDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品信息
	 *
	 * @param findProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ProductDto>  findProducts(FindProductPage findProductPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品信息
	 *
	 * @param updateProduct
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateProduct(ProductDto productDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品信息
	 *
	 * @param findProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ProductDto> findProductPage(FindProductPage findProductPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：小B查询商品信息
	 *
	 * @param findProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017.08.30
	 *
	 */
	public Page<ProductDto> findIndexProductPage(FindProductPage findProductPage) throws TsfaServiceException;
	
	/**
	 * 方法说明：根据商品统计类型累加统计次数。
	 *
	 * @param updateProductCntDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy  2017年8月31日
	 *
	 */
	public int updateProductCntByType(UpdateProductCntDto updateProductCntDto )throws TsfaServiceException;
	
	
}
