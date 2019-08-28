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
import com.lj.eshop.dao.IMbrbankDao;
import com.lj.eshop.domain.Mbrbank;
import com.lj.eshop.dto.FindMbrbankPage;
import com.lj.eshop.dto.MbrbankDto;
import com.lj.eshop.service.IMbrbankService;
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
public class MbrbankServiceImpl implements IMbrbankService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MbrbankServiceImpl.class);
	

	@Resource
	private IMbrbankDao mbrbankDao;
	
	
	@Override
	public void addMbrbank(
			MbrbankDto mbrbankDto) throws TsfaServiceException {
		logger.debug("addMbrbank(AddMbrbank addMbrbank={}) - start", mbrbankDto); 

		AssertUtils.notNull(mbrbankDto);
		try {
			Mbrbank mbrbank = new Mbrbank();
			//add数据录入
			mbrbank.setCode(GUID.generateCode());
			mbrbank.setMbrCode(mbrbankDto.getMbrCode());
			mbrbank.setBankName(mbrbankDto.getBankName());
			mbrbank.setBranchBank(mbrbankDto.getBranchBank());
			mbrbank.setBankAccNo(mbrbankDto.getBankAccNo());
			mbrbank.setAccName(mbrbankDto.getAccName());
			mbrbank.setCreateTime(new Date());
			mbrbank.setBankCode(mbrbankDto.getBankCode());
			mbrbank.setPhone(mbrbankDto.getPhone());
			mbrbankDao.insertSelective(mbrbank);
			logger.debug("addMbrbank(MbrbankDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增银行卡信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MBRBANK_ADD_ERROR,"新增银行卡信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询银行卡信息
	 *
	 * @param findMbrbankPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<MbrbankDto>  findMbrbanks(FindMbrbankPage findMbrbankPage)throws TsfaServiceException{
		AssertUtils.notNull(findMbrbankPage);
		List<MbrbankDto> returnList=null;
		try {
			returnList = mbrbankDao.findMbrbanks(findMbrbankPage);
		} catch (Exception e) {
			logger.error("查找银行卡信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MBRBANK_NOT_EXIST_ERROR,"银行卡信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateMbrbank(
			MbrbankDto mbrbankDto)
			throws TsfaServiceException {
		logger.debug("updateMbrbank(MbrbankDto mbrbankDto={}) - start", mbrbankDto); //$NON-NLS-1$

		AssertUtils.notNull(mbrbankDto);
		AssertUtils.notNullAndEmpty(mbrbankDto.getCode(),"Code不能为空");
		try {
			Mbrbank mbrbank = new Mbrbank();
			//update数据录入
			mbrbank.setCode(mbrbankDto.getCode());
			mbrbank.setMbrCode(mbrbankDto.getMbrCode());
			mbrbank.setBankName(mbrbankDto.getBankName());
			mbrbank.setBranchBank(mbrbankDto.getBranchBank());
			mbrbank.setBankAccNo(mbrbankDto.getBankAccNo());
			mbrbank.setAccName(mbrbankDto.getAccName());
			//mbrbank.setCreateTime(mbrbankDto.getCreateTime());
			mbrbank.setBankCode(mbrbankDto.getBankCode());
			mbrbank.setPhone(mbrbankDto.getPhone());
			AssertUtils.notUpdateMoreThanOne(mbrbankDao.updateByPrimaryKeySelective(mbrbank));
			logger.debug("updateMbrbank(MbrbankDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("银行卡信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MBRBANK_UPDATE_ERROR,"银行卡信息更新信息错误！",e);
		}
	}

	

	@Override
	public MbrbankDto findMbrbank(
			MbrbankDto mbrbankDto) throws TsfaServiceException {
		logger.debug("findMbrbank(FindMbrbank findMbrbank={}) - start", mbrbankDto); //$NON-NLS-1$

		AssertUtils.notNull(mbrbankDto);
		AssertUtils.notAllNull(mbrbankDto.getCode(),"Code不能为空");
		try {
			Mbrbank mbrbank = mbrbankDao.selectByPrimaryKey(mbrbankDto.getCode());
			if(mbrbank == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.MBRBANK_NOT_EXIST_ERROR,"银行卡信息不存在");
			}
			MbrbankDto findMbrbankReturn = new MbrbankDto();
			//find数据录入
			findMbrbankReturn.setCode(mbrbank.getCode());
			findMbrbankReturn.setMbrCode(mbrbank.getMbrCode());
			findMbrbankReturn.setBankName(mbrbank.getBankName());
			findMbrbankReturn.setBranchBank(mbrbank.getBranchBank());
			findMbrbankReturn.setBankAccNo(mbrbank.getBankAccNo());
			findMbrbankReturn.setAccName(mbrbank.getAccName());
			findMbrbankReturn.setCreateTime(mbrbank.getCreateTime());
			findMbrbankReturn.setBankCode(mbrbank.getBankCode());
			findMbrbankReturn.setPhone(mbrbank.getPhone());
			logger.debug("findMbrbank(MbrbankDto) - end - return value={}", findMbrbankReturn); //$NON-NLS-1$
			return findMbrbankReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找银行卡信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MBRBANK_FIND_ERROR,"查找银行卡信息信息错误！",e);
		}


	}

	
	@Override
	public Page<MbrbankDto> findMbrbankPage(
			FindMbrbankPage findMbrbankPage)
			throws TsfaServiceException {
		logger.debug("findMbrbankPage(FindMbrbankPage findMbrbankPage={}) - start", findMbrbankPage); //$NON-NLS-1$

		AssertUtils.notNull(findMbrbankPage);
		List<MbrbankDto> returnList=null;
		int count = 0;
		try {
			returnList = mbrbankDao.findMbrbankPage(findMbrbankPage);
			count = mbrbankDao.findMbrbankPageCount(findMbrbankPage);
		}  catch (Exception e) {
			logger.error("银行卡信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MBRBANK_FIND_PAGE_ERROR,"银行卡信息不存在错误.！",e);
		}
		Page<MbrbankDto> returnPage = new Page<MbrbankDto>(returnList, count, findMbrbankPage);

		logger.debug("findMbrbankPage(FindMbrbankPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
