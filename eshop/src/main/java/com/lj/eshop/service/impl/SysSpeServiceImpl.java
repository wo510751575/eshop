package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
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
import com.lj.eshop.dao.ISysSpeDao;
import com.lj.eshop.domain.SysSpe;
import com.lj.eshop.dto.FindSysSpePage;
import com.lj.eshop.dto.SysSpeDto;
import com.lj.eshop.service.ISysSpeService;
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
public class SysSpeServiceImpl implements ISysSpeService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(SysSpeServiceImpl.class);
	

	@Resource
	private ISysSpeDao sysSpeDao;
	
	
	@Override
	public void addSysSpe(
			SysSpeDto sysSpeDto) throws TsfaServiceException {
		logger.debug("addSysSpe(AddSysSpe addSysSpe={}) - start", sysSpeDto); 

		AssertUtils.notNull(sysSpeDto);
		try {
			SysSpe sysSpe = new SysSpe();
			//add数据录入
			sysSpe.setCode(GUID.generateCode());
			sysSpe.setSpeName(sysSpeDto.getSpeName());
			sysSpe.setCreater(sysSpeDto.getCreater());
			sysSpe.setCreateTime(new Date());
			sysSpe.setStatus(sysSpeDto.getStatus());
			sysSpeDao.insertSelective(sysSpe);
			logger.debug("addSysSpe(SysSpeDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品规格信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SYS_SPE_ADD_ERROR,"新增商品规格信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品规格信息
	 *
	 * @param findSysSpePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<SysSpeDto>  findSysSpes(FindSysSpePage findSysSpePage)throws TsfaServiceException{
		AssertUtils.notNull(findSysSpePage);
		List<SysSpeDto> returnList=null;
		try {
			returnList = sysSpeDao.findSysSpes(findSysSpePage);
		} catch (Exception e) {
			logger.error("查找商品规格信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SYS_SPE_NOT_EXIST_ERROR,"商品规格信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateSysSpe(
			SysSpeDto sysSpeDto)
			throws TsfaServiceException {
		logger.debug("updateSysSpe(SysSpeDto sysSpeDto={}) - start", sysSpeDto); //$NON-NLS-1$

		AssertUtils.notNull(sysSpeDto);
		AssertUtils.notNullAndEmpty(sysSpeDto.getCode(),"Code不能为空");
		try {
			SysSpe sysSpe = new SysSpe();
			//update数据录入
			sysSpe.setCode(sysSpeDto.getCode());
			sysSpe.setSpeName(sysSpeDto.getSpeName());
			sysSpe.setCreater(sysSpeDto.getCreater());
			sysSpe.setCreateTime(sysSpeDto.getCreateTime());
			sysSpe.setStatus(sysSpeDto.getStatus());
			AssertUtils.notUpdateMoreThanOne(sysSpeDao.updateByPrimaryKeySelective(sysSpe));
			logger.debug("updateSysSpe(SysSpeDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品规格信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SYS_SPE_UPDATE_ERROR,"商品规格信息更新信息错误！",e);
		}
	}

	

	@Override
	public SysSpeDto findSysSpe(
			SysSpeDto sysSpeDto) throws TsfaServiceException {
		logger.debug("findSysSpe(FindSysSpe findSysSpe={}) - start", sysSpeDto); //$NON-NLS-1$

		AssertUtils.notNull(sysSpeDto);
		AssertUtils.notAllNull(sysSpeDto.getCode(),"Code不能为空");
		try {
			SysSpe sysSpe = sysSpeDao.selectByPrimaryKey(sysSpeDto.getCode());
			if(sysSpe == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.SYS_SPE_NOT_EXIST_ERROR,"商品规格信息不存在");
			}
			SysSpeDto findSysSpeReturn = new SysSpeDto();
			//find数据录入
			findSysSpeReturn.setCode(sysSpe.getCode());
			findSysSpeReturn.setSpeName(sysSpe.getSpeName());
			findSysSpeReturn.setCreater(sysSpe.getCreater());
			findSysSpeReturn.setCreateTime(sysSpe.getCreateTime());
			findSysSpeReturn.setStatus(sysSpe.getStatus());
			
			logger.debug("findSysSpe(SysSpeDto) - end - return value={}", findSysSpeReturn); //$NON-NLS-1$
			return findSysSpeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品规格信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SYS_SPE_FIND_ERROR,"查找商品规格信息信息错误！",e);
		}


	}

	
	@Override
	public Page<SysSpeDto> findSysSpePage(
			FindSysSpePage findSysSpePage)
			throws TsfaServiceException {
		logger.debug("findSysSpePage(FindSysSpePage findSysSpePage={}) - start", findSysSpePage); //$NON-NLS-1$

		AssertUtils.notNull(findSysSpePage);
		List<SysSpeDto> returnList=null;
		int count = 0;
		try {
			returnList = sysSpeDao.findSysSpePage(findSysSpePage);
			count = sysSpeDao.findSysSpePageCount(findSysSpePage);
		}  catch (Exception e) {
			logger.error("商品规格信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SYS_SPE_FIND_PAGE_ERROR,"商品规格信息不存在错误.！",e);
		}
		Page<SysSpeDto> returnPage = new Page<SysSpeDto>(returnList, count, findSysSpePage);

		logger.debug("findSysSpePage(FindSysSpePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
