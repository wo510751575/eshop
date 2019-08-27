package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lj.base.core.util.StringUtils;
import com.lj.base.mvc.remote.hession.HessianInvoke;
import com.lj.cc.clientintf.IJob;
import com.lj.cc.clientintf.IParamJob;
import com.lj.cc.util.ApplicationContextHelper;

/**
 * 
 * 
 * 类说明： * 临时调度中心解决方案
 * 以后需要改为异步消息平台.
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
public class QuartzJob implements Job{
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(QuartzJob.class);
    //XXX 通过获取分布式锁,抢到资源的才能执行
	//XXX 要解决CC分布式系统机器的时间同步问题(否则可能存在重复执行)
	/* (non-Javadoc)
     * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
     */
    @Override
	public void execute(JobExecutionContext jec) throws JobExecutionException { 
		String rmiJobUrl = jec.getJobDetail().getJobDataMap().getString("rmiJobUrl");
		String jobParam = jec.getJobDetail().getJobDataMap().getString("jobParam");
		logger.debug("定时任务Quartz调用{} -- start, jobParam={}", rmiJobUrl, jobParam);
		try {
			int serviceNamePos = rmiJobUrl.lastIndexOf('/');
			HessianInvoke hi = new HessianInvoke(rmiJobUrl.substring(0,serviceNamePos));
			hi.setOverloadEnabled(Boolean.TRUE);	// 支持重载
			hi.setConnectTimeout(10000);			// 连接超时时间
			if(StringUtils.isEmpty(jobParam)) {
				IJob job = (IJob) hi.getImpl(IJob.class,rmiJobUrl.substring(serviceNamePos+1));
				job.runJob();				// 执行任务
			} else {
				IParamJob job = (IParamJob) hi.getImpl(IParamJob.class,rmiJobUrl.substring(serviceNamePos+1));
				job.runParamJob(jobParam);	// 执行任务
			}
		} catch(Exception e) {
			logger.error("执行任务" + jec.getJobDetail().getJobDataMap().getString("jobName") + "异常", e);
			return;
		} finally {
			removeTempJob(jec);			// 删除缓存中的临时任务
		}
		logger.debug("定时任务Quartz调用{} -- end, jobParam={}", rmiJobUrl, jobParam);
	}
    
    /**
     * 
     *
     * 方法说明：删除缓存中的临时任务
     *
     * @param jec
     *
     * @author 曾垂瑜 CreateDate: 2017年12月22日
     *
     */
    private void removeTempJob(JobExecutionContext jec) {
    	logger.info("remove Temp Job, dataMap: {}", jec.getJobDetail().getJobDataMap());
		boolean tempJob = jec.getJobDetail().getJobDataMap().getBoolean("tempJob");
		if(tempJob) {	// 如果调度任务为临时的，则删除任务
			String jobName = jec.getJobDetail().getJobDataMap().getString("jobName");
			JobCenterFactory jobCenterFactory = (JobCenterFactory) ApplicationContextHelper.getBean(JobCenterFactory.class);
			jobCenterFactory.deleteTempJob(jobName);
		}
    }

}
