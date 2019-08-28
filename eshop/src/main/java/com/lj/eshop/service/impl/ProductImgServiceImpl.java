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
import com.lj.eshop.dao.IProductImgDao;
import com.lj.eshop.domain.ProductImg;
import com.lj.eshop.dto.FindProductImgPage;
import com.lj.eshop.dto.ProductImgDto;
import com.lj.eshop.service.IProductImgService;
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
public class ProductImgServiceImpl implements IProductImgService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ProductImgServiceImpl.class);
	

	@Resource
	private IProductImgDao productImgDao;
	
	
	@Override
	public void addProductImg(
			ProductImgDto productImgDto) throws TsfaServiceException {
		logger.debug("addProductImg(AddProductImg addProductImg={}) - start", productImgDto); 

		AssertUtils.notNull(productImgDto);
		try {
			ProductImg productImg = new ProductImg();
			//add数据录入
			productImg.setCode(GUID.generateCode());
			productImg.setProductCode(productImgDto.getProductCode());
			productImg.setStatus(productImgDto.getStatus());
			productImg.setImg(productImgDto.getImg());
			productImg.setOrderNo(productImgDto.getOrderNo());
			productImgDao.insertSelective(productImg);
			logger.debug("addProductImg(ProductImgDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品图片信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_IMG_ADD_ERROR,"新增商品图片信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品图片信息
	 *
	 * @param findProductImgPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ProductImgDto>  findProductImgs(FindProductImgPage findProductImgPage)throws TsfaServiceException{
		AssertUtils.notNull(findProductImgPage);
		List<ProductImgDto> returnList=null;
		try {
			returnList = productImgDao.findProductImgs(findProductImgPage);
		} catch (Exception e) {
			logger.error("查找商品图片信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_IMG_NOT_EXIST_ERROR,"商品图片信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateProductImg(
			ProductImgDto productImgDto)
			throws TsfaServiceException {
		logger.debug("updateProductImg(ProductImgDto productImgDto={}) - start", productImgDto); //$NON-NLS-1$

		AssertUtils.notNull(productImgDto);
		AssertUtils.notNullAndEmpty(productImgDto.getCode(),"Code不能为空");
		try {
			ProductImg productImg = new ProductImg();
			//update数据录入
			productImg.setCode(productImgDto.getCode());
			productImg.setProductCode(productImgDto.getProductCode());
			productImg.setStatus(productImgDto.getStatus());
			productImg.setImg(productImgDto.getImg());
			productImg.setOrderNo(productImgDto.getOrderNo());
			AssertUtils.notUpdateMoreThanOne(productImgDao.updateByPrimaryKeySelective(productImg));
			logger.debug("updateProductImg(ProductImgDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品图片信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_IMG_UPDATE_ERROR,"商品图片信息更新信息错误！",e);
		}
	}

	

	@Override
	public ProductImgDto findProductImg(
			ProductImgDto productImgDto) throws TsfaServiceException {
		logger.debug("findProductImg(FindProductImg findProductImg={}) - start", productImgDto); //$NON-NLS-1$

		AssertUtils.notNull(productImgDto);
		AssertUtils.notAllNull(productImgDto.getCode(),"Code不能为空");
		try {
			ProductImg productImg = productImgDao.selectByPrimaryKey(productImgDto.getCode());
			if(productImg == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.PRODUCT_IMG_NOT_EXIST_ERROR,"商品图片信息不存在");
			}
			ProductImgDto findProductImgReturn = new ProductImgDto();
			//find数据录入
			findProductImgReturn.setCode(productImg.getCode());
			findProductImgReturn.setProductCode(productImg.getProductCode());
			findProductImgReturn.setStatus(productImg.getStatus());
			findProductImgReturn.setImg(productImg.getImg());
			findProductImgReturn.setOrderNo(productImg.getOrderNo());
			logger.debug("findProductImg(ProductImgDto) - end - return value={}", findProductImgReturn); //$NON-NLS-1$
			return findProductImgReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品图片信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_IMG_FIND_ERROR,"查找商品图片信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ProductImgDto> findProductImgPage(
			FindProductImgPage findProductImgPage)
			throws TsfaServiceException {
		logger.debug("findProductImgPage(FindProductImgPage findProductImgPage={}) - start", findProductImgPage); //$NON-NLS-1$

		AssertUtils.notNull(findProductImgPage);
		List<ProductImgDto> returnList=null;
		int count = 0;
		try {
			returnList = productImgDao.findProductImgPage(findProductImgPage);
			count = productImgDao.findProductImgPageCount(findProductImgPage);
		}  catch (Exception e) {
			logger.error("商品图片信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_IMG_FIND_PAGE_ERROR,"商品图片信息不存在错误.！",e);
		}
		Page<ProductImgDto> returnPage = new Page<ProductImgDto>(returnList, count, findProductImgPage);

		logger.debug("findProductImgPage(FindProductImgPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.eshop.service.IProductImgService#updateProductImgByProductCode(com.lj.eshop.dto.ProductImgDto)
	 */
	@Override
	public void updateProductImgByProductCode(ProductImgDto productImgDto)
			throws TsfaServiceException {
		logger.debug("updateProductImg(ProductImgDto productImgDto={}) - start", productImgDto); //$NON-NLS-1$

		AssertUtils.notNull(productImgDto);
		try {
			ProductImg productImg = new ProductImg();
			//update数据录入
			productImg.setCode(productImgDto.getCode());
			productImg.setProductCode(productImgDto.getProductCode());
			productImg.setStatus(productImgDto.getStatus());
			productImg.setImg(productImgDto.getImg());
			productImg.setOrderNo(productImgDto.getOrderNo());
			productImgDao.updateProductImgByProductCode(productImg);
			logger.debug("updateProductImg(ProductImgDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品图片信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_IMG_UPDATE_ERROR,"商品图片信息更新信息错误！",e);
		}
	} 


}
