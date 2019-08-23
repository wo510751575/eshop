package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.cfErrorInfo.AddCfErrorInfoDto;
import com.lj.business.cf.dto.cfErrorInfo.CfErrorInfoReturnDto;
import com.lj.business.cf.dto.cfErrorInfo.EditCfErrorInfoDto;
import com.lj.business.cf.dto.cfErrorInfo.FindCfErrorInfoPageDto;
import com.lj.business.cf.service.ICfErrorInfoService;


/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 
 * 
 * CreateDate: 2017-06-14
 */
public class CfErrorInfoServiceImplTest extends SpringTestCase{
	@Resource
	private ICfErrorInfoService cfErrorInfoService;
	/**
	 * 
	 *
	 * 方法说明：添加跟进异常情况表
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	@Test
	public void addCfErrorInfo() {
		AddCfErrorInfoDto cfErrorInfo = new AddCfErrorInfoDto();
		cfErrorInfo.setMerchantNo(GUID.getPreUUID());
		cfErrorInfo.setShopNo(GUID.getPreUUID());
		cfErrorInfo.setShopName("宝安分店");
		cfErrorInfo.setMemberNoGm(GUID.getPreUUID());
		cfErrorInfo.setMemberNameGm("邹磊");
		cfErrorInfo.setCodeList(GUID.getPreUUID());
		cfErrorInfo.setNameList("打电话");
		cfErrorInfo.setErrorNum(1L);
		cfErrorInfo.setCreateId("邹磊");
		cfErrorInfo.setRemark("很好");
		cfErrorInfo.setRemark2("很好");
		cfErrorInfo.setRemark3("很好");
		cfErrorInfo.setRemark4("很好");
		cfErrorInfoService.addCfErrorInfo(cfErrorInfo);
		
	}

	/**
	 * 
	 *
	 * 方法说明：编辑跟进异常情况表
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	@Test
	public void editCfErrorInfo() {
		EditCfErrorInfoDto cfErrorInfo = new EditCfErrorInfoDto();
		cfErrorInfo.setCode(GUID.getPreUUID());
		cfErrorInfo.setMerchantNo(GUID.getPreUUID());
		cfErrorInfo.setShopNo(GUID.getPreUUID());
		cfErrorInfo.setShopName("龙华分店");
		cfErrorInfo.setMemberNoGm(GUID.getPreUUID());
		cfErrorInfo.setMemberNameGm("邹磊");
		cfErrorInfo.setCodeList(GUID.getPreUUID());
		cfErrorInfo.setNameList("打电话");
		cfErrorInfo.setErrorNum(1L);
		cfErrorInfo.setCreateId("邹磊");
		cfErrorInfo.setRemark("很好");
		cfErrorInfo.setRemark2("很好");
		cfErrorInfo.setRemark3("很好");
		cfErrorInfo.setRemark4("很好");
		cfErrorInfo.setCreateDate(new Date());
		cfErrorInfoService.editCfErrorInfo(cfErrorInfo);
	}
	
	/**
	 * 
	 *
	 * 方法说明：通过主键查询跟进异常情况表
	 *
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void selectByCode() {
		CfErrorInfoReturnDto cfErrorInfoReturnDto = cfErrorInfoService.selectByCode("LJ_11adfa2e2ae9484f88a9df0779c721eb");
		Assert.assertNotNull(cfErrorInfoReturnDto.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找跟进异常情况表(不分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void findCfErrorInfos() {
		FindCfErrorInfoPageDto findCfErrorInfoPageDto = new FindCfErrorInfoPageDto();
		findCfErrorInfoPageDto.setMerchantNo("LJ_591d7d9d09854535a5c59ea39a981af7");
		List<FindCfErrorInfoPageDto> list = cfErrorInfoService.findCfErrorInfos(findCfErrorInfoPageDto);
		System.out.println(list.toString());
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找跟进异常情况表(分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void findCfErrorInfoPage() {
		FindCfErrorInfoPageDto findCfErrorInfoPageDto = new FindCfErrorInfoPageDto();
		findCfErrorInfoPageDto.setMerchantNo("LJ_591d7d9d09854535a5c59ea39a981af7");
		Page<FindCfErrorInfoPageDto> page = cfErrorInfoService.findCfErrorInfoPage(findCfErrorInfoPageDto);
		System.out.println(page.getTotal());
		Assert.assertNotNull(page);
	}
	
	
}
