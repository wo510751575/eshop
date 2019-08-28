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

import com.lj.eshop.dto.FlagDto;
import com.lj.eshop.dto.FindFlagPage;
import com.lj.eshop.service.IFlagService;

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
public class FlagServiceImplTest extends SpringTestCase{

	@Resource
	IFlagService flagService;



	/**
	 * 
	 *
	 * 方法说明：添加商品标记信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addFlag() throws TsfaServiceException{
		FlagDto flagDto = new FlagDto();
		//add数据录入
		flagDto.setCode("Code");
		flagDto.setProductFlag("ProductFlag");
		flagDto.setProductSeq(1);
		flagDto.setStatus("Status");
		flagDto.setCreater("Creater");
		flagDto.setFlagType("1");
		flagDto.setShowCnt(4);
		flagService.addFlag(flagDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品标记信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateFlag() throws TsfaServiceException{
		FlagDto flagDto = new FlagDto();
		//update数据录入
		flagDto.setCode("Code");
		flagDto.setProductFlag("ProductFlag");
		flagDto.setProductSeq(1);
		flagDto.setStatus("Status");
		flagDto.setCreater("Creater");
		flagDto.setFlagType("1");
		flagService.updateFlag(flagDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品标记信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findFlag() throws TsfaServiceException{
		FlagDto findFlag = new FlagDto();
		findFlag.setCode("111");
		flagService.findFlag(findFlag);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品标记信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findFlagPage() throws TsfaServiceException{
		FindFlagPage findFlagPage = new FindFlagPage();
		Page<FlagDto> page = flagService.findFlagPage(findFlagPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品标记信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findFlags() throws TsfaServiceException{
		FindFlagPage findFlagPage = new FindFlagPage();
		List<FlagDto> page = flagService.findFlags(findFlagPage);
		Assert.assertNotNull(page);
		
	}
	
}
