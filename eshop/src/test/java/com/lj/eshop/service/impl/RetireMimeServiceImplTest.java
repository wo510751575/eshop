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

import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.RetireMimeDto;
import com.lj.eshop.dto.FindRetireMimePage;
import com.lj.eshop.service.IRetireMimeService;

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
public class RetireMimeServiceImplTest extends SpringTestCase{

	@Resource
	IRetireMimeService retireMimeService;



	/**
	 * 
	 *
	 * 方法说明：添加退设备信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addRetireMime() throws TsfaServiceException{
		RetireMimeDto retireMimeDto = new RetireMimeDto();
		//add数据录入
		retireMimeDto.setCode("Code");
		retireMimeDto.setPhone("Phone");
		retireMimeDto.setMemberName("MemberName");
		retireMimeDto.setCellMime("CellMime");
		retireMimeDto.setExpressNo("ExpressNo");
		retireMimeDto.setExpressName("ExpressName");
		retireMimeDto.setCreateTime(new Date());
		retireMimeDto.setStatus("Status");
		retireMimeDto.setRemarks("Remarks");
		
		retireMimeService.addRetireMime(retireMimeDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改退设备信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateRetireMime() throws TsfaServiceException{
		RetireMimeDto retireMimeDto = new RetireMimeDto();
		//update数据录入
		retireMimeDto.setCode("Code");
		retireMimeDto.setPhone("Phone");
		retireMimeDto.setMemberName("MemberName");
		retireMimeDto.setCellMime("CellMime");
		retireMimeDto.setExpressNo("ExpressNo");
		retireMimeDto.setExpressName("ExpressName");
		retireMimeDto.setCreateTime(new Date());
		retireMimeDto.setStatus("Status");
		retireMimeDto.setRemarks("Remarks");

		retireMimeService.updateRetireMime(retireMimeDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找退设备信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findRetireMime() throws TsfaServiceException{
		RetireMimeDto findRetireMime = new RetireMimeDto();
		findRetireMime.setCode("111");
		retireMimeService.findRetireMime(findRetireMime);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找退设备信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findRetireMimePage() throws TsfaServiceException{
		FindRetireMimePage findRetireMimePage = new FindRetireMimePage();
		Page<RetireMimeDto> page = retireMimeService.findRetireMimePage(findRetireMimePage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找退设备信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findRetireMimes() throws TsfaServiceException{
		FindRetireMimePage findRetireMimePage = new FindRetireMimePage();
		List<RetireMimeDto> page = retireMimeService.findRetireMimes(findRetireMimePage);
		Assert.assertNotNull(page);
		
	}
	
}
