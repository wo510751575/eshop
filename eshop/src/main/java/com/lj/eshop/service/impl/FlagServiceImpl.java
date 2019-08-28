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
import com.lj.eshop.dao.IFlagDao;
import com.lj.eshop.domain.Flag;
import com.lj.eshop.dto.FindFlagPage;
import com.lj.eshop.dto.FlagDto;
import com.lj.eshop.service.IFlagService;
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
public class FlagServiceImpl implements IFlagService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(FlagServiceImpl.class);
	

	@Resource
	private IFlagDao flagDao;
	
	
	@Override
	public void addFlag(
			FlagDto flagDto) throws TsfaServiceException {
		logger.debug("addFlag(AddFlag addFlag={}) - start", flagDto); 

		AssertUtils.notNull(flagDto);
		try {
			Flag flag = new Flag();
			//add数据录入
			flag.setCode(GUID.generateCode());
			flag.setProductFlag(flagDto.getProductFlag());
			flag.setProductSeq(flagDto.getProductSeq());
			flag.setStatus(flagDto.getStatus());
			flag.setCreater(flagDto.getCreater());
			flag.setCreateTime(new Date());
			flag.setFlagType(flagDto.getFlagType());
			flag.setShowCnt(flagDto.getShowCnt());
			flag.setImageUrl(flagDto.getImageUrl());
			flagDao.insertSelective(flag);
			logger.debug("addFlag(FlagDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品标记信息错误！",e);
			throw new TsfaServiceException(ErrorCode.FLAG_ADD_ERROR,"新增商品标记信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品标记信息
	 *
	 * @param findFlagPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<FlagDto>  findFlags(FindFlagPage findFlagPage)throws TsfaServiceException{
		AssertUtils.notNull(findFlagPage);
		List<FlagDto> returnList=null;
		try {
			returnList = flagDao.findFlags(findFlagPage);
		} catch (Exception e) {
			logger.error("查找商品标记信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.FLAG_NOT_EXIST_ERROR,"商品标记信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateFlag(
			FlagDto flagDto)
			throws TsfaServiceException {
		logger.debug("updateFlag(FlagDto flagDto={}) - start", flagDto); //$NON-NLS-1$

		AssertUtils.notNull(flagDto);
		AssertUtils.notNullAndEmpty(flagDto.getCode(),"Code不能为空");
		try {
			Flag flag = new Flag();
			//update数据录入
			flag.setCode(flagDto.getCode());
			flag.setProductFlag(flagDto.getProductFlag());
			flag.setProductSeq(flagDto.getProductSeq());
			flag.setStatus(flagDto.getStatus());
			flag.setFlagType(flagDto.getFlagType());
			flag.setShowCnt(flagDto.getShowCnt());
			flag.setImageUrl(flagDto.getImageUrl());
			AssertUtils.notUpdateMoreThanOne(flagDao.updateByPrimaryKeySelective(flag));
			logger.debug("updateFlag(FlagDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品标记信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.FLAG_UPDATE_ERROR,"商品标记信息更新信息错误！",e);
		}
	}

	

	@Override
	public FlagDto findFlag(
			FlagDto flagDto) throws TsfaServiceException {
		logger.debug("findFlag(FindFlag findFlag={}) - start", flagDto); //$NON-NLS-1$

		AssertUtils.notNull(flagDto);
		AssertUtils.notAllNull(flagDto.getCode(),"Code不能为空");
		try {
			Flag flag = flagDao.selectByPrimaryKey(flagDto.getCode());
			if(flag == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.FLAG_NOT_EXIST_ERROR,"商品标记信息不存在");
			}
			FlagDto findFlagReturn = new FlagDto();
			//find数据录入
			findFlagReturn.setCode(flag.getCode());
			findFlagReturn.setProductFlag(flag.getProductFlag());
			findFlagReturn.setProductSeq(flag.getProductSeq());
			findFlagReturn.setStatus(flag.getStatus());
			findFlagReturn.setCreater(flag.getCreater());
			findFlagReturn.setCreateTime(flag.getCreateTime());
			findFlagReturn.setFlagType(flag.getFlagType());
			findFlagReturn.setShowCnt(flag.getShowCnt());
			findFlagReturn.setImageUrl(flag.getImageUrl());
			logger.debug("findFlag(FlagDto) - end - return value={}", findFlagReturn); //$NON-NLS-1$
			return findFlagReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品标记信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.FLAG_FIND_ERROR,"查找商品标记信息信息错误！",e);
		}


	}

	
	@Override
	public Page<FlagDto> findFlagPage(
			FindFlagPage findFlagPage)
			throws TsfaServiceException {
		logger.debug("findFlagPage(FindFlagPage findFlagPage={}) - start", findFlagPage); //$NON-NLS-1$

		AssertUtils.notNull(findFlagPage);
		List<FlagDto> returnList=null;
		int count = 0;
		try {
			returnList = flagDao.findFlagPage(findFlagPage);
			count = flagDao.findFlagPageCount(findFlagPage);
		}  catch (Exception e) {
			logger.error("商品标记信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.FLAG_FIND_PAGE_ERROR,"商品标记信息不存在错误.！",e);
		}
		Page<FlagDto> returnPage = new Page<FlagDto>(returnList, count, findFlagPage);

		logger.debug("findFlagPage(FindFlagPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
