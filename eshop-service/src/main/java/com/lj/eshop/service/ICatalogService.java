package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.CatalogDto;
import com.lj.eshop.dto.FindCatalogPage;


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
public interface ICatalogService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品类目信息
	 *
	 * @param catalogDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public CatalogDto addCatalog(CatalogDto catalogDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品类目信息
	 *
	 * @param findCatalog
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public CatalogDto findCatalog(CatalogDto catalogDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品类目信息
	 *
	 * @param findCatalogPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<CatalogDto>  findCatalogs(FindCatalogPage findCatalogPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品类目信息
	 *
	 * @param updateCatalog
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateCatalog(CatalogDto catalogDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品类目信息
	 *
	 * @param findCatalogPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<CatalogDto> findCatalogPage(FindCatalogPage findCatalogPage) throws TsfaServiceException;
	

}
