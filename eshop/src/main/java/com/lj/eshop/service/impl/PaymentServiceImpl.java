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
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.dto.FindPaymentPage;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IPaymentDao;
import com.lj.eshop.domain.Payment;
import com.lj.eshop.service.IPaymentService;
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
public class PaymentServiceImpl implements IPaymentService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	

	@Resource
	private IPaymentDao paymentDao;
	
	
	@Override
	public void addPayment(
			PaymentDto paymentDto) throws TsfaServiceException {
		logger.debug("addPayment(AddPayment addPayment={}) - start", paymentDto); 

		AssertUtils.notNull(paymentDto);
		try {
			Payment payment = new Payment();
			Date now = new Date();
			//add数据录入
			payment.setCode(GUID.generateCode());
			payment.setCreateDate(now);
			payment.setModifyDate(now);
			payment.setAccCode(paymentDto.getAccCode());
			payment.setBank(paymentDto.getBank());
			payment.setExpire(paymentDto.getExpire());
			payment.setFee(paymentDto.getFee());
			payment.setMemo(paymentDto.getMemo());
			payment.setOperator(paymentDto.getOperator());
			payment.setPayer(paymentDto.getPayer());
			payment.setPaymentDate(paymentDto.getPaymentDate());
			payment.setPaymentMethod(paymentDto.getPaymentMethod());
			payment.setSn(paymentDto.getSn());
			payment.setStatus(paymentDto.getStatus());
			payment.setType(paymentDto.getType());
			payment.setMbrCode(paymentDto.getMbrCode());
			payment.setBizNo(paymentDto.getBizNo());
			payment.setDelFlag(paymentDto.getDelFlag());
			payment.setThirdpartyTradeNo(paymentDto.getThirdpartyTradeNo());
			payment.setAmount(paymentDto.getAmount());
			payment.setFailReason(paymentDto.getFailReason());
			payment.setAccSource(paymentDto.getAccSource());
			paymentDao.insertSelective(payment);
			logger.debug("addPayment(PaymentDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增预支付流水信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PAYMENT_ADD_ERROR,"新增预支付流水信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询预支付流水信息
	 *
	 * @param findPaymentPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<PaymentDto>  findPayments(FindPaymentPage findPaymentPage)throws TsfaServiceException{
		AssertUtils.notNull(findPaymentPage);
		List<PaymentDto> returnList=null;
		try {
			returnList = paymentDao.findPayments(findPaymentPage);
		} catch (Exception e) {
			logger.error("查找预支付流水信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PAYMENT_NOT_EXIST_ERROR,"预支付流水信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updatePayment(
			PaymentDto paymentDto)
			throws TsfaServiceException {
		logger.debug("updatePayment(PaymentDto paymentDto={}) - start", paymentDto); //$NON-NLS-1$

		AssertUtils.notNull(paymentDto);
		AssertUtils.notNullAndEmpty(paymentDto.getCode(),"Code不能为空");
		try {
			Payment payment = new Payment();
			//update数据录入
			payment.setCode(paymentDto.getCode());
			payment.setModifyDate(new Date());
			payment.setAccCode(paymentDto.getAccCode());
			payment.setBank(paymentDto.getBank());
			payment.setExpire(paymentDto.getExpire());
			payment.setFee(paymentDto.getFee());
			payment.setMemo(paymentDto.getMemo());
			payment.setOperator(paymentDto.getOperator());
			payment.setPayer(paymentDto.getPayer());
			payment.setPaymentDate(paymentDto.getPaymentDate());
			payment.setPaymentMethod(paymentDto.getPaymentMethod());
			payment.setSn(paymentDto.getSn());
			payment.setStatus(paymentDto.getStatus());
			payment.setType(paymentDto.getType());
			payment.setMbrCode(paymentDto.getMbrCode());
			payment.setBizNo(paymentDto.getBizNo());
			payment.setDelFlag(paymentDto.getDelFlag());
			payment.setThirdpartyTradeNo(paymentDto.getThirdpartyTradeNo());
			payment.setAmount(paymentDto.getAmount());
			payment.setFailReason(paymentDto.getFailReason());
			payment.setAccSource(paymentDto.getAccSource());
			AssertUtils.notUpdateMoreThanOne(paymentDao.updateByPrimaryKeySelective(payment));
			logger.debug("updatePayment(PaymentDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("预支付流水信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PAYMENT_UPDATE_ERROR,"预支付流水信息更新信息错误！",e);
		}
	}

	

	@Override
	public PaymentDto findPayment(
			PaymentDto paymentDto) throws TsfaServiceException {
		logger.debug("findPayment(FindPayment findPayment={}) - start", paymentDto); //$NON-NLS-1$

		AssertUtils.notNull(paymentDto);
		AssertUtils.notAllNull(paymentDto.getCode(),"Code不能为空");
		try {
			Payment payment = paymentDao.selectByPrimaryKey(paymentDto.getCode());
			if(payment == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.PAYMENT_NOT_EXIST_ERROR,"预支付流水信息不存在");
			}
			PaymentDto findPaymentReturn = new PaymentDto();
			//find数据录入
			findPaymentReturn.setCode(payment.getCode());
			findPaymentReturn.setCreateDate(payment.getCreateDate());
			findPaymentReturn.setModifyDate(payment.getModifyDate());
			findPaymentReturn.setAccCode(payment.getAccCode());
			findPaymentReturn.setBank(payment.getBank());
			findPaymentReturn.setExpire(payment.getExpire());
			findPaymentReturn.setFee(payment.getFee());
			findPaymentReturn.setMemo(payment.getMemo());
			findPaymentReturn.setOperator(payment.getOperator());
			findPaymentReturn.setPayer(payment.getPayer());
			findPaymentReturn.setPaymentDate(payment.getPaymentDate());
			findPaymentReturn.setPaymentMethod(payment.getPaymentMethod());
			findPaymentReturn.setSn(payment.getSn());
			findPaymentReturn.setStatus(payment.getStatus());
			findPaymentReturn.setType(payment.getType());
			findPaymentReturn.setMbrCode(payment.getMbrCode());
			findPaymentReturn.setBizNo(payment.getBizNo());
			findPaymentReturn.setDelFlag(payment.getDelFlag());
			findPaymentReturn.setThirdpartyTradeNo(payment.getThirdpartyTradeNo());
			findPaymentReturn.setAmount(payment.getAmount());
			findPaymentReturn.setFailReason(payment.getFailReason());
			findPaymentReturn.setAccSource(payment.getAccSource());
			
			logger.debug("findPayment(PaymentDto) - end - return value={}", findPaymentReturn); //$NON-NLS-1$
			return findPaymentReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找预支付流水信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PAYMENT_FIND_ERROR,"查找预支付流水信息信息错误！",e);
		}


	}

	
	@Override
	public Page<PaymentDto> findPaymentPage(
			FindPaymentPage findPaymentPage)
			throws TsfaServiceException {
		logger.debug("findPaymentPage(FindPaymentPage findPaymentPage={}) - start", findPaymentPage); //$NON-NLS-1$

		AssertUtils.notNull(findPaymentPage);
		List<PaymentDto> returnList=null;
		int count = 0;
		try {
			returnList = paymentDao.findPaymentPage(findPaymentPage);
			count = paymentDao.findPaymentPageCount(findPaymentPage);
		}  catch (Exception e) {
			logger.error("预支付流水信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.PAYMENT_FIND_PAGE_ERROR,"预支付流水信息不存在错误.！",e);
		}
		Page<PaymentDto> returnPage = new Page<PaymentDto>(returnList, count, findPaymentPage);

		logger.debug("findPaymentPage(FindPaymentPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
