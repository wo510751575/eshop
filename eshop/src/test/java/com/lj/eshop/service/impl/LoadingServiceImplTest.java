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

import com.lj.eshop.dto.LoadingDto;
import com.lj.eshop.emus.LoadingBiz;
import com.lj.eshop.dto.FindLoadingPage;
import com.lj.eshop.service.ILoadingService;

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
public class LoadingServiceImplTest extends SpringTestCase{

	@Resource
	ILoadingService loadingService;



	/**
	 * 
	 *
	 * 方法说明：添加广告信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addLoading() throws TsfaServiceException{
		LoadingDto loadingDto = new LoadingDto();
		//add数据录入
		loadingDto.setCode("Code");
		loadingDto.setImgUrl("ImgUrl");
		loadingDto.setIndexSeq(1);
		loadingDto.setStatus("1");
		loadingDto.setBiz(LoadingBiz.FEMALE.getValue());
		loadingDto.setJumpUrl("jumpurl");
		loadingService.addLoading(loadingDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改广告信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateLoading() throws TsfaServiceException{
		LoadingDto loadingDto = new LoadingDto();
		//update数据录入
		loadingDto.setCode("Code");
		loadingDto.setImgUrl("ImgUrl");
		loadingDto.setIndexSeq(1);
		loadingDto.setStatus("1");
		loadingDto.setBiz(LoadingBiz.FEMALE.getValue());
		loadingDto.setJumpUrl("jumpurl2");
		loadingService.updateLoading(loadingDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找广告信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findLoading() throws TsfaServiceException{
		LoadingDto findLoading = new LoadingDto();
		findLoading.setCode("111");
		loadingService.findLoading(findLoading);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找广告信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findLoadingPage() throws TsfaServiceException{
		FindLoadingPage findLoadingPage = new FindLoadingPage();
		Page<LoadingDto> page = loadingService.findLoadingPage(findLoadingPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找广告信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findLoadings() throws TsfaServiceException{
		FindLoadingPage findLoadingPage = new FindLoadingPage();
		List<LoadingDto> page = loadingService.findLoadings(findLoadingPage);
		Assert.assertNotNull(page);
		
	}
	
}
