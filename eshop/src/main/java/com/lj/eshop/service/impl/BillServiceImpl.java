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
import com.lj.eshop.dao.IBillDao;
import com.lj.eshop.domain.Bill;
import com.lj.eshop.dto.BillDto;
import com.lj.eshop.dto.FindBillPage;
import com.lj.eshop.service.IBillService;
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
public class BillServiceImpl implements IBillService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);
	

	@Resource
	private IBillDao billDao;
	
	
	@Override
	public void addBill(
			BillDto billDto) throws TsfaServiceException {
		logger.debug("addBill(AddBill addBill={}) - start", billDto); 

		AssertUtils.notNull(billDto);
		try {
			Bill bill = new Bill();
			//add数据录入
			bill.setCode(GUID.generateCode());
			bill.setSupplyName(billDto.getSupplyName());
			bill.setSupplyCode(billDto.getSupplyCode());
			bill.setPhone(billDto.getPhone());
			bill.setBillAddr(billDto.getBillAddr());
			bill.setPayType(billDto.getPayType());
			bill.setAccountDays(billDto.getAccountDays());
			bill.setStatus(billDto.getStatus());
			bill.setBillDate(billDto.getBillDate());
			bill.setPayDate(billDto.getPayDate());
			bill.setAmt(billDto.getAmt());
			bill.setStartDate(billDto.getStartDate());
			bill.setEndDate(billDto.getEndDate());
			bill.setRetireAmt(billDto.getRetireAmt());
			bill.setBillFileAddrs(billDto.getBillFileAddrs());
			bill.setCnt(billDto.getCnt());
			bill.setRtCnt(billDto.getRtCnt());
			billDao.insertSelective(bill);
			logger.debug("addBill(BillDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增大B账单信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BILL_ADD_ERROR,"新增大B账单信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询大B账单信息
	 *
	 * @param findBillPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<BillDto>  findBills(FindBillPage findBillPage)throws TsfaServiceException{
		AssertUtils.notNull(findBillPage);
		List<BillDto> returnList=null;
		try {
			returnList = billDao.findBills(findBillPage);
		} catch (Exception e) {
			logger.error("查找大B账单信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.BILL_NOT_EXIST_ERROR,"大B账单信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateBill(
			BillDto billDto)
			throws TsfaServiceException {
		logger.debug("updateBill(BillDto billDto={}) - start", billDto); //$NON-NLS-1$

		AssertUtils.notNull(billDto);
		AssertUtils.notNullAndEmpty(billDto.getCode(),"Code不能为空");
		try {
			Bill bill = new Bill();
			//update数据录入
			bill.setCode(billDto.getCode());
			bill.setSupplyName(billDto.getSupplyName());
			bill.setSupplyCode(billDto.getSupplyCode());
			bill.setPhone(billDto.getPhone());
			bill.setBillAddr(billDto.getBillAddr());
			bill.setPayType(billDto.getPayType());
			bill.setAccountDays(billDto.getAccountDays());
			bill.setStatus(billDto.getStatus());
			bill.setBillDate(billDto.getBillDate());
			bill.setPayDate(billDto.getPayDate());
			bill.setAmt(billDto.getAmt());
			bill.setStartDate(billDto.getStartDate());
			bill.setEndDate(billDto.getEndDate());
			bill.setRetireAmt(billDto.getRetireAmt());
			bill.setBillFileAddrs(billDto.getBillFileAddrs());
			bill.setCnt(billDto.getCnt());
			bill.setRtCnt(billDto.getRtCnt());
			AssertUtils.notUpdateMoreThanOne(billDao.updateByPrimaryKeySelective(bill));
			logger.debug("updateBill(BillDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("大B账单信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BILL_UPDATE_ERROR,"大B账单信息更新信息错误！",e);
		}
	}

	

	@Override
	public BillDto findBill(
			BillDto billDto) throws TsfaServiceException {
		logger.debug("findBill(FindBill findBill={}) - start", billDto); //$NON-NLS-1$

		AssertUtils.notNull(billDto);
		AssertUtils.notAllNull(billDto.getCode(),"Code不能为空");
		try {
			Bill bill = billDao.selectByPrimaryKey(billDto.getCode());
			if(bill == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.BILL_NOT_EXIST_ERROR,"大B账单信息不存在");
			}
			BillDto findBillReturn = new BillDto();
			//find数据录入
			findBillReturn.setCode(bill.getCode());
			findBillReturn.setSupplyName(bill.getSupplyName());
			findBillReturn.setSupplyCode(bill.getSupplyCode());
			findBillReturn.setPhone(bill.getPhone());
			findBillReturn.setBillAddr(bill.getBillAddr());
			findBillReturn.setPayType(bill.getPayType());
			findBillReturn.setAccountDays(bill.getAccountDays());
			findBillReturn.setStatus(bill.getStatus());
			findBillReturn.setBillDate(bill.getBillDate());
			findBillReturn.setPayDate(bill.getPayDate());
			findBillReturn.setAmt(bill.getAmt());
			findBillReturn.setStartDate(bill.getStartDate());
			findBillReturn.setEndDate(bill.getEndDate());
			findBillReturn.setRetireAmt(bill.getRetireAmt());
			findBillReturn.setBillFileAddrs(bill.getBillFileAddrs());
			findBillReturn.setCnt(bill.getCnt());
			findBillReturn.setRtCnt(bill.getRtCnt());
			
			logger.debug("findBill(BillDto) - end - return value={}", findBillReturn); //$NON-NLS-1$
			return findBillReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找大B账单信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BILL_FIND_ERROR,"查找大B账单信息信息错误！",e);
		}


	}

	
	@Override
	public Page<BillDto> findBillPage(
			FindBillPage findBillPage)
			throws TsfaServiceException {
		logger.debug("findBillPage(FindBillPage findBillPage={}) - start", findBillPage); //$NON-NLS-1$

		AssertUtils.notNull(findBillPage);
		List<BillDto> returnList=null;
		int count = 0;
		try {
			returnList = billDao.findBillPage(findBillPage);
			count = billDao.findBillPageCount(findBillPage);
		}  catch (Exception e) {
			logger.error("大B账单信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.BILL_FIND_PAGE_ERROR,"大B账单信息不存在错误.！",e);
		}
		Page<BillDto> returnPage = new Page<BillDto>(returnList, count, findBillPage);

		logger.debug("findBillPage(FindBillPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
