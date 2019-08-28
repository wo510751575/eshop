package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2018-2021  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
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
import com.lj.eshop.dao.IProductRankPriceDao;
import com.lj.eshop.domain.ProductRankPrice;
import com.lj.eshop.dto.FindProductRankPricePage;
import com.lj.eshop.dto.ProductRankPriceDto;
import com.lj.eshop.service.IProductRankPriceService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 段志鹏
 * 
 * 
 *         CreateDate: 2017.12.14
 */
@Service
public class ProductRankPriceServiceImpl implements IProductRankPriceService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ProductRankPriceServiceImpl.class);

	@Resource
	private IProductRankPriceDao productRankPriceDao;

	@Override
	public void addProductRankPrice(ProductRankPriceDto productRankPriceDto) throws TsfaServiceException {
		logger.debug("addProductRankPrice(AddProductRankPrice addProductRankPrice={}) - start", productRankPriceDto);

		AssertUtils.notNull(productRankPriceDto);
		try {
			ProductRankPrice productRankPrice = new ProductRankPrice();
			// add数据录入
			productRankPrice.setCode(GUID.generateCode());
			productRankPrice.setProductCode(productRankPriceDto.getProductCode());
			productRankPrice.setRankCode(productRankPriceDto.getRankCode());
			productRankPrice.setSkuCode(productRankPriceDto.getSkuCode());
			productRankPrice.setRankPrice(productRankPriceDto.getRankPrice());
			productRankPriceDao.insertSelective(productRankPrice);
			logger.debug("addProductRankPrice(ProductRankPriceDto) - end - return");
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增商品特权价格信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_RANK_PRICE_ADD_ERROR, "新增商品特权价格信息错误！", e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：不分页查询商品特权价格信息
	 *
	 * @param findProductRankPricePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年12月14日
	 *
	 */
	public List<ProductRankPriceDto> findProductRankPrices(FindProductRankPricePage findProductRankPricePage)
			throws TsfaServiceException {
		AssertUtils.notNull(findProductRankPricePage);
		List<ProductRankPriceDto> returnList = null;
		try {
			returnList = productRankPriceDao.findProductRankPrices(findProductRankPricePage);
		} catch (Exception e) {
			logger.error("查找商品特权价格信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_RANK_PRICE_NOT_EXIST_ERROR, "商品特权价格信息不存在");
		}
		return returnList;
	}

	@Override
	public void updateProductRankPrice(ProductRankPriceDto productRankPriceDto) throws TsfaServiceException {
		logger.debug("updateProductRankPrice(ProductRankPriceDto productRankPriceDto={}) - start", productRankPriceDto);

		AssertUtils.notNull(productRankPriceDto);
		AssertUtils.notNullAndEmpty(productRankPriceDto.getCode(), "Code不能为空");
		try {
			ProductRankPrice productRankPrice = new ProductRankPrice();
			// update数据录入
			productRankPrice.setCode(productRankPriceDto.getCode());
			productRankPrice.setProductCode(productRankPriceDto.getProductCode());
			productRankPrice.setRankCode(productRankPriceDto.getRankCode());
			productRankPrice.setSkuCode(productRankPriceDto.getSkuCode());
			productRankPrice.setRankPrice(productRankPriceDto.getRankPrice());
			AssertUtils.notUpdateMoreThanOne(productRankPriceDao.updateByPrimaryKeySelective(productRankPrice));
			logger.debug("updateProductRankPrice(ProductRankPriceDto) - end - return");
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("商品特权价格信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_RANK_PRICE_UPDATE_ERROR, "商品特权价格信息更新信息错误！", e);
		}
	}

	@Override
	public ProductRankPriceDto findProductRankPrice(ProductRankPriceDto productRankPriceDto)
			throws TsfaServiceException {
		logger.debug("findProductRankPrice(FindProductRankPrice findProductRankPrice={}) - start", productRankPriceDto);

		AssertUtils.notNull(productRankPriceDto);
		AssertUtils.notAllNull(productRankPriceDto.getCode(), "Code不能为空");
		try {
			ProductRankPrice productRankPrice = productRankPriceDao.selectByPrimaryKey(productRankPriceDto.getCode());
			if (productRankPrice == null) {
				return null;
				// throw new
				// TsfaServiceException(ErrorCode.PRODUCT_RANK_PRICE_NOT_EXIST_ERROR,"商品特权价格信息不存在");
			}
			ProductRankPriceDto findProductRankPriceReturn = new ProductRankPriceDto();
			// find数据录入
			findProductRankPriceReturn.setCode(productRankPrice.getCode());
			findProductRankPriceReturn.setProductCode(productRankPrice.getProductCode());
			findProductRankPriceReturn.setRankCode(productRankPrice.getRankCode());
			findProductRankPriceReturn.setSkuCode(productRankPrice.getSkuCode());
			findProductRankPriceReturn.setRankPrice(productRankPrice.getRankPrice());

			logger.debug("findProductRankPrice(ProductRankPriceDto) - end - return value={}",
					findProductRankPriceReturn);
			return findProductRankPriceReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品特权价格信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_RANK_PRICE_FIND_ERROR, "查找商品特权价格信息信息错误！", e);
		}

	}

	@Override
	public Page<ProductRankPriceDto> findProductRankPricePage(FindProductRankPricePage findProductRankPricePage)
			throws TsfaServiceException {
		logger.debug("findProductRankPricePage(FindProductRankPricePage findProductRankPricePage={}) - start",
				findProductRankPricePage);

		AssertUtils.notNull(findProductRankPricePage);
		List<ProductRankPriceDto> returnList = null;
		int count = 0;
		try {
			count = productRankPriceDao.findProductRankPricePageCount(findProductRankPricePage);
			if (count > 0) {
				returnList = productRankPriceDao.findProductRankPricePage(findProductRankPricePage);
			}
		} catch (Exception e) {
			logger.error("商品特权价格信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_RANK_PRICE_FIND_PAGE_ERROR, "商品特权价格信息不存在错误.！", e);
		}
		Page<ProductRankPriceDto> returnPage = new Page<ProductRankPriceDto>(returnList, count,
				findProductRankPricePage);

		logger.debug("findProductRankPricePage(FindProductRankPricePage) - end - return value={}", returnPage);
		return returnPage;
	}

}
