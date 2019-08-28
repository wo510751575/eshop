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

import com.lj.eshop.dto.EvlLikeDto;
import com.lj.eshop.dto.FindEvlLikePage;
import com.lj.eshop.service.IEvlLikeService;

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
public class EvlLikeServiceImplTest extends SpringTestCase{

	@Resource
	IEvlLikeService evlLikeService;



	/**
	 * 
	 *
	 * 方法说明：添加商品评价点赞记录信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addEvlLike() throws TsfaServiceException{
		EvlLikeDto evlLikeDto = new EvlLikeDto();
		//add数据录入
		evlLikeDto.setCode("Code");
		evlLikeDto.setMbrCode("MbrCode");
		evlLikeDto.setEvlCode("EvlCode");
		evlLikeDto.setCreateTime(new Date());
		
		evlLikeService.addEvlLike(evlLikeDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品评价点赞记录信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateEvlLike() throws TsfaServiceException{
		EvlLikeDto evlLikeDto = new EvlLikeDto();
		//update数据录入
		evlLikeDto.setCode("Code");
		evlLikeDto.setMbrCode("MbrCode");
		evlLikeDto.setEvlCode("EvlCode");
		evlLikeDto.setCreateTime(new Date());

		evlLikeService.updateEvlLike(evlLikeDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品评价点赞记录信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findEvlLike() throws TsfaServiceException{
		EvlLikeDto findEvlLike = new EvlLikeDto();
		findEvlLike.setCode("111");
		evlLikeService.findEvlLike(findEvlLike);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品评价点赞记录信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findEvlLikePage() throws TsfaServiceException{
		FindEvlLikePage findEvlLikePage = new FindEvlLikePage();
		Page<EvlLikeDto> page = evlLikeService.findEvlLikePage(findEvlLikePage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品评价点赞记录信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findEvlLikes() throws TsfaServiceException{
		FindEvlLikePage findEvlLikePage = new FindEvlLikePage();
		List<EvlLikeDto> page = evlLikeService.findEvlLikes(findEvlLikePage);
		Assert.assertNotNull(page);
		
	}
	
}
