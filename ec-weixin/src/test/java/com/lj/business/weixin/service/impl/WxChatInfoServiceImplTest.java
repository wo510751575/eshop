package com.lj.business.weixin.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.DateUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.weixin.dto.AddWxChatInfo;
import com.lj.business.weixin.dto.FindWxChatInfo;
import com.lj.business.weixin.dto.FindWxChatInfoPage;
import com.lj.business.weixin.dto.FindWxChatInfoPageReturn;
import com.lj.business.weixin.dto.UpdateWxChatInfo;
import com.lj.business.weixin.service.IWxChatInfoService;


/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 罗书明
 * 
 * 
 * CreateDate: 2017-06-14
 */
public class WxChatInfoServiceImplTest extends SpringTestCase{

	@Resource
	IWxChatInfoService wxChatInfoService;



	/**
	 * 
	 *
	 * 方法说明：添加微信朋友圈评论表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addWxChatInfo() throws TsfaServiceException{
		AddWxChatInfo addWxChatInfo = new AddWxChatInfo();
		//add数据录入
		addWxChatInfo.setNoWx("laoerjiu123");
		addWxChatInfo.setMsgsvrid("Msgsvrida");
		addWxChatInfo.setIssend("h");
		addWxChatInfo.setTalker("Talkera");
		addWxChatInfo.setContent("Contenta");
		addWxChatInfo.setImgpath("Imgpatha");
		addWxChatInfo.setCreateDate(new Date());
		Assert.assertNotNull(wxChatInfoService.addWxChatInfo(addWxChatInfo ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改微信朋友圈评论表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateWxChatInfo() throws TsfaServiceException{
		UpdateWxChatInfo updateWxChatInfo = new UpdateWxChatInfo();
		//update数据录入
//		updateWxChatInfo.setId(1l);
//		updateWxChatInfo.setMemberNo(22l);
//		updateWxChatInfo.setMemberName("MemberNam");
//		updateWxChatInfo.setMsgid("Msgid");
//		updateWxChatInfo.setMsgsvrid("Msgsvrid");
//		updateWxChatInfo.setIssend("h");
//		updateWxChatInfo.setTalker("Talker");
//		updateWxChatInfo.setContent("Content");
//		updateWxChatInfo.setImgpath("Imgpath");
//		updateWxChatInfo.setTimestamp("Timestamp");
//		updateWxChatInfo.setImgpathLocal("ImgpathLocal");
//		updateWxChatInfo.setCreateDate(new Date());

		wxChatInfoService.updateWxChatInfo(updateWxChatInfo );
		
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
	public void findWxChatInfo() throws TsfaServiceException{
		FindWxChatInfo findWxChatInfo = new FindWxChatInfo();
		findWxChatInfo.setCode("15eaa32ea0c54d7f8e74de539ea155e8");
		wxChatInfoService.findWxChatInfo(findWxChatInfo);
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
	public void findWxChatInfoPage() throws TsfaServiceException{
		FindWxChatInfoPage findWxChatInfoPage = new FindWxChatInfoPage();
		Page<FindWxChatInfoPageReturn> page = wxChatInfoService.findWxChatInfoPage(findWxChatInfoPage);
		Assert.assertNotNull(page);
		
	}
	
	@Test
	public void getMaxChatDateByWxNo() throws TsfaServiceException{
		String no ="wxid_irv0g85ymlh522"; 
		long time = wxChatInfoService.getMaxChatDateByWxNo(no);
		System.out.println(time);
		
	}
	
	@Test
	public void uploadWxChatInfo() throws TsfaServiceException{
		String paramJson ="{\"noWxGM\": \"wxid_irv0g85ymlh522\",\"data\": [{\"msgSvrId\": 8598821623638697580,\"type\": 1,\"isSend\": 0,\"createTime\": 1500357770000,\"talker\": \"weixin\",\"content\": \"🍃叶子🍃\"},{\"msgSvrId\": 3241639453335362770,\"type\": 1,\"isSend\": 1,\"createTime\": 1500358316248,\"talker\": \"KENNYvip6688\",\"content\": \"u就和好\"},{\"msgSvrId\": 422616114379195524,\"type\": 10000,\"isSend\": 0,\"createTime\": 1500358321000,\"talker\": \"KENNYvip6688\",\"content\": \"你已添加了kenny，现在可以开始聊天了。\"},{\"msgSvrId\": 434761895076111991,\"type\": 49,				      \"isSend\": 0,\"createTime\": 1500467551000,\"talker\": \"KENNYvip6688\",\"content\": \"分享\",\"shareTitle\": \"【肆客足球】纳瓦斯：C罗？最好的球员应该留在皇马\",\"shareDes\": \"根据《阿斯报》报道，皇马门将纳瓦斯在出席发布会时表示：“C罗？最好的球员应该待在皇马，他也是这么感觉的。”C罗，最好的球员 “他是否会继续留在皇马？我不知道，这谁都不知道。我们所有人都希望他留下。世界上最好的球员就应该留在皇马，他也是这么感觉的。\",\"shareUrl\": \"http://m.zijiecdn.cn/group/6444403154624102669/?iid=12240220820&amp;app=news_article&amp;wxshare_count=1&amp;tt_from=weixin&amp;utm_source=weixin&amp;utm_medium=toutiao_android&amp;utm_campaign=client_share \"}]}";
		int flag = wxChatInfoService.uploadWxChatInfo(paramJson);
		System.out.println(flag);
		
	}
	@Test
	public void findWxChatInfoPageOMS() throws TsfaServiceException{
		Map<String, Object> parmMap= new HashMap<String, Object>();
		parmMap.put("talker", "KENNYvip6688");
		parmMap.put("start", "0");
		parmMap.put("limit", "10");
//		parmMap.put("startTime", new Date());
//		parmMap.put("endTime", DateUtils.addDays(new Date(), 7));
		Page<Map<String,String>> list= wxChatInfoService.findWxChatInfoPageOMS(parmMap);
		System.out.println(list);
		
	}
	@Test
	public void findWxChantInfoCounts() throws TsfaServiceException{
		FindWxChatInfo chatInfo=new FindWxChatInfo();
		chatInfo.setMemberNo("efbc3bb7be534d24b9cb6d72ac21f666");
		chatInfo.setStartTime("19:00");
		chatInfo.setEndTime("20:00");
		int count=wxChatInfoService.findWxChantInfoCountTime(chatInfo);
		System.out.println(count);
	}
}
