package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
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
import com.lj.eshop.dao.IAccWaterDao;
import com.lj.eshop.domain.AccWater;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.service.IAccWaterService;
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
public class AccWaterServiceImpl implements IAccWaterService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(AccWaterServiceImpl.class);
	

	@Resource
	private IAccWaterDao accWaterDao;
	
	
	@Override
	public void addAccWater(
			AccWaterDto accWaterDto) throws TsfaServiceException {
		logger.debug("addAccWater(AddAccWater addAccWater={}) - start", accWaterDto); 

		AssertUtils.notNull(accWaterDto);
		try {
			AccWater accWater = new AccWater();
			//add数据录入
			accWater.setCode(GUID.generateCode());
			accWater.setAccWaterNo(GUID.generateByUUID());
			accWater.setAccDate(accWaterDto.getAccDate());
			accWater.setAccSource(accWaterDto.getAccSource());
			accWater.setAccType(accWaterDto.getAccType());
			accWater.setTranOrderNo(accWaterDto.getTranOrderNo());
			accWater.setAmt(accWaterDto.getAmt());
			accWater.setAccNo(accWaterDto.getAccNo());
			accWater.setStatus(accWaterDto.getStatus());
			accWater.setPayType(accWaterDto.getPayType());
			accWater.setBeforeAmt(accWaterDto.getBeforeAmt());
			accWater.setAfterAmt(accWaterDto.getAfterAmt());
			accWater.setBizType(accWaterDto.getBizType());
			accWater.setUpdateTime(new Date());
			accWater.setOpCode(accWaterDto.getOpCode());
			accWater.setWaterType(accWaterDto.getWaterType());
			accWater.setAccCode(accWaterDto.getAccCode());
			accWaterDao.insertSelective(accWater);
			logger.debug("addAccWater(AccWaterDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增账户流水信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACC_WATER_ADD_ERROR,"新增账户流水信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询账户流水信息
	 *
	 * @param findAccWaterPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<AccWaterDto>  findAccWaters(FindAccWaterPage findAccWaterPage)throws TsfaServiceException{
		AssertUtils.notNull(findAccWaterPage);
		List<AccWaterDto> returnList=null;
		try {
		returnList = accWaterDao.findAccWaters(findAccWaterPage);
		} catch (Exception e) {
			logger.error("查找账户流水信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ACC_WATER_NOT_EXIST_ERROR,"账户流水信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateAccWater(
			AccWaterDto accWaterDto)
			throws TsfaServiceException {
		logger.debug("updateAccWater(AccWaterDto accWaterDto={}) - start", accWaterDto); //$NON-NLS-1$

		AssertUtils.notNull(accWaterDto);
		AssertUtils.notNullAndEmpty(accWaterDto.getCode(),"Code不能为空");
		try {
			AccWater accWater = new AccWater();
			//update数据录入
			accWater.setCode(accWaterDto.getCode());
			accWater.setAccWaterNo(accWaterDto.getAccWaterNo());
			accWater.setAccDate(accWaterDto.getAccDate());
			accWater.setAccSource(accWaterDto.getAccSource());
			accWater.setAccType(accWaterDto.getAccType());
			accWater.setTranOrderNo(accWaterDto.getTranOrderNo());
			accWater.setAmt(accWaterDto.getAmt());
			accWater.setAccNo(accWaterDto.getAccNo());
			accWater.setStatus(accWaterDto.getStatus());
			accWater.setPayType(accWaterDto.getPayType());
			accWater.setBeforeAmt(accWaterDto.getBeforeAmt());
			accWater.setAfterAmt(accWaterDto.getAfterAmt());
			accWater.setBizType(accWaterDto.getBizType());
			accWater.setUpdateTime(new Date());
			accWater.setOpCode(accWaterDto.getOpCode());
			accWater.setWaterType(accWaterDto.getWaterType());
			accWater.setAccCode(accWaterDto.getAccCode());
			AssertUtils.notUpdateMoreThanOne(accWaterDao.updateByPrimaryKeySelective(accWater));
			logger.debug("updateAccWater(AccWaterDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("账户流水信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACC_WATER_UPDATE_ERROR,"账户流水信息更新信息错误！",e);
		}
	}

	

	@Override
	public AccWaterDto findAccWater(
			AccWaterDto accWaterDto) throws TsfaServiceException {
		logger.debug("findAccWater(FindAccWater findAccWater={}) - start", accWaterDto); //$NON-NLS-1$

		AssertUtils.notNull(accWaterDto);
		AssertUtils.notAllNull(accWaterDto.getCode(),"Code不能为空");
		try {
			AccWater accWater = accWaterDao.selectByPrimaryKey(accWaterDto.getCode());
			if(accWater == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.ACC_WATER_NOT_EXIST_ERROR,"账户流水信息不存在");
			}
			AccWaterDto findAccWaterReturn = new AccWaterDto();
			//find数据录入
			findAccWaterReturn.setCode(accWater.getCode());
			findAccWaterReturn.setAccWaterNo(accWater.getAccWaterNo());
			findAccWaterReturn.setAccDate(accWater.getAccDate());
			findAccWaterReturn.setAccSource(accWater.getAccSource());
			findAccWaterReturn.setAccType(accWater.getAccType());
			findAccWaterReturn.setTranOrderNo(accWater.getTranOrderNo());
			findAccWaterReturn.setAmt(accWater.getAmt());
			findAccWaterReturn.setAccNo(accWater.getAccNo());
			findAccWaterReturn.setStatus(accWater.getStatus());
			findAccWaterReturn.setPayType(accWater.getPayType());
			findAccWaterReturn.setBeforeAmt(accWater.getBeforeAmt());
			findAccWaterReturn.setAfterAmt(accWater.getAfterAmt());
			findAccWaterReturn.setBizType(accWater.getBizType());
			findAccWaterReturn.setUpdateTime(accWater.getUpdateTime());
			findAccWaterReturn.setOpCode(accWater.getOpCode());
			findAccWaterReturn.setWaterType(accWater.getWaterType());
			findAccWaterReturn.setAccCode(accWater.getAccCode());
			logger.debug("findAccWater(AccWaterDto) - end - return value={}", findAccWaterReturn); //$NON-NLS-1$
			return findAccWaterReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找账户流水信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ACC_WATER_FIND_ERROR,"查找账户流水信息信息错误！",e);
		}


	}

	
	@Override
	public Page<AccWaterDto> findAccWaterPage(
			FindAccWaterPage findAccWaterPage)
			throws TsfaServiceException {
		logger.debug("findAccWaterPage(FindAccWaterPage findAccWaterPage={}) - start", findAccWaterPage); //$NON-NLS-1$

		AssertUtils.notNull(findAccWaterPage);
		List<AccWaterDto> returnList=null;
		int count = 0;
		try {
		returnList = accWaterDao.findAccWaterPage(findAccWaterPage);
		count = accWaterDao.findAccWaterPageCount(findAccWaterPage);
		}  catch (Exception e) {
			logger.error("账户流水信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.ACC_WATER_FIND_PAGE_ERROR,"账户流水信息不存在错误.！",e);
		}
		Page<AccWaterDto> returnPage = new Page<AccWaterDto>(returnList, count, findAccWaterPage);

		logger.debug("findAccWaterPage(FindAccWaterPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.eshop.service.IAccWaterService#findIncomeAmt(com.lj.eshop.dto.FindAccWaterPage)
	 */
	@Override
	public BigDecimal findIncomeAmt(FindAccWaterPage findAccWaterPage)
			throws TsfaServiceException {
		logger.debug("findAccWaterPage(FindAccWaterPage findIncomeAmt={}) - start", findAccWaterPage); //$NON-NLS-1$

		AssertUtils.notNull(findAccWaterPage);
		BigDecimal amt = null;
		try {
			amt = accWaterDao.findIncomeAmt(findAccWaterPage);
		}  catch (Exception e) {
			logger.error("账户总收益查询错误",e);
			throw new TsfaServiceException(ErrorCode.ACC_WATER_FIND_PAGE_ERROR,"账户总收益查询错误！",e);
		}
		logger.debug("findAccWaterPage(findIncomeAmt) - end - return value={}", amt); //$NON-NLS-1$
		return  amt;
	}


	/* (non-Javadoc)
	 * @see com.lj.eshop.service.IAccWaterService#findAcctWaterDetailPage(com.lj.eshop.dto.FindAccWaterPage)
	 */
	@Override
	public Page<AccWaterDto> findAcctWaterDetailPage(
			FindAccWaterPage findAccWaterPage) throws TsfaServiceException {
		logger.debug("findAccWaterPage(FindAccWaterPage findAccWaterPage={}) - start", findAccWaterPage); //$NON-NLS-1$

		AssertUtils.notNull(findAccWaterPage);
		List<AccWaterDto> returnList=null;
		int count = 0;
		try {
			returnList = accWaterDao.findAcctWaterDetailPage(findAccWaterPage);
			count = accWaterDao.findAcctWaterDetailPageCount(findAccWaterPage);
		}  catch (Exception e) {
			logger.error("账户流水信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.ACC_WATER_FIND_PAGE_ERROR,"账户流水信息不存在错误.！",e);
		}
		Page<AccWaterDto> returnPage = new Page<AccWaterDto>(returnList, count, findAccWaterPage);

		logger.debug("findAccWaterPage(FindAccWaterPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.eshop.service.IAccWaterService#findAllAcctWaterDetailPage(com.lj.eshop.dto.FindAccWaterPage)
	 */
	@Override
	public Page<AccWaterDto> findAllAcctWaterDetailPage(
			FindAccWaterPage findAccWaterPage) throws TsfaServiceException {
		logger.debug("findAllAcctWaterDetailPage(FindAccWaterPage findAccWaterPage={}) - start", findAccWaterPage); //$NON-NLS-1$

		AssertUtils.notNull(findAccWaterPage);
		List<AccWaterDto> returnList=null;
		int count = 0;
		try {
			returnList = accWaterDao.findAllAcctWaterDetailPage(findAccWaterPage);
			count = accWaterDao.findAllAcctWaterDetailPageCount(findAccWaterPage);
		}  catch (Exception e) {
			logger.error("账户流水信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.ACC_WATER_FIND_PAGE_ERROR,"账户流水信息不存在错误.！",e);
		}
		Page<AccWaterDto> returnPage = new Page<AccWaterDto>(returnList, count, findAccWaterPage);

		logger.debug("findAllAcctWaterDetailPage(FindAccWaterPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 
	
	
}
