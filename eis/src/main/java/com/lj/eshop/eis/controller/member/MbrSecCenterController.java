/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.UpdateGuidMember;
import com.lj.business.member.dto.UpdateGuidMemberDto;
import com.lj.business.member.dto.UpdatePwdDto;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.CodeCheckDto;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.MbrSecCenterDto;
import com.lj.eshop.eis.dto.MobilePhoneLoginDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.service.IUserLoginService;
import com.lj.eshop.eis.service.impl.MbrGuidMemberService;
import com.lj.eshop.eis.utils.AuthCodeUtils;
import com.lj.eshop.eis.utils.JsonUtils;
import com.lj.eshop.eis.utils.encryption.EncryptionUtils;
import com.lj.eshop.emus.CodeCheckBizType;
import com.lj.eshop.emus.MessageTemplate;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IMessageService;

/**
 * 
 * 类说明：B端安全中心。
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月4日
 */
@RestController
public class MbrSecCenterController extends BaseController {

	@Autowired
	IMemberService memberService;
	@Autowired
	IAccountService accountService;
	@Autowired
	IUserLoginService userLoginService;
	@Autowired
	IMessageService messageService;
	@Autowired
	IGuidMemberService guidMemberService;// 导购
	@Autowired
	MbrGuidMemberService mbrGuidMemberService;

	/**
	 * 方法说明：安全中心首页。
	 * 
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	@RequestMapping(value = "/mbr/sec/cnt/index", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto index() {
		logger.debug("MbrSecCenterController --> index() - start");
		String mbrCode = getLoginMemberCode();
		MemberDto member = new MemberDto();
		member.setCode(mbrCode);
		// 获取手机号
		MemberDto findMember = memberService.findMember(member);
		AccountDto accountDto = accountService.findAccountByMbrCode(mbrCode);

		MbrSecCenterDto centerDto = new MbrSecCenterDto();
		centerDto.setPhone(findMember.getPhone());
		if (StringUtils.isNotEmpty(accountDto.getPayPwd())) {
			centerDto.setHasPayPwd(true);
		} else {
			centerDto.setHasPayPwd(false);
		}
		// 获取是否设置的密码
		return ResponseDto.successResp(centerDto);
	}

	/**
	 * 方法说明：安全中心认证旧手机号发送验证码。
	 * 
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	@RequestMapping(value = "/mbr/sec/cnt/auth/code", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto sendSms() {
		String mbrCode = getLoginMemberCode();
		MemberDto member = new MemberDto();
		member.setCode(mbrCode);
		// 获取手机号
		MemberDto findMember = memberService.findMember(member);
		CodeCheckDto codeCheckDto = new CodeCheckDto();
		codeCheckDto.setRevicerPhone(findMember.getPhone());
		codeCheckDto.setBizType(CodeCheckBizType.CHANGE_MOBLIE.getValue());
		AuthCodeUtils.sendAuthCode(codeCheckDto);
		return ResponseDto.successResp(null);
	}

	/**
	 * 方法说明：安全中心认证旧手机号发送验证码后验证。
	 * 
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	@RequestMapping(value = "/mbr/sec/cnt/auth/verify", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto vaildAuthCode(CodeCheckDto authCode) {
		if (StringUtils.isEmpty(authCode.getSendCode())) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		String mbrCode = getLoginMemberCode();
		MemberDto member = new MemberDto();
		member.setCode(mbrCode);
		// 获取手机号
		MemberDto findMember = memberService.findMember(member);
		CodeCheckDto codeCheckDto = new CodeCheckDto();
		codeCheckDto.setRevicerPhone(findMember.getPhone());
		codeCheckDto.setBizType(CodeCheckBizType.CHANGE_MOBLIE.getValue());
		AuthCodeUtils.validAuthCode(findMember.getPhone(), CodeCheckBizType.CHANGE_MOBLIE.getValue(),
				authCode.getSendCode(), AuthCodeUtils.AUTH_CODE_VALID_TIME);
		return ResponseDto.successResp(null);
	}

	/**
	 * 方法说明：修改手机号。
	 *
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	@RequestMapping(value = "/mbr/sec/cnt/phone/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto changePhone(MobilePhoneLoginDto updatePhoneDto) {
		if (StringUtils.isEmpty(updatePhoneDto.getMobilePhone()) || StringUtils.isEmpty(updatePhoneDto.getAuthCode())) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		// 一：第一步校验
		AuthCodeUtils.validAuthCode(updatePhoneDto.getMobilePhone(), CodeCheckBizType.CHANGE_MOBLIE.getValue(),
				updatePhoneDto.getAuthCode(), AuthCodeUtils.AUTH_CODE_VALID_TIME);
		// 2.验证手机号是否已存在,或当前本身就是这个手机号
		MemberDto mbr = userLoginService.findMemberDtoByPhone(updatePhoneDto.getMobilePhone());
		if (mbr != null && mbr.getPhone().equals(updatePhoneDto.getMobilePhone())) {
			throw new TsfaServiceException(ResponseCode.PHONE_REPEAT.getCode(), ResponseCode.PHONE_REPEAT.getMsg());
		}
		if (mbr != null) {
			throw new TsfaServiceException(ResponseCode.PHONE_EXIST.getCode(), ResponseCode.PHONE_EXIST.getMsg());
		}
		// 3.修改手机号
		String mbrCode = getLoginMemberCode();
		MemberDto memberDto = new MemberDto();
		memberDto.setCode(mbrCode);
		memberDto.setPhone(updatePhoneDto.getMobilePhone());
		memberService.updateMember(memberDto);
		// 4.同步修改导购的手机号，首次新增导购时设置密码，后续不修改其密码，只修改手机号
		String guidMbr = getLoginMemberCode();
		if (StringUtils.isNotEmpty(guidMbr)) {
			UpdateGuidMember updateGuidMember = new UpdateGuidMember();
			updateGuidMember.setCode(getLoginMemberCode());
			updateGuidMember.setMobile(updatePhoneDto.getMobilePhone());
			guidMemberService.updateGuidMember(updateGuidMember);
		}
		// 5.发送通知信息
		MessageDto messageDto = new MessageDto();
		messageDto.setRecevier(memberDto.getCode());
		messageDto.setcClientMobilePhone(updatePhoneDto.getMobilePhone());
		messageService.addMessageByTemplate(messageDto, MessageTemplate.B_SYS_CHANGE_PASSWORD);

		// 6.返回修改结果
		return ResponseDto.successResp(null);

	}

	/**
	 * 方法说明：修改支付密码。
	 * <p>
	 * md5加密一次明文传输，系统再一次Md5加密密文存贮。
	 * 
	 * @return
	 * @author lhy 2017年9月4日
	 */
	@RequestMapping(value = "/mbr/sec/cnt/paypwd/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto changePayPwd(AccountDto accountDto) {
		if (StringUtils.isEmpty(accountDto.getPayPwd())) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		String mbrCode = getLoginMemberCode();
		// 先找到账户，再修改密码
		AccountDto findAcct = accountService.findAccountByMbrCode(mbrCode);
		AccountDto updateAcct = new AccountDto();
		updateAcct.setMbrCode(mbrCode);
		updateAcct.setPayPwd(EncryptionUtils.md5SavePwd(accountDto.getPayPwd()));
		updateAcct.setCode(findAcct.getCode());
		accountService.updateAccount(updateAcct);

		// 2.发送通知信息
		if (StringUtils.isNotEmpty(findAcct.getPayPwd())) {
			MessageDto messageDto = new MessageDto();
			messageDto.setRecevier(mbrCode);
			messageService.addMessageByTemplate(messageDto, MessageTemplate.B_SYS_WITHDRAW);
		}
		return ResponseDto.successResp(null);
	}

	/**
	 *
	 * 方法说明：找回APP登录密码。
	 * 
	 * @param mobilePhone 手机号 必填
	 * @param authCode    验证码 必填
	 * @param password    新密码 必填 ,规则一次md5加密
	 * @return
	 * @user app
	 * @author lhy 2017年9月22日
	 *
	 */
	@RequestMapping(value = "/mbr/getpass", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto findLoginPwd(MobilePhoneLoginDto pwdDto) {
		mbrGuidMemberService.findLoginPwd(pwdDto);
		return ResponseDto.successResp(null);
	}

	/**
	 * 方法说明：APP修改密码，手机号发送验证码。
	 * 
	 * @return
	 * @user app
	 * @author lhy 2017年9月4日
	 *
	 */
	@RequestMapping(value = "/mbr/updpass/authcode", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto sendUpdLoginPwdSms() {
		String mbrCode = getLoginMemberCode();
		MemberDto member = new MemberDto();
		member.setCode(mbrCode);
		// 获取手机号
		MemberDto findMember = memberService.findMember(member);
		CodeCheckDto codeCheckDto = new CodeCheckDto();
		codeCheckDto.setRevicerPhone(findMember.getPhone());
		codeCheckDto.setBizType(CodeCheckBizType.CHANGE_LOGIN_PWD.getValue());
		AuthCodeUtils.sendAuthCode(codeCheckDto);
		return ResponseDto.successResp(null);
	}

	/**
	 * 方法说明：修改APP登录密码。
	 * 
	 * @param password 登录密码，必填 ,规则一次md5加密
	 * @param authCode 短信验证码，必填
	 * @return
	 * @user app
	 * @author lhy 2017年9月22日
	 *
	 */
	@RequestMapping(value = "/mbr/updpass", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto changeLoginPwd(MobilePhoneLoginDto pwdDto) {
		if (StringUtils.isEmpty(pwdDto.getPassword()) || StringUtils.isEmpty(pwdDto.getAuthCode())) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		String mbrCode = getLoginMemberCode();
		MemberDto member = new MemberDto();
		member.setCode(mbrCode);
		// 获取手机号
		MemberDto findMember = memberService.findMember(member);
		// 1.第一步校验
		AuthCodeUtils.validAuthCode(findMember.getPhone(), CodeCheckBizType.CHANGE_LOGIN_PWD.getValue(),
				pwdDto.getAuthCode(), AuthCodeUtils.AUTH_CODE_VALID_TIME);
		// 2.修改登录密码
		UpdatePwdDto updatePwdDto = new UpdatePwdDto();
		updatePwdDto.setCode(getLoginMemberCode());
		updatePwdDto.setPwd(pwdDto.getPassword());
		guidMemberService.updatePwd(updatePwdDto);

		// 修改密码通知
		MessageDto messageDto = new MessageDto();
		messageDto.setRecevier(mbrCode);
		messageService.addMessageByTemplate(messageDto, MessageTemplate.B_APP_SYS_PASSWORD);

		return ResponseDto.successResp(null);
	}

	/**
	 * 方法说明：我的个人信息-导购。
	 * 
	 * @return
	 * @user app
	 * @author lhy 2017年9月22日
	 *
	 */
	@RequestMapping(value = "/mbr/myinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto myGuidInfo() {
		String mbrCode = getLoginMemberCode();
		FindGuidMember find = new FindGuidMember();
		find.setMemberNo(mbrCode);
		FindGuidMemberReturn mbrRt = guidMemberService.findGuidMember(find);
		mbrRt.setPwd(null);// 密码不返回到前端
		mbrRt.setCreateDate(getLoginShop().getOpenTime());
		return ResponseDto.successResp(mbrRt);
	}

	/**
	 * 方法说明：修改我的个人信息-导购。
	 * 
	 * @return
	 * @user app
	 * @author lhy 2017年9月22日
	 *
	 */
	@RequestMapping(value = "/mbr/myinfo/upd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto updateMyGuidInfo(String paramJson) {
		logger.info("updateMyGuidInfo(String paramJson={}) - start", paramJson); //$NON-NLS-1$
		if (StringUtils.isEmpty(paramJson)) {
			throw new TsfaServiceException(ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg());
		}
		UpdateGuidMemberDto dto = JsonUtils.toObj(paramJson, UpdateGuidMemberDto.class);
		logger.info("dto.getHeadAddress={}", dto.getHeadAddress()); //$NON-NLS-1$
		// 姓名 性别 邮箱 地区 头像
//		if(StringUtils.isEmpty(dto.getMemberName())
//				/*|| StringUtils.isEmpty(dto.getGender())*/
//				/*|| StringUtils.isEmpty(dto.getEmail())*/
//				/*|| StringUtils.isEmpty(dto.getProvinceCode())*/
//				/*|| StringUtils.isEmpty(dto.getCityCode())*/
//				/*|| StringUtils.isEmpty(dto.getCityAreaCode())*/
//				/*|| StringUtils.isEmpty(dto.getHeadAddress())*/
//				/*|| StringUtils.isEmpty(dto.getAddress())*/
//				){
//			throw new TsfaServiceException(ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg());
//		}
		mbrGuidMemberService.updateMember(dto);
		return ResponseDto.successResp(null);
	}

	/**
	 *
	 * 方法说明：修改电商H5个人头像。
	 *
	 * @param img 头像
	 * @return
	 *
	 * @author lhy 2017年9月28日
	 *
	 */
	@RequestMapping(value = "/mbr/img/upd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto updateMyHeadImg(String img) {
		if (StringUtils.isEmpty(img)) {
			throw new TsfaServiceException(ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg());
		}
		UpdateGuidMemberDto dto = new UpdateGuidMemberDto();
		dto.setHeadAddress(img); // 修改头像
		mbrGuidMemberService.updateMember(dto);
		return ResponseDto.successResp(null);
	}

	public static void main(String[] args) {
		UpdateGuidMemberDto update = new UpdateGuidMemberDto();
		update.setAddress("南山区科技园99");
		update.setCityAreaCode("33");
		update.setCityCode("22");
		update.setProvinceCode("11");
		update.setEmail("1008601@qq.com");
		update.setGender("FEMALE");
		update.setHeadAddress("/test.jpg");
		update.setMemberName("萧华");
		String json = JsonUtils.toJSON(update);
		System.out.println(json);
		UpdateGuidMemberDto obj = JsonUtils.toObj(json, UpdateGuidMemberDto.class);
		System.out.println(obj.getAddress());

	}
}
