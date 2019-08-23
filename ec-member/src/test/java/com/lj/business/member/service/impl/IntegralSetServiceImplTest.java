package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.dto.integralSet.AddIntegralSet;
import com.lj.business.member.dto.integralSet.DelIntegralSet;
import com.lj.business.member.dto.integralSet.FindIntegralSet;
import com.lj.business.member.dto.integralSet.UpdateIntegralSet;
import com.lj.business.member.service.IIntegralSetService;


/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 冯辉
 * 
 * 
 * CreateDate: 2017-06-14
 */
public class IntegralSetServiceImplTest extends SpringTestCase{

	@Resource
	IIntegralSetService integralSetService;



	/**
	 * 
	 *
	 * 方法说明：添加积分设置表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void addIntegralSet() throws TsfaServiceException{
		AddIntegralSet addIntegralSet = new AddIntegralSet();
		//add数据录入
		addIntegralSet.setCode("Code");
		addIntegralSet.setMerchantNo("MerchantNo");
		addIntegralSet.setMerchantName("MerchantName");
		addIntegralSet.setShopNo("ShopNo");
		addIntegralSet.setShopName("ShopName");
		addIntegralSet.setAreaCode("AreaCode");
		addIntegralSet.setAreaName("AreaName");
		addIntegralSet.setIntegralType("IntegralType");
		addIntegralSet.setIntegralName("IntegralName");
		addIntegralSet.setIntegralScore(0.0);
		addIntegralSet.setIntegralUp(0.0);
		addIntegralSet.setIntegralDown(0.0);
		addIntegralSet.setStatus("Status");
		addIntegralSet.setUpdateId("UpdateId");
		addIntegralSet.setUpdateDate(new Date());
		addIntegralSet.setCreateId("CreateId");
		addIntegralSet.setCreateDate(new Date());
		
		integralSetService.addIntegralSet(addIntegralSet );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改积分设置表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void updateIntegralSet() throws TsfaServiceException{
		UpdateIntegralSet updateIntegralSet = new UpdateIntegralSet();
		//update数据录入
		updateIntegralSet.setCode("Code");
		updateIntegralSet.setMerchantNo("MerchantNo");
		updateIntegralSet.setMerchantName("MerchantName");
		updateIntegralSet.setShopNo("ShopNo");
		updateIntegralSet.setShopName("ShopName");
		updateIntegralSet.setAreaCode("AreaCode");
		updateIntegralSet.setAreaName("AreaName");
		updateIntegralSet.setIntegralType("IntegralType");
		updateIntegralSet.setIntegralName("IntegralName");
		updateIntegralSet.setIntegralScore(0.0);
		updateIntegralSet.setIntegralUp(0.0);
		updateIntegralSet.setIntegralDown(0.0);
		updateIntegralSet.setStatus("Status");
		updateIntegralSet.setUpdateId("UpdateId");
		updateIntegralSet.setUpdateDate(new Date());
		updateIntegralSet.setCreateId("CreateId");
		updateIntegralSet.setCreateDate(new Date());

		integralSetService.updateIntegralSet(updateIntegralSet );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找积分设置表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void findIntegralSet() throws TsfaServiceException{
		FindIntegralSet findIntegralSet = new FindIntegralSet();
		findIntegralSet.setCode("111");
		integralSetService.findIntegralSet(findIntegralSet);
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除积分设置表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void delIntegralSet() throws TsfaServiceException{
		DelIntegralSet delIntegralSet = new DelIntegralSet();
		delIntegralSet.setCode("111");
		integralSetService.delIntegralSet(delIntegralSet);
		
	}
	
	
}
