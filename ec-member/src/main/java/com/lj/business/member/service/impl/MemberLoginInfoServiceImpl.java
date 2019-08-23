package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
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
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IMemberLoginInfoDao;
import com.lj.business.member.domain.MemberLoginInfo;
import com.lj.business.member.dto.AddMemberLoginInfo;
import com.lj.business.member.dto.AddMemberLoginInfoReturn;
import com.lj.business.member.dto.DelMemberLoginInfo;
import com.lj.business.member.dto.DelMemberLoginInfoReturn;
import com.lj.business.member.dto.FindMemberLoginInfo;
import com.lj.business.member.dto.FindMemberLoginInfoPage;
import com.lj.business.member.dto.FindMemberLoginInfoPageReturn;
import com.lj.business.member.dto.FindMemberLoginInfoReturn;
import com.lj.business.member.dto.UpdateMemberLoginInfo;
import com.lj.business.member.dto.UpdateMemberLoginInfoReturn;
import com.lj.business.member.service.IMemberLoginInfoService;

/**
 * 类说明：登录信息记录
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
public class MemberLoginInfoServiceImpl implements IMemberLoginInfoService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MemberLoginInfoServiceImpl.class);
	

	/** The member login info dao. */
	@Resource
	private IMemberLoginInfoDao memberLoginInfoDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemberLoginInfoService#addMemberLoginInfo(com.lj.business.member.dto.AddMemberLoginInfo)
	 */
	@Override
	public AddMemberLoginInfoReturn addMemberLoginInfo(
			AddMemberLoginInfo addMemberLoginInfo) throws TsfaServiceException {
		logger.debug("addMemberLoginInfo(AddMemberLoginInfo addMemberLoginInfo={}) - start", addMemberLoginInfo); 

		AssertUtils.notNull(addMemberLoginInfo);
		try {
			MemberLoginInfo memberLoginInfo = new MemberLoginInfo();
			//add数据录入
			memberLoginInfo.setCode(GUID.generateByUUID());
			memberLoginInfo.setMemberType(addMemberLoginInfo.getMemberType());
			memberLoginInfo.setMemberNo(addMemberLoginInfo.getMemberNo());
			memberLoginInfo.setIpAddress(addMemberLoginInfo.getIpAddress());
			memberLoginInfo.setMac(addMemberLoginInfo.getMac());
			memberLoginInfo.setNetType(addMemberLoginInfo.getNetType());
			memberLoginInfo.setEquipment(addMemberLoginInfo.getEquipment());
			memberLoginInfo.setAreaInfo(addMemberLoginInfo.getAreaInfo());
			memberLoginInfo.setLoginArea(addMemberLoginInfo.getLoginArea());
			memberLoginInfo.setCreateDate(new Date());
			memberLoginInfoDao.insert(memberLoginInfo);
			AddMemberLoginInfoReturn addMemberLoginInfoReturn = new AddMemberLoginInfoReturn();
			
			logger.debug("addMemberLoginInfo(AddMemberLoginInfo) - end - return value={}", addMemberLoginInfoReturn); 
			return addMemberLoginInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增登录信息记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_LOGIN_INFO_ADD_ERROR,"新增登录信息记录表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemberLoginInfoService#delMemberLoginInfo(com.lj.business.member.dto.DelMemberLoginInfo)
	 */
	@Override
	public DelMemberLoginInfoReturn delMemberLoginInfo(
			DelMemberLoginInfo delMemberLoginInfo) throws TsfaServiceException {
		logger.debug("delMemberLoginInfo(DelMemberLoginInfo delMemberLoginInfo={}) - start", delMemberLoginInfo); 

		AssertUtils.notNull(delMemberLoginInfo);
		AssertUtils.notNull(delMemberLoginInfo.getCode(),"ID不能为空！");
		try {
			memberLoginInfoDao.deleteByPrimaryKey(delMemberLoginInfo.getCode());
			DelMemberLoginInfoReturn delMemberLoginInfoReturn  = new DelMemberLoginInfoReturn();

			logger.debug("delMemberLoginInfo(DelMemberLoginInfo) - end - return value={}", delMemberLoginInfoReturn); //$NON-NLS-1$
			return delMemberLoginInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除登录信息记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_LOGIN_INFO_DEL_ERROR,"删除登录信息记录表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemberLoginInfoService#updateMemberLoginInfo(com.lj.business.member.dto.UpdateMemberLoginInfo)
	 */
	@Override
	public UpdateMemberLoginInfoReturn updateMemberLoginInfo(
			UpdateMemberLoginInfo updateMemberLoginInfo)
			throws TsfaServiceException {
		logger.debug("updateMemberLoginInfo(UpdateMemberLoginInfo updateMemberLoginInfo={}) - start", updateMemberLoginInfo); //$NON-NLS-1$

		AssertUtils.notNull(updateMemberLoginInfo);
		AssertUtils.notNullAndEmpty(updateMemberLoginInfo.getCode(),"ID不能为空");
		try {
			MemberLoginInfo memberLoginInfo = new MemberLoginInfo();
			//update数据录入
			memberLoginInfo.setCode(updateMemberLoginInfo.getCode());
			memberLoginInfo.setMemberType(updateMemberLoginInfo.getMemberType());
			memberLoginInfo.setMemberNo(updateMemberLoginInfo.getMemberNo());
			memberLoginInfo.setIpAddress(updateMemberLoginInfo.getIpAddress());
			memberLoginInfo.setMac(updateMemberLoginInfo.getMac());
			memberLoginInfo.setNetType(updateMemberLoginInfo.getNetType());
			memberLoginInfo.setEquipment(updateMemberLoginInfo.getEquipment());
			memberLoginInfo.setAreaInfo(updateMemberLoginInfo.getAreaInfo());
			memberLoginInfo.setLoginArea(updateMemberLoginInfo.getLoginArea());
			memberLoginInfo.setCreateDate(updateMemberLoginInfo.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(memberLoginInfoDao.updateByPrimaryKeySelective(memberLoginInfo));
			UpdateMemberLoginInfoReturn updateMemberLoginInfoReturn = new UpdateMemberLoginInfoReturn();

			logger.debug("updateMemberLoginInfo(UpdateMemberLoginInfo) - end - return value={}", updateMemberLoginInfoReturn); //$NON-NLS-1$
			return updateMemberLoginInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("登录信息记录表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_LOGIN_INFO_UPDATE_ERROR,"登录信息记录表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemberLoginInfoService#findMemberLoginInfo(com.lj.business.member.dto.FindMemberLoginInfo)
	 */
	@Override
	public FindMemberLoginInfoReturn findMemberLoginInfo(
			FindMemberLoginInfo findMemberLoginInfo) throws TsfaServiceException {
		logger.debug("findMemberLoginInfo(FindMemberLoginInfo findMemberLoginInfo={}) - start", findMemberLoginInfo); //$NON-NLS-1$

		AssertUtils.notNull(findMemberLoginInfo);
		AssertUtils.notAllNull(findMemberLoginInfo.getCode(),"ID不能为空");
		try {
			MemberLoginInfo memberLoginInfo = memberLoginInfoDao.selectByPrimaryKey(findMemberLoginInfo.getCode());
			if(memberLoginInfo == null){
				throw new TsfaServiceException(ErrorCode.MEMBER_LOGIN_INFO_NOT_EXIST_ERROR,"登录信息记录不存在");
			}
			FindMemberLoginInfoReturn findMemberLoginInfoReturn = new FindMemberLoginInfoReturn();
			//find数据录入
			findMemberLoginInfoReturn.setCode(memberLoginInfo.getCode());
			findMemberLoginInfoReturn.setMemberType(memberLoginInfo.getMemberType());
			findMemberLoginInfoReturn.setMemberNo(memberLoginInfo.getMemberNo());
			findMemberLoginInfoReturn.setIpAddress(memberLoginInfo.getIpAddress());
			findMemberLoginInfoReturn.setMac(memberLoginInfo.getMac());
			findMemberLoginInfoReturn.setNetType(memberLoginInfo.getNetType());
			findMemberLoginInfoReturn.setEquipment(memberLoginInfo.getEquipment());
			findMemberLoginInfoReturn.setAreaInfo(memberLoginInfo.getAreaInfo());
			findMemberLoginInfoReturn.setLoginArea(memberLoginInfo.getLoginArea());
			findMemberLoginInfoReturn.setCreateDate(memberLoginInfo.getCreateDate());
			
			logger.debug("findMemberLoginInfo(FindMemberLoginInfo) - end - return value={}", findMemberLoginInfoReturn); //$NON-NLS-1$
			return findMemberLoginInfoReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找登录信息记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_LOGIN_INFO_FIND_ERROR,"查找登录信息记录表信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemberLoginInfoService#findMemberLoginInfoPage(com.lj.business.member.dto.FindMemberLoginInfoPage)
	 */
	@Override
	public Page<FindMemberLoginInfoPageReturn> findMemberLoginInfoPage(
			FindMemberLoginInfoPage findMemberLoginInfoPage)
			throws TsfaServiceException {
		logger.debug("findMemberLoginInfoPage(FindMemberLoginInfoPage findMemberLoginInfoPage={}) - start", findMemberLoginInfoPage); //$NON-NLS-1$

		AssertUtils.notNull(findMemberLoginInfoPage);
		List<FindMemberLoginInfoPageReturn> returnList=null;
		int count = 0;
		try {
			returnList = memberLoginInfoDao.findMemberLoginInfoPage(findMemberLoginInfoPage);
			count = memberLoginInfoDao.findMemberLoginInfoPageCount(findMemberLoginInfoPage);
		}  catch (Exception e) {
			logger.error("登录信息记录表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_LOGIN_INFO_FIND_PAGE_ERROR,"登录信息记录表信息分页查询错误.！",e);
		}
		Page<FindMemberLoginInfoPageReturn> returnPage = new Page<FindMemberLoginInfoPageReturn>(returnList, count, findMemberLoginInfoPage);

		logger.debug("findMemberLoginInfoPage(FindMemberLoginInfoPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
