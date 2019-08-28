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
import com.lj.business.member.dto.behaviorInfoPm.AddBehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.DelBehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmPage;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmPageReturn;
import com.lj.business.member.dto.behaviorInfoPm.UpdateBehaviorInfoPm;
import com.lj.business.member.service.IBehaviorInfoPmService;


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
public class BehaviorInfoPmServiceImplTest extends SpringTestCase{

	@Resource
	IBehaviorInfoPmService behaviorInfoPmService;



	/**
	 * 
	 *
	 * 方法说明：添加客户动态详情信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addBehaviorInfoPm() throws TsfaServiceException{
		AddBehaviorInfoPm addBehaviorInfoPm = new AddBehaviorInfoPm();
		//add数据录入
		addBehaviorInfoPm.setMemberNo("MemberNo");
		addBehaviorInfoPm.setMemberName("MemberName");
		addBehaviorInfoPm.setBehaviorDesc("BehaviorDesc");
		addBehaviorInfoPm.setBehaviorDate(new Date());
		addBehaviorInfoPm.setBehaviorCode("BehaviorCode");
		addBehaviorInfoPm.setRemark("Remark");
		addBehaviorInfoPm.setRemark2("Remark2");
		addBehaviorInfoPm.setRemark3("Remark3");
		addBehaviorInfoPm.setRemark4("Remark4");
		
		behaviorInfoPmService.addBehaviorInfoPm(addBehaviorInfoPm );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户动态详情信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateBehaviorInfoPm() throws TsfaServiceException{
		UpdateBehaviorInfoPm updateBehaviorInfoPm = new UpdateBehaviorInfoPm();
		//update数据录入
		updateBehaviorInfoPm.setCode("Code");
		updateBehaviorInfoPm.setBehaviorDesc("BehaviorDesc");
		updateBehaviorInfoPm.setBehaviorDate(new Date());
		updateBehaviorInfoPm.setBehaviorCode("BehaviorCode");
		updateBehaviorInfoPm.setRemark("Remark");
		updateBehaviorInfoPm.setRemark2("Remark2");
		updateBehaviorInfoPm.setRemark3("Remark3");
		updateBehaviorInfoPm.setRemark4("Remark4");

		behaviorInfoPmService.updateBehaviorInfoPm(updateBehaviorInfoPm );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户动态详情信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findBehaviorInfoPm() throws TsfaServiceException{
		FindBehaviorInfoPm findBehaviorInfoPm = new FindBehaviorInfoPm();
		findBehaviorInfoPm.setCode("111");
		behaviorInfoPmService.findBehaviorInfoPm(findBehaviorInfoPm);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户动态详情信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findBehaviorInfoPmPage() throws TsfaServiceException{
		FindBehaviorInfoPmPage findBehaviorInfoPmPage = new FindBehaviorInfoPmPage();
		Page<FindBehaviorInfoPmPageReturn> page = behaviorInfoPmService.findBehaviorInfoPmPage(findBehaviorInfoPmPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除客户动态详情信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delBehaviorInfoPm() throws TsfaServiceException{
		DelBehaviorInfoPm delBehaviorInfoPm = new DelBehaviorInfoPm();
		delBehaviorInfoPm.setCode("111");
		behaviorInfoPmService.delBehaviorInfoPm(delBehaviorInfoPm);
		
	}
	
	
}
