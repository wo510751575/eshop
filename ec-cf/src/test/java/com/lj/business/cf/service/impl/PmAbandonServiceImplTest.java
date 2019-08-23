package com.lj.business.cf.service.impl;

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
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.pmAbandon.AddPmAbandon;
import com.lj.business.cf.dto.pmAbandon.DelPmAbandon;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandon;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonList;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonPage;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonPageReturn;
import com.lj.business.cf.dto.pmAbandon.UpdatePmAbandon;
import com.lj.business.cf.service.IPmAbandonService;


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
public class PmAbandonServiceImplTest extends SpringTestCase{

	@Resource
	IPmAbandonService pmAbandonService;



	/**
	 * 
	 *
	 * 方法说明：添加客户放弃表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addPmAbandon() throws TsfaServiceException{
		AddPmAbandon addPmAbandon = new AddPmAbandon();
		//add数据录入
		addPmAbandon.setCode("Code");
		addPmAbandon.setMemberNoGm("MemberNoGm");
		addPmAbandon.setMemberNameGm("MemberNameGm");
		addPmAbandon.setResean("Resean");
		addPmAbandon.setFollowDate(new Date());
		addPmAbandon.setCheckDate(new Date());
		addPmAbandon.setChecker("Checker");
		addPmAbandon.setCheckDes("CheckDes");
		addPmAbandon.setRemark("Remark");
		addPmAbandon.setCreateId("CreateId");
		addPmAbandon.setCreateDate(new Date());
		addPmAbandon.setUpdateId("UpdateId");
		addPmAbandon.setUpdateDate(new Date());
		
		Assert.assertNotNull(pmAbandonService.addPmAbandon(addPmAbandon ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户放弃表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updatePmAbandon() throws TsfaServiceException{
		UpdatePmAbandon updatePmAbandon = new UpdatePmAbandon();
		//update数据录入
		updatePmAbandon.setCode("Code");
		updatePmAbandon.setMemberNoGm("MemberNoGm");
		updatePmAbandon.setMemberNameGm("MemberNameGm");
		updatePmAbandon.setResean("Resean");
		updatePmAbandon.setFollowDate(new Date());
		updatePmAbandon.setCheckDate(new Date());
		updatePmAbandon.setChecker("Checker");
		updatePmAbandon.setCheckDes("CheckDes");
		updatePmAbandon.setRemark("Remark");
		updatePmAbandon.setCreateId("CreateId");
		updatePmAbandon.setCreateDate(new Date());
		updatePmAbandon.setUpdateId("UpdateId");
		updatePmAbandon.setUpdateDate(new Date());

		pmAbandonService.updatePmAbandon(updatePmAbandon );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户放弃表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPmAbandon() throws TsfaServiceException{
		FindPmAbandon findPmAbandon = new FindPmAbandon();
		findPmAbandon.setCode("Code");
		pmAbandonService.findPmAbandon(findPmAbandon);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户放弃表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPmAbandonPage() throws TsfaServiceException{
		FindPmAbandonPage findPmAbandonPage = new FindPmAbandonPage();
		Page<FindPmAbandonPageReturn> page = pmAbandonService.findPmAbandonPage(findPmAbandonPage);
		Assert.assertNotNull(page);
		
	}
	/**
	 * 
	 *
	 * 方法说明：查找客户放弃记录
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年7月13日
	 *
	 */
	
	@Test
	public void findPmAbandonList() throws TsfaServiceException{
		FindPmAbandonList findPmAbandonList=new FindPmAbandonList();
		pmAbandonService.findPmAbandonList(findPmAbandonList);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除客户放弃表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delPmAbandon() throws TsfaServiceException{
		DelPmAbandon delPmAbandon = new DelPmAbandon();
		delPmAbandon.setCode("Code");
		Assert.assertNotNull(pmAbandonService.delPmAbandon(delPmAbandon));
		
	}
	
	
}
