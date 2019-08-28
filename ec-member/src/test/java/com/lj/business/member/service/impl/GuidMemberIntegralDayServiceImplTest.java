package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.lj.base.core.util.DateUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.dto.guidMemberIntegralDay.AddGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.DelGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDayReturn;
import com.lj.business.member.dto.guidMemberIntegralDay.UpdateGuidMemberIntegralDay;
import com.lj.business.member.service.IGuidMemberIntegralDayService;


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
public class GuidMemberIntegralDayServiceImplTest extends SpringTestCase{

	@Resource
	IGuidMemberIntegralDayService guidMemberIntegralDayService;



	/**
	 * 
	 *
	 * 方法说明：添加导购积分日总表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void addGuidMemberIntegralDay() throws TsfaServiceException{
		AddGuidMemberIntegralDay addGuidMemberIntegralDay = new AddGuidMemberIntegralDay();
		//add数据录入
		addGuidMemberIntegralDay.setCode("Code");
		addGuidMemberIntegralDay.setMerchantNo("MerchantNo");
		addGuidMemberIntegralDay.setMerchantName("MerchantName");
		addGuidMemberIntegralDay.setMemberNo("MemberNo");
		addGuidMemberIntegralDay.setMemberName("MemberName");
		addGuidMemberIntegralDay.setShopNo("ShopNo");
		addGuidMemberIntegralDay.setShopName("ShopName");
		addGuidMemberIntegralDay.setAreaCode("AreaCode");
		addGuidMemberIntegralDay.setAreaName("AreaName");
		addGuidMemberIntegralDay.setIntegralScore(0.0);
		addGuidMemberIntegralDay.setDaySt(new Date());
		addGuidMemberIntegralDay.setUpdateId("UpdateId");
		addGuidMemberIntegralDay.setUpdateDate(new Date());
		addGuidMemberIntegralDay.setCreateId("CreateId");
		addGuidMemberIntegralDay.setCreateDate(new Date());
		
		guidMemberIntegralDayService.addGuidMemberIntegralDay(addGuidMemberIntegralDay );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改导购积分日总表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void updateGuidMemberIntegralDay() throws TsfaServiceException{
		UpdateGuidMemberIntegralDay updateGuidMemberIntegralDay = new UpdateGuidMemberIntegralDay();
		//update数据录入
		updateGuidMemberIntegralDay.setCode("Code");
		updateGuidMemberIntegralDay.setMerchantNo("MerchantNo");
		updateGuidMemberIntegralDay.setMerchantName("MerchantName");
		updateGuidMemberIntegralDay.setMemberNo("MemberNo");
		updateGuidMemberIntegralDay.setMemberName("MemberName");
		updateGuidMemberIntegralDay.setShopNo("ShopNo");
		updateGuidMemberIntegralDay.setShopName("ShopName");
		updateGuidMemberIntegralDay.setAreaCode("AreaCode");
		updateGuidMemberIntegralDay.setAreaName("AreaName");
		updateGuidMemberIntegralDay.setIntegralScore(0.0);
		updateGuidMemberIntegralDay.setDaySt(new Date());
		updateGuidMemberIntegralDay.setUpdateId("UpdateId");
		updateGuidMemberIntegralDay.setUpdateDate(new Date());
		updateGuidMemberIntegralDay.setCreateId("CreateId");
		updateGuidMemberIntegralDay.setCreateDate(new Date());

		guidMemberIntegralDayService.updateGuidMemberIntegralDay(updateGuidMemberIntegralDay );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找导购积分日总表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void findGuidMemberIntegralDay() throws TsfaServiceException{
		FindGuidMemberIntegralDay findGuidMemberIntegralDay = new FindGuidMemberIntegralDay();
		findGuidMemberIntegralDay.setCode("111");
		guidMemberIntegralDayService.findGuidMemberIntegralDay(findGuidMemberIntegralDay);
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除导购积分日总表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void delGuidMemberIntegralDay() throws TsfaServiceException{
		DelGuidMemberIntegralDay delGuidMemberIntegralDay = new DelGuidMemberIntegralDay();
		delGuidMemberIntegralDay.setCode("111");
		guidMemberIntegralDayService.delGuidMemberIntegralDay(delGuidMemberIntegralDay);
		
	}
	
	@Test
	public void findByGMDayList() throws Exception {
		FindGuidMemberIntegralDay findGuidMemberIntegralDay = new FindGuidMemberIntegralDay();
		findGuidMemberIntegralDay.setMemberNo("d7b963349b8f4bcbbed9a36fe41ae626");
		findGuidMemberIntegralDay.setDaySt(DateUtils.getPreday(new Date()));
		List<FindGuidMemberIntegralDayReturn> findByGMDayList = guidMemberIntegralDayService.findByGMDayList(findGuidMemberIntegralDay);
		double ratioWork = 0;
		for (FindGuidMemberIntegralDayReturn findGuidMemberIntegralDayReturn : findByGMDayList) {
			ratioWork += findGuidMemberIntegralDayReturn.getIntegralScore();
		}
		System.out.println(ratioWork);
	}
	
	
}
