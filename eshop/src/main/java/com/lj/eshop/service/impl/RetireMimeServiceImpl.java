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
import com.lj.eshop.dao.IRetireMimeDao;
import com.lj.eshop.domain.RetireMime;
import com.lj.eshop.dto.FindRetireMimePage;
import com.lj.eshop.dto.RetireMimeDto;
import com.lj.eshop.service.IRetireMimeService;
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
public class RetireMimeServiceImpl implements IRetireMimeService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(RetireMimeServiceImpl.class);
	

	@Resource
	private IRetireMimeDao retireMimeDao;
	
	
	@Override
	public void addRetireMime(
			RetireMimeDto retireMimeDto) throws TsfaServiceException {
		logger.debug("addRetireMime(AddRetireMime addRetireMime={}) - start", retireMimeDto); 

		AssertUtils.notNull(retireMimeDto);
		try {
			RetireMime retireMime = new RetireMime();
			//add数据录入
			retireMime.setCode(GUID.generateCode());
			retireMime.setPhone(retireMimeDto.getPhone());
			retireMime.setMemberName(retireMimeDto.getMemberName());
			retireMime.setCellMime(retireMimeDto.getCellMime());
			retireMime.setExpressNo(retireMimeDto.getExpressNo());
			retireMime.setExpressName(retireMimeDto.getExpressName());
			retireMime.setCreateTime(retireMimeDto.getCreateTime());
			retireMime.setStatus(retireMimeDto.getStatus());
			retireMime.setRemarks(retireMimeDto.getRemarks());
			retireMimeDao.insertSelective(retireMime);
			logger.debug("addRetireMime(RetireMimeDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增退设备信息错误！",e);
			throw new TsfaServiceException(ErrorCode.RETIRE_MIME_ADD_ERROR,"新增退设备信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询退设备信息
	 *
	 * @param findRetireMimePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<RetireMimeDto>  findRetireMimes(FindRetireMimePage findRetireMimePage)throws TsfaServiceException{
		AssertUtils.notNull(findRetireMimePage);
		List<RetireMimeDto> returnList=null;
		try {
			returnList = retireMimeDao.findRetireMimes(findRetireMimePage);
		} catch (Exception e) {
			logger.error("查找退设备信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.RETIRE_MIME_NOT_EXIST_ERROR,"退设备信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateRetireMime(
			RetireMimeDto retireMimeDto)
			throws TsfaServiceException {
		logger.debug("updateRetireMime(RetireMimeDto retireMimeDto={}) - start", retireMimeDto); //$NON-NLS-1$

		AssertUtils.notNull(retireMimeDto);
		AssertUtils.notNullAndEmpty(retireMimeDto.getCode(),"Code不能为空");
		try {
			RetireMime retireMime = new RetireMime();
			//update数据录入
			retireMime.setCode(retireMimeDto.getCode());
			retireMime.setPhone(retireMimeDto.getPhone());
			retireMime.setMemberName(retireMimeDto.getMemberName());
			retireMime.setCellMime(retireMimeDto.getCellMime());
			retireMime.setExpressNo(retireMimeDto.getExpressNo());
			retireMime.setExpressName(retireMimeDto.getExpressName());
			retireMime.setCreateTime(retireMimeDto.getCreateTime());
			retireMime.setStatus(retireMimeDto.getStatus());
			retireMime.setRemarks(retireMimeDto.getRemarks());
			AssertUtils.notUpdateMoreThanOne(retireMimeDao.updateByPrimaryKeySelective(retireMime));
			logger.debug("updateRetireMime(RetireMimeDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("退设备信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.RETIRE_MIME_UPDATE_ERROR,"退设备信息更新信息错误！",e);
		}
	}

	

	@Override
	public RetireMimeDto findRetireMime(
			RetireMimeDto retireMimeDto) throws TsfaServiceException {
		logger.debug("findRetireMime(FindRetireMime findRetireMime={}) - start", retireMimeDto); //$NON-NLS-1$

		AssertUtils.notNull(retireMimeDto);
		AssertUtils.notAllNull(retireMimeDto.getCode(),"Code不能为空");
		try {
			RetireMime retireMime = retireMimeDao.selectByPrimaryKey(retireMimeDto.getCode());
			if(retireMime == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.RETIRE_MIME_NOT_EXIST_ERROR,"退设备信息不存在");
			}
			RetireMimeDto findRetireMimeReturn = new RetireMimeDto();
			//find数据录入
			findRetireMimeReturn.setCode(retireMime.getCode());
			findRetireMimeReturn.setPhone(retireMime.getPhone());
			findRetireMimeReturn.setMemberName(retireMime.getMemberName());
			findRetireMimeReturn.setCellMime(retireMime.getCellMime());
			findRetireMimeReturn.setExpressNo(retireMime.getExpressNo());
			findRetireMimeReturn.setExpressName(retireMime.getExpressName());
			findRetireMimeReturn.setCreateTime(retireMime.getCreateTime());
			findRetireMimeReturn.setStatus(retireMime.getStatus());
			findRetireMimeReturn.setRemarks(retireMime.getRemarks());
			
			logger.debug("findRetireMime(RetireMimeDto) - end - return value={}", findRetireMimeReturn); //$NON-NLS-1$
			return findRetireMimeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找退设备信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.RETIRE_MIME_FIND_ERROR,"查找退设备信息信息错误！",e);
		}


	}

	
	@Override
	public Page<RetireMimeDto> findRetireMimePage(
			FindRetireMimePage findRetireMimePage)
			throws TsfaServiceException {
		logger.debug("findRetireMimePage(FindRetireMimePage findRetireMimePage={}) - start", findRetireMimePage); //$NON-NLS-1$

		AssertUtils.notNull(findRetireMimePage);
		List<RetireMimeDto> returnList=null;
		int count = 0;
		try {
			returnList = retireMimeDao.findRetireMimePage(findRetireMimePage);
			count = retireMimeDao.findRetireMimePageCount(findRetireMimePage);
		}  catch (Exception e) {
			logger.error("退设备信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.RETIRE_MIME_FIND_PAGE_ERROR,"退设备信息不存在错误.！",e);
		}
		Page<RetireMimeDto> returnPage = new Page<RetireMimeDto>(returnList, count, findRetireMimePage);

		logger.debug("findRetireMimePage(FindRetireMimePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
