
package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.cc.domain.SystemParams;
import com.lj.cc.domain.SystemParamsKey;
import com.lj.cc.dto.FindSystemGroup;
import com.lj.cc.dto.FindSystemGroupRetrun;
import com.lj.cc.dto.FindSystemParam;
import com.lj.cc.dto.FindSystemValue;
import com.lj.cc.dto.FindSystemValueRetrun;
import com.lj.cc.enums.SystemAliasName;
import com.lj.cc.service.ISystemParamsService;
import com.lj.base.mvc.web.test.SpringTestCase;



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
 * CreateDate: 2017-7-13
 */
public class SystemParamsServiceImplTest extends SpringTestCase{
	
	/** The system params service. */
	@Resource
	ISystemParamsService systemParamsService;
	
	/**
	 * Test find system group.
	 */
	@Test
	public void testFindSystemGroup(){
		FindSystemGroup findSystemGroup = new FindSystemGroup();
		findSystemGroup.setSystemAliasName("pc");
		findSystemGroup.setGroupName("PC_CARD_TYPE");
		FindSystemGroupRetrun findSystemGroupRetrun = systemParamsService.findSystemGroup(findSystemGroup);
		Assert.assertNotNull(findSystemGroupRetrun);
		
		findSystemGroup = new FindSystemGroup();
		findSystemGroup.setSystemAliasName("pp");
		findSystemGroup.setGroupName("TERMINAL_PARAMS");
	    findSystemGroupRetrun = systemParamsService.findSystemGroup(findSystemGroup);
		Assert.assertNotNull(findSystemGroupRetrun);
		
		//缓存测试
		findSystemGroup = new FindSystemGroup();
		findSystemGroup.setSystemAliasName("pc");
		findSystemGroup.setGroupName("PC_CARD_AREA");
	    findSystemGroupRetrun = systemParamsService.findSystemGroup(findSystemGroup);
		Assert.assertNotNull(findSystemGroupRetrun);
	}
	
	/**
	 * Test find system value.
	 */
	@Test
	public void testFindSystemValue(){
		FindSystemValue findSystemValue = new FindSystemValue();
		findSystemValue.setSystemAliasName("pc");
		findSystemValue.setGroupName("PC_CARD_TYPE");
		findSystemValue.setSysParamName("10");
		
		FindSystemValueRetrun findSystemValueRetrun = systemParamsService.findSystemValue(findSystemValue);
		Assert.assertNotNull(findSystemValueRetrun);
		
		//缓存测试
		findSystemValue = new FindSystemValue();
		findSystemValue.setSystemAliasName("pc");
		findSystemValue.setGroupName("PC_CARD_TYPE");
		findSystemValue.setSysParamName("10");
	    findSystemValueRetrun = systemParamsService.findSystemValue(findSystemValue);
		Assert.assertNotNull(findSystemValueRetrun);
	}
	
	/**
	 * Test find system params.
	 */
	@Test
	public void testFindSystemParams(){
		List<SystemParams> list = systemParamsService.findSystemParams(null);
		Assert.assertNotNull(list);
		
	}
	
	/**
	 * Test find system params page.
	 */
	@Test
	public void testFindSystemParamsPage() {
		FindSystemParam param = new FindSystemParam();
		param.setSystemAliasName(SystemAliasName.cc.name());
		param.setGroupName("PC_CARD_AREA");
		param.setSysParamName("01");
		param.setModifyFlag(Boolean.FALSE);
		Assert.assertNotNull(systemParamsService.findSystemParamsPage(param));
	}
	
	/**
	 * Test update system param.
	 */
	@Test
	public void testUpdateSystemParam() {
		SystemParams param = new SystemParams();
		param.setSystemAliasName(SystemAliasName.cc.name());
		param.setGroupName("AACC_TEST");
		param.setSysParamName("test");
		param.setSysParamValue("testddds");
		param.setRemark("测试啊测试");
		param.setOnlyAdminModify("0");
		systemParamsService.updateSystemParam(param);
	}
	
	@Test
	public void testPages(){
		FindSystemParam param=new FindSystemParam();
	 System.out.println(systemParamsService.findSystemParamsPage(param));
	}
	
	@Test
	public void selectByPrimaryKey(){
		SystemParamsKey key=new SystemParamsKey();
		key.setGroupName("abandon");
		key.setSysParamName("abandonCount");
		SystemParams params = systemParamsService.selectByPrimaryKey(key);
		System.out.println(params);
		
	}
}
