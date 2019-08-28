package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.dto.behaviorPm.AddBehaviorPm;
import com.lj.business.member.dto.behaviorPm.DelBehaviorPm;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPm;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmPage;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmPageReturn;
import com.lj.business.member.dto.behaviorPm.UpdateBehaviorPm;
import com.lj.business.member.service.IBehaviorPmService;
import com.lj.business.member.util.TestHelp;


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
public class BehaviorPmServiceImplTest extends SpringTestCase{

	@Resource
	IBehaviorPmService behaviorPmService;



	/**
	 * 
	 *
	 * 方法说明：添加客户最近动态信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addBehaviorPm() throws TsfaServiceException{
		AddBehaviorPm addBehaviorPm = new AddBehaviorPm();
		//add数据录入
		addBehaviorPm.setMemberNo("LJ_8c3868e93edd4f25bc47eeb5f37e713a");
		addBehaviorPm.setMemberName("小强");
		addBehaviorPm.setBehaviorDesc("暂无动态");
		addBehaviorPm.setBehaviorDate(new Date());
		addBehaviorPm.setRemark("Remark");
		addBehaviorPm.setRemark2("Remark2");
		addBehaviorPm.setRemark3("Remark3");
		addBehaviorPm.setRemark4("Remark4");
		
		behaviorPmService.addBehaviorPm(addBehaviorPm );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户最近动态信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateBehaviorPm() throws TsfaServiceException{
		UpdateBehaviorPm updateBehaviorPm = new UpdateBehaviorPm();
		//update数据录入
		updateBehaviorPm.setMemberNo(TestHelp.memberNo_test);
		updateBehaviorPm.setBehaviorDesc("BehaviorDesc");
		updateBehaviorPm.setBehaviorDate(new Date());
		updateBehaviorPm.setRemark("Remark");
		updateBehaviorPm.setRemark2("Remark2");
		updateBehaviorPm.setRemark3("Remark3");
		updateBehaviorPm.setRemark4("Remark4");

		behaviorPmService.updateBehaviorPm(updateBehaviorPm );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户最近动态信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findBehaviorPm() throws TsfaServiceException{
		FindBehaviorPm findBehaviorPm = new FindBehaviorPm();
		findBehaviorPm.setCode("111");
		behaviorPmService.findBehaviorPm(findBehaviorPm);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户最近动态信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findBehaviorPmPage() throws TsfaServiceException{
		FindBehaviorPmPage findBehaviorPmPage = new FindBehaviorPmPage();
		Page<FindBehaviorPmPageReturn> page = behaviorPmService.findBehaviorPmPage(findBehaviorPmPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除客户最近动态信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delBehaviorPm() throws TsfaServiceException{
		DelBehaviorPm delBehaviorPm = new DelBehaviorPm();
		delBehaviorPm.setCode("111");
		behaviorPmService.delBehaviorPm(delBehaviorPm);
		
	}
	
	
}
