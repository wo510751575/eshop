package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ProductRuleDto;
import com.lj.eshop.dto.FindProductRulePage;


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
public interface IProductRuleService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品规格分类信息
	 *
	 * @param productRuleDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ProductRuleDto addProductRule(ProductRuleDto productRuleDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格分类信息
	 *
	 * @param findProductRule
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public ProductRuleDto findProductRule(ProductRuleDto productRuleDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品规格分类信息
	 *
	 * @param findProductRulePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<ProductRuleDto>  findProductRules(FindProductRulePage findProductRulePage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品规格分类信息
	 *
	 * @param updateProductRule
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateProductRule(ProductRuleDto productRuleDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品规格分类信息
	 *
	 * @param findProductRulePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<ProductRuleDto> findProductRulePage(FindProductRulePage findProductRulePage) throws TsfaServiceException;
	

}
