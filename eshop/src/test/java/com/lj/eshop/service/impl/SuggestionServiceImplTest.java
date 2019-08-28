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

import com.lj.eshop.dto.SuggestionDto;
import com.lj.eshop.dto.FindSuggestionPage;
import com.lj.eshop.service.ISuggestionService;

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
public class SuggestionServiceImplTest extends SpringTestCase{

	@Resource
	ISuggestionService suggestionService;



	/**
	 * 
	 *
	 * 方法说明：添加意见反馈信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addSuggestion() throws TsfaServiceException{
		SuggestionDto suggestionDto = new SuggestionDto();
		//add数据录入
		suggestionDto.setSuggestion("Suggestion");
		suggestionDto.setMbrCode("MbrCode");
		suggestionDto.setMbrName("MbrName");
		
		suggestionService.addSuggestion(suggestionDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改意见反馈信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateSuggestion() throws TsfaServiceException{
		SuggestionDto suggestionDto = new SuggestionDto();
		//update数据录入
		suggestionDto.setCode("Code");
		suggestionDto.setSuggestion("Suggestion");
		suggestionDto.setMbrCode("MbrCode");
		suggestionDto.setMbrName("MbrName");

		suggestionService.updateSuggestion(suggestionDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找意见反馈信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSuggestion() throws TsfaServiceException{
		SuggestionDto findSuggestion = new SuggestionDto();
		findSuggestion.setCode("111");
		suggestionService.findSuggestion(findSuggestion);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找意见反馈信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSuggestionPage() throws TsfaServiceException{
		FindSuggestionPage findSuggestionPage = new FindSuggestionPage();
		Page<SuggestionDto> page = suggestionService.findSuggestionPage(findSuggestionPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找意见反馈信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSuggestions() throws TsfaServiceException{
		FindSuggestionPage findSuggestionPage = new FindSuggestionPage();
		List<SuggestionDto> page = suggestionService.findSuggestions(findSuggestionPage);
		Assert.assertNotNull(page);
		
	}
	
}
