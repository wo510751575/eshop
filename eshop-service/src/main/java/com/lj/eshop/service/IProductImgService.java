package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ProductImgDto;
import com.lj.eshop.dto.FindProductImgPage;


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
public interface IProductImgService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品图片信息
	 *
	 * @param productImgDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addProductImg(ProductImgDto productImgDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品图片信息
	 *
	 * @param findProductImg
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ProductImgDto findProductImg(ProductImgDto productImgDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品图片信息
	 *
	 * @param findProductImgPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ProductImgDto>  findProductImgs(FindProductImgPage findProductImgPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品图片信息
	 *
	 * @param updateProductImg
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateProductImg(ProductImgDto productImgDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品图片信息
	 *
	 * @param findProductImgPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ProductImgDto> findProductImgPage(FindProductImgPage findProductImgPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据商品CODE批量修改商品图片信息
	 *
	 * @param updateProductImg
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-28
	 *
	 */
	public void updateProductImgByProductCode(ProductImgDto productImgDto)throws TsfaServiceException;

}
