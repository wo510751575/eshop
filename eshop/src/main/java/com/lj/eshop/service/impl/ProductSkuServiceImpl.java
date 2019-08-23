package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
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
import com.lj.eshop.dao.IProductDao;
import com.lj.eshop.dao.IProductSkuDao;
import com.lj.eshop.domain.Product;
import com.lj.eshop.domain.ProductSku;
import com.lj.eshop.dto.FindProductSkuPage;
import com.lj.eshop.dto.ProductSkuDto;
import com.lj.eshop.emus.IsDefault;
import com.lj.eshop.service.IProductSkuService;
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
public class ProductSkuServiceImpl implements IProductSkuService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ProductSkuServiceImpl.class);
	

	@Resource
	private IProductSkuDao productSkuDao;
	@Resource
	private IProductDao productDao;
	
	
	@Override
	public void addProductSku(
			ProductSkuDto productSkuDto) throws TsfaServiceException {
		logger.debug("addProductSku(AddProductSku addProductSku={}) - start", productSkuDto); 

		AssertUtils.notNull(productSkuDto);
		try {
			ProductSku productSku = new ProductSku();
			//add数据录入
			productSku.setCode(GUID.generateCode());
			productSku.setCnt(productSkuDto.getCnt());
			productSku.setProductCode(productSkuDto.getProductCode());
			productSku.setProductSpes(productSkuDto.getProductSpes());
			productSku.setSkuNo(productSkuDto.getSkuNo());
			productSku.setDelFlag(productSkuDto.getDelFlag());
			productSku.setCostPrice(productSkuDto.getCostPrice());
			productSku.setSalePrice(productSkuDto.getSalePrice());
			productSku.setOrgPrice(productSkuDto.getOrgPrice());
			productSku.setGapPrice(productSkuDto.getGapPrice());
			productSku.setPrice(productSkuDto.getPrice());
			productSku.setIsDefault(productSkuDto.getIsDefault());
			productSku.setSkuDesc(productSkuDto.getSkuDesc());
			productSku.setOrderNo(productSkuDto.getOrderNo());
			productSkuDao.insertSelective(productSku);
			logger.debug("addProductSku(ProductSkuDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品SKU信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SKU_ADD_ERROR,"新增商品SKU信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品SKU信息
	 *
	 * @param findProductSkuPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ProductSkuDto>  findProductSkus(FindProductSkuPage findProductSkuPage)throws TsfaServiceException{
		AssertUtils.notNull(findProductSkuPage);
		List<ProductSkuDto> returnList=null;
		try {
			returnList = productSkuDao.findProductSkus(findProductSkuPage);
		} catch (Exception e) {
			logger.error("查找商品SKU信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SKU_NOT_EXIST_ERROR,"商品SKU信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateProductSku(
			ProductSkuDto productSkuDto)
			throws TsfaServiceException {
		logger.debug("updateProductSku(ProductSkuDto productSkuDto={}) - start", productSkuDto); //$NON-NLS-1$

		AssertUtils.notNull(productSkuDto);
		AssertUtils.notNullAndEmpty(productSkuDto.getCode(),"Code不能为空");
		try {
			ProductSku productSku = new ProductSku();
			//update数据录入
			productSku.setCode(productSkuDto.getCode());
			productSku.setCnt(productSkuDto.getCnt());
			productSku.setProductCode(productSkuDto.getProductCode());
			productSku.setProductSpes(productSkuDto.getProductSpes());
			productSku.setSkuNo(productSkuDto.getSkuNo());
			productSku.setDelFlag(productSkuDto.getDelFlag());
			productSku.setCostPrice(productSkuDto.getCostPrice());
			productSku.setSalePrice(productSkuDto.getSalePrice());
			productSku.setOrgPrice(productSkuDto.getOrgPrice());
			productSku.setGapPrice(productSkuDto.getGapPrice());
			productSku.setPrice(productSkuDto.getPrice());
			productSku.setIsDefault(productSkuDto.getIsDefault());
			productSku.setSkuDesc(productSkuDto.getSkuDesc());
			productSku.setOrderNo(productSkuDto.getOrderNo());
			if(IsDefault.YES.getValue().equals(productSkuDto.getIsDefault())){//如果改了是否默认，则先重置所有的为非默认
				ProductSku u=new ProductSku();
				u.setIsDefault(IsDefault.NO.getValue());
				u.setProductCode(productSkuDto.getProductCode());
				productSkuDao.updateProductSkuByProductCode(u);
			}
			AssertUtils.notUpdateMoreThanOne(productSkuDao.updateByPrimaryKeySelective(productSku));
			
			if(productSkuDto.getCnt()!=null){//如果改了库存,在修改库存后重置产品的整库存
				Product u=new Product();
				u.setCode(productSkuDto.getProductCode());
				productDao.updateProdcutCnt(u);
			}
			logger.debug("updateProductSku(ProductSkuDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品SKU信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SKU_UPDATE_ERROR,"商品SKU信息更新信息错误！",e);
		}
	}

	

	@Override
	public ProductSkuDto findProductSku(ProductSkuDto productSkuDto) throws TsfaServiceException {
		logger.debug("findProductSku(FindProductSku findProductSku={}) - start", productSkuDto); //$NON-NLS-1$

		AssertUtils.notNull(productSkuDto);
		AssertUtils.notAllNull(productSkuDto.getCode(),"Code不能为空");
		try {
			ProductSku productSku = productSkuDao.selectByPrimaryKey(productSkuDto.getCode());
			if(productSku == null){
				throw new TsfaServiceException(ErrorCode.PRODUCT_SKU_NOT_EXIST_ERROR,"商品SKU信息不存在");
			}
			ProductSkuDto findProductSkuReturn = new ProductSkuDto();
			//find数据录入
			findProductSkuReturn.setCode(productSku.getCode());
			findProductSkuReturn.setCnt(productSku.getCnt());
			findProductSkuReturn.setProductCode(productSku.getProductCode());
			findProductSkuReturn.setProductSpes(productSku.getProductSpes());
			findProductSkuReturn.setSkuNo(productSku.getSkuNo());
			findProductSkuReturn.setDelFlag(productSku.getDelFlag());
			findProductSkuReturn.setCostPrice(productSku.getCostPrice());
			findProductSkuReturn.setSalePrice(productSku.getSalePrice());
			findProductSkuReturn.setOrgPrice(productSku.getOrgPrice());
			findProductSkuReturn.setGapPrice(productSku.getGapPrice());
			findProductSkuReturn.setPrice(productSku.getPrice());
			findProductSkuReturn.setIsDefault(productSku.getIsDefault());
			findProductSkuReturn.setSkuDesc(productSku.getSkuDesc());
			findProductSkuReturn.setOrderNo(productSku.getOrderNo());
			logger.debug("findProductSku(ProductSkuDto) - end - return value={}", findProductSkuReturn); //$NON-NLS-1$
			return findProductSkuReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品SKU信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SKU_FIND_ERROR,"查找商品SKU信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ProductSkuDto> findProductSkuPage(
			FindProductSkuPage findProductSkuPage)
			throws TsfaServiceException {
		logger.debug("findProductSkuPage(FindProductSkuPage findProductSkuPage={}) - start", findProductSkuPage); //$NON-NLS-1$

		AssertUtils.notNull(findProductSkuPage);
		List<ProductSkuDto> returnList=null;
		int count = 0;
		try {
			returnList = productSkuDao.findProductSkuPage(findProductSkuPage);
			count = productSkuDao.findProductSkuPageCount(findProductSkuPage);
		}  catch (Exception e) {
			logger.error("商品SKU信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SKU_FIND_PAGE_ERROR,"商品SKU信息不存在错误.！",e);
		}
		Page<ProductSkuDto> returnPage = new Page<ProductSkuDto>(returnList, count, findProductSkuPage);

		logger.debug("findProductSkuPage(FindProductSkuPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.eshop.service.IProductSkuService#updateProductSkuByProductCode(com.lj.eshop.dto.ProductSkuDto)
	 */
	@Override
	public void updateProductSkuByProductCode(ProductSkuDto productSkuDto)
			throws TsfaServiceException {
		logger.debug("updateProductFlag(ProductFlagDto productFlagDto={}) - start", productSkuDto); //$NON-NLS-1$

		AssertUtils.notNull(productSkuDto);
		AssertUtils.notNullAndEmpty(productSkuDto.getProductCode(),"productCode不能为空");
		try {
			ProductSku productSku = new ProductSku();
			//update数据录入
			productSku.setCode(productSkuDto.getCode());
			productSku.setCnt(productSkuDto.getCnt());
			productSku.setProductCode(productSkuDto.getProductCode());
			productSku.setProductSpes(productSkuDto.getProductSpes());
			productSku.setSkuNo(productSkuDto.getSkuNo());
			productSku.setDelFlag(productSkuDto.getDelFlag());
			productSku.setCostPrice(productSkuDto.getCostPrice());
			productSku.setSalePrice(productSkuDto.getSalePrice());
			productSku.setOrgPrice(productSkuDto.getOrgPrice());
			productSku.setGapPrice(productSkuDto.getGapPrice());
			productSku.setPrice(productSkuDto.getPrice());
			productSku.setIsDefault(productSkuDto.getIsDefault());
			productSku.setSkuDesc(productSkuDto.getSkuDesc());
			productSku.setOrderNo(productSkuDto.getOrderNo());
			productSkuDao.updateProductSkuByProductCode(productSku);
			logger.debug("deleteByProductCode(ProductFlagDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品标记关联信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_FLAG_DELETE_ERROR,"商品标记关联信息更新信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.eshop.service.IProductSkuService#findMinProductSkus(com.lj.eshop.dto.FindProductSkuPage)
	 */
	@Override
	public List<ProductSkuDto> findMinProductSkus(
			FindProductSkuPage findProductSkuPage) throws TsfaServiceException {
		AssertUtils.notNull(findProductSkuPage);
		List<ProductSkuDto> returnList=null;
		try {
			returnList = productSkuDao.findMinProductSkus(findProductSkuPage);
		} catch (Exception e) {
			logger.error("查找商品SKU信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SKU_NOT_EXIST_ERROR,"商品SKU信息不存在");
		}
		return returnList;
	} 


}
