package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
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
import com.lj.eshop.dao.ILoadingDao;
import com.lj.eshop.domain.Loading;
import com.lj.eshop.dto.FindLoadingPage;
import com.lj.eshop.dto.LoadingDto;
import com.lj.eshop.service.ILoadingService;
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
public class LoadingServiceImpl implements ILoadingService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(LoadingServiceImpl.class);
	

	@Resource
	private ILoadingDao loadingDao;
	
	
	@Override
	public void addLoading(
			LoadingDto loadingDto) throws TsfaServiceException {
		logger.debug("addLoading(AddLoading addLoading={}) - start", loadingDto); 

		AssertUtils.notNull(loadingDto);
		try {
			Loading loading = new Loading();
			//add数据录入
			loading.setCode(GUID.generateCode());
			loading.setImgUrl(loadingDto.getImgUrl());
			loading.setIndexSeq(loadingDto.getIndexSeq());
			loading.setStatus(loadingDto.getStatus());
			loading.setBiz(loadingDto.getBiz());
			loading.setJumpUrl(loadingDto.getJumpUrl());
			loadingDao.insertSelective(loading);
			logger.debug("addLoading(LoadingDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增广告信息错误！",e);
			throw new TsfaServiceException(ErrorCode.LOADING_ADD_ERROR,"新增广告信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询广告信息
	 *
	 * @param findLoadingPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<LoadingDto>  findLoadings(FindLoadingPage findLoadingPage)throws TsfaServiceException{
		AssertUtils.notNull(findLoadingPage);
		List<LoadingDto> returnList=null;
		try {
			returnList = loadingDao.findLoadings(findLoadingPage);
		} catch (Exception e) {
			logger.error("查找广告信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.LOADING_NOT_EXIST_ERROR,"广告信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateLoading(
			LoadingDto loadingDto)
			throws TsfaServiceException {
		logger.debug("updateLoading(LoadingDto loadingDto={}) - start", loadingDto); //$NON-NLS-1$

		AssertUtils.notNull(loadingDto);
		AssertUtils.notNullAndEmpty(loadingDto.getCode(),"Code不能为空");
		try {
			Loading loading = new Loading();
			//update数据录入
			loading.setCode(loadingDto.getCode());
			loading.setImgUrl(loadingDto.getImgUrl());
			loading.setIndexSeq(loadingDto.getIndexSeq());
			loading.setStatus(loadingDto.getStatus());
			loading.setBiz(loadingDto.getBiz());
			loading.setJumpUrl(loadingDto.getJumpUrl());
			AssertUtils.notUpdateMoreThanOne(loadingDao.updateByPrimaryKeySelective(loading));
			logger.debug("updateLoading(LoadingDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("广告信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.LOADING_UPDATE_ERROR,"广告信息更新信息错误！",e);
		}
	}

	

	@Override
	public LoadingDto findLoading(
			LoadingDto loadingDto) throws TsfaServiceException {
		logger.debug("findLoading(FindLoading findLoading={}) - start", loadingDto); //$NON-NLS-1$

		AssertUtils.notNull(loadingDto);
		AssertUtils.notAllNull(loadingDto.getCode(),"Code不能为空");
		try {
			Loading loading = loadingDao.selectByPrimaryKey(loadingDto.getCode());
			if(loading == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.LOADING_NOT_EXIST_ERROR,"广告信息不存在");
			}
			LoadingDto findLoadingReturn = new LoadingDto();
			//find数据录入
			findLoadingReturn.setCode(loading.getCode());
			findLoadingReturn.setImgUrl(loading.getImgUrl());
			findLoadingReturn.setIndexSeq(loading.getIndexSeq());
			findLoadingReturn.setStatus(loading.getStatus());
			findLoadingReturn.setBiz(loading.getBiz());
			findLoadingReturn.setJumpUrl(loading.getJumpUrl());
			logger.debug("findLoading(LoadingDto) - end - return value={}", findLoadingReturn); //$NON-NLS-1$
			return findLoadingReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找广告信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.LOADING_FIND_ERROR,"查找广告信息信息错误！",e);
		}


	}

	
	@Override
	public Page<LoadingDto> findLoadingPage(
			FindLoadingPage findLoadingPage)
			throws TsfaServiceException {
		logger.debug("findLoadingPage(FindLoadingPage findLoadingPage={}) - start", findLoadingPage); //$NON-NLS-1$

		AssertUtils.notNull(findLoadingPage);
		List<LoadingDto> returnList=null;
		int count = 0;
		try {
			returnList = loadingDao.findLoadingPage(findLoadingPage);
			count = loadingDao.findLoadingPageCount(findLoadingPage);
		}  catch (Exception e) {
			logger.error("广告信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.LOADING_FIND_PAGE_ERROR,"广告信息不存在错误.！",e);
		}
		Page<LoadingDto> returnPage = new Page<LoadingDto>(returnList, count, findLoadingPage);

		logger.debug("findLoadingPage(FindLoadingPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
