package com.lj.business.member.service.impl;

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
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IPersonMemberBaseDao;
import com.lj.business.member.domain.PersonMemberBase;
import com.lj.business.member.dto.AddPersonMemberBase;
import com.lj.business.member.dto.AddPersonMemberBaseReturn;
import com.lj.business.member.dto.DelPersonMemberBase;
import com.lj.business.member.dto.DelPersonMemberBaseReturn;
import com.lj.business.member.dto.FindPersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBaseList;
import com.lj.business.member.dto.FindPersonMemberBasePage;
import com.lj.business.member.dto.FindPersonMemberBasePageReturn;
import com.lj.business.member.dto.FindPersonMemberBaseReturn;
import com.lj.business.member.dto.FindPersonMemberBaseReturnList;
import com.lj.business.member.dto.FindPersonMemberName;
import com.lj.business.member.dto.UpdatePersonMemberBase;
import com.lj.business.member.dto.UpdatePersonMemberBaseRatioClientInfoDto;
import com.lj.business.member.dto.UpdatePersonMemberBaseReturn;
import com.lj.business.member.emus.MemberStatus;
import com.lj.business.member.emus.NameAuthFlag;
import com.lj.business.member.service.IPersonMemberBaseService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 段志鹏
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class PersonMemberBaseServiceImpl implements IPersonMemberBaseService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(PersonMemberBaseServiceImpl.class);
	

	/** The person member base dao. */
	@Resource
	private IPersonMemberBaseDao personMemberBaseDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPersonMemberBaseService#addPersonMemberBase(com.lj.business.member.dto.AddPersonMemberBase)
	 */
	@Override
	public AddPersonMemberBaseReturn addPersonMemberBase(
			AddPersonMemberBase addPersonMemberBase) throws TsfaServiceException {
		logger.debug("addPersonMemberBase(AddPersonMemberBase addPersonMemberBase={}) - start", addPersonMemberBase); 

		AssertUtils.notNull(addPersonMemberBase);
		try {
			if(addPersonMemberBase.getStatus() == null)
				addPersonMemberBase.setStatus(MemberStatus.NORMAL);
			if(addPersonMemberBase.getNameAuthFlag() == null)
				addPersonMemberBase.setNameAuthFlag(NameAuthFlag.N);
			
			PersonMemberBase personMemberBase = new PersonMemberBase();
			//add数据录入
			personMemberBase.setCode(GUID.getPreUUID());
			personMemberBase.setMemberNo(GUID.generateByUUID());
			personMemberBase.setMemberName(addPersonMemberBase.getMemberName());
			personMemberBase.setStatus(StringUtils.toStringNull(addPersonMemberBase.getStatus()));
			personMemberBase.setCertTypeCode(addPersonMemberBase.getCertTypeCode());
			personMemberBase.setCertNo(addPersonMemberBase.getCertNo());
			personMemberBase.setMobile(addPersonMemberBase.getMobile());
			personMemberBase.setImei(addPersonMemberBase.getImei());
			personMemberBase.setEmail(addPersonMemberBase.getEmail());
			personMemberBase.setJob(addPersonMemberBase.getJob());
			personMemberBase.setAddress(addPersonMemberBase.getAddress());
			personMemberBase.setAge(addPersonMemberBase.getAge());
			personMemberBase.setSex(addPersonMemberBase.getSex());
			personMemberBase.setNameAuthFlag(StringUtils.toStringNull(addPersonMemberBase.getNameAuthFlag()));
			personMemberBase.setPwd(addPersonMemberBase.getPwd());
			personMemberBase.setEncryptionCode(addPersonMemberBase.getEncryptionCode());
			personMemberBase.setMemberSrc(addPersonMemberBase.getMemberSrc());
			personMemberBase.setOpenIdGzhWx(addPersonMemberBase.getOpenIdGzhWx());
			personMemberBase.setOpenIdXcxWx(addPersonMemberBase.getOpenIdXcxWx());
			personMemberBase.setNoWx(addPersonMemberBase.getNoWx());
			personMemberBase.setNickNameWx(addPersonMemberBase.getNickNameWx());
			personMemberBase.setCityWx(addPersonMemberBase.getCityWx());
			personMemberBase.setCountryWx(addPersonMemberBase.getCountryWx());
			personMemberBase.setProvinceWx(addPersonMemberBase.getProvinceWx());
			personMemberBase.setHeadAddress(addPersonMemberBase.getHeadAddress());
			personMemberBase.setSubsribeTime(addPersonMemberBase.getSubsribeTime());
			personMemberBase.setFamilyCode(addPersonMemberBase.getFamilyCode());
			personMemberBase.setFamilyName(addPersonMemberBase.getFamilyName());
			personMemberBase.setInterest(addPersonMemberBase.getInterest());
			personMemberBase.setAreaCode(addPersonMemberBase.getAreaCode());
			personMemberBase.setAreaName(addPersonMemberBase.getAreaName());
			personMemberBase.setProvinceCode(addPersonMemberBase.getProvinceCode());
			personMemberBase.setCityCode(addPersonMemberBase.getCityCode());
			personMemberBase.setCityAreaCode(addPersonMemberBase.getCityAreaCode());
			personMemberBase.setCreateId(addPersonMemberBase.getCreateId());
			personMemberBaseDao.insertSelective(personMemberBase);
			AddPersonMemberBaseReturn addPersonMemberBaseReturn = new AddPersonMemberBaseReturn();
			addPersonMemberBaseReturn.setPersonMemberBase(personMemberBase);
			logger.debug("addPersonMemberBase(AddPersonMemberBase) - end - return value={}", addPersonMemberBaseReturn); 
			return addPersonMemberBaseReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户会员基础信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_ADD_ERROR,"新增客户会员基础信息错误！",e);
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPersonMemberBaseService#delPersonMemberBase(com.lj.business.member.dto.DelPersonMemberBase)
	 */
	@Override
	public DelPersonMemberBaseReturn delPersonMemberBase(
			DelPersonMemberBase delPersonMemberBase) throws TsfaServiceException {
		logger.debug("delPersonMemberBase(DelPersonMemberBase delPersonMemberBase={}) - start", delPersonMemberBase); 

		AssertUtils.notNull(delPersonMemberBase);
		AssertUtils.notNull(delPersonMemberBase.getCode(),"ID不能为空！");
		try {
			personMemberBaseDao.deleteByPrimaryKey(delPersonMemberBase.getCode());
			DelPersonMemberBaseReturn delPersonMemberBaseReturn  = new DelPersonMemberBaseReturn();

			logger.debug("delPersonMemberBase(DelPersonMemberBase) - end - return value={}", delPersonMemberBaseReturn); //$NON-NLS-1$
			return delPersonMemberBaseReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户会员基础表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_DEL_ERROR,"删除客户会员基础表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPersonMemberBaseService#updatePersonMemberBase(com.lj.business.member.dto.UpdatePersonMemberBase)
	 */
	@Override
	public UpdatePersonMemberBaseReturn updatePersonMemberBase(
			UpdatePersonMemberBase updatePersonMemberBase)
			throws TsfaServiceException {
		logger.debug("updatePersonMemberBase(UpdatePersonMemberBase updatePersonMemberBase={}) - start", updatePersonMemberBase); //$NON-NLS-1$

		AssertUtils.notNull(updatePersonMemberBase);
		AssertUtils.notNullAndEmpty(updatePersonMemberBase.getCode(),"CODE不能为空");
		try {
			PersonMemberBase personMemberBase = new PersonMemberBase();
			//update数据录入
			personMemberBase.setCode(updatePersonMemberBase.getCode());
			personMemberBase.setMemberNo(updatePersonMemberBase.getMemberNo());
			personMemberBase.setMemberName(updatePersonMemberBase.getMemberName());
			personMemberBase.setStatus(updatePersonMemberBase.getStatus());
			personMemberBase.setCertTypeCode(updatePersonMemberBase.getCertTypeCode());
			personMemberBase.setCertNo(updatePersonMemberBase.getCertNo());
			personMemberBase.setMobile(updatePersonMemberBase.getMobile());
			personMemberBase.setEmail(updatePersonMemberBase.getEmail());
			personMemberBase.setJob(updatePersonMemberBase.getJob());
			personMemberBase.setAddress(updatePersonMemberBase.getAddress());
			personMemberBase.setAge(updatePersonMemberBase.getAge());
			personMemberBase.setSex(updatePersonMemberBase.getSex());
			personMemberBase.setNameAuthFlag(updatePersonMemberBase.getNameAuthFlag());
			personMemberBase.setPwd(updatePersonMemberBase.getPwd());
			personMemberBase.setEncryptionCode(updatePersonMemberBase.getEncryptionCode());
			personMemberBase.setMemberSrc(updatePersonMemberBase.getMemberSrc());
			personMemberBase.setOpenIdGzhWx(updatePersonMemberBase.getOpenIdGzhWx());
			personMemberBase.setOpenIdXcxWx(updatePersonMemberBase.getOpenIdXcxWx());
			personMemberBase.setNoWx(updatePersonMemberBase.getNoWx());
			personMemberBase.setNickNameWx(updatePersonMemberBase.getNickNameWx());
			personMemberBase.setCityWx(updatePersonMemberBase.getCityWx());
			personMemberBase.setCountryWx(updatePersonMemberBase.getCountryWx());
			personMemberBase.setProvinceWx(updatePersonMemberBase.getProvinceWx());
			personMemberBase.setHeadAddress(updatePersonMemberBase.getHeadAddress());
			personMemberBase.setSubsribeTime(updatePersonMemberBase.getSubsribeTime());
			personMemberBase.setCityAreaCode(updatePersonMemberBase.getCityAreaCode());
			personMemberBase.setCreateId(updatePersonMemberBase.getCreateId());
			personMemberBase.setCreateDate(updatePersonMemberBase.getCreateDate());
			personMemberBase.setUpdateId(updatePersonMemberBase.getUpdateId());
			personMemberBase.setUpdateDate(updatePersonMemberBase.getUpdateDate());
			personMemberBase.setBirthday(updatePersonMemberBase.getBirthday());
			personMemberBase.setAreaCode(updatePersonMemberBase.getAreaCode());
			personMemberBase.setAreaName(updatePersonMemberBase.getAreaName());
			personMemberBase.setCertTypeCode(updatePersonMemberBase.getCertTypeCode());
			personMemberBase.setCityAreaCode(updatePersonMemberBase.getCityAreaCode());
			personMemberBase.setCityCode(updatePersonMemberBase.getCityCode());
			personMemberBase.setProvinceCode(updatePersonMemberBase.getProvinceCode());
			personMemberBase.setRatioClientInfo(updatePersonMemberBase.getRatioClientInfo());
			
			AssertUtils.notUpdateMoreThanOne(personMemberBaseDao.updateByPrimaryKeySelective(personMemberBase));
			UpdatePersonMemberBaseReturn updatePersonMemberBaseReturn = new UpdatePersonMemberBaseReturn();

			logger.debug("updatePersonMemberBase(UpdatePersonMemberBase) - end - return value={}", updatePersonMemberBaseReturn); //$NON-NLS-1$
			return updatePersonMemberBaseReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户会员基础表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_UPDATE_ERROR,"客户会员基础表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPersonMemberBaseService#findPersonMemberBase(com.lj.business.member.dto.FindPersonMemberBase)
	 */
	@Override
	public FindPersonMemberBaseReturn findPersonMemberBase(
			FindPersonMemberBase findPersonMemberBase) throws TsfaServiceException {
		logger.debug("findPersonMemberBase(FindPersonMemberBase findPersonMemberBase={}) - start", findPersonMemberBase); //$NON-NLS-1$

		AssertUtils.notNull(findPersonMemberBase);
		try {
			PersonMemberBase personMemberBase = personMemberBaseDao.selectByParams(findPersonMemberBase);
			if(personMemberBase == null){
				throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_NOT_EXIST_ERROR,"客户会员基础表信息不存在错误");
			}
			FindPersonMemberBaseReturn findPersonMemberBaseReturn = new FindPersonMemberBaseReturn();
			//find数据录入
			findPersonMemberBaseReturn.setCode(personMemberBase.getCode());
			findPersonMemberBaseReturn.setMemberNo(personMemberBase.getMemberNo());
			findPersonMemberBaseReturn.setMemberName(personMemberBase.getMemberName());
			findPersonMemberBaseReturn.setStatus(personMemberBase.getStatus());
			findPersonMemberBaseReturn.setCertTypeCode(personMemberBase.getCertTypeCode());
			findPersonMemberBaseReturn.setCertNo(personMemberBase.getCertNo());
			findPersonMemberBaseReturn.setMobile(personMemberBase.getMobile());
			findPersonMemberBaseReturn.setEmail(personMemberBase.getEmail());
			findPersonMemberBaseReturn.setJob(personMemberBase.getJob());
			findPersonMemberBaseReturn.setAddress(personMemberBase.getAddress());
			findPersonMemberBaseReturn.setAge(personMemberBase.getAge());
			findPersonMemberBaseReturn.setSex(personMemberBase.getSex());
			findPersonMemberBaseReturn.setNameAuthFlag(personMemberBase.getNameAuthFlag());
			findPersonMemberBaseReturn.setPwd(personMemberBase.getPwd());
			findPersonMemberBaseReturn.setEncryptionCode(personMemberBase.getEncryptionCode());
			findPersonMemberBaseReturn.setMemberSrc(personMemberBase.getMemberSrc());
			findPersonMemberBaseReturn.setOpenIdGzhWx(personMemberBase.getOpenIdGzhWx());
			findPersonMemberBaseReturn.setOpenIdXcxWx(personMemberBase.getOpenIdXcxWx());
			findPersonMemberBaseReturn.setNoWx(personMemberBase.getNoWx());
			findPersonMemberBaseReturn.setNickNameWx(personMemberBase.getNickNameWx());
			findPersonMemberBaseReturn.setCityWx(personMemberBase.getCityWx());
			findPersonMemberBaseReturn.setCountryWx(personMemberBase.getCountryWx());
			findPersonMemberBaseReturn.setProvinceWx(personMemberBase.getProvinceWx());
			findPersonMemberBaseReturn.setHeadAddress(personMemberBase.getHeadAddress());
			findPersonMemberBaseReturn.setSubsribeTime(personMemberBase.getSubsribeTime());
			findPersonMemberBaseReturn.setCityAreaCode(personMemberBase.getCityAreaCode());
			findPersonMemberBaseReturn.setCreateId(personMemberBase.getCreateId());
			findPersonMemberBaseReturn.setCreateDate(personMemberBase.getCreateDate());
			findPersonMemberBaseReturn.setUpdateId(personMemberBase.getUpdateId());
			findPersonMemberBaseReturn.setUpdateDate(personMemberBase.getUpdateDate());
			findPersonMemberBaseReturn.setBirthday(personMemberBase.getBirthday());
			findPersonMemberBaseReturn.setRatioClientInfo(personMemberBase.getRatioClientInfo());
			
			logger.debug("findPersonMemberBase(FindPersonMemberBase) - end - return value={}", findPersonMemberBaseReturn); //$NON-NLS-1$
			return findPersonMemberBaseReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户会员基础表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_ERROR,"查找客户会员基础表信息错误！",e);
		}
	}

	
	@Override
	public FindPersonMemberBaseReturn findPersonMemberBaseParams(
			FindPersonMemberBase findPersonMemberBase) throws TsfaServiceException {
		logger.debug("findPersonMemberBase(FindPersonMemberBase findPersonMemberBase={}) - start", findPersonMemberBase); //$NON-NLS-1$

		AssertUtils.notNull(findPersonMemberBase);
		try {
			PersonMemberBase personMemberBase = personMemberBaseDao.findPersonMemberBaseParams(findPersonMemberBase);
			if(personMemberBase == null){
				throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_NOT_EXIST_ERROR,"客户会员基础表信息不存在错误");
			}
			FindPersonMemberBaseReturn findPersonMemberBaseReturn = new FindPersonMemberBaseReturn();
			//find数据录入
			findPersonMemberBaseReturn.setMemberNo(personMemberBase.getMemberNo());
			findPersonMemberBaseReturn.setMemberName(personMemberBase.getMemberName());
			findPersonMemberBaseReturn.setStatus(personMemberBase.getStatus());
			findPersonMemberBaseReturn.setCertTypeCode(personMemberBase.getCertTypeCode());
			findPersonMemberBaseReturn.setCertNo(personMemberBase.getCertNo());
			findPersonMemberBaseReturn.setMobile(personMemberBase.getMobile());
			findPersonMemberBaseReturn.setEmail(personMemberBase.getEmail());
			findPersonMemberBaseReturn.setJob(personMemberBase.getJob());
			findPersonMemberBaseReturn.setAddress(personMemberBase.getAddress());
			findPersonMemberBaseReturn.setAge(personMemberBase.getAge());
			findPersonMemberBaseReturn.setSex(personMemberBase.getSex());
			findPersonMemberBaseReturn.setNameAuthFlag(personMemberBase.getNameAuthFlag());
			findPersonMemberBaseReturn.setPwd(personMemberBase.getPwd());
			findPersonMemberBaseReturn.setEncryptionCode(personMemberBase.getEncryptionCode());
			findPersonMemberBaseReturn.setMemberSrc(personMemberBase.getMemberSrc());
			findPersonMemberBaseReturn.setOpenIdGzhWx(personMemberBase.getOpenIdGzhWx());
			findPersonMemberBaseReturn.setOpenIdXcxWx(personMemberBase.getOpenIdXcxWx());
			findPersonMemberBaseReturn.setNoWx(personMemberBase.getNoWx());
			findPersonMemberBaseReturn.setNickNameWx(personMemberBase.getNickNameWx());
			findPersonMemberBaseReturn.setCityWx(personMemberBase.getCityWx());
			findPersonMemberBaseReturn.setCountryWx(personMemberBase.getCountryWx());
			findPersonMemberBaseReturn.setProvinceWx(personMemberBase.getProvinceWx());
			findPersonMemberBaseReturn.setHeadAddress(personMemberBase.getHeadAddress());
			findPersonMemberBaseReturn.setSubsribeTime(personMemberBase.getSubsribeTime());
			findPersonMemberBaseReturn.setCityAreaCode(personMemberBase.getCityAreaCode());
			findPersonMemberBaseReturn.setCreateId(personMemberBase.getCreateId());
			findPersonMemberBaseReturn.setCreateDate(personMemberBase.getCreateDate());
			findPersonMemberBaseReturn.setUpdateId(personMemberBase.getUpdateId());
			findPersonMemberBaseReturn.setUpdateDate(personMemberBase.getUpdateDate());
			findPersonMemberBaseReturn.setBirthday(personMemberBase.getBirthday());
			findPersonMemberBaseReturn.setRatioClientInfo(personMemberBase.getRatioClientInfo());
			findPersonMemberBaseReturn.setNickNameRemarkLocal(personMemberBase.getNickNameRemarkLocal());
			
			logger.debug("findPersonMemberBase(FindPersonMemberBase) - end - return value={}", findPersonMemberBaseReturn); //$NON-NLS-1$
			return findPersonMemberBaseReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户会员基础表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_ERROR,"查找客户会员基础表信息错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPersonMemberBaseService#findPersonMemberBasePage(com.lj.business.member.dto.FindPersonMemberBasePage)
	 */
	@Override
	public Page<FindPersonMemberBasePageReturn> findPersonMemberBasePage(
			FindPersonMemberBasePage findPersonMemberBasePage)
			throws TsfaServiceException {
		logger.debug("findPersonMemberBasePage(FindPersonMemberBasePage findPersonMemberBasePage={}) - start", findPersonMemberBasePage); //$NON-NLS-1$

		AssertUtils.notNull(findPersonMemberBasePage);
		List<FindPersonMemberBasePageReturn> returnList=null;
		int count = 0;
		try {
			returnList = personMemberBaseDao.findPersonMemberBasePage(findPersonMemberBasePage);
			count = personMemberBaseDao.findPersonMemberBasePageCount(findPersonMemberBasePage);
		}  catch (Exception e) {
			logger.error("客户会员基础表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_PAGE_ERROR,"客户会员基础表信息分页查询错误.！",e);
		}
		Page<FindPersonMemberBasePageReturn> returnPage = new Page<FindPersonMemberBasePageReturn>(returnList, count, findPersonMemberBasePage);

		logger.debug("findPersonMemberBasePage(FindPersonMemberBasePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPersonMemberBaseService#findByMobile(java.lang.String)
	 */
	@Override
	public FindPersonMemberBaseReturn findByMobile(FindPersonMemberBase findPersonMemberBase) {

		AssertUtils.notNull(findPersonMemberBase);
		PersonMemberBase personMemberBase=null;
		FindPersonMemberBaseReturn findPersonMemberBaseReturn = new FindPersonMemberBaseReturn();
		try {
			personMemberBase = personMemberBaseDao.findByMobile(findPersonMemberBase);
	 			//find数据录入
	 			if(personMemberBase!=null){
	 				findPersonMemberBaseReturn.setCode(personMemberBase.getCode());
		 			findPersonMemberBaseReturn.setMemberNo(personMemberBase.getMemberNo());
		 			findPersonMemberBaseReturn.setMemberName(personMemberBase.getMemberName());
		 			findPersonMemberBaseReturn.setStatus(personMemberBase.getStatus());
		 			findPersonMemberBaseReturn.setCertTypeCode(personMemberBase.getCertTypeCode());
		 			findPersonMemberBaseReturn.setCertNo(personMemberBase.getCertNo());
		 			findPersonMemberBaseReturn.setMobile(personMemberBase.getMobile());
		 			findPersonMemberBaseReturn.setEmail(personMemberBase.getEmail());
		 			findPersonMemberBaseReturn.setJob(personMemberBase.getJob());
		 			findPersonMemberBaseReturn.setAddress(personMemberBase.getAddress());
		 			findPersonMemberBaseReturn.setAge(personMemberBase.getAge());
		 			findPersonMemberBaseReturn.setSex(personMemberBase.getSex());
		 			findPersonMemberBaseReturn.setNameAuthFlag(personMemberBase.getNameAuthFlag());
		 			findPersonMemberBaseReturn.setPwd(personMemberBase.getPwd());
		 			findPersonMemberBaseReturn.setEncryptionCode(personMemberBase.getEncryptionCode());
		 			findPersonMemberBaseReturn.setMemberSrc(personMemberBase.getMemberSrc());
		 			findPersonMemberBaseReturn.setOpenIdGzhWx(personMemberBase.getOpenIdGzhWx());
		 			findPersonMemberBaseReturn.setOpenIdXcxWx(personMemberBase.getOpenIdXcxWx());
		 			findPersonMemberBaseReturn.setNoWx(personMemberBase.getNoWx());
		 			findPersonMemberBaseReturn.setNickNameWx(personMemberBase.getNickNameWx());
		 			findPersonMemberBaseReturn.setCityWx(personMemberBase.getCityWx());
		 			findPersonMemberBaseReturn.setCountryWx(personMemberBase.getCountryWx());
		 			findPersonMemberBaseReturn.setProvinceWx(personMemberBase.getProvinceWx());
		 			findPersonMemberBaseReturn.setHeadAddress(personMemberBase.getHeadAddress());
		 			findPersonMemberBaseReturn.setSubsribeTime(personMemberBase.getSubsribeTime());
		 			findPersonMemberBaseReturn.setCityAreaCode(personMemberBase.getCityAreaCode());
		 			findPersonMemberBaseReturn.setCreateId(personMemberBase.getCreateId());
		 			findPersonMemberBaseReturn.setCreateDate(personMemberBase.getCreateDate());
		 			findPersonMemberBaseReturn.setUpdateId(personMemberBase.getUpdateId());
		 			findPersonMemberBaseReturn.setUpdateDate(personMemberBase.getUpdateDate());
		 			findPersonMemberBaseReturn.setBirthday(personMemberBase.getBirthday());
		 			return findPersonMemberBaseReturn;
	 			}else {
	 				return null;
				}
		   } catch (NullPointerException e) {
			logger.error("客户会员基础信息查询错误",e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_PAGE_ERROR,"客户会员基础信息查询错误.！",e);
		}
		
	}

	@Override
	public List<FindPersonMemberName> findByCodeList(List<String> codeList) {
		AssertUtils.notNull(codeList);

		try {
			return this.personMemberBaseDao.findByCodeList(codeList);
		} catch (Exception e) {
			logger.error("客户会员基础信息查询错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_PAGE_ERROR, "客户会员基础信息查询错误.！", e);
		}
	}


	@Override
	public FindPersonMemberBaseReturnList findPersonMemberBaseList(
			FindPersonMemberBaseList findPersonMemberBaseList)throws TsfaServiceException {
		logger.debug("findPersonMemberBaseList(FindPersonMemberBaseList findPersonMemberBaseList={}) - start", findPersonMemberBaseList); 
		AssertUtils.notNull(findPersonMemberBaseList);
		FindPersonMemberBaseReturnList list=null;
		try {
			list=personMemberBaseDao.findPersonMemberBaseList(findPersonMemberBaseList);
		} catch (Exception e) {
			logger.error("客户会员基础信息查询错误",e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_PAGE_ERROR,"客户会员基础信息查询错误.！",e);
		}
		return list;
	}


	@Override
	public FindPersonMemberBaseReturnList findPersonMemberBaseCounts(
			FindPersonMemberBaseList findPersonMemberBaseList)
			throws TsfaServiceException {
		AssertUtils.notNull(findPersonMemberBaseList);
		FindPersonMemberBaseReturnList findPersonMemberBaseReturnList=null;
		try {
			findPersonMemberBaseReturnList=personMemberBaseDao.findPersonMemberBaseCounts(findPersonMemberBaseList);
		} catch (Exception e) {
			logger.error("客户会员基础信息查询错误",e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_PAGE_ERROR,"客户会员基础信息查询错误.！",e);
		}
		return findPersonMemberBaseReturnList;
	}


	@Override
	public void updatePersonMemberBaseRatioClientInfo(UpdatePersonMemberBaseRatioClientInfoDto dto) throws TsfaServiceException {
		AssertUtils.notNull(dto);
		try{
			personMemberBaseDao.updateRatioClientInfoByMemberNo(dto);
		} catch (Exception e) {
			logger.error("客户会员基础表信息更新错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_UPDATE_ERROR, "客户会员基础表信息更新错误！", e);
		}
	}


	  @Override
	  public FindPersonMemberBaseReturnList findPersonMemberMax()
			throws TsfaServiceException {
		logger.debug("findPersonMemberMax() - start"); 
		FindPersonMemberBaseReturnList findPersonMemberBaseReturnList=null;
		try {
			findPersonMemberBaseReturnList=personMemberBaseDao.findPersonMemberMax();
		} catch (Exception e) {
			logger.error("客户会员基础信息查询错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_PAGE_ERROR, "客户会员基础信息查询错误.！", e);
		}
		
		return findPersonMemberBaseReturnList;
	}


	@Override
	public List<FindPersonMemberBaseList> findPersonMemberBaseMemberCount(FindPersonMemberBase findPersonMemberBase)
			throws TsfaServiceException {
		logger.debug("findPersonMemberBaseMemberCount() - start"); 
		List<FindPersonMemberBaseList> findPersonMemberBaseList = null;
		try {
			findPersonMemberBaseList=personMemberBaseDao.findPersonMemberBaseMemberCount(findPersonMemberBase);
		} catch (Exception e) {
			logger.error("客户会员基础信息查询错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_PAGE_ERROR, "客户会员基础信息查询错误.！", e);
		}
		return findPersonMemberBaseList;
	}


	@Override
	public int findPersonMemberBaseNumAdd(
			FindPersonMemberBaseList findPersonMemberBaseList)
			throws TsfaServiceException {
		logger.debug("findPersonMemberBaseMemberCount() - start"); 
		AssertUtils.notNull(findPersonMemberBaseList);
		int count=0;
		try {
			count=personMemberBaseDao.findPersonMemberBaseNumAdd(findPersonMemberBaseList);
		} catch (Exception e) {
			logger.error("客户会员基础信息客户数量查询错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_PAGE_ERROR, "客户会员基础信息客户数量查询错误.！", e);
		}
		return count;
	}



	
}
