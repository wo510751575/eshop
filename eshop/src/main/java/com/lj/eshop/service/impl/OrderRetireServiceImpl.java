package com.lj.eshop.service.impl;

import java.math.BigDecimal;
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
import org.springframework.transaction.annotation.Transactional;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dao.IOrderRetireDao;
import com.lj.eshop.domain.OrderRetire;
import com.lj.eshop.dto.FindOrderRetirePage;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.dto.OrderDetailDto;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.OrderRetireDetailDto;
import com.lj.eshop.dto.OrderRetireDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.emus.MessageTemplate;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.service.IMessageService;
import com.lj.eshop.service.IOrderDetailService;
import com.lj.eshop.service.IOrderRetireDetailService;
import com.lj.eshop.service.IOrderRetireService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IShopService;
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
public class OrderRetireServiceImpl implements IOrderRetireService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(OrderRetireServiceImpl.class);
	

	@Resource
	private IOrderRetireDao orderRetireDao;
	@Resource
	private IOrderRetireDetailService orderRetireDetailService;
	
	@Resource
	private IOrderService orderService;
	
	@Resource
	private IOrderDetailService orderDetailService;
	
	@Resource
	private IMessageService messageService;
	
	@Resource
	private IShopService shopService;
	
	
	@Override
	public void addOrderRetire(
			OrderRetireDto orderRetireDto) throws TsfaServiceException {
		logger.debug("addOrderRetire(AddOrderRetire addOrderRetire={}) - start", orderRetireDto); 

		AssertUtils.notNull(orderRetireDto);
		try {
			OrderRetire orderRetire = new OrderRetire();
			//add数据录入
			orderRetire.setCode(orderRetireDto.getCode());
			orderRetire.setOrderNo(orderRetireDto.getOrderCode());
			orderRetire.setExpressNo(orderRetireDto.getExpressNo());
			orderRetire.setExpressName(orderRetireDto.getExpressName());
			orderRetire.setRemarks(orderRetireDto.getRemarks());
			orderRetire.setImg1(orderRetireDto.getImg1());
			orderRetire.setImg2(orderRetireDto.getImg2());
			orderRetire.setImg3(orderRetireDto.getImg3());
			orderRetire.setImg4(orderRetireDto.getImg4());
			orderRetire.setType(orderRetireDto.getType());
			orderRetire.setCreateTime(orderRetireDto.getCreateTime());
			orderRetire.setUpdateTime(orderRetireDto.getUpdateTime());
			orderRetire.setRetireNo(orderRetireDto.getRetireNo());
			orderRetire.setAuditor(orderRetireDto.getAuditor());
			orderRetire.setAuditStatus(orderRetireDto.getAuditStatus());
			orderRetire.setFailReason(orderRetireDto.getFailReason());
			orderRetire.setAmt(orderRetireDto.getAmt());
			orderRetireDao.insertSelective(orderRetire);
			logger.debug("addOrderRetire(OrderRetireDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增订单退换信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_ADD_ERROR,"新增订单退换信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询订单退换信息
	 *
	 * @param findOrderRetirePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<OrderRetireDto>  findOrderRetires(FindOrderRetirePage findOrderRetirePage)throws TsfaServiceException{
		AssertUtils.notNull(findOrderRetirePage);
		List<OrderRetireDto> returnList=null;
		try {
			returnList = orderRetireDao.findOrderRetires(findOrderRetirePage);
		} catch (Exception e) {
			logger.error("查找订单退换信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_NOT_EXIST_ERROR,"订单退换信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateOrderRetire(
			OrderRetireDto orderRetireDto)
			throws TsfaServiceException {
		logger.debug("updateOrderRetire(OrderRetireDto orderRetireDto={}) - start", orderRetireDto); //$NON-NLS-1$

		AssertUtils.notNull(orderRetireDto);
		AssertUtils.notNullAndEmpty(orderRetireDto.getCode(),"Code不能为空");
		try {
			OrderRetire orderRetire = new OrderRetire();
			//update数据录入
			orderRetire.setCode(orderRetireDto.getCode());
			orderRetire.setOrderNo(orderRetireDto.getOrderNo());
			orderRetire.setExpressNo(orderRetireDto.getExpressNo());
			orderRetire.setExpressName(orderRetireDto.getExpressName());
			orderRetire.setRemarks(orderRetireDto.getRemarks());
			orderRetire.setImg1(orderRetireDto.getImg1());
			orderRetire.setImg2(orderRetireDto.getImg2());
			orderRetire.setImg3(orderRetireDto.getImg3());
			orderRetire.setImg4(orderRetireDto.getImg4());
			orderRetire.setType(orderRetireDto.getType());
			orderRetire.setCreateTime(orderRetireDto.getCreateTime());
			orderRetire.setUpdateTime(orderRetireDto.getUpdateTime());
			orderRetire.setRetireNo(orderRetireDto.getRetireNo());
			orderRetire.setAuditor(orderRetireDto.getAuditor());
			orderRetire.setAuditStatus(orderRetireDto.getAuditStatus());
			orderRetire.setFailReason(orderRetireDto.getFailReason());
			orderRetire.setAmt(orderRetireDto.getAmt());
			AssertUtils.notUpdateMoreThanOne(orderRetireDao.updateByPrimaryKeySelective(orderRetire));
			logger.debug("updateOrderRetire(OrderRetireDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("订单退换信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_UPDATE_ERROR,"订单退换信息更新信息错误！",e);
		}
	}

	

	@Override
	public OrderRetireDto findOrderRetire(
			OrderRetireDto orderRetireDto) throws TsfaServiceException {
		logger.debug("findOrderRetire(FindOrderRetire findOrderRetire={}) - start", orderRetireDto); //$NON-NLS-1$

		AssertUtils.notNull(orderRetireDto);
		AssertUtils.notAllNull(orderRetireDto.getCode(),"Code不能为空");
		try {
			OrderRetire orderRetire = orderRetireDao.selectByPrimaryKey(orderRetireDto.getCode());
			if(orderRetire == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_NOT_EXIST_ERROR,"订单退换信息不存在");
			}
			OrderRetireDto findOrderRetireReturn = new OrderRetireDto();
			//find数据录入
			findOrderRetireReturn.setCode(orderRetire.getCode());
			findOrderRetireReturn.setOrderNo(orderRetire.getOrderNo());
			findOrderRetireReturn.setExpressNo(orderRetire.getExpressNo());
			findOrderRetireReturn.setExpressName(orderRetire.getExpressName());
			findOrderRetireReturn.setRemarks(orderRetire.getRemarks());
			findOrderRetireReturn.setImg1(orderRetire.getImg1());
			findOrderRetireReturn.setImg2(orderRetire.getImg2());
			findOrderRetireReturn.setImg3(orderRetire.getImg3());
			findOrderRetireReturn.setImg4(orderRetire.getImg4());
			findOrderRetireReturn.setType(orderRetire.getType());
			findOrderRetireReturn.setCreateTime(orderRetire.getCreateTime());
			findOrderRetireReturn.setUpdateTime(orderRetire.getUpdateTime());
			findOrderRetireReturn.setRetireNo(orderRetire.getRetireNo());
			findOrderRetireReturn.setAuditor(orderRetire.getAuditor());
			findOrderRetireReturn.setAuditStatus(orderRetire.getAuditStatus());
			findOrderRetireReturn.setFailReason(orderRetire.getFailReason());
			findOrderRetireReturn.setAmt(orderRetire.getAmt());
			
			logger.debug("findOrderRetire(OrderRetireDto) - end - return value={}", findOrderRetireReturn); //$NON-NLS-1$
			return findOrderRetireReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找订单退换信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_FIND_ERROR,"查找订单退换信息信息错误！",e);
		}


	}

	
	@Override
	public Page<OrderRetireDto> findOrderRetirePage(
			FindOrderRetirePage findOrderRetirePage)
			throws TsfaServiceException {
		logger.debug("findOrderRetirePage(FindOrderRetirePage findOrderRetirePage={}) - start", findOrderRetirePage); //$NON-NLS-1$

		AssertUtils.notNull(findOrderRetirePage);
		List<OrderRetireDto> returnList=null;
		int count = 0;
		try {
			returnList = orderRetireDao.findOrderRetirePage(findOrderRetirePage);
			count = orderRetireDao.findOrderRetirePageCount(findOrderRetirePage);
		}  catch (Exception e) {
			logger.error("订单退换信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_FIND_PAGE_ERROR,"订单退换信息不存在错误.！",e);
		}
		Page<OrderRetireDto> returnPage = new Page<OrderRetireDto>(returnList, count, findOrderRetirePage);

		logger.debug("findOrderRetirePage(FindOrderRetirePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	@Transactional
	public void applyBack(OrderRetireDto orderRetireDto) throws TsfaServiceException{
		logger.debug("addOrderRetire(applyBack applyBack={}) - start", orderRetireDto); 

		AssertUtils.notNull(orderRetireDto);

		try {
			//插入退货订单
			orderRetireDto.setRetireNo(NoUtil.generateNo(NoUtil.JY));
			orderRetireDto.setCode(GUID.generateCode());
			addOrderRetire(orderRetireDto);
			
			//插入退货明细
			String productName = null;
			BigDecimal totalAmt = new BigDecimal(0);
			List<OrderRetireDetailDto> retireDetails = orderRetireDto.getRetireDetailDtos();
			for (OrderRetireDetailDto retireDetailDto : retireDetails) {
				OrderDetailDto paramOrderDetailDto = new OrderDetailDto();
				paramOrderDetailDto.setCode(retireDetailDto.getOrderDetailCode());
				OrderDetailDto rltOrderDetailDto = orderDetailService.findOrderDetail(paramOrderDetailDto);
				retireDetailDto.setAmt(rltOrderDetailDto.getSalePrice());
				retireDetailDto.setSkuNo(rltOrderDetailDto.getSkuCode());
				retireDetailDto.setRetireNo(orderRetireDto.getRetireNo());
				orderRetireDetailService.addOrderRetireDetail(retireDetailDto);
				if(StringUtils.isEmpty(productName)) {
					productName = rltOrderDetailDto.getProductName();
				}
				
				if(retireDetailDto.getCnt().compareTo(rltOrderDetailDto.getCnt())>0) {
					throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_ADD_ERROR,"订单有误，退货数量大于订单数量！");
				}
				
				totalAmt = totalAmt.add(rltOrderDetailDto.getSalePrice().multiply(new BigDecimal(retireDetailDto.getCnt())));
			}
			orderRetireDto.setAmt(totalAmt);
			updateOrderRetire(orderRetireDto);
			
			
			//订单状态变更为申请退货
			OrderDto orderDto = new OrderDto();
			orderDto.setCode(orderRetireDto.getOrderCode());
			orderDto.setStatus(OrderStatus.UNRETURNS.getValue());
			orderService.updateOrder(orderDto);
			OrderDto rOrderDto = new OrderDto();
			rOrderDto.setCode(orderRetireDto.getOrderCode());
			rOrderDto = orderService.findOrder(orderDto);
			
			ShopDto paramShopDto = new ShopDto();
			paramShopDto.setCode(rOrderDto.getShopCode());
			ShopDto rltShopDto = shopService.findShop(paramShopDto);
			
			//发送消息通知
			MessageDto messageDto = new MessageDto();
			messageDto.setRecevier(rltShopDto.getMbrCode());
			messageDto.setcClientName(rOrderDto.getMbrName());
			messageDto.setcClientCommodity(productName);
			messageDto.setcClientOrderNo(orderRetireDto.getRetireNo());
			messageService.addMessageByTemplate(messageDto, MessageTemplate.B_SERVICE_ORDER_BILL_BACK);
			
			logger.debug("applyBack(OrderRetireDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增订单退换信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_ADD_ERROR,"新增订单退换信息错误！",e);
		}
		
	}
	
	
	@Override
	public Page<OrderRetireDto> findOrderRetirePage4BC(
			FindOrderRetirePage findOrderRetirePage)
			throws TsfaServiceException {
		logger.debug("findOrderRetirePage(FindOrderRetirePage findOrderRetirePage={}) - start", findOrderRetirePage); //$NON-NLS-1$

		AssertUtils.notNull(findOrderRetirePage);
		List<OrderRetireDto> returnList=null;
		int count = 0;
		try {
			returnList = orderRetireDao.findOrderRetirePage4BC(findOrderRetirePage);
			count = orderRetireDao.findOrderRetirePageCount4BC(findOrderRetirePage);
		}  catch (Exception e) {
			logger.error("订单退换信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.ORDER_RETIRE_FIND_PAGE_ERROR,"订单退换信息不存在错误.！",e);
		}
		Page<OrderRetireDto> returnPage = new Page<OrderRetireDto>(returnList, count, findOrderRetirePage);

		logger.debug("findOrderRetirePage(FindOrderRetirePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


}
