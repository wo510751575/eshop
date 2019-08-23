package com.lj.eshop.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.business.member.domain.LoginCheck;
import com.lj.business.member.dto.AddLoginCheck;
import com.lj.business.member.dto.AddLoginCheckReturn;
import com.lj.business.member.dto.DelLoginCheck;
import com.lj.business.member.dto.DelLoginCheckReturn;
import com.lj.business.member.dto.FindLoginCheck;
import com.lj.business.member.dto.FindLoginCheckPage;
import com.lj.business.member.dto.FindLoginCheckPageReturn;
import com.lj.business.member.dto.FindLoginCheckReturn;
import com.lj.business.member.dto.UpdateLoginCheck;
import com.lj.business.member.dto.UpdateLoginCheckReturn;
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;


/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-06-14
 */
public interface IEcLoginCheckService {
	
	/**
	 * 方法说明：添加登录检查信息.
	 *
	 * @param addLoginCheck the add login check
	 * @return the adds the login check return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public AddLoginCheckReturn addLoginCheck(AddLoginCheck addLoginCheck) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找登录检查信息.
	 *
	 * @param findLoginCheck the find login check
	 * @return the find login check return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindLoginCheckReturn findLoginCheck(FindLoginCheck findLoginCheck) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：删除登录检查信息.
	 *
	 * @param delLoginCheck the del login check
	 * @return the del login check return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public DelLoginCheckReturn delLoginCheck(DelLoginCheck delLoginCheck) throws TsfaServiceException;

	/**
	 * 方法说明：修改登录检查信息.
	 *
	 * @param updateLoginCheck the update login check
	 * @return the update login check return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public UpdateLoginCheckReturn updateLoginCheck(UpdateLoginCheck updateLoginCheck)throws TsfaServiceException;

	/**
	 * 方法说明：查找登录检查信息.
	 *
	 * @param findLoginCheckPage the find login check page
	 * @return the page< find login check page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindLoginCheckPageReturn> findLoginCheckPage(FindLoginCheckPage findLoginCheckPage) throws TsfaServiceException;
	

	/**
	 * 方法说明：根据条件查询登录检查信息.
	 *
	 * @param loginCheck the login check
	 * @return the login check
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年6月24日
	 */
	public LoginCheck findLoginCheck(LoginCheck loginCheck) throws TsfaServiceException;
}
