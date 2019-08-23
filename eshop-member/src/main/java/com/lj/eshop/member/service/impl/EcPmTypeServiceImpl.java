/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.member.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IPmTypeDao;
import com.lj.business.member.dao.IPmTypePmDao;
import com.lj.business.member.domain.PmType;
import com.lj.business.member.domain.PmTypePm;
import com.lj.business.member.dto.AddPmTypePmDto;
import com.lj.business.member.dto.FindPmType;
import com.lj.business.member.dto.FindPmTypePmReturn;
import com.lj.business.member.dto.FindPmTypeReturn;
import com.lj.eshop.member.service.IEcPmTypeService;

/**
 * 
 * 类说明：
 * todo
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月18日
 */
@Service
public class EcPmTypeServiceImpl implements IEcPmTypeService {
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(EcPmTypeServiceImpl.class);

	/** The pm type dao. */
	@Resource
	private IPmTypeDao pmTypeDao;
	/** The pm type pm dao. */
	@Resource
	private IPmTypePmDao pmTypePmDao;
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#findPmTypeByMP(com.lj.business.member.dto.FindPmType)
	 */
	@Override
	public FindPmTypeReturn findPmTypeByMP(FindPmType findPmType) throws TsfaServiceException {
		logger.debug("findPmTypeByMP(FindPmType findPmType={}) - start", findPmType); //$NON-NLS-1$

		AssertUtils.notNull(findPmType);
		AssertUtils.notAllNull(findPmType.getMerchantNo(),"商户号不能为空");
		AssertUtils.notAllNull(findPmType.getPmTypeType(),"客户分类不能为空");
		try {
			PmType pmType = pmTypeDao.selectByMP(findPmType);
			if(pmType == null){
				//throw new TsfaServiceException(ErrorCode.PM_TYPE_NOT_EXIST_ERROR,"客户分类表信息不存在");
				return null;
			}
			FindPmTypeReturn findPmTypeReturn = new FindPmTypeReturn();
			//find数据录入
			findPmTypeReturn.setCode(pmType.getCode());
			findPmTypeReturn.setMerchantNo(pmType.getMerchantNo());
			findPmTypeReturn.setMemberNo(pmType.getMemberNo());
			findPmTypeReturn.setMemberName(pmType.getMemberName());
			findPmTypeReturn.setTypeName(pmType.getTypeName());
			findPmTypeReturn.setPmTypeType(pmType.getPmTypeType());
			findPmTypeReturn.setPmTypeDim(pmType.getPmTypeDim());
			findPmTypeReturn.setStatus(pmType.getStatus());
			findPmTypeReturn.setCreateId(pmType.getCreateId());
			findPmTypeReturn.setCreateDate(pmType.getCreateDate());
			findPmTypeReturn.setRemark(pmType.getRemark());
			findPmTypeReturn.setRemark2(pmType.getRemark2());
			findPmTypeReturn.setRemark3(pmType.getRemark3());
			findPmTypeReturn.setRemark4(pmType.getRemark4());
			findPmTypeReturn.setFreValue(pmType.getFreValue());
			logger.debug("findPmTypeByMP(FindPmType) - end - return value={}", findPmTypeReturn); //$NON-NLS-1$
			return findPmTypeReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户分类表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_FIND_ERROR,"查找客户分类表信息错误！",e);
		}


	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#addPmTypePmRepeat(com.lj.business.member.dto.AddPmTypePmDto)
	 */
	@Override
	public void addPmTypePmRepeat(AddPmTypePmDto addPmTypePmDto) throws TsfaServiceException{
		logger.debug("addPmTypePmRepeat(AddPmTypePmDto addPmTypePmDto={}) - start", addPmTypePmDto); //$NON-NLS-1$

		AssertUtils.notNull(addPmTypePmDto);
		AssertUtils.notNullAndEmpty(addPmTypePmDto.getCodePm(), "会员code不能为空");
		AssertUtils.notNullAndEmpty(addPmTypePmDto.getPmTypeCode(), "分组code不能为空");
		try{
			FindPmTypePmReturn findPmTypePmReturn = pmTypePmDao.findByPmCodeAndPmTypeCode(addPmTypePmDto);
			if(findPmTypePmReturn == null){
				PmTypePm p1 = new PmTypePm();
				p1.setCode(GUID.getPreUUID());
				p1.setCodePm(addPmTypePmDto.getCodePm());
				p1.setPmTypeCode(addPmTypePmDto.getPmTypeCode());
				p1.setCreateDate(new Date());
				pmTypePmDao.insert(p1);
			}
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户分类表信息添加错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_ADD_ERROR,"客户分类表信息添加错误！",e);
		}

		logger.debug("addPmTypePmRepeat() - end"); //$NON-NLS-1$
	}
	
}
