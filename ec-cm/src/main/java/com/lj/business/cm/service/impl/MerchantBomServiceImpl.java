package com.lj.business.cm.service.impl;

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
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.constant.ErrorCode;
import com.lj.business.cm.dao.IMerchantBomDao;
import com.lj.business.cm.domain.MerchantBom;
import com.lj.business.cm.dto.AddMerchantBom;
import com.lj.business.cm.dto.AddMerchantBomReturn;
import com.lj.business.cm.dto.DelMerchantBom;
import com.lj.business.cm.dto.DelMerchantBomReturn;
import com.lj.business.cm.dto.FindMerchantBom;
import com.lj.business.cm.dto.FindMerchantBomPage;
import com.lj.business.cm.dto.FindMerchantBomPageReturn;
import com.lj.business.cm.dto.FindMerchantBomReturn;
import com.lj.business.cm.dto.UpdateMerchantBom;
import com.lj.business.cm.dto.UpdateMerchantBomReturn;
import com.lj.business.cm.service.IMerchantBomService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 罗书明
 * 
 * 
 * CreateDate: 2017-06-21
 */
@Service
public class MerchantBomServiceImpl implements IMerchantBomService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MerchantBomServiceImpl.class);
	

	/** The merchant bom dao. */
	@Resource
	private IMerchantBomDao merchantBomDao;
	
	/**
	 * 方法说明：添加商户产品表信息.
	 *
	 * @param addMerchantBom the add merchant bom
	 * @return the adds the merchant bom return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public AddMerchantBomReturn addMerchantBom(
			AddMerchantBom addMerchantBom) throws TsfaServiceException {
		logger.debug("addMerchantBom(AddMerchantBom addMerchantBom={}) - start", addMerchantBom); 

		AssertUtils.notNull(addMerchantBom);
		try {
			MerchantBom merchantBom = new MerchantBom();
			//add数据录入
			merchantBom.setCode(addMerchantBom.getCode());
			merchantBom.setMerchantNo(addMerchantBom.getMerchantNo());
			merchantBom.setMerchantName(addMerchantBom.getMerchantName());
			merchantBom.setBomCode(addMerchantBom.getBomCode());
			merchantBom.setBomName(addMerchantBom.getBomName());
			merchantBom.setImgAddr(addMerchantBom.getImgAddr());
			merchantBom.setCreateId(addMerchantBom.getCreateId());
			merchantBom.setCreateDate(addMerchantBom.getCreateDate());
			merchantBomDao.insert(merchantBom);
			AddMerchantBomReturn addMerchantBomReturn = new AddMerchantBomReturn();
			
			logger.debug("addMerchantBom(AddMerchantBom) - end - return value={}", addMerchantBomReturn); 
			return addMerchantBomReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商户产品表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_BOM_ADD_ERROR,"新增商户产品表信息错误！",e);
		}
	}
	
	/**
	 * 方法说明：删除商户产品表信息.
	 *
	 * @param delMerchantBom the del merchant bom
	 * @return the del merchant bom return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public DelMerchantBomReturn delMerchantBom(
			DelMerchantBom delMerchantBom) throws TsfaServiceException {
		logger.debug("delMerchantBom(DelMerchantBom delMerchantBom={}) - start", delMerchantBom); 

		AssertUtils.notNull(delMerchantBom);
		AssertUtils.notNull(delMerchantBom.getCode(),"ID不能为空！");
		try {
			merchantBomDao.deleteByPrimaryKey(delMerchantBom.getCode());
			DelMerchantBomReturn delMerchantBomReturn  = new DelMerchantBomReturn();

			logger.debug("delMerchantBom(DelMerchantBom) - end - return value={}", delMerchantBomReturn); //$NON-NLS-1$
			return delMerchantBomReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除商户产品表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_BOM_DEL_ERROR,"删除商户产品表信息错误！",e);

		}
	}
	
	/**
	 * 方法说明：更新修改商户产品表信息.
	 *
	 * @param updateMerchantBom the update merchant bom
	 * @return the update merchant bom return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public UpdateMerchantBomReturn updateMerchantBom(
			UpdateMerchantBom updateMerchantBom)
			throws TsfaServiceException {
		logger.debug("updateMerchantBom(UpdateMerchantBom updateMerchantBom={}) - start", updateMerchantBom); //$NON-NLS-1$

		AssertUtils.notNull(updateMerchantBom);
		AssertUtils.notNullAndEmpty(updateMerchantBom.getCode(),"ID不能为空");
		try {
			MerchantBom merchantBom = new MerchantBom();
			//update数据录入
			merchantBom.setCode(updateMerchantBom.getCode());
			merchantBom.setMerchantNo(updateMerchantBom.getMerchantNo());
			merchantBom.setMerchantName(updateMerchantBom.getMerchantName());
			merchantBom.setBomCode(updateMerchantBom.getBomCode());
			merchantBom.setBomName(updateMerchantBom.getBomName());
			merchantBom.setImgAddr(updateMerchantBom.getImgAddr());
			merchantBom.setCreateId(updateMerchantBom.getCreateId());
			merchantBom.setCreateDate(updateMerchantBom.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(merchantBomDao.updateByPrimaryKeySelective(merchantBom));
			UpdateMerchantBomReturn updateMerchantBomReturn = new UpdateMerchantBomReturn();

			logger.debug("updateMerchantBom(UpdateMerchantBom) - end - return value={}", updateMerchantBomReturn); //$NON-NLS-1$
			return updateMerchantBomReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商户产品表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_BOM_UPDATE_ERROR,"商户产品表信息更新错误！",e);
		}
	}

	
	/**
	 * 方法说明：查询商户产品表信息.
	 *
	 * @param findMerchantBom the find merchant bom
	 * @return the find merchant bom return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public FindMerchantBomReturn findMerchantBom(
			FindMerchantBom findMerchantBom) throws TsfaServiceException {
		logger.debug("findMerchantBom(FindMerchantBom findMerchantBom={}) - start", findMerchantBom); //$NON-NLS-1$

		AssertUtils.notNull(findMerchantBom);
		AssertUtils.notAllNull(findMerchantBom.getCode(),"ID不能为空");
		try {
			MerchantBom merchantBom = merchantBomDao.selectByPrimaryKey(findMerchantBom.getCode());
			if(merchantBom == null){
				throw new TsfaServiceException(ErrorCode.MERCHANT_BOM_NOT_EXIST_ERROR,"商户产品表信息不存在");
			}
			FindMerchantBomReturn findMerchantBomReturn = new FindMerchantBomReturn();
			//find数据录入
			findMerchantBomReturn.setCode(merchantBom.getCode());
			findMerchantBomReturn.setMerchantNo(merchantBom.getMerchantNo());
			findMerchantBomReturn.setMerchantName(merchantBom.getMerchantName());
			findMerchantBomReturn.setBomCode(merchantBom.getBomCode());
			findMerchantBomReturn.setBomName(merchantBom.getBomName());
			findMerchantBomReturn.setImgAddr(merchantBom.getImgAddr());
			findMerchantBomReturn.setCreateId(merchantBom.getCreateId());
			findMerchantBomReturn.setCreateDate(merchantBom.getCreateDate());
			
			logger.debug("findMerchantBom(FindMerchantBom) - end - return value={}", findMerchantBomReturn); //$NON-NLS-1$
			return findMerchantBomReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找商户产品表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_BOM_FIND_ERROR,"查找商户产品表信息错误！",e);
		}


	}

	/**
	 * 方法说明：分页查询商户产品表信息.
	 *
	 * @param findMerchantBomPage the find merchant bom page
	 * @return the page< find merchant bom page return>
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public Page<FindMerchantBomPageReturn> findMerchantBomPage(
			FindMerchantBomPage findMerchantBomPage)
			throws TsfaServiceException {
		logger.debug("findMerchantBomPage(FindMerchantBomPage findMerchantBomPage={}) - start", findMerchantBomPage); //$NON-NLS-1$

		AssertUtils.notNull(findMerchantBomPage);
		List<FindMerchantBomPageReturn> returnList;
		int count = 0;
		try {
			returnList = merchantBomDao.findMerchantBomPage(findMerchantBomPage);
			count = merchantBomDao.findMerchantBomPageCount(findMerchantBomPage);
		}  catch (Exception e) {
			logger.error("商户产品表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_BOM_FIND_PAGE_ERROR,"商户产品表信息分页查询错误.！",e);
		}
		Page<FindMerchantBomPageReturn> returnPage = new Page<FindMerchantBomPageReturn>(returnList, count, findMerchantBomPage);

		logger.debug("findMerchantBomPage(FindMerchantBomPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
