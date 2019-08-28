package com.lj.business.weixin.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.weixin.dto.AddWxLikeInfo;
import com.lj.business.weixin.dto.FindWxLikeInfo;
import com.lj.business.weixin.dto.UpdateWxLikeInfo;
import com.lj.business.weixin.service.IWxLikeInfoService;


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
public class WxLikeInfoServiceImplTest extends SpringTestCase{

	@Resource
	IWxLikeInfoService wxLikeInfoService;



	/**
	 * 
	 *
	 * 方法说明：添加微信朋友圈评论表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addWxLikeInfo() throws TsfaServiceException{
		AddWxLikeInfo addWxLikeInfo = new AddWxLikeInfo();
		//add数据录入
		addWxLikeInfo.setCodeWfi("6685cb9126214c738c9ab476ae63187a");
		addWxLikeInfo.setMemberNo("MemberNo");
		addWxLikeInfo.setMemberName("MemberName");
		addWxLikeInfo.setIdWx("IdWx");
		addWxLikeInfo.setUsername("Username");
		addWxLikeInfo.setNickname("Nickname");
		Assert.assertNotNull(wxLikeInfoService.addWxLikeInfo(addWxLikeInfo ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改微信朋友圈评论表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateWxLikeInfo() throws TsfaServiceException{
		UpdateWxLikeInfo updateWxLikeInfo = new UpdateWxLikeInfo();
		//update数据录入
		updateWxLikeInfo.setCode("20b18a10a810470eb7639943b987d954");
		updateWxLikeInfo.setCodeWfi("6685cb9126214c738c9ab476ae63187a");
		updateWxLikeInfo.setMemberNo("MemberNo");
		updateWxLikeInfo.setMemberName("MemberName");
		updateWxLikeInfo.setMemberName("MemberNames");
		updateWxLikeInfo.setIdWx("IdWxs");
		updateWxLikeInfo.setUsername("Username");
		updateWxLikeInfo.setNickname("Nickname");
		updateWxLikeInfo.setCreateDate(new Date());
		wxLikeInfoService.updateWxLikeInfo(updateWxLikeInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找微信朋友圈评论表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWxLikeInfo() throws TsfaServiceException{
		FindWxLikeInfo findWxLikeInfo = new FindWxLikeInfo();
		findWxLikeInfo.setCode("2e5fa90b036e487c9ca715e6ae0fe851");
		wxLikeInfoService.findWxLikeInfo(findWxLikeInfo);
	}
	
	@Test
	public void findWxLikeInfos() throws TsfaServiceException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("idWx", "12584616400788402476");
		List<Map<String,String>> list= wxLikeInfoService.findWxLikeInfos(map);
		System.out.println(list.toString());
	}
	
}
