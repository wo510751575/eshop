

package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.lj.cc.domain.JobExecuteLog;
import com.lj.cc.dto.JobExecuteLogParam;
import com.lj.cc.service.IJobExecuteFeedbackService;
import com.lj.base.core.pagination.IPage;
import com.lj.base.mvc.web.test.SpringTestCase;

/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * CreateDate: 2017-6-23
 */
public class JobExecuteLogFeedbackServiceImplTest extends SpringTestCase{ 
	
	/** The job execute log feedback service impl. */
	@Resource
	IJobExecuteFeedbackService jobExecuteLogFeedbackServiceImpl;
	
	/**
	 * Test change account status.
	 */
	@Test
	public void testChangeAccountStatus(){
		JobExecuteLog jel = new JobExecuteLog();
		jel.setJobEnglishName("a");
		jel.setJobExecuteInfo("b");
		jel.setJobExecuteStatus("c");
		jel.setJobExecuteTime(new Date());
		jobExecuteLogFeedbackServiceImpl.pushJobExecuteInfo(jel);
	}
	@Test
	public void testPages(){
		//queryJobExecuteLogList
		JobExecuteLogParam param=new JobExecuteLogParam();
		IPage<JobExecuteLog> page=jobExecuteLogFeedbackServiceImpl.queryJobExecuteLogList(param);
		System.out.println(page);
	}
}
