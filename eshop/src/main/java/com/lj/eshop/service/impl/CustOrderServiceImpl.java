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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dao.ICustOrderDao;
import com.lj.eshop.domain.CustOrder;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.CustOrderDto;
import com.lj.eshop.dto.FindCustOrderPage;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.CustOrderStatus;
import com.lj.eshop.emus.MessageTemplate;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.ICustOrderService;
import com.lj.eshop.service.IMessageService;
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
public class CustOrderServiceImpl implements ICustOrderService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(CustOrderServiceImpl.class);
	

	@Resource
	private ICustOrderDao custOrderDao;
	@Autowired
	private IAccWaterService accWaterService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IShopService shopService;
	@Autowired
	private IMessageService messageService;
	
	@Override
	public void addCustOrder(
			CustOrderDto custOrderDto) throws TsfaServiceException {
		logger.debug("addCustOrder(AddCustOrder addCustOrder={}) - start", custOrderDto); 

		AssertUtils.notNull(custOrderDto);
		try {
			CustOrder custOrder = new CustOrder();
			//add数据录入
			custOrder.setCode(GUID.generateCode());
			custOrder.setSupplyCode(custOrderDto.getSupplyCode());
			custOrder.setSupplyName(custOrderDto.getSupplyName());
			custOrder.setImg1(custOrderDto.getImg1());
			custOrder.setImg2(custOrderDto.getImg2());
			custOrder.setImg3(custOrderDto.getImg3());
			custOrder.setImg4(custOrderDto.getImg4());
			custOrder.setImg5(custOrderDto.getImg5());
			custOrder.setImg6(custOrderDto.getImg6());
			custOrder.setRemarks(custOrderDto.getRemarks());
			custOrder.setPayAmt(custOrderDto.getPayAmt());
			custOrder.setCreateTime(new Date());
			custOrder.setUpdateTime(new Date());
			custOrder.setCatalogCode(custOrderDto.getCatalogCode());
			custOrder.setCatalogName(custOrderDto.getCatalogName());
			custOrder.setPayType(custOrderDto.getPayType());
			custOrder.setOrderNo(custOrderDto.getOrderNo());
			custOrder.setCostPrice(custOrderDto.getCostPrice());
			custOrder.setOrgPrice(custOrderDto.getOrgPrice());
			custOrder.setGapPrice(custOrderDto.getGapPrice());
			custOrder.setSalePrice(custOrderDto.getSalePrice());
			custOrder.setMerchantCode(custOrderDto.getMerchantCode());
			custOrder.setStatus(custOrderDto.getStatus());
			custOrder.setExpressNo(custOrderDto.getExpressNo());
			custOrder.setExpressName(custOrderDto.getExpressName());
			custOrder.setMbrCode(custOrderDto.getMbrCode());
			custOrder.setShopCode(custOrderDto.getShopCode());
			custOrder.setShopName(custOrderDto.getShopName());
			custOrderDao.insertSelective(custOrder);
			logger.debug("addCustOrder(CustOrderDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品定制订单信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CUST_ORDER_ADD_ERROR,"新增商品定制订单信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品定制订单信息
	 *
	 * @param findCustOrderPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<CustOrderDto>  findCustOrders(FindCustOrderPage findCustOrderPage)throws TsfaServiceException{
		AssertUtils.notNull(findCustOrderPage);
		List<CustOrderDto> returnList=null;
		try {
			returnList = custOrderDao.findCustOrders(findCustOrderPage);
		} catch (Exception e) {
			logger.error("查找商品定制订单信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.CUST_ORDER_NOT_EXIST_ERROR,"商品定制订单信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateCustOrder(
			CustOrderDto custOrderDto)
			throws TsfaServiceException {
		logger.debug("updateCustOrder(CustOrderDto custOrderDto={}) - start", custOrderDto); //$NON-NLS-1$

		AssertUtils.notNull(custOrderDto);
		AssertUtils.notNullAndEmpty(custOrderDto.getCode(),"Code不能为空");
		try {
			CustOrder custOrder = new CustOrder();
			//update数据录入
			custOrder.setCode(custOrderDto.getCode());
			custOrder.setSupplyCode(custOrderDto.getSupplyCode());
			custOrder.setSupplyName(custOrderDto.getSupplyName());
			custOrder.setImg1(custOrderDto.getImg1());
			custOrder.setImg2(custOrderDto.getImg2());
			custOrder.setImg3(custOrderDto.getImg3());
			custOrder.setImg4(custOrderDto.getImg4());
			custOrder.setImg5(custOrderDto.getImg5());
			custOrder.setImg6(custOrderDto.getImg6());
			custOrder.setRemarks(custOrderDto.getRemarks());
			custOrder.setPayAmt(custOrderDto.getPayAmt());
			custOrder.setUpdateTime(new Date());
			custOrder.setCatalogCode(custOrderDto.getCatalogCode());
			custOrder.setCatalogName(custOrderDto.getCatalogName());
			custOrder.setPayType(custOrderDto.getPayType());
			custOrder.setOrderNo(custOrderDto.getOrderNo());
			custOrder.setCostPrice(custOrderDto.getCostPrice());
			custOrder.setOrgPrice(custOrderDto.getOrgPrice());
			custOrder.setGapPrice(custOrderDto.getGapPrice());
			custOrder.setSalePrice(custOrderDto.getSalePrice());
			custOrder.setMerchantCode(custOrderDto.getMerchantCode());
			custOrder.setStatus(custOrderDto.getStatus());
			custOrder.setExpressNo(custOrderDto.getExpressNo());
			custOrder.setExpressName(custOrderDto.getExpressName());
			custOrder.setMbrCode(custOrderDto.getMbrCode());
			custOrder.setShopCode(custOrderDto.getShopCode());
			custOrder.setShopName(custOrderDto.getShopName());
			AssertUtils.notUpdateMoreThanOne(custOrderDao.updateByPrimaryKeySelective(custOrder));
			logger.debug("updateCustOrder(CustOrderDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品定制订单信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CUST_ORDER_UPDATE_ERROR,"商品定制订单信息更新信息错误！",e);
		}
	}

	

	@Override
	public CustOrderDto findCustOrder(
			CustOrderDto custOrderDto) throws TsfaServiceException {
		logger.debug("findCustOrder(FindCustOrder findCustOrder={}) - start", custOrderDto); //$NON-NLS-1$

		AssertUtils.notNull(custOrderDto);
		AssertUtils.notAllNull(custOrderDto.getCode(),"Code不能为空");
		try {
			CustOrder custOrder = custOrderDao.selectByPrimaryKey(custOrderDto.getCode());
			if(custOrder == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.CUST_ORDER_NOT_EXIST_ERROR,"商品定制订单信息不存在");
			}
			CustOrderDto findCustOrderReturn = new CustOrderDto();
			//find数据录入
			findCustOrderReturn.setCode(custOrder.getCode());
			findCustOrderReturn.setSupplyCode(custOrder.getSupplyCode());
			findCustOrderReturn.setSupplyName(custOrder.getSupplyName());
			findCustOrderReturn.setImg1(custOrder.getImg1());
			findCustOrderReturn.setImg2(custOrder.getImg2());
			findCustOrderReturn.setImg3(custOrder.getImg3());
			findCustOrderReturn.setImg4(custOrder.getImg4());
			findCustOrderReturn.setImg5(custOrder.getImg5());
			findCustOrderReturn.setImg6(custOrder.getImg6());
			findCustOrderReturn.setRemarks(custOrder.getRemarks());
			findCustOrderReturn.setPayAmt(custOrder.getPayAmt());
			findCustOrderReturn.setCreateTime(custOrder.getCreateTime());
			findCustOrderReturn.setUpdateTime(custOrder.getUpdateTime());
			findCustOrderReturn.setCatalogCode(custOrder.getCatalogCode());
			findCustOrderReturn.setCatalogName(custOrder.getCatalogName());
			findCustOrderReturn.setPayType(custOrder.getPayType());
			findCustOrderReturn.setOrderNo(custOrder.getOrderNo());
			findCustOrderReturn.setCostPrice(custOrder.getCostPrice());
			findCustOrderReturn.setOrgPrice(custOrder.getOrgPrice());
			findCustOrderReturn.setGapPrice(custOrder.getGapPrice());
			findCustOrderReturn.setSalePrice(custOrder.getSalePrice());
			findCustOrderReturn.setMerchantCode(custOrder.getMerchantCode());
			findCustOrderReturn.setStatus(custOrder.getStatus());
			findCustOrderReturn.setExpressNo(custOrder.getExpressNo());
			findCustOrderReturn.setExpressName(custOrder.getExpressName());
			findCustOrderReturn.setMbrCode(custOrder.getMbrCode());
			findCustOrderReturn.setShopCode(custOrder.getShopCode());
			findCustOrderReturn.setShopName(custOrder.getShopName());
			logger.debug("findCustOrder(CustOrderDto) - end - return value={}", findCustOrderReturn); //$NON-NLS-1$
			return findCustOrderReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品定制订单信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CUST_ORDER_FIND_ERROR,"查找商品定制订单信息信息错误！",e);
		}


	}

	
	@Override
	public Page<CustOrderDto> findCustOrderPage(
			FindCustOrderPage findCustOrderPage)
			throws TsfaServiceException {
		logger.debug("findCustOrderPage(FindCustOrderPage findCustOrderPage={}) - start", findCustOrderPage); //$NON-NLS-1$

		AssertUtils.notNull(findCustOrderPage);
		List<CustOrderDto> returnList=null;
		int count = 0;
		try {
			returnList = custOrderDao.findCustOrderPage(findCustOrderPage);
			count = custOrderDao.findCustOrderPageCount(findCustOrderPage);
		}  catch (Exception e) {
			logger.error("商品定制订单信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.CUST_ORDER_FIND_PAGE_ERROR,"商品定制订单信息不存在错误.！",e);
		}
		Page<CustOrderDto> returnPage = new Page<CustOrderDto>(returnList, count, findCustOrderPage);

		logger.debug("findCustOrderPage(FindCustOrderPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	public void shipping(CustOrderDto custOrderDto,String expressNo,String expressName) throws TsfaServiceException {
		logger.debug("shipping(CustOrderDto custOrderDto={}) - start", custOrderDto); 
		AssertUtils.notNull(custOrderDto);
		AssertUtils.notNullAndEmpty(custOrderDto.getCode(),"定制订单编号不能为空");
		try {
			
			/*已付款*/
			if(!custOrderDto.getStatus().equals(CustOrderStatus.PAYMENT.getValue())){
				logger.error("商品定制订单状态流转错误！");
				throw new TsfaServiceException(ErrorCode.CUST_ORDER_STATUS_ERROR,"商品定制订单状态流转错误！");
			}
			
			/*状态流转至待收货*/
			custOrderDto.setStatus(CustOrderStatus.SHIPPED.getValue());
			custOrderDto.setExpressNo(expressNo);
			custOrderDto.setExpressName(expressName);
			this.updateCustOrder(custOrderDto);
			/*消息通知	TODO*/
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("商品定制订单发货错误！",e);
			throw new TsfaServiceException(ErrorCode.CUST_ORDER_UPDATE_ERROR,"商品定制订单发货错误！",e);
		}
	}


	@Override
	public void offer(CustOrderDto custOrderDto) throws TsfaServiceException {
		logger.debug("offer(CustOrderDto custOrderDto={}) - start", custOrderDto); 
		AssertUtils.notNull(custOrderDto);
		AssertUtils.notNullAndEmpty(custOrderDto.getCode(),"编号不能为空");
		AssertUtils.notNullAndEmpty(custOrderDto.getSupplyCode(),"供应商编号不能为空");
		AssertUtils.notNullAndEmpty(custOrderDto.getSupplyName(),"供应商名称不能为空");
		AssertUtils.notNullAndEmpty(custOrderDto.getCostPrice(),"出厂价不能为空");
		AssertUtils.notNullAndEmpty(custOrderDto.getOrgPrice(),"B端售价不能为空");
		try {
			/*待报价*/
			if(!custOrderDto.getStatus().equals(CustOrderStatus.UNOFFER.getValue())){
				logger.error("商品定制订单状态流转错误！");
				throw new TsfaServiceException(ErrorCode.CUST_ORDER_STATUS_ERROR,"商品定制订单状态流转错误！");
			}
			
			/*定制订单状态流转至待用户确认*/
			custOrderDto.setStatus(CustOrderStatus.UNCONFIRM.getValue());
			this.updateCustOrder(custOrderDto);
			
			/*消息通知	*/
			sendMessageByOrder(custOrderDto);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品定制订单商户报价错误！",e);
			throw new TsfaServiceException(ErrorCode.CUST_ORDER_UPDATE_ERROR,"商品定制订单商户报价错误！",e);
		}
		
	}


	@Override
	public void complete(CustOrderDto custOrderDto) throws TsfaServiceException {
		logger.debug("complete(CustOrderDto custOrderDto={}) - start", custOrderDto); 
		AssertUtils.notNull(custOrderDto);
		AssertUtils.notNullAndEmpty(custOrderDto.getOrderNo(),"订单编号不能为空");
		AssertUtils.notNullAndEmpty(custOrderDto.getShopCode(),"店铺编号不能为空");
		AssertUtils.notNullAndEmpty(custOrderDto.getPayAmt(),"已支付金额不能为空");
		try {
			
			/*状态流转至已完成*/
			custOrderDto.setStatus(CustOrderStatus.SUCCESS.getValue());
			this.updateCustOrder(custOrderDto);
			
			/*店主提成-店主账户增加提成金额*/
			/*获取店铺*/
			ShopDto parmShop = new ShopDto();
			parmShop.setCode(custOrderDto.getShopCode());
			ShopDto shopDto= shopService.findShop(parmShop);
			
			/*获取店主账户-增加提成*/
			AccountDto accountDto=  accountService.findAccountByMbrCode(shopDto.getMbrCode());
			BigDecimal beforeAmt = accountDto.getCashAmt();
			accountDto.setCashAmt(accountDto.getCashAmt().add(custOrderDto.getPayAmt()));
			accountService.updateAccount(accountDto);
			
			/*记录账户流水*/
			AccWaterDto accWaterDto = new AccWaterDto();
			accWaterDto.setAccWaterNo(NoUtil.generateNo(NoUtil.JY));
			accWaterDto.setAccDate(new Date());
			accWaterDto.setAccSource(AccWaterSource.COMMISSION.getValue());
			accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
			accWaterDto.setAmt(custOrderDto.getPayAmt());
			accWaterDto.setAccNo(accountDto.getAccNo());
			accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
//			accWaterDto.setPayType(custOrderDto.getPayType());		TODO 加支付字段
			accWaterDto.setBeforeAmt(beforeAmt);
			accWaterDto.setAfterAmt(accountDto.getCashAmt());
			accWaterDto.setBizType(AccWaterBizType.COMMISSION.getValue());
			accWaterDto.setWaterType(AccWaterType.ADD.getValue());
			accWaterService.addAccWater(accWaterDto);
			
			/*消息通知	TODO*/
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("订单发货错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_SHIPPED_ERROR,"订单发货错误！",e);
		}
		
		
	}


	@Override
	public void offerShop(CustOrderDto custOrderDto)
			throws TsfaServiceException {
		logger.debug("offerShop(CustOrderDto custOrderDto={}) - start", custOrderDto); 
		AssertUtils.notNull(custOrderDto);
		AssertUtils.notNullAndEmpty(custOrderDto.getCode(),"编号不能为空");
		AssertUtils.notNullAndEmpty(custOrderDto.getSalePrice(),"C端售价不能为空");
		try {
			/*待用户确认*/
			if(!custOrderDto.getStatus().equals(CustOrderStatus.UNCONFIRM.getValue())){
				logger.error("商品定制订单状态流转错误！");
				throw new TsfaServiceException(ErrorCode.CUST_ORDER_STATUS_ERROR,"商品定制订单状态流转错误！");
			}
			
			/*计算差价=C端价-B端价*/
			custOrderDto.setGapPrice(custOrderDto.getSalePrice().subtract(custOrderDto.getOrgPrice()));
			
			/*定制订单状态流转至待付款*/
			custOrderDto.setStatus(CustOrderStatus.UNPAID.getValue());
			this.updateCustOrder(custOrderDto);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品定制订单商户报价错误！",e);
			throw new TsfaServiceException(ErrorCode.CUST_ORDER_UPDATE_ERROR,"商品定制订单商户报价错误！",e);
		}
		
	}


	@Override
	public void payment(CustOrderDto custOrderDto,BigDecimal amt,String payType) throws TsfaServiceException {
		logger.debug("payment(CustOrderDto custOrderDto={}) - start", custOrderDto); 
		AssertUtils.notNull(custOrderDto);
		AssertUtils.notNullAndEmpty(custOrderDto.getCode(),"编号不能为空");
		AssertUtils.notNullAndEmpty(amt,"付款金额不能为空");
		AssertUtils.notNullAndEmpty(custOrderDto.getPayType(),"支付类型不能为空");
		AssertUtils.notNullAndEmpty(custOrderDto.getSalePrice(),"C端售价不能为空");
		AssertUtils.notNullAndEmpty(custOrderDto.getMbrCode(),"会员编号不能为空");
		try {
			/*待支付 || 待付尾款*/
			if(!custOrderDto.getStatus().equals(CustOrderStatus.UNPAID.getValue())&&!custOrderDto.getStatus().equals(CustOrderStatus.UNRETAINAGE.getValue())){
				logger.error("商品定制订单状态流转错误！");
				throw new TsfaServiceException(ErrorCode.CUST_ORDER_STATUS_ERROR,"商品定制订单状态流转错误！");
			}
			
			/*已付金额*/
			custOrderDto.setPayAmt(custOrderDto.getPayAmt().add(amt));
			
			/*已付款*/
			if(custOrderDto.getPayAmt().compareTo(custOrderDto.getSalePrice())>=0){
				custOrderDto.setStatus(CustOrderStatus.PAYMENT.getValue());
			}else{
				custOrderDto.setStatus(CustOrderStatus.UNRETAINAGE.getValue());
			}
			this.updateCustOrder(custOrderDto);
			
			/*获取账户*/
			AccountDto accountDto= accountService.findAccountByMbrCode(custOrderDto.getMbrCode());
			
			/*记录账户流水*/
			AccWaterDto accWaterDto = new AccWaterDto();
			accWaterDto.setAccWaterNo(NoUtil.generateNo(NoUtil.JY));
			accWaterDto.setAccDate(new Date());
			accWaterDto.setAccSource(AccWaterSource.CUSTORDER.getValue());
			accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
			accWaterDto.setAmt(amt);
			accWaterDto.setAccNo(accountDto.getAccNo());
			accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
			accWaterDto.setPayType(payType);
			accWaterDto.setBizType(AccWaterBizType.PAYMENT.getValue());
			accWaterDto.setWaterType(AccWaterType.ADD.getValue());
			accWaterService.addAccWater(accWaterDto);
			
			//TODO 消息通知
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品定制订单商户报价错误！",e);
			throw new TsfaServiceException(ErrorCode.CUST_ORDER_UPDATE_ERROR,"商品定制订单商户报价错误！",e);
		}
	} 


	/**send message**/
	private void sendMessageByOrder(CustOrderDto orderDto) {
		
		ShopDto shopDto = new ShopDto();
		shopDto.setCode(orderDto.getShopCode());
		shopDto = shopService.findShop(shopDto);
		
		//消息实体
		MessageDto messageDto = new MessageDto();
		messageDto.setRecevier(shopDto.getMbrCode());
		messageService.addMessageByTemplate(messageDto, MessageTemplate.B_SERVICE_NOT_PARAM_ORDER_BILL_FEEDBACK);
	}
}
