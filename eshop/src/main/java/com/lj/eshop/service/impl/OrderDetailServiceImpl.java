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
import com.lj.eshop.dao.IOrderDetailDao;
import com.lj.eshop.domain.OrderDetail;
import com.lj.eshop.dto.FindOrderDetailPage;
import com.lj.eshop.dto.OrderDetailDto;
import com.lj.eshop.service.IOrderDetailService;
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
public class OrderDetailServiceImpl implements IOrderDetailService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailServiceImpl.class);
	

	@Resource
	private IOrderDetailDao orderDetailDao;
	
	
	@Override
	public void addOrderDetail(
			OrderDetailDto orderDetailDto) throws TsfaServiceException {
		logger.debug("addOrderDetail(AddOrderDetail addOrderDetail={}) - start", orderDetailDto); 

		AssertUtils.notNull(orderDetailDto);
		try {
			OrderDetail orderDetail = new OrderDetail();
			//add数据录入
			orderDetail.setCode(GUID.generateCode());
			orderDetail.setProductCode(orderDetailDto.getProductCode());
			orderDetail.setProductName(orderDetailDto.getProductName());
			orderDetail.setSupplyCode(orderDetailDto.getSupplyCode());
			orderDetail.setSupplyName(orderDetailDto.getSupplyName());
			orderDetail.setCnt(orderDetailDto.getCnt());
			orderDetail.setAmt(orderDetailDto.getAmt());
			orderDetail.setSalePrice(orderDetailDto.getSalePrice());
			orderDetail.setOrderNo(orderDetailDto.getOrderNo());
			orderDetail.setSkuCode(orderDetailDto.getSkuCode());
			orderDetail.setOrgPrice(orderDetailDto.getOrgPrice());
			orderDetail.setGapPrice(orderDetailDto.getGapPrice());
			orderDetail.setReturnCnt(orderDetailDto.getReturnCnt());
			orderDetailDao.insertSelective(orderDetail);
			logger.debug("addOrderDetail(OrderDetailDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增订单明细信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_DETAIL_ADD_ERROR,"新增订单明细信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询订单明细信息
	 *
	 * @param findOrderDetailPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<OrderDetailDto>  findOrderDetails(FindOrderDetailPage findOrderDetailPage)throws TsfaServiceException{
		AssertUtils.notNull(findOrderDetailPage);
		List<OrderDetailDto> returnList=null;
		try {
			returnList = orderDetailDao.findOrderDetails(findOrderDetailPage);
		} catch (Exception e) {
			logger.error("查找订单明细信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_DETAIL_NOT_EXIST_ERROR,"订单明细信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateOrderDetail(
			OrderDetailDto orderDetailDto)
			throws TsfaServiceException {
		logger.debug("updateOrderDetail(OrderDetailDto orderDetailDto={}) - start", orderDetailDto); //$NON-NLS-1$

		AssertUtils.notNull(orderDetailDto);
		AssertUtils.notNullAndEmpty(orderDetailDto.getCode(),"Code不能为空");
		try {
			OrderDetail orderDetail = new OrderDetail();
			//update数据录入
			orderDetail.setCode(orderDetailDto.getCode());
			orderDetail.setProductCode(orderDetailDto.getProductCode());
			orderDetail.setProductName(orderDetailDto.getProductName());
			orderDetail.setSupplyCode(orderDetailDto.getSupplyCode());
			orderDetail.setSupplyName(orderDetailDto.getSupplyName());
			orderDetail.setCnt(orderDetailDto.getCnt());
			orderDetail.setAmt(orderDetailDto.getAmt());
			orderDetail.setSalePrice(orderDetailDto.getSalePrice());
			orderDetail.setOrderNo(orderDetailDto.getOrderNo());
			orderDetail.setSkuCode(orderDetailDto.getSkuCode());
			orderDetail.setOrgPrice(orderDetailDto.getOrgPrice());
			orderDetail.setGapPrice(orderDetailDto.getGapPrice());
			orderDetail.setReturnCnt(orderDetailDto.getReturnCnt());
			AssertUtils.notUpdateMoreThanOne(orderDetailDao.updateByPrimaryKeySelective(orderDetail));
			logger.debug("updateOrderDetail(OrderDetailDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("订单明细信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_DETAIL_UPDATE_ERROR,"订单明细信息更新信息错误！",e);
		}
	}

	

	@Override
	public OrderDetailDto findOrderDetail(
			OrderDetailDto orderDetailDto) throws TsfaServiceException {
		logger.debug("findOrderDetail(FindOrderDetail findOrderDetail={}) - start", orderDetailDto); //$NON-NLS-1$

		AssertUtils.notNull(orderDetailDto);
		AssertUtils.notAllNull(orderDetailDto.getCode(),"Code不能为空");
		try {
			OrderDetail orderDetail = orderDetailDao.selectByPrimaryKey(orderDetailDto.getCode());
			if(orderDetail == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.ORDER_DETAIL_NOT_EXIST_ERROR,"订单明细信息不存在");
			}
			OrderDetailDto findOrderDetailReturn = new OrderDetailDto();
			//find数据录入
			findOrderDetailReturn.setCode(orderDetail.getCode());
			findOrderDetailReturn.setProductCode(orderDetail.getProductCode());
			findOrderDetailReturn.setProductName(orderDetail.getProductName());
			findOrderDetailReturn.setSupplyCode(orderDetail.getSupplyCode());
			findOrderDetailReturn.setSupplyName(orderDetail.getSupplyName());
			findOrderDetailReturn.setCnt(orderDetail.getCnt());
			findOrderDetailReturn.setAmt(orderDetail.getAmt());
			findOrderDetailReturn.setSalePrice(orderDetail.getSalePrice());
			findOrderDetailReturn.setOrderNo(orderDetail.getOrderNo());
			findOrderDetailReturn.setSkuCode(orderDetail.getSkuCode());
			findOrderDetailReturn.setOrgPrice(orderDetail.getOrgPrice());
			findOrderDetailReturn.setGapPrice(orderDetail.getGapPrice());
			findOrderDetailReturn.setReturnCnt(orderDetail.getReturnCnt());
			logger.debug("findOrderDetail(OrderDetailDto) - end - return value={}", findOrderDetailReturn); //$NON-NLS-1$
			return findOrderDetailReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找订单明细信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_DETAIL_FIND_ERROR,"查找订单明细信息信息错误！",e);
		}


	}

	
	@Override
	public Page<OrderDetailDto> findOrderDetailPage(
			FindOrderDetailPage findOrderDetailPage)
			throws TsfaServiceException {
		logger.debug("findOrderDetailPage(FindOrderDetailPage findOrderDetailPage={}) - start", findOrderDetailPage); //$NON-NLS-1$

		AssertUtils.notNull(findOrderDetailPage);
		List<OrderDetailDto> returnList=null;
		int count = 0;
		try {
			returnList = orderDetailDao.findOrderDetailPage(findOrderDetailPage);
			count = orderDetailDao.findOrderDetailPageCount(findOrderDetailPage);
		}  catch (Exception e) {
			logger.error("订单明细信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.ORDER_DETAIL_FIND_PAGE_ERROR,"订单明细信息不存在错误.！",e);
		}
		Page<OrderDetailDto> returnPage = new Page<OrderDetailDto>(returnList, count, findOrderDetailPage);

		logger.debug("findOrderDetailPage(FindOrderDetailPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
