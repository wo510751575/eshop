package com.lj.business.member.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.common.RiskControlParam;
import com.lj.business.common.SystemParamConstant;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IGuidMemberDao;
import com.lj.business.member.dao.ILoginCheckDao;
import com.lj.business.member.dao.IManagerMemberDao;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.domain.LoginCheck;
import com.lj.business.member.domain.ManagerMember;
import com.lj.business.member.dto.AddMemberLoginInfo;
import com.lj.business.member.dto.FindManagerMemberPage;
import com.lj.business.member.dto.FindManagerMemberPageReturn;
import com.lj.business.member.dto.PersonMemberLogin;
import com.lj.business.member.dto.PersonMemberLoginReturn;
import com.lj.business.member.emus.LockStatus;
import com.lj.business.member.emus.MemberStatus;
import com.lj.business.member.emus.MemberType;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IManagerMemberService;
import com.lj.business.member.service.IMemberLoginInfoService;
import com.lj.business.member.service.IMemberLoginService;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.cc.enums.SystemAliasName;


/**
 * 类说明：会员登录
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author LeoPeng
 * 
 * 
 * CreateDate: 2017-6-4
 */
@Service
public class MemberLoginServiceImpl implements IMemberLoginService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MemberLoginServiceImpl.class);



	/** 导购. */
	@Resource
	private IGuidMemberDao guidMemberDao;

	/** The login check dao. */
	@Resource
	private ILoginCheckDao loginCheckDao;

	/** The manager member dao. */
	@Resource
	private IManagerMemberDao managerMemberDao;

	/** The member login info service. */
	@Resource
	private IMemberLoginInfoService memberLoginInfoService;

	/** The local cache system params. */
	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	@Resource
	private IManagerMemberService managerMemberService;
	@Resource
	private IGuidMemberService guidMemberService;

	/**
	 * APP登录（优先店长身份，校验手机串号）.
	 *
	 * @param personMemberLogin the person member login
	 * @return the person member login return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public PersonMemberLoginReturn personMemberLoginAPP(
			PersonMemberLogin personMemberLogin) throws TsfaServiceException {
		logger.debug("personMemberLogin(PersonMemberLogin personMemberLogin=" + personMemberLogin + ") - start"); //$NON-NLS-1$ //$NON-NLS-2$
		String mobile =personMemberLogin.getMobile();
		String pwd = personMemberLogin.getPwd();
		String imei = personMemberLogin.getImei();
		PersonMemberLoginReturn personMemberLoginReturn = null;

		try{
			ManagerMember record = new ManagerMember();
			record.setMobile(mobile);
			//获取管理人员信息
			ManagerMember managerMember = managerMemberDao.findManagerMember(record);
			if(managerMember == null){//导购登录
				personMemberLoginReturn = guidLogin(personMemberLogin, mobile,pwd, imei);
			}else{//管理人员登录
				personMemberLoginReturn = manageLogin(personMemberLogin, pwd,imei, managerMember);
			}
			String uploadUrl =  localCacheSystemParams.getSystemParam(SystemAliasName.ms.toString(),SystemParamConstant.UPLOAD_GROUP, SystemParamConstant.UPLOAD_URL);
			personMemberLoginReturn.setUploadUrl(uploadUrl);
			
			String wxUpdateUrl =  localCacheSystemParams.getSystemParam(SystemAliasName.api.toString(),SystemParamConstant.GRP_MOBILE_VERSION, SystemParamConstant.ANDROID_WX_DOWNLOAD_URL);
			personMemberLoginReturn.setWxUpdateUrl(wxUpdateUrl);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("个人会员登录错误！",e);
			throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR,"个人会员登录错误！",e);
		}

		logger.debug("personMemberLoginAPP(PersonMemberLogin) - end - return value={}", personMemberLoginReturn); //$NON-NLS-1$
		return personMemberLoginReturn;
	}


	/**
	 * 
	 *
	 * 方法说明：管理人员登录
	 *
	 * @param personMemberLogin
	 * @param pwd
	 * @param imei
	 * @param managerMember
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月20日
	 *
	 */
	private PersonMemberLoginReturn manageLogin(
			PersonMemberLogin personMemberLogin, String pwd, String imei,
			ManagerMember managerMember) {
		PersonMemberLoginReturn personMemberLoginReturn;
		if(MemberStatus.FREEZE.toString().equals(managerMember.getStatus())){
			logger.error("个人会员登录错误：会员被冻结！");
			throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_FREEZE,"个人会员登录错误：会员被冻结！");
		}
		if(MemberStatus.CANCEL.toString().equals(managerMember.getStatus())){
			logger.error("个人会员登录错误：会员被注销！");
			throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_FREEZE,"个人会员登录错误：会员被注销！");
		}
		//暂时注释，不判断IMEI
		/*if(StringUtils.isEmpty(imei) || !managerMember.getImei().equals(imei)){
			logger.error("个人会员登录错误：不是本人手机！");
			throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_MOBILE,"个人会员登录错误：不是本人手机！");
		}*/

		//登录密码锁定时间（小时）
		String loginPasswordLockTimeStr = localCacheSystemParams.getSystemParam(RiskControlParam.GroupName,RiskControlParam.LoginPasswordLockTime);
		LoginCheck findLoginCheck = new LoginCheck();
		findLoginCheck.setMemberNo(managerMember.getMemberNo());

		LoginCheck loginCheck = loginCheckDao.findLoginCheck(findLoginCheck);
		//登录密码连续输入错误次数
		if(loginCheck.getCycleLoginFailTimes() == null) loginCheck.setCycleLoginFailTimes(0);
		Integer cycleLoginFailTimes = loginCheck.getCycleLoginFailTimes();
		Date lastLoginErrorDate = loginCheck.getLastLoginErrorDate();
		Date now = new Date();

		//会员是自动锁定
		if(LockStatus.AUTOLOCK.toString().equals(loginCheck.getLockStatus())){
			if(lastLoginErrorDate != null){
				double loginPasswordLockTime = Double.valueOf(loginPasswordLockTimeStr);
				logger.debug("登录冻结时间，loginPasswordLockTime:" + loginPasswordLockTime);
				double loginFreezeDisTime = ((double)(System.currentTimeMillis() - lastLoginErrorDate.getTime()))/(1000*60*60);
				logger.debug("登录冻结时间差，loginFreezeDisTime:" + loginFreezeDisTime +"小时");
				if(loginFreezeDisTime < loginPasswordLockTime){
					//如果没有超过冻结时间
					logger.error("个人会员登录错误：登录失败次数过多，会员被登录锁定！");
					throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_AUTOLOCK,"登录失败次数过多，会员被登录锁定！");
				}else{
					//如果超过冻结时间，重新计算错误次数，并解除登录冻结
					logger.debug("超过冻结时间，重新计算错误次数，并解除登录冻结");
					cycleLoginFailTimes = 0;
				}
			}
		}



		//登录成功
		logger.debug("登录成功，更新最后一次登录时间及会员锁定状态,");
		cycleLoginFailTimes = 0;
		ManagerMember managerMemberUpdateTemp = new ManagerMember();
		managerMemberUpdateTemp.setCode(managerMember.getCode());
		managerMemberUpdateTemp.setStatus(LockStatus.NORMAL.toString());//解除登录冻结
		managerMemberDao.updateByPrimaryKeySelective(managerMemberUpdateTemp);
		//更新错误次数
		loginCheck.setCycleLoginFailTimes(cycleLoginFailTimes);
		loginCheck.setLastLoginErrorDate(now);
		loginCheckDao.updateByPrimaryKeySelective(loginCheck);

		//获取导购信息
		personMemberLoginReturn = new PersonMemberLoginReturn();
		GuidMember recordGuidMember = new GuidMember();
		recordGuidMember.setMobile(personMemberLogin.getMobile());
		GuidMember guidMember = guidMemberDao.findGuidMember(recordGuidMember);
		if(guidMember == null){
			logger.error("店长没有导购信息！！");
		}else{
			personMemberLoginReturn.setMemberNoGuid(guidMember.getMemberNo());//导购编号
			personMemberLoginReturn.setMemberNameGuid(guidMember.getMemberName());//导购姓名
			personMemberLoginReturn.setQcord(guidMember.getQcord());//导购二维码
		}

		//登录返回信息
		personMemberLoginReturn.setCode(managerMember.getCode());
		personMemberLoginReturn.setMemberNoMerchant(managerMember.getMemberNoMerchant());
		personMemberLoginReturn.setMemberNameMerchant(managerMember.getMemberNameMerchant());
		personMemberLoginReturn.setMemberNoShop(managerMember.getMemberNo());
		personMemberLoginReturn.setMemberNameShop(managerMember.getMemberName());
		personMemberLoginReturn.setMemberType(managerMember.getMemberType());
		personMemberLoginReturn.setShopNo(managerMember.getMemberNoShop());
		personMemberLoginReturn.setShopName(managerMember.getMemberNameShop());

		personMemberLoginReturn.setMobile(managerMember.getMobile());
		personMemberLoginReturn.setEmail(managerMember.getEmail());
		personMemberLoginReturn.setProvinceCode(managerMember.getProvinceWx());
		personMemberLoginReturn.setCityCode(managerMember.getCityWx());
		personMemberLoginReturn.setAreaCode(managerMember.getAreaCode());
		personMemberLoginReturn.setHeadAddress(managerMember.getHeadAddress());
		personMemberLoginReturn.setGender(managerMember.getSex());
		personMemberLoginReturn.setWorkDate(managerMember.getWorkDate());
		personMemberLoginReturn.setStatus(managerMember.getStatus());
		personMemberLoginReturn.setNoWx(managerMember.getNoWx());

		//新增登录记录
		AddMemberLoginInfo addMemberLoginInfo = new AddMemberLoginInfo();
		addMemberLoginInfo.setMemberType(managerMember.getMemberType());
		addMemberLoginInfo.setMemberNo(managerMember.getMemberNo());
		addMemberLoginInfo.setIpAddress(personMemberLogin.getIpAddress());
		addMemberLoginInfo.setMac(personMemberLogin.getMac());
		addMemberLoginInfo.setNetType(personMemberLogin.getNetType());
		addMemberLoginInfo.setEquipment(personMemberLogin.getEquipment());
		addMemberLoginInfo.setAreaInfo(personMemberLogin.getAreaInfo());
		addMemberLoginInfo.setLoginArea(personMemberLogin.getLoginArea());
		addMemberLoginInfo(addMemberLoginInfo);
		return personMemberLoginReturn;
	}


	/**
	 * 
	 *
	 * 方法说明：导购登录
	 *
	 * @param personMemberLogin
	 * @param mobile
	 * @param pwd
	 * @param imei
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月20日
	 *
	 */
	private PersonMemberLoginReturn guidLogin(
			PersonMemberLogin personMemberLogin, String mobile, String pwd,
			String imei) {
		PersonMemberLoginReturn personMemberLoginReturn;

		//获取导购信息
		GuidMember recordGuidMember = new GuidMember();
		recordGuidMember.setMobile(mobile);
		GuidMember guidMember = guidMemberDao.findGuidMember(recordGuidMember);

		if(guidMember == null){
			logger.info("个人会员登录错误：会员不存在！");
			throw new TsfaServiceException(ErrorCode.PERSON_ERROR_NOT_EXIST,"个人会员登录错误：会员不存在！");
		}

		if(MemberStatus.FREEZE.toString().equals(guidMember.getStatus())){
			logger.error("个人会员登录错误：会员被冻结！");
			throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_FREEZE,"个人会员登录错误：会员被冻结！");
		}
		if(MemberStatus.CANCEL.toString().equals(guidMember.getStatus())){
			logger.error("个人会员登录错误：会员被注销！");
			throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_FREEZE,"个人会员登录错误：会员被注销！");
		}

		//暂时注释，不判断IMEI
		/*if(StringUtils.isEmpty(imei) || !guidMember.getImei().equals(imei)){
			logger.error("个人会员登录错误：不是本人手机！");
			throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_CANCEL,"个人会员登录错误：不是本人手机！");
		}*/

		//登录密码锁定时间（小时）
		String loginPasswordLockTimeStr = localCacheSystemParams.getSystemParam(RiskControlParam.GroupName,RiskControlParam.LoginPasswordLockTime);
		LoginCheck findLoginCheck = new LoginCheck();
		findLoginCheck.setMemberNo(guidMember.getMemberNo());

		LoginCheck loginCheck = loginCheckDao.findLoginCheck(findLoginCheck);
		//登录密码连续输入错误次数
		if(loginCheck.getCycleLoginFailTimes() == null)
			loginCheck.setCycleLoginFailTimes(0);
		Integer cycleLoginFailTimes = loginCheck.getCycleLoginFailTimes();
		Date lastLoginErrorDate = loginCheck.getLastLoginErrorDate();
		Date now = new Date();

		if(LockStatus.AUTOLOCK.toString().equals(loginCheck.getLockStatus())){
			if(lastLoginErrorDate != null){
				double loginPasswordLockTime = Double.valueOf(loginPasswordLockTimeStr);
				logger.debug("登录冻结时间，loginPasswordLockTime:" + loginPasswordLockTime);
				double loginFreezeDisTime = ((double)(System.currentTimeMillis() - lastLoginErrorDate.getTime()))/(1000*60*60);
				logger.debug("登录冻结时间差，loginFreezeDisTime:" + loginFreezeDisTime +"小时");
				if(loginFreezeDisTime < loginPasswordLockTime){
					//如果没有超过冻结时间
					logger.error("个人会员登录错误：登录失败次数过多，会员被登录锁定！");
					throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_AUTOLOCK,"登录失败次数过多，会员被登录锁定！");
				}else{
					//如果超过冻结时间，重新计算错误次数，并解除登录冻结
					logger.debug("超过冻结时间，重新计算错误次数，并解除登录冻结");
					cycleLoginFailTimes = 0;
				}
			}
		}



		//登录成功
		logger.debug("登录成功，更新最后一次登录时间及会员锁定状态,");
		cycleLoginFailTimes = 0;
		GuidMember personMemberUpdate = new GuidMember();
		personMemberUpdate.setCode(guidMember.getCode());
		personMemberUpdate.setStatus(LockStatus.NORMAL.toString());//解除登录冻结
		guidMemberDao.updateByPrimaryKeySelective(personMemberUpdate);
		//更新错误次数
		loginCheck.setCycleLoginFailTimes(cycleLoginFailTimes);
		loginCheck.setLastLoginErrorDate(now);
		loginCheckDao.updateByPrimaryKeySelective(loginCheck);

		personMemberLoginReturn = new PersonMemberLoginReturn();

		//店长信息录入
		FindManagerMemberPage managerMemberQuery = new FindManagerMemberPage();
		managerMemberQuery.setMemberNoShop(guidMember.getShopNo());
		managerMemberQuery.setMemberType(MemberType.SHOP.toString());
		List<FindManagerMemberPageReturn> listManagerMember = managerMemberDao.findManagerMembers(managerMemberQuery);
		if(listManagerMember.size() > 1){
			logger.error("导购有2个以上的店长信息！！");
		}else if(listManagerMember.size() == 0 ){
			logger.debug("导购没有店长信息！！");
		}else{
			FindManagerMemberPageReturn findManagerMemberPageReturn = listManagerMember.get(0);
			personMemberLoginReturn.setMemberNoShop(findManagerMemberPageReturn.getMemberNo());//店长编号
			personMemberLoginReturn.setMemberNameShop(findManagerMemberPageReturn.getMemberName());//店长姓名
		}


		//登录返回信息
		personMemberLoginReturn.setCode(guidMember.getCode());
		personMemberLoginReturn.setMemberNoGuid(guidMember.getMemberNo());
		personMemberLoginReturn.setMemberNameGuid(guidMember.getMemberName());
		personMemberLoginReturn.setMemberNoMerchant(guidMember.getMerchantNo());
		personMemberLoginReturn.setMemberNameMerchant(guidMember.getMerchantName());
		personMemberLoginReturn.setShopNo(guidMember.getShopNo());
		personMemberLoginReturn.setShopName(guidMember.getShopName());

		personMemberLoginReturn.setMobile(guidMember.getMobile());
		personMemberLoginReturn.setEmail(guidMember.getEmail());
		personMemberLoginReturn.setProvinceCode(guidMember.getProvinceCode());
		personMemberLoginReturn.setCityCode(guidMember.getCityCode());
		personMemberLoginReturn.setAreaCode(guidMember.getAreaCode());
		personMemberLoginReturn.setHeadAddress(guidMember.getHeadAddress());
		personMemberLoginReturn.setGender(guidMember.getGender());
		personMemberLoginReturn.setMemberType("GUID");
		personMemberLoginReturn.setWorkDate(guidMember.getWorkDate());
		personMemberLoginReturn.setQcord(guidMember.getQcord());
		personMemberLoginReturn.setStatus(guidMember.getStatus());
		personMemberLoginReturn.setNoWx(guidMember.getNoWx());
		//新增登录记录
		AddMemberLoginInfo addMemberLoginInfo = new AddMemberLoginInfo();				
		addMemberLoginInfo.setMemberType(MemberType.GUID.toString());
		addMemberLoginInfo.setMemberNo(guidMember.getMemberNo());
		addMemberLoginInfo.setIpAddress(personMemberLogin.getIpAddress());
		addMemberLoginInfo.setMac(personMemberLogin.getMac());
		addMemberLoginInfo.setNetType(personMemberLogin.getNetType());
		addMemberLoginInfo.setEquipment(personMemberLogin.getEquipment());
		addMemberLoginInfo.setAreaInfo(personMemberLogin.getAreaInfo());
		addMemberLoginInfo.setLoginArea(personMemberLogin.getLoginArea());
		addMemberLoginInfo(addMemberLoginInfo);
		return personMemberLoginReturn;
	}


	/**
	 * H5登录（BOOS，区域经理，店长）
	 * 不校验手机串号（前端拿不到）.
	 *	如果既有openIdGzhWx ，也有手机号，视为第一次登录
	 * 	如果只有openIdGzhWx ，没有手机号，视为微信自动登录
	 *
	 * @param personMemberLogin the person member login
	 * @return the person member login return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public PersonMemberLoginReturn personMemberLoginH5(
			PersonMemberLogin personMemberLogin) throws TsfaServiceException {
		logger.debug("personMemberLoginH5(PersonMemberLogin personMemberLogin={}) - start", personMemberLogin); //$NON-NLS-1$

		AssertUtils.notNull(personMemberLogin);
		//AssertUtils.notAllNullAndEmpty(personMemberLogin.getMobile(), personMemberLogin.getOpenIdGzhWx(),"手机号、公众号OPENID不能全部为空！");
		PersonMemberLoginReturn personMemberLoginReturn = null;
		String mobile =personMemberLogin.getMobile();
		String pwd = personMemberLogin.getPwd();
		String openIdGzhWx = personMemberLogin.getOpenIdGzhWx();
		try{
			if(StringUtils.isEmpty(personMemberLogin.getMobile()) && StringUtils.isEmpty(personMemberLogin.getOpenIdGzhWx()) ){
				logger.error("手机号、公众号OPENID全部为空，直接返回NULL，提示前端需要账号密码登录");
				throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_PSW_LOGIN,"个人会员登录错误：需要密码登录");
			}
			ManagerMember managerMember = null;

			//如果只有openIdGzhWx ，没有手机号，视为微信自动登录
			if(!StringUtils.isEmpty(openIdGzhWx) && StringUtils.isEmpty(mobile)){
				ManagerMember record = new ManagerMember();
				record.setOpenIdGzhWx(openIdGzhWx);
				//获取管理人员信息
				managerMember = managerMemberDao.findManagerMember(record);
				if(managerMember == null)//如果openIdGzhWx对应的数据不存在，返回NULL，需要用户重新登录
					throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_PSW_LOGIN,"个人会员登录错误：需要密码登录");
				
				if(MemberStatus.FREEZE.toString().equals(managerMember.getStatus())){
					logger.error("个人会员登录错误：会员被冻结！");
					throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_FREEZE,"个人会员登录错误：会员被冻结！");
				}
			}
			
			//如果既有openIdGzhWx(有可能无法获取) ，也有手机号，视为第一次登录
			if(!StringUtils.isEmpty(mobile)){
				ManagerMember record = new ManagerMember();
				record.setMobile(mobile);
				//获取管理人员信息
				managerMember = managerMemberDao.findManagerMember(record);
				
				if(managerMember == null){
					logger.info("个人会员登录错误：会员不存在！");
					throw new TsfaServiceException(ErrorCode.PERSON_ERROR_NOT_EXIST,"个人会员登录错误：会员不存在！");
				}
				if(MemberStatus.FREEZE.toString().equals(managerMember.getStatus())){
					logger.error("个人会员登录错误：会员被冻结！");
					throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_FREEZE,"个人会员登录错误：会员被冻结！");
				}

				//登录密码锁定时间（小时）
				String loginPasswordLockTimeStr = localCacheSystemParams.getSystemParam(RiskControlParam.GroupName,RiskControlParam.LoginPasswordLockTime);
				LoginCheck findLoginCheck = new LoginCheck();
				findLoginCheck.setMemberNo(managerMember.getMemberNo());

				LoginCheck loginCheck = loginCheckDao.findLoginCheck(findLoginCheck);
				//登录密码连续输入错误次数
				if(loginCheck.getCycleLoginFailTimes() == null) loginCheck.setCycleLoginFailTimes(0);
				Integer cycleLoginFailTimes = loginCheck.getCycleLoginFailTimes();
				Date lastLoginErrorDate = loginCheck.getLastLoginErrorDate();
				Date now = new Date();

				//会员是自动锁定
				if(LockStatus.AUTOLOCK.toString().equals(loginCheck.getLockStatus())){
					if(lastLoginErrorDate != null){
						double loginPasswordLockTime = Double.valueOf(loginPasswordLockTimeStr);
						logger.debug("登录冻结时间，loginPasswordLockTime:" + loginPasswordLockTime);
						double loginFreezeDisTime = ((double)(System.currentTimeMillis() - lastLoginErrorDate.getTime()))/(1000*60*60);
						logger.debug("登录冻结时间差，loginFreezeDisTime:" + loginFreezeDisTime +"小时");
						if(loginFreezeDisTime < loginPasswordLockTime){
							//如果没有超过冻结时间
							logger.error("个人会员登录错误：登录失败次数过多，会员被登录锁定！");
							throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_AUTOLOCK,"登录失败次数过多，会员被登录锁定！");
						}else{
							//如果超过冻结时间，重新计算错误次数，并解除登录冻结
							logger.debug("超过冻结时间，重新计算错误次数，并解除登录冻结");
							cycleLoginFailTimes = 0;
						}
					}
				}



				//登录成功
				logger.debug("登录成功，更新最后一次登录时间及会员锁定状态,");
				cycleLoginFailTimes = 0;
				ManagerMember managerMemberUpdateTemp = new ManagerMember();
				managerMemberUpdateTemp.setCode(managerMember.getCode());
				managerMemberUpdateTemp.setStatus(LockStatus.NORMAL.toString());//解除登录冻结
				if(!StringUtils.isEmpty(openIdGzhWx))
					managerMemberUpdateTemp.setOpenIdGzhWx(openIdGzhWx);//更新公众号
				managerMemberDao.updateByPrimaryKeySelective(managerMemberUpdateTemp);
				//更新错误次数
				loginCheck.setCycleLoginFailTimes(cycleLoginFailTimes);
				loginCheck.setLastLoginErrorDate(now);
				loginCheckDao.updateByPrimaryKeySelective(loginCheck);
			}
			

			//登录返回信息
			personMemberLoginReturn = new PersonMemberLoginReturn();
			personMemberLoginReturn.setCode(managerMember.getCode());

			//获取导购信息
			GuidMember recordGuidMember = new GuidMember();
			recordGuidMember.setMobile(mobile);
			GuidMember guidMember = guidMemberDao.findGuidMember(recordGuidMember);
			if(guidMember!=null){
				personMemberLoginReturn.setMemberNoGuid(guidMember.getMemberNo());
				personMemberLoginReturn.setMemberNameGuid(guidMember.getMemberName());
			}
			personMemberLoginReturn.setMobile(managerMember.getMobile());
			personMemberLoginReturn.setEmail(managerMember.getEmail());
			personMemberLoginReturn.setProvinceCode(managerMember.getProvinceCode());
			personMemberLoginReturn.setCityCode(managerMember.getCityCode());
			personMemberLoginReturn.setAreaCode(managerMember.getAreaCode());
			personMemberLoginReturn.setHeadAddress(managerMember.getHeadAddress());
			personMemberLoginReturn.setGender(managerMember.getSex());
			personMemberLoginReturn.setMemberNoMerchant(managerMember.getMemberNoMerchant());
			personMemberLoginReturn.setMemberNameMerchant(managerMember.getMemberNameMerchant());
			personMemberLoginReturn.setMemberNoShop(managerMember.getMemberNo());
			personMemberLoginReturn.setMemberNameShop(managerMember.getMemberName());
			personMemberLoginReturn.setMemberType(managerMember.getMemberType());
			personMemberLoginReturn.setWorkDate(managerMember.getWorkDate());
			personMemberLoginReturn.setStatus(managerMember.getStatus());
			personMemberLoginReturn.setShopNo(managerMember.getMemberNoShop());
			personMemberLoginReturn.setShopName(managerMember.getMemberNameShop());
			String uploadUrl =  localCacheSystemParams.getSystemParam(SystemAliasName.ms.toString(),SystemParamConstant.UPLOAD_GROUP, SystemParamConstant.UPLOAD_URL);
			personMemberLoginReturn.setUploadUrl(uploadUrl);
			//新增登录记录
			AddMemberLoginInfo addMemberLoginInfo = new AddMemberLoginInfo();
			addMemberLoginInfo.setMemberType(managerMember.getMemberType());
			addMemberLoginInfo.setMemberNo(managerMember.getMemberNo());
			addMemberLoginInfo.setIpAddress(personMemberLogin.getIpAddress());
			addMemberLoginInfo.setMac(personMemberLogin.getMac());
			addMemberLoginInfo.setNetType(personMemberLogin.getNetType());
			addMemberLoginInfo.setEquipment(personMemberLogin.getEquipment());
			addMemberLoginInfo.setAreaInfo(personMemberLogin.getAreaInfo());
			addMemberLoginInfo.setLoginArea(personMemberLogin.getLoginArea());
			addMemberLoginInfo(addMemberLoginInfo);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("个人会员登录错误！",e);
			throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR,"个人会员登录错误！",e);

		}

		logger.debug("personMemberLogin(PersonMemberLogin) - end"); //$NON-NLS-1$
		return personMemberLoginReturn;
	}


	/**
	 * 方法说明：添加用户登录记录.
	 *
	 * @param addMemberLoginInfo the add member login info
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年6月20日
	 */
	private void addMemberLoginInfo(AddMemberLoginInfo addMemberLoginInfo) throws TsfaServiceException {
		logger.debug("addMemberLoginInfo(AddMemberLoginInfo addMemberLoginInfo={}) - start", addMemberLoginInfo); //$NON-NLS-1$

		try{
			memberLoginInfoService.addMemberLoginInfo(addMemberLoginInfo);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("添加会员登录信息错误",e);
			throw new TsfaServiceException(ErrorCode.PERSON_ADD_LOGIN_INFO_ERROR,"添加会员登录信息错误",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemberLoginService#updatePwd(com.lj.business.member.dto.UpdatePwdDto)
	 */
	/*@Override
	public void updatePwd(UpdatePwdDto updatePwdDto)
			throws TsfaServiceException {
		logger.debug("updatePwd(UpdatePwdDto updatePwdDto=" + updatePwdDto + ") - start"); //$NON-NLS-1$ //$NON-NLS-2$

		String mobile =updatePwdDto.getMobile();
		String merchantNo =updatePwdDto.getMerchantNo();
		AssertUtils.notNullAndEmpty(mobile,"手机号不能为空");
		AssertUtils.notNullAndEmpty(merchantNo,"商户编号不能为空");
		try{
			String validateCode = "123456";		
			if(!updatePwdDto.getValidateCode().equals(validateCode)){
				logger.error("验证码错误！");
				throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR_PSW,"验证码错误");
			}

			//获取导购信息
			GuidMember recordGuidMember = new GuidMember();
			recordGuidMember.setMobile(mobile);
			recordGuidMember.setMerchantNo(merchantNo);
			GuidMember guidMember = guidMemberDao.findGuidMember(recordGuidMember);

			//获取管理人员信息
			ManagerMember record = new ManagerMember();
			record.setMobile(mobile);
			record.setMemberNoMerchant(merchantNo);
			ManagerMember managerMember = managerMemberDao.findManagerMember(record);

			if(guidMember==null && managerMember==null){
				logger.info("用户不存在！");
				throw new TsfaServiceException(ErrorCode.PERSON_ERROR_NOT_EXIST,"用户不存在！"); 
			}

			//XXX LEOPENG 待完善，管理员、导购优先级问题
			if(guidMember!=null){
				//密码检测 前台会做一次MD5
				updatePwdDto.setCode(guidMember.getCode());
				guidMemberService.updatePwd(updatePwdDto);
			}

			if(managerMember!=null){
				updatePwdDto.setCode(managerMember.getCode());
				managerMemberService.updatePwd(updatePwdDto);
			}
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("修改登录密码错误！",e);
			throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR,"修改登录密码错误！",e);
		}
	}*/


	@Override
	public String getValideCode(String mobile) throws TsfaServiceException {
		logger.debug("getValideCode(String mobile=" + mobile + ") - start"); //$NON-NLS-1$ //$NON-NLS-2$
		AssertUtils.notNullAndEmpty(mobile,"手机号不能为空");
		try{
			String validateCode = "123456";		//TODO 获取短信验证码

			//获取导购信息
			GuidMember recordGuidMember = new GuidMember();
			recordGuidMember.setMobile(mobile);
			GuidMember guidMember = guidMemberDao.findGuidMember(recordGuidMember);

			//获取管理人员信息
			ManagerMember record = new ManagerMember();
			record.setMobile(mobile);
			ManagerMember managerMember = managerMemberDao.findManagerMember(record);

			if(guidMember==null && managerMember==null){
				logger.info("用户不存在！");
				throw new TsfaServiceException(ErrorCode.PERSON_ERROR_NOT_EXIST,"用户不存在！"); 
			}
			return validateCode;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("修改登录密码错误！",e);
			throw new TsfaServiceException(ErrorCode.PERSON_LOGIN_ERROR,"修改登录密码错误！",e);
		}
	}



}
