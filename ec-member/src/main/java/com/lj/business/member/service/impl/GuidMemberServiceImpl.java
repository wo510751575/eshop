package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.encryption.MD5;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.unfinishTaskSummary.AddUnfinishTaskSummary;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListPageReturn;
import com.lj.business.cf.emus.ShopTaskType;
import com.lj.business.cf.service.IUnfinishTaskSummaryService;
import com.lj.business.cf.service.IWorkTaskListService;
import com.lj.business.cf.service.IWorkTaskService;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IGuidMemberDao;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.dto.AddGuidMember;
import com.lj.business.member.dto.AddGuidMemberDto;
import com.lj.business.member.dto.AddGuidMemberReturn;
import com.lj.business.member.dto.AddLoginCheck;
import com.lj.business.member.dto.DelGuidMember;
import com.lj.business.member.dto.DelGuidMemberReturn;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberDto;
import com.lj.business.member.dto.FindGuidMemberPage;
import com.lj.business.member.dto.FindGuidMemberPageReturn;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindShopGmDto;
import com.lj.business.member.dto.FindShopGmReturn;
import com.lj.business.member.dto.GuidInfoShop;
import com.lj.business.member.dto.GuidMemberReturnDto;
import com.lj.business.member.dto.UpdateGuidMember;
import com.lj.business.member.dto.UpdateGuidMemberReturn;
import com.lj.business.member.dto.UpdatePwdDto;
import com.lj.business.member.emus.LockStatus;
import com.lj.business.member.emus.MemberType;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.ILoginCheckService;

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
public class GuidMemberServiceImpl implements IGuidMemberService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(GuidMemberServiceImpl.class);

	/** The guid member dao. */
	@Resource
	private IGuidMemberDao guidMemberDao;

	/** The login check service. */
	@Resource
	private ILoginCheckService loginCheckService;


	@Resource
	private IUnfinishTaskSummaryService unfinishTaskSummaryService;

	@Resource
	private IWorkTaskListService workTaskListService;

	@Resource
	private IWorkTaskService workTaskService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IGuidMemberService#addGuidMember(com.lj
	 * .business.member.dto.AddGuidMember)
	 */
	@Override
	public AddGuidMemberReturn addGuidMember(AddGuidMember addGuidMember) throws TsfaServiceException {
		logger.debug("addGuidMember(AddGuidMember addGuidMember={}) - start", addGuidMember);
		AssertUtils.notNull(addGuidMember);
		try {
			GuidMember guidMember = new GuidMember();
			// add数据录入
			guidMember.setCode(GUID.getPreUUID());
			guidMember.setMemberNo(GUID.generateByUUID());
			guidMember.setMemberName(addGuidMember.getMemberName());
			guidMember.setShopNo(addGuidMember.getShopNo());
			guidMember.setShopName(addGuidMember.getShopName());
			guidMember.setMerchantNo(addGuidMember.getMerchantNo());
			guidMember.setMerchantName(addGuidMember.getMerchantName());
			guidMember.setStatus(addGuidMember.getStatus());
			guidMember.setJobNum(addGuidMember.getJobNum());
			guidMember.setMobile(addGuidMember.getMobile());
			guidMember.setImei(addGuidMember.getImei());
			guidMember.setEmail(addGuidMember.getEmail());
			guidMember.setNickName(addGuidMember.getNickName());
			guidMember.setAreaCode(addGuidMember.getAreaCode());
			guidMember.setAreaName(addGuidMember.getAreaName());
			guidMember.setNoWx(addGuidMember.getNoWx());
			guidMember.setProvinceCode(addGuidMember.getProvinceCode());
			guidMember.setCityCode(addGuidMember.getCityCode());
			guidMember.setCityAreaCode(addGuidMember.getCityAreaCode());
			guidMember.setAddress(addGuidMember.getAddress());
			guidMember.setAge(addGuidMember.getAge());
			guidMember.setGender(addGuidMember.getGender());
			guidMember.setHeadAddress(addGuidMember.getHeadAddress());
			guidMember.setWorkDate(addGuidMember.getWorkDate());
			guidMember.setQcord(addGuidMember.getQcord());
			guidMember.setCreateId(addGuidMember.getCreateId());
			guidMember.setRemark4(addGuidMember.getRemark4());
			guidMember.setRemark3(addGuidMember.getRemark3());
			guidMember.setRemark2(addGuidMember.getRemark2());
			guidMember.setRemark(addGuidMember.getRemark());
			guidMember.setCreateDate(new Date());


			guidMemberDao.insert(guidMember);
			AddGuidMemberReturn addGuidMemberReturn = new AddGuidMemberReturn();

			// 新增登录检查
			AddLoginCheck addLoginCheck = new AddLoginCheck();
			addLoginCheck.setCode(GUID.generateByUUID());
			addLoginCheck.setMemberNo(guidMember.getMemberNo());
			addLoginCheck.setCycleLoginFailTimes(0);
			addLoginCheck.setLockStatus(LockStatus.NORMAL.toString());
			addLoginCheck.setMemberType(MemberType.GUID.toString());
			loginCheckService.addLoginCheck(addLoginCheck);


			// 初始化未完成工作统计表
			List<FindWorkTaskListPageReturn> list = workTaskListService.findWorkTaskListAll();
			if (list != null && list.size() > 0) {
				for (FindWorkTaskListPageReturn findWorkTaskListPageReturn : list) {
					if (!ShopTaskType.XIAO_SHOU.toString().equals(findWorkTaskListPageReturn.getTaskType())) {
						AddUnfinishTaskSummary addUnfinishTaskSummary = new AddUnfinishTaskSummary();
						addUnfinishTaskSummary.setMerchantNo(addGuidMember.getMerchantNo());
						addUnfinishTaskSummary.setMemberNoGm(guidMember.getMemberNo());
						addUnfinishTaskSummary.setMemberNameGm(addGuidMember.getMemberName());
						addUnfinishTaskSummary.setShopNo(addGuidMember.getShopNo());
						addUnfinishTaskSummary.setShopName(addGuidMember.getShopName());
						addUnfinishTaskSummary.setErrorNum(0L);
						addUnfinishTaskSummary
								.setTaskUnit(findWorkTaskListPageReturn
										.getTaskUnit());
						addUnfinishTaskSummary
								.setCodeList(findWorkTaskListPageReturn
										.getCode());
						addUnfinishTaskSummary
								.setNameList(findWorkTaskListPageReturn
										.getTaskName());
						addUnfinishTaskSummary.setCreateDate(new Date());
						unfinishTaskSummaryService
								.addUnfinishTaskSummary(addUnfinishTaskSummary);
					}
				}
			}

			logger.debug(
					"addGuidMember(AddGuidMember) - end - return value={}",
					addGuidMemberReturn);
			return addGuidMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增导购表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_ADD_ERROR,
					"新增导购表信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IGuidMemberService#delGuidMember(com.lj
	 * .business.member.dto.DelGuidMember)
	 */
	@Override
	public DelGuidMemberReturn delGuidMember(DelGuidMember delGuidMember)
			throws TsfaServiceException {
		logger.debug("delGuidMember(DelGuidMember delGuidMember={}) - start",
				delGuidMember);

		AssertUtils.notNull(delGuidMember);
		AssertUtils.notNull(delGuidMember.getCode(), "ID不能为空！");
		try {
			guidMemberDao.deleteByPrimaryKey(delGuidMember.getCode());
			DelGuidMemberReturn delGuidMemberReturn = new DelGuidMemberReturn();

			logger.debug(
					"delGuidMember(DelGuidMember) - end - return value={}", delGuidMemberReturn); //$NON-NLS-1$
			return delGuidMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("删除导购表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_DEL_ERROR,
					"删除导购表信息错误！", e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IGuidMemberService#updateGuidMember(com
	 * .lj.business.member.dto.UpdateGuidMember)
	 */
	@Override
	public UpdateGuidMemberReturn updateGuidMember(
			UpdateGuidMember updateGuidMember) throws TsfaServiceException {
		logger.debug(
				"updateGuidMember(UpdateGuidMember updateGuidMember={}) - start", updateGuidMember); //$NON-NLS-1$

		AssertUtils.notNull(updateGuidMember);
		AssertUtils.notNull(updateGuidMember.getCode(), "CODE不能为空");
		try {
			GuidMember guidMember = new GuidMember();
			// update数据录入
			guidMember.setCode(updateGuidMember.getCode());
			guidMember.setMemberNo(updateGuidMember.getMemberNo());
			guidMember.setMemberName(updateGuidMember.getMemberName());
			guidMember.setShopNo(updateGuidMember.getShopNo());
			guidMember.setShopName(updateGuidMember.getShopName());
			guidMember.setMerchantNo(updateGuidMember.getMerchantNo());
			guidMember.setMerchantName(updateGuidMember.getMerchantName());
			guidMember.setStatus(updateGuidMember.getStatus());
			guidMember.setJobNum(updateGuidMember.getJobNum());
			guidMember.setMobile(updateGuidMember.getMobile());
			guidMember.setImei(updateGuidMember.getImei());
			guidMember.setEmail(updateGuidMember.getEmail());
			guidMember.setNickName(updateGuidMember.getNickName());
			guidMember.setAreaCode(updateGuidMember.getAreaCode());
			guidMember.setAreaName(updateGuidMember.getAreaName());
			guidMember.setProvinceCode(updateGuidMember.getProvinceCode());
			guidMember.setCityCode(updateGuidMember.getCityCode());
			guidMember.setAddress(updateGuidMember.getAddress());
			guidMember.setAge(updateGuidMember.getAge());
			guidMember.setGender(updateGuidMember.getGender());
			guidMember.setHeadAddress(updateGuidMember.getHeadAddress());
			guidMember.setWorkDate(updateGuidMember.getWorkDate());
			guidMember.setQcord(updateGuidMember.getQcord());
			guidMember.setCreateId(updateGuidMember.getCreateId());
			guidMember.setCreateDate(updateGuidMember.getCreateDate());
			guidMember.setUpdateId(updateGuidMember.getUpdateId());
			guidMember.setUpdateDate(updateGuidMember.getUpdateDate());
			guidMember.setNoWx(updateGuidMember.getNoWx());//电商需要修改微信号
			guidMember.setCityAreaCode(updateGuidMember.getCityAreaCode());//电商需要修改
			/*
			 * if(updateGuidMember.getPwd()!=null){ //加密机加密 EncryptRequest
			 * encryptRequest= new EncryptRequest();
			 * encryptRequest.setAppCode(MemberConstants.ENCRYPT_APPCODE);
			 * encryptRequest.setOriginalText(updateGuidMember.getPwd());
			 * 
			 * EncryptResponse encryptResponse=
			 * iEncryptor.encrypt(encryptRequest);
			 * guidMember.setPwd(encryptResponse.getCipherText() );
			 * guidMember.setEncryptionCode(encryptResponse.getEncryptorId()); }
			 */
			AssertUtils.notUpdateMoreThanOne(guidMemberDao
					.updateByPrimaryKeySelective(guidMember));
			UpdateGuidMemberReturn updateGuidMemberReturn = new UpdateGuidMemberReturn();

			logger.debug(
					"updateGuidMember(UpdateGuidMember) - end - return value={}", updateGuidMemberReturn); //$NON-NLS-1$
			return updateGuidMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("导购表信息更新错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_UPDATE_ERROR,
					"导购表信息更新错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IGuidMemberService#findGuidMember(com.
	 * lj.business.member.dto.FindGuidMember)
	 */
	@Override
	public FindGuidMemberReturn findGuidMember(FindGuidMember findGuidMember)
			throws TsfaServiceException {
		logger.debug(
				"findGuidMember(FindGuidMember findGuidMember={}) - start", findGuidMember); //$NON-NLS-1$

		AssertUtils.notNull(findGuidMember);
		if(StringUtils.isEmpty(findGuidMember.getCode()) && StringUtils.isEmpty(findGuidMember.getMemberNo()) 
				&& StringUtils.isEmpty(findGuidMember.getMobile()) && StringUtils.isEmpty(findGuidMember.getNoWx())){
			throw new IllegalArgumentException("参数不能全部为空！");
		}
		
		try {
			GuidMember guidMemberQuery = new GuidMember();
			guidMemberQuery.setCode(findGuidMember.getCode());
			guidMemberQuery.setMemberNo(findGuidMember.getMemberNo());
			guidMemberQuery.setMobile(findGuidMember.getMobile());
			guidMemberQuery.setNoWx(findGuidMember.getNoWx());
			GuidMember guidMember = guidMemberDao.selectByParams(guidMemberQuery);
			if (guidMember == null) {
				throw new TsfaServiceException(
						ErrorCode.GUID_MEMBER_NOT_EXIST_ERROR, "导购表信息不存在");
			}
			FindGuidMemberReturn findGuidMemberReturn = new FindGuidMemberReturn();
			// find数据录入
			findGuidMemberReturn.setCode(guidMember.getCode());
			findGuidMemberReturn.setMemberNo(guidMember.getMemberNo());
			findGuidMemberReturn.setMemberName(guidMember.getMemberName());
			findGuidMemberReturn.setShopNo(guidMember.getShopNo());
			findGuidMemberReturn.setShopName(guidMember.getShopName());
			findGuidMemberReturn.setMerchantNo(guidMember.getMerchantNo());
			findGuidMemberReturn.setMerchantName(guidMember.getMerchantName());
			findGuidMemberReturn.setStatus(guidMember.getStatus());
			findGuidMemberReturn.setJobNum(guidMember.getJobNum());
			findGuidMemberReturn.setMobile(guidMember.getMobile());
			findGuidMemberReturn.setEmail(guidMember.getEmail());
			findGuidMemberReturn.setNickName(guidMember.getNickName());
			findGuidMemberReturn.setAddress(guidMember.getAddress());
			findGuidMemberReturn.setAge(guidMember.getAge());
			findGuidMemberReturn.setGender(guidMember.getGender());
			findGuidMemberReturn.setPwd(guidMember.getPwd());
			findGuidMemberReturn.setEncryptionCode(guidMember
					.getEncryptionCode());
			findGuidMemberReturn.setHeadAddress(guidMember.getHeadAddress());
			findGuidMemberReturn.setCreateId(guidMember.getCreateId());
			findGuidMemberReturn.setCreateDate(guidMember.getCreateDate());
			findGuidMemberReturn.setUpdateId(guidMember.getUpdateId());
			findGuidMemberReturn.setUpdateDate(guidMember.getUpdateDate());
			findGuidMemberReturn.setAreaCode(guidMember.getAreaCode());
			findGuidMemberReturn.setAreaName(guidMember.getAreaName());
			findGuidMemberReturn.setProvinceCode(guidMember.getProvinceCode());
			findGuidMemberReturn.setCityCode(guidMember.getCityCode());
			findGuidMemberReturn.setCityAreaCode(guidMember.getCityAreaCode());
			findGuidMemberReturn.setNoWx(guidMember.getNoWx());
			logger.debug(
					"findGuidMember(FindGuidMember) - end - return value={}", findGuidMemberReturn); //$NON-NLS-1$
			return findGuidMemberReturn;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找导购表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR,
					"查找导购表信息错误！", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IGuidMemberService#findGuidMemberPage(
	 * com.lj.business.member.dto.FindGuidMemberPage)
	 */
	@Override
	public Page<FindGuidMemberPageReturn> findGuidMemberPage(
			FindGuidMemberPage findGuidMemberPage) throws TsfaServiceException {
		logger.debug(
				"findGuidMemberPage(FindGuidMemberPage findGuidMemberPage={}) - start", findGuidMemberPage); //$NON-NLS-1$

		AssertUtils.notNull(findGuidMemberPage);
		List<FindGuidMemberPageReturn> returnList = null;
		int count = 0;
		try {
			returnList = guidMemberDao.findGuidMemberPage(findGuidMemberPage);
			count = guidMemberDao.findGuidMemberPageCount(findGuidMemberPage);
		} catch (Exception e) {
			logger.error("导购表信息分页查询错误", e);
			throw new TsfaServiceException(
					ErrorCode.GUID_MEMBER_FIND_PAGE_ERROR, "导购表信息分页查询错误.！", e);
		}
		Page<FindGuidMemberPageReturn> returnPage = new Page<FindGuidMemberPageReturn>(
				returnList, count, findGuidMemberPage);

		logger.debug(
				"findGuidMemberPage(FindGuidMemberPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IGuidMemberService#findGuidMembers(com
	 * .lj.business.member.dto.FindGuidMemberPage)
	 */
	@Override
	public List<FindGuidMemberPageReturn> findGuidMembers(
			FindGuidMemberPage findGuidMemberPage) throws TsfaServiceException {
		AssertUtils.notNull(findGuidMemberPage);
		List<FindGuidMemberPageReturn> returnList = null;
		try {
			returnList = guidMemberDao.findGuidMembers(findGuidMemberPage);
		} catch (Exception e) {
			logger.error("导购表信息分页查询错误", e);
			throw new TsfaServiceException(
					ErrorCode.GUID_MEMBER_FIND_PAGE_ERROR, "导购表信息分页查询错误.！", e);
		}
		return returnList;
	}
	
	/**
	 * Find guid members no self.
	 *
	 * @param findGuidMemberPage the find guid member page
	 * @return the list
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public List<FindGuidMemberPageReturn> findGuidMembersNoSelf(FindGuidMemberPage findGuidMemberPage) throws TsfaServiceException {
		AssertUtils.notNull(findGuidMemberPage);
		List<FindGuidMemberPageReturn> returnList = null;
		try {
			returnList = guidMemberDao.findGuidMembersNoSelf(findGuidMemberPage);
		} catch (Exception e) {
			logger.error("导购表信息分页查询错误", e);
			throw new TsfaServiceException(
					ErrorCode.GUID_MEMBER_FIND_PAGE_ERROR, "导购表信息分页查询错误.！", e);
		}
		return returnList;
	}
	
	/**
	 * 查找个人中心导购信息.
	 *
	 * @param findGuidMemberDto
	 *            the find guid member dto
	 * @return the guid member return dto
	 */
	@Override
	public GuidMemberReturnDto findGuid(FindGuidMemberDto findGuidMemberDto) {
		AssertUtils.notNull(findGuidMemberDto);
		AssertUtils.notAllNullAndEmpty(findGuidMemberDto.getCode(),
				findGuidMemberDto.getMemberNo(), "code,MemberNo不能全部为空");
		try {
			GuidMemberReturnDto guidMember = guidMemberDao
					.findGuid(findGuidMemberDto);
			GuidMemberReturnDto guidMemberReturnDto = new GuidMemberReturnDto();
			guidMemberReturnDto.setCode(guidMember.getCode());
			guidMemberReturnDto.setMemberNo(guidMember.getMemberNo());
			guidMemberReturnDto.setMemberName(guidMember.getMemberName());
			guidMemberReturnDto.setShopNo(guidMember.getShopNo());
			guidMemberReturnDto.setShopName(guidMember.getShopName());
			guidMemberReturnDto.setMerchantNo(guidMember.getMerchantNo());
			guidMemberReturnDto.setMerchantName(guidMember.getMerchantName());
			guidMemberReturnDto.setMobile(guidMember.getMobile());
			guidMemberReturnDto.setEmail(guidMember.getEmail());
			guidMemberReturnDto.setAreaCode(guidMember.getAreaCode());
			guidMemberReturnDto.setProvinceCode(guidMember.getProvinceCode());
			guidMemberReturnDto.setCityCode(guidMember.getCityCode());
			guidMemberReturnDto.setCityAreaCode(guidMember.getCityAreaCode());
			guidMemberReturnDto.setAddress(guidMember.getAddress());
			guidMemberReturnDto.setHeadAddress(guidMember.getHeadAddress());
			guidMemberReturnDto.setGender(guidMember.getGender());
			return guidMemberReturnDto;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找导购表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR,
					"查找导购表信息错误！", e);
		}
	}

	/**
	 * 添加个人中心导购信息.
	 *
	 * @param addGuidMemberDto
	 *            the add guid member dto
	 */
	@Override
	public void addGuidMember(AddGuidMemberDto addGuidMemberDto) {
		logger.debug(
				"addGuidMemberDto(AddGuidMemberDto addGuidMemberDto={}) - start",
				addGuidMemberDto);
		AssertUtils.notNull(addGuidMemberDto);
		try {
			GuidMember guidMember = new GuidMember();
			guidMember.setCode(addGuidMemberDto.getCode());
			guidMember.setMemberNo(addGuidMemberDto.getMemberNo());
			guidMember.setMemberName(addGuidMemberDto.getMemberName());
			guidMember.setShopNo(addGuidMemberDto.getShopNo());
			guidMember.setShopName(addGuidMemberDto.getShopName());
			guidMember.setMerchantNo(addGuidMemberDto.getMerchantNo());
			guidMember.setMerchantName(addGuidMemberDto.getMerchantName());
			guidMember.setMobile(addGuidMemberDto.getMobile());
			guidMember.setEmail(addGuidMemberDto.getEmail());
			guidMember.setAreaCode(addGuidMemberDto.getAreaCode());
			guidMember.setProvinceCode(addGuidMemberDto.getProvinceCode());
			guidMember.setCityCode(addGuidMemberDto.getCityCode());
			guidMember.setCityAreaCode(addGuidMemberDto.getCityAreaCode());
			guidMember.setAddress(addGuidMemberDto.getAddress());
			guidMember.setHeadAddress(addGuidMemberDto.getHeadAddress());
			guidMember.setGender(addGuidMemberDto.getGender());
			guidMemberDao.addGuid(guidMember);
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增导购表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_ADD_ERROR,
					"新增导购表信息错误！", e);
		}
	}

	/**
	 * 按主键查询导购个人信息
	 */
	@Override
	public GuidMemberReturnDto findGuidMemberByCode(
			UpdateGuidMember updateGuidMember) {
		logger.debug(
				"findGuidMember(UpdateGuidMember updateGuidMember={}) - start",
				updateGuidMember);
		AssertUtils.notNull(updateGuidMember);
		try {
			GuidMember guidMember = guidMemberDao
					.selectByPrimaryKey(updateGuidMember.getCode());
			GuidMemberReturnDto guidMemberReturnDto = new GuidMemberReturnDto();
			guidMemberReturnDto.setCode(guidMember.getCode());
			guidMemberReturnDto.setMemberNo(guidMember.getMemberNo());
			guidMemberReturnDto.setMemberName(guidMember.getMemberName());
			guidMemberReturnDto.setShopNo(guidMember.getShopNo());
			guidMemberReturnDto.setShopName(guidMember.getShopName());
			guidMemberReturnDto.setMerchantNo(guidMember.getMerchantNo());
			guidMemberReturnDto.setMerchantName(guidMember.getMerchantName());
			guidMemberReturnDto.setMobile(guidMember.getMobile());
			guidMemberReturnDto.setEmail(guidMember.getEmail());
			guidMemberReturnDto.setAreaCode(guidMember.getAreaCode());
			guidMemberReturnDto.setProvinceCode(guidMember.getProvinceCode());
			guidMemberReturnDto.setCityCode(guidMember.getCityCode());
			guidMemberReturnDto.setCityAreaCode(guidMember.getCityAreaCode());
			guidMemberReturnDto.setAddress(guidMember.getAddress());
			guidMemberReturnDto.setHeadAddress(guidMember.getHeadAddress());
			guidMemberReturnDto.setGender(guidMember.getGender());
			guidMemberReturnDto.setAddress(guidMember.getAddress());
			guidMemberReturnDto.setWorkDate(guidMember.getWorkDate());
			guidMemberReturnDto.setStatus(guidMember.getStatus());
			guidMemberReturnDto.setImei(guidMember.getImei());
			guidMemberReturnDto.setAge(guidMember.getAge());
			return guidMemberReturnDto;
		} catch (Exception e) {
			logger.error("导购表信息分页查询错误", e);
			throw new TsfaServiceException(
					ErrorCode.GUID_MEMBER_FIND_PAGE_ERROR, "导购表信息分页查询错误.！", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IGuidMemberService#findGuidMemberList(
	 * com.lj.business.member.dto.FindGuidMemberDto)
	 */
	@Override
	public List<GuidMemberReturnDto> findGuidMemberList(
			FindGuidMemberDto findGuidMemberDto) throws TsfaServiceException {
		AssertUtils.notNullAndEmpty(findGuidMemberDto.getMerchantNo(),
				"商户号不能为空");
		AssertUtils.notNullAndEmpty(findGuidMemberDto.getShopNo(), "分店编号不能为空");
		try {
			List<GuidMemberReturnDto> list = guidMemberDao
					.findGuidMemberList(findGuidMemberDto);
			return list;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增导购表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_ADD_ERROR,
					"新增导购表信息错误！", e);
		}
	}

	@Override
	public Page<FindGuidMemberPageReturn> findGuidMemberPage(int currentPage,
			int limit) {
		FindGuidMemberPage findGuidMemberPage = new FindGuidMemberPage();
		findGuidMemberPage.setLimit(limit);
		findGuidMemberPage.setStatus("NORMAL");
		findGuidMemberPage.setStart((currentPage - 1)
				* findGuidMemberPage.getLimit());
		return findGuidMemberPage(findGuidMemberPage);
	}


	@Override
	public int findGuidMemberCount(FindGuidMemberPage findGuidMemberPage) {
		
		int count =0;
		try {
			count =guidMemberDao.findGuidMemberPageCount(findGuidMemberPage);
			return count;
		} catch (Exception e) {
			logger.error("统计导购信息错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR,"统计导购信息错误！", e);
		}
	}

	@Override
	public int findGuidMemberByMerchantNo(FindGuidMemberPage findGuidMemberPage) {
		int count =0;
		try {
			count =guidMemberDao.findGuidMemberByMerchantNo(findGuidMemberPage);
			return count;
		} catch (Exception e) {
			logger.error("统计导购信息错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR,"统计导购信息错误！", e);
		}
	}

	@Override
	public List<GuidInfoShop> findGuidInfoShop(FindGuidMemberDto findGuidMemberDto) {
		List<GuidInfoShop> list=null;
		try {
			list=guidMemberDao.findGuidInfoShop(findGuidMemberDto);
		} catch (Exception e) {
			logger.error("查找导购表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR,
					"查找导购表信息错误！", e);
		}
		return list;
	}

	@Override
	public List<FindGuidMemberPageReturn> findGuidMemberExport(
			FindGuidMemberPage findGuidMemberPage) throws TsfaServiceException {
		
		List<FindGuidMemberPageReturn> returnList = null;
		try {
			returnList = guidMemberDao.findGuidMemberExport(findGuidMemberPage);
		} catch (Exception e) {
			logger.error("导购表信息查询错误", e);
			throw new TsfaServiceException(
					ErrorCode.GUID_MEMBER_FIND_ERROR, "导购表信息查询错误.！", e);
		}
		return returnList;
	}
	
	@Override
	public List<FindShopGmReturn> findShopGm(FindShopGmDto findShopGmDto) throws TsfaServiceException{
		AssertUtils.notNull(findShopGmDto);
		AssertUtils.notNullAndEmpty(findShopGmDto.getMerchantNo(),"商户号不能为空");
		AssertUtils.notNullAndEmpty(findShopGmDto.getShopNo(),"分店编号不能为空");
		List<FindShopGmReturn> list = new ArrayList<FindShopGmReturn>();
		try{
			list = guidMemberDao.findShopGm(findShopGmDto);
			return list;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找导购表信息错误", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR,"查找导购表信息错误", e);
		}
	}
	
	@Override
	public List<FindShopGmReturn> findShopGmPy(FindShopGmDto findShopGmDto) throws TsfaServiceException{
		AssertUtils.notNull(findShopGmDto);
		AssertUtils.notNullAndEmpty(findShopGmDto.getMerchantNo(),"商户号不能为空");
		AssertUtils.notNullAndEmpty(findShopGmDto.getShopNo(),"分店编号不能为空");
		List<FindShopGmReturn> list = new ArrayList<FindShopGmReturn>();
		try{
			list = guidMemberDao.findShopGmPy(findShopGmDto);
			return list;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找导购表信息错误", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR,"查找导购表信息错误", e);
		}
	}

	@Override
	public void updatePwd(UpdatePwdDto updatePwdDto)
			throws TsfaServiceException {
		logger.debug("updatePwd(UpdatePwdDto updatePwdDto={}) - start", updatePwdDto); //$NON-NLS-1$

		AssertUtils.notNull(updatePwdDto);
		AssertUtils.notNull(updatePwdDto.getCode(), "CODE不能为空");
		AssertUtils.notNull(updatePwdDto.getPwd(), "Pwd不能为空");
		try {
			GuidMember guidMember = new GuidMember();
			guidMember.setCode(updatePwdDto.getCode());
			guidMember.setPwd(MD5.encryptByMD5(updatePwdDto.getPwd()));
			AssertUtils.notUpdateMoreThanOne(guidMemberDao.updateByPrimaryKeySelective(guidMember));

		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("导购表信息更新错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_UPDATE_ERROR,"导购表信息更新错误！", e);
		}
	}

	@Override
	public List<GuidMember> findGuidMember(GuidMember guidMember) throws TsfaServiceException {
		return guidMemberDao.findGuidMemberAllList(guidMember);
	}

	@Override
	public int findPersonUngroupCount(GuidMember guidMember) throws TsfaServiceException {
		return guidMemberDao.findPersonUngroupCount(guidMember);
	}
	
	/* (non-Javadoc)
	 * @see com.lj.eshop.member.service.IEcGuidMemberService#findGuidMemberByMoblie(java.lang.String)
	 */
	@Override
	public FindGuidMemberReturn findGuidMemberByMoblie_ec(String moblie)
			throws TsfaServiceException {
		logger.debug("findGuidMemberByMoblie_ec(findGuidMemberByMoblie moblie={}) - start", moblie);
		AssertUtils.notNull(moblie);
		GuidMember guidMember = new GuidMember();
		guidMember.setMobile(moblie);
		try {
			GuidMember guidMbrRt = guidMemberDao.findGuidMember(guidMember);
			if(guidMbrRt==null){
				return null;
			}
			FindGuidMemberReturn dto=new FindGuidMemberReturn();
			dto.setCode(guidMbrRt.getCode());
			dto.setMemberNo(guidMbrRt.getMemberNo());
			dto.setMemberName(guidMbrRt.getMemberName());
			dto.setShopNo(guidMbrRt.getShopNo());
			dto.setShopName(guidMbrRt.getShopName());
			dto.setMerchantNo(guidMbrRt.getMerchantNo());
			dto.setMerchantName(guidMbrRt.getMerchantName());
			dto.setStatus(guidMbrRt.getStatus());
			dto.setJobNum(guidMbrRt.getJobNum());
			dto.setMobile(guidMbrRt.getMobile());
//			dto.setImei(guidMbrRt.getImei());
			dto.setEmail(guidMbrRt.getEmail());
			dto.setNickName(guidMbrRt.getNickName());
			dto.setAreaCode(guidMbrRt.getAreaCode());
			dto.setAreaName(guidMbrRt.getAreaName());
			dto.setNoWx(guidMbrRt.getNoWx());
//			dto.setProvinceCode(guidMbrRt.getProvinceCode());
//			dto.setCityCode(guidMbrRt.getCityCode());
//			dto.setCityAreaCode(guidMbrRt.getCityAreaCode());
			dto.setAddress(guidMbrRt.getAddress());
			dto.setAge(guidMbrRt.getAge());
			dto.setGender(guidMbrRt.getGender());
			dto.setHeadAddress(guidMbrRt.getHeadAddress());
//			dto.setWorkDate(guidMbrRt.getWorkDate());
			dto.setQcord(guidMbrRt.getQcord());
			dto.setCreateId(guidMbrRt.getCreateId());
//			dto.setRemark4(guidMbrRt.getRemark4());
//			dto.setRemark3(guidMbrRt.getRemark3());
//			dto.setRemark2(guidMbrRt.getRemark2());
//			dto.setRemark(guidMbrRt.getRemark());
			dto.setPwd(guidMbrRt.getPwd());
			dto.setEncryptionCode(guidMbrRt.getEncryptionCode());
			dto.setCreateDate(guidMbrRt.getCreateDate());
			
			logger.debug("findGuidMemberByMoblie(moblie) - end - return value={}", dto);
			return dto;
		} catch (Exception e) {
			logger.error("导购查询错误", e);
			throw new TsfaServiceException(
					ErrorCode.GUID_MEMBER_FIND_ERROR, "导购查询错误.！", e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IGuidMemberService#addGuidMember_ec(com.lj.business.member.dto.AddGuidMember)
	 */
	@Override
	public AddGuidMemberReturn addGuidMember_ec(AddGuidMember addGuidMember)
			throws TsfaServiceException {
		logger.debug("addGuidMember_ec(AddGuidMember addGuidMember={}) - start", addGuidMember);
		AssertUtils.notNull(addGuidMember);
		try {
			GuidMember guidMember = new GuidMember();
			// add数据录入
			guidMember.setCode(GUID.getPreUUID());
			//guidMember.setMemberNo(GUID.generateByUUID()); 和电商的会员号保持一直进行关联，不自动生成
			guidMember.setMemberNo(addGuidMember.getMemberNo());//=eshop.t_member.code
			guidMember.setMemberName(addGuidMember.getMemberName());
			guidMember.setShopNo(addGuidMember.getShopNo());
			guidMember.setShopName(addGuidMember.getShopName());
			guidMember.setMerchantNo(addGuidMember.getMerchantNo());
			guidMember.setMerchantName(addGuidMember.getMerchantName());
			guidMember.setStatus(addGuidMember.getStatus());
			guidMember.setJobNum(addGuidMember.getJobNum());
			guidMember.setMobile(addGuidMember.getMobile());
			guidMember.setImei(addGuidMember.getImei());
			guidMember.setEmail(addGuidMember.getEmail());
			guidMember.setNickName(addGuidMember.getNickName());
			guidMember.setAreaCode(addGuidMember.getAreaCode());
			guidMember.setAreaName(addGuidMember.getAreaName());
			guidMember.setNoWx(addGuidMember.getNoWx());
			guidMember.setProvinceCode(addGuidMember.getProvinceCode());
			guidMember.setCityCode(addGuidMember.getCityCode());
			guidMember.setCityAreaCode(addGuidMember.getCityAreaCode());
			guidMember.setAddress(addGuidMember.getAddress());
			guidMember.setAge(addGuidMember.getAge());
			guidMember.setGender(addGuidMember.getGender());
			guidMember.setHeadAddress(addGuidMember.getHeadAddress());
			guidMember.setWorkDate(addGuidMember.getWorkDate());
			guidMember.setQcord(addGuidMember.getQcord());
			guidMember.setCreateId(addGuidMember.getCreateId());
			guidMember.setRemark4(addGuidMember.getRemark4());
			guidMember.setRemark3(addGuidMember.getRemark3());
			guidMember.setRemark2(addGuidMember.getRemark2());
			guidMember.setRemark(addGuidMember.getRemark());
			guidMember.setCreateDate(new Date());
			guidMember.setPwd(addGuidMember.getPwd());

			guidMemberDao.insert(guidMember);
			AddGuidMemberReturn addGuidMemberReturn = new AddGuidMemberReturn();

			// 新增登录检查
			AddLoginCheck addLoginCheck = new AddLoginCheck();
			addLoginCheck.setCode(GUID.generateByUUID());
			addLoginCheck.setMemberNo(guidMember.getMemberNo());
			addLoginCheck.setCycleLoginFailTimes(0);
			addLoginCheck.setLockStatus(LockStatus.NORMAL.toString());
			addLoginCheck.setMemberType(MemberType.GUID.toString());
			loginCheckService.addLoginCheck(addLoginCheck);

			logger.debug("addGuidMember_ec(AddGuidMember) - end - return value={}",addGuidMemberReturn);
			return addGuidMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增导购表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_ADD_ERROR,
					"新增导购表信息错误！", e);
		}
	}


	
}
