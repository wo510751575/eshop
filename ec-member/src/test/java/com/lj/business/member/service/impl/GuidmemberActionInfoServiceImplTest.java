package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.dto.guidmemberActionInfo.AddGuidmemberActionInfo;
import com.lj.business.member.dto.guidmemberActionInfo.DelGuidmemberActionInfo;
import com.lj.business.member.dto.guidmemberActionInfo.FindGuidmemberActionInfo;
import com.lj.business.member.dto.guidmemberActionInfo.UpdateGuidmemberActionInfo;
import com.lj.business.member.service.IGuidmemberActionInfoService;


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
public class GuidmemberActionInfoServiceImplTest extends SpringTestCase{

	@Resource
	IGuidmemberActionInfoService guidmemberActionInfoService;



	/**
	 * 
	 *
	 * 方法说明：添加导购行为信息记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void addGuidmemberActionInfo() throws TsfaServiceException{
		AddGuidmemberActionInfo addGuidmemberActionInfo = new AddGuidmemberActionInfo();
		//add数据录入
		addGuidmemberActionInfo.setCode("Code");
		addGuidmemberActionInfo.setMerchantNo("MerchantNo");
		addGuidmemberActionInfo.setShopNo("ShopNo");
		addGuidmemberActionInfo.setShopName("ShopName");
		addGuidmemberActionInfo.setMemberNoGm("MemberNoGm");
		addGuidmemberActionInfo.setMemberNameGm("MemberNameGm");
		addGuidmemberActionInfo.setActionType("ActionType");
		addGuidmemberActionInfo.setActionDetail("ActionDetail");
		addGuidmemberActionInfo.setActionTime(new Date());
		addGuidmemberActionInfo.setCreateDate(new Date());
		
		guidmemberActionInfoService.addGuidmemberActionInfo(addGuidmemberActionInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改导购行为信息记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void updateGuidmemberActionInfo() throws TsfaServiceException{
		UpdateGuidmemberActionInfo updateGuidmemberActionInfo = new UpdateGuidmemberActionInfo();
		//update数据录入
		updateGuidmemberActionInfo.setCode("Code");
		updateGuidmemberActionInfo.setMerchantNo("MerchantNo");
		updateGuidmemberActionInfo.setShopNo("ShopNo");
		updateGuidmemberActionInfo.setShopName("ShopName");
		updateGuidmemberActionInfo.setMemberNoGm("MemberNoGm");
		updateGuidmemberActionInfo.setMemberNameGm("MemberNameGm");
		updateGuidmemberActionInfo.setActionType("ActionType");
		updateGuidmemberActionInfo.setActionDetail("ActionDetail");
		updateGuidmemberActionInfo.setActionTime(new Date());
		updateGuidmemberActionInfo.setCreateDate(new Date());

		guidmemberActionInfoService.updateGuidmemberActionInfo(updateGuidmemberActionInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找导购行为信息记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void findGuidmemberActionInfo() throws TsfaServiceException{
		FindGuidmemberActionInfo findGuidmemberActionInfo = new FindGuidmemberActionInfo();
		findGuidmemberActionInfo.setCode("111");
		guidmemberActionInfoService.findGuidmemberActionInfo(findGuidmemberActionInfo);
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除导购行为信息记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void delGuidmemberActionInfo() throws TsfaServiceException{
		DelGuidmemberActionInfo delGuidmemberActionInfo = new DelGuidmemberActionInfo();
		delGuidmemberActionInfo.setCode("111");
		guidmemberActionInfoService.delGuidmemberActionInfo(delGuidmemberActionInfo);
		
	}
	
	
}
