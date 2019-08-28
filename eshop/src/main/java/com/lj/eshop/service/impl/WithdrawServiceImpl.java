package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
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
import com.lj.eshop.dao.IAccWaterDao;
import com.lj.eshop.dao.IAccountDao;
import com.lj.eshop.dao.IWithdrawDao;
import com.lj.eshop.domain.AccWater;
import com.lj.eshop.domain.Withdraw;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindWithdrawPage;
import com.lj.eshop.dto.WithdrawDto;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.WithdrawStatus;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IWithdrawService;
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
public class WithdrawServiceImpl implements IWithdrawService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(WithdrawServiceImpl.class);
	

	@Resource
	private IWithdrawDao withdrawDao;
	@Resource
	private IAccountDao accountDao;
	@Resource
	private IAccWaterDao accWaterDao ;
	@Resource
	IAccountService accountService;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void addWithdraw(
			WithdrawDto withdrawDto) throws TsfaServiceException {
		logger.debug("addWithdraw(AddWithdraw addWithdraw={}) - start", withdrawDto); 

		AssertUtils.notNull(withdrawDto);
		try {
			Withdraw withdraw = new Withdraw();
			//add数据录入
			Date now=new Date();
			withdraw.setCode(GUID.generateCode());
			withdraw.setMbrName(withdrawDto.getMbrName());
			withdraw.setMbrCode(withdrawDto.getMbrCode());
			withdraw.setAmt(withdrawDto.getAmt());
			withdraw.setBankName(withdrawDto.getBankName());
			withdraw.setBankAccNo(withdrawDto.getBankAccNo());
			withdraw.setBranchBank(withdrawDto.getBranchBank());
			withdraw.setStatus(WithdrawStatus.APPLY.getValue());
			withdraw.setPhone(withdrawDto.getPhone());
			withdraw.setFailReason(withdrawDto.getFailReason());
			withdraw.setCreateTime(now);
			withdraw.setUpdateTime(now);
			withdraw.setWithdrawNo(NoUtil.generateNo(NoUtil.JY));
			//1.申请提现
			withdrawDao.insertSelective(withdraw);
			AccountDto account=accountService.findAccountByMbrCode(withdrawDto.getMbrCode());
			BigDecimal afterAmt = account.getCashAmt()
					.subtract(withdrawDto.getAmt())
					.setScale(2, BigDecimal.ROUND_HALF_UP);
			if (afterAmt.compareTo(BigDecimal.ZERO) < 0) {
				throw new TsfaServiceException(ErrorCode.ACC_UNDERBALANCE,
						"可用余额不足");
			}
			//2.记录流水 
			AccWater accWater=new AccWater();
			accWater.setCode(GUID.generateCode());
			accWater.setAccWaterNo(GUID.generateByUUID());
			accWater.setAccDate(now);
			accWater.setAccSource(AccWaterSource.WITHDRAW.getValue());
			accWater.setAccType(AccWaterAccType.AUTO.getValue());
			accWater.setTranOrderNo(withdraw.getWithdrawNo());
			accWater.setAmt(withdraw.getAmt());
			accWater.setAccNo(account.getAccNo());
			accWater.setStatus(AccWaterStatus.SUCCESS.getValue());
			accWater.setPayType(AccWaterPayType.VIRTUAL.getValue());
			accWater.setBeforeAmt(account.getCashAmt());
			accWater.setAfterAmt(afterAmt);
			accWater.setBizType(AccWaterBizType.WITHDRAW.getValue());
			accWater.setUpdateTime(now);
			accWater.setOpCode(withdrawDto.getMbrCode());
			accWater.setWaterType(AccWaterType.SUBTRACT.getValue());
			accWater.setAccCode(account.getCode());
			accWaterDao.insertSelective(accWater);
			
			//3.扣可用余额,增提现总额
			AccountDto updateAcc=new AccountDto();
			updateAcc.setCode(account.getCode());
			updateAcc.setCashAmt(afterAmt);
			updateAcc.setTotalWithdrawAmt(account.getTotalWithdrawAmt()
					.add(withdrawDto.getAmt())
					.setScale(2, BigDecimal.ROUND_HALF_UP));
			accountService.updateAccount(updateAcc);
			logger.debug("addWithdraw(WithdrawDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增提现申请信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WITHDRAW_ADD_ERROR,"新增提现申请信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询提现申请信息
	 *
	 * @param findWithdrawPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<WithdrawDto>  findWithdraws(FindWithdrawPage findWithdrawPage)throws TsfaServiceException{
		AssertUtils.notNull(findWithdrawPage);
		List<WithdrawDto> returnList=null;
		try {
			returnList = withdrawDao.findWithdraws(findWithdrawPage);
		} catch (Exception e) {
			logger.error("查找提现申请信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.WITHDRAW_NOT_EXIST_ERROR,"提现申请信息不存在");
		}
		return returnList;
	}
	

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateWithdraw(
			WithdrawDto withdrawDto)
			throws TsfaServiceException {
		logger.debug("updateWithdraw(WithdrawDto withdrawDto={}) - start", withdrawDto); //$NON-NLS-1$

		AssertUtils.notNull(withdrawDto);
		AssertUtils.notNullAndEmpty(withdrawDto.getCode(),"Code不能为空");
		try {
			Withdraw withdraw = new Withdraw();
			//update数据录入
			withdraw.setCode(withdrawDto.getCode());
			withdraw.setMbrName(withdrawDto.getMbrName());
			withdraw.setMbrCode(withdrawDto.getMbrCode());
			withdraw.setAmt(withdrawDto.getAmt());
			withdraw.setBankName(withdrawDto.getBankName());
			withdraw.setBankAccNo(withdrawDto.getBankAccNo());
			withdraw.setBranchBank(withdrawDto.getBranchBank());
			withdraw.setStatus(withdrawDto.getStatus());
			withdraw.setPhone(withdrawDto.getPhone());
			withdraw.setFailReason(withdrawDto.getFailReason());
			withdraw.setUpdateTime(new Date());
			withdraw.setWithdrawNo(withdrawDto.getWithdrawNo());
			AssertUtils.notUpdateMoreThanOne(withdrawDao.updateByPrimaryKeySelective(withdraw));
			logger.debug("updateWithdraw(WithdrawDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("提现申请信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WITHDRAW_UPDATE_ERROR,"提现申请信息更新信息错误！",e);
		}
	}

	

	@Override
	public WithdrawDto findWithdraw(
			WithdrawDto withdrawDto) throws TsfaServiceException {
		logger.debug("findWithdraw(FindWithdraw findWithdraw={}) - start", withdrawDto); //$NON-NLS-1$

		AssertUtils.notNull(withdrawDto);
		AssertUtils.notAllNull(withdrawDto.getCode(),"Code不能为空");
		try {
			Withdraw withdraw = withdrawDao.selectByPrimaryKey(withdrawDto.getCode());
			if(withdraw == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.WITHDRAW_NOT_EXIST_ERROR,"提现申请信息不存在");
			}
			WithdrawDto findWithdrawReturn = new WithdrawDto();
			//find数据录入
			findWithdrawReturn.setCode(withdraw.getCode());
			findWithdrawReturn.setMbrName(withdraw.getMbrName());
			findWithdrawReturn.setMbrCode(withdraw.getMbrCode());
			findWithdrawReturn.setAmt(withdraw.getAmt());
			findWithdrawReturn.setBankName(withdraw.getBankName());
			findWithdrawReturn.setBankAccNo(withdraw.getBankAccNo());
			findWithdrawReturn.setBranchBank(withdraw.getBranchBank());
			findWithdrawReturn.setStatus(withdraw.getStatus());
			findWithdrawReturn.setPhone(withdraw.getPhone());
			findWithdrawReturn.setFailReason(withdraw.getFailReason());
			findWithdrawReturn.setCreateTime(withdraw.getCreateTime());
			findWithdrawReturn.setUpdateTime(withdraw.getUpdateTime());
			findWithdrawReturn.setWithdrawNo(withdraw.getWithdrawNo());
			
			logger.debug("findWithdraw(WithdrawDto) - end - return value={}", findWithdrawReturn); //$NON-NLS-1$
			return findWithdrawReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找提现申请信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WITHDRAW_FIND_ERROR,"查找提现申请信息信息错误！",e);
		}


	}

	
	@Override
	public Page<WithdrawDto> findWithdrawPage(
			FindWithdrawPage findWithdrawPage)
			throws TsfaServiceException {
		logger.debug("findWithdrawPage(FindWithdrawPage findWithdrawPage={}) - start", findWithdrawPage); //$NON-NLS-1$

		AssertUtils.notNull(findWithdrawPage);
		List<WithdrawDto> returnList=null;
		int count = 0;
		try {
			returnList = withdrawDao.findWithdrawPage(findWithdrawPage);
			count = withdrawDao.findWithdrawPageCount(findWithdrawPage);
		}  catch (Exception e) {
			logger.error("提现申请信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.WITHDRAW_FIND_PAGE_ERROR,"提现申请信息不存在错误.！",e);
		}
		Page<WithdrawDto> returnPage = new Page<WithdrawDto>(returnList, count, findWithdrawPage);

		logger.debug("findWithdrawPage(FindWithdrawPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
