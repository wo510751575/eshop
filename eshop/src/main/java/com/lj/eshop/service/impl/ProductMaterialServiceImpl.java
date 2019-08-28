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
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IProductMaterialDao;
import com.lj.eshop.domain.ProductMaterial;
import com.lj.eshop.dto.FindProductMaterialPage;
import com.lj.eshop.dto.ProductMaterialDto;
import com.lj.eshop.service.IProductMaterialService;
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
 * CreateDate: 2017.12.14
 */
@Service
public class ProductMaterialServiceImpl implements IProductMaterialService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ProductMaterialServiceImpl.class);
	

	@Resource
	private IProductMaterialDao productMaterialDao;
	
	
	@Override
	public void addProductMaterial(
			ProductMaterialDto productMaterialDto) throws TsfaServiceException {
		logger.debug("addProductMaterial(AddProductMaterial addProductMaterial={}) - start", productMaterialDto); 

		AssertUtils.notNull(productMaterialDto);
		try {
			ProductMaterial productMaterial = new ProductMaterial();
			//add数据录入
			productMaterial.setCode(productMaterialDto.getCode());
			productMaterial.setAdvCode(productMaterialDto.getAdvCode());
			productMaterial.setProductCode(productMaterialDto.getProductCode());
			productMaterial.setStatus(productMaterialDto.getStatus());
			productMaterial.setImg(productMaterialDto.getImg());
			productMaterial.setOrderNo(productMaterialDto.getOrderNo());
			productMaterial.setRemark(productMaterialDto.getRemark());
			productMaterialDao.insertSelective(productMaterial);
			logger.debug("addProductMaterial(ProductMaterialDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增产品素材信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_MATERIAL_ADD_ERROR,"新增产品素材信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询产品素材信息
	 *
	 * @param findProductMaterialPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年12月14日
	 *
	 */
	public List<ProductMaterialDto>  findProductMaterials(FindProductMaterialPage findProductMaterialPage)throws TsfaServiceException{
		AssertUtils.notNull(findProductMaterialPage);
		List<ProductMaterialDto> returnList=null;
		try {
			returnList = productMaterialDao.findProductMaterials(findProductMaterialPage);
		} catch (Exception e) {
			logger.error("查找产品素材信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_MATERIAL_NOT_EXIST_ERROR,"产品素材信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateProductMaterial(
			ProductMaterialDto productMaterialDto)
			throws TsfaServiceException {
		logger.debug("updateProductMaterial(ProductMaterialDto productMaterialDto={}) - start", productMaterialDto); 

		AssertUtils.notNull(productMaterialDto);
		AssertUtils.notNullAndEmpty(productMaterialDto.getCode(),"Code不能为空");
		try {
			ProductMaterial productMaterial = new ProductMaterial();
			//update数据录入
			productMaterial.setCode(productMaterialDto.getCode());
			productMaterial.setAdvCode(productMaterialDto.getAdvCode());
			productMaterial.setProductCode(productMaterialDto.getProductCode());
			productMaterial.setStatus(productMaterialDto.getStatus());
			productMaterial.setImg(productMaterialDto.getImg());
			productMaterial.setOrderNo(productMaterialDto.getOrderNo());
			productMaterial.setRemark(productMaterialDto.getRemark());
			AssertUtils.notUpdateMoreThanOne(productMaterialDao.updateByPrimaryKeySelective(productMaterial));
			logger.debug("updateProductMaterial(ProductMaterialDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("产品素材信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_MATERIAL_UPDATE_ERROR,"产品素材信息更新信息错误！",e);
		}
	}

	

	@Override
	public ProductMaterialDto findProductMaterial(
			ProductMaterialDto productMaterialDto) throws TsfaServiceException {
		logger.debug("findProductMaterial(FindProductMaterial findProductMaterial={}) - start", productMaterialDto); 

		AssertUtils.notNull(productMaterialDto);
		AssertUtils.notAllNull(productMaterialDto.getCode(),"Code不能为空");
		try {
			ProductMaterial productMaterial = productMaterialDao.selectByPrimaryKey(productMaterialDto.getCode());
			if(productMaterial == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.PRODUCT_MATERIAL_NOT_EXIST_ERROR,"产品素材信息不存在");
			}
			ProductMaterialDto findProductMaterialReturn = new ProductMaterialDto();
			//find数据录入
			findProductMaterialReturn.setCode(productMaterial.getCode());
			findProductMaterialReturn.setAdvCode(productMaterial.getAdvCode());
			findProductMaterialReturn.setProductCode(productMaterial.getProductCode());
			findProductMaterialReturn.setStatus(productMaterial.getStatus());
			findProductMaterialReturn.setImg(productMaterial.getImg());
			findProductMaterialReturn.setOrderNo(productMaterial.getOrderNo());
			findProductMaterialReturn.setRemark(productMaterial.getRemark());
			
			logger.debug("findProductMaterial(ProductMaterialDto) - end - return value={}", findProductMaterialReturn); 
			return findProductMaterialReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找产品素材信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_MATERIAL_FIND_ERROR,"查找产品素材信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ProductMaterialDto> findProductMaterialPage(
			FindProductMaterialPage findProductMaterialPage)
			throws TsfaServiceException {
		logger.debug("findProductMaterialPage(FindProductMaterialPage findProductMaterialPage={}) - start", findProductMaterialPage); 

		AssertUtils.notNull(findProductMaterialPage);
		List<ProductMaterialDto> returnList=null;
		int count = 0;
		try {
			returnList = productMaterialDao.findProductMaterialPage(findProductMaterialPage);
			count = productMaterialDao.findProductMaterialPageCount(findProductMaterialPage);
		}  catch (Exception e) {
			logger.error("产品素材信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_MATERIAL_FIND_PAGE_ERROR,"产品素材信息不存在错误.！",e);
		}
		Page<ProductMaterialDto> returnPage = new Page<ProductMaterialDto>(returnList, count, findProductMaterialPage);

		logger.debug("findProductMaterialPage(FindProductMaterialPage) - end - return value={}", returnPage); 
		return  returnPage;
	}


	/**   
	 * <p>Title: updateByProductCode</p>   
	 * <p>Description: </p>   
	 * @param code
	 * @throws TsfaServiceException   
	 * @see com.lj.eshop.service.IProductMaterialService#updateByProductCode(java.lang.String)   
	 */
	@Override
	public void updateByProductCode(String code) throws TsfaServiceException {
		logger.debug("updateByProductCode(String code = {})- start",code);
		try {
			productMaterialDao.updateByProductCode(code);
		} catch (Exception e) {
			logger.error("通过产品code更新产品素材状态错误",e);
		}
	}


	/**   
	 * <p>Title: updateStatusOpon</p>   
	 * <p>Description: </p>   
	 * @param productCode
	 * @throws TsfaServiceException   
	 * @see com.lj.eshop.service.IProductMaterialService#updateStatusOpon(java.lang.String)   
	 */
	@Override
	public void updateStatusOpon(String productCode) throws TsfaServiceException {
		logger.debug("updateStatusOpon(String productCode = {})",productCode);
		try {
			productMaterialDao.updateStatusOpon(productCode);
		} catch (Exception e) {
			logger.error("更新产品素材状态为启用发生错误",e);
		}
	}


	


}
