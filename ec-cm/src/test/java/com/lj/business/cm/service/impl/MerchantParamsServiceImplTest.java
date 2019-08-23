package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cm.dto.merchantParams.AddMerchantParams;
import com.lj.business.cm.dto.merchantParams.DelMerchantParams;
import com.lj.business.cm.dto.merchantParams.FindMerchantParams;
import com.lj.business.cm.dto.merchantParams.FindMerchantParamsPage;
import com.lj.business.cm.dto.merchantParams.FindMerchantParamsPageReturn;
import com.lj.business.cm.dto.merchantParams.UpdateMerchantParams;
import com.lj.business.cm.service.IMerchantParamsService;


/**
 * 类说明：测试类
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
public class MerchantParamsServiceImplTest extends SpringTestCase{

	@Resource
	IMerchantParamsService merchantParamsService;



	/**
	 * 
	 *
	 * 方法说明：添加商户参数配置信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addMerchantParams() throws TsfaServiceException{
		AddMerchantParams addMerchantParams = new AddMerchantParams();
		//add数据录入
		addMerchantParams.setMerchantNo("MerchantNo");
		addMerchantParams.setMerchantName("MerchantName");
		addMerchantParams.setSysParamName("SysParamName");
		addMerchantParams.setGroupName("GroupName");
		addMerchantParams.setSysParamValue("SysParamValue");
		addMerchantParams.setRemark("Remark");
		addMerchantParams.setOnlyAdminModify("1");
		
		merchantParamsService.addMerchantParams(addMerchantParams );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商户参数配置信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateMerchantParams() throws TsfaServiceException{
		UpdateMerchantParams updateMerchantParams = new UpdateMerchantParams();
		//update数据录入
		updateMerchantParams.setCode("Code");
		updateMerchantParams.setMerchantNo("MerchantNo");
		updateMerchantParams.setMerchantName("MerchantName");
		updateMerchantParams.setSysParamName("SysParamName");
		updateMerchantParams.setGroupName("GroupName");
		updateMerchantParams.setSysParamValue("SysParamValue");
		updateMerchantParams.setRemark("Remark");
		updateMerchantParams.setOnlyAdminModify("2");

		merchantParamsService.updateMerchantParams(updateMerchantParams );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户参数配置信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findMerchantParams() throws TsfaServiceException{
		FindMerchantParams findMerchantParams = new FindMerchantParams();
		findMerchantParams.setCode("111");
		merchantParamsService.findMerchantParams(findMerchantParams);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户参数配置信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findMerchantParamsPage() throws TsfaServiceException{
		FindMerchantParamsPage findMerchantParamsPage = new FindMerchantParamsPage();
		Page<FindMerchantParamsPageReturn> page = merchantParamsService.findMerchantParamsPage(findMerchantParamsPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除商户参数配置信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delMerchantParams() throws TsfaServiceException{
		DelMerchantParams delMerchantParams = new DelMerchantParams();
		delMerchantParams.setCode("111");
		merchantParamsService.delMerchantParams(delMerchantParams);
		
	}
	
	
}
