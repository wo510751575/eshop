package com.lj.business.weixin.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.encryption.Base64;
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.weixin.dto.AddWxFriendsInfo;
import com.lj.business.weixin.dto.FindWxFriendsInfo;
import com.lj.business.weixin.dto.FindWxFriendsInfoPage;
import com.lj.business.weixin.dto.FindWxFriendsInfoPageReturn;
import com.lj.business.weixin.dto.UpdateWxFriendsInfo;
import com.lj.business.weixin.service.IWxFriendsInfoService;


/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * 
 * @author 彭阳
 *   
 * CreateDate: 2017年6月14日
 */
public class WxFriendsInfoServiceImplTest extends SpringTestCase{

	@Resource
	IWxFriendsInfoService wxFriendsInfoService;



	/**
	 * 
	 *
	 * 方法说明：添加微信朋友圈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addWxFriendsInfo() throws TsfaServiceException{
		AddWxFriendsInfo addWxFriendsInfo = new AddWxFriendsInfo();
		//add数据录入
		addWxFriendsInfo.setMemberNo("MemberNo");
		addWxFriendsInfo.setMemberName("MemberName");
		addWxFriendsInfo.setAuthorid("Authorid");
		addWxFriendsInfo.setAuthorname("Authorname");
		addWxFriendsInfo.setComments("Comments");
		addWxFriendsInfo.setContent("Content");
		addWxFriendsInfo.setIdWx("IdWx");
		addWxFriendsInfo.setMedialist("Medialist");
		addWxFriendsInfo.setTimestamp("Timestamp");
		addWxFriendsInfo.setImgpathLocal("ImgpathLocal");
		
		Assert.assertNotNull(wxFriendsInfoService.addWxFriendsInfo(addWxFriendsInfo ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改微信朋友圈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateWxFriendsInfo() throws TsfaServiceException{
		UpdateWxFriendsInfo updateWxFriendsInfo = new UpdateWxFriendsInfo();
		//update数据录入
		updateWxFriendsInfo.setCode("6685cb9126214c738c9ab476ae63187a");
		updateWxFriendsInfo.setMemberNo("MemberNo");
		updateWxFriendsInfo.setMemberName("MemberName");
		updateWxFriendsInfo.setAuthorid("Authorid");
		updateWxFriendsInfo.setAuthorname("Authorname");
		updateWxFriendsInfo.setComments("Comments");
		updateWxFriendsInfo.setContent("Content");
		updateWxFriendsInfo.setIdWx("IdWx");
		updateWxFriendsInfo.setMedialist("Medialist");
		updateWxFriendsInfo.setTimestamp("Timestamp");
		updateWxFriendsInfo.setImgpathLocal("ImgpathLocal");

		wxFriendsInfoService.updateWxFriendsInfo(updateWxFriendsInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找微信朋友圈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWxFriendsInfo() throws TsfaServiceException{
		FindWxFriendsInfo findWxFriendsInfo = new FindWxFriendsInfo();
		findWxFriendsInfo.setCode("6685cb9126214c738c9ab476ae63187a");
		
		System.out.println(wxFriendsInfoService.findWxFriendsInfo(findWxFriendsInfo).toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找微信朋友圈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWxFriendsInfoPage() throws TsfaServiceException{
		FindWxFriendsInfoPage findWxFriendsInfoPage = new FindWxFriendsInfoPage();
		Page<FindWxFriendsInfoPageReturn> page = wxFriendsInfoService.findWxFriendsInfoPage(findWxFriendsInfoPage);
		Assert.assertNotNull(page);
		
	}
	
	@Test
	public void getNewDateByWxNo() throws TsfaServiceException{
		String no ="wxid_irv0g85ymlh522"; 
		long time = wxFriendsInfoService.getNewDateByWxNo(no);
		System.out.println(time);
		
	}
	
	@Test
	public void uploadWxFriendsInfo() throws TsfaServiceException{
		String paramJson ="{'noWxGM':'fe7403','memberNoGuid':'23e97e67852a44d1ab40cec87a7417c4','data':[{'id':'12631776091786326161','userName':'huxingbo5434','nickName':'黑夜','type':1,'sourceType':2,'createTime':1505825053,'content':'','likes':[{'userName':'wxid_v8ddqwte3uqf22','nickName':'风爾'}]},{'id':'12631854079999938796','userName':'KENNYvip6688','nickName':'曹建才','type':3,'sourceType':8,'createTime':1505834350,'content':'慢慢的，轻轻的。','shareTitle':'单曲:遥远的歌-Cannie','shareUrl':'https://h.xiami.com/music/feed-details-share.html?id=44641513'},{'id':'12635853771336061179','userName':'wxid_bxxpj6cxshy721','nickName':'A杨俊13510216075','type':1,'sourceType':8,'createTime':1506311150,'content':'爱美的MM看过来[勾引][勾引]平安太强大，资源整合，服务客户。首发日半天劲爆销售40万，爱美的亲联系我吧[勾引]','comments':[{'userName':'wxid_bxxpj6cxshy721','nickName':'A杨俊13510216075','content':'女人的生活，感性的写在脸上，和好看不好看没关系，而是脸的状态，以及对待脸的方式，传递着对生活状态以及人生态度。平安好医生已于9月20日隆重推出医疗美容产品，为你一站式解决美白祛斑除皱等皮肤问题，让你轻松变冻龄女神！<U+1F389><U+1F389><U+1F389>[玫瑰][玫瑰][玫瑰]','toNickName':null,'toUserName':null}]},{'id':'12634321042542498089','userName':'wxid_bxxpj6cxshy721','nickName':'A杨俊13510216075','type':1,'sourceType':8,'createTime':1506128435,'content':'活着，就应该发出自己的光，但如果能一群人一起发光，就更好！周末愉快！[玫瑰][太阳]'},{'id':'12635757645414215787','userName':'wxid_fjqp5vt0au6621','nickName':'Nini','type':1,'sourceType':8,'createTime':1506299691,'content':'哈哈哈哈哈这就很扎心了，是我[皱眉]'},{'id':'12634858733871771753','userName':'wxid_fjqp5vt0au6621','nickName':'Nini','type':1,'sourceType':8,'createTime':1506192533,'content':'今日最好，别说来日方长，晚安[爱心]'},{'id':'12632566114696310900','userName':'wxid_fjqp5vt0au6621','nickName':'Nini','type':15,'sourceType':8,'createTime':1505919231,'content':'知世故而不世故[愉快]','shareTitle':'知世故而不世故[愉快]','shareUrl':'http://szzjwxsns.video.qq.com/102/20202/snsvideodownload?filekey=30270201010420301e0201660402535a041081244177c70307d21783b575871205e602031c9bb40400&hy=SZ&storeid=32303137303932303134353335313030303162356430393365356436326131353738333830613030303030303636&dotrans=0&bizid=1023'},{'id':'12636718558496567427','userName':'huxingbo5434','nickName':'黑夜','type':1,'sourceType':2,'createTime':1506414241,'content':'又是一年中秋快到了。'},{'id':'12636734311594209555','userName':'wxid_saltsmp6jh7c31','nickName':'LINDA','type':1,'sourceType':0,'createTime':1506416119,'content':''},{'id':'12636818547621572741','userName':'wxid_fjqp5vt0au6621','nickName':'Nini','type':2,'sourceType':2,'createTime':1506426161,'content':'哈哈'},{'id':'12636827824169103492','userName':'wxid_fjqp5vt0au6621','nickName':'Nini','type':2,'sourceType':2,'createTime':1506427267,'content':'嗯嗯嗯'},{'id':'12636199720818774297','userName':'wxid_4213502133712','nickName':'blue','type':3,'sourceType':8,'createTime':1506352391,'content':'中年危机如何应对','shareTitle':'比高房价更可怕的是，35岁以后你还能干嘛？这是我看过的最棒建议','shareUrl':'http://mp.weixin.qq.com/s?__biz=MzA4MTkwODU5MQ==&mid=2650752258&idx=1&sn=fa859609f307396e907c9514495bb477&chksm=87862302b0f1aa14cff1dfb65790520da2ebccd0605b3816967b589777d737615ddedeffba04&mpshare=1&scene=2&srcid=09259sIixwFZcickKbgn8bHo#rd'}]}";
		int flag = wxFriendsInfoService.uploadWxFriendsInfo(paramJson);
		System.out.println(flag);
		
	}
	
	public static void main(String[] args) {
		String tr = Base64.encodeBase64String("🍃叶子🍃".getBytes());
		System.out.println("v1_98d02b419cfa7f8768adc1ceb9b69c8b119216378681ef45b898a9d51bfe5989@stranger".length());
		System.out.println(Base64.decode2(tr));
		System.out.println(new String(Base64.decode2(tr)));
	}
}
