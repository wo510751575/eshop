package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.IPage;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.cc.dao.IJobExecuteLogDao;
import com.lj.cc.domain.JobExecuteLog;
import com.lj.cc.dto.JobExecuteLogParam;
import com.lj.cc.service.IJobExecuteFeedbackService;

/**
 * 
 * 
 * 类说明：业务系统回调服务，记录业务目前job的执行情况.
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
public class JobExecuteLogFeedbackServiceImpl implements IJobExecuteFeedbackService{
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(JobExecuteLogFeedbackServiceImpl.class);

	/** The job execute log dao. */
	@Resource
	private IJobExecuteLogDao jobExecuteLogDao;
	
	
	/**
	 * *
	 * 业务系统执行反馈信息（可多次调用），但最后结束需要调用一次status为end.
	 *
	 * @param jobExecuteLogFeedback the job execute log feedback
	 */
	public void pushJobExecuteInfo(JobExecuteLog jobExecuteLogFeedback){
		logger.debug("pushJobExecuteInfo(JobExecuteLog =" + jobExecuteLogFeedback + ") - start");  //$NON-NLS-2$
		jobExecuteLogFeedback.setCode(GUID.generateByUUID());
		if(jobExecuteLogFeedback.getJobCode() == null) {
			jobExecuteLogFeedback.setJobCode(jobExecuteLogFeedback.getJobEnglishName());
		}
		jobExecuteLogDao.insert(jobExecuteLogFeedback);

	}

	@Override
	public IPage<JobExecuteLog> queryJobExecuteLogList(JobExecuteLogParam param) {
		logger.debug("pushJobExecuteInfo(JobExecuteLog =" + param + ") - start");
		int count =0;
		List<JobExecuteLog> list =null;
		try {
			count=jobExecuteLogDao.queryJobExecuteLogTotal(param);
			if(count>0){
			list=jobExecuteLogDao.queryJobExecuteLogList(param);
			}
		} catch (Exception e) {
		   e.printStackTrace();
		   logger.error("分页异常！");
		}
		return new Page<JobExecuteLog>(list, count, param, null);

	}
}
