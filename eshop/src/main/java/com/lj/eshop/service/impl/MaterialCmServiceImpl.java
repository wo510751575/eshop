package com.lj.eshop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.dto.AddMaterial;
import com.lj.business.cm.dto.AddMaterialCommen;
import com.lj.business.cm.dto.AddMaterialCommenReturn;
import com.lj.business.cm.dto.AddMaterialReturn;
import com.lj.business.cm.dto.DelMaterial;
import com.lj.business.cm.dto.DelMaterialCommen;
import com.lj.business.cm.dto.FindMaterialCommenPage;
import com.lj.business.cm.dto.FindMaterialCommenPageReturn;
import com.lj.business.cm.dto.FindMaterialPage;
import com.lj.business.cm.dto.FindMaterialPageReturn;
import com.lj.business.cm.dto.FindMaterialType;
import com.lj.business.cm.dto.FindMaterialTypeReturn;
import com.lj.business.cm.dto.UpdateMaterialCommen;
import com.lj.business.cm.service.IMaterialCommenService;
import com.lj.business.cm.service.IMaterialService;
import com.lj.business.cm.service.IMaterialTypeService;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IMaterialCmDao;
import com.lj.eshop.domain.MaterialCm;
import com.lj.eshop.dto.FindMaterialCmPage;
import com.lj.eshop.dto.FindMaterialEcmPage;
import com.lj.eshop.dto.MateriaEcmDto;
import com.lj.eshop.dto.MaterialCmDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.emus.MaterialCmType;
import com.lj.eshop.service.IMaterialCmService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 林进权
 * 
 * 
 *         CreateDate: 2017-08-22
 */
@Service
public class MaterialCmServiceImpl implements IMaterialCmService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MaterialCmServiceImpl.class);

	@Resource
	private IMaterialCmDao materialCmDao;

	@Autowired
	private IMaterialService cmMaterialService;

	@Autowired
	private IMaterialCommenService materialCommenService;
	
	@Autowired
	private IMaterialTypeService materialTypeService;
	
	@Override
	public void addMaterialCm(MaterialCmDto materialCmDto) throws TsfaServiceException {
		logger.debug("addMaterialCm(AddMaterialCm addMaterialCm={}) - start", materialCmDto);

		AssertUtils.notNull(materialCmDto);
		try {
			MaterialCm materialCm = new MaterialCm();
			// add数据录入
//			materialCm.setCode(GUID.getPreUUID());
			materialCm.setCode(materialCmDto.getCmMaterialCode());
			materialCm.setCmMaterialCode(materialCmDto.getCmMaterialCode());
			materialCm.setProductCode(materialCmDto.getProductCode());
			materialCm.setProductName(materialCmDto.getProductName());
			materialCm.setType(materialCmDto.getType());
			materialCm.setChoicenessCode(materialCmDto.getChoicenessCode());
			materialCm.setShopCode(materialCmDto.getShopCode());
			materialCm.setMerchantCode(materialCmDto.getMerchantCode());
			materialCm.setCreateTime(new Date());
			materialCm.setMaterialTypeCode(materialCmDto.getMaterialTypeCode());
			materialCmDao.insert(materialCm);
			logger.debug("addMaterialCm(MaterialCmDto) - end - return");
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增CM素材关联信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_CM_ADD_ERROR, "新增CM素材关联信息信息错误！", e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：不分页查询CM素材关联信息信息
	 *
	 * @param findMaterialCmPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017年07月10日
	 *
	 */
	public List<MaterialCmDto> findMaterialCms(FindMaterialCmPage findMaterialCmPage) throws TsfaServiceException {
		AssertUtils.notNull(findMaterialCmPage);
		List<MaterialCmDto> returnList = null;
		try {
			returnList = materialCmDao.findMaterialCms(findMaterialCmPage);
		} catch (Exception e) {
			logger.error("查找CM素材关联信息信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_CM_NOT_EXIST_ERROR, "CM素材关联信息信息不存在");
		}
		return returnList;
	}

	@Override
	public void updateMaterialCm(MaterialCmDto materialCmDto) throws TsfaServiceException {
		logger.debug("updateMaterialCm(MaterialCmDto materialCmDto={}) - start", materialCmDto); //$NON-NLS-1$

		AssertUtils.notNull(materialCmDto);
		AssertUtils.notNullAndEmpty(materialCmDto.getCode(), "Code不能为空");
		try {
			MaterialCm materialCm = new MaterialCm();
			// update数据录入
			materialCm.setCode(materialCmDto.getCode());
			materialCm.setCmMaterialCode(materialCmDto.getCmMaterialCode());
			materialCm.setProductCode(materialCmDto.getProductCode());
			materialCm.setType(materialCmDto.getType());
			materialCm.setChoicenessCode(materialCmDto.getChoicenessCode());
			materialCm.setShopCode(materialCmDto.getShopCode());
			materialCm.setProductName(materialCmDto.getProductName());
			materialCm.setMerchantCode(materialCmDto.getMerchantCode());
			materialCm.setMaterialTypeCode(materialCmDto.getMaterialTypeCode());
			AssertUtils.notUpdateMoreThanOne(materialCmDao.updateByPrimaryKeySelective(materialCm));
			logger.debug("updateMaterialCm(MaterialCmDto) - end - return"); //$NON-NLS-1$
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("CM素材关联信息信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_CM_UPDATE_ERROR, "CM素材关联信息信息更新信息错误！", e);
		}
	}

	@Override
	public MaterialCmDto findMaterialCm(MaterialCmDto materialCmDto) throws TsfaServiceException {
		logger.debug("findMaterialCm(FindMaterialCm findMaterialCm={}) - start", materialCmDto); //$NON-NLS-1$

		AssertUtils.notNull(materialCmDto);
		AssertUtils.notAllNull(materialCmDto.getCode(), "Code不能为空");
		try {
			MaterialCm materialCm = materialCmDao.selectByPrimaryKey(materialCmDto.getCode());
			if (materialCm == null) {
				return null;
				// throw new
				// TsfaServiceException(ErrorCode.MATERIAL_CM_NOT_EXIST_ERROR,"CM素材关联信息信息不存在");
			}
			MaterialCmDto findMaterialCmReturn = new MaterialCmDto();
			// find数据录入
			findMaterialCmReturn.setCode(materialCm.getCode());
			findMaterialCmReturn.setCmMaterialCode(materialCm.getCmMaterialCode());
			findMaterialCmReturn.setProductCode(materialCm.getProductCode());
			findMaterialCmReturn.setProductName(materialCm.getProductName());
			findMaterialCmReturn.setType(materialCm.getType());
			findMaterialCmReturn.setChoicenessCode(materialCm.getChoicenessCode());
			findMaterialCmReturn.setShopCode(materialCm.getShopCode());
			findMaterialCmReturn.setMerchantCode(materialCm.getMerchantCode());
			findMaterialCmReturn.setMaterialTypeCode(materialCm.getMaterialTypeCode());
			logger.debug("findMaterialCm(MaterialCmDto) - end - return value={}", findMaterialCmReturn); //$NON-NLS-1$
			return findMaterialCmReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找CM素材关联信息信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_CM_FIND_ERROR, "查找CM素材关联信息信息信息错误！", e);
		}

	}

	@Override
	public Page<MaterialCmDto> findMaterialCmPage(FindMaterialCmPage findMaterialCmPage) throws TsfaServiceException {
		logger.debug("findMaterialCmPage(FindMaterialCmPage findMaterialCmPage={}) - start", findMaterialCmPage); //$NON-NLS-1$

		AssertUtils.notNull(findMaterialCmPage);
		
		List<MaterialCmDto> returnList = null;
		int count = 0;
		try {
			returnList = materialCmDao.findMaterialCmPage(findMaterialCmPage);
			count = materialCmDao.findMaterialCmPageCount(findMaterialCmPage);
		} catch (Exception e) {
			logger.error("CM素材关联信息信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_CM_FIND_PAGE_ERROR, "CM素材关联信息信息不存在错误.！", e);
		}
		Page<MaterialCmDto> returnPage = new Page<MaterialCmDto>(returnList, count, findMaterialCmPage);

		logger.debug("findMaterialCmPage(FindMaterialCmPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	@Override
	public Page<MateriaEcmDto> findCmMaterialPgae(FindMaterialEcmPage findMaterialEcmPage) throws TsfaServiceException {
		logger.debug("findCmMaterialPgae(FindMaterialReturnPage findMaterialReturnPage={}) - start", findMaterialEcmPage); //$NON-NLS-1$
		
		AssertUtils.notNull(findMaterialEcmPage);
		AssertUtils.notNull(findMaterialEcmPage.getParam().getMerchantCode(), "商户Code不能为空");
//		AssertUtils.notNull(findMaterialEcmPage.getParam().getShopCode(), "商店Code不能为空");
		
		FindMaterialCmPage findMaterialCmPage = new FindMaterialCmPage();
		findMaterialCmPage.setStart(findMaterialEcmPage.getStart());
		findMaterialCmPage.setLimit(findMaterialEcmPage.getLimit());
		findMaterialCmPage.setParam(findMaterialEcmPage.getParam());
		
		Page<MaterialCmDto>  page = findMaterialCmPage(findMaterialCmPage);
		List<MaterialCmDto> materialCmDtos = new ArrayList<MaterialCmDto>();
		materialCmDtos.addAll(page.getRows());
		
		List<MateriaEcmDto> materialReturnDtos = reBuildMaterials(materialCmDtos);
		
	    Page<MateriaEcmDto> pageMaterial = new Page<MateriaEcmDto>(materialReturnDtos, page.getTotal(), page.getStart(), page.getLimit());
	    logger.debug("findCmMaterialPgae(FindMaterialCmPage) - end - return value={}", pageMaterial); //$NON-NLS-1$
		return pageMaterial;
	}

	private List<MateriaEcmDto> reBuildMaterials(List<MaterialCmDto> materialCmDtos) {
		List<MateriaEcmDto> list = new ArrayList<MateriaEcmDto>();
		if(materialCmDtos.size()>0) {
			List<String> codes = new ArrayList<String>();
			for (MaterialCmDto materialCmDto : materialCmDtos) {
				codes.add(materialCmDto.getCmMaterialCode());
			}
			
			FindMaterialPage findMaterialPage = new FindMaterialPage();
			findMaterialPage.setCodes(codes);
			List<FindMaterialPageReturn>  findMaterialPageReturns = cmMaterialService.findMaterials(findMaterialPage);
			if(findMaterialPageReturns.size()>0) {
				Map<String, FindMaterialPageReturn> findMaterialPageReturnMap = new HashMap<String, FindMaterialPageReturn>();
				for (FindMaterialPageReturn findMaterialPageReturn : findMaterialPageReturns) {
					findMaterialPageReturnMap.put(findMaterialPageReturn.getCode(), findMaterialPageReturn);
				}
				
				
				for (MaterialCmDto materialCmDto : materialCmDtos) {
					MateriaEcmDto returnDto = new MateriaEcmDto();
					FindMaterialPageReturn sourceMaterial = findMaterialPageReturnMap.get(materialCmDto.getCmMaterialCode());
					if(null!=sourceMaterial) {
						BeanUtils.copyProperties(sourceMaterial, returnDto);
						returnDto.setType(materialCmDto.getType());
						returnDto.setMaterialCmCode(materialCmDto.getCmMaterialCode());
						returnDto.setCmMaterialCode(materialCmDto.getCmMaterialCode());
						returnDto.setCode(materialCmDto.getCode());
						returnDto.setProductCode(materialCmDto.getProductCode());
						returnDto.setProductName(materialCmDto.getProductName());
						returnDto.setChoicenessCode(materialCmDto.getChoicenessCode());
						returnDto.setCreateDate(materialCmDto.getCreateTime());
						list.add(returnDto);
					}
				}
			}
		}
		return list;
	}

	@Override
	public Page<MateriaEcmDto> findCmCommonMaterialPgae(FindMaterialEcmPage findMaterialEcmPage)
			throws TsfaServiceException {
		logger.debug("findCmCommonMaterialPgae(FindMaterialReturnPage findMaterialReturnPage)={}) - start", findMaterialEcmPage); //$NON-NLS-1$
		
		AssertUtils.notNull(findMaterialEcmPage);
		AssertUtils.notNull(findMaterialEcmPage.getParam().getMerchantCode(), "商户Code不能为空");
		
		FindMaterialCmPage findMaterialCmPage = new FindMaterialCmPage();
		findMaterialCmPage.setStart(findMaterialEcmPage.getStart());
		findMaterialCmPage.setLimit(findMaterialEcmPage.getLimit());
		MaterialCmDto findMaterialCmDto = findMaterialEcmPage.getParam();
		findMaterialCmDto.setType(MaterialCmType.PUBLIC.getValue());
//		materialCmDto.setMerchantCode(findMaterialReturnPage.getMerchantCode());
//		if(null!=findMaterialReturnPage.getParam()) {
//			materialCmDto.setProductName(findMaterialReturnPage.getParam().getProductName());
//		}
		findMaterialCmPage.setParam(findMaterialCmDto);
		
		Page<MaterialCmDto>  page = findMaterialCmPage(findMaterialCmPage);
		List<MaterialCmDto> materialCmDtos = new ArrayList<MaterialCmDto>();
		materialCmDtos.addAll(page.getRows());
		
		List<MateriaEcmDto> materialReturnDtos = reBuildCommonMaterials(materialCmDtos);
	    Page<MateriaEcmDto> pageMaterial = new Page<MateriaEcmDto>(materialReturnDtos, page.getTotal(), page.getStart(), page.getLimit());
	    logger.debug("findCmCommonMaterialPgae(FindMaterialReturnPage findMaterialReturnPage) - end - return value={}", pageMaterial); //$NON-NLS-1$
		return pageMaterial;
	}

	private List<MateriaEcmDto> reBuildCommonMaterials(List<MaterialCmDto> materialCmDtos) {
		List<MateriaEcmDto> list = new ArrayList<MateriaEcmDto>();
		if(materialCmDtos.size()>0) {
//			for (MaterialCmDto materialCmDto : materialCmDtos) {
//				FindMaterialCommen findMaterialCommen = new FindMaterialCommen();
//				findMaterialCommen.setCode(materialCmDto.getCmMaterialCode());
//				try {
//					FindMaterialCommenReturn sourceCommon  = materialCommenService.findMaterialCommen(findMaterialCommen);
//					MateriaEcmDto returnDto = new MateriaEcmDto();
//					BeanUtils.copyProperties(sourceCommon, returnDto);
//					materialCmDto.setType(MaterialCmType.PUBLIC.getValue());
//					returnDto.setMaterialCmCode(materialCmDto.getCmMaterialCode());
//					returnDto.setCmMaterialCode(materialCmDto.getCmMaterialCode());
//					returnDto.setCode(materialCmDto.getCode());
//					returnDto.setCreateDate(materialCmDto.getCreateTime());
//					returnDto.setProductCode(materialCmDto.getProductCode());
//					returnDto.setProductName(materialCmDto.getProductName());
//					list.add(returnDto);
//				} catch (Exception e) {
//				}
//			}
			List<String> codes = new ArrayList<String>();
			for (MaterialCmDto materialCmDto : materialCmDtos) {
				codes.add(materialCmDto.getCmMaterialCode());
			}
			
			FindMaterialCommenPage findMaterialCommenPage = new FindMaterialCommenPage();
			findMaterialCommenPage.setCodes(codes);
			FindMaterialPage findMaterialPage = new FindMaterialPage();
			findMaterialPage.setCodes(codes);
			List<FindMaterialCommenPageReturn>  findMaterialPageReturns = materialCommenService.findMaterialCommenList(findMaterialCommenPage);
			if(findMaterialPageReturns.size()>0) {
				Map<String, FindMaterialCommenPageReturn> findMaterialPageReturnMap = new HashMap<String, FindMaterialCommenPageReturn>();
				for (FindMaterialCommenPageReturn findMaterialPageReturn : findMaterialPageReturns) {
					findMaterialPageReturnMap.put(findMaterialPageReturn.getCode(), findMaterialPageReturn);
				}
				
				
				for (MaterialCmDto materialCmDto : materialCmDtos) {
					MateriaEcmDto returnDto = new MateriaEcmDto();
					FindMaterialCommenPageReturn sourceMaterial = findMaterialPageReturnMap.get(materialCmDto.getCmMaterialCode());
					if(null!=sourceMaterial) {
						BeanUtils.copyProperties(sourceMaterial, returnDto);
						returnDto.setType(materialCmDto.getType());
						returnDto.setMaterialCmCode(materialCmDto.getCmMaterialCode());
						returnDto.setCmMaterialCode(materialCmDto.getCmMaterialCode());
						returnDto.setCode(materialCmDto.getCode());
						returnDto.setProductCode(materialCmDto.getProductCode());
						returnDto.setProductName(materialCmDto.getProductName());
						returnDto.setChoicenessCode(materialCmDto.getChoicenessCode());
						returnDto.setCreateDate(materialCmDto.getCreateTime());
						list.add(returnDto);
					}
				}
			}
		}
		return list;
	}

	@Override
	public void delMaterial(MaterialCmDto materialCmDto) throws TsfaServiceException {
		logger.debug("delMaterial(MaterialCmDto materialCmDto)={}) - start", materialCmDto);
		
		AssertUtils.notNull(materialCmDto);
		AssertUtils.notAllNull(materialCmDto.getCode(), "Code不能为空");
		
		try {
			materialCmDao.deleteByPrimaryKey(materialCmDto.getCode());
			logger.debug("delMaterial(MaterialCmDto materialCmDto)={}) - end"); 
		} catch (Exception e) {
			
		}
	}
	@Override
	public void delCmMaterial(MaterialCmDto materialCmDto) throws TsfaServiceException {
		logger.debug("delMaterial(MaterialCmDto materialCmDto)={}) - start", materialCmDto);
		
		AssertUtils.notNull(materialCmDto);
		AssertUtils.notAllNull(materialCmDto.getCode(), "Code不能为空");
		
		try {
			MaterialCmDto rltMaterial = findMaterialCm(materialCmDto);
			
			//删除个人素材
			DelMaterial delMaterial = new DelMaterial();
			delMaterial.setCode(rltMaterial.getCode());
			cmMaterialService.delMaterial(delMaterial);
			
			
			//删除关连的个人素材
			delMaterial(materialCmDto);
			
			// 减少类型总数
			materialTypeService.decrementTypeCountByPrimaryKey(rltMaterial.getMaterialTypeCode(), 1);
						
			logger.debug("delMaterial(MaterialCmDto materialCmDto)={}) - end"); 
		} catch (Exception e) {
			
		}
	}
	
	@Override
	public void delCommonMaterial(MaterialCmDto materialCmDto) throws TsfaServiceException {
		logger.debug("delMaterial(MaterialCmDto materialCmDto)={}) - start", materialCmDto);
		
		AssertUtils.notNull(materialCmDto);
		AssertUtils.notAllNull(materialCmDto.getCode(), "Code不能为空");
		
		try {
			
			MaterialCmDto rltMaterial = findMaterialCm(materialCmDto);
			
			//删除公共素材
			DelMaterialCommen delMaterialCommen = new DelMaterialCommen();
			delMaterialCommen.setCode(rltMaterial.getCmMaterialCode());
			materialCommenService.delMaterialCommen(delMaterialCommen);
			
			//清除卖家素材关联的精选素材
			FindMaterialCmPage findMaterialCmPage = new FindMaterialCmPage();
			MaterialCmDto findMaterialCmPageParam = new MaterialCmDto();
			findMaterialCmPageParam.setChoicenessCode(rltMaterial.getCode());
			findMaterialCmPage.setParam(findMaterialCmPageParam);
			List<MaterialCmDto> materialCmDtos = findMaterialCms(findMaterialCmPage);
			if(materialCmDtos.size()>0) {
				MaterialCm target = new MaterialCm();
				BeanUtils.copyProperties(materialCmDtos.get(0), target);
				target.setChoicenessCode(null);
				materialCmDao.updateByPrimaryKey(target);
			}
			
			//删除关连的公共素材
			delMaterial(materialCmDto);
			
			// 减少类型总数
			materialTypeService.decrementTypeCountByPrimaryKey(rltMaterial.getMaterialTypeCode(), 1);
			
			logger.debug("delMaterial(MaterialCmDto materialCmDto)={}) - end"); 
		} catch (Exception e) {
			
		}
	}

	@Override
	public void addMaterialSale(MateriaEcmDto addMateriaEcmDto) {
		logger.debug(" addMaterialEs(MaterialReturnDto materialReturnDto) ={}) - start", addMateriaEcmDto); 
		
		AssertUtils.notNull(addMateriaEcmDto);
		AssertUtils.notAllNull(addMateriaEcmDto.getMerchantCode(), "商户Code不能为空");
		AssertUtils.notAllNull(addMateriaEcmDto.getShopCode(), "商店Code不能为空");
		AssertUtils.notAllNull(addMateriaEcmDto.getMemberNoGm(), "卖家Code不能为空");
//		AssertUtils.notAllNull(materialReturnDto.getProductCode(), "商品Code不能为空");
		
		
		
		
		//素材添加
		AddMaterial addMaterial = new AddMaterial();
		addMaterial.setTitle(addMateriaEcmDto.getTitle());
//		addMaterial.setBrief(materialReturnDto.getBrief());
		addMaterial.setContent(addMateriaEcmDto.getContent());
		addMaterial.setImgAddr(addMateriaEcmDto.getImgAddr());
		addMaterial.setMemberNameGm(addMateriaEcmDto.getMemberNameGm());
		addMaterial.setMemberNoGm(addMateriaEcmDto.getMemberNoGm());
		addMaterial.setMerchantNo(addMateriaEcmDto.getMerchantNo());
		
		//如果有分类类型
		if(StringUtils.isNotEmpty(addMateriaEcmDto.getMaterialTypeCode())) {
			
			FindMaterialType findMaterialType = new FindMaterialType();
			findMaterialType.setCode(addMateriaEcmDto.getMaterialTypeCode());
			FindMaterialTypeReturn findMaterialTypeReturn = materialTypeService.findMaterialType(findMaterialType);
			addMaterial.setMaterialTypeCode(findMaterialTypeReturn.getCode());
			addMaterial.setMaterialTypeName(findMaterialTypeReturn.getTypeName());
		} 

		
		//导购信息
		addMaterial.setMemberNoGm(addMateriaEcmDto.getMemberNoGm());
		addMaterial.setMemberNameGm(addMateriaEcmDto.getMemberNameGm());
		addMaterial.setMerchantNo(addMateriaEcmDto.getMerchantNo());
		AddMaterialReturn addMatralReturn = cmMaterialService.addMaterialEc(addMaterial);
		
		//插入关联表
		MaterialCmDto materialCmDto = new MaterialCmDto();
		materialCmDto.setCmMaterialCode(addMatralReturn.getCode());
		materialCmDto.setProductCode(addMateriaEcmDto.getProductCode());
		materialCmDto.setProductName(addMateriaEcmDto.getProductName());
		materialCmDto.setType(addMateriaEcmDto.getType());
		materialCmDto.setShopCode(addMateriaEcmDto.getShopCode());
		materialCmDto.setMerchantCode(addMateriaEcmDto.getMerchantCode());
		materialCmDto.setCreateTime(new Date());
		materialCmDto.setMaterialTypeCode(addMaterial.getMaterialTypeCode());
		addMaterialCm(materialCmDto);
		
		logger.debug(" addMaterialEs(MaterialReturnDto materialReturnDto) ={}) - end"); 
	}
	
	
	@Override
	public void addMaterialPub(MateriaEcmDto materialReturnDto) {
		logger.debug(" addMaterialPub(MaterialEcDto materialEcDto) ={}) - start", materialReturnDto);
		
		AssertUtils.notNull(materialReturnDto);
		AssertUtils.notAllNull(materialReturnDto.getMerchantNo(), "商户Code不能为空");
		AssertUtils.notAllNull(materialReturnDto.getCreateId(), "创建人不能为空");
		AssertUtils.notAllNull(materialReturnDto.getProductCode(), "商品Code不能为空");
		
		//插入公共素材
		AddMaterialCommen addMaterial = new AddMaterialCommen();
		BeanUtils.copyProperties(materialReturnDto, addMaterial);
		addMaterial.setCode(GUID.getPreUUID());
		addMaterial.setMerchantNo(materialReturnDto.getMerchantNo());
		addMaterial.setMerchantName(materialReturnDto.getMerchantName());
		addMaterial.setCreateId(materialReturnDto.getCreateId());
		AddMaterialCommenReturn commonReturn = materialCommenService.addMaterialCommen(addMaterial);
		
		//插入关连表
		MaterialCmDto materialCmDto = new MaterialCmDto();
		materialCmDto.setCmMaterialCode(commonReturn.getCode());
		materialCmDto.setType(MaterialCmType.PUBLIC.getValue());
		materialCmDto.setCreateTime(new Date());
		materialCmDto.setMerchantCode(materialReturnDto.getMerchantCode());
		materialCmDto.setProductCode(materialReturnDto.getProductCode());
		materialCmDto.setProductName(materialReturnDto.getProductName());
		materialCmDto.setMaterialTypeCode(addMaterial.getMaterialTypeCode());
		addMaterialCm(materialCmDto);
		logger.debug(" addMaterialPub(MaterialReturnDto materialReturnDto) ={}) - end"); 
	}

	@Override
	public void updBiztypeForPub(MateriaEcmDto materialReturnDto, ShopDto shopDto) {
		logger.debug(" updMaterialPub(MaterialEcDto materialEcDto)={}) - start", materialReturnDto); 
		
		AssertUtils.notNull(materialReturnDto);
		AssertUtils.notAllNull(materialReturnDto.getMerchantNo(), "商户code不能为空");
		AssertUtils.notAllNull(materialReturnDto.getCode(), "电商素材code不能为空");
		
		//增加公共素材
		AddMaterialCommen addMaterialCommen = new AddMaterialCommen();
		BeanUtils.copyProperties(materialReturnDto, addMaterialCommen);
		addMaterialCommen.setRespondNum(0);
		addMaterialCommen.setShopNo(shopDto.getCode());
		addMaterialCommen.setShopName(shopDto.getShopName());
		addMaterialCommen.setMaterialTypeCode(null);
		addMaterialCommen.setMaterialTypeName(null);
		AddMaterialCommenReturn commonReturn = materialCommenService.addMaterialCommen(addMaterialCommen);
		
		//设置电商素材为精选
		MaterialCmDto updCmDto = new MaterialCmDto();
		updCmDto.setChoicenessCode(commonReturn.getCode());
		updCmDto.setCode(materialReturnDto.getCode());
		updateMaterialCm(updCmDto);
		
		MaterialCmDto paramMaterialCmDto = new MaterialCmDto();
		paramMaterialCmDto.setCode(materialReturnDto.getCode());
		MaterialCmDto rltMaterialCmDto = findMaterialCm(paramMaterialCmDto);
		
		//增加公共素材关连信息
		MaterialCmDto materialCmDto = new MaterialCmDto();
		materialCmDto.setCmMaterialCode(commonReturn.getCode());
		materialCmDto.setType(MaterialCmType.PUBLIC.getValue());
		materialCmDto.setCreateTime(new Date());
		materialCmDto.setMerchantCode(materialReturnDto.getMerchantCode());
		materialCmDto.setProductCode(rltMaterialCmDto.getProductCode());
		materialCmDto.setProductName(rltMaterialCmDto.getProductName());
//		materialCmDto.setMaterialTypeCode(rltCmDto.getMaterialTypeCode());
		addMaterialCm(materialCmDto);
		
		logger.debug(" updBiztypeForPub(MaterialEcDto materialEcDto)={}) - end");
	}

	@Override
	public void updMaterialPub(MateriaEcmDto materialReturnDto) {
		logger.debug(" updMaterialPub(MaterialEcDto materialEcDto)={}) - start", materialReturnDto); 
		AssertUtils.notNull(materialReturnDto);
		AssertUtils.notAllNull(materialReturnDto.getCode(), "公共素材code不能为空");
		AssertUtils.notAllNull(materialReturnDto.getProductCode(), "商品不能为空");
		
		//公共素材更新
		UpdateMaterialCommen updateMaterial = new UpdateMaterialCommen();
		BeanUtils.copyProperties(materialReturnDto, updateMaterial);
		materialCommenService.updateMaterialCommen(updateMaterial);
		
		//更新关连表
		MaterialCmDto materialCmDto = new MaterialCmDto();
		materialCmDto.setCode(materialReturnDto.getMaterialCmCode());
		materialCmDto.setProductCode(materialReturnDto.getProductCode());
		materialCmDto.setProductName(materialReturnDto.getProductName());
		materialCmDto.setMaterialTypeCode(updateMaterial.getMaterialTypeCode());
		updateMaterialCm(materialCmDto);
		logger.debug(" updMaterialPub(MaterialEcDto materialEcDto)={}) - end");
	}

	@Override
	public MateriaEcmDto findMaterialEcm(MateriaEcmDto findMateriaEcmDto) {
		logger.debug(" findMaterialEcm(MateriaEcmDto findMateriaEcmDto)={}) - start", findMateriaEcmDto);
		AssertUtils.notNull(findMateriaEcmDto);
		AssertUtils.notAllNull(findMateriaEcmDto.getCode(), "素材code不能为空");
		
		MaterialCmDto findMaterialCmDto = new MaterialCmDto();
		findMaterialCmDto.setCode(findMateriaEcmDto.getCode());
		MateriaEcmDto commonTarget = new MateriaEcmDto();
		try {
			MaterialCmDto materialCm = findMaterialCm(findMaterialCmDto);
			if(null==materialCm) {
				findMaterialCmDto.setCode(null);
				findMaterialCmDto.setCmMaterialCode(findMateriaEcmDto.getCode());
				FindMaterialCmPage findMaterialCmPage = new FindMaterialCmPage();
				findMaterialCmPage.setParam(findMaterialCmDto);
				List<MaterialCmDto> list = findMaterialCms(findMaterialCmPage);
				materialCm = list.get(0);
			}
			
			if(StringUtils.equal(materialCm.getType(), MaterialCmType.PUBLIC.getValue())) {
				FindMaterialCommenPageReturn findMaterialCommenReturn = materialCommenService.findMaterialCommenByCode(materialCm.getCmMaterialCode());
				BeanUtils.copyProperties(findMaterialCommenReturn, commonTarget);
				
			} else {
				//查询素材表
				FindMaterialPageReturn sourceMaterial = cmMaterialService .findMaterialByCode(materialCm.getCmMaterialCode());
				BeanUtils.copyProperties(sourceMaterial, commonTarget);
				
			}
			
			commonTarget.setType(materialCm.getType());
			commonTarget.setMaterialCmCode(materialCm.getCmMaterialCode());
			commonTarget.setCmMaterialCode(materialCm.getCmMaterialCode());
			commonTarget.setCode(materialCm.getCode());
			commonTarget.setProductCode(materialCm.getProductCode());
			commonTarget.setProductName(materialCm.getProductName());
			commonTarget.setChoicenessCode(materialCm.getChoicenessCode());
			commonTarget.setShopCode(materialCm.getShopCode());
			commonTarget.setMerchantCode(materialCm.getMerchantCode());
			commonTarget.setMaterialTypeCode(materialCm.getMaterialTypeCode());
			
		} catch (Exception e) {
			logger.error("CM素材关联信息信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.MATERIAL_CM_FIND_PAGE_ERROR, "CM素材关联信息信息不存在错误.！", e);
		}
		logger.debug(" findMaterialEcm(MateriaEcmDto findMateriaEcmDto)={}) - end", commonTarget);
		return commonTarget;
	}

	
}
