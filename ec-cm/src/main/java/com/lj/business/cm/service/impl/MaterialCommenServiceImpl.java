package com.lj.business.cm.service.impl;

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
import com.lj.business.cm.constant.ErrorCode;
import com.lj.business.cm.dao.IMaterialCommenDao;
import com.lj.business.cm.domain.MaterialCommen;
import com.lj.business.cm.dto.AddMaterialCommen;
import com.lj.business.cm.dto.AddMaterialCommenReturn;
import com.lj.business.cm.dto.CountMaterialCommenDto;
import com.lj.business.cm.dto.DelMaterialCommen;
import com.lj.business.cm.dto.DelMaterialCommenReturn;
import com.lj.business.cm.dto.FindMaterialCommen;
import com.lj.business.cm.dto.FindMaterialCommenPage;
import com.lj.business.cm.dto.FindMaterialCommenPageReturn;
import com.lj.business.cm.dto.FindMaterialCommenReturn;
import com.lj.business.cm.dto.GeneratorMaterialTotalReturn;
import com.lj.business.cm.dto.UpdateMaterialCommen;
import com.lj.business.cm.dto.UpdateMaterialCommenReturn;
import com.lj.business.cm.service.IMaterialCommenService;
import com.lj.business.cm.service.IMaterialTypeService;

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
 * CreateDate: 2017-06-14
 */
@Service
public class MaterialCommenServiceImpl implements IMaterialCommenService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MaterialCommenServiceImpl.class);
	

	/** The material commen dao. */
	@Resource
	private IMaterialCommenDao materialCommenDao;
	
	@Resource
	private IMaterialTypeService materialTypeService;
	
	/**
	 * 方法说明：添加公用素材中心表信息.
	 *
	 * @param addMaterialCommen
	 *            the add material commen
	 * @return the adds the material commen return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 */
	@Override
	public AddMaterialCommenReturn addMaterialCommen(AddMaterialCommen addMaterialCommen) throws TsfaServiceException {
		logger.debug("addMaterialCommen(AddMaterialCommen addMaterialCommen={}) - start", addMaterialCommen);

		AssertUtils.notNull(addMaterialCommen);
		try {
			MaterialCommen materialCommen = new MaterialCommen();
			// add数据录入
			materialCommen.setCode(GUID.getPreUUID());
			materialCommen.setMaterialTypeCode(addMaterialCommen.getMaterialTypeCode());
			materialCommen.setMaterialTypeName(addMaterialCommen.getMaterialTypeName());
			materialCommen.setTitle(addMaterialCommen.getTitle());
			materialCommen.setContent(addMaterialCommen.getContent());
			materialCommen.setBrief(addMaterialCommen.getBrief());
			materialCommen.setShopNo(addMaterialCommen.getShopNo());
			materialCommen.setShopName(addMaterialCommen.getShopName());
			materialCommen.setDimensionSt(addMaterialCommen.getDimensionSt());
			materialCommen.setImgAddr(addMaterialCommen.getImgAddr());
			materialCommen.setRespondNum(addMaterialCommen.getRespondNum());
			materialCommen.setCreateId(addMaterialCommen.getCreateId());
			materialCommen.setCreateDate(new Date());
			materialCommen.setMerchantNo(addMaterialCommen.getMerchantNo());
			materialCommen.setMerchantName(addMaterialCommen.getMerchantName());
			materialCommen.setLinkUrl(addMaterialCommen.getLinkUrl());
			materialCommen.setShopType(addMaterialCommen.getShopType());
			materialCommen.setTempId(addMaterialCommen.getTempId());
			materialCommenDao.insertSelective(materialCommen);
			
			// 增加类型总数
			materialTypeService.incrementTypeCountByPrimaryKey(addMaterialCommen.getMaterialTypeCode(), 1);
			AddMaterialCommenReturn addMaterialCommenReturn = new AddMaterialCommenReturn();
			addMaterialCommenReturn.setCode(materialCommen.getCode());
			logger.debug("addMaterialCommen(AddMaterialCommen) - end - return value={}", addMaterialCommenReturn);
			return addMaterialCommenReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增公用素材中心表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_COMMEN_ADD_ERROR, "新增公用素材中心表信息错误！", e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IMaterialCommenService#delMaterialCommen(com.lj.business.cm.dto.DelMaterialCommen)
	 */
	@Override
	public DelMaterialCommenReturn delMaterialCommen(
			DelMaterialCommen delMaterialCommen) throws TsfaServiceException {
		logger.debug("delMaterialCommen(DelMaterialCommen delMaterialCommen={}) - start", delMaterialCommen); 

		AssertUtils.notNull(delMaterialCommen);
		AssertUtils.notNull(delMaterialCommen.getCode(),"ID不能为空！");
		try {
			materialCommenDao.deleteByPrimaryKey(delMaterialCommen.getCode());
			DelMaterialCommenReturn delMaterialCommenReturn  = new DelMaterialCommenReturn();

			logger.debug("delMaterialCommen(DelMaterialCommen) - end - return value={}", delMaterialCommenReturn); //$NON-NLS-1$
			return delMaterialCommenReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除公用素材中心表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_COMMEN_DEL_ERROR,"删除公用素材中心表信息错误！",e);

		}
	}

	/**
	 * 方法说明：更新公用素材中心表信息.
	 *
	 * @param updateMaterialCommen the update material commen
	 * @return the update material commen return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public UpdateMaterialCommenReturn updateMaterialCommen(
			UpdateMaterialCommen updateMaterialCommen)
			throws TsfaServiceException {
		logger.debug("updateMaterialCommen(UpdateMaterialCommen updateMaterialCommen={}) - start", updateMaterialCommen); //$NON-NLS-1$

		AssertUtils.notNull(updateMaterialCommen);
		AssertUtils.notNullAndEmpty(updateMaterialCommen.getCode(),"ID不能为空");
		try {
			MaterialCommen materialCommen = new MaterialCommen();
			//update数据录入
			materialCommen.setCode(updateMaterialCommen.getCode());
			materialCommen.setMaterialTypeCode(updateMaterialCommen.getMaterialTypeCode());
			materialCommen.setMaterialTypeName(updateMaterialCommen.getMaterialTypeName());
			materialCommen.setTitle(updateMaterialCommen.getTitle());
			materialCommen.setContent(updateMaterialCommen.getContent());
			materialCommen.setBrief(updateMaterialCommen.getBrief());
			materialCommen.setShopNo(updateMaterialCommen.getShopNo());
			materialCommen.setShopName(updateMaterialCommen.getShopName());
			materialCommen.setDimensionSt(updateMaterialCommen.getDimensionSt());
			materialCommen.setImgAddr(updateMaterialCommen.getImgAddr());
			materialCommen.setRespondNum(updateMaterialCommen.getRespondNum());
			materialCommen.setCreateId(updateMaterialCommen.getCreateId());
			materialCommen.setCreateDate(updateMaterialCommen.getCreateDate());
			materialCommen.setLinkUrl(updateMaterialCommen.getLinkUrl());
			materialCommen.setShopType(updateMaterialCommen.getShopType());
			materialCommen.setTempId(updateMaterialCommen.getTempId());
			AssertUtils.notUpdateMoreThanOne(materialCommenDao.updateByPrimaryKeySelective(materialCommen));
			UpdateMaterialCommenReturn updateMaterialCommenReturn = new UpdateMaterialCommenReturn();
			logger.debug("updateMaterialCommen(UpdateMaterialCommen) - end - return value={}", updateMaterialCommenReturn); //$NON-NLS-1$
			return updateMaterialCommenReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("公用素材中心表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_COMMEN_UPDATE_ERROR,"公用素材中心表信息更新错误！",e);
		}
	}


	/**
	 * 方法说明：查询公用素材中心表信息.
	 *
	 * @param findMaterialCommen the find material commen
	 * @return the find material commen return
	 * @throws TsfaServiceException the tsfa service exception
	 */

	@Override
	public FindMaterialCommenReturn findMaterialCommen(
			FindMaterialCommen findMaterialCommen) throws TsfaServiceException {
		logger.debug("findMaterialCommen(FindMaterialCommen findMaterialCommen={}) - start", findMaterialCommen); //$NON-NLS-1$

		AssertUtils.notNull(findMaterialCommen);
		AssertUtils.notAllNull(findMaterialCommen.getCode(),"ID不能为空");
		try {
			MaterialCommen materialCommen = materialCommenDao.selectByPrimaryKey(findMaterialCommen.getCode());
			if(materialCommen == null){
				throw new TsfaServiceException(ErrorCode.MATERIAL_COMMEN_NOT_EXIST_ERROR,"公用素材中心表信息不存在");
			}
			FindMaterialCommenReturn findMaterialCommenReturn = new FindMaterialCommenReturn();
			//find数据录入
			findMaterialCommenReturn.setCode(materialCommen.getCode());
			findMaterialCommenReturn.setMaterialTypeCode(materialCommen.getMaterialTypeCode());
			findMaterialCommenReturn.setMaterialTypeName(materialCommen.getMaterialTypeName());
			findMaterialCommenReturn.setTitle(materialCommen.getTitle());
			findMaterialCommenReturn.setContent(materialCommen.getContent());
			findMaterialCommenReturn.setBrief(materialCommen.getBrief());
			findMaterialCommenReturn.setShopNo(materialCommen.getShopNo());
			findMaterialCommenReturn.setShopName(materialCommen.getShopName());
			findMaterialCommenReturn.setDimensionSt(materialCommen.getDimensionSt());
			findMaterialCommenReturn.setImgAddr(materialCommen.getImgAddr());
			findMaterialCommenReturn.setRespondNum(materialCommen.getRespondNum());
			findMaterialCommenReturn.setCreateId(materialCommen.getCreateId());
			findMaterialCommenReturn.setCreateDate(materialCommen.getCreateDate());
			findMaterialCommenReturn.setMerchantNo(materialCommen.getMerchantNo());
			findMaterialCommenReturn.setMerchantName(materialCommen.getMerchantName());
			findMaterialCommenReturn.setLinkUrl(materialCommen.getLinkUrl());
			findMaterialCommenReturn.setShopType(materialCommen.getShopType());
			findMaterialCommenReturn.setTempId(materialCommen.getTempId());
			logger.debug("findMaterialCommen(FindMaterialCommen) - end - return value={}", findMaterialCommenReturn); //$NON-NLS-1$
			return findMaterialCommenReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找公用素材中心表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_COMMEN_FIND_ERROR,"查找公用素材中心表信息信息错误！",e);
		}


	}

	/**
	 * 方法说明：分页查询公用素材.
	 *
	 * @param findMaterialCommenPage the find material commen page
	 * @return the page< find material commen page return>
	 * @throws TsfaServiceException the tsfa service exception
	 */
	
	@Override
	public Page<FindMaterialCommenPageReturn> findMaterialCommenPage(
			FindMaterialCommenPage findMaterialCommenPage)
			throws TsfaServiceException {
		logger.debug("findMaterialCommenPage(FindMaterialCommenPage findMaterialCommenPage={}) - start", findMaterialCommenPage); //$NON-NLS-1$

		AssertUtils.notNull(findMaterialCommenPage);
		List<FindMaterialCommenPageReturn> returnList;
		int count = 0;
		try {
			returnList = materialCommenDao.findMaterialCommenPage(findMaterialCommenPage);
			count = materialCommenDao.findMaterialCommenPageCount(findMaterialCommenPage);
		}  catch (Exception e) {
			logger.error("公用素材中心表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_COMMEN_FIND_PAGE_ERROR,"公用素材中心表信息分页查询错误.！",e);
		}
		Page<FindMaterialCommenPageReturn> returnPage = new Page<FindMaterialCommenPageReturn>(returnList, count, findMaterialCommenPage);

		logger.debug("findMaterialCommenPage(FindMaterialCommenPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


   
	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IMaterialCommenService#findMaterialCommenList(com.lj.business.cm.dto.FindMaterialCommenPage)
	 */
	public List<FindMaterialCommenPageReturn> findMaterialCommenList (FindMaterialCommenPage findMaterialCommenPage) throws TsfaServiceException {
		logger.debug("findMaterialCommenPage(FindMaterialCommenPage findMaterialCommenPage={}) - start", findMaterialCommenPage); 	
		List<FindMaterialCommenPageReturn> list;
		 try {
			list=materialCommenDao.findMaterialCommenList(findMaterialCommenPage);
		
		} catch (Exception e) {
			logger.error("公用素材中心表信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_COMMEN_FIND_PAGE_ERROR,"公用素材中心表信息不存在错误.！",e);
		}
			return list;
	}


	@Override
	public FindMaterialCommenPageReturn findMaterialCommenByCode(String code) {
		AssertUtils.notNull(code);
		return materialCommenDao.findMaterialCommenByCode(code);
	}


	@Override
	public void addMaterialCommentRespondNum(String code) {
		AssertUtils.notNull(code);
		int updateNum = 0;//更新行数
		try {
			while(updateNum > 0){//当更新行数大于0，则证明更新成功
				FindMaterialCommenPageReturn materialCommenPageReturn = findMaterialCommenByCode(code);
				MaterialCommen materialCommen = new MaterialCommen();
				materialCommen.setCode(code);
				materialCommen.setRespondNum(materialCommenPageReturn.getRespondNum());
				updateNum = materialCommenDao.updateRespondNumByPrimaryKeyAndRespondNum(materialCommen);
			}
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("增加公共素材回应数量失败！",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_COMMEN_ADD_RESPOND_NUMBER_ERROR,"增加公共素材回应数量失败！",e);
		}
	}


	@Override
	public int countMaterialCommenSelective(
			CountMaterialCommenDto countMaterialCommenDto) {
		AssertUtils.notNull(countMaterialCommenDto);
		return materialCommenDao.countMaterialCommenSelective(countMaterialCommenDto);
	}


	@Override
	public long getMaterialCommentResponseTotal(String merchantNo) {
		return materialCommenDao.getMaterialCommentResponseTotal(merchantNo);
	}


	@Override
	public List<GeneratorMaterialTotalReturn> generatorMaterialCommenTotal(String merchantNo) {
		return materialCommenDao.generatorMaterialCommenTotal(merchantNo);
	}

}
