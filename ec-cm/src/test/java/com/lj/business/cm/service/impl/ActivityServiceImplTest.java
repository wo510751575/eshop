package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cm.dto.activity.AddActivity;
import com.lj.business.cm.dto.activity.DelActivity;
import com.lj.business.cm.dto.activity.FindActivity;
import com.lj.business.cm.dto.activity.FindActivityDto;
import com.lj.business.cm.dto.activity.FindActivityPage;
import com.lj.business.cm.dto.activity.FindActivityPageReturn;
import com.lj.business.cm.dto.activity.FindActivityReturnDto;
import com.lj.business.cm.dto.activity.UpdateActivity;
import com.lj.business.cm.dto.activity.UpdateActivityForReadDto;
import com.lj.business.cm.service.IActivityService;


/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 
 * 
 * CreateDate: 2017-07-24
 */
public class ActivityServiceImplTest extends SpringTestCase{

	@Resource
	IActivityService activityService;



	/**
	 * 
	 *
	 * 方法说明：添加活动表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年10月10日
	 *
	 */
	@Test
	public void addActivity() throws TsfaServiceException{
		AddActivity addActivity = new AddActivity();
		//add数据录入
		addActivity.setCode(GUID.generateCode());
		addActivity.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		addActivity.setMerchantName("MerchantName");
		addActivity.setTitle("暑假优惠来袭！抢4000元大礼包！");
		addActivity.setContent("暑假优惠来袭！抢4000元大礼包！");
		addActivity.setImgAddr("http://a1.qpic.cn/psb?/V12hnLlA1zyPXC/FRe.mjtnuyIjkciHrtISlWJZ998AAE129aKC0h3tQMk!/b/dD4BAAAAAAAA&bo=kABuAAAAAAADB9w!&rf=viewer_4");
		addActivity.setCreateId("邹磊");
		addActivity.setCreateDate(new Date());
		addActivity.setRemark("测试数据");
		addActivity.setRemark2("Remark2");
		addActivity.setRemark3("Remark3");
		addActivity.setRemark4("Remark4");
		Assert.assertNotNull(activityService.addActivity(addActivity));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改活动表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年10月10日
	 *
	 */
	@Test
	public void updateActivity() throws TsfaServiceException{
		UpdateActivity updateActivity = new UpdateActivity();
		//update数据录入
		updateActivity.setCode(GUID.generateCode());
		updateActivity.setMerchantNo(GUID.getPreUUID());
		updateActivity.setMerchantName("敏华集团");
		updateActivity.setTitle("暑假优惠来袭！抢4000元大礼包！");
		updateActivity.setContent("暑假优惠来袭！抢4000元大礼包！");
		updateActivity.setImgAddr("http://a1.qpic.cn/psb?/V12hnLlA1zyPXC/FRe.mjtnuyIjkciHrtISlWJZ998AAE129aKC0h3tQMk!/b/dD4BAAAAAAAA&bo=kABuAAAAAAADB9w!&rf=viewer_4");
		updateActivity.setCreateId("邹磊");
		updateActivity.setCreateDate(new Date());
		updateActivity.setRemark("测试数据");
		updateActivity.setRemark2("Remark2");
		updateActivity.setRemark3("Remark3");
		updateActivity.setRemark4("Remark4");

		activityService.updateActivity(updateActivity );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找活动表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年10月10日
	 *
	 */
	@Test
	public void findActivity() throws TsfaServiceException{
		FindActivity findActivity = new FindActivity();
		findActivity.setCode("LJ_21bfdee3759e41938693e12e9d89764e");
		activityService.findActivity(findActivity);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找活动表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年10月10日
	 *
	 */
	@Test
	public void findActivityPage() throws TsfaServiceException{
		FindActivityPage findActivityPage = new FindActivityPage();
		findActivityPage.setCode("LJ_21bfdee3759e41938693e12e9d89764e");
		Page<FindActivityPageReturn> page = activityService.findActivityPage(findActivityPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除活动表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年10月10日
	 *
	 */
	@Test
	public void delActivity() throws TsfaServiceException{
		DelActivity delActivity = new DelActivity();
		delActivity.setCode("LJ_21bfdee3759e41938693e12e9d89764e");
		Assert.assertNotNull(activityService.delActivity(delActivity));
		
	}
	/**
	 * 
	 *
	 * 方法说明：通过商户编号查找所有的活动列表
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 邹磊 CreateDate: 2017年7月24日
	 *
	 */
	@Test
	public void findActivitys() throws TsfaServiceException{
		FindActivityPage findActivityDto = new FindActivityPage();
//		findActivityDto.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findActivityDto.setStartDate(DateUtils.formatDate(new Date(), DateUtils.PATTERN_yyyy_MM_dd));
		List<FindActivityPageReturn> findActivitys = activityService.findActivitys(findActivityDto);
		Assert.assertNotNull(findActivitys);
		System.out.println(findActivitys.toString());
	}
	/**
	 * 
	 *
	 * 方法说明：点击量+1
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 邹磊 CreateDate: 2017年7月25日
	 *
	 */
	@Test
	public void updateActivityForRead() throws TsfaServiceException{
		UpdateActivityForReadDto updateActivityForReadDto = new UpdateActivityForReadDto();
		updateActivityForReadDto.setLinkUrl("https://cheers.tmall.com/");
		activityService.updateActivityForRead(updateActivityForReadDto);
	}
}
