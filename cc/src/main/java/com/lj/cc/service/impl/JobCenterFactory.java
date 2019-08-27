package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.base.json.JsonUtils;
import com.lj.cc.dao.IJobCenterDao;
import com.lj.cc.domain.JobCenter;
import com.lj.distributecache.RedisCache;

/**
 * 
 * 
 * 类说明：调度中心，自动加载，读取文件并装入quartz
 * 【Quartz在系统重启可能常驻内存导致重复任务执行，需要shutdown做清理，所以加了shutdownScheduler方法】.
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
public class JobCenterFactory {
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(JobCenterFactory.class);
	
	public static final String JOB_CACHE_KEY = "JOBCACHEHASHKEY";	// 临时调度任务缓存KEY
	
	/** The job center dao. */
	@Resource
	private IJobCenterDao jobCenterDao;
	
	/** The is enable. */
	@Value("${timessharing.jobcenter.enable}")
	private boolean isEnable;//防止多机被调用（配置人员必须保证只有一台启用）
    
    /** The is writable. */
    private static boolean isWritable = true;//防止本机重复启用
    
    /** The scheduler. */
    private Scheduler scheduler; //Quartz对象
    
    /** The locker. */
    private static Object LOCKER = new Object();//防止并发，添加任务单个执行的同步锁
	
	@Resource 
	private RedisCache redisCache;
	
	/**
	 * Start schedulers.
	 */
	@PostConstruct
	public void startSchedulers(){
		//改为分布式的思路：改为启动线程，用IDistributeLock抢占锁，抢到锁的启动任务
		//线程定时用expandLockTime延长锁寿命，如果本系统还活着
		//则一直由它做调度任务
		//如果本机器出现故障，则由其他机器监管
		//本机器则shutdownScheduler
		if(isEnable && isWritable){
			try{
				isWritable = false;//禁止再启用（防止本机被重复调用）
				logger.debug("【调度中心】初始化调度任务，将阻止其他线程再度调用，isWritable："+isWritable);
				shutdownScheduler();//清理之前的调度任务
				scheduler = new StdSchedulerFactory("properties/quartz.properties").getScheduler(); 
				
				// 加载数据库中的调度任务
				List<JobCenter> jobs = jobCenterDao.selectAllJobs();
				for(JobCenter jc : jobs){
					generateCron(scheduler,jc, Boolean.FALSE);
					logger.debug("已注册调度任务：{}", jc.getJobEnglishName());
				}
				
				// 加载redis缓存中的临时调度任务
				Map<String, String> tempJobMap = redisCache.hgetAll(JOB_CACHE_KEY);
				if(tempJobMap != null && !tempJobMap.isEmpty()) {
					Set<Entry<String, String>> set = tempJobMap.entrySet();
					for(Entry<String, String> entry : set) {
						JobCenter jc = (JobCenter) JsonUtils.objectFromJson(entry.getValue(), JobCenter.class);
//						redisCache.hdel(JobCenterFactory.JOB_CACHE_KEY, jc.getJobEnglishName());	// 删除缓存
						try {
							generateCron(scheduler, jc, Boolean.TRUE);
						} catch(SchedulerException e) {
							if(100 == e.getErrorCode()) {	// 任务过期
								redisCache.hdel(JobCenterFactory.JOB_CACHE_KEY, jc.getJobEnglishName());	// 删除缓存
								logger.error("任务{}已过期，删除任务缓存", jc.getJobEnglishName());
							} else {
								logger.error("注册临时调度任务" + jc.getJobEnglishName() + "失败", e);
							}
							continue;
						} catch(Exception e) {
							logger.error("注册临时调度任务失败", e);
							continue;
						}
						logger.debug("已注册临时调度任务：{}", jc.getJobEnglishName());
					}
				}
				
				// 开始 
		        scheduler.start(); 
			}catch(Throwable t){
				logger.error("cron error",t);
			}
			
		}
	}
    
    /**
     * Generate cron.
     *
     * @param scheduler the scheduler
     * @param jc the jc
     * @param tempJob 临时任务（执行一次就抛弃）
     * @throws SchedulerException the scheduler exception
     * @throws ParseException the parse exception
     */
    private static void generateCron(Scheduler scheduler,JobCenter jc, boolean tempJob) throws SchedulerException, ParseException{ 
        // job 
        JobDetail jobDetail = new JobDetail(jc.getJobEnglishName(), jc.getJobEnglishName(), QuartzJob.class);  
        JobDataMap jdm = new JobDataMap();
        jdm.put("rmiJobUrl", jc.getJobIntf());
        jdm.put("jobName", jc.getJobEnglishName());
        jdm.put("jobParam", jc.getJobParam());
        jdm.put("tempJob", tempJob);
        jobDetail.setJobDataMap(jdm);
        String triggerName = getTriggerName(jc.getJobEnglishName());
        //定时
        CronTrigger cronTrigger = new CronTrigger(triggerName, triggerName, jc.getJobCalender());  

        // 调度
        scheduler.scheduleJob(jobDetail, cronTrigger);  
    	 
    }
    
    /**
     * Shutdown scheduler.
     */
    @PreDestroy
    public void shutdownScheduler(){
    	try {
    		if(scheduler !=null){
				logger.debug("【调度中心】清理之前的调度任务："+scheduler.isShutdown());
				if(!scheduler.isShutdown())
					scheduler.shutdown();
			}
		} catch (SchedulerException e) {
			logger.error("【调度中心】清理原调度任务出错："+e);
		}
    }
    
    /**
     * 
     *
     * 方法说明：添加临时性任务
	 * 1、只适合那种只执行一次的任务
	 * 2、任务在执行前会删除任务缓存
     *
     * @param jc
     * @throws TsfaServiceException
     *
     * @author 曾垂瑜 CreateDate: 2017年12月22日
     *
     */
	public void addTempJob(JobCenter jc) throws TsfaServiceException {
		synchronized (LOCKER) {
			if (redisCache.hexists(JOB_CACHE_KEY, jc.getJobEnglishName())) {
				logger.error("重复添加临时任务: {}", jc.getJobEnglishName());
				throw new TsfaServiceException("addTempJobRepeat", "重复添加调度任务");
			}
			try {
				// 注册调度任务
				generateCron(scheduler, jc, Boolean.TRUE);
				// 将任务信息存入缓存
				redisCache.hset(JOB_CACHE_KEY, jc.getJobEnglishName(), JsonUtils.jsonFromObject(jc));
			} catch (Throwable e) {
				logger.error("添加任务失败", e);
				throw new TsfaServiceException("addTempJobError", "任务添加失败！", e);
			}
		}
	}
	
	/**
	 * 
	 *
	 * 方法说明：注销调度任务
	 *
	 * @param jobName
	 *
	 * @author 曾垂瑜 CreateDate: 2017年12月22日
	 *
	 */
	public void deleteJob(String jobName) {
		try {
			if(scheduler == null || scheduler.isShutdown()) {
				return;
			}
			// 停止触发器
//			scheduler.pauseTrigger(jobName, jobName);	
			// 移除触发器
//			String triggerName = getTriggerName(jobName);
//			if(scheduler.unscheduleJob(triggerName, triggerName)) {
//				logger.info("unschedule Job success: {}", jobName);
//			} else {
//				logger.info("unschedule Job failure: {}", jobName);
//			}
			// 删除任务
			if(scheduler.deleteJob(jobName, jobName)) {
				logger.info("delete Job success: {}", jobName);
			} else {
				logger.info("delete Job failure: {}", jobName);
			}
		} catch (SchedulerException e) {
			logger.error("注销调度任务失败", e);
		}
	}
	
	/**
	 * 
	 *
	 * 方法说明：注销临时调度任务
	 *
	 * @param jobName
	 *
	 * @author 曾垂瑜 CreateDate: 2017年12月22日
	 *
	 */
	public void deleteTempJob(String jobName) {
		redisCache.hdel(JobCenterFactory.JOB_CACHE_KEY, jobName);	// 删除缓存
		this.deleteJob(jobName);
	}
	
	/**
	 * 
	 *
	 * 方法说明：获取触发器名称，即任务名称+Trigger
	 *
	 * @param jobName
	 * @return
	 *
	 * @author 曾垂瑜 CreateDate: 2018年4月27日
	 *
	 */
	private static String getTriggerName(String jobName) {
		return jobName+"Trigger";
	}
}
