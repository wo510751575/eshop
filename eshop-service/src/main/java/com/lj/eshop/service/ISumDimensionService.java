package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.SumDimensionDto;
import com.lj.eshop.dto.FindSumDimensionPage;


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
public interface ISumDimensionService {
	
	/**
	 * 
	 *
	 * 方法说明：添加统计维度信息
	 *
	 * @param sumDimensionDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addSumDimension(SumDimensionDto sumDimensionDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找统计维度信息
	 *
	 * @param findSumDimension
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public SumDimensionDto findSumDimension(SumDimensionDto sumDimensionDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询统计维度信息
	 *
	 * @param findSumDimensionPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<SumDimensionDto>  findSumDimensions(FindSumDimensionPage findSumDimensionPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改统计维度信息
	 *
	 * @param updateSumDimension
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateSumDimension(SumDimensionDto sumDimensionDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询统计维度信息
	 *
	 * @param findSumDimensionPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<SumDimensionDto> findSumDimensionPage(FindSumDimensionPage findSumDimensionPage) throws TsfaServiceException;
	

}
