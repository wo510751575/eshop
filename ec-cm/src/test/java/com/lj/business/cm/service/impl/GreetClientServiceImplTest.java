package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cm.dto.AddGreetClient;
import com.lj.business.cm.dto.DelGreetClient;
import com.lj.business.cm.dto.FindGreetClient;
import com.lj.business.cm.dto.FindGreetClientForDayDto;
import com.lj.business.cm.dto.FindGreetClientPage;
import com.lj.business.cm.dto.FindGreetClientPageReturn;
import com.lj.business.cm.dto.UpdateGreetClient;
import com.lj.business.cm.emus.SendType;
import com.lj.business.cm.service.IGreetClientService;


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
public class GreetClientServiceImplTest extends SpringTestCase{

	@Resource
	IGreetClientService greetClientService;



	/**
	 * 
	 *
	 * 方法说明：添加问候客户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addGreetClient() throws TsfaServiceException{
		AddGreetClient addGreetClient = new AddGreetClient();
		//add数据录入
		addGreetClient.setCode(GUID.getPreUUID());
		addGreetClient.setMerchantNo(GUID.getPreUUID());
		addGreetClient.setMemberNoGm(GUID.getPreUUID());
		addGreetClient.setMemberNameGm("邹磊");
		addGreetClient.setTitle("公司活动");
		addGreetClient.setContent("您好,最近活动购买8折!");
		addGreetClient.setSendType(SendType.ALL);
		addGreetClient.setMemberNo(GUID.getPreUUID());
		addGreetClient.setCreateId(GUID.getPreUUID());
		addGreetClient.setCreateDate(new Date());
		Assert.assertNotNull(greetClientService.addGreetClient(addGreetClient ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改问候客户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateGreetClient() throws TsfaServiceException{
		UpdateGreetClient updateGreetClient = new UpdateGreetClient();
		//update数据录入
		updateGreetClient.setCode("Code");
		updateGreetClient.setMerchantNo("MerchantNo");
		updateGreetClient.setMemberNoGm("MemberNoGm");
		updateGreetClient.setMemberNameGm("MemberNameGm");
		updateGreetClient.setTitle("Title");
		updateGreetClient.setContent("Content");
		updateGreetClient.setSendType(SendType.ALL);
		updateGreetClient.setMemberNo("MemberNo");
		updateGreetClient.setCreateId("CreateId");
		updateGreetClient.setCreateDate(new Date());

		greetClientService.updateGreetClient(updateGreetClient );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找问候客户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findGreetClient() throws TsfaServiceException{
		FindGreetClient findGreetClient = new FindGreetClient();
		findGreetClient.setCode("73302e1e9c3f4a1793f8181e879ba3f8");
		greetClientService.findGreetClient(findGreetClient);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找问候客户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findGreetClientPage() throws TsfaServiceException{
		FindGreetClientPage findGreetClientPage = new FindGreetClientPage();
		findGreetClientPage.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		Page<FindGreetClientPageReturn> page = greetClientService.findGreetClientPage(findGreetClientPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除问候客户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delGreetClient() throws TsfaServiceException{
		DelGreetClient delGreetClient = new DelGreetClient();
		delGreetClient.setCode("5e3a7b193e814ffaafb3e9ecb316f376");
		Assert.assertNotNull(greetClientService.delGreetClient(delGreetClient));
		
	}
	/**
	 * 
	 *
	 * 方法说明：查找当日的问候信息(今日工作)
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 邹磊 CreateDate: 2017年7月20日
	 * @throws ParseException 
	 *
	 */
	@Test  
	public void findGreetClientForDay() throws TsfaServiceException, ParseException{
		FindGreetClientForDayDto findGreetClientForDayDto = new FindGreetClientForDayDto();
		findGreetClientForDayDto.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		//Date date = DateUtils.parseDate("2017-07-20", DateUtils.PATTERN_yyyy_MM_dd);
		findGreetClientForDayDto.setCreateDate("2017-07-20");
		greetClientService.findGreetClientForDay(findGreetClientForDayDto);
	}
}
