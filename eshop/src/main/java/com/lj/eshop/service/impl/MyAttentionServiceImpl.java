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
import com.lj.eshop.dao.IMyAttentionDao;
import com.lj.eshop.domain.MyAttention;
import com.lj.eshop.dto.FindMyAttentionPage;
import com.lj.eshop.dto.MyAttentionDto;
import com.lj.eshop.service.IMyAttentionService;
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
public class MyAttentionServiceImpl implements IMyAttentionService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MyAttentionServiceImpl.class);
	

	@Resource
	private IMyAttentionDao myAttentionDao;
	
	
	@Override
	public void addMyAttention(
			MyAttentionDto myAttentionDto) throws TsfaServiceException {
		logger.debug("addMyAttention(AddMyAttention addMyAttention={}) - start", myAttentionDto); 

		AssertUtils.notNull(myAttentionDto);
		try {
			MyAttention myAttention = new MyAttention();
			//add数据录入
			myAttention.setCode(GUID.generateCode());
			myAttention.setMbrCode(myAttentionDto.getMbrCode());
			myAttention.setMbrName(myAttentionDto.getMbrName());
			myAttention.setShopCode(myAttentionDto.getShopCode());
			myAttention.setShopName(myAttentionDto.getShopName());
			myAttention.setStatus(myAttentionDto.getStatus());
			myAttention.setCreateTime(new Date());
			myAttention.setUpdateTime(myAttentionDto.getUpdateTime());
			myAttention.setShopImg(myAttentionDto.getShopImg());
			myAttentionDao.insertSelective(myAttention);
			logger.debug("addMyAttention(MyAttentionDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增店铺关注信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MY_ATTENTION_ADD_ERROR,"新增店铺关注信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询店铺关注信息
	 *
	 * @param findMyAttentionPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<MyAttentionDto>  findMyAttentions(FindMyAttentionPage findMyAttentionPage)throws TsfaServiceException{
		AssertUtils.notNull(findMyAttentionPage);
		List<MyAttentionDto> returnList=null;
		try {
			returnList = myAttentionDao.findMyAttentions(findMyAttentionPage);
		} catch (Exception e) {
			logger.error("查找店铺关注信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MY_ATTENTION_NOT_EXIST_ERROR,"店铺关注信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateMyAttention(
			MyAttentionDto myAttentionDto)
			throws TsfaServiceException {
		logger.debug("updateMyAttention(MyAttentionDto myAttentionDto={}) - start", myAttentionDto); //$NON-NLS-1$

		AssertUtils.notNull(myAttentionDto);
		AssertUtils.notNullAndEmpty(myAttentionDto.getCode(),"Code不能为空");
		try {
			MyAttention myAttention = new MyAttention();
			//update数据录入
			myAttention.setCode(myAttentionDto.getCode());
			myAttention.setMbrCode(myAttentionDto.getMbrCode());
			myAttention.setMbrName(myAttentionDto.getMbrName());
			myAttention.setShopCode(myAttentionDto.getShopCode());
			myAttention.setShopName(myAttentionDto.getShopName());
			myAttention.setStatus(myAttentionDto.getStatus());
			myAttention.setUpdateTime(new Date());
			myAttention.setShopImg(myAttentionDto.getShopImg());
			AssertUtils.notUpdateMoreThanOne(myAttentionDao.updateByPrimaryKeySelective(myAttention));
			logger.debug("updateMyAttention(MyAttentionDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("店铺关注信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MY_ATTENTION_UPDATE_ERROR,"店铺关注信息更新信息错误！",e);
		}
	}

	

	@Override
	public MyAttentionDto findMyAttention(
			MyAttentionDto myAttentionDto) throws TsfaServiceException {
		logger.debug("findMyAttention(FindMyAttention findMyAttention={}) - start", myAttentionDto); //$NON-NLS-1$

		AssertUtils.notNull(myAttentionDto);
		AssertUtils.notAllNull(myAttentionDto.getCode(),"Code不能为空");
		try {
			MyAttention myAttention = myAttentionDao.selectByPrimaryKey(myAttentionDto.getCode());
			if(myAttention == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.MY_ATTENTION_NOT_EXIST_ERROR,"店铺关注信息不存在");
			}
			MyAttentionDto findMyAttentionReturn = new MyAttentionDto();
			//find数据录入
			findMyAttentionReturn.setCode(myAttention.getCode());
			findMyAttentionReturn.setMbrCode(myAttention.getMbrCode());
			findMyAttentionReturn.setMbrName(myAttention.getMbrName());
			findMyAttentionReturn.setShopCode(myAttention.getShopCode());
			findMyAttentionReturn.setShopName(myAttention.getShopName());
			findMyAttentionReturn.setStatus(myAttention.getStatus());
			findMyAttentionReturn.setCreateTime(myAttention.getCreateTime());
			findMyAttentionReturn.setUpdateTime(myAttention.getUpdateTime());
			findMyAttentionReturn.setShopImg(myAttention.getShopImg());
			
			logger.debug("findMyAttention(MyAttentionDto) - end - return value={}", findMyAttentionReturn); //$NON-NLS-1$
			return findMyAttentionReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找店铺关注信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MY_ATTENTION_FIND_ERROR,"查找店铺关注信息信息错误！",e);
		}


	}

	
	@Override
	public Page<MyAttentionDto> findMyAttentionPage(
			FindMyAttentionPage findMyAttentionPage)
			throws TsfaServiceException {
		logger.debug("findMyAttentionPage(FindMyAttentionPage findMyAttentionPage={}) - start", findMyAttentionPage); //$NON-NLS-1$

		AssertUtils.notNull(findMyAttentionPage);
		List<MyAttentionDto> returnList=null;
		int count = 0;
		try {
			returnList = myAttentionDao.findMyAttentionPage(findMyAttentionPage);
			count = myAttentionDao.findMyAttentionPageCount(findMyAttentionPage);
		}  catch (Exception e) {
			logger.error("店铺关注信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MY_ATTENTION_FIND_PAGE_ERROR,"店铺关注信息不存在错误.！",e);
		}
		Page<MyAttentionDto> returnPage = new Page<MyAttentionDto>(returnList, count, findMyAttentionPage);

		logger.debug("findMyAttentionPage(FindMyAttentionPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	public int findMyAttentionPageCount(FindMyAttentionPage findMyAttentionPage)
			throws TsfaServiceException {
		logger.debug("findMyAttentionPageCount(FindMyAttentionPage findMyAttentionPage={}) - start", findMyAttentionPage); //$NON-NLS-1$

		AssertUtils.notNull(findMyAttentionPage);
		int count = 0;
		try {
			count = myAttentionDao.findMyAttentionPageCount(findMyAttentionPage);
		}  catch (Exception e) {
			logger.error("店铺关注信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MY_ATTENTION_FIND_PAGE_ERROR,"店铺关注信息不存在错误.！",e);
		}

		logger.debug("findMyAttentionPageCount(FindMyAttentionPage) - end - return value={}", count); //$NON-NLS-1$
		return  count;
	} 


}
