package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.AddWorkTask;
import com.lj.business.cf.dto.DelWorkTask;
import com.lj.business.cf.dto.FindWorkTask;
import com.lj.business.cf.dto.FindWorkTaskMainList;
import com.lj.business.cf.dto.FindWorkTaskMainListReturn;
import com.lj.business.cf.dto.FindWorkTaskPage;
import com.lj.business.cf.dto.FindWorkTaskPageReturn;
import com.lj.business.cf.dto.UpdateWorkTask;
import com.lj.business.cf.dto.UpdateWorkTaskFinishNum;
import com.lj.business.cf.emus.TaskType;
import com.lj.business.cf.service.IClientGuidInfoService;
import com.lj.business.cf.service.IWorkTaskService;
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
public class WorkTaskServiceImplTest extends SpringTestCase{

	@Resource
	IWorkTaskService workTaskService;
	
	@Resource
	private IClientGuidInfoService clientGuidInfoService;



	/**
	 * 
	 *
	 * 方法说明：添加工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addWorkTask() throws TsfaServiceException{
		List<String> list = new ArrayList<String>();
		list.add("LJ_01bdd27cf25649e8b450abb0b0b770d0");
		list.add("LJ_8c05621d5608495ead3b43cc9d264133");
		list.add("LJ_3ae07164d8874900abcc119fd4d1eb7f");
		list.add("LJ_12230989aad5472eb3cab86507be1238");
		
		List<String> listName = new ArrayList<String>();
		listName.add("沟通客户");
		listName.add("新增客户");
		listName.add("社交任务");
		listName.add("销售目标");
		for (int i = 0; i < list.size(); i++) {
			AddWorkTask addWorkTask = new AddWorkTask();
			//add数据录入
			addWorkTask.setMerchantNo(TestHelp.merchantNo_test);
			addWorkTask.setShopNo(TestHelp.shopNo_test);
			addWorkTask.setShopName("龙华分店");
			addWorkTask.setMemberNoGm(TestHelp.memberNoGm_test);
			addWorkTask.setMemberNameGm("MemberNameGm");
			addWorkTask.setCodeList(list.get(i));
			addWorkTask.setNameList(listName.get(i));
			addWorkTask.setWorkDate(new Date());
			addWorkTask.setRequireNum(24L);
			addWorkTask.setFinishNum(24L);
			addWorkTask.setUnfinishNum(24L);
			addWorkTask.setDefeatNum(24L);
			addWorkTask.setFinish("Y");
			addWorkTask.setReason("忘记了");
			addWorkTask.setCreateId("CreateId");
			addWorkTask.setRemark("henhao");
			addWorkTask.setRemark2("henhao");
			addWorkTask.setRemark3("henhao");
			addWorkTask.setRemark4("henhao");
			Assert.assertNotNull(workTaskService.addWorkTask(addWorkTask ));
		}
		

	}

	
	/**
	 * 
	 *
	 * 方法说明：修改工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateWorkTask() throws TsfaServiceException{
		UpdateWorkTask updateWorkTask = new UpdateWorkTask();
		//update数据录入
		updateWorkTask.setCode(GUID.getPreUUID());
		updateWorkTask.setMerchantNo(GUID.getPreUUID());
		updateWorkTask.setShopNo(GUID.getPreUUID());
		updateWorkTask.setShopName("龙华分店");
		updateWorkTask.setMemberNoGm(GUID.getPreUUID());
		updateWorkTask.setMemberNameGm("zoulei");
		updateWorkTask.setCodeList(GUID.getPreUUID());
		updateWorkTask.setNameList("项目名称");
		updateWorkTask.setWorkDate(new Date());
		updateWorkTask.setRequireNum(24L);
		updateWorkTask.setFinishNum(24L);
		updateWorkTask.setUnfinishNum(24L);
		updateWorkTask.setDefeatNum(24L);
		updateWorkTask.setFinish("Y");
		updateWorkTask.setReason("忘记了");
		updateWorkTask.setRemark("henhao");
		updateWorkTask.setRemark2("henhao");
		updateWorkTask.setRemark3("henhao");
		updateWorkTask.setRemark4("henhao");

		workTaskService.updateWorkTask(updateWorkTask );

	}

	/**
	 * 
	 *
	 * 方法说明：查找工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWorkTask() throws TsfaServiceException{
		FindWorkTask findWorkTask = new FindWorkTask();
		findWorkTask.setCode("LJ_b30649a45cfd4b5f8713a14c1217c809");
		workTaskService.findWorkTask(findWorkTask);
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年8月24日
	 *
	 */
	@Test
	public void findWtsMain() throws TsfaServiceException{
		FindWorkTask findWorkTask = new FindWorkTask();
		findWorkTask.setShopNo("LJ_31bdf059170446808c39467e0b8ef2ff");
		findWorkTask.setMerchantNo("1f2a6d3e3022448382734bc70c9384af");
		findWorkTask.setMemberNoGm("3f59ef3cd6514dd7887b93c88b08c2fb");
		findWorkTask.setMemberNameGm("张海");
		
		workTaskService.findWtsMain(findWorkTask);
	}

	/**
	 * 
	 *
	 * 方法说明：查找工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWorkTaskPage() throws TsfaServiceException{
		FindWorkTaskPage findWorkTaskPage = new FindWorkTaskPage();
		Page<FindWorkTaskPageReturn> page = workTaskService.findWorkTaskPage(findWorkTaskPage);
		Assert.assertNotNull(page);

	}
	
	/**
	 * 
	 *
	 * 方法说明：查找主要/其他工作任务表信息_APP
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月27日
	 *
	 */
	@Test
	public void findWorkTaskMainList() throws TsfaServiceException{
		FindWorkTaskMainList findWorkTaskMainList = new FindWorkTaskMainList();
		findWorkTaskMainList.setMemberNoGm(TestHelp.memberNoGm_test);
		findWorkTaskMainList.setWorkDate(new Date());
		List<FindWorkTaskMainListReturn> page = workTaskService.findWorkTaskMainList(findWorkTaskMainList);
		Assert.assertNotNull(page);

	}

	/**
	 * 
	 *
	 * 方法说明：查找工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findWorkTaskMainPage() throws TsfaServiceException{
		FindWorkTaskMainList findWorkTaskMainList = new FindWorkTaskMainList();
		findWorkTaskMainList.setMemberNoGm("LJ_76c320de6fef4590962bf71a2b114c5b");
		Date now = new Date();
		now = DateUtils.truncate(now,Calendar.DAY_OF_MONTH);
		findWorkTaskMainList.setWorkDate(now);
		List<FindWorkTaskMainListReturn> page = workTaskService.findWorkTaskMainList(findWorkTaskMainList);
		Assert.assertNotNull(page);
		findWorkTaskMainList.setMemberNoGm("LJ_76c320de6fef4590962bf71a2b114c5b");
		page = workTaskService.findWorkTaskMainList(findWorkTaskMainList);
		Assert.assertNotNull(page);
	}

	/**
	 * 
	 *
	 * 方法说明：删除工作任务表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delWorkTask() throws TsfaServiceException{
		DelWorkTask delWorkTask = new DelWorkTask();
		delWorkTask.setCode("LJ_ffa6fcc1be7e4d73a4fcaa397884c671");
		Assert.assertNotNull(workTaskService.delWorkTask(delWorkTask));

	}
	
	@Test
	public void updateRequireNumByGmTypeDay() throws Exception {
		
		UpdateWorkTask updateWorkTask = new UpdateWorkTask();
		updateWorkTask.setMemberNoGm("c0854fe7eadc45c1a1936b389ecdf364");
		updateWorkTask.setTaskType("SHE_JIAO");
		updateWorkTask.setWorkDate(new Date());
		System.out.println(workTaskService.updateRequireNumByGmTypeDay(updateWorkTask));
		
	}
	
	@Test
	public void updateFinishNum() throws Exception {
		UpdateWorkTaskFinishNum updateWorkTaskFinishNum = new UpdateWorkTaskFinishNum();
		updateWorkTaskFinishNum.setFinishNum(1L);
		updateWorkTaskFinishNum.setMemberNoGm("c0854fe7eadc45c1a1936b389ecdf364");
		updateWorkTaskFinishNum.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		updateWorkTaskFinishNum.setTaskType(TaskType.SHE_JIAO);
		workTaskService.updateFinishNum(updateWorkTaskFinishNum);
	}

	
//merchantNo=1f2a6d3e3022448382734bc70c9384af, 
//memberNo=9d14e16c532040229f3966db0a8e2ced,
//memberName=null, 
//memberNoGm=04f52a95d04d42548325e99232d5ef7b, 
//memberNameGm=null, 
//shopNo=LJ_31bdf059170446808c39467e0b8ef2ff,
//shopName=null, 
//sendTime=null, 
//materialCode=LJ_0f37ccdaae5b466c9b2f85d53afab609,
//materialCommenType=COMMEN, 
//comTaskCode=null, 
//dis=false, 
//finishOrgComTask=true, 
//cfNo=null
	
	@Test
	public void addGuidInfoRecord() throws TsfaServiceException{
		
		FindWorkTask findWorkTask = new FindWorkTask();
		
		
		//"shopNo":"LJ_31bdf059170446808c39467e0b8ef2ff","merchantNo":"1f2a6d3e3022448382734bc70c9384af","memberNoGm":"04f52a95d04d42548325e99232d5ef7b","memberNameGm":"李白"
		findWorkTask.setShopNo("LJ_31bdf059170446808c39467e0b8ef2ff");
		
		findWorkTask.setMerchantNo("1f2a6d3e3022448382734bc70c9384af");
		findWorkTask.setMemberNoGm("04f52a95d04d42548325e99232d5ef7b");
		findWorkTask.setMemberNameGm("李白");
		workTaskService.findWtsMain(findWorkTask);

	}
	

}
