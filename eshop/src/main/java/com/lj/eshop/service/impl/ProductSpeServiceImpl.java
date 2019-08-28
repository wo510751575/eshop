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
import com.lj.eshop.dao.IProductSpeDao;
import com.lj.eshop.domain.ProductSpe;
import com.lj.eshop.dto.FindProductSpePage;
import com.lj.eshop.dto.ProductSpeDto;
import com.lj.eshop.service.IProductSpeService;
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
public class ProductSpeServiceImpl implements IProductSpeService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ProductSpeServiceImpl.class);
	

	@Resource
	private IProductSpeDao productSpeDao;
	
	
	@Override
	public ProductSpeDto addProductSpe(
			ProductSpeDto productSpeDto) throws TsfaServiceException {
		logger.debug("addProductSpe(AddProductSpe addProductSpe={}) - start", productSpeDto); 

		AssertUtils.notNull(productSpeDto);
		try {
			ProductSpe productSpe = new ProductSpe();
			//add数据录入
			productSpe.setCode(GUID.generateCode());
			productSpe.setProductCode(productSpeDto.getProductCode());
			productSpe.setRuleDetail(productSpeDto.getRuleDetail());
			productSpe.setRuleCode(productSpeDto.getRuleCode());
			productSpe.setSalePrice(productSpeDto.getSalePrice());
			productSpe.setIsDefault(productSpeDto.getIsDefault());
			productSpe.setStoreCnt(productSpeDto.getStoreCnt());
			productSpe.setRemarks(productSpeDto.getRemarks());
			productSpe.setOrderNo(productSpeDto.getOrderNo());
			productSpeDao.insertSelective(productSpe);
			productSpeDto.setCode(productSpe.getCode());
			logger.debug("addProductSpe(ProductSpeDto) - end - return"); 
			return productSpeDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品规格值信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SPE_ADD_ERROR,"新增商品规格值信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品规格值信息
	 *
	 * @param findProductSpePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ProductSpeDto>  findProductSpes(FindProductSpePage findProductSpePage)throws TsfaServiceException{
		AssertUtils.notNull(findProductSpePage);
		List<ProductSpeDto> returnList=null;
		try {
			returnList = productSpeDao.findProductSpes(findProductSpePage);
		} catch (Exception e) {
			logger.error("查找商品规格值信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SPE_NOT_EXIST_ERROR,"商品规格值信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateProductSpe(
			ProductSpeDto productSpeDto)
			throws TsfaServiceException {
		logger.debug("updateProductSpe(ProductSpeDto productSpeDto={}) - start", productSpeDto); //$NON-NLS-1$

		AssertUtils.notNull(productSpeDto);
		AssertUtils.notNullAndEmpty(productSpeDto.getCode(),"Code不能为空");
		try {
			ProductSpe productSpe = new ProductSpe();
			//update数据录入
			productSpe.setCode(productSpeDto.getCode());
			productSpe.setProductCode(productSpeDto.getProductCode());
			productSpe.setRuleDetail(productSpeDto.getRuleDetail());
			productSpe.setRuleCode(productSpeDto.getRuleCode());
			productSpe.setSalePrice(productSpeDto.getSalePrice());
			productSpe.setIsDefault(productSpeDto.getIsDefault());
			productSpe.setStoreCnt(productSpeDto.getStoreCnt());
			productSpe.setRemarks(productSpeDto.getRemarks());
			productSpe.setOrderNo(productSpeDto.getOrderNo());
			AssertUtils.notUpdateMoreThanOne(productSpeDao.updateByPrimaryKeySelective(productSpe));
			logger.debug("updateProductSpe(ProductSpeDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品规格值信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SPE_UPDATE_ERROR,"商品规格值信息更新信息错误！",e);
		}
	}

	

	@Override
	public ProductSpeDto findProductSpe(
			ProductSpeDto productSpeDto) throws TsfaServiceException {
		logger.debug("findProductSpe(FindProductSpe findProductSpe={}) - start", productSpeDto); //$NON-NLS-1$

		AssertUtils.notNull(productSpeDto);
		AssertUtils.notAllNull(productSpeDto.getCode(),"Code不能为空");
		try {
			ProductSpe productSpe = productSpeDao.selectByPrimaryKey(productSpeDto.getCode());
			if(productSpe == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.PRODUCT_SPE_NOT_EXIST_ERROR,"商品规格值信息不存在");
			}
			ProductSpeDto findProductSpeReturn = new ProductSpeDto();
			//find数据录入
			findProductSpeReturn.setCode(productSpe.getCode());
			findProductSpeReturn.setProductCode(productSpe.getProductCode());
			findProductSpeReturn.setRuleDetail(productSpe.getRuleDetail());
			findProductSpeReturn.setRuleCode(productSpe.getRuleCode());
			findProductSpeReturn.setSalePrice(productSpe.getSalePrice());
			findProductSpeReturn.setIsDefault(productSpe.getIsDefault());
			findProductSpeReturn.setStoreCnt(productSpe.getStoreCnt());
			findProductSpeReturn.setRemarks(productSpe.getRemarks());
			findProductSpeReturn.setOrderNo(productSpe.getOrderNo());
			
			logger.debug("findProductSpe(ProductSpeDto) - end - return value={}", findProductSpeReturn); //$NON-NLS-1$
			return findProductSpeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品规格值信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SPE_FIND_ERROR,"查找商品规格值信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ProductSpeDto> findProductSpePage(
			FindProductSpePage findProductSpePage)
			throws TsfaServiceException {
		logger.debug("findProductSpePage(FindProductSpePage findProductSpePage={}) - start", findProductSpePage); //$NON-NLS-1$

		AssertUtils.notNull(findProductSpePage);
		List<ProductSpeDto> returnList=null;
		int count = 0;
		try {
			returnList = productSpeDao.findProductSpePage(findProductSpePage);
			count = productSpeDao.findProductSpePageCount(findProductSpePage);
		}  catch (Exception e) {
			logger.error("商品规格值信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_SPE_FIND_PAGE_ERROR,"商品规格值信息不存在错误.！",e);
		}
		Page<ProductSpeDto> returnPage = new Page<ProductSpeDto>(returnList, count, findProductSpePage);

		logger.debug("findProductSpePage(FindProductSpePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
