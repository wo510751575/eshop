package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Test;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.dto.PersonMemberLogin;
import com.lj.business.member.dto.PersonMemberLoginReturn;
import com.lj.business.member.service.IMemberLoginService;


/**
 * 
 * 
 * 类说明：登录测试用例
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年6月24日
 */
public class MemberLoginServiceImplTest extends SpringTestCase{

	@Resource
	IMemberLoginService loginService;
	

	/**
	 * 
	 *
	 * 方法说明：APP登录
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年6月26日
	 *
	 */
	@Test
	public void loginApp() throws TsfaServiceException{
		PersonMemberLogin personMemberLogin = new PersonMemberLogin();
		personMemberLogin.setMobile("18665435142");
		personMemberLogin.setPwd("cb243e32ab946f8bf55756e67f742ebf");
		personMemberLogin.setImei("99000987075234");
		//System.out.println("MD5+++++++"+MD5.encryptByMD5("123456").equals("e10adc3949ba59abbe56e057f20f883e"));
		PersonMemberLoginReturn loginReturn =loginService.personMemberLoginAPP(personMemberLogin);
		System.out.println(loginReturn.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：H5登录
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年6月26日
	 *
	 */
	@Test
	public void loginH5() throws TsfaServiceException{
		PersonMemberLogin personMemberLogin = new PersonMemberLogin();
		personMemberLogin.setMobile("18665435142");
		personMemberLogin.setPwd("cb243e32ab946f8bf55756e67f742ebf");
		//System.out.println("MD5+++++++"+MD5.encryptByMD5("123456").equals("e10adc3949ba59abbe56e057f20f883e"));
		PersonMemberLoginReturn loginReturn =loginService.personMemberLoginH5(personMemberLogin);
		System.out.println(loginReturn.toString());
	}
	
	/*@Test
	public void updatePwd() throws TsfaServiceException{
		UpdatePwdDto updatePwdDto = new UpdatePwdDto();
		updatePwdDto.setMobile("18665435142");
		updatePwdDto.setMerchantNo(TestHelp.merchantNo_test);
//		updatePwdDto.setPwd(MD5.encryptByMD5("435143"));
		updatePwdDto.setPwd(MD5.encryptByMD5("435142"));
		updatePwdDto.setValidateCode("123456");
		loginService.updatePwd(updatePwdDto);
	}*/
	
	@Test
	public void getValideCode() throws TsfaServiceException{
		String code =loginService.getValideCode("18665435143");
		System.out.println(code);
	}
	
	@Test
	public void login() throws Exception {
		
	}
	
}
