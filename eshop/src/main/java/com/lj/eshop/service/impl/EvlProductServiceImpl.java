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
import com.lj.eshop.dao.IEvlProductDao;
import com.lj.eshop.domain.EvlProduct;
import com.lj.eshop.dto.EvlProductDto;
import com.lj.eshop.dto.FindEvlProductPage;
import com.lj.eshop.service.IEvlProductService;
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
public class EvlProductServiceImpl implements IEvlProductService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(EvlProductServiceImpl.class);
	

	@Resource
	private IEvlProductDao evlProductDao;
	
	
	@Override
	public void addEvlProduct(
			EvlProductDto evlProductDto) throws TsfaServiceException {
		logger.debug("addEvlProduct(AddEvlProduct addEvlProduct={}) - start", evlProductDto); 

		AssertUtils.notNull(evlProductDto);
		try {
			EvlProduct evlProduct = new EvlProduct();
			//add数据录入
			evlProduct.setCode(GUID.generateCode());
			evlProduct.setEvlInfo(evlProductDto.getEvlInfo());
			evlProduct.setEvlGrade(evlProductDto.getEvlGrade());
			evlProduct.setEvlMbrCode(evlProductDto.getEvlMbrCode());
			evlProduct.setEvlMbrName(evlProductDto.getEvlMbrName());
			evlProduct.setEvlMbrImg(evlProductDto.getEvlMbrImg());
			evlProduct.setCreateTime(new Date());
			evlProduct.setProductCode(evlProductDto.getProductCode());
			evlProduct.setProductName(evlProductDto.getProductName());
			evlProduct.setProductSkuCode(evlProductDto.getProductSkuCode());
			evlProduct.setGoodCnt(evlProductDto.getGoodCnt());
			evlProduct.setImgs(evlProductDto.getImgs());
			evlProductDao.insertSelective(evlProduct);
			logger.debug("addEvlProduct(EvlProductDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品评价信息错误！",e);
			throw new TsfaServiceException(ErrorCode.EVL_PRODUCT_ADD_ERROR,"新增商品评价信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品评价信息
	 *
	 * @param findEvlProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<EvlProductDto>  findEvlProducts(FindEvlProductPage findEvlProductPage)throws TsfaServiceException{
		AssertUtils.notNull(findEvlProductPage);
		List<EvlProductDto> returnList=null;
		try {
			returnList = evlProductDao.findEvlProducts(findEvlProductPage);
		} catch (Exception e) {
			logger.error("查找商品评价信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.EVL_PRODUCT_NOT_EXIST_ERROR,"商品评价信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateEvlProduct(
			EvlProductDto evlProductDto)
			throws TsfaServiceException {
		logger.debug("updateEvlProduct(EvlProductDto evlProductDto={}) - start", evlProductDto); //$NON-NLS-1$

		AssertUtils.notNull(evlProductDto);
		AssertUtils.notNullAndEmpty(evlProductDto.getCode(),"Code不能为空");
		try {
			EvlProduct evlProduct = new EvlProduct();
			//update数据录入
			evlProduct.setCode(evlProductDto.getCode());
			evlProduct.setEvlInfo(evlProductDto.getEvlInfo());
			evlProduct.setEvlGrade(evlProductDto.getEvlGrade());
			evlProduct.setEvlMbrCode(evlProductDto.getEvlMbrCode());
			evlProduct.setEvlMbrName(evlProductDto.getEvlMbrName());
			evlProduct.setEvlMbrImg(evlProductDto.getEvlMbrImg());
			evlProduct.setProductCode(evlProductDto.getProductCode());
			evlProduct.setProductName(evlProductDto.getProductName());
			evlProduct.setProductSkuCode(evlProductDto.getProductSkuCode());
			evlProduct.setGoodCnt(evlProductDto.getGoodCnt());
			evlProduct.setImgs(evlProductDto.getImgs());
			AssertUtils.notUpdateMoreThanOne(evlProductDao.updateByPrimaryKeySelective(evlProduct));
			logger.debug("updateEvlProduct(EvlProductDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品评价信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.EVL_PRODUCT_UPDATE_ERROR,"商品评价信息更新信息错误！",e);
		}
	}

	

	@Override
	public EvlProductDto findEvlProduct(
			EvlProductDto evlProductDto) throws TsfaServiceException {
		logger.debug("findEvlProduct(FindEvlProduct findEvlProduct={}) - start", evlProductDto); //$NON-NLS-1$

		AssertUtils.notNull(evlProductDto);
		AssertUtils.notAllNull(evlProductDto.getCode(),"Code不能为空");
		try {
			EvlProduct evlProduct = evlProductDao.selectByPrimaryKey(evlProductDto.getCode());
			if(evlProduct == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.EVL_PRODUCT_NOT_EXIST_ERROR,"商品评价信息不存在");
			}
			EvlProductDto findEvlProductReturn = new EvlProductDto();
			//find数据录入
			findEvlProductReturn.setCode(evlProduct.getCode());
			findEvlProductReturn.setEvlInfo(evlProduct.getEvlInfo());
			findEvlProductReturn.setEvlGrade(evlProduct.getEvlGrade());
			findEvlProductReturn.setEvlMbrCode(evlProduct.getEvlMbrCode());
			findEvlProductReturn.setEvlMbrName(evlProduct.getEvlMbrName());
			findEvlProductReturn.setEvlMbrImg(evlProduct.getEvlMbrImg());
			findEvlProductReturn.setCreateTime(evlProduct.getCreateTime());
			findEvlProductReturn.setProductCode(evlProduct.getProductCode());
			findEvlProductReturn.setProductName(evlProduct.getProductName());
			findEvlProductReturn.setProductSkuCode(evlProduct.getProductSkuCode());
			findEvlProductReturn.setGoodCnt(evlProduct.getGoodCnt());
			findEvlProductReturn.setImgs(evlProduct.getImgs());
			
			logger.debug("findEvlProduct(EvlProductDto) - end - return value={}", findEvlProductReturn); //$NON-NLS-1$
			return findEvlProductReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品评价信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.EVL_PRODUCT_FIND_ERROR,"查找商品评价信息信息错误！",e);
		}


	}

	
	@Override
	public Page<EvlProductDto> findEvlProductPage(
			FindEvlProductPage findEvlProductPage)
			throws TsfaServiceException {
		logger.debug("findEvlProductPage(FindEvlProductPage findEvlProductPage={}) - start", findEvlProductPage); //$NON-NLS-1$

		AssertUtils.notNull(findEvlProductPage);
		List<EvlProductDto> returnList=null;
		int count = 0;
		try {
			returnList = evlProductDao.findEvlProductPage(findEvlProductPage);
			count = evlProductDao.findEvlProductPageCount(findEvlProductPage);
		}  catch (Exception e) {
			logger.error("商品评价信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.EVL_PRODUCT_FIND_PAGE_ERROR,"商品评价信息不存在错误.！",e);
		}
		Page<EvlProductDto> returnPage = new Page<EvlProductDto>(returnList, count, findEvlProductPage);

		logger.debug("findEvlProductPage(FindEvlProductPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
