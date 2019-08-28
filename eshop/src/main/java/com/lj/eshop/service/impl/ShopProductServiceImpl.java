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
import com.lj.eshop.dao.IShopProductDao;
import com.lj.eshop.domain.ShopProduct;
import com.lj.eshop.dto.FindShopProductPage;
import com.lj.eshop.dto.ShopProductDto;
import com.lj.eshop.service.IShopProductService;

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
 *         CreateDate: 2017-08-22
 */
@Service
public class ShopProductServiceImpl implements IShopProductService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ShopProductServiceImpl.class);

	@Resource
	private IShopProductDao shopProductDao;

	@Override
	public void addShopProduct(ShopProductDto shopProductDto) throws TsfaServiceException {
		logger.debug("addShopProduct(AddShopProduct addShopProduct={}) - start", shopProductDto);

		AssertUtils.notNull(shopProductDto);
		try {
			ShopProduct shopProduct = new ShopProduct();
			// add数据录入
			shopProduct.setCode(GUID.generateCode());
			shopProduct.setShopCode(shopProductDto.getShopCode());
			shopProduct.setProductCode(shopProductDto.getProductCode());
			shopProduct.setStatus(shopProductDto.getStatus());
			shopProduct.setCreateTime(new Date());
			shopProductDao.insertSelective(shopProduct);
			logger.debug("addShopProduct(ShopProductDto) - end - return");
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增店铺商品信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SHOP_PRODUCT_ADD_ERROR, "新增店铺商品信息错误！", e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：不分页查询店铺商品信息
	 *
	 * @param findShopProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ShopProductDto> findShopProducts(FindShopProductPage findShopProductPage) throws TsfaServiceException {
		AssertUtils.notNull(findShopProductPage);
		List<ShopProductDto> returnList = null;
		try {
			returnList = shopProductDao.findShopProducts(findShopProductPage);
		} catch (Exception e) {
			logger.error("查找店铺商品信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SHOP_PRODUCT_NOT_EXIST_ERROR, "店铺商品信息不存在");
		}
		return returnList;
	}

	@Override
	public void updateShopProduct(ShopProductDto shopProductDto) throws TsfaServiceException {
		logger.debug("updateShopProduct(ShopProductDto shopProductDto={}) - start", shopProductDto); //$NON-NLS-1$

		AssertUtils.notNull(shopProductDto);
		AssertUtils.notNullAndEmpty(shopProductDto.getCode(), "Code不能为空");
		try {
			ShopProduct shopProduct = new ShopProduct();
			// update数据录入
			shopProduct.setCode(shopProductDto.getCode());
			shopProduct.setShopCode(shopProductDto.getShopCode());
			shopProduct.setProductCode(shopProductDto.getProductCode());
			shopProduct.setStatus(shopProductDto.getStatus());
			shopProduct.setCreateTime(new Date());
			AssertUtils.notUpdateMoreThanOne(shopProductDao.updateByPrimaryKeySelective(shopProduct));
			logger.debug("updateShopProduct(ShopProductDto) - end - return"); //$NON-NLS-1$
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("店铺商品信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SHOP_PRODUCT_UPDATE_ERROR, "店铺商品信息更新信息错误！", e);
		}
	}

	@Override
	public ShopProductDto findShopProduct(ShopProductDto shopProductDto) throws TsfaServiceException {
		logger.debug("findShopProduct(FindShopProduct findShopProduct={}) - start", shopProductDto); //$NON-NLS-1$

		AssertUtils.notNull(shopProductDto);
		AssertUtils.notAllNull(shopProductDto.getCode(), "Code不能为空");
		try {
			ShopProduct shopProduct = shopProductDao.selectByPrimaryKey(shopProductDto.getCode());
			if (shopProduct == null) {
				return null;
				// throw new
				// TsfaServiceException(ErrorCode.SHOP_PRODUCT_NOT_EXIST_ERROR,"店铺商品信息不存在");
			}
			ShopProductDto findShopProductReturn = new ShopProductDto();
			// find数据录入
			findShopProductReturn.setCode(shopProduct.getCode());
			findShopProductReturn.setShopCode(shopProduct.getShopCode());
			findShopProductReturn.setProductCode(shopProduct.getProductCode());
			findShopProductReturn.setStatus(shopProduct.getStatus());
			findShopProductReturn.setCreateTime(shopProduct.getCreateTime());

			logger.debug("findShopProduct(ShopProductDto) - end - return value={}", findShopProductReturn); //$NON-NLS-1$
			return findShopProductReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找店铺商品信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SHOP_PRODUCT_FIND_ERROR, "查找店铺商品信息信息错误！", e);
		}

	}

	@Override
	public Page<ShopProductDto> findShopProductPage(FindShopProductPage findShopProductPage)
			throws TsfaServiceException {
		logger.debug("findShopProductPage(FindShopProductPage findShopProductPage={}) - start", findShopProductPage); //$NON-NLS-1$

		AssertUtils.notNull(findShopProductPage);
		List<ShopProductDto> returnList = null;
		int count = 0;
		try {
			returnList = shopProductDao.findShopProductPage(findShopProductPage);
			count = shopProductDao.findShopProductPageCount(findShopProductPage);
		} catch (Exception e) {
			logger.error("店铺商品信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.SHOP_PRODUCT_FIND_PAGE_ERROR, "店铺商品信息不存在错误.！", e);
		}
		Page<ShopProductDto> returnPage = new Page<ShopProductDto>(returnList, count, findShopProductPage);

		logger.debug("findShopProductPage(FindShopProductPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	@Override
	public Page<ShopProductDto> findIndexShopProductPage(FindShopProductPage findShopProductPage)
			throws TsfaServiceException {
		logger.debug("findShopProductIndexPage(FindShopProductPage findShopProductPage={}) - start", //$NON-NLS-1$
				findShopProductPage);

		AssertUtils.notNull(findShopProductPage);
		List<ShopProductDto> returnList = null;
		int count = 0;
		try {
			count = shopProductDao.findIndexProductPageCount(findShopProductPage);
			if (count > 0) {
				returnList = shopProductDao.findIndexProductPage(findShopProductPage);
			}

		} catch (Exception e) {
			logger.error("店铺商品信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.SHOP_PRODUCT_FIND_PAGE_ERROR, "店铺商品信息不存在错误.！", e);
		}
		Page<ShopProductDto> returnPage = new Page<ShopProductDto>(returnList, count, findShopProductPage);

		logger.debug("findShopProductIndexPage(FindShopProductPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	@Override
	public ShopProductDto findByShopCodeAndProCode(ShopProductDto param) throws TsfaServiceException {
		logger.debug("findByShopCodeAndProCode(ShopProductDto param={}) - start", param);

		AssertUtils.notNull(param);
		AssertUtils.notNullAndEmpty(param.getShopCode(), "店铺编号不能为空");
		AssertUtils.notNullAndEmpty(param.getProductCode(), "商品编号不能为空");
		List<ShopProductDto> returnList = null;
		try {
			FindShopProductPage findShopProductPage = new FindShopProductPage();
			findShopProductPage.setParam(param);
			returnList = shopProductDao.findShopProducts(findShopProductPage);
			if (returnList.size() > 0) {
				logger.debug("findByShopCodeAndProCode(ShopProductDto) - end - return value={}", returnList.get(0));
				return returnList.get(0);
			}
		} catch (Exception e) {
			logger.error("店铺商品信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.SHOP_PRODUCT_FIND_PAGE_ERROR, "店铺商品信息不存在错误.！", e);
		}
		return null;
	}

}
