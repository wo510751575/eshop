package com.lj.business.cf.service.impl;

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

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.comTask.AddComTask;
import com.lj.business.cf.dto.comTask.DelComTask;
import com.lj.business.cf.dto.comTask.FindComTask;
import com.lj.business.cf.dto.comTask.FindComTaskIndexPage;
import com.lj.business.cf.dto.comTask.FindComTaskIndexPageReturn;
import com.lj.business.cf.dto.comTask.FindComTaskPage;
import com.lj.business.cf.dto.comTask.FindComTaskPageReturn;
import com.lj.business.cf.dto.comTask.GenerateNextDate;
import com.lj.business.cf.dto.comTask.UpdateComTask;
import com.lj.business.cf.emus.ComTaskFinish;
import com.lj.business.cf.service.IComTaskService;
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
public class ComTaskServiceImplTest extends SpringTestCase{

	@Resource
	IComTaskService comTaskService;



	/**
	 * 
	 *
	 * 方法说明：添加客户沟通任务信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addComTask() throws TsfaServiceException{
		AddComTask addComTask = new AddComTask();
		//add数据录入
		addComTask.setMerchantNo(TestHelp.merchantNo_test);
		addComTask.setShopNo(TestHelp.shopNo_test);
		addComTask.setShopName("ShopName");
		addComTask.setMemberNoGm(TestHelp.memberNoGm_test);
		addComTask.setMemberNameGm("MemberNameGm");
		//addComTask.setMemberNo(TestHelp.memberNo_test);
		addComTask.setMemberNo("87fe398d68374ae49f0568b037f73835");
		addComTask.setMemberName("memberName");
		addComTask.setCodeList(TestHelp.codeList_test);
		addComTask.setNameList("NameList");
		addComTask.setWorkDate(new Date());
		addComTask.setRemarkCom("RemarkCom");
		addComTask.setFinish(ComTaskFinish.NORMAL);
		addComTask.setReason("Reason");
		addComTask.setCreateId("CreateId");
		addComTask.setRemark4("Remark4");
		addComTask.setRemark3("Remark3");
		addComTask.setRemark2("Remark2");
		addComTask.setRemark("Remark");
		
		comTaskService.addComTask(addComTask );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户沟通任务信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateComTask() throws TsfaServiceException{
		UpdateComTask updateComTask = new UpdateComTask();
		//update数据录入
		updateComTask.setCode("Code");
		updateComTask.setMerchantNo("MerchantNo");
		updateComTask.setShopNo("ShopNo");
		updateComTask.setShopName("ShopName");
		updateComTask.setMemberNoGm("MemberNoGm");
		updateComTask.setMemberNameGm("MemberNameGm");
		updateComTask.setCodeList("CodeList");
		updateComTask.setNameList("NameList");
		updateComTask.setWorkDate(new Date());
		updateComTask.setRemarkCom("RemarkCom");
		updateComTask.setFinish("Finish");
		updateComTask.setReason("Reason");
		updateComTask.setRemark4("Remark4");
		updateComTask.setRemark3("Remark3");
		updateComTask.setRemark2("Remark2");
		updateComTask.setRemark("Remark");

		comTaskService.updateComTask(updateComTask );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findComTask() throws TsfaServiceException{
		FindComTask findComTask = new FindComTask();
		findComTask.setCode("LJ_c992d7757e644733bf0da24f5ab9d3ca");
		comTaskService.findComTask(findComTask);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findComTaskPage() throws TsfaServiceException{
		FindComTaskPage findComTaskPage = new FindComTaskPage();
		Page<FindComTaskPageReturn> page = comTaskService.findComTaskPage(findComTaskPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：沟通任务首页：当天沟通任务明细查询
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findComTaskIndexPage() throws TsfaServiceException{
		FindComTaskIndexPage findComTaskIndexPage = new FindComTaskIndexPage();
		findComTaskIndexPage.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		findComTaskIndexPage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findComTaskIndexPage.setCodeList("LJ_6db71533aa06470f8d37274182170e9d");
		findComTaskIndexPage.setFlag("DIS");
		Page<FindComTaskIndexPageReturn> page = comTaskService.findComTaskIndexPage(findComTaskIndexPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除客户沟通任务信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delComTask() throws TsfaServiceException{
		DelComTask delComTask = new DelComTask();
		delComTask.setCode("111");
		comTaskService.delComTask(delComTask);
		
	}
	
	@Test
	public void generateNextDate() throws TsfaServiceException{
		GenerateNextDate generateNextDate = new GenerateNextDate();
		generateNextDate.setNextDate(new Date());
		comTaskService.generateNextDate(generateNextDate);
		
	}
	
	@Test
	public void findCountFinishByDay() throws Exception {
		FindComTask findComTask = new FindComTask();
		findComTask.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findComTask.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		findComTask.setDate(new Date());
		int i = comTaskService.findCountFinishByDay(findComTask);
		System.out.println(i);
	}
	
	@Test
	public void findExpResults() throws TsfaServiceException{
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("merchantNo", "e79d975846ee41ba8c3c55738fda66a9");
		parmMap.put("startTime", "2017-08-22");
		parmMap.put("endTime","2017-08-22");
		parmMap.put("codeList","LJ_2ed8e963cc2841acac845f2e177241d7");
		List<Map<String, Object>> list=  comTaskService.findExpResults(parmMap);
		System.out.println(list.toString());
		
	}
	
}
