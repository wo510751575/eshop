/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.cc.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lj.base.core.util.DateUtils;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.cc.domain.JobCenter;
import com.lj.cc.dto.FindJobCenter;
import com.lj.cc.service.IJobMgrService;

/**
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 曾垂瑜
 *   
 * CreateDate: 2017年12月22日
 */
public class JobMgrServiceImplTest extends SpringTestCase {

	@Resource
	private IJobMgrService jobMgrService;
	
	@Autowired
	private JobCenterFactory jobCenterFactory;
	
	@Test
	public void testAddTempJob() throws InterruptedException {
		this.addTempJob();
	}
	
	private JobCenter addTempJob() {
		JobCenter jc = new JobCenter();
		jc.setJobEnglishName("testTempJob" + System.currentTimeMillis());
		jc.setJobName("临时任务测试");
		jc.setSystemAliasName("cc");
		jc.setJobIntf("http://localhost:8080/cc/hessian/logParamJob");
//		jc.setJobIntf("http://localhost:8080/cc/hessian/logJob");
		jc.setJobParam(jc.getJobEnglishName());
		jc.setJobCalenderByTime(DateUtils.addMinutes(new Date(), 2));
		jc.setIsEnable("1");
		jobMgrService.addTempJob(jc);
		return jc;
	}
	
	@Test
	public void queryJobExecuteLogList(){
		FindJobCenter param=new FindJobCenter();
		System.out.println(jobMgrService.queryJobList(param));
	}
	
	@Test
	public void delTempJob() throws InterruptedException {
		JobCenter jc = this.addTempJob();
		jobMgrService.delTempJob(jc.getJobEnglishName());
//		jobCenterFactory.deleteJobNew(jc.getJobName(), jc.getJobEnglishName());
		Thread.sleep(1000000);
	}
	
}
