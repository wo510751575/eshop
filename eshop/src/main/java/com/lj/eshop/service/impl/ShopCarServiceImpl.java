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
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IShopCarDao;
import com.lj.eshop.domain.ShopCar;
import com.lj.eshop.dto.FindShopCarPage;
import com.lj.eshop.dto.ShopCarDto;
import com.lj.eshop.service.IShopCarService;
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
public class ShopCarServiceImpl implements IShopCarService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ShopCarServiceImpl.class);
	

	@Resource
	private IShopCarDao shopCarDao;
	
	
	@Override
	public void addShopCar(
			ShopCarDto shopCarDto) throws TsfaServiceException {
		logger.debug("addShopCar(AddShopCar addShopCar={}) - start", shopCarDto); 

		AssertUtils.notNull(shopCarDto);
		try {
			ShopCar shopCar = new ShopCar();
			//add数据录入
			shopCar.setCode(GUID.generateCode());
			shopCar.setProductCode(shopCarDto.getProductCode());
			shopCar.setProductName(shopCarDto.getProductName());
			shopCar.setProductSkuCode(shopCarDto.getProductSkuCode());
			shopCar.setCnt(shopCarDto.getCnt());
			shopCar.setCreateTime(new Date());
			shopCar.setMbrCode(shopCarDto.getMbrCode());
			shopCar.setImg(shopCarDto.getImg());
			shopCar.setShopCode(shopCarDto.getShopCode());
			shopCarDao.insertSelective(shopCar);
			logger.debug("addShopCar(ShopCarDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增购物车信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_CAR_ADD_ERROR,"新增购物车信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询购物车信息
	 *
	 * @param findShopCarPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ShopCarDto>  findShopCars(FindShopCarPage findShopCarPage)throws TsfaServiceException{
		AssertUtils.notNull(findShopCarPage);
		List<ShopCarDto> returnList=null;
		try {
			returnList = shopCarDao.findShopCars(findShopCarPage);
		} catch (Exception e) {
			logger.error("查找购物车信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SHOP_CAR_NOT_EXIST_ERROR,"购物车信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateShopCar(
			ShopCarDto shopCarDto)
			throws TsfaServiceException {
		logger.debug("updateShopCar(ShopCarDto shopCarDto={}) - start", shopCarDto); //$NON-NLS-1$

		AssertUtils.notNull(shopCarDto);
		AssertUtils.notNullAndEmpty(shopCarDto.getCode(),"Code不能为空");
		try {
			ShopCar shopCar = new ShopCar();
			//update数据录入
			shopCar.setCode(shopCarDto.getCode());
			shopCar.setProductCode(shopCarDto.getProductCode());
			shopCar.setProductName(shopCarDto.getProductName());
			shopCar.setProductSkuCode(shopCarDto.getProductSkuCode());
			shopCar.setCnt(shopCarDto.getCnt());
			shopCar.setCreateTime(shopCarDto.getCreateTime());
			shopCar.setMbrCode(shopCarDto.getMbrCode());
			shopCar.setImg(shopCarDto.getImg());
			shopCar.setShopCode(shopCarDto.getShopCode());
			AssertUtils.notUpdateMoreThanOne(shopCarDao.updateByPrimaryKeySelective(shopCar));
			logger.debug("updateShopCar(ShopCarDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("购物车信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_CAR_UPDATE_ERROR,"购物车信息更新信息错误！",e);
		}
	}

	

	@Override
	public ShopCarDto findShopCar(
			ShopCarDto shopCarDto) throws TsfaServiceException {
		logger.debug("findShopCar(FindShopCar findShopCar={}) - start", shopCarDto); //$NON-NLS-1$

		AssertUtils.notNull(shopCarDto);
		AssertUtils.notAllNull(shopCarDto.getCode(),"Code不能为空");
		try {
			ShopCar shopCar = shopCarDao.selectByPrimaryKey(shopCarDto.getCode());
			if(shopCar == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.SHOP_CAR_NOT_EXIST_ERROR,"购物车信息不存在");
			}
			ShopCarDto findShopCarReturn = new ShopCarDto();
			//find数据录入
			findShopCarReturn.setCode(shopCar.getCode());
			findShopCarReturn.setProductCode(shopCar.getProductCode());
			findShopCarReturn.setProductName(shopCar.getProductName());
			findShopCarReturn.setProductSkuCode(shopCar.getProductSkuCode());
			findShopCarReturn.setCnt(shopCar.getCnt());
			findShopCarReturn.setCreateTime(shopCar.getCreateTime());
			findShopCarReturn.setMbrCode(shopCar.getMbrCode());
			findShopCarReturn.setImg(shopCar.getImg());
			findShopCarReturn.setShopCode(shopCar.getShopCode());
			logger.debug("findShopCar(ShopCarDto) - end - return value={}", findShopCarReturn); //$NON-NLS-1$
			return findShopCarReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找购物车信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_CAR_FIND_ERROR,"查找购物车信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ShopCarDto> findShopCarPage(
			FindShopCarPage findShopCarPage)
			throws TsfaServiceException {
		logger.debug("findShopCarPage(FindShopCarPage findShopCarPage={}) - start", findShopCarPage); //$NON-NLS-1$

		AssertUtils.notNull(findShopCarPage);
		List<ShopCarDto> returnList=null;
		int count = 0;
		try {
			returnList = shopCarDao.findShopCarPage(findShopCarPage);
			count = shopCarDao.findShopCarPageCount(findShopCarPage);
		}  catch (Exception e) {
			logger.error("购物车信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_CAR_FIND_PAGE_ERROR,"购物车信息不存在错误.！",e);
		}
		Page<ShopCarDto> returnPage = new Page<ShopCarDto>(returnList, count, findShopCarPage);

		logger.debug("findShopCarPage(FindShopCarPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	public void deleteShopCar(String code) throws TsfaServiceException {
		logger.debug("deleteShopCar(String code={}) - start", code); 
		AssertUtils.notNullAndEmpty(code,"编号不能为空");
		int count = 0;
		try {
			count = shopCarDao.deleteByPrimaryKey(code);
		}  catch (Exception e) {
			logger.error("购物车信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_CAR_DEL_ERROR,"购物车删除错误.！",e);
		}
		logger.debug("deleteShopCar(count) - end - return value={}", count);
	} 


}
