package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.cc.clientintf.IJob;
import com.lj.cc.clientintf.IParamJob;

/**
 * 
 * 
 * 类说明：示例，业务系统的调度任务的处理逻辑.
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月15日
 */
@Service
public class SimpleLogJob implements IJob, IParamJob {
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(SimpleLogJob.class);
	
	/* (non-Javadoc)
	 * @see com.lj.cc.clientintf.IJob#runJob()
	 */
	@Override
	public void runJob() {
		logger.info("The Quartz Task is working: {}", System.currentTimeMillis());
	}

	/* (non-Javadoc)
	 * @see com.lj.cc.clientintf.IParamJob#runParamJob(java.lang.String)
	 */
	@Override
	public void runParamJob(String param) {
		logger.info("The Quartz Task is working: {}", param);
		
	}

}
