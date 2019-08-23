package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.dto.AddMemberLoginInfo;
import com.lj.business.member.dto.DelMemberLoginInfo;
import com.lj.business.member.dto.FindMemberLoginInfo;
import com.lj.business.member.dto.FindMemberLoginInfoPage;
import com.lj.business.member.dto.FindMemberLoginInfoPageReturn;
import com.lj.business.member.dto.UpdateMemberLoginInfo;
import com.lj.business.member.service.IMemberLoginInfoService;


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
public class MemberLoginInfoServiceImplTest extends SpringTestCase{

	@Resource
	IMemberLoginInfoService memberLoginInfoService;



	/**
	 * 
	 *
	 * 方法说明：添加登录记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addMemberLoginInfo() throws TsfaServiceException{
		AddMemberLoginInfo addMemberLoginInfo = new AddMemberLoginInfo();
		//add数据录入
		addMemberLoginInfo.setMemberType("MemberType");
		addMemberLoginInfo.setMemberNo("MemberNo");
		addMemberLoginInfo.setIpAddress("IpAddress");
		addMemberLoginInfo.setMac("Mac");
		addMemberLoginInfo.setNetType("NetType");
		addMemberLoginInfo.setEquipment("Equipment");
		addMemberLoginInfo.setAreaInfo("AreaInfo");
		addMemberLoginInfo.setLoginArea("LoginArea");
		addMemberLoginInfo.setCreateDate(new Date());
		
		Assert.assertNotNull(memberLoginInfoService.addMemberLoginInfo(addMemberLoginInfo ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改登录记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateMemberLoginInfo() throws TsfaServiceException{
		UpdateMemberLoginInfo updateMemberLoginInfo = new UpdateMemberLoginInfo();
		//update数据录入
		updateMemberLoginInfo.setCode(GUID.getPreUUID());
		updateMemberLoginInfo.setMemberType("MemberType");
		updateMemberLoginInfo.setMemberNo("MemberNo");
		updateMemberLoginInfo.setIpAddress("IpAddress");
		updateMemberLoginInfo.setMac("Mac");
		updateMemberLoginInfo.setNetType("NetType");
		updateMemberLoginInfo.setEquipment("Equipment");
		updateMemberLoginInfo.setAreaInfo("AreaInfo");
		updateMemberLoginInfo.setLoginArea("LoginArea");
		updateMemberLoginInfo.setCreateDate(new Date());

		memberLoginInfoService.updateMemberLoginInfo(updateMemberLoginInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找登录记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findMemberLoginInfo() throws TsfaServiceException{
		FindMemberLoginInfo findMemberLoginInfo = new FindMemberLoginInfo();
		findMemberLoginInfo.setCode("LJ_5d6a564c-f3cc-4f6b-80d2-e8750e407da4");
		memberLoginInfoService.findMemberLoginInfo(findMemberLoginInfo);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找登录记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findMemberLoginInfoPage() throws TsfaServiceException{
		FindMemberLoginInfoPage findMemberLoginInfoPage = new FindMemberLoginInfoPage();
		Page<FindMemberLoginInfoPageReturn> page = memberLoginInfoService.findMemberLoginInfoPage(findMemberLoginInfoPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除登录记录表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delMemberLoginInfo() throws TsfaServiceException{
		DelMemberLoginInfo delMemberLoginInfo = new DelMemberLoginInfo();
		delMemberLoginInfo.setCode(GUID.getPreUUID());
		Assert.assertNotNull(memberLoginInfoService.delMemberLoginInfo(delMemberLoginInfo));
		
	}
	
	
}
