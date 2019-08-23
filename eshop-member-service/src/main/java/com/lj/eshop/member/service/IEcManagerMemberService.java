/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.member.service;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.AddManagerMember;
import com.lj.business.member.dto.AddManagerMemberReturn;

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
public interface IEcManagerMemberService {
	/**
	 * 方法说明：添加商户表信息.
	 *
	 * @param addManagerMember
	 *            the add manager member
	 * @return the adds the manager member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public AddManagerMemberReturn addManagerMember(AddManagerMember addManagerMember) throws TsfaServiceException;

}
