package com.lj.eshop.service.impl;

import java.math.BigDecimal;
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
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dao.IShopDao;
import com.lj.eshop.domain.Shop;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindShopPage;
import com.lj.eshop.dto.MemberRankApplyDto;
import com.lj.eshop.dto.MemberRankDto;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.MessageTemplate;
import com.lj.eshop.emus.ShopStatus;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAccountService;
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
public class ShopServiceImpl implements IShopService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);
	

	@Resource
	private IShopDao shopDao;

	@Resource
	private IAccWaterService accWaterService;
	
	@Resource
	private IAccountService accountService;
	@Override
	public ShopDto addShop(
			ShopDto shopDto) throws TsfaServiceException {
		logger.debug("addShop(AddShop addShop={}) - start", shopDto); 

		AssertUtils.notNull(shopDto);
		try {
			Shop shop = new Shop();
			//add数据录入
			shop.setCode(GUID.generateCode());
			shop.setShopName(shopDto.getShopName());
			shop.setShopProvide(shopDto.getShopProvide());
			shop.setShopCity(shopDto.getShopCity());
			shop.setShopArea(shopDto.getShopArea());
			shop.setShopAddinfo(shopDto.getShopAddinfo());
			shop.setStatus(shopDto.getStatus());
			shop.setImg(shopDto.getImg());
			shop.setShopFlag(shopDto.getShopFlag());
			shop.setShopBgImgCode(shopDto.getShopBgImgCode());
			shop.setShopGarde(shopDto.getShopGarde());
			shop.setCloseReason(shopDto.getCloseReason());
			shop.setCreateTime(new Date());
			shop.setCloseTime(shopDto.getCloseTime());
			shop.setOpenTime(shopDto.getOpenTime());
			shop.setShopStyleCode(shopDto.getShopStyleCode());
			shop.setMimeCode(shopDto.getMimeCode());
			shop.setReadNum(shopDto.getReadNum());
			shop.setMerchantCode(shopDto.getMerchantCode());
			shop.setMbrCode(shopDto.getMbrCode());
			shop.setRankCode(shopDto.getRankCode());
			shop.setRankExpireTime(shopDto.getRankExpireTime());
			shop.setUnLogin(shopDto.getUnLogin());
			shop.setShopNo(shopDto.getShopNo());
			shopDao.insertSelective(shop);
			logger.debug("addShop(ShopDto) - end - return"); 
			ShopDto rt=new ShopDto();
			rt.setCode(shop.getCode());
			rt.setMbrCode(shopDto.getMbrCode());
			return rt;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增微店店铺信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_ADD_ERROR,"新增微店店铺信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询微店店铺信息
	 *
	 * @param findShopPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ShopDto>  findShops(FindShopPage findShopPage)throws TsfaServiceException{
		AssertUtils.notNull(findShopPage);
		List<ShopDto> returnList=null;
		try {
			returnList = shopDao.findShops(findShopPage);
		} catch (Exception e) {
			logger.error("查找微店店铺信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SHOP_NOT_EXIST_ERROR,"微店店铺信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateShop(
			ShopDto shopDto)
			throws TsfaServiceException {
		logger.debug("updateShop(ShopDto shopDto={}) - start", shopDto); //$NON-NLS-1$

		AssertUtils.notNull(shopDto);
		AssertUtils.notNullAndEmpty(shopDto.getCode(),"Code不能为空");
		try {
			Shop shop = new Shop();
			//update数据录入
			shop.setCode(shopDto.getCode());
			shop.setShopName(shopDto.getShopName());
			shop.setShopProvide(shopDto.getShopProvide());
			shop.setShopCity(shopDto.getShopCity());
			shop.setShopArea(shopDto.getShopArea());
			shop.setShopAddinfo(shopDto.getShopAddinfo());
			shop.setStatus(shopDto.getStatus());
			shop.setImg(shopDto.getImg());
			shop.setShopFlag(shopDto.getShopFlag());
			shop.setShopBgImgCode(shopDto.getShopBgImgCode());
			shop.setShopGarde(shopDto.getShopGarde());
			shop.setCloseReason(shopDto.getCloseReason());
			shop.setCloseTime(shopDto.getCloseTime());
			shop.setOpenTime(shopDto.getOpenTime());
			shop.setShopStyleCode(shopDto.getShopStyleCode());
			shop.setMimeCode(shopDto.getMimeCode());
			shop.setReadNum(shopDto.getReadNum());
			shop.setMerchantCode(shopDto.getMerchantCode());
			shop.setMbrCode(shopDto.getMbrCode());
			shop.setRankCode(shopDto.getRankCode());
			shop.setRankExpireTime(shopDto.getRankExpireTime());
			shop.setUnLogin(shopDto.getUnLogin());
			shop.setShopNo(shopDto.getShopNo());
			AssertUtils.notUpdateMoreThanOne(shopDao.updateByPrimaryKeySelective(shop));
			logger.debug("updateShop(ShopDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("微店店铺信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_UPDATE_ERROR,"微店店铺信息更新信息错误！",e);
		}
	}

	

	@Override
	public ShopDto findShop(
			ShopDto shopDto) throws TsfaServiceException {
		logger.debug("findShop(FindShop findShop={}) - start", shopDto); //$NON-NLS-1$

		AssertUtils.notNull(shopDto);
		AssertUtils.notAllNull(shopDto.getCode(),"Code不能为空");
		try {
			Shop shop = shopDao.selectByPrimaryKey(shopDto.getCode());
			if(shop == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.SHOP_NOT_EXIST_ERROR,"微店店铺信息不存在");
			}
			ShopDto findShopReturn = new ShopDto();
			//find数据录入
			findShopReturn.setCode(shop.getCode());
			findShopReturn.setShopName(shop.getShopName());
			findShopReturn.setShopProvide(shop.getShopProvide());
			findShopReturn.setShopCity(shop.getShopCity());
			findShopReturn.setShopArea(shop.getShopArea());
			findShopReturn.setShopAddinfo(shop.getShopAddinfo());
			findShopReturn.setStatus(shop.getStatus());
			findShopReturn.setImg(shop.getImg());
			findShopReturn.setShopFlag(shop.getShopFlag());
			findShopReturn.setShopBgImgCode(shop.getShopBgImgCode());
			findShopReturn.setShopGarde(shop.getShopGarde());
			findShopReturn.setCloseReason(shop.getCloseReason());
			findShopReturn.setCreateTime(shop.getCreateTime());
			findShopReturn.setCloseTime(shop.getCloseTime());
			findShopReturn.setOpenTime(shop.getOpenTime());
			findShopReturn.setShopStyleCode(shop.getShopStyleCode());
			findShopReturn.setMimeCode(shop.getMimeCode());
			findShopReturn.setReadNum(shop.getReadNum());
			findShopReturn.setMerchantCode(shop.getMerchantCode());
			findShopReturn.setMbrCode(shop.getMbrCode());
			findShopReturn.setUnLogin(shop.getUnLogin());
			findShopReturn.setShopNo(shop.getShopNo());
			findShopReturn.setRankCode(shop.getRankCode());
			findShopReturn.setRankExpireTime(shop.getRankExpireTime());
			logger.debug("findShop(ShopDto) - end - return value={}", findShopReturn); //$NON-NLS-1$
			return findShopReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找微店店铺信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"查找微店店铺信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ShopDto> findShopPage(
			FindShopPage findShopPage)
			throws TsfaServiceException {
		logger.debug("findShopPage(FindShopPage findShopPage={}) - start", findShopPage); //$NON-NLS-1$

		AssertUtils.notNull(findShopPage);
		List<ShopDto> returnList=null;
		int count = 0;
		try {
			returnList = shopDao.findShopPage(findShopPage);
			count = shopDao.findShopPageCount(findShopPage);
		}  catch (Exception e) {
			logger.error("微店店铺信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_PAGE_ERROR,"微店店铺信息不存在错误.！",e);
		}
		Page<ShopDto> returnPage = new Page<ShopDto>(returnList, count, findShopPage);

		logger.debug("findShopPage(FindShopPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	public void payment(PaymentDto paymentDto) {
		logger.debug("payment(PaymentDto paymentDto={}) - start", paymentDto); 
		AssertUtils.notNull(paymentDto);
//		AssertUtils.notNull(paymentDto.getAmount(),"支付金额不能为空");
//		AssertUtils.notNullAndEmpty(paymentDto.getAccCode(),"账户编号不能为空");
		AssertUtils.notNullAndEmpty(paymentDto.getBizNo(),"订单号不能为空");
//		AssertUtils.notNullAndEmpty(paymentDto.getPaymentMethod(),"支付方式不能为空");
		AccountDto accountDto = accountService.findAccountByMbrCode(paymentDto.getMbrCode());
		try {
			if(paymentDto.getAmount().compareTo(NoUtil.DEFAULT_CASH_PLEDGE)<=0){
				
				/*记录账户流水*/
				AccWaterDto accWaterDto = new AccWaterDto();
				accWaterDto.setAccWaterNo(NoUtil.generateNo(NoUtil.JY));
				accWaterDto.setAccDate(new Date());
				accWaterDto.setAccSource(AccWaterSource.DEPOSIT.getValue());
				accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
				accWaterDto.setAmt(paymentDto.getAmount());
				accWaterDto.setAccNo(accountDto.getAccNo());
				accWaterDto.setAccCode(accountDto.getCode());
				accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
				accWaterDto.setPayType(paymentDto.getPaymentMethod());
				accWaterDto.setBizType(AccWaterBizType.RECHARGE.getValue());
				accWaterDto.setWaterType(AccWaterType.ADD.getValue());
				accWaterService.addAccWater(accWaterDto);
			} else {
				throw new TsfaServiceException(ErrorCode.ORDER_PAYMENT_ERROR,"付款金额有误："+paymentDto.getAmount());
			}

			FindShopPage findShopPage = new FindShopPage();
			ShopDto shopDto = new ShopDto();
			shopDto.setShopNo(paymentDto.getBizNo());
			findShopPage.setParam(shopDto);
			List<ShopDto> shopList = findShops(findShopPage);
			//更新商店为正常
			ShopDto updShopDto =  new ShopDto();
			updShopDto.setCode(shopList.get(0).getCode());
			updShopDto.setStatus(ShopStatus.NORMAL.getValue());
			updateShop(updShopDto);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("开店支付错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_PAYMENT_ERROR,"开店支付错误！",e);
		}
		
	}


	@Override
	public BigDecimal queryCashPledge(String shopNo) {
		
		return NoUtil.DEFAULT_CASH_PLEDGE;
	} 


}
