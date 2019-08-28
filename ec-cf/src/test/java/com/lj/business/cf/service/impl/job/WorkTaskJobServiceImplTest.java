package com.lj.business.cf.service.impl.job;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Test;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;


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
public class WorkTaskJobServiceImplTest extends SpringTestCase{

	@Resource
	private WokTaskJobServiceImpl wokTaskJobServiceImpl;

	
	/**
	 * 
	 *
	 * 方法说明：工作任务统计
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年8月19日
	 *
	 */
	@Test
	public void triggerWokTaskJob() throws TsfaServiceException{
		wokTaskJobServiceImpl.triggerWokTaskJob();
	}



}
