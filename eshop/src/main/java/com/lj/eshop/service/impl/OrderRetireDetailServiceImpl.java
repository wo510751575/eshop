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
import com.lj.eshop.dao.IOrderRetireDetailDao;
import com.lj.eshop.domain.OrderRetireDetail;
import com.lj.eshop.dto.FindOrderRetireDetailPage;
import com.lj.eshop.dto.OrderRetireDetailDto;
import com.lj.eshop.service.IOrderRetireDetailService;
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
public class OrderRetireDetailServiceImpl implements IOrderRetireDetailService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(OrderRetireDetailServiceImpl.class);
	

	@Resource
	private IOrderRetireDetailDao orderRetireDetailDao;
	
	
	@Override
	public void addOrderRetireDetail(
			OrderRetireDetailDto orderRetireDetailDto) throws TsfaServiceException {
		logger.debug("addOrderRetireDetail(AddOrderRetireDetail addOrderRetireDetail={}) - start", orderRetireDetailDto); 

		AssertUtils.notNull(orderRetireDetailDto);
		try {
			OrderRetireDetail orderRetireDetail = new OrderRetireDetail();
			//add数据录入
			orderRetireDetail.setCode(GUID.generateCode());
			orderRetireDetail.setCnt(orderRetireDetailDto.getCnt());
			orderRetireDetail.setAmt(orderRetireDetailDto.getAmt());
			orderRetireDetail.setRetireNo(orderRetireDetailDto.getRetireNo());
			orderRetireDetail.setSkuNo(orderRetireDetailDto.getSkuNo());
			orderRetireDetail.setOrderDetailCode(orderRetireDetailDto.getOrderDetailCode());
			orderRetireDetailDao.insertSelective(orderRetireDetail);
			logger.debug("addOrderRetireDetail(OrderRetireDetailDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增订单退换明细信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_DETAIL_ADD_ERROR,"新增订单退换明细信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询订单退换明细信息
	 *
	 * @param findOrderRetireDetailPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<OrderRetireDetailDto>  findOrderRetireDetails(FindOrderRetireDetailPage findOrderRetireDetailPage)throws TsfaServiceException{
		AssertUtils.notNull(findOrderRetireDetailPage);
		List<OrderRetireDetailDto> returnList=null;
		try {
			returnList = orderRetireDetailDao.findOrderRetireDetails(findOrderRetireDetailPage);
		} catch (Exception e) {
			logger.error("查找订单退换明细信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_DETAIL_NOT_EXIST_ERROR,"订单退换明细信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateOrderRetireDetail(
			OrderRetireDetailDto orderRetireDetailDto)
			throws TsfaServiceException {
		logger.debug("updateOrderRetireDetail(OrderRetireDetailDto orderRetireDetailDto={}) - start", orderRetireDetailDto); //$NON-NLS-1$

		AssertUtils.notNull(orderRetireDetailDto);
		AssertUtils.notNullAndEmpty(orderRetireDetailDto.getCode(),"Code不能为空");
		try {
			OrderRetireDetail orderRetireDetail = new OrderRetireDetail();
			//update数据录入
			orderRetireDetail.setCode(orderRetireDetailDto.getCode());
			orderRetireDetail.setCnt(orderRetireDetailDto.getCnt());
			orderRetireDetail.setAmt(orderRetireDetailDto.getAmt());
			orderRetireDetail.setRetireNo(orderRetireDetailDto.getRetireNo());
			orderRetireDetail.setSkuNo(orderRetireDetailDto.getSkuNo());
			orderRetireDetail.setOrderDetailCode(orderRetireDetailDto.getOrderDetailCode());
			AssertUtils.notUpdateMoreThanOne(orderRetireDetailDao.updateByPrimaryKeySelective(orderRetireDetail));
			logger.debug("updateOrderRetireDetail(OrderRetireDetailDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("订单退换明细信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_DETAIL_UPDATE_ERROR,"订单退换明细信息更新信息错误！",e);
		}
	}

	

	@Override
	public OrderRetireDetailDto findOrderRetireDetail(
			OrderRetireDetailDto orderRetireDetailDto) throws TsfaServiceException {
		logger.debug("findOrderRetireDetail(FindOrderRetireDetail findOrderRetireDetail={}) - start", orderRetireDetailDto); //$NON-NLS-1$

		AssertUtils.notNull(orderRetireDetailDto);
		AssertUtils.notAllNull(orderRetireDetailDto.getCode(),"Code不能为空");
		try {
			OrderRetireDetail orderRetireDetail = orderRetireDetailDao.selectByPrimaryKey(orderRetireDetailDto.getCode());
			if(orderRetireDetail == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_DETAIL_NOT_EXIST_ERROR,"订单退换明细信息不存在");
			}
			OrderRetireDetailDto findOrderRetireDetailReturn = new OrderRetireDetailDto();
			//find数据录入
			findOrderRetireDetailReturn.setCode(orderRetireDetail.getCode());
			findOrderRetireDetailReturn.setCnt(orderRetireDetail.getCnt());
			findOrderRetireDetailReturn.setAmt(orderRetireDetail.getAmt());
			findOrderRetireDetailReturn.setRetireNo(orderRetireDetail.getRetireNo());
			findOrderRetireDetailReturn.setSkuNo(orderRetireDetail.getSkuNo());
			findOrderRetireDetailReturn.setOrderDetailCode(orderRetireDetail.getOrderDetailCode());
			logger.debug("findOrderRetireDetail(OrderRetireDetailDto) - end - return value={}", findOrderRetireDetailReturn); //$NON-NLS-1$
			return findOrderRetireDetailReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找订单退换明细信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_DETAIL_FIND_ERROR,"查找订单退换明细信息信息错误！",e);
		}


	}

	
	@Override
	public Page<OrderRetireDetailDto> findOrderRetireDetailPage(
			FindOrderRetireDetailPage findOrderRetireDetailPage)
			throws TsfaServiceException {
		logger.debug("findOrderRetireDetailPage(FindOrderRetireDetailPage findOrderRetireDetailPage={}) - start", findOrderRetireDetailPage); //$NON-NLS-1$

		AssertUtils.notNull(findOrderRetireDetailPage);
		List<OrderRetireDetailDto> returnList=null;
		int count = 0;
		try {
			returnList = orderRetireDetailDao.findOrderRetireDetailPage(findOrderRetireDetailPage);
			count = orderRetireDetailDao.findOrderRetireDetailPageCount(findOrderRetireDetailPage);
		}  catch (Exception e) {
			logger.error("订单退换明细信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_DETAIL_FIND_PAGE_ERROR,"订单退换明细信息不存在错误.！",e);
		}
		Page<OrderRetireDetailDto> returnPage = new Page<OrderRetireDetailDto>(returnList, count, findOrderRetireDetailPage);

		logger.debug("findOrderRetireDetailPage(FindOrderRetireDetailPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
