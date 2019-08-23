package com.lj.business.member.service;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.PersonMemberLogin;
import com.lj.business.member.dto.PersonMemberLoginReturn;


/**
 * 类说明：
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
public interface IMemberLoginService {

	
	
	/**
	 * 方法说明：添加用户登录信息.
	 *
	 * @param personMemberLogin the person member login
	 * @return the person member login return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月14日
	 */
//	public AddMemberLoginInfoReturn addMemberLoginInfo(AddMemberLoginInfo addMemberLoginInfo)  throws TsfaServiceException;
	
	/**
	 * 方法说明：个人用户登录.
	 *
	 * @param personMemberLogin the person member login
	 * @return the PersonMemberLoginReturn
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 */
	public PersonMemberLoginReturn personMemberLoginAPP(PersonMemberLogin personMemberLogin)  throws TsfaServiceException;


	/**
	 * 方法说明：会员登录 H5接口 店长 BOSS.
	 *
	 * @param personMemberLogin the person member login
	 * @return the person member login return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年6月24日
	 */
	public PersonMemberLoginReturn personMemberLoginH5(PersonMemberLogin personMemberLogin)  throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改登录密码
	 *
	 * @param updatePwdDto
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月9日
	 *@deprecated 2017-08-18
	 */
	//public void updatePwd(UpdatePwdDto updatePwdDto)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：获取验证码
	 *
	 * @param mobile
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月9日
	 *@deprecated 2017-08-18
	 */
	public String getValideCode(String mobile)throws TsfaServiceException;
	
}
