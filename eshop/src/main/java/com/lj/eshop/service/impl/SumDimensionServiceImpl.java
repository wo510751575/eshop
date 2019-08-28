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
import com.lj.eshop.dao.ISumDimensionDao;
import com.lj.eshop.domain.SumDimension;
import com.lj.eshop.dto.FindSumDimensionPage;
import com.lj.eshop.dto.SumDimensionDto;
import com.lj.eshop.service.ISumDimensionService;
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
public class SumDimensionServiceImpl implements ISumDimensionService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(SumDimensionServiceImpl.class);
	

	@Resource
	private ISumDimensionDao sumDimensionDao;
	
	
	@Override
	public void addSumDimension(
			SumDimensionDto sumDimensionDto) throws TsfaServiceException {
		logger.debug("addSumDimension(AddSumDimension addSumDimension={}) - start", sumDimensionDto); 

		AssertUtils.notNull(sumDimensionDto);
		try {
			SumDimension sumDimension = new SumDimension();
			//add数据录入
			sumDimension.setCode(GUID.generateCode());
			sumDimension.setName(sumDimensionDto.getName());
			sumDimension.setRemarks(sumDimensionDto.getRemarks());
			sumDimension.setStatus(sumDimensionDto.getStatus());
			sumDimensionDao.insertSelective(sumDimension);
			logger.debug("addSumDimension(SumDimensionDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增统计维度信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUM_DIMENSION_ADD_ERROR,"新增统计维度信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询统计维度信息
	 *
	 * @param findSumDimensionPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<SumDimensionDto>  findSumDimensions(FindSumDimensionPage findSumDimensionPage)throws TsfaServiceException{
		AssertUtils.notNull(findSumDimensionPage);
		List<SumDimensionDto> returnList=null;
		try {
			returnList = sumDimensionDao.findSumDimensions(findSumDimensionPage);
		} catch (Exception e) {
			logger.error("查找统计维度信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SUM_DIMENSION_NOT_EXIST_ERROR,"统计维度信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateSumDimension(
			SumDimensionDto sumDimensionDto)
			throws TsfaServiceException {
		logger.debug("updateSumDimension(SumDimensionDto sumDimensionDto={}) - start", sumDimensionDto); //$NON-NLS-1$

		AssertUtils.notNull(sumDimensionDto);
		AssertUtils.notNullAndEmpty(sumDimensionDto.getCode(),"Code不能为空");
		try {
			SumDimension sumDimension = new SumDimension();
			//update数据录入
			sumDimension.setCode(sumDimensionDto.getCode());
			sumDimension.setName(sumDimensionDto.getName());
			sumDimension.setRemarks(sumDimensionDto.getRemarks());
			sumDimension.setStatus(sumDimensionDto.getStatus());
			AssertUtils.notUpdateMoreThanOne(sumDimensionDao.updateByPrimaryKeySelective(sumDimension));
			logger.debug("updateSumDimension(SumDimensionDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("统计维度信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUM_DIMENSION_UPDATE_ERROR,"统计维度信息更新信息错误！",e);
		}
	}

	

	@Override
	public SumDimensionDto findSumDimension(
			SumDimensionDto sumDimensionDto) throws TsfaServiceException {
		logger.debug("findSumDimension(FindSumDimension findSumDimension={}) - start", sumDimensionDto); //$NON-NLS-1$

		AssertUtils.notNull(sumDimensionDto);
		AssertUtils.notAllNull(sumDimensionDto.getCode(),"Code不能为空");
		try {
			SumDimension sumDimension = sumDimensionDao.selectByPrimaryKey(sumDimensionDto.getCode());
			if(sumDimension == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.SUM_DIMENSION_NOT_EXIST_ERROR,"统计维度信息不存在");
			}
			SumDimensionDto findSumDimensionReturn = new SumDimensionDto();
			//find数据录入
			findSumDimensionReturn.setCode(sumDimension.getCode());
			findSumDimensionReturn.setName(sumDimension.getName());
			findSumDimensionReturn.setRemarks(sumDimension.getRemarks());
			findSumDimensionReturn.setStatus(sumDimension.getStatus());
			
			logger.debug("findSumDimension(SumDimensionDto) - end - return value={}", findSumDimensionReturn); //$NON-NLS-1$
			return findSumDimensionReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找统计维度信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUM_DIMENSION_FIND_ERROR,"查找统计维度信息信息错误！",e);
		}


	}

	
	@Override
	public Page<SumDimensionDto> findSumDimensionPage(
			FindSumDimensionPage findSumDimensionPage)
			throws TsfaServiceException {
		logger.debug("findSumDimensionPage(FindSumDimensionPage findSumDimensionPage={}) - start", findSumDimensionPage); //$NON-NLS-1$

		AssertUtils.notNull(findSumDimensionPage);
		List<SumDimensionDto> returnList=null;
		int count = 0;
		try {
			returnList = sumDimensionDao.findSumDimensionPage(findSumDimensionPage);
			count = sumDimensionDao.findSumDimensionPageCount(findSumDimensionPage);
		}  catch (Exception e) {
			logger.error("统计维度信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SUM_DIMENSION_FIND_PAGE_ERROR,"统计维度信息不存在错误.！",e);
		}
		Page<SumDimensionDto> returnPage = new Page<SumDimensionDto>(returnList, count, findSumDimensionPage);

		logger.debug("findSumDimensionPage(FindSumDimensionPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
