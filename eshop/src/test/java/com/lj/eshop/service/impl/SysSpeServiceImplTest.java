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

import com.lj.eshop.dto.SysSpeDto;
import com.lj.eshop.dto.FindSysSpePage;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.ISysSpeService;

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
public class SysSpeServiceImplTest extends SpringTestCase{

	@Resource
	ISysSpeService sysSpeService;



	/**
	 * 
	 *
	 * 方法说明：添加商品规格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addSysSpe() throws TsfaServiceException{
		SysSpeDto sysSpeDto = new SysSpeDto();
		//add数据录入
		sysSpeDto.setCode("Code");
		sysSpeDto.setSpeName("SpeName");
		sysSpeDto.setCreater("Creater");
		sysSpeDto.setStatus(Status.USE.getValue());
		sysSpeService.addSysSpe(sysSpeDto);
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品规格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateSysSpe() throws TsfaServiceException{
		SysSpeDto sysSpeDto = new SysSpeDto();
		//update数据录入
		sysSpeDto.setCode("Code");
		sysSpeDto.setSpeName("SpeName");
		sysSpeDto.setCreater("Creater");

		sysSpeService.updateSysSpe(sysSpeDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSysSpe() throws TsfaServiceException{
		SysSpeDto findSysSpe = new SysSpeDto();
		findSysSpe.setCode("111");
		sysSpeService.findSysSpe(findSysSpe);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSysSpePage() throws TsfaServiceException{
		FindSysSpePage findSysSpePage = new FindSysSpePage();
		Page<SysSpeDto> page = sysSpeService.findSysSpePage(findSysSpePage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSysSpes() throws TsfaServiceException{
		FindSysSpePage findSysSpePage = new FindSysSpePage();
		List<SysSpeDto> page = sysSpeService.findSysSpes(findSysSpePage);
		Assert.assertNotNull(page);
		
	}
	
}
