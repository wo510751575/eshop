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
import com.lj.eshop.dao.IShopStyleDao;
import com.lj.eshop.domain.ShopStyle;
import com.lj.eshop.dto.FindShopStylePage;
import com.lj.eshop.dto.ShopStyleDto;
import com.lj.eshop.service.IShopStyleService;
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
public class ShopStyleServiceImpl implements IShopStyleService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ShopStyleServiceImpl.class);
	

	@Resource
	private IShopStyleDao shopStyleDao;
	
	
	@Override
	public void addShopStyle(
			ShopStyleDto shopStyleDto) throws TsfaServiceException {
		logger.debug("addShopStyle(AddShopStyle addShopStyle={}) - start", shopStyleDto); 

		AssertUtils.notNull(shopStyleDto);
		try {
			ShopStyle shopStyle = new ShopStyle();
			//add数据录入
			shopStyle.setCode(GUID.generateCode());
			shopStyle.setName(shopStyleDto.getName());
			shopStyle.setSpe(shopStyleDto.getSpe());
			shopStyle.setStatus(shopStyleDto.getStatus());
			shopStyleDao.insertSelective(shopStyle);
			logger.debug("addShopStyle(ShopStyleDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增店铺风格信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_STYLE_ADD_ERROR,"新增店铺风格信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询店铺风格信息
	 *
	 * @param findShopStylePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ShopStyleDto>  findShopStyles(FindShopStylePage findShopStylePage)throws TsfaServiceException{
		AssertUtils.notNull(findShopStylePage);
		List<ShopStyleDto> returnList=null;
		try {
			returnList = shopStyleDao.findShopStyles(findShopStylePage);
		} catch (Exception e) {
			logger.error("查找店铺风格信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SHOP_STYLE_NOT_EXIST_ERROR,"店铺风格信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateShopStyle(
			ShopStyleDto shopStyleDto)
			throws TsfaServiceException {
		logger.debug("updateShopStyle(ShopStyleDto shopStyleDto={}) - start", shopStyleDto); //$NON-NLS-1$

		AssertUtils.notNull(shopStyleDto);
		AssertUtils.notNullAndEmpty(shopStyleDto.getCode(),"Code不能为空");
		try {
			ShopStyle shopStyle = new ShopStyle();
			//update数据录入
			shopStyle.setCode(shopStyleDto.getCode());
			shopStyle.setName(shopStyleDto.getName());
			shopStyle.setSpe(shopStyleDto.getSpe());
			shopStyle.setStatus(shopStyleDto.getStatus());
			AssertUtils.notUpdateMoreThanOne(shopStyleDao.updateByPrimaryKeySelective(shopStyle));
			logger.debug("updateShopStyle(ShopStyleDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("店铺风格信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_STYLE_UPDATE_ERROR,"店铺风格信息更新信息错误！",e);
		}
	}

	

	@Override
	public ShopStyleDto findShopStyle(
			ShopStyleDto shopStyleDto) throws TsfaServiceException {
		logger.debug("findShopStyle(FindShopStyle findShopStyle={}) - start", shopStyleDto); //$NON-NLS-1$

		AssertUtils.notNull(shopStyleDto);
		AssertUtils.notAllNull(shopStyleDto.getCode(),"Code不能为空");
		try {
			ShopStyle shopStyle = shopStyleDao.selectByPrimaryKey(shopStyleDto.getCode());
			if(shopStyle == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.SHOP_STYLE_NOT_EXIST_ERROR,"店铺风格信息不存在");
			}
			ShopStyleDto findShopStyleReturn = new ShopStyleDto();
			//find数据录入
			findShopStyleReturn.setCode(shopStyle.getCode());
			findShopStyleReturn.setName(shopStyle.getName());
			findShopStyleReturn.setSpe(shopStyle.getSpe());
			findShopStyleReturn.setStatus(shopStyle.getStatus());
			
			logger.debug("findShopStyle(ShopStyleDto) - end - return value={}", findShopStyleReturn); //$NON-NLS-1$
			return findShopStyleReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找店铺风格信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_STYLE_FIND_ERROR,"查找店铺风格信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ShopStyleDto> findShopStylePage(
			FindShopStylePage findShopStylePage)
			throws TsfaServiceException {
		logger.debug("findShopStylePage(FindShopStylePage findShopStylePage={}) - start", findShopStylePage); //$NON-NLS-1$

		AssertUtils.notNull(findShopStylePage);
		List<ShopStyleDto> returnList=null;
		int count = 0;
		try {
			returnList = shopStyleDao.findShopStylePage(findShopStylePage);
			count = shopStyleDao.findShopStylePageCount(findShopStylePage);
		}  catch (Exception e) {
			logger.error("店铺风格信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_STYLE_FIND_PAGE_ERROR,"店铺风格信息不存在错误.！",e);
		}
		Page<ShopStyleDto> returnPage = new Page<ShopStyleDto>(returnList, count, findShopStylePage);

		logger.debug("findShopStylePage(FindShopStylePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
