package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.SuggestionDto;
import com.lj.eshop.dto.FindSuggestionPage;


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
public interface ISuggestionService {
	
	/**
	 * 
	 *
	 * 方法说明：添加意见反馈信息
	 *
	 * @param suggestionDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addSuggestion(SuggestionDto suggestionDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找意见反馈信息
	 *
	 * @param findSuggestion
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public SuggestionDto findSuggestion(SuggestionDto suggestionDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询意见反馈信息
	 *
	 * @param findSuggestionPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<SuggestionDto>  findSuggestions(FindSuggestionPage findSuggestionPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改意见反馈信息
	 *
	 * @param updateSuggestion
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateSuggestion(SuggestionDto suggestionDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询意见反馈信息
	 *
	 * @param findSuggestionPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<SuggestionDto> findSuggestionPage(FindSuggestionPage findSuggestionPage) throws TsfaServiceException;
	

}
