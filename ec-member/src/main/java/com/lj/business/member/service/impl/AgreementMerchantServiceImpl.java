package com.lj.business.member.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaContextServiceException;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IAgreementMerchantDao;
import com.lj.business.member.domain.AgreementMerchant;
import com.lj.business.member.dto.AddAgreementMerchantDto;
import com.lj.business.member.dto.AgreementMerchantReturnDto;
import com.lj.business.member.dto.EditAgreementMerchantDto;
import com.lj.business.member.dto.FindAgreementMerchant;
import com.lj.business.member.dto.FindAgreementMerchantPageDto;
import com.lj.business.member.dto.FindAgreementMerchantReturnDto;
import com.lj.business.member.service.IAgreementMerchantService;


/**
 * 类说明：商户服务协议表实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊 CreateDate: 2017年6月30日
 * 
 * 
 * @Company: 深圳扬恩科技有限公司
 */
@Service
public class AgreementMerchantServiceImpl implements IAgreementMerchantService {

	/** The agreement merchant dao. */
	@Resource
	private IAgreementMerchantDao agreementMerchantDao;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(AgreementMerchantServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IAgreementMerchantService#addAgreementMerchant(com.lj.business.member.dto.AddAgreementMerchant)
	 */
	
	@Override
	public void addAgreementMerchant(AddAgreementMerchantDto addAgreementMerchantDto) {
		AssertUtils.notNull(addAgreementMerchantDto);
		AssertUtils.notNullAndEmpty(addAgreementMerchantDto.getMerchantNo(),"商户编号不能为空");
		try {
			AgreementMerchant agreementMerchant = new AgreementMerchant();
			agreementMerchant.setCode(GUID.getPreUUID());
			agreementMerchant.setMerchantNo(addAgreementMerchantDto.getMerchantNo());
			agreementMerchant.setAgreement(addAgreementMerchantDto.getAgreement());
			agreementMerchant.setCreateId(addAgreementMerchantDto.getCreateId());
			agreementMerchant.setAgreementType(addAgreementMerchantDto.getAgreementType());
			agreementMerchant.setCreateDate(addAgreementMerchantDto.getCreateDate());
			agreementMerchant.setUpdateId(addAgreementMerchantDto.getUpdateId());
			agreementMerchant.setUpdateDate(addAgreementMerchantDto.getUpdateDate());
			agreementMerchantDao.addAgreementMerchant(agreementMerchant);
		} catch (TsfaContextServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增商户服务协议表信息错误！", e);
			throw new TsfaServiceException(
					ErrorCode.AGREEMENTMERCHANT_ADD_ERROR, "新增商户服务协议表信息错误！", e);
		}

	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IAgreementMerchantService#editAgreementMerchant(com.lj.business.member.dto.EditAgreementMerchant)
	 */
	
	@Override
	public void editAgreementMerchant(EditAgreementMerchantDto editAgreementMerchantDto) {
		AssertUtils.notNull(editAgreementMerchantDto);
		AssertUtils.notNullAndEmpty(editAgreementMerchantDto.getCode(), "CODE不能为空");
		try {
			AgreementMerchant agreementMerchant = new AgreementMerchant();
			agreementMerchant.setCode(editAgreementMerchantDto.getCode());
			agreementMerchant.setMerchantNo(editAgreementMerchantDto.getMerchantNo());
			agreementMerchant.setAgreement(editAgreementMerchantDto.getAgreement());
			agreementMerchant.setAgreementType(editAgreementMerchantDto.getAgreementType());
			agreementMerchant.setCreateId(editAgreementMerchantDto.getCreateId());
			agreementMerchant.setUpdateId(editAgreementMerchantDto.getUpdateId());
			agreementMerchantDao.editAgreementMerchant(agreementMerchant);
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("编辑商户服务协议表信息错误！", e);
			throw new TsfaServiceException(
					ErrorCode.AGREEMENTMERCHANT_EDIT_ERROR, "编辑商户服务协议表信息错误！", e);
		}
	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IAgreementMerchantService#findAgreementMerchantByCodeOrMerchantNo(com.lj.business.member.dto.FindAgreementMerchant)
	 */
	/**
	 * 查找商户协议(个人中心)
	 */
	@Override
	public FindAgreementMerchantReturnDto findAgreementMerchant(FindAgreementMerchant findAgreementMerchant) {
		AssertUtils.notNull(findAgreementMerchant);
		AssertUtils.notAllNullAndEmpty(findAgreementMerchant.getCode(), findAgreementMerchant.getMerchantNo(), "Code,MerchantNo不能全部为空");
		try {
			AgreementMerchant agreementMerchant = agreementMerchantDao.findAgreementMerchant(findAgreementMerchant);
			if(agreementMerchant == null){
				throw new TsfaServiceException(ErrorCode.AGREEMENTMERCHANT_NOT_EXIST_ERROR,"商户服务协议信息不存在");
			}
			FindAgreementMerchantReturnDto findAgreementMerchantReturnDto = new FindAgreementMerchantReturnDto();
			findAgreementMerchantReturnDto.setMerchantNo(agreementMerchant.getMerchantNo());
			findAgreementMerchantReturnDto.setAgreement(agreementMerchant.getAgreement());
			return findAgreementMerchantReturnDto;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商户服务协议信息表错误", e);
			throw new TsfaServiceException(
					ErrorCode.AGREEMENTMERCHANT_FIND_ERROR, "查找商户服务协议表信息错误！", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IAgreementMerchantService#selectByCode(java.lang.String)
	 */
	
	@Override
	public AgreementMerchantReturnDto selectByCode(String code) {
		AssertUtils.notNullAndEmpty(code, "CODE不能为空");
		try {
			AgreementMerchant agreementMerchant = agreementMerchantDao.selectByCode(code);
			AgreementMerchantReturnDto agreementMerchantReturnDto = new AgreementMerchantReturnDto();
			agreementMerchantReturnDto.setCode(agreementMerchant.getCode());
			agreementMerchantReturnDto.setMerchantNo(agreementMerchant.getMerchantNo());
			agreementMerchantReturnDto.setAgreement(agreementMerchant.getAgreement());
			agreementMerchantReturnDto.setCreateId(agreementMerchant.getCreateId());
			agreementMerchantReturnDto.setCreateDate(agreementMerchant.getCreateDate());
			agreementMerchantReturnDto.setUpdateId(agreementMerchant.getUpdateId());
			agreementMerchantReturnDto.setUpdateDate(agreementMerchant.getUpdateDate());
			return agreementMerchantReturnDto;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商户服务协议信息表错误", e);
			throw new TsfaServiceException(
					ErrorCode.AGREEMENTMERCHANT_FIND_ERROR, "查找商户服务协议表信息错误！", e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IAgreementMerchantService#findAgreementMerchants(com.lj.business.member.dto.FindAgreementMerchantPageDto)
	 */
	
	@Override
	public List<FindAgreementMerchantPageDto> findAgreementMerchants(
			FindAgreementMerchantPageDto findAgreementMerchantPageDto) {
		AssertUtils.notNull(findAgreementMerchantPageDto);
		List<FindAgreementMerchantPageDto> returnList;
		try {
			returnList = agreementMerchantDao.findAgreementMerchants(findAgreementMerchantPageDto);
		} catch (Exception e) {
			logger.error("查找商户服务协议表信息错误", e);
			throw new TsfaServiceException(
					ErrorCode.AGREEMENTMERCHANT_FIND_ERROR, "查找商户服务协议表信息错误.！",
					e);
		}
		return returnList;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IAgreementMerchantService#findAgreementMerchantPage(com.lj.business.member.dto.FindAgreementMerchantPageDto)
	 */
	
	@Override
	public Page<FindAgreementMerchantPageDto> findAgreementMerchantPage(
			FindAgreementMerchantPageDto findAgreementMerchantPageDto) {
		logger.debug(
				"findAgreementMerchantPageDto(FindAgreementMerchantPageDto findAgreementMerchantPageDto) ) - start",
				findAgreementMerchantPageDto);

		AssertUtils.notNull(findAgreementMerchantPageDto);
		List<FindAgreementMerchantPageDto> returnList;
		int count = 0;
		try {
			returnList = agreementMerchantDao.findAgreementMerchantPage(findAgreementMerchantPageDto);
			count = agreementMerchantDao.findAgreementMerchantPageCount(findAgreementMerchantPageDto);
		} catch (Exception e) {
			logger.error("商户服务协议表信息分页查询错误", e);
			throw new TsfaServiceException(ErrorCode.AGREEMENTMERCHANT_FIND_ERROR, "商户服务协议表信息分页查询错误.！",e);
		}
		Page<FindAgreementMerchantPageDto> returnPage = new Page<FindAgreementMerchantPageDto>(returnList, count, findAgreementMerchantPageDto);

		logger.debug(
				"findAgreementMerchantPageDto(FindAgreementMerchantPageDto) - end - return value={}",
				returnPage);
		return returnPage;
	}

}
