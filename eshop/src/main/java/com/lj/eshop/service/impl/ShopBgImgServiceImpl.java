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
import com.lj.eshop.dao.IShopBgImgDao;
import com.lj.eshop.domain.ShopBgImg;
import com.lj.eshop.dto.FindShopBgImgPage;
import com.lj.eshop.dto.ShopBgImgDto;
import com.lj.eshop.service.IShopBgImgService;
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
public class ShopBgImgServiceImpl implements IShopBgImgService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ShopBgImgServiceImpl.class);
	

	@Resource
	private IShopBgImgDao shopBgImgDao;
	
	
	@Override
	public void addShopBgImg(
			ShopBgImgDto shopBgImgDto) throws TsfaServiceException {
		logger.debug("addShopBgImg(AddShopBgImg addShopBgImg={}) - start", shopBgImgDto); 

		AssertUtils.notNull(shopBgImgDto);
		try {
			ShopBgImg shopBgImg = new ShopBgImg();
			//add数据录入
			shopBgImg.setCode(GUID.generateCode());
			shopBgImg.setName(shopBgImgDto.getName());
			shopBgImg.setSpe(shopBgImgDto.getSpe());
			shopBgImg.setStatus(shopBgImgDto.getStatus());
			shopBgImgDao.insertSelective(shopBgImg);
			logger.debug("addShopBgImg(ShopBgImgDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增店铺背景图信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_BG_IMG_ADD_ERROR,"新增店铺背景图信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询店铺背景图信息
	 *
	 * @param findShopBgImgPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ShopBgImgDto>  findShopBgImgs(FindShopBgImgPage findShopBgImgPage)throws TsfaServiceException{
		AssertUtils.notNull(findShopBgImgPage);
		List<ShopBgImgDto> returnList=null;
		try {
			returnList = shopBgImgDao.findShopBgImgs(findShopBgImgPage);
		} catch (Exception e) {
			logger.error("查找店铺背景图信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SHOP_BG_IMG_NOT_EXIST_ERROR,"店铺背景图信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateShopBgImg(
			ShopBgImgDto shopBgImgDto)
			throws TsfaServiceException {
		logger.debug("updateShopBgImg(ShopBgImgDto shopBgImgDto={}) - start", shopBgImgDto); //$NON-NLS-1$

		AssertUtils.notNull(shopBgImgDto);
		AssertUtils.notNullAndEmpty(shopBgImgDto.getCode(),"Code不能为空");
		try {
			ShopBgImg shopBgImg = new ShopBgImg();
			//update数据录入
			shopBgImg.setCode(shopBgImgDto.getCode());
			shopBgImg.setName(shopBgImgDto.getName());
			shopBgImg.setSpe(shopBgImgDto.getSpe());
			shopBgImg.setStatus(shopBgImgDto.getStatus());
			AssertUtils.notUpdateMoreThanOne(shopBgImgDao.updateByPrimaryKeySelective(shopBgImg));
			logger.debug("updateShopBgImg(ShopBgImgDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("店铺背景图信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_BG_IMG_UPDATE_ERROR,"店铺背景图信息更新信息错误！",e);
		}
	}

	

	@Override
	public ShopBgImgDto findShopBgImg(
			ShopBgImgDto shopBgImgDto) throws TsfaServiceException {
		logger.debug("findShopBgImg(FindShopBgImg findShopBgImg={}) - start", shopBgImgDto); //$NON-NLS-1$

		AssertUtils.notNull(shopBgImgDto);
		AssertUtils.notAllNull(shopBgImgDto.getCode(),"Code不能为空");
		try {
			ShopBgImg shopBgImg = shopBgImgDao.selectByPrimaryKey(shopBgImgDto.getCode());
			if(shopBgImg == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.SHOP_BG_IMG_NOT_EXIST_ERROR,"店铺背景图信息不存在");
			}
			ShopBgImgDto findShopBgImgReturn = new ShopBgImgDto();
			//find数据录入
			findShopBgImgReturn.setCode(shopBgImg.getCode());
			findShopBgImgReturn.setName(shopBgImg.getName());
			findShopBgImgReturn.setSpe(shopBgImg.getSpe());
			findShopBgImgReturn.setStatus(shopBgImg.getStatus());
			
			logger.debug("findShopBgImg(ShopBgImgDto) - end - return value={}", findShopBgImgReturn); //$NON-NLS-1$
			return findShopBgImgReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找店铺背景图信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_BG_IMG_FIND_ERROR,"查找店铺背景图信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ShopBgImgDto> findShopBgImgPage(
			FindShopBgImgPage findShopBgImgPage)
			throws TsfaServiceException {
		logger.debug("findShopBgImgPage(FindShopBgImgPage findShopBgImgPage={}) - start", findShopBgImgPage); //$NON-NLS-1$

		AssertUtils.notNull(findShopBgImgPage);
		List<ShopBgImgDto> returnList=null;
		int count = 0;
		try {
			returnList = shopBgImgDao.findShopBgImgPage(findShopBgImgPage);
			count = shopBgImgDao.findShopBgImgPageCount(findShopBgImgPage);
		}  catch (Exception e) {
			logger.error("店铺背景图信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_BG_IMG_FIND_PAGE_ERROR,"店铺背景图信息不存在错误.！",e);
		}
		Page<ShopBgImgDto> returnPage = new Page<ShopBgImgDto>(returnList, count, findShopBgImgPage);

		logger.debug("findShopBgImgPage(FindShopBgImgPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
