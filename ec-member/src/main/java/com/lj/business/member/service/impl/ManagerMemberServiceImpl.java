package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.common.MemberConstants;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IGuidMemberDao;
import com.lj.business.member.dao.IGuidMemberIntegralDayDao;
import com.lj.business.member.dao.IManagerMemberDao;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.domain.ManagerMember;
import com.lj.business.member.dto.AddLoginCheck;
import com.lj.business.member.dto.AddManagerMember;
import com.lj.business.member.dto.AddManagerMemberDto;
import com.lj.business.member.dto.AddManagerMemberReturn;
import com.lj.business.member.dto.DelManagerMember;
import com.lj.business.member.dto.DelManagerMemberReturn;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindManagerMember;
import com.lj.business.member.dto.FindManagerMemberPage;
import com.lj.business.member.dto.FindManagerMemberPageReturn;
import com.lj.business.member.dto.FindManagerMemberReturn;
import com.lj.business.member.dto.FindManagersDto;
import com.lj.business.member.dto.FindManagersReturnDto;
import com.lj.business.member.dto.ManagerMemberDto;
import com.lj.business.member.dto.ManagerMemberReturnDto;
import com.lj.business.member.dto.UpdateManagerMember;
import com.lj.business.member.dto.UpdateManagerMemberDto;
import com.lj.business.member.dto.UpdateManagerMemberReturn;
import com.lj.business.member.dto.UpdateManagerOrGuidPwdDto;
import com.lj.business.member.dto.UpdatePwdDto;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDay;
import com.lj.business.member.emus.LockStatus;
import com.lj.business.member.emus.MemberType;
import com.lj.business.member.service.ILoginCheckService;
import com.lj.business.member.service.IManagerMemberService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 *         CreateDate: 2017-06-14
 */
@Service
public class ManagerMemberServiceImpl implements IManagerMemberService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ManagerMemberServiceImpl.class);

	/** The manager member dao. */
	@Resource
	private IManagerMemberDao managerMemberDao;

	/** The login check service. */
	@Resource
	private ILoginCheckService loginCheckService;


	@Resource
	private IGuidMemberDao guidMemberDao;

	@Resource
	private IGuidMemberIntegralDayDao guidMemberIntegralDayDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IManagerMemberService#addManagerMember
	 * (com.lj.business.member.dto.AddManagerMember)
	 */
	@Override
	public AddManagerMemberReturn addManagerMember(AddManagerMember addManagerMember) throws TsfaServiceException {
		logger.debug("addManagerMember(AddManagerMember addManagerMember={}) - start", addManagerMember);

		AssertUtils.notNull(addManagerMember);

		try {
			ManagerMember managerMember = new ManagerMember();
			// add数据录入
			managerMember.setCode(GUID.getPreUUID());
			managerMember.setMemberType(addManagerMember.getMemberType().toString());
			managerMember.setMemberNo(addManagerMember.getMemberNo());
			managerMember.setMemberName(addManagerMember.getMemberName());
			managerMember.setMemberNoShop(addManagerMember.getMemberNoShop());
			managerMember.setMemberNameShop(addManagerMember.getMemberNameShop());
			managerMember.setMemberNoMerchant(addManagerMember.getMemberNoMerchant());
			managerMember.setMemberNameMerchant(addManagerMember.getMemberNameMerchant());
			managerMember.setStatus(addManagerMember.getStatus());
			managerMember.setJobNum(addManagerMember.getJobNum());
			managerMember.setTelephone(addManagerMember.getTelephone());
			managerMember.setMobile(addManagerMember.getMobile());
			managerMember.setNoWx(addManagerMember.getNoWx());
			managerMember.setImei(addManagerMember.getImei());
			managerMember.setEmail(addManagerMember.getEmail());
			managerMember.setNickName(addManagerMember.getNickName());
			managerMember.setAddress(addManagerMember.getAddress());
			managerMember.setAge(addManagerMember.getAge());
			managerMember.setEncryptionCode(addManagerMember.getEncryptionCode());
			managerMember.setHeadAddress(addManagerMember.getHeadAddress());
			managerMember.setOpenIdGzhWx(addManagerMember.getOpenIdGzhWx());
			managerMember.setOpenIdXcxWx(addManagerMember.getOpenIdXcxWx());
			managerMember.setNickNameWx(addManagerMember.getNickNameWx());
			managerMember.setSex(addManagerMember.getSex());
			managerMember.setCityWx(addManagerMember.getCityWx());
			managerMember.setCountryWx(addManagerMember.getCountryWx());
			managerMember.setProvinceWx(addManagerMember.getProvinceWx());
			managerMember.setSubsribeTime(addManagerMember.getSubsribeTime());
			managerMember.setAreaCode(addManagerMember.getAreaCode());
			managerMember.setAreaName(addManagerMember.getAreaName());
			managerMember.setCreateId(addManagerMember.getCreateId());
			managerMember.setCreateDate(addManagerMember.getCreateDate());
			managerMember.setWorkDate(addManagerMember.getWorkDate());
			managerMember.setUpdateId(addManagerMember.getUpdateId());
			managerMember.setUpdateDate(addManagerMember.getUpdateDate());
			managerMember.setRemark4(addManagerMember.getRemark4());
			managerMember.setRemark3(addManagerMember.getRemark3());
			managerMember.setRemark2(addManagerMember.getRemark2());
			managerMember.setRemark(addManagerMember.getRemark());


			managerMemberDao.insertSelective(managerMember);
			AddManagerMemberReturn addManagerMemberReturn = new AddManagerMemberReturn();

			// 新增登录检查
			AddLoginCheck addLoginCheck = new AddLoginCheck();
			addLoginCheck.setCode(GUID.generateByUUID());
			addLoginCheck.setMemberNo(addManagerMember.getMemberNo());
			addLoginCheck.setCycleLoginFailTimes(0);
			addLoginCheck.setLockStatus(LockStatus.NORMAL.toString());
			addLoginCheck.setMemberType(MemberType.GUID.toString());
			loginCheckService.addLoginCheck(addLoginCheck);

			logger.debug("addManagerMember(AddManagerMember) - end - return value={}", addManagerMemberReturn);
			return addManagerMemberReturn;

		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增管理人员表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_ADD_ERROR, "新增管理人员表信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IManagerMemberService#delManagerMember
	 * (com.lj.business.member.dto.DelManagerMember)
	 */
	@Override
	public DelManagerMemberReturn delManagerMember(DelManagerMember delManagerMember) throws TsfaServiceException {
		logger.debug("delManagerMember(DelManagerMember delManagerMember={}) - start", delManagerMember);

		AssertUtils.notNull(delManagerMember);
		AssertUtils.notNull(delManagerMember.getCode(), "ID不能为空！");
		try {
			managerMemberDao.deleteByPrimaryKey(delManagerMember.getCode());
			DelManagerMemberReturn delManagerMemberReturn = new DelManagerMemberReturn();

			logger.debug("delManagerMember(DelManagerMember) - end - return value={}", delManagerMemberReturn); //$NON-NLS-1$
			return delManagerMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("删除管理人员表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_DEL_ERROR, "删除管理人员表信息错误！", e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IManagerMemberService#updateManagerMember
	 * (com.lj.business.member.dto.UpdateManagerMember)
	 */
	@Override
	public UpdateManagerMemberReturn updateManagerMember(UpdateManagerMember updateManagerMember) throws TsfaServiceException {
		logger.debug("updateManagerMember(UpdateManagerMember updateManagerMember={}) - start", updateManagerMember); //$NON-NLS-1$

		AssertUtils.notNull(updateManagerMember);
		AssertUtils.notAllNullAndEmpty(updateManagerMember.getCode(), updateManagerMember.getMemberNo(), "code和MemberNo不能同时为空");

		try {
			ManagerMember managerMember = new ManagerMember();
			// update数据录入
			managerMember.setCode(updateManagerMember.getCode());
			managerMember.setMemberNo(updateManagerMember.getMemberNo());
			managerMember.setMemberName(updateManagerMember.getMemberName());
			managerMember.setMemberNoShop(updateManagerMember.getMemberNoShop());
			managerMember.setMemberNameShop(updateManagerMember.getMemberNameShop());
			managerMember.setMemberNoMerchant(updateManagerMember.getMemberNoMerchant());
			managerMember.setMemberNameMerchant(updateManagerMember.getMemberNameMerchant());
			managerMember.setStatus(updateManagerMember.getStatus());
			managerMember.setJobNum(updateManagerMember.getJobNum());
			managerMember.setTelephone(updateManagerMember.getTelephone());
			managerMember.setMobile(updateManagerMember.getMobile());
			managerMember.setEmail(updateManagerMember.getEmail());
			managerMember.setNickName(updateManagerMember.getNickName());
			managerMember.setAddress(updateManagerMember.getAddress());
			managerMember.setAge(updateManagerMember.getAge());

			// 加密机加密
			/*
			 * EncryptRequest encryptRequest= new EncryptRequest();
			 * encryptRequest.setAppCode(MemberConstants.ENCRYPT_APPCODE);
			 * encryptRequest.setOriginalText(updateManagerMember.getPwd());
			 * 
			 * EncryptResponse encryptResponse=
			 * iEncryptor.encrypt(encryptRequest);
			 * managerMember.setPwd(encryptResponse.getCipherText());
			 * managerMember
			 * .setEncryptionCode(encryptResponse.getEncryptorId());
			 */

			// managerMember.setPwd(updateManagerMember.getPwd());
			// managerMember.setEncryptionCode(updateManagerMember.getEncryptionCode());

			managerMember.setHeadAddress(updateManagerMember.getHeadAddress());
			managerMember.setOpenIdGzhWx(updateManagerMember.getOpenIdGzhWx());
			managerMember.setOpenIdXcxWx(updateManagerMember.getOpenIdXcxWx());
			managerMember.setNickNameWx(updateManagerMember.getNickNameWx());
			managerMember.setSex(updateManagerMember.getSex());
			managerMember.setCityWx(updateManagerMember.getCityWx());
			managerMember.setCountryWx(updateManagerMember.getCountryWx());
			managerMember.setProvinceWx(updateManagerMember.getProvinceWx());
			managerMember.setSubsribeTime(updateManagerMember.getSubsribeTime());
			managerMember.setCreateId(updateManagerMember.getCreateId());
			managerMember.setCreateDate(updateManagerMember.getCreateDate());
			managerMember.setUpdateId(updateManagerMember.getUpdateId());
			managerMember.setUpdateDate(updateManagerMember.getUpdateDate());
			managerMember.setRemark4(updateManagerMember.getRemark4());
			managerMember.setRemark3(updateManagerMember.getRemark3());
			managerMember.setRemark2(updateManagerMember.getRemark2());
			managerMember.setRemark(updateManagerMember.getRemark());
			managerMember.setAreaCode(updateManagerMember.getAreaCode());
			AssertUtils.notUpdateMoreThanOne(managerMemberDao.updateByPrimaryKeySelective(managerMember));
			UpdateManagerMemberReturn updateManagerMemberReturn = new UpdateManagerMemberReturn();
			logger.debug("updateManagerMember(UpdateManagerMember) - end - return value={}", updateManagerMemberReturn); //$NON-NLS-1$
			return updateManagerMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("管理人员表信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_UPDATE_ERROR, "管理人员表信息更新信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IManagerMemberService#findManagerMember
	 * (com.lj.business.member.dto.FindManagerMember)
	 */
	@Override
	public FindManagerMemberReturn findManagerMember(FindManagerMember findManagerMember) throws TsfaServiceException {
		logger.debug("findManagerMember(FindManagerMember findManagerMember={}) - start", findManagerMember); //$NON-NLS-1$

		AssertUtils.notNull(findManagerMember);
		AssertUtils.notNullAndEmpty(findManagerMember.getCode(), "CODE不能为空！");
		try {
			ManagerMember managerMember = managerMemberDao.selectByPrimaryKey(findManagerMember.getCode());
			if (managerMember == null) {
				throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_NOT_EXIST_ERROR, "管理人员表信息不存在");
			}
			FindManagerMemberReturn findManagerMemberReturn = new FindManagerMemberReturn();
			// find数据录入
			findManagerMemberReturn.setCode(findManagerMember.getCode());
			findManagerMemberReturn.setMemberType(managerMember.getMemberType());
			findManagerMemberReturn.setMemberNo(managerMember.getMemberNo());
			findManagerMemberReturn.setMemberName(managerMember.getMemberName());
			findManagerMemberReturn.setMemberNoShop(managerMember.getMemberNoShop());
			findManagerMemberReturn.setMemberNameShop(managerMember.getMemberNameShop());
			findManagerMemberReturn.setMemberNoMerchant(managerMember.getMemberNoMerchant());
			findManagerMemberReturn.setMemberNameMerchant(managerMember.getMemberNameMerchant());
			findManagerMemberReturn.setStatus(managerMember.getStatus());
			findManagerMemberReturn.setJobNum(managerMember.getJobNum());
			findManagerMemberReturn.setTelephone(managerMember.getTelephone());
			findManagerMemberReturn.setMobile(managerMember.getMobile());
			findManagerMemberReturn.setEmail(managerMember.getEmail());
			findManagerMemberReturn.setNickName(managerMember.getNickName());
			findManagerMemberReturn.setAddress(managerMember.getAddress());
			findManagerMemberReturn.setAge(managerMember.getAge());
			findManagerMemberReturn.setPwd(managerMember.getPwd());
			findManagerMemberReturn.setEncryptionCode(managerMember.getEncryptionCode());
			findManagerMemberReturn.setHeadAddress(managerMember.getHeadAddress());
			findManagerMemberReturn.setOpenIdGzhWx(managerMember.getOpenIdGzhWx());
			findManagerMemberReturn.setOpenIdXcxWx(managerMember.getOpenIdXcxWx());
			findManagerMemberReturn.setNickNameWx(managerMember.getNickNameWx());
			findManagerMemberReturn.setSex(managerMember.getSex());
			findManagerMemberReturn.setCityWx(managerMember.getCityWx());
			findManagerMemberReturn.setCountryWx(managerMember.getCountryWx());
			findManagerMemberReturn.setProvinceWx(managerMember.getProvinceWx());
			findManagerMemberReturn.setSubsribeTime(managerMember.getSubsribeTime());
			findManagerMemberReturn.setCreateId(managerMember.getCreateId());
			findManagerMemberReturn.setCreateDate(managerMember.getCreateDate());
			findManagerMemberReturn.setUpdateId(managerMember.getUpdateId());
			findManagerMemberReturn.setUpdateDate(managerMember.getUpdateDate());
			findManagerMemberReturn.setWorkDate(managerMember.getWorkDate());
			findManagerMemberReturn.setImei(managerMember.getImei());
			findManagerMemberReturn.setAreaCode(managerMember.getAreaCode());
			findManagerMemberReturn.setAreaName(managerMember.getAreaName());

			logger.debug("findManagerMember(FindManagerMember) - end - return value={}", findManagerMemberReturn); //$NON-NLS-1$
			return findManagerMemberReturn;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找管理人员表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_FIND_ERROR, "查找管理人员表信息错误！", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IManagerMemberService#findManagerMemberPage
	 * (com.lj.business.member.dto.FindManagerMemberPage)
	 */
	@Override
	public Page<FindManagerMemberPageReturn> findManagerMemberPage(FindManagerMemberPage findManagerMemberPage) throws TsfaServiceException {
		logger.debug("findManagerMemberPage(FindManagerMemberPage findManagerMemberPage={}) - start", findManagerMemberPage); //$NON-NLS-1$

		AssertUtils.notNull(findManagerMemberPage);
		List<FindManagerMemberPageReturn> returnList;
		int count = 0;
		try {
			returnList = managerMemberDao.findManagerMemberPage(findManagerMemberPage);
			count = managerMemberDao.findManagerMemberPageCount(findManagerMemberPage);
		} catch (Exception e) {
			logger.error("管理人员表信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_FIND_PAGE_ERROR, "管理人员表信息不存在错误.！", e);
		}
		Page<FindManagerMemberPageReturn> returnPage = new Page<FindManagerMemberPageReturn>(returnList, count, findManagerMemberPage);

		logger.debug("findManagerMemberPage(FindManagerMemberPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IManagerMemberService#findManagerMembers
	 * (com.lj.business.member.dto.FindManagerMemberPage)
	 */
	@Override
	public List<FindManagerMemberPageReturn> findManagerMembers(FindManagerMemberPage findManagerMemberPage) throws TsfaServiceException {
		AssertUtils.notNull(findManagerMemberPage);
		List<FindManagerMemberPageReturn> returnList;
		try {
			returnList = managerMemberDao.findManagerMembers(findManagerMemberPage);
		} catch (Exception e) {
			logger.error("管理人员表信息分页查询错误", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_FIND_PAGE_ERROR, "管理人员表信息分页查询错误.！", e);
		}

		return returnList;
	}

	/**
	 * 查找店长信息(个人中心).
	 *
	 * @param managerMemberDto
	 *            the manager member dto
	 * @return the manager member return dto
	 */
	@Override
	public ManagerMemberReturnDto findManager(ManagerMemberDto managerMemberDto) {
		AssertUtils.notNull(managerMemberDto);
		AssertUtils.notAllNullAndEmpty(managerMemberDto.getCode(), managerMemberDto.getMemberNo(), "code,MemberNo不能全部为空");
		try {
			ManagerMemberReturnDto managerMember = managerMemberDao.findManager(managerMemberDto);
			if (managerMember == null) {
				throw new TsfaServiceException(ErrorCode.MERCHANT_NOT_EXIST_ERROR, "商户表信息不存在");
			}
			ManagerMemberReturnDto managerMemberReturnDto = new ManagerMemberReturnDto();
			managerMemberReturnDto.setCode(managerMember.getCode());
			managerMemberReturnDto.setMemberNo(managerMember.getMemberNo());
			managerMemberReturnDto.setMemberType(managerMember.getMemberType());
			managerMemberReturnDto.setMemberName(managerMember.getMemberName());
			managerMemberReturnDto.setMemberNoShop(managerMember.getMemberNoShop());
			managerMemberReturnDto.setMemberNameShop(managerMember.getMemberNameShop());
			managerMemberReturnDto.setMemberNoMerchant(managerMember.getMemberNoMerchant());
			managerMemberReturnDto.setMemberNameMerchant(managerMember.getMemberNameMerchant());
			managerMemberReturnDto.setMobile(managerMember.getMobile());
			managerMemberReturnDto.setEmail(managerMember.getEmail());
			managerMemberReturnDto.setAreaCode(managerMember.getAreaCode());
			managerMemberReturnDto.setAreaName(managerMember.getAreaName());
			managerMemberReturnDto.setProvinceCode(managerMember.getProvinceCode());
			managerMemberReturnDto.setCityCode(managerMember.getCityCode());
			managerMemberReturnDto.setCityAreaCode(managerMember.getCityAreaCode());
			managerMemberReturnDto.setAddress(managerMember.getAddress());
			managerMemberReturnDto.setHeadAddress(managerMember.getHeadAddress());
			managerMemberReturnDto.setSex(managerMember.getSex());
			return managerMemberReturnDto;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找管理人员表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_FIND_ERROR, "查找管理人员表信息错误！", e);
		}
	}

	/**
	 * 更新店长信息(个人中心).
	 *
	 * @param updateManagerMemberDto
	 *            the update manager member dto
	 */
	@Override
	public void updateManager(UpdateManagerMemberDto updateManagerMemberDto) {
		logger.debug("updateManagerMemberDto(updateManagerMemberDto updateManagerMemberDto={}) - start", updateManagerMemberDto);
		AssertUtils.notNull(updateManagerMemberDto);
		AssertUtils.notNull(updateManagerMemberDto.getMemberNo(), "memberNo不能为空");
		AssertUtils.notNull(updateManagerMemberDto.getMemberType(), "memberType不能为空");
		// 如果是店长
		if (updateManagerMemberDto.getMemberType().equals(MemberType.SHOP.toString())) {
			ManagerMember record = new ManagerMember();
			record.setMemberNo(updateManagerMemberDto.getMemberNo());
			record.setMemberName(updateManagerMemberDto.getMemberName());
			record.setEmail(updateManagerMemberDto.getEmail());
			record.setAreaCode(updateManagerMemberDto.getAreaCode());
			record.setCityAreaCode(updateManagerMemberDto.getCityAreaCode());
			record.setCityCode(updateManagerMemberDto.getCityCode());
			record.setProvinceCode(updateManagerMemberDto.getProvinceCode());
			record.setAddress(updateManagerMemberDto.getAddress());
			record.setSex(updateManagerMemberDto.getSex());
			record.setHeadAddress(updateManagerMemberDto.getHeadAddress());
			managerMemberDao.updateManager(record);

			ManagerMemberDto managerMemberDto = new ManagerMemberDto();
			managerMemberDto.setMemberNo(updateManagerMemberDto.getMemberNo());
			ManagerMemberReturnDto findManager = managerMemberDao.findManager(managerMemberDto);

			FindGuidMember guidMember = new FindGuidMember();
			guidMember.setMobile(findManager.getMobile());
			GuidMember guid = guidMemberDao.findGuidMember(guidMember);
			updateManagerMemberDto.setMemberNo(guid.getMemberNo());
		}
		GuidMember guidMember = new GuidMember();
		guidMember.setMemberNo(updateManagerMemberDto.getMemberNo());
		guidMember.setMemberName(updateManagerMemberDto.getMemberName());
		guidMember.setEmail(updateManagerMemberDto.getEmail());
		guidMember.setAreaCode(updateManagerMemberDto.getAreaCode());
		guidMember.setCityAreaCode(updateManagerMemberDto.getCityAreaCode());
		guidMember.setCityCode(updateManagerMemberDto.getCityCode());
		guidMember.setProvinceCode(updateManagerMemberDto.getProvinceCode());
		guidMember.setAddress(updateManagerMemberDto.getAddress());
		guidMember.setGender((updateManagerMemberDto.getSex()));
		guidMember.setHeadAddress(updateManagerMemberDto.getHeadAddress());
		guidMemberDao.updateGuid(guidMember);

		if (updateManagerMemberDto.getMemberType().equals(MemberType.AREA_MAN.toString())) {
			ManagerMember record = new ManagerMember();
			record.setMemberNo(updateManagerMemberDto.getMemberNo());
			record.setMemberName(updateManagerMemberDto.getMemberName());
			record.setEmail(updateManagerMemberDto.getEmail());
			record.setAreaCode(updateManagerMemberDto.getAreaCode());
			record.setCityAreaCode(updateManagerMemberDto.getCityAreaCode());
			record.setCityCode(updateManagerMemberDto.getCityCode());
			record.setProvinceCode(updateManagerMemberDto.getProvinceCode());
			record.setAddress(updateManagerMemberDto.getAddress());
			record.setSex(updateManagerMemberDto.getSex());
			record.setHeadAddress(updateManagerMemberDto.getHeadAddress());
			managerMemberDao.updateManager(record);
		}
		if (updateManagerMemberDto.getMemberType().equals(MemberType.BOSS.toString())) {
			ManagerMember record = new ManagerMember();
			record.setMemberNo(updateManagerMemberDto.getMemberNo());
			record.setMemberName(updateManagerMemberDto.getMemberName());
			record.setEmail(updateManagerMemberDto.getEmail());
			record.setAreaCode(updateManagerMemberDto.getAreaCode());
			record.setCityAreaCode(updateManagerMemberDto.getCityAreaCode());
			record.setCityCode(updateManagerMemberDto.getCityCode());
			record.setProvinceCode(updateManagerMemberDto.getProvinceCode());
			record.setAddress(updateManagerMemberDto.getAddress());
			record.setSex(updateManagerMemberDto.getSex());
			record.setHeadAddress(updateManagerMemberDto.getHeadAddress());
			managerMemberDao.updateManager(record);
		}
	}

	/**
	 * 添加店长信息(个人中心).
	 *
	 * @param addManagerMemberDto
	 *            the add manager member dto
	 */
	@Override
	public void addManager(AddManagerMemberDto addManagerMemberDto) {
		logger.debug("addManagerMemberDto(AddManagerMemberDto addManagerMemberDto={}) - start", addManagerMemberDto);
		AssertUtils.notNull(addManagerMemberDto);
		try {
			ManagerMember managerMember = new ManagerMember();
			managerMember.setCode(addManagerMemberDto.getCode());
			managerMember.setMemberNo(addManagerMemberDto.getMemberNo());
			managerMember.setMemberType(addManagerMemberDto.getMemberType());
			managerMember.setMemberName(addManagerMemberDto.getMemberName());
			managerMember.setMemberNoShop(addManagerMemberDto.getMemberNoShop());
			managerMember.setMemberNameShop(addManagerMemberDto.getMemberNameShop());
			managerMember.setMemberNoMerchant(addManagerMemberDto.getMemberNoMerchant());
			managerMember.setMemberNameMerchant(addManagerMemberDto.getMemberNameMerchant());
			managerMember.setMobile(addManagerMemberDto.getMobile());
			managerMember.setEmail(addManagerMemberDto.getEmail());
			managerMember.setAreaCode(addManagerMemberDto.getAreaCode());
			managerMember.setProvinceCode(addManagerMemberDto.getProvinceCode());
			managerMember.setCityCode(addManagerMemberDto.getCityCode());
			managerMember.setCityAreaCode(addManagerMemberDto.getCityAreaCode());
			managerMember.setAddress(addManagerMemberDto.getAddress());
			managerMember.setHeadAddress(addManagerMemberDto.getHeadAddress());
			managerMember.setSex(addManagerMemberDto.getSex());
			managerMemberDao.addManager(managerMember);
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增管理人员表信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_ADD_ERROR, "新增管理人员表信息错误！", e);
		}
	}

	/**
	 * 查找店长信息列表(通讯录). 0de0ff3dafc4ee696e174423b9dd7ebd
	 * 
	 * @param findManagerMemberPage
	 *            the find manager member page
	 * @return the list< manager member return dto>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 */
	@Override
	public List<FindManagersReturnDto> findManagers(FindManagersDto findManagersDto) throws TsfaServiceException {
		logger.debug("findManagers(FindManagersDto findManagersDto={}) - start", findManagersDto); //$NON-NLS-1$

		AssertUtils.notNull(findManagersDto);
		AssertUtils.notNullAndEmpty(findManagersDto.getMemberNoShop(), "分店编号不能为空");
		AssertUtils.notNullAndEmpty(findManagersDto.getMerchantNo(), "商家编号不能为空");
		List<FindManagersReturnDto> returnList;
		try {
			returnList = managerMemberDao.findManagers(findManagersDto);

			// update by 杨杰 2017-09-06
			if (CollectionUtils.isNotEmpty(returnList)) {
				for (FindManagersReturnDto frd : returnList) {
					FindGuidMemberIntegralDay fgmid = new FindGuidMemberIntegralDay();
					// 此处有坑 店长的 manager_member memberNo不等于 guid_member memberNo
					if (!"SHOP".equals(frd.getMemberType())) {
						GuidMember guidMember = new GuidMember();
						guidMember.setMobile(frd.getMobile());
						GuidMember queryQuidMember = guidMemberDao.findGuidMember(guidMember);
						fgmid.setMemberNo(queryQuidMember.getMemberNo());
					} else {
						fgmid.setMemberNo(frd.getMemberNo());
					}
					double scoreSum = guidMemberIntegralDayDao.findMemberScoreSum(fgmid);
					frd.setScoreSum((int)scoreSum);
				}
			}
		} catch (Exception e) {
			logger.error("管理人员表信息分页查询错误", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_FIND_PAGE_ERROR, "管理人员表信息分页查询错误.！", e);
		}

		logger.debug("findManagers(FindManagersDto) - end - return value={}", returnList); //$NON-NLS-1$
		return returnList;
	}

	@Override
	public List<FindManagerMemberPageReturn> findManagerMemberExport(FindManagerMemberPage findManagerMemberPage) {
		logger.debug("findManagerMemberExport(FindManagerMemberPage findManagerMemberPage={}) - start", findManagerMemberPage); //$NON-NLS-1$
		List<FindManagerMemberPageReturn> returnList;
		try {
			returnList = managerMemberDao.findManagerMemberExport(findManagerMemberPage);
		} catch (Exception e) {
			logger.error("管理人员表信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_FIND_PAGE_ERROR, "管理人员表信息不存在错误.！", e);
		}
		logger.debug("findManagerMemberPage(FindManagerMemberPage) - end - return value={}", returnList); //$NON-NLS-1$
		return returnList;
	}

	/**
	 * 修改密码
	 */
	@Override
	public void updateManagerForPwd(UpdateManagerOrGuidPwdDto updateManagerOrGuidPwdDto) throws TsfaServiceException {
		logger.debug("updateManagerOrGuidPwdDto(updateManagerOrGuidPwdDto updateManagerOrGuidPwdDto={}) - start", updateManagerOrGuidPwdDto); //$NON-NLS-1$
		AssertUtils.notNull(updateManagerOrGuidPwdDto);
		AssertUtils.notAllNullAndEmpty(updateManagerOrGuidPwdDto.getMobile(), updateManagerOrGuidPwdDto.getPwd(), "店长编号和密码不能全部为空");

		// 店长
		String mobile = updateManagerOrGuidPwdDto.getMobile();
		ManagerMember managerMember = new ManagerMember();
		managerMember.setMobile(mobile);
		ManagerMember findManagerMember = managerMemberDao.findManagerMember(managerMember);
		// 导购
		GuidMember guidMember = new GuidMember();
		guidMember.setMobile(mobile);
		GuidMember findGuidMember = guidMemberDao.findGuidMember(guidMember);

		if (updateManagerOrGuidPwdDto.getMemberType().equals(MemberType.SHOP.toString()) && findManagerMember.getMobile().equals(findGuidMember.getMobile())) {
			try {
				managerMemberDao.updateManagerAndGuidForPwd(updateManagerOrGuidPwdDto);
			} catch (TsfaServiceException e) {
				logger.error(e.getMessage(), e);
				throw e;
			} catch (Exception e) {
				logger.error("密码更新错误！", e);
				throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_UPDATE_ERROR, "密码更新错误！", e);
			}
			return;
		}

		// 单独更新店长
		if (updateManagerOrGuidPwdDto.getMemberType().equals(MemberType.SHOP.toString())) {
			try {
				managerMemberDao.updateManagerForPwd(updateManagerOrGuidPwdDto);
			} catch (TsfaServiceException e) {
				logger.error(e.getMessage(), e);
				throw e;
			} catch (Exception e) {
				logger.error("管理表信息更新信息错误！", e);
				throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_UPDATE_ERROR, "管理表信息更新信息错误！", e);
			}
			// 更新导购
		} else {
			try {
				guidMemberDao.updateGuidForPwd(updateManagerOrGuidPwdDto);
			} catch (TsfaServiceException e) {
				logger.error(e.getMessage(), e);
				throw e;
			} catch (Exception e) {
				logger.error("导购表信息更新信息错误！", e);
				throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_UPDATE_ERROR, "导购表表信息更新信息错误！", e);
			}

		}
	}

	@Override
	public int findManagerMemberCount(FindManagerMemberPage findManagerMemberPage) {
		int count = 0;
		try {
			count = managerMemberDao.findManagerMemberPageCount(findManagerMemberPage);
		} catch (Exception e) {
			logger.error("查找管理人员表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_FIND_ERROR, "查找管理人员表信息错误！", e);
		}
		return count;
	}

	@Override
	public void updatePwd(UpdatePwdDto updatePwdDto) throws TsfaServiceException {
		logger.debug("updatePwd(UpdatePwdDto updatePwdDto={}) - start", updatePwdDto); //$NON-NLS-1$

		AssertUtils.notNull(updatePwdDto);
		AssertUtils.notAllNullAndEmpty(updatePwdDto.getCode(), "code不能为空");

		try {
			ManagerMember managerMember = new ManagerMember();
			managerMember.setCode(updatePwdDto.getCode());

			AssertUtils.notUpdateMoreThanOne(managerMemberDao.updateByPrimaryKeySelective(managerMember));
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("管理人员表信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_UPDATE_ERROR, "管理人员表信息更新信息错误！", e);
		}
	}

	@Override
	public List<ManagerMemberReturnDto> findManagerMemberByShop(String shopNo) throws TsfaServiceException {
		AssertUtils.notNullAndEmpty(shopNo, "分店编号不能为空");
		return managerMemberDao.findManagerByShop(shopNo);
	}

	@Override
	public int findCountManagerMember(String merchantNo) {
		AssertUtils.notNullAndEmpty(merchantNo, "分店编号不能为空");
		return managerMemberDao.findCountManagerMember(merchantNo);
	}

	@Override
	public Map<String, Object> countByCondition(Map<String, Object> parmMap) {
		AssertUtils.notNull(parmMap);
		return managerMemberDao.countByCondition(parmMap);
	}

	@Override
	public ManagerMemberReturnDto findManagerMemberByMobile(ManagerMemberDto managerMemberDto) {
		return managerMemberDao.findManager(managerMemberDto);
	}

	@Override
	public List<FindManagerMemberPageReturn> findMemberNoShop(
			FindManagerMemberPage findManagerMemberPage) {
		logger.debug("FindManagerMemberPageReturn(FindManagerMemberPage findManagerMemberPage={}) - start", findManagerMemberPage); //$NON-NLS-1$
		AssertUtils.notNull(findManagerMemberPage);
		List<FindManagerMemberPageReturn> list=null;
		try {
			list=managerMemberDao.findMemberNoShop(findManagerMemberPage);
		} catch (Exception e) {
			logger.error("查找管理人员表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MANAGER_MEMBER_FIND_ERROR, "查找管理人员表信息错误！", e);
		}
		return list;
	}

}
