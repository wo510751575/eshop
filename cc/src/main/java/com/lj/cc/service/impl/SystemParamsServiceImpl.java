
package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.cc.dao.ISystemParamsDao;
import com.lj.cc.common.ErrorCode;
import com.lj.cc.domain.SystemParams;
import com.lj.cc.domain.SystemParamsKey;
import com.lj.cc.dto.FindSystemGroup;
import com.lj.cc.dto.FindSystemGroupRetrun;
import com.lj.cc.dto.FindSystemParam;
import com.lj.cc.dto.FindSystemValue;
import com.lj.cc.dto.FindSystemValueRetrun;
import com.lj.cc.service.ISystemParamsService;
import com.lj.base.core.pagination.IPage;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.exception.TsfaServiceException;

/**
 * 
 * 
 * 类说明：系统参数服务
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
public class SystemParamsServiceImpl implements ISystemParamsService {

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(SystemParamsServiceImpl.class);

	/** The system params dao. */
	@Resource
	private ISystemParamsDao systemParamsDao;

	/** key:SYSTEM_ALIAS_NAME value:SystemParams LIST. */
	private static Map<String,Map<String,Map<String,String>>>  cacheMap =  new HashMap<String,Map<String,Map<String,String>>>();

	/** key:SYSTEM_ALIAS_NAME value:缓存时间的毫秒数. */
	private static Map<String, Map<String,Long>>  cacheMapTime =  new HashMap<String, Map<String,Long>>();

	/** 缓存存在时间的毫秒值. */
	private static int intervalMillis = 1000*60*60;


	/* (non-Javadoc)
	 * @see com.lj.cc.service.ISystemParamsService#findSystemGroup(com.lj.cc.dto.FindSystemGroup)
	 */
	@Override
	public FindSystemGroupRetrun findSystemGroup(FindSystemGroup findSystemGroup)
			throws TsfaServiceException {
		logger.debug("findSystemGroup(FindSystemGroup findSystemGroup=" + findSystemGroup + ") - start");  //$NON-NLS-2$

		FindSystemGroupRetrun findSystemGroupRetrun = null;
		try {
			AssertUtils.notNull(findSystemGroup);
			AssertUtils.notNullAndEmpty(findSystemGroup.getGroupName());//必须指定具体值
			AssertUtils.notNullAndEmpty(findSystemGroup.getSystemAliasName());//必须指定具体值

			Map<String, String> groupMaps = getGroupmaps(findSystemGroup.getSystemAliasName(), findSystemGroup.getGroupName());

			findSystemGroupRetrun = new FindSystemGroupRetrun();
			findSystemGroupRetrun.setGroupMaps(groupMaps);

		} catch (Exception e) {
			logger.error("查找配置信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CC_QUERY_ERROR,"查找配置信息错误！",e);
		}

		logger.debug("findSystemGroup(FindSystemGroup) - end : " + findSystemGroupRetrun); 
		return findSystemGroupRetrun;
	}

	/**
	 * 方法说明：获取groupMaps.
	 *
	 * @param systemAliasName the system alias name
	 * @param groupName the group name
	 * @return the groupmaps
	 * @author 彭阳
	 */
	private Map<String, String> getGroupmaps(String systemAliasName,String groupName) {
		SystemParams key = new SystemParams();
		key.setSystemAliasName(systemAliasName);
		key.setGroupName(groupName);
		
		Map<String,Map<String,String>> systemMaps = cacheMap.get(systemAliasName);
		if(systemMaps == null){
			systemMaps = new HashMap<String,Map<String,String>>();
		}
		Map<String,String> groupMaps = null;
		Long currentTimeMillis = System.currentTimeMillis();

		//没有缓存时间 或者 缓存时间大于缓存存在时间，刷新缓存
		Map<String, Long> systemMapTime = cacheMapTime.get(systemAliasName);
		Long cacheTimeMillis = null;
		if(systemMapTime != null){
			cacheTimeMillis = systemMapTime.get(groupName) ;
		}else{
			systemMapTime = new HashMap<String, Long>();//初始化MAP
		}
		if(cacheTimeMillis == null || (currentTimeMillis - cacheTimeMillis) > intervalMillis){
			List<SystemParams> list = systemParamsDao.selectByParameters(key);
			groupMaps = new HashMap<String,String>();
			for (SystemParams systemParams : list) {
				groupMaps.put(systemParams.getSysParamName(), systemParams.getSysParamValue());
			}
			systemMaps.put(groupName, groupMaps);
			cacheMap.put(systemAliasName, systemMaps);//存入缓存
			systemMapTime.put(groupName, currentTimeMillis);//存入缓存
			cacheMapTime.put(systemAliasName, systemMapTime);//存入缓存
			
		}
		groupMaps = cacheMap.get(systemAliasName).get(groupName);//从缓存获取数据
		return groupMaps;
	}

	/* (non-Javadoc)
	 * @see com.lj.cc.service.ISystemParamsService#findSystemValue(com.lj.cc.dto.FindSystemValue)
	 */
	public FindSystemValueRetrun findSystemValue(FindSystemValue findSystemValue) throws TsfaServiceException{
		logger.debug("findSystemValue(FindSystemValue findSystemValue=" + findSystemValue + ") - start");  //$NON-NLS-2$

		FindSystemValueRetrun findSystemValueRetrun = null;
		try {
			AssertUtils.notNull(findSystemValue);
			AssertUtils.notNullAndEmpty(findSystemValue.getGroupName());//必须指定具体值
			AssertUtils.notNullAndEmpty(findSystemValue.getSystemAliasName());//必须指定具体值
			AssertUtils.notNullAndEmpty(findSystemValue.getSysParamName());//必须指定具体值
			
			Map<String, String> groupMaps = getGroupmaps(findSystemValue.getSystemAliasName(), findSystemValue.getGroupName());
			String value = groupMaps.get(findSystemValue.getSysParamName());
			
		    findSystemValueRetrun = new FindSystemValueRetrun();
			findSystemValueRetrun.setValue(value);
		}   catch (Exception e) {
			logger.error("查找配置信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CC_QUERY_ERROR,"查找配置信息错误！",e);
		}
		logger.debug("findSystemValue(FindSystemValue) - end :" + findSystemValueRetrun); 
		return findSystemValueRetrun;
	}



	/* (non-Javadoc)
	 * @see com.lj.cc.service.ISystemParamsService#findSystemParams(java.lang.String)
	 */
	@Override
	public List<SystemParams> findSystemParams(String systemAliasName) {
		logger.debug("findSystemParams(String systemAliasName={}) - start", systemAliasName); 

		SystemParams key = new SystemParams();
		key.setSystemAliasName(systemAliasName); 
		List<SystemParams> returnList = systemParamsDao.selectByParameters(key);
		logger.debug("findSystemParams(String) - end - return value={}", returnList); 
		return returnList;
	}

	/* (non-Javadoc)
	 * @see com.lj.cc.service.ISystemParamsService#findSystemParamsPage(com.lj.cc.dto.FindSystemParam)
	 */
	@Override
	public IPage<SystemParams> findSystemParamsPage(FindSystemParam param) {
		try {
			long count = systemParamsDao.querySystemParamsCount(param);
			List<SystemParams> list = null;
			if(count > 0) {
				list = systemParamsDao.querySystemParamsList(param);
			}
			return new Page<SystemParams>(list, count, param, null);
		} catch(Exception e) {
			logger.error("查询系统参数明细[" + param + "]失败: ", e);
			throw new TsfaServiceException(ErrorCode.CC_QUERY_ERROR, "查询系统参数明细[" + param + "]失败: ", e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.cc.service.ISystemParamsService#updateSystemParam(com.lj.cc.domain.SystemParams)
	 */
	@Override
	public void updateSystemParam(SystemParams systemParams) {
		logger.debug("updateSystemParam(SystemParams={}) - start", systemParams);
		if(systemParams == null) {
			logger.error("参数为空");
		}
		if(StringUtils.isEmpty(systemParams.getSystemAliasName())) {
			logger.error("系统别名systemAliasName为空");
			throw new IllegalArgumentException("所属系统为空");
		}
		if(StringUtils.isEmpty(systemParams.getGroupName())) {
			logger.error("分组信息groupName为空");
			throw new IllegalArgumentException("分组信息为空");
		}
		if(StringUtils.isEmpty(systemParams.getSysParamName())) {
			logger.error("参数名sysParamName为空");
			throw new IllegalArgumentException("参数名为空");
		}
		if(StringUtils.isEmpty(systemParams.getSysParamValue())) {
			logger.error("参数值sysParamValue为空");
			throw new IllegalArgumentException("参数值为空");
		}
		if(StringUtils.isEmpty(systemParams.getRemark())) {
			logger.error("参数说明remark为空");
			throw new IllegalArgumentException("参数说明为空");
		}
		if(StringUtils.isEmpty(systemParams.getOnlyAdminModify())) {
			logger.error("能否修改onlyAdminModify为空");
			throw new IllegalArgumentException("能否修改参数为空");
		} else if(!"1".equals(systemParams.getOnlyAdminModify())) {
			systemParams.setOnlyAdminModify("0");
		}
		try {
			systemParamsDao.updateSystemParam(systemParams);
		} catch(Exception e) {
			logger.error("更新系统参数失败：", e);
			throw new TsfaServiceException(ErrorCode.CC_UPDATE_ERROR, "更新系统参数失败", e);
		}
		
		// 更新本地缓存
		Map<String,Map<String,String>> systemParamsMap = cacheMap.get(systemParams.getSystemAliasName());
		if(systemParamsMap != null && !systemParamsMap.isEmpty()) {
			Map<String,String> paramsMap = systemParamsMap.get(systemParams.getGroupName());
			if(paramsMap != null && !paramsMap.isEmpty()) {
				paramsMap.put(systemParams.getSysParamName(), systemParams.getSysParamValue());
			}
		}

		logger.debug("updateSystemParam(SystemParams) - end");
	}

	@Override
	public SystemParams selectByPrimaryKey(SystemParamsKey key) {
		logger.debug("updateSystemParam(SystemParams={}) - start", key);
		SystemParams params = null;
		try {
			params=systemParamsDao.selectByPrimaryKey(key);
		} catch (Exception e) {
			logger.error("查找配置信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CC_QUERY_ERROR,"查找配置信息错误！",e);
		}
		logger.debug("findSystemGroup(FindSystemGroup) - end : " + params); 
		return params;
	} 

}
