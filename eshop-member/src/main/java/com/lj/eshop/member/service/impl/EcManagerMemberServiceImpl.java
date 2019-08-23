/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.member.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.common.MemberConstants;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IManagerMemberDao;
import com.lj.business.member.domain.ManagerMember;
import com.lj.business.member.dto.AddLoginCheck;
import com.lj.business.member.dto.AddManagerMember;
import com.lj.business.member.dto.AddManagerMemberReturn;
import com.lj.business.member.emus.LockStatus;
import com.lj.business.member.emus.MemberType;
import com.lj.eshop.member.service.IEcLoginCheckService;
import com.lj.eshop.member.service.IEcManagerMemberService;
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
public class EcManagerMemberServiceImpl implements IEcManagerMemberService{
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(EcManagerMemberServiceImpl.class);

	/** The manager member dao. */
	@Resource
	private IManagerMemberDao managerMemberDao;
	/** The i encryptor. */
	@Resource
	private IEncryptor iEncryptor;
	/** The login check service. */
	@Resource
	private IEcLoginCheckService ecLoginCheckService;
	/* (non-Javadoc)
	 * @see com.lj.eshop.member.service.IEcManagerMemberService#addManagerMember(com.lj.business.member.dto.AddManagerMember)
	 */
	@Override
	public AddManagerMemberReturn addManagerMember(
			AddManagerMember addManagerMember) throws TsfaServiceException {
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

			// 加密机加密
			EncryptRequest encryptRequest = new EncryptRequest();
			encryptRequest.setAppCode(MemberConstants.ENCRYPT_APPCODE);
			encryptRequest.setOriginalText(addManagerMember.getPwd());

			EncryptResponse encryptResponse = iEncryptor.encrypt(encryptRequest);
			managerMember.setPwd(encryptResponse.getCipherText());
			managerMember.setEncryptionCode(encryptResponse.getEncryptorId());

			managerMemberDao.insertSelective(managerMember);
			AddManagerMemberReturn addManagerMemberReturn = new AddManagerMemberReturn();

			// 新增登录检查
			AddLoginCheck addLoginCheck = new AddLoginCheck();
			addLoginCheck.setCode(GUID.generateByUUID());
			addLoginCheck.setMemberNo(addManagerMember.getMemberNo());
			addLoginCheck.setCycleLoginFailTimes(0);
			addLoginCheck.setLockStatus(LockStatus.NORMAL.toString());
			addLoginCheck.setMemberType(MemberType.GUID.toString());
			ecLoginCheckService.addLoginCheck(addLoginCheck);

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

}
