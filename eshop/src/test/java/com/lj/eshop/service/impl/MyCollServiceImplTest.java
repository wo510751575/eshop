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

import com.lj.eshop.dto.MyCollDto;
import com.lj.eshop.dto.FindMyCollPage;
import com.lj.eshop.service.IMyCollService;

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
public class MyCollServiceImplTest extends SpringTestCase{

	@Resource
	IMyCollService myCollService;



	/**
	 * 
	 *
	 * 方法说明：添加我的收藏信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addMyColl() throws TsfaServiceException{
		MyCollDto myCollDto = new MyCollDto();
		//add数据录入
		myCollDto.setProductCode("ProductCode");
		myCollDto.setMbrCode("MbrCode");
		myCollDto.setCreateDate(new Date());
		
		myCollService.addMyColl(myCollDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改我的收藏信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateMyColl() throws TsfaServiceException{
		MyCollDto myCollDto = new MyCollDto();
		//update数据录入
		myCollDto.setProductCode("ProductCode");
		myCollDto.setMbrCode("MbrCode");
		myCollDto.setCreateDate(new Date());

		myCollService.updateMyColl(myCollDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找我的收藏信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMyColl() throws TsfaServiceException{
		MyCollDto findMyColl = new MyCollDto();
		findMyColl.setMbrCode("111");
		findMyColl.setProductCode("111");
		myCollService.findMyColl(findMyColl);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找我的收藏信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMyCollPage() throws TsfaServiceException{
		FindMyCollPage findMyCollPage = new FindMyCollPage();
		Page<MyCollDto> page = myCollService.findMyCollPage(findMyCollPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找我的收藏信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMyColls() throws TsfaServiceException{
		FindMyCollPage findMyCollPage = new FindMyCollPage();
		List<MyCollDto> page = myCollService.findMyColls(findMyCollPage);
		Assert.assertNotNull(page);
		
	}
	
}
