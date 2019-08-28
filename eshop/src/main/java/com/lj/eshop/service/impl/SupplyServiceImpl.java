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
import org.springframework.transaction.annotation.Transactional;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dao.IAccountDao;
import com.lj.eshop.dao.IMemberDao;
import com.lj.eshop.dao.ISupplyDao;
import com.lj.eshop.domain.Account;
import com.lj.eshop.domain.Member;
import com.lj.eshop.domain.Supply;
import com.lj.eshop.dto.FindSupplyPage;
import com.lj.eshop.dto.SupplyDto;
import com.lj.eshop.emus.AccountStatus;
import com.lj.eshop.emus.AccountType;
import com.lj.eshop.emus.MemberStatus;
import com.lj.eshop.emus.MemberType;
import com.lj.eshop.service.ISupplyService;
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
public class SupplyServiceImpl implements ISupplyService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(SupplyServiceImpl.class);
	

	@Resource
	private ISupplyDao supplyDao;
	@Resource
	private IMemberDao memberDao;
	@Resource
	private IAccountDao accountDao;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void addSupply(
			SupplyDto supplyDto) throws TsfaServiceException {
		logger.debug("addSupply(AddSupply addSupply={}) - start", supplyDto); 

		AssertUtils.notNull(supplyDto);
		try {
			Supply supply = new Supply();
			//add数据录入
			supply.setCode(GUID.generateCode());
			supply.setSupplyName(supplyDto.getSupplyName());
			supply.setSupplyCode(supplyDto.getSupplyCode());
			supply.setTel(supplyDto.getTel());
			supply.setEmail(supplyDto.getEmail());
			supply.setStatus(supplyDto.getStatus());
			supply.setFax(supplyDto.getFax());
			supply.setPayType(supplyDto.getPayType());
			supply.setAccountDays(supplyDto.getAccountDays());
			supply.setBankNo(supplyDto.getBankNo());
			supply.setBankName(supplyDto.getBankName());
			supply.setRemarks(supplyDto.getRemarks());
			supply.setUpdateTime(supplyDto.getUpdateTime());
			supply.setCreateTime(new Date());
			supply.setDiscountOff(supplyDto.getDiscountOff());
			supply.setBillStart(supplyDto.getBillStart());
			supply.setAddrs(supplyDto.getAddrs());
			supply.setMerchantCode(supplyDto.getMerchantCode());
			supply.setMerchantName(supplyDto.getMerchantName());
			supply.setBankAccName(supplyDto.getBankAccName());
			supply.setBankBranch(supplyDto.getBankBranch());
			supplyDao.insertSelective(supply);
			
			//二：同时给供应商开会员
			Member member=new Member();
			member.setCode(GUID.generateCode());
			member.setStatus(MemberStatus.NORMAL.getValue());
			member.setOpenId(supply.getCode());
			member.setCreateTime(new Date());
			member.setType(MemberType.SHOP.getValue());
			member.setMerchantCode(supply.getMerchantCode());
			memberDao.insertSelective(member);
			//三：开虚拟账户
			Account account=new Account();
			account.setCode(GUID.generateCode());
			account.setMbrCode(member.getCode());
			account.setCreateTime(new Date());
			account.setStatus(AccountStatus.NORMAL.getValue());
			account.setType(AccountType.ACC.getValue());
			account.setUpdateTime(new Date());
			//账号accNo生成规则，供应商虚拟账户不用，暂时不存
			account.setAccNo(NoUtil.generateNo(NoUtil.JY));
			accountDao.insertSelective(account);
			logger.debug("addSupply(SupplyDto) - end - return"); 
			
			
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增供应商信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUPPLY_ADD_ERROR,"新增供应商信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询供应商信息
	 *
	 * @param findSupplyPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<SupplyDto>  findSupplys(FindSupplyPage findSupplyPage)throws TsfaServiceException{
		AssertUtils.notNull(findSupplyPage);
		List<SupplyDto> returnList=null;
		try {
			returnList = supplyDao.findSupplys(findSupplyPage);
		} catch (Exception e) {
			logger.error("查找供应商信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SUPPLY_NOT_EXIST_ERROR,"供应商信息不存在");
		}
		return returnList;
	}
	

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateSupply(
			SupplyDto supplyDto)
			throws TsfaServiceException {
		logger.debug("updateSupply(SupplyDto supplyDto={}) - start", supplyDto); //$NON-NLS-1$

		AssertUtils.notNull(supplyDto);
		AssertUtils.notNullAndEmpty(supplyDto.getCode(),"Code不能为空");
		try {
			Supply supply = new Supply();
			//update数据录入
			supply.setCode(supplyDto.getCode());
			supply.setSupplyName(supplyDto.getSupplyName());
			supply.setSupplyCode(supplyDto.getSupplyCode());
			supply.setTel(supplyDto.getTel());
			supply.setEmail(supplyDto.getEmail());
			supply.setStatus(supplyDto.getStatus());
			supply.setFax(supplyDto.getFax());
			supply.setPayType(supplyDto.getPayType());
			supply.setAccountDays(supplyDto.getAccountDays());
			supply.setBankNo(supplyDto.getBankNo());
			supply.setBankName(supplyDto.getBankName());
			supply.setRemarks(supplyDto.getRemarks());
			supply.setUpdateTime(new Date());
			supply.setDiscountOff(supplyDto.getDiscountOff());
			supply.setBillStart(supplyDto.getBillStart());
			supply.setAddrs(supplyDto.getAddrs());
			supply.setMerchantCode(supplyDto.getMerchantCode());
			supply.setMerchantName(supplyDto.getMerchantName());
			supply.setBankAccName(supplyDto.getBankAccName());
			supply.setBankBranch(supplyDto.getBankBranch());
			AssertUtils.notUpdateMoreThanOne(supplyDao.updateByPrimaryKeySelective(supply));
			logger.debug("updateSupply(SupplyDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("供应商信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUPPLY_UPDATE_ERROR,"供应商信息更新信息错误！",e);
		}
	}

	

	@Override
	public SupplyDto findSupply(
			SupplyDto supplyDto) throws TsfaServiceException {
		logger.debug("findSupply(FindSupply findSupply={}) - start", supplyDto); //$NON-NLS-1$

		AssertUtils.notNull(supplyDto);
		AssertUtils.notAllNull(supplyDto.getCode(),"Code不能为空");
		try {
			Supply supply = supplyDao.selectByPrimaryKey(supplyDto.getCode());
			if(supply == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.SUPPLY_NOT_EXIST_ERROR,"供应商信息不存在");
			}
			SupplyDto findSupplyReturn = new SupplyDto();
			//find数据录入
			findSupplyReturn.setCode(supply.getCode());
			findSupplyReturn.setSupplyName(supply.getSupplyName());
			findSupplyReturn.setSupplyCode(supply.getSupplyCode());
			findSupplyReturn.setTel(supply.getTel());
			findSupplyReturn.setEmail(supply.getEmail());
			findSupplyReturn.setStatus(supply.getStatus());
			findSupplyReturn.setFax(supply.getFax());
			findSupplyReturn.setPayType(supply.getPayType());
			findSupplyReturn.setAccountDays(supply.getAccountDays());
			findSupplyReturn.setBankNo(supply.getBankNo());
			findSupplyReturn.setBankName(supply.getBankName());
			findSupplyReturn.setRemarks(supply.getRemarks());
			findSupplyReturn.setUpdateTime(supply.getUpdateTime());
			findSupplyReturn.setCreateTime(supply.getCreateTime());
			findSupplyReturn.setDiscountOff(supply.getDiscountOff());
			findSupplyReturn.setBillStart(supply.getBillStart());
			findSupplyReturn.setAddrs(supply.getAddrs());
			findSupplyReturn.setMerchantCode(supply.getMerchantCode());
			findSupplyReturn.setMerchantName(supply.getMerchantName());
			findSupplyReturn.setBankAccName(supply.getBankAccName());
			findSupplyReturn.setBankBranch(supply.getBankBranch());
			
			logger.debug("findSupply(SupplyDto) - end - return value={}", findSupplyReturn); //$NON-NLS-1$
			return findSupplyReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找供应商信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUPPLY_FIND_ERROR,"查找供应商信息信息错误！",e);
		}


	}

	
	@Override
	public Page<SupplyDto> findSupplyPage(
			FindSupplyPage findSupplyPage)
			throws TsfaServiceException {
		logger.debug("findSupplyPage(FindSupplyPage findSupplyPage={}) - start", findSupplyPage); //$NON-NLS-1$

		AssertUtils.notNull(findSupplyPage);
		List<SupplyDto> returnList=null;
		int count = 0;
		try {
			returnList = supplyDao.findSupplyPage(findSupplyPage);
			count = supplyDao.findSupplyPageCount(findSupplyPage);
		}  catch (Exception e) {
			logger.error("供应商信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SUPPLY_FIND_PAGE_ERROR,"供应商信息不存在错误.！",e);
		}
		Page<SupplyDto> returnPage = new Page<SupplyDto>(returnList, count, findSupplyPage);

		logger.debug("findSupplyPage(FindSupplyPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
