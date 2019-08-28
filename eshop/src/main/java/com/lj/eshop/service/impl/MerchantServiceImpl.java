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
import com.lj.eshop.dao.IMerchantDao;
import com.lj.eshop.domain.Merchant;
import com.lj.eshop.dto.FindMerchantPage;
import com.lj.eshop.dto.MerchantDto;
import com.lj.eshop.service.IMerchantService;
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
public class MerchantServiceImpl implements IMerchantService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MerchantServiceImpl.class);
	

	@Resource
	private IMerchantDao merchantDao;
	
	
	@Override
	public void addMerchant(
			MerchantDto merchantDto) throws TsfaServiceException {
		logger.debug("addMerchant(AddMerchant addMerchant={}) - start", merchantDto); 

		AssertUtils.notNull(merchantDto);
		try {
			Merchant merchant = new Merchant();
			//add数据录入
			merchant.setCode(GUID.generateCode());
			merchant.setMerchantName(merchantDto.getMerchantName());
			merchant.setMerchantPhone(merchantDto.getMerchantPhone());
			merchant.setMerchantAddr(merchantDto.getMerchantAddr());
			merchant.setCreateTime(merchantDto.getCreateTime());
			merchant.setOfficeId(merchantDto.getOfficeId());
			merchantDao.insertSelective(merchant);
			logger.debug("addMerchant(MerchantDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商户信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_ADD_ERROR,"新增商户信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商户信息
	 *
	 * @param findMerchantPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<MerchantDto>  findMerchants(FindMerchantPage findMerchantPage)throws TsfaServiceException{
		AssertUtils.notNull(findMerchantPage);
		List<MerchantDto> returnList=null;
		try {
			returnList = merchantDao.findMerchants(findMerchantPage);
		} catch (Exception e) {
			logger.error("查找商户信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_NOT_EXIST_ERROR,"商户信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateMerchant(
			MerchantDto merchantDto)
			throws TsfaServiceException {
		logger.debug("updateMerchant(MerchantDto merchantDto={}) - start", merchantDto); //$NON-NLS-1$

		AssertUtils.notNull(merchantDto);
		AssertUtils.notNullAndEmpty(merchantDto.getCode(),"Code不能为空");
		try {
			Merchant merchant = new Merchant();
			//update数据录入
			merchant.setCode(merchantDto.getCode());
			merchant.setMerchantName(merchantDto.getMerchantName());
			merchant.setMerchantPhone(merchantDto.getMerchantPhone());
			merchant.setMerchantAddr(merchantDto.getMerchantAddr());
			merchant.setCreateTime(merchantDto.getCreateTime());
			merchant.setOfficeId(merchantDto.getOfficeId());
			AssertUtils.notUpdateMoreThanOne(merchantDao.updateByPrimaryKeySelective(merchant));
			logger.debug("updateMerchant(MerchantDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商户信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_UPDATE_ERROR,"商户信息更新信息错误！",e);
		}
	}

	

	@Override
	public MerchantDto findMerchant(
			MerchantDto merchantDto) throws TsfaServiceException {
		logger.debug("findMerchant(FindMerchant findMerchant={}) - start", merchantDto); //$NON-NLS-1$

		AssertUtils.notNull(merchantDto);
		AssertUtils.notAllNull(merchantDto.getCode(),"Code不能为空");
		try {
			Merchant merchant = merchantDao.selectByPrimaryKey(merchantDto.getCode());
			if(merchant == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.MERCHANT_NOT_EXIST_ERROR,"商户信息不存在");
			}
			MerchantDto findMerchantReturn = new MerchantDto();
			//find数据录入
			findMerchantReturn.setCode(merchant.getCode());
			findMerchantReturn.setMerchantName(merchant.getMerchantName());
			findMerchantReturn.setMerchantPhone(merchant.getMerchantPhone());
			findMerchantReturn.setMerchantAddr(merchant.getMerchantAddr());
			findMerchantReturn.setCreateTime(merchant.getCreateTime());
			findMerchantReturn.setOfficeId(merchant.getOfficeId());
			logger.debug("findMerchant(MerchantDto) - end - return value={}", findMerchantReturn); //$NON-NLS-1$
			return findMerchantReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商户信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_FIND_ERROR,"查找商户信息信息错误！",e);
		}


	}

	
	@Override
	public Page<MerchantDto> findMerchantPage(
			FindMerchantPage findMerchantPage)
			throws TsfaServiceException {
		logger.debug("findMerchantPage(FindMerchantPage findMerchantPage={}) - start", findMerchantPage); //$NON-NLS-1$

		AssertUtils.notNull(findMerchantPage);
		List<MerchantDto> returnList=null;
		int count = 0;
		try {
			returnList = merchantDao.findMerchantPage(findMerchantPage);
			count = merchantDao.findMerchantPageCount(findMerchantPage);
		}  catch (Exception e) {
			logger.error("商户信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_FIND_PAGE_ERROR,"商户信息不存在错误.！",e);
		}
		Page<MerchantDto> returnPage = new Page<MerchantDto>(returnList, count, findMerchantPage);

		logger.debug("findMerchantPage(FindMerchantPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
