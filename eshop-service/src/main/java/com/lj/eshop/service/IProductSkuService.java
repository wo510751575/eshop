package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ProductSkuDto;
import com.lj.eshop.dto.FindProductSkuPage;


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
public interface IProductSkuService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品SKU信息
	 *
	 * @param productSkuDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addProductSku(ProductSkuDto productSkuDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品SKU信息
	 *
	 * @param findProductSku
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ProductSkuDto findProductSku(ProductSkuDto productSkuDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品SKU信息
	 *
	 * @param findProductSkuPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ProductSkuDto>  findProductSkus(FindProductSkuPage findProductSkuPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品SKU信息
	 *
	 * @param updateProductSku
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateProductSku(ProductSkuDto productSkuDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品SKU信息
	 *
	 * @param findProductSkuPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ProductSkuDto> findProductSkuPage(FindProductSkuPage findProductSkuPage) throws TsfaServiceException;
	


	/**
	 * 
	 *
	 * 方法说明：修改商品SKU信息
	 *
	 * @param updateProductSku
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateProductSkuByProductCode(ProductSkuDto productSkuDto)throws TsfaServiceException;


	/**
	 * 
	 *
	 * 方法说明：终端使用，按供应商设置的 折扣比例计算提出，仅查需要的数据，比如成本价不查。
	 *
	 * @param findProductSkuPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-31
	 *
	 */
	public List<ProductSkuDto>  findMinProductSkus(FindProductSkuPage findProductSkuPage)throws TsfaServiceException;

}
