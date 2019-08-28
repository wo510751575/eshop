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

import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.constant.ErrorCode;
import com.lj.business.cm.dao.IMaterialDao;
import com.lj.business.cm.dao.IMaterialTypeDao;
import com.lj.business.cm.domain.Material;
import com.lj.business.cm.dto.AddMaterial;
import com.lj.business.cm.dto.AddMaterialReturn;
import com.lj.business.cm.dto.CountMaterialDto;
import com.lj.business.cm.dto.DelMaterial;
import com.lj.business.cm.dto.DelMaterialReturn;
import com.lj.business.cm.dto.FindMaterial;
import com.lj.business.cm.dto.FindMaterialAppPage;
import com.lj.business.cm.dto.FindMaterialAppPageReturn;
import com.lj.business.cm.dto.FindMaterialPage;
import com.lj.business.cm.dto.FindMaterialPageReturn;
import com.lj.business.cm.dto.FindMaterialReturn;
import com.lj.business.cm.dto.GeneratorMaterialTotalReturn;
import com.lj.business.cm.dto.UpdateMaterial;
import com.lj.business.cm.dto.UpdateMaterialReturn;
import com.lj.business.cm.service.IMaterialService;
import com.lj.business.cm.service.IMaterialTypeService;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.guidMemberIntegral.GuidMemberIntegralDto;
import com.lj.business.member.emus.IntegralType;
import com.lj.business.member.service.IGuidMemberIntegralService;
import com.lj.business.member.service.IGuidMemberService;


/**
 * 类说明：素材中心
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
public class MaterialServiceImpl implements IMaterialService { 


	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);


	/** The material dao. */
	@Resource
	private IMaterialDao materialDao;

	/** The guid member service. */
	@Resource
	private IGuidMemberService guidMemberService;//findGuidMembers

	/** The material type dao. */
	@Resource
	private IMaterialTypeDao materialTypeDao;
	
	@Resource
	private IMaterialTypeService materialTypeService;
	
	@Resource
	private IGuidMemberIntegralService guidMemberIntegralService;

	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;

	/**
	 * 方法说明：添加素材中心表信息.
	 *
	 * @param addMaterial
	 *            the add material
	 * @return the adds the material return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 */
	@Override
	public AddMaterialReturn addMaterial(AddMaterial addMaterial) throws TsfaServiceException {
		logger.debug("addMaterial(AddMaterial addMaterial={}) - start", addMaterial);
		AssertUtils.notNull(addMaterial);
		
		try {
			Material material = new Material();
			material.setCode(GUID.getPreUUID());
			material.setMerchantNo(addMaterial.getMerchantNo());
			material.setMemberNoGm(addMaterial.getMemberNoGm());
			// 判断是否有名字传进来
			material.setMemberNameGm(addMaterial.getMemberNameGm());
			// 从素材类型里获取类型code与名称
			material.setMaterialTypeCode(addMaterial.getMaterialTypeCode());
			material.setMaterialTypeName(addMaterial.getMaterialTypeName());
			material.setTitle(addMaterial.getTitle());
			material.setContent(addMaterial.getContent());
			material.setBrief(addMaterial.getBrief());
			material.setImgAddr(addMaterial.getImgAddr());
			material.setRespondNum(addMaterial.getRespondNum());
			material.setCreateId(addMaterial.getCreateId());
			material.setLinkUrl(addMaterial.getLinkUrl());
			material.setCreateDate(new Date());
			materialDao.insertSelective(material);
			
			// 增加类型总数
			materialTypeService.incrementTypeCountByPrimaryKey(material.getMaterialTypeCode(), 1);
			
			AddMaterialReturn addMaterialReturn = new AddMaterialReturn();
			addMaterialReturn.setCode(material.getCode());
			
			//添加积分
			GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
			guidMemberIntegralDto.setMerchantNo(addMaterial.getMerchantNo());
			guidMemberIntegralDto.setMemberNo(addMaterial.getMemberNoGm());
			FindGuidMember findGuidMember =  new FindGuidMember();
			findGuidMember.setMemberNo(addMaterial.getMemberNoGm());
			FindGuidMemberReturn member = guidMemberService.findGuidMember(findGuidMember);
			if(member != null){
				guidMemberIntegralDto.setShopNo(member.getShopNo());
				guidMemberIntegralDto.setAreaCode(member.getAreaCode());
			}
			guidMemberIntegralDto.setIntegralType(IntegralType.NEW_MET.toString());
			guidMemberIntegralService.doIntegral(guidMemberIntegralDto);
			
			logger.debug("addMaterial(AddMaterial) - end - return value={}", addMaterialReturn);
			return addMaterialReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增素材中心表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_ADD_ERROR, "新增素材中心表信息错误！", e);
		}
	}

	/**
	 * 方法说明：删除素材中心表信息.
	 *
	 * @param delMaterial the del material
	 * @return the del material return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public DelMaterialReturn delMaterial(
			DelMaterial delMaterial) throws TsfaServiceException {
		logger.debug("delMaterial(DelMaterial delMaterial={}) - start", delMaterial); 

		AssertUtils.notNull(delMaterial);
		AssertUtils.notNull(delMaterial.getCode(),"ID不能为空！");
		try {
			materialDao.deleteByPrimaryKey(delMaterial.getCode());
			DelMaterialReturn delMaterialReturn  = new DelMaterialReturn();

			logger.debug("delMaterial(DelMaterial) - end - return value={}", delMaterialReturn); //$NON-NLS-1$
			return delMaterialReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除素材中心表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_DEL_ERROR,"删除素材中心表信息错误！",e);

		}
	}

	/**
	 * 方法说明：更新素材中心表信息.
	 *
	 * @param updateMaterial the update material
	 * @return the update material return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public  UpdateMaterialReturn updateMaterial(
			UpdateMaterial updateMaterial)
					throws TsfaServiceException {
		logger.debug("updateMaterial(UpdateMaterial updateMaterial={}) - start", updateMaterial); //$NON-NLS-1$

		AssertUtils.notNull(updateMaterial);
		AssertUtils.notNullAndEmpty(updateMaterial.getCode(),"ID不能为空");
		try {
			Material material = new Material();
			//update数据录入
			material.setCode(updateMaterial.getCode());
			material.setMerchantNo(updateMaterial.getMerchantNo());
			material.setMemberNoGm(updateMaterial.getMemberNoGm());
			material.setMemberNameGm(updateMaterial.getMemberNameGm());			
			material.setMaterialTypeCode(updateMaterial.getMaterialTypeCode());
			material.setMaterialTypeName(updateMaterial.getMaterialTypeName());
			material.setTitle(updateMaterial.getTitle());
			material.setLinkUrl(updateMaterial.getLinkUrl());
			material.setContent(updateMaterial.getContent());
			material.setBrief(updateMaterial.getBrief());
			material.setImgAddr(updateMaterial.getImgAddr());
			material.setRespondNum(updateMaterial.getRespondNum());
			material.setCreateId(updateMaterial.getCreateId());
			AssertUtils.notUpdateMoreThanOne(materialDao.updateByPrimaryKeySelective(material));
			UpdateMaterialReturn updateMaterialReturn = new UpdateMaterialReturn();

			logger.debug("updateMaterial(UpdateMaterial) - end - return value={}", updateMaterialReturn); //$NON-NLS-1$
			return updateMaterialReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("素材中心表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_UPDATE_ERROR,"素材中心表信息更新错误！",e);
		}
	}


	/**
	 * 方法说明：查询素材中心表信息.
	 *
	 * @param findMaterial the find material
	 * @return the find material return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public FindMaterialReturn findMaterial(
			FindMaterial findMaterial) throws TsfaServiceException {
		logger.debug("findMaterial(FindMaterial findMaterial={}) - start", findMaterial); //$NON-NLS-1$

		AssertUtils.notNull(findMaterial);
		AssertUtils.notAllNull(findMaterial.getCode(),"code不能为空");
		try {
			Material material = materialDao.selectByPrimaryKey(findMaterial.getCode());
			//FindMaterialPage findMaterialPage=new FindMaterialPage();
			//findMaterialPage.setTitle(findMaterial.getTitle());
			//int count=materialDao.findMaterialPageCount(findMaterialPage);
			FindMaterialReturn findMaterialReturn = new FindMaterialReturn();
			//find数据录入
			findMaterialReturn.setCode(material.getCode());
			findMaterialReturn.setMerchantNo(material.getMerchantNo());
			findMaterialReturn.setMemberNoGm(material.getMemberNoGm());
			findMaterialReturn.setMemberNameGm(material.getMemberNameGm());
			findMaterialReturn.setMaterialTypeCode(material.getMaterialTypeCode());
			findMaterialReturn.setMaterialTypeName(material.getMaterialTypeName());
			findMaterialReturn.setTitle(material.getTitle());
			findMaterialReturn.setContent(material.getContent());
			findMaterialReturn.setBrief(material.getBrief());
			findMaterialReturn.setImgAddr(material.getImgAddr());
			findMaterialReturn.setRespondNum(material.getRespondNum());
			findMaterialReturn.setCreateId(material.getCreateId());
			findMaterialReturn.setLinkUrl(material.getLinkUrl());
			//findMaterialReturn.setCreateDate(material.getCreateDate());
			//findMaterialReturn.setCount(count);
			logger.debug("findMaterial(FindMaterial) - end - return value={}", findMaterialReturn); //$NON-NLS-1$
			return  findMaterialReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找素材中心表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_FIND_ERROR,"查找素材中心表信息信息错误！",e);
		}


	}

	/**
	 * 方法说明：分页查询素材中心表信息.
	 *
	 * @param findMaterialPage the find material page
	 * @return the page< find material page return>
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public Page<FindMaterialPageReturn> findMaterialPage(
			FindMaterialPage findMaterialPage)
					throws TsfaServiceException {
		logger.debug("findMaterialPage(FindMaterialPage findMaterialPage={}) - start", findMaterialPage); //$NON-NLS-1$

		AssertUtils.notNull(findMaterialPage);
		List<FindMaterialPageReturn> returnList;
		int count = 0;
		try {
			returnList = materialDao.findMaterialPage(findMaterialPage);
			count = materialDao.findMaterialPageCount(findMaterialPage);
		}  catch (Exception e) {
			logger.error("素材中心表信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_FIND_PAGE_ERROR,"素材中心表信息不存在错误.！",e);
		}
		Page<FindMaterialPageReturn> returnPage = new Page<FindMaterialPageReturn>(returnList, count, findMaterialPage);

		logger.debug("findMaterialPage(FindMaterialPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 

	/**
	 * 方法说明：查询数量.
	 *
	 * @param findMaterialPage the find material page
	 * @return the int
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 罗书明 CreateDate: 2017年6月22日
	 */
	public int findMaterialPageCount(FindMaterialPage findMaterialPage)	throws TsfaServiceException{
		logger.debug("findMaterialPageCount(FindMaterialPage findMaterialPage={}) - start", findMaterialPage);

		try {			 
			return materialDao.findMaterialPageCount(findMaterialPage);
		}  catch (TsfaServiceException e) {
			logger.error("素材中心表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_FIND_PAGE_ERROR,"素材中心表信息分页查询错误.！",e);
		}

	}

	/**
	 * 方法说明：根据类型查找标题.
	 *
	 * @param materialTypeName the material type name
	 * @return the material
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 罗书明 CreateDate: 2017年6月22日
	 */
	public Material selectByTypeName(String materialTypeName) throws TsfaServiceException{
		logger.debug("delMaterial(DelMaterial delMaterial={}) - start", materialTypeName); 

		AssertUtils.notNull(materialTypeName);
		try{
			return  materialDao.selectByTypeName(materialTypeName);
		}catch(TsfaServiceException e) {
			logger.error("素材中心表类型标题信息不存在",e);
			throw new TsfaServiceException(ErrorCode.MATERIALTYPENAME_NOT_EXIST_ERROR,"素材中心表类型标题信息不存在.！",e);
		}
	}


	@Override
	public Page<FindMaterialAppPageReturn> findMaterialAppPage(FindMaterialAppPage findMaterialAppPage)
			throws TsfaServiceException {
		logger.debug("findMaterialAppPage(FindMaterialAppPage findMaterialAppPage={}) - start", findMaterialAppPage); //$NON-NLS-1$

		AssertUtils.notNull(findMaterialAppPage);
		List<FindMaterialAppPageReturn> returnList;
		int count = 0;
		try {
			//String uploadUrl =  localCacheSystemParams.getSystemParam(SystemAliasName.ms.toString(), SystemParamConstant.UPLOAD_GROUP, SystemParamConstant.UPLOAD_URL);
			returnList = materialDao.findMaterialAppPage(findMaterialAppPage);
			for (int i = 0; i < returnList.size(); i++) {
				FindMaterialAppPageReturn findMaterialAppPageReturn = returnList.get(i);
				if ("COMMEN".equals(findMaterialAppPageReturn.getCommenMaterial())) {
					/*外部连接为空，访问自己的H5*/
					if(StringUtils.isNullOrEmpty(findMaterialAppPageReturn.getLinkUrl())){
						findMaterialAppPageReturn.setUrlH5("oms-web/a/business/materialcommen/viewH5?code=" + findMaterialAppPageReturn.getCode());
					}else{
						findMaterialAppPageReturn.setUrlH5(findMaterialAppPageReturn.getLinkUrl());
					}
				}
				else {
					/*外部连接为空，访问自己的H5*/
					if(StringUtils.isNullOrEmpty(findMaterialAppPageReturn.getLinkUrl())){
						findMaterialAppPageReturn.setUrlH5("oms-web/a/business/material/viewH5?code=" + findMaterialAppPageReturn.getCode());
					}else{
						findMaterialAppPageReturn.setUrlH5(findMaterialAppPageReturn.getLinkUrl());
					}
				}
			}
			count = materialDao.findMaterialAppPageCount(findMaterialAppPage);
		} catch (Exception e) {
			logger.error("素材中心表信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_FIND_PAGE_ERROR, "素材中心表信息不存在错误.！", e);
		}
		Page<FindMaterialAppPageReturn> returnPage = new Page<FindMaterialAppPageReturn>(returnList, count,
				findMaterialAppPage);

		logger.debug("findMaterialAppPage(FindMaterialAppPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	@Override
	public FindMaterialPageReturn findMaterialByCode(String code) {
		AssertUtils.notNull(code);
		return materialDao.findMaterialByCode(code);
	}

	@Override
	public int countMaterialSelective(CountMaterialDto countMaterialDto) {
		AssertUtils.notNull(countMaterialDto);
		return materialDao.countMaterialSelective(countMaterialDto);
	}

	@Override
	public List<GeneratorMaterialTotalReturn> generatorMaterialTotal(String merchantNo) {
		return materialDao.generatorMaterialTotal(merchantNo);
	}

	@Override
	public long getMaterialResponseTotal(String merchantNo) {
		return materialDao.getMaterialResponseTotal(merchantNo);
	}

	@Override
	public AddMaterialReturn addMaterialEc(AddMaterial addMaterial) throws TsfaServiceException {
		logger.debug("addMaterial(AddMaterial addMaterial={}) - start", addMaterial);
		AssertUtils.notNull(addMaterial);
		
		try {
			Material material = new Material();
			material.setCode(GUID.getPreUUID());
			material.setMerchantNo(addMaterial.getMerchantNo());
			material.setMemberNoGm(addMaterial.getMemberNoGm());
			// 判断是否有名字传进来
			material.setMemberNameGm(addMaterial.getMemberNameGm());
			// 从素材类型里获取类型code与名称
			material.setMaterialTypeCode(addMaterial.getMaterialTypeCode());
			material.setMaterialTypeName(addMaterial.getMaterialTypeName());
			material.setTitle(addMaterial.getTitle());
			material.setContent(addMaterial.getContent());
			material.setBrief(addMaterial.getBrief());
			material.setImgAddr(addMaterial.getImgAddr());
			material.setRespondNum(addMaterial.getRespondNum());
			material.setCreateId(addMaterial.getCreateId());
			material.setLinkUrl(addMaterial.getLinkUrl());
			material.setCreateDate(new Date());
			materialDao.insertSelective(material);
			
			// 增加类型总数
			materialTypeService.incrementTypeCountByPrimaryKey(material.getMaterialTypeCode(), 1);
			
			AddMaterialReturn addMaterialReturn = new AddMaterialReturn();
			addMaterialReturn.setCode(material.getCode());
			
			logger.debug("addMaterial(AddMaterial) - end - return value={}", addMaterialReturn);
			return addMaterialReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增素材中心表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_ADD_ERROR, "新增素材中心表信息错误！", e);
		}
	}

	@Override
	public List<FindMaterialPageReturn> findMaterials(FindMaterialPage findMaterialPage) throws TsfaServiceException {
		logger.debug("findMaterialPage(FindMaterialPage findMaterialPage={}) - start", findMaterialPage); //$NON-NLS-1$

		AssertUtils.notNull(findMaterialPage);
		List<FindMaterialPageReturn> returnList;
		try {
			returnList = materialDao.findMaterials(findMaterialPage);
		}  catch (Exception e) {
			logger.error("素材中心表信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_FIND_PAGE_ERROR,"素材中心表信息不存在错误.！",e);
		}
		logger.debug("findMaterialPage(FindMaterialPage) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnList;
	}
}



