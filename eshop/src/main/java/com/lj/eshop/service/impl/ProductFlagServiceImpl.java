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
import com.lj.eshop.dao.IProductFlagDao;
import com.lj.eshop.domain.ProductFlag;
import com.lj.eshop.dto.FindProductFlagPage;
import com.lj.eshop.dto.ProductFlagDto;
import com.lj.eshop.service.IProductFlagService;
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
public class ProductFlagServiceImpl implements IProductFlagService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ProductFlagServiceImpl.class);
	

	@Resource
	private IProductFlagDao productFlagDao;
	
	
	@Override
	public void addProductFlag(
			ProductFlagDto productFlagDto) throws TsfaServiceException {
		logger.debug("addProductFlag(AddProductFlag addProductFlag={}) - start", productFlagDto); 

		AssertUtils.notNull(productFlagDto);
		try {
			ProductFlag productFlag = new ProductFlag();
			//add数据录入
			productFlag.setCode(GUID.generateCode());
			productFlag.setProductCode(productFlagDto.getProductCode());
			productFlag.setFlagCode(productFlagDto.getFlagCode());
			productFlagDao.insertSelective(productFlag);
			logger.debug("addProductFlag(ProductFlagDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品标记关联信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_FLAG_ADD_ERROR,"新增商品标记关联信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品标记关联信息
	 *
	 * @param findProductFlagPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ProductFlagDto>  findProductFlags(FindProductFlagPage findProductFlagPage)throws TsfaServiceException{
		AssertUtils.notNull(findProductFlagPage);
		List<ProductFlagDto> returnList=null;
		try {
			returnList = productFlagDao.findProductFlags(findProductFlagPage);
		} catch (Exception e) {
			logger.error("查找商品标记关联信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_FLAG_NOT_EXIST_ERROR,"商品标记关联信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateProductFlag(
			ProductFlagDto productFlagDto)
			throws TsfaServiceException {
		logger.debug("updateProductFlag(ProductFlagDto productFlagDto={}) - start", productFlagDto); //$NON-NLS-1$

		AssertUtils.notNull(productFlagDto);
		AssertUtils.notNullAndEmpty(productFlagDto.getCode(),"Code不能为空");
		try {
			ProductFlag productFlag = new ProductFlag();
			//update数据录入
			productFlag.setCode(productFlagDto.getCode());
			productFlag.setProductCode(productFlagDto.getProductCode());
			productFlag.setFlagCode(productFlagDto.getFlagCode());
			AssertUtils.notUpdateMoreThanOne(productFlagDao.updateByPrimaryKeySelective(productFlag));
			logger.debug("updateProductFlag(ProductFlagDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品标记关联信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_FLAG_UPDATE_ERROR,"商品标记关联信息更新信息错误！",e);
		}
	}

	

	@Override
	public ProductFlagDto findProductFlag(
			ProductFlagDto productFlagDto) throws TsfaServiceException {
		logger.debug("findProductFlag(FindProductFlag findProductFlag={}) - start", productFlagDto); //$NON-NLS-1$

		AssertUtils.notNull(productFlagDto);
		AssertUtils.notAllNull(productFlagDto.getCode(),"Code不能为空");
		try {
			ProductFlag productFlag = productFlagDao.selectByPrimaryKey(productFlagDto.getCode());
			if(productFlag == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.PRODUCT_FLAG_NOT_EXIST_ERROR,"商品标记关联信息不存在");
			}
			ProductFlagDto findProductFlagReturn = new ProductFlagDto();
			//find数据录入
			findProductFlagReturn.setCode(productFlag.getCode());
			findProductFlagReturn.setProductCode(productFlag.getProductCode());
			findProductFlagReturn.setFlagCode(productFlag.getFlagCode());
			
			logger.debug("findProductFlag(ProductFlagDto) - end - return value={}", findProductFlagReturn); //$NON-NLS-1$
			return findProductFlagReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品标记关联信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_FLAG_FIND_ERROR,"查找商品标记关联信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ProductFlagDto> findProductFlagPage(
			FindProductFlagPage findProductFlagPage)
			throws TsfaServiceException {
		logger.debug("findProductFlagPage(FindProductFlagPage findProductFlagPage={}) - start", findProductFlagPage); //$NON-NLS-1$

		AssertUtils.notNull(findProductFlagPage);
		List<ProductFlagDto> returnList=null;
		int count = 0;
		try {
			returnList = productFlagDao.findProductFlagPage(findProductFlagPage);
			count = productFlagDao.findProductFlagPageCount(findProductFlagPage);
		}  catch (Exception e) {
			logger.error("商品标记关联信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_FLAG_FIND_PAGE_ERROR,"商品标记关联信息不存在错误.！",e);
		}
		Page<ProductFlagDto> returnPage = new Page<ProductFlagDto>(returnList, count, findProductFlagPage);

		logger.debug("findProductFlagPage(FindProductFlagPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.eshop.service.IProductFlagService#deleteByProductCode(com.lj.eshop.dto.ProductFlagDto)
	 */
	@Override
	public int deleteByProductCode(ProductFlagDto productFlagDto) {
		logger.debug("updateProductFlag(ProductFlagDto productFlagDto={}) - start", productFlagDto); //$NON-NLS-1$

		AssertUtils.notNull(productFlagDto);
		AssertUtils.notNullAndEmpty(productFlagDto.getProductCode(),"productCode不能为空");
		try {
			ProductFlag productFlag = new ProductFlag();
			//update数据录入
			productFlag.setCode(productFlagDto.getCode());
			productFlag.setProductCode(productFlagDto.getProductCode());
			productFlag.setFlagCode(productFlagDto.getFlagCode());
			int i= productFlagDao.deleteByProductCode(productFlag);
			logger.debug("deleteByProductCode(ProductFlagDto) - end - return"); //$NON-NLS-1$
			return i;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品标记关联信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_FLAG_DELETE_ERROR,"商品标记关联信息更新信息错误！",e);
		}
	} 
	
	


}
