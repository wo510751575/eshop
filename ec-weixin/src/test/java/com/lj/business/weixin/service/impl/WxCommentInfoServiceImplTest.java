package com.lj.business.weixin.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.weixin.dto.AddWxCommentInfo;
import com.lj.business.weixin.dto.FindWxCommentInfo;
import com.lj.business.weixin.dto.FindWxCommentInfoPage;
import com.lj.business.weixin.dto.FindWxCommentInfoPageReturn;
import com.lj.business.weixin.dto.UpdateWxCommentInfo;
import com.lj.business.weixin.service.IWxCommentInfoService;


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
public class WxCommentInfoServiceImplTest extends SpringTestCase{

	@Resource
	IWxCommentInfoService wxCommentInfoService;



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
	public void addWxCommentInfo() throws TsfaServiceException{
		AddWxCommentInfo addWxCommentInfo = new AddWxCommentInfo();
		//add数据录入
		addWxCommentInfo.setCodeWfi("6685cb9126214c738c9ab476ae63187a");
		addWxCommentInfo.setMemberNo("MemberNo");
		addWxCommentInfo.setMemberName("MemberName");
		addWxCommentInfo.setIdWx("IdWx");
		addWxCommentInfo.setUsername("Username");
		addWxCommentInfo.setNickname("Nickname");
		addWxCommentInfo.setTousername("Tousername");
		addWxCommentInfo.setTonickname("Tonickname");
		addWxCommentInfo.setContent("Content");
		Assert.assertNotNull(wxCommentInfoService.addWxCommentInfo(addWxCommentInfo ));
		
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
	public void updateWxCommentInfo() throws TsfaServiceException{
		UpdateWxCommentInfo updateWxCommentInfo = new UpdateWxCommentInfo();
		//update数据录入
		updateWxCommentInfo.setCode("20b18a10a810470eb7639943b987d954");
		updateWxCommentInfo.setCodeWfi("6685cb9126214c738c9ab476ae63187a");
		updateWxCommentInfo.setMemberNo("MemberNo");
		updateWxCommentInfo.setMemberName("MemberName");
		updateWxCommentInfo.setMemberName("MemberNames");
		updateWxCommentInfo.setIdWx("IdWxs");
		updateWxCommentInfo.setUsername("Username");
		updateWxCommentInfo.setNickname("Nickname");
		updateWxCommentInfo.setTousername("Tousername");
		updateWxCommentInfo.setTonickname("Tonickname");
		updateWxCommentInfo.setContent("Contents");
		updateWxCommentInfo.setCreateDate(new Date());
		wxCommentInfoService.updateWxCommentInfo(updateWxCommentInfo );
		
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
	public void findWxCommentInfo() throws TsfaServiceException{
		FindWxCommentInfo findWxCommentInfo = new FindWxCommentInfo();
		findWxCommentInfo.setCode("20b18a10a810470eb7639943b987d954");
		wxCommentInfoService.findWxCommentInfo(findWxCommentInfo);
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
	public void findWxCommentInfoPage() throws TsfaServiceException{
		FindWxCommentInfoPage findWxCommentInfoPage = new FindWxCommentInfoPage();
		Page<FindWxCommentInfoPageReturn> page = wxCommentInfoService.findWxCommentInfoPage(findWxCommentInfoPage);
		Assert.assertNotNull(page);
	}
	
	@Test
	public void findWxCommentInfos() throws TsfaServiceException{
		FindWxCommentInfoPage findWxCommentInfoPage = new FindWxCommentInfoPage();
		findWxCommentInfoPage.setIdWx("12584059392696127712");
		List<FindWxCommentInfoPageReturn> page = wxCommentInfoService.findWxCommentInfos(findWxCommentInfoPage);
		System.out.println(page.toString());
	}
}
