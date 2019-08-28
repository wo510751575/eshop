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
import com.lj.eshop.dao.ICatalogDao;
import com.lj.eshop.domain.Catalog;
import com.lj.eshop.dto.CatalogDto;
import com.lj.eshop.dto.FindCatalogPage;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.service.ICatalogService;
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
public class CatalogServiceImpl implements ICatalogService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);
	

	@Resource
	private ICatalogDao catalogDao;
	
	
	@Override
	public CatalogDto addCatalog(
			CatalogDto catalogDto) throws TsfaServiceException {
		logger.debug("addCatalog(AddCatalog addCatalog={}) - start", catalogDto); 

		AssertUtils.notNull(catalogDto);
		try {
			Catalog catalog = new Catalog();
			//add数据录入
			catalog.setCode(GUID.generateCode());
			catalog.setCatalogName(catalogDto.getCatalogName());
			catalog.setParentCatalogCode(catalogDto.getParentCatalogCode());
			catalog.setParentCatalogName(catalogDto.getParentCatalogName());
			catalog.setImageUrl(catalogDto.getImageUrl());
			catalog.setOrderNo(catalogDto.getOrderNo());
			catalog.setCreater(catalogDto.getCreater());
			catalog.setCreateTime(new Date());
			catalog.setDelFlag(DelFlag.N.getValue());
			catalog.setRecommend(catalogDto.getRecommend());
			catalogDao.insertSelective(catalog);
			catalogDto.setCode(catalog.getCode());
			logger.debug("addCatalog(CatalogDto) - end - return"); 
			return catalogDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品类目信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CATALOG_ADD_ERROR,"新增商品类目信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品类目信息
	 *
	 * @param findCatalogPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<CatalogDto>  findCatalogs(FindCatalogPage findCatalogPage)throws TsfaServiceException{
		AssertUtils.notNull(findCatalogPage);
		List<CatalogDto> returnList=null;
		try {
			returnList = catalogDao.findCatalogs(findCatalogPage);
		} catch (Exception e) {
			logger.error("查找商品类目信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.CATALOG_NOT_EXIST_ERROR,"商品类目信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateCatalog(
			CatalogDto catalogDto)
			throws TsfaServiceException {
		logger.debug("updateCatalog(CatalogDto catalogDto={}) - start", catalogDto); //$NON-NLS-1$

		AssertUtils.notNull(catalogDto);
		AssertUtils.notNullAndEmpty(catalogDto.getCode(),"Code不能为空");
		try {
			Catalog catalog = new Catalog();
			//update数据录入
			catalog.setCode(catalogDto.getCode());
			catalog.setCatalogName(catalogDto.getCatalogName());
			catalog.setParentCatalogCode(catalogDto.getParentCatalogCode());
			catalog.setParentCatalogName(catalogDto.getParentCatalogName());
			catalog.setImageUrl(catalogDto.getImageUrl());
			catalog.setOrderNo(catalogDto.getOrderNo());
			catalog.setCreater(catalogDto.getCreater());
			catalog.setCreateTime(catalogDto.getCreateTime());
			catalog.setDelFlag(catalogDto.getDelFlag());
			catalog.setRecommend(catalogDto.getRecommend());
			AssertUtils.notUpdateMoreThanOne(catalogDao.updateByPrimaryKeySelective(catalog));
			logger.debug("updateCatalog(CatalogDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品类目信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CATALOG_UPDATE_ERROR,"商品类目信息更新信息错误！",e);
		}
	}

	

	@Override
	public CatalogDto findCatalog(
			CatalogDto catalogDto) throws TsfaServiceException {
		logger.debug("findCatalog(FindCatalog findCatalog={}) - start", catalogDto); //$NON-NLS-1$

		AssertUtils.notNull(catalogDto);
		AssertUtils.notAllNull(catalogDto.getCode(),"Code不能为空");
		try {
			Catalog catalog = catalogDao.selectByPrimaryKey(catalogDto.getCode());
			if(catalog == null){
				throw new TsfaServiceException(ErrorCode.CATALOG_NOT_EXIST_ERROR,"商品类目信息不存在");
			}
			CatalogDto findCatalogReturn = new CatalogDto();
			//find数据录入
			findCatalogReturn.setCode(catalog.getCode());
			findCatalogReturn.setCatalogName(catalog.getCatalogName());
			findCatalogReturn.setParentCatalogCode(catalog.getParentCatalogCode());
			findCatalogReturn.setParentCatalogName(catalog.getParentCatalogName());
			findCatalogReturn.setImageUrl(catalog.getImageUrl());
			findCatalogReturn.setOrderNo(catalog.getOrderNo());
			findCatalogReturn.setCreater(catalog.getCreater());
			findCatalogReturn.setCreateTime(catalog.getCreateTime());
			findCatalogReturn.setDelFlag(catalog.getDelFlag());
			findCatalogReturn.setRecommend(catalog.getRecommend());
			logger.debug("findCatalog(CatalogDto) - end - return value={}", findCatalogReturn); //$NON-NLS-1$
			return findCatalogReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品类目信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CATALOG_FIND_ERROR,"查找商品类目信息信息错误！",e);
		}


	}

	
	@Override
	public Page<CatalogDto> findCatalogPage(
			FindCatalogPage findCatalogPage)
			throws TsfaServiceException {
		logger.debug("findCatalogPage(FindCatalogPage findCatalogPage={}) - start", findCatalogPage); //$NON-NLS-1$

		AssertUtils.notNull(findCatalogPage);
		List<CatalogDto> returnList=null;
		int count = 0;
		try {
			returnList = catalogDao.findCatalogPage(findCatalogPage);
			count = catalogDao.findCatalogPageCount(findCatalogPage);
		}  catch (Exception e) {
			logger.error("商品类目信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.CATALOG_FIND_PAGE_ERROR,"商品类目信息不存在错误.！",e);
		}
		Page<CatalogDto> returnPage = new Page<CatalogDto>(returnList, count, findCatalogPage);

		logger.debug("findCatalogPage(FindCatalogPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
