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

import com.lj.eshop.dto.MyAttentionDto;
import com.lj.eshop.dto.FindMyAttentionPage;
import com.lj.eshop.emus.MyAttentionStatus;
import com.lj.eshop.service.IMyAttentionService;

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
public class MyAttentionServiceImplTest extends SpringTestCase{

	@Resource
	IMyAttentionService myAttentionService;



	/**
	 * 
	 *
	 * 方法说明：添加店铺关注信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addMyAttention() throws TsfaServiceException{
		for(int i=0; i<100; i++) {
			MyAttentionDto myAttentionDto = new MyAttentionDto();
			//add数据录入
			myAttentionDto.setMbrCode("LJ_19970ac72b1049e2a1addf51f78e98a4");
			myAttentionDto.setMbrName("订单");
			myAttentionDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
			myAttentionDto.setShopName("杨晴");
			myAttentionDto.setStatus(MyAttentionStatus.Y.getValue());
			myAttentionDto.setShopImg("/eoms/image/shop/888b3199-6168-4cc0-8beb-3409dd99ce2d.png");
			
			myAttentionService.addMyAttention(myAttentionDto);
		}
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改店铺关注信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateMyAttention() throws TsfaServiceException{
		MyAttentionDto myAttentionDto = new MyAttentionDto();
		//update数据录入
		myAttentionDto.setCode("Code");
		myAttentionDto.setMbrCode("MbrCode");
		myAttentionDto.setMbrName("MbrcName");
		myAttentionDto.setShopCode("ShopCode");
		myAttentionDto.setShopName("ShopName");
		myAttentionDto.setStatus("Status");
		myAttentionDto.setCreateTime(new Date());
		myAttentionDto.setUpdateTime(new Date());
		myAttentionDto.setShopImg("ShopImg");

		myAttentionService.updateMyAttention(myAttentionDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺关注信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMyAttention() throws TsfaServiceException{
		MyAttentionDto findMyAttention = new MyAttentionDto();
		findMyAttention.setCode("111");
		myAttentionService.findMyAttention(findMyAttention);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺关注信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMyAttentionPage() throws TsfaServiceException{
		FindMyAttentionPage findMyAttentionPage = new FindMyAttentionPage();
		Page<MyAttentionDto> page = myAttentionService.findMyAttentionPage(findMyAttentionPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺关注信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMyAttentions() throws TsfaServiceException{
		FindMyAttentionPage findMyAttentionPage = new FindMyAttentionPage();
		List<MyAttentionDto> page = myAttentionService.findMyAttentions(findMyAttentionPage);
		Assert.assertNotNull(page);
		
	}
	
}
