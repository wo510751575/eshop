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
import com.lj.business.member.dto.guidMemberIntegral.AddGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.DelGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.FindGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.GuidMemberIntegralDto;
import com.lj.business.member.dto.guidMemberIntegral.UpdateGuidMemberIntegral;
import com.lj.business.member.service.IGuidMemberIntegralService;


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
public class GuidMemberIntegralServiceImplTest extends SpringTestCase{

	@Resource
	IGuidMemberIntegralService guidMemberIntegralService;



	/**
	 * 
	 *
	 * 方法说明：添加导购积分明细表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void addGuidMemberIntegral() throws TsfaServiceException{
		AddGuidMemberIntegral addGuidMemberIntegral = new AddGuidMemberIntegral();
		//add数据录入
		addGuidMemberIntegral.setCode("Code");
		addGuidMemberIntegral.setMerchantNo("MerchantNo");
		addGuidMemberIntegral.setMerchantName("MerchantName");
		addGuidMemberIntegral.setMemberNo("MemberNo");
		addGuidMemberIntegral.setMemberName("MemberName");
		addGuidMemberIntegral.setShopNo("ShopNo");
		addGuidMemberIntegral.setShopName("ShopName");
		addGuidMemberIntegral.setAreaCode("AreaCode");
		addGuidMemberIntegral.setAreaName("AreaName");
		addGuidMemberIntegral.setCodeList("CodeList");
		addGuidMemberIntegral.setCodeName("CodeName");
		addGuidMemberIntegral.setIntegralType("IntegralType");
		addGuidMemberIntegral.setIntegralScore(0.0);
		addGuidMemberIntegral.setDaySt(new Date());
		addGuidMemberIntegral.setCreateId("CreateId");
		addGuidMemberIntegral.setCreateDate(new Date());
		
		guidMemberIntegralService.addGuidMemberIntegral(addGuidMemberIntegral );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改导购积分明细表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void updateGuidMemberIntegral() throws TsfaServiceException{
		UpdateGuidMemberIntegral updateGuidMemberIntegral = new UpdateGuidMemberIntegral();
		//update数据录入
		updateGuidMemberIntegral.setCode("Code");
		updateGuidMemberIntegral.setMerchantNo("MerchantNo");
		updateGuidMemberIntegral.setMerchantName("MerchantName");
		updateGuidMemberIntegral.setMemberNo("MemberNo");
		updateGuidMemberIntegral.setMemberName("MemberName");
		updateGuidMemberIntegral.setShopNo("ShopNo");
		updateGuidMemberIntegral.setShopName("ShopName");
		updateGuidMemberIntegral.setAreaCode("AreaCode");
		updateGuidMemberIntegral.setAreaName("AreaName");
		updateGuidMemberIntegral.setCodeList("CodeList");
		updateGuidMemberIntegral.setCodeName("CodeName");
		updateGuidMemberIntegral.setIntegralType("IntegralType");
		updateGuidMemberIntegral.setIntegralScore(0.0);
		updateGuidMemberIntegral.setDaySt(new Date());
		updateGuidMemberIntegral.setCreateId("CreateId");
		updateGuidMemberIntegral.setCreateDate(new Date());

		guidMemberIntegralService.updateGuidMemberIntegral(updateGuidMemberIntegral );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找导购积分明细表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void findGuidMemberIntegral() throws TsfaServiceException{
		FindGuidMemberIntegral findGuidMemberIntegral = new FindGuidMemberIntegral();
		findGuidMemberIntegral.setCode("111");
		guidMemberIntegralService.findGuidMemberIntegral(findGuidMemberIntegral);
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除导购积分明细表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void delGuidMemberIntegral() throws TsfaServiceException{
		DelGuidMemberIntegral delGuidMemberIntegral = new DelGuidMemberIntegral();
		delGuidMemberIntegral.setCode("111");
		guidMemberIntegralService.delGuidMemberIntegral(delGuidMemberIntegral);
		
	}
	
	@Test
	public void doIntegral() throws Exception {
		GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
		guidMemberIntegralDto.setMerchantNo("de6e5fb49f4b44b88e63a00b65986ff0");
		guidMemberIntegralDto.setMemberNo("bfb6baf33ba44f3a9d99e72916b01123");
		guidMemberIntegralDto.setShopNo("LJ_ca14b6ef0da14967881c462af775bd8e");
		guidMemberIntegralDto.setAreaCode("2");
		guidMemberIntegralDto.setIntegralType("NOTICE");
		guidMemberIntegralService.doIntegral(guidMemberIntegralDto);
	}
	
	
}
