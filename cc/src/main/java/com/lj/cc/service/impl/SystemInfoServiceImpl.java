
package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.cc.dao.ISystemInfoDao;
import com.lj.cc.domain.SystemInfo;
import com.lj.cc.service.ISystemInfoService;
import com.lj.base.exception.TsfaServiceException;

/**
 * 
 * 
 * 类说明： 配置中心系统信息服务
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月15日
 */
@Service
public class SystemInfoServiceImpl implements ISystemInfoService {

	/** The system info dao. */
	@Resource
	private ISystemInfoDao systemInfoDao;

	/* (non-Javadoc)
	 * @see com.lj.cc.service.ISystemInfoService#findSystemInfo(java.lang.String)
	 */
	@Override
	public SystemInfo findSystemInfo(String systemAliasName)
			throws TsfaServiceException {
		
		return systemInfoDao.selectByPrimaryKey(systemAliasName);
	}

	/* (non-Javadoc)
	 * @see com.lj.cc.service.ISystemInfoService#findAllSystemInfo()
	 */
	@Override
	public List<SystemInfo> findAllSystemInfo() throws TsfaServiceException {
		return systemInfoDao.queryAllSystemInfo();
	}

}
