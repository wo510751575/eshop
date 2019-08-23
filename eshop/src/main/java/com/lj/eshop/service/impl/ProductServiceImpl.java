package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
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
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.FindProductPage;
import com.lj.eshop.dto.UpdateProductCntDto;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IProductDao;
import com.lj.eshop.domain.Product;
import com.lj.eshop.service.IProductService;
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
public class ProductServiceImpl implements IProductService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	

	@Resource
	private IProductDao productDao;
	
	
	@Override
	public ProductDto addProduct(
			ProductDto productDto) throws TsfaServiceException {
		logger.debug("addProduct(AddProduct addProduct={}) - start", productDto); 

		AssertUtils.notNull(productDto);
		try {
			Product product = new Product();
			//add数据录入
			product.setCode(GUID.generateCode());
			product.setSupplyCode(productDto.getSupplyCode());
			product.setSupplyName(productDto.getSupplyName());
			product.setName(productDto.getName());
			product.setCatalogTypeCode(productDto.getCatalogTypeCode());
			product.setOrgPrice(productDto.getOrgPrice());
			product.setSalePrice(productDto.getSalePrice());
			product.setGapPrice(productDto.getGapPrice());
			product.setCnt(productDto.getCnt());
			product.setSaleCnt(productDto.getSaleCnt());
			product.setRemarks(productDto.getRemarks());
			product.setUnit(productDto.getUnit());
			product.setStatus(productDto.getStatus());
			product.setPackageInfo(productDto.getPackageInfo());
			product.setExpressFee(productDto.getExpressFee());
			product.setTotalScore(productDto.getTotalScore());
			product.setSpeImg(productDto.getSpeImg());
			product.setViewCnt(productDto.getViewCnt());
			product.setEvlCnt(productDto.getEvlCnt());
			product.setShareCnt(productDto.getShareCnt());
			product.setSaleShopCnt(productDto.getSaleShopCnt());
			product.setMerchantCode(productDto.getMerchantCode());
			product.setCollectFlag(productDto.getCollectFlag());
			product.setReturnFlag(productDto.getReturnFlag());
			product.setPackFlag(productDto.getPackFlag());
			product.setCreateTime(new Date());
			product.setUpdateTime(new Date());
			product.setProductKey(productDto.getProductKey());
			product.setProductIcon(productDto.getProductIcon());
			product.setProductOrder(productDto.getProductOrder());
			product.setProductDesc(productDto.getProductDesc());
			productDao.insertSelective(product);
			//消费端要使用商品ID
			productDto.setCode(product.getCode());
			logger.debug("addProduct(ProductDto) - end - return");
			return productDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_ADD_ERROR,"新增商品信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品信息
	 *
	 * @param findProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ProductDto>  findProducts(FindProductPage findProductPage)throws TsfaServiceException{
		AssertUtils.notNull(findProductPage);
		List<ProductDto> returnList=null;
		try {
			returnList = productDao.findProducts(findProductPage);
		} catch (Exception e) {
			logger.error("查找商品信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_NOT_EXIST_ERROR,"商品信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateProduct(
			ProductDto productDto)
			throws TsfaServiceException {
		logger.debug("updateProduct(ProductDto productDto={}) - start", productDto); //$NON-NLS-1$

		AssertUtils.notNull(productDto);
		AssertUtils.notNullAndEmpty(productDto.getCode(),"Code不能为空");
		try {
			Product product = new Product();
			//update数据录入
			product.setCode(productDto.getCode());
			product.setSupplyCode(productDto.getSupplyCode());
			product.setSupplyName(productDto.getSupplyName());
			product.setName(productDto.getName());
			product.setCatalogTypeCode(productDto.getCatalogTypeCode());
			product.setOrgPrice(productDto.getOrgPrice());
			product.setSalePrice(productDto.getSalePrice());
			product.setGapPrice(productDto.getGapPrice());
			product.setCnt(productDto.getCnt());
			product.setSaleCnt(productDto.getSaleCnt());
			product.setRemarks(productDto.getRemarks());
			product.setUnit(productDto.getUnit());
			product.setStatus(productDto.getStatus());
			product.setPackageInfo(productDto.getPackageInfo());
			product.setExpressFee(productDto.getExpressFee());
			product.setTotalScore(productDto.getTotalScore());
			product.setSpeImg(productDto.getSpeImg());
			product.setViewCnt(productDto.getViewCnt());
			product.setEvlCnt(productDto.getEvlCnt());
			product.setShareCnt(productDto.getShareCnt());
			product.setSaleShopCnt(productDto.getSaleShopCnt());
			product.setMerchantCode(productDto.getMerchantCode());
			product.setCollectFlag(productDto.getCollectFlag());
			product.setReturnFlag(productDto.getReturnFlag());
			product.setPackFlag(productDto.getPackFlag());
			product.setCreateTime(productDto.getCreateTime());
			product.setUpdateTime(new Date());
			product.setProductKey(productDto.getProductKey());
			product.setProductIcon(productDto.getProductIcon());
			product.setProductOrder(productDto.getProductOrder());
			product.setProductDesc(productDto.getProductDesc());
			AssertUtils.notUpdateMoreThanOne(productDao.updateByPrimaryKeySelective(product));
			logger.debug("updateProduct(ProductDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_UPDATE_ERROR,"商品信息更新信息错误！",e);
		}
	}

	

	@Override
	public ProductDto findProduct(
			ProductDto productDto) throws TsfaServiceException {
		logger.debug("findProduct(FindProduct findProduct={}) - start", productDto); //$NON-NLS-1$

		AssertUtils.notNull(productDto);
		AssertUtils.notAllNull(productDto.getCode(),"Code不能为空");
		try {
			Product product = productDao.selectByPrimaryKey(productDto.getCode());
			if(product == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.PRODUCT_NOT_EXIST_ERROR,"商品信息不存在");
			}
			ProductDto findProductReturn = new ProductDto();
			//find数据录入
			findProductReturn.setCode(product.getCode());
			findProductReturn.setSupplyCode(product.getSupplyCode());
			findProductReturn.setSupplyName(product.getSupplyName());
			findProductReturn.setName(product.getName());
			findProductReturn.setCatalogTypeCode(product.getCatalogTypeCode());
			findProductReturn.setOrgPrice(product.getOrgPrice());
			findProductReturn.setSalePrice(product.getSalePrice());
			findProductReturn.setGapPrice(product.getGapPrice());
			findProductReturn.setCnt(product.getCnt());
			findProductReturn.setSaleCnt(product.getSaleCnt());
			findProductReturn.setRemarks(product.getRemarks());
			findProductReturn.setUnit(product.getUnit());
			findProductReturn.setStatus(product.getStatus());
			findProductReturn.setPackageInfo(product.getPackageInfo());
			findProductReturn.setExpressFee(product.getExpressFee());
			findProductReturn.setTotalScore(product.getTotalScore());
			findProductReturn.setSpeImg(product.getSpeImg());
			findProductReturn.setViewCnt(product.getViewCnt());
			findProductReturn.setEvlCnt(product.getEvlCnt());
			findProductReturn.setShareCnt(product.getShareCnt());
			findProductReturn.setSaleShopCnt(product.getSaleShopCnt());
			findProductReturn.setMerchantCode(product.getMerchantCode());
			findProductReturn.setCollectFlag(product.getCollectFlag());
			findProductReturn.setReturnFlag(product.getReturnFlag());
			findProductReturn.setPackFlag(product.getPackFlag());
			findProductReturn.setCreateTime(product.getCreateTime());
			findProductReturn.setUpdateTime(product.getUpdateTime());
			findProductReturn.setProductKey(product.getProductKey());
			findProductReturn.setProductIcon(product.getProductIcon());
			findProductReturn.setProductOrder(product.getProductOrder());
			findProductReturn.setProductDesc(product.getProductDesc());
			
			logger.debug("findProduct(ProductDto) - end - return value={}", findProductReturn); //$NON-NLS-1$
			return findProductReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_FIND_ERROR,"查找商品信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ProductDto> findProductPage(
			FindProductPage findProductPage)
			throws TsfaServiceException {
		logger.debug("findProductPage(FindProductPage findProductPage={}) - start", findProductPage); //$NON-NLS-1$

		AssertUtils.notNull(findProductPage);
		List<ProductDto> returnList=null;
		int count = 0;
		try {
			returnList = productDao.findProductPage(findProductPage);
			count = productDao.findProductPageCount(findProductPage);
		}  catch (Exception e) {
			logger.error("商品信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_FIND_PAGE_ERROR,"商品信息不存在错误.！",e);
		}
		Page<ProductDto> returnPage = new Page<ProductDto>(returnList, count, findProductPage);

		logger.debug("findProductPage(FindProductPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.eshop.service.IProductService#findIndexProductPage(com.lj.eshop.dto.FindProductPage)
	 */
	@Override
	public Page<ProductDto> findIndexProductPage(FindProductPage findProductPage)
			throws TsfaServiceException {
		logger.debug("findProductPage(FindProductPage findIndexProductPage={}) - start", findProductPage); //$NON-NLS-1$

		AssertUtils.notNull(findProductPage);
		List<ProductDto> returnList=null;
		int count = 0;
		try {
			returnList = productDao.findIndexProductPage(findProductPage);
			count = productDao.findIndexProductPageCount(findProductPage);
		}  catch (Exception e) {
			logger.error("商品信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_FIND_PAGE_ERROR,"商品信息不存在错误.！",e);
		}
		Page<ProductDto> returnPage = new Page<ProductDto>(returnList, count, findProductPage);

		logger.debug("findProductPage(findIndexProductPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.eshop.service.IProductService#updateProductCntByType(com.lj.eshop.dto.UpdateProductCntDto)
	 */
	@Override
	public int updateProductCntByType(UpdateProductCntDto updateProductCntDto)
			throws TsfaServiceException {
		logger.debug("updateProductCntByType(UpdateProductCntDto updateProductCntDto={}) - start", updateProductCntDto); //$NON-NLS-1$

		AssertUtils.notNull(updateProductCntDto);
		AssertUtils.notNullAndEmpty(updateProductCntDto.getCode(),"Code不能为空");
		AssertUtils.notNullAndEmpty(updateProductCntDto.getType(),"Type不能为空");
		try {
			 
			int i= productDao.updateProductCntByType(updateProductCntDto);
			logger.debug("updateProductCntByType(UpdateProductCntDto) - end - return"); //$NON-NLS-1$
			return i;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_UPDATE_ERROR,"商品信息更新信息错误！",e);
		}
	}

}
