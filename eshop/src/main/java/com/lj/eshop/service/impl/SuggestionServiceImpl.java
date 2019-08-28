package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.ISuggestionDao;
import com.lj.eshop.domain.Suggestion;
import com.lj.eshop.dto.FindSuggestionPage;
import com.lj.eshop.dto.SuggestionDto;
import com.lj.eshop.service.ISuggestionService;
/**
 * 类说明：实现类
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
@Service
public class SuggestionServiceImpl implements ISuggestionService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(SuggestionServiceImpl.class);
	

	@Resource
	private ISuggestionDao suggestionDao;
	
	
	@Override
	public void addSuggestion(
			SuggestionDto suggestionDto) throws TsfaServiceException {
		logger.debug("addSuggestion(AddSuggestion addSuggestion={}) - start", suggestionDto); 

		AssertUtils.notNull(suggestionDto);
		try {
			Suggestion suggestion = new Suggestion();
			//add数据录入
			suggestion.setCode(GUID.generateCode());
			suggestion.setSuggestion(suggestionDto.getSuggestion());
			suggestion.setMbrCode(suggestionDto.getMbrCode());
			suggestion.setMbrName(suggestionDto.getMbrName());
			suggestion.setCreateTime(new Date());
			suggestionDao.insertSelective(suggestion);
			logger.debug("addSuggestion(SuggestionDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增意见反馈信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUGGESTION_ADD_ERROR,"新增意见反馈信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询意见反馈信息
	 *
	 * @param findSuggestionPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<SuggestionDto>  findSuggestions(FindSuggestionPage findSuggestionPage)throws TsfaServiceException{
		AssertUtils.notNull(findSuggestionPage);
		List<SuggestionDto> returnList=null;
		try {
			returnList = suggestionDao.findSuggestions(findSuggestionPage);
		} catch (Exception e) {
			logger.error("查找意见反馈信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SUGGESTION_NOT_EXIST_ERROR,"意见反馈信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateSuggestion(
			SuggestionDto suggestionDto)
			throws TsfaServiceException {
		logger.debug("updateSuggestion(SuggestionDto suggestionDto={}) - start", suggestionDto); //$NON-NLS-1$

		AssertUtils.notNull(suggestionDto);
		AssertUtils.notNullAndEmpty(suggestionDto.getCode(),"Code不能为空");
		try {
			Suggestion suggestion = new Suggestion();
			//update数据录入
			suggestion.setCode(suggestionDto.getCode());
			suggestion.setSuggestion(suggestionDto.getSuggestion());
			suggestion.setMbrCode(suggestionDto.getMbrCode());
			suggestion.setMbrName(suggestionDto.getMbrName());
			suggestion.setCreateTime(suggestionDto.getCreateTime());
			AssertUtils.notUpdateMoreThanOne(suggestionDao.updateByPrimaryKeySelective(suggestion));
			logger.debug("updateSuggestion(SuggestionDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("意见反馈信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUGGESTION_UPDATE_ERROR,"意见反馈信息更新信息错误！",e);
		}
	}

	

	@Override
	public SuggestionDto findSuggestion(
			SuggestionDto suggestionDto) throws TsfaServiceException {
		logger.debug("findSuggestion(FindSuggestion findSuggestion={}) - start", suggestionDto); //$NON-NLS-1$

		AssertUtils.notNull(suggestionDto);
		AssertUtils.notAllNull(suggestionDto.getCode(),"Code不能为空");
		try {
			Suggestion suggestion = suggestionDao.selectByPrimaryKey(suggestionDto.getCode());
			if(suggestion == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.SUGGESTION_NOT_EXIST_ERROR,"意见反馈信息不存在");
			}
			SuggestionDto findSuggestionReturn = new SuggestionDto();
			//find数据录入
			findSuggestionReturn.setCode(suggestion.getCode());
			findSuggestionReturn.setSuggestion(suggestion.getSuggestion());
			findSuggestionReturn.setMbrCode(suggestion.getMbrCode());
			findSuggestionReturn.setMbrName(suggestion.getMbrName());
			findSuggestionReturn.setCreateTime(suggestion.getCreateTime());
			
			logger.debug("findSuggestion(SuggestionDto) - end - return value={}", findSuggestionReturn); //$NON-NLS-1$
			return findSuggestionReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找意见反馈信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUGGESTION_FIND_ERROR,"查找意见反馈信息信息错误！",e);
		}


	}

	
	@Override
	public Page<SuggestionDto> findSuggestionPage(
			FindSuggestionPage findSuggestionPage)
			throws TsfaServiceException {
		logger.debug("findSuggestionPage(FindSuggestionPage findSuggestionPage={}) - start", findSuggestionPage); //$NON-NLS-1$

		AssertUtils.notNull(findSuggestionPage);
		List<SuggestionDto> returnList=null;
		int count = 0;
		try {
			returnList = suggestionDao.findSuggestionPage(findSuggestionPage);
			count = suggestionDao.findSuggestionPageCount(findSuggestionPage);
		}  catch (Exception e) {
			logger.error("意见反馈信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SUGGESTION_FIND_PAGE_ERROR,"意见反馈信息不存在错误.！",e);
		}
		Page<SuggestionDto> returnPage = new Page<SuggestionDto>(returnList, count, findSuggestionPage);

		logger.debug("findSuggestionPage(FindSuggestionPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
