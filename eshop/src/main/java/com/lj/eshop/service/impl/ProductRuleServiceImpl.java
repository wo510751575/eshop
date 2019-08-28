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
import com.lj.eshop.dao.IProductRuleDao;
import com.lj.eshop.domain.ProductRule;
import com.lj.eshop.dto.FindProductRulePage;
import com.lj.eshop.dto.ProductRuleDto;
import com.lj.eshop.service.IProductRuleService;
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
public class ProductRuleServiceImpl implements IProductRuleService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ProductRuleServiceImpl.class);
	

	@Resource
	private IProductRuleDao productRuleDao;
	
	
	@Override
	public ProductRuleDto addProductRule(
			ProductRuleDto productRuleDto) throws TsfaServiceException {
		logger.debug("addProductRule(AddProductRule addProductRule={}) - start", productRuleDto); 

		AssertUtils.notNull(productRuleDto);
		try {
			ProductRule productRule = new ProductRule();
			//add数据录入
			productRule.setCode(GUID.generateCode());
			productRule.setName(productRuleDto.getName());
			productRule.setProductCode(productRuleDto.getProductCode());
			productRule.setRemarks(productRuleDto.getRemarks());
			productRule.setOrderNo(productRuleDto.getOrderNo());
			productRuleDao.insertSelective(productRule);
			productRuleDto.setCode(productRule.getCode());
			logger.debug("addProductRule(ProductRuleDto) - end - return"); 
			return productRuleDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品规格分类信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_RULE_ADD_ERROR,"新增商品规格分类信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品规格分类信息
	 *
	 * @param findProductRulePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ProductRuleDto>  findProductRules(FindProductRulePage findProductRulePage)throws TsfaServiceException{
		AssertUtils.notNull(findProductRulePage);
		List<ProductRuleDto> returnList=null;
		try {
			returnList = productRuleDao.findProductRules(findProductRulePage);
		} catch (Exception e) {
			logger.error("查找商品规格分类信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_RULE_NOT_EXIST_ERROR,"商品规格分类信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateProductRule(
			ProductRuleDto productRuleDto)
			throws TsfaServiceException {
		logger.debug("updateProductRule(ProductRuleDto productRuleDto={}) - start", productRuleDto); //$NON-NLS-1$

		AssertUtils.notNull(productRuleDto);
		AssertUtils.notNullAndEmpty(productRuleDto.getCode(),"Code不能为空");
		try {
			ProductRule productRule = new ProductRule();
			//update数据录入
			productRule.setCode(productRuleDto.getCode());
			productRule.setName(productRuleDto.getName());
			productRule.setProductCode(productRuleDto.getProductCode());
			productRule.setRemarks(productRuleDto.getRemarks());
			productRule.setOrderNo(productRuleDto.getOrderNo());
			AssertUtils.notUpdateMoreThanOne(productRuleDao.updateByPrimaryKeySelective(productRule));
			logger.debug("updateProductRule(ProductRuleDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品规格分类信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_RULE_UPDATE_ERROR,"商品规格分类信息更新信息错误！",e);
		}
	}

	

	@Override
	public ProductRuleDto findProductRule(
			ProductRuleDto productRuleDto) throws TsfaServiceException {
		logger.debug("findProductRule(FindProductRule findProductRule={}) - start", productRuleDto); //$NON-NLS-1$

		AssertUtils.notNull(productRuleDto);
		AssertUtils.notAllNull(productRuleDto.getCode(),"Code不能为空");
		try {
			ProductRule productRule = productRuleDao.selectByPrimaryKey(productRuleDto.getCode());
			if(productRule == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.PRODUCT_RULE_NOT_EXIST_ERROR,"商品规格分类信息不存在");
			}
			ProductRuleDto findProductRuleReturn = new ProductRuleDto();
			//find数据录入
			findProductRuleReturn.setCode(productRule.getCode());
			findProductRuleReturn.setName(productRule.getName());
			findProductRuleReturn.setProductCode(productRule.getProductCode());
			findProductRuleReturn.setRemarks(productRule.getRemarks());
			findProductRuleReturn.setOrderNo(productRule.getOrderNo());
			
			logger.debug("findProductRule(ProductRuleDto) - end - return value={}", findProductRuleReturn); //$NON-NLS-1$
			return findProductRuleReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品规格分类信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_RULE_FIND_ERROR,"查找商品规格分类信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ProductRuleDto> findProductRulePage(
			FindProductRulePage findProductRulePage)
			throws TsfaServiceException {
		logger.debug("findProductRulePage(FindProductRulePage findProductRulePage={}) - start", findProductRulePage); //$NON-NLS-1$

		AssertUtils.notNull(findProductRulePage);
		List<ProductRuleDto> returnList=null;
		int count = 0;
		try {
			returnList = productRuleDao.findProductRulePage(findProductRulePage);
			count = productRuleDao.findProductRulePageCount(findProductRulePage);
		}  catch (Exception e) {
			logger.error("商品规格分类信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.PRODUCT_RULE_FIND_PAGE_ERROR,"商品规格分类信息不存在错误.！",e);
		}
		Page<ProductRuleDto> returnPage = new Page<ProductRuleDto>(returnList, count, findProductRulePage);

		logger.debug("findProductRulePage(FindProductRulePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
