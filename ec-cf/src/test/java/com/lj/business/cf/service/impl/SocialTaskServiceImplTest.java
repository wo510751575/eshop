package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.socialTask.AddSocialTask;
import com.lj.business.cf.dto.socialTask.DelSocialTask;
import com.lj.business.cf.dto.socialTask.FindSocialTask;
import com.lj.business.cf.dto.socialTask.FindSocialTaskPage;
import com.lj.business.cf.dto.socialTask.FindSocialTaskPageReturn;
import com.lj.business.cf.dto.socialTask.FindSocialTaskSt;
import com.lj.business.cf.dto.socialTask.FindStIndexPage;
import com.lj.business.cf.dto.socialTask.FindStIndexPageReturn;
import com.lj.business.cf.dto.socialTask.UpdateSocialTask;
import com.lj.business.cf.emus.FinishSocial;
import com.lj.business.cf.service.ISocialTaskService;
import com.lj.business.cf.util.TestHelp;


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
public class SocialTaskServiceImplTest extends SpringTestCase{

	@Resource
	ISocialTaskService socialTaskService;
	


	/**
	 * 
	 *
	 * 方法说明：添加工作任务表（社交）信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void addSocialTask() throws TsfaServiceException{
		
		/*merchantNo=null, shopNo=null, shopName=null, memberNoGm=c795e08ca
				dac4867bb7fad496216efaf, memberNameGm=店长-老袁, codeList=null, nameList=null, memberNo=null, memberName=null, workDate=Fri Sep 01 21:46:39 CST 2017, workFinishDate=null, finish=null, actionTask=null, reason=null, idWx=12618384181809
				123590, friendUpdateDate=Fri Sep 01 09:16:53 CST 2017, createId=null, remark4=null, remark3=null, remark2=null, remark=null, noWx=wxid_981feuk1kbl222*/
		AddSocialTask addSocialTask = new AddSocialTask();
		//add数据录入
		//addSocialTask.setMerchantNo(TestHelp.merchantNo_test);
		//addSocialTask.setShopNo(TestHelp.shopNo_test);
		//addSocialTask.setShopName("ShopName");
		addSocialTask.setMemberNoGm("c795e08cadac4867bb7fad496216efaf");
		addSocialTask.setMemberNameGm("店长-老袁");
		//addSocialTask.setCodeList("CodeList");
		//addSocialTask.setNameList("NameList");
		//addSocialTask.setMemberNo("87fe398d68374ae49f0568b037f73835");
		//addSocialTask.setMemberName("MemberName");
		addSocialTask.setWorkDate(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH) );
		//addSocialTask.setFinish("Y");
		//addSocialTask.setReason("Reason");
		addSocialTask.setIdWx("12618384181809123590");
		//addSocialTask.setCreateId("CreateId");
		//addSocialTask.setRemark4("Remark4");
		//addSocialTask.setRemark3("Remark3");
		//addSocialTask.setRemark2("Remark2");
		//addSocialTask.setRemark("Remark");
		addSocialTask.setNoWx("wxid_981feuk1kbl222");
		addSocialTask.setFriendUpdateDate(new Date());
		//addSocialTask.setWorkFinishDate(new Date());
		socialTaskService.addSocialTask(addSocialTask );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改工作任务表（社交）信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void updateSocialTask() throws TsfaServiceException{
		UpdateSocialTask updateSocialTask = new UpdateSocialTask();
		//update数据录入
		updateSocialTask.setCode("LJ_54047bc280a84ed387e9c5a9e47fd0c2");
		updateSocialTask.setFinish(FinishSocial.Y.toString());
		socialTaskService.updateSocialTask(updateSocialTask );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找工作任务表（社交）信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void findSocialTask() throws TsfaServiceException{
		FindSocialTask findSocialTask = new FindSocialTask();
		findSocialTask.setCode("111");
		socialTaskService.findSocialTask(findSocialTask);
	}
	
	@Test
	public void findSocialTaskStByDay() throws TsfaServiceException{
		List<FindSocialTaskSt> list = socialTaskService.findSocialTaskStByDay(new Date());
		Assert.assertNotNull(list);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找工作任务表（社交）信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void findSocialTaskPage() throws TsfaServiceException{
		FindSocialTaskPage findSocialTaskPage = new FindSocialTaskPage();
		Page<FindSocialTaskPageReturn> page = socialTaskService.findSocialTaskPage(findSocialTaskPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除工作任务表（社交）信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void delSocialTask() throws TsfaServiceException{
		DelSocialTask delSocialTask = new DelSocialTask();
		delSocialTask.setCode("111");
		socialTaskService.delSocialTask(delSocialTask);
		
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：分页查询工作任务首页信息_APP社交任务首页
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	@Test
	public void findStIndexPage() throws TsfaServiceException{
		FindStIndexPage findStIndexPage = new FindStIndexPage();
		findStIndexPage.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		findStIndexPage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findStIndexPage.setFlag("NOW");
		Page<FindStIndexPageReturn> page = socialTaskService.findStIndexPage(findStIndexPage);
		for (FindStIndexPageReturn data : page.getRows()) {
			System.out.println(data);
		}
		Assert.assertNotNull(page);
		
	}
	
	@Test
	public void findCountSocialByGm() throws Exception {
		Map<String, Object> map = new HashMap<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		map.put("beginTime", calendar.getTime());
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		map.put("endTime", calendar.getTime());
		map.put("memberNoGm", "38df1c34ff2b430599fdbbe6aab1aaac");
		map.put("finish", "Y");
		System.out.println(socialTaskService.findCountSocialByGm(map));
	}
	
}
