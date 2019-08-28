package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;

import java.util.List;

import com.lj.eshop.dto.SumDimensionDto;
import com.lj.eshop.dto.FindSumDimensionPage;
import com.lj.eshop.service.ISumDimensionService;

/**
 * 类说明：测试类
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
public class SumDimensionServiceImplTest extends SpringTestCase{

	@Resource
	ISumDimensionService sumDimensionService;



	/**
	 * 
	 *
	 * 方法说明：添加统计维度信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addSumDimension() throws TsfaServiceException{
		SumDimensionDto sumDimensionDto = new SumDimensionDto();
		//add数据录入
		sumDimensionDto.setCode("Code");
		sumDimensionDto.setName("Name");
		sumDimensionDto.setRemarks("Remarks");
		sumDimensionDto.setStatus("Status");
		
		sumDimensionService.addSumDimension(sumDimensionDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改统计维度信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateSumDimension() throws TsfaServiceException{
		SumDimensionDto sumDimensionDto = new SumDimensionDto();
		//update数据录入
		sumDimensionDto.setCode("Code");
		sumDimensionDto.setName("Name");
		sumDimensionDto.setRemarks("Remarks");
		sumDimensionDto.setStatus("Status");

		sumDimensionService.updateSumDimension(sumDimensionDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找统计维度信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSumDimension() throws TsfaServiceException{
		SumDimensionDto findSumDimension = new SumDimensionDto();
		findSumDimension.setCode("111");
		sumDimensionService.findSumDimension(findSumDimension);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找统计维度信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSumDimensionPage() throws TsfaServiceException{
		FindSumDimensionPage findSumDimensionPage = new FindSumDimensionPage();
		Page<SumDimensionDto> page = sumDimensionService.findSumDimensionPage(findSumDimensionPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找统计维度信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSumDimensions() throws TsfaServiceException{
		FindSumDimensionPage findSumDimensionPage = new FindSumDimensionPage();
		List<SumDimensionDto> page = sumDimensionService.findSumDimensions(findSumDimensionPage);
		Assert.assertNotNull(page);
		
	}
	
}
