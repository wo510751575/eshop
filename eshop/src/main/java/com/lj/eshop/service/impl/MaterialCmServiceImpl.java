package com.lj.eshop.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.lj.business.cm.dto.FindMaterial;
import com.lj.business.cm.dto.FindMaterialCommen;
import com.lj.business.cm.dto.FindMaterialCommenReturn;
import com.lj.business.cm.dto.FindMaterialPageReturn;
import com.lj.business.cm.dto.FindMaterialReturn;
import com.lj.business.cm.dto.FindMaterialType;
import com.lj.business.cm.dto.FindMaterialTypePage;
import com.lj.business.cm.dto.FindMaterialTypePageReturn;
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
	public Page<MateriaEcmDto> findCmMaterialPgae(FindMaterialEcmPage findMaterialReturnPage) throws TsfaServiceException {
		logger.debug("findCmMaterialPgae(FindMaterialReturnPage findMaterialReturnPage={}) - start", findMaterialReturnPage); //$NON-NLS-1$
		
		AssertUtils.notNull(findMaterialReturnPage);
		AssertUtils.notAllNull(findMaterialReturnPage.getMerchantCode(), "商户Code不能为空");
		AssertUtils.notAllNull(findMaterialReturnPage.getShopCode(), "商店Code不能为空");
		
		FindMaterialCmPage findMaterialCmPage = new FindMaterialCmPage();
		findMaterialCmPage.setStart(findMaterialReturnPage.getStart());
		findMaterialCmPage.setLimit(findMaterialReturnPage.getLimit());
		MaterialCmDto materialCmDto = new MaterialCmDto();
		materialCmDto.setType(MaterialCmType.SALE.getValue());
		materialCmDto.setMerchantCode(findMaterialReturnPage.getMerchantCode());
		materialCmDto.setShopCode(findMaterialReturnPage.getShopCode());
		if(null!=findMaterialReturnPage.getParam()) {
			materialCmDto.setProductName(findMaterialReturnPage.getParam().getProductName());
		}
		findMaterialCmPage.setParam(materialCmDto);
		
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
			for (MaterialCmDto materialCmDto : materialCmDtos) {
				FindMaterial findMaterial = new FindMaterial();
				findMaterial.setCode(materialCmDto.getCmMaterialCode());
				try {
					FindMaterialReturn sourceMaterial  = cmMaterialService.findMaterial(findMaterial);
					MateriaEcmDto returnDto = new MateriaEcmDto();
					BeanUtils.copyProperties(sourceMaterial, returnDto);
					returnDto.setType(materialCmDto.getType());
					returnDto.setMaterialCmCode(materialCmDto.getCmMaterialCode());
					returnDto.setCmMaterialCode(materialCmDto.getCmMaterialCode());
					returnDto.setCode(materialCmDto.getCode());
					returnDto.setProductCode(materialCmDto.getProductCode());
					returnDto.setProductName(materialCmDto.getProductName());
					returnDto.setChoicenessCode(materialCmDto.getChoicenessCode());
					if(StringUtils.isNotEmpty(materialCmDto.getChoicenessCode())) {
						returnDto.setType(MaterialCmType.CHOICE.getValue());
					}
					returnDto.setCreateDate(materialCmDto.getCreateTime());
					list.add(returnDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public Page<MateriaEcmDto> findCmCommonMaterialPgae(FindMaterialEcmPage findMaterialReturnPage)
			throws TsfaServiceException {
		logger.debug("findCmCommonMaterialPgae(FindMaterialReturnPage findMaterialReturnPage)={}) - start", findMaterialReturnPage); //$NON-NLS-1$
		
		AssertUtils.notNull(findMaterialReturnPage);
		AssertUtils.notAllNull(findMaterialReturnPage.getMerchantCode(), "商户Code不能为空");
		
		FindMaterialCmPage findMaterialCmPage = new FindMaterialCmPage();
		findMaterialCmPage.setStart(findMaterialReturnPage.getStart());
		findMaterialCmPage.setLimit(findMaterialReturnPage.getLimit());
		MaterialCmDto materialCmDto = new MaterialCmDto();
		materialCmDto.setType(MaterialCmType.PUBLIC.getValue());
		materialCmDto.setMerchantCode(findMaterialReturnPage.getMerchantCode());
		if(null!=findMaterialReturnPage.getParam()) {
			materialCmDto.setProductName(findMaterialReturnPage.getParam().getProductName());
		}
		findMaterialCmPage.setParam(materialCmDto);
		
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
			for (MaterialCmDto materialCmDto : materialCmDtos) {
				FindMaterialCommen findMaterialCommen = new FindMaterialCommen();
				findMaterialCommen.setCode(materialCmDto.getCmMaterialCode());
				try {
					FindMaterialCommenReturn sourceCommon  = materialCommenService.findMaterialCommen(findMaterialCommen);
					MateriaEcmDto returnDto = new MateriaEcmDto();
					BeanUtils.copyProperties(sourceCommon, returnDto);
					materialCmDto.setType(MaterialCmType.PUBLIC.getValue());
					returnDto.setMaterialCmCode(materialCmDto.getCmMaterialCode());
					returnDto.setCmMaterialCode(materialCmDto.getCmMaterialCode());
					returnDto.setCode(materialCmDto.getCode());
					returnDto.setCreateDate(materialCmDto.getCreateTime());
					returnDto.setProductCode(materialCmDto.getProductCode());
					returnDto.setProductName(materialCmDto.getProductName());
					list.add(returnDto);
				} catch (Exception e) {
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
			
			MaterialCmDto rltMaterial = findMaterialCm(materialCmDto);
			
			DelMaterial delMaterial = new DelMaterial();
			delMaterial.setCode(rltMaterial.getCmMaterialCode());
			cmMaterialService.delMaterial(delMaterial);
			
			DelMaterialCommen delMaterialCommen = new DelMaterialCommen();
			delMaterialCommen.setCode(rltMaterial.getCmMaterialCode());
			materialCommenService.delMaterialCommen(delMaterialCommen);
			
			materialCmDao.deleteByPrimaryKey(rltMaterial.getCode());
			logger.debug("delMaterial(MaterialCmDto materialCmDto)={}) - end"); 
		} catch (Exception e) {
			
		}
	}

	@Override
	public void addMaterialSale(MateriaEcmDto materialReturnDto) {
		logger.debug(" addMaterialEs(MaterialReturnDto materialReturnDto) ={}) - start", materialReturnDto); 
		
		AssertUtils.notNull(materialReturnDto);
		AssertUtils.notAllNull(materialReturnDto.getMerchantNo(), "商户Code不能为空");
		AssertUtils.notAllNull(materialReturnDto.getShopCode(), "商店Code不能为空");
		AssertUtils.notAllNull(materialReturnDto.getMemberNoGm(), "卖家Code不能为空");
//		AssertUtils.notAllNull(materialReturnDto.getProductCode(), "商品Code不能为空");
		
		
		
		
		//素材添加
		AddMaterial addMaterial = new AddMaterial();
		addMaterial.setTitle(materialReturnDto.getTitle());
//		addMaterial.setBrief(materialReturnDto.getBrief());
		addMaterial.setContent(materialReturnDto.getContent());
		addMaterial.setImgAddr(materialReturnDto.getImgAddr());
		addMaterial.setMemberNameGm(materialReturnDto.getMemberNameGm());
		addMaterial.setMemberNoGm(materialReturnDto.getMemberNoGm());
		addMaterial.setMerchantNo(materialReturnDto.getMerchantNo());
		
		//如果有分类类型
		if(StringUtils.isNotEmpty(materialReturnDto.getMaterialTypeCode())) {
			
			FindMaterialType findMaterialType = new FindMaterialType();
			findMaterialType.setCode(materialReturnDto.getMaterialTypeCode());
			FindMaterialTypeReturn findMaterialTypeReturn = materialTypeService.findMaterialType(findMaterialType);
			addMaterial.setMaterialTypeCode(findMaterialTypeReturn.getCode());
			addMaterial.setMaterialTypeName(findMaterialTypeReturn.getTypeName());
		} else {
			
			//默认分类类型
			FindMaterialTypePage findMaterialTypePage = new FindMaterialTypePage();
			findMaterialTypePage.setMerchantNo(materialReturnDto.getMerchantNo());
			findMaterialTypePage.setMemberNoGm(materialReturnDto.getMemberNoGm());
			List<FindMaterialTypePageReturn> materialTypePageReturns = materialTypeService.findMaterialTypes(findMaterialTypePage);
			if(materialTypePageReturns.size()>0) {
				addMaterial.setMaterialTypeCode(materialTypePageReturns.get(0).getCode());
				addMaterial.setMaterialTypeName(materialTypePageReturns.get(0).getTypeName());
			}
		}
		
		
		//导购信息
//		addMaterial.setMemberNoGm(materialReturnDto.getEcGuildNo());
//		addMaterial.setMemberNameGm(materialReturnDto.getMemberNameGm());
//		addMaterial.setMerchantNo(materialReturnDto.getMerchantNo());
		
		AddMaterialReturn addMatralReturn = cmMaterialService.addMaterialEc(addMaterial);
		
		//插入关联表
		MaterialCmDto materialCmDto = new MaterialCmDto();
		materialCmDto.setCmMaterialCode(addMatralReturn.getCode());
		materialCmDto.setProductCode(materialReturnDto.getProductCode());
		materialCmDto.setProductName(materialReturnDto.getProductName());
		materialCmDto.setType(materialReturnDto.getType());
		materialCmDto.setShopCode(materialReturnDto.getShopCode());
		materialCmDto.setMerchantCode(materialReturnDto.getMerchantNo());
		materialCmDto.setCreateTime(new Date());
		materialCmDto.setMaterialTypeCode(materialReturnDto.getMaterialTypeCode());
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
		materialCmDto.setMerchantCode(materialReturnDto.getMerchantNo());
		materialCmDto.setProductCode(materialReturnDto.getProductCode());
		materialCmDto.setProductName(materialReturnDto.getProductName());
		addMaterialCm(materialCmDto);
		logger.debug(" addMaterialPub(MaterialReturnDto materialReturnDto) ={}) - end"); 
	}


	@Override
	public MateriaEcmDto findMaterialCommen(FindMaterialEcmPage findMaterialReturnPage) {
		logger.debug(" findMaterialCommen(FindMaterialReturnPage findMaterialReturnPage) ={}) - start", findMaterialReturnPage); 
		AssertUtils.notNull(findMaterialReturnPage);
		AssertUtils.notAllNull(findMaterialReturnPage.getCmMaterialCode(), "公共素材code不能为空");
		AssertUtils.notAllNull(findMaterialReturnPage.getMaterialCmCode(), "电商关连code不能为空");
		
		FindMaterialCommen findMaterialCommen = new FindMaterialCommen();
		findMaterialCommen.setCode(findMaterialReturnPage.getCmMaterialCode());
		FindMaterialCommenReturn findMaterialCommenReturn = materialCommenService.findMaterialCommen(findMaterialCommen);
		MateriaEcmDto commonTarget = new MateriaEcmDto(); 
		BeanUtils.copyProperties(findMaterialCommenReturn, commonTarget);
		
		MaterialCmDto paramCmDto = new MaterialCmDto();
		paramCmDto.setCode(findMaterialReturnPage.getMaterialCmCode());
		MaterialCmDto rltMaterialCm = findMaterialCm(paramCmDto);
		commonTarget.setProductCode(rltMaterialCm.getProductCode());
		commonTarget.setProductName(rltMaterialCm.getProductName());
		commonTarget.setMaterialCmCode(rltMaterialCm.getCode());
		commonTarget.setCmMaterialCode(rltMaterialCm.getCmMaterialCode());
		logger.debug(" findMaterialCommen(FindMaterialReturnPage findMaterialReturnPage) ={}) - end");
		return commonTarget;
	}

	@Override
	public MateriaEcmDto findMaterialSale(FindMaterialEcmPage findMaterialReturnPage) {
		logger.debug(" findMaterialSale(FindMaterialReturnPage findMaterialReturnPage) ={}) - start", findMaterialReturnPage); 
		AssertUtils.notNull(findMaterialReturnPage);
		AssertUtils.notAllNull(findMaterialReturnPage.getCmMaterialCode(), "素材code不能为空");
		AssertUtils.notAllNull(findMaterialReturnPage.getMaterialCmCode(), "电商关连code不能为空");
		
		FindMaterialPageReturn sourceMaterial = cmMaterialService .findMaterialByCode(findMaterialReturnPage.getCmMaterialCode());
		
		//查询关连表
		MaterialCmDto paramMaterialCmDto = new MaterialCmDto();
		paramMaterialCmDto.setCode(findMaterialReturnPage.getMaterialCmCode());
		MaterialCmDto materialCmDto = findMaterialCm(paramMaterialCmDto);
		
		//查询素材表
		MateriaEcmDto returnDto = new MateriaEcmDto();
		BeanUtils.copyProperties(sourceMaterial, returnDto);
//		returnDto.setType(MaterialCmType.SALE.getValue());
		returnDto.setType(materialCmDto.getType());
		returnDto.setMaterialCmCode(materialCmDto.getCmMaterialCode());
		returnDto.setCmMaterialCode(materialCmDto.getCmMaterialCode());
		returnDto.setCode(materialCmDto.getCode());
		returnDto.setProductCode(materialCmDto.getProductCode());
		returnDto.setProductName(materialCmDto.getProductName());
		returnDto.setChoicenessCode(materialCmDto.getChoicenessCode());
		if(StringUtils.isNotEmpty(materialCmDto.getChoicenessCode())) {
			returnDto.setType(MaterialCmType.CHOICE.getValue());
		}
		returnDto.setCreateDate(materialCmDto.getCreateTime());
		logger.debug(" findMaterialSale(FindMaterialReturnPage findMaterialReturnPage) ={}) - end");
		return returnDto;
	}

	@Override
	public void updBiztypeForPub(MateriaEcmDto materialReturnDto, ShopDto shopDto) {
		logger.debug(" updMaterialPub(MaterialEcDto materialEcDto)={}) - start", materialReturnDto); 
		
		AssertUtils.notNull(materialReturnDto);
		AssertUtils.notAllNull(materialReturnDto.getMerchantNo(), "商户code不能为空");
		AssertUtils.notAllNull(materialReturnDto.getMaterialCmCode(), "电商素材code不能为空");
		
		//增加公共素材
		AddMaterialCommen addMaterialCommen = new AddMaterialCommen();
		BeanUtils.copyProperties(materialReturnDto, addMaterialCommen);
		addMaterialCommen.setRespondNum(0);
		addMaterialCommen.setShopNo(shopDto.getCode());
		addMaterialCommen.setShopName(shopDto.getShopName());
		AddMaterialCommenReturn commonReturn = materialCommenService.addMaterialCommen(addMaterialCommen);
		
		//设置电商素材为精选
		MaterialCmDto paramCmdto = new MaterialCmDto();
		paramCmdto.setCode(materialReturnDto.getMaterialCmCode());
		MaterialCmDto rltCmDto = findMaterialCm(paramCmdto);
		rltCmDto.setChoicenessCode(commonReturn.getCode());
		updateMaterialCm(rltCmDto);
		
		//增加关连信息
		MaterialCmDto materialCmDto = new MaterialCmDto();
		materialCmDto.setCmMaterialCode(commonReturn.getCode());
		materialCmDto.setType(MaterialCmType.PUBLIC.getValue());
		materialCmDto.setCreateTime(new Date());
		materialCmDto.setMerchantCode(materialReturnDto.getMerchantNo());
		materialCmDto.setProductCode(rltCmDto.getProductCode());
		materialCmDto.setProductName(rltCmDto.getProductName());
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
		updateMaterialCm(materialCmDto);
		logger.debug(" updMaterialPub(MaterialEcDto materialEcDto)={}) - end");
	}

	
}
