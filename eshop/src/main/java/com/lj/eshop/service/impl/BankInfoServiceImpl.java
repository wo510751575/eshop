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
import com.lj.eshop.dao.IBankInfoDao;
import com.lj.eshop.domain.BankInfo;
import com.lj.eshop.dto.BankInfoDto;
import com.lj.eshop.dto.FindBankInfoPage;
import com.lj.eshop.service.IBankInfoService;
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
public class BankInfoServiceImpl implements IBankInfoService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(BankInfoServiceImpl.class);
	

	@Resource
	private IBankInfoDao bankInfoDao;
	
	
	@Override
	public void addBankInfo(
			BankInfoDto bankInfoDto) throws TsfaServiceException {
		logger.debug("addBankInfo(AddBankInfo addBankInfo={}) - start", bankInfoDto); 

		AssertUtils.notNull(bankInfoDto);
		try {
			BankInfo bankInfo = new BankInfo();
			//add数据录入
			bankInfo.setCode(GUID.generateCode());
			bankInfo.setBankName(bankInfoDto.getBankName());
			bankInfo.setBankIcon(bankInfoDto.getBankIcon());
			bankInfo.setOrderNo(bankInfoDto.getOrderNo());
			bankInfo.setCreateTime(new Date());
			bankInfo.setBgIcon(bankInfoDto.getBgIcon());
			bankInfoDao.insertSelective(bankInfo);
			logger.debug("addBankInfo(BankInfoDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增银行卡信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BANK_INFO_ADD_ERROR,"新增银行卡信息信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询银行卡信息信息
	 *
	 * @param findBankInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<BankInfoDto>  findBankInfos(FindBankInfoPage findBankInfoPage)throws TsfaServiceException{
		AssertUtils.notNull(findBankInfoPage);
		List<BankInfoDto> returnList=null;
		try {
			returnList = bankInfoDao.findBankInfos(findBankInfoPage);
		} catch (Exception e) {
			logger.error("查找银行卡信息信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.BANK_INFO_NOT_EXIST_ERROR,"银行卡信息信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateBankInfo(
			BankInfoDto bankInfoDto)
			throws TsfaServiceException {
		logger.debug("updateBankInfo(BankInfoDto bankInfoDto={}) - start", bankInfoDto); //$NON-NLS-1$

		AssertUtils.notNull(bankInfoDto);
		AssertUtils.notNullAndEmpty(bankInfoDto.getCode(),"Code不能为空");
		try {
			BankInfo bankInfo = new BankInfo();
			//update数据录入
			bankInfo.setCode(bankInfoDto.getCode());
			bankInfo.setBankName(bankInfoDto.getBankName());
			bankInfo.setBankIcon(bankInfoDto.getBankIcon());
			bankInfo.setOrderNo(bankInfoDto.getOrderNo());
			bankInfo.setCreateTime(bankInfoDto.getCreateTime());
			bankInfo.setBgIcon(bankInfoDto.getBgIcon());
			AssertUtils.notUpdateMoreThanOne(bankInfoDao.updateByPrimaryKeySelective(bankInfo));
			logger.debug("updateBankInfo(BankInfoDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("银行卡信息信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BANK_INFO_UPDATE_ERROR,"银行卡信息信息更新信息错误！",e);
		}
	}

	

	@Override
	public BankInfoDto findBankInfo(
			BankInfoDto bankInfoDto) throws TsfaServiceException {
		logger.debug("findBankInfo(FindBankInfo findBankInfo={}) - start", bankInfoDto); //$NON-NLS-1$

		AssertUtils.notNull(bankInfoDto);
		AssertUtils.notAllNull(bankInfoDto.getCode(),"Code不能为空");
		try {
			BankInfo bankInfo = bankInfoDao.selectByPrimaryKey(bankInfoDto.getCode());
			if(bankInfo == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.BANK_INFO_NOT_EXIST_ERROR,"银行卡信息信息不存在");
			}
			BankInfoDto findBankInfoReturn = new BankInfoDto();
			//find数据录入
			findBankInfoReturn.setCode(bankInfo.getCode());
			findBankInfoReturn.setBankName(bankInfo.getBankName());
			findBankInfoReturn.setBankIcon(bankInfo.getBankIcon());
			findBankInfoReturn.setOrderNo(bankInfo.getOrderNo());
			findBankInfoReturn.setCreateTime(bankInfo.getCreateTime());
			findBankInfoReturn.setBgIcon(bankInfo.getBgIcon());
			logger.debug("findBankInfo(BankInfoDto) - end - return value={}", findBankInfoReturn); //$NON-NLS-1$
			return findBankInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找银行卡信息信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BANK_INFO_FIND_ERROR,"查找银行卡信息信息信息错误！",e);
		}


	}

	
	@Override
	public Page<BankInfoDto> findBankInfoPage(
			FindBankInfoPage findBankInfoPage)
			throws TsfaServiceException {
		logger.debug("findBankInfoPage(FindBankInfoPage findBankInfoPage={}) - start", findBankInfoPage); //$NON-NLS-1$

		AssertUtils.notNull(findBankInfoPage);
		List<BankInfoDto> returnList=null;
		int count = 0;
		try {
			returnList = bankInfoDao.findBankInfoPage(findBankInfoPage);
			count = bankInfoDao.findBankInfoPageCount(findBankInfoPage);
		}  catch (Exception e) {
			logger.error("银行卡信息信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.BANK_INFO_FIND_PAGE_ERROR,"银行卡信息信息不存在错误.！",e);
		}
		Page<BankInfoDto> returnPage = new Page<BankInfoDto>(returnList, count, findBankInfoPage);

		logger.debug("findBankInfoPage(FindBankInfoPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
