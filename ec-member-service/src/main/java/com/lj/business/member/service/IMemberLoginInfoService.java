package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
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

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;


/**
 * 类说明：接口类
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
public interface IMemberLoginInfoService {
	
	/**
	 * 方法说明：添加登录记录表信息.
	 *
	 * @param addMemberLoginInfo the add member login info
	 * @return the adds the member login info return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年6月9日
	 */
	public AddMemberLoginInfoReturn addMemberLoginInfo(AddMemberLoginInfo addMemberLoginInfo) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找登录记录表信息.
	 *
	 * @param findMemberLoginInfo the find member login info
	 * @return the find member login info return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年6月9日
	 */
	public FindMemberLoginInfoReturn findMemberLoginInfo(FindMemberLoginInfo findMemberLoginInfo) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：删除登录记录表信息.
	 *
	 * @param delMemberLoginInfo the del member login info
	 * @return the del member login info return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年6月9日
	 */
	public DelMemberLoginInfoReturn delMemberLoginInfo(DelMemberLoginInfo delMemberLoginInfo) throws TsfaServiceException;

	/**
	 * 方法说明：修改登录记录表信息.
	 *
	 * @param updateMemberLoginInfo the update member login info
	 * @return the update member login info return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年6月9日
	 */
	public UpdateMemberLoginInfoReturn updateMemberLoginInfo(UpdateMemberLoginInfo updateMemberLoginInfo)throws TsfaServiceException;

	/**
	 * 方法说明：查找登录记录表信息.
	 *
	 * @param findMemberLoginInfoPage the find member login info page
	 * @return the page< find member login info page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年6月9日
	 */
	public Page<FindMemberLoginInfoPageReturn> findMemberLoginInfoPage(FindMemberLoginInfoPage findMemberLoginInfoPage) throws TsfaServiceException;
	

}
