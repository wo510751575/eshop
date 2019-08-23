package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.business.member.dto.phoneInfo.AddPhoneInfo;
import com.lj.business.member.dto.phoneInfo.DelPhoneInfo;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfo;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfoPage;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfoPageReturn;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfoReturn;
import com.lj.business.member.dto.phoneInfo.UpdatePhoneInfo;

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
public interface IPhoneInfoService {
	
	/**
	 * 方法说明：添加设备信息信息.
	 *
	 * @param addPhoneInfo the add phone info
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void addPhoneInfo(AddPhoneInfo addPhoneInfo) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找设备信息信息.
	 *
	 * @param findPhoneInfo the find phone info
	 * @return the find phone info return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindPhoneInfoReturn findPhoneInfo(FindPhoneInfo findPhoneInfo) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：删除设备信息信息.
	 *
	 * @param delPhoneInfo the del phone info
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void delPhoneInfo(DelPhoneInfo delPhoneInfo) throws TsfaServiceException;

	/**
	 * 方法说明：修改设备信息信息.
	 *
	 * @param updatePhoneInfo the update phone info
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void updatePhoneInfo(UpdatePhoneInfo updatePhoneInfo)throws TsfaServiceException;

	/**
	 * 方法说明：分页查询设备信息信息.
	 *
	 * @param findPhoneInfoPage the find phone info page
	 * @return the page< find phone info page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindPhoneInfoPageReturn> findPhoneInfoPage(FindPhoneInfoPage findPhoneInfoPage) throws TsfaServiceException;
	

}
