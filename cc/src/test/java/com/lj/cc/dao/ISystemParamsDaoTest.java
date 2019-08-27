
package com.lj.cc.dao;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.cc.dao.ISystemParamsDao;
import com.lj.cc.domain.SystemParams;
import com.lj.cc.domain.SystemParamsKey;
import com.lj.base.mvc.web.test.SpringTestCase;

/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * CreateDate: 2017-7-1
 */
public class ISystemParamsDaoTest extends SpringTestCase{
	
	/** The system params dao. */
	@Resource
	ISystemParamsDao systemParamsDao;
	
	/**
	 * Test insert.
	 */
	@Test
	public void testInsert(){
		SystemParams record = new SystemParams();
		record.setGroupName("11");
		record.setSysParamName("222");
		record.setSysParamValue("2");
		record.setRemark("3");
		record.setSystemAliasName("4");
		record.setOnlyAdminModify("5");
		
		int count = 0;
		try {
			count = systemParamsDao.insert(record);
		} catch (Exception e) {
			logger.error("",e);
		}
		
		logger.debug("count:" + count);
		Assert.assertNotNull(count);
	}
	
	/**
	 * Test select by primary key.
	 */
	@Test
	public void testSelectByPrimaryKey(){
		SystemParams systemParams = null;
		try {
			SystemParamsKey key = new SystemParamsKey();
			key.setGroupName("111");
			key.setSysParamName("222");
			systemParams = systemParamsDao.selectByPrimaryKey(key);
		} catch (Exception e) {
			logger.error("",e);
		}
		
		logger.debug("systemParams:" + systemParams);
		Assert.assertNotNull(systemParams);
	}

}
