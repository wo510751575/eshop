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
import com.lj.business.member.common.MemberConstants;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IGuidMemberDao;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.dto.AddGuidMember;
import com.lj.business.member.dto.AddGuidMemberReturn;
import com.lj.business.member.dto.AddLoginCheck;
import com.lj.business.member.emus.LockStatus;
import com.lj.business.member.emus.MemberType;
import com.lj.eshop.member.service.IEcGuidMemberService;
import com.lj.eshop.member.service.IEcLoginCheckService;
import com.lj.kms.dto.EncryptRequest;
import com.lj.kms.dto.EncryptResponse;
import com.lj.kms.service.IEncryptor;

/**
 * 
 * 类说明：
 *  
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
public class EcGuidMemberServiceImpl implements IEcGuidMemberService {
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(EcGuidMemberServiceImpl.class);

	@Resource
	private IGuidMemberDao guidMemberDao;
	/** The i encryptor. */
	@Resource
	private IEncryptor iEncryptor;
	
	/** The login check service. */
	@Resource
	private IEcLoginCheckService ecLoginCheckService;
	
	/* (non-Javadoc)
	 * @see com.lj.eshop.member.service.IEcGuidMemberService#addGuidMember(com.lj.business.member.dto.AddGuidMember)
	 */
	@Override
	public AddGuidMemberReturn addGuidMember(AddGuidMember addGuidMember)
			throws TsfaServiceException {
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

			// 加密机加密
			EncryptRequest encryptRequest = new EncryptRequest();
			encryptRequest.setAppCode(MemberConstants.ENCRYPT_APPCODE);
			encryptRequest.setOriginalText(addGuidMember.getPwd());

			EncryptResponse encryptResponse = iEncryptor.encrypt(encryptRequest);
			guidMember.setPwd(encryptResponse.getCipherText());
			guidMember.setEncryptionCode(encryptResponse.getEncryptorId());

			guidMemberDao.insert(guidMember);
			AddGuidMemberReturn addGuidMemberReturn = new AddGuidMemberReturn();
			
			// 新增登录检查
			AddLoginCheck addLoginCheck = new AddLoginCheck();
			addLoginCheck.setCode(GUID.generateByUUID());
			addLoginCheck.setMemberNo(guidMember.getMemberNo());
			addLoginCheck.setCycleLoginFailTimes(0);
			addLoginCheck.setLockStatus(LockStatus.NORMAL.toString());
			addLoginCheck.setMemberType(MemberType.GUID.toString());
			ecLoginCheckService.addLoginCheck(addLoginCheck);
			
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

}
